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

import com.company.app.entity.Reporter;
import com.company.app.service.ReporterService;

@Controller
public class ReporterController {
	
	@Autowired
	private ReporterService reporterService;
	
	@GetMapping("/admin/reporter")
	public String viewReporter(Model model){
		model.addAttribute("listReporters",reporterService.getAllReporter());
		return "admin/reporters";
	}
	
	@GetMapping("/admin/reporter/add")
	public String addReporter(Model model) {
		Reporter reporter = new Reporter();
		model.addAttribute("reporter", reporter);
		return "admin/add_reporter";
	}
	
	@PostMapping("/admin/reporter/save")
	public String saveReporter(@ModelAttribute ("reporter") Reporter reporter) {
		reporterService.addReporter(reporter);
		return "redirect:/admin/reporter";
	}

	@GetMapping("/admin/reporter/edit/{id}")
	public String editReporter(@PathVariable int id, Model model) throws TemplateInputException{
		Optional<Reporter> reporter = reporterService.findReporterById(id);
			model.addAttribute("reporter",reporter.get());
			return "admin/add_reporter";
	}
	
	@GetMapping("/admin/reporter/delete/{id}")
	public String deleteReporter(@PathVariable int id) {
		this.reporterService.deleteReporter(id);
		return "redirect:/admin/reporter";
	}
	
}
