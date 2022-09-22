package com.company.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.app.entity.Reporter;

@Repository
public interface ReporterRepository extends JpaRepository<Reporter, Integer>{

}
