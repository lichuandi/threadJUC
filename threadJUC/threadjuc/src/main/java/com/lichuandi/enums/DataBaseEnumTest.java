package com.lichuandi.enums;

import java.util.EnumMap;

/**
 * @Auther digege
 * @Date 2021/5/15
 * @Description：
 * @page com.lichuandi.enums
 * version：1
 */
public class DataBaseEnumTest {
  EnumMap<DataBaseType, String> mapUrls = new EnumMap<DataBaseType, String>(DataBaseType.class);
  public EnumMap<DataBaseType, String> dataBaseInfo(){

    mapUrls.put(DataBaseType.DB2,"jdbc:db2://localhost:5000/sample");
    mapUrls.put(DataBaseType.MYSQL,"jdbc:mysql://localhost/mydb");
    mapUrls.put(DataBaseType.ORACLE,"jdbc:oracle:thin:@localhost:1521:sample");
    mapUrls.put(DataBaseType.SQLSERVER,"jdbc:microsoft:sqlserver://sql:1433;Database=mydb");
    return mapUrls;
  }
  //根据不同的数据库类型，返回对应的URL
// @param type DataBaseType 枚举类新实例
// @return
  public  String getURL(DataBaseType type) {
    return mapUrls.get(type);
  }

  public static void main(String[] args) {
    DataBaseEnumTest dataBaseEnumTest = new DataBaseEnumTest();
    System.out.println(dataBaseEnumTest.dataBaseInfo());
    System.out.println(dataBaseEnumTest.getURL(DataBaseType.DB2));
  }
}
