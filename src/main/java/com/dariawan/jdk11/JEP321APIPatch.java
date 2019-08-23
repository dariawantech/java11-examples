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
package com.dariawan.jdk11;

import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.concurrent.CompletableFuture;

public class JEP321APIPatch {

    public static void main(String[] args) throws Exception {

        String json = "{ \"title\": \"Title\" }";
        final HttpClient httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .proxy(ProxySelector.getDefault())
                .build();

        HttpRequest request = HttpRequest.newBuilder()
           .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
           .header("Content-type", "application/json")
           .method("PATCH", BodyPublishers.ofString(json))
           .build();

        CompletableFuture<HttpResponse<String>> response
                = httpClient.sendAsync(request, BodyHandlers.ofString());
        String body = response.thenApply(HttpResponse::body).get();
        HttpHeaders headers = response.thenApply(HttpResponse::headers).get();
        int statusCode = response.thenApply(HttpResponse::statusCode).get();
        System.out.println("status code: " + statusCode);
        System.out.println("headers: " + headers);
        System.out.println("body: " + body);
    }
}
