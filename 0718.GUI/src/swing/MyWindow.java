package swing;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

//������ Ŭ����
public class MyWindow extends JFrame {

	public MyWindow() {
		// ��ġ�� ũ�� ����
		setBounds(200, 200, 1500, 1500);
		// title
		setTitle("������ �̿��� ������");
		// exit button event
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		ImageIcon icon = new ImageIcon("C:\\�̿��\\�̹���\\�����1.PNG");
		JLabel label = new JLabel(icon);
		label.setToolTipText("�ȳ��ϼ���");
		EtchedBorder border = new EtchedBorder(Color.RED, Color.pink);
		label.setBorder(border);
		panel.add(label);
		add(panel);

		JButton btn = new JButton("��ư");
		panel.add(btn);
		// ȭ�� ���
		setVisible(true);
		
		// �׸� ���� �̸��� �迭�� �����
		// �迭�� ����� ũ�� ������ �ȵ�.

		String[] images = { "�����1.PNG", "�����2.PNG", "�����3.PNG" };

		// ����Ʈ�� ũ�� ������ ���� �� �迭
		ArrayList<String> list = new ArrayList<>();
		list.add("�����1.PNG");
		list.add("�����2.PNG");
		list.add("�����3.PNG");

		// �̹����� ����Ǵ� ���ȿ��� �ٸ� �۾��� �� �� �־��
		// �ϹǷ� �̹��� ������ ������� ����
		Thread th = new Thread() {
			public void run() {
				int idx = 0;
				while (true) {
					try {
						Thread.sleep(500);
						// ImageIcon icon = new ImageIcon("C:\\�̿��\\�̹���\\"+images[idx%images.length]);
						// label.setIcon(icon);
						ImageIcon icon = new ImageIcon("C:\\�̿��\\�̹���\\" + list.get(idx % list.size()));
						label.setIcon(icon);
						idx += 1;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		th.start();
	}
}
