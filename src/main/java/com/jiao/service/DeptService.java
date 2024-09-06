package com.jiao.service;

import com.jiao.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {


    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();


    /**
     * 删除部门信息
     */

    void delete(Integer id);

    /**
     * 新增部门信息
     */

    void add(Dept dept);


    /**
     * 查询被编辑的部门信息
     */
    Dept getById(Integer id);

    /**
     * 更改数据
     * @param dept
     */

    void update(Dept dept);


}
