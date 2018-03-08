package com.redhat;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.component.salesforce.SalesforceLoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${security.loginUrl}")
    String loginUrl;

    @Autowired
    SalesforceComponent component;

    @Bean("loginConfig")
    public SalesforceLoginConfig create() {
        SalesforceLoginConfig cfg = new SalesforceLoginConfig();
        cfg.setLoginUrl(loginUrl);
        return cfg;
    }

    @Bean
    AMQPConnectionDetails amqpConnection() {
        String serviceName = System.getenv("AMQP_SVC_NAME");
        String servicePort = System.getenv("AMQP_SVC_PORT");
        String userName = System.getenv("AMQP_USERNAME");
        String userPassword = System.getenv("AMQP_USERPWD");

        return new AMQPConnectionDetails("amqp://" + serviceName + ":" + servicePort, userName, userPassword);
    }
}