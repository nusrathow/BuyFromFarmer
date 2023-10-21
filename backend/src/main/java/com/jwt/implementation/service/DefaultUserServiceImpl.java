//package com.jwt.implementation.service;
//
//import java.util.Collection;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//
//import com.jwt.implementation.dto.UserRegisteredDTO;
//import com.jwt.implementation.model.Role;
//import com.jwt.implementation.model.User;
//import com.jwt.implementation.repository.RoleRepository;
//import com.jwt.implementation.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class DefaultUserServiceImpl implements DefaultUserService{
//	@Autowired
//	private UserRepository userRepo;
//	@Autowired
//	private RoleRepository roleRepo;
//
//
//	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//		User user = userRepo.findByEmail(email);
//		if(user == null) {
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
//	}
//
//	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
//		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
//	}
//
//	@Override
//	public User save(UserRegisteredDTO userRegisteredDTO) {
//		Role role = new Role();
//		if(userRegisteredDTO.getRole().equals("USER"))
//			role = roleRepo.findByRole("USER");
//		else if(userRegisteredDTO.getRole().equals("ADMIN"))
//			role = roleRepo.findByRole("ADMIN");
//		User user = new User();
//		user.setEmail(userRegisteredDTO.getEmail_id());
//		user.setUserName(userRegisteredDTO.getName());
//		user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
//		user.setRole(role);
//
//		return userRepo.save(user);
//	}
//}