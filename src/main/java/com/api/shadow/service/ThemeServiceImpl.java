package com.api.shadow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shadow.dao.ThemeDao;
import com.api.shadow.entity.ColorSchemeEntity;

@Service
public class ThemeServiceImpl implements ThemeService {

	@Autowired
	ThemeDao themeDao;

	@Override
	public ColorSchemeEntity getColorScheme() {
		return themeDao.getColorScheme();
	}

	@Override
	public ColorSchemeEntity saveColorScheme(ColorSchemeEntity colorSchemeEntity) {
		return themeDao.saveColorScheme(colorSchemeEntity);
	}
}
