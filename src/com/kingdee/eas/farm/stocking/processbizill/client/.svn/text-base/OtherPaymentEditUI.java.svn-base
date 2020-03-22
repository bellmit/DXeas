/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.FarmROrPTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
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
public class OtherPaymentEditUI extends AbstractOtherPaymentEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(OtherPaymentEditUI.class);
    private String curStorageOrgUnitID;//当前库存组织
    private String curCompanyID;//当前财务组织
    private F7ContextManager f7Manager;
    private OrgUnitInfo orgInfo = null;//库存组织
    private boolean isLoadField=false;
    
    /**
     * output class constructor
     */
    public OtherPaymentEditUI() throws Exception
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
       bizType_changed();
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
        return com.kingdee.eas.farm.stocking.processbizill.OtherPaymentFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.processbizill.OtherPaymentInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.OtherPaymentInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBizDate(new Date());
        return objectValue;
    }
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
    	curStorageOrgUnitID=StockingClientComm.checkAndGetStorageOrgUnitID();
    	curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
    	super.onLoad();
		initControl();
	}
    
	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.btnCalFemal.setIcon(EASResource.getIcon("imgTbtn_cal"));
		
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		
		setFilter();
		
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});
		
		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
				if(!isLoadField) {
					StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
				}
			}});
		
		this.prmtstockingBatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});
		this.bizType.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				bizType_changed();
			}});
		
		this.prmtreviceType.setRequired(true);
		this.prmtpaymentType.setRequired(true);
	}
	
	private void bizType_changed() {
		 if(bizType.getSelectedItem()!=null){
	        	if(bizType.getSelectedItem().equals(FarmROrPTypeEnum.receive)) {
	        		this.contreviceType.setVisible(true);
	            	this.contpaymentType.setVisible(false);
	        	}else{
	        		this.contreviceType.setVisible(false);
	            	this.contpaymentType.setVisible(true);
	        	}
	        }else{
	        	this.contreviceType.setVisible(false);
	        	this.contpaymentType.setVisible(true);
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
		String batchID=null;
		if(e.getNewValue()!=null) {
			batchID=((PropertyContainer) e.getNewValue()).getString("id");
		}
		try {
			if(StringUtils.isNotEmpty(batchID)){
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("farmer.*"));
				slor.add(new SelectorItemInfo("farm.*"));
				StockingBatchInfo bInfo=StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchID),slor);
				prmtfarmer.setValue(bInfo.getFarmer());
			}
		}catch(Exception err) {
			err.printStackTrace();
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
//		StockingClientComm.makeApplierF7(this.prmtperson, companyID, this, false);
		//批次过滤
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
	/**
	 * 计算母鸭代付生活费
	 */
	public void actionCalFemalAmount_actionPerformed(ActionEvent e) throws Exception {
		if(this.bizType.getSelectedItem()==null) {
			MsgBox.showWarning("业务类型不能为空！");
			return;
		}
		if(this.prmtcompany.getValue()==null) {
			MsgBox.showWarning("财务组织不能为空！");
			return;
		}
		if(this.prmtstockingBatch.getValue()==null) {
			MsgBox.showWarning("批次不能为空！");
			return;
		}
		if(bizType.getSelectedItem().equals(FarmROrPTypeEnum.payForOther)) {//代付款类型
			Calendar cal=Calendar.getInstance();
			cal.setTime(this.pkBizDate.getTimestamp());
			cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			Date endDate = cal.getTime();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			//每只数量
			String contractID = StockingComm.getContractIDByBatchID(null, ((IPropertyContainer) this.prmtstockingBatch.getValue()).getString("id"));
			if(StringUtils.isEmpty(contractID)) {
				MsgBox.showWarning("批次对应合同为空！");
				return;
			}
			SelectorItemCollection solr=new SelectorItemCollection();
			solr.add(new SelectorItemInfo("settlementPolicy.*"));
			BatchContractInfo cInfo;
			try {
				cInfo = BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(contractID),solr);
			}catch(Exception e1) {
				MsgBox.showWarning("批次对应合同为空！");
				return;
			}
			
			//母鸭初始数量
			BigDecimal femaleQty= ((StockingBatchInfo)this.prmtstockingBatch.getValue()).getFemaleQty();
			
			//全部死淘
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(FFemaleCullQty,0)+isnull(FFemaleDeathQty,0) FFemaleDeadQty")
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBDAE tentry on tentry.FparentID=tbill.fid")
			.append(" where tbill.FCompanyID='").append(this.curCompanyID).append("'")
			.append(" and tbill.CFStockingBatchID='").append(((IPropertyContainer) this.prmtstockingBatch.getValue()).getString("id")).append("'")
			.append(" and tbill.CFBaseStatus=4")
			.append(" and tbill.FbizDate<({ts '").append(sdf.format(endDate)).append(" 00:00:00'})");
			 IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			 BigDecimal femaleDeadQty=BigDecimal.ZERO;
			if(rs.next()) {
				femaleDeadQty=rs.getBigDecimal("FFemaleDeadQty");
			}
			
			femaleQty=femaleQty.subtract(femaleDeadQty);//母鸭存栏数量
			BigDecimal price=cInfo.getSettlementPolicy().getAvgFemaleFee();
			if(price==null) {
				price=BigDecimal.ZERO;
			}
			
			IRow row=this.kdtEntrys.addRow();
			row.getCell("amount").setValue(price.multiply(femaleQty).setScale(2,BigDecimal.ROUND_HALF_UP));
			row.getCell("reason").setValue("母鸭代付生活费");
			row.getCell("occurDate").setValue(this.pkBizDate.getValue());
		}else{
			MsgBox.showWarning("该业务类型不能进行计算！");
		}
	}
	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		 if(bizType.getSelectedItem()!=null){
	        	if(bizType.getSelectedItem().equals(FarmROrPTypeEnum.receive)) {
	        		if(prmtreviceType.getValue()==null) {
	        			MsgBox.showWarning("收款类型不能为空！");
	        		}
	        	}else{
	        		if(prmtpaymentType.getValue()==null) {
	        			MsgBox.showWarning("付款类型不能为空！");
	        		}
	        	}
        }
	}
	
	
	
}