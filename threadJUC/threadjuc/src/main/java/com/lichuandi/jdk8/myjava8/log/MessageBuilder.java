package com.lichuandi.jdk8.myjava8.log;

/**
 * @author digege
 * @date 2022/1/21 23:37
 * @description：TODO
 * @page com.lichuandi.jdk8.myjava8.log
 * version：1
 */
@FunctionalInterface
public interface MessageBuilder {

    /**
     * 建立日志
     * @return {@link String}
     */
    public abstract String builderMessage();
}
