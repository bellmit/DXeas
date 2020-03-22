package com.kingdee.eas.custom.bsxbudget.budgetCommUtils;

import java.math.BigDecimal;

public class BSXBudgetCommUtils {

	
	
	/**
	 * bigdecimal转整型  四舍五入
	 */
	public static int translateFromBigdecimalToInteger(BigDecimal value){
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
}
