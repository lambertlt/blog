package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity( name = "t_media")
@ApiModel(value = "媒体实体")
public class TMediaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "media_name", columnDefinition = "varchar(255) COMMENT '媒体名'")
	@ApiModelProperty(value = "媒体名")
	private String mediaName;

	@Column(name = "file_id", columnDefinition = "int COMMENT '文件id'")
	@ApiModelProperty(value = "文件id")
	private Integer fileId;

	public Integer getId() {return id;}

	public void setId (Integer id) {this.id = id;}

	public String getMediaName() {return mediaName;}

	public void setMediaName (String mediaName) {this.mediaName = mediaName;}

	public Integer getFileId() {return fileId;}

	public void setFileId (Integer fileId) {this.fileId = fileId;}

}