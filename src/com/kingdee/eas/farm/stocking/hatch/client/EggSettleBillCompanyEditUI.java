/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.reportone.r1.print.data.AbstractPrintDataProvider;
import com.kingdee.bos.ctrl.reportone.r1.print.data.R1PrintDataSource;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryCollection;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryPriceEntryCollection;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryPriceEntryInfo;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.KDTableUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class EggSettleBillCompanyEditUI extends AbstractEggSettleBillCompanyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(EggSettleBillCompanyEditUI.class);
    private String curCompanyID;//当前财务组织
    
    /**
     * output class constructor
     */
    public EggSettleBillCompanyEditUI() throws Exception
    {
        super();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension((int)(d.getWidth()*0.8),(int)(d.getHeight()*0.8)));
		this.setUITitle("代孵费结算单");
    }
    /**
     * output loadFields method
     */
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
        setColHide();
    }


    @Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
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
	/**
	 * 设置枚数 提交时
	 * @throws BOSException 
	 */
    private void setNum() throws BOSException{
    	if(this.editData.getId() == null){
    		MsgBox.showWarning("请先保存单据！");
    		SysUtil.abort();
    	}else{
    		EggSettleBillCompanyEntryCollection collection=editData.getEntrys();
    		for (int i = 0; i < collection.size(); i++) {//获取主分录
    			int mei=0;
    			EggSettleBillCompanyEntryInfo info=collection.get(i);
    			EggSettleBillCompanyEntryPriceEntryCollection col=info.getPriceEntry();//子分录
    			for (int j = 0; j < col.size(); j++) {//遍历子分录
    				EggSettleBillCompanyEntryPriceEntryInfo einfo=col.get(j);
    				if(StringUtils.isNotEmpty(einfo.getRemark())&&("代孵费(负数扣减)").equals(einfo.getRemark())){
    					mei=einfo.getNum();
    					break;
    				}
				}
    			StringBuffer sql= new StringBuffer();
    			sql.append("update CT_FM_EggSBCE set CFMeiNum='").append(new BigDecimal(mei)).append("' where fid='").append(info.getId().toString()).append("'");
    			ToolFacadeFactory.getRemoteInstance().execute(sql.toString());
    		}
			
		}
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
    
    
    @Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
    	
		super.actionSubmit_actionPerformed(e);
		setNum();
		refreshCurPage();
	}
	/**
     * 执行结算
     */
    public void actionExeSettle_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.conthatchBeginDate.isVisible()&&(this.pkhatchBeginDate.getValue()==null||this.pkhatchEndDate.getValue()==null)) {
    		 MsgBox.showWarning("出雏日期不能为空！");
    		 SysUtil.abort();
    	}
    	
    	if(this.editData.getBillStatus()!=null&&this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止结算！");
			return;
		}
		if(MsgBox.showConfirm2("是否进行种蛋结算？")!=MsgBox.YES) {
			return;
		}
		
		 if(this.editData.getId()==null) {
			 this.editData.setId(BOSUuid.create(this.editData.getBOSType()));
		}
       String oldOprtState=this.oprtState;
//       this.kdtEntrys.removeRows();
//       //先保存
       this.actionSave_actionPerformed(e);
//       storeFields();
       
       super.actionExeSettle_actionPerformed(e);
       doAfterSave(new ObjectUuidPK(this.editData.getId()));
       this.setOprtState(oldOprtState);
       loadFields();
       
//       updateEggBatchNumber();
    
	   MsgBox.showInfo("结算完成");
    }

    /**
     * @author niuxinping 2017-08-03
     * 更新种蛋批次号
     */
    private void updateEggBatchNumber() {
		// TODO Auto-generated method stub
    	if(this.eggSource.getSelectedItem().equals(EggSourceType.Purchase)){
//    		for(int i =0 ;i<this.editData.getEntrys().size();i++){
//    			SupplierInfo info = (SupplierInfo)this.editData.getEntrys().get(i).get("supplier");
//    			EggSettleBillCompanyEntryInfo entryInfo =this.editData.getEntrys().get(i);
//    			entryInfo.setEggBatchNumber(info.getSimpleName());
//    			
//    		}
    		
    		for(int rowIndex=0; rowIndex<this.kdtEntrys.getRowCount();rowIndex++){
    			SupplierInfo info = (SupplierInfo)this.kdtEntrys.getCell(rowIndex, "supplier").getValue();
    			this.kdtEntrys.getCell(rowIndex, "eggBatchNumber").setValue(info.getSimpleName());
    		}
    		
    	}
    	
    	
    	
		
	}
	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
//        objectValue.setDestCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
        objectValue.setHatchBeginDate(new Date());
        objectValue.setHatchEndDate(new Date());
        objectValue.setEggSource(EggSourceType.PurchaseInstead);
        return objectValue;
    }
    
    @Override
	public void onLoad() throws Exception {
    	curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
//		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
//		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
	}
    
    
	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		this.pkhatchBeginDate.setRequired(true);
		this.pkhatchEndDate.setRequired(true);
		this.pkhatchBeginDate.setSupportedEmpty(false);
		this.pkhatchEndDate.setSupportedEmpty(false);
		
		this.pkhatchBeginDate.setDatePattern("yyyy-MM-dd");
		this.pkhatchEndDate.setDatePattern("yyyy-MM-dd");
		this.pkBizDate.setDatePattern("yyyy-MM-dd");
		
		StorageF7 sf7=new StorageF7();
		this.prmtstorageOrgUnit.setSelector(sf7);
		
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});
		
		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				bizDate_changed();
			}});
		
		this.kdtEntrys_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent arg0) throws Exception {
			}
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				e.getObjectValue().put("sendDate", pkBizDate.getTimestamp());
			}});
		
		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
			}});
	
		
		eggSource.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setColHide();	
				IRow row = com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil.getSelectedRow(kdtEntrys);
				if(row!=null) {
					setEntryFilter(row.getRowIndex(), kdtEntrys.getColumnIndex("farmer"));
				}
			}
		});
		
		KDBizPromptBox kdtEntrys_material_PromptBox1 = new KDBizPromptBox();
        kdtEntrys_material_PromptBox1.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEntrys_material_PromptBox1.setVisible(true);
        kdtEntrys_material_PromptBox1.setEditable(true);
        kdtEntrys_material_PromptBox1.setDisplayFormat("$name$");
        kdtEntrys_material_PromptBox1.setEditFormat("$name$");
        kdtEntrys_material_PromptBox1.setCommitFormat("$name$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor1 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox1);
        ObjectValueRender kdtEntrys_material_OVR1 = new ObjectValueRender();
        kdtEntrys_material_OVR1.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor1);  
        this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR1);
        
        this.txtpaymentAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				calActualAmount();
			}}
        );
        this.txtcompensateAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				calActualAmount();
			}}
        );
        this.txtotherAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				calActualAmount();
			}}
        );
        this.txtbyProductAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				calActualAmount();
			}}
        );
        
        this.kdtPriceEntry_detailPanel.addRemoveListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent paramDetailPanelEvent) throws Exception {
				calEntry(KDTableUtil.getSelectedRow(kdtEntrys));
			}

			public void beforeEvent(DetailPanelEvent paramDetailPanelEvent) throws Exception {
				
			}});
        this.kdtEntrys_detailPanel.addRemoveListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent paramDetailPanelEvent) throws Exception {
				calActualAmount();
			}

			public void beforeEvent(DetailPanelEvent paramDetailPanelEvent) throws Exception {
				
			}});
        
        final KDBizPromptBox kdtEggEntry_parentBatch_PromptBox = new KDBizPromptBox();
        kdtEggEntry_parentBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7ParentBreedBatchQuery");
        kdtEggEntry_parentBatch_PromptBox.setVisible(true);
        kdtEggEntry_parentBatch_PromptBox.setEditable(true);
        kdtEggEntry_parentBatch_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_parentBatch_PromptBox.setEditFormat("$number$");
        kdtEggEntry_parentBatch_PromptBox.setCommitFormat("$number$");
        kdtEggEntry_parentBatch_PromptBox.setEntityViewInfo(new EntityViewInfo());
        KDTDefaultCellEditor kdtEggEntry_parentBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_parentBatch_PromptBox);
        this.kdtEntrys.getColumn("internalBatch").setEditor(kdtEggEntry_parentBatch_CellEditor);
        ObjectValueRender kdtEggEntry_parentBatch_OVR = new ObjectValueRender();
        kdtEggEntry_parentBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("internalBatch").setRenderer(kdtEggEntry_parentBatch_OVR);
        
        //移除多余选项  去除自养和放养
        this.eggSource.removeItem(EggSourceType.SubContract);
        this.eggSource.removeItem(EggSourceType.InternalFarm);
        
        CompanyF7 cf71=new CompanyF7();
        this.prmtdestCompany.setSelector(cf71);
        
        kdtEntrys.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				setEntryFilter(e.getSelectBlock().getBeginRow(), e.getSelectBlock().getBeginCol());
			}});
        
        kdtPriceEntry_detailPanel.setVisible(false);
        
        prmtsupplier.setRequired(true);
        prmtdestCompany.setRequired(true);
	}
	
	/**
	 * 计算实际运费
	 */
	private void calActualAmount() {
		BigDecimal amount=BigDecimal.ZERO;//this.txtamount.getBigDecimalValue();
		BigDecimal paymentAmount=this.txtpaymentAmount.getBigDecimalValue();//提成
		BigDecimal compensateAmount=this.txtcompensateAmount.getBigDecimalValue();//补偿
		BigDecimal otherAmount=this.txtotherAmount.getBigDecimalValue();
		BigDecimal byProductAmount=this.txtbyProductAmount.getBigDecimalValue();
		
		if(amount==null) {
			amount=BigDecimal.ZERO;
		}
		if(paymentAmount==null) {
			paymentAmount=BigDecimal.ZERO;
		}
		if(compensateAmount==null) {
			compensateAmount=BigDecimal.ZERO;
		}
		if(otherAmount==null) {
			otherAmount=BigDecimal.ZERO;
		}
		if(byProductAmount==null) {
			byProductAmount=BigDecimal.ZERO;
		}
		
		for(int i=0;i<kdtEntrys.getRowCount();i++) {
			amount=amount.add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i, "amount").getValue()));
		}
		this.txtamount.setValue(amount);
		this.txtactualAmount.setValue(amount.subtract(paymentAmount).subtract(compensateAmount).subtract(otherAmount).subtract(byProductAmount));
	}
	
	@Override
	public void kdtPriceEntry_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtPriceEntry_Changed(rowIndex, colIndex);
		   if ("qty".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())||"price".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
			   kdtPriceEntry.getCell(rowIndex, "amount").setValue(UIRuleUtil.getBigDecimal(kdtPriceEntry.getCell(rowIndex, "price").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtPriceEntry.getCell(rowIndex, "qty").getValue()).setScale(2,BigDecimal.ROUND_HALF_UP)));
		   }
		if(kdtPriceEntry.getColumnKey(colIndex).equalsIgnoreCase("price")||kdtPriceEntry.getColumnKey(colIndex).equalsIgnoreCase("qty")||kdtPriceEntry.getColumnKey(colIndex).equalsIgnoreCase("amount")) {
			int pIndex = KDTableUtil.getSelectedRow(kdtEntrys);
			if(pIndex<0) {
				return;
			}
			calEntry(pIndex);
		}
	}
	
	private void calEntry(int pIndex) {
		BigDecimal sumAmount=BigDecimal.ZERO;
		for(int i=0;i<kdtPriceEntry.getRowCount();i++) {
			sumAmount=sumAmount.add(UIRuleUtil.getBigDecimal(kdtPriceEntry.getCell(i, "amount").getValue()));
		}
		kdtEntrys.getCell(pIndex, "amount").setValue(sumAmount);
		calActualAmount();
	}

	/**
	 * 计算分录金额
	 */
	private void calEntryAmount() {
		
	}
	
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		super.kdtEntrys_Changed(rowIndex, colIndex);
		
		

		//根据合同和批次带出养殖户和农场 ,
		if(kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")) {
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				kdtEntrys.getCell(rowIndex, "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farmer"));
				kdtEntrys.getCell(rowIndex, "farm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farm"));
				kdtEntrys.getCell(rowIndex, "farmerGroup").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"farmer").getValue(), "treeid"));
				
				kdtEntrys.getCell(rowIndex, "warehouse").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"farm").getValue(), "defaultEggFactory"));
				
				kdtEntrys.getCell(rowIndex, "eggBatchNumber").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "eggBatchNo"));//根据养殖户带出种蛋批次号

			}
		}
		//根据供应商 带出种蛋批次号 =供应商简称
		if(kdtEntrys.getColumn(colIndex).getKey().equals("supplier")){
			if(kdtEntrys.getCell(rowIndex, "supplier").getValue()!=null) {
				
				kdtEntrys.getCell(rowIndex, "eggBatchNumber").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"supplier").getValue(), "SimpleName"));//根据养殖户带出种蛋批次号

			}
		}
		
		//根据养殖户带出养殖场
		if(kdtEntrys.getColumnKey(colIndex).equals("farmer")) {
			String farmerID=null;
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null) {
				farmerID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, colIndex).getValue()).getString("id");
			}
			kdtEntrys.getCell(rowIndex, "farm").setValue(StockingComm.getFarmInfoByFarmerID(null,farmerID));
			if(StringUtils.isEmpty(farmerID)) {
				kdtEntrys.getCell(rowIndex, "house").setValue(null);
			}
			if(farmerID!=null&&kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				if(!((IPropertyContainer) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farmer")).getString("id").equals(farmerID)) {
					 kdtEntrys.getCell(rowIndex,"stockingBatch").setValue(null);
				}
			}
		}
		
		//根据养殖厂带出默认
		calEntryWeekAndDayAge(rowIndex, colIndex);
		if(kdtEntrys.getColumnKey(colIndex).equals("amount")) {
			calActualAmount();
		}
		
	}
	/**
	 * 设置列的隐藏
	 */
	private void setColHide() {
		this.conthatchBeginDate.setVisible(false);
		this.conthatchEndDate.setVisible(false);
		
		if(eggSource.getSelectedIndex()<0) {
			return;
		}
		this.contdestCompany.setVisible(false);
		this.contsupplier.setVisible(false);
		
		if(eggSource.getSelectedItem().equals(EggSourceType.Purchase)||eggSource.getSelectedItem().equals(EggSourceType.PurchaseInstead)) {
			kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalBatch").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalHouse").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("farm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("house").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(true);
			this.contsupplier.setVisible(true);
			
			this.conthatchBeginDate.setVisible(true);
			this.conthatchEndDate.setVisible(true);
		}else if(eggSource.getSelectedItem().equals(EggSourceType.InternalPurchase)) {
			kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalBatch").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalHouse").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("farm").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("house").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(false);
			
			this.contdestCompany.setVisible(true);
			
			this.conthatchBeginDate.setVisible(true);
			this.conthatchEndDate.setVisible(true);
		}	else {
			this.conthatchBeginDate.setVisible(false);
			this.conthatchEndDate.setVisible(false);
		}
	}
	
	
	/**
	 * 设置分录过滤条件
	 * @param e
	 */
	private void setEntryFilter(int rowIndex,int colIndex) {
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtEntrys.getColumnKey(colIndex);
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")||key.equals("house")) {
//			rowIndex=rowIndex
			KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id");
			}
			
			StockingFarmTypeEnum farmType=null;//养殖场类型
			String curCompanyID = "";
			if(prmtcompany.getValue()!=null) {
				curCompanyID=((CompanyOrgUnitInfo)prmtcompany.getValue()).getString("id");
			}
			//集团内采购-只查询其他公司
			boolean isOtherCompany=false;
			if(eggSource.getSelectedItem()!=null&&eggSource.getSelectedItem().equals(EggSourceType.InternalPurchase)) {
				isOtherCompany=true;
			}
			//内部放养
			else if(eggSource.getSelectedItem()!=null&&eggSource.getSelectedItem().equals(EggSourceType.SubContract)) {
				farmType=StockingFarmTypeEnum.stocking;
			}
			
			//养殖户过滤
			StockingClientComm.setFarmerFilter(prmtFarmer, curCompanyID,false,isOtherCompany,farmType);
			//养殖场过滤
			StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID,false,isOtherCompany,farmType);
			//批次过滤
			StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID,houseID,false,isOtherCompany,farmType);
			//棚舍过滤
			HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,false);
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		}
	}
	
	private void bizDate_changed() {
		int colIndex=kdtEntrys.getColumnIndex("stockingBatch");
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			try {
				calEntryWeekAndDayAge(rowIndex, colIndex);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	/**
	 * 计算周龄、日龄
	 * @param rowIndex
	 * @throws BOSException 
	 * @throws DataAccessException 
	 * @throws EASBizException 
	 */
	private void calEntryWeekAndDayAge(int rowIndex,int colIndex) throws DataAccessException, BOSException, EASBizException {
		//计算周龄、日龄
		if(kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("stockingBatch")||kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("sendDate")) {
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null&&kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
				Date nowDate=null,inDate=null;
				if(kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {//禽舍不为空
					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add("*");
					slor.add("HouseEntry.*");
					StockingBatchInfo batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id")),slor);

					for(int index=0;index<batchInfo.getHouseEntry().size();index++) {
						if(batchInfo.getHouseEntry().get(index).getHouse().getString("id").equals(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id"))) {
							inDate=batchInfo.getHouseEntry().get(index).getInData();
							break;
						}
					}
					//申请周龄
					if(kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
						nowDate=(Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "weekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(0);
					}
					//当前周龄
					/*if(pkBizDate.getValue()!=null) {
						nowDate=pkBizDate.getTimestamp();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "weekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(0);
					}*/
				}else{
					inDate=(Date) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "inDate");
					//当前周龄
					if(pkBizDate.getValue()!=null) {
						nowDate=pkBizDate.getTimestamp();
					}
					/*if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "weekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(0);
					}*/
					//申请周龄
					if(kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
						nowDate=(Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "weekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(0);
					}
				}
			}
		}
	}
	
	
	/**
	 * 开始编辑
	 * @param e
	 */
	private void kdteditStarted(KDTEditEvent e) {
		int rowIndex=e.getRowIndex();
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtEntrys.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")||key.equals("house")) {
			/*KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id");
			}
		
			String tempCompanyID=curCompanyID;
			//养殖场过滤
			if(this.eggSource.getSelectedItem().equals(EggSourceType.InternalPurchase)) {
				curCompanyID=null;
			}	
			StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID,houseID);
			StockingClientComm.setFarmerFilter(prmtFarmer, curCompanyID);
			StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
			//棚舍过滤
			HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,true);
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
			curCompanyID=tempCompanyID;*/
		}
		if(key.equals("internalBatch")) {
			String farmID=null;
			if(this.kdtEntrys.getCell(rowIndex, "internalFarm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "internalFarm").getValue()).getString("id");
			}
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtEntrys.getColumn("internalBatch").getEditor().getComponent()).setEntityViewInfo(ev);
		}
		if(key.equals("internalHouse")) {
			String farmID=null;
			if(this.kdtEntrys.getCell(rowIndex, "internalFarm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "internalFarm").getValue()).getString("id");
			}
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtEntrys.getColumn("internalHouse").getEditor().getComponent()).setEntityViewInfo(ev);
		}
	}
	
	/**
	 * 设置过滤条件
	 */
	private void setFilter() {
    	if(this.prmtcompany.getValue()!=null) {
    		curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
    	}else{
    		curCompanyID=null;
    	}
	}	
	
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		if(eggSource.getSelectedItem().equals(EggSourceType.InternalPurchase)) {
			if(prmtdestCompany.getValue()==null) {
				MsgBox.showWarning("结算公司不能为空！");
				SysUtil.abort();
			}
		}
		if(eggSource.getSelectedItem().equals(EggSourceType.Purchase)||eggSource.getSelectedItem().equals(EggSourceType.PurchaseInstead)) {
			if(prmtsupplier.getValue()==null) {
				MsgBox.showWarning("供应商不能为空！");
				SysUtil.abort();
			}
		}
	}
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
		vo.setInt("eggSource", EggSourceType.PURCHASEINSTEAD_VALUE);
	}
	
	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
//		super.actionPrint_actionPerformed(e);
		ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        MyDataProvider data=new MyDataProvider((String) idList.get(0));
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
	}

	@Override
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception {
//		super.actionPrintPreview_actionPerformed(e);
		ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        MyDataProvider data=new MyDataProvider((String) idList.get(0));
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
	}

	public class MyDataProvider extends AbstractPrintDataProvider 
	{
		private String id;
		public MyDataProvider(String id) {
			this.id=id;
		}
		public IRowSet getData(R1PrintDataSource dataSource) throws Exception
		{
			IRowSet rowset=null;
			if("EggSettleBillCompanyPrintQuery".equals(dataSource.getId())) 
			{
				//可能会以选中数据的ID做过滤条件查数据
				//构造RowSet
				StringBuffer sql=new StringBuffer();//sum(SALEFEE) SALEFEE,sum(HATCHFEECOST) HATCHFEECOST
				sql.append(" select case when torg.fid is null then ts.fname_l2 else torg.fname_l2 end as \"orgOrSupplier.name\",")
				.append(" \"EGGSETTLEBILL\".cFEggSource AS \"EGGSOURCE\", ")
				.append(" \"EGGSETTLEBILL\".CFHatchBeginDate AS \"HATCHBEGINDATE\", ")
				.append(" \"EGGSETTLEBILL\".CFHatchEndDate AS \"HATCHENDDATE\", ")
				.append(" \"EGGSETTLEBILL\".FNumber AS \"NUMBER\", ")
				.append(" \"EGGSETTLEBILL\".FBizDate AS \"BIZDATE\", ")
				.append(" \"torg\".FName_l2 AS \"STORAGEORGUNIT.NAME\", ")
				.append(" \"EGGSETTLEBILL\".FID AS \"ID\", ")
//				"CREATOR".FName_l2 AS "CREATOR.NAME", 
				.append(" \"CREATOR\".FName_l2 AS \"CREATOR\",")
				.append(" \"AUDITOR\".FName_l2 AS \"AUDITOR\", ")
				
				.append("  sum(ttemp.AMOUNT) AMOUNT,sum(ttemp.ACTUALAMOUNT) ACTUALAMOUNT,sum(ttemp.OTHERAMOUNT) OTHERAMOUNT,sum(ttemp.BYPRODUCTAMOUNT) BYPRODUCTAMOUNT,")
				.append(" sum(ttemp.COMPENSATEAMOUNT) COMPENSATEAMOUNT,sum(ttemp.PAYMENTAMOUNT) PAYMENTAMOUNT,sum(ttemp.SALEFEE) SALEFEE,sum(ttemp.HATCHQTY) HATCHQTY,sum(ttemp.HATCHFEECOST) HATCHFEECOST")
				.append(" from (")
				.append(" select ")
				.append(" \"EGGSETTLEBILL\".CFAmount AS \"AMOUNT\", ")
				.append(" \"EGGSETTLEBILL\".CFActualAmount AS \"ACTUALAMOUNT\", ")
				.append(" \"EGGSETTLEBILL\".CFOtherAmount AS \"OTHERAMOUNT\", ")
				.append(" \"EGGSETTLEBILL\".CFByProductAmount AS \"BYPRODUCTAMOUNT\", ")
				.append(" \"EGGSETTLEBILL\".CFCompensateAmount AS \"COMPENSATEAMOUNT\", ")
				.append(" \"EGGSETTLEBILL\".CFPaymentAmount AS \"PAYMENTAMOUNT\",")
				.append(" 0 SALEFEE,")
				.append(" 0 HATCHFEECOST,")
				.append(" 0 HATCHQTY, ")
				.append(" \"EGGSETTLEBILL\".FID AS \"ID\" ")
				.append(" from CT_FM_EggSettleBillCompany as \"EGGSETTLEBILL\"")
				.append(" where EGGSETTLEBILL.fid='").append(id).append("'")
				.append(" union all")
				.append(" SELECT ")
				.append(" 0,0,0,0,0,0,")
				.append(" isnull((-1)* tdetail.Famount,0) SALEFEE, ")
				.append(" 0 HATCHFEECOST,")
				.append(" 0 HATCHQTY, ")
				.append(" tmain.FID ID")
				.append(" FROM CT_FM_EggSBCE  tentry")
				.append(" inner join CT_FM_EggSBCEPE tdetail on tdetail.fparentid=tentry.fid")
				.append(" inner join T_FM_SettlementItem titem on titem.fid=tentry.FSettleItemID")
				.append(" INNER JOIN CT_FM_EggSettleBillCompany  tmain ON tentry.FParentID = tmain.FID ")
				.append(" where tmain.fid='").append(id).append("'")
				.append(" and tdetail.FMaterialID is null")
//				.append(" and ( tdetail.FRemark like '%销售费用%' or FRemark like '%苗差价%')")
				.append(" and ( tdetail.FRemark like '%销售费用%')")

				.append(" union all")
				.append(" SELECT ")
				.append(" 0,0,0,0,0,0,")
				.append(" 0 SALEFEE, ")
				.append(" isnull((-1)*tdetail.Famount,0) HATCHFEECOST, ")
				.append(" isnull(tdetail.fqty,0) HATCHQTY, ")
				.append(" tmain.FID ID")
				.append(" ")
				.append(" FROM CT_FM_EggSBCE  tentry")
				.append(" inner join CT_FM_EggSBCEPE tdetail on tdetail.fparentid=tentry.fid")
				.append(" inner join T_FM_SettlementItem titem on titem.fid=tentry.FSettleItemID")
				.append(" INNER JOIN CT_FM_EggSettleBillCompany  tmain ON tentry.FParentID = tmain.FID ")
				.append(" where tmain.fid='").append(id).append("'")
				.append(" and tdetail.FMaterialID is null")
				.append(" and tdetail.FRemark like '%代孵费%'")
				.append(" ) ttemp ")
				.append(" inner join  CT_FM_EggSettleBillCompany as \"EGGSETTLEBILL\" on EGGSETTLEBILL.fid=ttemp.id")
				

				.append(" LEFT OUTER JOIN T_PM_User AS \"AUDITOR\" ON \"EGGSETTLEBILL\".FAuditorID = \"AUDITOR\".FID")
				.append(" LEFT OUTER JOIN T_PM_User AS \"CREATOR\" ON \"EGGSETTLEBILL\".FCreatorID = \"CREATOR\".FID")
				
				.append(" left join t_org_company torg on torg.fid=EGGSETTLEBILL.CFDestCompanyID")
				.append(" left join t_bd_supplier ts on ts.fid=EGGSETTLEBILL.CFSupplierID")
				.append(" group by \"EGGSETTLEBILL\".cFEggSource,")
				.append(" \"EGGSETTLEBILL\".CFHatchBeginDate,")
				.append(" \"EGGSETTLEBILL\".CFHatchEndDate ,")
				.append(" \"EGGSETTLEBILL\".FNumber ,")
				.append(" \"EGGSETTLEBILL\".FBizDate ,")
				.append(" \"torg\".FName_l2 ,")
				.append(" \"EGGSETTLEBILL\".FID , ")
				.append(" torg.fid,torg.fname_l2,ts.fname_l2,\"CREATOR\".FName_l2,\"AUDITOR\".FName_l2")
				;
				
				rowset=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
	 			return rowset;
			}
			else if("EggSettleBillCompanyEntryPrintQuery".equals(dataSource.getId()))
			{
				StringBuffer sql=new StringBuffer();
				sql.append(" SELECT \"PARENT.ID\",SETTLEITENum,SETTLEITEMNAME,sum(QTY) QTY,sum(QTYWITHLOSS) QTYWITHLOSS,sum(LOSSQTY) LOSSQTY,sum(AMOUNT) AMOUNT,")
				.append(" case when sum(Qty) =0 then 0 else round(sum(AMOUNT)/sum(QTY),6) end PRICE")
				.append(" from (")
				.append(" select ")
				.append(" tm.fnumber SETTLEITENum,tm.fname_l2 SETTLEITEMNAME, ")
				.append(" tdetail.FQty QTY, ")
				.append(" isnull(tdetail.CFLossQty,0)+isnull(tdetail.Fqty,0) QTYWITHLOSS, ")
				.append(" tdetail.CFLossQty LOSSQTY, ")
				.append(" 0 PRICE, ")
				.append(" tdetail.FAmount AMOUNT, ")
				.append(" 0 SALEFEE, ")
				.append(" 0 HATCHFEECOST, ")
				.append(" tmain.FID as \"PARENT.ID\"")
				.append(" ")
				.append(" FROM CT_FM_EggSBCE  tentry")
				.append(" inner join CT_FM_EggSBCEPE tdetail on tdetail.fparentid=tentry.fid")
				.append(" inner join t_bd_material tm on tm.fid=tdetail.FMaterialID")
				.append(" inner join T_FM_SettlementItem titem on titem.fid=tentry.FSettleItemID")
				.append(" INNER JOIN CT_FM_EggSettleBillCompany  tmain ON tentry.FParentID = tmain.FID ")
				.append(" where tmain.fid='").append(id).append("'")
				.append(" and tdetail.FMaterialID is not null")
				.append(" ) ttemp")
				.append(" group by \"PARENT.ID\",SETTLEITENum,SETTLEITEMNAME")
				.append(" order by SETTLEITENum")
				;
				rowset=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
	 			return rowset;
			} 
			else if("EggSettleBillCompanyDetailQuery".equals(dataSource.getId()))
			{
				StringBuffer sql=new StringBuffer();
				rowset=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
	 			return rowset;
			} 
			return null;
		}
	}
	  /**
     * 刷新页面
     * @throws EASBizException
     * @throws BOSException
     * @throws Exception
     */
    protected void refreshCurPage() throws EASBizException, BOSException,
	Exception {
    if (editData.getId() != null) {
	BOSUuid pk = editData.getId();
    	super.doAfterSave(new ObjectUuidPK(editData.getId()));
    	editData.setId(pk);
}
}
}