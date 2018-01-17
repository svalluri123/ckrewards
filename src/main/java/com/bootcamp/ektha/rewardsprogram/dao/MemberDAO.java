package com.bootcamp.ektha.rewardsprogram.dao;

import com.bootcamp.ektha.rewardsprogram.entity.Member;

/**
 * DAO class for the MEMBER TABLE
 * @author SV
 *
 */
public interface MemberDAO  {
	
	public boolean registerNewMember(Member member) ;
	public Member getMemberById(String memberID) ;
	
}
