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

	@Override
	public TB_PurchaseVO DetaliContent(int purchase_seq) throws Exception {
		
		return mapper.DetailContent(purchase_seq);
	}

	@Override
	public int DeletePurchase(int purchase_seq) throws Exception {
		
		return mapper.DeletePurchase(purchase_seq);
	}

	@Override
	public int UpdatePurchase(TB_PurchaseVO vo) throws Exception {
		
		return mapper.UpdatePurchase(vo);
	}

	@Override
	public void InsertPurchase(TB_PurchaseVO vo) throws Exception {
		mapper.InsertPurchase(vo);
		
	}

}
