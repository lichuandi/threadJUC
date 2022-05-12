package com.lichuandi.jdk8.stream;

/**
 * @author digege
 * @date 2022/3/17 23:03
 * @description：TODO
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lichuandi.jdk8.myjava8.entity.Coupon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class ListGroupTest {
    public static void main(String[] args) {
        List<Coupon> couponList = new ArrayList<>();
        Coupon coupon1 = new Coupon(1,100,"优惠券1");
        Coupon coupon2 = new Coupon(2,200,"优惠券2");
        Coupon coupon3 = new Coupon(3,300,"优惠券3");
        Coupon coupon4 = new Coupon(3,400,"优惠券4");
        couponList.add(coupon1);
        couponList.add(coupon2);
        couponList.add(coupon3);
        couponList.add(coupon4);
        Map<Integer, List<Coupon>> resultList = couponList.stream().collect(Collectors.groupingBy(Coupon::getCouponId));
        System.out.println(JSON.toJSONString(resultList, SerializerFeature.PrettyFormat));
        Map<Integer, List<String>> resultList2 = couponList.stream().collect(Collectors.groupingBy(Coupon::getCouponId,Collectors.mapping(Coupon::getName,Collectors.toList())));
        System.out.println(JSON.toJSONString(resultList2, SerializerFeature.PrettyFormat));

    }
}