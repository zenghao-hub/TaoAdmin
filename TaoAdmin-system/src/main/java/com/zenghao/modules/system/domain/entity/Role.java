/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.modules.system.domain.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.zenghao.base.BaseEntity;
import com.zenghao.utils.enums.DataScopeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Role extends BaseEntity {
	@Id
	@Column(name = "role_id")
	@NotNull(groups = {Update.class})
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "ID", hidden = true)
	private Long id;

	// 不会返回这个字段
	@JSONField(serialize = false)
	@ManyToMany(mappedBy = "roles")
	@ApiModelProperty(value = "用户", hidden = true)
	private Set<User> users;

	@ManyToMany
	@JoinTable(name = "sys_roles_menus",
			joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "role_id")},
			inverseJoinColumns = {@JoinColumn(name = "menu_id",referencedColumnName = "menu_id")})
	@ApiModelProperty(value = "菜单", hidden = true)
	private Set<Menu> menus;

	@ManyToMany
	@JoinTable(name = "sys_roles_depts",
			joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "role_id")},
			inverseJoinColumns = {@JoinColumn(name = "dept_id",referencedColumnName = "dept_id")})
	@ApiModelProperty(value = "部门", hidden = true)
	private Set<Department> depts;

	@Column(name = "level")
	@ApiModelProperty(value = "级别，数值越小，级别越大")
	private Integer level = 3;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "数据权限，全部 、 本级 、 自定义")
	private String dataScope = DataScopeEnum.THIS_LEVEL.getValue();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Role role = (Role) o;
		return Objects.equals(id, role.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), id);
	}
}
