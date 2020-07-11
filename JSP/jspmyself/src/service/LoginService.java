package service;

import dao.MemberDao;
import dto.MemberDto;
import singleton.Singleton;

public class LoginService {
	MemberDao dao = new MemberDao();
	
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
	public LoginService() {		
	}
}
