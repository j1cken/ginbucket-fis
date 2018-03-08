package com.redhat;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Value("${security.loginUrl}")
    // String loginUrl;

    // @Autowired
    // SalesforceComponent component;

    // @Bean("loginConfig")
    // public SalesforceLoginConfig loginConfig() {
    //     SalesforceLoginConfig cfg = new SalesforceLoginConfig();
    //     cfg.setLoginUrl(loginUrl);
    //     return cfg;
    // }

    String serviceName = System.getenv("AMQP_SVC_NAME");
    String servicePort = System.getenv("AMQP_SVC_PORT");
    String userName = System.getenv("AMQP_USERNAME");
    String userPassword = System.getenv("AMQP_USERPWD");

    @Bean
    AMQPConnectionDetails amqpConnection() {
        return new AMQPConnectionDetails("amqp://" + serviceName + ":" + servicePort, userName, userPassword);
    }

    // @Bean
    // public JmsConnectionFactory jmsConnectionFactory() {
    //     JmsConnectionFactory factory = new JmsConnectionFactory();
    //     factory.setRemoteURI("amqp://" + serviceName + ":" + servicePort);
    //     factory.setUsername(userName);
    //     factory.setPassword(userPassword);
    //     return factory;
    // }

    // @Bean
    // public CachingConnectionFactory jmsCachingConnectionFactory() {
    //     CachingConnectionFactory factory = new CachingConnectionFactory();
    //     factory.setTargetConnectionFactory(jmsConnectionFactory());
    //     return factory;
    // }

    // @Bean
    // public JmsConfiguration jmsConfig() {
    //     JmsConfiguration jmsConfiguration = new JmsConfiguration();
    //     jmsConfiguration.setConnectionFactory(jmsCachingConnectionFactory());
    //     jmsConfiguration.setCacheLevelName("CACHE_CONSUMER");
    //     return jmsConfiguration;
    // }

    // @Bean
    // public AMQPComponent amqp() {
    //     AMQPComponent component = new AMQPComponent();
    //     component.setConfiguration(jmsConfig());
    //     return component;
    // }

}

/*
<bean id="jmsConnectionFactory" class="org.apache.qpid.jms.JmsConnectionFactory">
  <property name="remoteURI" value="amqp://localhost:5672" />
  <property name="username" value="admin"/>
  <property name="password" value="admin"/>
</bean>
 
<bean id="jmsCachingConnectionFactory" class="org.springframework.jms.connection.CachingConnectionFactory">
  <property name="targetConnectionFactory" ref="jmsConnectionFactory" />
</bean>
 
<bean id="jmsConfig" class="org.apache.camel.component.jms.JmsConfiguration" >
  <property name="connectionFactory" ref="jmsCachingConnectionFactory" /> 
  <property name="cacheLevelName" value="CACHE_CONSUMER" />
</bean>    
 
<bean id="amqp" class="org.apache.camel.component.amqp.AMQPComponent">
    <property name="configuration" ref="jmsConfig" />
</bean> 
*/