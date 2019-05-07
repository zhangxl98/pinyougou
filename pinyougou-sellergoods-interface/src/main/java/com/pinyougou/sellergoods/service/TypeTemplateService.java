package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import entity.PageResult;

import java.util.List;

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
}
