package service.impl;

import dao.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.MemberDto;
import service.MemberService;

//controller와 dao의 중간자
public class MemberServiceImpl implements MemberService {
	MemberDao dao = new MemberDaoImpl();
	
	//service ==db에서 가져온거 편집할 때 사용
	@Override
	public boolean getID(String id) {
		return dao.getID(id);
	}

	@Override
	public boolean addMember(MemberDto dto) {
		return dao.addMember(dto);
	}

	@Override
	public MemberDto login(String id, String pwd) {
		return dao.login(id, pwd);
	}
}
