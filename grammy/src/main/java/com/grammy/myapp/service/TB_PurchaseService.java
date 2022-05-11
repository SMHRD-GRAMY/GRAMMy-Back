package com.grammy.myapp.service;

import java.util.List;

import com.grammy.myapp.domain.TB_PurchaseVO;



public interface TB_PurchaseService {
	
	public List<TB_PurchaseVO> AllList() throws Exception;
	
	public TB_PurchaseVO DetaliContent(int purchase_seq) throws Exception;
	
	public int DeletePurchase(int purchase_seq) throws Exception;
	
	public int UpdatePurchase(TB_PurchaseVO vo) throws Exception;
	
	public void InsertPurchase(TB_PurchaseVO vo) throws Exception;

	public void viewCount(int purchase_seq) throws Exception;
}
