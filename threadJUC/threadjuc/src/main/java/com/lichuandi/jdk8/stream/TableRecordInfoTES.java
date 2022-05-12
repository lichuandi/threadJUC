package com.lichuandi.jdk8.stream;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther digege
 * @Date 2021/6/25
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
public class TableRecordInfoTES {
  public static void main(String[] args) {
    //
      List<TableRecordInfo> tableRecordInfos = new ArrayList<>();
      TableRecordInfo a = new TableRecordInfo();
      a.setTableName("tableA");
      TableRecordInfo b = new TableRecordInfo();
      b.setTableName("tableB");
      TableRecordInfo c = new TableRecordInfo();
      c.setTableName("tableC");
      //
      List<String> aa= new ArrayList<>();
      aa.add("columnNamesA");
      aa.add("columnNamesB");
      aa.add("columnNamesC");
      aa.add("columnNamesD");
      a.setColumnNames(aa);
      List<String> bb= new ArrayList<>();
      bb.add("columnNamesA");
      bb.add("columnNamesD");
      bb.add("columnNamesE");
      bb.add("columnNamesF");
      b.setColumnNames(bb);
      List<String> cc= new ArrayList<>();
      cc.add("columnNamesB");
      cc.add("columnNamesI");
      cc.add("columnNamesJ");
      cc.add("columnNamesG");
      c.setColumnNames(cc);
      //遍历
      tableRecordInfos.add(a);
      tableRecordInfos.add(b);
      tableRecordInfos.add(c);
      //数据配置
      List<TableRecordValue> tableRecordValues = new ArrayList<>();

      TableRecordValue tableRecordValue = new TableRecordValue();
      List<Object> objects1 = new ArrayList<>();
      objects1.add("2021-06-25 09:31:11.192");
      objects1.add("OHLOTOPE");
      objects1.add(null);
      objects1.add("chenhu");
      tableRecordValue.setTableName("tableA");
      tableRecordValue.setReportTimeStamp("shijian");
      tableRecordValue.setColumnValues(objects1);

      TableRecordValue tableRecordValue1 = new TableRecordValue();
      List<Object> objects2 = new ArrayList<>();
      objects2.add("2021-06-25 09:31:11.192");
      objects2.add(null);
      objects2.add(null);
      objects2.add("lili");
      tableRecordValue1.setTableName("tableB");
      tableRecordValue1.setReportTimeStamp("shijian1");
      tableRecordValue1.setColumnValues(objects2);

      TableRecordValue tableRecordValue2 = new TableRecordValue();
      List<Object> objects3 = new ArrayList<>();
      objects3.add("2021-06-25 09:31:11.192");
      objects3.add("digege");
      objects3.add(null);
      objects3.add("gogog");
      tableRecordValue2.setTableName("tableC");
      tableRecordValue2.setReportTimeStamp("shijian2");
      tableRecordValue2.setColumnValues(objects3);

      TableRecordValue tableRecordValue3 = new TableRecordValue();
      List<Object> objects4 = new ArrayList<>();
      objects4.add("2021-06-25 09:31:11.192");
      objects4.add("OHLOTOPE");
      objects4.add(null);
      objects4.add("chenhu");
      tableRecordValue3.setTableName("tableA");
      tableRecordValue3.setReportTimeStamp("shijian3");
      tableRecordValue3.setColumnValues(objects4);

      tableRecordValues.add(tableRecordValue);
      tableRecordValues.add(tableRecordValue1);
      tableRecordValues.add(tableRecordValue2);
      tableRecordValues.add(tableRecordValue3);

    System.out.println("tableRecordInfos:"+tableRecordInfos);
    System.out.println("tableRecordValues:"+tableRecordValues);
      HistoryInformationInqResult result = new HistoryInformationInqResult();
      result.setStrTableRecordInfoSeq(tableRecordInfos);
      result.setStrTableRecordValueSeq(tableRecordValues);
    System.out.println(result);
    System.out.println("**********************************************************************");
     //获取所有字段
      Set<String> s12 = new HashSet<>();
      result.getStrTableRecordInfoSeq().parallelStream().map(
              obj->{
                  Set<String> t2 = new HashSet<>();
                  List<String> columnNames = obj.getColumnNames();
                  t2.addAll(obj.getColumnNames());
                  s12.addAll(t2);
                  return t2;
              }
      ).collect(Collectors.toSet());
    System.out.println("我是去重字段"+s12);
      Map<String, String> map12 = s12.stream().collect(Collectors.toMap(v -> v, v -> "null"));
      System.out.println("对表字段初始化"+map12);
      List<TableRecordInfo> strTableRecordInfoSeq = result.getStrTableRecordInfoSeq();
    System.out.println(strTableRecordInfoSeq.size());
      Iterator<TableRecordInfo> iterator2 = result.getStrTableRecordInfoSeq().iterator();
      Map<String, List<String>> objectObjectHashMap = new HashMap<>();
    for (int i = 0; i < strTableRecordInfoSeq.size(); i++) {
        List<String> columnNames = strTableRecordInfoSeq.get(i).getColumnNames();
        String tableName = strTableRecordInfoSeq.get(i).getTableName();
        objectObjectHashMap.put(tableName,columnNames);
    }
    System.out.println("我是表对应的字段"+objectObjectHashMap);
   //   strTableRecordInfoSeq.parallelStream().map().collect(Collectors.toMap());
    //  Map<String, List<String>> objectObjectHashMap = new HashMap<>();
      //while (iterator2.hasNext()){
      //System.out.println("123");
         // String tableName = iterator2.next().getTableName();//表名 为key
           //List<String> columnNames = iterator2.next().getColumnNames();//表字段为 value
        //  objectObjectHashMap.put(tableName,columnNames);
      //}
   // System.out.println(objectObjectHashMap);
    //  Iterator<TableRecordInfo> iterator23 = strTableRecordInfoSeq.iterator();
   // System.out.println;
     // Map<String, List<String>> objectObjectHashMap = new HashMap<>();
    //  while (iterator23.hasNext()){
      // objectObjectHashMap.put(iterator2.next().getTableName(),iterator2.next().getColumnNames());
      // String tableName = iterator23.next().getTableName();//表名 为key
      /// List<String> columnNames = iterator23.next().getColumnNames();//表字段为 value
      // objectObjectHashMap.put(tableName,columnNames);
     // System.out.println("333");
      //}
    //System.out.println("表名k，字段v"+objectObjectHashMap);
      List<TableRecordValue> strTableRecordValueSeq = result.getStrTableRecordValueSeq();
    System.out.println("4=:"+strTableRecordValueSeq.size());
      Map<Object, String> hashMap2 = new HashMap<>();
    for (int i = 0; i <strTableRecordValueSeq.size(); i++) {
        //
        String tableName1 = strTableRecordValueSeq.get(i).getTableName();
       // TableRecordInfo tableRecordInfo = strTableRecordInfoSeq.get(i);
    //  System.out.println(tableRecordInfo);
    //  System.out.println(tableRecordInfo.getColumnNames());
        // System.out.println(tableName1);
       // List<String> stringList = objectObjectHashMap.get("tableA");
     // System.out.println(stringList);
        //  List<String> columnNames1 = strTableRecordInfoSeq.get(i).getColumnNames();
     // System.out.println(columnNames1.size()+":"+);
      if (objectObjectHashMap.containsKey(tableName1)){
          List<String> stringList = objectObjectHashMap.get(tableName1);
          //strTableRecordInfoSeq.get(i).getColumnNames();
        System.out.println(stringList);
      }

        //if (tableName1.equals(objectObjectHashMap.containsKey("tableA"))){
       // System.out.println("33333");
         //   List<String> stringList2 = objectObjectHashMap.get(tableName1);
           // System.out.println(columnNames1.size()+":"+stringList2.size());
      //  };
       /* if (tableName.equals(objectObjectHashMap.containsKey(tableName))){
            List<String> stringList = objectObjectHashMap.get(tableName);
            if (stringList.size()==columnValues.size()){
                for (int i = 0; i < columnValues.size(); i++) {
                    hashMap.put(columnValues.get(i),stringList.get(i));
                }
            }
        }*/

    }

    /*  Iterator<TableRecordValue> iterator1 = strTableRecordValueSeq.iterator();
    //System.out.println(iterator);
      Map<Object, String> hashMap = new HashMap<>();
      while (iterator1.hasNext()){
          String tableName = iterator1.next().getTableName();
          List<Object> columnValues = iterator1.next().getColumnValues();
      // strTableRecordInfoSeq.
      System.out.println("biao"+tableName);
          boolean equals = tableName.equals(objectObjectHashMap.containsKey(tableName));
      System.out.println("wosjjjjj:"+equals
      );

          if (tableName.equals(objectObjectHashMap.containsKey(tableName))){
              List<String> stringList = objectObjectHashMap.get(tableName);
              if (stringList.size()==columnValues.size()){
                    for (int i = 0; i < columnValues.size(); i++) {
                    hashMap.put(columnValues.get(i),stringList.get(i));
               }
              }
          }
         // System.out.println("222");
      }
    System.out.println("我对每一条数据合并"+hashMap);*/
      Set<TableRecordInfo> collect = tableRecordInfos.parallelStream().map(obj -> {
          TableRecordInfo t = new TableRecordInfo();
          BeanUtils.copyProperties(obj, t);
          t.setColumnNames(obj.getColumnNames());
          return t;
      }).collect(Collectors.toSet());
    System.out.println(collect);
    System.out.println("****************");

      /*Set<List<String>> collect1 = tableRecordInfos.parallelStream().map(obj -> {
          // TableRecordInfo t = new TableRecordInfo();
          //BeanUtils.copyProperties(obj, t);
          //t.setColumnNames(obj.getColumnNames());
          List<String> t = new ArrayList<>();
          t.add(obj.getColumnNames().toString());
          return t;
      }).collect(Collectors.toSet());
      System.out.println(collect1);*/
      Set<Set<String>> collect1 = tableRecordInfos.parallelStream().map(obj -> {
          TableRecordInfo t = new TableRecordInfo();
          BeanUtils.copyProperties(obj, t);
          t.setColumnNames(obj.getColumnNames());
          Set<String> t2 = new HashSet<>();
          Iterator<String> iterator = obj.getColumnNames().iterator();
          while (iterator.hasNext()) {
              t2.add(iterator.next());
          }
          //String next = iterator.next();
          // columnNames.forEach(columnNames.);
          // List<String> t = new ArrayList<>();
          //  t.add(obj.getColumnNames().toString());
          return t2;
      }).collect(Collectors.toSet());
      System.out.println(collect1);
      //
      Set<List<String>> collect2 = tableRecordInfos.parallelStream().map(obj -> {
          // TableRecordInfo t = new TableRecordInfo();
          //BeanUtils.copyProperties(obj, t);
          //t.setColumnNames(obj.getColumnNames());
          List<String> t = new ArrayList<>();
          t.addAll(obj.getColumnNames());
          return t;
      }).collect(Collectors.toSet());
    System.out.println(collect2);
      Set<String> setname = new HashSet<>();
      Iterator<List<String>> iterator = collect2.iterator();
      while (iterator.hasNext()){
          //List<String> next = iterator.next();
          setname.addAll(iterator.next());
      };
    System.out.println("我过滤le"+setname);
      //
      List<String> aa1= new ArrayList<>();
      aa1.add("A");
      aa1.add("B");
      aa1.add("C");
      aa1.add("D");
      List<String> aa11= new ArrayList<>();
      aa11.add("A");
      aa11.add("B");
      aa11.add("C");
      aa11.add("D");
      List<String> aa12= new ArrayList<>();
      aa12.add("A");
      aa12.add("B");
      aa12.add("C");
      aa12.add("D");
      List<String> aaa= new ArrayList<>();
      aaa.addAll(aa1);
      aaa.addAll(aa11);
      aaa.addAll(aa12);
    System.out.println(aaa);
    Set<String> objects = new HashSet<>();
    objects.addAll(aaa);
    System.out.println(objects);


    ///
      Set<String> t2 = new HashSet<>();
      tableRecordInfos.parallelStream().map(obj -> {
         // TableRecordInfo t = new TableRecordInfo();
        //  BeanUtils.copyProperties(obj, t);
       //   t.setColumnNames(obj.getColumnNames());
          List<String> ttt= new ArrayList<>();
         /* Iterator<String> iterator = obj.getColumnNames().iterator();
          while (iterator.hasNext()) {
              t2.add(iterator.next());
          }*/
          ttt.addAll(obj.getColumnNames());
          t2.addAll(ttt);

          //String next = iterator.next();
          // columnNames.forEach(columnNames.);
          // List<String> t = new ArrayList<>();
          //  t.add(obj.getColumnNames().toString());
          return ttt;
      }).collect(Collectors.toSet());
    System.out.println(t2);
      Map<String, String> map = t2.stream().collect(Collectors.toMap(v -> v, v -> "null"));
     System.out.println(map);
      Map<String, String> stringStringHashMap = new HashMap<>();
      stringStringHashMap.put("A","abd");
      stringStringHashMap.put("B","lili");
      map.putAll(stringStringHashMap);
      //
      Map<String, String> stringStringHashMap2 = new HashMap<>();
      stringStringHashMap2.put("C","abd");
      stringStringHashMap2.put("D","lili");

    //  map.putAll(stringStringHashMap2);
    System.out.println(map);
  }
}
