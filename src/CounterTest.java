/*
 * 파일명: CounterTest.java
 * 작성일: 2018.12.21
 * 작성자: 진영
 * 설명:  카운터
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyCounter extends JFrame implements ActionListener {
	private JLabel label, label1;
	private JButton button;
	private int count = 0;

	public MyCounter( ) {
		JPanel panel = new JPanel();
		label = new JLabel("Counter");
		panel.add(label);

		label1 =  new JLabel(" " + count);
		label1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 100)); // 레이블에 폰트를 설정
		panel.add(label1);

		button = new JButton("카운터 증가");
		panel.add(button);
		button.addActionListener(this); // 버튼에 이벤트 리스너 객체를 등록

		add(panel);
		setSize(300, 300);
		setTitle("My Counter");
		setVisible(true);
	}

	// 버튼이 눌려지면 카운터 값을 증가시키고 레이블에 쓰는  ActionEvent
	@Override
	public void actionPerformed(ActionEvent event) {
		count++;
		label1.setText(count + " ");
	}
}

public class CounterTest {

	public static void main(String[] args) {
		new MyCounter();
	}

}
