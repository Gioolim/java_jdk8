/*
 * 파일명: CarGameTest.java
 * 작성일: 2018.12.19
 * 작성자: 진영
 * 설명:   키보드의 화살표 키로 움직이는 자동차 애플리케이션
 */
 
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel extends JPanel {
	BufferedImage img = null;
	int img_x = 100, img_y = 100;

	public MyPanel() {
		// 이미지를 읽는다. 오류가 발생하면 실행을 종료한다.
		try {
			img = ImageIO.read(new File("car.jpg"));
		}
		catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}

		// 키 리스너를 무명 클래스로 작성해서 패널에 붙인다.
		// 화살표 키가 입력되면 이미지의 좌표를 변경한다.
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:	img_y -= 10;	break;
				case KeyEvent.VK_DOWN:	img_y += 10;	break;
				case KeyEvent.VK_LEFT:	img_x -= 10;	break;
				case KeyEvent.VK_RIGHT:	img_x += 10;	break;
				}
				repaint();
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		});

		this.requestFocus();
		setFocusable(true); // 키보드 포커스를 요청하고 패널이 포커스를 받을 수 있게 한다.
		                    // 디폴트로는 패널이 키보드 포커스를 받을 수 없다.
	}

	// 자동차 이미지를 화면의 (img_x, img_y) 위치에 그린다.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,  img_x, img_y, null);
	}
}

public class CarGameTest extends JFrame {
	public CarGameTest() {
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		CarGameTest s = new CarGameTest();
	}

}
