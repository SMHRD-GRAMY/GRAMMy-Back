package com.grammy.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grammy.myapp.domain.TB_PurchaseVO;
import com.grammy.myapp.service.TB_PurchaseService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/purchase")
public class TB_PurchaseController {
	
	@Autowired
	TB_PurchaseService service;
	// 게시판리스트
	@RequestMapping("/list.do")
	public List<TB_PurchaseVO> AllList() throws Exception{
		List<TB_PurchaseVO> list=service.AllList();
		
		return list;
	}
	
	//게시판 상세내용
	@RequestMapping("/content.do")
	public TB_PurchaseVO DetailContent(int purchase_seq) throws Exception{
		
		return service.DetaliContent(purchase_seq);
	}
	//게시판 삭제
	@RequestMapping("/delete.do")
	public String Delete(int purchase_seq) throws Exception{
		int result=service.DeletePurchase(purchase_seq);
		if(result>0) {
		return "Success";
		}
		else {
			return "fail";
		}
	}
	//게시판 업데이트
	@RequestMapping("/update.do")
	public String Update(int purchase_seq) throws Exception{
		
		return "Success";
	}
	//게시판 작성
	@RequestMapping("/insert.do")
	public String Insert(int purchase_seq) throws Exception{
		
		return "Success";
	}

}
