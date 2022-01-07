package com.lambert.fun.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity( name = "t_diary")
@ApiModel(value = "日记实体")
public class TDiaryEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title", columnDefinition = "varchar(255) COMMENT '标题'")
	@ApiModelProperty(value = "标题")
	private String title;

	@Column(name = "create_time", columnDefinition = "datetime COMMENT '创建时间'")
	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	@Column(name = "update_time", columnDefinition = "datetime COMMENT '上次编辑时间'")
	@ApiModelProperty(value = "上次编辑时间")
	private Timestamp updateTime;

	@Column(name = "content", columnDefinition = "text COMMENT '内容'")
	@ApiModelProperty(value = "内容")
	private String content;

	public Integer getId() {return id;}

	public void setId (Integer id) {this.id = id;}

	public String getTitle() {return title;}

	public void setTitle (String title) {this.title = title;}

	public Timestamp getCreateTime() {return createTime;}

	public void setCreateTime (Timestamp createTime) {this.createTime = createTime;}

	public Timestamp getUpdateTime() {return updateTime;}

	public void setUpdateTime (Timestamp updateTime) {this.updateTime = updateTime;}

	public String getContent() {return content;}

	public void setContent (String content) {this.content = content;}

}