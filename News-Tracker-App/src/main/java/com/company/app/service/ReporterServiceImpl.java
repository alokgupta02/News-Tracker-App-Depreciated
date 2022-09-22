package com.company.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.entity.Reporter;
import com.company.app.repository.ReporterRepository;

@Service
public class ReporterServiceImpl implements ReporterService{

	@Autowired
	private ReporterRepository reporterRepository;
	
	@Override
	public void addReporter(Reporter reporter) {
		this.reporterRepository.save(reporter);
	}

	@Override
	public List<Reporter> getAllReporter() {
		return reporterRepository.findAll();
	}

	@Override
	public Optional<Reporter> findReporterById(int id) {
		return reporterRepository.findById(id);
	}

	@Override
	public void deleteReporter(int id) {
		this.reporterRepository.deleteById(id);
	}

}
