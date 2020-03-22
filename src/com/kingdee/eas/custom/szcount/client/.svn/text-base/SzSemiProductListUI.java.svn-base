/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.szcount.ISzSemiProduct;
import com.kingdee.eas.custom.szcount.SzSemiProductFactory;
import com.kingdee.eas.custom.szcount.SzSemiProductInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.client.UITools;

/**
 * output class name
 */
public class SzSemiProductListUI extends AbstractSzSemiProductListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SzSemiProductListUI.class);
    
    /**
     * output class constructor
     */
    public SzSemiProductListUI() throws Exception
    {
        super();
        this.setUITitle("德翔计数");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }


    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }
    @Override
	protected void refresh(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.refresh(e);
		String[] tableclick = new  String[] {"entrys.weight"};
        UITools.apendFootRow(tblMain,tableclick);
	}


    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("Status").equals(BillBaseStatusEnum.AUDITED_VALUE)){
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("Status").equals(BillBaseStatusEnum.AUDITED_VALUE)){
    		MsgBox.showWarning("单据已经审核，禁止删除！");
    		SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("Status").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
    	}
    	if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("Status").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
    	}
        super.actionAudit_actionPerformed(e);
        this.actionRefresh_actionPerformed(null);
    }

    /**
     * output actionUnaudit_actionPerformed
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("Status").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
    	}
        super.actionUnaudit_actionPerformed(e);
        this.actionRefresh_actionPerformed(null);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.szcount.SzSemiProductFactory.getRemoteInstance();
    }
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.szcount.SzSemiProductInfo objectValue = new com.kingdee.eas.custom.szcount.SzSemiProductInfo();
		
        return objectValue;
    }
    

	@Override
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		String companyId="123";
		if(SysContext.getSysContext().getCurrentFIUnit()!=null) {
			companyId=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		}
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",companyId,CompareType.EQUALS));
		return filter;
	}

	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		return super.initCommonQueryDialog();
	}

	@Override
	protected boolean initDefaultFilter() {
		return true;
	}

	@Override
	public void actionAllAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
	 	checkSelected();
	/*	String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		if (!currentCompanyId.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("非集团组织下不允许审核！");
			SysUtil.abort();
		}*/
		ArrayList ids = getSelectedIdValues();
		String number = "";
		int a = 0;
		int b = ids.size();
		ISzSemiProduct is = SzSemiProductFactory.getRemoteInstance();
		//ISupplierReq is = SupplierReqFactory.getRemoteInstance();
		SzSemiProductInfo info ;
		for (int i = 0; i < ids.size(); ++i) {
			if (ids.get(i) == null)
				continue;
			info = is.getSzSemiProductInfo(new ObjectUuidPK(ids.get(i).toString()));
			//if (info.getBillStatus().equals(bdaApplyBillStatus.Audit)|| info.getBillStatus().equals(bdaApplyBillStatus.unAudit)) {// 已经审核或审核不通过
			if (!info.getStatus().equals(BillBaseStatusEnum.SUBMITED)) {//操作已经提交的单据
				if (StringUtils.isNotBlank(number)) 
					number +=",";
					
				if (StringUtils.isNotBlank(info.getNumber())) {
					number += info.getNumber();
					a= a+1;
				}
				else {
					number +="选择的第"+(i+1)+"行";
					a= a+1;
				}
			} else {
				is.audit(info);//supplierAudit(info);
			}
		}
        if(StringUtils.isBlank(number)){
        	MsgBox.showInfo("共"+b+"张单据批量审核成功！");
        }else{
        	MsgBox.showError("审核成功"+(b-a)+"张，审核失败"+a+"张。\n"+number+"\n非提交状态单据，审核不通过！");
        }
        refresh(e);
		super.actionAllAudit_actionPerformed(e);
		
	}
	
    
}