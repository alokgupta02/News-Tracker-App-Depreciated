package com.company.app.service;

import java.util.List;
import java.util.Optional;

import com.company.app.entity.TeamMember;

public interface TeamMemberService {
	
	// create
	public void addTeamMember(TeamMember teamMember);
	
	// read
	public List<TeamMember> getAllTeamMember();

	// update
	public Optional<TeamMember> findTeamMemberById(int id);

	// delete
	public void deleteTeamMember(int id);
	
	// get input team member list
	public List<TeamMember> findByTeam(int id);
	
}