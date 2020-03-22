/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
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
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
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
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class BirdsRecycleBillEditUI extends AbstractBirdsRecycleBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BirdsRecycleBillEditUI.class);
    private String curStorageOrgUnitID;//当前库存组织
    private String curCompanyID;//当前财务组织
    private F7ContextManager f7Manager;
    private OrgUnitInfo orgInfo = null;//库存组织
    private boolean isLoadField=false;
    /**
     * output class constructor
     */
    public BirdsRecycleBillEditUI() throws Exception
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
        return com.kingdee.eas.farm.stocking.processbizill.BirdsRecycleBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.processbizill.BirdsRecycleBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.BirdsRecycleBillInfo();
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
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");
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
		
		
		this.chkisWeightSettle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				isWeightSettle_changed();
			}});
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
	 * 是否重量结算改变事件
	 */
	private void isWeightSettle_changed(){
//		if(chkisWeightSettle.isSelected()) {
//			
//		}
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
			
			String breedDataID=((PropertyContainer) UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "breedData")).getString("id");
			
			if(this.kdtEntrys.getRowCount()<=0) {
				IMaterial ims = MaterialFactory.getRemoteInstance();
				MaterialInfo mInfo;

				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("baseUnit.*"));
				String materialID=BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(breedDataID)).getBridMaterial().getString("id");
				mInfo=ims.getMaterialInfo(new ObjectUuidPK(materialID),slor);
				IRow row=this.kdtEntrys.addRow();
				row.getCell("material").setValue(mInfo);
				row.getCell("materialName").setValue(mInfo.getName());
				row.getCell("model").setValue(mInfo.getModel());
				row.getCell("unit").setValue(mInfo.getBaseUnit());
				row.getCell("warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, mInfo.getString("id")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			//设置基础价格
			StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_IN_TYPE,batchID,kdtEntrys.getRow(rowIndex));
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
		
		//人员过滤
		StockingClientComm.makeApplierF7(this.prmtperson, curCompanyID, this, false);
		//养殖户过滤
		StockingClientComm.setFarmerFilter(prmtfarmer, curCompanyID);
		//批次过滤
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		StockingClientComm.setStockingBatchFilter(prmtstockingBatch,curCompanyID,farmerID,farmID);
		//养殖场过滤
		StockingClientComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID);
	}
	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")) {			
			//设置仓库
			if(kdtEntrys.getCell(rowIndex,"material").getValue()!=null) {
				kdtEntrys.getCell(rowIndex,"warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, ((PropertyContainer) kdtEntrys.getCell(rowIndex,"material").getValue()).getString("id")));
			}
		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")||kdtEntrys.getColumn(colIndex).getKey().equals("unit")) {	
			//设置基础价格
			String batchID=null;
			if(prmtstockingBatch.getValue()!=null){
				batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
			}
			StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_IN_TYPE,batchID,kdtEntrys.getRow(rowIndex));
			//触发单价事件，带出金额
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
		}
		//计算金额 公
		if(kdtEntrys.getColumn(colIndex).getKey().equals("qty")||kdtEntrys.getColumn(colIndex).getKey().equals("receivePrice")||kdtEntrys.getColumn(colIndex).getKey().equals("weight")) {	
			BigDecimal qty=(BigDecimal) kdtEntrys.getCell(rowIndex, "qty").getValue();
			BigDecimal weightQty=(BigDecimal) kdtEntrys.getCell(rowIndex, "weight").getValue();
			BigDecimal receivePrice=(BigDecimal) kdtEntrys.getCell(rowIndex, "receivePrice").getValue();
			BigDecimal amount=BigDecimal.ZERO,femaleAmount=BigDecimal.ZERO;
			if(qty==null) {
				qty=BigDecimal.ZERO;
			}
			if(weightQty==null) {
				weightQty=BigDecimal.ZERO;
			}
			
			if(receivePrice==null) {
				receivePrice=BigDecimal.ZERO;
			}
			
			if(chkisWeightSettle.isSelected()) {//重量结算
				amount=weightQty.multiply(receivePrice).setScale(2,BigDecimal.ROUND_HALF_UP);
			}else {//数量结算
				amount=qty.multiply(receivePrice).setScale(2,BigDecimal.ROUND_HALF_UP);
			}
			kdtEntrys.getCell(rowIndex, "amount").setValue(amount);
			
			if(kdtEntrys.getCell(rowIndex, "femaleAmount").getValue()!=null) {
				femaleAmount=(BigDecimal) kdtEntrys.getCell(rowIndex, "femaleAmount").getValue();
			}
			kdtEntrys.getCell(rowIndex, "allAmount").setValue(amount.add(femaleAmount));
		}
		
		//计算金额 母
		if(kdtEntrys.getColumn(colIndex).getKey().equals("femaleQty")||kdtEntrys.getColumn(colIndex).getKey().equals("femalePrice")||kdtEntrys.getColumn(colIndex).getKey().equals("femaleWeight")) {	
			BigDecimal qty=(BigDecimal) kdtEntrys.getCell(rowIndex, "femaleQty").getValue();
			BigDecimal weightQty=(BigDecimal) kdtEntrys.getCell(rowIndex, "femaleWeight").getValue();
			BigDecimal receivePrice=(BigDecimal) kdtEntrys.getCell(rowIndex, "femalePrice").getValue();
			BigDecimal amount=BigDecimal.ZERO,maleAmount=BigDecimal.ZERO;
			if(qty==null) {
				qty=BigDecimal.ZERO;
			}
			if(weightQty==null) {
				weightQty=BigDecimal.ZERO;
			}
			
			if(receivePrice==null) {
				receivePrice=BigDecimal.ZERO;
			}
			
			if(chkisWeightSettle.isSelected()) {//重量结算
				amount=weightQty.multiply(receivePrice).setScale(2,BigDecimal.ROUND_HALF_UP);
			}else {//数量结算
				amount=qty.multiply(receivePrice).setScale(2,BigDecimal.ROUND_HALF_UP);
			}
			kdtEntrys.getCell(rowIndex, "femaleAmount").setValue(amount);
			
			if(kdtEntrys.getCell(rowIndex, "femaleAmount").getValue()!=null) {
				maleAmount=(BigDecimal) kdtEntrys.getCell(rowIndex, "amount").getValue();
			}
			kdtEntrys.getCell(rowIndex, "allAmount").setValue(amount.add(maleAmount));
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
		if(chkisWeightSettle.isSelected()) {//重量结算
		}else {//数量结算
		}
	}
	@Override
	protected void setFieldsNull(AbstractObjectValue arg0) {
		// TODO Auto-generated method stub
		super.setFieldsNull(arg0);
	}
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
		vo.put("isWeightSettle", 1);
	}
	
}