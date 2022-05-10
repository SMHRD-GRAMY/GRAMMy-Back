package com.grammy.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grammy.myapp.domain.TB_PurchaseVO;
import com.grammy.myapp.mapper.TB_PurchaseMapper;

@Service
public class TB_PurchaseServiceImpl implements TB_PurchaseService{

	@Autowired
	TB_PurchaseMapper mapper;
	
	@Override
	public List<TB_PurchaseVO> AllList() throws Exception {
		
		return mapper.AllList();
	}

}
