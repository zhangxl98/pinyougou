package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
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
 * @Date 5/7/19 7:03 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 类型模板 Controller
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 返回全部列表
     * <pre>createTime:
     * 5/7/19 7:14 PM</pre>
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbTypeTemplate> findAll() {
        return typeTemplateService.findAll();
    }

    /**
     * 返回分页列表
     * <pre>createTime:
     * 5/7/19 7:15 PM</pre>
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return typeTemplateService.findPage(page, rows);
    }

    /**
     * 增加模板
     * <pre>createTime:
     * 5/8/19 9:54 AM</pre>
     *
     * @param tbTypeTemplate
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate tbTypeTemplate) {
        try {
            typeTemplateService.add(tbTypeTemplate);
            // 增加成功
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 增加失败
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改模板
     * <pre>createTime:
     * 5/8/19 9:55 AM</pre>
     *
     * @param tbTypeTemplate
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbTypeTemplate tbTypeTemplate) {
        try {
            typeTemplateService.update(tbTypeTemplate);
            // 修改成功
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 修改失败
            return new Result(false, "修改失败");
        }
    }


    /**
     * 根据 id 获取实体
     * <pre>createTime:
     * 5/8/19 9:27 AM</pre>
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Long id) {
        return typeTemplateService.findOne(id);
    }
}
