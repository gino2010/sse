package com.gino.ssedemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 * http client test
 *
 * @author gino
 * Created on 16/02/2018
 */
@RunWith(value = JUnit4.class)
public class HttpClientTest {

    @Test
    public void testClient() throws Exception {
        String url = "http://localhost:8080/stock/transaction";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
//         request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        // StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            // result.append(line);
            System.out.println(line);
        }
    }
}
