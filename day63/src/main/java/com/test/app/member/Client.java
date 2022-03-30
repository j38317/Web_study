package com.test.app.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms = (MemberService)factory.getBean("memberService");
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("ari");
		memberVO.setName("아리");
		memberVO.setPassword("1234");
		memberVO.setRole("USER");
		ms.insertMember(memberVO);
		
		List<MemberVO> datas = ms.getMemberList(memberVO);
		for (MemberVO v : datas) {
			System.out.println(v);
		}
		
		factory.close();
	}

}
