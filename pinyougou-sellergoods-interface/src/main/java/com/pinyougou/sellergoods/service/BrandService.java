package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 4/29/19 3:52 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 品牌服务层接口
 */
public interface BrandService {

    /**
     * 返回全部列表
     * <pre>createTime:
     * 4/29/19 3:55 PM</pre>
     *
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 返回分页列表
     * <pre>createTime:
     * 4/30/19 11:29 AM</pre>
     *
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 按条件返回分页列表
     * <pre>createTime:
     * 5/6/19 9:41 AM</pre>
     *
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(TbBrand brand, int pageNum, int pageSize);

    /**
     * 增加品牌
     * <pre>createTime:
     * 5/5/19 9:42 AM</pre>
     *
     * @param brand
     */
    void add(TbBrand brand);

    /**
     * 根据 id 获取单个实体类
     * <pre>createTime:
     * 5/5/19 11:06 AM</pre>
     *
     * @param id
     * @return
     */
    TbBrand findOne(Long id);

    /**
     * 更新品牌
     * <pre>createTime:
     * 5/5/19 11:15 AM</pre>
     *
     * @param brand
     */
    void update(TbBrand brand);

    /**
     * 批量删除品牌
     * <pre>createTime:
     * 5/5/19 12:33 PM</pre>
     *
     * @param ids
     */
    void delete(long[] ids);
}
