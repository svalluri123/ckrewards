package com.bootcamp.ektha.rewardsprogram.dao;

import org.springframework.stereotype.Repository;

import com.bootcamp.ektha.rewardsprogram.entity.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Override
	public Member getMemberById(String memberId) {
		return null;
	}

	@Override
	public boolean registerNewMember(Member member) {
		// TODO Auto-generated method stub
		
		//Member mem = new Member();
		System.out.println(member.getFirstName());
		
		return true;
	}


}
