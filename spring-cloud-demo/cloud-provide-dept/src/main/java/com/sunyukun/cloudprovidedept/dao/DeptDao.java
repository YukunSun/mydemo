package com.sunyukun.cloudprovidedept.dao;

import com.sunyukun.cloudprovidedept.entity.Dept;

import java.util.List;

/**
 * @author: yukunsun@didiglobal.com
 * @time: 2021/8/20 09:27
 * @description:
 */
public class DeptDao {
    public Dept getDeptById(Long id) {
        Dept dept = new Dept();
        dept.setId(1L);
        dept.setName("金融");
        return dept;
    }
}
