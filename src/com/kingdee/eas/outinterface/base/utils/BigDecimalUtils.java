package com.kingdee.eas.outinterface.base.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {
	
	/**
	 * ªÒ»°bigdecimal
	 * @param obj
	 * @return
	 */
	public static BigDecimal getBigDecimalValue(Object obj) {
		if(obj==null) {
			return BigDecimal.ZERO;
		}
		if(obj instanceof BigDecimal) {
			return (BigDecimal) obj;
		}
		return new BigDecimal(obj.toString());
	}
}
