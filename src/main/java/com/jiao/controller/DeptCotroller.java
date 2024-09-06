package com.jiao.controller;


import com.jiao.mapper.DeptMapper;
import com.jiao.pojo.Dept;
import com.jiao.pojo.Result;
import com.jiao.service.DeptService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller    将该类交给IOC管理 ...
//@ResponseBody  直接将返回的数据result转成JSON格式 ...
//@RestController = @Controller + @ResponseBody
@RestController
@Slf4j//添加日志注解，下面可以直接使用log
@RequestMapping("/depts")
public class DeptCotroller {
    /**
     * 前端发送请求到Conctroller方法，Controller方法中调用Service方法获取数据，
     * 在Service当中调用了mapper接口中的方法来查询全部的部门信息，
     * Mapper接口向数据库发送sql语句，并且把查询的信息封装在list集合中并且返回给Service，
     * Service又返回给了Controller，Controller拿到信息后再返回给前端
     */

    @Autowired
    private DeptService deptService;//注入了一个实现了DeptService接口的Bean对象


    /**
     * 查询部门信息
     *
     * @return
     */

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求类型只能是GET
    @GetMapping
    //@PostMapping
    public Result list() {
        log.info("查询部门全部日志");//输出日志

        List<Dept> deptList = deptService.list();//获取了从DeptService返回D的数据并放入集合中

        return Result.success(deptList);//将集合转换成JSON格式并返回给前端
    }


    /**
     * 删除部门
     */
    @DeleteMapping("/{id}")
    //请求路径参数
    public Result list(@PathVariable Integer id) {

        log.info("删除部门{}", id);
        deptService.delete(id);
        return Result.success();

    }

    /**
     * 新增部门
     */

    @PostMapping
    //传进来一个JSON格式的数据
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门:{}", dept);
        deptService.add(dept);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result listById(@PathVariable Integer id) {
        log.info("先查询要编辑的部门id{}", id);
        Dept dept= deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);

        return Result.success();
    }

}
