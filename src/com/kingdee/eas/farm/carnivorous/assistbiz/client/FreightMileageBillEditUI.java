/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.assistbiz.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTSortManager;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.hatch.GenerateType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FreightMileageBillEditUI extends AbstractFreightMileageBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FreightMileageBillEditUI.class);
	/**
	 * output class constructor
	 */
	public FreightMileageBillEditUI() throws Exception
	{
		super();
	}
	
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		KDTSortManager sm = new KDTSortManager(kdtEntrys){
			@Override
			public void sort(int colIndex, int sortType) {
				super.sort(colIndex, sortType);			
			}
		};		
		sm.setSortAuto(true); 
		sm.setClickCount(2); 
		for(int i=0;i<kdtEntrys.getColumnCount();i++){
			this.kdtEntrys.getColumn(i).setSortable(true); 
		}  
	}

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		routeType_changed();
	}
	
	@Override
	public void loadFields() {
		// TODO Auto-generated method 
		super.loadFields();
		setUIStatus();
		routeType_changed();
		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				kdtEntrys_changed(e.getRowIndex(),e.getColIndex());
			}

			@Override
			public void editStarting(KDTEditEvent e) {
				kdtEntrys_editStarting(e.getRowIndex(),e.getColIndex());
			}
		});

		routeType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				routeType_changed();
			}
		});
		setFilter();
	}

	private void kdtEntrys_changed(int rowIndex,int colIndex)  {
		if(kdtEntrys.getColumnKey(colIndex).equals("farmer")){
			if(kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null){
				String farmerID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
				FarmInfo farm = StockingComm.getFarmInfoByFarmerID(null, farmerID);
				kdtEntrys.getCell(rowIndex, "farm").setValue(farm);
				kdtEntrys.getCell(rowIndex, "farmAddress").setValue(farm.getAddress());
			}else{
				kdtEntrys.getCell(rowIndex, "farm").setValue(null);		
				kdtEntrys.getCell(rowIndex, "farmAddress").setValue(null);
			}
		}
		if(kdtEntrys.getColumnKey(colIndex).equals("farm")){
			if(kdtEntrys.getCell(rowIndex, "farm").getValue()!=null){
				String farmID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
				kdtEntrys.getCell(rowIndex, "farmer").setValue(StockingComm.getFarmerInfoByFarm(null, farmID));		
			}
		}
		if(kdtEntrys.getColumnKey(colIndex).indexOf("Freight")>0){
			routeType_changed();
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

	private void routeType_changed() {
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(routeType.getSelectedItem()==null){
				kdtEntrys.getCell(i, "seedFreight").setValue(null);		
				kdtEntrys.getCell(i, "fodderFreight").setValue(null);		
				kdtEntrys.getCell(i, "recCKFreight").setValue(null);		
			}else if(routeType.getSelectedItem()==FreightTypeEnum.seed){
				kdtEntrys.getCell(i, "fodderFreight").setValue(null);		
				kdtEntrys.getCell(i, "recCKFreight").setValue(null);	
			}else if(routeType.getSelectedItem()==FreightTypeEnum.Fodder){
				kdtEntrys.getCell(i, "seedFreight").setValue(null);		
				kdtEntrys.getCell(i, "recCKFreight").setValue(null);	
			}else if(routeType.getSelectedItem()==FreightTypeEnum.recCK){
				kdtEntrys.getCell(i, "seedFreight").setValue(null);		
				kdtEntrys.getCell(i, "fodderFreight").setValue(null);		
			}
		}
		if(routeType.getSelectedItem()==null){
			prmtbreedData.setEnabled(true);
			prmtcarSize.setEnabled(true);
		}else if(routeType.getSelectedItem()==FreightTypeEnum.seed){
			prmtbreedData.setEnabled(true);
			prmtcarSize.setEnabled(true);	
		}else{
			prmtbreedData.setEnabled(false);
			prmtcarSize.setEnabled(false);	
			prmtbreedData.setValue(null);
			prmtcarSize.setValue(null);
		}
	}

	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		if(routeType.getSelectedItem()!=null&&routeType.getSelectedItem()==FreightTypeEnum.seed){
			if(prmtbreedData.getValue()==null||prmtcarSize.getValue()==null){
				MsgBox.showWarning("雏苗类型,品种与车辆规格必须填写!");
				SysUtil.abort();
			}
		}
	}

	private void setFilter() {
		// TODO Auto-generated method stub
		String companyID=prmtFICompany.getValue()==null?"":((IPropertyContainer)prmtFICompany.getValue()).getString("id");
		StockingComm.setCarSizeFilter(prmtcarSize, companyID);
		StockingComm.setCalUnitFilter((KDBizPromptBox) kdtEntrys.getColumn("calUnit").getEditor().getComponent(), companyID);
		//品种过滤
		StockingComm.setBreedDataFilter(prmtbreedData,GenerateType.Commerce);
	}

	private void setUIStatus() {
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
		if (!(UtilRequest.isPrepare("ActionCopy", this))){
			checkModified();
		}
		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState())))){
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
		loadFields();
		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
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
		return com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		return objectValue;
	}

}