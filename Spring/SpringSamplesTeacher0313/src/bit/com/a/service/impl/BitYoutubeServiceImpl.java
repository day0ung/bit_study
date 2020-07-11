package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitYoutubeDao;
import bit.com.a.model.YoutubeSave;
import bit.com.a.service.BitYoutubeService;

@Service
public class BitYoutubeServiceImpl implements BitYoutubeService {
	
	@Autowired
	BitYoutubeDao dao;
	
	@Override
	public boolean writeYoutube(YoutubeSave ys) {
		return dao.writeYoutube(ys);
	}

	@Override
	public YoutubeSave getYoutube(YoutubeSave ys) {
		return dao.getYoutube(ys);
	}

	@Override
	public List<YoutubeSave> getYoutubeSave(String id) {
		return dao.getYoutubeSave(id);
	}

	@Override
	public void deleteYoutube(YoutubeSave y) {
		dao.deleteYoutube(y);
		
	}

}
