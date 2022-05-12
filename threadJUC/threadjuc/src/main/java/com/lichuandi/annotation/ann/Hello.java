package com.lichuandi.annotation.ann;

import org.springframework.data.repository.query.Param;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author digege
 * @date 2021/9/3 15:49
 * @description：TODO
 * @page com.lichuandi.annotation.ann
 * version：1
 */
@Resource(description = "hello")
public class Hello {
    @Inject
    int n;

    @PostConstruct
    public void hello(@Param("name") String name) {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Hello";
    }
}