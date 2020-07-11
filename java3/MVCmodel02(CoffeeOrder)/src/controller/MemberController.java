package controller;

import javax.swing.JOptionPane;

import dto.MemberDTO;

import service.MemberService;
import service.impl.MemberServiceImpl;
import view.AccountView;
import view.LoginView;

public class MemberController {
	MemberService memServ = new MemberServiceImpl();
	
	public void loginView() {
		new LoginView();
	}
	

	
	public void register() {
		new AccountView();
	}
	
	public void regiAf(String id, String pwd, String name, String email) {
		boolean b = memServ.addMember(new MemberDTO(id, pwd, name, email, 3));
		if(b) {
			JOptionPane.showMessageDialog(null, "회원가입 성공!");
			loginView();
		}else {
			JOptionPane.showMessageDialog(null, "회원가입 실패!");
			register();
		}		
	}
	
	public boolean idCheck(String id) {
		return memServ.getId(id);
	}
}
