package com.api.shadow.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.MenuDao;
import com.api.shadow.entity.ConfiguredTileEntity;
import com.api.shadow.entity.MenuEntity;
import com.api.shadow.modal.ManagedContent;
import com.api.shadow.modal.MenuModal;
import com.api.shadow.modal.TileModal;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDao menuDao;

	@Override
	public List<MenuEntity> findAll(String authReq, String isAdmin) {
		return menuDao.findAll(authReq, isAdmin);
	}

	@Override
	public List<MenuEntity> findAllMenus() {
		return menuDao.findAllMenus();
	}

	@Override
	public boolean createMenuItem(MenuModal menuModal) {
		return this.menuDao.createMenuItem(menuModal);
	}

	@Override
	public List<ManagedContent> getConfiguredTileList() {
		return this.menuDao.getConfiguredTileList();
	}

	@Override
	public List<ConfiguredTileEntity> getConfiguredTileModalList() {
		return menuDao.getConfiguredTileModalList();
	}

	@Override
	public boolean saveConfiguredTileModal(TileModal tileModal) {
		ConfiguredTileEntity configuredTileEntity = new ConfiguredTileEntity();
		BeanUtils.copyProperties(tileModal, configuredTileEntity);
		configuredTileEntity.setTileCreatedDateTime(new Date());
		configuredTileEntity.setTileModifiedDateTime(new Date());
		configuredTileEntity.setTileIsAccessed(VariableConstants.FLAG_Y);
		configuredTileEntity.setTileIsDelete(VariableConstants.FLAG_N);
		return menuDao.saveConfiguredTileModal(configuredTileEntity);
	}

	@Override
	public boolean updateConfiguredTileModal(ConfiguredTileEntity configuredTileEntity) {
		return menuDao.saveConfiguredTileModal(configuredTileEntity);
	}
}
