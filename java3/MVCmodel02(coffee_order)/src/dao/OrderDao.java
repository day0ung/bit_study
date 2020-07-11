package dao;

import java.util.List;

import dto.MenuDTO;
import dto.OrderDTO;

public interface OrderDao {
	public List<MenuDTO> getMenu();
	
	public boolean addorder(OrderDTO dto);
	
	public List<OrderDTO> getOrdered();
}
