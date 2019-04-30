package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

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

}
