/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.Date;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.farm.carnivorous.basedata.CalUnit;
import com.kingdee.eas.farm.carnivorous.basedata.MaterialType;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class TempPolicyEditUI extends AbstractTempPolicyEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(TempPolicyEditUI.class);

	/**
	 * output class constructor
	 */
	public TempPolicyEditUI() throws Exception
	{
		super();
	}
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.kDPanel2.setVisible(false);
		this.kdtMarketPriceEntrys.setVisible(false);
	}

	@Override
	public void loadFields() {
		// TODO Auto-generated method 
		super.loadFields();
		setUIStatus();
		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				kdtEntrys_changed(e.getRowIndex(),e.getColIndex());
			}
			public void editStarting(KDTEditEvent e) {
				kdtEntrys_editStarting(e.getRowIndex(),e.getColIndex());
			}
		});

		materialType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				setUIStatus();				
			}
		});
	}

	private void kdtEntrys_changed(int rowIndex,int colIndex) {
		if(kdtEntrys.getColumnKey(colIndex).equals("farmer")){
			if(kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null){
				String farmerID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
				kdtEntrys.getCell(rowIndex, "farm").setValue(StockingComm.getFarmInfoByFarmerID(null, farmerID));		
			}else{
				kdtEntrys.getCell(rowIndex, "farm").setValue(null);		
			}
		}
		if(kdtEntrys.getColumnKey(colIndex).equals("farm")){
			if(kdtEntrys.getCell(rowIndex, "farm").getValue()!=null){
				String farmID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
				kdtEntrys.getCell(rowIndex, "farmer").setValue(StockingComm.getFarmerInfoByFarm(null, farmID));		
			}
		}
	}
	private void kdtEntrys_editStarting(int rowIndex,int colIndex) {
		String companyID=prmtFICompany.getValue()==null?"":((IPropertyContainer)prmtFICompany.getValue()).getString("id");
		StockingComm.setFarmerFilter((KDBizPromptBox) kdtEntrys.getColumn("farmer").getEditor().getComponent(), companyID);
		if(kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null){
			String farmerID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
			StockingComm.setFarmFilter((KDBizPromptBox) kdtEntrys.getColumn("farm").getEditor().getComponent(), companyID, farmerID, null);
		}
	}

	private void setUIStatus() {
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
			}
		}if(editData.getId()==null){
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);			
		}

		if(materialType.getSelectedItem()!=MaterialType.recCK){
			txtavgWgtFrom.setValue(null);
			txtavgWgtTo.setValue(null);
			txtavgWgtFrom.setEnabled(false);
			txtavgWgtTo.setEnabled(false);
			if(materialType.getSelectedItem()==MaterialType.marketPrice){
				txtkbPrice.setValue(null);
				txtkbPrice.setEnabled(false);
			}else{
				txtkbPrice.setEnabled(true);
			}
		}else{
			txtavgWgtFrom.setEnabled(true);
			txtavgWgtTo.setEnabled(true);
			txtkbPrice.setEnabled(true);
		}
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus()!=null&&!this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			MsgBox.showWarning("单据已经核准或禁用，禁止删除！");
			return;
		}
		super.actionRemove_actionPerformed(arg0);
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
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

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (!(UtilRequest.isPrepare("ActionCopy", this)))
		{
			checkModified();
		}

		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState()))))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if (objectValue != null)
			{
				try
				{
					String id = this.idList.getID(this.idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
				}
				catch (Throwable E) {
				}
			}
		}
		ObjectValueUtil.copy(this.editData);

		unLockUI();

		setFieldsNull(this.editData);
		setOprtState("ADDNEW");


		this.editData.setBaseStatus(null);

		setDataObject(this.editData);
		//	loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}


	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		if(materialType.getSelectedItem()!=MaterialType.recCK){
			txtavgWgtFrom.setValue(null);
			txtavgWgtTo.setValue(null);
			if(materialType.getSelectedItem()==MaterialType.marketPrice){
				txtkbPrice.setValue(null);
			}
			if(materialType.getSelectedItem()==MaterialType.seedCK&&calUnit.getSelectedItem()==CalUnit.kg){
				MsgBox.showWarning("物料类型选择雏鸡时,计算单位不能为公斤!");
				SysUtil.abort();
			}
		}else{
			if(txtavgWgtFrom.getBigDecimalValue()==null||txtavgWgtTo.getBigDecimalValue()==null){
				MsgBox.showWarning("物料选择毛鸡时,均重起止值必须填写!");
				SysUtil.abort();
			}
		}

//		if(materialType.getSelectedItem()!=MaterialType.marketPrice&&txtkbPrice.getBigDecimalValue()==null){
//			MsgBox.showWarning("物料类型不是毛鸡市场价时,扣补单价必须填写!");
//			SysUtil.abort();
//		}
	}

	@Override
	protected void setFieldsNull(AbstractObjectValue newData) {
		super.setFieldsNull(newData);
		newData.put("baseStatus", 1);
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basedata.TempPolicyFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());       
		return objectValue;
	}

}