package awtMouseEven;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener, MouseListener, MouseMotionListener {

	Label label;
	int x,y;
	public WindowTest() {
		super("");
		setLayout(null);
		
		label = new Label("x = y = ");
		label.setBounds(50,100,200,30);
		add(label);
		
		setSize(800,600);
		setLocation(100, 0);
		setVisible(true);
		
		addWindowListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		
	}
	
	//MouseMoved >>이거사용하려면 다른것을 상속받아야함

	
	@Override
	public void mouseClicked(MouseEvent e) {
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


	@Override
	public void mousePressed(MouseEvent e) { //클릭했을때
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
		/*
		//좌표값얻어올때
		x = e.getX();
		y = e.getY();
		
		//레이블에 올려줌
		label.setText("x = " +x + "y = " +y);
		*/
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		label.setText("x = " + x + " y = " + y);
		label.setBounds(x, y, 200, 30);
		
	}



}
