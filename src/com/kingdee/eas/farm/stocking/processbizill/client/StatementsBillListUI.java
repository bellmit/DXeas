/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillInfo;
import com.kingdee.eas.farm.hatch.IBEggCandlingBill;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo;
import com.kingdee.eas.farm.stocking.hatch.IEggSettleBill;
import com.kingdee.eas.farm.stocking.processbizill.IStatementsBill;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class StatementsBillListUI extends AbstractStatementsBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(StatementsBillListUI.class);

	/**
	 * output class constructor
	 */
	public StatementsBillListUI() throws Exception
	{
		super();
	}

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{	
//		checkSelected();
//		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
//			MsgBox.showWarning("单据尚未提交，禁止再次审核！");
//			SysUtil.abort();
//		}
//		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
//			MsgBox.showWarning("单据已经审核，禁止再次审核！");
//			SysUtil.abort();
//		}
		

		checkSelected();
	
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
	
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IStatementsBill iBEggCandlingBill = StatementsBillFactory.getRemoteInstance();
	
		StatementsBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggCandlingBill.getStatementsBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"非提交状态的单据禁止审核"+"\n";
				num--;
				continue;
			}
			iBEggCandlingBill.audit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("审核失败,单据状态必须是提交状态的单子才能审核");
			else if(num==0)
				MsgBox.showInfo("审核失败,没有符合审核条件的单子");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子审核完成\n"+error));
			}
		}
		finally{
			refreshList();
		}
	
		//		super.actionAudit_actionPerformed(e);
	
		
		
//		
//		super.actionAudit_actionPerformed(e);
//		this.actionRefresh_actionPerformed(null);
	}

	/**
	 * 生成结算单
	 */
	@Override
	public void actionBreateBill_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionBreateBill_actionPerformed(e);
		HashMap<Object,Object> map = new HashMap<Object,Object>();
		ClientUtils.openChildUIFromParentUI(UIFactoryName.MODEL, "com.kingdee.eas.farm.stocking.processbizill.client.FiltrationUI", map, null, OprtState.ADDNEW);
	}

//	@Override
//	public void actionBreateBill_actionPerform(ActionEvent e)
//			throws Exception {
//		// TODO Auto-generated method stub
//		super.actionBreateBill_actionPerformed(e);
//		HashMap<Object,Object> map = new HashMap<Object,Object>();
//		ClientUtils.openChildUIFromParentUI(UIFactoryName.MODEL, "com.kingdee.eas.farm.stocking.processbizill.client.FiltrationUI", map, null, OprtState.ADDNEW);
//	}

	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}

	private void initControl() throws Exception{
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.tblMain.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				selectedRowChanged(e.getSelectBlock().getBeginRow());
			}});
		this.mBtnAllExeCal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionExeAllCal_actionPerformed();
			}});
	}
	/**
	 * 行选择 改变事件
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("billStatus");
		if(list.size()>0) {
			if(list.get(0).equals("审核")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);
				this.actionEdit.setEnabled(false);
			}else if(list.get(0).equals("提交")) {
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}else{
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
	}

	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		return super.getDefaultFilterForQuery();
	}

	protected boolean initDefaultFilter() {
		return true;
	}



	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
	}


	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0, EntityViewInfo ev) {

		SorterItemCollection sic=ev.getSorter();
		SorterItemInfo si =new SorterItemInfo("bizDate");
		si.setSortType(SortType.DESCEND);
		sic.add(si);
		ev.setSorter(sic);
		return super.getQueryExecutor(arg0, ev);
	}

	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		CommonQueryDialog ds = super.initCommonQueryDialog();
		Date nowDate = new java.util.Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		Date beginDate = cal.getTime();
		cal.add(Calendar.MONTH,1);//月增加1天 
		cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天 
		Date endDate = cal.getTime();
		try {
			PeriodInfo upperPeriodInfo = DateUtilsComm.getUpperPeriodInfo(DateUtilsComm.getCurrentPeriodInfo());
			beginDate = upperPeriodInfo.getBeginDate();
			endDate = upperPeriodInfo.getEndDate();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
		ev.setFilter(filter);
		ds.setDefalutEntityViewInfo(ev);
		return ds;
	}
	/**
	 * output actionBtnExeCal_actionPerformed
	 */
	public void actionBtnExeCal_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionBtnExeCal_actionPerformed(e);
		this.actionRefresh_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo();

		return objectValue;
	}

	/**
	 * 执行结算
	 * 
	 */
	public void actionExeAllCal_actionPerformed() {
		try {
			UIContext uiContext = new UIContext(this);
			IUIWindow uiWindow = null ;
			// UIFactoryName.MODEL 为弹出模式
			uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.farm.stocking.processbizill.client.ExeSettleOPUI", uiContext, null,OprtState.VIEW);
			//开始展现UI
			uiWindow.show();
			actionRefresh_actionPerformed(null);
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	@Override
	public void actionMultiSubmit_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IStatementsBill iStatementsBill = StatementsBillFactory.getRemoteInstance();

		StatementsBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iStatementsBill.getStatementsBillInfo(new ObjectUuidPK(selIDs[i]));
			if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"非保存或提交状态的单据禁止提交"+"\n";
				num--;
				continue;
			}
			iStatementsBill.submit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("提交成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("提交成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("提交失败,单据状态必须是保存或提交状态的单子才能提交");
			else if(num==0)
				MsgBox.showInfo("提交失败,没有符合提交条件的单子");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子提交完成\n"+error));
			}
		}
		finally{
			refreshList();
		}
		//		super.actionMultiSubmit_actionPerformed(e);
	}

	@Override
	public void actionCarryover_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCarryover_actionPerformed(e);
		HashMap<Object,Object> hashMap=new HashMap<Object, Object>();
		ClientUtils.openChildUIFromParentUI(UIFactoryName.MODEL, "com.kingdee.eas.farm.stocking.processbizill.client.CarryoverUI",hashMap , null, OprtState.ADDNEW);
	}




}