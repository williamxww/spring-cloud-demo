package com.bow.cloud.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/config")
@RestController
@RefreshScope
public class ConfigDisplayer {

    @Autowired
    private Environment env;

    @Value("${name}")
    private String name;

    /**
     * 通过Environment获取配置
     *
     * @return
     */
    @RequestMapping("/env")
    public String env() {
        String configValue = env.getProperty("name", "william");
        return configValue;
    }


    /**
     * 通过注入获取配置
     *
     * @return
     */
    @RequestMapping("/name")
    public String name() {
        return name;
    }

}
