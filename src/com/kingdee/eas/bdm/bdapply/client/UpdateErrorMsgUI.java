/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class UpdateErrorMsgUI extends AbstractUpdateErrorMsgUI
{
    private static final Logger logger = CoreUIObject.getLogger(UpdateErrorMsgUI.class);
    String billId="";
    String billType="物料";
    String cuid="";
    
    /**
     * output class constructor
     */
    public UpdateErrorMsgUI() throws Exception
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
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }
    public void onLoad() throws Exception {
		super.onLoad();
		
		if(getUIContext().get("cuid")!=null){
			cuid=(String)getUIContext().get("cuid");
		}
		if(getUIContext().get("billType")!=null){
			billType=(String)getUIContext().get("billType");
		}
		if(getUIContext().get("billId")!=null){
			billId=(String)getUIContext().get("billId");
		}
		this.setUITitle(billType+"驳回界面");
		this.btnAudit.setVisible(false);
	}
    /**
     * output btnAudit_actionPerformed method
     */
    protected void btnAudit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAudit_actionPerformed(e);
    }

    /**
     * output btnUnAudit_actionPerformed method
     */
    protected void btnUnAudit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	StringBuffer sql=new StringBuffer();
    	String errorMsg=this.txtErrorMsg.getText();
    	String tableName="";
    	if(errorMsg==null)errorMsg="";
    	if(errorMsg.equals("")){
    		MsgBox.showError("请填写错误原因！");
    		SysUtil.abort();
    	}
    	sql=new StringBuffer();
    	if(billType.equals("物料")){
    		tableName="CT_BDM_MaterialInfoReq";
    		sql.append(" update "+tableName+" set cferrorMsg='"+errorMsg+"',CFStatus='0' ");
    	}else if(billType.equals("客户")){
    		tableName="CT_BDM_CustomerInfoReq";
    		sql.append(" update "+tableName+" set CFErrorMsg='"+errorMsg+"',CFStatus='0' ");
    	}else if(billType.equals("供应商")){
    		tableName="CT_BDM_SupplierReq";
    		sql.append(" update "+tableName+" set cferrorMsg='"+errorMsg+"',CFUserstated='0' ");
    	}
		sql.append(" where fid='"+billId+"' ");
//		CommSqlFacadeFactory.getRemoteInstance().execute(sql.toString());
		CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql.toString());
		
		MsgBox.showInfo("操作成功");
    }

}