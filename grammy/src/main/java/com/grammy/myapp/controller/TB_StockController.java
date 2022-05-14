package com.grammy.myapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grammy.myapp.domain.TB_ShelfVO;
import com.grammy.myapp.domain.TB_StockVO;

@RestController
@RequestMapping("/stock")
public class TB_StockController {
	
	@RequestMapping(value="/weight", method=RequestMethod.POST)
    public void hardware(TB_StockVO vo) {
    	System.out.println(vo);
    	
    }
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String StockRegister(){
    	
    	return "";
    	
    }
    @RequestMapping(value="/insertShelf", method=RequestMethod.POST)
    public void insertShelf(TB_ShelfVO vo) {
    	
    }
    

}
