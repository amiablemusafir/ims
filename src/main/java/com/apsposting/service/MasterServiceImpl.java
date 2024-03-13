package com.apsposting.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.apsposting.bean.CategotyBean;
import com.apsposting.bean.CategotyTypeBean;
import com.apsposting.bean.ProductMasterBean;
import com.apsposting.entity.AdminDetailDto;
import com.apsposting.entity.CategotyMaster;
import com.apsposting.entity.CategotyTypeMaster;
import com.apsposting.entity.ProductMaster;
import com.apsposting.repository.CategoryRepository;
import com.apsposting.repository.CategoryTypeRepository;
import com.apsposting.repository.ProductRepository;


@Service
public class MasterServiceImpl implements MasterService {

	CategoryTypeRepository categoryTypeRepository;
	CategoryRepository categoryRepository;
	ProductRepository productRepository; 
	
	@Autowired
	UserService userService;
	
	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);

    public MasterServiceImpl(CategoryTypeRepository categoryTypeRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryTypeRepository = categoryTypeRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	@Override
	public CategotyTypeMaster checkByCategoryTypeName(String category_type_name) {
		return categoryTypeRepository.checkByCategoryName(category_type_name);
	}
	
	@Override
	public void saveCategoryTypeMaster(CategotyTypeBean categotyTypeBean) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Logged in user email id ::::::::::::::::"+auth.getName());
        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
		CategotyTypeMaster categotyTypeMaster = new CategotyTypeMaster();
        
		categotyTypeMaster.setCategotyTypeId(categotyTypeBean.getCategotyTypeId());
		categotyTypeMaster.setCategoryTypeName(categotyTypeBean.getCategoryTypeName());
		categotyTypeMaster.setCategoryTypeDesc(categotyTypeBean.getCategoryTypeDesc());
        categotyTypeMaster.setAdminDetailDto(adminDetailDto);
		categotyTypeMaster.setEntryDate(new Date());
		categotyTypeMaster.setIsActive(1);
		
		categoryTypeRepository.save(categotyTypeMaster);
	}
	
	@Override
	public void getInactiveCategotyTypeMasterById(Integer id) {
		// TODO Auto-generated method stub
		CategotyTypeMaster categotyTypeMaster = categoryTypeRepository.getById(id);
		categotyTypeMaster.setIsActive(0);
		categotyTypeMaster.setEntryDate(new Date());
		
		categoryTypeRepository.save(categotyTypeMaster);
	}

	@Override
	public List<CategotyTypeBean> getCategotyTypeMasterList(Integer userId) {
		// TODO Auto-generated method stub
		List<CategotyTypeMaster> categotyTypeMasterList = categoryTypeRepository.getCategotyTypeMasterList(userId);
		return categotyTypeMasterList.stream()
                .map((categotyTypeMaster) -> mapToCategotyTypeBean(categotyTypeMaster))
                .collect(Collectors .toList());
	}

	@Override
	public CategotyTypeBean getCategotyTypeMasterById(Integer id) {
		// TODO Auto-generated method stub
		CategotyTypeMaster categotyTypeMaster = categoryTypeRepository.getById(id);		
		return mapToCategotyTypeBean(categotyTypeMaster);
	}
	
	
	@Override
	public void saveCategoryMaster(CategotyBean categotyBean) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
		CategotyMaster categotyMaster = new CategotyMaster();
        
		categotyMaster.setCategotyId(categotyBean.getCategoryId());
		
		CategotyTypeMaster categotyTypeMaster = categoryTypeRepository.getById(categotyBean.getCategoryTypeId());
		categotyMaster.setCategotyTypeMaster(categotyTypeMaster);
		categotyMaster.setCategoryName(categotyBean.getCategoryName());
		categotyMaster.setCategoryDesc(categotyBean.getCategoryDesc());
        categotyMaster.setAdminDetailDto(adminDetailDto);
		categotyMaster.setEntryDate(new Date());
		categotyMaster.setIsActive(1);
		
		categoryRepository.save(categotyMaster);
	}
	
	@Override
	public void getInactiveCategotyMasterById(Integer id) {
		// TODO Auto-generated method stub
		CategotyMaster categotyMaster = categoryRepository.getById(id);
		categotyMaster.setIsActive(0);
		categotyMaster.setEntryDate(new Date());
		
		categoryRepository.save(categotyMaster);
	}

	@Override
	public List<CategotyBean> getCategotyMasterList(Integer userId) {
		// TODO Auto-generated method stub
		List<CategotyMaster> categotyMasterList = categoryRepository.getCategotyMasterList(userId);
		return categotyMasterList.stream()
                .map((categotyMaster) -> mapToCategotyBean(categotyMaster))
                .collect(Collectors .toList());
	}
	
	@Override
	public List<CategotyBean> getCategotyMasterListByTypeId(Integer userId, Integer categoryTypeId) {
		// TODO Auto-generated method stub
		List<CategotyMaster> categotyMasterList = categoryRepository.getCategotyMasterListByTypeId(userId, categoryTypeId);
		return categotyMasterList.stream().map((categotyMaster) -> mapToCategotyBean(categotyMaster))
		                .collect(Collectors .toList());
	}
	

	@Override
	public CategotyBean getCategotyMasterById(Integer id) {
		// TODO Auto-generated method stub
		CategotyMaster categotyMaster = categoryRepository.getById(id);		
		return mapToCategotyBean(categotyMaster);
	}
	
	@Override
	public CategotyMaster checkByCategoryName(String category_name, Integer category_type_id) {
		return categoryRepository.checkByCategoryName(category_name, category_type_id);
	}
	
	@Override
	public ProductMaster checkByProductName(String product_name) {
		// TODO Auto-generated method stub
		return productRepository.checkByProductName(product_name);
	}

	@Override
	public List<ProductMasterBean> getProductMasterList(Integer user_id) {
		// TODO Auto-generated method stub
		List<ProductMaster > productMasterList = productRepository.getProductMasterList(user_id);
		return productMasterList.stream()
                .map((productMaster) -> mapToProductBean(productMaster))
                .collect(Collectors .toList());
	}

	@Override
	public void saveProductMaster(ProductMasterBean productBean) {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
		ProductMaster productMaster = new ProductMaster();
        
		productMaster.setProductId(productBean.getProductId());
		
		CategotyMaster categotyMaster = categoryRepository.getById(productBean.getCategoryId());
		productMaster.setCategotyTypeMaster(categotyMaster.getCategotyTypeMaster());
		productMaster.setCategotyMaster(categotyMaster);		
		productMaster.setProductName(productBean.getProductName());
		productMaster.setBarcode(productBean.getBarcode());
		productMaster.setBatchNo(productBean.getBatchNo());		
		productMaster.setPrice(productBean.getPrice());
		productMaster.setStock(productBean.getStock());		
		
		try {
			productMaster.setMfgDate(formatter.parse(productBean.getMfgDate()));
			productMaster.setExpDate(formatter.parse(productBean.getExpDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		productMaster.setProductDesc(productBean.getProductDesc());		
		productMaster.setAdminDetailDto(adminDetailDto);
		productMaster.setEntryDate(new Date());
		productMaster.setIsActive(1);
		
		productRepository.save(productMaster);		
	}

	@Override
	public ProductMasterBean getProductMasterById(Integer id) {
		// TODO Auto-generated method stub
		ProductMaster productMaster = productRepository.getById(id);		
		return mapToProductBean(productMaster);
	}

	@Override
	public void getInactiveProductMasterById(Integer id) {
		// TODO Auto-generated method stub
		ProductMaster productMaster = productRepository.getById(id);
		
		productMaster.setEntryDate(new Date());
		productMaster.setIsActive(0);
		
		productRepository.save(productMaster);
	}

	@Override
	public List<ProductMasterBean> getProductMasterListByTypeId(Integer user_id, Integer categoryId) {
		// TODO Auto-generated method stub
		List<ProductMaster> productMasterList = productRepository.getProductMasterListByCategory(user_id, categoryId);
		return productMasterList.stream()
                .map((productMaster) -> mapToProductBean(productMaster))
                .collect(Collectors .toList());
	}
	
	
	private CategotyTypeBean mapToCategotyTypeBean(CategotyTypeMaster categotyTypeMaster){
		CategotyTypeBean categotyTypeBean = new CategotyTypeBean();
		categotyTypeBean.setAdminDetailDto(categotyTypeMaster.getAdminDetailDto());
		categotyTypeBean.setCategotyTypeId(categotyTypeMaster.getCategotyTypeId());
		categotyTypeBean.setCategoryTypeName(categotyTypeMaster.getCategoryTypeName());
		categotyTypeBean.setCategoryTypeDesc(categotyTypeMaster.getCategoryTypeDesc());
		categotyTypeBean.setEntryDate(categotyTypeMaster.getEntryDate());
		categotyTypeBean.setIsActive(categotyTypeMaster.getIsActive());
		
	    return categotyTypeBean;
	}
	
	private CategotyBean mapToCategotyBean(CategotyMaster categotyMaster){
		CategotyBean categotyBean = new CategotyBean();
				
		categotyBean.setAdminDetailDto(categotyMaster.getAdminDetailDto());
		categotyBean.setCategoryId(categotyMaster.getCategotyId());
		categotyBean.setCategoryTypeId(categotyMaster.getCategotyTypeMaster().getCategotyTypeId());
		categotyBean.setCategoryTypeName(categotyMaster.getCategotyTypeMaster().getCategoryTypeName());
		categotyBean.setCategoryName(categotyMaster.getCategoryName());
		categotyBean.setCategoryDesc(categotyMaster.getCategoryDesc());
		categotyBean.setEntryDate(categotyMaster.getEntryDate());
		categotyBean.setIsActive(categotyMaster.getIsActive());
		
	    return categotyBean;
	}
	
	private ProductMasterBean mapToProductBean(ProductMaster productMaster){
		ProductMasterBean productBean = new ProductMasterBean();
				
		productBean.setProductId(productMaster.getProductId());		
		productBean.setCategoryId(productMaster.getCategotyMaster().getCategotyId());
		productBean.setCategoryName(productMaster.getCategotyMaster().getCategoryName());		
		productBean.setCategoryTypeId (productMaster.getCategotyTypeMaster().getCategotyTypeId());
		productBean.setCategoryTypeName(productMaster.getCategotyTypeMaster().getCategoryTypeName());		
		productBean.setProductName(productMaster.getProductName());
		productBean.setBarcode(productMaster.getBarcode());
		productBean.setBatchNo(productMaster.getBatchNo());		
		productBean.setPrice(productMaster.getPrice());
		productBean.setStock(productMaster.getStock());		
		
		if(productMaster.getMfgDate() != null)
		productBean.setMfgDate(formatter.format(productMaster.getMfgDate()));
		System.out.println("MFG======="+productBean.getMfgDate());
		
		if(productMaster.getExpDate() != null)
		productBean.setExpDate(formatter.format(productMaster.getExpDate()));
		System.out.println("Exp======="+productBean.getExpDate());
		
		productBean.setProductDesc(productMaster.getProductDesc());		
		productBean.setAdminDetailDto(productMaster.getAdminDetailDto());
		productBean.setEntryDate(productMaster.getEntryDate());
		productBean.setIsActive(productMaster.getIsActive());
		
	    return productBean;
	}

	
}
