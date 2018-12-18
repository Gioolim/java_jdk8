/*
 * 파일명: KeyEventTest.java
 * 작성일: 2018.12.18
 * 작성자: 진영
 * 설명:   키 이벤트 예제 : 키 이벤트 표시하기
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


// 키 이벤트 리스너로 만들기 위해 KeyListener 인터페이스를 구현한다.
public class KeyEventTest extends JFrame implements KeyListener {

	private JPanel panel;
	private JTextField field;
	private JTextArea area;

	public KeyEventTest() {
		panel = new JPanel(new GridLayout(0,2));
		panel.add(new JLabel("문자를 입력하시오 : "));
		field = new JTextField(10);
		panel.add(field);
		area = new JTextArea(3, 30);
		add(panel, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);

		field.addKeyListener(this); // addKeyListener() 메소드로 현재 객체를 이벤트 리스너로 추가한다.
		setTitle("KeyEvent Test");
		setSize(400,200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new KeyEventTest();
	}

	// 키가 입력되면 호출된다.
	public void keyTyped(KeyEvent e) {
		display(e,"Key Typed        ");
	}

	// 키를 누르는 순간 호출된다.
	public void keyPressed(KeyEvent e) {
		display(e,"Key Pressed        ");
	}

	// 키에서 손을 떼는 순간 호출된다.
	public void keyReleased(KeyEvent e) {
		display(e,"Key Released ");
	}

	public void display(KeyEvent e, String s) {
		char c = e.getKeyChar();
		int KeyCode = e.getKeyCode();
		String modifiers = "Alt: " + e.isAltDown() + "Ctrl: " + e.isControlDown()
		+ "Shift: " + e.isShiftDown();
		area.append(" " + s + "문자 " + c + "z(코드: " + KeyCode + ") " + modifiers + "\n");
	}

}
