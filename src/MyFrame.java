/*
 * 파일명: MyFrame.java
 * 작성일: 2018.12.19
 * 작성자: 진영
 * 설명:  버튼을 누르면 신호가 변경되는 신호등 구현
      : 패널 안에 GUI 컴포넌트를 추가하고, 동시에 패널에 무언가를 그려보기
      : 화면에 무언가를 그리려면 JPanel apthem 중에서 paintComponent()를 오버라이드 한다.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel implements ActionListener {
	boolean flag = false;
			private int light_number = 0;

	public MyPanel() {
		setLayout(new BorderLayout());
		JButton b = new JButton("traffic light turn on");
		b.addActionListener(this);
		add(b, BorderLayout.SOUTH);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 100, 100);
		g.drawOval(100, 200, 100, 100);
		g.drawOval(100, 300, 100, 100);
		if (light_number == 0) {
			g.setColor(Color.RED);
			g.fillOval(100, 100, 100, 100);
		}
		else if (light_number == 1) {
			g.setColor(Color.GREEN);
			g.fillOval(100, 200, 100, 100);
		}
		else {
			g.setColor(Color.YELLOW);
			g.fillOval(100, 300, 100, 100);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (++light_number >= 3)
			light_number = 0;
		repaint();
	}
}

public class MyFrame extends JFrame {
	public MyFrame( ) {
		add(new MyPanel());
		setSize(300, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
