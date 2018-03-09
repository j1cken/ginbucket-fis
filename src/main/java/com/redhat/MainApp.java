package com.redhat;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Camel Application
 */
@SpringBootApplication
@EnableAutoConfiguration
public class MainApp extends RouteBuilder {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void configure() throws Exception {
        String chatId = System.getenv("TELEGRAM_CHAT_ID");
        String authToken = System.getenv("TELEGRAM_AUTH_TOKEN");

        restConfiguration().component("undertow").port(8080).bindingMode(RestBindingMode.auto);

        // rest("/opp").put("/subscribe").to("amqp:queue:subs");

        // from("amqp:queue:subs").setHeader("CamelTelegramChatId", constant(chatId))
        //         .to("telegram:bots/" + authToken);
        rest("/opp").put("/subscribe").to("direct:foo");

        from("direct:foo").setHeader("CamelTelegramChatId", constant(chatId)).to("telegram:bots/" + authToken);

    }

}
