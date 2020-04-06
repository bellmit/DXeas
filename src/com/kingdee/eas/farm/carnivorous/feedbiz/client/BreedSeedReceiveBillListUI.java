/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
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
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BreedSeedReceiveBillListUI extends AbstractBreedSeedReceiveBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(BreedSeedReceiveBillListUI.class);

	/**
	 * output class constructor
	 */
	public BreedSeedReceiveBillListUI() throws Exception
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

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo();

		return objectValue;
	}

	@Override
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return true;
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
		MsgBox.showInfo("校验完成");
		refreshList();
		super.actionChkVoucherFlag_actionPerformed(e);
	}
	/**
	 * 校验凭证标志
	 * @param string
	 */
	private void updateVoucherFlag(String id) {
		try {
			String str = "/*dialect*/update T_FM_BreedSeedReceiveBill t5 set (t5.FFivouchered,t5.FVoucherNum) =(select case when max(t3.FID) is not null then 1 else 0 end,max(t3.FNumber) from T_BOT_Relation t1 left join T_BOT_Relation t2 on  t1.FDestObjectID=t2.FSrcObjectID left join T_GL_Voucher t3 on t3.FID=t2.FDestObjectID where 1=1 and t1.FSrcObjectID=t5.FID";
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

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception{
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)
				||this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.CLOSED_VALUE)){
			MsgBox.showWarning("单据已经审核或关闭，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionClose_actionPerformed(ActionEvent e) throws Exception{	
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止关闭！");
			SysUtil.abort();
		}

		IBreedSeedReceiveBill  instence= (IBreedSeedReceiveBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 关闭操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.close(instence.getBreedSeedReceiveBillInfo(pk));	
		}
		MsgBox.showInfo("关闭成功！");
		refreshList();
	}


	public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.CLOSED_VALUE)){
			MsgBox.showWarning("单据尚未关闭，禁止反关闭！");
			SysUtil.abort();
		}
		IBreedSeedReceiveBill  instence= (IBreedSeedReceiveBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 反关闭操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.unClose(instence.getBreedSeedReceiveBillInfo(pk));	
		}
		MsgBox.showInfo("反关闭成功！");
		refreshList();
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

		IBreedSeedReceiveBill  instence= (IBreedSeedReceiveBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.audit(instence.getBreedSeedReceiveBillInfo(pk));	
		}
		MsgBox.showInfo("审核成功！");
		refreshList();
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
		IBreedSeedReceiveBill  instence= (IBreedSeedReceiveBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 反审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.unAudit(instence.getBreedSeedReceiveBillInfo(pk));	
		}
		MsgBox.showInfo("反审核成功！");
		refreshList();
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


	//	@Override
	//	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0, EntityViewInfo ev) {
	//		
	//		SorterItemCollection sic=new SorterItemCollection();
	//		SorterItemInfo si =new SorterItemInfo("number");
	//		si.setSortType(SortType.DESCEND);
	//		sic.add(si);
	//		ev.setSorter(sic);
	//		return super.getQueryExecutor(arg0, ev);
	//	}


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

	@Override
	public void actionUpdatePrice_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionUpdatePrice_actionPerformed(e);
		Map map=new UIContext(this);
		//弹出UI界面
		IUIWindow uiWindow=null; 
		String scanUI = "com.kingdee.eas.farm.carnivorous.basedata.client.UpdatePriceByMaterial";
		uiWindow = (UIModelDialog) UIFactory.createUIFactory(UIFactoryName.MODEL).create(
				scanUI, map, null, OprtState.VIEW);
		uiWindow.show();

		//获取返回的 结算政策
		Map<String,BigDecimal> uiMap = (Map<String, BigDecimal>) uiWindow.getUIObject().getUIContext().get("matEntry");
		if(uiMap != null && uiMap.size() > 0){
		//获取选中行
		List<Integer> selectList = new ArrayList<Integer>();
		selectList = getSelectList();
		System.out.println(selectList);
		String billid = null;
		for(int i=0,size=selectList.size();i<size;i++){
			//根据返回的Map，后台更新或者插入结算政策的投入政策分录信息
			billid = tblMain.getCell(selectList.get(i),"id").getValue().toString();

			BreedSeedReceiveBillInfo billInfo = BreedSeedReceiveBillFactory.getRemoteInstance().getBreedSeedReceiveBillInfo(new ObjectUuidPK(billid));
			BreedSeedReceiveBillEntryCollection entryColl = billInfo.getEntrys();
			BreedSeedReceiveBillEntryInfo entryInfo = null;
			for(int j = 0,s = entryColl.size();j<s;j++){
				entryInfo = BreedSeedReceiveBillEntryFactory.getRemoteInstance().getBreedSeedReceiveBillEntryInfo(new ObjectUuidPK(entryColl.get(j).get("id").toString()));
				BigDecimal qty = UIRuleUtil.getBigDecimal(entryInfo.getAllReceiveQty());
				if(uiMap.get(entryInfo.getMaterial().getId().toString()) != null){
					BigDecimal price = uiMap.get(entryInfo.getMaterial().getId().toString());;
					//价格大于0，执行更新操作
					if(price.compareTo(BigDecimal.ZERO) > 0){
						BigDecimal amount = price.multiply(qty);
						String s1 = "/*dialect*/ update T_FM_BreedSeedReceiveBillentry  set FReceivePrice = "+price+" , CFPolicySettleAmt = "+amount+" where fid = '"+entryInfo.getId()+"'";
						CommFacadeFactory.getRemoteInstance().excuteUpdateSql(s1);
					}
				}
			}
		}
		if(uiMap != null && uiMap.size() > 0){
			MsgBox.showWarning("更新单价完成！");
		}
	}
	}
}