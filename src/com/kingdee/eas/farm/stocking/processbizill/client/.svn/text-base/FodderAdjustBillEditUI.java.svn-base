/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;

/**
 * output class name
 */
public class FodderAdjustBillEditUI extends AbstractFodderAdjustBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FodderAdjustBillEditUI.class);
	private IStockingBatch iStockingBatch = StockingBatchFactory.getRemoteInstance();
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织

	/**
	 * output class constructor
	 */
	public FodderAdjustBillEditUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		String curStorageOrgUnitID=StockingClientComm.checkAndGetStorageOrgUnitID();
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		initControl();
	}

	private void initControl() {
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);	

		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			@Override
			public void editStarting(KDTEditEvent e) {
				int rowIndex = e.getRowIndex();
				int colIndex = e.getColIndex();
				if(kdtEntrys.getColumnKey(colIndex).equals("batch")||kdtEntrys.getColumnKey(colIndex).equals("house")){
					setFilter(rowIndex);
				}
			}
			@Override
			public void editStopped(KDTEditEvent e) {
				int rowIndex = e.getRowIndex();
				int colIndex = e.getColIndex();
				if(kdtEntrys.getColumnKey(colIndex).equals("farm")){
					kdtEntrys.getCell(rowIndex, "batch").setValue(null);
					kdtEntrys.getCell(rowIndex, "house").setValue(null);
				}
				if(kdtEntrys.getColumnKey(colIndex).equals("batch")){
					kdtEntrys.getCell(rowIndex, "house").setValue(null);
				}
				if(kdtEntrys.getColumnKey(colIndex).equals("material")){
					if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null){
						String materialID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
						SelectorItemCollection slor=new SelectorItemCollection();
						slor.add("*");
						slor.add("baseUnit.*");
						try {
							MaterialInfo material=MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(materialID),slor);
							kdtEntrys.getCell(rowIndex, "unit").setValue(material.getBaseUnit());
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		setFilter(-1);
	}



	public void loadFields(){
		super.loadFields();
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
	}

	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	public void actionAudit_actionPerformed(ActionEvent e) throws Exception  {
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		if(!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if(editData != null && !OprtState.VIEW.equals(getOprtState())){
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if(objectValue != null)
				try{
					String id = idList.getID(idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
				}
			catch(Throwable E) { }
		}
		ObjectValueUtil.copy(editData);
		unLockUI();
		setFieldsNull(editData);
		editData.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		setMakeRelations(null);
	}

	private void setFilter(int rowIndex) {
		String companyID="";
		String farmID="";
		String batchID="";
		if(prmtFICompany.getValue()!=null){
			companyID=((IPropertyContainer)prmtFICompany.getValue()).getString("id");
		}
		orgInfo = SysContext.getSysContext().getCurrentStorageUnit();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",orgInfo.getId().toString(),CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		SelectorListener[] ls = ((KDBizPromptBox)kdtEntrys.getColumn("farm").getEditor().getComponent()).getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			((KDBizPromptBox)kdtEntrys.getColumn("farm").getEditor().getComponent()).removeSelectorListener(ls[i]);
		}
		((KDBizPromptBox)kdtEntrys.getColumn("farm").getEditor().getComponent()).setEntityViewInfo(evi);

		if(rowIndex!=-1&&kdtEntrys.getCell(rowIndex, "farm").getValue()!=null){
			farmID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
		}
		filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
		evi=new EntityViewInfo();
		evi.setFilter(filter);
		ls = ((KDBizPromptBox)kdtEntrys.getColumn("batch").getEditor().getComponent()).getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			((KDBizPromptBox)kdtEntrys.getColumn("batch").getEditor().getComponent()).removeSelectorListener(ls[i]);
		}
		((KDBizPromptBox)kdtEntrys.getColumn("batch").getEditor().getComponent()).setEntityViewInfo(evi);

		if(rowIndex!=-1&&kdtEntrys.getCell(rowIndex, "batch").getValue()!=null){
			batchID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "batch").getValue()).getString("id");
		}
		LinkedHashSet<String> houseSet = StockingComm.getHouseSetByBatchID(null, batchID);
		filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("id",houseSet,CompareType.INCLUDE));
		evi=new EntityViewInfo();
		evi.setFilter(filter);
		ls = ((KDBizPromptBox)kdtEntrys.getColumn("house").getEditor().getComponent()).getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			((KDBizPromptBox)kdtEntrys.getColumn("house").getEditor().getComponent()).removeSelectorListener(ls[i]);
		}
		((KDBizPromptBox)kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(evi);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.FodderAdjustBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.stocking.processbizill.FodderAdjustBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.FodderAdjustBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

}