/*
 * 파일명: ActionEventTest2.java
 * 작성일: 2018.12.10
 * 작성자: 진영
 * 설명: 리스너 클래스를 내부 클래스로 작성
 */
import java.awt.event.*;
import javax.swing.*; // 이벤트 처리를 위한 패키지

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
		button.addActionListener(new MyListener()); // 버튼에 이벤트 리스너 등록
		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}

	class MyListener implements ActionListener {
		// MyListener 클래스 안에서 actionPerformed() 메소드는 반드시 정의되어야 한다.
		// 이 메소드는 사용자가 버튼을 누를 때마다 실행된다.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button)
				label.setText("마침내 버튼이 눌려졌습니다.");
			// 멤버인 label에 쉽게 접근할 수 있다.
		}
	}
}

public class ActionEventTest2 {
	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}

}
