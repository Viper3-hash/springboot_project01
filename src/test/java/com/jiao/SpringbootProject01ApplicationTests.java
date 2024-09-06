package com.jiao;

import com.jiao.mapper.DeptMapper;
import com.jiao.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootProject01ApplicationTests {
    @Autowired
    private DeptMapper deptMapper;



    @Test
    public void testlist() {
    List<Dept> deptList = deptMapper.list();
    deptList.forEach(System.out::println);
    }
}
