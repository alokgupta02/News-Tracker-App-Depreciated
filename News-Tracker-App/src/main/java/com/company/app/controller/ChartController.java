package com.company.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.company.app.entity.ChartData;
import com.company.app.service.ChartService;
import com.company.app.service.ReporterService;
import com.company.app.service.TeamMemberService;

@Controller
public class ChartController {

	@Autowired
	private ChartService chartService;

	@Autowired
	private TeamMemberService teamMemberService;
	
	@Autowired
	private ReporterService reporterService;

	// input chart controller
	@GetMapping("/admin/inputChart")
	public String viewInputChart(Model model) {
		List<ChartData> dataList = chartService.getAllInputDetails();
		List<String> days = dataList.stream().map(x -> x.getDate()).collect(Collectors.toList());
		List<Integer> news = dataList.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		model.addAttribute("inputList", teamMemberService.findByTeam(1));
		model.addAttribute("days", days);
		model.addAttribute("news", news);
		return "inputChart";
	}

	@GetMapping("/admin/inputChart/{id}")
	public String viewEachInputChart(@PathVariable int id, Model model) {
		List<ChartData> dataList = chartService.getInputDetails(id);
		List<String> days = dataList.stream().map(x -> x.getDate()).collect(Collectors.toList());
		List<Integer> news = dataList.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		System.out.println(dataList);
		model.addAttribute("inputList", teamMemberService.findByTeam(1));
		model.addAttribute("days", days);
		model.addAttribute("news", news);
		return "inputChart";
	}

	// output chart controller
	@GetMapping("/admin/outputChart")
	public String viewOutputChart(Model model) {
		List<ChartData> dataList = chartService.getAllOutputDetails();
		List<String> days = dataList.stream().map(x -> x.getDate()).collect(Collectors.toList());
		List<Integer> news = dataList.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		model.addAttribute("outputList", teamMemberService.findByTeam(2));
		model.addAttribute("days", days);
		model.addAttribute("news", news);
		return "outputChart";
	}

	@GetMapping("/admin/outputChart/{id}")
	public String viewEachOutputChart(@PathVariable int id, Model model) {
		List<ChartData> dataList = chartService.getOutputDetails(id);
		List<String> days = dataList.stream().map(x -> x.getDate()).collect(Collectors.toList());
		List<Integer> news = dataList.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		System.out.println(dataList);
		model.addAttribute("outputList", teamMemberService.findByTeam(2));
		model.addAttribute("days", days);
		model.addAttribute("news", news);
		return "outputChart";
	}

	// reporter chart controller
	@GetMapping("/admin/reporterChart")
	public String viewReporterChart(Model model) {
		List<ChartData> dataList = chartService.getAllReporterDetails();
		List<String> days = dataList.stream().map(x -> x.getDate()).collect(Collectors.toList());
		List<Integer> news = dataList.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		model.addAttribute("reporterList", reporterService.getAllReporter());
		model.addAttribute("days", days);
		model.addAttribute("news", news);
		return "reporterChart";
	}

	@GetMapping("/admin/reporterChart/{id}")
	public String viewEachReporterChart(@PathVariable int id, Model model) {
		List<ChartData> dataList = chartService.getReporterDetails(id);
		List<String> days = dataList.stream().map(x -> x.getDate()).collect(Collectors.toList());
		List<Integer> news = dataList.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		System.out.println(dataList);
		model.addAttribute("reporterList", reporterService.getAllReporter());
		model.addAttribute("days", days);
		model.addAttribute("news", news);
		return "reporterChart";
	}

}