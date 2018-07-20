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
		setTitle("키보드 이벤트");
		setLayout(null);
		Label label = new Label("★");
		label.setBounds(70, 70, 40, 50);
		
		add(label);

		KeyListener klistener = new KeyListener() {

			// 문자 키를 눌렀을 때
			@Override
			public void keyTyped(KeyEvent e) {

			}

			// 키보드를 눌렀을 때
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

					Label l = new Label("▼");
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
				// Modifiers는 같이 누른 조합키 값을 리턴
				if (e.getModifiers() == KeyEvent.ALT_MASK && e.getKeyCode() == KeyEvent.VK_F1) {
					System.exit(0);
				}

			}

			// 키보드에서 손을 뗄 때
			@Override
			public void keyReleased(KeyEvent e) {

			}
		};

		// Frame에 KeyEvent 적용
		addKeyListener(klistener);

		
		//윈도우 조작을 위한 이벤트를 처리하기 위한 리스너
		WindowAdapter winlistener = new WindowAdapter() {
		
			//종료 버튼을 누를 때 호출되는 메소드
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//프로그램 종료
				System.exit(0);
			}
			
		
		};
		addWindowListener(winlistener);
		
		setVisible(true);
	}
}
