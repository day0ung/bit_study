package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.model.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	//spring boot가 imple을 해줌 namespace 연결할때 xml에서 
	public List<MemberDto> allMember();
	
	public int getId(String id);
	
	public int addmember(MemberDto dto);
	
	public MemberDto login(MemberDto dto);
}
