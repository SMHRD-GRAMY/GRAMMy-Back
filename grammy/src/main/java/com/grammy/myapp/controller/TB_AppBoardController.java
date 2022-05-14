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
	//게시글 작성
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	private String insertBoard(TB_App_BoardVO vo) {
		System.out.println(vo);
		int result=service.insertBoard(vo);
		System.out.println(result);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	//게시글 삭제
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	private String deleteBoard(TB_App_BoardVO vo) {
		System.out.println(vo);
		int result=service.deleteBoard(vo);
		System.out.println(result);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	//게시글 업데이트
	@RequestMapping(value="/update",method=RequestMethod.POST)
	private String updateBoard(TB_App_BoardVO vo) {
		System.out.println(vo);
		int result=service.updateBoard(vo);
		System.out.println(result);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	

}
