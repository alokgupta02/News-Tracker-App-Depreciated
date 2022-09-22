package com.company.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
@Table(name="reporter")
public class Reporter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reporter_id")
	private int id;
	
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	private String gender;
	private String district;
	private String state;
}
