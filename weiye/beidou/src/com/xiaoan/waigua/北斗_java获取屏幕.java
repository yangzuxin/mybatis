package com.xiaoan.waigua;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class 北斗_java获取屏幕 {

	public static void main(String[] args) throws AWTException {//throws AWTException  robot的异常
		// TODO Auto-generated method stub
		int dialog = JOptionPane.showConfirmDialog(null,"对方请求获取您的电脑屏幕","远程获取", JOptionPane.OK_CANCEL_OPTION);
		//System.out.println(dialog);//确定返回0，取消返回2
		
		String ipAddress = JOptionPane.showInputDialog("请输入IP地址端口号", "192.168.1.100");
		if(!ipAddress.equals("192.168.1.100")){
			return;
			}
		
		//实现一个窗口来监控对方的窗口
		JFrame jf = new JFrame();
		jf.setSize(500, 500);//窗口大小
		jf.setTitle("java监控");//标题
		jf.setVisible(true);//显示窗口
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭且退出
		
		jf.setAlwaysOnTop(true);
		
		//Toolkit 获取当前屏幕大小的配套工具
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
	//System.out.println(width+";"+height);
		
		//创建一个JLable面板
		JLabel jla = new JLabel();
		
		while (true) {
			jf.add(jla);//把jla添加到jf
			//robot 机器人 帮助获取屏幕尺寸
			Robot robot = new Robot();
			//获取到屏幕的矩形形状
			Rectangle rect = new Rectangle(screenSize);
			//获取屏幕的图像
			BufferedImage img = robot.createScreenCapture(rect);
			ImageIcon imge = new ImageIcon(img);
			//Jlable
			jla.setIcon(imge);
			
		}
	}
}
