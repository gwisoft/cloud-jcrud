package org.jcrud.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * EurekaServer test
 * @author Lincm
 */
@SpringBootApplication
@EnableEurekaServer
@EnableZuulProxy
public class EurekaServerApp 
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(EurekaServerApp.class).web(true).run(args);
    }
}
