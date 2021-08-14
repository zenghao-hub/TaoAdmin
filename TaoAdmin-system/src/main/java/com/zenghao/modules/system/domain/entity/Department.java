/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.modules.system.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zenghao.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name="sys_dept")
public class Department extends BaseEntity{
	@Id
	@Column(name = "dept_id")
	@NotNull(groups = Update.class)
	@ApiModelProperty(value = "ID", hidden = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JSONField(serialize = false)
	@ManyToMany(mappedBy = "depts")
	@ApiModelProperty(value = "角色")
	private Set<Role> roles;

	@ApiModelProperty(value = "上级部门")
	private Long pid;

	@ApiModelProperty(value = "子节点数目", hidden = true)
	private Integer subCount = 0;

	@NotBlank
	@ApiModelProperty(value = "部门名称")
	private String name;

	@ApiModelProperty(value = "排序")
	private Integer deptSort;

	@NotNull
	@ApiModelProperty(value = "是否启用")
	private Boolean enabled;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Department that = (Department) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
