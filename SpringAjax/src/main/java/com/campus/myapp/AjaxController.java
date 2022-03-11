package com.campus.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxView")
	public String ajaxView() {
		return "ajax/ajaxView";
	}

	@RequestMapping(value="/ajaxString", method=RequestMethod.GET, produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajaxString(int num, String name, String addr) {
		System.out.println("num:"+num);
		System.out.println("name:"+name);
		System.out.println("addr:"+addr);
		
		String data = "번호 : "+num + "<br/>이름 : "+name + "<br/>주소 : "+ addr;
		return data;
		
	}
	
	//				여기로 접속이 되면
	@RequestMapping("/ajaxObject")
	@ResponseBody
	public ProductVO ajaxObject(int num, String name) {
		System.out.println(num+"===>"+name);
		
		// ProductVO를 만들어 여기에 데이터를 담아서 ajax에게 보내기
		ProductVO vo = new ProductVO(1234, "컴퓨터",1200000, 13);
		
		return vo;
	}
	
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<ProductVO> ajaxList() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		list.add(new ProductVO(100, "모션데스크 DSDM1207", 700000, 2));
		list.add(new ProductVO(200, "모션데스크 DSDM1407", 800000, 4));
		list.add(new ProductVO(300, "모션데스크 DSDM1607", 900000, 3));
		list.add(new ProductVO(400, "시디즈 T500HLDA", 400000, 10));
		
		return list;
	}
	
	//Map
	@RequestMapping("/ajaxMap")
	@ResponseBody
	public HashMap<String, ProductVO> ajaxMap() {
		
		HashMap<String, ProductVO> map = new HashMap<String, ProductVO>();
		
		map.put("p1", new ProductVO(100, "시디즈 T550HLDA", 450000, 2));
		map.put("p2", new ProductVO(200, "시디즈 T500HDA", 300000, 3));
		map.put("p3", new ProductVO(300, "시디즈 T400HLDA", 350000, 5));
		map.put("p4", new ProductVO(400, "시디즈 T200HA", 250000, 2));
		map.put("p5", new ProductVO(500, "시디즈 RINGO", 160000, 8));
		
		return map;
		
	}

	
	@RequestMapping(value="/ajaxJson", method=RequestMethod.GET, produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajaxJson(int no, String name, String tel) {
		System.out.println(no+">>>>"+name+">>>>"+tel);
		
		int proNo = 1234;
		String proName = "LG 냉장고";
		int price = 2000000;
		
		String txt = "{\"proNo\":\""+proNo+"\",\"proName\":\""+proName+"\",\"price\":\""+price+"\"}";
		System.out.println(txt);
		return txt;
	}
	
	@RequestMapping(value="/ajaxForm", method=RequestMethod.POST)
	@ResponseBody
	public String ajaxForm(String proName, int price) {
		System.out.println(proName);
		System.out.println(price);
		return "ok";  //ok안넘어가는 이유는 form이 다음페이지로 넘어가기 때문에 event로 제어해주자!
	}
}
