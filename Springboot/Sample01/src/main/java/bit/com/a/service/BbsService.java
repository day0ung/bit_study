package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

@Service
@Transactional
public class BbsService {
	
	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getBbsList(BbsParam param){
		return dao.getBbsList(param);
	}
	
	//글의 총수 
	public int getBbsCount(BbsParam param) {
		return dao.getBbsCount(param);
	}
	
	public boolean writeBbs(BbsDto dto) {
		int n = dao.writeBbs(dto);
		return n>0?true:false;
	}
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
	
	public boolean updateBbs(BbsDto dto) {
		int n = dao.updateBbs(dto);
		return n>0?true:false;
	}
	public boolean deleteBbs(int seq) {
		int n = dao.deleteBbs(seq);
		return n>0?true:false;
	}
}
