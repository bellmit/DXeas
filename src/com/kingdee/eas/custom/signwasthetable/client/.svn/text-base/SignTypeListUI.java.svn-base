/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.*;
import java.util.HashMap;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.signwasthetable.SignTypeFactory;
import com.kingdee.eas.custom.signwasthetable.SignTypeInfo;
import com.kingdee.eas.custom.signwasthetable.UsedStatus;

/**
 * output class name
 */
public class SignTypeListUI extends AbstractSignTypeListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SignTypeListUI.class);
    
    /**
     * output class constructor
     */
    public SignTypeListUI() throws Exception
    {
        super();
    	if(isF7ListUI)
			this.setDefaultEntityViewInfo(getDefaultEntityViewInfo());
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
			vwFilter.getFilterItems().add(new FilterItemInfo("billStatus",UsedStatus.TRUEVALUE_VALUE, CompareType.EQUALS));  
			ewinfo.setFilter(vwFilter); 
			setButtonUnVisible();
			return ewinfo;  
		}else{  
			return super.getDefaultEntityViewInfo();  
		}  
	}  

	/**
	 * 设置按钮不可见
	 */
    private void setButtonUnVisible() {
		// TODO Auto-generated method stub
    	menuBar.setVisible(false);
    	btnAddNew.setVisible(false);
    	btnGroupAddNew.setVisible(false);
    	btnGroupEdit.setVisible(false);
    	btnGroupView.setVisible(false);
    	btnGroupRemove.setVisible(false);
    	btnGroupMoveTree.setVisible(false);
    	btnCancel.setVisible(false);
    	btnCancelCancel.setVisible(false);
    	btnAudit.setVisible(false);
    	btnUnAudit.setVisible(false);
    	btnEdit.setVisible(false);
    	btnRemove.setVisible(false);
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

    /**
     * output chkIncludeChild_itemStateChanged method
     */
    protected void chkIncludeChild_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.chkIncludeChild_itemStateChanged(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.signwasthetable.SignTypeFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.custom.signwasthetable.SignTypeTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.custom.signwasthetable.client.SignTypeTreeEditUI.class.getName();
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
        return "签呈类别";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.signwasthetable.SignTypeInfo objectValue = new com.kingdee.eas.custom.signwasthetable.SignTypeInfo();
		
        return objectValue;
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
        this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
        this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
        tblMain.getColumn("FIOrgUnit.name").setWidth(200);
        tblMain.getColumn("adminOrgUnit.name").setWidth(200);
        tblMain.getColumn("stoOrgUnit.name").setWidth(200);
        tblMain.getColumn("lastUpdateTime").setWidth(150);
        tblMain.getColumn("createTime").setWidth(150);
		super.onLoad();
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshList();
		setMessageText("审核成功");
		showMessage();
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshList();
		setMessageText("反审核成功");
		showMessage();
	}

	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		refreshList();
		setMessageText("禁用成功");
		showMessage();
	}

	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionCancelCancel_actionPerformed(e);
		String id = this.getSelectedKeyValue();
		CoreBaseInfo info = SignTypeFactory.getRemoteInstance().getSignTypeInfo(new ObjectUuidPK(id));
		com.kingdee.eas.custom.signwasthetable.SignTypeFactory.getRemoteInstance().cancelCancel(new ObjectUuidPK(id), info);
		refreshList();
		setMessageText("启用成功");
		showMessage();
	}

}