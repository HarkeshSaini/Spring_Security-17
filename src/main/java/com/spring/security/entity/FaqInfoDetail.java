package com.spring.security.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "FaqInfoDetail")
public class FaqInfoDetail {

	private String id;
	private String pageType;
	private String faQues;
	private String faqAns;
	private String url;
	private String faqStatus;
	private String modifyBy;
	public long postTime;
	public long updateTime;
	private String lang_code;
}
