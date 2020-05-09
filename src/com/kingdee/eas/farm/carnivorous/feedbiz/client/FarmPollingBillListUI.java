/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill;
import com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBill;
import com.kingdee.eas.framework.query.QuickFilteringSupportItems;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class FarmPollingBillListUI extends AbstractFarmPollingBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(FarmPollingBillListUI.class);
    
    /**
     * output class constructor
     */
    public FarmPollingBillListUI() throws Exception
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
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
	}
    protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		 // 默认 
    	String companyId="";
    	if(SysContext.getSysContext().getCurrentFIUnit()!=null) {
    		companyId=SysContext.getSysContext().getCurrentFIUnit().getString("id");
    	}
		FilterInfo filterInfo  = new FilterInfo();
    	filterInfo.getFilterItems().add(new FilterItemInfo("company.id",companyId,CompareType.EQUALS));
    	
    	return filterInfo;
	}
	
	

    @Override
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	QuickFilteringSupportItems qfsi = new QuickFilteringSupportItems(true, true);
    protected QuickFilteringSupportItems getQuickFilteringSupport() {
		if (isNeedQuickQueryFilter()) {
			qfsi.getSystemSolutionItem().setSolutionInfo(getCurrentSolutionInfo());
			return qfsi;
		} else {
			return super.getQuickFilteringSupport();
		}
	}

	protected boolean isNeedQuickQueryFilter() {
		return true;
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
		
		IFarmPollingBill instence= (IFarmPollingBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.audit(instence.getFarmPollingBillInfo(pk));	
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
		IFarmPollingBill  instence= (IFarmPollingBill) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 反审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			instence.unAudit(instence.getFarmPollingBillInfo(pk));	
		}
		MsgBox.showInfo("反审核成功！");
		refreshList();
	}

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo();
		
        return objectValue;
    }

}