package com.spring.security.entity;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class UserInfoDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String phone;
	private long dateOfBirth;
	private long createDate;
	private long updateDate;
	private String role;
	private int age;
	private int totalUser;
	private String address;
	private int numOfRoom;
	private String comment;
	private String status;
	private boolean emailVerified;
	private String another_phone;
	private String imgUrl;
	private long aadhar_number;
	private String gender;
	private String country;
	private String state;
	private String zipCode;

	public UserInfoDetail(User user) {
		this.email = user.getUsername();
		this.password = user.getPassword();
		this.role = user.getAuthorities().stream().map(x -> x.getAuthority()).collect(Collectors.joining(", "));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Set.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
