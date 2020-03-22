/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CostCenterF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FarmersEditUI extends AbstractFarmersEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FarmersEditUI.class);
    private BaseSysSettingInfo sysSetting;
    /**
     * output class constructor
     */
    public FarmersEditUI() throws Exception
    {
        super();
    }
    @Override
	public void loadFields() {
		// TODO Auto-generated method 
		super.loadFields();
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
	}
    @Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
	}

	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
	
		super.actionCancelCancel_actionPerformed(e);
	}

	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmersFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.FarmersInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FarmersInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        return objectValue;
    }
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
		//分录F7添加过滤
//	 	//farm
	    KDBizPromptBox prmtPost = (KDBizPromptBox) kdtFarmEntry.getColumn("farm").getEditor().getComponent(); //养殖场  
//	    prmtPost.setValue( FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK("lwwAAAAXnuSteMMH")));
	    EntityViewInfo view1 = new EntityViewInfo(); // 新定义视图  
	    FilterInfo filter1 = new FilterInfo(); // 设置过滤条件  
	    filter1.getFilterItems().add(new FilterItemInfo("baseStatus", 3,CompareType.EQUALS)); // 未启用不出现
	   // String theGroupName = ((IPropertyContainer) prmttheGroup.getValue()).getString("Name");
//	    if(theGroupName!=null){
	    filter1.getFilterItems().add(new FilterItemInfo("isAllot", "1",CompareType.NOTEQUALS)); // 已分配不出现 
	    filter1.setMaskString("#0 and #1");
//	    }
	    view1.setFilter(filter1); // 设置过滤条件  
	    prmtPost.setEntityViewInfo(view1); // 重新设定视图  
	}
    
	private void initControl() {
		
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
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
		
//		CostCenterF7 cf7=new CostCenterF7();
//		cf7.setIsCUFilter(true);
//		this.prmtcostCenter.setSelector(cf7);
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(false);
        EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("CU.id",SysContext.getSysContext().getCurrentFIUnit().getString("id"),CompareType.EQUALS));
		evi.setFilter(filter );
		//this.prmtcostCenter.setEntityViewInfo(evi );
		
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter2 = new FilterInfo();
        filter2.getFilterItems().add(new FilterItemInfo("creatorCompany.id",SysContext.getSysContext().getCurrentFIUnit().getString("id"),CompareType.EQUALS));
		ev.setFilter(filter2 );
		prmtgeneralAsstActType.setEntityViewInfo(ev);		
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
		this.actionCancelCancel.setEnabled(true);
		this.actionEdit.setEnabled(false);
		
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
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCopy_actionPerformed(e);
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
//		loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}
	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		//内部管理
		if(sysSetting.isIsInner()) {
			if(this.prmtcostCenter.getValue()==null) {
				MsgBox.showWarning("成本中心不能为空！");
				SysUtil.abort();
			}
		}else{
			if(this.prmtsupplier.getValue()==null||this.prmtcustomer.getValue()==null) {
				MsgBox.showWarning("客户和供应商不能为空！");
				SysUtil.abort();
			}
		}
	}
	
}