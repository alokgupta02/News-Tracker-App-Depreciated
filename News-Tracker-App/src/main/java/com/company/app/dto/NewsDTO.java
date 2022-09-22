package com.company.app.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class NewsDTO {
	
	private int id;
	private String slug;
	private String format;
	private String state;
	private String district;
	private int input;
	private int output;
	private String priority;
	private String status;
	private String remarks;
	private int reporterId;
	private Timestamp last_update;

}
