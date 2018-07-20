package swing;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

//윈도우 클래스
public class MyWindow extends JFrame {

	public MyWindow() {
		// 위치와 크기 설정
		setBounds(200, 200, 1500, 1500);
		// title
		setTitle("스윙을 이용한 윈도우");
		// exit button event
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		ImageIcon icon = new ImageIcon("C:\\이우미\\이미지\\고양이1.PNG");
		JLabel label = new JLabel(icon);
		label.setToolTipText("안녕하세요");
		EtchedBorder border = new EtchedBorder(Color.RED, Color.pink);
		label.setBorder(border);
		panel.add(label);
		add(panel);

		JButton btn = new JButton("버튼");
		panel.add(btn);
		// 화면 출력
		setVisible(true);
		
		// 그림 파일 이름을 배열로 만들기
		// 배열은 만들면 크기 변경이 안됨.

		String[] images = { "고양이1.PNG", "고양이2.PNG", "고양이3.PNG" };

		// 리스트는 크기 변경이 가능 한 배열
		ArrayList<String> list = new ArrayList<>();
		list.add("고양이1.PNG");
		list.add("고양이2.PNG");
		list.add("고양이3.PNG");

		// 이미지가 변경되는 동안에도 다른 작업을 할 수 있어야
		// 하므로 이미지 변경은 스레드로 생성
		Thread th = new Thread() {
			public void run() {
				int idx = 0;
				while (true) {
					try {
						Thread.sleep(500);
						// ImageIcon icon = new ImageIcon("C:\\이우미\\이미지\\"+images[idx%images.length]);
						// label.setIcon(icon);
						ImageIcon icon = new ImageIcon("C:\\이우미\\이미지\\" + list.get(idx % list.size()));
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
