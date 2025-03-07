package com.capgemini.bootcamp.java.excersicetwo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestHelper {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
