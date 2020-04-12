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
@Table(name = "VERSION_ENTITY")
public class VersionEntity implements Serializable {

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

	@Column(name = "VERSION", nullable = false)
	private String version;

	@Column(name = "ISAUTHENTICATED", nullable = false)
	private String isAuthenticated;

	@Column(name = "ACCESSED_BY", nullable = false)
	private String accessedBy;

	@Column(name = "CREATED_DATE_TIME", nullable = false)
	private Date createdDateTime;

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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(String isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public String getAccessedBy() {
		return accessedBy;
	}

	public void setAccessedBy(String accessedBy) {
		this.accessedBy = accessedBy;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
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
