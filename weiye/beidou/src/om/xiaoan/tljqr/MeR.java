package om.xiaoan.tljqr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MeR {

	public static void main(String[] args) throws IOException {
		
		     System.out.println("**********每日一言**********");
		     System.out.println("");
			 System.out.println(jiequ(getResult()));
	}

	private static String jiequ(String result) {
		int a =  result.indexOf("hitokoto");
		 int b = result.indexOf("type");
		 String str2 = result.substring(a,b);
		 int c = str2.length();
		 String str3 = str2.substring(12,(c-11));
		 if(str3.equals("")){
			 return "什么都没有";
		 }else{
			 return str3;
		 }
	}
	
	public static String getResult() throws IOException{
		//https://v1.alapi.cn/api/hitokoto?type=b  每日一言接口
		//设置机器人接口   key：6922db142c064f0db4dac5a01dda1c88  秘钥： b53e79c237b60610
//		String requestUrl ="https://v1.alapi.cn/api/hitokoto?type=b";
		String requestUrl ="http://android.fuliapps.com/vod/listing-13-0-0-0-0-0-2-0-2";
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
