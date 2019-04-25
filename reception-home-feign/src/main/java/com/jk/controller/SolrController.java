package com.jk.controller;

import com.ctc.wstx.util.ExceptionUtil;
import com.jk.model.Product;
import com.jk.model.Result;
import com.jk.service.HomeServiceFeign;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * solr全局搜索
 */
@RequestMapping("solr")
@Controller
public class SolrController {

    @Autowired
    private SolrClient client;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    @RequestMapping("search")
    @ResponseBody
    public Map<String,Object> productlist(Product product, Integer page, Integer rows,HttpServletRequest request) throws IOException, SolrServerException {
        System.out.println("---"+product.getProductName());
        //因为使用easyui返回数据
        Map<String,Object> mSolr=new HashMap<String,Object>();
        //把所有查询的高亮显示内容发到list中
        List<Product> productlist=new ArrayList<>();
        //查询条件的对象
        SolrQuery params = new SolrQuery();
        //判断前台传递的关键字是否为空
        if(!"".equals(product.getProductName()) && product.getProductName()!=null ){
            //不为空设置条件为关键字
            params.set("q", product.getProductName());
        }else{//如果为空查询所有
            params.set("q", "*:*");

        }
        //默认查询字段  一般默认指定
        params.set("df", "productName");
        //指定查询结果返回哪些字段
        params.set("fl", "id,productName,productColor,productPrice,productSize,productState,productImg");
        // 设置高亮字段
        params.addHighlightField("productName"); // 高亮字段
        //分页
        if(page==null){
            params.setStart(0);
        }else {
            params.setStart((page-1)*rows);
        }
        if(rows==null){
            params.setRows(5);
        }else {
            params.setRows(rows);
        }


        //高亮
        //打开开关
        params.setHighlight(true);
        //设置前缀
        params.setHighlightSimplePre("<span style='color:red'>");
        //设置后缀
        params.setHighlightSimplePost("</span>");
        //QueryResponse是查询返回的对象数据   client.query("core1",params)  查询的是哪个索引库和条件
        QueryResponse queryResponse = client.query("core1",params);
        ///查询返回的结果list对象   不包括高亮
        SolrDocumentList results = queryResponse.getResults();
        //查询出来总条数
        long numFound = results.getNumFound();
        //查询返回的高亮结果
        Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
        //循环查询的所有结果
        for (SolrDocument result : results) {
            //创建对象接收循环的对象数据
            Product product1=new Product();
            //设置高亮的字段
            String highname="";
            //根据id获得高亮的内容
            Map<String, List<String>> map = highlight.get(result.get("id"));
            //根据高亮字段拿到数据
            List<String> list = map.get("productName");
            //判断数据是否为空
            if(list==null){
                //如果为空把普通字段放到对象中
                highname=(String)result.get("productName");
            }else{
                //获得高亮字段查询的值放到变量
                highname=list.get(0);
            }
            product1.setProductId(Integer.parseInt((String) result.get("id")));
            product1.setProductName(highname);
            product1.setProductColor((String)result.get("productColor"));
            product1.setProductPrice((Double)result.get("productPrice"));
            product1.setProductSize((String)result.get("productSize"));
            product1.setProductState((Integer)result.get("productState"));
            product1.setProductImg((String)result.get("productImg"));
            productlist.add(product1);

        }
        mSolr.put("total",numFound);
        mSolr.put("rows",productlist);
        /*model.addAttribute("data",mSolr);*/
        /*HttpSession session = request.getSession();
        session.setAttribute("productlist",productlist);*/
        String key = "keys";
        redisTemplate.opsForValue().set(key,productlist);
        return mSolr;
    }

    @RequestMapping("findSearch")
    @ResponseBody
    public List<Product> findSearch(HttpServletRequest request){
        /*HttpSession sess = request.getSession();
        List<Product> list = (List<Product>)sess.getAttribute("productlist");*/
        /*System.out.println(obj.get("total"));
        List<Product> list =(List<Product>)obj.get("rows");*/
        String key = "keys";
        List<Product> list= (List<Product>)redisTemplate.opsForValue().get(key);
        for (Product li:list) {
            System.out.println(li.getProductName());
            System.out.println("==========="+li.getProductImg());
        }
        redisTemplate.delete(key);
        return list;
    }
}
