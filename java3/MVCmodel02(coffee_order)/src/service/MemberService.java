package service;

import dto.MemberDto;

public interface MemberService {
	//proto type
	public boolean getID(String id);
	
	public boolean addMember(MemberDto dto);
	
	public MemberDto login(String id, String pwd);
}
