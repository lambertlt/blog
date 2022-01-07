package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "t_comment_reply")
@ApiModel(value = "二级评论实体")
public class TCommentReplyEntity implements Serializable {

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

    @Column(name = "comment_id", columnDefinition = "bigint COMMENT ''")
    @ApiModelProperty(value = "")
    private Long commentId;

    @Column(name = "reply_user_id", columnDefinition = "bigint COMMENT ''")
    @ApiModelProperty(value = "")
    private Long replyUserId;

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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}