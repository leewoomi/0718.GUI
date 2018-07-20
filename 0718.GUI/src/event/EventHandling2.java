package event;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventHandling2 extends Frame {

	public EventHandling2() {
		setBounds(300, 300, 700, 700);
		setTitle("Ű���� �̺�Ʈ");
		setLayout(null);
		Label label = new Label("��");
		label.setBounds(70, 70, 40, 50);
		
		add(label);

		KeyListener klistener = new KeyListener() {

			// ���� Ű�� ������ ��
			@Override
			public void keyTyped(KeyEvent e) {

			}

			// Ű���带 ������ ��
			@Override
			public void keyPressed(KeyEvent e) {
				int x = label.getLocation().x;
				int y = label.getLocation().y;
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {

					y += 10;
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {

					y -= 10;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					x += 10;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					x -= 10;
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {

					Label l = new Label("��");
					l.setBounds(label.getLocation().x, label.getLocation().y - 20, 30, 30);
					add(l);

					Thread th = new Thread() {
						public void run() {
							try {
								while (true) {
									Thread.sleep(100);
									int x = l.getLocation().x;
									int y = l.getLocation().y;
									l.setLocation(x, y - 5);
									if (y < 60) {
										break;
									}
									
								}
								l.setVisible(false);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					};
					th.start();
				}

				label.setLocation(x, y);
				// Modifiers�� ���� ���� ����Ű ���� ����
				if (e.getModifiers() == KeyEvent.ALT_MASK && e.getKeyCode() == KeyEvent.VK_F1) {
					System.exit(0);
				}

			}

			// Ű���忡�� ���� �� ��
			@Override
			public void keyReleased(KeyEvent e) {

			}
		};

		// Frame�� KeyEvent ����
		addKeyListener(klistener);

		
		//������ ������ ���� �̺�Ʈ�� ó���ϱ� ���� ������
		WindowAdapter winlistener = new WindowAdapter() {
		
			//���� ��ư�� ���� �� ȣ��Ǵ� �޼ҵ�
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//���α׷� ����
				System.exit(0);
			}
			
		
		};
		addWindowListener(winlistener);
		
		setVisible(true);
	}
}
