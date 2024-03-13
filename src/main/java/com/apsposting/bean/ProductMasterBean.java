
package com.apsposting.bean;

import java.io.Serializable;
import java.util.Date;

import com.apsposting.entity.AdminDetailDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductMasterBean implements Serializable{
	
	private Integer productId;
	
	@NotNull(message = "Please select category!")
	private Integer categoryId;	
	
	private String categoryName;
	
	@NotNull(message = "Please select category type!")
    private Integer categoryTypeId;	
	
	private String categoryTypeName;
	
	@NotNull(message = "Please enter category name!")
    @Size(min = 2, max = 30)
	private String productName;
	
	@NotNull(message = "Please Enter Barcode!")
	private String  Barcode;
	
	private String batchNo;
	
	@NotNull(message = "Please Enter MRP!")
	private Integer price;
	
	@NotNull(message = "Please Enter Stock!")
	private Integer stock;
	
	private String mfgDate;
	
	private String expDate;
	
	private String productDesc;
	
	private Integer isActive;	
	
	public AdminDetailDto adminDetailDto;	
	
	private Date entryDate;

	@Override
	public String toString() {
		return "ProductMasterBean [productId=" + productId + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", categoryTypeId=" + categoryTypeId + ", categoryTypeName=" + categoryTypeName
				+ ", productName=" + productName + ", Barcode=" + Barcode + ", batchNo=" + batchNo + ", price=" + price
				+ ", stock=" + stock + ", mfddate=" + mfgDate + ", expDate=" + expDate + ", productDesc=" + productDesc
				+ ", isActive=" + isActive + ", adminDetailDto=" + adminDetailDto + ", entryDate=" + entryDate + "]";
	}

	
}
