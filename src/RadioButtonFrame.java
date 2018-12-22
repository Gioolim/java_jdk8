/*
 * 파일명: RadioButtonFrame.java
 * 작성일: 2018.12.22
 * 작성자: 진영
 * 설명:  라디오 버튼 연습 - 커피 주문 화면
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

class RadioButtonFrame extends JFrame implements ActionListener {
	private JRadioButton small, medium, large;
	private JPanel topPanel, sizePanel, resultPanel;
	private JLabel text;

	public RadioButtonFrame() {
		setTitle("라디오 버튼 연습 - 커피 주문 화면");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		topPanel = new JPanel();
		JLabel label = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		topPanel.add(label);
		add(topPanel, BorderLayout.NORTH);

		// 라디오 버튼 생성
		sizePanel = new JPanel();
		small = new JRadioButton("Small Size");
		medium = new JRadioButton("Medium Size");
		large = new JRadioButton("Large Size");

		// 버튼 그룹을 생성하고 라디오 버튼을 추가
		ButtonGroup size = new ButtonGroup();
		size.add(small);
		size.add(medium);
		size.add(large);

		// 버튼에 액션 리스너 등록
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);

		// 버튼 그룹을 생성하고 라디오 버튼을 추가
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		add(sizePanel, BorderLayout.CENTER);

		resultPanel = new JPanel();
		text = new JLabel("크기가 선택되지 않았습니다.");
		text.setForeground(Color.red);
		resultPanel.add(text);
		add(resultPanel, BorderLayout.SOUTH);
		setVisible(true);

		// 경계 만들기
		Border border = BorderFactory.createTitledBorder("크기");
		sizePanel.setBorder(border);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == small)
			text.setText("Small 크기가 선택되었습니다.");
		if (e.getSource() == medium)
			text.setText("Medium 크기가 선택되었습니다.");
		if (e.getSource() == large)
			text.setText("Large 크기가 선택되었습니다.");
	}

	public static void main(String[] args) {
		new RadioButtonFrame();
	}

}
