package com.apsposting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apsposting.bean.CategotyBean;
import com.apsposting.bean.CategotyTypeBean;
import com.apsposting.bean.ProductMasterBean;
import com.apsposting.entity.AdminDetailDto;
import com.apsposting.entity.CategotyMaster;
import com.apsposting.entity.CategotyTypeMaster;
import com.apsposting.entity.ProductMaster;
import com.apsposting.service.MasterService;
import com.apsposting.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/master")
public class MasterController  {

	@Value("${spring.application.name}")
	String appName;

	private UserService userService;
	private MasterService masterService;
	

    public MasterController(UserService userService, MasterService masterService) {
        this.userService = userService;
        this.masterService = masterService;       
    }

    /** Category Type module - Started**/
    @GetMapping("/addcategorytypemaster")
    public String addcategorytypemaster(Model model){
    	CategotyTypeBean categorytypebean = new CategotyTypeBean();
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Logged in user email id ::::::::::::::::"+auth.getName());
        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
    	
    	List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
    	
    	model.addAttribute("categorytypebean", categorytypebean);
    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
    	model.addAttribute("appName", appName);
        return "categorytypemaster";
    }
    
    @PostMapping("/savecategorytypemaster")
    public String registration(@Valid @ModelAttribute("categorytypebean") CategotyTypeBean categotyTypeBean, BindingResult bindResult, Model model){
    	
    	CategotyTypeMaster existingCategory = masterService.checkByCategoryTypeName(categotyTypeBean.getCategoryTypeName());
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Logged in user email id ::::::::::::::::"+auth.getName());
        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
    	
    	List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
    	
    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
    	if(categotyTypeBean.getCategotyTypeId() == null) {
    	    if(existingCategory != null && existingCategory.getCategoryTypeName() != null && !existingCategory.getCategoryTypeName().isEmpty()){
    	    	bindResult.rejectValue("categoryTypeName", null, "Data already exist for "+existingCategory.getCategoryTypeName()+"!");
	        }
	
	        if(bindResult.hasErrors()){
	            model.addAttribute("categotytypebean", categotyTypeBean);
	            return "categorytypemaster";
	        }
    	}

        masterService.saveCategoryTypeMaster(categotyTypeBean);
        return "redirect:/master/addcategorytypemaster?success";
    }
    
    @GetMapping("/editcategorytypemaster/{id}")
    public String editcategorytypemaster(@PathVariable Integer id, Model model){
    	CategotyTypeBean categorytypebean = new CategotyTypeBean();
    	categorytypebean = masterService.getCategotyTypeMasterById(id);
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
    	
    	List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
    	
    	model.addAttribute("categorytypebean", categorytypebean);
    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
    	model.addAttribute("appName", appName);
        return "categorytypemaster";
    }
    
    @GetMapping("/deletecategorytypemaster/{id}")
    public String deletecategorytypemaster(@PathVariable Integer id, Model model){        	
    	masterService.getInactiveCategotyTypeMasterById(id);
    	return "redirect:/master/addcategorytypemaster?delete";
    }
    /** Category Type Module - Ended **/
    
    /** Category Module - Started **/
	@GetMapping("/addcategorymaster")
    public String addCategory(Model model){
		CategotyBean categorybean = new CategotyBean();
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
        
        List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
    	
    	List<CategotyBean> categotyBeanList = new ArrayList<CategotyBean>();
    	categotyBeanList = masterService.getCategotyMasterList(adminDetailDto.getInum_user_id());
    	
    	model.addAttribute("categorybean", categorybean);
    	model.addAttribute("categotybeanlist", categotyBeanList);
    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
    	model.addAttribute("appName", appName);
        return "categorymaster";
    }
	
	@PostMapping("/savecategorymaster")
    public String saveCategoryMaster(@Valid @ModelAttribute("categorytypebean") CategotyBean categotyBean, BindingResult bindResult, Model model){
    	
    	CategotyMaster existingCategory = masterService.checkByCategoryName(categotyBean.getCategoryName(), categotyBean.getCategoryTypeId());
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
    	
        List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
    	
    	List<CategotyBean> categotyBeanList = new ArrayList<CategotyBean>();
    	categotyBeanList = masterService.getCategotyMasterList(adminDetailDto.getInum_user_id());
    	
    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
    	model.addAttribute("categotybeanlist", categotyBeanList);
    	model.addAttribute("appName", appName);
    	if(categotyBean.getCategoryId() == null) {
    	    if(existingCategory != null && existingCategory.getCategoryName() != null && !existingCategory.getCategoryName().isEmpty()){
    	    	bindResult.rejectValue("categoryName", null, "Data already exist for "+existingCategory.getCategoryName()+"!");
	        }
	
	        if(bindResult.hasErrors()){
	            model.addAttribute("categotybean", categotyBean);
	            return "categorymaster";
	        }
    	}

        masterService.saveCategoryMaster(categotyBean);
        return "redirect:/master/addcategorymaster?success";
    }
	
	 @GetMapping("/editcategorymaster/{id}")
	    public String editcategorymaster(@PathVariable Integer id, Model model){
	    	CategotyBean categorybean = new CategotyBean();
	    	categorybean = masterService.getCategotyMasterById(id);
	    	
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
	    	
	        List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
	    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
	    	
	    	List<CategotyBean> categotyBeanList = new ArrayList<CategotyBean>();
	    	categotyBeanList = masterService.getCategotyMasterList(adminDetailDto.getInum_user_id());
	    	
	    	model.addAttribute("categorybean", categorybean);
	    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
	    	model.addAttribute("categotybeanlist", categotyBeanList);
	    	model.addAttribute("appName", appName);
	        return "categorymaster";
	    }
	    
	    @GetMapping("/deletecategorymaster/{id}")
	    public String deletecategorymaster(@PathVariable Integer id, Model model){        	
	    	masterService.getInactiveCategotyMasterById(id);
	    	return "redirect:/master/addcategorymaster?delete";
	    }
	    
	    /** Product module - Started**/
	    @GetMapping("/addproductmaster")
	    public String addproductmaster(Model model){
	    	ProductMasterBean productMasterbean = new ProductMasterBean();
	    	
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
	        
	        List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
	    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
	    	
	    	List<CategotyBean> categotyBeanList = new ArrayList<CategotyBean>();
	    	categotyBeanList = masterService.getCategotyMasterList(adminDetailDto.getInum_user_id());
	    	
	    	List<ProductMasterBean> productMasterBeanList = new ArrayList<ProductMasterBean>(); 
	    	productMasterBeanList = masterService.getProductMasterList(adminDetailDto.getInum_user_id());
	    		    	
	    	model.addAttribute("productmasterbean", productMasterbean);
	    	model.addAttribute("categotybeanlist", categotyBeanList);
	    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
	    	model.addAttribute("productmasterbeanlist", productMasterBeanList);
	    	model.addAttribute("appName", appName);
	        return "productmaster";
	    }
	    
		
	    @PostMapping("/saveproductmaster") 
	    public String saveCategoryMaster(@Valid @ModelAttribute("productmasterbean") ProductMasterBean productMasterBean, BindingResult bindResult, Model model){
		  
	    	ProductMaster existingProduct = masterService.checkByProductName(productMasterBean.getProductName());
		  
	    	if(productMasterBean.getProductId() == null) { 
	    		if(existingProduct != null && existingProduct.getProductName() != null && !existingProduct.getProductName().isEmpty()){
	    			bindResult.rejectValue("categoryName", null,"Data already exist for "+existingProduct.getProductName()+"!"); 
	    		}    		
	    	}
	    	
	    	if(bindResult.hasErrors()){ 
	    		
	    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    	AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
			  
	    		List<ProductMasterBean> productMasterBeanList = new ArrayList<ProductMasterBean>(); 
		    	productMasterBeanList = masterService.getProductMasterList(adminDetailDto.getInum_user_id());
		    	
		    	List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
		    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
		    	
		    	List<CategotyBean> categotyBeanList = new ArrayList<CategotyBean>();
		    	categotyBeanList = masterService.getCategotyMasterList(adminDetailDto.getInum_user_id());
		    	
			   	model.addAttribute("categotybeanlist", categotyBeanList);
		    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
		    	model.addAttribute("productmasterbeanlist", productMasterBeanList);
		    	model.addAttribute("appName", appName);
    			model.addAttribute("productmasterbean", productMasterBean);    	    	
    			return "productmaster"; 
    		} 
		  
	    	masterService.saveProductMaster(productMasterBean); 
	    	return "redirect:/master/addproductmaster?success"; 
	    }
	    
	    @GetMapping("/editproductmaster/{id}")
	    public String editproductmaster(@PathVariable Integer id, Model model){
	    	ProductMasterBean productMasterBean = new ProductMasterBean();
	    	productMasterBean = masterService.getProductMasterById(id);
	    	
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	AdminDetailDto adminDetailDto = userService.findUserByEmail(auth.getName());
		  
    		List<ProductMasterBean> productMasterBeanList = new ArrayList<ProductMasterBean>(); 
	    	productMasterBeanList = masterService.getProductMasterList(adminDetailDto.getInum_user_id());
	    	
	    	List<CategotyTypeBean> categotyTypeBeanList = new ArrayList<CategotyTypeBean>();
	    	categotyTypeBeanList = masterService.getCategotyTypeMasterList(adminDetailDto.getInum_user_id());
	    	
	    	List<CategotyBean> categotyBeanList = new ArrayList<CategotyBean>();
	    	categotyBeanList = masterService.getCategotyMasterList(adminDetailDto.getInum_user_id());
	    	
		   	model.addAttribute("categotybeanlist", categotyBeanList);
	    	model.addAttribute("categotytypebeanlist", categotyTypeBeanList);
	    	model.addAttribute("productmasterbeanlist", productMasterBeanList);
	    	model.addAttribute("appName", appName);
			model.addAttribute("productmasterbean", productMasterBean);    	    	
			return "productmaster"; 
	    }
	    
	    @GetMapping("/deleteproductmaster/{id}")
	    public String deleteproductmaster(@PathVariable Integer id, Model model){        	
	    	masterService.getInactiveProductMasterById(id);
	    	return "redirect:/master/addproductmaster?delete";
	    }
		 

}
