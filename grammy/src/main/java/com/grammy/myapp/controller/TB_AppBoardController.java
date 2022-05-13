package com.grammy.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grammy.myapp.domain.TB_App_BoardVO;
import com.grammy.myapp.service.TB_AppBoardService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/app")
public class TB_AppBoardController {
	
	@Autowired
	TB_AppBoardService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	private List<TB_App_BoardVO> BoardList(){
		
		return service.boardList();
		
	}
	

}
