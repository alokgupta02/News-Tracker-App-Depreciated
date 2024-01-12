package com.company.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
@Table(name="team_member")
public class TeamMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_id")
	private int id;

	@NotNull @NotEmpty @NotBlank
	@Column(name="first_name")
	@Pattern(regexp = "[a-zA-Z]")
	private String firstName;

	@NotNull @NotEmpty @NotBlank
	@Pattern(regexp = "[a-zA-Z]")
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="team_id")
	//@OneToMany(mappedBy = "teamMember")
	private int team;

}
