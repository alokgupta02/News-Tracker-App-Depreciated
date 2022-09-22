package com.company.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.app.entity.TeamMember;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {

	List<TeamMember> findByTeam(int id);
}