package com.bootcamp.ektha.rewardsprogram.service;

import com.bootcamp.ektha.rewardsprogram.entity.Member;

public interface MemberService {
	public boolean addMember(Member member);
	public Member getMemberById(String memberId);
}
