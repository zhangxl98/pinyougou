package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/13/19 9:50 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 类型模板控制层
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 根据 id 获取实体
     * <pre>createTime:
     * 5/13/19 9:57 PM</pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Long id) {
        return typeTemplateService.findOne(id);
    }

    /**
     * 返回规格列表
     * <pre>createTime:
     * 5/14/19 6:37 PM</pre>
     *
     * @param id 模板 id
     * @return
     */
    @RequestMapping("/findSpecList")
    public List<Map> findSpecList(Long id) {
        return typeTemplateService.findSpecList(id);
    }

}
