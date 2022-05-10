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

}
