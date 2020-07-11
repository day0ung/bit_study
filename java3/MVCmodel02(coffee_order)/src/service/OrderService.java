package service;

import java.util.List;

import dto.MenuDTO;
import dto.OrderDTO;

public interface OrderService {
	public List<MenuDTO> getMenu();
	
	public boolean addorder(OrderDTO dto);
	
	public List<OrderDTO> getOrdered();
}
