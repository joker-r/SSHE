package com.viva.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.viva.entity.cg_sshe_report;

public interface cg_sshe_report_dao {
 public int add_request_received_for_HE_by_CP(cg_sshe_report kpi);
public List<cg_sshe_report> generateReport(String cpid);

}