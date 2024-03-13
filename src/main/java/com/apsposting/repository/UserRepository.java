package com.apsposting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsposting.entity.AdminDetailDto;

public interface UserRepository extends JpaRepository<AdminDetailDto, Integer> {

	@Query(value = "SELECT * FROM admin_user_mst WHERE istr_email = ?1", nativeQuery = true)
	AdminDetailDto findByEmail(String istr_email);

}
