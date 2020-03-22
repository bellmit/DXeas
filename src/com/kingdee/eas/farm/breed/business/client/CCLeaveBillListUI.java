/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageBizUnitF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CCLeaveBillListUI extends AbstractCCLeaveBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCLeaveBillListUI.class);
    
    /**
     * output class constructor
     */
    public CCLeaveBillListUI() throws Exception
    {
        super();
    }


    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)||this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.FINISH_VALUE)){
    		MsgBox.showWarning("单据已经审核或完成，禁止修改！");
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
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)||this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.FINISH_VALUE)){
    		MsgBox.showWarning("单据已经审核或完成，禁止再次审核！");
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
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)||this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.FINISH_VALUE)){
    		MsgBox.showWarning("单据已经审核或完成，禁止反审核！");
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
        return com.kingdee.eas.farm.breed.business.CCLeaveBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.business.CCLeaveBillInfo objectValue = new com.kingdee.eas.farm.breed.business.CCLeaveBillInfo();
       
        return objectValue;
    }
    @Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		String orgID="filterOrgNumber";
		if(SysContext.getSysContext().getCurrentStorageUnit()!=null)
			orgID=SysContext.getSysContext().getCurrentStorageUnit().getId().toString();
		FilterInfo fliterInfo=super.getDefaultFilterForQuery();
		fliterInfo.getFilterItems().clear();
		fliterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",orgID,CompareType.EQUALS));
		fliterInfo.setMaskString("#0");
		OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
		if(orgInfo.isIsCompanyOrgUnit()) {
			try {
				ArrayList<String> list=FarmCommUtils.getToOrgIDByRelation(null, orgInfo.getId().toString(), 4, 1);
				if(list!=null&&list.size()>0) {
					HashSet set=new HashSet();
					for(String id:list) {
						set.add(id);
					}
					fliterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",set,CompareType.INCLUDE));
					fliterInfo.setMaskString("#0 OR #1");
				}
			} catch (BOSException e) {
				e.printStackTrace();
			}
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
		
		this.tblMain.addKDTMouseListener(new KDTMouseListener(){
			public void tableClicked(KDTMouseEvent e) {
				selectedRowChanged(e.getRowIndex());
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
			} else  if(list.get(0).equals("完成")) {
				this.mBtnAudit.setEnabled(false);
				this.mBtnUnAudit.setEnabled(false);
				this.tBtnAudit.setEnabled(false);
				this.tBtnUnAudit.setEnabled(false);
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

    
}