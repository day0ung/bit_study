package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.MemberDto;

public interface MemberDao {
	public List<MemberDto> allMember();
	
	public int getId(MemberDto mem); //int로 
	
	public boolean addmember(MemberDto mem);
	//bbs
	public MemberDto login(MemberDto dto); 
}
