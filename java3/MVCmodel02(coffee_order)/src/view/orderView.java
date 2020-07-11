package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dto.MenuDTO;
import dto.OrderDTO;
import singleton.Singleton;

public class orderView extends JFrame implements ActionListener {
	JComboBox<String> choiceList;
	JRadioButton rbShort, rbTall,rbGrande;
	JRadioButton rbV, rbC, rbH;
	JRadioButton rbShot, rbWhip;
	DateFormat date = DateFormat.getDateInstance(DateFormat.LONG);
	JButton menu, orderBtn ;
	JTextField textF;
	ButtonGroup size, syrupBtn;
	
	String csize = null;
	String syrup = null;
	String shot = null;
	String whip = null;

	
	public orderView() {
		super("주문");
		
		
		setLayout(null);
		
		String selects[] = new String[]{ "선택","헤이즐넛 카라멜 모카", "카라멜 마끼아또", "화이트 초콜릿 모카 ", "카라멜 모카"
				+ "카페 모카","카라멜 라떼","카페 라떼","카푸치노","아메리카노","오늘의 커피"};
		choiceList = new JComboBox<String>(selects);
		choiceList.setBounds(120, 70, 200, 20);
		add(choiceList);
		
		JLabel coffee = new JLabel("커피선택:");
		coffee.setBounds(50, 55, 90, 50);
		add(coffee);
		
		menu = new JButton("메뉴보기");
		menu.setBounds(400, 10, 90, 30);
		add(menu);
		menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.orderCtrl.menulist();
			}
		});
		
		//-------------크기 시럽 기타
		
		JPanel sizeP = new JPanel();
		sizeP.setLayout(new GridLayout(4,1));
		sizeP.setBackground(Color.LIGHT_GRAY);
		sizeP.setBounds(50, 150, 100, 150);
		add(sizeP);
		
		JLabel label1 = new JLabel("크기");
		sizeP.add(label1);
		
		size = new ButtonGroup();
		rbShort = new JRadioButton("Short");
		rbTall = new JRadioButton("Tall");
		rbGrande = new JRadioButton("Grande");
		rbShort.addActionListener(this);
		rbTall.addActionListener(this);
		rbGrande.addActionListener(this);
		
		size.add(rbShort);
		size.add(rbTall);
		size.add(rbGrande);
				
		
		sizeP.add(rbShort);
		sizeP.add(rbTall);
		sizeP.add(rbGrande);
		
		JPanel syrupP = new JPanel();
		syrupP.setLayout(new GridLayout(4,1));
		syrupP.setBackground(Color.LIGHT_GRAY);
		syrupP.setBounds(200, 150, 100, 150);
		add(syrupP);
		
		
		JLabel label2 = new JLabel("시럽");
		syrupP.add(label2);
		
		syrupBtn= new ButtonGroup();
		rbV = new JRadioButton("Vanila");
		rbC = new JRadioButton("Caramel");
		rbH = new JRadioButton("Hazelnut");		
		rbV.addActionListener(this);
		rbC.addActionListener(this);
		rbH.addActionListener(this);
		
		syrupBtn.add(rbV);
		syrupBtn.add(rbC);
		syrupBtn.add(rbH);
		
		syrupP.add(rbV);
		syrupP.add(rbC);
		syrupP.add(rbH);
		
		JPanel ectP = new JPanel();
		ectP.setLayout(new GridLayout(4,1));
		ectP.setBackground(Color.LIGHT_GRAY);
		ectP.setBounds(350, 150, 100, 150);
		add(ectP);
		
		
		JLabel label3 = new JLabel("기타");
		ectP.add(label3);
		
		rbShot = new JRadioButton("샷 추가", false);
		rbWhip = new JRadioButton("휘핑 크림", false);
		rbShot.addActionListener(this);
		rbWhip.addActionListener(this);
		
		ectP.add(rbShot);
		ectP.add(rbWhip);
		
		JLabel label4 = new JLabel("다중 선택 가능");
		ectP.add(label4);
		
		
		 textF = new JTextField();
		textF.setBounds(160, 350, 40, 30);
		textF.setBackground(Color.white);
		add(textF);
		
		JLabel label5 = new JLabel("잔");
		label5.setBounds(200, 340, 100, 50);
		add(label5);
		
		orderBtn = new JButton("주문하기");
		orderBtn.setBounds(250, 350, 100, 30);
		add(orderBtn);
		orderBtn.addActionListener(this); 

		
		getContentPane().setBackground(Color.white);
		setBounds(100, 100, 520, 500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Singleton s = Singleton.getInstance();

		Object obj = e.getSource();

		String selectedItem = (String)choiceList.getSelectedItem();
		String cup = null;
		
		
		if(obj == rbShort || obj == rbTall || obj == rbGrande) {			
			JRadioButton rb = (JRadioButton)obj;
			if(rb.isSelected()) {					
				csize =(String) rb.getLabel();					
			}
			
		}else if(obj == rbV || obj == rbC || obj == rbH) {
			JRadioButton rb = (JRadioButton)obj;
			if(rb.isSelected()) {
				syrup =rb.getLabel();	
			}
		}else if(obj == rbShot) {
			JRadioButton rb = (JRadioButton)obj;
			if(rb.isSelected()) {
				shot =rb.getLabel();
			}
		}else if(obj == rbWhip) {
			JRadioButton rb = (JRadioButton)obj;
			if(rb.isSelected()) {
				whip = rb.getLabel();
			}
		}
		else if(obj ==textF) {
			cup = textF.getText();
			
		}
//		else if(obj == orderBtn) {
//			JButton btn = (JButton)obj;
//			OrderDTO dto = new OrderDTO(s.getLoginID(), selectedItem, csize, syrup, shot, whip, cup, price, date);
//			System.out.println(dto.toString());
//			s.orderCtrl.getOrderList(dto);
//			JOptionPane.showMessageDialog(null, dto.toString());
//			
//		}
	}
	
//	public List<MenuDTO> price() {
//		
//		
//		return 10;
//	}
}
