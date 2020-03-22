/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.form.metadata.EnumItem;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.PeriodTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgSelect;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.client.OrgUnitTreePromptBox;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.ResultInfo;
import com.kingdee.eas.custom.salediscount.CustomerDiscountInfo;
import com.kingdee.eas.custom.salediscount.CustomerMaterialDSInfo;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.custom.salediscount.DiscountTypeEnum;
import com.kingdee.eas.custom.salediscount.IDiscountFacade;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.enums.EnumUtils;

/**
 * output class name
 */
public class DiscountAdjustPlatform extends AbstractDiscountAdjustPlatform
{
    private static final Logger logger = CoreUIObject.getLogger(DiscountAdjustPlatform.class);
    
    /* 当前展示在table中的数据条件 和 数据信息,暂存下来主要为了每次查询前先比较是否只有 调整类别 发生变化
    /* 如果只有调整类别发生变化，则直接从内存中取数，按调整类别展示，否则重新调用后台接口取数
    /********************************************************************************/
    private CompanyOrgUnitInfo displayDataCompany;
    private Date displayDataBeginDate;
    private Date displayDataEndDate;
    private DiscountTypeEnum displayDataDSType;
    private String displayDataAdjustType;
    private PeriodInfo displayDataPeriod;
    private Map<CustomerInfo,CustomerDiscountInfo>  displayDataDiscountInfos;
    /**********************************************************************************/
    /**
     * output class constructor
     */
    public DiscountAdjustPlatform() throws Exception
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
    /**
     * 加载项目
     */
    @Override
    public void loadFields(){
    	super.loadFields();
    }

	@Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		this.setUITitle("折让调整");
		this.kDTable1.checkParsed();
		 // 选择列
		KDCheckBox cb = new KDCheckBox();
		cb.setSelected(false);
//			cb.setVisible(true);
		this.kDTable1.getColumn("selected").setEditor(
					new KDTDefaultCellEditor(cb));
		// 公司
		//公司的F7的设置
		OrgType[] CompanyType = { OrgType.Company };
		//首先定义需要显示那些树，这里只显示财务树
		//为F7控件指定PromptBox
		this.prmtCompany.setEditFormat("$number$");
		this.prmtCompany.setDisplayFormat("$name$");
		this.prmtCompany.setEditable(true);
		this.prmtCompany.setCommitFormat("$number$");
		OrgUnitTreePromptBox boxCompany = new OrgUnitTreePromptBox(this, CompanyType, null,
		OrgSelect.OnlySelectCompanyEntity, false, false, false);
		prmtCompany.setSelector(boxCompany);
		prmtCompany.setData(SysContext.getSysContext().getCurrentFIUnit());
		prmtCompany.setEnabled(false);
		// 折让类别
		this.cbDiscountType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salediscount.DiscountTypeEnum").toArray());	
		
//		this.cbDiscountType.addItem(new )
		this.cbDiscountType.setSelectedIndex(0);
        this.cbDiscountType.setRequired(false);
        // 调整方式 总量、大类、小类、产品
        EnumItem enumItem = new EnumItem();
		enumItem.setDisplayValue_L1("all");
		enumItem.setDisplayValue_L2("总量");
		enumItem.setDisplayValue_L3("总量");
		enumItem.setDisplayValueValue("总量");
		enumItem.setValue(0);
//		enumItem.
		this.cbAdjustType.addItem(enumItem);
		enumItem = new EnumItem();
		enumItem.setDisplayValue_L1("detail");
		enumItem.setDisplayValue_L2("产品");
		enumItem.setDisplayValue_L3("产品");
		enumItem.setDisplayValueValue("产品");
		enumItem.setValue(9);
//		enumItem.
		this.cbAdjustType.addItem(enumItem);
		
		this.cbAdjustType.setSelectedIndex(0);
		
//		this.dpBeginTime.setDatePattern("yyyy-MM-dd HH:mm:ss");
//		this.dpEndTime.setDatePattern("yyyy-MM-dd HH:mm:ss");
		// 设置日期区间
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.set(cal.get(cal.YEAR), cal.get(cal.MONTH) , 1, 0, 0, 0);
		this.dpBeginTime.setValue(cal.getTime());
		cal.add(Calendar.MONTH,1);
		cal.add(Calendar.DATE, -1);
		cal.set(cal.get(cal.YEAR), cal.get(cal.MONTH), cal.get(cal.DATE),  23, 59, 59);
		this.dpEndTime.setValue(cal.getTime());
		
		
		this.btnSearch.setEnabled(true);
		this.search.setEnabled(true);
		
		this.btnConfirm.setEnabled(true);
		this.confirm.setEnabled(true);
		
		this.rbByDiscountQty.setSelected(true);
		
		this.prmtPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtPeriod.setVisible(true);		
        this.prmtPeriod.setEditable(true);		
        this.prmtPeriod.setDisplayFormat("$number$");		
        this.prmtPeriod.setEditFormat("$number$");		
        this.prmtPeriod.setCommitFormat("$number$");		
        this.prmtPeriod.setRequired(false);		
//        this.prmtPeriod.setEnabled(false);
		
		
		
		
	}
	
	/**
	 * 查询订单
	 */
	public void search_actionPerformed(ActionEvent e) throws Exception {
		// 按照 查询头
		Date beginTime = this.dpBeginTime.getSqlDate();
		Date endTime = this.dpEndTime.getSqlDate();
		if(beginTime == null || endTime == null){
			MsgBox.showInfo("日期不能为空");
			SysUtil.abort();
		}
		PeriodInfo periodInfo = (PeriodInfo) this.prmtPeriod.getValue();
		if(periodInfo == null){
			MsgBox.showInfo("还未设置结算单期间");
			this.prmtPeriod.requestFocus();
			return;
		}
		
		DiscountTypeEnum dstype = (DiscountTypeEnum)this.cbDiscountType.getSelectedItem();
		if(dstype == null){
			MsgBox.showInfo("请先选择折让类别");
			SysUtil.abort();
		}
		CompanyOrgUnitInfo currCompanyInfo = SysContext.getSysContext().getCurrentFIUnit();
		if(currCompanyInfo == null){
			MsgBox.showInfo("获取当前公司失败");
			SysUtil.abort();
		}else{
//			if(beginTime.equals(this.displayDataBeginDate) &&
//					endTime.equals(this.displayDataEndDate) && 
//					dstype.equals(this.displayDataDSType) && 
//					currCompanyInfo.equals(this.displayDataCompany) &&
//					periodInfo.equals(this.displayDataPeriod)  &&
//					this.displayDataDiscountInfos != null && 
//					this.displayDataDiscountInfos.size() > 0){
//				
//			}else{
//				
			
				IDiscountFacade discountFacade = DiscountFacadeFactory.getRemoteInstance();
				Map<CustomerInfo,CustomerDiscountInfo>  returns = discountFacade.getDiscountInfos(
						currCompanyInfo.getId().toString(),
						beginTime,
						endTime,
						dstype.getValue(),
						periodInfo);
				// 暂存结果
				this.displayDataDiscountInfos = returns;
				this.displayDataBeginDate = beginTime;
				this.displayDataEndDate = endTime;
				this.displayDataDSType = dstype;
				this.displayDataCompany = currCompanyInfo;
				this.displayDataPeriod = periodInfo;
//			}
			// 展示查询结果
			if(this.displayDataDiscountInfos != null && this.displayDataDiscountInfos.size() > 0){
				displayDiscountInfos(this.displayDataDiscountInfos);
			}
			
		}
	}
	/**
	 * 展示查询结果
	 * @param returns
	 */
	private void displayDiscountInfos(Map<CustomerInfo,CustomerDiscountInfo>  discountInfos){
		this.kDTable1.removeRows();
		
		EnumItem adjustTypeEnum = (EnumItem) this.cbAdjustType.getSelectedItem();
		
		Set<CustomerInfo> customerInfos = discountInfos.keySet();
		Iterator<CustomerInfo> customerIterators = customerInfos.iterator();
		while(customerIterators.hasNext()){
			// 客户
			CustomerInfo currCustomerInfo = customerIterators.next();
			// 客户折让信息
			CustomerDiscountInfo customerDSInfo = discountInfos.get(currCustomerInfo);
			// 客户物料折让明细
			List<CustomerMaterialDSInfo> customerMaterialDSInfos = customerDSInfo.getMaterialDiscountInfos();
			// 按明细展示
			this.kDTable1.getColumn("customer").getStyleAttributes().setHided(true);
			if("产品".equals(adjustTypeEnum.getDisplayValue())){
				this.kDTable1.getColumn("groupID").getStyleAttributes().setHided(true);
				this.kDTable1.getColumn("groupNumber").getStyleAttributes().setHided(true);
				this.kDTable1.getColumn("groupName").getStyleAttributes().setHided(true);
				
				this.kDTable1.getColumn("material").getStyleAttributes().setHided(true);
				this.kDTable1.getColumn("materialNumber").getStyleAttributes().setHided(false);
				this.kDTable1.getColumn("materialName").getStyleAttributes().setHided(false);
				for(int j = 0; j < customerMaterialDSInfos.size(); j++){
					CustomerMaterialDSInfo cMaterialDSInfo = customerMaterialDSInfos.get(j);
					
					IRow newRow = this.kDTable1.addRow();
					newRow.getCell("selected").setValue(Boolean.FALSE);
					newRow.getCell("customer").setValue(currCustomerInfo);
					newRow.getCell("customerNumber").setValue(currCustomerInfo.getNumber());
					newRow.getCell("customerName").setValue(currCustomerInfo.getName());
					
					newRow.getCell("groupID").setValue(cMaterialDSInfo.getMaterialInfo().getId().toString());
					newRow.getCell("groupNumber").setValue(cMaterialDSInfo.getMaterialInfo().getNumber());
					newRow.getCell("groupName").setValue(cMaterialDSInfo.getMaterialInfo().getName());
					
					newRow.getCell("material").setValue(cMaterialDSInfo.getMaterialInfo());
					newRow.getCell("materialNumber").setValue(cMaterialDSInfo.getMaterialInfo().getNumber());
					newRow.getCell("materialName").setValue(cMaterialDSInfo.getMaterialInfo().getName());
					
					newRow.getCell("orderDSAmount").setValue(cMaterialDSInfo.getSaleOrderDiscountAmount());
					newRow.getCell("adjustAmount").setValue(new BigDecimal("0"));
					newRow.getCell("confirmAmount").setValue(cMaterialDSInfo.getSaleOrderDiscountAmount());
					
					// 折扣销量
					if(cMaterialDSInfo.getSaleOrderDiscountAmount() != null && 
							cMaterialDSInfo.getSaleOrderDiscountAmount().compareTo(new BigDecimal(0)) != 0){
						// 按吨显示
						BigDecimal saleOrderDisQty = cMaterialDSInfo.getSaleOrderDiscountQty();
						if(saleOrderDisQty == null){saleOrderDisQty = new BigDecimal("0");}
						saleOrderDisQty = saleOrderDisQty.divide(new BigDecimal("1000"),4,RoundingMode.HALF_UP);
						newRow.getCell("discountSaleQty").setValue(saleOrderDisQty);
					}else{
						newRow.getCell("discountSaleQty").setValue(new BigDecimal("0"));
					}
					BigDecimal saleQty = cMaterialDSInfo.getSaleQty();
					if(saleQty == null){saleQty = new BigDecimal("0");}
					saleQty = saleQty.divide(new BigDecimal("1000"),4,RoundingMode.HALF_UP);
					
					newRow.getCell("saleBaseQty").setValue(saleQty);
					
					newRow.getCell("saleAmount").setValue(cMaterialDSInfo.getSaleAmount());

					// 有记录
					if(StringUtils.isNotBlank(cMaterialDSInfo.getDisRecordNumber()) && cMaterialDSInfo.getDisRecordAdustAmount() != null){
						//orderDSAmount其中参数的 16-23 位表示红色成分，8-15 位表示绿色成分，0-7 位表示兰色成分。0 表示这个基色成分没有参与颜色构成。
						Color color = new Color(250,250,230); 
						
						newRow.getStyleAttributes().setBackground(color);
						
						newRow.getCell("disRecordNumber").setValue(cMaterialDSInfo.getDisRecordNumber());
						newRow.getCell("vision").setValue(cMaterialDSInfo.getDisRecordVision());
						newRow.getCell("disRecordState").setValue(cMaterialDSInfo.getDisRecordStatus().getAlias());
						newRow.getCell("adjustType").setValue(cMaterialDSInfo.getAdjustType());
						newRow.getCell("adjustor").setValue(cMaterialDSInfo.getDisRecordCreator().getName());
						newRow.getCell("disRecordCreateTime").setValue(cMaterialDSInfo.getDisRecordCreateTime());
						newRow.getCell("disRecordBizdate").setValue(cMaterialDSInfo.getDisRecordBizdate());
						newRow.getCell("disRecordAmount").setValue(cMaterialDSInfo.getDisRecordAdustAmount());
						
						
						BigDecimal adjustRecord = cMaterialDSInfo.getDisRecordAdustAmount();
						if(adjustRecord == null){ adjustRecord = new BigDecimal("0");}
						BigDecimal confirmAmount = cMaterialDSInfo.getSaleOrderDiscountAmount();
						if(confirmAmount == null) {confirmAmount = new BigDecimal("0");}
						confirmAmount = confirmAmount.add(adjustRecord);
						
						newRow.getCell("adjustAmount").setValue(adjustRecord);
						newRow.getCell("confirmAmount").setValue(confirmAmount);
						
						newRow.getCell("disRecordID").setValue(cMaterialDSInfo.getDisRecordID());
						newRow.getCell("disRecordEntryID").setValue(cMaterialDSInfo.getDisRecordEntryID());
					}
					
				}
			}else if("总量".equals(adjustTypeEnum.getDisplayValue())){
				this.kDTable1.getColumn("groupID").getStyleAttributes().setHided(true);
				this.kDTable1.getColumn("groupNumber").getStyleAttributes().setHided(true);
				this.kDTable1.getColumn("groupName").getStyleAttributes().setHided(false);
				
				this.kDTable1.getColumn("material").getStyleAttributes().setHided(true);
				this.kDTable1.getColumn("materialNumber").getStyleAttributes().setHided(true);
				this.kDTable1.getColumn("materialName").getStyleAttributes().setHided(true);
				
				IRow newRow = this.kDTable1.addRow();
				newRow.getCell("selected").setValue(Boolean.FALSE);
				newRow.getCell("customer").setValue(currCustomerInfo);
				newRow.getCell("customerNumber").setValue(currCustomerInfo.getNumber());
				newRow.getCell("customerName").setValue(currCustomerInfo.getName());
				
				newRow.getCell("groupID").setValue(null);
				newRow.getCell("groupNumber").setValue("");
				newRow.getCell("groupName").setValue("总量");
				
				newRow.getCell("material").setValue(null);
				newRow.getCell("materialNumber").setValue("");
				newRow.getCell("materialName").setValue("");
				
				// 统计客户所有物料合计值
				BigDecimal orderDSAmount = new BigDecimal("0");
				BigDecimal saleBaseQty = new BigDecimal("0");
				BigDecimal saleAmount = new BigDecimal("0");
				BigDecimal discountSaleQty = new BigDecimal("0");
				BigDecimal adjustAmount = new BigDecimal("0");
				
				BigDecimal recordAllAmount = new BigDecimal("0");
				for(int j = 0; j < customerMaterialDSInfos.size(); j++){
					CustomerMaterialDSInfo cMaterialDSInfo = customerMaterialDSInfos.get(j);
					orderDSAmount = orderDSAmount.add(cMaterialDSInfo.getSaleOrderDiscountAmount() == null? new BigDecimal("0") : cMaterialDSInfo.getSaleOrderDiscountAmount());
					adjustAmount = adjustAmount.add(cMaterialDSInfo.getAdjustAmount() == null?  new BigDecimal("0") : cMaterialDSInfo.getAdjustAmount());
					
					saleBaseQty = saleBaseQty.add(cMaterialDSInfo.getSaleQty());
					saleAmount = saleAmount.add(cMaterialDSInfo.getSaleAmount());
					recordAllAmount = recordAllAmount.add(cMaterialDSInfo.getDisRecordAdustAmount() == null? new BigDecimal("0"): cMaterialDSInfo.getDisRecordAdustAmount());
					// 折扣销量
//					if(cMaterialDSInfo.getSaleOrderDiscountAmount() != null && 
//							cMaterialDSInfo.getSaleOrderDiscountAmount().compareTo(new BigDecimal(0)) != 0){
						discountSaleQty = discountSaleQty.add(cMaterialDSInfo.getSaleOrderDiscountQty());
						// 
//					}
					
					// 有记录
					if( j == 0  && StringUtils.isNotBlank(cMaterialDSInfo.getDisRecordNumber()) && cMaterialDSInfo.getDisRecordAdustAmount() != null){
						Color color = new Color(250,250,200);  
						
						newRow.getStyleAttributes().setBackground(color);
//						newRow.getCell("disRecordNumber").setValue(cMaterialDSInfo.getDisRecordNumber());
//						newRow.getCell("vision").setValue(cMaterialDSInfo.getDisRecordVision());
//						newRow.getCell("disRecordState").setValue(cMaterialDSInfo.getDisRecordStatus().getAlias());
//						newRow.getCell("adjustType").setValue(cMaterialDSInfo.getAdjustType());
//						newRow.getCell("adjustor").setValue(cMaterialDSInfo.getDisRecordCreator().getName());
//						newRow.getCell("disRecordCreateTime").setValue(cMaterialDSInfo.getDisRecordCreateTime());
//						newRow.getCell("disRecordBizdate").setValue(cMaterialDSInfo.getDisRecordBizdate());
						
						
//						newRow.getCell("disRecordID").setValue(cMaterialDSInfo.getDisRecordID());
//						newRow.getCell("disRecordEntryID").setValue(cMaterialDSInfo.getDisRecordEntryID());
					}
					
				}
				
				
				
				
				newRow.getCell("orderDSAmount").setValue(orderDSAmount);
				newRow.getCell("adjustAmount").setValue(adjustAmount);
				BigDecimal confirmAmount = orderDSAmount.add(adjustAmount);
				newRow.getCell("confirmAmount").setValue(confirmAmount);
				
				discountSaleQty = discountSaleQty.divide(new BigDecimal("1000"),4,RoundingMode.HALF_UP);
				newRow.getCell("discountSaleQty").setValue(discountSaleQty);
				saleBaseQty = saleBaseQty.divide(new BigDecimal("1000"),4,RoundingMode.HALF_UP);
				newRow.getCell("saleBaseQty").setValue(saleBaseQty);
				newRow.getCell("saleAmount").setValue(saleAmount);
				
				newRow.getCell("disRecordAmount").setValue(recordAllAmount);
				
			}
		}
	}
	/**
	 * 调整金额编辑事件
	 */
	@Override
	protected void kDTable1_editStopped(KDTEditEvent e) throws Exception {
		// 金额调整时 将调整金额添加到 确认金额中
		
		int rowIndex = e.getRowIndex();
		int colIndex = e.getColIndex();
		
		if(colIndex == this.kDTable1.getColumnIndex("confirmAmount")){
			Object confirm =  this.kDTable1.getCell(rowIndex, colIndex).getValue();
			BigDecimal confirmAmount = new BigDecimal("0");
			if(confirm instanceof BigDecimal){
				confirmAmount = (BigDecimal) confirm;
			}else{
				try{
					confirmAmount = new BigDecimal((String)confirm);
					this.kDTable1.getCell(rowIndex, colIndex).getStyleAttributes().setBackground(null);
				}catch(Exception ex){
					MsgBox.showInfo("确认金额输入不合法");
					this.kDTable1.getCell(rowIndex, colIndex).getStyleAttributes().setBackground(Color.RED);
					return;
				}
			}
			
			// 金额不为0 则  同步更新掉 总金额和   选中
			if(confirmAmount != null && confirmAmount.compareTo(new BigDecimal("0")) != 0){
				BigDecimal orderDSAmount = (BigDecimal) this.kDTable1.getCell(rowIndex, "orderDSAmount").getValue();
				orderDSAmount = (orderDSAmount == null ? new BigDecimal("0"):orderDSAmount);
				BigDecimal adjustAmount = confirmAmount.subtract(orderDSAmount);
//				adjustAmount
				this.kDTable1.getCell(rowIndex, "adjustAmount").setValue(adjustAmount);
				// 勾选 
				this.kDTable1.getCell(rowIndex, "selected").setValue(Boolean.TRUE);
				
				
				
			}
			
		}
	}
	/**
	 * 合计方式变化后处理
	 */
	@Override
	protected void cbAdjustType_actionPerformed(ActionEvent e) throws Exception {
		EnumItem adjustTypeEnum = (EnumItem) this.cbAdjustType.getSelectedItem();
		if("产品".equals(adjustTypeEnum.getDisplayValue())){
			this.rbByAllQty.setEnabled(false);
			this.rbByDiscountQty.setEnabled(false);
		}else{
			this.rbByAllQty.setEnabled(true);
			this.rbByDiscountQty.setEnabled(true);
		}
		// 按照 查询头
		Date beginTime = this.dpBeginTime.getSqlDate();
		Date endTime = this.dpEndTime.getSqlDate();
		if(beginTime == null || endTime == null){
			
			SysUtil.abort();
		}
		
		DiscountTypeEnum dstype = (DiscountTypeEnum)this.cbDiscountType.getSelectedItem();
		if(dstype == null){
			
			SysUtil.abort();
		}
		CompanyOrgUnitInfo currCompanyInfo = SysContext.getSysContext().getCurrentFIUnit();
		if(currCompanyInfo == null){
			
			SysUtil.abort();
		}else if(beginTime.equals(this.displayDataBeginDate) &&
					endTime.equals(this.displayDataEndDate) && 
					dstype.equals(this.displayDataDSType) && 
					currCompanyInfo.equals(this.displayDataCompany) &&
					this.displayDataDiscountInfos != null && 
					this.displayDataDiscountInfos.size() > 0){
			// 展示查询结果
			if(this.displayDataDiscountInfos != null && this.displayDataDiscountInfos.size() > 0){
				displayDiscountInfos(this.displayDataDiscountInfos);
			}
			
		}
		
	}

	/**
	 * 提交 生成结算单
	 */
	public void confirm_actionPerformed(ActionEvent e) throws Exception {
		
		Date bizDate = this.dpBizDate.getSqlDate();
		if(bizDate == null){
			MsgBox.showInfo("还未设置结算单业务日期");
			this.dpBizDate.requestFocus();
			return;
		}
		
		PeriodInfo periodInfo = (PeriodInfo) this.prmtPeriod.getValue();
		if(periodInfo == null){
			MsgBox.showInfo("还未设置结算单期间");
			this.prmtPeriod.requestFocus();
			return;
		}
		
		DiscountTypeEnum dtEnum = (DiscountTypeEnum) this.cbDiscountType.getSelectedItem();
		if(dtEnum == null){
			MsgBox.showInfo("还未选择折让类型");
			this.cbDiscountType.requestFocus();
			return;
		}
		
		if(this.displayDataDiscountInfos == null || displayDataDiscountInfos.size() == 0){
			MsgBox.showInfo("没有可生成记录单的数据");
			return;
		}else{
			
			List<CustomerMaterialDSInfo> adjustDSInfos = new ArrayList<CustomerMaterialDSInfo>();
			
			IDiscountFacade discountFacade = DiscountFacadeFactory.getRemoteInstance();
			// 如果是按产品调整 则，直接按行 保存生成 折让记录单据，否则  按界面调节 拆分
			EnumItem adjustTypeEnum = (EnumItem) this.cbAdjustType.getSelectedItem();
			if("产品".equals(adjustTypeEnum.getDisplayValue())){
				
				
				boolean check = false;
				boolean isIgnoreSubmitReord = false;
				
				
				for(int i = 0; i < this.kDTable1.getRowCount(); i++){
					Boolean selected = (Boolean) this.kDTable1.getCell(i, "selected").getValue();
					if(!selected) continue;
					String recordState = (String) this.kDTable1.getCell(i, "disRecordState").getValue();
					if(StringUtils.isNotBlank(recordState)){
						
						String disRecordBillID = (String)this.kDTable1.getCell(i, "disRecordID").getValue();
						boolean isExistDestBill = discountFacade.isExistDestBill(disRecordBillID, "BB4F0454");
						String disRecordBillNumber = (String)this.kDTable1.getCell(i, "disRecordNumber").getValue();
						if(StringUtils.isNotBlank(disRecordBillID) &&  isExistDestBill){
							MsgBox.showInfo("记录单" + disRecordBillNumber + "已生成下游单据，不能修改。请处理掉下游单据后再进行操作。");
							return;
						}else if(("审核".equals(recordState)  || "新增".equals(recordState) || "保存".equals(recordState) || "提交".equals(recordState)) && !check){
							
							if(MsgBox.showConfirm2("是否覆盖已生成的记录单？") != MsgBox.OK){
								check = true;
								isIgnoreSubmitReord = true;
								return;
							}else{
								check = true;
								isIgnoreSubmitReord = false;
								// ok了的话  则跳过当前数据
	//							continue;
							}
						}else if(isIgnoreSubmitReord){
							continue;
						}
					}
					
					Object adjustValue = this.kDTable1.getCell(i, "adjustAmount").getValue();
					BigDecimal adjustAmount = new BigDecimal("0");
					if(adjustValue instanceof String){
						try{
							adjustAmount = new BigDecimal((String) adjustValue);
						}catch(Exception ex){
							MsgBox.showInfo("第" +(i + 1) + "行分录调整金额录入数据不对，不能计算" );
							return;
						}
					}else{
						adjustAmount = (BigDecimal)adjustValue;
					}
//					BigDecimal adjustAmount = (BigDecimal) this.kDTable1.getCell(i, "adjustAmount").getValue();
					// 有调整金额的才进行调整
					if(adjustAmount != null && adjustAmount.compareTo(new BigDecimal("0")) != 0){
						CustomerInfo currCustomerInfo = (CustomerInfo) this.kDTable1.getCell(i, "customer").getValue();
						
						MaterialInfo currMaterialInfo = (MaterialInfo) this.kDTable1.getCell(i, "material").getValue();
						
						String disRecordBillID = (String)this.kDTable1.getCell(i, "disRecordID").getValue();
//						String disRecordEntryID = (String)this.kDTable1.getCell(i, "disRecordEntryID").getValue();
						if(currCustomerInfo != null && currMaterialInfo != null){
							
							if(DiscountTypeEnum.FenXiao.equals(dtEnum)){
								String parentID = DiscountFacadeFactory.getRemoteInstance().getParentCustomer(currCustomerInfo.getId().toString());
								if(StringUtils.isBlank(parentID)){
									MsgBox.showInfo("客户" + currCustomerInfo.getName() + "没有维护上级客户，不能生成对应记录单");
									return;
								}else{
									currCustomerInfo = CustomerFactory.getRemoteInstance().getCustomerInfo(new ObjectUuidPK(parentID));
								}
							}
							
							CustomerMaterialDSInfo cmDSInfo = new CustomerMaterialDSInfo();
							cmDSInfo.setAdjustAmount(adjustAmount);
							cmDSInfo.setCustomerInfo(currCustomerInfo);
							cmDSInfo.setMaterialInfo(currMaterialInfo);
							
							cmDSInfo.setPeriod((PeriodInfo)this.prmtPeriod.getValue());
							cmDSInfo.setAdjustType("产品");
							if(StringUtils.isNotBlank(disRecordBillID)){
								int version = (Integer)this.kDTable1.getCell(i, "vision").getValue();
								cmDSInfo.setDisRecordVision(version);
								cmDSInfo.setDisRecordID(disRecordBillID);
							}
							
							adjustDSInfos.add(cmDSInfo);
							
						}
					}
				}
			}else if("总量".equals(adjustTypeEnum.getDisplayValue())){
				boolean check = false;            
				boolean isIgnoreSubmitReord = true;   // 默认跳过已生成的 记录
				
				for(int i = 0; i < this.kDTable1.getRowCount(); i++){
					Boolean selected = (Boolean) this.kDTable1.getCell(i, "selected").getValue();
					if(!selected) continue;
					
					
					
					
					
					
					
					Object adjustValue = this.kDTable1.getCell(i, "adjustAmount").getValue();
					BigDecimal adjustAmount = new BigDecimal("0");
					if(adjustValue instanceof String){
						try{
							adjustAmount = new BigDecimal((String) adjustValue);
						}catch(Exception ex){
							MsgBox.showInfo("第" +(i + 1) + "行分录调整金额录入数据不对，不能计算" );
							return;
						}
					}else{
						adjustAmount = (BigDecimal) adjustValue;
					}
//					BigDecimal adjustAmount = (BigDecimal) this.kDTable1.getCell(i, "adjustAmount").getValue();
					// 有调整金额的才进行调整
					if(adjustAmount != null && adjustAmount.compareTo(new BigDecimal("0")) != 0){
						CustomerInfo currCustomerInfo = (CustomerInfo) this.kDTable1.getCell(i, "customer").getValue();
						
						
						
//						String disRecordBillID = (String)this.kDTable1.getCell(i, "disRecordID").getValue();
						CustomerDiscountInfo currCusDISInfo = displayDataDiscountInfos.get(currCustomerInfo);
						// 是否按折让销量分摊
						boolean byDisSaleQty = this.rbByDiscountQty.isSelected();
						
						if(currCusDISInfo != null){
							
							// 已分摊 金额
							BigDecimal ftAdjustAmount = new BigDecimal("0");
							
							BigDecimal discountSaleQty = currCusDISInfo.getDiscountSaleQty();
							
							BigDecimal allSaleQty = currCusDISInfo.getAllSaleQty();
							// 折让销量或者总销量为0 则 不计算
							if(allSaleQty == null || allSaleQty.compareTo(new BigDecimal("0")) == 0 ){
								continue;
							}
							List<CustomerMaterialDSInfo> currCusMatDSInfos = currCusDISInfo.getMaterialDiscountInfos();
							// 当前客户的需要保存的  折让记录列表
							List<CustomerMaterialDSInfo> newDisRedords = new ArrayList<CustomerMaterialDSInfo>();
							for(int j = 0; j < currCusMatDSInfos.size(); j++){
								CustomerMaterialDSInfo cusMatDSInfo = currCusMatDSInfos.get(j);
								
								String recordState = cusMatDSInfo.getDisRecordStatus() == null?"":cusMatDSInfo.getDisRecordStatus().getAlias();
								String disRecordBillID = cusMatDSInfo.getDisRecordID();
								if(StringUtils.isNotBlank(recordState) && StringUtils.isNotBlank(disRecordBillID)){
									
									boolean isExistDestBill = discountFacade.isExistDestBill(disRecordBillID, "BB4F0454");
									if(StringUtils.isNotBlank(disRecordBillID) &&  isExistDestBill){
										MsgBox.showInfo("记录单" + (cusMatDSInfo.getDisRecordNumber()) + "已生成下游单据，不能修改。请处理掉下游单据后再进行操作。");
										return;
									}else if(("审核".equals(recordState)  || "新增".equals(recordState) || "保存".equals(recordState) || "提交".equals(recordState))  && !check){
										
										if(MsgBox.showConfirm2("是否覆盖已生成的记录单？") != MsgBox.OK){
											check = true;
											isIgnoreSubmitReord = true;
											return;
										}else{
											check = true;
											isIgnoreSubmitReord = false;
											// ok了的话  则跳过当前数据
				//							continue;
										}
									}
									if(isIgnoreSubmitReord){
										continue;
									}
								}
								
								
								// 按折让销量的话，如果没有 折让销量则不计算
								if(byDisSaleQty){
									
									// 折让销量或者总销量为0 则 不计算
									if(discountSaleQty == null || discountSaleQty.compareTo(new BigDecimal("0")) == 0 ){
										
										if(MsgBox.showConfirm2("第" +(i+1) +"行数据已提销量为空，不能按已有折扣销量分配，是否继续执行？") == MsgBox.OK){
											continue;
										}else{
											return;
										}
									}
									String adjustType = "总量_已提";
									
									BigDecimal disAmount = cusMatDSInfo.getSaleOrderDiscountAmount();
//									if(disAmount == null || disAmount.compareTo(new BigDecimal("0")) == 0){
////										continue;
//									}else{
										BigDecimal saleOrderDiscountQty = cusMatDSInfo.getSaleOrderDiscountQty();
										if(saleOrderDiscountQty == null ) saleOrderDiscountQty = new BigDecimal("0");
////											continue;
//										}else{
											// 按比例 分摊到分录中
											BigDecimal currAdjustAmount = adjustAmount.multiply(saleOrderDiscountQty).divide(discountSaleQty,2,RoundingMode.HALF_UP);
											ftAdjustAmount = ftAdjustAmount.add(currAdjustAmount);
											if(DiscountTypeEnum.FenXiao.equals(dtEnum)){
												String parentID = DiscountFacadeFactory.getRemoteInstance().getParentCustomer(currCustomerInfo.getId().toString());
												if(StringUtils.isBlank(parentID)){
													MsgBox.showInfo("客户" + currCustomerInfo.getName() + "没有维护上级客户，不能生成对应记录单");
													return;
												}else{
													currCustomerInfo = CustomerFactory.getRemoteInstance().getCustomerInfo(new ObjectUuidPK(parentID));
												}
											}
											CustomerMaterialDSInfo cmDSInfo = new CustomerMaterialDSInfo();
											cmDSInfo.setAdjustAmount(currAdjustAmount);
											cmDSInfo.setCustomerInfo(currCustomerInfo);
											cmDSInfo.setMaterialInfo(cusMatDSInfo.getMaterialInfo());
											cmDSInfo.setPeriod((PeriodInfo)this.prmtPeriod.getValue());
											cmDSInfo.setAdjustType("总量_已提");
											if(StringUtils.isNotBlank(cusMatDSInfo.getDisRecordID())){
												Integer version = cusMatDSInfo.getDisRecordVision();
												cmDSInfo.setDisRecordVision(version);
												cmDSInfo.setDisRecordID(cusMatDSInfo.getDisRecordID());
											}
											
											adjustDSInfos.add(cmDSInfo); 
											// 
											
//										}
									
									
									
								}else{
									BigDecimal saleQty = cusMatDSInfo.getSaleQty();
									if(saleQty == null || saleQty.compareTo(new BigDecimal("0")) == 0){
//										continue;
									}else{
										// 按比例 分摊到分录中
										BigDecimal currAdjustAmount = adjustAmount.multiply(saleQty).divide(allSaleQty,2,RoundingMode.HALF_UP);
										ftAdjustAmount = ftAdjustAmount.add(currAdjustAmount);
										if(DiscountTypeEnum.FenXiao.equals(dtEnum)){
											String parentID = DiscountFacadeFactory.getRemoteInstance().getParentCustomer(currCustomerInfo.getId().toString());
											if(StringUtils.isBlank(parentID)){
												MsgBox.showInfo("客户" + currCustomerInfo.getName() + "没有维护上级客户，不能生成对应记录单");
												return;
											}else{
												currCustomerInfo = CustomerFactory.getRemoteInstance().getCustomerInfo(new ObjectUuidPK(parentID));
											}
										}
										CustomerMaterialDSInfo cmDSInfo = new CustomerMaterialDSInfo();
										cmDSInfo.setAdjustAmount(currAdjustAmount);
										cmDSInfo.setCustomerInfo(currCustomerInfo);
										cmDSInfo.setMaterialInfo(cusMatDSInfo.getMaterialInfo());
										cmDSInfo.setPeriod((PeriodInfo)this.prmtPeriod.getValue());
										cmDSInfo.setAdjustType("总量_总量");
										if(StringUtils.isNotBlank(cusMatDSInfo.getDisRecordID())){
											Integer version = cusMatDSInfo.getDisRecordVision();
											cmDSInfo.setDisRecordVision(version);
											cmDSInfo.setDisRecordID(cusMatDSInfo.getDisRecordID());
										}
										adjustDSInfos.add(cmDSInfo); 
										// 
										
									}
								}
								
								// 最后一条的时候 如果 分摊的 折让数 有尾差 则 全部累加到最后一条分录上
								if(j == currCusMatDSInfos.size() - 1 && ftAdjustAmount.compareTo(adjustAmount) != 0){
									BigDecimal ftTailAdjust = adjustAmount.subtract(ftAdjustAmount);
									if(adjustDSInfos.size() > 0){
										CustomerMaterialDSInfo tailDSInfo = adjustDSInfos.get(adjustDSInfos.size() -1);
										tailDSInfo.setAdjustAmount(tailDSInfo.getAdjustAmount().add(ftTailAdjust));
									}
								}
								// 添加到总结果中
//								adjustDSInfos.addAll(currCusMatDSInfos);
								
							}
							
						}
						
					}
				}
			}
			
			// 保存
			if(adjustDSInfos.size() > 0){
				CompanyOrgUnitInfo currCompany = SysContext.getSysContext().getCurrentFIUnit();
			
				String adjustType = (String) this.dbAdjustType.getSelectedItem();
				if(StringUtils.isBlank(adjustType)){
					adjustType = "调整生成";
				}
				// 保存数据
				ResultInfo result = discountFacade.addDiscountRecords(currCompany, this.displayDataDSType.getValue(), bizDate, adjustDSInfos,adjustType);
				if(result.isSuccess()){
					MsgBox.showInfo("生成完成");
					search_actionPerformed(null);
					return;
				}else{
					MsgBox.showInfo(result.getMessage());
					return;
				}
			}else{
				MsgBox.showInfo("没有符合条件的数据");
				return;
			}
			
			
//			adjustDSInfos
			
		}
		
		
	}

	/**
	 * 根据 开始日期更新 查询条件中的 期间
	 */
	protected void dpBeginTime_dataChanged(DataChangeEvent e) throws Exception {
		
		Date beginDate = this.dpBeginTime.getSqlDate();
		if(beginDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(beginDate);
			int year = cal.get(Calendar.YEAR);
			int period = cal.get(Calendar.MONTH);
			
			PeriodTypeInfo	type = new PeriodTypeInfo();
			type.setId(BOSUuid.read("JsOI2jUYRWCjgdHPsfrsDF9piaY="));
			PeriodInfo periodInfo = PeriodFactory.getRemoteInstance().getPeriodInfo(year, period + 1, type);
			
			if(periodInfo != null){
				this.prmtPeriod.setValue(periodInfo);
			}
		}
	}

	


    
}