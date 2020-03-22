package com.kingdee.eas.scm.sd.sale.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.form.SqlExecutorFacade;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import com.kingdee.eas.basedata.scm.sd.sale.client.PricePolicyCache;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.scm.common.client.SCMGroupClientUtils;
import com.kingdee.eas.scm.common.client.helper.SaleUiHandlingHelper;
import com.kingdee.eas.scm.common.loadmass.SaleOrderDataVO;
import com.kingdee.eas.scm.sd.sale.SaleInvBizException;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

public class SaleOrderEditUIPIEx extends SaleOrderEditUI {
	//
	//
	//	LinkedHashSet materialsID;
	//	HashMap payMap=new HashMap();
	//	public String cuid="";
	//	boolean isYhl=false;
	//	boolean isXszr=false;
	//
	//	boolean isAllInPay=false;
	//	boolean isCustom002=false;//参数控制 是否启用开票价格
	//	boolean isCustom003=false;//参数控制 是否启用一体化合同拉料量控制
	//	BigDecimal slQty=new BigDecimal("0");
	//	BigDecimal unslQty=new BigDecimal("0");
	//	PeriodInfo currPeriod=null;
	//	PeriodInfo currDisPeriod=null;
	//	String currPeriodId="";
	//	String currDisPeriodId="";
	//	String customerId="";
	//	String customerBId="";
	//
	//	// 当前客户的应收余额信息
	//	private CustomerCreditBean customerCreditInfo;
	//	// 折让公司
	//	private DiscountCompanyInfo discountCompanyInfo;
	//
	//	// 折让计算记录 
	//	private List discountLogs;
	//	// 是否启用新希望折让处理
	//	private boolean isEnableXXWDiscount;
	//	// private boolean  是否校验客户余额    余额=应收余额+已开票未收款余额
	//	private boolean isCheckCustomerBalance;
	//	// 是否校验物料库存   
	//	private boolean isCheckMaterialInventory;
	//	// 有效的订单分录ID   格式为 'akldshfakjdshf','adkjfhajdskhfk','asdjfhjdsajkf'
	//	private String valieOrderEntryIDs;
	//	// 订单物料数量暂存，在订单提交校验库存时 用来 暂存物料数量，对于分录中包含多行相同物料，累加数量后校验库存
	//	private Map<String,BigDecimal> entryMaterialQtys;
	//	// 业务日期暂存
	//	private Date bizDate;
	//
	//
	public SaleOrderEditUIPIEx() throws Exception {
		super();
		//		this.setCuid(SysContext.getSysContext().getCurrentStorageUnit().getId().toString());
	}
	//
	//	@Override
	//	public void onLoad() throws Exception {
	//		// TODO Auto-generated method stub
	//		super.onLoad();
	//		((KDFormattedTextField)kdtEntries.getColumn("lossQty").getEditor().getComponent()).setPrecision(0);
	//		((KDFormattedTextField)kdtEntries.getColumn("supplementQty").getEditor().getComponent()).setPrecision(0);
	//		((KDFormattedTextField)kdtEntries.getColumn("issueQty").getEditor().getComponent()).setPrecision(8);
	//	}
	//
	//	@Override
	//	protected void prmtOrderCustomer_dataChanged(DataChangeEvent e)
	//	throws Exception {
	//		// TODO Auto-generated method stub
	//		super.prmtOrderCustomer_dataChanged(e);
	//		if(e.getNewValue()==null)
	//			return;
	//		cuid=SysContext.getSysContext().getCurrentStorageUnit().getId().toString();
	//		//销售员数量大于1提示
	//		StringBuffer sql = new StringBuffer();
	//		sql.append(" select t2.fpersonid  from T_BD_CustomerSaleInfo t1 ");
	//		sql.append(" inner join T_BD_CustomerSaler t2 on t2.fcustomersaleid=t1.fid ");
	//		sql.append(" where t1.fcontrolunitid='"+cuid+"'");
	//		sql.append(" and fcustomerid='"+((PropertyContainer) e.getNewValue()).getString("id")+"'");
	//		sql.append(" ");
	//
	//		this.kdtEntries.removeRows();
	//		//		IRowSet rs = com.kingdee.eas.custom.xszr.CalUtilFacadeFactory.getRemoteInstance().getSqlData(sql.toString());
	//		//		if(rs.size()>1) {//业务员大于1个选着画面
	//		//			List list=new ArrayList();
	//		//			while(rs.next()) {
	//		//				String personId=rs.getString("fpersonid");
	//		//				list.add(personId);		
	//		//			}
	//		//			UIContext uiContext = new UIContext(this);
	//		//			uiContext.put("personIdList", list);
	//		//			IUIFactory uiFactory = UIFactory.createUIFactory(UIFactoryName.MODEL);
	//		//			IUIWindow window = uiFactory.create("com.kingdee.eas.custom.xszr.client.SalePersonUI", uiContext, null);
	//		//			window.show();
	//		//			PersonInfo personInfo=(PersonInfo) window.getUIObject().getUIContext().get("personInfo");
	//		//			SaleGroupInfo saleGroupInfo=(SaleGroupInfo) window.getUIObject().getUIContext().get("saleGroupInfo");
	//		//			this.prmtSaleGroup.setValue(saleGroupInfo);
	//		//		    this.prmtSalePerson.setValue(personInfo);
	//		//		}
	//	}
	//
	//	/**
	//	 * 获得 vo
	//	 */
	//	public SCMBizDataVO getSCMBizDataVO() {
	//		return super.getSCMBizDataVO();
	//	}
	//
	//
	//	/**
	//	 * 获得 默认 主要业务组织
	//	 */
	//	public  OrgUnitInfo getNowDefaultMainBizOrg() {
	//		return super.getDefaultMainBizOrg();
	//	}
	//
	//	/**
	//	 * getDefaultDelegatedOrg
	//	 */
	//	@Override
	//	public OrgUnitInfo getDefaultDelegatedOrg(OrgType orgType)
	//	throws EASBizException, BOSException, UuidException {
	//		return super.getDefaultDelegatedOrg(orgType);
	//	}
	//	/**
	//	 * 初始化时 获得 参数设置   
	//	 */
	//	public void loadFields() {
	//		try {
	//			//			this.removeListenerCustom();
	//
	//			super.loadFields();
	//
	//
	//			String cuid = SysContext.getSysContext().getCurrentCtrlUnit().getId().toString();
	//
	//			boolean isEnableXXWDiscount = DiscountFacadeFactory.getRemoteInstance().isEnableDiscount(cuid);
	//			setEnableXXWDiscount(isEnableXXWDiscount);
	//			// 编辑状态 删除bizdate 事件监听
	//			removeAllBizDateListener();
	//
	//			//			addListenerCustom();
	//		} catch (Exception e) {
	//			// TODO Auto-generated catch block
	//			this.handleException(e);
	//		}
	//	}
	//	
	//	@Override
	//	public void onShow() throws Exception {
	//		// TODO Auto-generated method stub
	//		super.onShow();
	//		setDetailTableColumnVisible();
	//	}
	//
	//	@Override
	//	protected void prmtSaleOrgUnit_dataChanged(DataChangeEvent e)
	//			throws Exception {
	//		// TODO Auto-generated method stub
	//		super.prmtSaleOrgUnit_dataChanged(e);
	//		setDetailTableColumnVisible();
	//	}
	//
	//	/**
	//	 * 设置分录不分裂的可见性
	//	 */
	//	protected void setDetailTableColumnVisible() {
	//		// TODO Auto-generated method stub
	//		SaleOrgUnitInfo saleOrgUnit=null;;
	//		if(prmtSaleOrgUnit.getValue()!=null){
	//			try {
	//				saleOrgUnit = SaleOrgUnitFactory.getRemoteInstance().getSaleOrgUnitInfo(new ObjectUuidPK(((IPropertyContainer)prmtSaleOrgUnit.getValue()).getString("id")));
	//			} catch (EASBizException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			} catch (BOSException e) {
	//
	//			
	//			
	//			}
	//		}
	//		if(prmtSaleOrgUnit.getValue()==null||saleOrgUnit.getLongNumber().indexOf("0!2")!=0){
	//			getDetailTable().getColumn("lossQty").getStyleAttributes().setHided(true);
	//			getDetailTable().getColumn("supplementQty").getStyleAttributes().setHided(true);
	//			getDetailTable().getColumn("issueQty").getStyleAttributes().setHided(true);
	//			getDetailTable().getColumn("sendAddress").getStyleAttributes().setHided(true);
	//		}else{
	//			getDetailTable().getColumn("lossQty").getStyleAttributes().setHided(false);
	//			getDetailTable().getColumn("supplementQty").getStyleAttributes().setHided(false);
	//			getDetailTable().getColumn("issueQty").getStyleAttributes().setHided(false);
	//			getDetailTable().getColumn("sendAddress").getStyleAttributes().setHided(false);
	//		}
	//	}
	//
	//	/**
	//	 * 删除业务日期上的监听
	//	 */
	//	private void  removeAllBizDateListener(){
	//		if(OprtState.VIEW.equals(this.getOprtState()) || OprtState.EDIT.equals(this.getOprtState())){
	//			Date bizDate = this.pkBizDate.getSqlDate();
	//
	//			this.pkBizDate = new KDDatePicker();
	//			this.pkBizDate.setValue(bizDate);
	//			this.pkBizDate.setName("pkBizDate");
	//			this.contOrderDate.setBoundEditor(this.pkBizDate);
	//			this.dataBinder.registerBinding("bizDate", Date.class, this.pkBizDate, "value");
	//			//			pkBizDateChangeListener = null;
	//			//			this.pkBizDate.removeDataChangeListener(this.pkBizDateChangeListener);
	//			//			DataChangeListener[] dls = this.pkBizDate.getListeners(DataChangeListener.class);
	//			//			for(int i= 0; i < dls.length; i++){
	//			//				this.pkBizDate.removeDataChangeListener(dls[i]);
	//			//			}
	//
	//
	//		}
	//		// 如果当期公司启用了 折让处理。则 新增时  也删除业务日期上的监听
	//		else if(this.isEnableXXWDiscount()){
	//			Date bizDate = this.pkBizDate.getSqlDate();
	//
	//			this.pkBizDate = new KDDatePicker();
	//			this.pkBizDate.setValue(bizDate);
	//			this.pkBizDate.setName("pkBizDate");
	//			this.contOrderDate.setBoundEditor(this.pkBizDate);
	//			this.dataBinder.registerBinding("bizDate", Date.class, this.pkBizDate, "value");
	//		}
	//
	//		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
	//
	//			public void dataChanged(DataChangeEvent e) {
	//				// TODO Auto-generated method stub
	//				Date newBizDate = (Date) e.getNewValue();
	//				//				if(newBizDate != null){
	//				SaleOrderEditUIPIEx.this.setBizDate(newBizDate);
	//				//				}
	//			}	
	//		});
	//	}
	//
	//
	//	/**
	//	 * 保存日志记录
	//	 */
	//	public void afterAction(BatchActionEnum bizAction,
	//			BatchSelectionEntries arg1, int arg2) {
	//		super.afterAction(bizAction, arg1, arg2);
	//		if(bizAction.equals(BatchActionEnum.SAVE)){
	//			try {
	//				// 保存 折让数据
	//				if(isEnableXXWDiscount()){
	//					saveDiscountGridLogInfos(this.editData,this.getDiscountLogs());
	//				}
	//			}catch(Exception e){
	//				e.printStackTrace();
	//			}
	//		}else if(bizAction.equals(BatchActionEnum.SUBMIT)){
	//			try {
	//				// 保存折让数据
	//				// 保存 折让数据
	//				if(isEnableXXWDiscount()){
	//					saveDiscountGridLogInfos(this.editData,this.getDiscountLogs());
	//				}
	//				//				if(this.isXszr==true){
	//				//        			useAmount();
	//				//        		}
	//				//				if(this.isCustom003==true){
	//				//					this.updateContractSlQty();
	//				//				}
	//				// 编辑状态 删除bizdate 事件监听
	//				//removeAllBizDateListener();
	//
	//
	//				refreshCurPage();
	//				setSave(true);
	//				setSaved(true);
	//				//setOprtState(OprtState.VIEW);
	//				btnPre.setEnabled(true);
	//				btnFirst.setEnabled(true);
	//				//addSaleOrderChange();
	//				//addSaleOderListener2();
	//				//loadSendAddress();
	//				//setSave(true);
	//				//setSaved(true);
	//				// showMessageForStatus();
	//				//showSaveSuccess();
	//				//uiHelper.initInLoadFields(prepareVoForLoadData());
	//				//nodeList.distributeInitialize();
	//				//btnAudit.setVisible(false);
	//
	//			} catch (EASBizException e) {
	//
	//				e.printStackTrace();
	//			} catch (BOSException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			} catch (Exception e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		}else if(bizAction.equals(BatchActionEnum.AUDIT)){
	//			try {
	//				menuItemRevoke.setEnabled(false);
	//				btnRevoke.setEnabled(false);
	//				actionRevoke.setEnabled(false);
	//				menuItemAudit.setEnabled(false);
	//				btnAudit.setEnabled(false);
	//				actionAudit.setEnabled(false);
	//				menuItemUnFreezed.setEnabled(false);
	//				btnUnfreezed.setEnabled(false);
	//				ActionUnfreezed.setEnabled(false);
	//				menuItemUnAudit.setEnabled(true);
	//				btnUnAudit.setEnabled(true);
	//				actionUnAudit.setEnabled(true);
	//				menuItemFreezed.setEnabled(true);
	//				btnFreezed.setEnabled(true);
	//				ActionFreezed.setEnabled(true);
	//				menuItemClose.setEnabled(true);
	//				btnClose.setEnabled(true);
	//				actionClose.setEnabled(true);
	//				setUnAuditStatus(true);
	//				setOprtState(OprtState.VIEW);
	//				refreshCurPage();
	//			} catch (EASBizException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			} catch (BOSException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			} catch (Exception e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		}
	//		//super.afterAction(bizAction, arg1, arg2);
	//	}
	//	/**
	//	 * 保存折让日志 
	//	 * @param editData
	//	 * @param discountLogs2
	//	 * @throws BOSException 
	//	 * @throws EASBizException 
	//	 */
	//	private void saveDiscountGridLogInfos(SaleOrderInfo editData,
	//			List discountLogs) throws EASBizException, BOSException {
	//		// 设置日志相关信息，然后保存
	//		if(discountLogs != null && discountLogs.size() >0 && editData != null && editData.getEntries() != null && editData.size() > 0){
	//			SaleOrderEntryCollection orderEntrys = editData.getEntries();
	//			// 生成日志单据
	//			DiscountGridLogInfo logInfo  = new DiscountGridLogInfo();
	//			logInfo.setOrderNumber(editData.getNumber());
	//			logInfo.setSaleOrder(editData);
	//			if(editData.getObjectValue("customerb") != null){
	//				CustomerInfo parentCustomer = (CustomerInfo) editData.getObjectValue("customerb");
	//				logInfo.setParentCustomerID(parentCustomer.getId().toString());
	//			}
	//			if(editData.getOrderCustomer() != null){
	//				logInfo.setCustomerID(editData.getOrderCustomer().getId().toString());
	//			}
	//			DiscountGridLogEntryCollection logEntrys = logInfo.getEntrys();
	//			if(logEntrys == null){
	//				logEntrys = new DiscountGridLogEntryCollection();
	//			}
	//
	//			// 将 订单分录id设置到log中  然后保存 logentry
	//			for(int i = 0; i < discountLogs.size(); i++){
	//				DiscountGridLogEntryInfo logEntryInfo = (DiscountGridLogEntryInfo) discountLogs.get(i);
	//				logEntryInfo.setOrderID(editData.getId().toString());
	//				int seq = logEntryInfo.getOrderEntrySeq();
	//				for(int j = 0; j < orderEntrys.size(); j++){
	//					SaleOrderEntryInfo orderEntryInfo = orderEntrys.get(j);
	//					if(orderEntryInfo != null && orderEntryInfo.getId() != null){
	//						if(seq == orderEntryInfo.getSeq()){
	//							logEntryInfo.setOrderEntryID(orderEntryInfo.getId().toString());
	//							break;
	//						}
	//					}
	//				}
	//
	//				logEntrys.add(logEntryInfo);
	//			}
	//			DiscountFacadeFactory.getRemoteInstance().removeOrderDsgridLogs(editData.getId().toString());
	//			// 保存日志信息
	//			DiscountGridLogFactory.getRemoteInstance().save(logInfo);
	//		}
	//
	//	}
	//
	//
	//
	//
	//	/*********************************************************************************************************************/
	//	public LinkedHashSet getMaterialsID() {
	//		return materialsID;
	//	}
	//
	//	public void setMaterialsID(LinkedHashSet materialsID) {
	//		this.materialsID = materialsID;
	//	}
	//
	//	public HashMap getPayMap() {
	//		return payMap;
	//	}
	//
	//	public void setPayMap(HashMap payMap) {
	//		this.payMap = payMap;
	//	}
	//
	//	public String getCuid() {
	//		return cuid;
	//	}
	//
	//	public void setCuid(String cuid) {
	//		this.cuid = cuid;
	//	}
	//
	//	public boolean isYhl() {
	//		return isYhl;
	//	}
	//
	//	public void setYhl(boolean isYhl) {
	//		this.isYhl = isYhl;
	//	}
	//
	//	public boolean isXszr() {
	//		return isXszr;
	//	}
	//
	//	public void setXszr(boolean isXszr) {
	//		this.isXszr = isXszr;
	//	}
	//
	//	public boolean isAllInPay() {
	//		return isAllInPay;
	//	}
	//
	//	public void setAllInPay(boolean isAllInPay) {
	//		this.isAllInPay = isAllInPay;
	//	}
	//
	//	public boolean isCustom002() {
	//		return isCustom002;
	//	}
	//
	//	public void setCustom002(boolean isCustom002) {
	//		this.isCustom002 = isCustom002;
	//	}
	//
	//	public boolean isCustom003() {
	//		return isCustom003;
	//	}
	//
	//	public void setCustom003(boolean isCustom003) {
	//		this.isCustom003 = isCustom003;
	//	}
	//
	//	public BigDecimal getSlQty() {
	//		return slQty;
	//	}
	//
	//	public void setSlQty(BigDecimal slQty) {
	//		this.slQty = slQty;
	//	}
	//
	//	public BigDecimal getUnslQty() {
	//		return unslQty;
	//	}
	//
	//	public void setUnslQty(BigDecimal unslQty) {
	//		this.unslQty = unslQty;
	//	}
	//
	//	public PeriodInfo getCurrPeriod() {
	//		return currPeriod;
	//	}
	//
	//	public void setCurrPeriod(PeriodInfo currPeriod) {
	//		this.currPeriod = currPeriod;
	//	}
	//
	//	public PeriodInfo getCurrDisPeriod() {
	//		return currDisPeriod;
	//	}
	//
	//	public void setCurrDisPeriod(PeriodInfo currDisPeriod) {
	//		this.currDisPeriod = currDisPeriod;
	//	}
	//
	//	public String getCurrPeriodId() {
	//		return currPeriodId;
	//	}
	//
	//	public void setCurrPeriodId(String currPeriodId) {
	//		this.currPeriodId = currPeriodId;
	//	}
	//
	//	public String getCurrDisPeriodId() {
	//		return currDisPeriodId;
	//	}
	//
	//	public void setCurrDisPeriodId(String currDisPeriodId) {
	//		this.currDisPeriodId = currDisPeriodId;
	//	}
	//
	//	public String getCustomerId() {
	//		return customerId;
	//	}
	//
	//	public void setCustomerId(String customerId) {
	//		this.customerId = customerId;
	//	}
	//
	//	public String getCustomerBId() {
	//		return customerBId;
	//	}
	//
	//	public void setCustomerBId(String customerBId) {
	//		this.customerBId = customerBId;
	//	}
	//
	//	public CustomerCreditBean getCustomerCreditInfo() {
	//		return customerCreditInfo;
	//	}
	//
	//	public void setCustomerCreditInfo(CustomerCreditBean customerCreditInfo) {
	//		this.customerCreditInfo = customerCreditInfo;
	//	}
	//
	//	public DiscountCompanyInfo getDiscountCompanyInfo() {
	//		return discountCompanyInfo;
	//	}
	//
	//	public void setDiscountCompanyInfo(DiscountCompanyInfo discountCompanyInfo) {
	//		this.discountCompanyInfo = discountCompanyInfo;
	//	}
	//
	//	public List getDiscountLogs() {
	//		return discountLogs;
	//	}
	//
	//	public void setDiscountLogs(List discountLogs) {
	//		this.discountLogs = discountLogs;
	//	}
	//
	//	public boolean isEnableXXWDiscount() {
	//		return isEnableXXWDiscount;
	//	}
	//
	//	public void setEnableXXWDiscount(boolean isEnableXXWDiscount) {
	//		this.isEnableXXWDiscount = isEnableXXWDiscount;
	//	}
	//
	//	public boolean isCheckCustomerBalance() {
	//		return isCheckCustomerBalance;
	//	}
	//
	//	public void setCheckCustomerBalance(boolean isCheckCustomerBalance) {
	//		this.isCheckCustomerBalance = isCheckCustomerBalance;
	//	}
	//
	//	public boolean isCheckMaterialInventory() {
	//		return isCheckMaterialInventory;
	//	}
	//
	//	public void setCheckMaterialInventory(boolean isCheckMaterialInventory) {
	//		this.isCheckMaterialInventory = isCheckMaterialInventory;
	//	}
	//
	//	public String getValieOrderEntryIDs() {
	//		return valieOrderEntryIDs;
	//	}
	//
	//	public void setValieOrderEntryIDs(String valieOrderEntryIDs) {
	//		this.valieOrderEntryIDs = valieOrderEntryIDs;
	//	}
	//
	//	public Map<String, BigDecimal> getEntryMaterialQtys() {
	//		return entryMaterialQtys;
	//	}
	//
	//	public void setEntryMaterialQtys(Map<String, BigDecimal> entryMaterialQtys) {
	//		this.entryMaterialQtys = entryMaterialQtys;
	//	}
	//
	//	public Date getBizDate() {
	//		return bizDate;
	//	}
	//
	//	public void setBizDate(Date bizDate) {
	//		this.bizDate = bizDate;
	//	}
	//
	//	@Override
	//	protected void appendFootRow(KDTable arg0) {
	//		// TODO Auto-generated method stub
	//		super.appendFootRow(arg0);
	//	}
	//
	//	@Override
	//	protected void setTableToSumField() {
	//		// TODO Auto-generated method stub
	//		super.setTableToSumField();
	//	}
	//
	//	@Override
	//	protected String[] getSumColNames() {
	//		// TODO Auto-generated method stub
	//		String[] stdCols = super.getSumColNames();
	//		String[] depCols=new String[]{"lz","bag","addedValue","contributrionMargin","NoDSQty","NoDSAmount","LzAmount","SwDsQty","MonthDSAmount","YearDSAmount","FxDSAmount","SwDSamount","BaseAmount","NetSaleAmount","issueQty","supplementQty","lossQty"};
	//		ArrayList<String> colList=new ArrayList<String>();
	//		for(int i=0;i<stdCols.length;i++) {
	//			colList.add(stdCols[i]);
	//		}
	//		for(int i=0;i<depCols.length;i++) {
	//			colList.add(depCols[i]);
	//		}
	//		String[] cols=new String[colList.size()];
	//		for(int i=0;i<colList.size();i++) {
	//			cols[i]=colList.get(i);
	//		}
	//		return cols;
	//	}
	//

	@Override
	public void kdtEntries_Changed(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntries_Changed(e);

		String fieldName = this.kdtEntries.getColumnKey(e.getColIndex());	  
		calPremiumPrice(fieldName,e.getRowIndex());
	}
	private void setPolicyPrice(String fieldName,int rowIndex) {
		if(kdtEntries.getColumn("policyPrice")!=null&&kdtEntries.getColumn("premiumPrice")!=null) {
			kdtEntries.getCell(rowIndex, "policyPrice").setValue(UIRuleUtil.getBigDecimal(kdtEntries.getCell(rowIndex, "taxPrice").getValue()));
			kdtEntries.getCell(rowIndex, "premiumPrice").setValue(BigDecimal.ZERO);
		}
	}
	private void calPremiumPrice(String fieldName,int rowIndex) {
		if(kdtEntries.getColumn("policyPrice")!=null&&kdtEntries.getColumn("premiumPrice")!=null) {
			if(fieldName.toLowerCase().contains("price")||fieldName.toLowerCase().contains("qty")||fieldName.toLowerCase().contains("amount")){
				BigDecimal taxPice=UIRuleUtil.getBigDecimal(kdtEntries.getCell(rowIndex, "taxPrice").getValue());
				BigDecimal policyPrice=UIRuleUtil.getBigDecimal(kdtEntries.getCell(rowIndex, "policyPrice").getValue());
				policyPrice=taxPice.subtract(policyPrice);
				kdtEntries.getCell(rowIndex, "premiumPrice").setValue(policyPrice);
				if(policyPrice.signum()<0) {
					MsgBox.showWarning("第"+(rowIndex+1)+"行分录价格小于基本定价！");
				}
			}
		}
	}


	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		super.verifyInput(e);
		if(e.getActionCommand().endsWith("ActionSave")){
			return;
		}
		if(editData.get("licensePlateNum")!=null&&editData.getBizDate()!=null&&editData.getSaleOrgUnit()!=null){
			String carNum=(String) editData.get("licensePlateNum");	
			Boolean isHasSameCar=checckIsHasSameCar(carNum);
			if(isHasSameCar){
				if(MsgBox.showConfirm2("当前车辆在本公司两天内拉过货，请注意是否继续。")==MsgBox.YES){
					return;
				}else{
					SysUtil.abort();
				};
			}	
		} 
	}


	private Boolean checckIsHasSameCar(String carNum) {
		// TODO Auto-generated method stub
		Boolean isHasSameCar=false;
		String billID="X_X";
		if(editData.getId()!=null){
			billID=editData.getId().toString();
		}
		try {
		SaleOrgUnitInfo company=editData.getSaleOrgUnit();
		String companyID=company.getId().toString();
		CompanyOrgUnitInfo  companyInfo=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyID));
		char firstNum=companyInfo.getNumber().charAt(0);
		Date bizdate=editData.getBizDate();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer stf=new StringBuffer();
		stf.append("/*dialect*/select *  from T_SD_SaleOrder t1")
		.append(" inner join T_ORG_Sale t2 on t2.fid=t1.FSaleOrgUnitID")
		.append(" where t1.FBizDate>=to_date('").append(sdf.format(bizdate)).append("','yyyy-mm-dd')-2")
		.append(" and t1.FBizDate<=to_date('").append(sdf.format(bizdate)).append("','yyyy-mm-dd')+2")
		.append(" and t1.CFLicensePlateNum ='").append(carNum).append("'")
		.append(" and t2.fnumber like'").append(firstNum+"%").append("'")
		.append(" and t1.fid<>'").append(billID).append("'");

			IRowSet rs = SQLExecutorFactory.getRemoteInstance(stf.toString()).executeSQL();
			if(rs.next()){
				isHasSameCar=true;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return isHasSameCar;
	}

	@Override
	public void calEntryLocalAmount() throws SaleInvBizException {
		// TODO Auto-generated method stub
		super.calEntryLocalAmount();
	}
	@Override
	protected void doMaterialChanged(KDBizPromptBox bizMaterialBox, MaterialInfo[] materialInfos, int selectedRow,
			String materialFieldname) throws Exception {
		// TODO Auto-generated method stub
		super.doMaterialChanged(bizMaterialBox, materialInfos, selectedRow, materialFieldname);
		setPolicyPrice(materialFieldname,selectedRow);
		calPremiumPrice(materialFieldname,selectedRow);
	}

}
