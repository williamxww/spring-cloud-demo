package com.bow.cloud.ice;

/**
 * @author vv
 * @since 2018/4/5.
 */
@IceClient(name="printer", configuration = SimpleClientConfiguration.class)
public interface IPrinter {

    boolean printer(String content);
}
