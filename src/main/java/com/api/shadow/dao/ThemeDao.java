package com.api.shadow.dao;

import com.api.shadow.entity.ColorSchemeEntity;

public interface ThemeDao {

	ColorSchemeEntity getColorScheme();

	ColorSchemeEntity saveColorScheme(ColorSchemeEntity colorSchemeEntity);
}
