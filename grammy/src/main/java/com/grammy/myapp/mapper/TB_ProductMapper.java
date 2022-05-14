package com.grammy.myapp.mapper;

import java.util.List;

import com.grammy.myapp.domain.TB_ShelfVO;

public interface TB_ProductMapper {
	
	//선반(창고) 등록하기
	public int insertShelf(TB_ShelfVO vo);
	//선반(창고) 리스트 가져오기
	public List<TB_ShelfVO> shelfList(TB_ShelfVO vo);


}
