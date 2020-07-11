package controller;

import java.util.List;

import dto.BbsDto;
import service.BbsService;
import service.impl.BbsServiceImpl;
import view.bbsListView;

public class BbsController {
	BbsService bbsServ = new BbsServiceImpl();
	
	
	public void getBbsList() {
		//데이터를가지고가서 생성해야하기 때문에 list생성
		List<BbsDto> list = bbsServ.getBbsList();
		new bbsListView(list); //생성해서 가지고 가서 이동하고, 리스트를 뿌려줌
	}
}
