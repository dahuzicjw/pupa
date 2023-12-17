package com.cjw.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjw.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public String get() {
        PageHelper.startPage(1, 2);
        return JSON.toJSONString(userMapper.selectList(new QueryWrapper()));
    }
}
