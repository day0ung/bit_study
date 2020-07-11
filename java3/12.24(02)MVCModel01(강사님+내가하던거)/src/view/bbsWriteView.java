package view;

import java.awt.Color;
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

public class bbsWriteView extends JFrame{
	JLabel id;
	JLabel title;
	JLabel content;
	
	JTextField idTextF;
	JTextField titleTextF;
	JTextArea contentA;
	
	JButton btn;
	JButton backBtn;
	
	public bbsWriteView() {
		super("글쓰기 창");
		setLayout(null);
		
		id = new JLabel("ID");
		id.setBounds(100, 20, 120, 15);
		add(id);
		
		MemberDao mdao = MemberDao.getInstance();
		
		title = new JLabel("제목");
		title.setBounds(100, 60, 120, 15);
		add(title);
		
		content = new JLabel("내용");
		content.setBounds(100,100, 120, 15);
		add(content);
		
		idTextF = new JTextField();
		idTextF.setBounds(200, 20, 150, 20);
		add(idTextF);
		
		titleTextF = new JTextField();
		titleTextF.setBounds(200, 60, 150, 20);
		add(titleTextF);
		
		contentA = new JTextArea();
		contentA.setLineWrap(true);
		
		JScrollPane  scrPane = new JScrollPane(contentA);
		scrPane.setPreferredSize(new Dimension(200,600)); //텍스트에어리어의 사이즈
		scrPane.setBounds(100, 130, 460, 200);
		add(scrPane);

		btn = new JButton("글올리기");
		btn.setBounds(150, 380, 100, 20);		
		add(btn);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = mdao.getLoginID();
				String title = titleTextF.getText();
				String content = contentA.getText();
				
				BbsDao bdao = BbsDao.getInstance();
				
				BbsDto dto = new BbsDto(0, id, title, content, null, 0, 0);
				boolean b = bdao.writeBBS(dto);
				
				if(b) {
					JOptionPane.showMessageDialog(null,	"성공적으로 추가되었습니다." );
					dispose();
					new bbsListView();
				}else {
					JOptionPane.showMessageDialog(null,	"추가되지 못했습니다." );
				}
				
				
			}
		});
		backBtn = new JButton("목록");
		backBtn.setBounds(350, 380, 100, 20);		
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new bbsListView();
				
			}
		});
		add(backBtn);
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
