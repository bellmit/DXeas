/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
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
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class FodderReceiveBillListUI extends AbstractFodderReceiveBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(FodderReceiveBillListUI.class);

	/**
	 * output class constructor
	 */
	public FodderReceiveBillListUI() throws Exception
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
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
			MsgBox.showWarning("单据尚未提交，禁止再次审核！");
			SysUtil.abort();
		}
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
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

		SorterItemCollection sorterItems=ev.getSorter();
		SorterItemInfo sorterItem = null;

		if(sorterItems.size()==1){
			sorterItem = new SorterItemInfo(tblMain.getColumn("id").getFieldName());
			sorterItem.setSortType(SortType.ASCEND);
			if(sorterItems.getSorter().get(0).equals(sorterItem))
				sorterItems.clear();
		}

		if (sorterItems != null && sorterItems.size() == 0) {
			sorterItem = new SorterItemInfo(tblMain.getColumn("bizDate").getFieldName());
			sorterItem.setSortType(SortType.DESCEND);
			sorterItems.add(sorterItem);
			sorterItem = new SorterItemInfo(tblMain.getColumn("number").getFieldName());
			sorterItem.setSortType(SortType.DESCEND);
			sorterItems.add(sorterItem);
			sorterItem = new SorterItemInfo(tblMain.getColumn("entrys.seq").getFieldName());
			sorterItem.setSortType(SortType.ASCEND);
			sorterItems.add(sorterItem);
		}
		ev.setSorter(sorterItems);
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

		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
		ev.setFilter(filter);
		ds.setDefalutEntityViewInfo(ev);
		return ds;
	}


	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillInfo();

		return objectValue;
	}
	@Override
	protected java.util.List getQueryPKFields() 
	{ 
		return super.getQueryPKFields();
		//        java.util.List pkList = new ArrayList(); 
		//        pkList.add("id"); 
		////        pkList.add("entrys.id"); 
		//        return pkList;
	}

	@Override
	public void actionChkVoucherAll_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		updateVoucherFlag("");
		super.actionChkVoucherAll_actionPerformed(e);
		MsgBox.showInfo("校验完成");
		refreshList();
	}

	@Override
	public void actionChkVoucherFlag_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		checkSelected();
		ArrayList<String> list=new ArrayList<String>();
		String ids;
		String[] id = KDTableUtil.getSelectRowFieldValue(tblMain,getKeyFieldName());
		for(int i=0;i<id.length;i++){
			ids=id[i];
			if(!list.contains(ids))
				list.add(ids);
		}

		for(int i=0;i<list.size();i++){
			updateVoucherFlag(list.get(i));
		}
		super.actionChkVoucherFlag_actionPerformed(e);
		MsgBox.showInfo("校验完成");
		refreshList();
	}
	
	/**
	 * 校验凭证标志
	 * @param string
	 */
	private void updateVoucherFlag(String id) {
		try {
			String str = "/*dialect*/update T_FM_FodderReceiveBill t5 set (t5.FFivouchered,t5.FVoucherNum) =(select case when max(t3.FID) is not null then 1 else 0 end,max(t3.FNumber) from T_BOT_Relation t1 left join T_BOT_Relation t2 on  t1.FDestObjectID=t2.FSrcObjectID left join T_GL_Voucher t3 on t3.FID=t2.FDestObjectID where 1=1 and t1.FSrcObjectID=t5.FID";
			//原始单据ID
			if(StringUtils.isNotEmpty(id)){
				str+=" and t1.FSrcObjectID='"+id+"'";
			}
			str+=" and t5.FCompanyID='"+ClientUtils.getCurrentFIUnit().getString("id")+"')";
//			System.out.println(str);
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(str);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}