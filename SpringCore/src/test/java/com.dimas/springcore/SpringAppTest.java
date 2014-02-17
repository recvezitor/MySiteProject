package com.dimas.springcore;

import com.dimas.springcore.HelloService;
import com.dimas.util.SimpleUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringAppTest {
    final Logger l = LoggerFactory.getLogger(getClass());
    @Autowired
    private HelloService helloService;

    @Value("${dimas.required}")
    String hello;

    @Test
    public void testSayHello() {
        assertEquals(hello, helloService.sayHello());
        l.info("UNIT core");
        SimpleUtil util = new SimpleUtil();
        util.setName("Name");
        util.setVersion(123);
        util.print();
        util.print1();
    }

}
