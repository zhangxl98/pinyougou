package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSeller;
import entity.PageResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/10/19 10:41 AM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商家服务层接口
 */
public interface SellerService {

    /**
     * 返回全部列表
     * <pre>createTime:
     * 5/10/19 2:45 PM</pre>
     *
     * @return
     */
    List<TbSeller> findAll();

    /**
     * 返回分页列表
     * <pre>createTime:
     * 5/10/19 2:48 PM</pre>
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加
     * <pre>createTime:
     * 5/10/19 12:43 PM</pre>
     *
     * @param seller
     */
    void add(TbSeller seller);
}
