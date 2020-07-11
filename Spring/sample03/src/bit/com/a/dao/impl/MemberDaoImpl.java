package bit.com.a.dao.impl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;

@Repository // ==저장소
public class MemberDaoImpl implements MemberDao {
	//DB와 통신
	@Autowired // <- 객체 생성(의존성) 스프링프레임워크에 기댐
	SqlSession sqlSession; //sqlsession은 interface소속임 실체가없다 
	//이실제는 applicationContext.xml 의 sqlSession취득 부분에 있음
	//SqlSession은 어디서든 접근할 수 있도록 만들어놓음, autowired만 붙여놓으면
	
	String namespace = "Member."; // ?
	
	@Override
	public List<MemberDto> allMember() {
		List<MemberDto> list = sqlSession.selectList(namespace+ "allMember");
		return list;
	}

	@Override
	public int getId(MemberDto mem) {
		int exist = sqlSession.selectOne(namespace+"getId",mem);
		return exist;
	}
	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto mem = sqlSession.selectOne(namespace+"login", dto);
		return mem;
	}
	
	@Override
	public boolean addmember(MemberDto mem) {		
		int n = sqlSession.insert(namespace + "addmember", mem);		
		return n>0?true:false;
	}


	

}
