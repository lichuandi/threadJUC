package com.lichuandi.jdk8.stream;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther digege
 * @Date 2021/6/28
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
public class TableVOTest {
  public static void main(String[] args) {
    //
      List<TableVO> list = new ArrayList<>();
      TableVO tableVO1 = new TableVO();
      tableVO1.setColumnA("lili");
      tableVO1.setColumnB("ddd");
      tableVO1.setColumnC("eerr");
      tableVO1.setColumnD("fggh");
      TableVO tableVO2 = new TableVO();
      tableVO2.setColumnA("gege");
      tableVO2.setColumnB("pppp");
      tableVO2.setColumnC("nmnmn");
      tableVO2.setColumnD("jjjjj");
      list.add(tableVO1);
      list.add(tableVO2);
      System.out.println("我是list数据"+list);
      ExportParams entity = new ExportParams();
      entity.setType(ExcelType.XSSF);
      entity.setTitle("表名");
      Workbook workbook = ExcelExportUtil.exportExcel(entity, TableVO.class, list);
  //    List<Map<String,Object>> objectMap = new HashMap<>();
      /**
       *  service.createSheet(workbook, (ExportParams) map.get("title"),
       *                 (Class<?>) map.get("entity"), (Collection<?>) map.get("data"));
       */

      List<Map<String,Object>> list1 = new ArrayList<>();
      Map<String, Object> hashMap = new HashMap<>();
      hashMap.put("title",entity);
      hashMap.put("entity",TableVO.class);
      hashMap.put("data",list);
      list1.add(hashMap);
      Workbook sheets = ExcelExportUtil.exportExcel(list1, ExcelType.XSSF);
    System.out.println(sheets);

      // ExcelExportUtil.exportExcel()
  }
}
