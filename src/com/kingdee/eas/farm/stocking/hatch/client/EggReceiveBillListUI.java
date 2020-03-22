/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.bot.BOTRelation;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.breed.layegg.BillStatus;
import com.kingdee.eas.farm.breed.layegg.ILifeFee;
import com.kingdee.eas.farm.breed.layegg.LifeFeeFactory;
import com.kingdee.eas.farm.breed.layegg.LifeFeeInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillCollection;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory;
import com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class EggReceiveBillListUI extends AbstractEggReceiveBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(EggReceiveBillListUI.class);

	/**
	 * output class constructor
	 */
	public EggReceiveBillListUI() throws Exception
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



	@Override
	public List<String> getFieldSumList() {
		// TODO Auto-generated method stub
		
		List<String> sumFieldNames = new  ArrayList<String>();
		sumFieldNames.add("entrys.effectAllQty");
		sumFieldNames.add("entrys.sendAllQty");
		sumFieldNames.add("entrys.brokenQty");
		sumFieldNames.add("entrys.allQty");
		sumFieldNames.add("entrys.wrongSharpEgg");
		sumFieldNames.add("entrys.eggLiquid");
		return sumFieldNames;
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{	

		// TODO Auto-generated method stub

		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IEggReceiveBill iEggReceive = EggReceiveBillFactory.getRemoteInstance();

		EggReceiveBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iEggReceive.getEggReceiveBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"非提交状态的单据禁止审核"+"\n";
				num--;
				continue;
			}
			iEggReceive.audit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("审核失败");
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

	}

	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{	
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IEggReceiveBill iEggReceive = EggReceiveBillFactory.getRemoteInstance();

		EggReceiveBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iEggReceive.getEggReceiveBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"非提交状态的单据禁止反审核"+"\n";
				num--;
				continue;
			}
			iEggReceive.unAudit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("反审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("反审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("反审核失败");
			else if(num==0)
				MsgBox.showInfo("反审核失败,没有符合反审核条件的单子");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子反审核完成\n"+error));
			}
		}
		finally{
			refreshList();
		}

		//		super.actionAudit_actionPerformed(e);


	}

	private void initControl() throws Exception{
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		getFieldSumList();
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
		FilterInfo filter = super.getDefaultFilterForQuery();

		//检查是否具有初始化权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "viewAllBillstockingHatch");
		}catch(Exception err) {
			//库存组织过滤
			if(SysContext.getSysContext().getCurrentStorageUnit()!=null) {
				filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",SysContext.getSysContext().getCurrentStorageUnit().getString("id"),CompareType.EQUALS));
				filter.setMaskString("("+filter.getMaskString()+") AND #"+(filter.getFilterItems().size()-1));
			}
		}


		return filter;
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
			sorterItem = new SorterItemInfo(tblMain.getColumn("number").getFieldName());
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
		Calendar cal=Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		Date beginDate = cal.getTime();
		cal.add(Calendar.MONTH,1);//月增加1天 
		cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天 
		Date endDate = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		try {
			filter.getFilterItems().add(new FilterItemInfo("bizDate",sdf1.parse(sdf.format(beginDate)+" 00:00:00"),CompareType.GREATER_EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("bizDate",sdf1.parse(sdf.format(endDate)+" 23:59:55"),CompareType.LESS_EQUALS));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ev.setFilter(filter);
		ds.setDefalutEntityViewInfo(ev);
		return ds;
	}


	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo();

		return objectValue;
	}
	@Override
	public void actionDeleteDownBill_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		String id = this.getSelectedKeyValue();
		if(id==null)
			return;
		ArrayList<String> list = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(id, "7DD0D62D");
		BOTRelationCollection coll;
		EntityViewInfo evi=new EntityViewInfo();
		if(list.size()>0){
			int result=MsgBox.showConfirm2("确认删除所有下游结算单么？");
			if(result==0){
				for(int i=0;i<list.size();i++){
					FilterInfo filter=new FilterInfo();
					filter.getFilterItems().add(new FilterItemInfo("SrcObjectID",id,CompareType.EQUALS));
					filter.getFilterItems().add(new FilterItemInfo("DestObjectID",list.get(i),CompareType.EQUALS));
					evi.setFilter(filter);
					coll = BOTRelationFactory.getRemoteInstance().getCollection(evi);
					EggSettleBillFactory.getRemoteInstance().delete(new ObjectUuidPK(list.get(i)));
					BOTRelationFactory.getRemoteInstance().delete(new ObjectUuidPK(coll.get(0).getString("id")));
				}
				MsgBox.showInfo("删除成功，此次共删除"+list.size()+"张结算单据");
			}
		}
	}
}