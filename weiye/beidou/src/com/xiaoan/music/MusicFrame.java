package com.xiaoan.music;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MusicFrame extends JFrame  {
	
	JButton upMusic;
	JButton doMusic;
	Thread th;
	int index = 0;
	//路径不对空值异常
	File file = new File("D:\\javaPro\\weiye\\beidou\\music");
	File[] i = file.listFiles();
	int contun = i.length;
	TextArea textArea;
	JPanel musicText;
	//窗口无参构造方法
	public MusicFrame(){
		setSize(450,150);//大小
		setTitle("java音乐播放器");//标题
		setVisible(true);//窗口可见
		setLocationRelativeTo(null);//null为默认居中
		//关闭窗口停止进程  底层EXIT_ON_CLOSE的值为3
		//所以意味着setDefaultCloseOperation(3);也可以实现
		//但是在实际开发中，可读性和优化中间优先选择可读性，写3可读性不高
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inUI();//调用按钮面板方法
		jt();//调用监听方法
		//打开就播放
		MusicPlay musicPlayer = new MusicPlay(new File(musicPath(index)));
		th = new Thread(musicPlayer);
		th.start();
	}
	//面板
	public void inUI(){
		//按钮面板
		JPanel musicJpanel = new JPanel();
		upMusic = new JButton("上一首");
		doMusic = new JButton("下一首");
		musicJpanel.add(upMusic);
		musicJpanel.add(doMusic);
		add(musicJpanel,BorderLayout.SOUTH);
		//简介面板
		musicText = new JPanel(); 
		textArea = new TextArea(musicName(index));
		textArea.setBackground(Color.white);
		textArea.setSize(450, 20);
		textArea.setEditable(false);//不可编辑
		textArea.setFont(new Font("微软雅黑", Font.BOLD, 11));
		musicText.add(textArea);
		add(musicText,BorderLayout.NORTH);
		//歌词面板
		
		
	}
	
	//事件监听
	public void jt(){
		upMusic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//播放类
				//多线程
				index--;
				if(index < 0){
					index = 0;
					musicPath(index);
					thPlayer(musicPath(index));
				}else{
					thPlayer(musicPath(index));
				}
				/*//此处用多线程 否则会卡死
				 * try {	
					musicPlayer.playMusic();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		doMusic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//播放类
				//多线程
				index++;
				if(index >= contun){
					index = 0;
					thPlayer(musicPath(index));
				}else{
					thPlayer(musicPath(index));
				}
			}
		});
	}
	//优化多线程调用
	public void thPlayer(String path){
		th.stop();
		//System.out.println(index);
		textArea.setText(musicName(index));
		textArea.setFont(new Font("黑体",Font.BOLD,10));
		MusicPlay musicPlayer = new MusicPlay(new File(path));
		th = new Thread(musicPlayer);
		th.start();
	}
	//获取music文件夹都多少文件及文件名称
	public String musicPath(int a){
		StringBuilder sb = new StringBuilder();
		File path = i[a];
		//System.out.println(path);
		sb.append(path);
		return sb.toString();
	}
	
	//获取名字
	public String musicName(int a){
		StringBuilder sb = new StringBuilder();
		sb.append(i[a].getName());
		String name1 = sb.toString();
		name1 = name1.replace(".mp3", "");
		return name1;
	}
	
}
