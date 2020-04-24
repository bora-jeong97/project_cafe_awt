package main;

import db.DBConnection;
import singleton.Singleton;
import view.MenuView;
import view.OrderListView;
import view.OrderView;
import view.OrderedListView;


public class mainClass {
	public static void main(String[] args) {
		DBConnection.initConnection();
//		
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();
//		new OrderView();
//		new MenuView();
//		new OrderListView();
//		new OrderedListView();
	}
}
