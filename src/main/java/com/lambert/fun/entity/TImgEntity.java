package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity( name = "t_img")
@ApiModel(value = "图片实体")
public class TImgEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "img_name", columnDefinition = "varchar(255) COMMENT '图片名称'")
	@ApiModelProperty(value = "图片名称")
	private String imgName;

	@Column(name = "file_id", columnDefinition = "int COMMENT '文件id'")
	@ApiModelProperty(value = "文件id")
	private Integer fileId;

	public Integer getId() {return id;}

	public void setId (Integer id) {this.id = id;}

	public String getImgName() {return imgName;}

	public void setImgName (String imgName) {this.imgName = imgName;}

	public Integer getFileId() {return fileId;}

	public void setFileId (Integer fileId) {this.fileId = fileId;}

}