/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageBizUnitF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class FuleDaliyEditUI extends AbstractFuleDaliyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FuleDaliyEditUI.class);
    
    /**
     * output class constructor
     */
    public FuleDaliyEditUI() throws Exception
    {
        super();
        initControl();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields(); 
        if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(true);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.mBtnAudit.setEnabled(true);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(true);
			this.tBtnUnAudit.setEnabled(false);
		}else {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(false);
		}
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}
	
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionRemove_actionPerformed(e);
	}
	/**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		//this.setDataObject(this.editData);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.FuleDaliyInfo objectValue = new com.kingdee.eas.farm.food.FuleDaliyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompanyOrgUnit(SysContext.getSysContext().getCurrentFIUnit());
        StorageOrgUnitInfo so = SysContext.getSysContext().getCurrentStorageUnit();
        if(so.isIsBizUnit()) {
        	objectValue.setStorageOrgUnit(so);
        }
        objectValue.setBizDate(new java.util.Date());
        return objectValue;
    }
    private void initControl() throws Exception{
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		
		StorageBizUnitF7 storageF7 = new StorageBizUnitF7();
		storageF7.setIsCUFilter(true);
		this.prmtStorageOrgUnit.setSelector(storageF7);
		
		this.prmtStorageOrgUnit.setEnabled(false);
		this.prmtcompanyOrgUnit.setEnabled(false);
		
    }
    @Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	super.verifyInput(e);
		if(this.pkBizDate.getValue()==null) {
			MsgBox.showWarning("业务日期不能为空！");
			SysUtil.abort();
		}
		java.util.Date date=(Date) this.pkBizDate.getValue();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		date=sdf.parse(sdf.format(date));
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",date,CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",cal.getTime(),CompareType.LESS));
		if(!this.oprtState.equalsIgnoreCase("addnew")) {
			filter.getFilterItems().add(new FilterItemInfo("id",this.editData.getId().toString(),CompareType.NOTEQUALS));
		}
		ev.setFilter(filter);
		CoreBaseCollection coll = getBizInterface().getCollection(ev);
		if(coll!=null&&coll.size()>0) {
			MsgBox.showWarning("当前业务日期已经存在单据！");
			SysUtil.abort();
		}
	}
}