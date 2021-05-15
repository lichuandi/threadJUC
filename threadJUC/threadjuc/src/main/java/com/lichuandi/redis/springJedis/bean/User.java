package com.lichuandi.redis.springJedis.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther digege
 * @Date 2021/5/3
 * @Description：com.lichuandi.redis.springJedis.bean version：1
 */

@Slf4j
@Data
public class User implements Serializable {
    String uid;
    String devId;
    String token;
    String nickName;

}

