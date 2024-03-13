package com.apsposting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsposting.entity.CategotyTypeMaster;

public interface CategoryTypeRepository extends JpaRepository<CategotyTypeMaster, Integer> {

	@Query(value = "SELECT * FROM category_type_mst WHERE category_type_name = ?1", nativeQuery = true)
	CategotyTypeMaster checkByCategoryName(String category_type_name);

	@Query(value = "SELECT * FROM category_type_mst WHERE is_active = 1 and user_id = ?1", nativeQuery = true)
	List<CategotyTypeMaster> getCategotyTypeMasterList(Integer userId);

}
