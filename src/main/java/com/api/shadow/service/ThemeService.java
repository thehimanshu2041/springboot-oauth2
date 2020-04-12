package com.api.shadow.service;

import com.api.shadow.entity.ColorSchemeEntity;

public interface ThemeService {

	ColorSchemeEntity getColorScheme();

	ColorSchemeEntity saveColorScheme(ColorSchemeEntity colorSchemeEntity);
}
