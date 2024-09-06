package com.jiao.controller;


import com.jiao.pojo.Emp;
import com.jiao.pojo.Result;
import com.jiao.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    //传JSON格式的数据一定要记得加上@RequestBody注解
    public Result login(@RequestBody Emp emp) {
        log.info("验证员工的信息{}",emp);
        Emp e = empService.login(emp);
        return e!=null?Result.success():Result.error("账号或密码错误");
    }

}
