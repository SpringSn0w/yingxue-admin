package com.agg.yingxue.category.service;

import com.agg.yingxue.category.dto.CategoryInfo;
import com.agg.yingxue.category.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分类 服务类
 * </p>
 *
 * @author agg
 * @since 2023-02-20
 */
public interface ICategoryService extends IService<Category> {

    List<CategoryInfo> selectCategoriesWithChild();
}
