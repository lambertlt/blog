package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity( name = "t_post")
@ApiModel(value = "文章实体")
public class TPostEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title", columnDefinition = "varchar(255) COMMENT '标题'")
	@ApiModelProperty(value = "标题")
	private String title;

	@Column(name = "content", columnDefinition = "varchar(255) COMMENT '内容'")
	@ApiModelProperty(value = "内容")
	private String content;

	@Column(name = "tag_id", columnDefinition = "int COMMENT '分类id'")
	@ApiModelProperty(value = "分类id")
	private Integer tagId;

	@Column(name = "favour", columnDefinition = "int COMMENT '点赞'")
	@ApiModelProperty(value = "点赞")
	private Integer favour;

	@Column(name = "view_number", columnDefinition = "int COMMENT '浏览量'")
	@ApiModelProperty(value = "浏览量")
	private Integer viewNumber;

	@Column(name = "create_time", columnDefinition = "datetime COMMENT '创建时间'")
	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	@Column(name = "update_time", columnDefinition = "datetime COMMENT '修改时间'")
	@ApiModelProperty(value = "修改时间")
	private Timestamp updateTime;

	@Column(name = "top", columnDefinition = "int COMMENT '是否置顶'")
	@ApiModelProperty(value = "是否置顶")
	private Integer top;

	@Column(name = "order", columnDefinition = "int COMMENT '排列顺序'")
	@ApiModelProperty(value = "排列顺序")
	private Integer order;

	public Integer getId() {return id;}

	public void setId (Integer id) {this.id = id;}

	public String getTitle() {return title;}

	public void setTitle (String title) {this.title = title;}

	public String getContent() {return content;}

	public void setContent (String content) {this.content = content;}

	public Integer getTagId() {return tagId;}

	public void setTagId (Integer tagId) {this.tagId = tagId;}

	public Integer getFavour() {return favour;}

	public void setFavour (Integer favour) {this.favour = favour;}

	public Integer getViewNumber() {return viewNumber;}

	public void setViewNumber (Integer viewNumber) {this.viewNumber = viewNumber;}

	public Timestamp getCreateTime() {return createTime;}

	public void setCreateTime (Timestamp createTime) {this.createTime = createTime;}

	public Timestamp getUpdateTime() {return updateTime;}

	public void setUpdateTime (Timestamp updateTime) {this.updateTime = updateTime;}

	public Integer getTop() {return top;}

	public void setTop (Integer top) {this.top = top;}

	public Integer getOrder() {return order;}

	public void setOrder (Integer order) {this.order = order;}

}