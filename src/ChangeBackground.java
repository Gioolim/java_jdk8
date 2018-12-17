/*
 * 파일명: ChangeBackground.java
 * 작성일: 2018.12.17
 * 작성자: 진영
 * 설명:   액션 이벤트 예제 : 배경색 선정하기
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class MyFrame extends JFrame {
	private JButton button1;
	private JButton button2;
	private JPanel panel;
	MyListener listener = new MyListener(); // 리스너 객체를 미리 생성시켜 놓는다.

	public MyFrame() {
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제 : 배경색 선정하기");
		panel = new JPanel();
		button1 = new JButton("노란색");
		button1.addActionListener(listener); // 1
		panel.add(button1);
		button2 = new JButton("분홍색");
		button2.addActionListener(listener); // 2 . 두 개의 버튼에 동일한 이벤트 리스너 객체를 등록한다.
		panel.add(button2);
		this.add(panel);
		this.setVisible(true);
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				panel.setBackground(Color.YELLOW); // 1
			}
			else if (e.getSource() == button2) { // 2 , getSource()를 사용해 이벤트 소스를 찾는다.
				panel.setBackground(Color.PINK);
			}
		}
	}
}

public class ChangeBackground {
	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}
}
