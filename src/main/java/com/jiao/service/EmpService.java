package com.jiao.service;

import com.jiao.pojo.Emp;
import com.jiao.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {



    //封装PageBean
   PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    //删除员工信息
    void delete(List<Integer> ids);



    //添加员工信息
    void add(Emp emp);



    //根据id查询员工用于回显
    Emp getById(Integer id);


    //用于修改员工信息
    void update(Emp emp);


    //用于验证登录信息
    Emp login(Emp emp);
}
