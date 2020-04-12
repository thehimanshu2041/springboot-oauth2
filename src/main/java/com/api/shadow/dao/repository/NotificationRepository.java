package com.api.shadow.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.shadow.entity.NotificationEntity;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

	@Query("SELECT me FROM NotificationEntity as me WHERE me.notifUserID = :notifUserID AND me.notifIsDeleted = :notifIsDeleted ORDER BY me.notifCreatedDateTime")
	List<NotificationEntity> getNotificationList(@Param("notifUserID") int notifUserID,
			@Param("notifIsDeleted") String notifIsDeleted);
}
