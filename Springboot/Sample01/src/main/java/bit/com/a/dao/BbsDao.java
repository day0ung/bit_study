package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

@Mapper
@Repository
public interface BbsDao {
						//xml의 id와 이름이 같아야함
	public List<BbsDto> getBbsList(BbsParam param);
	public int getBbsCount(BbsParam param);
	
	public int writeBbs(BbsDto dto);
	public BbsDto getBbs(int seq);
	
	public int updateBbs(BbsDto dto);
	public int deleteBbs(int seq);
}
