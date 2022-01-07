package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity( name = "t_resource")
@ApiModel(value = "资源实体")
public class TResourceEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "resource_url", columnDefinition = "varchar(255) COMMENT '资源地址'")
	@ApiModelProperty(value = "资源地址")
	private String resourceUrl;

	@Column(name = "resource_img_id", columnDefinition = "varchar(255) COMMENT '资源图片id'")
	@ApiModelProperty(value = "资源图片id")
	private String resourceImgId;

	@Column(name = "resource_introduce", columnDefinition = "varchar(255) COMMENT '资源介绍'")
	@ApiModelProperty(value = "资源介绍")
	private String resourceIntroduce;

	@Column(name = "resource_title", columnDefinition = "varchar(255) COMMENT '资源标题'")
	@ApiModelProperty(value = "资源标题")
	private String resourceTitle;

	@Column(name = "top", columnDefinition = "int COMMENT '是否置顶'")
	@ApiModelProperty(value = "是否置顶")
	private Integer top;

	public Integer getId() {return id;}

	public void setId (Integer id) {this.id = id;}

	public String getResourceUrl() {return resourceUrl;}

	public void setResourceUrl (String resourceUrl) {this.resourceUrl = resourceUrl;}

	public String getResourceImgId() {return resourceImgId;}

	public void setResourceImgId (String resourceImgId) {this.resourceImgId = resourceImgId;}

	public String getResourceIntroduce() {return resourceIntroduce;}

	public void setResourceIntroduce (String resourceIntroduce) {this.resourceIntroduce = resourceIntroduce;}

	public String getResourceTitle() {return resourceTitle;}

	public void setResourceTitle (String resourceTitle) {this.resourceTitle = resourceTitle;}

	public Integer getTop() {return top;}

	public void setTop (Integer top) {this.top = top;}

}