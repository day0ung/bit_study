package WindowChange;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowOne extends Frame implements WindowListener {
	
	public WindowOne() {
		
		
		setLayout(null);
		//버튼만들기
		Button btn = new Button("move win");
		btn.setBounds(100, 100, 100, 30); //버튼크기와 위치
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.win1.setVisible(false);
				s.win2.setVisible(true);
			}
		});
		add(btn);
		
		
		setSize(640, 480); 
		setLocation(0, 0); 
		setBackground(Color.RED);
		setVisible(false); // 2번째방법사용하기위해서 싱글턴사용
		
		addWindowListener(this);
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
