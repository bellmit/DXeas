/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BasePriceAdjustPolicyListUI extends AbstractBasePriceAdjustPolicyListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BasePriceAdjustPolicyListUI.class);
    
    /**
     * output class constructor
     */
    public BasePriceAdjustPolicyListUI() throws Exception
    {
        super();
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.btnCancel.setVisible(true);
		this.btnCancel.setEnabled(true);
		this.btnCancelCancel.setVisible(true);
		this.btnCancelCancel.setEnabled(true);
	}

    
    
    
	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		IBasePriceAdjustPolicy iBasePriceAdjustPolicy = (IBasePriceAdjustPolicy)getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		if(billIdlist.length != 0){
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(FarmBaseStatusEnum.APPROVE_VALUE)
				|| this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(FarmBaseStatusEnum.FROZEN_VALUE)){
			MsgBox.showWarning("单据已经核准或者禁用，不允许修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
		}else{
			MsgBox.showWarning("请选择记录行！");
			SysUtil.abort();
		}
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
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    @Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		actionRefresh_actionPerformed(e);
	}


	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{

		
		IBasePriceAdjustPolicy iBasePriceAdjustPolicy = (IBasePriceAdjustPolicy)getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		if(billIdlist.length != 0){
		for(int j=0;j<billIdlist.length;j++){
		if (this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("单据已经核准，禁止再次核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
    	
				// 审核操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				iBasePriceAdjustPolicy.audit(iBasePriceAdjustPolicy.getBasePriceAdjustPolicyInfo(pk));	
		}
		MsgBox.showInfo("核准成功！");
		refreshList();
		}else{
			MsgBox.showWarning("请选择记录行！");
		}
    }

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
        
		
		
		
		
		IBasePriceAdjustPolicy iBasePriceAdjustPolicy = (IBasePriceAdjustPolicy)getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		if(billIdlist.length != 0){
		for(int j=0;j<billIdlist.length;j++){
    	if (!this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("未核准单据不能反核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
				// 反核准操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				iBasePriceAdjustPolicy.unAudit(iBasePriceAdjustPolicy.getBasePriceAdjustPolicyInfo(pk));	
		}
		MsgBox.showInfo("反核准成功！");
		refreshList();
		}else{
			MsgBox.showWarning("请选择记录行！");
		}
    }


	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception{
		// TODO Auto-generated method stub
		checkSelected();
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
		  return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
		  prepareCancel(null).callHandler();
		}
		cancelCancel();
		actionRefresh_actionPerformed(e);
	}


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo();
		
        return objectValue;
    }

}