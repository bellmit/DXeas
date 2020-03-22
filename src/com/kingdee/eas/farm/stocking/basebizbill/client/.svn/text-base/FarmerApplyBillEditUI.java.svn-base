/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basebizbill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory;
import com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FarmerApplyBillEditUI extends AbstractFarmerApplyBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FarmerApplyBillEditUI.class);
    
    /**
     * output class constructor
     */
    public FarmerApplyBillEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    public void loadFields()
    {
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
        if(this.editData.getFarmer()!=null) {
        	this.actionUnAudit.setEnabled(false);
        }
      /*  if(chkisTemplate.isSelected()) {
        	kdtEntrys.setEnabled(true);
        	  this.kdtEntrys.getColumn("checkItem").getStyleAttributes().setLocked(false);
        }*/
    }
    
    @Override
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
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionRemove_actionPerformed(e);
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
		super.actionAudit_actionPerformed(e);
		
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
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


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo objectValue = new com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo();
      //加载模板
        if(SysContext.getSysContext().getCurrentFIUnit()!=null){
        	FarmerApplyBillInfo info=this.getDefaultData(SysContext.getSysContext().getCurrentFIUnit().getString("id"));
	        if(info!=null) {
	        	objectValue=info;
	        	objectValue.setId(null);
	        	for(int index=0;index<objectValue.getEntrys().size();index++) {
	        		objectValue.getEntrys().get(index).setId(null);
	        	}
	        	for(int index=0;index<objectValue.getFarmEntry().size();index++) {
	        		objectValue.getFarmEntry().get(index).setId(null);
	        	}
	        }
        }
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        objectValue.setIsTemplate(false);
        objectValue.setBillStatus(BillBaseStatusEnum.ADD);
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
	}
    
	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
//				setFilter();
			}});

		this.kdtFarmEntry.checkParsed();
		KDBizPromptBox kdtFarmEntry_farmGroup_PromptBox = new KDBizPromptBox();
        kdtFarmEntry_farmGroup_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmGroupQuery");
        kdtFarmEntry_farmGroup_PromptBox.setVisible(true);
        kdtFarmEntry_farmGroup_PromptBox.setEditable(true);
        kdtFarmEntry_farmGroup_PromptBox.setDisplayFormat("$number$");
        kdtFarmEntry_farmGroup_PromptBox.setEditFormat("$number$");
        kdtFarmEntry_farmGroup_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmEntry_farmGroup_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_farmGroup_PromptBox);
	    this.kdtFarmEntry.getColumn("farmGroup").setEditor(kdtFarmEntry_farmGroup_CellEditor);
	    
		//检查是否具有设置权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isTemplateStockingFarmerApply");
			this.chkisTemplate.setVisible(true);
		}catch(Exception err) {
			err.printStackTrace();
			this.chkisTemplate.setVisible(false);
		}
		//检查是否具有评定项目权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isCheckItemEntrySFApply");
			this.kdtEntrys.setEnabled(true);
			this.kdtEntrys.getColumn("checkItem").getStyleAttributes().setLocked(false);
		}catch(Exception err) {
			err.printStackTrace();
			this.kdtEntrys.setVisible(false);
		}
        setFilter();
	}
	
	/**
	 * 获取默认的模板
	 * @param storageOrgUnit
	 * @return
	 */
	private FarmerApplyBillInfo getDefaultData(String companyID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid from T_FM_FarmerApplyBill ");
			sql.append(" where FCompanyID='").append(companyID).append("'");
			sql.append(" and FIsTemplate=1");
			sql.append(" order by FCreateTime desc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()){
				/*SelectorItemCollection slor=new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("material.*"));
				slor.add(new SelectorItemInfo("material1.*"));
				slor.add(new SelectorItemInfo("material2.*"));
				slor.add(new SelectorItemInfo("material3.*"));*/
				return FarmerApplyBillFactory.getRemoteInstance().getFarmerApplyBillInfo(new ObjectUuidPK(rs.getString("fid")),getSelectors());
				
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private void setFilter() {
		String companyID=null;
		if(this.prmtcompany.getValue()!=null) {
			companyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}
		
		EntityViewInfo ev=new EntityViewInfo();
        FilterInfo filter=new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("CU.id",SysContext.getSysContext().getCurrentCtrlUnit().getString("id"),CompareType.EQUALS));
		ev.setFilter(filter);
		
		((KDBizPromptBox) this.kdtFarmEntry.getColumn("farmGroup").getEditor().getComponent()).setEntityViewInfo(ev);
		
		EntityViewInfo ev2=new EntityViewInfo();
        FilterInfo filter2=new FilterInfo();
        filter2.getFilterItems().add(new FilterItemInfo("CU.id",SysContext.getSysContext().getCurrentCtrlUnit().getString("id"),CompareType.EQUALS));
        ev2.setFilter(filter2);
		this.prmtfarmerGroup.setEntityViewInfo(ev2);
		
	}
	
	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);
	}
	
	
	
	@Override
	public void kdtFarmEntry_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtFarmEntry_Changed(rowIndex, colIndex);
		//养殖场名称修改带出养殖场
		if(this.kdtFarmEntry.getColumnKey(colIndex).equals("name")) {
			if(this.kdtFarmEntry.getCell(rowIndex, colIndex).getValue()==null) {
				this.kdtFarmEntry.getCell(rowIndex, "farm").setValue(null);
			}else {
				if(this.prmtcompany.getValue()==null) {
					this.kdtFarmEntry.getCell(rowIndex, "farm").setValue(null);
				}else {
					FarmInfo farmInfo = StockingClientComm.getFarmInfoByNumOrName(((IPropertyContainer) this.prmtcompany.getValue()).getString("id"), null,this.kdtFarmEntry.getCell(rowIndex, colIndex).getValue().toString());
					if(farmInfo!=null) {
						this.kdtFarmEntry.getCell(rowIndex, "farm").setValue(farmInfo);
						this.kdtFarmEntry.getCell(rowIndex, "address").setValue(farmInfo.getAddress());
						this.kdtFarmEntry.getCell(rowIndex, "area").setValue(farmInfo.getArea());
						this.kdtFarmEntry.getCell(rowIndex, "succahQty").setValue(farmInfo.getSuccahQty());
					}else{
						this.kdtFarmEntry.getCell(rowIndex, "farm").setValue(null);
//						this.kdtFarmEntry.getCell(rowIndex, "address").setValue(null);
//						this.kdtFarmEntry.getCell(rowIndex, "area").setValue(null);
//						this.kdtFarmEntry.getCell(rowIndex, "succahQty").setValue(null);
					}
				}
			}
		}
	}
	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		checkExistIdentityFarmer();
	}
	/**
	 * 检查是否存在身份证号的养殖户
	 * @return
	 * @throws BOSException 
	 */
	private boolean checkExistIdentityFarmer() throws BOSException {
			
			String identity=this.txtidentity.getText().trim();
			String name=this.txtname.getText().trim();
			if(prmtfarmer.getValue()!=null&&((FarmersInfo)prmtfarmer.getValue()).getIdentity().equals(identity)) {
				return false;
			}
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("company.id",((IPropertyContainer) this.prmtcompany.getValue()).getString("id"),CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("identity",identity,CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("name",name,CompareType.EQUALS));
			ev.setFilter(filter);
			FarmersCollection col = FarmersFactory.getRemoteInstance().getFarmersCollection(ev);
			if(col!=null&&col.size()>0) {
//				if(this.editData.getFarmer()!=null&&this.editData.getFarmer().getId().equals(col.get(0).getId())) {
//					
//				}else {
					MsgBox.showWarning("相同\"姓名+身份证号\"的养殖户已经存在,不允许重复申请！");
					SysUtil.abort();
//				}
			}
		return false;
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
        editData.setBillStatus(BillBaseStatusEnum.ADD);
//        editData.setNumber(null);
        editData.setFarmer(null);
        editData.setBizDate(new java.util.Date());
        editData.setFarmer(null);
        editData.getEntrys().clear();
        setOprtState("ADDNEW");
        setDataObject(editData);
        loadFields();
        showCopyAddNew();
        actionCopy.setEnabled(false);
        chkMenuItemSubmitAndAddNew.setVisible(true);
        setDefaultFocused();
        
        setMakeRelations(null);
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(!this.chkisTemplate.isSelected()) {//不可见，非m模板
			super.beforeStoreFields(arg0);
		}
		if(this.kdtFarmEntry.getRowCount()<=0) {
			MsgBox.showWarning("养殖场信息不能为空！");
			SysUtil.abort();
		}
	}
	
}