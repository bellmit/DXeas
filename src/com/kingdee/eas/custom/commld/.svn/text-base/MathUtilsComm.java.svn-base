package com.kingdee.eas.custom.commld;

import java.math.BigDecimal;

import com.kingdee.bos.ui.face.UIRuleUtil;
import com.sun.msv.datatype.xsd.datetime.BigTimeDurationValueType;

public class MathUtilsComm {
	/**
	 * bigdecimal转整型  四舍五入
	 * @param value
	 * @return
	 */
	public static  int translateFromBigdecimalToInteger(BigDecimal value){
		String valueString = value.toString();
		if(valueString.indexOf(".")<0)
			return Integer.valueOf(valueString);
		else{
			if(Integer.valueOf(valueString.substring(valueString.indexOf(".")+1,valueString.indexOf(".")+2))>=5)
				return Integer.valueOf(valueString.substring(0,valueString.indexOf(".")))+1;
			else
				return 
				Integer.valueOf(valueString.substring(0,valueString.indexOf(".")));
		}
	}

	/**
	 * 将一个整数转化成特定长度的字符串
	 * @param length       需要转化成的字符串的长度
	 * @param number       需要转化的数字
	 * @return
	 */
	public static String getStringByNumber(int length,int number){
		//		if(String.valueOf(number).length()>=length)
		//			return String.valueOf(number);
		//		
		String str="";
		for(int i=String.valueOf(number).length();i<length;i++)
			str+="0";
		return str+=String.valueOf(number);
	}

	/**
	 * 获取两个BigDecimal值中的较大值
	 * @param bigOne
	 * @param bigdTwo
	 * @return
	 */
	public static BigDecimal getBiggerOneFromBigdecimalValues(BigDecimal bigOne,BigDecimal bigdTwo){
		if(UIRuleUtil.getBigDecimal(bigOne).compareTo(UIRuleUtil.getBigDecimal(bigdTwo))>=0)
			return bigOne;
		else
			return bigdTwo;
	}
	
	/**
	 * 获取两个BigDecimal值中的较x小值
	 * @param bigOne
	 * @param bigdTwo
	 * @return
	 */
	public static BigDecimal getSmallerOneFromBigdecimalValues(BigDecimal bigOne,BigDecimal bigdTwo){
		if(UIRuleUtil.getBigDecimal(bigOne).compareTo(UIRuleUtil.getBigDecimal(bigdTwo))>=0)
			return bigdTwo;
		else
			return bigOne;
	}
}
