package service.impl;

import java.util.List;

import dao.MenuDao_;
import dao.impl.MenuDaoImple_;
import dto.MenuDto;
import dto.OrderDto;
import service.MenuService;

public class MenuServiceImpl implements MenuService {
	MenuDao_ menuDao = new MenuDaoImple_();
	
	@Override
	public List<MenuDto> getMenuList() {
		return menuDao.getMenuList();
	}

	@Override
	public MenuDto getMenuInfo(String menu) {
		
		return menuDao.getMenuInfo(menu);
	}

}
