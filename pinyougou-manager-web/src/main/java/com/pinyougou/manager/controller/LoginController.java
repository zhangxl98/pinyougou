package com.pinyougou.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/9/19 10:01 AM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 登录 Controller
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    
    @RequestMapping("/getName")
    public Map name() {
        Map map = new HashMap<>(16);

        // 获取当前登录的用户名
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        map.put("loginName",name);

        return map;
    }
}
