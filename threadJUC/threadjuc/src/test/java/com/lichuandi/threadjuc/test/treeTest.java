package com.lichuandi.threadjuc.test;

import com.alibaba.fastjson.JSON;
import com.lichuandi.jdk8.stream.MenuTree;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author digege
 * @date 2021/11/3 15:14
 * @description：TODO
 * @page com.lichuandi.threadjuc.test
 * version：1
 */
@SpringBootTest
public class treeTest {
    @Test
    public void testtree(){
        //模拟从数据库查询出来
        List<MenuTree> menus = Arrays.asList(
                new MenuTree(1,"根节点",0),
                new MenuTree(2,"子节点1",1),
                new MenuTree(3,"子节点1.1",2),
                new MenuTree(4,"子节点1.2",2),
                new MenuTree(5,"根节点1.3",2),
                new MenuTree(6,"根节点2",1),
                new MenuTree(7,"根节点2.1",6),
                new MenuTree(8,"根节点2.2",6),
                new MenuTree(9,"根节点2.2.1",7),
                new MenuTree(10,"根节点2.2.2",7),
                new MenuTree(11,"根节点3",1),
                new MenuTree(12,"根节点3.1",11)
        );

        //获取父节点
        List<MenuTree> collect = menus.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildList(getChildrens(m, menus));
                    return m;
                }
        ).collect(Collectors.toList());
        System.out.println("-------转json输出结果-------");
        System.out.println(JSON.toJSON(collect));
    }

    /**
     * 递归查询子节点
     * @param root  根节点
     * @param all   所有节点
     * @return 根节点信息
     */
    private List<MenuTree> getChildrens(MenuTree root, List<MenuTree> all) {
        List<MenuTree> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getId());
        }).map(
                (m) -> {
                    m.setChildList(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }
}
