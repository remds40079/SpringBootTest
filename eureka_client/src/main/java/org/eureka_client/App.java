package org.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	
    public static void main( String[] args )
    {
    	SpringApplication application = new SpringApplication(App.class);
    	application.run(args);
    }
}
