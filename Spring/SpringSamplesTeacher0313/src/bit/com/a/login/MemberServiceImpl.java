package bit.com.a.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.model.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
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
	public boolean addmember(MemberDto mem) {		
		return memberDao.addmember(mem);		
	}

	@Override
	public MemberDto login(MemberDto dto) {		
		return memberDao.login(dto);		
	}
	
	
}





