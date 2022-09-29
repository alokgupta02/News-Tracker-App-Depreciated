package com.company.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.app.entity.TeamMember;
import com.company.app.repository.TeamMemberRepository;

@ExtendWith(MockitoExtension.class)
class TeamMemberServiceTest {

	@InjectMocks
	private TeamMemberServiceImpl teamMemberService;

	@Mock
	private TeamMemberRepository teamMemberRepository;

	private TeamMember member;

	@BeforeEach
	public void setup() {
		member = TeamMember.builder().id(1).firstName("Amit").lastName("Jaiswal").team(1).build();
	}

	// JUnit test for saveTeamMember method
	/*
	 * @DisplayName("JUnit test for addTeamMember method")
	 * 
	 * @Test public void
	 * given_TeamMemberObj_when_addTeamMember_then_Return_TeamMemberObj() {
	 * Mockito.when(teamMemberRepository.save(member)) .thenReturn(member);
	 * TeamMember actual =
	 * teamMemberService.getAllTeamMember(List.of(member.getFirstName()));
	 * System.out.println(member); assertThat(member).isNotNull(); }
	 */

	/*
	 * @Test void testGetAllTeamMember() { when(teamMemberRepository.findAll())
	 * .thenReturn(Stream.of(new TeamMember(1, "Amit", "Singh", 3), new
	 * TeamMember(2, "Sakshi", "Thakur", 4)) .collect(Collectors.toList()));
	 * assertEquals(2, teamMemberService.getAllTeamMember().size()); }
	 */

	/*
	 * @Test void testFindTeamMemberById() { }
	 * 
	 * @Test void testDeleteTeamMember() { }
	 * 
	 * @Test void testFindByTeam() { }
	 */

}
