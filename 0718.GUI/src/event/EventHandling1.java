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
		setTitle("�̺�Ʈ ó�� ����");

		// ���� ���� ��ġ�ϱ� ���ؼ� �г� ��ġ
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

		Button btn1 = new Button("���");
		panel.add(btn1);

		ActionListener listener1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// txtf1 + txtf2 = result

				// ù��°�� �ι�° �ؽ�Ʈ �ʽ��� ���� ��������
				String n1 = txtf1.getText();
				String n2 = txtf2.getText();

				int sum = Integer.parseInt(n1) + Integer.parseInt(n2);
				// System.out.println(n1+"+"+n2+"="+sum);
				result.setText(String.format("%d", sum));

			}
		};

		btn1.addActionListener(listener1);

		Button exit = new Button("����");
		panel.add(exit);

		ActionListener listener2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		};
		exit.addActionListener(listener2);

		Label lblPw = new Label("��й�ȣ");
		panel.add(lblPw);
		TextField pw = new TextField(15);
		panel.add(pw);
		Label pwresult = new Label();
		panel.add(pwresult);

		// �ؽ�Ʈ �ʵ��� ������ ����� ���� ó���� �� �ִ�
		// �������̽��� �ν��Ͻ��� ����
		TextListener tl = new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
				String password = pw.getText();

				int dae = 0, so = 0, su = 0, etc = 0;

				for (int i = 0; i < password.length(); i++) {
					char ch = password.charAt(i);

					// �빮������ Ȯ�� : A-Z
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
			
				//4�� �߿� �Ѱ��� 0�� ������ 
				if (dae*so*su*etc>0) {
					pwresult.setText("��� ������ ��й�ȣ");
				}else {
					pwresult.setText("��� �� �� ���� ��й�ȣ");
				}
			}

		};

		pw.addTextListener(tl);
		add(panel);
		setVisible(true);
	}
}
