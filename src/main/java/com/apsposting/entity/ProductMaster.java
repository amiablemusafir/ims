
package com.apsposting.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name="product_mst")
public class ProductMaster implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id") 
	private Integer productId;
	
	@ManyToOne
	@JoinColumn(name = "category_type_id") 
	public CategotyTypeMaster categotyTypeMaster;
	
	@ManyToOne
	@JoinColumn(name = "category_id") 
	public CategotyMaster categotyMaster;
		
	@Column(name="product_name") 
	private String productName;
	
	@Column(name="barcode") 
	private String  Barcode;
	
	@Column(name="batch_no") 
	private String batchNo;
	
	@Column(name="price") 
	private Integer price;
	
	@Column(name="stock") 
	private Integer stock;
	
	@Column(name="mfg_date") 
	private Date mfgDate;
	
	@Column(name="exp_date") 
	private Date expDate;
	
	@Column(name="product_desc") 
	private String productDesc;
	
	@Column(name="is_active") 
	private Integer isActive;
	
	@ManyToOne
	@JoinColumn(name = "user_id") 
	public AdminDetailDto adminDetailDto;
	
	@Column(name="entry_date") 
	private Date entryDate;

	@Override
	public String toString() {
		return "ProductMaster [productId=" + productId + ", categotyTypeMaster=" + categotyTypeMaster
				+ ", categotyMaster=" + categotyMaster + ", productName=" + productName + ", Barcode=" + Barcode
				+ ", batchNo=" + batchNo + ", price=" + price + ", stock=" + stock + ", mfgDate=" + mfgDate
				+ ", expDate=" + expDate + ", productDesc=" + productDesc + ", isActive=" + isActive
				+ ", adminDetailDto=" + adminDetailDto + ", entryDate=" + entryDate + "]";
	}
}
