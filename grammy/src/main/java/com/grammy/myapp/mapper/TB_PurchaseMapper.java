package com.grammy.myapp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.grammy.myapp.domain.TB_PurchaseVO;

@MapperScan
public interface TB_PurchaseMapper {
	
	//리스트 다가져오기
	public List<TB_PurchaseVO> AllList();
	
	//세부내용 가져오기
	public TB_PurchaseVO DetailContent(int pruchase_seq);
	
	//게시판 지우기
	public int DeletePurchase(int purchase_seq);
	//게시판 업데이트
	public int UpdatePurchase(TB_PurchaseVO vo);
	//게시판 작성
	public void InsertPurchase(TB_PurchaseVO vo);

}
