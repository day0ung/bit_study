package controller;

import java.util.List;

import javax.swing.JOptionPane;

import dto.BbsDto;
import service.BbsService;
import service.impl.BbsServiceImpl;
import view.bbsAddView;
import view.bbsDetailView;
import view.bbsListView;
import view.bbsUpdateView;

public class BbsController {

	BbsService bbsServ = new BbsServiceImpl();
	
	public void getBbsList() {
		
		List<BbsDto> list = bbsServ.getBbsList();
		new bbsListView(list);
	}
	
	public void bbsDetail(int seq) {
		BbsDto dto = bbsServ.getBBS(seq);
		new bbsDetailView(dto);
	}
	
	public void getBbsFindList(String fStr, String fword){
		List<BbsDto> list = bbsServ.getFindList(fStr.trim(), fword);
		
		if(list.size() == 0 || fStr.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "데이터를 찾을 수 없습니다");
			List<BbsDto> _list = bbsServ.getBbsList();
			new bbsListView(_list);
		}else {
			new bbsListView(list);
		}				
	}
	
	public void bbsWrite() {
		new bbsAddView();
	}
	
	public void bbsWriteAf(BbsDto dto){
		boolean b = bbsServ.writeBbs(dto);
		if(b){			
			JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
			getBbsList();
		}else{
			JOptionPane.showMessageDialog(null, "추가되지 못했습니다");
			bbsWrite();
		}
	}
	
	public void bbsDelete(int seq) {
		boolean b =  bbsServ.bbsDelete(seq);
		if(b){
			JOptionPane.showMessageDialog(null, "성공적으로 삭제되었습니다");
			getBbsList();
		}else{
			JOptionPane.showMessageDialog(null, "삭제하지 못했습니다");
			bbsDetail(seq);
		}
	}
	
	public void bbsUpdate(int seq) {
		BbsDto dto = bbsServ.getBBS(seq);
		new bbsUpdateView(dto);
	}
	
	public void bbsUpdateAf(int seq, String title, String content) {
		boolean b = bbsServ.bbsUpdate(seq, title, content);
		if(b) {
			JOptionPane.showMessageDialog(null, "성공적으로 수정되었습니다");
			getBbsList();
		}else {
			JOptionPane.showMessageDialog(null, "수정되지 못했습니다");
			BbsDto dto = bbsServ.getBBS(seq);
			new bbsUpdateView(dto);
		}
	}
}





