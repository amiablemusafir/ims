package com.apsposting.service;

import java.util.List;

import com.apsposting.entity.AdminDetailDto;

public interface UserService {
	
	AdminDetailDto findUserByEmail(String email);

    List<AdminDetailDto> findAllUsers();
}
