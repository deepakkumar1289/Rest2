package com.deepak.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
	
	@Controller
	public class HelloController {
		@RequestMapping(value = "/hello1/{name}",method = RequestMethod.GET )
		@ResponseBody public Hello getMessage1(@PathVariable("name") String name) {
		System.out.println("HC-getMessage1()" + name);
		String msg="Hello "+name +" Welcome !!!" ;
		Hello hello=new Hello(101,msg);
		return hello;
		}
		
		@GetMapping(value = "/hello2/{name}" )
		@ResponseBody public String getMessage2(@PathVariable("name") String name) {
		System.out.println("HC-getMessage2()" + name);
		String msg="Hello "+name +" Welcome !!!" ;
		return msg;
		}
		
		@GetMapping(value = "/hello3/{name}" )
		@ResponseBody public String getMessage3(@PathVariable("name") String name,Model model) {
	    System.out.println("HC-getMessage3()" + name);
		String msg="Hello "+name +" Welcome !!!" ;
		model.addAttribute("MyMsg", msg);
		return "myhello"; //View
		}
		
		@PostMapping(value="/myhello", produces = "application/xml")
		@ResponseBody public String getMessage(@RequestBody Hello hello) {
		System.out.println("HC-getMessage()");
		System.out.println(hello.getId());
		System.out.println(hello.getMessage());
		String msg=hello.getMessage();
		return msg;

}
	}
	
