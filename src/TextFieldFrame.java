/*
 * 파일명: TextFieldFrame.java
 * 작성일: 2018.12.22
 * 작성자: 진영
 * 설명:  입력받은 정수의 제곱 계산하기
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame {
	private JButton button;
	private JTextField text, result;

	public TextFieldFrame() {
		setTitle("제곱 계산하기");
		setSize(300, 130);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		ButtonListener listener = new ButtonListener(); // 리스너 객체 생성

		JPanel panel = new JPanel();
		panel.add(new JLabel("숫자 입력: ")); // 레이블 객체 생성
		text = new JTextField(15); // 컬럼수가 15인 텍스트 필드 생성
		text.addActionListener(listener); // 텍스트 필드에 리스너 연결
		panel.add(text);

		panel.add(new JLabel("제곱한 값: "));
		result = new JTextField(15);
		result.addActionListener(listener); // 결과를 나타낼 텍스트 필드
		panel.add(result); // 편집 불가 설정

		button = new JButton("OK");
		button.addActionListener(listener);
		panel.add(button);
		add(panel);
		setVisible(true);
	}

	// 내부 클래스로서 텍스트 필드와 버튼의 액션 이벤트 처리
	// 버튼을 누르거나 텍스트 필드에서 엔터키를 누르면 호출
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button || e.getSource() == text) {
				String name = text.getText();
				int value = Integer.parseInt(name);
				result.setText(" " + value * value);
				text.requestFocus();
			}
			// 텍스트를 입력받아 정수로 변환하고, 제곱값을 구한 후 결과를 result에 출력
		}
	}

	public static void main(String[] args) {
		new TextFieldFrame();
	}
}
