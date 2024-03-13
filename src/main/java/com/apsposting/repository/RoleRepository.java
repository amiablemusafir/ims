package com.apsposting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsposting.entity.RoleMasterDto;

public interface RoleRepository extends JpaRepository<RoleMasterDto, Integer> {

	@Query(value = "SELECT * FROM RoleMasterDto WHERE istr_role_name = ?1", nativeQuery = true)
	RoleMasterDto findByName(String role_name);
}