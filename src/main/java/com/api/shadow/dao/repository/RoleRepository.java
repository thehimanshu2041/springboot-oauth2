package com.api.shadow.dao.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.shadow.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	@Query(value = "SELECT * FROM Role_ENTITY where name IN (:roles)", nativeQuery = true)
	Set<RoleEntity> find(@Param("roles") List<String> roles);

}
