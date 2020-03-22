/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class FarmerGuaranteeBillEditUI extends AbstractFarmerGuaranteeBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FarmerGuaranteeBillEditUI.class);

	/**
	 * output class constructor
	 */
	public FarmerGuaranteeBillEditUI() throws Exception
	{
		super();
	}
	private boolean isLoadField=false;
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
	}

	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;
		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
		setUIStatus();

		prmtFICompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent areg0) {
				if(prmtFICompany.getValue()!=null){
					setFilter();
				}
			}	
		});

		pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				pkbeginDate.setValue(pkBizDate.getValue());
			}
		});

		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarmer.getValue()!=null){
					String farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add("*");
					slor.add("person.*");
					try {
						FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerID),slor);
						prmtperson.setValue(farmer.getPerson());
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else{
					prmtperson.setValue(null);
				}
			}
		});

		setFilter();
	}

	private void setUIStatus() {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
			actionEdit.setEnabled(false);
			actionCancel.setEnabled(true);
			actionSave.setEnabled(false);
			actionSubmit.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
			actionCancelCancel.setEnabled(false);
			actionCancel.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)){
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			actionCancelCancel.setEnabled(true);
			actionEdit.setEnabled(false);
			actionCancel.setEnabled(false);
			actionSave.setEnabled(false);
			actionSubmit.setEnabled(false);
		}else{
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			actionCancelCancel.setEnabled(false);
			actionCancel.setEnabled(false);
			actionEdit.setEnabled(true);
		}
	}

	private void setFilter() {
		String companyID=null;
		if(this.prmtFICompany.getValue()!=null) {
			companyID=((IPropertyContainer) this.prmtFICompany.getValue()).getString("id");
		}
		StockingComm.setFarmerFilter(prmtfarmer, companyID,false);
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
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
		lockUIForViewStatus();
		setOprtState(STATUS_VIEW);
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
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
		setUIStatus();
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			MsgBox.showWarning("单据已经审核或禁用，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			MsgBox.showWarning("单据已经审核或禁用，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
	//重写父类方法,防止有单据转换直接赋上默认值的情况
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
		if(!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if(editData != null && !OprtState.VIEW.equals(getOprtState()))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if(objectValue != null)
				try
			{
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
		//        editData.setNumber(null);
		//		editData.setFarmer(null);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		//		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		//		editData.setPerson(null);
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		isLoadField=false;

		setMakeRelations(null);

	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setBeginDate(new Date());
		return objectValue;
	}

}