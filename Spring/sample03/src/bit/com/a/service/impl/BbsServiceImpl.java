package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.service.BbsService;

@Service  //controller와 dao의 중간자
public class BbsServiceImpl implements BbsService {
	@Autowired
	BbsDao bbsDao;

	@Override
	public List<BbsDto> getBbsList() {
		return bbsDao.getBbsList();
	}
	
	@Override
	public boolean writeBbs(BbsDto bbs) {		
		return bbsDao.writeBbs(bbs);		
	}
	
	@Override
	public BbsDto getBbs(int seq) {		
		return bbsDao.getBbs(seq);		
	}
	
	@Override
	public void reply(BbsDto bbs) throws Exception {
		bbsDao.replyBbsUpdate(bbs);
		bbsDao.replyBbsInsert(bbs);	
	}
}
