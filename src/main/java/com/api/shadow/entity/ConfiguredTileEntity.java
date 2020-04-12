package com.api.shadow.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURED_TILE")
public class ConfiguredTileEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TILE_SEQ_NO", insertable = false, updatable = false)
	private int tileSeqNO;

	@Column(name = "TILE_TITLE", nullable = false)
	private String tileTitle;

	@Column(name = "TILE_DESCRIPTION", nullable = false)
	private String tileDescription;

	@Column(name = "TILE_CODE", nullable = false, unique = true)
	private String tileCode;

	@Column(name = "TILE_COMPONENT", nullable = false)
	private String tileComponent;

	@Column(name = "Tile_IS_ACCESSED", nullable = false)
	private String tileIsAccessed;

	@Column(name = "TILE_IS_DELETE", nullable = false)
	private String tileIsDelete;

	@Column(name = "TILE_CREATED_DATE_TIME", nullable = false)
	private Date tileCreatedDateTime;

	@Column(name = "TILE_MODIFIED_DATE_TIME", nullable = false)
	private Date tileModifiedDateTime;

	@Column(name = "TILE_PRIORITY", nullable = false, unique = true)
	private int tilePriority;

	public int getTileSeqNO() {
		return tileSeqNO;
	}

	public void setTileSeqNO(int tileSeqNO) {
		this.tileSeqNO = tileSeqNO;
	}

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

	public Date getTileCreatedDateTime() {
		return tileCreatedDateTime;
	}

	public void setTileCreatedDateTime(Date tileCreatedDateTime) {
		this.tileCreatedDateTime = tileCreatedDateTime;
	}

	public Date getTileModifiedDateTime() {
		return tileModifiedDateTime;
	}

	public void setTileModifiedDateTime(Date tileModifiedDateTime) {
		this.tileModifiedDateTime = tileModifiedDateTime;
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
