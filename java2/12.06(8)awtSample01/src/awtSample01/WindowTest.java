package awtSample01;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WindowTest extends JFrame implements WindowListener, MouseListener {
	
	JTable table;
	JScrollPane scrPane;
	
	String  columnNames[] = {
			"상품번호"
			, "상품명"
			, "상품가격"
			, "상품회사"
	};
	
	Object rowDatas[][] = {//데이터를 삽입하는 배열
			{1001, "맛동산", 1000, "오리온"},
			{1002, "초코파이", 1200, "해태"},
			{1003, "감자깡", 1500, "롯데"},
	}; 
	
	public WindowTest() {
	
		table = new JTable(rowDatas, columnNames);
		scrPane = new JScrollPane(table); //스크롤에 집어넣을때 테이블을 넣어야함
		add(scrPane); //레이아웃안잡으면 꽉찬화면으로나옴
		
		//클릭을했을때 데이터를 얻어오고싶다 == 마우스로 클릭함(마우스리스너의- 마우스프렛드가 중요
		
		
		setSize(800,600);
		setLocation(100, 0);
		setVisible(true);
		
		table.addMouseListener(this);
		addWindowListener(this);
		//addMouseListener(this); 여기아니고 테이블에 달아줘야함 , 지금반응하는건 윈도우가 아님
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		 
		
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
		int rowNum = table.getSelectedRow();	 
		String item = "상품번호:" +rowDatas[rowNum][0] +"\n"+
					 "상품명: "+rowDatas[rowNum][1] +"\n"+
					 "상품가격" + rowDatas[rowNum][2] +"\n"+
					 "상품회사" + rowDatas[rowNum][3];
		JOptionPane.showMessageDialog(null, item);
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}