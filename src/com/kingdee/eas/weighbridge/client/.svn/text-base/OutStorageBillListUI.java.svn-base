/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.WeighBaseStatus;

/**
 * output class name
 */
public class OutStorageBillListUI extends AbstractOutStorageBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(OutStorageBillListUI.class);
    
    /**
     * output class constructor
     */
    public OutStorageBillListUI() throws Exception
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
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }


    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(WeighBaseStatus.AUDIT_VALUE)||this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(WeighBaseStatus.FINISH_VALUE)){
			MsgBox.showWarning("单据已经完成或审核，禁止修改！");
			SysUtil.abort();
    	}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.OutStorageBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.OutStorageBillInfo objectValue = new com.kingdee.eas.weighbridge.OutStorageBillInfo();
		
        return objectValue;
    }
    @Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
    	String orgID="filterOrgNumber";
		OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
		orgID=orgInfo.getId().toString();
		FilterInfo fliterInfo=super.getDefaultFilterForQuery();
		fliterInfo.getFilterItems().clear();
		fliterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",orgID,CompareType.EQUALS));
		fliterInfo.getFilterItems().add(new FilterItemInfo("orderStorageOrgUnit.id",orgID,CompareType.EQUALS));
		fliterInfo.setMaskString("#0 OR #1");
		if(orgInfo.isIsCompanyOrgUnit()) {
			fliterInfo.getFilterItems().add(new FilterItemInfo("company.id",orgID,CompareType.EQUALS));
			fliterInfo.setMaskString("#0 OR #1 OR #2");
		}
		return fliterInfo;
	}
    @Override
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
		
		this.btnCancel.setVisible(true);
		this.btnCancelCancel.setVisible(true);
	}
	/**
	 * 行选择 改变事件
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("billStatus");
		if(list.size()>0) {
			if(list.get(0).equals(WeighBaseStatus.audit.getAlias())) {
				this.mBtnAudit.setEnabled(false);
				this.mBtnUnAudit.setEnabled(true);
				this.tBtnAudit.setEnabled(false);
				this.tBtnUnAudit.setEnabled(true);
				this.btnEdit.setEnabled(false);
				this.menuItemEdit.setEnabled(false);
			} else if(list.get(0).equals(WeighBaseStatus.finish.getAlias())) {
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

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}
	protected boolean initDefaultFilter() {
		return true;
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