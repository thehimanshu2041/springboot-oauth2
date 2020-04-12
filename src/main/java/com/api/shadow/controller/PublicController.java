package com.api.shadow.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.repository.CountryRepository;
import com.api.shadow.dao.repository.MenuRepository;
import com.api.shadow.dao.repository.VersionRepository;
import com.api.shadow.entity.ColorSchemeEntity;
import com.api.shadow.entity.ConfiguredTileEntity;
import com.api.shadow.entity.MenuEntity;
import com.api.shadow.entity.UserEntity;
import com.api.shadow.modal.MenuModal;
import com.api.shadow.modal.TileModal;
import com.api.shadow.response.ApiResponseColorSchemeObject;
import com.api.shadow.response.ApiResponseConfiguredTileList;
import com.api.shadow.response.ApiResponseConfiguredTileModalList;
import com.api.shadow.response.ApiResponseConfiguredTileboolean;
import com.api.shadow.response.ApiResponseCountryList;
import com.api.shadow.response.ApiResponseMenuList;
import com.api.shadow.response.ApiResponseMenuboolean;
import com.api.shadow.response.ApiResponseNewsList;
import com.api.shadow.response.ApiResponseUserObject;
import com.api.shadow.response.ApiResponseVersionObject;
import com.api.shadow.service.MenuService;
import com.api.shadow.service.NewsService;
import com.api.shadow.service.ThemeService;
import com.api.shadow.service.UserService;

@RestController
@RequestMapping("/pub")
public class PublicController {

	@Autowired
	UserService userService;

	@Autowired
	VersionRepository versionRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	MenuService menuService;

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	ThemeService themeService;

	@Autowired
	NewsService newsService;

	@GetMapping(produces = "application/json")
	@ResponseBody
	public ApiResponseVersionObject version() {
		return new ApiResponseVersionObject(HttpStatus.OK, VariableConstants.SUCCESS,
				versionRepository.findByIsAuthenticated(VariableConstants.FLAG_Y));
	}

	@RequestMapping(value = "create-user", method = RequestMethod.POST)
	public ApiResponseUserObject create(@RequestBody UserEntity user) {
		return new ApiResponseUserObject(HttpStatus.OK, VariableConstants.SUCCESS, userService.save(user));
	}

	@PostMapping(value = "create-menu-item", produces = "application/json")
	@ResponseBody
	public ApiResponseMenuboolean createMenuItem(@RequestBody MenuModal menuModal) throws Exception {
		return new ApiResponseMenuboolean(HttpStatus.OK, VariableConstants.SUCCESS,
				menuService.createMenuItem(menuModal));
	}

	@PutMapping(value = "update-menu-item", produces = "application/json")
	@ResponseBody
	public ApiResponseMenuboolean updateMenuItem(@RequestBody MenuEntity menuEntity) throws Exception {

		MenuEntity oldMenuEntity = menuRepository.findBymenuID(menuEntity.getMenuID());
		menuEntity.setMenuCreatedDateTime(oldMenuEntity.getMenuCreatedDateTime());
		menuEntity.setMenuModifiedDateTime(new Date());
		menuEntity.setMenuUpdatedBy("ENGINE");
		menuRepository.save(menuEntity);
		return new ApiResponseMenuboolean(HttpStatus.OK, VariableConstants.SUCCESS, true);
	}

	@GetMapping(value = "menu-list", produces = "application/json")
	@ResponseBody
	public ApiResponseMenuList menuList(@RequestParam(name = "authReq", required = true) String authReq,
			@RequestParam(name = "isAdmin", required = false) String isAdmin) throws Exception {
		return new ApiResponseMenuList(HttpStatus.OK, VariableConstants.SUCCESS, menuService.findAll(authReq, isAdmin));
	}

	@GetMapping(value = "all-parent-menu-list", produces = "application/json")
	@ResponseBody
	public ApiResponseMenuList allParentMenuList() throws Exception {
		return new ApiResponseMenuList(HttpStatus.OK, VariableConstants.SUCCESS, menuService.findAllMenus());
	}

	@GetMapping(value = "all-menu-list", produces = "application/json")
	@ResponseBody
	public ApiResponseMenuList allMenuList() throws Exception {
		return new ApiResponseMenuList(HttpStatus.OK, VariableConstants.SUCCESS, menuRepository.findAll());
	}

	@GetMapping(value = "country-list", produces = "application/json")
	@ResponseBody
	public ApiResponseCountryList countryList() throws Exception {
		return new ApiResponseCountryList(HttpStatus.OK, VariableConstants.SUCCESS, countryRepository.findAll());
	}

	@GetMapping(value = "news-list", produces = "application/json")
	@ResponseBody
	public ApiResponseNewsList newsList() throws Exception {
		return new ApiResponseNewsList(HttpStatus.OK, VariableConstants.SUCCESS, newsService.getNewsList());
	}

	@GetMapping(value = "color-scheme", produces = "application/json")
	@ResponseBody
	public ApiResponseColorSchemeObject colorScheme() throws Exception {
		return new ApiResponseColorSchemeObject(HttpStatus.OK, VariableConstants.SUCCESS,
				themeService.getColorScheme());
	}

	@GetMapping(value = "get-configured-tile-list", produces = "application/json")
	@ResponseBody
	public ApiResponseConfiguredTileList getConfiguredTileList() throws Exception {
		return new ApiResponseConfiguredTileList(HttpStatus.OK, VariableConstants.SUCCESS,
				menuService.getConfiguredTileList());
	}

	@PutMapping(value = "color-scheme", produces = "application/json")
	@ResponseBody
	public ApiResponseColorSchemeObject saveColorScheme(@RequestBody ColorSchemeEntity colorSchemeEntity)
			throws Exception {
		return new ApiResponseColorSchemeObject(HttpStatus.OK, VariableConstants.SUCCESS,
				themeService.saveColorScheme(colorSchemeEntity));
	}

	@GetMapping(value = "get-configured-tile-modal-list", produces = "application/json")
	@ResponseBody
	public ApiResponseConfiguredTileModalList getConfiguredTileModalList() throws Exception {
		return new ApiResponseConfiguredTileModalList(HttpStatus.OK, VariableConstants.SUCCESS,
				menuService.getConfiguredTileModalList());
	}

	@PostMapping(value = "save-configured-tile-modal", produces = "application/json")
	@ResponseBody
	public ApiResponseConfiguredTileboolean saveConfiguredTileModal(@RequestBody TileModal tileModal) throws Exception {
		return new ApiResponseConfiguredTileboolean(HttpStatus.OK, VariableConstants.SUCCESS,
				menuService.saveConfiguredTileModal(tileModal));
	}

	@PutMapping(value = "update-configured-tile-modal", produces = "application/json")
	@ResponseBody
	public ApiResponseConfiguredTileboolean updateConfiguredTileModal(
			@RequestBody ConfiguredTileEntity configuredTileEntity) throws Exception {
		return new ApiResponseConfiguredTileboolean(HttpStatus.OK, VariableConstants.SUCCESS,
				menuService.updateConfiguredTileModal(configuredTileEntity));
	}
}
