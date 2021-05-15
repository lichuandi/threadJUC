package com.lichuandi.enums;

/**
 * @Auther digege
 * @Date 2021/5/15
 * @Description：
 * @page com.lichuandi.enums
 * version：1
 */
public class InnerEnumTest {
    enum Color{
        RED,GREEN,BLUE;
        // 构造函数
        private Color()
        {
            System.out.println("Constructor called for : " + this.toString());
        }

        public void colorInfo()
        {
            System.out.println("Universal Color");
        }
    }

    public InnerEnumTest() {
    System.out.println();
    }

    public static void main(String[] args) {
      Color red = Color.RED;
    System.out.println(red);
    red.colorInfo();
  }
}
//枚举类color转为内部类实现
class Color{
    public static  final Color RED= new Color();
    public static  final Color GREEN= new Color();
    public static  final Color BLUE= new Color();
}