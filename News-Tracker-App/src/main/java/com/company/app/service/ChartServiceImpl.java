package com.company.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.company.app.entity.ChartData;
import com.company.app.repository.DashboardRowMapperImpl;
import com.company.app.repository.RowMapperImpl;

@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ChartData> getAllInputDetails() {
		String query = "SELECT DATE(last_update),input_id, COUNT(*) FROM news_tracker_app.news WHERE input_id IS NOT NULL GROUP BY DAY(last_update);";
		RowMapper<ChartData> rowMapper = new RowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper);
		return chartData;
	}

	@Override
	public List<ChartData> getInputDetails(int id) {
		String query = "SELECT DATE(last_update),input_id, COUNT(*) FROM news_tracker_app.news WHERE input_id = ? GROUP BY DAY(last_update)";
		RowMapper<ChartData> rowMapper = new RowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper, id);
		return chartData;
	}
	
	@Override
	public List<ChartData> getAllOutputDetails() {
		String query = "SELECT DATE(last_update),output_id, COUNT(*) FROM news_tracker_app.news WHERE output_id IS NOT NULL GROUP BY DAY(last_update)";
		RowMapper<ChartData> rowMapper = new RowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper);
		return chartData;
	}

	@Override
	public List<ChartData> getOutputDetails(int id) {
		String query = "SELECT DATE(last_update),output_id, COUNT(*) FROM news_tracker_app.news WHERE output_id = ? GROUP BY DAY(last_update)";
		RowMapper<ChartData> rowMapper = new RowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper, id);
		return chartData;
	}
	
	@Override
	public List<ChartData> getAllReporterDetails() {
		String query = "SELECT DATE(last_update),reporter_id, COUNT(*) FROM news_tracker_app.news GROUP BY DAY(last_update)";
		RowMapper<ChartData> rowMapper = new RowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper);
		return chartData;
	}

	@Override
	public List<ChartData> getReporterDetails(int id) {
		String query = "SELECT DATE(last_update),reporter_id, COUNT(*) FROM news_tracker_app.news WHERE reporter_id = ? GROUP BY DAY(last_update)";
		RowMapper<ChartData> rowMapper = new RowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper, id);
		return chartData;
	}

	@Override
	public List<ChartData> getLatestNewsCount() {
		//String query = "SELECT COUNT(*) FROM news_tracker_app.news GROUP BY DAY(last_update) ORDER BY DATE(last_update) DESC LIMIT 1";
		String query = "SELECT COUNT(*), DATE(last_update) AS update_date\n" +
				"FROM news_tracker_app.news\n" +
				"GROUP BY update_date\n" +
				"ORDER BY update_date DESC\n" +
				"LIMIT 1";
		RowMapper<ChartData> rowMapper = new DashboardRowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper);
		return chartData;
	}

	@Override
	public List<ChartData> getInputNewsCount() {
		String query = "SELECT COUNT(*) FROM news_tracker_app.news WHERE input_id IS NOT NULL";
		RowMapper<ChartData> rowMapper = new DashboardRowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper);
		return chartData;
	}

	@Override
	public List<ChartData> getOutputNewsCount() {
		String query = "SELECT COUNT(*) FROM news_tracker_app.news WHERE output_id IS NOT NULL";
		RowMapper<ChartData> rowMapper = new DashboardRowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper);
		return chartData;
	}

	@Override
	public List<ChartData> getRejectedNewsCount() {
		String query = "SELECT COUNT(*) FROM news_tracker_app.news WHERE status = 'rejected'";
		RowMapper<ChartData> rowMapper = new DashboardRowMapperImpl();
		List<ChartData> chartData = this.jdbcTemplate.query(query, rowMapper);
		return chartData;
	}
}