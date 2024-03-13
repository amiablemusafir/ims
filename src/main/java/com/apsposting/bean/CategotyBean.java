
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
public class CategotyBean implements Serializable{
	
	private Integer categoryId;	
	
	@NotNull(message = "Please select category type!")
    private Integer categoryTypeId;	
	
	@NotNull(message = "Please enter category name!")
    @Size(min = 2, max = 30)
	private String categoryName;
	
	private String categoryTypeName;
	
	private String categoryDesc;	
	
	private Integer isActive;	
	
	public AdminDetailDto adminDetailDto;	
	
	private Date entryDate;

	@Override
	public String toString() {
		return "CategotyBean [categotyId=" + categoryId + ", categoryTypeId=" + categoryTypeId + ", categoryName="
				+ categoryName + ", categoryTypeName=" + categoryTypeName + ", categoryDesc=" + categoryDesc
				+ ", isActive=" + isActive + ", adminDetailDto=" + adminDetailDto + ", entryDate=" + entryDate + "]";
	}

}
