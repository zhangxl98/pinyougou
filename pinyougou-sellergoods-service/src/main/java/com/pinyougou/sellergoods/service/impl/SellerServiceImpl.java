package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbSellerMapper;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/10/19 12:44 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商家服务层实现类
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private TbSellerMapper sellerMapper;

    @Override
    public void add(TbSeller seller) {
        // 审核状态
        seller.setStatus("0");
        // 申请时间
        seller.setCreateTime(new Date());

        sellerMapper.insert(seller);
    }
}
