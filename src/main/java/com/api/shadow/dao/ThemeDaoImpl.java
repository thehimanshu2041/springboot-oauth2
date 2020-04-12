package com.api.shadow.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shadow.dao.repository.ColorSchemeRepository;
import com.api.shadow.entity.ColorSchemeEntity;

@Service
public class ThemeDaoImpl implements ThemeDao {

	@Autowired
	ColorSchemeRepository colorSchemeRepository;

	@Override
	public ColorSchemeEntity getColorScheme() {
		return colorSchemeRepository.findAll().get(0);
	}

	@Override
	public ColorSchemeEntity saveColorScheme(ColorSchemeEntity colorSchemeEntity) {
		return colorSchemeRepository.save(colorSchemeEntity);
	}
}
