/*
 * 파일명: MouseMotionTest.java
 * 작성일: 2018.12.20
 * 작성자: 진영
 * 설명:  마우스로 자동차를 움직이는 프로그램
 */
 
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel extends JPanel {
	BufferedImage img = null;
	int img_x = 0, img_y = 0;

	public MyPanel() {
		// 이미지를 읽는다. 오류가 발생하면 실행을 종료한다.
		try {
			img = ImageIO.read(new File("car.jpg"));
		}
		catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}

		// 패널에 마우스 리스너를 추가한다. (무명 클래스로 작성)
		addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}
}

public class MouseMotionTest extends JFrame {
	public MouseMotionTest() {
		add(new MyPanel());
		setSize(300, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MouseMotionTest();
	}

}
