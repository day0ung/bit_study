package WindowChangePanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PanelOne extends Panel{
	WindowTest wt; 
	public PanelOne(WindowTest wt) {
		this.wt = wt;
		setLayout(null);
		
		Button btn = new Button("window");
		btn.setBackground(Color.CYAN);
		btn.setBounds(100, 100, 100, 30);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				wt.removeAll();
				wt.add(new PanelTwo(wt));
			}
		});
		add(btn);
		
		setBounds(0,0,640, 800);
		setBackground(Color.red);
	}
}
