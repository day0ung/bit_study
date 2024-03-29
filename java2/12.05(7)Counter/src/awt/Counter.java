package awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Counter extends JFrame  {
	
	Button plusBtn, minusBtn, reset;
	Label label;
	int count;


	public Counter() {
		
		super("버튼누르면 카운트를세는 과제");

		count = 0;
	    setLayout(new GridLayout(3, 1));
		
		label = new Label("Count" +count);
		label.setBounds(100, 100, 300, 30);
		add(label);
		
		//아래부분		
		
		Panel panel = new Panel();
		panel.setBackground(Color.BLUE);
		panel.setLayout(new GridLayout(1, 2));
		add(panel);
		
		plusBtn = new Button("PLUS");
		plusBtn.setBackground(Color.GREEN);
		panel.add(plusBtn);
		plusBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
				Button btn = (Button) e.getSource(); // 클릭면가져오는것
				String btnTitle = btn.getLabel();
				if (btnTitle.equals("PLUS")) {
					count++;
					label.setText(count + "");
				}
			}
		});
		
		minusBtn = new Button("MINUS");
		minusBtn.setBackground(Color.RED);
		panel.add(minusBtn);
		minusBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Button btn = (Button) e.getSource(); // 클릭면가져오는것
				String btnTitle = btn.getLabel();
				if (btnTitle.equals("MINUS")) {
					count--;
					label.setText(count + "");
				}
			}
		});
		
		reset = new Button("RESET");
		reset.setBackground(Color.GRAY);
		add(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Button btn = (Button) e.getSource(); // 클릭면가져오는것
				String btnTitle = btn.getLabel();
				if (btnTitle.equals("RESET")) {
					label.setText(0 + "");
				}
				
			}
		});
		
		
		setSize(800, 600);
		setLocation(100, 0);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
	}
}
