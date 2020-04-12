package com.api.shadow.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.repository.ConfiguredTileRepository;
import com.api.shadow.dao.repository.MenuRepository;
import com.api.shadow.entity.ConfiguredTileEntity;
import com.api.shadow.entity.MenuEntity;
import com.api.shadow.modal.ManagedContent;
import com.api.shadow.modal.ManagedContentTile;
import com.api.shadow.modal.MenuModal;

@Service
public class MenuDaoImpl implements MenuDao {

	@Autowired
	MenuRepository menuRepository;
	@Autowired
	ConfiguredTileRepository configuredTileRepository;

	@Override
	public List<MenuEntity> findAll(String authReq, String isAdmin) {

		List<MenuEntity> menuList = null;
		if (null != isAdmin && isAdmin.equalsIgnoreCase(VariableConstants.FLAG_Y)) {
			menuList = menuRepository.findAdminMenuList(authReq, VariableConstants.FLAG_N, isAdmin);
		} else {
			menuList = menuRepository.findMenuList(authReq, VariableConstants.FLAG_N, VariableConstants.FLAG_N);
		}

		for (MenuEntity itrMenuList : menuList) {
			List<MenuEntity> subMenulist = findChildMenuEntity(itrMenuList, authReq, isAdmin);
			itrMenuList.setChildren(subMenulist);
		}
		return menuList;
	}

	private List<MenuEntity> findChildMenuEntity(MenuEntity menuListItem, String authReq, String isAdmin) {

		List<MenuEntity> subMenulist = null;

		if (null != isAdmin && isAdmin.equalsIgnoreCase(VariableConstants.FLAG_Y)) {
			subMenulist = menuRepository.findAdminSubMenuList(menuListItem.getMenuID(), authReq,
					VariableConstants.FLAG_N, isAdmin);
		} else {
			subMenulist = menuRepository.findSubMenuList(menuListItem.getMenuID(), authReq, VariableConstants.FLAG_N,
					VariableConstants.FLAG_N);
		}
		return subMenulist;
	}

	@Override
	public List<MenuEntity> findAllMenus() {
		List<MenuEntity> menuList = null;
		menuList = menuRepository.findAllMenuList();

		for (MenuEntity itrMenuList : menuList) {
			List<MenuEntity> subMenulist = findAllChildMenuList(itrMenuList);
			itrMenuList.setChildren(subMenulist);
		}
		return menuList;
	}

	private List<MenuEntity> findAllChildMenuList(MenuEntity menuListItem) {
		return menuRepository.findAllSubMenuList(menuListItem.getMenuID());
	}

	@Override
	public boolean createMenuItem(MenuModal menuModal) {
		boolean flag = false;
		try {
			MenuEntity menuEntity = new MenuEntity();
			BeanUtils.copyProperties(menuModal, menuEntity);
			menuEntity.setMenuCreatedDateTime(new Date());
			menuEntity.setMenuModifiedDateTime(new Date());
			menuEntity.setMenuIsAuthReq(VariableConstants.FLAG_N);
			menuEntity.setMenuIsDeleted(VariableConstants.FLAG_N);
			menuEntity.setMenuIsVisible(VariableConstants.FLAG_Y);
			menuEntity.setMenuUpdatedBy("ENGINE");
			menuEntity.setMenuParentID(0);
			menuEntity.setMenuIsAdmin(VariableConstants.FLAG_N);
			menuRepository.save(menuEntity);
			return true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	public List<ManagedContent> getConfiguredTileList() {
		List<ConfiguredTileEntity> configuredTileEntity = configuredTileRepository
				.findAllConfiguredTile(VariableConstants.FLAG_Y, VariableConstants.FLAG_N);
		List<ManagedContent> managedContentList = createTileStructure(configuredTileEntity);
		return managedContentList;
	}

	private List<ManagedContent> createTileStructure(List<ConfiguredTileEntity> list) {

		List<ManagedContent> managedContentList = new ArrayList<ManagedContent>();
		ManagedContent manageContent = null;
		ManagedContentTile managedContentTile = null;
		for (ConfiguredTileEntity mc : list) {
			managedContentTile = new ManagedContentTile();
			manageContent = new ManagedContent();

			managedContentTile.setKey(mc.getTileCode());
			managedContentTile.setDescription(mc.getTileDescription());
			managedContentTile.setTitle(mc.getTileDescription());
			managedContentTile.setIcon("person");
			managedContentTile.setType("11");
			manageContent.setTile(managedContentTile);
			managedContentList.add(manageContent);
		}
		return managedContentList;
	}

	@Override
	public List<ConfiguredTileEntity> getConfiguredTileModalList() {
		return configuredTileRepository.findAll();
	}

	@Override
	public boolean saveConfiguredTileModal(ConfiguredTileEntity configuredTileEntity) {
		boolean flag = false;
		try {
			configuredTileRepository.save(configuredTileEntity);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;

	}

}
