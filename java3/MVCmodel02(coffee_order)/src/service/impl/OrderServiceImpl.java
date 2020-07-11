package service.impl;

import java.util.List;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import dto.MenuDTO;
import dto.OrderDTO;
import service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = new OrderDaoImpl();

	@Override
	public List<MenuDTO> getMenu() {
		return dao.getMenu();
	}

	@Override
	public boolean addorder(OrderDTO dto) {
		return dao.addorder(dto);
	}

	@Override
	public List<OrderDTO> getOrdered() {
		return dao.getOrdered();
	}
}
