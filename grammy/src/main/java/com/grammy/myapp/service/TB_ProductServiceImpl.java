package com.grammy.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grammy.myapp.domain.TB_ShelfVO;
import com.grammy.myapp.mapper.TB_ProductMapper;

@Service
public class TB_ProductServiceImpl implements TB_ProductService{

	@Autowired
	TB_ProductMapper mapper;
	

	@Override
	public List<TB_ShelfVO> shelfList(TB_ShelfVO vo) {
		return mapper.shelfList(vo);

	}

	@Override
	public int insertShelf(TB_ShelfVO vo) {
		return mapper.insertShelf(vo);
		
	}

}
