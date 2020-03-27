/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.IPrintIntegration;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.PrintIntegrationFactory;
import com.kingdee.eas.basedata.assistant.PrintIntegrationInfo;
import com.kingdee.eas.basedata.assistant.util.CommonPrintIntegrationDataProvider;
import com.kingdee.eas.basedata.assistant.util.PrintIntegrationManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.framework.print.MultiapproveDataProvider;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.scm.common.util.SCMCommonDataProvider;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSortManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class CKSettleBillEditUI extends AbstractCKSettleBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKSettleBillEditUI.class);
	private boolean isLoadField=false;
	/**
	 * output class constructor
	 */
	public CKSettleBillEditUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment(); 
		Rectangle rect=ge.getMaximumWindowBounds(); 
		this.setPreferredSize(new Dimension(rect.width,rect.height));
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		btnClose.setIcon(EASResource.getIcon("imgState_iconclose_1"));
		btnUnClose.setIcon(EASResource.getIcon("imgTable_success"));
		actionCopy.setVisible(false);
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		
		
		txtpunishAmt.setPrecision(6);
		txtviewItemAmt.setPrecision(6);
		
		
		contadPayAmount.setVisible(false);
		contpayOweMoneryB.setVisible(false);
		contmarginAmt.setVisible(true);
		contunLockedMargin.setVisible(true);
		contmarginOccupyFee.setVisible(false);
		contconFeedSubsidies.setVisible(false);
		contfreightDiffSubsidies.setVisible(false);
		contdeductMargin.setVisible(false);
		contpayOweMonery.setVisible(false);
		contadPayBalance.setVisible(false);
		contnoPfoRetAmt.setVisible(false);
		contspecialPermitAmt.setVisible(false);
		contfarmeronlyPro.setVisible(false);
		contfarmerOnlyProOne.setVisible(false);
		
		
		
		contbatchOccupyMargin.setVisible(false);
		contkbConFeedPolicy.setVisible(false);
		contlFeedWgt.setVisible(false);
		conttotalMargin.setVisible(false);
		contdeductAdPayAmt.setVisible(false);
		contmoneyOccupyDays.setVisible(false);

		contstandardMargin.setVisible(false);
		contcontractCKWgt.setVisible(false);
		contfreightPrice.setVisible(false);
		contoccupyMargin.setVisible(true);
		contoutSaleKbAmt.setVisible(false);
		contloanRate.setVisible(false);

		contsingleMargin.setVisible(true);
		contconFeedPolicySub.setVisible(false);
		contfreightSubsidiesStd.setVisible(false);
		contenableMargin.setVisible(false);
		contdyfBalance.setVisible(false);
		contkYFKOccupyFee.setVisible(false);
		
		contoutSaleKbAmt2.setEnabled(false);
		contchickenRetunAmt.setEnabled(false);
		
		contreserveRiskCost.setEnabled(false);
		contbrokenCost.setEnabled(false);
		contlongBorrowAmount.setEnabled(false);
		contcoalCost.setEnabled(false);
		contnowAccountBac.setEnabled(false);
		contspecialBorrowinst.setEnabled(false);
		contborrowAmiunt.setEnabled(false);
		contmarginProfit.setEnabled(false);
		contequipmentReAmt.setEnabled(false);
		chkpreVoucher.setEnabled(false);
		chkhasPay.setEnabled(false);
		contgetChickCost.setEnabled(false);
		contcleanHouseCost.setEnabled(false);
		contcleanTowerCost.setEnabled(false);
		contassetsOccupy.setEnabled(false);
		contimmuneCostOne.setEnabled(false);
		contimmuneCost.setEnabled(false);
		contimmuneCostOne.setVisible(false);
		
		
		
		
		setTableToSumField(kdtSeedSourceEntrys, new String[]{"qty"});
		setTableToSumField(kdtSeedEntrys, new String[]{"qty","amount","cost"});
		setTableToSumField(kdtFodderEntrys, new String[]{"qty","bagQty","amount","cost","hjFee"});
		setTableToSumField(kdtDrugEntrys, new String[]{"qty","amount","cost"});
		setTableToSumField(kdtSlaughterEntrys, new String[]{"preHouseSuttle","recQty","carcassQty","carcassWgt","inCompleteQty","inCompleteWgt"});
		setTableToSumField(kdtSaleEntrys, new String[]{"outSaleAmt","recSuttle"});
		setTableToSumField(kdtEntrys, new String[]{"qty","weight","amount"});
		setTableToSumField(kdtQCEntrys, new String[]{"punishAmt","punishWgt"});
		setTableToSumField(kdtViewReqEntrys, new String[]{"amount","auditAmt"});
		setTableToSumField(kdtOtherEntrys, new String[]{"amount"});
		setTableToSumField(kdtPreHouseEntrys, new String[]{"preHouseSuttle","preHouseQty","preHouseTare","preHouseGross","recQty","settleWgt","recSuttle"});
		setTableToSumField(kdtTempPolicyEntrys, new String[]{"kbAmount"});
		setSort(new KDTable[]{kdtTempPolicyEntrys,kdtSeedSourceEntrys,kdtSeedEntrys,kdtDrugEntrys,kdtSlaughterEntrys,kdtSaleEntrys,kdtQCEntrys,kdtViewReqEntrys,kdtPreHouseEntrys});
		contpreHouseWgt.setVisible(false);
		contfeedQty.setVisible(false);
		contrecSuttle.setVisible(false);
		kDPanel16.setVisible(false);
		kdtSeedSourceEntrys.setVisible(false);

		//过滤扣补项目
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",2,CompareType.EQUALS));
		ev.setFilter(filter);

		final KDBizPromptBox kdtSeedSourceEntrys_storageOrgUnit_PromptBox = new KDBizPromptBox();
		kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SubsidyPolicyQuery");
		kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setVisible(true);
		kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setEditable(true);
		kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setDisplayFormat("$number$");
		kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setEditFormat("$number$");
		kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setCommitFormat("$number$");
		kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setEntityViewInfo(ev);
		KDTDefaultCellEditor kdtSeedSourceEntrys_storageOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtSeedSourceEntrys_storageOrgUnit_PromptBox);
		this.kdtOtherEntrys.getColumn("suType").setEditor(kdtSeedSourceEntrys_storageOrgUnit_CellEditor);





		KDTSortManager sm = new KDTSortManager(kdtFodderEntrys){
			@Override
			public void sort(int colIndex, int sortType) {
				for(int i=0;i<kdtFodderEntrys.getRowCount();i++){
					if(kdtFodderEntrys.getCell(i,"Car").getValue()!=null){
						CarInfo car=(CarInfo) kdtFodderEntrys.getCell(i,"Car").getValue();
						car.setDisplayFormat(((IPropertyContainer)kdtFodderEntrys.getCell(i,"Car").getValue()).getString("number"));	
					}if(kdtFodderEntrys.getCell(i,"driver").getValue()!=null){
						DriverInfo driver=(DriverInfo) kdtFodderEntrys.getCell(i,"driver").getValue();
						driver.setDisplayFormat(((IPropertyContainer)kdtFodderEntrys.getCell(i,"driver").getValue()).getString("driverName"));
					}
				}
				super.sort(colIndex, sortType);			
			}
		};		
		sm.setSortAuto(true); 
		sm.setClickCount(2); 
		for(int i=0;i<kdtFodderEntrys.getColumnCount();i++){
			this.kdtFodderEntrys.getColumn(i).setSortable(true); 
		}
		removeBtnAndLocked(new DetailPanel[]{kdtTempPolicyEntrys_detailPanel,kdtSeedSourceEntrys_detailPanel,kdtEntrys_detailPanel,kdtDrugEntrys_detailPanel,kdtFodderEntrys_detailPanel,kdtQCEntrys_detailPanel,
				kdtSaleEntrys_detailPanel,kdtSeedEntrys_detailPanel,kdtSlaughterEntrys_detailPanel,kdtViewReqEntrys_detailPanel,kdtPreHouseEntrys_detailPanel});

		/**
		 * 日期添加监听事件
		 */
		pkBizDate.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//设置会计期间
				sPeriod();


			}

		});



	}

	private void setSort(KDTable[] kdtEntrys) {
		// TODO Auto-generated method stub
		for(KDTable kdtEntry:kdtEntrys){
			KDTSortManager sm2 = new KDTSortManager(kdtEntry){
				public void sort(int colIndex, int sortType) {
					super.sort(colIndex, sortType);			
				}
			};		
			sm2.setSortAuto(true); 
			sm2.setClickCount(2); 
			for(int i=0;i<kdtEntry.getColumnCount();i++){
				kdtEntry.getColumn(i).setSortable(true); 
			}
		}
	}

	private void removeBtnAndLocked(DetailPanel[] detailPanels) {
		// TODO Auto-generated method stub
		for(DetailPanel detailPanel:detailPanels){
			detailPanel.getEntryTable().setEditable(false);
			detailPanel.getAddNewLineButton().setVisible(false);
			detailPanel.getInsertLineButton().setVisible(false);
			detailPanel.getRemoveLinesButton().setVisible(false);
			detailPanel.getEntryTable().getStyleAttributes().setLocked(true); 
		}
	}

	public void loadFields(){
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

		String curCompanyID=prmtFICompany.getValue()==null?"":((IPropertyContainer)prmtFICompany.getValue()).getString("id");
		Date bizDate=pkBizDate.getValue()==null?null:(Date)pkBizDate.getValue();
		String farmerID=prmtfarmer.getValue()==null?"":((IPropertyContainer)prmtfarmer.getValue()).getString("id");
		String farmID=prmtfarm.getValue()==null?"":((IPropertyContainer)prmtfarm.getValue()).getString("id");
		//设置连养政策过滤条件
		StockingComm.setConFeedPolicyFilter(prmtkbConFeedPolicy,curCompanyID ,bizDate);
		//设置连养合同过滤条件
		StockingComm.setConFeedContractFilter(prmtconFeedContract, curCompanyID, farmerID, farmID, bizDate);
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

		if(prmtbatchContract.getValue()!=null){
			kblBatchContract.setText("批次合同:"+((IPropertyContainer)prmtbatchContract.getValue()).getString("number"));
		}

		//设置会计期间
		sPeriod();

	}

	/**
	 * 设置会计期间
	 */
	private void sPeriod() {
		// TODO Auto-generated method stub
		if(UIRuleUtil.isNotNull(pkBizDate.getValue())){
			Date bizdate = (Date) pkBizDate.getValue();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//根据业务日期查找会计期间
			String s1 = "/*dialect*/ select t1.fid periodid from T_BD_Period t1" +
			" where to_date(to_char(t1.FBeginDate,'yyyy-mm-dd'),'yyyy-mm-dd')<= {d '"+sdf.format(bizdate)+"'}" +
			" and to_date(to_char(t1.FEndDate,'yyyy-mm-dd'),'yyyy-mm-dd')>= {d '"+sdf.format(bizdate)+"'}";
			IRowSet r1;
			String periodid = null;
			try {
				r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
				if(r1.next()){
					periodid = r1.getString("periodid");
					if(UIRuleUtil.isNotNull(periodid)){
						PeriodInfo periodInfo = PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(periodid));
						prmtperiod.setValue(periodInfo);
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
	}

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			MsgBox.showWarning("单据已经审核或关闭，禁止修改！");
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
	public void actionHasPay_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionHasPay_actionPerformed(e);
		refreshCurPage();
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
	protected void refreshCurPage() throws EASBizException, BOSException,
	Exception {
		if (editData.getId() != null) {
			BOSUuid pk = editData.getId();
			super.doAfterSave(new ObjectUuidPK(editData.getId()));
			editData.setId(pk);
		}else{
			this.loadData();
		}
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal deductMargin = UIRuleUtil.getBigDecimal(txtdeductMargin.getBigDecimalValue());
		BigDecimal deductAdPayAmt = UIRuleUtil.getBigDecimal(txtdeductAdPayAmt.getBigDecimalValue());	
		BigDecimal payOweMonery = UIRuleUtil.getBigDecimal(txtpayOweMonery.getBigDecimalValue());
		BigDecimal dyFee = UIRuleUtil.getBigDecimal(txtdyFee.getBigDecimalValue());
		if(deductMargin.signum()<0){
			MsgBox.showWarning("扣保证金不能小于0,提交失败!");
			SysUtil.abort();
		}		
		if(deductAdPayAmt.signum()<0){
			MsgBox.showWarning("扣预付款不能小于0,提交失败!");
			SysUtil.abort();
		}
		if(payOweMonery.signum()<0){
			MsgBox.showWarning("还赊欠款不能小于0,提交失败!");
			SysUtil.abort();
		}

		if(dyFee.signum()>0){
			if(dyFee.subtract(deductMargin).subtract(deductAdPayAmt).subtract(payOweMonery).signum()<0){
				MsgBox.showWarning("扣保证金、扣预付款金额与还赊欠款之和大于代养费,提交失败!");
				SysUtil.abort();
			}
		}else{
			if(deductMargin.add(deductMargin).add(payOweMonery).signum()!=0){
				MsgBox.showWarning("代养费为负数或零时,扣保证金、扣预付款金额与还赊欠款之和必须为0,提交失败!");
				SysUtil.abort();
			}
		}
		for(int i=0;i<kdtViewReqEntrys.getRowCount();i++){
			if(kdtViewReqEntrys.getCell(i, "billStatus").getValue()==null
					||((BillBaseStatusEnum)kdtViewReqEntrys.getCell(i, "billStatus").getValue()!=BillBaseStatusEnum.AUDITED
							&&(BillBaseStatusEnum)kdtViewReqEntrys.getCell(i, "billStatus").getValue()!=BillBaseStatusEnum.DELETED)){
				MsgBox.showWarning("客诉申请单未全部审核,提交失败!");
				SysUtil.abort();
			}			
		}
		super.actionSubmit_actionPerformed(e);
		actionAudit_actionPerformed(e);
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

	public void actionClose_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据未审核，禁止关闭！");
			SysUtil.abort();
		}
		super.actionClose_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("关闭成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			MsgBox.showWarning("单据尚未关闭，禁止反关闭！");
			SysUtil.abort();
		}
		super.actionUnClose_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反关闭成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	@Override
	public void actionExecSettle_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		beforeStoreFields(e);
		storeFields();
		if(editData.getId()==null){
			super.actionSave_actionPerformed(e);
		}
		Map result=CKSettleBillFactory.getRemoteInstance().execSettle(editData);
		if(result.get("information")!=null){
			MsgBox.showWarning((String) result.get("information"));
		}
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("结算完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	@Override
	public void actionUpdateSaleData_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		beforeStoreFields(e);
		storeFields();
		if(editData.getId()==null){
			super.actionSave_actionPerformed(e);
		}
		super.actionUpdateSaleData_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("更新完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * 更新实际支付字段
	 */
	@Override
	public void actionUpdateActAmt_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub


		//实际支付 = 代养费-保证金留取金额-预留风险押金-保证金利息-笼养借款还款金额-
		//-借款利息-设备升级借款还款-特批借款还款金额-亏损还款
		BigDecimal actualPayAmt = UIRuleUtil.getBigDecimal(txtdyFee.getValue())
		.subtract(UIRuleUtil.getBigDecimal(txtmarginGAmount.getValue()))
		.subtract(UIRuleUtil.getBigDecimal(txtlongBorrowReturn.getValue()));
		txtactualPayAmt.setValue(actualPayAmt);

		//设置现账面累计余额 = 上批余额+预留风险押金+保证金留取金额+设备借款还款金额+特批借款还款金额+笼养借款还款金额
		BigDecimal nowAccountBac = UIRuleUtil.getBigDecimal(txtbeforeBatchAmount.getValue())
		.add(UIRuleUtil.getBigDecimal(txtreserveRiskCost.getValue()))
		.add(UIRuleUtil.getBigDecimal(txtmarginGAmount.getValue()))
		.add(UIRuleUtil.getBigDecimal(txtequipmentReAmt.getValue()))
		.add(UIRuleUtil.getBigDecimal(txtspecialPermitAmt.getValue()))
		.add(UIRuleUtil.getBigDecimal(txtnoPfoRetAmt.getValue()))
		.add(UIRuleUtil.getBigDecimal(txtlongBorrowReturn.getValue()));
		txtnowAccountBac.setValue(nowAccountBac);






		if(editData.getId()==null){
			super.actionSave_actionPerformed(e);
		}
		super.actionSave_actionPerformed(e);
		super.actionUpdateActAmt_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("更新完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (editData == null)
			return;
		//		BillBaseStatusEnum billBaseStatus = editData.getBillStatus();
		//		if (editData.getId() == null
		//				|| billBaseStatus != null
		//				&& (billBaseStatus.getValue() == 0 || billBaseStatus.getValue() == 1)) {
		//			MsgBox.showInfo(this, InvClientUtils
		//					.getResource("CanPrintAndPrintView"));
		//			SysUtil.abort();
		//		}
		BeforeInvokePrintFunction(true);
	}

	public void actionPrintPreview_actionPerformed(ActionEvent e)
	throws Exception {
		if (editData == null)
			return;
		//		BillBaseStatusEnum billBaseStatus = editData.getBillStatus();
		//		if (editData.getId() == null
		//				|| billBaseStatus != null
		//				&& (billBaseStatus.getValue() == 0 || billBaseStatus.getValue() == 1)) {
		//			MsgBox.showInfo(this, InvClientUtils.getResource("CanPrintAndPrintView"));
		//			SysUtil.abort();
		//		}
		BeforeInvokePrintFunction(false);
	}

	protected void BeforeInvokePrintFunction(boolean isPrint) {
		ArrayList idList;
		idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id")))
			idList.add(editData.getString("id"));
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null|| getTDFileName() == null)
			return;
		try {
			String bosType = getBizInterface().getType().toString();
			IPrintIntegration printInte = PrintIntegrationFactory.getRemoteInstance();
			java.util.List infoList = printInte.getBillsPrintInfoByList(idList,bosType);
			if (infoList.size() > 0) {
				StringBuffer sb = new StringBuffer();
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add(new SelectorItemInfo("id"));
				sic.add(new SelectorItemInfo("number"));
				for (int i = 0; i < 1; i++) {
					PrintIntegrationInfo info = (PrintIntegrationInfo) infoList.get(i);
					PrintIntegrationInfo info2 = PrintIntegrationFactory.getRemoteInstance().getPrintIntegrationInfo(new ObjectUuidPK(info.getId()),getPrintIntegrationSelector());
					//修改处
					CKSettleBillInfo bill = CKSettleBillFactory.getRemoteInstance().getCKSettleBillInfo(new ObjectUuidPK(info2.getPrintBillID()),sic);
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String lastPrtTime = format.format(info2.getLastPrintTime());
					sb.append(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","58_SaleOrderEditUI"),new Object[] {bill.getNumber().toString(),info2.getLastPrintUser().getName().toString(),lastPrtTime,(new Integer(info2.getPrintedNumber())).toString() }));
				}
				int flag = 0;
				if (isPrint)
					flag = MsgBox.showConfirm2(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","56_SaleOrderEditUI"),new Object[] { "\n\r\n\r",sb.toString() }));
				else
					flag = MsgBox.showConfirm2(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","57_SaleOrderEditUI"),new Object[] { "\n\r\n\r",sb.toString() }));
				if (flag == 2)
					return;
			}
		} catch (Exception e) {
			super.handleException(e);
		}

		try {
			invokePrintFunction(isPrint);
		} catch (Exception e) {
			super.handleException(e);
		}
		return;
	}

	private SelectorItemCollection getPrintIntegrationSelector() {
		SelectorItemCollection piSic = new SelectorItemCollection();
		piSic.add(new SelectorItemInfo("id"));
		piSic.add(new SelectorItemInfo("lastPrintTime"));
		piSic.add(new SelectorItemInfo("printedNumber"));
		piSic.add(new SelectorItemInfo("printBillID"));
		piSic.add(new SelectorItemInfo("lastPrintUser.name"));
		return piSic;
	}


	protected void invokePrintFunction(boolean isPrint) {
		ArrayList idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id")))
			idList.add(editData.getString("id"));
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null|| getTDFileName() == null)
			return;
		com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy data = new MultiDataSourceDataProviderProxy();
		SCMCommonDataProvider mainQueryData = new SCMCommonDataProvider(idList,getTDQueryPK());
		mainQueryData.setFilter(getPrintFilter(idList));
		data.put("MainQuery", mainQueryData);
		MultiapproveDataProvider multiapproveDataSource = new MultiapproveDataProvider(getSelectedIdForPrint(), isShowMultiapproveHistoryForPrint(),"billId");
		multiapproveDataSource.setMultiapproveDataFilter(getMultiapproveDataFilter());
		data.put(getMultiapproveQueryNameForPrint(), multiapproveDataSource);
		KDNoteHelper appHlp = new KDNoteHelper();
		CommonPrintIntegrationDataProvider printQueryData = new CommonPrintIntegrationDataProvider(editData.getBOSType().toString(), PrintIntegrationManager.getPrintQueryPK());
		data.put("PrintQuery", printQueryData);
		PrintIntegrationManager.initPrint(appHlp, editData.getBOSType(),idList, getTDFileName(),"com.kingdee.eas.scm.common.SCMResource", true);
		if (isPrint)
			appHlp.print(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
		else
			appHlp.printPreview(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
	}

	protected FilterInfo getPrintFilter(List ids) {
		FilterInfo filter = new FilterInfo();
		if (ids.size() == 1) {
			filter.getFilterItems().add(
					new FilterItemInfo("id", ids.toArray()[0].toString(),
							CompareType.EQUALS));
		} else {
			filter.getFilterItems().add(
					new FilterItemInfo("id", new HashSet(ids),
							CompareType.INCLUDE));
		}
		//		filter.getFilterItems().add(
		//				new FilterItemInfo("billStatus", new Integer(0),
		//						CompareType.NOTEQUALS));
		//		filter.getFilterItems().add(
		//				new FilterItemInfo("billStatus", new Integer(1),
		//						CompareType.NOTEQUALS));
		//		filter.setMaskString("#0 and #1 and #2");
		return filter;
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
		objectValue.setInDate(new Date());
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		return objectValue;
	}

}