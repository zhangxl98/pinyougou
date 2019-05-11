package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbItemCat;
import entity.PageResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/10/19 8:16 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商品分类服务层接口
 */
public interface ItemCatService {

    /**
     * 返回全部列表
     * <pre>createTime:
     * 5/10/19 8:19 PM</pre>
     *
     * @return
     */
    List<TbItemCat> findAll();

    /**
     * 返回分页列表
     * <pre>createTime:
     * 5/10/19 8:19 PM</pre>
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 根据 id 获取实体
     * <pre>createTime:
     * 5/10/19 9:19 PM</pre>
     *
     * @param id
     * @return
     */
    TbItemCat findOne(Long id);

    /**
     * 增加
     * <pre>createTime:
     * 5/11/19 9:56 AM</pre>
     *
     * @param itemCat
     */
    void add(TbItemCat itemCat);

    /**
     * 修改
     * <pre>createTime:
     * 5/11/19 9:57 AM</pre>
     *
     * @param itemCat
     */
    void update(TbItemCat itemCat);

    /**
     * 根据上级 id 返回列表
     * <pre>createTime:
     * 5/10/19 9:43 PM</pre>
     *
     * @param parentId
     * @return
     */
    List<TbItemCat> findByParentId(Long parentId);
}
