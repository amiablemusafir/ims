package com.apsposting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsposting.entity.CategotyMaster;
import com.apsposting.entity.CategotyTypeMaster;

public interface CategoryRepository extends JpaRepository<CategotyMaster, Integer> {

	@Query(value = "SELECT * FROM category_mst WHERE category_name = ?1 and category_type_id = ?2", nativeQuery = true)
	CategotyMaster checkByCategoryName(String category_name, Integer category_type_id);

	@Query(value = "SELECT * FROM category_mst WHERE is_active = 1 and user_id = ?1", nativeQuery = true)
	List<CategotyMaster> getCategotyMasterList(Integer userId);
	
	@Query(value = "SELECT * FROM category_mst WHERE is_active = 1 and user_id = ?1 and category_type_id = ?2", nativeQuery = true)
	List<CategotyMaster> getCategotyMasterListByTypeId(Integer userId, Integer categoryTypeId);

}
