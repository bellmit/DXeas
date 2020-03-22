package com.kingdee.eas.weighbridge.comm;

import com.kingdee.eas.base.btp.client.BTPBillEditImpl;
import com.kingdee.eas.framework.client.CoreBillEditUI;


public class BTPBillEditImplEx extends BTPBillEditImpl {
	public BTPBillEditImplEx(CoreBillEditUI billEditUI) {
		super(billEditUI);
	}
	protected String getCreateFromUI(int flag) {
		String fromUIClassName = "";
		if (flag == 0)
			fromUIClassName = "com.kingdee.eas.base.btp.client.BTPMakeBillFromUI";
		else if (flag == 1)
			fromUIClassName = "com.kingdee.eas.weighbridge.comm.BTPMakeBillFromMultiDataEx";
		else if (flag == 2) {
			fromUIClassName = "com.kingdee.eas.base.btp.client.BTPMakeBillFromMultiDataListUI";
		}
		return fromUIClassName;
	}
}