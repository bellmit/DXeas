/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.EarlyEggStockFactory;
import com.kingdee.eas.farm.hatch.billStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class EarlyEggStockListUI extends AbstractEarlyEggStockListUI
{
	private static final Logger logger = CoreUIObject.getLogger(EarlyEggStockListUI.class);

	/**
	 * output class constructor
	 */
	public EarlyEggStockListUI() throws Exception
	{
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
		this.setPreferredSize(screenSize);
	}
	public void onLoad() throws Exception {
		super.onLoad();
		CompanyOrgUnitInfo currOrgUnitInfo = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);

		//      currOrgUnitInfo = SysContext.getSysContext().getCurrentFIUnit();
		String cuid;
		cuid = currOrgUnitInfo.getId().toString().trim();
		if (cuid.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("当前公司为虚体，不允许使用该功能。请选择实体公司！");
			SysUtil.abort();
		}
	}


	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(billStatus.AUDIT_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(billStatus.AUDIT_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return EarlyEggStockFactory.getRemoteInstance();
	}

}