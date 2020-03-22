/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
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
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
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
public class EggRecycleEditUI extends AbstractEggRecycleEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(EggRecycleEditUI.class);
    private String curStorageOrgUnitID;//当前库存组织
    private String curCompanyID;//当前财务组织
    private F7ContextManager f7Manager;
    private OrgUnitInfo orgInfo = null;//库存组织
    private boolean isLoadField=false;
    ArrayList<String> list ;
	ArrayList<String> qcList;
	HashSet srcCompanyIDSet=new HashSet();;
    
    /**
     * output class constructor
     */
    public EggRecycleEditUI() throws Exception
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
    	
    	DataChangeListener[] ls2 = this.pkBizDate.getListeners(DataChangeListener.class);
    	for(int i=0;i<ls2.length;i++) {
    		this.pkBizDate.removeDataChangeListener(ls2[i]);
    	}
    	isLoadField=true;
    	super.loadFields(); 
    	isLoadField=false;
    	for(int i=0;i<ls.length;i++) {
    		this.prmtstockingBatch.addDataChangeListener(ls[i]);
    	}
    	for(int i=0;i<ls2.length;i++) {
    		this.pkBizDate.addDataChangeListener(ls2[i]);
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
        return com.kingdee.eas.farm.stocking.processbizill.EggRecycleFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.processbizill.EggRecycleInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.EggRecycleInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        try {
			objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID)));
		} catch (Exception e) {
			e.printStackTrace();
		} 
        objectValue.setBizDate(new Date());
        return objectValue;
    }
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
    	curStorageOrgUnitID=StockingClientComm.checkAndGetStorageOrgUnitID();
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
//		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");
		
		 //仓库
		   EntityViewInfo ev=new EntityViewInfo();
	       FilterInfo filter=new FilterInfo();
	       filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
	       ev.setFilter(filter);
	       ((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
		
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
				if(!isLoadField) {
					StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
					StockingClientComm.setBatchByFarmerFarm(curCompanyID, prmtstockingBatch, prmtfarmer, prmtfarm);
				}
				setFilter();
			}});
		
		this.prmtstockingBatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});
		
		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				bizDate_changed(e);
			}
			
		});
		//检查是否具有初始化权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isInitStockingBatchCrt");
			this.chkisInit.setVisible(true);
		}catch(Exception err) {
			this.chkisInit.setVisible(false);
		}
	}
	/**
	 * 业务日期改变
	 * @param e
	 */
	private void bizDate_changed(DataChangeEvent e) {
		if(e.getNewValue()!=null) {
			Date bizDate=(Date) e.getNewValue();
			String materialID;
			String str="";
			for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
				materialID=null;
				if(this.kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
					materialID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
				}
				BigDecimal eggBasePrice=StockingComm.getBasePriceByPricePolicy(null,curCompanyID, materialID, bizDate);
				if(eggBasePrice.signum()>0) {
					this.kdtEntrys.getCell(rowIndex, "basePrice").setValue(eggBasePrice);
				}else{
					str+=" "+(rowIndex+1);
					String batchID=null;
					if(prmtstockingBatch!=null) {
						batchID=((PropertyContainer) prmtstockingBatch.getValue()).getString("id");
					}
					//设置基础价格
					StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));
				}
				try {
					kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(str.length()>0) {
//				MsgBox.showInfo("第"+str+"行今日蛋品价格没有维护，讲采用保底价格！");
			}
		}else{
			for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
				this.kdtEntrys.getCell(rowIndex, "basePrice").setValue(BigDecimal.ZERO);
			}
		}
	}
	
	/**
	 * 批次改变
	 * 带出基本价格
	 */
	private void batch_changed(DataChangeEvent e) {
		if(isLoadField) {
			return;
		}
		isLoadField=true;
		String batchID=null;
		if(e.getNewValue()==null) {
			return;
		}
		try {
			batchID=((PropertyContainer) e.getNewValue()).getString("id");
			this.prmtfarmer.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "farmer"));
			this.prmtfarm.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "farm"));
			
			if(this.kdtEntrys.getRowCount()<=0) {
				list = StockingComm.getEggListByStockingBatchID(null, batchID, false);
				qcList = StockingComm.getEggListByStockingBatchID(null, batchID, true);
				IMaterial ims = MaterialFactory.getRemoteInstance();
				MaterialInfo mInfo;
				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("baseUnit.*"));
				MeasureUnitInfo kgUnit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK("gw5fUwEOEADgAAsRwKgSOFuCXFc="));
				IRow row;
				for(String materialID:list) {
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(materialID),slor);
					row=this.kdtEntrys.addRow();
					row.getCell("material").setValue(mInfo);
					row.getCell("materialName").setValue(mInfo.getName());
					row.getCell("model").setValue(mInfo.getModel());
					//菜单按公斤算
					if(!qcList.contains(materialID)) {
						row.getCell("unit").setValue(kgUnit);
					}else{
						row.getCell("unit").setValue(mInfo.getBaseUnit());
					}
					row.getCell("warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, mInfo.getString("id")));
				}
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			//设置基础价格
//			StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_IN_TYPE,batchID,kdtEntrys.getRow(rowIndex));
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
		 //仓库
		   EntityViewInfo ev=new EntityViewInfo();
	       FilterInfo filter=new FilterInfo();
	       filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
	       ev.setFilter(filter);
	       ((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
		
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
		
		try {
			srcCompanyIDSet.clear();
			srcCompanyIDSet.add(curCompanyID);
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct tmain.FCompanyID")
			.append(" from T_FM_BaseSysSetting tmain")
			.append(" inner join CT_FM_BaseSSSE tentry  on tentry.fparentid=tmain.fid")
			.append(" ")
			.append(" where tentry.FOutOrgType=").append(OutOrgEnum.HATCH_VALUE)
			.append(" and tentry.CFStorageOrgUnitID='").append(curCompanyID).append("'")
			;
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()) {
				srcCompanyIDSet.add(rs.getString("FCompanyID"));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		
		//人员过滤
//		StockingClientComm.makeApplierF7(this.prmtperson, companyID, this, false);
		//批次过滤
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		setStockingBatchFilter(prmtstockingBatch,srcCompanyIDSet,farmerID,farmID);
		//养殖户过滤
		setFarmerFilter(prmtfarmer, srcCompanyIDSet);
		//养殖场过滤
		setFarmFilter(this.prmtfarm, srcCompanyIDSet, farmerID);
	}
	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);
		String batchID=null;
		if(prmtstockingBatch.getValue()!=null){
			batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")) {			
			//设置仓库
			if(kdtEntrys.getCell(rowIndex,"material").getValue()!=null) {
				kdtEntrys.getCell(rowIndex,"warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, ((PropertyContainer) kdtEntrys.getCell(rowIndex,"material").getValue()).getString("id")));
			}

		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")||kdtEntrys.getColumn(colIndex).getKey().equals("unit")) {	
			//设置基础价格
	
			//StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_IN_TYPE,batchID,kdtEntrys.getRow(rowIndex));*/
			
			//带出种蛋价格政策
			String materialID=null;
			if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
				materialID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
			}
			BigDecimal eggBasePrice=StockingComm.getBasePriceByPricePolicy(null,curCompanyID, materialID, (Date) this.pkBizDate.getValue()); 
			if(eggBasePrice.signum()>0) {
				kdtEntrys.getCell(rowIndex, "basePrice").setValue(eggBasePrice);
			}else{
				//设置基础价格
				StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));
//				MsgBox.showInfo("第"+(rowIndex+1)+"行今日蛋品价格没有维护，讲采用保底价格！");
			}
			if(kdtEntrys.getCell(rowIndex, "receivePrice").getValue()==null||((BigDecimal)kdtEntrys.getCell(rowIndex, "receivePrice").getValue()).signum()<=0){
				kdtEntrys.getCell(rowIndex, "receivePrice").setValue(kdtEntrys.getCell(rowIndex, "basePrice").getValue());
			}
			//触发单价事件，带出金额
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumnIndex("receivePrice"));
		}
		//数量或重量改变
		if(kdtEntrys.getColumn(colIndex).getKey().equals("number")||kdtEntrys.getColumn(colIndex).getKey().equals("weight")) {
			if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
				String materialID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
				//合格单
				if(qcList==null) {
					qcList = StockingComm.getEggListByStockingBatchID(null, batchID, true);
				}
				if(qcList.contains(materialID)) {
					kdtEntrys.getCell(rowIndex, "qty").setValue(kdtEntrys.getCell(rowIndex,"number").getValue());
				}else {
					kdtEntrys.getCell(rowIndex, "qty").setValue(kdtEntrys.getCell(rowIndex,"weight").getValue());
				}
			}
			//触发数量事件，带出金额
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumnIndex("qty"));
		}
		//触发受精蛋数事件
		if(kdtEntrys.getColumn(colIndex).getKey().equals("number")||kdtEntrys.getColumn(colIndex).getKey().equals("ertilityQty")) {
			BigDecimal num=(BigDecimal) kdtEntrys.getCell(rowIndex, "number").getValue();
			if(num==null) {
				num=BigDecimal.ZERO;
			}if(num.signum()<=0) {
				kdtEntrys.getCell(rowIndex, "ertilityRate").setValue(BigDecimal.ZERO);
				return;
			}
			BigDecimal eQty=(BigDecimal) kdtEntrys.getCell(rowIndex, "ertilityQty").getValue();
			if(eQty==null){
				eQty=BigDecimal.ZERO;
			}
			BigDecimal rate=eQty.multiply(new BigDecimal(100)).divide(num,2,BigDecimal.ROUND_HALF_UP);
			kdtEntrys.getCell(rowIndex, "ertilityRate").setValue(rate);
		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("ertilityRate")){
			BigDecimal num=(BigDecimal) kdtEntrys.getCell(rowIndex, "number").getValue();
			if(num==null) {
				num=BigDecimal.ZERO;
			}
			BigDecimal rate=(BigDecimal) kdtEntrys.getCell(rowIndex, "ertilityRate").getValue();
			BigDecimal eQty=num.multiply(rate).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);
			kdtEntrys.getCell(rowIndex, "ertilityQty").setValue(eQty);
		}
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
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			if(kdtEntrys.getCell(rowIndex,"number").getValue()==null&&kdtEntrys.getCell(rowIndex,"weight").getValue()==null){
				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，数量和重量不能同时为0！");
				SysUtil.abort();
			}
		}
	}
	/**
	 * 给放养批次设置过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static void setStockingBatchFilter( final KDBizPromptBox prmtstockingBatch, final HashSet companyID,final String farmerID,final String farmID) {
		 // prmtstockingBatch	
		
		 SelectorListener[] ls = prmtstockingBatch.getSelectorListeners();
		 for(int i=0;i<ls.length;i++) {
			 prmtstockingBatch.removeSelectorListener(ls[i]);
		 }
        prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
        prmtstockingBatch.setVisible(true);		
        prmtstockingBatch.setEditable(true);		
        prmtstockingBatch.setDisplayFormat("$number$");		
        prmtstockingBatch.setEditFormat("$number$");		
        prmtstockingBatch.setCommitFormat("$number$");		
        prmtstockingBatch.setRequired(true);
        		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.INNER));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								if(StringUtils.isNotEmpty(farmerID)) {
									filter.getFilterItems().add(new FilterItemInfo("farmer.id",farmerID,CompareType.EQUALS));
								}
								if(StringUtils.isNotEmpty(farmID)) {
									filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
								}
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								return true;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								return true;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingBatch_F7ListUI));
					prmtstockingBatch_F7ListUI.setF7Use(true,ctx);
					prmtstockingBatch.setSelector(prmtstockingBatch_F7ListUI);
				}
			}
		});
	}
	
	 /* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public  static void setFarmerFilter(final KDBizPromptBox prmtfarmer,final HashSet companyID) {
		// prmtfarmer
		SelectorListener[] ls = prmtfarmer.getSelectorListeners();
		 for(int i=0;i<ls.length;i++) {
			 prmtfarmer.removeSelectorListener(ls[i]);
		 }
		 
	    prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
	    prmtfarmer.setEditable(true);		
	    prmtfarmer.setDisplayFormat("$name$");		
	    prmtfarmer.setEditFormat("$name$");		
	    prmtfarmer.setCommitFormat("$number$");		
	    prmtfarmer.setRequired(true);
	    		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.INNER));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								//获取业务员对应的养殖户
								 Set ids=new HashSet();
								 if(SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null) {
									 try {
										 StringBuffer sql=new StringBuffer();
										 sql.append(" select t2.FFarmerID from T_FM_PersonFarmerRelation t1  ")
										 .append(" inner join  T_FM_PersonFarmerRelationEntry t2 on t2.fparentid=t1.fid")
										 .append(" where FPersonID='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getString("id")).append("'")
										 .append(" ")
										 ;
										 IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
										 while(rs.next()) {
											 ids.add(rs.getString("FFarmerID"));
										 }
									 }catch(Exception err) {
										 err.printStackTrace();
									 }
								 }
								 
								if(ids.size()>0) {
									filter.getFilterItems().add(new FilterItemInfo("id",ids,CompareType.INNER));
								}
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								return true;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								return true;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
				}
			}
		});
	 }
	
	 /* 设置养殖场过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public  static void setFarmFilter(final KDBizPromptBox prmtfarm,final HashSet companyID,final String farmerID) {
		// prmtfarm	
		SelectorListener[] ls = prmtfarm.getSelectorListeners();
		 for(int i=0;i<ls.length;i++) {
			 prmtfarm.removeSelectorListener(ls[i]);
		 }
        prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        prmtfarm.setVisible(true);		
        prmtfarm.setEditable(true);		
        prmtfarm.setDisplayFormat("$name$");		
        prmtfarm.setEditFormat("$number$");		
        prmtfarm.setCommitFormat("$number$");		
        prmtfarm.setRequired(true);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								//养殖户所包含养殖场
								Set idSet=new HashSet();
								idSet.add("hahahahaha");
								if(StringUtils.isNotBlank(farmerID)) {
									try {
										StringBuffer sql=new StringBuffer();
										sql.append(" select distinct tentry.FFarmID from T_FM_Farmers tmain ")
										.append(" inner join T_FM_FarmersFarmEntry tentry on tentry.FParentid=tmain.fid")
										.append(" where tmain.FID='").append(farmerID).append("'")
										;
										IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
										while(rs.next()) {
											idSet.add(rs.getString("FFarmID"));
										}
									}catch(Exception err) {
										err.printStackTrace();
									}
								
								}
								
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.INNER));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								if(StringUtils.isNotBlank(farmerID)) {
									filter.getFilterItems().add(new FilterItemInfo("id",idSet,CompareType.INNER));
								}
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								return true;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								return true;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
					prmtfarm_F7ListUI.setF7Use(true,ctx);
					prmtfarm.setSelector(prmtfarm_F7ListUI);
				}
			}
		});
	}
	
}