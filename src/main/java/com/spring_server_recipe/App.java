package com.spring_server_recipe;

import com.sun.tools.jconsole.JConsoleContext;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class,args);
        try {
            Console.main(args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
