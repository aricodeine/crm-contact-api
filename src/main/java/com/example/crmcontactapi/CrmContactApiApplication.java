package com.example.crmcontactapi;

import com.example.crmcontactapi.config.SalesforceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SalesforceProperties.class)
public class CrmContactApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmContactApiApplication.class, args);
    }

}
