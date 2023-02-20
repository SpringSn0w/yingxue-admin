package com.agg.yingxue.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 分类
 * </p>
 *
 * @author agg
 * @since 2023-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父级分类id
     */
    private Integer parentId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


}
