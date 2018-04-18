package com.bow.cloud.hystrix;

import java.util.concurrent.TimeUnit;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * @author vv
 * @since 2018/4/18.
 */
public class SimpleCommand extends HystrixCommand<String> {

    protected SimpleCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CmdGrp"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("CmdKey"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
        .withCircuitBreakerRequestVolumeThreshold(10)
        .withCircuitBreakerErrorThresholdPercentage(50)
        .withCircuitBreakerSleepWindowInMilliseconds(10_000)
        .withExecutionTimeoutInMilliseconds(10_000)));
    }

    @Override
    protected String run() throws Exception {
        // 制造超时
        TimeUnit.SECONDS.sleep(3);
        return "result vv";
    }

    @Override
    protected String getFallback() {
        System.out.println(">> executing fallback.");
        return "fallback vv";
    }




}
