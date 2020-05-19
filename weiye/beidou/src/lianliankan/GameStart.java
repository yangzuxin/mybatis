package lianliankan;

import javax.swing.JFrame;

public class GameStart {
	public static void main(String[] args) throws Exception {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		frame.showMouseInfo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
