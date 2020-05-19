package com.xiaoan.zhidushu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.util.Random;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame f = new Frame("标题吗？");
		//窗体的大小
		f.setSize(200, 100);
//		f.setLocationRelativeTo(null);
		//窗体的位置
		Random ran = new Random();
		f.setLocation(200, 500);
		TextArea textArea = new TextArea();
		textArea = new TextArea("大家啊大家啊");
		textArea.setBackground(Color.white);
		textArea.setEditable(false);//不可编辑
		textArea.setFont(new Font("微软雅黑", Font.BOLD, 11));
		f.add(textArea);
		//显示窗体
		f.setVisible(true);
	}
}
