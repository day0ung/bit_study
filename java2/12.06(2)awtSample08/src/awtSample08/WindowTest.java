package awtSample08;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener/*, ItemListener*/ {
	
	Choice choice;
	Label label;
	
	public WindowTest() {
		//AWT 	- Choice
		//swing - JCombobox
		setLayout(new FlowLayout());
		
		choice = new Choice();
		choice.add("사과");
		choice.add("망고");
		choice.add("오렌지");
		choice.add("포도");
		choice.add("배");
		
		//choice.addItemListener(this);
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label.setText(choice.getSelectedItem()); //레이블에 텍스트를 넣음, 
				//인스턴스값이 초이스임, 
				
			}
		});
		
		add(choice);
		
		//선택되어진것을 보기위해 레이블 생성
		label = new Label("---");
		add(label);
		
		
		
		setSize(640, 480); 
		setLocation(100, 0); 
		setVisible(true); // 윈도우 시각화
		
		addWindowListener(this);
	}
	
	/*
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice ch = (Choice)e.getSource(); //섞어쓸때는 소스를 오브젝트로받아놓고 변경해줘야함, 체크박스처		
		String selected = ch.getSelectedItem(); //현재스트링이 넘어옴	
		//레이블에 집어넣기
		label.setText(selected);
		
	}
	*/
	
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
