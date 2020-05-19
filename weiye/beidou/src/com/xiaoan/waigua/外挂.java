package com.xiaoan.waigua;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class 外挂 extends Thread {
	/*
	 * 4.13北斗学院学习
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Robot r = new Robot();
		// 鼠标移动方法
		// r.mouseMove(450, 769);
		// 获取点的颜色值
		/*
		 * Color c = r.getPixelColor(220, 198); int red = c.getRed();
		 * System.out.println(red);
		 */
		// 移动到某个地方双击左键
		/*
		 * r.mouseMove(450, 769); r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 * r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 */
		// 简单的别踩白块脚本
		// 90*118 180*118 270*118 360*118
		
		// int a5 = r.getPixelColor(448,512).getRed();
		 
		int i = 0;
		a:while (i < 1000) {
			i++;
			try {
				int a1 = r.getPixelColor(280, 540).getRed();
				int a2 = r.getPixelColor(360, 540).getRed();
				int a3 = r.getPixelColor(440, 540).getRed();
				int a4 = r.getPixelColor(525, 540).getRed();
				//System.out.println(a4);
				Thread.sleep(100);// 毫秒
				if (a1 == 1) {
					r.mouseMove(280, 540);
					r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					Thread.sleep(150);// 毫秒
					r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				continue;
				}else if (a2 == 1) {
					r.mouseMove(360, 540);
					r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					Thread.sleep(150);// 毫秒
					r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					continue;
				}else if (a3 == 1) {
					r.mouseMove(440, 540);
					r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					Thread.sleep(150);// 毫秒
					r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					continue;
				}else if (a4 == 1) {
					r.mouseMove(525, 540);
					r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					Thread.sleep(150);// 毫秒
					r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					continue;
				}
				//System.out.println("延时0，5秒");
			} catch (Exception e) {
				System.out.println("抛出异常");
				break a;
			}
		}
	}
}
