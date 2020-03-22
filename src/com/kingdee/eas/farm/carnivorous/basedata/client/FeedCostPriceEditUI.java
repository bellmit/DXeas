/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.Date;

import org.apache.log4j.Logger;

import com.itrus.util.SystemUtils;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.BreedData;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.rptclient.newrpt.util.MsgBox;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class FeedCostPriceEditUI extends AbstractFeedCostPriceEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FeedCostPriceEditUI.class);

	/**
	 * output class constructor
	 */
	public FeedCostPriceEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();


		//为分录中的养殖场设置query
		final KDBizPromptBox kdtEntrys_outFarm_PromptBox = new KDBizPromptBox();
		kdtEntrys_outFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basebiz.app.FarmGroupQuery");
		kdtEntrys_outFarm_PromptBox.setVisible(true);
		kdtEntrys_outFarm_PromptBox.setEditable(true);
		kdtEntrys_outFarm_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_outFarm_PromptBox.setEditFormat("$number$");
		kdtEntrys_outFarm_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_outFarm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outFarm_PromptBox);
		this.kdtEntrys.getColumn("farm").setEditor(kdtEntrys_outFarm_CellEditor);
		//设置公司为必填项
		this.prmtcompany.setRequired(true);
		this.btnCancel.setVisible(true);
		this.btnCancel.setEnabled(true);
		this.btnCancelCancel.setVisible(true);
		this.btnCancelCancel.setEnabled(true);
		this.contAuditor.setVisible(false);
		this.contauditTime.setVisible(false);

	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
	{
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output MenuItemPCVoucher_actionPerformed method
	 */
	protected void MenuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.MenuItemPCVoucher_actionPerformed(e);
	}

	/**
	 * output menuItemDelPCVoucher_actionPerformed method
	 */
	protected void menuItemDelPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemDelPCVoucher_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		//默认品种为“商品代308”
		BreedDataInfo breedDataInfo = null;
		try {
			breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK("Uwyk6SNeT3GfXFYXNLEgdKenEw0="));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objectValue.setBreed(breedDataInfo);
		return objectValue;
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		if(this.editData.getBaseStatus()!=null&&!this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			MsgBox.showWarning("单据已经核准或禁用，禁止删除！");
			return;
		}
		super.actionRemove_actionPerformed(e);
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		try{
			super.actionAudit_actionPerformed(e);
		}catch(BOSException e1){
			MsgBox.showWarning(e1.getMessage());
			SysUtil.abort();
		}
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();

	}
	private void setUIStatus() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);		
			}else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);		
			}else  if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);		
			}else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}if(editData.getId()==null){
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);			
			this.actionEdit.setEnabled(false);
		}

	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();

	}
	/**
	 *设置单据复制之后单据的状态为未核准
	 */
	@Override
	protected void setFieldsNull(AbstractObjectValue newData) {
		// TODO Auto-generated method stub
		newData.put("baseStatus",FarmBaseStatusEnum.unApprove);
	}
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		try{
		super.actionCancelCancel_actionPerformed(e);
		}catch(BOSException e1){
			MsgBox.showWarning(e1.getMessage());
			SysUtil.abort();
		}
	}





}