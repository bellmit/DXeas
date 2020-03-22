/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class TransBirdsBillEditUI extends AbstractTransBirdsBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(TransBirdsBillEditUI.class);
    private String curStorageOrgUnitID;//当前库存组织
    private String curCompanyID;//当前财务组织
    private F7ContextManager f7Manager;
    private OrgUnitInfo orgInfo = null;//库存组织
    private boolean isLoadField=false;
    private BaseSysSettingInfo sysSetting;
    /**
     * output class constructor
     */
    public TransBirdsBillEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    public void loadFields()
    {
    	DataChangeListener[] ls = this.prmtstockingBatch.getListeners(DataChangeListener.class);
    	for(int i=0;i<ls.length;i++) {
    		this.prmtstockingBatch.removeDataChangeListener(ls[i]);
    	}
    	isLoadField=true;
    	super.loadFields(); 
    	isLoadField=false;
    	
    	for(int i=0;i<ls.length;i++) {
    		this.prmtstockingBatch.addDataChangeListener(ls[i]);
    	}
        
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
        return com.kingdee.eas.farm.stocking.processbizill.TransBirdsBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.processbizill.TransBirdsBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.TransBirdsBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        try {
        	objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID)));
        }catch(Exception err) {
        }
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
        	curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
    		super.onLoad();
    		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
    		f7Manager = new F7ContextManager(this, OrgType.Storage);
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
    		
    		StorageF7 sf7=new StorageF7();
    		sf7.setIsCUFilter(true);
    		this.prmtstorageOrgUnit.setSelector(sf7);
    		
    		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
    		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");
    		
    		setFilter();
    		
    		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
    			public void dataChanged(DataChangeEvent e) {
    				setFilter();
    			}});
    		
    		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
    			public void dataChanged(DataChangeEvent e) {
    				storageOrgUnit_changed(e);
    			}});
    		
    		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
    			public void dataChanged(DataChangeEvent e) {
    				setFilter();
    				if(!isLoadField) {
    					StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
    					StockingClientComm.setBatchByFarmerFarm(curCompanyID, prmtstockingBatch, prmtfarmer, prmtfarm);
    				}
    			}});
    		
    		this.prmtstockingBatch.addDataChangeListener(new DataChangeListener(){
    			public void dataChanged(DataChangeEvent e) {
    				batch_changed(e);
    			}});
    		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
    			public void editStarted(KDTEditEvent e) {
    				// TODO Auto-generated method stub
    				kdtEdit_started(e);
    			}});
    		
    	}
    	
    	private void kdtEdit_started(KDTEditEvent e) {
    		if(this.kdtEntrys.getColumnKey(e.getColIndex()).equals("orderFarmer")||this.kdtEntrys.getColumnKey(e.getColIndex()).equals("orderFarm")||this.kdtEntrys.getColumnKey(e.getColIndex()).equals("orderStockingBatch")) {
    			IRow row=kdtEntrys.getRow(e.getRowIndex());
    			String farmerID=null,farmID=null;
    			if(row.getCell("orderFarmer").getValue()!=null) {
    				farmerID=((IPropertyContainer) row.getCell("orderFarmer").getValue()).getString("id");
    			}
    			if(row.getCell("orderFarm").getValue()!=null) {
    				farmID=((IPropertyContainer) row.getCell("orderFarm").getValue()).getString("id");
    			}
    			//养殖场过滤
//    			if(this.kdtEntrys.getColumnKey(e.getColIndex()).equals("orderFarmer")) {
    				StockingClientComm.setFarmFilter((KDBizPromptBox) this.kdtEntrys.getColumn("orderFarm").getEditor().getComponent(), curCompanyID, farmerID);
//    			}else {
    				StockingClientComm.setStockingBatchFilter((KDBizPromptBox) this.kdtEntrys.getColumn("orderStockingBatch").getEditor().getComponent(), curCompanyID, farmerID, farmID);
//    			}
    		}
    	}
    	
    	
    	/**
    	 * 批次改变
    	 * 带出基本价格
    	 */
    	private void batch_changed(DataChangeEvent e) {
    		if(isLoadField){
    			return;
    		}
    		isLoadField=true;
    		String batchID=null;
    		if(e.getNewValue()!=null) {
    			batchID=((PropertyContainer) e.getNewValue()).getString("id");
    		}
    		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
    			//设置基础价格
    			StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));
    		}

			try {
				if(StringUtils.isNotEmpty(batchID)){
					this.prmtfarmer.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "farmer"));
					this.prmtfarm.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "farm"));
		    		if(this.kdtEntrys.getRowCount()<=0) {
	    			StringBuffer sql=new StringBuffer();
	    			sql.append(" select FBridMaterialID from t_fm_breedData t1")
	    			.append(" inner join t_fm_stockingBatch t2 on t2.Fbreeddataid=t1.fid")
	    			.append(" where t2.fid='").append(batchID).append("'")
	    			.append(" ");
	    			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
	    			if(rs.next()) {
	    				SelectorItemCollection slor=new SelectorItemCollection();
						slor.add(new SelectorItemInfo("*"));
	    				slor.add(new SelectorItemInfo("baseUnit.*"));
						MaterialInfo mInfo=MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(rs.getString("FBridMaterialID")),slor);
						IRow row = this.kdtEntrys.addRow();
						row.getCell("material").setValue(mInfo);
						kdtEntrys_Changed(row.getRowIndex(), kdtEntrys.getColumn("material").getColumnIndex());
	    			}
		    		}
				}
    			}catch(Exception err) {
    				err.printStackTrace();
    			}
    			isLoadField=false;
    	}
    	
    	private void storageOrgUnit_changed(DataChangeEvent e){
    		if(e.getNewValue()==null) {
    			curStorageOrgUnitID=null;
    		}else{
    			curStorageOrgUnitID=((PropertyContainer) this.prmtstorageOrgUnit.getValue()).getString("id");
    			try {
    				orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
    				f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
    				f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");
    			} catch (EASBizException e1) {
    				e1.printStackTrace();
    			} catch (BOSException e1) {
    				e1.printStackTrace();
    			}
    		}
    		
    	}
    	
    	/**
    	 * 设置过滤条件
    	 * @param companyID
    	 */
    	private void setFilter() {
    		if(this.prmtcompany.getValue()!=null) {
    			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
    		}else{
    			curCompanyID=null;
    		}
    		
    		//人员过滤
//    		StockingClientComm.makeApplierF7(this.prmtperson, companyID, this, false);
    		String farmerID=null,farmID=null;
    		if(prmtfarmer.getValue()!=null) {
    			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
    		}
    		if(prmtfarm.getValue()!=null) {
    			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
    		}
    		StockingClientComm.setStockingBatchFilter(prmtstockingBatch,curCompanyID,farmerID,farmID);
    		//养殖户过滤
    		StockingClientComm.setFarmerFilter(prmtfarmer, curCompanyID);
    		//养殖场过滤
    		StockingClientComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID);
    		
    		//批次过滤
    		StockingClientComm.setStockingBatchFilter((KDBizPromptBox) this.kdtEntrys.getColumn("orderStockingBatch").getEditor().getComponent(),curCompanyID,farmerID,farmID);
    		//养殖户过滤
    		StockingClientComm.setFarmerFilter((KDBizPromptBox) this.kdtEntrys.getColumn("orderFarmer").getEditor().getComponent(), curCompanyID,false);
    		//养殖场过滤
//    		String farmerID=null;
//    		if(this.prmtfarmer.getValue()!=null) {
//    			farmerID=((IPropertyContainer) this.prmtfarmer.getValue()).getString("id");
//    		}
//    		StockingClientComm.setFarmFilter((KDBizPromptBox) this.kdtEntrys.getColumn("orderFarm").getEditor().getComponent(), curCompanyID, farmerID);
    	}
    	@Override
    	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
    		// TODO Auto-generated method stub
    		super.kdtEntrys_Changed(rowIndex, colIndex);
    		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")) {			
    			//设置仓库
    			if(kdtEntrys.getCell(rowIndex,"material").getValue()!=null) {
    				kdtEntrys.getCell(rowIndex,"warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, ((PropertyContainer) kdtEntrys.getCell(rowIndex,"material").getValue()).getString("id")));
    				kdtEntrys.getCell(rowIndex,"orderWarehouse").setValue(kdtEntrys.getCell(rowIndex,"warehouse").getValue());
    			};
    		}
    		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")||kdtEntrys.getColumn(colIndex).getKey().equals("unit")) {	
    			//设置基础价格
    			String batchID=null;
    			if(prmtstockingBatch.getValue()!=null){
    				batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
    			}
    			StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));
    			//触发单价事件，带出金额
    			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
    		}
    		//设置目标基础价格
    		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")||kdtEntrys.getColumn(colIndex).getKey().equals("unit")||kdtEntrys.getColumn(colIndex).getKey().equals("orderStockingBatch")) {//目标批次	 
    			String orderBatchID=null;
    			if(kdtEntrys.getCell(rowIndex, "orderStockingBatch").getValue()!=null) {
    				orderBatchID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "orderStockingBatch").getValue()).getString("id");
    			}
    			StockingClientComm.setEntryOrderBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,orderBatchID,kdtEntrys.getRow(rowIndex));
    			//触发单价事件，带出金额
    			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("orderReceivePrice").getColumnIndex());
    		}
    			
    		//根据养殖户带出养殖场
    		if(kdtEntrys.getColumnKey(colIndex).equals("orderFarmer")) {
    			String farmerID=null;
    			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null) {
    				farmerID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, colIndex).getValue()).getString("id");
    			}
    			kdtEntrys.getCell(rowIndex, "orderFarm").setValue(StockingComm.getFarmInfoByFarmerID(null,farmerID));
    		}
    		//根据合同和批次带出养殖户和农场
    		if(kdtEntrys.getColumn(colIndex).getKey().equals("orderStockingBatch")) {
    			String batchID =null;
    			if(kdtEntrys.getCell(rowIndex, "orderStockingBatch").getValue()!=null){
    				batchID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "orderStockingBatch").getValue()).getString("id");
    			}
    			if(StringUtils.isNotEmpty(batchID)) {
    				SelectorItemCollection slorslor=new SelectorItemCollection();
    				slorslor.add(new SelectorItemInfo("farmer.*"));
    				slorslor.add(new SelectorItemInfo("farm.*"));
    				StockingBatchInfo bInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchID),slorslor);
    				kdtEntrys.getCell(rowIndex, "orderFarmer").setValue(bInfo.getFarmer());
    				kdtEntrys.getCell(rowIndex, "orderFarm").setValue(bInfo.getFarm());
    			}
    		}
    	}
    	
    	@Override
    	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
    		// TODO Auto-generated method stub
//    		super.actionCopy_actionPerformed(e);
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
//            editData.setNumber(null);
            editData.setFarmer(null);
            editData.setBizDate(new java.util.Date());
            setOprtState("ADDNEW");
            setDataObject(editData);
            loadFields();
            showCopyAddNew();
            actionCopy.setEnabled(false);
            chkMenuItemSubmitAndAddNew.setVisible(true);
            setDefaultFocused();
            
            setMakeRelations(null);
    	}
}