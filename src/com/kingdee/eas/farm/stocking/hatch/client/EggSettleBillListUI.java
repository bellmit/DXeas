/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillInfo;
import com.kingdee.eas.farm.hatch.IBEggCandlingBill;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo;
import com.kingdee.eas.farm.stocking.hatch.IEggSettleBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
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
public class EggSettleBillListUI extends AbstractEggSettleBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(EggSettleBillListUI.class);

	/**
	 * output class constructor
	 */
	public EggSettleBillListUI() throws Exception
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

		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
		selIDs=commUtils.arrayListClearSamevalue(selIDs);

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IEggSettleBill iBEggCandlingBill = EggSettleBillFactory.getRemoteInstance();

		EggSettleBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggCandlingBill.getEggSettleBillInfo(new ObjectUuidPK(selIDs[i]));
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
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		IEggSettleBill iBEggCandlingBill = EggSettleBillFactory.getRemoteInstance();

		EggSettleBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggCandlingBill.getEggSettleBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"非审核状态的单据禁止反审核"+"\n";
				num--;
				continue;
			}
			iBEggCandlingBill.unAudit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("反审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("反审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("反审核失败,单据状态必须是审核状态的单子才能反审核");
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


	/**
	 * 批量提交
	 */
	@Override
	public void actionBatchSubmit_actionPerformed(ActionEvent e)
	throws Exception {	

		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		IEggSettleBill iBEggCandlingBill = EggSettleBillFactory.getRemoteInstance();

		EggSettleBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggCandlingBill.getEggSettleBillInfo(new ObjectUuidPK(selIDs[i]));
			if(info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"已审核的单据禁止提交"+"\n";
				num--;
				continue;
			}
			iBEggCandlingBill.submit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("提交成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("提交成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("提交失败,单据状态必须是保存或者提交状态的单子才能进行此操作");
			else if(num==0)
				MsgBox.showInfo("提交失败,没有符合提交条件的单子");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子提交完成\n"+error));
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

	@Override
	public OrgUnitInfo getMainOrgInfo() {
		// TODO Auto-generated method stub
		return super.getMainOrgInfo();
	}


	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo filter = super.getDefaultFilterForQuery();
		String mskStr = filter.getMaskString();
		int size = filter.getFilterItems().size();
		String stoOrgUnitID = "";
		if(SysContext.getSysContext().getCurrentStorageUnit()!=null){
			stoOrgUnitID = SysContext.getSysContext().getCurrentStorageUnit().getString("id");
			StorageOrgUnitInfo info;
			try {
				info = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(stoOrgUnitID));
				filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.longNumber",info.getLongNumber()+"%",CompareType.LIKE));

				filter.setMaskString("("+mskStr+") and #"+size);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return filter;
	}


	@Override
	public EntityViewInfo getMainQuery() {
		// TODO Auto-generated method stub
		return super.getMainQuery();
	}


	@Override
	public IMetaDataPK getMainQueryPK() {
		// TODO Auto-generated method stub
		return super.getMainQueryPK();
	}


	protected boolean initDefaultFilter() {
		return true;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
		//		apendFootRow(tblMain,new String[]{"entrys.num","entrys.settleQty","entrys.amount"});
	}




	@Override
	public void afterActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		super.afterActionPerformed(arg0);
		//		apendFootRow(tblMain,new String[]{"entrys.num","entrys.settleQty","entrys.amount"});
	}


	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0, EntityViewInfo ev) {

		SorterItemCollection sic=new SorterItemCollection();
		SorterItemInfo si =new SorterItemInfo("number");
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");



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
	 * output actionExeSettle_actionPerformed
	 */
	public void actionExeSettle_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExeSettle_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo();

		return objectValue;
	}


	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		ICell cell = row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (obj != null) {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
		}  
	}
	/**
	 * 批量删除单据
	 */
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> idList = this.getSelectedIdValues();
		EggSettleBillInfo info;
		for(int i=0;i<idList.size();i++)
			EggSettleBillFactory.getRemoteInstance().delete(new ObjectUuidPK(idList.get(i)));
		super.actionRemove_actionPerformed(e);
	}
}