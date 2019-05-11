package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbItemCatExample;
import com.pinyougou.sellergoods.service.ItemCatService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/10/19 8:20 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 商品分类服务层实现类
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TbItemCat> findAll() {
        return itemCatMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbItemCat> page = (Page<TbItemCat>) itemCatMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public TbItemCat findOne(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(TbItemCat itemCat) {
        itemCatMapper.insert(itemCat);
    }

    @Override
    public void update(TbItemCat itemCat) {
        itemCatMapper.updateByPrimaryKey(itemCat);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {

            // 删除所有下级分类
            deleteSon(id);

            // 删除当前分类
            itemCatMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<TbItemCat> findByParentId(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return itemCatMapper.selectByExample(example);
    }

    /**
     * 递归删除所有子分类
     * <pre>createTime:
     * 5/11/19 3:09 PM</pre>
     *
     * @param parentId 上级分类 id
     */
    private void deleteSon(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        // parentId 为 上级分类 id 的分类为子分类
        criteria.andParentIdEqualTo(parentId);

        // 获取子分类
        List<TbItemCat> sonItemCats = itemCatMapper.selectByExample(example);
        // 判空
        if (null != sonItemCats && sonItemCats.size() > 0) {
            // 遍历子分类
            for (TbItemCat sonIemCat : sonItemCats) {
                // 获取子分类 id
                Long sonId = sonIemCat.getId();

                // 删除子分类
                itemCatMapper.deleteByPrimaryKey(sonId);

                // 递归
                deleteSon(sonId);
            }
        }
    }
}
