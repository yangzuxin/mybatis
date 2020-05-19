package om.xiaoan.tljqr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("*************聊天机器人*************");
		System.out.println("输入退出结束");
		while(true){
			System.out.print("输入文字吧：");
			String sc = input.next();
			if(sc.equals("退出")){
				System.out.println("本次对话已结束");
				System.exit(0);
			}else{
				String str = getResult(sc);
				System.out.println(str);
			}
			
		}
		
	}
	
	//实现图灵机器人
	public static String getResult(String str) throws IOException{
		//
		String str1 = 	URLEncoder.encode(str,"UTF-8");
		//https://v1.alapi.cn/api/hitokoto?type=b  每日一言接口
		//设置机器人接口   key：6922db142c064f0db4dac5a01dda1c88  秘钥： b53e79c237b60610
		String requestUrl = "http://www.tuling123.com/openapi/api?key=6922db142c064f0db4dac5a01dda1c88&info="
				+str1;
			//打开链接
			URL url = new URL(requestUrl);
			URLConnection uc = url.openConnection();
//			System.out.println(uc);
			uc.connect();
			
			//程序外部的内容进入程序界面
			InputStream open = uc.getInputStream();
			InputStreamReader der = new InputStreamReader(open,"UTF-8");
			//代码往回拿
			BufferedReader br = new BufferedReader(der);
			String temp ="";
			StringBuffer buffer = new StringBuffer();
			//
			while((temp = br.readLine()) != null){
				buffer.append(temp);
			}
			//重点逻辑
			br.close();
			der.close();
			//
			//
		return buffer.toString();
	}

}
