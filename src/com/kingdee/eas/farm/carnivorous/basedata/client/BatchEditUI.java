/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.ActionEvent;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class BatchEditUI extends AbstractBatchEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BatchEditUI.class);
    private String curCompanyID;
    private SystemSettingInfo sysSetting;
    /**
     * output class constructor
     */
    public BatchEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
    	ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
        super.loadFields();
//    	setUIStatus();
        
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BatchFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.carnivorous.basedata.BatchTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.BatchInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.BatchInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setInDate(new Date());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        return objectValue;
    }
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		initControl();
		this.btnRemove.setVisible(true);
//		this.txtNumber.setEnabled(true);
	}
	
	  
	private void initControl() throws Exception {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		sysSetting = StockingComm.getSystemSettingInfo(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		
		
		//设置棚舍的查询
		final KDBizPromptBox kdtHouseEntry_house_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.carviousFarmHouseQuery");
        kdtHouseEntry_house_PromptBox.setVisible(true);
        kdtHouseEntry_house_PromptBox.setEditable(true);
        kdtHouseEntry_house_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_house_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_house_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_house_PromptBox);
        this.kdtHouseEntry.getColumn("house").setEditor(kdtHouseEntry_house_CellEditor);
        ObjectValueRender kdtHouseEntry_house_OVR = new ObjectValueRender();
        kdtHouseEntry_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("house").setRenderer(kdtHouseEntry_house_OVR);
		
		
		
		
		
		StockingComm.setFarmerFilter(prmtfarmer, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		StockingComm.setFarmFilter(prmtfarm, SysContext.getSysContext().getCurrentFIUnit().getString("id"),null,null);
		StockingComm.setBatchContractFilter(prmtbatchContract, SysContext.getSysContext().getCurrentFIUnit().getString("id"), prmtfarmer, prmtfarm,true,true);

		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				company_changed(e);
			}});
		
		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setFarmFiler();
				StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
				StockingComm.setBatchContractFilter(prmtbatchContract, SysContext.getSysContext().getCurrentFIUnit().getString("id"), prmtfarmer, prmtfarm,true,true);
			}});
		
		prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				StockingComm.setBatchContractFilter(prmtbatchContract, SysContext.getSysContext().getCurrentFIUnit().getString("id"), prmtfarmer, prmtfarm,true,true);
			
				setHouseFilter();
				setHouseEntryHide();
			
			}});
		//检查是否具有初始化权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isInitStockingBatchCrt");
			this.txtinitBalanceAmount.setEnabled(true);
			this.txtinitMargin.setEnabled(true);
			this.txtinitLoanMargin.setEnabled(true);
			this.txtinitAllEggQty.setEnabled(true);
			this.txtinitFertilizeEggQty.setEnabled(true);
			this.txtinitQcEggQty.setEnabled(true);
		}catch(Exception err) {
			this.txtinitBalanceAmount.setEnabled(false);
			this.txtinitMargin.setEnabled(false);
			this.txtinitLoanMargin.setEnabled(false);
			this.txtinitAllEggQty.setEnabled(false);
			this.txtinitFertilizeEggQty.setEnabled(false);
			this.txtinitQcEggQty.setEnabled(false);
		}
        
		setHouseEntryHide();
		
	}
	/**
	 * 设置批次信息隐藏与否
	 */
	private void setHouseEntryHide() {
		boolean isExists=false;
		if(kDTabbedPane1.getComponentAt(kDTabbedPane1.getTabCount()-1).getName().equalsIgnoreCase("kDPanelHouseEntry")){
			isExists=true;
		}
		if(prmtfarm.getValue()==null) {
			if(isExists) {
				kDTabbedPane1.removeTabAt(kDTabbedPane1.getTabCount()-1);
			}
		}else{
			try {
				if((Boolean) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "isHouseManager")) {
					if(!isExists) {
						kDTabbedPane1.add("棚舍明细",kDPanelHouseEntry);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	/**
	 * 设置棚舍过滤条件
	 */
	private void setHouseFilter() {
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("parent.baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		if(this.prmtfarm.getValue()!=null) {
			filter.getFilterItems().add(new FilterItemInfo("parent.id",((IPropertyContainer) this.prmtfarm.getValue()).getString("id"),CompareType.EQUALS));
		}
		ev.setFilter(filter);
		((KDBizPromptBox) kdtHouseEntry.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
	}
	/**
	 * 公司改变
	 */
	private void company_changed(DataChangeEvent e) {
		try {
			if(e.getNewValue()!=null) {
				curCompanyID=((CompanyOrgUnitInfo) e.getNewValue()).getString("id");
			}else{
				curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	
	private void setFarmFiler() {
		String farmerID=null;
		if(this.prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) this.prmtfarmer.getValue()).getString("id");
		}
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,null);
		setHouseFilter();
	}
	
	 public void setOprtState(String oprtType)
	    {     super.setOprtState(oprtType);
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

		protected void setFieldsNull(AbstractObjectValue newData) {
			super.setFieldsNull(newData);
			newData.put("baseStatus", 1);
		}

	
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
	}

}