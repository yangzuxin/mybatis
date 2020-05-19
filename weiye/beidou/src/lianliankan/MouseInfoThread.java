package lianliankan;

import java.awt.MouseInfo;

import javax.swing.JLabel;

public class MouseInfoThread extends Thread {

	JLabel label;

	public MouseInfoThread(JLabel label) {
		// TODO 自动生成的构造函数存根
		this.label = label;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (true)
			try {
				Thread.sleep(200);

				label.setText(MouseInfo.getPointerInfo().getLocation()
						.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
