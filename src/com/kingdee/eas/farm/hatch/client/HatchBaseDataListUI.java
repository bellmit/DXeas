/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.hatchFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class HatchBaseDataListUI extends AbstractHatchBaseDataListUI
{
	private static final Logger logger = CoreUIObject.getLogger(HatchBaseDataListUI.class);

	StorageOrgUnitInfo currStoOrg;  // 当前库存组织
	 HatchBaseDataInfo hatchBaseInfo;  // 当前孵化场
	/**
	 * output class constructor
	 */
	public HatchBaseDataListUI() throws Exception
	{
		super();
		currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
//		try{
//	        currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
//	        if(currStoOrg != null){
//	        	hatchBaseInfo = hatchFacadeFactory.getRemoteInstance().getHatchBaseData(currStoOrg);
//	        }
//	        
//        }catch(BOSException bose){
//        	MsgBox.showInfo(bose.getMessage());
//        	SysUtil.abort();
//        }
        this.setFilterForQuery(this.getFilterInfo());
	}

    public FilterInfo getFilterInfo(){
    	FilterInfo filterInfo  = new FilterInfo();
    	CtrlUnitInfo currCU = SysContext.getSysContext().getCurrentCtrlUnit();
    	if(currCU == null){
    		SysUtil.abort();
    	}
    	
    	filterInfo.getFilterItems().add(new FilterItemInfo("CU.id",currCU.getId().toString(),CompareType.EQUALS));
    	// 如果当前在库存组织，则过滤 养殖场
    	if(currStoOrg != null){
    		filterInfo.getFilterItems().add(new FilterItemInfo("hatchFactory.name",currStoOrg.getName()+"%",CompareType.LIKE));
    	}
    	
    	return filterInfo;
    }
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output menuItemImportData_actionPerformed method
	 */
	protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemImportData_actionPerformed(e);
	}

	/**
	 * output treeMain_valueChanged method
	 */
	protected void treeMain_valueChanged(javax.swing.event.TreeSelectionEvent e) throws Exception
	{
		super.treeMain_valueChanged(e);
	}

	/**
	 * output chkIncludeChild_itemStateChanged method
	 */
	protected void chkIncludeChild_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
	{
		super.chkIncludeChild_itemStateChanged(e);
	}

	/**
	 * output actionExitCurrent_actionPerformed
	 */
	public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExitCurrent_actionPerformed(e);
	}

	/**
	 * output actionCalculator_actionPerformed
	 */
	public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionCalculator_actionPerformed(e);
	}

	/**
	 * output actionExport_actionPerformed
	 */
	public void actionExport_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExport_actionPerformed(e);
	}

	/**
	 * output actionExportSelected_actionPerformed
	 */
	public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExportSelected_actionPerformed(e);
	}

	/**
	 * output actionAddNew_actionPerformed
	 */
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionAddNew_actionPerformed(e);
	}

	/**
	 * output actionView_actionPerformed
	 */
	public void actionView_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionView_actionPerformed(e);
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub

		btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		btnunAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onLoad();
	}

	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id = this.getSelectedKeyValue();
		HatchBaseDataInfo info=HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(id));
		if(!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)){
			MsgBox.showInfo("单据状态不允许审核");
			abort();
		}
		super.actionAudit_actionPerformed(e);
		this.setMessageText("审核通过");
		this.showMessage();
	}

	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id = this.getSelectedKeyValue();
		HatchBaseDataInfo info=HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(id));
		if(!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit)&&!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.cancel)){
			MsgBox.showInfo("单据状态不允许反审核");
			abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.setMessageText("反审核通过");
		this.showMessage();
	}

	/**
	 * 编辑
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		String id = this.getSelectedKeyValue();
		HatchBaseDataInfo info=HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(id));
		if(!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.save)&&!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)){
			MsgBox.showInfo("单据状态不允许编辑");
			abort();
		}
		super.actionEdit_actionPerformed(e);
	}
	/**
	 * 删除
	 */
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id = this.getSelectedKeyValue();
		HatchBaseDataInfo info=HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(id));
		if(!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)&&!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.save)){
			MsgBox.showInfo("单据状态不允许删除");
			abort();
		}
		super.actionRemove_actionPerformed(e);
		refreshList();
	}

	/**
	 * output actionRefresh_actionPerformed
	 */
	public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionRefresh_actionPerformed(e);
	}

	/**
	 * output actionPrint_actionPerformed
	 */
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPrint_actionPerformed(e);
	}

	/**
	 * output actionPrintPreview_actionPerformed
	 */
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPrintPreview_actionPerformed(e);
	}

	/**
	 * output actionCancel_actionPerformed
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception
	{
		String id = this.getSelectedKeyValue();
		HatchBaseDataInfo info=HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(id));
		if(!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.cancelcancel)){
			MsgBox.showInfo("单据状态不符合禁用的条件");
			abort();
		}
		super.actionCancel_actionPerformed(e);
	}

	/**
	 * 启用
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
	{
		String id = this.getSelectedKeyValue();
		HatchBaseDataInfo info=HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(id));
		if(!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit)&&!info.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.cancel)){
			MsgBox.showInfo("单据状态不符合启用的条件");
			abort();
		}
		super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * output actionQueryScheme_actionPerformed
	 */
	public void actionQueryScheme_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionQueryScheme_actionPerformed(e);
	}

	/**
	 * output actionGroupAddNew_actionPerformed
	 */
	public void actionGroupAddNew_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionGroupAddNew_actionPerformed(e);
	}

	/**
	 * output actionGroupView_actionPerformed
	 */
	public void actionGroupView_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionGroupView_actionPerformed(e);
	}

	/**
	 * output actionGroupEdit_actionPerformed
	 */
	public void actionGroupEdit_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionGroupEdit_actionPerformed(e);
	}

	/**
	 * output actionGroupRemove_actionPerformed
	 */
	public void actionGroupRemove_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionGroupRemove_actionPerformed(e);
	}

	/**
	 * output actionGroupMoveTree_actionPerformed
	 */
	public void actionGroupMoveTree_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionGroupMoveTree_actionPerformed(e);
	}

	/**
	 * output actionMoveTree_actionPerformed
	 */
	public void actionMoveTree_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionMoveTree_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.hatch.HatchBaseDataFactory.getRemoteInstance();
	}

	/**
	 * output getTreeInterface method
	 */
	protected ITreeBase getTreeInterface() throws Exception
	{
		return com.kingdee.eas.farm.hatch.HatchBaseDataTreeFactory.getRemoteInstance();
	}

	/**
	 * output getGroupEditUIName method
	 */
	protected String getGroupEditUIName()
	{
		return com.kingdee.eas.farm.hatch.client.HatchBaseDataTreeEditUI.class.getName();
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
		return "孵化基础资料";
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.HatchBaseDataInfo objectValue = new com.kingdee.eas.farm.hatch.HatchBaseDataInfo();

		return objectValue;
	}

}