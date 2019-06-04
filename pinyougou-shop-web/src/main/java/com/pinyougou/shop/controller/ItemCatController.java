package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.sellergoods.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/13/19 7:31 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商品分类控制层
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    /**
     * 返回全部列表
     * <pre>createTime:
     * 6/4/19 9:32 AM</pre>
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbItemCat> findAll() {
        return itemCatService.findAll();
    }

    /**
     * 根据 id 获取实体
     * <pre>createTime:
     * 5/13/19 9:32 PM</pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbItemCat fendOne(Long id) {
        return itemCatService.findOne(id);
    }

    /**
     * 根据上级 id 查询下级列表
     * <pre>createTime:
     * 5/13/19 8:48 PM</pre>
     *
     * @param parentId
     * @return
     */
    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Long parentId) {
        return itemCatService.findByParentId(parentId);
    }
}
