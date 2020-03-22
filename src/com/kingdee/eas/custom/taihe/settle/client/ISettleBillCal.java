package com.kingdee.eas.custom.taihe.settle.client;

import com.kingdee.eas.custom.taihe.settle.client.SettleBillEditUI;
/**
 * 结算功能执行类
 * @author lenovo
 *
 */
public interface ISettleBillCal {
	//执行结算
	public void ExeCalSettleAmount(SettleBillEditUI settlebillEditUI) throws Exception;
}
