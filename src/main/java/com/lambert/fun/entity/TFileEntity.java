package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity( name = "t_file")
@ApiModel(value = "文件实体")
public class TFileEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "file_size", columnDefinition = "double COMMENT '文件大小'")
	@ApiModelProperty(value = "文件大小")
	private Double fileSize;

	@Column(name = "path", columnDefinition = "varchar(255) COMMENT '文件地址'")
	@ApiModelProperty(value = "文件地址")
	private String path;

	@Column(name = "create_time", columnDefinition = "datetime COMMENT '创建时间'")
	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	@Column(name = "file_type", columnDefinition = "varchar(255) COMMENT '文件类型'")
	@ApiModelProperty(value = "文件类型")
	private String fileType;

	public Integer getId() {return id;}

	public void setId (Integer id) {this.id = id;}

	public Double getFileSize() {return fileSize;}

	public void setFileSize (Double fileSize) {this.fileSize = fileSize;}

	public String getPath() {return path;}

	public void setPath (String path) {this.path = path;}

	public Timestamp getCreateTime() {return createTime;}

	public void setCreateTime (Timestamp createTime) {this.createTime = createTime;}

	public String getFileType() {return fileType;}

	public void setFileType (String fileType) {this.fileType = fileType;}

}