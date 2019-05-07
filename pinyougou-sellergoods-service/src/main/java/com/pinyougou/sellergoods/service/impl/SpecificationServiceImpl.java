package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/7/19 12:38 PM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 规格服务层接口实现类
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper specificationMapper;
    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    @Override
    public List<TbSpecification> findAll() {
        return specificationMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(Specification specification) {
        // 获取规格实体
        TbSpecification tbspecification = specification.getSpecification();
        specificationMapper.insert(tbspecification);

        // 获取规格选项集合
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for (TbSpecificationOption option : specificationOptionList) {
            // 设置规格 ID
            option.setSpecId(tbspecification.getId());
            // 新增规格
            specificationOptionMapper.insert(option);
        }
    }

    @Override
    public void update(Specification specification) {
        // 获取规格实体
        TbSpecification tbspecification = specification.getSpecification();
        specificationMapper.updateByPrimaryKey(tbspecification);

        // 删除原来的规格选项
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(tbspecification.getId());
        specificationOptionMapper.deleteByExample(example);

        // 获取规格选项集合
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for (TbSpecificationOption option : specificationOptionList) {
            // 设置规格 ID
            option.setSpecId(tbspecification.getId());
            // 新增规格
            specificationOptionMapper.insert(option);
        }
    }

    @Override
    public Specification findOne(Long id) {

        // 定义需要返回的规格组合实体
        Specification specification = new Specification();

        // 获取规格实体
        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);

        // 获取规格选项
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();

        // 根据规格 id 查询规格选项
        criteria.andSpecIdEqualTo(id);

        List<TbSpecificationOption> tbSpecificationOptions = specificationOptionMapper.selectByExample(tbSpecificationOptionExample);

        // 封装组合实体
        specification.setSpecification(tbSpecification);
        specification.setSpecificationOptionList(tbSpecificationOptions);

        return specification;
    }
}
