/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.client.f7.StorageBizUnitF7;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class FreshCountBillEditUI extends AbstractFreshCountBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FreshCountBillEditUI.class);
    
    /**
     * output class constructor
     */
    public FreshCountBillEditUI() throws Exception
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
        com.kingdee.eas.farm.food.FreshCountBillInfo objectValue = new com.kingdee.eas.farm.food.FreshCountBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
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
		this.prmtstorageOrg.setSelector(storageF7);
		
    }

}