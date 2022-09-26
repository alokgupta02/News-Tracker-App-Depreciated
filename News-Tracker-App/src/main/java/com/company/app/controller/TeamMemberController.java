package com.company.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.exceptions.TemplateInputException;

import com.company.app.entity.TeamMember;
import com.company.app.service.TeamMemberService;

@Controller
public class TeamMemberController {
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	@GetMapping("/admin/team")
	public String viewMember(Model model){
		model.addAttribute("listTeam",teamMemberService.getAllTeamMember());
		return "team_member";
	}
	
	@GetMapping("/admin/team/add")
	public String addMember(Model model) {
		TeamMember teamMember = new TeamMember();
		model.addAttribute("teamMember",teamMember);
		return "add_member";
	}
	
	@PostMapping("/admin/team/save")
	public String saveMember(@ModelAttribute ("teamMember") TeamMember teamMember) {
		teamMemberService.addTeamMember(teamMember);
		return "redirect:/admin/team";
	}
	
	@GetMapping("/admin/team/edit/{id}")
	public String editMember(@PathVariable int id, Model model) throws TemplateInputException{
		Optional<TeamMember> teamMember = teamMemberService.findTeamMemberById(id);
			model.addAttribute("teamMember",teamMember.get());
			return "add_member";
	}
	
	@GetMapping("/admin/team/delete/{id}")
	public String deleteMember(@PathVariable int id) {
		this.teamMemberService.deleteTeamMember(id);
		return "redirect:/admin/team";
	}
}