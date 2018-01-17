package com.bootcamp.ektha.rewardsprogram.service;

import com.bootcamp.ektha.rewardsprogram.dao.MemberDAO;
import com.bootcamp.ektha.rewardsprogram.entity.Member;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public Member getMemberById(String memberId) {
		return this.memberDAO.getMemberById(memberId);
	}

	@Override
	public boolean addMember(Member member) {
		boolean isSuccess = memberDAO.registerNewMember(member);
		return isSuccess;
	}
	
	
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
