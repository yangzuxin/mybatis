package com.xiaoan.music;

import java.io.File;

public class Test extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("music\\");
		File[] i = f.listFiles();
		System.out.println(i.length);
		for (int a = 0;a<i.length ;a++){
			StringBuilder sb = new StringBuilder();
			sb.append(i[a].getName());
			String name1 = sb.toString();
			name1 = name1.replace(".mp3", "");
			System.out.println(name1);
		}
		new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
	}
}
/*
 * 附：java文件常用操作：

1.获取File路径和检测状态: 
1）操作File路径和名称: 
File getAbsoluteFile() :获取绝对路径 
String getAbsolutePath():获取绝对路径 
String getPath() :获取文件路径 
String getName() :获取文件名称 
File getParentFile():获取上级目录文件 
String getParent() :获取上级目录路径

2）检测File状态的方法: 
boolean canExecute() :判断是否是可执行文件 
boolean canRead() :判断该文件是否可读 
boolean canWrite():判断该文件是否可写 
boolean isHidden():判断该文件是否是隐藏文件 
long lastModified():判断该文件的最后修改时间 

long length():获取该文件的长度大小(单位字节)



2.File类中方法
1）文件操作: 
boolean isFile() :是否是文件 
boolean createNewFile() :创建新的文件 
static File createTempFile(String prefix, String suffix) :创建临时文件 
boolean delete() :删除文件 
void deleteOnExit() :在JVM停止时删除文件 
boolean exists():判断文件是否存在 
boolean renameTo(File dest) :重新修改名称

2）目录操作 
boolean isDirectory() :判断是否是目录 
boolean mkdir() :创建当前目录 
boolean mkdirs() :创建当前目录和上级目录 
String[] list() :列出所有的文件名 
File[] listFiles() :列出所有文件对象 
static File[] listRoots() :列出系统盘符
————————————————
版权声明：本文为CSDN博主「yoyofu007」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/yoyofu007/java/article/details/80994999*/
