package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.MenuDTO;
import singleton.Singleton;

public class menuView extends JFrame{
	private JTable jtable;
	private JScrollPane jscrPane;
	
	String columnNames[] = {
			"Espresso Beverages", "Short", "Tall", "Grande"	
		};
	Object rowData[][];	
	DefaultTableModel model;
	
	List<MenuDTO> list = null;
	
	public menuView(List<MenuDTO> list) {
		super("메뉴보기");
		setLayout(null);
		
		JLabel label = new JLabel("가격표");
		label.setBounds(250, 10, 200, 50);
		add(label);
		
		this.list = list;
		
		rowData = new Object[list.size()][4];
		
		for (int i = 0; i < list.size(); i++) {
			MenuDTO dto = list.get(i);
			rowData[i][0] = dto.getBeverages();
			rowData[i][1] = dto.getShort();
			rowData[i][2] = dto.getTall();
			rowData[i][3] = dto.getGrande();
		}
		
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		jtable = new JTable(model);
		jtable.getColumnModel().getColumn(0).setMaxWidth(320);	
		jtable.getColumnModel().getColumn(1).setMaxWidth(80);	
		jtable.getColumnModel().getColumn(2).setMaxWidth(80);
		jtable.getColumnModel().getColumn(3).setMaxWidth(80);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 560, 200);
		add(jscrPane);
		
		JButton backBtn = new JButton("돌아가기");
		backBtn.setBounds(300, 300, 100, 50);
		add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.memCtrl.order();
				dispose();
			}
		});
		
		
		setBounds(100, 100, 600, 500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
