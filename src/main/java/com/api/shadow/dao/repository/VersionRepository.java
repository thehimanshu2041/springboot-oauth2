package com.api.shadow.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shadow.entity.VersionEntity;

public interface VersionRepository extends JpaRepository<VersionEntity, Long> {

	VersionEntity findByIsAuthenticated(String flag);

}
