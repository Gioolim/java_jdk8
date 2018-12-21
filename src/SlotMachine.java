/*
 * 파일명: SlotMachine.java
 * 작성일: 2018.12.21
 * 작성자: 진영
 * 설명:  3개의 난수가 표시되는 슬롯 머신
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class MyCounter extends JFrame implements ActionListener {
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;

	public MyCounter( ) {
		setSize(500, 300);
		JPanel panel = new JPanel();
		panel.setLayout(null);


		labels = new JLabel[3];
		numbers = new int[3];

		// 3개의 레이블을 생성하고, 절대 위치에 표시
		for (int i = 0; i < 3; i++) {
			labels[i] = new JLabel("" + numbers[i]);
			labels[i].setFont(new Font("Serif", Font.BOLD | Font.ITALIC,100));
			labels[i].setSize(100, 100);
			labels[i].setLocation(100 + 100 * i, 20);
			panel.add(labels[i]);
		}

		button = new JButton("SPIN");
		button.setSize(250, 50);
		button.setLocation(100, 150);
		panel.add(button);
		button.addActionListener(this); // 버튼에 이벤트 리스너 객체를 등록

		add(panel);
		setTitle("My SlotMachine");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		for (int i = 0; i < 3; i++) {
			numbers[i] = (int)(Math.random() * 10);
			labels[i].setText(" " + numbers[i]);
		}
	}
}	

public class SlotMachine {
	public static void main(String[] args) {
		new MyCounter();
	}

}
