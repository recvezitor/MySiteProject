package com.dimas.springcore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class HelloService implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware {

    final static Logger l = LoggerFactory.getLogger(HelloService.class);

    private String beanName;
    private ApplicationContext context;

    @Value("${dimas.required}")
    private String hello;

    public String sayHello() {
        return hello;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        l.info("Custom init");
        l.info("Bean name is: '{}'", beanName);
        l.info("Context is: '{}'", context);
        if (hello == null || hello.isEmpty())
            l.info("hello field is empty");
    }

    @Override
    public void destroy() throws Exception {
        l.info("Destroying Bean");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
