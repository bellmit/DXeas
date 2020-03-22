/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.org.client.f7.CostCenterF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class FarmerEditUI extends AbstractFarmerEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FarmerEditUI.class);
	private static final String KDBizPromptBox = null;
	private SystemSettingInfo sysSetting;
	/**
	 * output class constructor
	 */
	public FarmerEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();

		setUIStatus();
		final KDBizPromptBox kdtFarmEntry_farm_PromptBox = new KDBizPromptBox();
		kdtFarmEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");
		kdtFarmEntry_farm_PromptBox.setVisible(true);
		kdtFarmEntry_farm_PromptBox.setEditable(true);
		kdtFarmEntry_farm_PromptBox.setDisplayFormat("$name$");
		kdtFarmEntry_farm_PromptBox.setEditFormat("$name$");
		kdtFarmEntry_farm_PromptBox.setCommitFormat("$number$;$name$;$MnemonicCode$");
		StockingComm.setFarmFilter(kdtFarmEntry_farm_PromptBox, SysContext.getSysContext().getCurrentFIUnit().getString("id"), null,false);
		KDTDefaultCellEditor kdtFarmEntry_farm_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_farm_PromptBox);
		this.kdtFarmEntry.getColumn("farm").setEditor(kdtFarmEntry_farm_CellEditor);
		ObjectValueRender kdtFarmEntry_farm_OVR = new ObjectValueRender();
		kdtFarmEntry_farm_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtFarmEntry.getColumn("farm").setRenderer(kdtFarmEntry_farm_OVR);
		
		StockingComm.setFarmerTypeFilter(prmtfarmerType, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
	}

	
    public void setOprtState(String oprtType)
    {
    	super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
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
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtFarmEntry.getRowCount();i++){
			if(kdtFarmEntry.getCell(i, "farm").getValue()==null){
				MsgBox.showWarning("第"+(i+1)+"行分录养殖场不能为空");
				SysUtil.abort();
			}
			Object temp=kdtFarmEntry.getCell(i, "memoryCode").getValue()==null?"null":kdtFarmEntry.getCell(i, "memoryCode").getValue();
//			for (int j= i+1;j<kdtFarmEntry.getRowCount(); j++)
//			{
//				if (temp.equals(kdtFarmEntry.getCell(j, "memoryCode").getValue()==null?"null":kdtFarmEntry.getCell(j, "memoryCode").getValue()))
//				{
//					MsgBox.showWarning("栋舍号重复！");
//					SysUtil.abort();
//				}
//			}
		}
		super.verifyInput(e);
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory.getRemoteInstance();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) 
	{
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
	}
	private void initControl() {


		contcostCenter.setVisible(false);
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		sysSetting = StockingComm.getSystemSettingInfo(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		//内部管理
		if(sysSetting.isIsInner()) {
			this.contcustomer.setVisible(false);
			this.contsupplier.setVisible(false);
			this.contcostCenter.setVisible(true);
			if(sysSetting.getAccountType().equals(AccountTypeEnum.farmer)) {
				contcostCenter.setVisible(true);
			}else{
				contcostCenter.setVisible(false);
			}
		}else{
			this.contcustomer.setVisible(true);
			this.contsupplier.setVisible(true);
			this.contcostCenter.setVisible(false);;
		}
		//		OrgF7 of7=new OrgF7();
		////		of7.setIsCUFilter(true);
		//		of7.setContainSealUp(true);
		//		of7.setIsShowContainSealUp(true);
		//		of7.setIsShowSub(true);
		//		of7.setShowVirtual(true);
		//		of7.setShowAssistantOrg(true);
		////		of7.set
		//		of7.setOrgTypes(new OrgType[]{OrgType.});
		//		this.prmtcostCenter.setSelector(of7);

		CostCenterF7 cf7=new CostCenterF7();
		cf7.setIsCUFilter(true);
		this.prmtcostCenter.setSelector(cf7);

		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter2 = new FilterInfo();
		filter2.getFilterItems().add(new FilterItemInfo("creatorCompany.id",SysContext.getSysContext().getCurrentFIUnit().getString("id"),CompareType.EQUALS));
		ev.setFilter(filter2 );
		prmtgeneralAsstActType.setEntityViewInfo(ev);	
	}
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		contcostCenter.setVisible(false);
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
		prmtgeneralAsstActType.setValue(null);
		txtidentity.setText(null);
		kdtFarmEntry.removeRows();
		txttotalMargin.setValue(null);
		txtoccupyMargin.setValue(null);
		txtenableMargin.setValue(null);
		setDefaultFocused();
	}

}