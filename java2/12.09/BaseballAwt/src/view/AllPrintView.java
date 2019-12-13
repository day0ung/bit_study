package view;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class AllPrintView extends JFrame {

	JTable pitcherTable;
	JScrollPane scrPane;
	
	String pitcherNames[] = {
			"포지션", "번호", "이름", "나이", "신장", "승", "패", "방어율"
	};
	
	Object pitcherData[][];
	
	public AllPrintView() {
		super("AllPrintView");
		
		
		
		Singleton s = Singleton.getInstance();		
		
		pitcherData = new Object[s.map.size()][pitcherNames.length];
		int w = 0;
		Iterator<String> it = s.map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Human h = s.map.get(key);
			if(h instanceof Pitcher) {				
				Pitcher p = (Pitcher)h;				
				pitcherData[w][0] = "투수";
				pitcherData[w][1] = p.getNumber();
				pitcherData[w][2] = p.getName();
				pitcherData[w][3] = p.getAge();
				pitcherData[w][4] = p.getHeight();
				pitcherData[w][5] = p.getWin();
				pitcherData[w][6] = p.getLose();
				pitcherData[w][7] = p.getDefence();					
				w++;
			}			
		}	
		
		setLayout(null);
		
		JLabel label = new JLabel("투수");
		label.setBounds(10, 10, 200, 30);
		add(label);
				
		pitcherTable = new JTable(pitcherData, pitcherNames);
		scrPane = new JScrollPane(pitcherTable);
		scrPane.setBounds(10, 50, 600, 300);
		add(scrPane);
				
		setBounds(0, 0, 640, 480);
		setBackground(Color.gray);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}



