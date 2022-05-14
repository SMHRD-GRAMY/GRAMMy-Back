package com.grammy.myapp.service;

import java.util.List;

import com.grammy.myapp.domain.TB_App_BoardVO;

public interface TB_AppBoardService {
	
	public List<TB_App_BoardVO> boardList();
	
	public int insertBoard(TB_App_BoardVO vo);
	
	public int deleteBoard(TB_App_BoardVO vo);
	
	public int updateBoard(TB_App_BoardVO vo);

}
