package com.agg.yingxue.category.dto;

import com.agg.yingxue.category.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryInfo extends Category {
/**
 *孩子属性,有多个孩子
 */
    private List<Category> children;
}
