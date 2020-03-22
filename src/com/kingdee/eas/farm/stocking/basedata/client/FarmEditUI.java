/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
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
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.CostCenterF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FarmEditUI extends AbstractFarmEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FarmEditUI.class);
    private String curStorageOrgUnitID;//当前库存组织
	private BaseSysSettingInfo sysSetting;
    
    /**
     * output class constructor
     */
    public FarmEditUI() throws Exception
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


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.FarmInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FarmInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
    	sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
    	curStorageOrgUnitID=sysSetting.getDefaultStorageOrgUnit().getString("id");
		super.onLoad();
		initControl();
	}
    
	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		BaseSysSettingInfo sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setWarehouseFilter();
			}});
		
		CostCenterF7 cof7=new CostCenterF7();
		cof7.setIsCUFilter(true);
		this.prmtcostCenter.setSelector(cof7);
		
		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);
		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setWarehouseFilter();
			}});
		
		if(sysSetting.getAccountType().equals(AccountTypeEnum.farm)) {
			contcostCenter.setVisible(true);
		}else{
			contcostCenter.setVisible(false);
		}
		this.kdtHouseEntry_detailPanel.getRemoveLinesButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkDeleteEntry();
			}});
		
		KDBizPromptBox kdtEntrys_warehouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_warehouse_PromptBox.setVisible(true);
        kdtEntrys_warehouse_PromptBox.setEditable(true);
        kdtEntrys_warehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_warehouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_warehouse_PromptBox.setCommitFormat("$number$");
        
//        String storageOrgUnitID=null;
//		if(prmtstorageOrgUnit.getValue()!=null) {
//			storageOrgUnitID=((IPropertyContainer) prmtstorageOrgUnit.getValue()).getString("id");
//		}
//        //仓库
//        EntityViewInfo ev=new EntityViewInfo();
//        FilterInfo filter=new FilterInfo();
//        filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",storageOrgUnitID,CompareType.EQUALS));
//        ev.setFilter(filter);
//        filter.getFilterItems().add(new FilterItemInfo("WHSTATE", "1",CompareType.EQUALS)); 
//    	filter.setMaskString("#0 and #1");
//        kdtEntrys_warehouse_PromptBox.setEntityViewInfo(ev);
        
        KDTDefaultCellEditor kdtEntrys_warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_warehouse_PromptBox);
        this.kdtHouseEntry.getColumn("warehouse").setEditor(kdtEntrys_warehouse_CellEditor);
        ObjectValueRender kdtEntrys_warehouse_OVR = new ObjectValueRender();
        kdtEntrys_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("warehouse").setRenderer(kdtEntrys_warehouse_OVR);
        
		setWarehouseFilter();
	}
	/**
	 * 设置仓库过滤条件
	 * DX修改仓库过滤条件
	 */
	private void setWarehouseFilter() {
		String storageOrgUnitID=null;
		if(prmtstorageOrgUnit.getValue()!=null) {
			//storageOrgUnitID=((IPropertyContainer) prmtstorageOrgUnit.getValue()).getString("id");
			storageOrgUnitID=((IPropertyContainer) prmtstorageOrgUnit.getValue()).getString("number");
			storageOrgUnitID = storageOrgUnitID.substring(0,5);
		}
		//仓库
	   EntityViewInfo ev=new EntityViewInfo();
       FilterInfo filter=new FilterInfo();
      // filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",storageOrgUnitID,CompareType.EQUALS));
       filter.getFilterItems().add(new FilterItemInfo("storageOrg.number",storageOrgUnitID+"%",CompareType.LIKE));
       ev.setFilter(filter);  
       filter.getFilterItems().add(new FilterItemInfo("WHSTATE", "1",CompareType.EQUALS)); 
       filter.setMaskString("#0 and #1");
       prmtwarehouse.setEntityViewInfo(ev);
       
       ((KDBizPromptBox) this.kdtHouseEntry.getColumn("warehouse").getEditor().getComponent()).setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
       ((KDBizPromptBox) this.kdtHouseEntry.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
       
       ((KDBizPromptBox) this.kdtHouseEntry.getColumn("slwarehouse").getEditor().getComponent()).setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
       ((KDBizPromptBox) this.kdtHouseEntry.getColumn("slwarehouse").getEditor().getComponent()).setEntityViewInfo(ev);
       
       ((KDBizPromptBox) this.kdtHouseEntry.getColumn("ypwarehousse").getEditor().getComponent()).setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
       ((KDBizPromptBox) this.kdtHouseEntry.getColumn("ypwarehousse").getEditor().getComponent()).setEntityViewInfo(ev);
	}
	
	protected void checkDeleteEntry()  {
		// TODO Auto-generated method stub
			IRow row = KDTableUtil.getSelectedRow(kdtHouseEntry);
			if(row==null||row.getRowIndex()<0) {
				return;
			}
			if(row.getCell("seq").getValue()==null) {
				return;
			}
			if(this.editData.getId()==null||this.editData.getHouseEntry().size()<=0) {
				return;
			}
			int seq=Integer.parseInt(row.getCell("seq").getValue().toString());
			if(seq<=0) {
				return;
			}
			String entryID=null;
			for(int index=0;index<this.editData.getHouseEntry().size();index++) {
				if(this.editData.getHouseEntry().get(index).getSeq()==seq) {
					entryID=this.editData.getHouseEntry().get(index).getString("id");
					break;
				}
			}
			
			if(StringUtils.isEmpty(entryID)) {
				return;
			}
			
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid from T_FM_StockingBatchHouseEntry where fhouseID='").append(entryID).append("'")
			/*.append(" union all")
			.append(" select fid from T_FM_BreedSeedBill where fhouseID='").append(entryID).append("'")*/
			.append(" ");
			IRowSet rs=null;
			try {
				rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			} catch (BOSException e) {
				e.printStackTrace();
			}
			if(rs.size()>0) {
				MsgBox.showWarning("棚舍已经被使用，禁止删除");
				SysUtil.abort();
			}
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

}