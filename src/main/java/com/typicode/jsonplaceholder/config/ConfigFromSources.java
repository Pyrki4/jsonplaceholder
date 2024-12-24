package com.typicode.jsonplaceholder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:default.properties"})
public interface ConfigFromSources extends Config {
    @Key("base.uri")
    @DefaultValue("https://jsonplaceholder.typicode.com/")
    String getBaseUriResources();
}
