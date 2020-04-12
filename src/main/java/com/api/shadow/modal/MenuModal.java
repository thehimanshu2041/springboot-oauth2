package com.api.shadow.modal;

import java.io.Serializable;

public class MenuModal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuName;
	private String menuPath;
	private String menuDescription;
	private String menuIcon;
	private String menuKey;
	private int menuPriority;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public int getMenuPriority() {
		return menuPriority;
	}

	public void setMenuPriority(int menuPriority) {
		this.menuPriority = menuPriority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
