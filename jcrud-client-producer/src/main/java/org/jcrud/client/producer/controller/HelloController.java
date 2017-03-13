package org.jcrud.client.producer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {
	public static Logger logger = LoggerFactory.getLogger(HelloController.class);
	public static Log log = LogFactory.getLog(HelloController.class);
			
	@RequestMapping("/hello/{fallback}")
    @HystrixCommand(fallbackMethod="helloFallbackMethod")/*调用方式失败后调用helloFallbackMethod*/
    public String hello(@PathVariable("fallback") String fallback){
		logger.info("调用方法hello");
		log.info("调用方法hello");
		if("1".equals(fallback)){
            throw new RuntimeException("...");
        }
        return "hello";
    }

    public String helloFallbackMethod(String fallback){
    	logger.info("调用方法helloFallbackMethod");
    	log.info("调用方法helloFallbackMethod");
        return "fallback 参数值为:"+fallback;
    }
}
