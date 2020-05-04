package com.fileshare.config;

import com.fileshare.FileshareApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class StaticResourceConfiguration extends WebConfig {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/storage/**").addResourceLocations("file:" + FileshareApplication.STORAGE_DIR);
        super.addResourceHandlers(registry);
    }
}
