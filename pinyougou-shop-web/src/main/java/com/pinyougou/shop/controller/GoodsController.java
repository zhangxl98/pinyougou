package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojogroup.Goods;
import com.pinyougou.sellergoods.service.GoodsService;
import entity.PageResult;
import entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/12/19 8:55 AM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商品控制层
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference
    private GoodsService goodsService;

    /**
     * 增加
     * <pre>createTime:
     * 5/12/19 9:10 AM</pre>
     *
     * @param goods
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Goods goods) {

        // 获取当前商家用户名
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();

        // 设置商家 id
        goods.getGoods().setSellerId(sellerId);

        try {
            goodsService.add(goods);
            // 增加成功
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 增加失败
            return new Result(false, "增加失败");
        }
    }

    /**
     * 查询商家列表
     * <pre>createTime:
     * 5/18/19 10:48 PM</pre>
     *
     * @param goods
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbGoods goods, int page, int rows) {
        //获取商家ID
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        //添加查询条件
        goods.setSellerId(sellerId);
        return goodsService.findPage(goods, page, rows);
    }
}
