package com.lichuandi.string;

/**
 * @Auther digege
 * @Date 2021/6/4
 * @Description：
 * @page com.lichuandi.string
 * version：1
 */
public class StringNullDemo {
  public static void main(String[] args) {
    //
  }
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str.trim());
    }
    public static boolean isEmpty(Object str) {
        if (str instanceof String) {
            return isEmpty((String) str);
        }
        return org.springframework.util.StringUtils.isEmpty(str);
    }
    public static boolean equals(String source, String target) {
        if (source == null && target == null) {
            return true;
        }
        if (!isEmpty(source)) {
            return source.equals(target);
        }
        return isEmpty(target);
    }
}
