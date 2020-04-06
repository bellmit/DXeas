/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class UpdateSettlementPolicy extends AbstractUpdateSettlementPolicy
{
	private static final Logger logger = CoreUIObject.getLogger(UpdateSettlementPolicy.class);

	/**
	 * output class constructor
	 */
	public UpdateSettlementPolicy() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * 查询
	 * output kDWorkButton1_actionPerformed method
	 */
	protected void kDWorkButton1_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.kDWorkButton1_actionPerformed(e);
		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit();
		String s1 = "/*dialect*/ select t1.fid  billid,t1.fnumber billNum,t1.fname_l2 billName" +
		" from T_FM_SettlePolicy t1 where t1.FCompanyID = '"+companyInfo.getId()+"'";
		IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
		String billid = null;
		String billNum = null;
		String billName = null;
		while(r1.next()){
			billid = UIRuleUtil.getString(r1.getString("billid"));
			billNum = UIRuleUtil.getString(r1.getString("billNum"));
			billName = UIRuleUtil.getString(r1.getString("billName"));
			IRow row = kDTable1.addRow();
			row.getCell("isSelect").setValue(false);
			row.getCell("spNum").setValue(billNum);
			row.getCell("spName").setValue(billName);
			row.getCell("spid").setValue(billid);
		}






	}

	/**
	 * 更新
	 * output kDWorkButton2_actionPerformed method
	 */
	protected void kDWorkButton2_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.kDWorkButton2_actionPerformed(e);
		try{
			List<String> errorList = new ArrayList<String>();
			//点击更新，将界面设置的属性值，放到Map里面
			Map<String,SettlePolicyInfo> choMap = new HashMap<String,SettlePolicyInfo>();
			SettlePolicyInfo entryInfo = null;
			for(int i = 0,size = kDTable1.getRowCount();i<size;i++){
					if(kDTable1.getCell(i,"isSelect").getValue().equals(true)){
						errorList.add(UIRuleUtil.getString(kDTable1.getCell(i,"isSelect").getValue()));
						String spid = UIRuleUtil.getString(kDTable1.getCell(i,"spid").getValue());
						entryInfo = SettlePolicyFactory.getRemoteInstance().getSettlePolicyInfo(new ObjectUuidPK(spid));
						choMap.put(spid, entryInfo);
					}
			}

			if(errorList.size() > 1){
				throw new Exception("只能选择一条记录！");
			}


			this.getUIContext().put("settlementBill", choMap);
		}catch(Exception e1){
			throw new Exception(e1.getMessage());
		}

		this.getUIWindow().close();
		this.destroyWindow();
	}

}