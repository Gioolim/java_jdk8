package hw11_1;

/*
 * 파일명: ActionEventTest3.java
 * 작성일: 2018.12.11
 * 작성자: 진영
 * 설명: MyFrame 클래스가 이벤트를 처리
 */
import java.awt.event.*;
import javax.swing.*; // 이벤트 처리를 위한 패키지

class MyFrame extends JFrame implements ActionListener {
	// EventTest클래스는 JFrame 클래스를 상속받고 동시에 ActionListener를 구현한다.
	// 따라서 프레임이 버튼에서 발생하는 이벤트도 처리할 수 있다.
	private JButton button;
	private JLabel label;

	public MyFrame() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");

		JPanel panel = new JPanel();
		button = new JButton("버튼을 누르시오.");
		label = new JLabel("아직 버튼이 눌려지지 않았습니다.");
		button.addActionListener(this); // 현재 객체를 이벤트 리스너로 버튼에 등록. 즉 자기 자신이 이벤트를 처리한다고 등록.
		panel.add(button);
		panel.add(label);

		this.add(panel);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button)
			label.setText("마침내 버튼이 눌려졌습니다.");
	}
}

public class ActionEventTest3 {
	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}

}
