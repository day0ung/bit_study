package controller;


import java.util.List;

import javax.swing.JOptionPane;

import dto.MenuDTO;
import dto.OrderDTO;
import service.OrderService;
import service.impl.OrderServiceImpl;
import view.getOrderedView;
import view.menuView;
import view.selectedOrderView;

public class OrderController {
	OrderService orderServ = new OrderServiceImpl();
	
	public void menulist() {
		List<MenuDTO> list = orderServ.getMenu();
		new menuView(list);
	}
	
	public void showOrderList(OrderDTO dto) {		
			new selectedOrderView(dto);		
	
	}
	
	public void getOrderList(OrderDTO dto) {
		boolean b = orderServ.addorder(dto);
		
		if(b){			
			JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
			new selectedOrderView(dto);
		}else{
			JOptionPane.showMessageDialog(null, "추가되지 못했습니다");
		}
	
	}
	
	public void getOrdered() {
		List<OrderDTO> list = orderServ.getOrdered();
		new getOrderedView(list);
	}
}
