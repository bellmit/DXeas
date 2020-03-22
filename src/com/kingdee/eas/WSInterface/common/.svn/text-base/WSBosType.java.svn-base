package com.kingdee.eas.WSInterface.common;

import java.util.HashMap;
import java.util.Map;

import com.kingdee.eas.basedata.assistant.AccountBankInfo;
import com.kingdee.eas.basedata.assistant.BankInfo;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.ExchangeAuxInfo;
import com.kingdee.eas.basedata.assistant.ExchangeRateInfo;
import com.kingdee.eas.basedata.assistant.ExchangeTableInfo;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.master.auxacct.AsstAccountInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;
import com.kingdee.eas.scm.cal.CostAdjustBillInfo;

public class WSBosType {
	
	/**
	 * 保存 支持导入的 基础资料bostype
	 */
	public static final Map<String,String> DataBosTypes = new HashMap<String,String>(){
		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = 5297573870846627916L;

		{
			// 客户
			put("Customer", new CustomerInfo().getBOSType().toString());
			// 供应商
			put("Supplier", new SupplierInfo().getBOSType().toString());
			// 物料
			put("Material", new MaterialInfo().getBOSType().toString());
			// 科目类型 OK
			put("AccountView", new AccountViewInfo().getBOSType().toString());
			// 辅助账类型 ok
			put("AsstAccount", new AsstAccountInfo().getBOSType().toString());//465A10F8
			// 币别 OK
			put("Currency", new CurrencyInfo().getBOSType().toString());
			// 凭证类型
			put("VoucherType", "7487D35D");
			// 汇率 ok
			put("ExchangeRate", new ExchangeRateInfo().getBOSType().toString());//80E547EE
			// 汇率对应关系 ok
			put("ExchangeAux", new ExchangeAuxInfo().getBOSType().toString());//80E547EE
			// 汇率 表ok
			put("ExchangeTable", new ExchangeTableInfo().getBOSType().toString());//80E547EE
			// 銀行賬戶 OK
			put("AccountBank", new AccountBankInfo().getBOSType().toString());//FB326E5E
			// 金融机构（銀行）	not OK
			put("Bank", new BankInfo().getBOSType().toString());//0C5D4387
			//自定义核算项目
			put("GeneralAsstActType", new GeneralAsstActTypeInfo().getBOSType().toString());//0C5D4387
			//收款单
			put("ReceivingBill", new ReceivingBillInfo().getBOSType().toString());//0C5D4387
			//付款单
			put("PaymentBill", new PaymentBillInfo().getBOSType().toString());//0C5D4387
			//成本调整单
			put("CostAdjustBill", new CostAdjustBillInfo().getBOSType().toString());//0C5D4387
		}
	};
	
	
	public static Map<String,String> getBaseDataTypes(){
		return DataBosTypes;
	}
	
	
}
