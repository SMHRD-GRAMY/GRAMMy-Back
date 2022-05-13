package com.grammy.myapp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.grammy.myapp.domain.TB_App_BoardVO;

@MapperScan
public interface TB_AppMapper {
	
	// 게시판 리스트 가져오기
	public List<TB_App_BoardVO> boardList();

}
