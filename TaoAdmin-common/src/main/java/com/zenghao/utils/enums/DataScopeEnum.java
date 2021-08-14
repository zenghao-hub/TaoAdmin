package com.zenghao.utils.enums;

import lombok.Getter;

@Getter
public enum DataScopeEnum {
	ALL("全部", "全部数据权限"),
	THIS_LEVEL("本级", "自己部门的数据权限"),
	CUSTOMIZE("自定义", "自定义的数据权限");

	private final String value;
	private final String description;

	DataScopeEnum(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static DataScopeEnum find(String val) {
		for (DataScopeEnum dataScopeEnum : DataScopeEnum.values()) {
			if (val.equals(dataScopeEnum.getValue())) {
				return dataScopeEnum;
			}
		}
		return null;
	}
}
