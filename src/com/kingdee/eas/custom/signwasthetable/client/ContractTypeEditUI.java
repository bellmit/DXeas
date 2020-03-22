/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.*;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.master.cssp.UsedStatusEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.signwasthetable.UsedStatus;
import com.kingdee.eas.custom.wlhllicensemanager.DynamicFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class ContractTypeEditUI extends AbstractContractTypeEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(ContractTypeEditUI.class);

	/**
	 * output class constructor
	 */
	public ContractTypeEditUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		
		//设置按钮不可见
		this.btnSave.setVisible(false);
		this.btnCopy.setVisible(false);
		this.btnPrint.setVisible(false);
		this.btnPrintPreview.setVisible(false);
		this.btnRemove.setVerticalAlignment(1);
		this.kDSeparatorCloud.setVisible(false);

		if(this.oprtState.equals("ADDNEW")||this.oprtState.equals("EDIT"))
		{
			actionAudit.setEnabled(false);
			actionUnAudit.setEnabled(false);
		}
		if(this.oprtState.equals("VIEW"))
		{
			actionAudit.setEnabled(true);
			actionUnAudit.setEnabled(true);
			this.btnCancel.setEnabled(true);
			this.btnCancelCancel.setEnabled(true);
		}
		//审核状态，启用和禁用按钮可用
		if(!this.editData.getBillStatus().equals(UsedStatus.saveValue))
		{
			this.btnCancel.setEnabled(true);
			this.btnCancelCancel.setEnabled(true);
		}
		//修改图标
		this.cTypeAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
		this.cTypeUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
		this.cTypeAudit.setHideActionText(true);
		this.cTypeUnAudit.setHideActionText(true);
	}

	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
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
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSubmit_actionPerformed(e);
	}

	/**
	 * output actionCancel_actionPerformed
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(UsedStatus.auditValue)||this.editData.getBillStatus().equals(UsedStatus.trueValue))
		{
			//调用facade保存
			com.kingdee.eas.custom.signwasthetable.signTableSysFacadeFactory.getRemoteInstance().cTypeCancel(editData.getId().toString());
			this.setMessageText("禁用成功");
			this.showMessage();
			refreshCurPage();			
			abort();
		}
		if(this.editData.getBillStatus().equals(UsedStatus.saveValue)) abort();
		MsgBox.showInfo("只能禁用启用、审核状态的基础资料");
		//        super.actionCancel_actionPerformed(e);
	}

	/**
	 * output actionCancelCancel_actionPerformed
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(UsedStatus.auditValue)||this.editData.getBillStatus().equals(UsedStatus.falseValue))
		{
			//调用facade保存
			com.kingdee.eas.custom.signwasthetable.signTableSysFacadeFactory.getRemoteInstance().cTypeCancelCancel(editData.getId().toString());
			this.setMessageText("启用成功");
			this.showMessage();
			refreshCurPage();			
			abort();
		}
		if(this.editData.getBillStatus().equals(UsedStatus.trueValue)) abort();
		MsgBox.showInfo("只能启用审核、禁用状态的基础资料");
		//        super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * output actionFirst_actionPerformed
	 */
	public void actionFirst_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionFirst_actionPerformed(e);
	}

	/**
	 * output actionPre_actionPerformed
	 */
	public void actionPre_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPre_actionPerformed(e);
	}

	/**
	 * output actionNext_actionPerformed
	 */
	public void actionNext_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionNext_actionPerformed(e);
	}

	/**
	 * output actionLast_actionPerformed
	 */
	public void actionLast_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionLast_actionPerformed(e);
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
	 * output actionCopy_actionPerformed
	 */
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionCopy_actionPerformed(e);
	}

	/**
	 * output actionAddNew_actionPerformed
	 */
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionAddNew_actionPerformed(e);
	}

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData.getBillStatus().equals(UsedStatus.auditValue))
		{
			MsgBox.showInfo("已审核的基础资料禁止修改");
			abort();
		}
		if(editData.getBillStatus().equals(UsedStatus.trueValue))
		{
			MsgBox.showInfo("已启用的基础资料禁止修改");
			abort();
		}

		String id=this.editData.getId().toString();
		StringBuffer buffer=new StringBuffer();
		buffer.append("select  * from   T_SIG_ContractType t1");
		buffer.append(" inner join T_SIG_Contract t2");
		buffer.append(" on t1.fid=t2.FContractTypeID");
		buffer.append(" where t1.fid='");    	
		buffer.append(id).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		if(rs.next()){
			if(rs.next()){
				int n = JOptionPane.showConfirmDialog(null, "该基础资料已被引用，确定修改吗?", "确定", JOptionPane.YES_NO_OPTION);  
				if (n == JOptionPane.YES_OPTION) {  
					super.actionEdit_actionPerformed(e);
				} else  {  
					SysUtil.abort(); 
				}		
			}   
			super.actionEdit_actionPerformed(e);
		}
	}

		/**
		 * 刷新界面
		 */
		protected void refreshCurPage() throws EASBizException, BOSException, Exception //刷新
		{
			if (editData.getId() != null) 
			{
				com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
				
				IObjectValue iObjectValue = getValue(iObjectPk);
				setDataObject(iObjectValue);
				loadFields();
				setSave(true);
			}
		}	
		@Override
		public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
			// TODO Auto-generated method stub
			if(this.editData.getBillStatus().equals(UsedStatus.saveValue))
			{
				super.actionAudit_actionPerformed(e);
				this.setMessageText("审核完成");
				this.showMessage();
				refreshCurPage();
				abort();
			}
			MsgBox.showInfo("只能审核保存状态的基础资料");
		}

		@Override
		public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
			// TODO Auto-generated method stub
			if(this.editData.getBillStatus().equals(UsedStatus.trueValue))
			{
				MsgBox.showInfo("请先禁用该基础资料");
				abort();
			}
			if(this.editData.getBillStatus().equals(UsedStatus.saveValue))
			{
				MsgBox.showInfo("该基础资料尚未审核");
				abort();
			}
			super.actionUnAudit_actionPerformed(e);
			this.setMessageText("反审核完成");
			this.showMessage();
			refreshCurPage();
		}

		/**
		 * output actionRemove_actionPerformed
		 */
		public void actionRemove_actionPerformed(ActionEvent e) throws Exception
		{
			if(editData.getBillStatus().equals(UsedStatus.auditValue))
			{
				MsgBox.showInfo("已审核的基础资料禁止删除");
				abort();
			}
			if(editData.getBillStatus().equals(UsedStatus.trueValue))
			{
				MsgBox.showInfo("已启用的基础资料禁止删除");
				abort();
			}



			String id=this.editData.getId().toString();
			if(id==null)
			{
				MsgBox.showInfo("请选择记录行!");
				SysUtil.abort();
			}
			StringBuffer buffer=new StringBuffer();
			buffer.append("select  * from   T_SIG_ContractType t1");
			buffer.append(" inner join T_SIG_Contract t2");
			buffer.append(" on t1.fid=t2.FContractTypeID");
			buffer.append(" where t1.fid='");
			buffer.append(id).append("'");
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
			if(rs.next()){
				com.kingdee.eas.util.client.MsgBox.showInfo("该单据已被引用无法删除！");
				return;
			}    		
			super.actionRemove_actionPerformed(e);
		}

		/**
		 * output actionAttachment_actionPerformed
		 */
		public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
		{
			super.actionAttachment_actionPerformed(e);
		}

		/**
		 * output actionSubmitOption_actionPerformed
		 */
		public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
		{
			super.actionSubmitOption_actionPerformed(e);
		}

		/**
		 * output actionReset_actionPerformed
		 */
		public void actionReset_actionPerformed(ActionEvent e) throws Exception
		{
			super.actionReset_actionPerformed(e);
		}

		/**
		 * output actionMsgFormat_actionPerformed
		 */
		public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
		{
			super.actionMsgFormat_actionPerformed(e);
		}

		/**
		 * output getBizInterface method
		 */
		protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
		{
			return com.kingdee.eas.custom.signwasthetable.ContractTypeFactory.getRemoteInstance();
		}

		/**
		 * output createNewData method
		 */
		protected com.kingdee.bos.dao.IObjectValue createNewData()
		{
			com.kingdee.eas.custom.signwasthetable.ContractTypeInfo objectValue = new com.kingdee.eas.custom.signwasthetable.ContractTypeInfo();
			objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
			objectValue.setOrgUnit(SysContext.getSysContext().getCurrentAdminUnit());
			objectValue.setBillStatus(UsedStatus.saveValue);
			
//			//测试用
//			String jsonStr = "{\"bosType\":\"639C3776\",\"beginRow\":\"0\",\"endRow\":\"10000\"}";
//			try {
//				String re = DynamicFacadeFactory.getRemoteInstance().getBillList(jsonStr);
//				System.out.println("---------"+re);
//			} catch (EASBizException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (BOSException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
			
			
			return objectValue;
		}

	}