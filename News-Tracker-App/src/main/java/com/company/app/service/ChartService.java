package com.company.app.service;

import java.util.List;

import com.company.app.entity.ChartData;

public interface ChartService {

	// input team member details for chart
	public List<ChartData> getAllInputDetails();
	public List<ChartData> getInputDetails(int id);

	// output team member details for chart
	public List<ChartData> getAllOutputDetails();
	public List<ChartData> getOutputDetails(int id);

	// reporter details for chart
	public List<ChartData> getAllReporterDetails();
	public List<ChartData> getReporterDetails(int id);
	
	/* public List<ChartData> getDashboardData(); */
	
	public List<ChartData> getLatestNewsCount();
	
	public List<ChartData> getInputNewsCount();
	
	public List<ChartData> getOutputNewsCount();
	
	public List<ChartData> getRejectedNewsCount();

}
