package com.redhat;

import org.apache.camel.main.Main;
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
        Main main = new Main();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run(args);
    }

}
