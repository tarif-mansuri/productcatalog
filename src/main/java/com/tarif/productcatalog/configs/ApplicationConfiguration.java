package com.tarif.productcatalog.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public String getStringBean(){
        return "This is my Bean";
    }

    @Bean
    public RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }
}
