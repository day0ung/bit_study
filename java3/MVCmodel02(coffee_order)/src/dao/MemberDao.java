package dao;

import dto.MemberDto;

public interface MemberDao {


	//id확인하는 함수 
	public boolean getID(String id);
	
	//회원가입됬는지 안됬는지 확인하는함수
	public boolean addMember(MemberDto dto);
	
	//로그인하기위해서 데이터를 집어넣기위해
	public MemberDto login(String id, String pwd);
}