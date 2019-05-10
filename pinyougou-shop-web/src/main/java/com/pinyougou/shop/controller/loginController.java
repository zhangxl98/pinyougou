package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/10/19 7:04 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 登录 Controller
 */
@RestController
@RequestMapping("/login")
public class loginController {

    /**
     * 获取登录的用户名
     * <pre>createTime:
     * 5/10/19 7:07 PM</pre>
     *
     * @return
     */
    @RequestMapping("/getName")
    public Map getName() {
        Map map = new HashMap<>();

        // 获取当前用户名
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        map.put("loginName",name);

        return map;
    }
}
