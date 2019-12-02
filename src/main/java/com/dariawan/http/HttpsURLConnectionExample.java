/**
 * Java 11 Code Examples v1 (https://www.dariawan.com)
 * Copyright (C) 2019 Dariawan <hello@dariawan.com>
 *
 * Creative Commons Attribution-ShareAlike 4.0 International License
 *
 * Under this license, you are free to:
 * # Share - copy and redistribute the material in any medium or format
 * # Adapt - remix, transform, and build upon the material for any purpose,
 *   even commercially.
 *
 * The licensor cannot revoke these freedoms
 * as long as you follow the license terms.
 *
 * License terms:
 * # Attribution - You must give appropriate credit, provide a link to the
 *   license, and indicate if changes were made. You may do so in any
 *   reasonable manner, but not in any way that suggests the licensor
 *   endorses you or your use.
 * # ShareAlike - If you remix, transform, or build upon the material, you must
 *   distribute your contributions under the same license as the original.
 * # No additional restrictions - You may not apply legal terms or
 *   technological measures that legally restrict others from doing anything the
 *   license permits.
 *
 * Notices:
 * # You do not have to comply with the license for elements of the material in
 *   the public domain or where your use is permitted by an applicable exception
 *   or limitation.
 * # No warranties are given. The license may not give you all of
 *   the permissions necessary for your intended use. For example, other rights
 *   such as publicity, privacy, or moral rights may limit how you use
 *   the material.
 *
 * You may obtain a copy of the License at
 *   https://creativecommons.org/licenses/by-sa/4.0/
 *   https://creativecommons.org/licenses/by-sa/4.0/legalcode
 */
package com.dariawan.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;

public class HttpsURLConnectionExample {

    private HttpsURLConnection getHttpsClient(String url) throws Exception {

        HttpsURLConnection client = (HttpsURLConnection) new URL(url).openConnection();
        //add request header
        client.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        return client;
    }

    private void testGet() throws Exception {
        System.out.println("*** Test Http GET request ***");

        String url = "https://www.onlinefreeconverter.com/random-words?n=15";
        HttpsURLConnection client = getHttpsClient(url);

        int responseCode = client.getResponseCode();
        System.out.println("GET request to URL: " + url);
        System.out.println("Response Code     : " + responseCode);
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            System.out.println(response.toString());
        }
    }

    private void testPost() throws Exception {
        System.out.println("*** Test Http POST request ***");

        String url = "https://www.onlinefreeconverter.com/test/post";
        String urlParameters = "param1=a&param2=b&param3=c";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;

        HttpsURLConnection client = getHttpsClient(url);
        client.setRequestMethod("POST");
        client.setDoOutput(true);
        client.setInstanceFollowRedirects(false);
        client.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        client.setRequestProperty("charset", "utf-8");
        client.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        client.setUseCaches(false);

        try (OutputStream os = client.getOutputStream()) {
            os.write(postData);
        }

        int responseCode = client.getResponseCode();
        System.out.println("POST request to URL: " + url);
        System.out.println("POST Parameters    : " + urlParameters);
        System.out.println("Response Code      : " + responseCode);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            System.out.println(response.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        HttpsURLConnectionExample obj = new HttpsURLConnectionExample();
        obj.testGet();
        obj.testPost();
    }
}