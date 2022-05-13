package com.grammy.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grammy.myapp.domain.TB_App_BoardVO;
import com.grammy.myapp.mapper.TB_AppMapper;

@Service
public class TB_AppBoardServiceImpl implements TB_AppBoardService{

	@Autowired
	TB_AppMapper mapper;
	
	@Override
	public List<TB_App_BoardVO> boardList() {
		
		return mapper.boardList();
	}

}
