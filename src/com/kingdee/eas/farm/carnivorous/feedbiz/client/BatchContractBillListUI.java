/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class BatchContractBillListUI extends AbstractBatchContractBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(BatchContractBillListUI.class);

	/**
	 * output class constructor
	 */
	public BatchContractBillListUI() throws Exception
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
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return true;
	}
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
		checkSelected();

		//		if(WorkFlowUtil.checkBillInWorkflow(null,getSelectedKeyValue())){
		//			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
		//			SysUtil.abort();
		//		}
		//		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
		//			MsgBox.showWarning("单据尚未提交，不能审核！");
		//			SysUtil.abort();
		//		}
		//		super.actionAudit_actionPerformed(e);
		//		this.actionRefresh_actionPerformed(null);


		IBatchContractBill purorder = (IBatchContractBill) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());

			if(!this.getBizInterface().getValue(pk).get("billStatus").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
				MsgBox.showWarning("单据尚未提交，不能审核！");
				SysUtil.abort();
			}
			purorder.audit(purorder.getBatchContractBillInfo(pk));
			actionRefresh_actionPerformed(null);

		}







	}

	private String[] getSelectedListId() {
		// TODO Auto-generated method stub
		checkSelected();
		// SelectManager 是 kdtable 中行管理类
		ArrayList blocks =tblMain.getSelectManager().getBlocks();
		ArrayList idList = new ArrayList();
		Iterator iter = blocks.iterator();
		while (iter.hasNext()) {
			KDTSelectBlock block = (KDTSelectBlock) iter.next();
			int top = block.getTop();
			int bottom = block.getBottom();
			for (int rowIndex = top; rowIndex <= bottom; rowIndex++) {
				ICell cell = tblMain.getRow(rowIndex)
				.getCell(getKeyFieldName());
				if (!idList.contains(cell.getValue())) {
					idList.add(cell.getValue());
				}
			}
		}
		String[] listId = null;
		if (idList != null && idList.size() > 0) {
			Iterator iterat = idList.iterator();
			listId = new String[idList.size()];
			int index = 0;
			while (iterat.hasNext()) {
				listId[index] = (String) iterat.next();
				index++;
			}
		}
		return listId;
	}

	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		refreshList();
	}

	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionCancelCancel_actionPerformed(e);
		checkSelected();
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		IBatchContractBill iBill = BatchContractBillFactory.getRemoteInstance();
		BatchContractBillInfo info;
		int num=selIDs.length;
		String error="";
		String information=null;
		for (int i = 0;i<selIDs.length; i++) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farmer.*");
			slor.add("farm.*");
			info = iBill.getBatchContractBillInfo(new ObjectUuidPK(selIDs[i]),slor);
			information = checkIsHasUnSettle(info);
		}
		if(StringUtils.isNotBlank(information)){
			MsgBox.showWarning(information);
		}
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
			return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
			prepareCancel(null).callHandler();
		}
		cancelCancel();
		refreshList();
	}

	private String checkIsHasUnSettle(BatchContractBillInfo info) {
		StringBuffer information=new StringBuffer();
		try {
			Boolean isHasUnSettledBatch = StockingComm.isHasUnSettledBatch(null, info.getFarmer().getId().toString(), info.getFarm().getId().toString(), info.getId().toString());
			SettlePolicyInfo policy = SettlePolicyFactory.getRemoteInstance().getSettlePolicyInfo(new ObjectUuidPK(info.getSettlementPolicy().getId()));
			boolean isForbidUnSettle = UIRuleUtil.getBooleanValue(policy.isIsForbidUnSettle());
			if(isForbidUnSettle){
				if(isHasUnSettledBatch){
					MsgBox.showWarning("该养殖户/场存在未结算的批次合同,操作失败!");
					SysUtil.abort();
				}
			}else{
				if(isHasUnSettledBatch){
					information=information.append("养殖户:"+info.getFarmer().getName()).append(",养殖场:"+info.getFarm().getName()).append("存在未结算的批次合同,请注意!/n");
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return information.toString();
	}

	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		//		checkSelected();
		//		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
		//			MsgBox.showWarning("单据尚未审核，禁止反审核！");
		//			SysUtil.abort();
		//		}
		//		super.actionUnAudit_actionPerformed(e);
		//		this.actionRefresh_actionPerformed(null);


		IBatchContractBill purorder = (IBatchContractBill) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());

			if(!this.getBizInterface().getValue(pk).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
				MsgBox.showWarning("单据尚未审核，禁止反审核！");
				SysUtil.abort();
			}

			purorder.unAudit(purorder.getBatchContractBillInfo(pk));
			actionRefresh_actionPerformed(null);

		}




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
	}


	/**
	 * 行选择 改变事件
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("billStatus");
		if(list.size()>0) {
			if(list.get(0).equals("禁用")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(false);
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
			}else if(list.get(0).equals("审核")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);
				this.actionEdit.setEnabled(false);
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
			}else if(list.get(0).equals("提交")) {
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
			}else{
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
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
	protected void beforeExcutQuery(EntityViewInfo arg0) {
		// TODO Auto-generated method stub
		SorterItemCollection sorterItems = arg0.getSorter();
		SorterItemInfo sorterItem = null;
		if (sorterItems != null && sorterItems.size() == 0) {
			sorterItem = new SorterItemInfo(tblMain.getColumn("bizDate").getFieldName());
			sorterItem.setSortType(SortType.DESCEND);
			sorterItems.add(sorterItem);
		}
		super.beforeExcutQuery(arg0);
	}
	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		CommonQueryDialog ds = super.initCommonQueryDialog();
		Date nowDate = new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(sdf.format(nowDate)));
			cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			Date beginDate = cal.getTime();
			cal.add(Calendar.MONTH,1);//月增加1天 
			cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天 
			Date endDate = cal.getTime();
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
			ev.setFilter(filter);
			ds.setDefalutEntityViewInfo(ev);		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ds;
	}



	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo();

		return objectValue;
	}

}