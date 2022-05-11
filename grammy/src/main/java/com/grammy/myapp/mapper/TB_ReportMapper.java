package com.grammy.myapp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.grammy.myapp.domain.TB_ReportVO;

@MapperScan
public interface TB_ReportMapper {
	
	//리스트 다가져오기
	public List<TB_ReportVO> AllList();
	
	//세부내용 가져오기
	public TB_ReportVO DetailContent(int report_seq);
	
	//게시판 지우기
	public int DeleteReport(int report_seq);
	//게시판 업데이트
	public int UpdateReport(TB_ReportVO vo);
	//게시판 작성
	public void InsertReport(TB_ReportVO vo);

}
