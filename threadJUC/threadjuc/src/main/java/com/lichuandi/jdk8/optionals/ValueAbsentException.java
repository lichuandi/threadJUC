package com.lichuandi.jdk8.optionals;

/**
 * @author digege
 * @date 2021/11/22 15:50
 * @description：TODO
 * @page com.lichuandi.jdk8.optionals
 * version：1
 */
public class ValueAbsentException extends Throwable{
    public ValueAbsentException() {
        super();
    }
    public ValueAbsentException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
       // return super.getMessage();
        return "No Value present in" +
                " the Optional instance";
    }
}
