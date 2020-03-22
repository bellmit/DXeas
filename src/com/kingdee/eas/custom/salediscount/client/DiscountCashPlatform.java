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
     * ��ʼ����������
     * @throws Exception 
     */
    private void initUI() throws Exception{
    	Map context = this.getUIContext();
    	// ʵ����۲��ɲ���
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
		// ��Ӳ�����֯����
		filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
		evi.setFilter(filterInfo);
    	// ����F7��ѯԪ����
		String queryInfo = QueryInfoConstants.CUSTOMER_COMPANY_STANDARD;
//		prmtSelectCustomers.setQueryInfo(queryInfo);
		// ������ҵ����֯
		prmtSelectCustomers.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// ���ÿͻ�F7�Ĺ�������
		prmtSelectCustomers.setEntityViewInfo(evi);
		prmtSelectCustomers.setCommitFormat("$number$");//�ύ��ʽ
		prmtSelectCustomers.setDisplayFormat("$number$");//��ʾ��ʽ
		prmtSelectCustomers.setEditFormat("$number$");//�༭��ʽ
		prmtSelectCustomers.setEnabledMultiSelection(true);
		// ���ÿͻ�F7չ����ʽΪ�����ұ�
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
		
	    // ѡ����
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
		
		
        // ������������
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
	        			// �Ѿ����ڵ� �ͻ����ظ����
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
		        			// �Ѿ����ڵ� �ͻ����ظ����
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
     * У���¼���Ƿ��Ѿ����ڶ�Ӧ�Ŀͻ�ID��
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
     * У��  ��ȡ��������
     */
    private void valid(){
    	// �������
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
			MsgBox.showInfo("ֻ��ѡ��һ�����÷�ʽ���в���");
			SysUtil.abort();
		}
		this.setDiscountTypes(discountTypes);
		if(discountTypes.size() == 0){
			MsgBox.showInfo("�������δѡ��");
			SysUtil.abort();
		}
		
		Date beginDate = this.dpBeginDate.getSqlDate();
		this.setBeginDate(beginDate);
		if(beginDate == null){
			MsgBox.showInfo("��ʼ����Ϊ��");
			SysUtil.abort();
		}
		
		Date endDate = this.dpEndDate.getSqlDate();
		this.setEndDate(endDate);
		if(endDate == null){
			MsgBox.showInfo("��������Ϊ��");
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
	 * ���� ���ü�¼��
	 */
	@Override
	protected void btnGenerateRecord_actionPerformed(ActionEvent e)
			throws Exception {
		// ����ǰ У��
		this.valid();
		// ����
		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
		// ����ѡ�еĿͻ����� ���ü�¼��
		if(customers.size() <= 0){
			if(MsgBox.showConfirm2("δѡ���κοͻ����Ƿ�ȫ���ͻ��������ü�¼����") != MsgBox.OK){
				SysUtil.abort();
			}
		}
		if(companyInfo != null){
			boolean result = DiscountFacadeFactory.getRemoteInstance().generateDiscountRecordbill(companyInfo.getId().toString(), discountTypes,customers, beginDate, endDate);
			MsgBox.showInfo("�������");
			SysUtil.abort();
		}else{
			MsgBox.showInfo("��ǰδ�ڲ�����֯���޷�����");
			SysUtil.abort();
		}
	}
	/**
	 * ��ѯ
	 */
	@Override
	protected void btnSearch_actionPerformed(ActionEvent e) throws Exception {
		valid();
		
//		if(this.getCustomers() == null || this.getCustomers().size() == 0){
//			MsgBox.showInfo("δѡ��ͻ�");
//			SysUtil.abort();
//		}else{
			
			// ��ѯ
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
						// �ֽ� ����ͷ ���룬Ȼ�����������ϸ
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
								//orderDSAmount���в����� 16-23 λ��ʾ��ɫ�ɷ֣�8-15 λ��ʾ��ɫ�ɷ֣�0-7 λ��ʾ��ɫ�ɷ֡�0 ��ʾ�����ɫ�ɷ�û�в�����ɫ���ɡ�
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
					MsgBox.showInfo("û�з��������ļ�¼");
					SysUtil.abort();
				}
					
			}else{
				MsgBox.showInfo("��ǰδ�ڲ�����֯���޷�����");
				SysUtil.abort();
			}
//		}
		
		
	}
	
	/**
	 * �������¼���������� �ܼ��У�����ʾ�������ض�Ӧ�ͻ�����ϸ����
	 */
	@Override
	protected void kdtData_tableClicked(KDTMouseEvent e) throws Exception {
		
		int selRow = e.getRowIndex();
		int selCol = e.getColIndex();
		// �ϲ������۵�
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
	 * ѡ�� ���߷�ѡʱ ����Ƕ� �ϼ��� ������  ͬ�� ������ϸ��
	 */
	@Override
	protected void kdtData_editStopped(KDTEditEvent e) throws Exception {
		
		
		
	}
	/**
	 * ѡ�� ���߷�ѡʱ ����Ƕ� �ϼ��� ������  ͬ�� ������ϸ��
	 */
	@Override
	protected void kdtData_editValueChanged(KDTEditEvent e) throws Exception {
		int selRow = e.getRowIndex();
		int selCol = e.getColIndex();
		
		// ��ѡ
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
	 *��ʾ�������� ��ϸ��
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
	 *��ʾ�������� ��ϸ��
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
	 * �����տ
	 */
	@Override
	protected void btnConfirm_actionPerformed(ActionEvent e) throws Exception {
		Map<String,List<DiscountRecordBillInfo>> receivRecords = new HashMap<String, List<DiscountRecordBillInfo>>();
		List<DiscountRecordBillInfo> redords = new ArrayList<DiscountRecordBillInfo>();
		// ����
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
		
			// ���ýӿ�����
			DiscountFacadeFactory.getRemoteInstance().generateReceiveBills(companyOrgUnitInfo.getId().toString(), receivRecords);
			MsgBox.showInfo("�������");
			// ˢ�½���
			this.btnSearch_actionPerformed(null);
		}else{
			MsgBox.showInfo("��ǰδ�ڲ�����֯���޷�����");
			SysUtil.abort();
			
		}
		
		
	}
	
	/**
	 * �ͻ��б� ȫѡ
	 */
	@Override
	protected void btnSelectAll_actionPerformed(ActionEvent e) throws Exception {
		for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
			this.kdtCustomer.getCell(i, "selected").setValue(true);
		}
	}
    /**
     * �ͻ��б�  ȫ��ѡ
     */
	@Override
	protected void btnAllUnSelect_actionPerformed(ActionEvent e)
			throws Exception {
		for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
			this.kdtCustomer.getCell(i, "selected").setValue(false);
		}
	}
	/**
	 * �ͻ�   ɾ��ѡ�пͻ�
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
    		MsgBox.showInfo("û��ѡ���κοͻ�");
    		return;
    	}
    	if(MsgBox.showConfirm2("ȷ���Ƴ�ѡ�еĿͻ���") == MsgBox.OK){
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
	 * ���� ȫѡ
	 */
	@Override
	protected void btnSelectAllData_actionPerformed(ActionEvent e)
			throws Exception {
		for(int i = 0 ; i < this.kdtData.getRowCount(); i++){
			this.kdtData.getCell(i, "selected").setValue(true);
		}
	}
	/**
	 * ����  ȫ��ѡ
	 */
	@Override
	protected void btnAllUnSelectData_actionPerformed(ActionEvent e)
			throws Exception {
		for(int i = 0 ; i < this.kdtData.getRowCount(); i++){
			this.kdtData.getCell(i, "selected").setValue(false);
		}
	}
	
	/**
	 * �˳�
	 */
	@Override
	protected void btnCancel_actionPerformed(ActionEvent e) throws Exception {
		this.getUIWindow().close();
	}

	
	
}