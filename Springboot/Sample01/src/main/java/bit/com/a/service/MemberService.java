package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;

@Service
@Transactional //이게 있어야하는데 없음, frame소속의 annotaion
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	public List<MemberDto> allMember(){
		return dao.allMember();
	}
	
	public int getId(String id) {
		return dao.getId(id);
	}
	
	public boolean addmember(MemberDto dto) {
		int len = dao.addmember(dto);
		return len>0?true:false;
	}
	
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
	
}
