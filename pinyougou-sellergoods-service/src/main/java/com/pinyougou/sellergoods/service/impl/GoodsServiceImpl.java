package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.*;
import com.pinyougou.pojo.*;
import com.pinyougou.pojogroup.Goods;
import com.pinyougou.sellergoods.service.GoodsService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/12/19 8:50 AM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商品服务层实现类
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper goodsMapper;

    @Autowired
    private TbGoodsDescMapper goodsDescMapper;

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbBrandMapper brandMapper;

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Autowired
    private TbSellerMapper sellerMapper;

    @Override
    public void add(Goods goods) {

        // 设置为未审核状态
        goods.getGoods().setAuditStatus("0");
        goodsMapper.insert(goods.getGoods());

        // 设置商品扩展数据 id
        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
        goodsDescMapper.insert(goods.getGoodsDesc());

        if ("1".equals(goods.getGoods().getIsEnableSpec())) {
            // 启用规格

            for (TbItem item : goods.getItemList()) {

                // 构建标题  SPU名称+ 规格选项值
                // SPU 名称
                String title = goods.getGoods().getGoodsName();
                // 规格选项值
                Map<String, Object> specMap = JSON.parseObject(item.getSpec());
                // 拼接
                for (String key : specMap.keySet()) {
                    title += " " + specMap.get(key);
                }
                item.setTitle(title);


            }
            for (TbItem item : goods.getItemList()) {

                // 构建标题  SPU名称+ 规格选项值
                // SPU 名称
                String title = goods.getGoods().getGoodsName();
                // 规格选项值
                Map<String, Object> specMap = JSON.parseObject(item.getSpec());
                // 拼接
                for (String key : specMap.keySet()) {
                    title += " " + specMap.get(key);
                }
                item.setTitle(title);

                setItemValus(goods, item);

                itemMapper.insert(item);
            }
        } else {
            // 不启用规格

            TbItem item = new TbItem();

            //商品KPU+规格描述串作为SKU名称
            item.setTitle(goods.getGoods().getGoodsName());

            //价格
            item.setPrice(goods.getGoods().getPrice());

            //状态
            item.setStatus("1");

            //是否默认
            item.setIsDefault("1");

            //库存数量
            item.setNum(99999);

            item.setSpec("{}");

            setItemValus(goods, item);

            itemMapper.insert(item);
        }
    }

    private void setItemValus(Goods goods, TbItem item) {


        // 商品 SPU 编号
        item.setGoodsId(goods.getGoods().getId());

        // 商家编号
        item.setSellerId(goods.getGoods().getSellerId());

        // 商品分类编号 (3 级)
        item.setCategoryid(goods.getGoods().getCategory3Id());

        // 创建时间
        item.setCreateTime(new Date());

        // 更新时间
        item.setUpdateTime(new Date());


        // 品牌名称
        TbBrand brand = brandMapper.selectByPrimaryKey(goods.getGoods().getBrandId());
        item.setBrand(brand.getName());

        // 分类名称
        TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(goods.getGoods().getCategory3Id());
        item.setCategory(itemCat.getName());

        // 商家名称
        TbSeller seller = sellerMapper.selectByPrimaryKey(goods.getGoods().getSellerId());
        item.setSeller(seller.getNickName());

        // 图片地址（取 spu 的第一个图片）
        List<Map> imageList = JSON.parseArray(goods.getGoodsDesc().getItemImages(), Map.class);
        if (imageList.size() > 0) {
            item.setImage((String) imageList.get(0).get("url"));
        }
    }

    @Override
    public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbGoodsExample example = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = example.createCriteria();

        if (goods != null) {
            if (goods.getSellerId() != null && goods.getSellerId().length() > 0) {
                criteria.andSellerIdEqualTo(goods.getSellerId());
            }
            if (goods.getGoodsName() != null && goods.getGoodsName().length() > 0) {
                criteria.andGoodsNameLike("%" + goods.getGoodsName() + "%");
            }
            if (goods.getAuditStatus() != null && goods.getAuditStatus().length() > 0) {
                criteria.andAuditStatusLike("%" + goods.getAuditStatus() + "%");
            }
            if (goods.getIsMarketable() != null && goods.getIsMarketable().length() > 0) {
                criteria.andIsMarketableLike("%" + goods.getIsMarketable() + "%");
            }
            if (goods.getCaption() != null && goods.getCaption().length() > 0) {
                criteria.andCaptionLike("%" + goods.getCaption() + "%");
            }
            if (goods.getSmallPic() != null && goods.getSmallPic().length() > 0) {
                criteria.andSmallPicLike("%" + goods.getSmallPic() + "%");
            }
            if (goods.getIsEnableSpec() != null && goods.getIsEnableSpec().length() > 0) {
                criteria.andIsEnableSpecLike("%" + goods.getIsEnableSpec() + "%");
            }
            if (goods.getIsDelete() != null && goods.getIsDelete().length() > 0) {
                criteria.andIsDeleteLike("%" + goods.getIsDelete() + "%");
            }

        }

        Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
