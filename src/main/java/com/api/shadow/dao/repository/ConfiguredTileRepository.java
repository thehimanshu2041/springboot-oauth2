package com.api.shadow.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.shadow.entity.ConfiguredTileEntity;

public interface ConfiguredTileRepository extends JpaRepository<ConfiguredTileEntity, Long> {

	@Query("SELECT me FROM ConfiguredTileEntity as me WHERE me.tileIsAccessed = :tileIsAccessed AND me.tileIsDelete = :tileIsDelete ORDER BY me.tilePriority")
	List<ConfiguredTileEntity> findAllConfiguredTile(@Param("tileIsAccessed") String tileIsAccessed,
			@Param("tileIsDelete") String tileIsDelete);

}
