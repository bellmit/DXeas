package com.kingdee.eas.farm.breed.comm;

/**
 * 养殖通用方法
 * @author USER
 *
 */
public class BreedCommonUtil {

	/**
	 * 获得周龄日龄的 四位 组合子串
	 * 如果是 1周1日龄  则返回 0101
	 * 如果是20周1日龄则返回 2001
	 * 
	 * @param week
	 * @param day
	 * @return
	 */
	public static String getWeekDayStr(int week,int day){
		if(week < 10){
			return "0"+week+"0"+day;
		}else{
			return week+"0"+day;
		}
		
	}
	/**
	 * 获得的是周龄
	 * 周龄小于10     返回 0+周龄   例如 5 周龄返回  05
	 * 周龄不小于10   直接返回周龄  例如 15周龄返回  15
	 *@param  week
	 *@return
	 */
	public static String getWeekStr(int week)
	{
		if(week<10){
			return "0"+week;
		}
		else{
			return String.valueOf(week);
		}
	}
}
