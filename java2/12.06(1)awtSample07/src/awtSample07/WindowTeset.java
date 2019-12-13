package awtSample07;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class WindowTeset extends Frame implements WindowListener, ItemListener {
//체크박스와 레디오버튼?
	Checkbox cb1, cb2, cb3, cb4, cb5, cb6;
	Label label1, label2;
	
	JRadioButton rb;
	public WindowTeset() {
		/*
		  	Check Box(취미)
		  	Radio Button 다중선택 불가능, 하나를키면하나는 꺼짐
		  	
		  	AWT: radio -> checkbox
		  	swing : JRadioButton
		 */
		//그룹으로 묶어주는 부분
		CheckboxGroup cbg1 = new CheckboxGroup();
		//cb1, cb2, cb3 <- 1group
		cb1 = new Checkbox("사과", cbg1, true); //첫번째 레이블,그룹 , 상태 (t,f)
		cb2 = new Checkbox("딸기", cbg1, false);
		cb3 = new Checkbox("바나나", cbg1, false);
		//cb4, cb5 <- 2group
		CheckboxGroup cbg2 = new CheckboxGroup();
		cb4 = new Checkbox("남성", cbg2, true); //true하나만 켜놓는것, 래디오버튼 둘다 true해놓으면 마지막것이 꺼짐
		cb5 = new Checkbox("여성", cbg2, false);
		//cb6  <- checkbox
		cb6 = new Checkbox("exit");
		
		
		
		label1 = new Label("label1");
		label2 = new Label("label2");
		
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(cb6);
		
		//메세지박스나오게
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cb5.addItemListener(this);
		cb6.addItemListener(this);
		
		
		
		add(label1);
		add(label2);
		
		setLayout(new FlowLayout()); //옆으로 쭉나오게하는것 
		

		
		setSize(640, 480); 
		setLocation(100, 0); 
		setVisible(true); 
		
		addWindowListener(this); //스위치키는것, 윈도우리스너 (this)인스턴스값이 어디있는지적어주는것
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
	//	JOptionPane.showMessageDialog(null, "체크");
						//값을 얻어올때 쓰는것 getSource
		Object obj = e.getSource();
		Checkbox cb = (Checkbox)obj;
		
		//radio button
				
		
		if(obj == cb6) {  //checkbox
			cb = (Checkbox)obj;
			if(cb.getState()) { //true체크가 됬을때
				JOptionPane.showMessageDialog(null, "체크되었음");
			}else {
				JOptionPane.showMessageDialog(null, "체크취소됨");
			}
		}else if(obj == cb1 || obj == cb2 ||obj == cb3) {//그 외의것radio button
			if(cb.getState()) { //현재상태가 t였을때
				label1.setText( cb.getLabel()); //현재선택되어진부분의 레이블값(사과,배,등등)을 레이블 1에 셋해라	
			}
		}else if(obj == cb4 || obj == cb5) {
			if(cb.getState()) { //현재상태가 t였을때
				label2.setText( cb.getLabel());
			}
		}
	}
	
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	

}
