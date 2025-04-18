package com.spring.security.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.ReviewInfoDetail;
import com.spring.security.interfaces.ReviewsInfoService;
import com.spring.security.interfaces.UserInfoService;
import com.spring.security.request.UserInfoRequest;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class RestControllers {

	private final UserInfoService infoService;
	
	private final ReviewsInfoService infoReviews;

	public RestControllers(UserInfoService infoService, ReviewsInfoService infoReviews) {
		this.infoService = infoService;
		this.infoReviews = infoReviews;
	}

	@PostMapping(value = "/addAdminUser")
	private ResponseEntity<Object> addAdminUser(@RequestBody UserInfoRequest request) {
		return this.infoService.addAdminUser(request);
	}
 
	@GetMapping(value = "/getAllReviews")
	private List<ReviewInfoDetail> getAllReviews(HttpServletRequest request){
		ResponseEntity<List<ReviewInfoDetail>> allReviews = this.infoReviews.getAllReviews(request);
		return allReviews.getBody();
	}
}
