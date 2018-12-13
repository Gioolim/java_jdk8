/*
 * 파일명: KeyPad.java
 * 작성일: 2018.12.13
 * 작성자: 진영
 * 설명:  숫자를 입력할 수 있는 키패드 프로그램 만들기
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// 프레임 클래스가 이벤트도 처리한다.
public class KeyPad extends JFrame implements ActionListener {
	private JTextField txt;
	private JPanel panel;

	public KeyPad() {
		txt = new JTextField(20);
		add(txt, BorderLayout.NORTH);
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,3)); // 그리드 레이아웃을 지정한다.
		add(panel, BorderLayout.CENTER);
		for(int i = 1; i <= 9; i++) {
			JButton btn = new JButton("" + i);
			btn.addActionListener(this);
			btn.setPreferredSize(new Dimension(100, 100));
			panel.add(btn);
		}
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// 이벤트가 발생하면 호출된다.
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		txt.setText(txt.getText() + actionCommand);
	}
	
	public static void main(String[] args) {
		new KeyPad();
	}
}
