package com.jiao.mapper;

import com.jiao.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询员工总记录数
     */
    //@Select("select count(*) from emp")
    //Long count();


    /**
     * 查询分页记录
     */
    //@Select("select * from emp limit #{start},#{pageSize}")
    //List<Emp> page(@Param("start")Integer start, @Param("pageSize")Integer pageSize);


    /**
     * 使用xml方式
     */
    List<Emp> list(@Param("name") String name,@Param("gender") Short gender,
                   @Param("begin") LocalDate begin,@Param("end") LocalDate end);



    void delete(@Param("ids") List<Integer> ids);


    void insert(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp getById(@Param("id") Integer id);



    void update( Emp emp);


    //验证登录信息
    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp login( Emp emp);


}
