package com.test.app.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired // DI
	private MemberDAO memberdao;
	
	@Override
	public void insertMember(MemberVO vo) {
		memberdao.insertMember(vo);
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		return memberdao.getMember(vo);
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		return memberdao.getMemberList(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberdao.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberdao.deleteMember(vo);
	}

}
