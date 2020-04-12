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
@Table(name = "COLOR_SCHEME")
public class ColorSchemeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "PRIMARY_COLOR", nullable = false)
	private String primaryColor;

	@Column(name = "SECONDARY_COLOR", nullable = false)
	private String secondaryColor;

	@Column(name = "ACCENT_COLOR", nullable = false)
	private String accentColor;

	@Column(name = "WARN_COLOR", nullable = false)
	private String warnColor;

	@Column(name = "IS_NIGHT_MODE", nullable = false)
	private String isNightMode;

	@Column(name = "STYLE_SHEET_NAME", nullable = false)
	private String styleSheetName;

	@Column(name = "IS_ACTIVE_COLOR_SCHEME", nullable = false)
	private String isActiveColorScheme;

	@Column(name = "CREATED_BY", nullable = false)
	private String createdBy;

	@Column(name = "CREATED_DATE_TIME", nullable = false)
	private Date cretaedDateTime;

	@Column(name = "MODIFIED_DATE_TIME", nullable = false)
	private Date modifiedDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrimaryColor() {
		return primaryColor;
	}

	public void setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public String getAccentColor() {
		return accentColor;
	}

	public void setAccentColor(String accentColor) {
		this.accentColor = accentColor;
	}

	public String getWarnColor() {
		return warnColor;
	}

	public void setWarnColor(String warnColor) {
		this.warnColor = warnColor;
	}

	public String getIsNightMode() {
		return isNightMode;
	}

	public void setIsNightMode(String isNightMode) {
		this.isNightMode = isNightMode;
	}

	public String getStyleSheetName() {
		return styleSheetName;
	}

	public void setStyleSheetName(String styleSheetName) {
		this.styleSheetName = styleSheetName;
	}

	public String getIsActiveColorScheme() {
		return isActiveColorScheme;
	}

	public void setIsActiveColorScheme(String isActiveColorScheme) {
		this.isActiveColorScheme = isActiveColorScheme;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCretaedDateTime() {
		return cretaedDateTime;
	}

	public void setCretaedDateTime(Date cretaedDateTime) {
		this.cretaedDateTime = cretaedDateTime;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
