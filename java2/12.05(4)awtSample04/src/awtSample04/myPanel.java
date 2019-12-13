package awtSample04;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class myPanel extends Panel {
	
	public myPanel() {
		//크기와 높이 잡아 줄 필요 없 음 자동적으로 잡힘
		setLayout(new GridLayout(3,1));
		setBackground(Color.yellow);
		
		Label l1 = new Label("myPanel label1");
		Label l2 = new Label("myPanel label2");
		Label l3 = new Label("myPanel label3");
		
		add(l1);
		add(l2);
		add(l3);
	}
}
