package com.apsposting.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apsposting.entity.AdminDetailDto;
import com.apsposting.repository.RoleRepository;
import com.apsposting.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    

    @Override
    public AdminDetailDto findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<AdminDetailDto> findAllUsers() {
        List<AdminDetailDto> users = userRepository.findAll();
        return users;
    }
}
