package com.dimas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
    final static Logger l = LoggerFactory.getLogger(HelloApp.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("spring-config.xml");
        context.registerShutdownHook();
        HelloService helloService = context.getBean(HelloService.class);
        l.info(helloService.sayHello());
    }
}
