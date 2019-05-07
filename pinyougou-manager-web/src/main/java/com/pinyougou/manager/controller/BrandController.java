package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 4/29/19 4:48 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 品牌 Controller
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 返回全部列表
     * <pre>createTime:
     * 4/29/19 3:55 PM</pre>
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    /**
     * 返回分页列表
     * <pre>createTime:
     * 4/30/19 11:47 AM</pre>
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return brandService.findPage(page, rows);
    }

    /**
     * 增加品牌
     * <pre>createTime:
     * 5/5/19 10:13 AM</pre>
     *
     * @param brand
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand) {
        try {
            brandService.add(brand);
            // 增加成功
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 增加失败
            return new Result(false, "增加失败");
        }
    }

    /**
     * 根据 id 获取实体类
     * <pre>createTime:
     * 5/5/19 11:09 AM</pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    /**
     * 修改品牌
     * <pre>createTime:
     * 5/5/19 11:20 AM</pre>
     *
     * @param brand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand) {
        try {
            brandService.update(brand);
            // 修改成功
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 修改失败
            return new Result(false, "修改失败");
        }
    }

    /**
     * 批量删除品牌
     * <pre>createTime:
     * 5/5/19 12:36 PM</pre>
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(long[] ids) {
        try {
            brandService.delete(ids);
            // 删除成功
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 删除失败
            return new Result(false, "删除失败");
        }
    }

    /**
     * 按条件搜索并分页
     * <pre>createTime:
     * 5/6/19 10:22 AM</pre>
     *
     * @param brand
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand, int page, int rows) {
        return brandService.findPage(brand, page, rows);
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList() {
        return brandService.selectOptionList();
    }
}
