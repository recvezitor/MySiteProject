package com.dimas.springcore.functional;

import com.dimas.util.SimpleUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config.xml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class SpringAppFunctionalTest {
    final Logger l = LoggerFactory.getLogger(getClass());

    @Test
    public void testSayHello() {
        l.info("FUNCTIONAL core");
        SimpleUtil util = new SimpleUtil();
        util.setName("NameFFF");
        util.setVersion(123666);
        util.print2();
        util.print3();
    }
}
