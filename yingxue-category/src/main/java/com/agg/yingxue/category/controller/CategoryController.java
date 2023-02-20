package com.agg.yingxue.category.controller;


import com.agg.yingxue.category.dto.CategoryInfo;
import com.agg.yingxue.category.entity.Category;
import com.agg.yingxue.category.service.ICategoryService;
import com.agg.yingxue.commons.api.annotation.ResultBody;
import com.agg.yingxue.commons.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 分类 前端控制器
 * </p>
 *
 * @author agg
 * @since 2023-02-20
 */
@RestController
@ResultBody
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("categories")
    public List<CategoryInfo> selectAll() {
        List<CategoryInfo> categoryInfos = categoryService.selectCategoriesWithChild();
        return categoryInfos;
    }

    @GetMapping("{id}")
    public Category selectCategoryById(@PathVariable("id") Integer id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public Category add(@RequestBody Category category) {
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        categoryService.save(category);
        return category;
    }

    @PatchMapping("{id}")
    public Category updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
        category.setId(id)
                .setUpdatedAt(LocalDateTime.now());
        categoryService.updateById(category);

        return categoryService.getById(id);
    }

    @DeleteMapping("{id}")
    public void removeCategory(@PathVariable("id") Integer id) {

        Category category = new Category().setId(id).setDeletedAt(LocalDateTime.now());
        categoryService.updateById(category);

    }
}

