package com.jiao.controller;

import com.jiao.pojo.Emp;
import com.jiao.pojo.PageBean;
import com.jiao.pojo.Result;
import com.jiao.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
        log.info("传递的参数为{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        //调用Service方法获取结果
        PageBean pageBean = empService.page(page, pageSize,name,gender,begin,end);

        return Result.success(pageBean);
    }

    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除编号{}",ids);

        empService.delete(ids);
        return Result.success();
    }



    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp) {
        log.info("添加员工数据{}",emp);
        empService.add(emp);

    return Result.success();
    }


    @GetMapping("/emps/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        log.info("回显员工id：{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }


    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工为：{}" ,emp);
        empService.update(emp);

        return Result.success();
    }


}
