package WindowChangePanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PanelTwo extends Panel {
	WindowTest wt; 
	public PanelTwo(WindowTest wt) {
		this.wt = wt;
		setLayout(null);
		Button btn = new Button("click");
		btn.setBounds(100, 100, 100, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				wt.removeAll();
				wt.add(new PanelOne(wt));
				
			}
		});
		add(btn);
		
		setBounds(0,0,640, 800);
		setBackground(Color.blue);
	}
	
	
	
}
