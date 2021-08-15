/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorAware")
public class AuditConfig implements AuditorAware<String> {
	@Override
	public Optional<String> getCurrentAuditor() {
		try {
			// 这里应根据实际业务情况获取具体信息
			return Optional.of("test_zh");
		}catch (Exception ignored){}
		// 用户定时任务，或者无Token调用的情况
		return Optional.of("System");
	}
}
