package org.jcrud.client.consumer.controllers;

import org.jcrud.client.consumer.services.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	public static Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Autowired
    private HelloService helloServcie;
	
    @RequestMapping("/test/{fallback}")
    public String hello(@PathVariable("fallback") String fallback){
    	logger.info("调用方法hello");
    	String res=helloServcie.hello(fallback);
        return "调用服务结果为"+res;
    }
}
