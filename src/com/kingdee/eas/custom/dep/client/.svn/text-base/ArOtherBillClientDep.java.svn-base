package com.kingdee.eas.custom.dep.client;


import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.ep.client.UIParam;

/**
 * 应收单 dep扩展
 * @author Administrator
 *
 */
public class ArOtherBillClientDep {

	
	/**
     * 更新结算金额  
     * 
     * *****老折让代码****
     */
    public void updateClosingAmount(UIParam param) throws Exception
    {
        param.getKDFormattedTextField("txtClosingAmount").setValue(UIRuleUtil.getBigDecimal(UIRuleUtil.getBigDecimalValue(param.getKDFormattedTextField("txtTotalAmount").getValue())- UIRuleUtil.getBigDecimalValue(param.getKDFormattedTextField("txtDisAmount").getValue())));
    }
}
