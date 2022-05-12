package com.lichuandi.jdk8.stream;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author digege
 * @date 2021/11/3 15:04
 * @description：TODO
 * @page com.lichuandi.jdk8.stream
 * version：1
 */
@Data
@Builder
public class MenuTree {
    /**
     * id
     */
    public Integer id;
    /**
     * 名称
     */
    public String name;
    /**
     * 父id ，根节点为0
     */
    public Integer parentId;
    /**
     * 子节点信息
     */
    public List<MenuTree> childList;


    public MenuTree(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public MenuTree(Integer id, String name, Integer parentId, List<MenuTree> childList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
    }

}
