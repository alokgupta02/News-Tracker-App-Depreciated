package com.company.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.app.entity.TeamMember;

@SpringBootTest
@Disabled
class TeamMemberRepositoryTest {

	@Autowired
	private TeamMemberRepository teamMemberRepository;

	TeamMember teamMember = new TeamMember(1, "Jai", "Dev", 1);

	@Test
	void Given_Create_New_Member_When_findByTeam_is_called_Then_return_list_with_new_member() {
		teamMemberRepository.save(teamMember);
		List<TeamMember> memberList1 = teamMemberRepository.findByTeam(1);
		assertEquals(memberList1.size(), 1);
	}

	@Test
	void Given_New_Member_When_findByTeam_is_called_Then_return_list_with_new_member() {
		teamMemberRepository.save(teamMember);
		List<TeamMember> memberList1 = teamMemberRepository.findByTeam(1);
		assertNotEquals(memberList1.size(), 3);
	}

	@Test
	void CheckingName() {
		teamMemberRepository.save(teamMember);
		List<TeamMember> memberList1 = teamMemberRepository.findByTeam(1);
		assertEquals(memberList1.get(0).getFirstName(), "Jai");
	}

}
