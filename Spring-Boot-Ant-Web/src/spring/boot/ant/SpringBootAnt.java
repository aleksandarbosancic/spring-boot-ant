/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant;

/**
 *
 * @author abosancic
 */
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootAnt extends SpringBootServletInitializer implements CommandLineRunner
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootAnt.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootAnt.class);
    }

    @Override
    public void run(String... strings) throws Exception
    {
    }
}
