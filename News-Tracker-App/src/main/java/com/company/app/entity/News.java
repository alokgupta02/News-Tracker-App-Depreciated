package com.company.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
	private int id;

	private String slug;
	private String format;
	private String state;
	private String district;
	private String priority;
	private String status;
	private String remarks;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "input_id", referencedColumnName = "member_id")
	private TeamMember input;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "output_id", referencedColumnName = "member_id")
	private TeamMember output;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reporter_id", referencedColumnName = "reporter_id")
	private Reporter reporter;

	@UpdateTimestamp
	@Column(nullable = false)
	private Timestamp last_update;

}
