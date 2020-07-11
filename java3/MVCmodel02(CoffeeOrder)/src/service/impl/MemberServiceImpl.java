package service.impl;

import dao.MemberDAO;
import dao.impl.MemberDAOImpl;
import dto.MemberDTO;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao = new MemberDAOImpl();
	
	@Override
	public boolean getId(String id) {		
		return dao.getId(id);		
	}

	@Override
	public boolean addMember(MemberDTO dto) {		
		return dao.addMember(dto);		
	}

	@Override
	public MemberDTO login(String id, String pwd) {		
		return dao.login(id, pwd);		
	}
}
