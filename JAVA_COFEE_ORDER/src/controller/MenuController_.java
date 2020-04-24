package controller;

import java.util.List;


import dto.MenuDto;
import service.MenuService;
import service.OrderService;
import service.impl.MenuServiceImpl;
import service.impl.OrderServiceImple;

public class MenuController_ {
	MenuService menuServ = new MenuServiceImpl();
	
	public List<MenuDto> getMenuList() {
		return menuServ.getMenuList();
	}
	
	public MenuDto getMenuInfo(String menu) {
		return menuServ.getMenuInfo(menu);
	}
}
