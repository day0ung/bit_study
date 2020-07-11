package dao;

import dto.MemberDTO;


public interface MemberDAO {
	public boolean getId(String id);
	
	public boolean addMember(MemberDTO dto);
	
	public MemberDTO login(String id, String pwd);
}
