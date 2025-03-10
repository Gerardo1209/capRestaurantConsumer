package com.capgemini.bootcamp.java.excersicetwo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfiguration {

    @Bean
    public LogManager createLogManager(){
        return processLog("product.log");
    }

    protected LogManager processLog(String log){
        try{
            return new LogManagerImp(log);
        }catch (Exception e){
            return null;
        }
    }

}
