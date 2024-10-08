package com.jiao.service.impl;

import com.jiao.mapper.DeptMapper;
import com.jiao.pojo.Dept;
import com.jiao.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired  
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);

    }

    @Override
    public void add(Dept dept) {
        //补全时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);

    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id) ;
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }


}
