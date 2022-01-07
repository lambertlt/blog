package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity( name = "t_index_post")
@ApiModel(value = "")
public class TIndexPostEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "content", columnDefinition = "varchar(255) COMMENT '主页文章内容'")
	@ApiModelProperty(value = "主页文章内容")
	private String content;

	@Column(name = "order", columnDefinition = "int COMMENT '排列顺序'")
	@ApiModelProperty(value = "排列顺序")
	private Integer order;

	public Integer getId() {return id;}

	public void setId (Integer id) {this.id = id;}

	public String getContent() {return content;}

	public void setContent (String content) {this.content = content;}

	public Integer getOrder() {return order;}

	public void setOrder (Integer order) {this.order = order;}

}