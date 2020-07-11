package service;

import dto.MemberDTO;

public interface MemberService {

	boolean getId(String id);
	
	public boolean addMember(MemberDTO dto);
	
	public MemberDTO login(String id, String pwd);
}
