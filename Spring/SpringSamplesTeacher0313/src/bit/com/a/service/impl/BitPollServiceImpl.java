package bit.com.a.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitPollDao;
import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.Voter;
import bit.com.a.service.BitPollService;

@Service
public class BitPollServiceImpl implements BitPollService {
	
	@Autowired
	BitPollDao pollDao;
	
	@Override
	public List<PollDto> getPollAllList(String id) {
		//polldto 에는 boolean vote가 있음, -> 이것은 테이블안에 없다.
		//모든 투표 목록을 갖고 온다.
		List<PollDto> list = pollDao.getPollAllList();
		
		//편집을 통해서 투표가 가능한지 설정해서 넘겨줄 목록
		List<PollDto> plist = new ArrayList<PollDto>();
		
		for (PollDto poll : list) {
			int pollid = poll.getPollid(); //투표번호
						//질문이 필요하고, 아이디만 필요함 , poolid와  id
						//voter에서 만들어놓은 voter생성자 3개짜리 가 있음
			int count = pollDao.isVote(new Voter(pollid, -1, id));
			
			if(count == 1) { //투표함
				poll.setVote(true); //투표함
			}else {
				poll.setVote(false);
			}
			plist.add(poll);
		}
		return plist;
	}

	@Override
	public void makePoll(PollBean pbean) {
		//pbean은 뷰에서 넘어올거임
		//투표 질문
		PollDto poll = new PollDto(pbean.getId(), pbean.getQuestion(), pbean.getSdate(), pbean.getEdate(), pbean.getItemcount(), 0);
		
		pollDao.makePoll(poll);
		
		//보기들
		String answer[] = pbean.getPollnum();
							//pbean은 정해놓은거임, admin이 정해놓은 갯수에 따라가야하기 때문이다
		for (int i = 0; i < pbean.getItemcount(); i++) {
			PollSubDto pollsub = new PollSubDto();
			pollsub.setAnswer(answer[i]);
			
			pollDao.makePollSub(pollsub);
		}
	}

	@Override
	public PollDto getPoll(PollDto poll) {
		return pollDao.getPoll(poll);
	}

	@Override
	public List<PollSubDto> getPollSubList(PollDto poll) {
		return pollDao.getPollSubList(poll);
	}

	@Override
	public void polling(Voter voter) {
		pollDao.pollingVoter(voter);
		pollDao.pollingPoll(voter);
		pollDao.pollingSub(voter);
	}

}
