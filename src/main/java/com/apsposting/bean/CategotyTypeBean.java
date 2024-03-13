
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
public class CategotyTypeBean implements Serializable{
	
	private Integer categotyTypeId;	
	
	@NotNull(message = "Please enter category type name!")
    @Size(min = 2, max = 30)
	private String categoryTypeName;	
	
	private String categoryTypeDesc;	
	
	private Integer isActive;	
	
	public AdminDetailDto adminDetailDto;	
	
	private Date entryDate;

	@Override
	public String toString() {
		return "CategotyTypeMaster [categotyTypeId=" + categotyTypeId + ", categoryTypeName=" + categoryTypeName
				+ ", categoryTypeDesc=" + categoryTypeDesc + ", isActive=" + isActive + ", adminDetailDto="
				+ adminDetailDto + ", entryDate=" + entryDate + "]";
	}
}
