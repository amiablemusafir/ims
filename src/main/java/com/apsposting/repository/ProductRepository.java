package com.apsposting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsposting.entity.CategotyMaster;
import com.apsposting.entity.CategotyTypeMaster;
import com.apsposting.entity.ProductMaster;

public interface ProductRepository extends JpaRepository<ProductMaster, Integer> {

	@Query(value = "SELECT * FROM product_mst WHERE product_name = ?1", nativeQuery = true)
	ProductMaster checkByProductName(String product_name);

	@Query(value = "SELECT * FROM product_mst WHERE is_active = 1 and user_id = ?1", nativeQuery = true)
	List<ProductMaster> getProductMasterList(Integer userId);
	
	@Query(value = "SELECT * FROM product_mst WHERE is_active = 1 and user_id = ?1 and category_id = ?2", nativeQuery = true)
	List<ProductMaster> getProductMasterListByCategory(Integer userId, Integer categoryId);

}
