package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.PdsDao;
import bit.com.a.model.PdsDto;

@Repository
public class pdsDaoImpl implements PdsDao {
	@Autowired
	SqlSession sqlSession;
	
	String ns = "Pds.";

	@Override
	public List<PdsDto> getPdsList() {
		return sqlSession.selectList(ns+"getPdsList");
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		int n = sqlSession.insert(ns+"uploadPds", dto);
		return n>0?true:false;
	}

	@Override
	public PdsDto getPds(int seq) {
		return sqlSession.selectOne(ns+"getPds", seq);
	}
	

}
