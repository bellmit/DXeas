/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice;
import com.kingdee.eas.farm.carnivorous.basedata.IMarginPolicy;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class FeedCostPriceListUI extends AbstractFeedCostPriceListUI
{
	private static final Logger logger = CoreUIObject.getLogger(FeedCostPriceListUI.class);

	/**
	 * output class constructor
	 */
	public FeedCostPriceListUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		this.btnCancel.setVisible(true);
		this.btnCancel.setEnabled(true);
		this.btnCancelCancel.setVisible(true);
		this.btnCancelCancel.setEnabled(true);
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
	 * output menuItemPCVoucher_actionPerformed method
	 */
	protected void menuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemPCVoucher_actionPerformed(e);
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
		return com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceInfo();

		return objectValue;
	}

	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		actionRefresh_actionPerformed(e);
	}


	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if (this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("单据已经核准，禁止再次核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
		IFeedCostPrice iFeedCostPrice = (IFeedCostPrice)getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			iFeedCostPrice.audit(iFeedCostPrice.getFeedCostPriceInfo(pk));
		}
		MsgBox.showInfo("核准成功！");
		refreshList();
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if (!this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("未核准单据不能反核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
		IFeedCostPrice iFeedCostPrice = (IFeedCostPrice)getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 反核准操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			iFeedCostPrice.unAudit(iFeedCostPrice.getFeedCostPriceInfo(pk));		
		}
		MsgBox.showInfo("反核准成功！");
		refreshList();
	}


	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception{
		// TODO Auto-generated method stub
		checkSelected();
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
			return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
			prepareCancel(null).callHandler();
		}
		cancelCancel();
		actionRefresh_actionPerformed(e);
	}


}