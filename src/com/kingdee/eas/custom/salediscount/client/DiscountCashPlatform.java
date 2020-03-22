/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.client.F7CustomerTreeDetailListUI;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.DiscountCashDetail;
import com.kingdee.eas.custom.salediscount.DiscountCashInfo;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo;
import com.kingdee.eas.custom.salediscount.DiscountTypeEnum;
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.constants.QueryInfoConstants;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DiscountCashPlatform extends AbstractDiscountCashPlatform
{
    private static final Logger logger = CoreUIObject.getLogger(DiscountCashPlatform.class);
    
    private List<String> discountTypes;
    private Date beginDate;
    private Date endDate;
    private List<CustomerInfo> customers;
    
    public List<String> getDiscountTypes() {
		return discountTypes;
	}

	public void setDiscountTypes(List<String> discountTypes) {
		this.discountTypes = discountTypes;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void setCustomers(List<CustomerInfo> customers) {
		this.customers = customers;
	}

	public List<CustomerInfo> getCustomers() {
		return customers;
	}
	
	/**
     * output class constructor
     */
    public DiscountCashPlatform() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUI();
	}

    /**
     * 初始化界面内容
     * @throws Exception 
     */
    private void initUI() throws Exception{
    	Map context = this.getUIContext();
    	// 实物、立折不可操作
    	cbLz.setEditable(false);
    	cbLz.setEnabled(false);
    	cbSw.setEditable(false);
    	cbSw.setEnabled(false);
    	cbFx.setEditable(false);
    	cbFx.setEnabled(false);
//    	cbFx.set(false);
    	
    	CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		// 添加财务组织条件
		filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
		evi.setFilter(filterInfo);
    	// 设置F7查询元数据
		String queryInfo = QueryInfoConstants.CUSTOMER_COMPANY_STANDARD;
//		prmtSelectCustomers.setQueryInfo(queryInfo);
		// 设置主业务组织
		prmtSelectCustomers.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// 设置客户F7的过滤条件
		prmtSelectCustomers.setEntityViewInfo(evi);
		prmtSelectCustomers.setCommitFormat("$number$");//提交格式
		prmtSelectCustomers.setDisplayFormat("$number$");//显示格式
		prmtSelectCustomers.setEditFormat("$number$");//编辑格式
		prmtSelectCustomers.setEnabledMultiSelection(true);
		// 设置客户F7展现形式为左树右表
		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtSelectCustomers,
				F7CustomerTreeDetailListUI.class.getName(), 
				this,
				CSSPGroupInfo.getBosType(),
				queryInfo, 
				"browseGroup.id", 
				"companyOrgUnit.id");
		selectorAdaptor.setIsMultiSelect(true);
		prmtSelectCustomers.setSelector(selectorAdaptor);
		prmtSelectCustomers.addSelectorListener(selectorAdaptor);
		
	    // 选择列
	    this.kdtCustomer.checkParsed();
	    this.kdtData.checkParsed();
	    
		KDCheckBox cb = new KDCheckBox();
		cb.setSelected(false);
		this.kdtCustomer.getColumn("selected").setEditor(
				new KDTDefaultCellEditor(cb));
		
		this.kdtData.getColumn("selected").setEditor(
				new KDTDefaultCellEditor(cb));
	
		
		 // prmtCustomer
        this.prmtSelectCustomers.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtCustomer_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
		
		
        // 设置日期区间
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.set(cal.get(cal.YEAR), cal.get(cal.MONTH) , 1, 0, 0, 0);
		this.dpBeginDate.setValue(cal.getTime());
		cal.add(Calendar.MONTH,1);
		cal.add(Calendar.DATE, -1);
		cal.set(cal.get(cal.YEAR), cal.get(cal.MONTH), cal.get(cal.DATE),  23, 59, 59);
		this.dpEndDate.setValue(cal.getTime());
		
		
		this.cbLz.setEditable(false);
		this.cbLz.setEnabled(false);
		this.cbSw.setEditable(false);
		this.cbSw.setEnabled(false);
    }
	
    /**
     * output prmtCustomer_dataChanged method
     */
    protected void prmtCustomer_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
       
        if(this.prmtSelectCustomers.getData() != null){
        	 Object selectCustomers = this.prmtSelectCustomers.getData();
        	 if(selectCustomers != null && selectCustomers.getClass().equals(CustomerInfo.class)){
        		 CustomerInfo customerInfo = (CustomerInfo) selectCustomers;
     			if(customerInfo != null){
	        			String id = customerInfo.getId().toString();
	        			String number = customerInfo.getNumber();
	        			String name = customerInfo.getName();
	        			// 已经存在的 客户不重复添加
	        			if(this.isExistCustomer(id)){
	        				return;
	        			}
	        				
	        			
	        			IRow newRow = this.kdtCustomer.addRow();
	        			newRow.getCell("customer").setValue(customerInfo);
	        			newRow.getCell("selected").setValue(Boolean.FALSE);
	        			newRow.getCell("customerNumber").setValue(number);
	        			newRow.getCell("customerName").setValue(name);
     			}
        	 }else{
	        	Object[] selectedCustomers = (Object[]) selectCustomers;
	        	if(selectedCustomers.length > 0){
	        		for(int i = 0; i < selectedCustomers.length; i++){
	        			CustomerInfo customerInfo = (CustomerInfo) selectedCustomers[i];
	        			if(customerInfo != null){
		        			String id = customerInfo.getId().toString();
		        			String number = customerInfo.getNumber();
		        			String name = customerInfo.getName();
		        			// 已经存在的 客户不重复添加
		        			if(this.isExistCustomer(id)){
		        				continue;
		        			}
		        			IRow newRow = this.kdtCustomer.addRow();
//		        			newRow.getCell("customerID").setValue(id);
		        			newRow.getCell("selected").setValue(Boolean.FALSE);
		        			newRow.getCell("customer").setValue(customerInfo);
		        			newRow.getCell("customerNumber").setValue(number);
		        			newRow.getCell("customerName").setValue(name);
	        			}
	        		}
	        	}
        	 }
         }
    }
    
    
    /**
     * 校验分录中是否已经存在对应的客户ID了
     * @param customerID
     * @return
     */
    private boolean isExistCustomer(String customerID){
    	for(int i = 0; i < this.kdtCustomer.getRowCount(); i++){
			CustomerInfo currCustomer = (CustomerInfo)this.kdtCustomer.getRow(i).getCell("customer").getValue();
			if(currCustomer != null && customerID.equals(currCustomer.getId().toString())){
				return true;
			}
		}
    	
    	
    	return false;
		
    }
    
    /**
     * 校验  获取界面数据
     */
    private void valid(){
    	// 折让类别
		List<String> discountTypes = new ArrayList<String>();
		
		if(cbYz.isSelected()){
			discountTypes.add(DiscountTypeEnum.YUEZHE_VALUE);
		}
		if(cbNz.isSelected()){
			discountTypes.add(DiscountTypeEnum.NIANZHE_VALUE);
		}
		if(cbFx.isSelected()){
			discountTypes.add(DiscountTypeEnum.FENXIAO_VALUE);
		}
		if(discountTypes.size() > 1){
			MsgBox.showInfo("只能选择一种折让方式进行操作");
			SysUtil.abort();
		}
		this.setDiscountTypes(discountTypes);
		if(discountTypes.size() == 0){
			MsgBox.showInfo("折让类别未选择");
			SysUtil.abort();
		}
		
		Date beginDate = this.dpBeginDate.getSqlDate();
		this.setBeginDate(beginDate);
		if(beginDate == null){
			MsgBox.showInfo("开始日期为空");
			SysUtil.abort();
		}
		
		Date endDate = this.dpEndDate.getSqlDate();
		this.setEndDate(endDate);
		if(endDate == null){
			MsgBox.showInfo("结束日期为空");
			SysUtil.abort();
		}
		
		int rowCount = this.kdtCustomer.getRowCount();
		List<CustomerInfo> customers = new ArrayList<CustomerInfo>();
		if(rowCount > 0){
			for(int i = 0; i < rowCount; i++){
				CustomerInfo currCustomer = (CustomerInfo) this.kdtCustomer.getRow(i).getCell("customer").getValue();
				if(currCustomer != null){
					customers.add(currCustomer);
				}
			}
		}
		this.setCustomers(customers);
		
    }
	/**
	 * 生成 折让记录单
	 */
	@Override
	protected void btnGenerateRecord_actionPerformed(ActionEvent e)
			throws Exception {
		// 生成前 校验
		this.valid();
		// 生成
		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
		// 按照选中的客户生成 折让记录单
		if(customers.size() <= 0){
			if(MsgBox.showConfirm2("未选中任何客户，是否将全部客户生成折让记录单？") != MsgBox.OK){
				SysUtil.abort();
			}
		}
		if(companyInfo != null){
			boolean result = DiscountFacadeFactory.getRemoteInstance().generateDiscountRecordbill(companyInfo.getId().toString(), discountTypes,customers, beginDate, endDate);
			MsgBox.showInfo("生成完成");
			SysUtil.abort();
		}else{
			MsgBox.showInfo("当前未在财务组织，无法操作");
			SysUtil.abort();
		}
	}
	/**
	 * 查询
	 */
	@Override
	protected void btnSearch_actionPerformed(ActionEvent e) throws Exception {
		valid();
		
//		if(this.getCustomers() == null || this.getCustomers().size() == 0){
//			MsgBox.showInfo("未选择客户");
//			SysUtil.abort();
//		}else{
			
			// 查询
			CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
			if(companyInfo != null){
				List<DiscountCashInfo> discountCashInfos = 
					DiscountFacadeFactory.getRemoteInstance().getDiscountCashInfos(companyInfo.getId().toString(),
							discountTypes,
							beginDate, 
							endDate, 
							customers,
							this.cbNoReveiving.isSelected(),
							this.cbHaveReveiving.isSelected());
				if(discountCashInfos != null && discountCashInfos.size() > 0){
					this.kdtData.removeRows();
					for(int i = 0; i < discountCashInfos.size(); i++){
						DiscountCashInfo cashInfo = discountCashInfos.get(i);
						// 现将 单据头 插入，然后逐个插入明细
						IRow newRow = this.kdtData.addRow();
						newRow.getStyleAttributes().setLocked(true);
						newRow.getCell("selected").getStyleAttributes().setLocked(false);
						newRow.getCell("selected").setValue(false);
						newRow.getCell("isBill").setValue("1");
						
						newRow.getCell("detail").setValue("+");
						
						CustomerInfo customerInfo = cashInfo.getCustomerInfo();
						newRow.getCell("customer").setValue(customerInfo.getId().toString());
						newRow.getCell("customerNumber").setValue(customerInfo.getNumber());
						newRow.getCell("customerName").setValue(customerInfo.getName());
						newRow.getCell("amount").setValue(cashInfo.getAllAmount());
						newRow.getCell("billType").setValue(cashInfo.getDiscountTypeEnum().getAlias());
						newRow.getCell("billQty").setValue(cashInfo.getBillCount());
						List<DiscountCashDetail> cashDetails = cashInfo.getDetails();
						if(cashDetails != null && cashDetails.size() > 0){
							for(int j = 0; j < cashDetails.size(); j++){
								DiscountCashDetail detail = cashDetails.get(j);
								newRow = this.kdtData.addRow();
								//orderDSAmount其中参数的 16-23 位表示红色成分，8-15 位表示绿色成分，0-7 位表示兰色成分。0 表示这个基色成分没有参与颜色构成。
								Color color = new Color(250,250,230); 
								
								newRow.getStyleAttributes().setBackground(color);
								newRow.getStyleAttributes().setLocked(true);
								newRow.getStyleAttributes().setHided(true);
								newRow.getCell("selected").getStyleAttributes().setLocked(false);
								newRow.getCell("selected").setValue(false);
								newRow.getCell("isBill").setValue("0");
								newRow.getCell("detail").setValue("-");
								
								newRow.getCell("customer").setValue(customerInfo.getId().toString());
								newRow.getCell("customerNumber").setValue(customerInfo.getNumber());
								newRow.getCell("customerName").setValue(customerInfo.getName());
								newRow.getCell("bizDate").setValue(detail.getRecordBillInfo().getBizDate());
								newRow.getCell("billID").setValue(detail.getRecordBillInfo().getId().toString());
								newRow.getCell("billNumber").setValue(detail.getRecordBillInfo().getNumber());
								newRow.getCell("amount").setValue(detail.getRecordBillInfo().getAmount());
								newRow.getCell("status").setValue(detail.getRecordBillInfo().getStatus().getAlias());
								newRow.getCell("billQty").setValue(detail.getCount());
								newRow.getCell("billType").setValue(cashInfo.getDiscountTypeEnum().getAlias());
								if(detail.getReceivingBillInfo() != null){
									newRow.getCell("receiveBillID").setValue(detail.getReceivingBillInfo().getId().toString());
									newRow.getCell("receiveBillNumber").setValue(detail.getReceivingBillInfo().getNumber());
									newRow.getCell("receiveBillStatus").setValue(detail.getReceivingBillInfo().getBillStatus().getAlias());
									
									newRow.getCell("receiveUser").setValue(detail.getReveivingCreator());
									newRow.getCell("receiveTime").setValue(detail.getReceivingBillInfo().getCreateTime());
									newRow.getCell("receiveDate").setValue(detail.getReceivingBillInfo().getBizDate());
									
								}
							}
						}
					}
				}else{
					this.kdtData.removeRows();
					MsgBox.showInfo("没有符合条件的记录");
					SysUtil.abort();
				}
					
			}else{
				MsgBox.showInfo("当前未在财务组织，无法操作");
				SysUtil.abort();
			}
//		}
		
		
	}
	
	/**
	 * 处理单击事件，如果单击 总计行，则显示或者隐藏对应客户的明细单据
	 */
	@Override
	protected void kdtData_tableClicked(KDTMouseEvent e) throws Exception {
		
		int selRow = e.getRowIndex();
		int selCol = e.getColIndex();
		// 合并或者折叠
		if(selCol ==this.kdtData.getColumn("detail").getColumnIndex()){
//		if(selCol == this.kdtData.getColumnIndex(""))
			if(this.kdtData.getCell(selRow, "detail") != null){
				String isDetail = (String) this.kdtData.getCell(selRow, "detail").getValue();
				String isBill = (String) this.kdtData.getCell(selRow, "isBill").getValue();
				
				String customerID = (String) this.kdtData.getCell(selRow, "customer").getValue();
				String discountType = (String) this.kdtData.getCell(selRow, "billType").getValue();
				if("1".equals(isBill) && "+".equals(isDetail)){
					this.kdtData.getCell(selRow, "detail").setValue("-");
					showOrHideDetails(customerID,discountType,true);
				}else if("1".equals(isBill)){
					this.kdtData.getCell(selRow, "detail").setValue("+");
					showOrHideDetails(customerID,discountType,false);
				}
			}
		}
		
		
		
	
	}
	
	/**
	 * 选择 或者反选时 如果是对 合计行 操作则  同步 处理明细行
	 */
	@Override
	protected void kdtData_editStopped(KDTEditEvent e) throws Exception {
		
		
		
	}
	/**
	 * 选择 或者反选时 如果是对 合计行 操作则  同步 处理明细行
	 */
	@Override
	protected void kdtData_editValueChanged(KDTEditEvent e) throws Exception {
		int selRow = e.getRowIndex();
		int selCol = e.getColIndex();
		
		// 勾选
		if(selCol == this.kdtData.getColumn("selected").getColumnIndex() ){
			
			String isBill = (String) this.kdtData.getCell(selRow, "isBill").getValue();
			boolean selected = (Boolean)e.getValue();
			String customerID = (String) this.kdtData.getCell(selRow, "customer").getValue(); 
			if("1".equals(isBill)){
				selectOrUnselectDetails(customerID,selected);
			}
			
		}
	}

	/**
	 *显示或者隐藏 明细行
	 * @param customerID
	 */
	private void selectOrUnselectDetails(String customerID,boolean selected){
		for(int i = 0; i < this.kdtData.getRowCount(); i++){
			String currID = (String) this.kdtData.getCell(i, "customer").getValue();
			String isBill = (String) this.kdtData.getCell(i, "isBill").getValue();
			if(currID.equals(customerID) && "0".equals(isBill)){
				if(selected){
					this.kdtData.getRow(i).getCell("selected").setValue(true);
				}else{
					this.kdtData.getRow(i).getCell("selected").setValue(false);
				}
			}
		}
	}
	
	/**
	 *显示或者隐藏 明细行
	 * @param customerID
	 */
	private void showOrHideDetails(String customerID,String discountType,boolean isShow){
		for(int i = 0; i < this.kdtData.getRowCount(); i++){
			String currID = (String) this.kdtData.getCell(i, "customer").getValue();
			String isBill = (String) this.kdtData.getCell(i, "isBill").getValue();
			String currDiscountType = (String) this.kdtData.getCell(i, "billType").getValue();
			if(currID.equals(customerID) && currDiscountType.equals(discountType) && "0".equals(isBill)){
				if(isShow){
					this.kdtData.getRow(i).getStyleAttributes().setHided(false);
				}else{
					this.kdtData.getRow(i).getStyleAttributes().setHided(true);
				}
			}
		}
	}
	/**
	 * 生成收款单
	 */
	@Override
	protected void btnConfirm_actionPerformed(ActionEvent e) throws Exception {
		Map<String,List<DiscountRecordBillInfo>> receivRecords = new HashMap<String, List<DiscountRecordBillInfo>>();
		List<DiscountRecordBillInfo> redords = new ArrayList<DiscountRecordBillInfo>();
		// 生成
		CompanyOrgUnitInfo companyOrgUnitInfo = SysContext.getSysContext().getCurrentFIUnit();
		if(companyOrgUnitInfo != null){
			for(int i = 0; i < this.kdtData.getRowCount(); i++){
				String isBill = (String) this.kdtData.getCell(i, "isBill").getValue();
				boolean selected = (Boolean) this.kdtData.getCell(i, "selected").getValue();
				if("0".equals(isBill) && selected){
					String billID = (String) this.kdtData.getCell(i, "billID").getValue();
					String customerID = (String) this.kdtData.getCell(i, "customer").getValue();
					
					DiscountRecordBillInfo billInfo = new DiscountRecordBillInfo();
					billInfo.setId(BOSUuid.read(billID));
					
					if(receivRecords.containsKey(customerID)){
						List<DiscountRecordBillInfo>  billInfos = receivRecords.get(customerID);
						billInfos.add(billInfo);
					}else{
						List<DiscountRecordBillInfo>  billInfos = new ArrayList<DiscountRecordBillInfo>();
						billInfos.add(billInfo);
						receivRecords.put(customerID, billInfos);
					}
					
				}
			}
		
			// 调用接口生成
			DiscountFacadeFactory.getRemoteInstance().generateReceiveBills(companyOrgUnitInfo.getId().toString(), receivRecords);
			MsgBox.showInfo("生成完成");
			// 刷新界面
			this.btnSearch_actionPerformed(null);
		}else{
			MsgBox.showInfo("当前未在财务组织，无法操作");
			SysUtil.abort();
			
		}
		
		
	}
	
	/**
	 * 客户列表 全选
	 */
	@Override
	protected void btnSelectAll_actionPerformed(ActionEvent e) throws Exception {
		for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
			this.kdtCustomer.getCell(i, "selected").setValue(true);
		}
	}
    /**
     * 客户列表  全不选
     */
	@Override
	protected void btnAllUnSelect_actionPerformed(ActionEvent e)
			throws Exception {
		for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
			this.kdtCustomer.getCell(i, "selected").setValue(false);
		}
	}
	/**
	 * 客户   删除选中客户
	 */
	@Override
	protected void btnDel_actionPerformed(ActionEvent e) throws Exception {
		
		boolean allNoChecked = false;
    	for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
			Boolean selected = (Boolean) this.kdtCustomer.getCell(i, "selected").getValue();
			if(selected){
				allNoChecked = true;
			}
		}
    	if(!allNoChecked){
    		MsgBox.showInfo("没有选择任何客户");
    		return;
    	}
    	if(MsgBox.showConfirm2("确认移除选中的客户？") == MsgBox.OK){
	    	for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
				Boolean selected = (Boolean) this.kdtCustomer.getCell(i, "selected").getValue();
				if(selected){
					this.kdtCustomer.removeRow(i);
					i--;
				}
			}
    	}
	}

	/**
	 * 数据 全选
	 */
	@Override
	protected void btnSelectAllData_actionPerformed(ActionEvent e)
			throws Exception {
		for(int i = 0 ; i < this.kdtData.getRowCount(); i++){
			this.kdtData.getCell(i, "selected").setValue(true);
		}
	}
	/**
	 * 数据  全不选
	 */
	@Override
	protected void btnAllUnSelectData_actionPerformed(ActionEvent e)
			throws Exception {
		for(int i = 0 ; i < this.kdtData.getRowCount(); i++){
			this.kdtData.getCell(i, "selected").setValue(false);
		}
	}
	
	/**
	 * 退出
	 */
	@Override
	protected void btnCancel_actionPerformed(ActionEvent e) throws Exception {
		this.getUIWindow().close();
	}

	
	
}