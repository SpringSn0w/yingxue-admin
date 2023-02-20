package com.agg.yingxue.generator.service.impl;

import com.agg.yingxue.generator.entity.Category;
import com.agg.yingxue.generator.dao.CategoryMapper;
import com.agg.yingxue.generator.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类 服务实现类
 * </p>
 *
 * @author agg
 * @since 2023-02-20
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
