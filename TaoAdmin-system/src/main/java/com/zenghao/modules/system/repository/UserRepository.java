/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.modules.system.repository;

import com.zenghao.modules.system.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
