/*
 * 파일명: ActionEventTest1.java
 * 작성일: 2018.11.26
 * 작성자: 진영
 * 설명: 리스너를 독립적인 클래스로 작성
 */
import java.awt.event.*;
import javax.swing.*;

// 별도의 클래스 MyListener 정의 , ActionListener 인터페이스 구현
class MyListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton button =(JButton)e.getSource(); 
		button.setText("마침내 버튼이 눌려졌습니다.");
		// label.setText("마침내 버튼이 눌려졌습니다."); 레이블은 MyFrame 클래스 안에 있어서 접근하기 어렵다.
	}
}

class MyFrame extends JFrame {
	private JButton button;
	private JLabel label;

	public MyFrame() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");
		JPanel panel = new JPanel();
		button = new JButton("버튼을 누르시오.");
		label = new JLabel("아직 버튼이 눌려지지 않았습니다.");
		button.addActionListener(new MyListener()); // 이벤트 리스너 등록
		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}
}

public class ActionEventTest1 {
	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}

}
