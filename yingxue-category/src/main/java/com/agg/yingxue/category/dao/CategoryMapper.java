package com.agg.yingxue.category.dao;

import com.agg.yingxue.category.dto.CategoryInfo;
import com.agg.yingxue.category.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface CategoryMapper extends BaseMapper<Category> {
    List<CategoryInfo> selectCategoriesWithChild();
}