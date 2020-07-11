package main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BbsDto;
import dto.BbsParam;
import dto.MemberDto;

public class mainClass {

	public static void main(String[] args)throws Exception {

		// mybatis설정 파일을 읽어 들인다
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
			
		// SqlSessionFactory 객체를 취득
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		// SqlSession 객체를 취득 <-- 실질적으로 데이터를 write, read 하기위한 객체
		SqlSession session = factory.openSession();
		
		// insert
		/*
	//	MemberDto dto = new MemberDto("aaa", "111", "AAA");		
	//	MemberDto dto = new MemberDto("bbb", "222", "BBB");
		MemberDto dto = new MemberDto("ccc", "333", "CCC");
		int n = session.insert("add", dto);
		if(n > 0) {
			session.commit();
			System.out.println("추가 성공!");
		}else {
			session.rollback();
			System.out.println("추가 실패");
		}
		*/
		
		/*
		String id = "bbb";
		int n = session.delete("remove", id);
		if(n > 0) {
			session.commit();
			System.out.println("삭제 성공!");
		}else {
			session.rollback();
			System.out.println("삭제 실패");
		}
		*/
		
		/*
		MemberDto dto = new MemberDto("ccc", null, "");
		int n = session.delete("removeObj", dto);
		if(n > 0) {
			session.commit();
			System.out.println("삭제 성공!");
		}else {
			session.rollback();
			System.out.println("삭제 실패");
		}	
		*/
		// update
		
		// select
		String id = "ccc";
		MemberDto dto = session.selectOne("find", id);
		System.out.println(dto.toString());
		
		// select list
		List<MemberDto> list = session.selectList("allList");
		for (MemberDto mem : list) {
			System.out.println(mem.toString());
		}
		
		// BBS		
		// insert, delete, select, selectlist, update
		// search
		BbsParam bbp = new BbsParam("title", "MBC");
		List<BbsDto> searchlist = session.selectList("search", bbp);
		for (BbsDto bbs : searchlist) {
			System.out.println(bbs.toString());
		}
		
		
	}
}





