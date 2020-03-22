/**
 * output package name
 */
package com.kingdee.eas.custom.ccchargeback.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillFactory;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo;
import com.kingdee.eas.custom.ccchargeback.billStatus;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CcChargeBackBizBillListUI extends AbstractCcChargeBackBizBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(CcChargeBackBizBillListUI.class);

	/**
	 * output class constructor
	 */
	public CcChargeBackBizBillListUI() throws Exception
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
	 * output tblMain_tableClicked method
	 */
	protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
	{
		super.tblMain_tableClicked(e);
	}

	/**
	 * output tblMain_tableSelectChanged method
	 */
	protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
	{
		super.tblMain_tableSelectChanged(e);
	}

	/**
	 * output menuItemImportData_actionPerformed method
	 */
	protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemImportData_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo objectValue = new com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo();
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		setUI();
		super.onLoad();
	}

	/**
	 * UI设置
	 */
	private void setUI() {
		// TODO Auto-generated method stub
		this.setUITitle("商品鸡验收单");
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		refreshList();
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String pk = this.getSelectedKeyValue().toString();
		CoreBaseCollection coll = CcChargeBackBizBillFactory.getRemoteInstance().getCollection("where id='"+pk+"'");
		CcChargeBackBizBillInfo info=null;
		if(coll.size()>0)
			info=(CcChargeBackBizBillInfo)coll.get(0);
		if(info.getBillStatus().equals(billStatus.audit))
			commUtils.giveUserTipsAndRetire("禁止编辑已审核的验收标准");
		super.actionEdit_actionPerformed(e);
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核成功");
		refreshList();
	}
	
}