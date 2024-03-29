package awtSample09;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {
	
	Image img = null;
	Image pngImg = null;
			
	
	public WindowTest() {
		setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit(); //이미지를불러오기위해 툴킷 호출
		img = tk.getImage("house.jpg");
		//img = tk.getImage("d:\\tmp\\pig.png");
		//img = tk.getImage("\\\\192.168.3.3\\공유\\경치.gif"); //외부폴더에서 보여주기
		
		pngImg = tk.getImage("bird.png");
		//이미지 뿌려주기위해 오버라이딩하면됨 (윈도우안에 페인트)
		
		
		//이미지크기 얻어오기
		 img.getWidth(this);
		 img.getHeight(this);
		
		setSize(640, 480); 
		setLocation(100, 0); 
		setVisible(true); // 윈도우 시각화
		
		addWindowListener(this);
	}
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		//이미지 크기 얻어오기위해 
		int imgwidth = img.getWidth(this);
		int imgheight = img.getHeight(this);
		setSize(imgwidth, imgheight);
		//이미지 뿌려주기위해서 //img, x, y, observer
		g.drawImage(img, 0, 0, this); //그림경로는 프로젝트에다끌어너 놔야함 src에 넣으면안됨
		//프로젝트의 상대경로에서 불러온것
		
		//하우스 위에다 뿌리기
		g.drawImage(pngImg, 200, 200, this);
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
