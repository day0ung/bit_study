package view;

import java.awt.Color;
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
import dto.OrderDTO;
import singleton.Singleton;

public class selectedOrderView extends JFrame{
	
	private JTable jtable;
	private JScrollPane jscrPane;
	
	Object rowData[][];	
	DefaultTableModel model;
	String columnNames[] = {
			"number","Espresso Beverages", "Size", "Syrup","shot", "Whip","Price"	
		};
	
	OrderDTO dto = null;
	public selectedOrderView(OrderDTO dto) {

		setLayout(null);
		
		this.dto = dto;
		

		rowData = new Object[1][7];
		for (int i = 0; i < 1; i++) {

			rowData[i][0] =dto.getSeq();
			rowData[i][1] = dto.getBeverages();
			rowData[i][2] = dto.getCsize();
			rowData[i][3] = dto.getSyrup();
			rowData[i][4] = dto.getShot();
			rowData[i][5] = dto.getWhip();
			//rowData[i][6] = dto.getcup();
		}
		
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		jtable = new JTable(model);
		jtable.getColumnModel().getColumn(0).setMaxWidth(80);	
		jtable.getColumnModel().getColumn(1).setMaxWidth(80);	
		jtable.getColumnModel().getColumn(2).setMaxWidth(80);
		jtable.getColumnModel().getColumn(3).setMaxWidth(80);
		jtable.getColumnModel().getColumn(4).setMaxWidth(80);
		jtable.getColumnModel().getColumn(5).setMaxWidth(80);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 560, 200);
		add(jscrPane);
		
		JButton orderBtn = new JButton("주문하기");
		orderBtn.setBounds(300, 300, 100, 50);
		add(orderBtn);
		orderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.orderCtrl.getOrdered();
				dispose();
			}
		});
		getContentPane().setBackground(Color.white);
		setBounds(200, 200, 600, 800);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
	}
}
