package com.manconeg.dynamicProperty;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Properties;

@EnableScheduling
@Configuration
public class DynamicPropertyTask {
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        String resourceName = "application.properties";

        Properties props = new Properties();

        try {
            props = PropertiesLoaderUtils.loadAllProperties(resourceName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DynamicProperties.setProperties(props);
    }
}
