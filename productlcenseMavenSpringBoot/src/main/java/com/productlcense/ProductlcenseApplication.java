package com.productlcense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProductlcenseApplication extends SpringBootServletInitializer {

    @Override
    // Configuring method has to be overridden    
    protected SpringApplicationBuilder
            configure(SpringApplicationBuilder application) {
        return application.sources(
                ProductlcenseApplication.class);
    }

    // Method 2    
    // Main driver method    
    public static void main(String[] args) {
        SpringApplication.run(
                ProductlcenseApplication.class,
                args);
    }

}
