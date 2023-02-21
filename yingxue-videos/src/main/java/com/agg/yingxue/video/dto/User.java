package com.agg.yingxue.video.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author agg
 * @since 2023-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 头像链接
     */
    private String avatar;

    /**
     * 简介
     */
    private String intro;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否绑定手机号
     */
    @JsonProperty("phone_linked")
    private Boolean phoneLinked;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 是否绑定微信
     */
    @JsonProperty("wechat_linked")
    private Boolean wechatLinked;

    /**
     * 关注数
     */
    private Integer followingCount;

    /**
     * 粉丝数
     */
    private Integer followersCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


}
