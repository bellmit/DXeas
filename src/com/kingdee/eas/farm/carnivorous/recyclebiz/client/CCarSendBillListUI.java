/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIFactory;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.core.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class CCarSendBillListUI extends AbstractCCarSendBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(CCarSendBillListUI.class);

	/**
	 * output class constructor
	 */
	public CCarSendBillListUI() throws Exception
	{
		super();
		actionBatchSubmit.setEnabled(true);
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
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		ICCarSendBill iBill = CCarSendBillFactory.getRemoteInstance();
		CCarSendBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBill.getCCarSendBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"只有提交状态的单据可以审核"+"\n";
				num--;
				continue;
			}
			try{
				iBill.audit(info);
			}catch (Exception e1) {
				// TODO: handle exception
				error+=info.getString("number")+"\t"+e1.getMessage()+"\n";
				num--;
			}
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0)
				throw new EASBizException(new NumericExceptionSubItem("","审核失败!\n"+error));
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子审核完成\n"+error));
			}
		} 
		finally{
			refreshList();
		}
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
		ICCarSendBill iBill = CCarSendBillFactory.getRemoteInstance();
		CCarSendBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBill.getCCarSendBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"只有审核状态的单据可以反审核"+"\n";
				num--;
				continue;
			}
			try{
				iBill.unAudit(info);
			}catch (Exception e1) {
				// TODO: handle exception
				error+=info.getString("number")+"\t"+e1.getMessage()+"\n";
				num--;
			}
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("反审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("反审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0)
				throw new EASBizException(new NumericExceptionSubItem("","反审核失败!\n"+error));
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子反审核完成\n"+error));
			}
		} 
		finally{
			refreshList();
		}
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
		ICCarSendBill iBill = CCarSendBillFactory.getRemoteInstance();
		CCarSendBillInfo info;
		int num=selIDs.length;
		String error="";

		for (int i = 0;i<selIDs.length; i++) {
			info = iBill.getCCarSendBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)
					&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD)){
				error+=info.getString("number")+"\t"+"只有新增/保存/提交状态的单据可以提交"+"\n";
				num--;
				continue;
			}
			try{
				iBill.submit(info);
			}catch (Exception e1) {
				// TODO: handle exception
				error+=info.getString("number")+"\t"+e1.getMessage()+"\n";
				num--;
			}
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("提交成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("提交成功(操作单子数:"+selIDs.length+")");
			else if(num==0)
				throw new EASBizException(new NumericExceptionSubItem("","提交失败!\n"+error));
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子提交完成\n"+error));
			}
		} 
		finally{
			refreshList();
		}
	}

	private void initControl() throws Exception{

		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.tblMain.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				selectedRowChanged(e.getSelectBlock().getBeginRow());
			}});
		
		this.tblMain.getColumn("bizDate").getStyleAttributes().setNumberFormat("yyyy-MM-dd");
		this.tblMain.getColumn("auditTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
		this.tblMain.getColumn("arriveTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
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
			ds.setDefalutEntityViewInfo(ev);		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ds;
	}


	@Override
	public void actionManageSendCar_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		checkSelected();
		if(getSelectedIdValues().size()>1){
			MsgBox.showWarning("该功能不支持多条记录,请选择一条记录!");
			return;
		}
		String id=(String) getSelectedIdValues().get(0);
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("breedData.*");
		slor.add("customer.*");
		CCarSendBillInfo info=CCarSendBillFactory.getRemoteInstance().getCCarSendBillInfo(new ObjectUuidPK(id),slor);
		IUIFactory uiFactory = null;
		Map map = getUIContext();
		map.put("info",info);
		try {
			uiFactory = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UIModelDialogFactory");
			IUIWindow groupDialog = uiFactory.create("com.kingdee.eas.farm.carnivorous.recyclebiz.client.CarSendManageUI", map);
			groupDialog.show();
		} catch (BOSException ex) {
			ex.printStackTrace();
		}
		refreshList();		
	}



	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo();

		return objectValue;
	}

}