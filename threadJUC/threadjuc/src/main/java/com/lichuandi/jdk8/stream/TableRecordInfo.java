package com.lichuandi.jdk8.stream;

import lombok.Data;

import java.util.List;

/**
 * @Auther digege
 * @Date 2021/6/25
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
@Data
public class TableRecordInfo {
    private String tableName;
    private List<String> columnNames;
    private Object siInfo;
}
