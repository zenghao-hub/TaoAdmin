/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao;

import com.zenghao.annotation.rest.AnonymousGetMapping;
import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
@Api(hidden = true)
@EnableTransactionManagement
@SpringBootApplication
public class AppRun {
	public static void main(String[] args) {
		SpringApplication.run(AppRun.class, args);
	}

	@Bean
	public ServletWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory fa = new TomcatServletWebServerFactory();
		fa.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "[]{}"));
		return fa;
	}

	/**
	 * 访问首页提示
	 *
	 * @return /
	 */
	@AnonymousGetMapping("/")
	public String index() {
		return "Backend service started successfully";
	}
}
