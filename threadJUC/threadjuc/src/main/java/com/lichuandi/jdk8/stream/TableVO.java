package com.lichuandi.jdk8.stream;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Auther digege
 * @Date 2021/6/28
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
@Data
public class TableVO {
    @Excel(name = "columnA", width = 5)
    private String columnA;
    @Excel(name = "columnB", width = 5)
    private String columnB;
    @Excel(name = "columnC", width = 5)
    private String columnC;
    @Excel(name = "columnD", width = 5)
    private String columnD;
}
