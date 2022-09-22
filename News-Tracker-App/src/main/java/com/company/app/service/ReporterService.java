package com.company.app.service;

import java.util.List;
import java.util.Optional;

import com.company.app.entity.Reporter;

public interface ReporterService {

	// Create
	public void addReporter(Reporter reporter);

	// read
	public List<Reporter> getAllReporter();

	// update
	public Optional<Reporter> findReporterById(int id);

	// delete
	public void deleteReporter(int id);

}
