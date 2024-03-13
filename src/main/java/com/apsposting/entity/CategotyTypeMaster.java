
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name="category_type_mst")
public class CategotyTypeMaster implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="categoty_type_id") 
	private Integer categotyTypeId;
	
	@Column(name="category_type_name") 
	private String categoryTypeName;
	
	@Column(name="category_type_desc") 
	private String categoryTypeDesc;
	
	@Column(name="is_active") 
	private Integer isActive;
	
	@ManyToOne
	@JoinColumn(name = "user_id") 
	public AdminDetailDto adminDetailDto;
	
	@Column(name="entry_date") 
	private Date entryDate;

	@Override
	public String toString() {
		return "CategotyTypeMaster [categotyTypeId=" + categotyTypeId + ", categoryTypeName=" + categoryTypeName
				+ ", categoryTypeDesc=" + categoryTypeDesc + ", isActive=" + isActive + ", adminDetailDto="
				+ adminDetailDto + ", entryDate=" + entryDate + "]";
	}
}
