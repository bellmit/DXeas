/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.event.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill;
import com.kingdee.eas.farm.carnivorous.feedbiz.IDrugApplyBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DrugApplyBillListUI extends AbstractDrugApplyBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DrugApplyBillListUI.class);
    
    /**
     * output class constructor
     */
    public DrugApplyBillListUI() throws Exception
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
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output menuItemPCVoucher_actionPerformed method
     */
    protected void menuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemPCVoucher_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo();
		
        return objectValue;
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

		IDrugApplyBill  instence= (IDrugApplyBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 关闭操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.close(instence.getDrugApplyBillInfo(pk));	
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
		IDrugApplyBill  instence= (IDrugApplyBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 反关闭操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.unClose(instence.getDrugApplyBillInfo(pk));	
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
		
		IDrugApplyBill  instence= (IDrugApplyBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.audit(instence.getDrugApplyBillInfo(pk));	
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
		IDrugApplyBill  instence= (IDrugApplyBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 反审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.unAudit(instence.getDrugApplyBillInfo(pk));	
		}
		MsgBox.showInfo("反审核成功！");
		refreshList();
	}

    
    
    
    

}