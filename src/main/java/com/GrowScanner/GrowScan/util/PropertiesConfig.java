package com.GrowScanner.GrowScan.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class PropertiesConfig {
	@Autowired
    private Environment env;

    public String getProperty(String pPropertyKey) {
        return env.getProperty(pPropertyKey);
    }
}
