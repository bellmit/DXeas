/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.account.AccountViewFactory;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IFarm;
import com.kingdee.eas.farm.carnivorous.basedata.IFarmer;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;

import freemarker.template.SimpleDate;

/**
 * output class name
 */
public class CKCostAllocateBillEditUI extends AbstractCKCostAllocateBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKCostAllocateBillEditUI.class);
	private boolean isLoadField=false;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private IFarmer iFarmer=null;
	private IFarm iFarm=null;
	private IBatchContractBill iBatchContract=null;
	private BigDecimal allWeight=BigDecimal.ZERO;
	private BigDecimal allAmount=BigDecimal.ZERO;
	/**
	 * output class constructor
	 */
	public CKCostAllocateBillEditUI() throws Exception
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
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		setfilter();
		kdtPeriodEntry.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				BigDecimal endingBanace = UIRuleUtil.getBigDecimal(kdtPeriodEntry.getCell(e.getRowIndex(), "endingBanace").getValue());
				BigDecimal currentCost = UIRuleUtil.getBigDecimal(kdtPeriodEntry.getCell(e.getRowIndex(), "currentCost").getValue());
				kdtPeriodEntry.getCell(e.getRowIndex(), "restCost").setValue(endingBanace.subtract(currentCost));
			}

		});
		kdtEntrys_detailPanel.getEntryTable().getStyleAttributes().setLocked(false);
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
		setTableToSumField(kdtEntrys, new String[]{"weight","amount"});
	}

	/**
	 * 添加过滤
	 */
	private void setfilter() {
		// TODO Auto-generated method stub
		if(prmtFICompany.getValue() != null){
			CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) prmtFICompany.getValue();

			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			filterInfo.getFilterItems().add(new FilterItemInfo("companyID.id",companyInfo.getId().toString(),CompareType.EQUALS));
			viewInfo.setFilter(filterInfo);
			final KDBizPromptBox kdtPeriodEntry_accountView_PromptBox = new KDBizPromptBox();
			kdtPeriodEntry_accountView_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.account.app.F7AccountViewQuery");
			kdtPeriodEntry_accountView_PromptBox.setVisible(true);
			kdtPeriodEntry_accountView_PromptBox.setEditable(true);
			kdtPeriodEntry_accountView_PromptBox.setDisplayFormat("$number$");
			kdtPeriodEntry_accountView_PromptBox.setEditFormat("$number$");
			kdtPeriodEntry_accountView_PromptBox.setCommitFormat("$number$");
			kdtPeriodEntry_accountView_PromptBox.setEntityViewInfo(viewInfo);
			KDTDefaultCellEditor kdtPeriodEntry_accountView_CellEditor = new KDTDefaultCellEditor(kdtPeriodEntry_accountView_PromptBox);
			this.kdtPeriodEntry.getColumn("accountView").setEditor(kdtPeriodEntry_accountView_CellEditor);
		}
	}
	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

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

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		actionAudit_actionPerformed(e);
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
	public void actionExecAllocate_actionPerformed(ActionEvent e)
	throws Exception {
		beforeStoreFields(e);
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，无法执行该操作！");
			SysUtil.abort();
		}
		storeFields();
		LongTimeDialog dialog = new LongTimeDialog( (Frame) SwingUtilities.getWindowAncestor(this)); 
		dialog.setLongTimeTask(new ILongTimeTask() {
			public Object exec() throws Exception { 
				Object obj = "sunx"; 
				// 查询的数据赋值与表格 
				execAll();
				return obj; 
			} 

			public void afterExec(Object result) throws Exception {
				MsgBox.showInfo("费用分摊完成！"); 
			} 
		}); 
		Component[] cps=dialog.getContentPane().getComponents(); 
		for(Component cp:cps){ 
			if(cp instanceof JLabel){ 
				((JLabel) cp).setText("费用分摊执行中......."); 
			} 
		} 
		dialog.show(); 
	}

	private void execAll() {
		try {
			kdtEntrys.removeRows();
			allWeight=BigDecimal.ZERO;
			allAmount=UIRuleUtil.getBigDecimal(txtallAmount.getBigDecimalValue());
			iFarmer=FarmerFactory.getRemoteInstance();
			iFarm=FarmFactory.getRemoteInstance();
			iBatchContract=BatchContractBillFactory.getRemoteInstance();
			PeriodInfo period=PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(((IPropertyContainer)prmtperiod.getValue()).getString("id")));
			String companyID=((IPropertyContainer)prmtFICompany.getValue()).getString("id");
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select t1.CFFarmerID CFFarmerID,t1.CFFarmID CFFarmID,t1.CFBatchContractID CFBatchContractID, ")
			.append(" t1.CFRecQty CFSettleWgt,t1.CFSettleWgt recWgt,t3.FActualFemaleQty inQty from CT_FM_CKSettleBill t1 ")
			.append(" inner join CT_FM_Farm t2 on t2.fid = t1.CFFarmID")
			.append(" inner join T_FM_BatchContractBill t3 on t3.fid = t1.CFBatchContractID")
			.append(" where t1.CFBillStatus in (4,7) ")
			.append(" and t1.FBizDate >= to_date('"+sdf.format(period.getBeginDate())+"','yyyy-MM-dd hh24:mi:ss') ")
			.append(" and t1.FBizDate <= to_date('"+sdf.format(period.getEndDate())+" 23:59:59','yyyy-MM-dd hh24:mi:ss') ")
			//			.append(" and t2.FCostCenterID = '"+((IPropertyContainer)prmtcostCenter.getValue()).getString("id")+"'") 
			.append(" and t1.CFFICompanyID='"+companyID+"' ");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			while(rs.next()){
				IRow row = kdtEntrys.addRow();
				FarmerInfo farmer=iFarmer.getFarmerInfo(new ObjectUuidPK(rs.getString("CFFarmerID")));
				row.getCell("farmer").setValue(farmer);
				FarmInfo farm=iFarm.getFarmInfo(new ObjectUuidPK(rs.getString("CFFarmID")));
				row.getCell("farm").setValue(farm);
				BatchContractBillInfo batchContractBill=iBatchContract.getBatchContractBillInfo(new ObjectUuidPK(rs.getString("CFBatchContractID")));
				row.getCell("batchContract").setValue(batchContractBill);
				BreedDataInfo  breedDataInfo = batchContractBill.getBreedData();
				breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(breedDataInfo.getId()));
				row.getCell("breeddata").setValue(breedDataInfo);
				//成本中心
				CostCenterOrgUnitInfo costInfo = batchContractBill.getCostCenter();
				costInfo = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(costInfo.getId()));
				row.getCell("costCenter").setValue(costInfo);
				row.getCell("weight").setValue(rs.getBigDecimal("CFSettleWgt"));
				row.getCell("recWgt").setValue(rs.getBigDecimal("recWgt"));
				row.getCell("inQty").setValue(rs.getBigDecimal("inQty"));
				allWeight=allWeight.add(rs.getBigDecimal("CFSettleWgt"));
			}

			//根据成本中心还有会计期间获取所有的上苗数量
			BigDecimal allQty = BigDecimal.ZERO;
			Map<String,BigDecimal> qtyMap = new HashMap<String,BigDecimal>();
			SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
			PeriodInfo periodInfo = (PeriodInfo) prmtperiod.getValue();
			periodInfo = PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(periodInfo.getId()));
			String beginStr = adf.format(periodInfo.getBeginDate());
			String endStr = adf.format(periodInfo.getEndDate());
			for(int i=0;i<kdtPeriodEntry.getRowCount();i++){
				CostCenterOrgUnitInfo costInfo = (CostCenterOrgUnitInfo) kdtPeriodEntry.getCell(i,"costCenter").getValue();
				String s1 = "/*dialect*/ select sum(t1.CFBatchQty) allQty from CT_FM_CKSettleBill t1" +
				"  where t1.CFBillStatus in (4,7) and t1.CFCostCenterID = '"+costInfo.getId()+"'" +
				" and to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+beginStr+"' " +
				" and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+endStr+"'";
				IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
				if(r1.next()){
					BigDecimal ceQty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("allQty"));
					allQty = allQty.add(ceQty);
					qtyMap.put(costInfo.getId().toString(), ceQty);
				}
			}

			//成本中心，分摊金额
			Map<String,BigDecimal> amountMap = new HashMap<String,BigDecimal>();
			for(int i=0;i<kdtPeriodEntry.getRowCount();i++){
				CostCenterOrgUnitInfo costInfo = (CostCenterOrgUnitInfo) kdtPeriodEntry.getCell(i,"costCenter").getValue();
				BigDecimal amount=UIRuleUtil.getBigDecimal(kdtPeriodEntry.getCell(i,"currentCost").getValue());
				amountMap.put(costInfo.getId().toString(), amount);
			}



			for(int i=0;i<kdtEntrys.getRowCount();i++){
				IRow row=kdtEntrys.getRow(i);
				BigDecimal weight=(BigDecimal) row.getCell("inQty").getValue();
				CostCenterOrgUnitInfo costInfo = (CostCenterOrgUnitInfo) row.getCell("costCenter").getValue();
				//成本中心对应上苗数量
				BigDecimal costQty = UIRuleUtil.getBigDecimal(qtyMap.get(costInfo.getId().toString()));
				//成本中心对应分摊金额
				BigDecimal shareAmt = amountMap.get(costInfo.getId().toString());
				if(costQty.compareTo(BigDecimal.ZERO) > 0){
					if(kdtEntrys.getRowCount() == 1){
						BigDecimal amount=shareAmt.multiply(weight).divide(costQty,2,RoundingMode.HALF_UP);
						row.getCell("amount").setValue(amount);
					}else{
						BigDecimal amount=shareAmt.multiply(weight).divide(costQty,2,RoundingMode.HALF_UP);
						row.getCell("amount").setValue(amount);
					}
				}
			}

			//把小数点误差归集到最后一行分录
			Set<String> keySet = amountMap.keySet();//先获取map集合的所有键的Set集合
			Iterator<String> it = keySet.iterator();//有了Set集合，就可以获取其迭代器。
			while(it.hasNext()){
				String costCenterid = it.next();
				BigDecimal allAmount = amountMap.get(costCenterid);//有了键可以通过map集合的get方法获取其对应的值。

				BigDecimal otherAmount = BigDecimal.ZERO;
				int num = 0;
				for(int i=0;i<kdtEntrys.getRowCount();i++){
					IRow row=kdtEntrys.getRow(i);
					BigDecimal amount=(BigDecimal) row.getCell("amount").getValue();
					CostCenterOrgUnitInfo costInfo = (CostCenterOrgUnitInfo) row.getCell("costCenter").getValue();
					if(costCenterid.equalsIgnoreCase(costInfo.getId().toString())){
						otherAmount = otherAmount.add(amount);
						num = i;
					}
				}
				//如果分摊费用不等于批次分摊费用汇总
				if(allAmount.compareTo(otherAmount) != 0){
					for(int i=0;i<kdtEntrys.getRowCount();i++){
						IRow row=kdtEntrys.getRow(i);
						CostCenterOrgUnitInfo costInfo = (CostCenterOrgUnitInfo) row.getCell("costCenter").getValue();
						if(costCenterid.equalsIgnoreCase(costInfo.getId().toString())){
							row.getCell("amount").setValue(allAmount.subtract(otherAmount));
							break;
						}
					}
				}
			}






		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setPeriod(DateUtilsComm.getCurrentPeriodInfo());
		return objectValue;
	}

	/**
	 * 获取费用金额
	 */
	@Override
	public void actionCostAmt_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCostAmt_actionPerformed(e);

		if(prmtperiod.getValue() != null && prmtFICompany.getValue() != null){
			kdtPeriodEntry.removeRows();
			PeriodInfo periodInfo = (PeriodInfo) prmtperiod.getValue();
			periodInfo = PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(periodInfo.getId()));
			CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) prmtFICompany.getValue();
			companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyInfo.getId()));
			StringBuffer s1 = new StringBuffer();
			s1.append("/*dialect*/ select t9.comid,t9.comNum,t9.comName,t9.period,t9.accountid,t9.accountNum,t9.accountName,t9.typeName,").append("\n")
			.append(" t9.costid,t9.costNum,t9.costName,sum(t9.amt) amt from (select distinct t8.fid comid,t8.fnumber comNum,t8.fname_l2 comName,").append("\n")
			.append(" t1.fperiod period,t2.fid accountid,t2.fnumber accountNum,t2.fname_l2 accountName,t6.fname_l2 typeName,").append("\n")
			.append(" t7.fid   costid,t7.fnumber costNum,t7.fname_l2 costName,(t1.FEndBalanceLocal) amt from").append("\n")
			.append(" T_GL_AssistBalance t1 inner join t_bd_accountView t2 on t2.fid=t1.FAccountID").append("\n")
			.append(" inner join T_BD_AssistantHG t3 on t3.fid=t1.FAssistGrpID").append("\n")
			.append(" inner join T_BD_AsstAccount t4 on t4.fid=t3.FAsstAccountID").append("\n")
			.append(" inner join T_BD_AsstActGroupDetail t5 on t5.FAsstAccountID=t4.fid").append("\n")
			.append(" inner join T_BD_AsstActType t6 on t6.fid=t5.FAsstActTypeID").append("\n")
			.append(" inner join T_ORG_CostCenter t7 on t7.fid = t3.FCostOrgID").append("\n")
			.append(" inner join T_ORG_Company t8 on t8.fid = t1.FOrgUnitID")
			.append(" where t6.fnumber = '00011' and t2.fnumber = '5003'  and t8.fid = '")
			.append(companyInfo.getId())
			.append("' and t1.fperiod='")
			.append(periodInfo.getNumber())
			.append("' ) t9 ").append("\n")
			.append(" group by t9.comid,t9.comNum,t9.comName,t9.period,t9.accountid,t9.accountNum,t9.accountName,t9.typeName,t9.costid,t9.costNum,t9.costName").append("\n")
			.append(" order by t9.comNum,t9.period,t9.accountNum,t9.costNum");

			IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1.toString());
			String accountid = null;
			String costid = null;
			BigDecimal amt = BigDecimal.ZERO;
			while(r1.next()){
				accountid = UIRuleUtil.getString(r1.getString("accountid"));
				AccountViewInfo accountInfo = AccountViewFactory.getRemoteInstance().getAccountViewInfo(new ObjectUuidPK(accountid));
				costid = UIRuleUtil.getString(r1.getString("costid"));
				CostCenterOrgUnitInfo costInfo = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(costid));
				amt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("amt"));
				IRow row = kdtPeriodEntry.addRow();
				row.getCell("costCenter").setValue(costInfo);
				row.getCell("accountView").setValue(accountInfo);
				row.getCell("accountName").setValue(accountInfo.getName());
				//期末余额
				row.getCell("endingBanace").setValue(amt);
				//本期分摊费用
				row.getCell("currentCost").setValue(amt);
				//剩余金额
				row.getCell("restCost").setValue(BigDecimal.ZERO);
			}
		}
	}
}