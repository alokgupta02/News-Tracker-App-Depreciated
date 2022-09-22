package com.company.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.entity.TeamMember;
import com.company.app.repository.TeamMemberRepository;

@Service
public class TeamMemberServiceImpl implements TeamMemberService{

	@Autowired
	private TeamMemberRepository teamMemberRepository;

	@Override
	public void addTeamMember(TeamMember teamMember) {
		this.teamMemberRepository.save(teamMember);
	}

	@Override
	public List<TeamMember> getAllTeamMember() {
		return teamMemberRepository.findAll();
	}

	@Override
	public Optional<TeamMember> findTeamMemberById(int id) {
		return teamMemberRepository.findById(id);
	}

	@Override
	public void deleteTeamMember(int id) {
		this.teamMemberRepository.deleteById(id);
		
	}

	@Override
	public List<TeamMember> findByTeam(int id) {
		return teamMemberRepository.findByTeam(id);
	}
}