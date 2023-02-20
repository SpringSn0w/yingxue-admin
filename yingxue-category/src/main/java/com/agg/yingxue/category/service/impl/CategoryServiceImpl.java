package com.agg.yingxue.category.service.impl;

import com.agg.yingxue.category.dto.CategoryInfo;
import com.agg.yingxue.category.service.ICategoryService;
import com.agg.yingxue.category.entity.Category;
import com.agg.yingxue.category.dao.CategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 分类 服务实现类
 * </p>
 *
 * @author agg
 * @since 2023-02-20
 */
@Service
@Primary
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public List<CategoryInfo> selectCategoriesWithChild() {
        return categoryMapper.selectCategoriesWithChild();
    }
}
