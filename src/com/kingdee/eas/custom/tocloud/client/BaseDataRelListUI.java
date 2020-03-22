/**
 * output package name
 */
package com.kingdee.eas.custom.tocloud.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.ncm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class BaseDataRelListUI extends AbstractBaseDataRelListUI
{
	private static final Logger logger = CoreUIObject.getLogger(BaseDataRelListUI.class);

	/**
	 * output class constructor
	 */
	public BaseDataRelListUI() throws Exception
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
	 * output treeMain_valueChanged method
	 */
	protected void treeMain_valueChanged(javax.swing.event.TreeSelectionEvent e) throws Exception
	{
		super.treeMain_valueChanged(e);
	}


	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("status").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�ٴ���ˣ�");
			SysUtil.abort();
		}
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("status").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
			MsgBox.showWarning("������δ�ύ����ֹ��ˣ�");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		super.actionRefresh_actionPerformed(e);
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {

		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("status").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);

	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {

		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("status").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("�����Ѿ���ˣ���ֹɾ����");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {

		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("status").equals(BillBaseStatusEnum.AUDITED_VALUE)){	
			MsgBox.showWarning("������δ��ˣ���ֹ����ˣ�");
			SysUtil.abort();
		}

		super.actionUnAudit_actionPerformed(e);

		super.actionRefresh_actionPerformed(e);


	}

	/**
	 * output getTreeInterface method
	 */
	protected ITreeBase getTreeInterface() throws Exception
	{
		return com.kingdee.eas.custom.tocloud.BaseDataRelTreeFactory.getRemoteInstance();
	}

	/**
	 * output getGroupEditUIName method
	 */
	protected String getGroupEditUIName()
	{
		return com.kingdee.eas.custom.tocloud.client.BaseDataRelTreeEditUI.class.getName();
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
		return "��������ӳ��";
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.tocloud.BaseDataRelInfo objectValue = new com.kingdee.eas.custom.tocloud.BaseDataRelInfo();

		return objectValue;
	}

}