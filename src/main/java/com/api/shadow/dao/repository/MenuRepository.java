package com.api.shadow.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.shadow.entity.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

	@Query("SELECT me FROM MenuEntity as me WHERE me.menuID = me.menuParentID AND me.menuIsAuthReq = :authReq AND me.menuIsDeleted = :menuIsDeleted AND me.menuIsAdmin = :menuIsAdmin ORDER BY me.menuPriority")
	List<MenuEntity> findMenuList(@Param("authReq") String authReq, @Param("menuIsDeleted") String menuIsDeleted,
			@Param("menuIsAdmin") String menuIsAdmin);

	@Query("SELECT me FROM MenuEntity as me WHERE me.menuID != me.menuParentID AND me.menuParentID = :menuID AND me.menuIsAuthReq = :authReq AND me.menuIsDeleted = :menuIsDeleted AND me.menuIsAdmin = :menuIsAdmin ORDER BY me.menuPriority")
	List<MenuEntity> findSubMenuList(@Param("menuID") int menuID, @Param("authReq") String authReq,
			@Param("menuIsDeleted") String menuIsDeleted, @Param("menuIsAdmin") String menuIsAdmin);

	@Query("SELECT me FROM MenuEntity as me WHERE me.menuID = me.menuParentID AND me.menuIsAuthReq = :authReq AND me.menuIsDeleted = :menuIsDeleted AND me.menuIsAdmin = :menuIsAdmin ORDER BY me.menuPriority")
	List<MenuEntity> findAdminMenuList(@Param("authReq") String authReq, @Param("menuIsDeleted") String menuIsDeleted,
			@Param("menuIsAdmin") String menuIsAdmin);

	@Query("SELECT me FROM MenuEntity as me WHERE me.menuID != me.menuParentID AND me.menuParentID = :menuID AND me.menuIsAuthReq = :authReq AND me.menuIsDeleted = :menuIsDeleted AND me.menuIsAdmin = :menuIsAdmin ORDER BY me.menuPriority")
	List<MenuEntity> findAdminSubMenuList(@Param("menuID") int menuID, @Param("authReq") String authReq,
			@Param("menuIsDeleted") String menuIsDeleted, @Param("menuIsAdmin") String menuIsAdmin);

	/* Get All Parent Menu List */
	@Query("SELECT me FROM MenuEntity as me WHERE me.menuID = me.menuParentID ORDER BY me.menuPriority")
	List<MenuEntity> findAllMenuList();

	/* Get All Child Menu List */
	@Query("SELECT me FROM MenuEntity as me WHERE me.menuID != me.menuParentID AND me.menuParentID = :menuID ORDER BY me.menuPriority")
	List<MenuEntity> findAllSubMenuList(@Param("menuID") int menuID);

	MenuEntity findBymenuID(int menuID);
}