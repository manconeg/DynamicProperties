package com.manconeg.dynamicProperty;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Properties;

@EnableScheduling
@Configuration
public class DynamicPropertyTask {
    private String resourceName;

    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        Properties props = new Properties();

        try {
            props = PropertiesLoaderUtils.loadAllProperties(resourceName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DynamicProperties.setProperties(props);
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
