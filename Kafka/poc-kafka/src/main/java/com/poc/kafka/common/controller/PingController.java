package com.poc.kafka.common.controller;

import java.util.*;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET, headers= "Accept=application/json")
	public ModelMap ping(){
		ModelMap map = new ModelMap("time", new Date());
		return map;
	}

}
