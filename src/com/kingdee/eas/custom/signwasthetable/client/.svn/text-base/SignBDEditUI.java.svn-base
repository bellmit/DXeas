/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.*;
import java.util.EventListener;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.signwasthetable.UsedStatus;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.portal.web.portlet.ShowIndex;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SignBDEditUI extends AbstractSignBDEditUI
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = CoreUIObject.getLogger(SignBDEditUI.class);

	/**
	 * output class constructor
	 */
	public SignBDEditUI() throws Exception
	{
		super();
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
	 * 审核操作
	 * @operation
	 *
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()==null)
			return;
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
	/**
	 *反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()==null)
			return;
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
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
//		if(this.oprtState.equals("ADDNEW")||this.oprtState.equals("EDIT"))
//		{
//			actionAudit.setEnabled(false);
//			actionUnAudit.setEnabled(false);
//		}
//		if(this.oprtState.equals("VIEW"))
//		{
//			actionAudit.setEnabled(true);
//			actionUnAudit.setEnabled(true);
//			this.btnCancel.setEnabled(true);
//			this.btnCancelCancel.setEnabled(true);
//		}
//		//审核状态，启用和禁用按钮可用
//		if(!this.editData.getBillStatus().equals(UsedStatus.saveValue))
//		{
			this.btnCancel.setEnabled(true);
			this.btnCancelCancel.setEnabled(true);
//		}
		//修改审核和反审核的图标，并隐藏文字
		this.signTypeAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
		this.signTypeUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
		this.signTypeAudit.setHideActionText(true);
		this.signTypeUnAudit.setHideActionText(true);

		//设置打印、打印预览、暂存、复制按钮不可见
		this.btnPrint.setVisible(false);
		this.btnPrintPreview.setVisible(false);
		this.btnSave.setVisible(false);
		this.btnCopy.setVisible(false);
		this.kDSeparatorCloud.setVisible(false);
	}
	/**
	 * output actionPageSetup_actionPerformed
	 */
	public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPageSetup_actionPerformed(e);
	}

	/**
	 * output actionAbout_actionPerformed
	 */
	public void actionAbout_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionAbout_actionPerformed(e);
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
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSave_actionPerformed(e);
		refreshCurPage();
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSubmit_actionPerformed(e);
		refreshCurPage();
	}

	/**
	 * 禁用
	 * output actionCancel_actionPerformed
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData.getId()==null)
			return;
		if(this.editData.getBillStatus().equals(UsedStatus.auditValue)||this.editData.getBillStatus().equals(UsedStatus.trueValue))
		{
			//调用facade保存
			com.kingdee.eas.custom.signwasthetable.signTableSysFacadeFactory.getRemoteInstance().signTypeCancel(editData.getId().toString());
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
	 * 启用
	 * output actionCancelCancel_actionPerformed
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData.getId()==null)
			return;
		if(this.editData.getBillStatus().equals(UsedStatus.auditValue)||this.editData.getBillStatus().equals(UsedStatus.falseValue))
		{
			//调用facade保存
			com.kingdee.eas.custom.signwasthetable.signTableSysFacadeFactory.getRemoteInstance().signTypeCancelcancel(editData.getId().toString());
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
	 * output actionPre_actionPerformed
	 */
	public void actionPre_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPre_actionPerformed(e);
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
		//审核的和启用的基础资料禁止修改
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
		buffer.append("select  * from   CT_SIG_SignBD t1");
		buffer.append(" inner join CT_SIG_SignWasTheTable  t2");
		//		buffer.append(" on t1.fid=t2.CFBillTypeID ");
		buffer.append(" on t1.fid=t2.FBillTypeID ");
		buffer.append(" where t1.fid='");
		buffer.append(id).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		if(rs.next())
		{
			if(rs.next())
			{
				int n = JOptionPane.showConfirmDialog(null, "该基础资料已被引用，确定修改吗?", "确定", JOptionPane.YES_NO_OPTION);  
				if (n == JOptionPane.YES_OPTION) 
				{  
					super.actionEdit_actionPerformed(e);
				} else  
				{  
					SysUtil.abort(); 
				}		
			}  			
		}
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception
	{		
		//审核的和启用的基础资料禁止修改
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
		StringBuffer buffer=new StringBuffer();
		buffer.append("select  * from   CT_SIG_SignBD t1");
		buffer.append(" inner join CT_SIG_SignWasTheTable  t2");
		//		buffer.append(" on t1.fid=t2.CFBillTypeID ");
		buffer.append(" on t1.fid=t2.FBillTypeID ");
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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.signwasthetable.SignBDFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.signwasthetable.SignBDInfo objectValue = new com.kingdee.eas.custom.signwasthetable.SignBDInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		//新增时，默认为禁用状态
		//        objectValue.setUsedStatus(UsedStatus.falseValue);
		objectValue.setBillStatus(UsedStatus.saveValue);		
		return objectValue;
	}

	/**
	 * 重载单据内容
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();
	}

}