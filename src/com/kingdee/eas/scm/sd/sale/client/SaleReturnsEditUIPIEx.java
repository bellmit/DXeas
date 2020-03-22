package com.kingdee.eas.scm.sd.sale.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.DiscountCompanyInfo;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.custom.salediscount.DiscountGridLogEntryCollection;
import com.kingdee.eas.custom.salediscount.DiscountGridLogEntryInfo;
import com.kingdee.eas.custom.salediscount.DiscountGridLogFactory;
import com.kingdee.eas.custom.salediscount.DiscountGridLogInfo;
import com.kingdee.eas.framework.batchaction.BatchActionEnum;
import com.kingdee.eas.framework.batchaction.BatchSelectionEntries;
import com.kingdee.eas.scm.sd.sale.SaleReturnsEntryCollection;
import com.kingdee.eas.scm.sd.sale.SaleReturnsEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleReturnsInfo;

public class SaleReturnsEditUIPIEx extends SaleReturnsEditUI {

	private static final long serialVersionUID = 2669558462342588258L;

	public SaleReturnsEditUIPIEx() throws Exception {
		super();
		this.setCuid(SysContext.getSysContext().getCurrentStorageUnit().getId().toString());
	}
	/**
	 * 开发分录编辑接口给dep调用
	 */
	public void kdtEntrys_editStopped(KDTEditEvent e)
		throws Exception
	  {
			super.kdtEntrys_editStopped(e);
	  }
	
//	
//	public void actionAudit_actionPerformed(ActionEvent arg0) throws Exception {
//		// TODO Auto-generated method stub
//		this.calLz();
//		super.actionAudit_actionPerformed(arg0);
//	}
//
//	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
//		// TODO Auto-generated method stub
//		this.calLz();
//		super.actionSubmit_actionPerformed(e);
//	}
//
//	
//	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
//		// TODO Auto-generated method stub
//		//this.calLz();
//		super.actionSave_actionPerformed(e);
//	}

//	/**************************************新折让添加逻辑  wgj 20150804 begin*************************************************/
	String cuid="";
	LinkedHashSet materialsID;
	boolean isXszr=false;
	boolean isYhl=false;
	
	PeriodInfo currPeriod;
	PeriodInfo currDisPeriod;
	String currPeriodId;
	String currDisPeriodId;
	String customerId="";
	String customerBId="";

	
	
	// 折让公司
	private DiscountCompanyInfo discountCompanyInfo;
	
	// 折让计算记录 
	private List discountLogs;
	// 是否启用新希望折让处理
	private boolean isEnableXXWDiscount;
	// private boolean  是否校验客户余额    余额=应收余额+已开票未收款余额
	private boolean isCheckCustomerBalance;
	// 是否校验物料库存   
	private boolean isCheckMaterialInventory;
	// 有效的订单分录ID   格式为 'akldshfakjdshf','adkjfhajdskhfk','asdjfhjdsajkf'
	private String valieOrderEntryIDs;
	// 订单物料数量暂存，在订单提交校验库存时 用来 暂存物料数量，对于分录中包含多行相同物料，累加数量后校验库存
	private Map<String,BigDecimal> entryMaterialQtys;
	
	public void afterAction(BatchActionEnum bizAction,
			BatchSelectionEntries arg1, int arg2) {
		super.afterAction(bizAction, arg1, arg2);
		if(bizAction.equals(BatchActionEnum.SAVE)){
			try {
				// 保存 折让数据
				if(isEnableXXWDiscount()){
					saveDiscountGridLogInfos(this.editData,this.getDiscountLogs());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(bizAction.equals(BatchActionEnum.SUBMIT)){
			try {
				// 保存折让数据
				// 保存 折让数据
				if(isEnableXXWDiscount()){
					saveDiscountGridLogInfos(this.editData,this.getDiscountLogs());
				}
//					if(this.isXszr==true){
//	        			useAmount();
//	        		}
//					if(this.isCustom003==true){
//						this.updateContractSlQty();
//					}
				// 编辑状态 删除bizdate 事件监听
				//removeAllBizDateListener();
				
				
				refreshCurPage();
	            setSave(true);
	            setSaved(true);
				//setOprtState(OprtState.VIEW);
				btnPre.setEnabled(true);
				btnFirst.setEnabled(true);
				//addSaleReturnsChange();
               //addSaleOderListener2();
               //loadSendAddress();
               //setSave(true);
               //setSaved(true);
              // showMessageForStatus();
               //showSaveSuccess();
               //uiHelper.initInLoadFields(prepareVoForLoadData());
               //nodeList.distributeInitialize();
               //btnAudit.setVisible(false);
				
			} catch (EASBizException e) {
				
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//super.afterAction(bizAction, arg1, arg2);
	}
	
	
	/**
	 * 保存折让日志 
	 * @param editData
	 * @param discountLogs2
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	 private void saveDiscountGridLogInfos(SaleReturnsInfo editData,
			List discountLogs) throws EASBizException, BOSException {
		// 设置日志相关信息，然后保存
		if(discountLogs != null && discountLogs.size() >0 && editData != null && editData.getEntries() != null && editData.size() > 0){
			SaleReturnsEntryCollection orderEntrys = editData.getEntries();
			// 生成日志单据
			DiscountGridLogInfo logInfo  = new DiscountGridLogInfo();
			logInfo.setOrderNumber(editData.getNumber());
			logInfo.setSaleReturns(editData);
			logInfo.setIsSaleReturns(true);
			if(editData.getObjectValue("customerb") != null){
				CustomerInfo parentCustomer = (CustomerInfo) editData.getObjectValue("customerb");
				logInfo.setParentCustomerID(parentCustomer.getId().toString());
			}
			if(editData.getOrderCustomer() != null){
				logInfo.setCustomerID(editData.getOrderCustomer().getId().toString());
			}
			DiscountGridLogEntryCollection logEntrys = logInfo.getEntrys();
			if(logEntrys == null){
				logEntrys = new DiscountGridLogEntryCollection();
			}
			
			// 将 订单分录id设置到log中  然后保存 logentry
			for(int i = 0; i < discountLogs.size(); i++){
				DiscountGridLogEntryInfo logEntryInfo = (DiscountGridLogEntryInfo) discountLogs.get(i);
				logEntryInfo.setOrderID(editData.getId().toString());
				int seq = logEntryInfo.getOrderEntrySeq();
				for(int j = 0; j < orderEntrys.size(); j++){
					SaleReturnsEntryInfo orderEntryInfo = orderEntrys.get(j);
					if(orderEntryInfo != null && orderEntryInfo.getId() != null){
						if(seq == orderEntryInfo.getSeq()){
							logEntryInfo.setOrderEntryID(orderEntryInfo.getId().toString());
							break;
						}
					}
				}
				
				logEntrys.add(logEntryInfo);
			}
			DiscountFacadeFactory.getRemoteInstance().removeOrderDsgridLogs(editData.getId().toString());
			// 保存日志信息
			DiscountGridLogFactory.getRemoteInstance().save(logInfo);
		}
		
	}
	 


	public String getCuid() {
		return cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}

	public LinkedHashSet getMaterialsID() {
		return materialsID;
	}

	public void setMaterialsID(LinkedHashSet materialsID) {
		this.materialsID = materialsID;
	}

	public boolean isXszr() {
		return isXszr;
	}

	public void setXszr(boolean isXszr) {
		this.isXszr = isXszr;
	}

	public boolean isYhl() {
		return isYhl;
	}

	public void setYhl(boolean isYhl) {
		this.isYhl = isYhl;
	}

	public PeriodInfo getCurrPeriod() {
		return currPeriod;
	}

	public void setCurrPeriod(PeriodInfo currPeriod) {
		this.currPeriod = currPeriod;
	}

	public PeriodInfo getCurrDisPeriod() {
		return currDisPeriod;
	}

	public void setCurrDisPeriod(PeriodInfo currDisPeriod) {
		this.currDisPeriod = currDisPeriod;
	}

	public String getCurrPeriodId() {
		return currPeriodId;
	}

	public void setCurrPeriodId(String currPeriodId) {
		this.currPeriodId = currPeriodId;
	}

	public String getCurrDisPeriodId() {
		return currDisPeriodId;
	}

	public void setCurrDisPeriodId(String currDisPeriodId) {
		this.currDisPeriodId = currDisPeriodId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerBId() {
		return customerBId;
	}

	public void setCustomerBId(String customerBId) {
		this.customerBId = customerBId;
	}

	public DiscountCompanyInfo getDiscountCompanyInfo() {
		return discountCompanyInfo;
	}

	public void setDiscountCompanyInfo(DiscountCompanyInfo discountCompanyInfo) {
		this.discountCompanyInfo = discountCompanyInfo;
	}

	public List getDiscountLogs() {
		return discountLogs;
	}

	public void setDiscountLogs(List discountLogs) {
		this.discountLogs = discountLogs;
	}

	public boolean isEnableXXWDiscount() {
		return isEnableXXWDiscount;
	}

	public void setEnableXXWDiscount(boolean isEnableXXWDiscount) {
		this.isEnableXXWDiscount = isEnableXXWDiscount;
	}

	public boolean isCheckCustomerBalance() {
		return isCheckCustomerBalance;
	}

	public void setCheckCustomerBalance(boolean isCheckCustomerBalance) {
		this.isCheckCustomerBalance = isCheckCustomerBalance;
	}

	public boolean isCheckMaterialInventory() {
		return isCheckMaterialInventory;
	}

	public void setCheckMaterialInventory(boolean isCheckMaterialInventory) {
		this.isCheckMaterialInventory = isCheckMaterialInventory;
	}

	public String getValieOrderEntryIDs() {
		return valieOrderEntryIDs;
	}

	public void setValieOrderEntryIDs(String valieOrderEntryIDs) {
		this.valieOrderEntryIDs = valieOrderEntryIDs;
	}

	public Map<String, BigDecimal> getEntryMaterialQtys() {
		return entryMaterialQtys;
	}

	public void setEntryMaterialQtys(Map<String, BigDecimal> entryMaterialQtys) {
		this.entryMaterialQtys = entryMaterialQtys;
	}
	
	/**************************************新折让添加逻辑  wgj 20150804 end***************************************************/
	
	@Override
	protected String[] getSumColNames() {
		// TODO Auto-generated method stub
		String[] stdCols = super.getSumColNames();
	    String[] depCols=new String[]{"lz","NoDSQty","NoDSAmount","LzAmount","SwDSQty","MonthDSAmount","YearDSAmount","FxDSAmount","SwDSamount","BaseAmount","NetSaleAmount"};
	    ArrayList<String> colList=new ArrayList<String>();
	    for(int i=0;i<stdCols.length;i++) {
	    	colList.add(stdCols[i]);
	    }
	    for(int i=0;i<depCols.length;i++) {
	    	colList.add(depCols[i]);
	    }
	    String[] cols=new String[colList.size()];
	    for(int i=0;i<colList.size();i++) {
	    	cols[i]=colList.get(i);
	    }
		return cols;
	}
}
