package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuView extends JFrame {
	JLabel menuLabel, sizeLabel, shortLabel, tallLabel, GrandeLabel;
	JLabel[] jMenu, shortPrice, tallPrice, GrandePrice;
	String[] strMenu = { "에스프레소", "헤이즐넛 카라멜 모카", "카라멜 마끼아또", "화이트 초콜릿 모카", "카라멜 모카", "카페 모카", "카라멜 라떼", "카푸치노", "아메리카노",
			"오늘의 커피" };
	String[] strShortPrice = { "4800", "4300", "4300", "4300", "4300", "3800", "3300", "3300", "2800", "2500" };

	public MenuView() {
		
		setLayout(null);
		
		menuLabel = new JLabel("가격표");
		menuLabel.setBounds(450, 30, 100, 30);
		// 메뉴
		add(menuLabel);
		
		sizeLabel = new JLabel("사이즈");
	    sizeLabel.setBounds(40, 100, 200, 30);
	    add(sizeLabel);
		jMenu = new JLabel[strMenu.length];
		for (int i = 0; i < jMenu.length; i++) {
			jMenu[i] = new JLabel(strMenu[i]);
			jMenu[i].setBounds(40, 140 + 30 * i, 200, 30);

			add(jMenu[i]);
		}
		
		shortLabel = new JLabel("Short");
		shortLabel.setBounds(240, 100, 200, 30);
	    add(shortLabel);
		shortPrice = new JLabel[strShortPrice.length];
		for (int i = 0; i < shortPrice.length; i++) {
			shortPrice[i] = new JLabel(strShortPrice[i]);

			shortPrice[i].setBounds(240, 140 + 30 * i, 200, 30);
			add(shortPrice[i]);
		}
		
		tallLabel = new JLabel("Tall");
		tallLabel.setBounds(440, 100, 200, 30);
	    add(tallLabel);
		tallPrice = new JLabel[strShortPrice.length];
		for (int i = 0; i < shortPrice.length; i++) {
			tallPrice[i] = new JLabel((Integer.parseInt(strShortPrice[i]) + 500) + "");

			tallPrice[i].setBounds(440, 140 + 30 * i, 200, 30);
			add(tallPrice[i]);
		}

		GrandeLabel = new JLabel("Grande");
		GrandeLabel.setBounds(640, 100, 200, 30);
	    add(GrandeLabel);
		GrandePrice = new JLabel[strShortPrice.length];
		for (int i = 0; i < shortPrice.length; i++) {
			GrandePrice[i] = new JLabel((Integer.parseInt(strShortPrice[i]) + 1000) + "");
			GrandePrice[i].setBounds(640, 140 + 30 * i, 200, 30);
			add(GrandePrice[i]);
		}

		setBounds(100, 100, 800, 700);
		setLocation(1100, 100);
		setVisible(true);
	}
}
