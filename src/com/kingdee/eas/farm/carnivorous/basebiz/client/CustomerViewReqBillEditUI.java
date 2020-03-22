/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeInfo;
import com.kingdee.eas.farm.carnivorous.basedata.DateRelate;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class CustomerViewReqBillEditUI extends AbstractCustomerViewReqBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CustomerViewReqBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * output class constructor
	 */
	public CustomerViewReqBillEditUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
	}

	public void loadFields(){
		super.loadFields();
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.DELETED)){
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			this.actionEdit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
		initControl();
	}

	private void initControl() {
		// TODO Auto-generated method stub
		setFilter();
		this.prmtFICompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});


		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtfarm.setValue(null);
				if(prmtfarmer.getValue()!=null){
					String farmerID=null,farmID=null;
					DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarm);
					ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
					//						StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
					ListenerUtil.F7AddDateChangeListener(prmtfarm, listener);
					farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
					if(prmtfarm.getValue()!=null){
						farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
						//							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
					}	
				}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtbatchContract.setValue(null);
				if(prmtfarm.getValue()!=null){
					DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarmer);
					ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
					prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
					ListenerUtil.F7AddDateChangeListener(prmtfarmer, listener);
					String farmerID = null;
					if(prmtfarmer.getValue()!=null){
						String farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						//							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
					}
				}
				setFilter();
			}});

		this.prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});

		prmtbatchContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				try {
					prmtbatchContract_Changed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		
		/**
		 * 申请补雏数量添加监听事件
		 * @param contractID
		 */
		txtapplyGetBreed.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				txtauditGetBreed.setValue(UIRuleUtil.getBigDecimal(txtapplyGetBreed.getValue()));
				txtamount.setValue(UIRuleUtil.getBigDecimal(txtapplyGetBreed.getValue())
						.multiply(UIRuleUtil.getBigDecimal(txtbreedPrice.getValue())));
				txtauditAmt.setValue(UIRuleUtil.getBigDecimal(txtauditGetBreed.getValue())
						.multiply(UIRuleUtil.getBigDecimal(txtbreedPrice.getValue())));
			}
			
		});
		
		//审核补雏数量添加监听事件
		txtauditGetBreed.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				txtamount.setValue(UIRuleUtil.getBigDecimal(txtapplyGetBreed.getValue())
						.multiply(UIRuleUtil.getBigDecimal(txtbreedPrice.getValue())));
				txtauditAmt.setValue(UIRuleUtil.getBigDecimal(txtauditGetBreed.getValue())
						.multiply(UIRuleUtil.getBigDecimal(txtbreedPrice.getValue())));
			}
			
		});
		

		txtamount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				BigDecimal amount = UIRuleUtil.getBigDecimal(txtamount.getBigDecimalValue());
				txtauditAmt.setValue(amount);
			}
		});
	}

	@Override
	protected void BtnUpdateSettle_actionPerformed(ActionEvent e)throws Exception {
		btnUpdateSettle_actionPerformed(e);
	}

	/**
	 * 批次改变
	 */
	private void batch_changed(DataChangeEvent e) {
		if(e.getNewValue()!=null) {
			try {
				pkinDate.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "inDate"));
				txtbatchQty.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "femaleQty"));
			} catch (DataAccessException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (BOSException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}		
		}else{
			pkinDate.setValue(null);
			txtbatchQty.setValue(null);
		}
	}




	public void prmtbatchContract_Changed(DataChangeEvent e) throws Exception {
		this.prmtbatch.setValue(null);
		prmtperson.setValue(null);
		pkrecDate.setValue(null);
		txtrecQty.setValue(null);
		txtrecSuttle.setValue(null);
		txtfeedWgt.setValue(null);
		txtrecRate.setValue(null);
		txtfmRate.setValue(null);
		txtdrugAmt.setValue(null);
		txtsingleDrugAmt.setValue(null);
		txtoValue.setValue(null);
		txtcAverageWgt.setValue(null);
		txtdyFee.setValue(null);
		txtsingleDyFee.setValue(null);
		txtfeedDays.setValue(null);
		txtsingleFeedWgt.setValue(null);
		prmtbreedData.setValue(null);
		prmtsettlePolicy.setValue(null);
		txtseedSource.setText(null);
		if(prmtbatchContract.getValue()!=null){
			String contractID=((IPropertyContainer) prmtbatchContract.getValue()).getString("id");
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("breedData.*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("person.*");
			slor.add("batch.*");
			slor.add("settlementPolicy.*");
			BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(contractID),slor );
			prmtperson.setValue(contractInfo.getPerson());
			prmtbreedData.setValue(contractInfo.getBreedData());
			prmtsettlePolicy.setValue(contractInfo.getSettlementPolicy());
			setSettleData(contractID);
			String seedSourceStr = StockingComm.getSeedSourceStr(null, contractID);
			txtseedSource.setText(seedSourceStr);
			String batchID=StockingComm.getBatchIDByContractID(null, contractID);
			if(StringUtils.isNotEmpty(batchID)) {
				this.prmtbatch.setValue(BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID)));
			}else {
				this.prmtbatch.setValue(null);
			}
			
			
			
			//批次合同改变自动带出政策单价赋值雏苗单价
			String s1 = "/*dialect*/ select t2.FReceivePrice from T_FM_BreedSeedReceiveBill t1" +
					" inner join T_FM_BreedSeedReceiveBillEntry t2 on t2.fparentid = t1.fid" +
					" where rownum = 1 and  t1.FBatchContractID ='"+contractID+"'";
			IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
			BigDecimal FReceivePrice = BigDecimal.ZERO;
			if(r1.next()){
				FReceivePrice = UIRuleUtil.getBigDecimal(r1.getBigDecimal("FReceivePrice"));
			}
			txtbreedPrice.setValue(FReceivePrice);
		}
		
		setFilter();
	}

	
	
	
	
	
	private void setSettleData(String contractID) {
		// TODO Auto-generated method stub
		StringBuffer str=new StringBuffer();
		str.append("select distinct t1.fid fid from CT_FM_CKSettleBill t1 ")
		.append(" inner join T_BOT_Relation t2 on (t1.fid=t2.FDestObjectID and t2.FSrcEntityID='")
		.append(new PreHouseWgtBillInfo().getBOSType().toString()).append("')")
		.append(" where t1.CFBatchContractID='"+contractID+"'");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str.toString()).executeSQL();
			if(rs.next()){
				CKSettleBillInfo info=CKSettleBillFactory.getRemoteInstance().getCKSettleBillInfo(new ObjectUuidPK(rs.getString("fid")));
				pkrecDate.setValue(info.getRecDate());
				txtrecQty.setValue(info.getRecQty());
				txtrecSuttle.setValue(info.getRecSuttle());
				txtfeedWgt.setValue(info.getFeedWgt());
				txtrecRate.setValue(info.getSurvivalRate());
				txtfmRate.setValue(info.getMeatRate());
				txtdrugAmt.setValue(info.getDrugAmt());
				txtsingleDrugAmt.setValue(info.getSingleDrugAmt());
				txtoValue.setValue(info.getOValue());
				txtcAverageWgt.setValue(info.getChickenAveWgt());
				txtdyFee.setValue(info.getDyFee());
				txtsingleDyFee.setValue(info.getSingleDyFee());
				txtfeedDays.setValue(info.getFeedDays());
				txtsingleFeedWgt.setValue(info.getSingleFeedWgt());
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
	}


	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtFICompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtFICompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
		String farmerID="";
		String farmID="";

		farmerID=prmtfarmer.getValue()==null?"":((FarmerInfo)prmtfarmer.getValue()).getId().toString();
		farmID=prmtfarm.getValue()==null?"":((FarmInfo)prmtfarm.getValue()).getId().toString();

		//批次过滤
		StockingComm.setStockingBatchFilter(prmtbatch,curCompanyID,farmerID,farmID,true,false);
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,true);
		//合同过滤
		StockingComm.setBatchContractFilter(prmtbatchContract, curCompanyID,farmerID,farmID,true,true);
		//客诉类型过滤
		StockingComm.setCustomerViewTypeFilter(prmtviewType, curCompanyID);
	}


	@Override
	protected void btnUpdateSettle_actionPerformed(ActionEvent e)
	throws Exception {
		if(billStatus.getSelectedItem()!=null&&billStatus.getSelectedItem()==BillBaseStatusEnum.AUDITED){
			return;
		}
		prmtbatchContract_Changed(null);
		storeFields();
		actionSave_actionPerformed(e);
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
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	@Override
	public void actionRevoke_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getId()==null){
			MsgBox.showWarning("新增单据无需作废！");
			SysUtil.abort();
		}
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止作废！");
			SysUtil.abort();
		}
		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
			SysUtil.abort();
		}
		if(MsgBox.showConfirm2("一旦作废将无法反作废,是否继续?")==MsgBox.YES){
			super.actionRevoke_actionPerformed(e);
			this.doAfterSave(new ObjectUuidPK(editData.getId()));
			setOprtState(STATUS_VIEW);
			lockUIForViewStatus();
			setNextMessageText("作废成功");
			setShowMessagePolicy(0);
			setIsShowTextOnly(false);
			showMessage();
		}
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

		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
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
		if(editData.getId()==null){
			actionSave_actionPerformed(e);
		}
		checkIsCanSubmit();
		super.actionSubmit_actionPerformed(e);
	}


	private void checkIsCanSubmit() {
		if(editData.getId()==null){
			return;
		}
		try {
			CustomerViewTypeInfo viewType = CustomerViewTypeFactory.getRemoteInstance().getCustomerViewTypeInfo(new ObjectUuidPK(editData.getViewType().getId()));
			if(viewType.getDateRelate()==null){
				MsgBox.showWarning("客诉类型未选择日期关联,请联系相关人员维护客诉类型!");
				SysUtil.abort();
			}
			Date createDate = editData.getCreateTime();
			int pemitDays = viewType.getPemitDays();
			Calendar cal=Calendar.getInstance();
			cal.setTime(sdf.parse(sdf.format(createDate)));
			Calendar endCal=Calendar.getInstance();
			if(viewType.getDateRelate()==DateRelate.inDate){
				if(editData.getInDate()==null){
					MsgBox.showWarning("缺少上苗日期,操作失败!");
					SysUtil.abort();
				}
				Date inDate = editData.getInDate();
				endCal.setTime(sdf.parse(sdf.format(inDate)));
			}else if(viewType.getDateRelate()==DateRelate.recDate){
				if(editData.getRecDate()==null){
					MsgBox.showWarning("缺少回收日期,操作失败!");
					SysUtil.abort();
				}
				Date recDate = editData.getRecDate();
				endCal.setTime(sdf.parse(sdf.format(recDate)));
			}
			endCal.add(Calendar.DATE, pemitDays);
			if(cal.after(endCal)){
				MsgBox.showWarning("客诉日期超出允许客诉日期:\n"+sdf.format(endCal.getTime())+",操作失败!");
				SysUtil.abort();
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());

		return objectValue;
	}

}