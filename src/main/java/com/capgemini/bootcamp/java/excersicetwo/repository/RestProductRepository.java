package com.capgemini.bootcamp.java.excersicetwo.repository;

import com.capgemini.bootcamp.java.excersicetwo.domain.entity.ProductEntity;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository
@Qualifier("rest")
public class RestProductRepository implements ProductRepository {

    private RestTemplate restTemplate;

    @Value("${application.auth.user}")
    private String user;
    @Value("${application.auth.password}")
    private String password;

    public RestProductRepository(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<ProductEntity> get(){
        var result = this.restTemplate.exchange(
                "http://localhost:8081/api/product",
                HttpMethod.GET,
                new HttpEntity<>(createHttpHeaders(this.user, this.password)),
               ProductEntity[].class
        );
        if(result.getBody() == null) return null;
        return List.of(result.getBody());
    }

    private HttpHeaders createHttpHeaders(String username, String password){
                return new HttpHeaders(){{
                    String auth = username + ":" + password;
                    byte[] encodedAuth = Base64.encode(auth.getBytes(StandardCharsets.US_ASCII));
                    String authHeader = "Basic " + new String(encodedAuth);
                    set("Authorization", authHeader);
                }};
    }

}
