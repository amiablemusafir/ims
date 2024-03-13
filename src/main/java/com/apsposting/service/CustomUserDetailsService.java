package com.apsposting.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apsposting.entity.AdminDetailDto;
import com.apsposting.entity.RoleMasterDto;
import com.apsposting.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException
    {
    	AdminDetailDto userDetails = userRepository.findByEmail(user_name);
    	if (userDetails != null) {
    		 return new org.springframework.security.core.userdetails.User(userDetails.getIstr_email(),
        			 passwordEncoder.encode(userDetails.getIstr_password()),
                    mapRolesToAuthorities(userDetails.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
       
    	
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <RoleMasterDto> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream().map(role -> new SimpleGrantedAuthority(role.getIstr_role_name()))
                .collect(Collectors.toList());
        return mapRoles;
    }
    
    
    //Below line of code is only for testing purpose
    public static void main(String[] args) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "12345678";
        String encodedPassword = passwordEncoder.encode(password);

        System.out.println();
        System.out.println("Password is         : " + password);
        System.out.println("Encoded Password is : " + encodedPassword);
        System.out.println();

        boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
        System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
	}
}
