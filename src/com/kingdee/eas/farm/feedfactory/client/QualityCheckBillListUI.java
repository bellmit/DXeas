/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

import java.awt.event.*;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.feedfactory.QualityCheckBillFactory;
import com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class QualityCheckBillListUI extends AbstractQualityCheckBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(QualityCheckBillListUI.class);
    
    /**
     * output class constructor
     */
    public QualityCheckBillListUI() throws Exception
    {
        super();
    }

    @Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	checkSelected();
    	String purOrderID = null;
    	QualityCheckBillInfo info = QualityCheckBillFactory.getRemoteInstance().getQualityCheckBillInfo(new ObjectUuidPK(this.getSelectedKeyValue()));
    	if(info.getPurOrder()!=null){
    		purOrderID=info.getPurOrder().getId().toString();
		}
		super.actionRemove_actionPerformed(e);
		
		if(StringUtils.isNotEmpty(purOrderID)){
			checkPurOrderBill(purOrderID);
		}
	}
    
    /**
	 * 
	 * @param purOrderID
	 */
	private void checkPurOrderBill(String purOrderID) {
		// TODO Auto-generated method stub
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance("select t1.CFIsHasQCBill,t2.FID from T_SM_PurOrder t1 left join CT_FM_QualityCheckBill t2 on t1.FID=t2.CFPurOrderID where t1.FID='"+purOrderID+"'").executeSQL();
			if(rs.next()){
				//没有时清除标志
				if(rs.getBoolean("CFIsHasQCBill")&&StringUtils.isEmpty(rs.getString("FID"))){
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_SM_PurOrder set CFIsHasQCBill=0 where FID='"+purOrderID+"'");
				}else if(!rs.getBoolean("CFIsHasQCBill")&&StringUtils.isNotEmpty(rs.getString("FID"))){
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_SM_PurOrder set CFIsHasQCBill=1 where FID='"+purOrderID+"'");
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
     * 界面初始化 
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.QualityCheckBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo objectValue = new com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo();
		
        return objectValue;
    }

    /**
     * 审核
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showInfo("审核完成");
			
			this.refreshList();
			this.setMessageText("审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showInfo("反审核完成");
			
			this.refreshList();
			this.setMessageText("反审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}
}