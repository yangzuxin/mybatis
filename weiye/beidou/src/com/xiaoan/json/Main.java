package com.xiaoan.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 使用JSONUtil工具类封装
 * <p>
 * fastjson.jar包
 * 把对象转换成json格式的字符串
 * public static String entity2JSON(Object entity);
 * <p>
 * 把实体对象转换成JSON字符串
 * public static String  entityList2JSON(List<?> entityList)
 * <p>
 * 将JSON字符串转换成指定类型的对象
 * public static <T> T JSON2Entity(String json, Class<T> clazz)
 * public static Object JSON2Entity(String json, Class<?> clazz)
 * <p>
 * 将JSON数组转换成指定类型对象列表
 * public static <T> List<T> JSONArray2List(String json, Class<T> clazz)
 * public static List<?> JSONArray2List(String json, Class<?> clazz)
 */

/**
 * @author 小安
 * @data 2020-05-01 18:26
 * JSON工具类 测试文件
 * 处理和json相关的内容
 */
public class Main {

	public static void main(String[] args) throws IOException {
        JsonUtil json = new JsonUtil();
        System.out.println("*************");
        String StrUrl = "首页";
        String jsonStr = getResult(StrUrl);
        String str = JSON2Entity(jsonStr, JsonUtil.class).getData();
        String string = JSON2Entity(str, JsonUtil.class).getVodrows();
        List<JsonUtil> jsonUtil = JSONArray2List(string, JsonUtil.class);
        String playUrl;
        for (JsonUtil json1 : jsonUtil) {
        	playUrl = "播放页链接"+json1.getPlay_url();
        	String result = getResult(playUrl);
        	String str2 = JSON2Entity(result, JsonUtil.class).getData();
        	JsonUtil json2Entity = JSON2Entity(str2, JsonUtil.class);
        	String httpurl;
        	if(json2Entity.getHttpurl() == null){
        		httpurl = json2Entity.getHttpurl_preview();
        	}else{
        		httpurl = json2Entity.getHttpurl();
        	}
            System.out.println(json1.getTitle()+"\n"+json1.getCoverpic()
            +"\n"+httpurl);
        	  
        }
    }
	
	public static String getResult(String str) throws IOException{
		//https://v1.alapi.cn/api/hitokoto?type=b  每日一言接口
		//设置机器人接口   key：6922db142c064f0db4dac5a01dda1c88  秘钥： b53e79c237b60610
		String requestUrl =str;
			//打开链接
			URL url = new URL(requestUrl);
			URLConnection uc = url.openConnection();
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
		return buffer.toString();
	}

    /**
     * 把对象转换成JSON格式的字符串
     *
     * @param jsonEntity 指定对象
     * @return 返回JSON格式的字符串
     */
    public static String entity2JSON(Object jsonEntity) {
        return JSON.toJSONString(jsonEntity);
    }

    /**
     * 把实体对象转换成JSON字符串
     *
     * @param entityList 实体对象
     * @return 返回JSON格式的字符串
     */
    public static String entityList2JSON(List<?> entityList) {
        return entity2JSON(entityList);
    }

    /**
     * 将JSON字符串转换成指定类型的对象
     * ？：泛型的通配符，未知的类型，或者说是Object
     *
     * @param json  要转换的数据
     * @param clazz 指定的类型
     * @return 返回Object对象
     */
    public static <T> T JSON2Entity(String json, Class<T> clazz) {
        //使用泛型
        return JSON.parseObject(json, clazz);
    }

    /**
     * 将JSON数组转换成指定类型对象列表
     * @param json 数据
     * @param clazz 指定的类型Class对象
     * @param <T>  泛型，任意类型
     * @return  返回数据列表
     */
    public static <T> List<T> JSONArray2List(String json, Class<T> clazz) {
        List<T> ts = JSON.parseArray(json, clazz);
        return ts;
    }
    /**
     * 例子
     * Entity entity = new Entity();
        entity.setId("1");
        entity.setOreateTime("18:00");
        entity.setDeleteTime("18:46");
        String json = entity2JSON(entity);
        System.out.println(json);

        System.out.println("*************");
        List<Entity> list = new ArrayList<>();
        list.add(entity);
        String listJson = entityList2JSON(list);
        System.out.println(listJson);

        System.out.println("*************");
        String jsonStr = "{\"deleteTime\":\"19:04\",\"id\":\"1\",\"idDel\":\"1\",\"oreateTime\":\"18:00\"}";
        Entity e = JSON2Entity(jsonStr, Entity.class);
        System.out.println(e.getDeleteTime());//获取删除时间

        System.out.println("**************");
        String jsonStrOne = "[{\"deleteTime\":\"19:14\",\"id\":\"1\",\"idDel\":\"1\",\"oreateTime\":\"18:00\"},{\"deleteTime\":\"19:15\",\"id\":\"1\",\"idDel\":\"1\",\"oreateTime\":\"18:00\"},{\"deleteTime\":\"19:16\",\"id\":\"1\",\"idDel\":\"1\",\"oreateTime\":\"18:00\"}]";
        List<Entity> list1 = JSONArray2List(jsonStrOne, Entity.class);
        for (Entity entity1 : list1) {
            System.out.println(entity1.getDeleteTime());
        }
     */
}
