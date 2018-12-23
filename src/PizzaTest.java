/*
 * 파일명: PizzaTest.java
 * 작성일: 2018.12.23
 * 작성자: 진영
 * 설명:  피자 주문 화면 구현
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener {
	private int sum, temp1, temp2, temp3; // 액션리스너 구현
	private JButton order_button, cancle_button;
	// 컴포넌트와 컨테이너 참조변수
	private JPanel down_panel;
	private JTextField text;

	WelcomePanel welcom_panel = new WelcomePanel();
	// 문구, 타입, 토핑, 크기 패널 생성
	TypePanel TypePanel = new TypePanel();
	ToppingPanel ToppingPanel = new ToppingPanel();
	SizePanel SizePanel = new SizePanel();

	public MyFrame() {
		this.setSize(500, 200); // 프레임 크기 정의
		this.setTitle("피자 주문"); // 타이틀 초기화
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 설정

		this.order_button = new JButton("주문"); // 버튼 생성	
		this.order_button.addActionListener(this); // 이벤트 처리 등록
		this.cancle_button = new JButton("취소");
		this.cancle_button.addActionListener(this);

		this.text = new JTextField();
		text.setEditable(false); // 수정 불가
		text.setColumns(6); // 길이 6칸

		down_panel = new JPanel();
		down_panel.add(this.order_button);
		down_panel.add(this.cancle_button);
		down_panel.add(this.text);

		this.setLayout(new BorderLayout()); // 프레임 배치관리자 설정

		this.add(welcom_panel, BorderLayout.NORTH); // 웰컴 패널 북쪽
		this.add(down_panel, BorderLayout.SOUTH); // 버튼 패널 남쪽
		this.add(SizePanel, BorderLayout.EAST); // 사이즈 패널 동쪽
		this.add(TypePanel, BorderLayout.WEST); // 타입 패널 서쪽
		this.add(ToppingPanel, BorderLayout.CENTER); // 토핑 패널 중앙

		this.setVisible(true); // 프레임 화면 표시
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.order_button)
			this.text.setText(" " + 20000); // 텍스트 필드 출력
		if (e.getSource() == this.cancle_button) {
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			this.text.setText(" " + sum);
		}
	}

	class WelcomePanel extends JPanel {
		private JLabel message; // 메세지 라벨 참조 변수

		public WelcomePanel() {
			message = new JLabel("징징피자에 오신 것을 환영합니다.");
			add(message); // 라벨을 생성, 객체에 추가
		}
	}

	class TypePanel extends JPanel {
		private JRadioButton combo, potato, bulgogi; // 라디오 버튼 정의
		private ButtonGroup bg;

		public TypePanel() {
			setLayout(new GridLayout(3, 1)); // 배치관리자 일렬

			combo = new JRadioButton("콤보", true);
			potato = new JRadioButton("포테이토");
			bulgogi = new JRadioButton("불고기");

			bg = new ButtonGroup();
			bg.add(combo);
			bg.add(potato);
			bg.add(bulgogi);

			setBorder(BorderFactory.createTitledBorder("종류"));

			add(combo);
			add(potato);
			add(bulgogi);
		}
	}


	class ToppingPanel extends JPanel {
		private JRadioButton pepper, cheese, peperoni, bacon;
		private ButtonGroup bg;

		public ToppingPanel() {
			setLayout(new GridLayout(4, 1));

			pepper = new JRadioButton("피망", true);
			cheese = new JRadioButton("치즈");
			peperoni = new JRadioButton("페페로니");
			bacon = new JRadioButton("베이컨");

			bg = new ButtonGroup();
			bg.add(pepper);
			bg.add(cheese);
			bg.add(peperoni);
			bg.add(bacon);

			setBorder(BorderFactory.createTitledBorder("토핑 추가"));

			add(pepper);
			add(cheese);
			add(peperoni);
			add(bacon);
		}
	}

	class SizePanel extends JPanel {
		private JRadioButton small, medium, large; // 라디오 버튼 정의
		private ButtonGroup bg;

		public SizePanel() {
			setLayout(new GridLayout(3, 1));

			small = new JRadioButton("S", true);
			medium = new JRadioButton("M");
			large = new JRadioButton("L");

			bg = new ButtonGroup();
			bg.add(small);
			bg.add(medium);
			bg.add(large);

			setBorder(BorderFactory.createTitledBorder("크기"));

			add(small);
			add(medium);
			add(large);
		}
	}
}

public class PizzaTest {
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}

