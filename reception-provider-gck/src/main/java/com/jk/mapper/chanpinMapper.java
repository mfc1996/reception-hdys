package com.jk.mapper;

import com.jk.model.chanpinBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface chanpinMapper {
    List<chanpinBean> queryChanpinList(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer queryChanpinCount();

    List<chanpinBean> queryProduct();
}
