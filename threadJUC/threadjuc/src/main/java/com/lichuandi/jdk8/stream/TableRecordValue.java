package com.lichuandi.jdk8.stream;

import lombok.Data;

import java.util.List;

/**
 * @Auther digege
 * @Date 2021/6/26
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
@Data
public class TableRecordValue {
    private String tableName;
    private String reportTimeStamp;
    private List<Object> columnValues;
}
