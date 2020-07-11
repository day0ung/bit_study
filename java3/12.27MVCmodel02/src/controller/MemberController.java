package controller;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.impl.MemberServiceImpl;
import singleton.Singleton;
import view.accountView;
import view.loginView;

//controller는 service와 대화한다
public class MemberController {
	//membercontroller가 생성되면 serviceimpl가 생성됨, serbiceimpl에서 memberdao가 생성됨
	//먼저생성하고 나서 거꾸로 접근하고 있음, dao가 제일나중에 생성
	MemberService memServ = new MemberServiceImpl();
	
	
	public void login() {
		new loginView();
	}
	
	//accountView회원가입화면으로 이동하기위한 메소드
	public void regi() {
		new accountView();
	}
	
	//회원가입후 다시 돌아오는 메소드
	public void regiAf(String id, String pwd, String name, String email) {
		//회원가입후 데이터를 넘겨 받아야함(매개변수들..)
		
	//회원가입후 넘어온것이기때문에 DB에 넣어야함
	 boolean b = memServ.addMember(new MemberDto(id, pwd, name, email, 3)); //auth사용자는 3번
	 
	 //정상적으로 회원가입이 이루어졌으면 특정부분으로 이동시켜줘야하지만, 여기선 message띄어주기
	 if(b) {
		 JOptionPane.showMessageDialog(null, "회원가입 성공");
		 login();
	 }else {
		 JOptionPane.showMessageDialog(null, "회원가입 실패");
		 regi();
	 }
	}
	
	//controller를 거쳐서 
	public boolean idCheck(String id) {
		return memServ.getID(id);
	}
	
	//login한 다음의 함수(MemberDto 리턴
	public void loginAf(String id, String pwd) {
		MemberDto dto = memServ.login(id, pwd);
		if(dto == null) { //db에서 못찾았다는 이야기
			JOptionPane.showMessageDialog(null, "id나 pw가 틀렸습니다");			
			login();
		}else {
			JOptionPane.showMessageDialog(null, dto.getId() + "님 환영합니다");
			//id저장 -> singleton에  //웹에서는 session
			Singleton s= Singleton.getInstance();
			s.setLoginID(dto.getId());
			
			//bbsList로 이동시키면됨 -->bbsController 안의 bbs list로 이동
			//getbbsList함수 먼저만들고 불러줘야함
			s.bbsCtrl.getBbsList();
		}
	}
}
