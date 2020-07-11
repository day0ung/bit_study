package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired //자동적으로 memberdaoimpl을 넣어준다. springframework가 
	MemberDao memberDao;
	
	@Override
	public List<MemberDto> allMember() {

		return memberDao.allMember();
	}

	@Override
	public int getId(MemberDto mem) {
		return memberDao.getId(mem);
	}

	
	@Override
	public MemberDto login(MemberDto dto) {
		return memberDao.login(dto);
	}
	
	@Override
	public boolean addmember(MemberDto mem) {		
		return memberDao.addmember(mem);		
	}

	

}
