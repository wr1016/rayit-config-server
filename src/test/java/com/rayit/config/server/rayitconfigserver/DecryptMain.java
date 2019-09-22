package com.rayit.config.server.rayitconfigserver;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DecryptMain {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送post请求
        HttpPost post = new HttpPost("http://localhost:8080/decrypt");

        // 设置请求的参数，对a06d29e1e6399f45c64227318da80ff1b00eb697e19eea499130f7e1a098ab90进行解密，编码格式为UTF-8
        HttpEntity entity = new StringEntity("a06d29e1e6399f45c64227318da80ff1b00eb697e19eea499130f7e1a098ab90", Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}