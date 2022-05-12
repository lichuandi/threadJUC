package com.lichuandi.jdk8.myjava8.entity;

/**
 * @author digege
 * @date 2022/3/17 23:02
 * @description：TODO
 * @page com.lichuandi.jdk8.myjava8.entity
 * version：1
 */
public class Coupon {
    private Integer couponId;
    private Integer price;
    private String name;
    public Coupon(Integer couponId, Integer price, String name) {
        this.couponId = couponId;
        this.price = price;
        this.name = name;
    }
    public Integer getCouponId() {
        return couponId;
    }
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}