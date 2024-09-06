package com.jiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiao.mapper.EmpMapper;
import com.jiao.pojo.Emp;
import com.jiao.pojo.PageBean;
import com.jiao.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;


    @Override
    public PageBean page(Integer page, Integer pageSize,
                         String name, Short gender, LocalDate begin, LocalDate end) {
        //获取总记录数
        //Long  count = empMapper.count();
        //获取每页记录
        //先获取每页开始数


        //设置分页查询
        PageHelper.startPage(page, pageSize);
        //执行分页查询
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        //获取分页结果
        Page<Emp> p =(Page<Emp>)empList;
        return new PageBean(p.getTotal(),p.getResult());

    }


    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);


    }

    @Override
    public void add(Emp emp) {

        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

    }

    @Override
    public Emp getById(Integer id) {


        return empMapper.getById(id);
    }



    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);

    }

    @Override
    public Emp login(Emp emp) {

        return empMapper.login(emp);
    }

}
