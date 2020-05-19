package com.xiaoan.erweima;

import com.swetake.util.Qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

/**
 * 
 * @param
 *            <a href="http://badu.com">百度一下</a>
 */
public class XiaoAn {
	private static int v = 10;
	// 声明二维码的大小
	private static int w = 170;
	private static int h = 170;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		xiaoan("anananana","d://ddd.jpg");
	}
	
	private static void xiaoan(String str,String paths) throws UnsupportedEncodingException, IOException {
		// int x = 60,y = 60,z = 80;
		// System.out.printf("%d,%d,%d",x,y,z);
		// System.out.printf("%d+%d+%d",x,y,z);
		// 相关参数设置
		new Qrcode();
		Qrcode ewm = new Qrcode();
		// 设置 setXxx 获取 getXxx
		// 容错率
		ewm.setQrcodeErrorCorrect('H');
		// 北斗说是编码：
		ewm.setQrcodeEncodeMode('B');// 注意版本信息 N代表数字 、A代表 a-z,A-Z、B代表 其他)
		// 能放多少东西
		ewm.setQrcodeVersion(v);// 版本号 1-40
		/***************************************/
		// 绘制二维码
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		// 画图工具
		Graphics2D htgj = img.createGraphics();// 创建一个2D画图工具
		// 画图工具的背景
		htgj.setBackground(Color.white);//
		// 画笔颜色
		htgj.setColor(Color.black);
		// 画图工具初始化
		htgj.clearRect(0, 0, w, h);
		// 字符串转数组
		byte[] str1 = str.getBytes("UTF-8");// 一个字符占8个字节.一个汉字占2个字符
		if (str1.length > 0 && str1.length < 140) {
			boolean[][] ewsz = ewm.calQrcode(str1);
			// for循环 foreach循环的区别，foreach循环只读，for循环可读可写
			for (int i = 0; i < ewsz.length; i++) {
				for (int j = 0; j < ewsz.length; j++) {
					if (ewsz[i][j]) {
						htgj.fillRect(j * 3, i * 3, 3, 3);
					}
				}
			}
			//增强for
			// for(boolean[] b : ewsz){
			// for(boolean bs : b){
			// System.out.print(bs);
			//if (ewsz[i][j]) {
			//htgj.fillRect(j * 3, i * 3, 3, 3);
			// }
			// }
			// }
		}
		// 销毁当前画笔生成的空间
		htgj.dispose();
		// 刷新图像
		img.flush();
		// 输出图像
		File path = new File(paths);
		boolean yesandno = ImageIO.write(img, "jpg", path);
		if (yesandno) {
			System.out.println("二维码生成成功!");
		} else {
			System.err.println("二维码生成失败!");
		}
	}
}

//// TODO Auto-generated method stub
//// int x = 60,y = 60,z = 80;
//// System.out.printf("%d,%d,%d",x,y,z);
//// System.out.printf("%d+%d+%d",x,y,z);
// int v = 10;
//// 声明二维码的大小
// final int w = 140;
// final int h = 140;
//// 相关参数设置
// Qrcode ewm = new Qrcode();
//// 设置 setXxx 获取 getXxx
//// 设置容错率
/// **
// * 纠错等级分为
// * level L : 最大 7% 的错误能够被纠正；
// * level M : 最大 15% 的错误能够被纠正；
// * level Q : 最大 25% 的错误能够被纠正；
// * level H : 最大 30% 的错误能够被纠正；
// */
//// 容错率
// ewm.setQrcodeErrorCorrect('L');
//// 北斗说是编码：
// ewm.setQrcodeEncodeMode('B');//注意版本信息 N代表数字 、A代表 a-z,A-Z、B代表 其他)
//// 能放多少东西
// ewm.setQrcodeVersion(v);//版本号 1-40
// String qrData = "小安@一只阿宅啊！！";//内容信息
// byte[] d = qrData.getBytes("utf-8");//汉字转格式需要抛出异常
//
//// 缓冲区
// BufferedImage bufferedImage = new BufferedImage(w, h,
//// BufferedImage.TYPE_INT_BGR);
//
//// 绘图
// Graphics2D gs = bufferedImage.createGraphics();
//
// gs.setBackground(Color.WHITE);
// gs.setColor(Color.BLACK);
// gs.clearRect(0, 0, w, h);
//
//// 偏移量
// int pixoff = 2;
//
//
/// **
// * 容易踩坑的地方
// * 1.注意for循环里面的i，j的顺序，
// * s[j][i]二维数组的j，i的顺序要与这个方法中的 gs.fillRect(j*3+pixoff,i*3+pixoff, 3, 3);
// * 顺序匹配，否则会出现解析图片是一串数字
// * 2.注意此判断if (d.length > 0 && d.length < 120)
// * 是否会引起字符串长度大于120导致生成代码不执行，二维码空白
// * 根据自己的字符串大小来设置此配置
// */
// if (d.length > 0 && d.length < 120) {
// boolean[][] s = ewm.calQrcode(d);
//
// for (int i = 0; i < s.length; i++) {
// for (int j = 0; j < s.length; j++) {
// if (s[j][i]) {
// gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
// }
// }
// }
// }
// gs.dispose();
// bufferedImage.flush();
//// 设置图片格式，与输出的路径
// ImageIO.write(bufferedImage, "png", new File("D:/qrcode.png"));
// System.out.println("二维码生成完毕");
