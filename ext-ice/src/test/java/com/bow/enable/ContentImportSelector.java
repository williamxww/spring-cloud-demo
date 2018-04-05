package com.bow.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 根据{@link EnableDemo#policy()}选择加载配置
 * 
 * @author vv
 * @since 2018/4/2.
 */
public class ContentImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Class<?> annotationType = EnableDemo.class;
        AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(importingClassMetadata.getAnnotationAttributes(annotationType.getName(), false));
        String policy = attributes.getString("policy");
        // policy是dev则注册DevConfig中配置的Bean
        if ("dev".equals(policy)) {
            return new String[] { DevConfig.class.getName() };
        } else {
            return new String[] { DemoConfig.class.getName() };
        }
    }
}
