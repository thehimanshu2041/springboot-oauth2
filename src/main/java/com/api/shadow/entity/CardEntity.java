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
@Table(name = "CARD_ENTITY")
public class CardEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", insertable = false, updatable = false)
	private long id;

	@Column(name = "CARD_USER_ID", nullable = false, unique = true)
	private int cardUserID;

	@Column(name = "CARD_NUMBER", nullable = false)
	private String cardNumber;

	@Column(name = "CARD_HOLDER_FIRST_NAME", nullable = false)
	private String holderFirstName;

	@Column(name = "CARD_HOLDER_LAST_NAME", nullable = false)
	private String holderLastName;

	@Column(name = "CARD_EXPIRY_MONTH", nullable = false)
	private String expiryMonth;

	@Column(name = "CARD_EXPIRY_YEAR", nullable = false)
	private String expiryYear;

	@Column(name = "CARD_CVV", nullable = false)
	private int cvv;

	@Column(name = "CARD_UPDATED_BY", nullable = false)
	private String updatedBy;

	@Column(name = "CARD_CREATED_DATE_TIME", nullable = false)
	private Date createdDateTime;

	@Column(name = "CARD_MODIFIED_DATE_TIME", nullable = false)
	private Date modifiedDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCardUserID() {
		return cardUserID;
	}

	public void setCardUserID(int i) {
		this.cardUserID = i;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getHolderFirstName() {
		return holderFirstName;
	}

	public void setHolderFirstName(String holderFirstName) {
		this.holderFirstName = holderFirstName;
	}

	public String getHolderLastName() {
		return holderLastName;
	}

	public void setHolderLastName(String holderLastName) {
		this.holderLastName = holderLastName;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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
