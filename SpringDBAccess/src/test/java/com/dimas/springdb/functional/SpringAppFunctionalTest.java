package com.dimas.springdb.functional;

import com.dimas.springdb.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class SpringAppFunctionalTest {
    final Logger l = LoggerFactory.getLogger(getClass());
    @Autowired
    private HelloService helloService;


    @Test
    public void testSayHello() {
        l.info("FUNCTIONAL");
    }
}
