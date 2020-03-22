/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.*;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.ibm.db2.jcc.t4.ob;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.custom.signwasthetable.SignBDFactory;
import com.kingdee.eas.custom.signwasthetable.SignBDInfo;
import com.kingdee.eas.custom.signwasthetable.UsedStatus;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.IIDList;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SignBDListUI extends AbstractSignBDListUI
{
	private static final Logger logger = CoreUIObject.getLogger(SignBDListUI.class);

	/**
	 * output class constructor
	 */
	public SignBDListUI() throws Exception
	{    	
		super();  
	}
	public boolean isIgnoreCUFilter(){
		return true;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.btnCancel.setVisible(true);
		this.btnCancelCancel.setVisible(true);
		//修改图标
		this.signTableAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
		this.signTableUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
		//隐藏文字
		//		this.signTableAudit.setHideActionText(true);
		//		this.signTableUnAudit.setHideActionText(true);

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


	/**
	 * output actionExport_actionPerformed
	 */
	public void actionExport_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExport_actionPerformed(e);
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
		SignBDInfo info = SignBDFactory.getRemoteInstance().getSignBDInfo(new ObjectUuidPK(id));

		//审核的和启用的基础资料禁止修改
		if(info.getBillStatus().equals(UsedStatus.auditValue))
		{
			MsgBox.showInfo("已审核的基础资料禁止修改");
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.trueValue))
		{
			MsgBox.showInfo("已启用的基础资料禁止修改");
			abort();
		}



		StringBuffer buffer=new StringBuffer();
		buffer.append("select  * from   CT_SIG_SignBD t1");
		buffer.append(" inner join CT_SIG_SignWasTheTable t2");
		//		buffer.append(" on t1.fid=t2.CFBillTypeID");
		buffer.append(" on t1.fid=t2.FBillTypeID");//由于数据库版本不一致，可能是上一条备注的
		buffer.append(" where t1.fid='");
		buffer.append(id).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
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
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception
	{
		String id=this.getSelectedKeyValue();
		int rows=this.getSelectedRowCount(tblMain);
		if(rows>1)
		{
			MsgBox.showInfo("请不要一次删除多条基础资料");
			abort();
		}
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行!");
			SysUtil.abort();
		}    

		SignBDInfo info = SignBDFactory.getRemoteInstance().getSignBDInfo(new ObjectUuidPK(id));		
		//审核的和启用的基础资料禁止修改
		if(info.getBillStatus().equals(UsedStatus.auditValue))
		{
			MsgBox.showInfo("已审核的基础资料禁止删除");
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.trueValue))
		{
			MsgBox.showInfo("已启用的基础资料禁止删除");
			abort();
		}


		StringBuffer buffer=new StringBuffer();
		buffer.append("select  * from   CT_SIG_SignBD t1");
		buffer.append(" inner join CT_SIG_SignWasTheTable t2");
		//		buffer.append(" on t1.fid=t2.CFBillTypeID");
		buffer.append(" on t1.fid=t2.FBillTypeID");
		buffer.append(" where t1.fid='");
		buffer.append(id).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		if(rs.next()){
			com.kingdee.eas.util.client.MsgBox.showInfo("该基础资料已被引用无法删除！");
			return;
		}    		
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * output actionRefresh_actionPerformed
	 */
	public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
	{
		refreshList();
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
	 * 禁用
	 * 处于审核或者启用下的单据才可以禁用
	 * output actionCancel_actionPerformed
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
		SignBDInfo info = SignBDFactory.getRemoteInstance().getSignBDInfo(new ObjectUuidPK(id));
		//非   启用和审核状态下的基础资料禁止禁用
		if(info.getBillStatus().equals(UsedStatus.auditValue)||info.getBillStatus().equals(UsedStatus.trueValue))
		{
			info.setBillStatus(UsedStatus.falseValue);//修改启用状态
			SignBDFactory.getRemoteInstance().save(info);//保存

			this.setMessageText("该单据已禁用");
			this.showMessage();
			refreshList();//刷新列表				
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.falseValue)) abort();
		MsgBox.showInfo("该基础资料尚未审核");

		//		super.cancel();
		//        super.actionCancel_actionPerformed(e);
	}
	/**
	 * 启用
	 * 处于禁用或者审核状态下的才可以审核
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
		SignBDInfo info = SignBDFactory.getRemoteInstance().getSignBDInfo(new ObjectUuidPK(id));
		//非   启用和审核状态下的基础资料禁止禁用
		if(info.getBillStatus().equals(UsedStatus.auditValue)||info.getBillStatus().equals(UsedStatus.falseValue))
		{
			info.setBillStatus(UsedStatus.trueValue);//修改启用状态
			SignBDFactory.getRemoteInstance().save(info);//保存

			this.setMessageText("该单据已禁用");
			this.showMessage();
			refreshList();//刷新列表				
			abort();
		}
		if(info.getBillStatus().equals(UsedStatus.trueValue)) abort();
		MsgBox.showInfo("该基础资料尚未审核");

		//        super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * 审核操作
	 * 只有保存状态下的单据才可以审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//获取当前选中行的id
		String id=this.getSelectedKeyValue();		
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			abort();
		}
		//获得info
		SignBDInfo info = SignBDFactory.getRemoteInstance().getSignBDInfo(new ObjectUuidPK(id));
		if(info.getBillStatus().equals(UsedStatus.saveValue))
		{
			//将状态修改为  审核并保存
			info.setBillStatus(UsedStatus.auditValue);
			SignBDFactory.getRemoteInstance().save(info);
			this.setMessageText("审核完成");
			this.showMessage();
			refreshList();

			abort();
		}
		MsgBox.showInfo("只有保存状态的基础资料需要审核");
		//		super.actionAudit_actionPerformed(e);
	}
	/**
	 * @operation  反审核
	 *只有审核和禁用状态下的单据可以反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//获得选择的单据的·id
		String id=this.getSelectedKeyValue();
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
			abort();
		}
		//获得info
		SignBDInfo info = SignBDFactory.getRemoteInstance().getSignBDInfo(new ObjectUuidPK(id));
		//非   启用和审核状态下的基础资料禁止禁用
		if(info.getBillStatus().equals(UsedStatus.auditValue)||info.getBillStatus().equals(UsedStatus.falseValue))
		{
			info.setBillStatus(UsedStatus.saveValue);//修改启用状态
			SignBDFactory.getRemoteInstance().save(info);//保存

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
		//		super.actionUnAudit_actionPerformed(e);
	}
	/**
	 * output actionQueryScheme_actionPerformed
	 */
	public void actionQueryScheme_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionQueryScheme_actionPerformed(e);
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

		return objectValue;
	}

}