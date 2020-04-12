package com.api.shadow.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shadow.entity.country.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

}
