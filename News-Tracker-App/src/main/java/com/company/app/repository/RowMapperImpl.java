package com.company.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.app.entity.ChartData;

public class RowMapperImpl implements RowMapper<ChartData>{

	@Override
	public ChartData mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChartData chartData = new ChartData();
		chartData.setDate(rs.getString(1));
		chartData.setMemberId(rs.getInt(2));
		chartData.setNewsCount(rs.getInt(3));
		return chartData;
	}

}
