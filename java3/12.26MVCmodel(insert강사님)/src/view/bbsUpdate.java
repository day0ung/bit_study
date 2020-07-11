package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dto.BbsDto;
import javabean.BbsDao;

public class bbsUpdate extends JFrame{
		
	JTextField idTextfield;
	JTextField wdateTextfield;
	JTextField readCountTextfield;
	JTextField titleTextfield;
	
	JTextArea contentArea;
	
	public bbsUpdate(int seq) {
		super("수정");	
		
		BbsDao dao = BbsDao.getInstance();
		BbsDto dto = dao.getBBS(seq);
		dao.readCount(seq);		
		
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
		add(titleTextfield);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 130, 60, 15);
		add(contentLabel);
				
		contentArea = new JTextArea(dto.getContent());		
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 160, 460, 300);
		add(scrPane);		
		
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBounds(10, 480, 100, 20);		
		add(bbsBtn);
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		
		// updatebutton
		JButton updateBtn = null;		
		updateBtn = new JButton("수정완료");
		updateBtn.setBounds(150, 480, 100, 20);
		add(updateBtn);
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {					
				String title = titleTextfield.getText();
				String content = contentArea.getText();
				
				if(title.equals("") || content.equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸을 모두 작성해 주십시오");
					return;
				}
				
				// 수정부분 db
				boolean b = dao.updateBbs(seq, title, content);
				if(b) {
					JOptionPane.showMessageDialog(null, "성공적으로 수정되었습니다");
					new bbsListView();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "수정되지 못했습니다");
				}				
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
