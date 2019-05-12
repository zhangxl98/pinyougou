package com.pinyougou.sellergoods.service;

import com.pinyougou.pojogroup.Goods;

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
}
