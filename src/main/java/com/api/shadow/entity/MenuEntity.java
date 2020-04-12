package com.api.shadow.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MENU_ENTITY")
public class MenuEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_ID", insertable = false, updatable = false)
	private int menuID;

	@Column(name = "MENU_PARENT_ID", nullable = false)
	private int menuParentID;

	@Column(name = "MENU_NAME", nullable = false)
	private String menuName;

	@Column(name = "MENU_PATH", nullable = true)
	private String menuPath;

	@Column(name = "MENU_DESCRIPTION", nullable = true)
	private String menuDescription;

	@Column(name = "MENU_ICON", nullable = true)
	private String menuIcon;

	@Column(name = "MENU_IS_DELETED", nullable = false)
	private String menuIsDeleted;

	@Column(name = "MENU_IS_ADMIN", nullable = false)
	private String menuIsAdmin;

	@Column(name = "MENU_IS_VISIBLE", nullable = false)
	private String menuIsVisible;

	@Column(name = "MENU_IS_AUTH_REQ", nullable = false)
	private String menuIsAuthReq;

	@Column(name = "MENU_KEY", nullable = false, unique = true)
	private String menuKey;

	@Column(name = "MENU_UPDATED_BY", nullable = false)
	private String menuUpdatedBy;

	@Column(name = "MENU_CREATED_DATE_TIME", nullable = false)
	private Date menuCreatedDateTime;

	@Column(name = "MENU_MODIFIED_DATE_TIME", nullable = false)
	private Date menuModifiedDateTime;

	@Column(name = "MENU_PRIORITY", nullable = false, unique = true)
	private int menuPriority;

	@Transient
	private List<MenuEntity> children;

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public int getMenuParentID() {
		return menuParentID;
	}

	public void setMenuParentID(int menuParentID) {
		this.menuParentID = menuParentID;
	}

	public String getMenuIsAdmin() {
		return menuIsAdmin;
	}

	public void setMenuIsAdmin(String menuIsAdmin) {
		this.menuIsAdmin = menuIsAdmin;
	}

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

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getMenuIsDeleted() {
		return menuIsDeleted;
	}

	public void setMenuIsDeleted(String menuIsDeleted) {
		this.menuIsDeleted = menuIsDeleted;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public String getMenuUpdatedBy() {
		return menuUpdatedBy;
	}

	public void setMenuUpdatedBy(String menuUpdatedBy) {
		this.menuUpdatedBy = menuUpdatedBy;
	}

	public Date getMenuCreatedDateTime() {
		return menuCreatedDateTime;
	}

	public void setMenuCreatedDateTime(Date menuCreatedDateTime) {
		this.menuCreatedDateTime = menuCreatedDateTime;
	}

	public Date getMenuModifiedDateTime() {
		return menuModifiedDateTime;
	}

	public void setMenuModifiedDateTime(Date menuModifiedDateTime) {
		this.menuModifiedDateTime = menuModifiedDateTime;
	}

	public String getMenuIsVisible() {
		return menuIsVisible;
	}

	public void setMenuIsVisible(String menuIsVisible) {
		this.menuIsVisible = menuIsVisible;
	}

	public String getMenuIsAuthReq() {
		return menuIsAuthReq;
	}

	public void setMenuIsAuthReq(String menuIsAuthReq) {
		this.menuIsAuthReq = menuIsAuthReq;
	}

	public List<MenuEntity> getChildren() {
		return children;
	}

	public void setChildren(List<MenuEntity> children) {
		this.children = children;
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
