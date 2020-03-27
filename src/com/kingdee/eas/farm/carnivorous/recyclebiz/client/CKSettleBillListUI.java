/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.core.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSaleEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class CKSettleBillListUI extends AbstractCKSettleBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKSettleBillListUI.class);

	/**
	 * output class constructor
	 */
	public CKSettleBillListUI() throws Exception{
		super();
		btnClose.setIcon(EASResource.getIcon("imgState_iconclose_1"));
		btnUnClose.setIcon(EASResource.getIcon("imgTable_success"));
	}
	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception{
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)
				||this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.CLOSED_VALUE)){
			MsgBox.showWarning("单据已经审核或关闭，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception{	
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}

		if(WorkFlowUtil.checkBillInWorkflow(null,getSelectedKeyValue())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
			SysUtil.abort();
		}

		super.actionAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}

	@Override
	public void actionUpdateSale_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionUpdateSale_actionPerformed(e);

		List<Integer> selectList = new ArrayList<Integer>();
		selectList = getSelectList();
		System.out.println(selectList);

		String billid = null;
		CKSettleBillInfo billInfo = null;
		for(int i=0,size=selectList.size();i<size;i++){
			billid = tblMain.getCell(selectList.get(i),"id").getValue().toString();
			billInfo = CKSettleBillFactory.getRemoteInstance().getCKSettleBillInfo(new ObjectUuidPK(billid));
			setSaleEntrys(billInfo);
		}
		MsgBox.showWarning("更新成功！");


	}


	private void setSaleEntrys(CKSettleBillInfo info) {
		// TODO Auto-generated method stub

		//删除销售分录
		CKSettleBillSaleEntryInfo saleInfo = null;
		for(int i = 0,size = info.getSaleEntrys().size();i<size;i++){
			saleInfo = info.getSaleEntrys().get(i);
			String s2 = "/*dialect*/ delete from CT_FM_CKSettleBillSaleEntrys where fid = '"+saleInfo.getId()+"'";
			try {
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(s2);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("/*dialect*/ select t3.FBizDate  bizDate, t3.fnumber   fnumber,t3.FBaseStatus billStatus,")
		.append(" t3.FCustomerID  customerID,t4.FQty  qty,t4.FTaxPrice taxPrice,t4.FAmount amount from")
		.append(" CT_FM_CSlaughterBill  t1 inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid")
		.append(" inner join T_IM_SaleIssueBill t3 on t3.fid = t2.FDestObjectID")
		.append(" inner join T_IM_SaleIssueEntry t4 on t4.FPARENTID = t3.fid")
		.append(" where t1.CFBillStatus in (4,7) and t1.CFBatchContractID = '").append(info.getBatchContract().getId().toString()).append("'");
		try { 
			IRowSet rs = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(sqlBuf.toString());
			Date bizDate = null;
			String fnumber = null;
			int billStatus = 1;
			String customerID = null;
			BigDecimal qty = BigDecimal.ZERO;
			BigDecimal taxPrice = BigDecimal.ZERO;
			BigDecimal amount = BigDecimal.ZERO;
			while(rs.next()) {
				//销售信息
				bizDate = rs.getDate("bizDate");
				fnumber = rs.getString("fnumber");
				billStatus = rs.getInt("billStatus");
				customerID = rs.getString("customerID");
				qty = rs.getBigDecimal("qty");
				taxPrice = rs.getBigDecimal("taxPrice");
				amount = rs.getBigDecimal("amount");

				String s5 = "/*dialect*/ SELECT newbosid('69C9FAB4') bosid FROM dual"; 
				String bosid = null;
				IRowSet r5 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s5.toString());
				if(r5.next()){ 
					bosid = r5.getString("bosid");
					if(bosid != null){
						//插入销售分录
						String s1 = "/*dialect*/ insert into  CT_FM_CKSettleBillSaleEntrys (fid,FParentID,CFBizDate,CFBillNumber,CFBaseStatus,CFCustomerID,CFRecSuttle,CFOutSalePrice,CFOutSaleAmt)" +
						" values('"+bosid+"','"+info.getId()+"', to_date('"+bizDate+"','yyyy-MM-dd') ,'"+fnumber+"','"+billStatus+"','"+customerID+"','"+qty+"','"+taxPrice+"','"+amount+"')";
						CommFacadeFactory.getRemoteInstance().excuteUpdateSql(s1);
					}
				}
			}

			//更新公司利润字段 = 审核状态的销售出库单价税合计汇总 - 总成本
			StringBuffer sql = new StringBuffer();
			sql.append("/*dialect*/ select sum(nvl(t4.FAmount,0))  amount1 from")
			.append(" CT_FM_CSlaughterBill  t1 inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid")
			.append(" inner join T_IM_SaleIssueBill t3 on t3.fid = t2.FDestObjectID")
			.append(" inner join T_IM_SaleIssueEntry t4 on t4.FPARENTID = t3.fid")
			.append(" where t1.CFBillStatus in (4,7) and t3.FBaseStatus = 4 and t1.CFBatchContractID = '").append(info.getBatchContract().getId().toString()).append("'"); 
			BigDecimal amount1 = BigDecimal.ZERO;
			IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
			if(r1.next()){
				amount1 = UIRuleUtil.getBigDecimal(r1.getBigDecimal("amount1"));
			}
			BigDecimal companyProfit = amount1.subtract(UIRuleUtil.getBigDecimal(info.getAllCost()));	
			String s1 = "/*dialect*/ update  CT_FM_CKSettleBill  set CFCompanyProfit ="+companyProfit+"  where fid = '"+info.getId()+"'";
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(s1);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	protected void btnBatchSettle_actionPerformed(ActionEvent e)
	throws Exception {
		checkSelected();
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		ICKSettleBill iBill = CKSettleBillFactory.getRemoteInstance();
		CKSettleBillInfo info;
		int num=selIDs.length;
		String error="";
		String information="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBill.getCKSettleBillInfo(new ObjectUuidPK(selIDs[i]));
//			if(!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)){
//				error+=info.getString("number")+"\t"+"只有保存状态的单据可以批量结算"+"\n";
//				num--;
//				continue;
//			}
			try{
				Map result = iBill.execSettle(info);
				if(result.get("information")!=null){
					information+=info.getString("number")+"\t"+result.get("information")+"\n";
				}
			}catch (Exception e1) {
				// TODO: handle exception
				error+=info.getString("number")+"\t"+e1.getMessage()+"\n";
				num--;
			}
		}
		try{
			if(num==selIDs.length)
				MsgBox.showConfirm3a("批量结算成功(操作单子数:"+selIDs.length+")", information);
			else if(num==0)
				throw new EASBizException(new NumericExceptionSubItem("","批量结算失败!\n"+error));
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子结算完成\n"+error+information));
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
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}

	private void initControl() throws Exception{
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tblMain.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				selectedRowChanged(e.getSelectBlock().getBeginRow());
			}});
	}

	public void actionClose_actionPerformed(ActionEvent e) throws Exception
	{	
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止关闭！");
			SysUtil.abort();
		}

		super.actionClose_actionPerformed(e);
		refreshList();
	}


	public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.CLOSED_VALUE)){
			MsgBox.showWarning("单据尚未关闭，禁止反关闭！");
			SysUtil.abort();
		}
		super.actionUnClose_actionPerformed(e);
		refreshList();
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
//			filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
//			filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
			ev.setFilter(filter);
			ds.setDefalutEntityViewInfo(ev);		
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	protected java.util.List getQueryPKFields() 
	{ 
		java.util.List pkList = new ArrayList(); 
		pkList.add("id"); 
		//        pkList.add("entrys.id"); 
		return pkList;
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo();

		return objectValue;
	}

	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0, EntityViewInfo ev) {

		SorterItemCollection sic=ev.getSorter();
		SorterItemInfo si =new SorterItemInfo("bizDate");
		si.setSortType(SortType.DESCEND);
		sic.add(si);
		ev.setSorter(sic);
		return super.getQueryExecutor(arg0, ev);
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

	
}