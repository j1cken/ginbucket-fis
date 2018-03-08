package com.redhat;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        String chatId = System.getenv("TELEGRAM_CHAT_ID");
        String authToken = System.getenv("TELEGRAM_AUTH_TOKEN");

        restConfiguration().component("undertow").port(8080).bindingMode(RestBindingMode.auto);

        rest("/opp").put("/subscribe").to("amqp:queue:subs");

        from("amqp:queue:subs").setHeader("CamelTelegramChatId", constant(chatId))
                // .setHeader("CamelTelegramMediaType", constant(TelegramMediaType.TEXT))
                .to("telegram:bots/" + authToken);

    }
}