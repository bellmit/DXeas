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
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
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
//			MsgBox.showWarning("������δ�ύ����ֹ�ٴ���ˣ�");
//			SysUtil.abort();
//		}
//		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
//			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�ٴ���ˣ�");
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
				error+=info.getString("number")+"\t"+"���ύ״̬�ĵ��ݽ�ֹ���"+"\n";
				num--;
				continue;
			}
			iBEggCandlingBill.audit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("��˳ɹ�");
			else if(num==selIDs.length)
				MsgBox.showInfo("��˳ɹ�(����������:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("���ʧ��,����״̬�������ύ״̬�ĵ��Ӳ������");
			else if(num==0)
				MsgBox.showInfo("���ʧ��,û�з�����������ĵ���");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","������ɵ������쳣������"+num+"�ŵ���������\n"+error));
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
	 * ���ɽ��㵥
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
			MsgBox.showWarning("������δ��ˣ���ֹ����ˣ�");
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
	 * ��ѡ�� �ı��¼�
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("billStatus");
		if(list.size()>0) {
			if(list.get(0).equals("���")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);
				this.actionEdit.setEnabled(false);
			}else if(list.get(0).equals("�ύ")) {
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
		cal.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ�� 
		Date beginDate = cal.getTime();
		cal.add(Calendar.MONTH,1);//������1�� 
		cal.add(Calendar.DAY_OF_MONTH,-1);//���ڵ���һ��,�ȵõ��������һ�� 
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
	 * ִ�н���
	 * 
	 */
	public void actionExeAllCal_actionPerformed() {
		try {
			UIContext uiContext = new UIContext(this);
			IUIWindow uiWindow = null ;
			// UIFactoryName.MODEL Ϊ����ģʽ
			uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.farm.stocking.processbizill.client.ExeSettleOPUI", uiContext, null,OprtState.VIEW);
			//��ʼչ��UI
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
				error+=info.getString("number")+"\t"+"�Ǳ�����ύ״̬�ĵ��ݽ�ֹ�ύ"+"\n";
				num--;
				continue;
			}
			iStatementsBill.submit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("�ύ�ɹ�");
			else if(num==selIDs.length)
				MsgBox.showInfo("�ύ�ɹ�(����������:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("�ύʧ��,����״̬�����Ǳ�����ύ״̬�ĵ��Ӳ����ύ");
			else if(num==0)
				MsgBox.showInfo("�ύʧ��,û�з����ύ�����ĵ���");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","������ɵ������쳣������"+num+"�ŵ����ύ���\n"+error));
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