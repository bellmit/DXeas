/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.rptclient.newrpt.util.MsgBox;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class MarginPolicyEditUI extends AbstractMarginPolicyEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MarginPolicyEditUI.class);
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * output class constructor
	 */
	public MarginPolicyEditUI() throws Exception
	{
		super();
	}
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		 this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
	        this.prmtFICompany.setEditable(true);		
	        this.prmtFICompany.setDisplayFormat("$name$");		
	        this.prmtFICompany.setEditFormat("$number$");		
	        this.prmtFICompany.setCommitFormat("$number$");		
	        this.prmtFICompany.setRequired(true);
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
	public void loadFields() {
		// TODO Auto-generated method 
		super.loadFields();
		setUIStatus();
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
protected void beforeStoreFields(ActionEvent e) throws Exception {
	if(pkbeginDate.getValue()!=null&&pkendDate.getValue()!=null){
		Date beginDate = (Date) pkbeginDate.getValue();
		Date enbdDate = (Date) pkendDate.getValue();
		if(enbdDate.before(beginDate)){
			MsgBox.showWarning("结束日期不能小于开始日期");
			SysUtil.abort();
		}
	}
	super.beforeStoreFields(e);
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

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyFactory.getRemoteInstance();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) 
	{
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
	}
	
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//	super.actionCopy_actionPerformed(e);
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

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		try {
			objectValue.setBeginDate(sdf.parse(sdf.format(new Date())));
//			objectValue.setEndDate(sdf.parse(sdf.format(new Date())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectValue;
	}

}