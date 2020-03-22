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
	 * ���� ֧�ֵ���� ��������bostype
	 */
	public static final Map<String,String> DataBosTypes = new HashMap<String,String>(){
		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = 5297573870846627916L;

		{
			// �ͻ�
			put("Customer", new CustomerInfo().getBOSType().toString());
			// ��Ӧ��
			put("Supplier", new SupplierInfo().getBOSType().toString());
			// ����
			put("Material", new MaterialInfo().getBOSType().toString());
			// ��Ŀ���� OK
			put("AccountView", new AccountViewInfo().getBOSType().toString());
			// ���������� ok
			put("AsstAccount", new AsstAccountInfo().getBOSType().toString());//465A10F8
			// �ұ� OK
			put("Currency", new CurrencyInfo().getBOSType().toString());
			// ƾ֤����
			put("VoucherType", "7487D35D");
			// ���� ok
			put("ExchangeRate", new ExchangeRateInfo().getBOSType().toString());//80E547EE
			// ���ʶ�Ӧ��ϵ ok
			put("ExchangeAux", new ExchangeAuxInfo().getBOSType().toString());//80E547EE
			// ���� ��ok
			put("ExchangeTable", new ExchangeTableInfo().getBOSType().toString());//80E547EE
			// �y���~�� OK
			put("AccountBank", new AccountBankInfo().getBOSType().toString());//FB326E5E
			// ���ڻ������y�У�	not OK
			put("Bank", new BankInfo().getBOSType().toString());//0C5D4387
			//�Զ��������Ŀ
			put("GeneralAsstActType", new GeneralAsstActTypeInfo().getBOSType().toString());//0C5D4387
			//�տ
			put("ReceivingBill", new ReceivingBillInfo().getBOSType().toString());//0C5D4387
			//���
			put("PaymentBill", new PaymentBillInfo().getBOSType().toString());//0C5D4387
			//�ɱ�������
			put("CostAdjustBill", new CostAdjustBillInfo().getBOSType().toString());//0C5D4387
		}
	};
	
	
	public static Map<String,String> getBaseDataTypes(){
		return DataBosTypes;
	}
	
	
}
