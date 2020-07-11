package service.impl;

import java.util.List;

import dao.BbsDao;
import dao.impl.BbsDaoImpl;
import dto.BbsDto;
import service.BbsService;

public class BbsServiceImpl implements BbsService {

	BbsDao dao = new BbsDaoImpl();
	
	@Override
	public List<BbsDto> getBbsList() {		
		return dao.getBbsList();
	}
	
	@Override
	public BbsDto getBBS(int seq) {		
		return dao.getBBS(seq);		
	}

	@Override
	public List<BbsDto> getFindList(String fStr, String fword) {		
		return dao.getFindList(fStr, fword);		
	}

	@Override
	public boolean writeBbs(BbsDto dto) {		
		return dao.writeBbs(dto);
	}

	@Override
	public boolean bbsDelete(int seq) {
		// TODO Auto-generated method stub
		return dao.bbsDelete(seq);
	}

	@Override
	public boolean bbsUpdate(int seq, String title, String content) {
		// TODO Auto-generated method stub
		return dao.bbsUpdate(seq, title, content);		
	}

}
