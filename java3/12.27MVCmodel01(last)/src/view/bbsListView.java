package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.BbsDto;
import javabean.BbsDao;
import javabean.MemberDao;

public class bbsListView extends JFrame implements MouseListener, ActionListener {
	
	private JTable jtable;
	private JScrollPane jscrPane;
	
	private JButton writeBtn;
	private JButton logoutBtn;
	
	String columnNames[] = {
		"번호", "제목", "작성자"	
	};
	
	Object rowData[][];	
	DefaultTableModel model;	// table의 넓이를 설정
	
	// 검색
	private JComboBox<String> choiceList;
	private JTextField selectField;
	private JButton selectBtn;
	
	
	List<BbsDto> list = null;
	
	public bbsListView() {
		super("게시판");
		
		setLayout(null);
				
		JLabel label = new JLabel("게시판");
		label.setBounds(10, 10, 120, 15);
		add(label);
		
		// dao를 통해서 list를 취득
		BbsDao dao = BbsDao.getInstance();
		list = dao.getBbsList();
		
		// jtable row를 생성
		rowData = new Object[list.size()][3];
		
		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			BbsDto dto = list.get(i);
			
			rowData[i][0] = i + 1;			// 글의 번호
			if(dto.getDel() == 1) {		// 글제목
				rowData[i][1] = "  ******이 글은 삭제되었습니다*****";
			}else {
				rowData[i][1] = dto.getTitle();
			}			
			rowData[i][2] = dto.getId();	// 작성자
		}
		
		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		// 테이블 생성
		jtable = new JTable(model);
		jtable.addMouseListener(this);
			
		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(50);	// 번호
		jtable.getColumnModel().getColumn(1).setMaxWidth(500);	// 제목
		jtable.getColumnModel().getColumn(2).setMaxWidth(200);	// 작성자
		
		
		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
		
		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
		
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		writeBtn = new JButton("글쓰기");
		writeBtn.setBounds(10, 380, 100, 20);
		writeBtn.addActionListener(this);
		add(writeBtn);
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(510, 10, 100, 20);	
		logoutBtn.addActionListener(this);
		add(logoutBtn);
		
		
		
		// 검색		
		String selects[] = new String[]{ "선택", "제목", "내용", "작성자" };
		choiceList = new JComboBox<String>(selects);
		choiceList.setBounds(150, 380, 80, 20);
		add(choiceList);
		
		selectField = new JTextField();
		selectField.setBounds(250, 380, 150, 20);
		add(selectField);
		
		selectBtn = new JButton("search");
		selectBtn.addActionListener(this);
		selectBtn.setBounds(420, 380, 100, 20);
		add(selectBtn);
		
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
				
		if(obj == logoutBtn){
			MemberDao dao = MemberDao.getInstance();
			dao.setLoginID("");
			
			this.dispose();
			new loginView();			
		}
		else if(obj == writeBtn){
			this.dispose();
			new bbsAddView();	
		}	
		else if(obj == selectBtn) {
		//	JOptionPane.showMessageDialog(null, "search button");
			
			// 무엇을 선택 == 제목,내용,작성자
			String selectedItem = (String)choiceList.getSelectedItem();
			// JOptionPane.showMessageDialog(null, selectedItem);
			
			// db에 접근 -> 검색된 글들
			BbsDao dao = BbsDao.getInstance();
			list = dao.getSelectList(selectedItem, selectField.getText());
			
			// 확인
			if(list.size() == 0 || selectField.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "검색한 단어로 데이터를 찾지 못했습니다");
				// 원본의 list를 호출
				list = dao.getBbsList();
			}
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			
			
			// table data와 table을 갱신하는 부분
			
			// jtable row를 생성
			rowData = new Object[list.size()][3];
			
			// list에서 테이블로 데이터를 삽입하기 위한 처리
			for (int i = 0; i < list.size(); i++) {
				BbsDto dto = list.get(i);
				
				rowData[i][0] = i + 1;			// 글의 번호
				if(dto.getDel() == 1) {		// 글제목
					rowData[i][1] = "  ******이 글은 삭제되었습니다*****";
				}else {
					rowData[i][1] = dto.getTitle();
				}			
				rowData[i][2] = dto.getId();	// 작성자
			}				
			model.setDataVector(rowData, columnNames);
			
			// column의 폭을 설정
			jtable.getColumnModel().getColumn(0).setMaxWidth(50);	// 번호
			jtable.getColumnModel().getColumn(1).setMaxWidth(500);	// 제목
			jtable.getColumnModel().getColumn(2).setMaxWidth(200);	// 작성자
			
			
			// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
			
			// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
			jtable.getColumn("번호").setCellRenderer(celAlignCenter);
			jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
						
			jtable.setModel(model);			
		}
		
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowNum = jtable.getSelectedRow();	
		
		if(list.get(rowNum).getDel() == 1) {
			JOptionPane.showMessageDialog(null, "이 글은 볼 수 없습니다");
			return;
		}
				
		JOptionPane.showMessageDialog(null, "선택한 글 정보:" + list.get(rowNum).toString());
		
		new bbsDetailView(list.get(rowNum).getSeq());
		this.dispose();		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
