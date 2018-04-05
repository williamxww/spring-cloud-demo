package com.bow.enable;

/**
 * @author vv
 * @since 2018/4/2.
 */
public class SimpleContentService implements ContentService {

    private String mode;

    public SimpleContentService(String m) {
        this.mode = m;
    }

    @Override
    public void doSomething() {
        System.out.println("wu la la " + mode);
    }
}
