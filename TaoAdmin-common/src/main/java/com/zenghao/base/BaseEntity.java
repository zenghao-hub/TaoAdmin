/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
	private static final long serialVersionUID  = 1L;

	@CreatedBy
	@Column(name="create_by", updatable = false)
	@ApiModelProperty(value = "创建人", hidden = true)
	private String createBy;

	@LastModifiedBy
	@Column(name = "update_by")
	@ApiModelProperty(value = "更新人", hidden = true)
	private String updateBy;

	@CreationTimestamp
	@Column(name = "create_time", updatable = false)
	@ApiModelProperty(value = "创建时间", hidden = true)
	private String createTime;

	@UpdateTimestamp
	@Column(name = "update_time")
	@ApiModelProperty(value = "更新时间", hidden = true)
	private String updateTime;

	@Override
	public String toString() {
		return "BaseEntity{" +
				"createBy='" + createBy + '\'' +
				", updateBy='" + updateBy + '\'' +
				", createTime='" + createTime + '\'' +
				", updateTime='" + updateTime + '\'' +
				'}';
	}

	/* 分组校验 */
	public @interface Create {}

	/* 分组校验 */
	public @interface Update {}
}
