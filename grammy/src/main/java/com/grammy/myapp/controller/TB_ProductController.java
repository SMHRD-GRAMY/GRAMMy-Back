package com.grammy.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grammy.myapp.domain.TB_ShelfVO;
import com.grammy.myapp.domain.TB_StockVO;
import com.grammy.myapp.service.TB_ProductService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/product")
public class TB_ProductController {
	@Autowired
	TB_ProductService service;
	
	//선반 리스트 가져오기
    @RequestMapping(value="/shelflist",method=RequestMethod.POST)
    public List<TB_ShelfVO> shelfList(TB_ShelfVO vo){
    	return service.shelfList(vo);
    }
    //선반 추가하기
    @RequestMapping(value="/insertshelf",method=RequestMethod.POST)
    public String insertShelf(TB_ShelfVO vo) {
    	int result=service.insertShelf(vo);
    	if(result>0) {
    		return "success";
    	}else {
    		return "fail";
    	}
    	
    }
    
	
	@RequestMapping(value="/weight", method=RequestMethod.POST)
    public void hardware(TB_StockVO vo) {
    	System.out.println(vo);
    	
    }
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String StockRegister(){
    	
    	return "";
    	
    }

    

    

}
