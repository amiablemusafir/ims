
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
@Entity @Table(name="category_mst")
public class CategotyMaster implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="categoty_id") 
	private Integer categotyId;
	
	@ManyToOne
	@JoinColumn(name = "category_type_id") 
	public CategotyTypeMaster categotyTypeMaster;
	
	
	@Column(name="category_name") 
	private String categoryName;
	
	@Column(name="category_desc") 
	private String categoryDesc;
	
	@Column(name="is_active") 
	private Integer isActive;
	
	@ManyToOne
	@JoinColumn(name = "user_id") 
	public AdminDetailDto adminDetailDto;
	
	@Column(name="entry_date") 
	private Date entryDate;

	@Override
	public String toString() {
		return "CategotyMaster [categotyId=" + categotyId + ", categotyTypeMaster=" + categotyTypeMaster
				+ ", categoryName=" + categoryName + ", categoryDesc=" + categoryDesc + ", isActive=" + isActive
				+ ", adminDetailDto=" + adminDetailDto + ", entryDate=" + entryDate + "]";
	}

}
