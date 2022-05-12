package com.lichuandi.jdk8.stream;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author digege
 * @date 2022/3/9 22:10
 * @description：TODO
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
@Data
public class MyStudent {
      private String name;
      private String sex;
      private String age;
      private List<ST> st;

      private Timestamp birthday;

}
@Data
class ST{
      private String aa;
      private String bb;
}