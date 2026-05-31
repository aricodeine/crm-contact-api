package com.example.crmcontactapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "salesforce")
public record SalesforceProperties(String baseUrl, String clientId, String clientSecret) {

}
