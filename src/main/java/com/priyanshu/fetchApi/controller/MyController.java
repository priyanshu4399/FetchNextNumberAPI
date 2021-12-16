package com.priyanshu.fetchApi.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.priyanshu.fetchApi.service.MyNumberService;

@RestController
public class MyController {
	
	@Autowired
	private MyNumberService myNumberService;
		
	//update the number
	@PutMapping("/FetchNextNumber")
	public Map<String,Integer> updateMyNumber(@RequestBody Map<String,String> thecategoryCode){
		String categoryCode = thecategoryCode.get("categoryCode");
		return this.myNumberService.updateMyNumber(categoryCode);
	}
	
}
