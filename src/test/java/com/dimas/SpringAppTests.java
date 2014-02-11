package com.dimas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringAppTests {

    @Autowired
    private HelloService helloService;

    @Value("${dimas.required}")
    String hello;

    @Test
    public void testSayHello() {
        assertEquals(hello, helloService.sayHello());
    }
}
