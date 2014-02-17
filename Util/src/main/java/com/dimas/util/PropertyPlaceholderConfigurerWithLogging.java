package com.dimas.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Copyright 2009-2013. NxSystems Inc.
 * PROPRIETARY/CONFIDENTIAL.
 * <p/>
 * Created: 17.10.13 16:18
 *
 * @author Dmitry Borovoy
 */
public class PropertyPlaceholderConfigurerWithLogging extends PropertyPlaceholderConfigurer {

    private final Logger l = LoggerFactory.getLogger(PropertyPlaceholderConfigurerWithLogging.class);

    private final static String PASSWORD_KEY = "pass";
    private final static String MASKED_PASSWORD = "********";
    private boolean propertiesLoggingEnabled = false;
    private boolean sortingEnabled = true;
    private boolean passwordMaskingEnabled = true;

    public boolean isPropertiesLoggingEnabled() {
        return propertiesLoggingEnabled;
    }

    public void setPropertiesLoggingEnabled(boolean propertiesLoggingEnabled) {
        this.propertiesLoggingEnabled = propertiesLoggingEnabled;
    }

    public boolean isSortingEnabled() {
        return sortingEnabled;
    }

    public void setSortingEnabled(boolean sortingEnabled) {
        this.sortingEnabled = sortingEnabled;
    }

    public boolean isPasswordMaskingEnabled() {
        return passwordMaskingEnabled;
    }

    public void setPasswordMaskingEnabled(boolean passwordMaskingEnabled) {
        this.passwordMaskingEnabled = passwordMaskingEnabled;
    }

    @Override
    protected Properties mergeProperties() throws IOException {
        Properties properties = super.mergeProperties();
        if (propertiesLoggingEnabled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PROPERTIES:");
            List tmp = Collections.list(properties.keys());
            if (sortingEnabled) {
                Collections.sort(tmp);
            }
            Iterator it = tmp.iterator();
            while (it.hasNext()) {
                String element = (String) it.next();
                stringBuilder.append("\r\n");
                stringBuilder.append(element);
                stringBuilder.append("=");
                stringBuilder.append(passwordMaskingEnabled & element.toLowerCase().contains(PASSWORD_KEY) ? MASKED_PASSWORD : properties.get(element));
            }
            l.debug("{}", stringBuilder.toString());
        }
        return properties;
    }
}