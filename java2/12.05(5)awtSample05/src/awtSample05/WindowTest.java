package awtSample05;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowTest extends Frame implements WindowListener /*,ActionListener*/ {
	Label label; //멤버변수
	Button btn1, btn2;
	public WindowTest() {
		super("간단한 예제");
		
		setLayout(null);
		/*
		   resource(자원) : button , panel, text field 
		   -> 데이터를얻어오려면 지정되어있는 주소값을얻어와야함 주소값 == Handel(번호)
		   //버튼의 번호가 몇이냐, 즉 변수명이 뭐냐   
		 */
		label = new Label("레이블");
		label.setBounds(100, 100, 300, 30);
		add(label);
		/*
		btn1 = new Button("버튼 one");
		btn1.setBounds(100, 160, 150, 30);
		btn1.addActionListener(this); //버튼클릭할때 메소드(actionPerformed) 호출해라
		add(btn1);
		
		btn2 = new Button("버튼 two"); //버튼 1옆에다두려고 300잡음
		btn2.setBounds(300, 160, 150, 30);
		btn2.addActionListener(this);
		add(btn2);
		//버튼을추가하였을때는 반응을 해줘야함, ActionListener 버튼을 클릭하면 이벤트발생 == action/ 메소드 오버라이딩해야함
		*/
		
		//버튼을 하나만썻을때 
		btn1 = new Button("버튼 one");
		btn1.setBounds(100, 160, 150, 30);
		btn1.addActionListener(new ActionListener() { //괄호안에 new ActionListener
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("one 버튼이 클릭!!");
				
			}
		});
		add(btn1);
		
		
		setSize(640, 480); // 윈도우의 크기(폭, 높이)
		setLocation(100, 0); //윈도우가 실행 위치(x오른쪽으로갈수록 늘어남, y 밑으로내려갈수록 늘어남)
		setVisible(true); // 윈도우 시각화
		
		addWindowListener(this); //스위치키는것, 윈도우리스너 (this)인스턴스값이 어디있는지적어주는것
	}
	/*
	@Override
	public void actionPerformed(ActionEvent e) { // ActionListener
	//	JOptionPane.showMessageDialog(null, "버튼클릭!");
		
		//버튼클릭 구분하는방법(파라미터로들어오는것 e)
		Button btn = (Button)e.getSource(); //클릭하면 e값을가져오는것
		//("버튼 two"); ==title
		String btnTitle = btn.getLabel(); //타이틀값을 얻어오는것
		
		if(btnTitle.equals("버튼 one")) {
			label.setText("one 버튼이 클릭되었습니다.");
			
		}else if(btnTitle.equals("버튼 two")) {
			label.setText("two 버튼이 클릭되었습니다.");
		}
		
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
		// TODO Auto-generated method stub
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
