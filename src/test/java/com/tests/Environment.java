package com.tests;

import org.aeonbits.owner.Config;


@Config.Sources({
    "classpath:${env}.properties" // mention the property file name
})

public interface Environment extends Config {
	    String url();
	}

