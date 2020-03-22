/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

import java.awt.event.*;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class CmpItemListUI extends AbstractCmpItemListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CmpItemListUI.class);
    
    /**
     * output class constructor
     */
    public CmpItemListUI() throws Exception
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
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salaryvoucher.CmpItemFactory.getRemoteInstance();
    }
/**
 * 放弃当前薪酬项目，自动获取sHR里的薪酬项目
 */
    @Override
	public void actionUpdateCmpItem_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
    	if(MsgBox.showConfirm2(this, "确定要同步sHR中的薪酬项目并删除客户端当前的薪酬项目吗？")==0){
    		//检测和sHR数据库的连接并更新
    		valiateDBConnection();
    		refreshList();
    	}
    	else
    		SysUtil.abort();
		super.actionUpdateCmpItem_actionPerformed(e);
	}

    /**
     * 检测和sHR数据库的连接
     */
	private void valiateDBConnection() {
	// TODO Auto-generated method stub
		String [] con=new String[5];
		String str="select * from T_SAL_ConnectServer where FStatus=3";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			if(rs.next()){
				con[0]=rs.getString("FIP");
				con[1]=rs.getString("FPort");
				con[2]=rs.getString("FDataBaseName");
				con[3]=rs.getString("FUserName");
				con[4]=rs.getString("FUserPassWord");
				if(com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getConnection(con))
					com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().updateCmpItem(con);				
			}
			else{
				MsgBox.showInfo("数据库连接配置错误");
				SysUtil.abort();
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

	/**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salaryvoucher.CmpItemInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.CmpItemInfo();
		
        return objectValue;
    }

}