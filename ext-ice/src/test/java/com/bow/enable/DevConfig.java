package com.bow.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author vv
 * @since 2018/4/2.
 */
@Configuration
public class DevConfig {

    @Bean
    public ContentService getService(){
        return new SimpleContentService("dev");
    }
}
