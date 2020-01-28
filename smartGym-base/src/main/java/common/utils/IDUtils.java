package common.utils;

import java.util.Random;

/**
 * 各种id生成策略
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年7月22日下午2:32:10
 * @version 1.0
 */
public class IDUtils {

	/**
	 * 图片名生成
	 *//*
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}*/
	
	/**
	 * 商品id生成
	 */
	public static long genId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	/*public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(genId());
	}*/
	
	/** 
	* @author Ma Shuaijie:
	* 
	* @version 创建时间：2019年10月23日 下午4:43:51 
	*
	*/
	
	/**
	 * 赛事id生成
	 */
	public static String comID(int existNum,int type1,int type2,int year) {
		String newString;
		newString =  year + "" + type1 + type2 + String.format("%03d", existNum + 1);
		return newString;
	}
	
	/**
	 * 比赛id合成
	 */
	public static String ceID(int existNum,String oldString) {
		String newString = oldString + "sj" + String.format("%03d", existNum + 1);
		return newString;	
	}
}
