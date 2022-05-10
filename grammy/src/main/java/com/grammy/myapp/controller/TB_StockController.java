package com.grammy.myapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class TB_StockController {
	
    @RequestMapping(value="/weight", method=RequestMethod.GET)
    public void hardware(@RequestParam String value) {
    	System.out.println(value);
    	
    }

}
