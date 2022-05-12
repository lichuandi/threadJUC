package com.lichuandi.jdk8.stream;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Auther digege
 * @Date 2021/6/26
 * @Description：
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
@Data
public  class HistoryInformationInqResult{
    private List<TableRecordInfo> strTableRecordInfoSeq;
    private List<TableRecordValue> strTableRecordValueSeq;
   // private Page<List<Infos.TableRecordValue>> strTableRecordValuePage;
    private Object  siInfo;
}