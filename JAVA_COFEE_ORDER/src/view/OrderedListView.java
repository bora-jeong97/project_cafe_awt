package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.OrderDto;
import singleton.Singleton;

public class OrderedListView extends JFrame {

	private JTable jtable;
	private JScrollPane jscrPane;
	private JLabel allPriceLabel;

	String columnNames[] = { "주문한 커피", "날짜", "사이즈", "잔", "가격"};

	Object rowData[][];
	DefaultTableModel model;
	List<OrderDto> list = null;
	
	public OrderedListView() {
		super("주문했던내역");

		setLayout(null);

		Singleton s = Singleton.getInstance();
		list = s.orderCtrl.getOrderedList(s.getLoginID());
		
//		this.list = list;
		rowData = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			OrderDto orderDto = list.get(i);
			
			rowData[i][0] = orderDto.getMenu();
			rowData[i][1] = orderDto.getWdate();
			rowData[i][2] = orderDto.getSize();
			rowData[i][3] = orderDto.getCup();
			rowData[i][4] = orderDto.getPrice();
		}
	

		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		jtable = new JTable(model);
		
	
		
//		jtable.addMouseListener(this);

		// column의 폭을 설정
//		jtable.getColumnModel().getColumn(0).setMaxWidth(50); // 번호
//		jtable.getColumnModel().getColumn(1).setMaxWidth(500); // 제목
//		jtable.getColumnModel().getColumn(2).setMaxWidth(200); // 작성자

		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
//		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
//		celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // 중간

		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
//		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
//		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);

		allPriceLabel = new JLabel("총 가격: " + (s.orderCtrl.allSum(s.getLoginID() + "")));
		allPriceLabel.setBounds(550, 380, 150, 30);
		
		add(allPriceLabel);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
	}
}












