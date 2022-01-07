package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "t_comment")
@ApiModel(value = "一级评论实体")
public class TCommentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_msg", columnDefinition = "varchar(255) COMMENT ''")
    @ApiModelProperty(value = "")
    private String commentMsg;

    @Column(name = "create_time", columnDefinition = "datetime(6) COMMENT ''")
    @ApiModelProperty(value = "")
    private Timestamp createTime;

    @Column(name = "like_it", columnDefinition = "bigint COMMENT ''")
    @ApiModelProperty(value = "")
    private Long likeIt;

    @Column(name = "state", columnDefinition = "int COMMENT ''")
    @ApiModelProperty(value = "")
    private Integer state;

    @Column(name = "update_time", columnDefinition = "datetime(6) COMMENT ''")
    @ApiModelProperty(value = "")
    private Timestamp updateTime;

    @Column(name = "t_media_id", columnDefinition = "bigint COMMENT ''")
    @ApiModelProperty(value = "")
    private Long tMediaId;

    @Column(name = "user_id", columnDefinition = "bigint COMMENT ''")
    @ApiModelProperty(value = "")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentMsg() {
        return commentMsg;
    }

    public void setCommentMsg(String commentMsg) {
        this.commentMsg = commentMsg;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getLikeIt() {
        return likeIt;
    }

    public void setLikeIt(Long likeIt) {
        this.likeIt = likeIt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTMediaId() {
        return tMediaId;
    }

    public void setTMediaId(Long tMediaId) {
        this.tMediaId = tMediaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}