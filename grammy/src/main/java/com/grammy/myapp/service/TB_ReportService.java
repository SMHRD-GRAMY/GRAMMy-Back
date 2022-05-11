package com.grammy.myapp.service;

import java.util.List;

import com.grammy.myapp.domain.TB_PurchaseVO;
import com.grammy.myapp.domain.TB_ReportVO;



public interface TB_ReportService {
	
	public List<TB_ReportVO> AllList() throws Exception;
	
	public TB_ReportVO DetaliContent(int report_seq) throws Exception;
	
	public int DeleteReport(int report_seq) throws Exception;
	
	public int UpdateReport(TB_ReportVO vo) throws Exception;
	
	public void InsertReport(TB_ReportVO vo) throws Exception;
	
	public void viewCount(int report_seq) throws Exception;

}
