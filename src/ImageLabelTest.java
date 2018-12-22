/*
 * 파일명: ImageLabelTest.java
 * 작성일: 2018.12.22
 * 작성자: 진영
 * 설명:  이미지를 표시하는 레이블
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabelTest extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel label;
	private JButton button;

	public ImageLabelTest() {
		setTitle("이미지 레이블");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		label = new JLabel("이미지를 보려면 옆의 버튼을 누르세요.");

		button = new JButton("이미지 레이블"); 
		ImageIcon icon = new ImageIcon("icon.jpg"); // 이미지 아이콘 객체를 생성
		button.setIcon(icon); // 버튼에 이미지 아이콘 객체를 설정
		button.addActionListener(this);
		panel.add(label);
		panel.add(button); // 패널에 레이블과 버튼을 추가

		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		ImageLabelTest t = new ImageLabelTest();
	}

	// 버튼이 눌려지면 레이블의 텍스트를 없애고 레이블에 이미지를 표시한 클래스
	public void actionPerformed(ActionEvent e) {
		ImageIcon fruit = new ImageIcon("fruit.jpg");
		label.setIcon(fruit);
		label.setText(null);
	}
}
