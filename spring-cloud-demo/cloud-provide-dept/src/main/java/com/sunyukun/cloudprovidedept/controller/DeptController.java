package com.sunyukun.cloudprovidedept.controller;

import com.sunyukun.cloudprovidedept.entity.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yukunsun@didiglobal.com
 * @time: 2021/8/22 15:28
 * @description:
 */
@RestController
public class DeptController {
    @RequestMapping(value = "dept/list")
    public String deptList() {
        Dept dept = new Dept();
        dept.setId(1L);
        dept.setName("hello");
        return dept.toString();
    }
}
