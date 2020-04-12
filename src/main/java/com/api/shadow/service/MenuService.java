package com.api.shadow.service;

import java.util.List;

import com.api.shadow.entity.ConfiguredTileEntity;
import com.api.shadow.entity.MenuEntity;
import com.api.shadow.modal.ManagedContent;
import com.api.shadow.modal.MenuModal;
import com.api.shadow.modal.TileModal;

public interface MenuService {

	List<MenuEntity> findAll(String authReq, String isAdmin);

	List<MenuEntity> findAllMenus();

	boolean createMenuItem(MenuModal menuModal);

	List<ManagedContent> getConfiguredTileList();

	List<ConfiguredTileEntity> getConfiguredTileModalList();

	boolean saveConfiguredTileModal(TileModal tileModal);

	boolean updateConfiguredTileModal(ConfiguredTileEntity configuredTileEntity);

}
