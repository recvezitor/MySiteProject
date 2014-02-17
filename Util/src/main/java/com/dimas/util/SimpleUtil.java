package com.dimas.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright 2009-2014. NxSystems Inc.
 * PROPRIETARY/CONFIDENTIAL.
 * <p/>
 * Created: 16.02.14 14:29
 *
 * @author Dmitry Borovoy
 */
public class SimpleUtil {

    private final Logger l = LoggerFactory.getLogger(SimpleUtil.class);

    private String name;

    private int version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void print() {
        l.info("Name:{}, version:{}", name, version);
    }


    public void print1() {
        l.info("123");
    }

    public void print2() {
        l.info("12345");
    }

    public void print3() {
        l.info("666");
    }


}
