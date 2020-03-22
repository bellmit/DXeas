/**
 * output package name
 */
package com.kingdee.eas.wlhlcomm.function.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;

/**
 * output class name
 */
public class BillUpdatePlatForm extends AbstractBillUpdatePlatForm
{
    private static final Logger logger = CoreUIObject.getLogger(BillUpdatePlatForm.class);
    
    /**
     * output class constructor
     */
    public BillUpdatePlatForm() throws Exception
    {
        super();
    }
    
    /**
     * 初始化F7
     */
    private void initBillF7(){
    	
    	prmtBillName.setQueryInfo("com.kingdee.eas.wlhlcomm.function.app.TobeUpdateBillsF7Query");
    	prmtBillName.setVisible(true);
    	prmtBillName.setEditable(true);
    	prmtBillName.setDisplayFormat("$billName$");
    	prmtBillName.setEditFormat("$billName$");
    	prmtBillName.setCommitFormat("$billName$");
    	// 根据当前登录用户过滤可 操作单据 列表
    	UserInfo currUserInfo = SysContext.getSysContext().getCurrentUserInfo();
    	
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnConfirm_actionPerformed method
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnConfirm_actionPerformed(e);
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnCancel_actionPerformed(e);
    }

    /**
     * output prmtBillName_dataChanged method
     */
    protected void prmtBillName_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        super.prmtBillName_dataChanged(e);
    }

    /**
     * output tfBillNumber_actionPerformed method
     */
    protected void tfBillNumber_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.tfBillNumber_actionPerformed(e);
    }

    /**
     * output cbFieldType_actionPerformed method
     */
    protected void cbFieldType_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.cbFieldType_actionPerformed(e);
    }

    /**
     * output cbFieldColumn_actionPerformed method
     */
    protected void cbFieldColumn_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.cbFieldColumn_actionPerformed(e);
    }

}