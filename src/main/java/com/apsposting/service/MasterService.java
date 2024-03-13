package com.apsposting.service;

import java.util.List;

import com.apsposting.bean.CategotyBean;
import com.apsposting.bean.CategotyTypeBean;
import com.apsposting.bean.ProductMasterBean;
import com.apsposting.entity.CategotyMaster;
import com.apsposting.entity.CategotyTypeMaster;
import com.apsposting.entity.ProductMaster;

public interface MasterService {
	
	 CategotyTypeMaster checkByCategoryTypeName(String category_type_name);
	 
	 List<CategotyTypeBean> getCategotyTypeMasterList(Integer user_id);
	
	 void saveCategoryTypeMaster(CategotyTypeBean categotyTypeBean);

	 CategotyTypeBean getCategotyTypeMasterById(Integer id);

	 void getInactiveCategotyTypeMasterById(Integer id);
	 
	 
	 CategotyMaster checkByCategoryName(String category_name, Integer category_type_id);
	 
	 List<CategotyBean> getCategotyMasterList(Integer user_id);
	 
	 List<CategotyBean> getCategotyMasterListByTypeId(Integer user_id, Integer categoryTypeId);
	
	 void saveCategoryMaster(CategotyBean categotyBean);

	 CategotyBean getCategotyMasterById(Integer id);

	 void getInactiveCategotyMasterById(Integer id);
	 
	 
	 
	 ProductMaster checkByProductName(String product_name);
	 
	 List<ProductMasterBean> getProductMasterList(Integer user_id);
	
	 void saveProductMaster(ProductMasterBean productBean);

	 ProductMasterBean getProductMasterById(Integer id);

	 void getInactiveProductMasterById(Integer id);
	 
	 List<ProductMasterBean> getProductMasterListByTypeId(Integer user_id, Integer categoryId);
		
	 
}
