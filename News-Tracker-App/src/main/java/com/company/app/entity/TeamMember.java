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
@Table(name="team_member")
public class TeamMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_id")
	private int id;
	
	private String firstName;
	private String lastName;
	
	@Column(name="team_id")
	//@OneToMany(mappedBy = "teamMember")
	private int team;

}
