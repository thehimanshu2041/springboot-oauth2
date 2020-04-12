package com.api.shadow.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shadow.entity.ColorSchemeEntity;

public interface ColorSchemeRepository extends JpaRepository<ColorSchemeEntity, Long> {

}
