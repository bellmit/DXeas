/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.*;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.IIDList;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.signwasthetable.ContractTypeFactory;
import com.kingdee.eas.custom.signwasthetable.ContractTypeInfo;
import com.kingdee.eas.custom.signwasthetable.EngProject;
import com.kingdee.eas.custom.signwasthetable.EngProjectFactory;
import com.kingdee.eas.custom.signwasthetable.EngProjectInfo;
import com.kingdee.eas.custom.signwasthetable.SignBDFactory;
import com.kingdee.eas.custom.signwasthetable.SignBDInfo;
import com.kingdee.eas.custom.signwasthetable.UsedStatus;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class EngProjectListUI extends AbstractEngProjectListUI
{
	private static final Logger logger = CoreUIObject.getLogger(EngProjectListUI.class);

	/**
	 * output class constructor
	 */
	public EngProjectListUI() throws Exception
	{
		super();
		if(isF7ListUI)
			this.setDefaultEntityViewInfo(getDefaultEntityViewInfo());
	}
	public boolean isIgnoreCUFilter(){
		return true;
	}
	/**
	 * output storeFields method
	 */
	boolean isF7ListUI=false;
	public void setF7Use(boolean isF7Use, HashMap ctx) {  
		isF7ListUI = true;//标记是F7控件调用还是基础资料List  
		super.setF7Use(isF7Use, ctx);  
	}  

	/**设置一个F7过滤
	 * 首先判断List 是列表还是F7字段
	 * 如果是列表则全部显示
	 * 否则只显示  启用状态的
	 */
	protected EntityViewInfo getDefaultEntityViewInfo() {  
		if(isF7ListUI){  
			EntityViewInfo ewinfo = new EntityViewInfo();  
			FilterInfo vwFilter = new FilterInfo();            
			vwFilter.getFilterItems().add(new FilterItemInfo("billStatus",1, CompareType.EQUALS));  
			ewinfo.setFilter(vwFilter);  
			return ewinfo;  
		}else{  
			return super.getDefaultEntityViewInfo();  
		}  
	}  

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
	 * output actionPageSetup_actionPerformed
	 */
	public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPageSetup_actionPerformed(e);
	}

	/**
	 * output actionExitCurrent_actionPerformed
	 */
	public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExitCurrent_actionPerformed(e);
	}

	/**
	 * output actionHelp_actionPerformed
	 */
	public void actionHelp_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionHelp_actionPerformed(e);
	}

	/**
	 * output actionAbout_actionPerformed
	 */
	public void actionAbout_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionAbout_actionPerformed(e);
	}

	/**
	 * output actionOnLoad_actionPerformed
	 */
	public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionOnLoad_actionPerformed(e);
	}

	/**
	 * output actionSendMessage_actionPerformed
	 */
	public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSendMessage_actionPerformed(e);
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
	 * output actionRegProduct_actionPerformed
	 */
	public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionRegProduct_actionPerformed(e);
	}

	/**
	 * output actionPersonalSite_actionPerformed
	 */
	public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPersonalSite_actionPerformed(e);
	}

	/**
	 * output actionProcductVal_actionPerformed
	 */
	public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionProcductVal_actionPerformed(e);
	}

	/**
	 * output actionExportSave_actionPerformed
	 */
	public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExportSave_actionPerformed(e);
	}

	/**
	 * output actionExportSelectedSave_actionPerformed
	 */
	public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExportSelectedSave_actionPerformed(e);
	}

	/**
	 * output actionKnowStore_actionPerformed
	 */
	public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionKnowStore_actionPerformed(e);
	}

	/**
	 * output actionAnswer_actionPerformed
	 */
	public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionAnswer_actionPerformed(e);
	}

	/**
	 * output actionRemoteAssist_actionPerformed
	 */
	public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionRemoteAssist_actionPerformed(e);
	}

	/**
	 * output actionPopupCopy_actionPerformed
	 */
	public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPopupCopy_actionPerformed(e);
	}

	/**
	 * output actionHTMLForMail_actionPerformed
	 */
	public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionHTMLForMail_actionPerformed(e);
	}

	/**
	 * output actionExcelForMail_actionPerformed
	 */
	public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExcelForMail_actionPerformed(e);
	}

	/**
	 * output actionHTMLForRpt_actionPerformed
	 */
	public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionHTMLForRpt_actionPerformed(e);
	}

	/**
	 * output actionExcelForRpt_actionPerformed
	 */
	public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExcelForRpt_actionPerformed(e);
	}

	/**
	 * output actionLinkForRpt_actionPerformed
	 */
	public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionLinkForRpt_actionPerformed(e);
	}

	/**
	 * output actionPopupPaste_actionPerformed
	 */
	public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPopupPaste_actionPerformed(e);
	}

	/**
	 * output actionToolBarCustom_actionPerformed
	 */
	public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionToolBarCustom_actionPerformed(e);
	}

	/**
	 * output actionCloudFeed_actionPerformed
	 */
	public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionCloudFeed_actionPerformed(e);
	}

	/**
	 * output actionCloudShare_actionPerformed
	 */
	public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionCloudShare_actionPerformed(e);
	}

	/**
	 * output actionCloudScreen_actionPerformed
	 */
	public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionCloudScreen_actionPerformed(e);
	}

	/**
	 * output actionXunTongFeed_actionPerformed
	 */
	public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionXunTongFeed_actionPerformed(e);
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

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行!");
			SysUtil.abort();
		}
		EngProjectInfo info = EngProjectFactory.getRemoteInstance().getEngProjectInfo(new ObjectUuidPK(id));
		if(info.getBillStatus().equals(UsedStatus.trueValue))
		{
			MsgBox.showInfo("该基础资料已启用,禁止修改");
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.auditValue))
		{
			MsgBox.showInfo("该基础资料已审核,禁止修改");
			abort();
		}
		StringBuffer buffer=new StringBuffer();
		buffer.append("select  * from   T_SIG_EngProject t1");
		buffer.append(" inner join T_SIG_ContractPayment t2");
		buffer.append(" on t1.fid=t2.FEngneerProjectID");
		buffer.append(" where t1.fid='");
		buffer.append(id).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		if(rs.next()){
			int n = JOptionPane.showConfirmDialog(null, "该合同类型已被引用，确定修改吗?", "确定", JOptionPane.YES_NO_OPTION);  
			if (n == JOptionPane.YES_OPTION) {  
				super.actionEdit_actionPerformed(e);
			} else  {  
				SysUtil.abort(); 
			}		
		}    		
		super.actionEdit_actionPerformed(e);
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.btnCancel.setVisible(true);
		this.btnCancelCancel.setVisible(true);

		this.Audit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
		this.UnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
		if(isF7ListUI)
		{
			btnCancel.setEnabled(false);
			btnCancelCancel.setEnabled(false);
			btnGroupAddNew.setVisible(false);
			btnGroupEdit.setVisible(false);
			btnGroupRemove.setVisible(false);
			btnGroupMoveTree.setVisible(false);
			btnRemove.setVisible(false);
			btnMoveTree.setVisible(false);
			Audit.setVisible(false);
			UnAudit.setVisible(false);			
		}
	}
	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception
	{
		int rows=this.getSelectedRowCount(tblMain);
		if(rows>1)
		{
			MsgBox.showInfo("请不要一次删除多条基础资料");
			abort();
		}
		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行!");
			SysUtil.abort();
		}
		EngProjectInfo info = EngProjectFactory.getRemoteInstance().getEngProjectInfo(new ObjectUuidPK(id));
		if(info.getBillStatus().equals(UsedStatus.trueValue))
		{
			MsgBox.showInfo("该基础资料已启用,禁止删除");
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.auditValue))
		{
			MsgBox.showInfo("该基础资料已审核,禁止删除");
			abort();
		}
		StringBuffer buffer=new StringBuffer();
		buffer.append("select  * from   T_SIG_EngProject t1");
		buffer.append(" inner join T_SIG_ContractPayment t2");
		buffer.append(" on t1.fid=t2.FEngneerProjectID");
		buffer.append(" where t1.fid='");
		buffer.append(id).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		if(rs.next()){
			com.kingdee.eas.util.client.MsgBox.showInfo("该单据已被引用无法删除！");
			return;
		}    		
		super.actionRemove_actionPerformed(e);
	}
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
	 * output actionLocate_actionPerformed
	 */
	public void actionLocate_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionLocate_actionPerformed(e);
	}

	/**
	 * output actionQuery_actionPerformed
	 */
	public void actionQuery_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionQuery_actionPerformed(e);
	}

	/**
	 * output actionImportData_actionPerformed
	 */
	public void actionImportData_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionImportData_actionPerformed(e);
	}

	/**
	 * output actionAttachment_actionPerformed
	 */
	public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionAttachment_actionPerformed(e);
	}

	/**
	 * output actionExportData_actionPerformed
	 */
	public void actionExportData_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExportData_actionPerformed(e);
	}

	/**
	 * output actionToExcel_actionPerformed
	 */
	public void actionToExcel_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionToExcel_actionPerformed(e);
	}

	/**
	 * output actionStartWorkFlow_actionPerformed
	 */
	public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionStartWorkFlow_actionPerformed(e);
	}

	/**
	 * output actionPublishReport_actionPerformed
	 */
	public void actionPublishReport_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPublishReport_actionPerformed(e);
	}

	/**
	 * 禁用
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception
	{
		//获得选择的单据的·id
		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			abort();
		}
		//获得info
		EngProjectInfo info = EngProjectFactory.getRemoteInstance().getEngProjectInfo(new ObjectUuidPK(id));
		//非   启用和审核状态下的基础资料禁止禁用
		if(info.getBillStatus().equals(UsedStatus.auditValue)||info.getBillStatus().equals(UsedStatus.trueValue))
		{
			info.setBillStatus(UsedStatus.falseValue);//修改启用状态
			EngProjectFactory.getRemoteInstance().save(info);//保存

			this.setMessageText("该单据已禁用");
			this.showMessage();
			refreshList();//刷新列表				
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.falseValue)) abort();
		MsgBox.showInfo("该基础资料尚未审核");
	}

	/**
	 * 启用
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
	{
		//获得选择的单据的·id
		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			abort();
		}
		//获得info
		EngProjectInfo info = EngProjectFactory.getRemoteInstance().getEngProjectInfo(new ObjectUuidPK(id));
		//非   启用和审核状态下的基础资料禁止禁用
		if(info.getBillStatus().equals(UsedStatus.auditValue)||info.getBillStatus().equals(UsedStatus.falseValue))
		{
			info.setBillStatus(UsedStatus.trueValue);//修改启用状态
			EngProjectFactory.getRemoteInstance().save(info);//保存

			this.setMessageText("该单据已禁用");
			this.showMessage();
			refreshList();//刷新列表				
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.trueValue)) abort();
		MsgBox.showInfo("该基础资料尚未审核");
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();		
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			abort();
		}
		//获得info
		EngProjectInfo info = EngProjectFactory.getRemoteInstance().getEngProjectInfo(new ObjectUuidPK(id));
		if(info.getBillStatus().equals(UsedStatus.saveValue))
		{
			//将状态修改为  审核并保存
			info.setBillStatus(UsedStatus.auditValue);
			EngProjectFactory.getRemoteInstance().save(info);
			this.setMessageText("审核完成");
			this.showMessage();
			refreshList();

			abort();
		}
		MsgBox.showInfo("只有保存状态的基础资料需要审核");
		//		super.actionAudit_actionPerformed(e);
		//		refreshList();
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			abort();
		}
		//获得info
		EngProjectInfo info = EngProjectFactory.getRemoteInstance().getEngProjectInfo(new ObjectUuidPK(id));
		//非   启用和审核状态下的基础资料禁止禁用
		if(info.getBillStatus().equals(UsedStatus.auditValue)||info.getBillStatus().equals(UsedStatus.falseValue))
		{
			info.setBillStatus(UsedStatus.saveValue);//修改启用状态
			EngProjectFactory.getRemoteInstance().save(info);//保存

			this.setMessageText("该单据已禁用");
			this.showMessage();
			refreshList();//刷新列表				
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.trueValue)) 
		{
			MsgBox.showInfo("请先禁用该基础资料");
			abort();
		}
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
		return com.kingdee.eas.custom.signwasthetable.EngProjectFactory.getRemoteInstance();
	}

	/**
	 * output getTreeInterface method
	 */
	protected ITreeBase getTreeInterface() throws Exception
	{
		return com.kingdee.eas.custom.signwasthetable.EngProjectTreeFactory.getRemoteInstance();
	}

	/**
	 * output getGroupEditUIName method
	 */
	protected String getGroupEditUIName()
	{
		return com.kingdee.eas.custom.signwasthetable.client.EngProjectTreeEditUI.class.getName();
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
		return "工程项目";
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.signwasthetable.EngProjectInfo objectValue = new com.kingdee.eas.custom.signwasthetable.EngProjectInfo();

		return objectValue;
	}

}