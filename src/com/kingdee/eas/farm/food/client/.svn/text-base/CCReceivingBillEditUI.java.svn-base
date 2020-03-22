/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.PurchaseBizUnitF7;
import com.kingdee.eas.basedata.org.client.f7.SaleBizUnitF7;
import com.kingdee.eas.basedata.org.client.f7.StorageBizUnitF7;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.business.CCLeaveBillInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CCReceivingBillEditUI extends AbstractCCReceivingBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCReceivingBillEditUI.class);
    private KDBizPromptBox kdtEntrys_CCLeaveBill_PromptBox;
    private final static int OWN_TYPE=1;
    private final static int OTHER_TYPE=2;
    private final static int ALL_TYPE=3;
    //private static int 

    /**
     * output class constructor
     */
    public CCReceivingBillEditUI() throws Exception
    {
        super();
        this.setUITitle("商品鸡接收单");
    	this.initControl();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(true);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.mBtnAudit.setEnabled(true);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(true);
			this.tBtnUnAudit.setEnabled(false);
		}else {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(false);
		}
        if(this.oprtState.equalsIgnoreCase(STATUS_ADDNEW)) {
        	fromStorageOrgUnitChanged(null);
        	storageOrgUnitChanged(null);
        }
        setControlFilter(ALL_TYPE);
    }


    
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}
	
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
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
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
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
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.loadData();
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
        return com.kingdee.eas.farm.food.CCReceivingBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.food.CCReceivingBillInfo objectValue = new com.kingdee.eas.farm.food.CCReceivingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        try{
	        StorageOrgUnitInfo stroageUnitOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
	        if(stroageUnitOrgInfo.isIsBizUnit())
	        	objectValue.setStorageOrgUnit(stroageUnitOrgInfo);
	        objectValue.setPurchaseOrgUnit(SysContext.getSysContext().getCurrentPurchaseUnit());
	        CompanyOrgUnitInfo companyOrg = SysContext.getSysContext().getCurrentFIUnit();
	        if(companyOrg!=null) {
	        	objectValue.setCompanyOrgUnit(companyOrg);
	        	//设置来源组织客户、既当前组织对应的客户
	        	objectValue.setCustomer(CustomerFactory.getRemoteInstance().getCustomerInfo("where internalCompany.id='"+companyOrg.getId().toString()+"'"));
	        }
        }catch(Exception e){ 
        	e.printStackTrace();
    	}
        return objectValue;
    }
    public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	
		
	}
    
	
	
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
	}
	private void initControl() throws Exception{
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		
		this.contLastUpdateTime.setVisible(true);
		this.contLastUpdateUser.setVisible(true);
		
		StorageBizUnitF7 storageF7 = new StorageBizUnitF7();
		storageF7.setIsCUFilter(true);
		this.prmtStorageOrgUnit.setSelector(storageF7);
		
		StorageBizUnitF7 fromStorageF7 = new StorageBizUnitF7();
		fromStorageF7.setIsCUFilter(false);
		this.prmtfromStorageOrgUnit.setSelector(fromStorageF7);
		
		CompanyF7 fiF7=new CompanyF7();
		fiF7.setIsCUFilter(true);
		this.prmtcompanyOrgUnit.setSelector(fiF7);
		
		CompanyF7 fromFFIF7=new CompanyF7();
		fromFFIF7.setIsCUFilter(false);
		this.prmtfromCompanyOrgUnit.setSelector(fromFFIF7);
		
		SaleBizUnitF7 saleF7=new SaleBizUnitF7();
		saleF7.setIsCUFilter(false);
		this.prmtfromSaleOrgUnit.setSelector(saleF7);
		
		PurchaseBizUnitF7 purF7=new PurchaseBizUnitF7();
		purF7.setIsCUFilter(true);
		this.prmtpurchaseOrgUnit.setSelector(purF7);
		
		final KDBizPromptBox kdtEntrys_PromptBox = new KDBizPromptBox();
		F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this,kdtEntrys_PromptBox);
		FilterInfo baseFilter=new FilterInfo();
		baseFilter.getFilterItems().add(new FilterItemInfo("name","%商品鸡%",CompareType.LIKE));
		baseFilter.setMaskString("#0");
		m7.setBaseFilter(baseFilter);
		//m7.setBaseFilter(new FilterInfo());
		kdtEntrys_PromptBox.setSelector(m7);
		kdtEntrys_PromptBox.setDisplayFormat("$name$");
		kdtEntrys_PromptBox.setEditFormat("$name$");
		kdtEntrys_PromptBox.setCommitFormat("$name$");
        KDTDefaultCellEditor kdtEntrys_CellEditor = new KDTDefaultCellEditor(kdtEntrys_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_CellEditor);
        
        this.contLastUpdateUser.setVisible(true);
        this.contLastUpdateTime.setVisible(true);
        
        this.prmtfromStorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {//来源仓库组织改变
				fromStorageOrgUnitChanged(e);
			}});
        this.prmtStorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				storageOrgUnitChanged(e);
			}});
        //商品鸡出场单
        kdtEntrys_CCLeaveBill_PromptBox = new KDBizPromptBox();
        kdtEntrys_CCLeaveBill_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.business.app.F7CCLeaveBillQuery");
        kdtEntrys_CCLeaveBill_PromptBox.setVisible(true);
        kdtEntrys_CCLeaveBill_PromptBox.setEditable(true);
        kdtEntrys_CCLeaveBill_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_CCLeaveBill_PromptBox.setEditFormat("$number$");
        kdtEntrys_CCLeaveBill_PromptBox.setCommitFormat("$number$");
        kdtEntrys_CCLeaveBill_PromptBox.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				CCLeaveBillChanged(e);
			}});
        KDTDefaultCellEditor kdtEntrys_CCLeaveBill_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CCLeaveBill_PromptBox);
        this.kdtEntrys.getColumn("CCLeaveBill").setEditor(kdtEntrys_CCLeaveBill_CellEditor);
        ObjectValueRender kdtEntrys_CCLeaveBill_OVR = new ObjectValueRender();
        kdtEntrys_CCLeaveBill_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("CCLeaveBill").setRenderer(kdtEntrys_CCLeaveBill_OVR);
	}
	/**
	 * 商品鸡出场单改变
	 * @param e
	 */
	private void CCLeaveBillChanged(DataChangeEvent e) {
		 IRow row = KDTableUtil.getSelectedRow(this.kdtEntrys);
		 if(row.getRowIndex()<0) {
			 return;
		 }
		CCLeaveBillInfo cclInfo=(CCLeaveBillInfo) e.getNewValue();
		if(cclInfo==null) {
			row.getCell("batch").setValue(null);
			row.getCell("fromWarehouse").setValue(null);
		}else {
			row.getCell("batch").setValue(cclInfo.getEntrys().get(0).getBatch());
			WarehouseInfo wareInfo=null;
			if(cclInfo.getEntrys().get(0).getWarehouse()!=null&&cclInfo.getEntrys().get(0).getWarehouse().getId()!=null)
				try {
					wareInfo=WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK(cclInfo.getEntrys().get(0).getWarehouse().getId()));
					row.getCell("fromWarehouse").setValue(wareInfo);
				} catch(Exception e1) {
					e1.printStackTrace();
				} 
		}
	}
/**
 * 来源仓库组织改变 带出财务组织、销售组织
 * @param e
 */
	private void  fromStorageOrgUnitChanged(DataChangeEvent e) {
		if(this.prmtfromStorageOrgUnit.getValue()!=null) {
			try {
				StorageOrgUnitInfo companyInfo=(StorageOrgUnitInfo) this.prmtfromStorageOrgUnit.getValue();
				String orgID=null;
				if(companyInfo.isIsCompanyOrgUnit()) {//是财务组织
					orgID=companyInfo.getId().toString();
				}else{
					orgID=FarmCommUtils.getFromOrgIDByRelation(null,companyInfo.getId().toString(), 4, 1);
				}
				if(!this.oprtState.equals(STATUS_ADDNEW))//非新增事件
					this.prmtfromCompanyOrgUnit.setValue(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(orgID)));

				this.prmtsupplier.setValue(SupplierFactory.getRemoteInstance().getSupplierInfo("where internalCompany.id='"+orgID+"'"));
				
				if(companyInfo.isIsSaleOrgUnit()) {//是否销售组织 来源带出本公司供应商，和来源销售组织
					orgID=companyInfo.getId().toString();
				}else{
					orgID=FarmCommUtils.getFromOrgIDByRelation(null,companyInfo.getId().toString(), 4, 2);
				}
				this.prmtfromSaleOrgUnit.setValue(SaleOrgUnitFactory.getRemoteInstance().getSaleOrgUnitInfo(new ObjectUuidPK(orgID)));
				
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		if(!this.oprtState.equals(STATUS_ADDNEW))
				setControlFilter(OTHER_TYPE);
	}
	/**
	 * 设置控件过滤条件
	 */
	private void setControlFilter(int filterType) {
		if(filterType==OTHER_TYPE||filterType==ALL_TYPE) {
			if (this.prmtfromStorageOrgUnit.getValue() != null) {
				StorageOrgUnitInfo companyInfo = (StorageOrgUnitInfo) this.prmtfromStorageOrgUnit.getValue();
				setWarehouseFilter("fromWarehouse", companyInfo.getId().toString());// 仓库过滤条件
				// 商品鸡出场单过滤条件
				EntityViewInfo ev = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("StorageOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("BillStatus", BillBaseStatusEnum.AUDITED.getValue(), CompareType.EQUALS));
				filter.setMaskString("#0 AND #1");
				ev.setFilter(filter);
				if(kdtEntrys_CCLeaveBill_PromptBox!=null)
					kdtEntrys_CCLeaveBill_PromptBox.setEntityViewInfo(ev);
			} else {
				this.prmtfromCompanyOrgUnit.setValue(null);
				this.prmtfromSaleOrgUnit.setValue(null);
				this.prmtsupplier.setValue(null);
				setWarehouseFilter("fromWarehouse", null);// 仓库过滤条件
				EntityViewInfo ev = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("BillStatus", BillBaseStatusEnum.AUDITED.getValue(), CompareType.EQUALS));
				filter.setMaskString("#0");
				ev.setFilter(filter);
				if(kdtEntrys_CCLeaveBill_PromptBox!=null)
					kdtEntrys_CCLeaveBill_PromptBox.setEntityViewInfo(ev);
			}
		}
		if(filterType==OWN_TYPE||filterType==ALL_TYPE) {
			if(this.prmtStorageOrgUnit.getValue()!=null) {
				StorageOrgUnitInfo companyInfo = (StorageOrgUnitInfo) this.prmtStorageOrgUnit.getValue();
				setWarehouseFilter("warehouse",companyInfo.getId().toString());//仓库过滤条件
			}else {
				this.prmtcompanyOrgUnit.setValue(null);
				this.prmtcustomer.setValue(null);
				this.prmtpurchaseOrgUnit.setValue(null);
				setWarehouseFilter("warehouse",null);//仓库过滤条件
		}
		}
	}
	/**
	 * 库存组织
	 * @param e
	 * @throws SQLException 
	 * @throws BOSException 
	 */
	private void  storageOrgUnitChanged(DataChangeEvent e)  {
		//仓库过滤条件
		if(this.prmtStorageOrgUnit.getValue()!=null) {
			try{
				StorageOrgUnitInfo companyInfo = (StorageOrgUnitInfo) this.prmtStorageOrgUnit.getValue();
				String orgID=companyInfo.getId().toString();
				if(companyInfo.isIsCompanyOrgUnit()) {//是财务组织
					orgID=companyInfo.getId().toString();
				}else{
					orgID=FarmCommUtils.getFromOrgIDByRelation(null,companyInfo.getId().toString(), 4, 1);
				}
				if(!this.oprtState.equals(STATUS_ADDNEW))//非新增事件
					this.prmtcompanyOrgUnit.setValue(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(orgID)));

				this.prmtcustomer.setValue(CustomerFactory.getRemoteInstance().getCustomerInfo("where internalCompany.id='"+orgID+"'"));
				
				if(companyInfo.isIsPurchaseOrgUnit()) {//是否采购组织 设置本组织采购组织，和来源组织客户
					orgID=companyInfo.getId().toString();
				}else{
					orgID=FarmCommUtils.getFromOrgIDByRelation(null,companyInfo.getId().toString(), 4, 3);
				}
				this.prmtpurchaseOrgUnit.setValue(PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(orgID)));
			}catch(Exception e1){}
		}
		if(!this.oprtState.equals(STATUS_ADDNEW))
			setControlFilter(OWN_TYPE);
	}
	/**
	 * 设置仓库过滤条件
	 */
	private void setWarehouseFilter(String colName,String companyID) {
		final KDBizPromptBox kdtEntrys_warehouse_PromptBox = new KDBizPromptBox();
		kdtEntrys_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
		kdtEntrys_warehouse_PromptBox.setVisible(true);
		kdtEntrys_warehouse_PromptBox.setEditable(true);
		kdtEntrys_warehouse_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_warehouse_PromptBox.setEditFormat("$number$");
		kdtEntrys_warehouse_PromptBox.setCommitFormat("$number$");
		
		if(StringUtils.isNotBlank(companyID)) {
			EntityViewInfo ev=new EntityViewInfo();
	        FilterInfo filter=new FilterInfo();
	        filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",companyID,CompareType.EQUALS));
	        filter.setMaskString("#0");
			ev.setFilter(filter);
			kdtEntrys_warehouse_PromptBox.setEntityViewInfo(ev);
		}
		
		KDTDefaultCellEditor kdtEntrys_warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_warehouse_PromptBox);
		this.kdtEntrys.getColumn(colName).setEditor(kdtEntrys_warehouse_CellEditor);
		ObjectValueRender kdtEntrys_warehouse_OVR = new ObjectValueRender();
		kdtEntrys_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn(colName).setRenderer(kdtEntrys_warehouse_OVR);
	}
	
	@Override
	 /**
	 * output kdtEntrys_Changed(int rowIndex,int colIndex) method
	 */
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "materialName").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty(
							(com.kingdee.bos.dao.IObjectValue) kdtEntrys.getCell(rowIndex, "material").getValue(),
							"name")));

		}

		if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "model").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty(
							(com.kingdee.bos.dao.IObjectValue) kdtEntrys.getCell(rowIndex, "material").getValue(),
							"model")));

		}

		if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "unit").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue) kdtEntrys
							.getCell(rowIndex, "material").getValue(), "baseUnit"));

		}

		if ("qty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "allAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "taxPrice").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));

		}

		if ("qty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "amount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));

		}

		if ("qty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "taxAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "allAmount").getValue())
							- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"amount").getValue())));

		}

		if ("qty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			if( com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"assistQty").getValue())!=0) 
			kdtEntrys.getCell(rowIndex, "assistUnitWeight").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty").getValue())
							/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"assistQty").getValue())));

		}

		if ("assistUnitWeight".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			if(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"assistUnitWeight").getValue())!=0)
			kdtEntrys.getCell(rowIndex, "assistQty").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty").getValue())
							/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"assistUnitWeight").getValue())));

		}

		if ("assistQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			if(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"assistQty").getValue())!=0)
			kdtEntrys.getCell(rowIndex, "assistUnitWeight").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty").getValue())
							/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"assistQty").getValue())));

		}

		if ("taxPrice".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "price").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "taxPrice").getValue())
							/ (1 + (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"rate").getValue()) / 100))));

		}

		if ("taxPrice".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "amount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));

		}

		if ("taxPrice".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "allAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "taxPrice").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));

		}

		if ("taxPrice".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "taxAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "allAmount").getValue())
							- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"amount").getValue())));

		}

		if ("price".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "taxPrice").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* (1 + (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"rate").getValue()) / 100))));

		}

		if ("price".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "allAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "taxPrice").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));
			kdtEntrys.getCell(rowIndex, "allAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "taxPrice").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));

		}

		if ("price".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "amount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));
			kdtEntrys.getCell(rowIndex, "amount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));

		}

		if ("price".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "taxAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "allAmount").getValue())
							- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"amount").getValue())));
			kdtEntrys.getCell(rowIndex, "taxAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "allAmount").getValue())
							- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"amount").getValue())));

		}

		if ("rate".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "price").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "taxPrice").getValue())
							/ (1 + (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"rate").getValue()) / 100))));

		}

		if ("rate".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "amount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));
			kdtEntrys.getCell(rowIndex, "amount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));
			kdtEntrys.getCell(rowIndex, "amount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));
			kdtEntrys.getCell(rowIndex, "amount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "price").getValue())
							* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "qty")
									.getValue())));

		}

		if ("rate".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex, "taxAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "allAmount").getValue())
							- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"amount").getValue())));
			kdtEntrys.getCell(rowIndex, "taxAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "allAmount").getValue())
							- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"amount").getValue())));
			kdtEntrys.getCell(rowIndex, "taxAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "allAmount").getValue())
							- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"amount").getValue())));
			kdtEntrys.getCell(rowIndex, "taxAmount").setValue(
					com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil
							.getBigDecimalValue(kdtEntrys.getCell(rowIndex, "allAmount").getValue())
							- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,
									"amount").getValue())));

		}
		//super.kdtEntrys_Changed(rowIndex, colIndex);
	}
	
}