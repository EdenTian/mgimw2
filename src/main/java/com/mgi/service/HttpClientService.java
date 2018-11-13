package com.mgi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgi.service.impl.JedisCacheClient;
import com.mgi.util.ExecuteResult2;
import com.mgi.util.ExecutionResult;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HttpClientService {

    @Autowired
    private CloseableHttpClient httpclient;
    @Autowired
    private JedisCacheClient jedisCacheClient;

    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private RequestConfig config;

    /**
     * 没有带参数的doget方法
     */
    public String doget(String url) throws ClientProtocolException, IOException {
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        // 设置请求配置信息
        httpGet.setConfig(config);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");

            }
        } finally {
            if (response != null) {
                response.close();
            }
        // 交给线程去清理
        // httpclient.close();
        }
        return null;
    }

    /**
     * 带参数的doget方法
     */
    public String doget(String url, Map<String, Object> parameters) throws ClientProtocolException,
            IOException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        if (!parameters.isEmpty()) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }
        URI uri = uriBuilder.build();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(uri);
        // 设置请求配置信息
        httpGet.setConfig(config);
        CloseableHttpResponse response = null;
        try {
        // 执行请求
            response = httpclient.execute(httpGet);
        // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");

            }
        } finally {
            if (response != null) {
                response.close();
            }
        // 交给线程去清理
        // httpclient.close();
        }
        return null;
    }

    /**
     * 有带参数的DoPost请求
     *
     * @throws IOException
     * @throws ClientProtocolException
     */
    public ExecutionResult doPost(String url, Map<String, Object> parameters) throws ClientProtocolException,
            IOException {

        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);

        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> listparameters = new ArrayList<NameValuePair>(0);
        if (!parameters.isEmpty()) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                listparameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }

            // 构造一个form表单式的实体
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(listparameters, "UTF-8");
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(formEntity);
        }

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            System.out.println("response = " + response.getEntity().toString());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                return new ExecutionResult (response.getStatusLine().getStatusCode(), EntityUtils.toString(
                        response.getEntity(), "UTF-8"));
            }
        } finally {
            if (response != null) {
                response.close();
            }
            // httpclient.close();
        }
        return new ExecutionResult (response.getStatusLine().getStatusCode(), null);
    }
    /**
     * 往SF发送数据,并返回结果
     *
     * @throws IOException
     * @throws ClientProtocolException
     */
    public ExecuteResult2 doPostHeader(String url,String s,String token) throws ClientProtocolException,
            IOException {

        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        if (token != null && !"".equals(token)){
            httpPost.setHeader("Authorization",token);
        }
        httpPost.setHeader("Content-Type","application/json; charset=UTF-8");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setEntity(new StringEntity(s,Charset.forName("UTF-8")));
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                JsonNode jsonNode = mapper.readTree(EntityUtils.toString(response.getEntity()));
                int status = Integer.parseInt(jsonNode.get("status").asText());
                String msg = jsonNode.get("msg").asText();
                System.out.println("status = " + status);
                return new ExecuteResult2(status, msg);
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return new ExecuteResult2 (response.getStatusLine().getStatusCode(),null);
    }
    /**
     * 有带参数的DoPost请求
     *
     * @throws IOException
     * @throws ClientProtocolException
     */
    public String doPosttoSFGetToken(String url) throws IOException {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String content = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch(Exception e){
             e.printStackTrace();
        }finally {
            if (response != null) {
                response.close();
            }
        }
        return content;
    }

    /**
     * 没有带参数的dopost
     *
     * @throws IOException
     * @throws ClientProtocolException
     */
    public ExecutionResult doPost(String url) throws ClientProtocolException, IOException {
        return this.doPost(url, null);
    }

}
