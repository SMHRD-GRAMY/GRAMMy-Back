package com.grammy.myapp.service;

import java.util.List;

import com.grammy.myapp.domain.TB_ShelfVO;

public interface TB_ProductService {
	
	public List<TB_ShelfVO> shelfList(TB_ShelfVO vo);
	
	public int insertShelf(TB_ShelfVO vo);

}
