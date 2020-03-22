/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
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
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CCReceivingBillListUI extends AbstractCCReceivingBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCReceivingBillListUI.class);
    
    /**
     * output class constructor
     */
    public CCReceivingBillListUI() throws Exception
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
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
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
    	if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
    	}
        super.actionUnAudit_actionPerformed(e);
        this.actionRefresh_actionPerformed(null);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.CCReceivingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.CCReceivingBillInfo objectValue = new com.kingdee.eas.farm.food.CCReceivingBillInfo();
		
        return objectValue;
    }
    
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		String orgID="filterOrgNumber";//库存组织
		if(SysContext.getSysContext().getCurrentStorageUnit()!=null) {
			orgID=SysContext.getSysContext().getCurrentStorageUnit().getId().toString();
		}
		FilterInfo fliterInfo=super.getDefaultFilterForQuery();
		fliterInfo.getFilterItems().clear();
		fliterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",orgID,CompareType.EQUALS));
		fliterInfo.getFilterItems().add(new FilterItemInfo("fromStorageOrgUnit.id",orgID,CompareType.EQUALS));
		fliterInfo.setMaskString("#0 OR #1");
		OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
		if(orgInfo.isIsCompanyOrgUnit()) {
			try {
				ArrayList<String> list=FarmCommUtils.getToOrgIDByRelation(null, orgInfo.getId().toString(), 4, 1);
				if(list!=null&&list.size()>0) {
					HashSet set=new HashSet();
					for(String id:list) {
						set.add(id);
					}
					fliterInfo.getFilterItems().add(new FilterItemInfo("fromStorageOrgUnit.id",set,CompareType.INCLUDE));
					fliterInfo.setMaskString("#0 OR #1 OR #2");
				}
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}
		return fliterInfo;
	}
    
    public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		initControl();
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
		ArrayList list = this.getSelectedFieldValues("BillStatus");
		if(list.size()>0) {
			if(list.get(0).equals("审核")) {
				this.mBtnAudit.setEnabled(false);
				this.mBtnUnAudit.setEnabled(true);
				this.tBtnAudit.setEnabled(false);
				this.tBtnUnAudit.setEnabled(true);
				this.btnEdit.setEnabled(false);
				this.menuItemEdit.setEnabled(false);
			}else if(list.get(0).equals("提交")) {
				this.mBtnAudit.setEnabled(true);
				this.mBtnUnAudit.setEnabled(false);
				this.tBtnAudit.setEnabled(true);
				this.tBtnUnAudit.setEnabled(false);
				this.btnEdit.setEnabled(true);
				this.menuItemEdit.setEnabled(true);
			}else{
				this.mBtnAudit.setEnabled(false);
				this.mBtnUnAudit.setEnabled(false);
				this.tBtnAudit.setEnabled(false);
				this.tBtnUnAudit.setEnabled(false);
				this.btnEdit.setEnabled(true);
				this.menuItemEdit.setEnabled(true);
			}
		}
	}
	protected boolean initDefaultFilter() {
		return true;
	}
//	@Override
//	protected CommonQueryDialog initCommonQueryDialog() {
//		// TODO Auto-generated method stub
//		CommonQueryDialog ds = super.initCommonQueryDialog();
//		EntityViewInfo ev=new EntityViewInfo();
//		FilterInfo filter=new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("bizDate",new java.util.Date(),CompareType.EQUALS));
//		ev.setFilter(filter);
//		ds.setDefalutEntityViewInfo(ev);
//		return ds;
//	}
	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0, EntityViewInfo ev) {
		
		SorterItemCollection sic=new SorterItemCollection();
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
		
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
		ev.setFilter(filter);
		ds.setDefalutEntityViewInfo(ev);
		return ds;
	}
}