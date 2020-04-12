package com.api.shadow.dao.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.shadow.entity.CardEntity;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

	CardEntity findByCardUserID(int userID);
	
	@Transactional
	@Modifying
	@Query("update CardEntity as me SET me.cardNumber = :cardNumber, me.holderFirstName = :holderFirstName , me.holderLastName = :holderLastName "
			+ ", me.expiryMonth = :expiryMonth , me.expiryYear = :expiryYear , me.cvv = :cvv WHERE me.cardUserID = :cardUserID")
	void updateCardDetails(@Param("cardNumber") String cardNumber, @Param("holderFirstName") String holderFirstName,
			@Param("holderLastName") String holderLastName, @Param("expiryMonth") String expiryMonth,
			@Param("expiryYear") String expiryYear, @Param("cvv") int cvv, @Param("cardUserID") int cardUserID);

}
