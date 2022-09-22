package com.company.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.app.entity.ChartData;

public class DashboardRowMapperImpl implements RowMapper<ChartData>{

	@Override
	public ChartData mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChartData chartData = new ChartData();
		chartData.setNewsCount(rs.getInt(1));
		return chartData;
	}

}
