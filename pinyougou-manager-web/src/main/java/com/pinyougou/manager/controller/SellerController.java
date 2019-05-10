package com.pinyougou.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/10/19 12:53 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商家 Controller
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;

    /**
     * 返回全部列表
     * <pre>createTime:
     * 5/10/19 2:46 PM</pre>
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbSeller> findAll() {
        return sellerService.findAll();
    }

    /**
     * 返回分页列表
     * <pre>createTime:
     * 5/10/19 2:54 PM</pre>
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return sellerService.findPage(page, rows);
    }

    /**
     * 根据 id 获取实体
     * <pre>createTime:
     * 5/10/19 3:17 PM</pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbSeller findOne(String id) {
        return sellerService.findOne(id);
    }
}
