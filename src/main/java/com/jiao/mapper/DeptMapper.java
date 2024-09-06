package com.jiao.mapper;

import com.jiao.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询被编辑的部门信息
     *
     * @param id
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 查询全部部门数据
     */
    @Select("select * from dept")
//操作数据库，将得到的数据封装到集合中
    List<Dept> list();


    /**
     * 删除部门信息
     */
    @Delete("delete from dept where id = #{id}")
//
    void deleteById(Integer id);


    /**
     * 添加部门信息
     *
     * @param dept
     */
    @Insert("insert into dept (name,create_time,update_time) values (#{name},#{createTime},#{updateTime});")
    void insert(Dept dept);


    /**
     * 修改部门信息
     * @param dept
     */
    @Update("update dept set name = #{name} where id=#{id}")
    void update(Dept dept);


}
