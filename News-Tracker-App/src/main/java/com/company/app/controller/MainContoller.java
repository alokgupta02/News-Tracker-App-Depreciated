package com.company.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.company.app.entity.ChartData;
import com.company.app.service.ChartService;

@Controller
public class MainContoller {
	
	@Autowired
	private ChartService chartService;
	
	@GetMapping("/admin")
	public String adminPanel(Model model) {
		List<ChartData> dataList = chartService.getLatestNewsCount();
		System.out.println(dataList);
		List<Integer> latestNewsCount = dataList.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		model.addAttribute("latestNews", latestNewsCount);
		
		List<ChartData> dataList1 = chartService.getInputNewsCount();
		System.out.println(dataList1);
		List<Integer> inputNewsCount = dataList1.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		model.addAttribute("inputNewsCount", inputNewsCount);
		
		List<ChartData> dataList2 = chartService.getOutputNewsCount();
		System.out.println(dataList2);
		List<Integer> outputNewsCount = dataList2.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		model.addAttribute("outputNewsCount", outputNewsCount);
		
		List<ChartData> dataList3 = chartService.getRejectedNewsCount();
		System.out.println(dataList3);
		List<Integer> rejectedNewsCount = dataList3.stream().map(x -> x.getNewsCount()).collect(Collectors.toList());
		model.addAttribute("rejectedNewsCount", rejectedNewsCount);
		return "admin";
	}
}