package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.sellergoods.service.ItemCatService;
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
 * @Date 5/10/19 9:04 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商品分类 Controller
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    /**
     * 返回全部列表
     * <pre>createTime:
     * 5/10/19 9:07 PM</pre>
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbItemCat> findAll() {
        return itemCatService.findAll();
    }

    /**
     * 返回分页列表
     * <pre>createTime:
     * 5/10/19 9:08 PM</pre>
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return itemCatService.findPage(page, rows);
    }

    /**
     * 根据 id 获取实体
     * <pre>createTime:
     * 5/10/19 9:26 PM</pre>
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
     * 5/10/19 9:51 PM</pre>
     *
     * @param parentId
     * @return
     */
    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Long parentId) {
        return itemCatService.findByParentId(parentId);
    }

    /**
     * 增加
     * <pre>createTime:
     * 5/11/19 10:00 AM</pre>
     *
     * @param itemCat
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbItemCat itemCat) {
        try {
            itemCatService.add(itemCat);
            // 增加成功
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 增加失败
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * <pre>createTime:
     * 5/11/19 10:02 AM</pre>
     *
     * @param itemCat
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbItemCat itemCat) {
        try {
            itemCatService.update(itemCat);
            // 修改成功
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 修改失败
            return new Result(false, "修改失败");
        }
    }

    /**
     * 批量删除
     * <pre>createTime:
     * 5/11/19 10:44 AM</pre>
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            itemCatService.delete(ids);
            // 删除成功
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 删除失败
            return new Result(false, "删除失败");
        }
    }
}
