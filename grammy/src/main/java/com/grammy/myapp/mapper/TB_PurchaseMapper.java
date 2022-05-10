package com.grammy.myapp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.grammy.myapp.domain.TB_PurchaseVO;

@MapperScan
public interface TB_PurchaseMapper {
	
	//리스트 다가져오기
	public List<TB_PurchaseVO> AllList();

}
