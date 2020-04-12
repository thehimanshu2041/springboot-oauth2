package com.api.shadow.modal;

import java.io.Serializable;

public class TileModal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tileTitle;
	private String tileDescription;
	private String tileCode;
	private String tileComponent;
	private String tileIsAccessed;
	private String tileIsDelete;
	private int tilePriority;

	public String getTileTitle() {
		return tileTitle;
	}

	public void setTileTitle(String tileTitle) {
		this.tileTitle = tileTitle;
	}

	public String getTileDescription() {
		return tileDescription;
	}

	public void setTileDescription(String tileDescription) {
		this.tileDescription = tileDescription;
	}

	public String getTileCode() {
		return tileCode;
	}

	public void setTileCode(String tileCode) {
		this.tileCode = tileCode;
	}

	public String getTileComponent() {
		return tileComponent;
	}

	public void setTileComponent(String tileComponent) {
		this.tileComponent = tileComponent;
	}

	public String getTileIsAccessed() {
		return tileIsAccessed;
	}

	public void setTileIsAccessed(String tileIsAccessed) {
		this.tileIsAccessed = tileIsAccessed;
	}

	public String getTileIsDelete() {
		return tileIsDelete;
	}

	public void setTileIsDelete(String tileIsDelete) {
		this.tileIsDelete = tileIsDelete;
	}

	public int getTilePriority() {
		return tilePriority;
	}

	public void setTilePriority(int tilePriority) {
		this.tilePriority = tilePriority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
