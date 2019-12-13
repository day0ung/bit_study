package game;



import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;

public class GbbGame extends JFrame {
	Scanner sc = new Scanner(System.in);

	Button rock, sicssors, paper;
	int userNum, comNum;
	int win, lose, draw;
	int result;
	Label  label;
	
	public GbbGame() {
		super("가위바위보 게임 과제");
		
		win  = 0;
		lose = 0;
		draw = 0;
		result =0;
		
		setLayout(new GridLayout(4,1));
		//위에칸
		label = new Label("[----WIN "+win+"----]" +
		"[----LOSE" + lose +"----]"+ "[----DRAW" + draw+"----]");
		label.setBounds(10, 10, 300, 30);
		label.setBackground(Color.lightGray);
		add(label);
		
		//2번째칸
		
		Panel play = new Panel();
		
		play.setLayout(new GridLayout(1, 3));
		add(play);
		
		Label l1 = new Label("Player");
		l1.setBackground(Color.magenta);
		play.add(l1);
			
		Label l2 = new Label("vs");
		l2.setBackground(Color.magenta);
		play.add(l2);
		
		Label l3 = new Label("Computer");
		l3.setBackground(Color.magenta);
		play.add(l3);
		
		//3번째칸
		Panel result = new Panel();
		result.setLayout(new GridLayout(1,3));
		
		add(result);
		Label r1 = new Label("Player result");
		r1.setBackground(Color.CYAN);
		result.add(r1);
			
		Label r2 = new Label("result");
		r2.setBackground(Color.lightGray);
		result.add(r2);
		
		Label r3 = new Label("Computer result");
		r3.setBackground(Color.CYAN);
		result.add(r3);
		
		//4번째칸
		Panel gbb = new Panel();
		gbb.setLayout(new GridLayout(1, 3));
		add(gbb);
		
		rock = new Button("Rock");
		gbb.add(rock);
		rock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rock = (int) e.getSource();
				rock = 1;
				label.setText(rock+"");
			}
		});
		
		sicssors = new Button("Scissors");
		gbb.add(sicssors);
		sicssors.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int sicssors = (int)e.getSource();
				sicssors = 0;
				label.setText(sicssors+"");
				
			}
		});
		
		paper = new Button("Paper");
		gbb.add(paper);
		paper.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int paper = (int)e.getSource();
				paper = 2;
				label.setText(paper+"");
				
			}
		});
		

		
		setSize(800, 600);
		setLocation(100, 0);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void randomSet() {
		//random
		comNum =(int)(Math.random()*3);
		System.out.println("comNum ="+comNum);
	}
	
	public String resultMessage() {
		String resultMsg ="";
		switch(result) {
			case 1:
				resultMsg ="이겼습니다.";
				win++;
				break;
			case 0:
				resultMsg = "졌습니다.";
				lose++;
				break;				
			case 2:
				resultMsg ="무승부";
				draw++;
				break;				
		}
		return resultMsg;
	}


	
}