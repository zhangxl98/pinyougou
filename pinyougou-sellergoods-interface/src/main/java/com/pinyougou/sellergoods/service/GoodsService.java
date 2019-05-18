package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojogroup.Goods;
import entity.PageResult;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/12/19 8:49 AM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商品服务层接口
 */
public interface GoodsService {


    /**
     * 增加
     * <pre>createTime:
     * 5/12/19 8:50 AM</pre>
     *
     * @param goods 商品组合
     */
    void add(Goods goods);

    /**
     * 根据搜索条件，返回分页数据
     * <pre>createTime:
     * 5/18/19 10:55 PM</pre>
     *
     * @param goods
     * @param pageNum  当前页码
     * @param pageSize 每条记录数
     * @return
     */
    PageResult findPage(TbGoods goods, int pageNum, int pageSize);
}
