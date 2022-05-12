package com.lichuandi.jdk8.stream;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
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
public class Tabletet {
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
        objects1.add("null");
        objects1.add("chenhu");
        tableRecordValue.setTableName("tableA");
        tableRecordValue.setReportTimeStamp("shijian");
        tableRecordValue.setColumnValues(objects1);

        TableRecordValue tableRecordValue1 = new TableRecordValue();
        List<Object> objects2 = new ArrayList<>();
        objects2.add("2021-06-25 09:31:11.192");
        objects2.add("null");
        objects2.add("null");
        objects2.add("lili");
        tableRecordValue1.setTableName("tableB");
        tableRecordValue1.setReportTimeStamp("shijian1");
        tableRecordValue1.setColumnValues(objects2);

        TableRecordValue tableRecordValue2 = new TableRecordValue();
        List<Object> objects3 = new ArrayList<>();
        objects3.add("2021-06-25 09:31:11.192");
        objects3.add("digege");
        objects3.add("null");
        objects3.add("gogog");
        tableRecordValue2.setTableName("tableC");
        tableRecordValue2.setReportTimeStamp("shijian2");
        tableRecordValue2.setColumnValues(objects3);

        TableRecordValue tableRecordValue3 = new TableRecordValue();
        List<Object> objects4 = new ArrayList<>();
        objects4.add("22");
        objects4.add("OHLOTOPE");
        objects4.add("null");
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
        Map<Object, String> map12 = s12.stream().collect(Collectors.toMap(v -> v, v -> "null"));
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
      /*  while (iterator2.hasNext()){
            List<String> columnNames = iterator2.next().getColumnNames();
            iterator2.next().getTableName();
            objectObjectHashMap.put(tableName,columnNames);
        }*/

        System.out.println("我是表对应的字段"+objectObjectHashMap);

        List<TableRecordValue> strTableRecordValueSeq = result.getStrTableRecordValueSeq();
        System.out.println("对每一条数据赋值"+strTableRecordValueSeq.size());
      //  List<Map<Object ,String>> listMap = new ArrayList<>();
       List<Map<String ,Object>> listMap = new ArrayList<>();
        //Set<Map<String ,Object>> listMap = new HashSet<>();

        for (int i = 0; i <strTableRecordValueSeq.size(); i++) {
            //
            //Map<Object, String> mapss = s12.stream().collect(Collectors.toMap(v -> v, v -> "null"));
            Map<String, Object> mapss = s12.stream().collect(Collectors.toMap(v -> v, v -> "null"));
            String tableName1 = strTableRecordValueSeq.get(i).getTableName();
            List<Object> columnValues = strTableRecordValueSeq.get(i).getColumnValues();
            System.out.println("sssssss"+columnValues.toString());
      //for (int m = 0; m < columnValues.size(); m++) {
        //
       //   columnValues.get(m)
                /*  if ( columnValues.get(m) == null|| columnValues.get(m)=="") {
                    //  columnValues.get(m)."null";
                      columnValues.add("null");
                  }*/
      //}
            //TableRecordInfo tableRecordInfo = strTableRecordInfoSeq.get(i);
            //System.out.println(tableRecordInfo);
            if (objectObjectHashMap.containsKey(tableName1)){
                //获取表对应的字段
                List<String> stringList = objectObjectHashMap.get(tableName1);
               // Map<Object,String > hashMap2 = new HashMap<>();
                Map<String, Object> hashMap2 = new HashMap<>();
                for (int j = 0; j < stringList.size(); j++){
                    if (columnValues.size()== stringList.size()){
                        Object o = columnValues.get(j);
                        /*if ("".equals(o)&&o.equals(null)){
                            o="null";
                        }*/
                        hashMap2.put(stringList.get(j),o.toString());
                        //
                        mapss.putAll(hashMap2);
                        // listMap.add(hashMap2);

                    }

                //columnValues.toString()

                 }
                listMap.add(mapss);
                System.out.println(stringList);
            }



        }
    //    System.out.println(hashMap2);
    System.out.println("最终的数据："+listMap);
        //HttpServletResponse httpServletResponse = new HttpServletResponse();
        ExportParams entity = new ExportParams();
        entity.setType(ExcelType.XSSF);
        entity.setTitle("最终的数据");
    /*    Iterator var3 = listMap.iterator();
        Map<String, List<Map<String, Object>>> objectObjectHashMap1 = new HashMap<>();
        objectObjectHashMap1.put("data",listMap);
        objectObjectHashMap1.put("title", (List<Map<String, Object>>) entity);
        objectObjectHashMap1.put("entity", (List<Map<String, Object>>) entity);*/

      //  List<String> data = objectObjectHashMap.put("data", listMap);
       // objectObjectHashMap.put("title", (List<String>) entity);
      /*  while(var3.hasNext()) {
            Map<String, Object> map = (Map)var3.next();
            ExcelExportService service = new ExcelExportService();

           // service.createSheet(workbook, (ExportParams)map.get("title"), (Class)map.get("entity"), (Collection)map.get("data"));
        }*/
        List<Map<String, Object>> list =new ArrayList<>();
       Map<String, Object> hashMap = new HashMap();
       hashMap.put("title","usemae");
       hashMap.put("entity",entity);
       hashMap.put("data",listMap);
       list.add(hashMap);


        //  list.add()
      //  listMap.
      //Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.XSSF);
        //Workbook workbook = ExcelExportUtil.exportExcel(entity, EquipmentHistoryExportVO.class, listMapData);
       // List<Map<Object, String>> listMap1 = listMap;
        List<Map<String, Object>> maps = new ArrayList<>();


        //maps=(List<Map<String, Object>>)listMapData;
       // Workbook workbook = ExcelExportUtil.exportExcel(listMap, ExcelType.XSSF);

        Set<TableRecordInfo> collect = tableRecordInfos.parallelStream().map(obj -> {
      ;      TableRecordInfo t = new TableRecordInfo();
            BeanUtils.copyProperties(obj, t);
            t.setColumnNames(obj.getColumnNames());
            return t;
        }).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println("****************");

    }
}
