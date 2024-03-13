package com.apsposting.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.relation.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "admin_user_mst")
public class AdminDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "inum_user_id") public Integer inum_user_id;
	@Column(name = "istr_login_id") public String istr_login_id;
	@Column(name = "istr_password") public String istr_password;
	@Column(name = "istr_dob") public String istr_dob;
	@Column(name = "istr_secrete_question") public String istr_secrete_question;
	@Column(name = "istr_answer") public String istr_answer;
	@Column(name = "istr_user_type") public String istr_user_type;
	@Column(name = "istr_user_name") public String istr_user_name;
	@Column(name = "istr_email") public String istr_email;
	@Column(name = "istr_designation") public String istr_designation;
	@Column(name = "istr_department") public String istr_department;
	@Column(name = "istr_address") public String istr_address;
	@Column(name = "istr_unit_name") public String istr_unit_name;
	@Column(name = "istr_unit_code") public String istr_unit_code;
	@Column(name = "istr_terminal") public String istr_terminal;
	@Column(name = "istr_mobile_no") public String istr_mobile_no;
	@Column(name = "inum_account_status") public Integer inum_account_status;
	@Column(name = "inum_is_rejected") public Integer inum_is_rejected;
	@Column(name = "inum_is_verified") public Integer inum_is_verified;
	@Column(name = "inum_is_active") public Integer inum_is_active;
	@Column(name = "inum_role_id") public Integer inum_role_id;
	@Column(name = "idt_entry_date") public Date idt_entry_date;
	
	 
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
	          name="users_roles",
	          joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="inum_user_id")},
	          inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="inum_role_id")})
	private List<RoleMasterDto> roles = new ArrayList<RoleMasterDto>();
	
	@Column(name="istr_dopt")public String istr_dopt;
	
	
	public String getIstr_unit_name() {
		return istr_unit_name;
	}
	public void setIstr_unit_name(String istr_unit_name) {
		this.istr_unit_name = istr_unit_name;
	}
	public String getIstr_unit_code() {
		return istr_unit_code;
	}
	public void setIstr_unit_code(String istr_unit_code) {
		this.istr_unit_code = istr_unit_code;
	}
	public String getIstr_terminal() {
		return istr_terminal;
	}
	public void setIstr_terminal(String istr_terminal) {
		this.istr_terminal = istr_terminal;
	}
	public String getIstr_dopt() {
		return istr_dopt;
	}
	public void setIstr_dopt(String istr_dopt) {
		this.istr_dopt = istr_dopt;
	}
	public Integer getInum_user_id() {
		return inum_user_id;
	}
	public void setInum_user_id(Integer inum_user_id) {
		this.inum_user_id = inum_user_id;
	}
	public String getIstr_login_id() {
		return istr_login_id;
	}
	public String getIstr_department() {
		return istr_department;
	}
	public void setIstr_department(String istr_department) {
		this.istr_department = istr_department;
	}
	public void setIstr_login_id(String istr_login_id) {
		this.istr_login_id = istr_login_id;
	}
	public String getIstr_password() {
		return istr_password;
	}
	public void setIstr_password(String istr_password) {
		this.istr_password = istr_password;
	}
	public String getIstr_secrete_question() {
		return istr_secrete_question;
	}
	public void setIstr_secrete_question(String istr_secrete_question) {
		this.istr_secrete_question = istr_secrete_question;
	}
	public String getIstr_answer() {
		return istr_answer;
	}
	public void setIstr_answer(String istr_answer) {
		this.istr_answer = istr_answer;
	}
	public String getIstr_user_type() {
		return istr_user_type;
	}
	public void setIstr_user_type(String istr_user_type) {
		this.istr_user_type = istr_user_type;
	}
	public String getIstr_dob() {
		return istr_dob;
	}
	public void setIstr_dob(String istr_dob) {
		this.istr_dob = istr_dob;
	}
	public String getIstr_user_name() {
		return istr_user_name;
	}
	public void setIstr_user_name(String istr_user_name) {
		this.istr_user_name = istr_user_name;
	}
	public String getIstr_email() {
		return istr_email;
	}
	public void setIstr_email(String istr_email) {
		this.istr_email = istr_email;
	}

	public String getIstr_designation() {
		return istr_designation;
	}
	public void setIstr_designation(String istr_designation) {
		this.istr_designation = istr_designation;
	}
	public Integer getInum_account_status() {
		return inum_account_status;
	}
	public void setInum_account_status(Integer inum_account_status) {
		this.inum_account_status = inum_account_status;
	}
	public Integer getInum_is_rejected() {
		return inum_is_rejected;
	}
	public void setInum_is_rejected(Integer inum_is_rejected) {
		this.inum_is_rejected = inum_is_rejected;
	}
	public Integer getInum_is_verified() {
		return inum_is_verified;
	}
	public void setInum_is_verified(Integer inum_is_verified) {
		this.inum_is_verified = inum_is_verified;
	}
	public String getIstr_address() {
		return istr_address;
	}
	public void setIstr_address(String istr_address) {
		this.istr_address = istr_address;
	}
	public String getIstr_mobile_no() {
		return istr_mobile_no;
	}
	public void setIstr_mobile_no(String istr_mobile_no) {
		this.istr_mobile_no = istr_mobile_no;
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
	public Integer getInum_role_id() {
		return inum_role_id;
	}
	public void setInum_role_id(Integer inum_role_id) {
		this.inum_role_id = inum_role_id;
	}
	public List<RoleMasterDto> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleMasterDto> roles) {
		this.roles = roles;
	}
	
	
	
}
