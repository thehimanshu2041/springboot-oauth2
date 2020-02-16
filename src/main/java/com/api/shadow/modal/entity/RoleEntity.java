package com.api.shadow.modal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_ENTITY")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "NAME", nullable = false)
	private RoleTypeEnum name;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "CREATED_ON", nullable = true)
	private Date createdOn;
	@Column(name = "MODIFIED_ON", nullable = true)
	private Date modifiedOn;

	public RoleTypeEnum getName() {
		return name;
	}

	public void setName(RoleTypeEnum name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}
