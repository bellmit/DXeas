/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.assistbiz.client;

import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class CKFreightBillEditUI extends AbstractCKFreightBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKFreightBillEditUI.class);
	private boolean isLoadField=false;
	/**
	 * output class constructor
	 */
	public CKFreightBillEditUI() throws Exception
	{
		super();
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.txtgrowthFreight.setPrecision(3);	
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
	}
	
	public void loadFields(){
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

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

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	@Override
	public void actionCalFreight_actionPerformed(ActionEvent e)
	throws Exception {
		beforeStoreFields(e);
		storeFields();
		if(editData.getId()==null){
			super.actionSave_actionPerformed(e);
		}
		super.actionCalFreight_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("����ɹ�");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("��˳ɹ�");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	
	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�ٴ���ˣ�");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("������δ�ύ����ֹ��ˣ�");
			SysUtil.abort();
		}

		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("��ǰ�������ڹ�����ִ�й���,����ִ�иò���");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("��˳ɹ�");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("������δ��ˣ���ֹ����ˣ�");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("����˳ɹ�");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
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
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		isLoadField=false;

		setMakeRelations(null);

	}

	//��д���෽��,��ֹ�е���ת��ֱ�Ӹ���Ĭ��ֵ�����
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}