package lianliankan;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 设置界面类
 * 
 * @author Vincent
 * 
 */
public class SettingDialog extends JDialog {
	private JFrame parent;

	private JTextField picX = new JTextField(GameInfo.PICX + "");
	private JTextField picY = new JTextField(GameInfo.PICY + "");

	private JTextField sleepTime = new JTextField(GameInfo.SLEEPTIME + "");

	private JButton submit = new JButton("submit");
	private JButton exit = new JButton("exit");

	public SettingDialog(JFrame parent) {
		// TODO 自动生成的构造函数存根
		super(parent, true);
		this.parent = parent;
		initUi();
		initListener();
	}

	private void initUi() {
		setTitle("游戏设置");
		setSize(300, 160);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(submit);
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder("设置"));
		mainPanel.setLayout(new GridLayout(3, 2, 5, 5));
		mainPanel.add(new JLabel("x坐标"));
		mainPanel.add(picX);
		mainPanel.add(new JLabel("y坐标"));
		mainPanel.add(picY);
		mainPanel.add(new JLabel("每次点击的间隔(毫秒)"));
		mainPanel.add(sleepTime);
		add(mainPanel, BorderLayout.CENTER);

	}

	private void initListener() {
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO 自动生成的方法存根

				try {

					int x = Integer.parseInt(picX.getText());
					int y = Integer.parseInt(picY.getText());
					int time = Integer.parseInt(sleepTime.getText());
					GameInfo.setPICX(x);
					GameInfo.setPICY(y);
					GameInfo.setSLEEPTIME(time);

					dispose();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});

	}
}
