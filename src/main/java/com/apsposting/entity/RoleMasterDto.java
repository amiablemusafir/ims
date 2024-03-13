
package com.apsposting.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity @Table(name="admin_role_mst")
public class RoleMasterDto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="inum_role_id") 
	private Integer inum_role_id;
	@Column(name="istr_role_name") 
	private String istr_role_name;
	@Column(name="istr_role_desc") 
	private String istr_role_desc;
	@Column(name="inum_is_active") 
	private Integer inum_is_active;
	@Column(name="idt_entry_date") 
	private Date idt_entry_date;
	
	@ManyToMany(mappedBy="roles")
	private List<AdminDetailDto> users;
	
	
	public Integer getInum_role_id() {
		return inum_role_id;
	}
	public void setInum_role_id(Integer inum_role_id) {
		this.inum_role_id = inum_role_id;
	}
	public String getIstr_role_name() {
		return istr_role_name;
	}
	public void setIstr_role_name(String istr_role_name) {
		this.istr_role_name = istr_role_name;
	}
	public String getIstr_role_desc() {
		return istr_role_desc;
	}
	public void setIstr_role_desc(String istr_role_desc) {
		this.istr_role_desc = istr_role_desc;
	}
	public Integer getInum_is_active() {
		return inum_is_active;
	}
	public void setInum_is_active(Integer inum_is_active) {
		this.inum_is_active = inum_is_active;
	}
	public Date getIdt_entry_date() {
		return idt_entry_date;
	}
	public void setIdt_entry_date(Date idt_entry_date) {
		this.idt_entry_date = idt_entry_date;
	}
	public List<AdminDetailDto> getUsers() {
		return users;
	}
	public void setUsers(List<AdminDetailDto> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return "RoleMasterDto [inum_role_id=" + inum_role_id + ", istr_role_name=" + istr_role_name
				+ ", istr_role_desc=" + istr_role_desc + ", inum_is_active=" + inum_is_active + ", idt_entry_date="
				+ idt_entry_date + ", users=" + users + "]";
	}
	
	
	
	
}
