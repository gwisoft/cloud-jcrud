package org.ZipkinServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ZipkinServerApp.class,args);
    }
}
