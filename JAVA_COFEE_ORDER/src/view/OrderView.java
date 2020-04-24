package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dto.MenuDto;
import dto.OrderDto;
import singleton.Singleton;

public class OrderView extends JFrame {
	JLabel sizeLabel, syrupLabel, etcLabel, cupLabel;
	JButton menuBtn, orderBtn, orderedListMenuBtn, cartBtn;
	Choice menuChoice;

	JPanel sizePanel, syrupPanel, etcPanel;

	ButtonGroup sizeGroup, syrupGroup, etcGroup;

	JRadioButton shortRButton, tallRButton, grandeRButton, banilaRButton, caramelButton, hazelnutsRButton, notRButton;

	JCheckBox shotCheckBtn, wheepingCheckBtn;

	JTextField cupTextField;

	public OrderView() {
		setLayout(null);

		orderedListMenuBtn = new JButton("주문 내역");
		orderedListMenuBtn.setBounds(630, 50, 150, 40);
		orderedListMenuBtn.addActionListener(new ActionListener() {
			Singleton s = Singleton.getInstance();

			@Override
			public void actionPerformed(ActionEvent e) {
				s.orderCtrl.getOrderedListView();

			}
		});

		add(orderedListMenuBtn);
//메뉴버튼
		menuBtn = new JButton("Menu Button");
		menuBtn.setBounds(800, 50, 150, 40);
		Singleton s = Singleton.getInstance();

		menuBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s.orderCtrl.getMenuView();

			}
		});

		menuChoice = new Choice();
//		menuChoice.add("에스프레소");
//		menuChoice.add("헤이즐넛 카라멜 모카");
//		menuChoice.add("카라멜 마끼아또");
//		menuChoice.add("화이트 초콜릿 모카");
//		menuChoice.add("카라멜 모카");
//		menuChoice.add("카페 모카");
//		menuChoice.add("카라멜 라떼");
//		menuChoice.add("카푸치노");
//		menuChoice.add("아메리카노");
//		menuChoice.add("오늘의 커피");

//		if()

		List<MenuDto> list = s.menuCtrl.getMenuList();

		for (int i = 0; i < list.size(); i++) {
			menuChoice.add(list.get(i).getMenu());
		}

		menuChoice.setBounds(150, 100, 500, 40);

		// 사이즈
		sizePanel = new JPanel();
		sizePanel.setLayout(new GridLayout(5, 1));
		sizePanel.setBorder(new LineBorder(Color.black, 1));
//		sizePanel.setBorder(BorderFactory.createEmptyBorder(10,	10,	10,	10));

		sizePanel.setBounds(100, 200, 180, 180);

		sizeLabel = new JLabel("크기");
		sizeGroup = new ButtonGroup();

		shortRButton = new JRadioButton("Short");
		tallRButton = new JRadioButton("Tall");
		grandeRButton = new JRadioButton("Grande");

		sizePanel.add(sizeLabel);

		sizeGroup.add(shortRButton);
		sizeGroup.add(tallRButton);
		sizeGroup.add(grandeRButton);

		sizePanel.add(shortRButton);
		sizePanel.add(tallRButton);
		sizePanel.add(grandeRButton);

		//

		// 시럽
		syrupPanel = new JPanel();
		syrupPanel.setLayout(new GridLayout(5, 1, 10, 10));
		syrupPanel.setBorder(new LineBorder(Color.black, 1));
//		sizePanel.setBorder(BorderFactory.createEmptyBorder(10,	10,	10,	10));

		syrupPanel.setBounds(300, 200, 180, 180);

		syrupLabel = new JLabel("시럽");

		syrupGroup = new ButtonGroup();

		banilaRButton = new JRadioButton("바닐라");
		caramelButton = new JRadioButton("카라멜");
		hazelnutsRButton = new JRadioButton("헤이즐넛");
		notRButton = new JRadioButton("없음");

		syrupPanel.add(syrupLabel);
		syrupGroup.add(banilaRButton);
		syrupGroup.add(caramelButton);
		syrupGroup.add(hazelnutsRButton);

		syrupPanel.add(banilaRButton);
		syrupPanel.add(caramelButton);
		syrupPanel.add(hazelnutsRButton);
		//

		// 기타
		etcPanel = new JPanel();
		etcPanel.setLayout(new GridLayout(5, 1, 10, 10));
		etcPanel.setBorder(new LineBorder(Color.black, 1));
//		sizePanel.setBorder(BorderFactory.createEmptyBorder(10,	10,	10,	10));

		etcPanel.setBounds(500, 200, 180, 180);

		etcLabel = new JLabel("기타");

//		etcGroup = new ButtonGroup();

		shotCheckBtn = new JCheckBox("샷 추가");
		wheepingCheckBtn = new JCheckBox("휘핑크림");

		etcPanel.add(etcLabel);
//		etcGroup.add(shotCheckBtn);
//		etcGroup.add(wheepingCheckBtn);

		etcPanel.add(shotCheckBtn);
		etcPanel.add(wheepingCheckBtn);
		//

		cupTextField = new JTextField();
		cupTextField.setBounds(150, 500, 80, 40);

		cupLabel = new JLabel("잔");
		cupLabel.setBounds(250, 500, 60, 40);

		orderBtn = new JButton("장바구니에 담기");
		orderBtn.setBounds(350, 500, 140, 40);
		
		
		
		
		orderBtn.addActionListener(new ActionListener() {
			Singleton s = Singleton.getInstance();

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cupTextField.getText().equals("") || cupTextField.getText() == null) {
					JOptionPane.showMessageDialog(null, "잔의 수를 입력해주세요!");
					return;
				}
  
				// 사이즈 선택
				String selectedSizeButton = null;
				if (shortRButton.isSelected()) {
					selectedSizeButton = shortRButton.getText();
				} else if (tallRButton.isSelected()) {
					selectedSizeButton = tallRButton.getText();
				} else if (grandeRButton.isSelected()) {
					selectedSizeButton = grandeRButton.getText();
				} else {
					JOptionPane.showMessageDialog(null, "커피의 사이즈를 선택해주세요!");
					return;
				}

				// 시럽 선택
				String selectedSyrupButton = null;
				if (banilaRButton.isSelected()) {
					selectedSyrupButton = banilaRButton.getText();
				} else if (caramelButton.isSelected()) {
					selectedSyrupButton = caramelButton.getText();
				} else if (hazelnutsRButton.isSelected()) {
					selectedSyrupButton = hazelnutsRButton.getText();
				} else {
					selectedSyrupButton = "없음";
				}

				String shot = null;
				String wheep = null;
				if (shotCheckBtn.isSelected()) {
					shot = "추가됨";
				} else {
					shot = "없음";
				}

				if (wheepingCheckBtn.isSelected()) {
					wheep = "추가됨";
				} else {
					wheep = "없음";
				}

				int price = getPrice() * Integer.parseInt(cupTextField.getText());

//				System.out.println(menuChoice.getSelectedItem());

//				JOptionPane.showMessageDialog(null, selectedButton);
//				OrderDto o = new OrderDto(id, menu, syrup, size, shot, wheeping, cup, price)
				OrderDto orderDto = new OrderDto(s.getLoginID(), menuChoice.getSelectedItem(), selectedSyrupButton,
						selectedSizeButton, shot, wheep, Integer.parseInt(cupTextField.getText()), price);

//				s.orderCtrl.order(orderDto);

				s.setOrderDto(orderDto);
				List<OrderDto> list = s.getList();
				list.add(orderDto);
				s.setList(list);

				JOptionPane.showMessageDialog(null, orderDto.toString());

				
//				System.out.println(orderDto.getSeq());
//				System.out.println(orderDto.getSeq());

			}
		});

		cartBtn = new JButton("장바구니로 이동");
		cartBtn.setBounds(500, 500, 140, 40);
		cartBtn.addActionListener(new ActionListener() {

			Singleton s = Singleton.getInstance();

			@Override
			public void actionPerformed(ActionEvent e) {
				s.orderCtrl.getOrderListView();
			}
		});

		
		add(cartBtn);
		add(menuBtn);
		add(menuChoice);
		add(sizePanel);
		add(syrupPanel);
		add(etcPanel);
		add(cupTextField);
		add(cupLabel);
		add(orderBtn);

		setBounds(100, 100, 1000, 700);
		setVisible(true);
	}

	public int getPrice() {
		Singleton s = Singleton.getInstance();
		if (menuChoice.getSelectedItem().equals(s.menuCtrl.getMenuInfo(menuChoice.getSelectedItem()).getMenu())) {
			if (shortRButton.isSelected()) {
				return s.menuCtrl.getMenuInfo(menuChoice.getSelectedItem()).getShortSize();
			} else if (tallRButton.isSelected()) {
				return s.menuCtrl.getMenuInfo(menuChoice.getSelectedItem()).getTallSize();
			} else if (grandeRButton.isSelected()) {
				return s.menuCtrl.getMenuInfo(menuChoice.getSelectedItem()).getGrandeSize();
			}
		}
		return 0;
	}
}
