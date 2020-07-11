package dao;

import java.util.List;

import dto.BbsDto;

public interface BbsDao {

	public List<BbsDto> getBbsList();
	public BbsDto getBBS(int seq);	
	public List<BbsDto> getFindList(String fStr, String fword);
	
	public boolean writeBbs(BbsDto dto);	
	public boolean bbsDelete(int seq);
	public boolean bbsUpdate(int seq, String title, String content);
}
