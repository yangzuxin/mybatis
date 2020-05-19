package com.xiaoan.liaomei;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//JFrame 是 Frame的子类
public class LoveFrame extends Frame implements Runnable{
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	
	public LoveFrame(){
		setSize(WIDTH,HEIGHT);
		setBackground(Color.black);
		
		//WindowFocusListener  匿名内部类
		addWindowListener(new WindowListener() {
			//
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			
			//不再是活动窗口时调用
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			//关闭窗体时调用
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//终止程序
				System.exit(0);//
			}
			//关闭窗体后调用
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			//设置为活动窗体时调用
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
	}
	//获取随机色的方法
	public Color getColor(){
		//随机数对象
		Random ran = new Random();
		return new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
	}
	
	//绘图方法
	@Override
	public void paint(Graphics g) {
		//绘制背景图
		for (int i = 0; i < 500; i++) {
			//画内容，g相当于画笔
			g.setColor(getColor());
			g.drawString("❤",(int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
		}
		//设置字体
		g.setFont(new Font("微软雅黑",Font.BOLD,50));
		//设置颜色
		g.setColor(getColor());
		//设置内容时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		g.drawString(date,0,200);
		//设置颜色
		g.setColor(getColor());
		g.drawString("LOVE",(WIDTH/2),(HEIGHT/2));
		
	}
	
	//入口
	public static void main(String[] args) {
		//创建一个窗体对象
		LoveFrame loveFrame = new LoveFrame();
		new Thread(loveFrame).start();
		loveFrame.setVisible(true);
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(500);
			}catch(Exception e){
				e.printStackTrace();
			}
			//刷新
			repaint();
		}
		
	}
}
