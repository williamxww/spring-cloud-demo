package com.bow.cloud.eureka.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 计算器
 * 普通调用 serviceId  provider-service
 * sidecar serviceId sidecarTest
 * @author vv
 * @since 2018/3/27.
 */
@FeignClient(value = "sidecarTest")
public interface ICalculator {

    @RequestMapping(value = "/calculate/add", method = RequestMethod.GET)
    int add(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b);

    @RequestMapping(value = "/calculate/sub", method = RequestMethod.GET)
    int sub(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b);
}
