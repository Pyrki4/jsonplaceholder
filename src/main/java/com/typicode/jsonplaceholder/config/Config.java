package com.typicode.jsonplaceholder.config;

import org.aeonbits.owner.ConfigFactory;

public class Config {
    public static ConfigFromSources config = ConfigFactory.create(ConfigFromSources.class);
}
