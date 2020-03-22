/**
 * output package name
 */
package com.kingdee.eas.custom.ccchargeback.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo;
import com.kingdee.eas.custom.ccchargeback.billStatus;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.client.IIDList;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class ChargeBackStdListUI extends AbstractChargeBackStdListUI
{
	private static final Logger logger = CoreUIObject.getLogger(ChargeBackStdListUI.class);

	/**
	 * output class constructor
	 */
	public ChargeBackStdListUI() throws Exception
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
	 * output menuItemImportData_actionPerformed method
	 */
	protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemImportData_actionPerformed(e);
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.getSelectedIdValues().size()==0)
			commUtils.giveUserTipsAndRetire("请选择记录行");
		super.actionAudit_actionPerformed(e);
		refreshList();
		setMessageText("审核成功");
	    showMessage();
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.getSelectedIdValues().size()==0)
			commUtils.giveUserTipsAndRetire("请选择记录行");
		super.actionUnAudit_actionPerformed(e);
		refreshList();
		setMessageText("反审核成功");
	    showMessage();
	}

	/**
	 * output actionPageSetup_actionPerformed
	 */
	public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPageSetup_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo objectValue = new com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo();

		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUI();
	}

	private void setUI() {
		// TODO Auto-generated method stub
		this.setUITitle("商品鸡验收标准");
		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
		//修改图标
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		btnAudit.setHideActionText(false);
		btnUnAudit.setHideActionText(false);
		btnCancel.setHideActionText(false);
		btnCancelCancel.setHideActionText(false);
	}

	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		MsgBox.showInfo("禁用成功");
		refreshList();
	}

	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionCancelCancel_actionPerformed(e);
		if(this.getSelectedIdValues().size()>1)
			commUtils.giveUserTipsAndRetire("一次只能启用一行记录");
		if(this.getSelectedKeyValues().size()==0)
			commUtils.giveUserTipsAndRetire("请选择记录行");



		String id = this.getSelectedKeyValue();
		CoreBaseCollection coll = ChargeBackStdFactory.getRemoteInstance().getCollection("where ID='"+id+"'");
		ChargeBackStdInfo info = (ChargeBackStdInfo)coll.get(0);

		ChargeBackStdFactory.getRemoteInstance().cancelCancel(new ObjectUuidPK(info.getId().toString()), info);
		MsgBox.showInfo("启用成功");
		refreshList();
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String pk = this.getSelectedKeyValue().toString();
		CoreBaseCollection coll = ChargeBackStdFactory.getRemoteInstance().getCollection("where id='"+pk+"'");
		ChargeBackStdInfo info=null;
		if(coll.size()>0)
			info=(ChargeBackStdInfo)coll.get(0);
		if(info.getBillStatus().equals(billStatus.cancelcancel))
			commUtils.giveUserTipsAndRetire("禁止编辑已启用的验收标准");
		super.actionEdit_actionPerformed(e);
	}

}