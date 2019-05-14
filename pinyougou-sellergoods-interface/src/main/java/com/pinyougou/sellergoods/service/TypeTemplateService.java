package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/7/19 6:57 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 类型模板服务层接口
 */
public interface TypeTemplateService {

    /**
     * 返回全部列表
     * <pre>createTime:
     * 5/7/19 6:58 PM</pre>
     *
     * @return
     */
    List<TbTypeTemplate> findAll();

    /**
     * 返回分页列表
     * <pre>createTime:
     * 5/7/19 6:59 PM</pre>
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加模板
     * <pre>createTime:
     * 5/8/19 9:49 AM</pre>
     *
     * @param tbTypeTemplate
     */
    void add(TbTypeTemplate tbTypeTemplate);

    /**
     * 修改模板
     * <pre>createTime:
     * 5/8/19 9:50 AM</pre>
     *
     * @param tbTypeTemplate
     */
    void update(TbTypeTemplate tbTypeTemplate);

    /**
     * 根据 id 获取实体
     * <pre>createTime:
     * 5/8/19 9:24 AM</pre>
     *
     * @param id
     * @return
     */
    TbTypeTemplate findOne(Long id);

    /**
     * 批量删除
     * <pre>createTime:
     * 5/8/19 10:12 AM</pre>
     *
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 返回规格列表
     * <pre>createTime:
     * 5/14/19 5:30 PM</pre>
     *
     * @param id 模板 id
     * @return 规格列表
     */
    List<Map> findSpecList(Long id);
}
