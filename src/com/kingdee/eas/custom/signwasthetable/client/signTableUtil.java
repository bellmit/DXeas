package com.kingdee.eas.custom.signwasthetable.client;

public class signTableUtil {

	
	/**
	 * 判断一个袁术是否存在于一个数组中
	 * @param obj   元素
	 * @param array 数组
	 * @return      是：true 否：false
	 */
	public static boolean isInArray(Object obj,Object[] array){
		for(int i=0;i<array.length;i++)
			if(array[i].equals(obj))
				return true;
		return false;
	}
}
