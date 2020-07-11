package bit.com.a.service;

import java.util.List;

import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.Voter;

public interface BitPollService {
	//id값을 넣어주는이유 isvote에서 필요하기 때문임
	public List<PollDto> getPollAllList(String id);
	
	//질문, 보기 넣어 주어야함, pollbean
	public void makePoll(PollBean pbean);
	
	public PollDto getPoll(PollDto poll); //문제
	
	public List<PollSubDto> getPollSubList(PollDto poll); //보기
	
	public void polling(Voter voter);
}
