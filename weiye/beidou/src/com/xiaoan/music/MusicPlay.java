package com.xiaoan.music;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MusicPlay extends Thread {
	//多线程
	public void run(){
		try {
			playMusic();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//1.成员变量  player jl.jar包自带
	Player player;//播放音乐的实例
	File music;//文件路径的实例
	//构造方法
	public MusicPlay(File file){
		this.music = file;	
		return;
	}
	//播放音乐方法
	public void playMusic() throws Exception{
		BufferedInputStream stream = new BufferedInputStream(new FileInputStream(music));
		player = new Player(stream);
		player.play();
	}	
}
