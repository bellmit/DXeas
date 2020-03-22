/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata.client;

import java.awt.event.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.feemanager.basedata.IDriver;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.commld.ClientUtils;

/**
 * output class name
 */
public class DriverListUI extends AbstractDriverListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DriverListUI.class);
    
    /**
     * output class constructor
     */
    public DriverListUI() throws Exception
    {
        super();
        CompanyOrgUnitInfo currAdminOrg = SysContext.getSysContext().getCurrentFIUnit();
    	if(currAdminOrg == null){
    		MsgBox.showError("非财务组织无法访问");
    		SysUtil.abort();
    	}
        this.setFilterForQuery(this.getFilterInfo());
    }
    /**
     * 设置默认过滤条件
     * 组织过滤：财务组织
     * @author Yumx
     * @return
     */
    public FilterInfo getFilterInfo(){
    	FilterInfo filterInfo  = new FilterInfo();
    	CompanyOrgUnitInfo companyOrgUnitInfo = SysContext.getSysContext().getCurrentFIUnit();
        //直接隔离
    	filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id",companyOrgUnitInfo.getId().toString(),CompareType.EQUALS));
    	
    	
    	return filterInfo;
    }
    public DriverListUI(EntityViewInfo evi) throws Exception
    {
    	
        super();
//        this.setFilterForQuery(fi);
        this.setDefaultEntityViewInfo(evi);
    }
    /**
	 * 添加过滤条件
	 * @param fi
	 */
	public void addFilter(EntityViewInfo evi){
		
		this.getDefaultFilterForQuery();
		this.setDefaultEntityViewInfo(evi);
	}

 

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon); 
	}

    
   /**
	 * 行选择 改变事件
	 * @param rowIndex
	 */
	protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.tblMain_tableSelectChanged(e);
		String baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "state").toString();
		if(baseStatus.equals("禁用")) {
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(true);
			this.actionEdit.setEnabled(false);
		}else if(baseStatus.equals("核准")) {
			this.actionCancel.setEnabled(true);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(false);
		}else{
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(true);
		}
	}
    



  @Override
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
    	// TODO Auto-generated method stub
    	super.actionCancel_actionPerformed(e);
    	refreshList();
    }
    
    @Override
    public void actionCancelCancel_actionPerformed(ActionEvent e)
    		throws Exception {
    	// TODO Auto-generated method stub
    	super.actionCancelCancel_actionPerformed(e);
		checkSelected();
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
		  return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
		  prepareCancel(null).callHandler();
		}
		cancelCancel();
    	refreshList();
    }

	 /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
//        super.actionAudit_actionPerformed(e);
    	if (this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("state")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("单据已经核准，禁止再次核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
    	IDriver  intenface= (IDriver) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 审核操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				intenface.audit(intenface.getDriverInfo(pk));
		}
		MsgBox.showInfo("核准成功！");
		refreshList();
    }
    
	 /**
     * output actionAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
//        super.actionAudit_actionPerformed(e);
    	if (!this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("state")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("未核准单据不能反核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
    	IDriver  intenface= (IDriver) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 反核准操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				intenface.unAudit(intenface.getDriverInfo(pk));		
		}
		MsgBox.showInfo("反核准成功！");
		refreshList();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feemanager.basedata.DriverFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.farm.feemanager.basedata.DriverTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.farm.feemanager.basedata.client.DriverTreeEditUI.class.getName();
    }

    /**
     * output getQueryFieldName method
     */
    protected String getQueryFieldName()
    {
        return "treeid.id";
    }

    /**
     * output getKeyFieldName method
     */
    protected String getKeyFieldName()
    {
        return "id";
    }

    /**
     * output getRootName method
     */
    protected String getRootName()
    {
        return "司机";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feemanager.basedata.DriverInfo objectValue = new com.kingdee.eas.farm.feemanager.basedata.DriverInfo();
		
        return objectValue;
    }

}