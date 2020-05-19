package lianliankan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 * 主界面类
 * 
 * @author Vincent
 * 
 */
public class MainFrame extends JFrame {

	/**
	 * map的宽度与高度
	 */
	int MAPWIDTH = GameInfo.MAPWIDTH, MAPHEIGHT = GameInfo.MAPHEIGHT;

	/**
	 * 图片按钮
	 */
	private JButton[][] button = new JButton[MAPHEIGHT][MAPWIDTH];

	private JButton start = new JButton("截图");// 开始游戏按钮
	private JButton cheat = new JButton("开挂"); // 开挂按钮
	private JButton cz = new JButton("重置"); // 开挂按钮
	private LineBorder border = new LineBorder(Color.black, 1);// 按钮的边界

	/*
	 * 用于显示鼠标坐标
	 */
	private JLabel label = new JLabel();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("游戏");
	private JMenuItem settting = new JMenuItem("设置");

	/**
	 * 保存各种图片对应的数值
	 */
	int[][] map = new int[MAPHEIGHT][MAPWIDTH];

	/**
	 * 当前鼠标点击的次数
	 */
	int clickCount = 0;
	/**
	 * 记录下点击的两个坐标
	 */
	Point point1 = new Point(), point2 = new Point();
	/**
	 * 空白图片对应的数值
	 */
	int blankImageValue = -1;
	/**
	 * 空白图片的数量
	 */
	int blankImageCount = -1;
	/**
	 * 剩下的可消除的图片的数量
	 */
	int otherImageCount = -1;

	public MainFrame() {
		// TODO 自动生成的构造函数存根
		initUi();
		initListener();
	}

	/**
	 * 初始化界面
	 */
	private void initUi() {
		setSize(600, 430);
		setTitle("连连看");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(settting);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(MAPHEIGHT, MAPWIDTH));
		add(mainPanel, BorderLayout.CENTER);
		add(label, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(start);
		buttonPanel.add(cheat);
		buttonPanel.add(cz);

		add(buttonPanel, BorderLayout.SOUTH);

		for (int i = 0; i < MAPHEIGHT; i++)
			for (int j = 0; j < MAPWIDTH; j++) {
				button[i][j] = new JButton();
				button[i][j].setBorder(border);
				mainPanel.add(button[i][j]);
			}

	}

	/**
	 * 初始化监听器
	 */
	private void initListener() {

		/**
		 * 开始截图并显示在界面上
		 */
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO 自动生成的方法存根
				try {
					// 截图
					ImageCapture imageCapture = new ImageCapture(GameInfo.PICX,
							GameInfo.PICY);
					imageCapture.capture();

					ImageUtil imageUtils = new ImageUtil();

					for (int i = 0; i < MAPHEIGHT; i++) {
						for (int j = 0; j < MAPWIDTH; j++) {
							// 获取i行j列的图片
							BufferedImage image = imageCapture.getImage(i, j);
							int value = imageUtils.getImageValue(image);
							map[i][j] = value;
							// 将图片显示在按钮上
							button[i][j].setIcon(new ImageIcon(image));

						}
					}

					/**
					 * 获取空白图片的数量与对应的数值
					 */
					blankImageValue = imageUtils.getBlankImageValue();
					blankImageCount = imageUtils.getBlankImageCount();
					otherImageCount = MAPWIDTH * MAPHEIGHT - blankImageCount;

					System.out.println("map:");
					for (int i = 0; i < MAPHEIGHT; i++) {
						for (int j = 0; j < MAPWIDTH; j++) {
							//System.out.printf("%6d  ", map[i][j]);
							if (map[i][j] == blankImageValue)
								button[i][j].setIcon(null);

						}
						System.out.println();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		/**
		 * 开挂
		 */
		cheat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					cheat();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					//e1.printStackTrace();
					System.out.println("程序异常");
				}
			}
		});
		/*
		 * 重置
		 */
		cz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		/**
		 * 游戏设置
		 */
		settting.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				SettingDialog settingDialog = new SettingDialog(MainFrame.this);
				settingDialog.setVisible(true);

			}
		});
	}

	/**
	 * 开挂
	 */
	public void cheat() throws Exception {
		int count = MAPHEIGHT * MAPWIDTH;
		while (otherImageCount > 0) {
			//otherImageCount = -1;
			for (int i = 0; i < count; i++)
				for (int j = i + 1; j < count; j++) {
					int startX = i / MAPWIDTH;
					int startY = i % MAPWIDTH;
					int endX = j / MAPWIDTH;
					int endY = j % MAPWIDTH;
					if (map[startX][startY] != map[endX][endY]
							|| map[startX][startY] == blankImageValue)
						continue;
					MapDetector mapDetector = new MapDetector(map, startX,
							startY, endX, endY, blankImageValue);
					if (mapDetector.isValid()) {
						// 点击
						GameRobot.clickButton(startX, startY, endX, endY);
						Thread.sleep(GameInfo.SLEEPTIME);
						otherImageCount = otherImageCount - 2;
						// System.out.println(otherImageCount);
						button[startX][startY].setIcon(null);
						button[endX][endY].setIcon(null);
						button[startX][startY].updateUI();
						button[endX][endY].updateUI();
						break;
					}

				}
		}

	}

	/**
	 * 显示鼠标信息
	 */
	public void showMouseInfo() {
		new MouseInfoThread(label).start();
	}

}
