package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import dto.BbsDto;
import javabean.BbsDao;
import javabean.MemberDao;

public class bbsDetailView extends JFrame {
		
	
	JTextField idTextfield;
	JTextField wdateTextfield;
	JTextField readCountTextfield;
	JTextField titleTextfield;
	
	JTextArea contentArea;
	
	public bbsDetailView(int seq) {
		super("내용 보기");		
		
		BbsDao dao = BbsDao.getInstance();
		dao.readCount(seq);		
		BbsDto dto = dao.getBBS(seq);
				
		setLayout(null);
		
		System.out.println("c = " + dto.toString());
		
		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 10, 60, 15);
		add(writerLabel);
				
		idTextfield = new JTextField(dto.getId());
		idTextfield.setBounds(120, 10, 200, 20);
		idTextfield.setEditable(false);		
		add(idTextfield);
		
		JLabel writedLabel = new JLabel("작성일:");
		writedLabel.setBounds(10, 40, 60, 15);
		add(writedLabel);
		
		wdateTextfield = new JTextField(dto.getWdate());
		wdateTextfield.setBounds(120, 40, 200, 20);
		wdateTextfield.setEditable(false);		
		add(wdateTextfield);
		
		JLabel readLabel = new JLabel("조회수:");
		readLabel.setBounds(10, 70, 60, 15);
		add(readLabel);
		
		readCountTextfield = new JTextField(dto.getReadcount() + "");
		readCountTextfield.setBounds(120, 70, 200, 20);
		readCountTextfield.setEditable(false);		
		add(readCountTextfield);
		
		JLabel titleLabel = new JLabel("제목:");
		titleLabel.setBounds(10, 100, 60, 15);
		add(titleLabel);
		
		titleTextfield = new JTextField(dto.getTitle());
		titleTextfield.setBounds(120, 100, 300, 20);
		titleTextfield.setEditable(false);		
		add(titleTextfield);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 130, 60, 15);
		add(contentLabel);
				
		contentArea = new JTextArea(dto.getContent());
		contentArea.setEditable(false);
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 160, 460, 300);
		add(scrPane);		
		
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBounds(10, 480, 100, 20);		
		add(bbsBtn);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setBounds(260, 480, 100, 20);		
		add(deleteBtn);
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		
		// updatebutton
		JButton updateBtn = null;		
		updateBtn = new JButton("수정");
		updateBtn.setBounds(150, 480, 100, 20);
		add(updateBtn);
		
		// 수정버튼의 비활성화(같은 id일 경우만)
		if(!dto.getId().equals(MemberDao.getInstance().getLoginID())){
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);			
		}
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				new bbsUpdate(seq);
				dispose();
			}
		});
		deleteBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				BbsDao dao = BbsDao.getInstance();
				if(dao.deleteBbs(seq)) {
					JOptionPane.showMessageDialog(null, "글을 삭제하였습니다");
				}else {
					JOptionPane.showMessageDialog(null, "글이 삭제되지 않았습니다");
				}
				new bbsListView();	
				dispose();
			}
		});
		
				
		bbsBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {					
				new bbsListView();
				dispose();
			}
		});
	}

}
