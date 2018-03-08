package com.redhat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Camel Application
 */
@SpringBootApplication
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        SpringApplication.run(MainApp.class, args);
        // Main main = new Main();
        // main.addRouteBuilder(new MyRouteBuilder());
        // main.run(args);
    }

}
