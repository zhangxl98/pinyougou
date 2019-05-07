package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;
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
 * @Date 5/7/19 12:45 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 规格 Controller
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    /**
     * 返回全部列表
     * <pre>createTime:
     * 5/7/19 12:47 PM</pre>
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbSpecification> findAll() {
        return specificationService.findAll();
    }

    /**
     * 返回分页列表
     * <pre>createTime:
     * 5/7/19 12:48 PM</pre>
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return specificationService.findPage(page, rows);
    }

    /**
     * 增加规格
     * <pre>createTime:
     * 5/7/19 4:43 PM</pre>
     *
     * @param specification
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Specification specification) {
        try {
            specificationService.add(specification);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改规格
     * <pre>createTime:
     * 5/7/19 5:18 PM</pre>
     *
     * @param specification
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Specification specification) {
        try {
            specificationService.update(specification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 根据 id 获取规格详情
     * <pre>createTime:
     * 5/7/19 5:10 PM</pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public Specification findOne(Long id) {
        return specificationService.findOne(id);
    }

    /**
     * 批量删除规格
     * <pre>createTime:
     * 5/7/19 5:37 PM</pre>
     *
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            specificationService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
