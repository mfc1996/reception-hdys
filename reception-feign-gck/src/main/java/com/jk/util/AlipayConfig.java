package com.jk.util;

/**
 * ������AliPay
 */
public class AlipayConfig {

	//AppId
	public static String app_id = "2016100100637894";//�ں�̨��ȡ���������ã�
	//˽Կ
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCUs3emHEqOVcEPHppmsTOdWNVBYqCedarAU1KmnLQqlLRJbqtZMgW9/jIfHHKIJTTCLOs8r/J0aJV7mU7qAoPse21vqYTr4rvSaxqbndtWfZeh8yqJq8ZAZCvXyxKGm6NlVRKTxS0LWrmk9C2TW0Q/i5Bn36qtj8zVIgsjPVjuygjpyYh5+PeebRuB0UZV6cr1vDN9uAsL+66KqpqIyf5+zaJvfxHudAF/+xzkO/db1gIY8G7CpNnEftThS+3laivYUcEvNGcWV6mswLuMJcEOlatECXMoPgAgqIekUaqRDy1MV0YeHotWxsKaU7+lDOkkJJM2CT3W8XLbJ0iU7+hlAgMBAAECggEBAI6/Tg/fPs8ukTtzdGM6nsLg4S94f5o+eOFR25jn+6iYwg1wOPtSIuMFn5XwGB6MIP56YoQKn6SSNVXGkVPhgEVHI4I66MgNC6LugEd9HW8E98hXB7HLfXCY+OGaJzmjNRL0vPWwJhKtUGOCqDG6PmUGFGUy+MTOs6KyoKB+pt3rAJp7aIFPNQK2bE0bbumBEXr+YlESFtFDZnXsrwRmHjE5Z7yujwQpWP5ZueuKtFYcvYhjGMAz5ulhM0Pme4PiDTgekBFvdgGYcXO+UrJPPdP7z6xW7KRY167FsbhjezyK1ECRul64pQvdN8KeO4d8aEC02XATaMxiCuY4QoyTOGECgYEA+mk23lylRlEd0a49IsBd2/FMiKp0XcAHdGwnwxdSq3aJvnR7l6Me42l1+pqCH2H9gr69i9XiJNWTWtQASCP7jYLMrmoZPO0g54wkMxRlbcF3p9r5N6amDnAL1B9cPygKHbQGGj/NvhFRDlJ28Bk7lG8611/nTk1Vqoa7zyyDi6kCgYEAmAUbnl9L6UCqTE51chPcLCrtLYHJcgMrPyGJteGAGmOMmPt9DDa3hje+2FSvgz7fsGSLQTeWwHOoaT8ALyKsZTP6oRIi5OqshKicNsHoMak1+UDXhXUHvBOsT/r9lW+YXh574H6T2HBgKOkGF1zxGXjgfwtTGWW3LcBU/kwwTF0CgYB2n70UXYMV6ntbx1TCz6om9Qoye70gZEWjy1CSxMuu2jqqdHfP/8A0LtNq4iLeRwdXFpCoW6wDkwF5N5Dim9kg0mOwBCbsi9DYn7TOVc0uz0WlyL/isxlbIY0Y8bo7WPZh19REPxFyBrYFON+LIgjtajvPp2jl2RDJ9YWmwQmX8QKBgALSFXEa043AZWiFDCjRtYQcR8pQXix/Yo4JUUTOqlHTBwjPocJYQY97+U6KQ7drszrSosLTBTkM7FMHmDlHq2s1S7ExZPRaZlkPx9Y8QtKpERdO3LDdOweCVfAl+A6Nw4X7itDfiF67tw0LRdGpJ9ARLhktXJ1cBcoTh4AwabUBAoGBAIqclBgNrogQAyeioWCALUMACj3uUTHQMtbvZmnicr41d8vVNAUxd7hA3kNqgxIjzUyYBAWtx+M17ry4CB3CXSfZ1i4VbjK+YjvvwKie2lnr9GbPxm7ot1ClYE3IVbS2n/f9PQCs8N5thZyogTbeHKYBaJOooF2MYxE+tf/raGzZ";//�̳̲鿴��ȡ��ʽ���������ã�
	//��Կ
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlLN3phxKjlXBDx6aZrEznVjVQWKgnnWqwFNSppy0KpS0SW6rWTIFvf4yHxxyiCU0wizrPK/ydGiVe5lO6gKD7Httb6mE6+K70msam53bVn2XofMqiavGQGQr18sShpujZVUSk8UtC1q5pPQtk1tEP4uQZ9+qrY/M1SILIz1Y7soI6cmIefj3nm0bgdFGVenK9bwzfbgLC/uuiqqaiMn+fs2ib38R7nQBf/sc5Dv3W9YCGPBuwqTZxH7U4Uvt5Wor2FHBLzRnFleprMC7jCXBDpWrRAlzKD4AIKiHpFGqkQ8tTFdGHh6LVsbCmlO/pQzpJCSTNgk91vFy2ydIlO/oZQIDAQAB";//�̳̲鿴��ȡ��ʽ���������ã�
	//�������첽֪ͨҳ��·��
	public static String notify_url = "http://www.linhongcun.com/SpringBootPay-0.0.1-SNAPSHOT/pay/notifyUrl";
	//ҳ����תͬ��֪ͨҳ��·��
	public static String return_url = "http://127.0.0.1:8086/returnUrl";
	//ǩ����ʽ
	public static String sign_type = "RSA2";

	public static String format = "json";
	//�ַ�����
	public static String charset = "utf-8";
	//֧��������
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";//ע�⣺ɳ����Ի�������ʽ����Ϊ��https://openapi.alipay.com/gateway.do
}
