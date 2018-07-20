package event;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class EventHandling1 extends Frame {

	public EventHandling1() {
		setBounds(600, 100, 999, 700);
		setTitle("이벤트 처리 연습");

		// 여러 개를 배치하기 위해서 패널 배치
		Panel panel = new Panel();

		TextField txtf1 = new TextField(5);
		panel.add(txtf1);
		Label plus = new Label("+");
		panel.add(plus);

		TextField txtf2 = new TextField(5);
		panel.add(txtf2);
		Label assign = new Label("=");
		panel.add(assign);

		TextField result = new TextField(6);
		panel.add(result);

		Button btn1 = new Button("계산");
		panel.add(btn1);

		ActionListener listener1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// txtf1 + txtf2 = result

				// 첫번째와 두번째 텍스트 필스의 내용 가져오기
				String n1 = txtf1.getText();
				String n2 = txtf2.getText();

				int sum = Integer.parseInt(n1) + Integer.parseInt(n2);
				// System.out.println(n1+"+"+n2+"="+sum);
				result.setText(String.format("%d", sum));

			}
		};

		btn1.addActionListener(listener1);

		Button exit = new Button("종료");
		panel.add(exit);

		ActionListener listener2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		};
		exit.addActionListener(listener2);

		Label lblPw = new Label("비밀번호");
		panel.add(lblPw);
		TextField pw = new TextField(15);
		panel.add(pw);
		Label pwresult = new Label();
		panel.add(pwresult);

		// 텍스트 필드의 내용이 변경될 때를 처리할 수 있는
		// 인터페이스의 인스턴스를 생성
		TextListener tl = new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
				String password = pw.getText();

				int dae = 0, so = 0, su = 0, etc = 0;

				for (int i = 0; i < password.length(); i++) {
					char ch = password.charAt(i);

					// 대문자인지 확인 : A-Z
					if (ch >= 'A' && ch <= 'Z') {
						dae += 1;
					} else if (ch >= 'a' && ch <= 'z') {
						so += 1;
					} else if (ch >= '0' && ch <= '9') {
						su += 1;
					} else {
						etc += 1;
					}
				}
			
				//4개 중에 한개도 0이 없으면 
				if (dae*so*su*etc>0) {
					pwresult.setText("사용 가능한 비밀번호");
				}else {
					pwresult.setText("사용 할 수 없는 비밀번호");
				}
			}

		};

		pw.addTextListener(tl);
		add(panel);
		setVisible(true);
	}
}
