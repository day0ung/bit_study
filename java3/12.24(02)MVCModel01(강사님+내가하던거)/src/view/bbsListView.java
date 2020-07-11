package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.BbsDto;
import javabean.BbsDao;
import javabean.MemberDao;

public class bbsListView extends JFrame implements MouseListener {
	private JTable jtable;
	//영역을 지정하는 것 scrolllpane
	private JScrollPane jscrPane;
	private JButton writeBtn;
	private JButton logoutBtn;
	
	//coulmn title 적어주는 부분
	String columnNames[] = {
			"번호", "제목", "작성자"
	};
	
	Object rowData[][]; //데이터를 집어넣을 곳
	
	DefaultTableModel model; //table의 넓이(폭)를 설정하기 위해서 필요함
	
	List<BbsDto> list = null; //dao에서 생성되기 때문에 생성할 필요없이서 null
	
	public bbsListView() {
		super("게시판");
		
		setLayout(null);
		JLabel label  = new JLabel("게시판");
		label.setBounds(10, 10, 120, 15);
		add(label);
		
		//dao(=db)를 통해서 list를 취득 list는 나중에 필요하니 멤버변수 선언
		BbsDao dao = BbsDao.getInstance();
		list = dao.getBbsList(); //db에서 데이터 꺼내 오는 것
		
		//Jtable의 row(갯수)생성
		rowData = new Object[list.size()][3];  //3은  "번호", "제목", "작성자"임
		
		//list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			//데이터 꺼내오기 위해 dto생성
			BbsDto dto = list.get(i);
			
			rowData[i][0] = i +1; //sequence넘버아니고 글의 번호임
			rowData[i][1] = dto.getTitle(); //글의 제목
			rowData[i][2] = dto.getId(); //작성자
		}
		
		//테이블 관련(UI)
		//table 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames); 
		//  rowdata = for문에서 만든 데이터들,  columnNames =  "번호", "제목", "작성자"
		
		//테이블생성
		jtable = new JTable(model);
		jtable.addMouseListener(this); //테이블을 클릭했을때 datail화면 == 내용을 보려고
		
		//column들의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(50); //번호가 들어갈 폭
		jtable.getColumnModel().getColumn(1).setMaxWidth(500); //Title제목이 들어갈 폭
		jtable.getColumnModel().getColumn(2).setMaxWidth(200); //작성자
	
		//실질적으로 눈으로 보는 테이블
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane); 
		
		
		writeBtn = new JButton("글쓰기");
		writeBtn.setBounds(10, 380, 100, 20);
		writeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "글추가 버튼");
					dispose();
					new bbsWriteView();
			}
		});
		add(writeBtn);
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(510, 10, 100, 20);
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDao dao = MemberDao.getInstance();
				dao.setLoginID(""); //dao로 접근하고 아이디를 비우기 위해서
				dispose();
				new loginView();
			}
		});
		add(logoutBtn);
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowNum = jtable.getSelectedRow();	
		JOptionPane.showMessageDialog(null,rowNum);
		
		if(list.get(rowNum).getDel() == 1) {
			System.out.println("list.get(rowNum).toString():"+list.get(rowNum).toString());
			JOptionPane.showMessageDialog(null, "이 글은 볼 수 없습니다");
			return;
		}
				
		JOptionPane.showMessageDialog(null, "선택한 글 정보:" + list.get(rowNum).toString());
		
		new bbsDetailView(list.get(rowNum).getSeq());
		this.dispose();		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
