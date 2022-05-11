package com.grammy.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grammy.myapp.domain.TB_PurchaseVO;
import com.grammy.myapp.domain.TB_ReportVO;
import com.grammy.myapp.service.TB_ReportService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/report")
public class TB_ReportController {
	
	@Autowired
	TB_ReportService service;
	// 게시판리스트
	@RequestMapping("/list.do")
	public List<TB_ReportVO> AllList() throws Exception{
		List<TB_ReportVO> list=service.AllList();
		
		return list;
	}
	
	//게시판 상세내용
	@RequestMapping(value="/content.do",method = RequestMethod.POST)
	public TB_ReportVO DetailContent(@RequestBody int report_seq) throws Exception{
		System.out.println(report_seq);
		
		return service.DetaliContent(report_seq);
	}
	//게시판 삭제
	@RequestMapping(value="/delete.do",method = RequestMethod.GET)
	public String Delete(@RequestBody int report_seq) throws Exception{
		int result=service.DeleteReport(report_seq);
		if(result>0) {
		return "Success";
		}
		else {
			return "fail";
		}
	}
	//게시판 업데이트
	@RequestMapping(value="/update.do",method = RequestMethod.POST)
	public String Update(@RequestBody TB_ReportVO vo) throws Exception{
		int result=service.UpdateReport(vo);
		if(result>0) {
		return "Success";
		}else {
		return "fail";
		}
	}
	//게시판 작성
	@RequestMapping(value="/insert.do",method=RequestMethod.POST)
	public String Insert(@RequestBody TB_ReportVO vo) throws Exception{
		System.out.println(vo);
		service.InsertReport(vo);
		return "Success";
	}

}
