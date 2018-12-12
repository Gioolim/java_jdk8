package hw11_1;

/*
 * 파일명: ActionEventTest5.java
 * 작성일: 2018.12.12
 * 작성자: 진영
 * 설명:  람다식을 이용하는 방법
 */

import javax.swing.*;

class MyFrame extends JFrame {
	private JButton button;
	private JLabel label;

	public MyFrame() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");
		
		JPanel panel = new JPanel();
		button = new JButton("버튼을 누르시오.");
		
		label = new JLabel("아직 버튼이 눌려지지 않았습니다.");
		button.addActionListener(e -> {
			label.setText("마침내 버튼이 눌려졌습니다.");
		});

		panel.add(button);
		panel.add(label);
		
		this.add(panel);
		this.setVisible(true);
	}

}

public class ActionEventTest5 {
	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}

}
