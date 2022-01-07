package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity( name = "t_tag")
@ApiModel(value = "文章分类实体")
public class TTagEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tag_name", columnDefinition = "varchar(255) COMMENT '分类名'")
	@ApiModelProperty(value = "分类名")
	private String tagName;

	@Column(name = "create_time", columnDefinition = "datetime COMMENT '创建时间'")
	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	public Integer getId() {return id;}

	public void setId (Integer id) {this.id = id;}

	public String getTagName() {return tagName;}

	public void setTagName (String tagName) {this.tagName = tagName;}

	public Timestamp getCreateTime() {return createTime;}

	public void setCreateTime (Timestamp createTime) {this.createTime = createTime;}

}