package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.Voter;

public interface BitPollDao {
	public List<PollDto> getPollAllList();
	
	public int isVote(Voter voter);
	
	//투표만들기
	public void makePoll(PollDto poll);
	public void makePollSub(PollSubDto pollsub);
	
	//투표하러가기
	public PollDto getPoll(PollDto poll); //질문에 대한것
	public List<PollSubDto> getPollSubList(PollDto poll); //보기들에 대한것 
	
	//투표하기
	public void pollingVoter(Voter voter);
	public void pollingPoll(Voter voter);
	public void pollingSub(Voter voter);
}
