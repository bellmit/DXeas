/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

import java.awt.event.*;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class OrganizationRelationEditUI extends AbstractOrganizationRelationEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(OrganizationRelationEditUI.class);

	/**
	 * output class constructor
	 */
	public OrganizationRelationEditUI() throws Exception
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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.salaryvoucher.OrganizationRelationFactory.getRemoteInstance();
	}

	/**	
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.kdtShrAdminOrg.setAutoResize(true);
		this.kdtShrAdminOrg.getColumn("shrAdminOrg").setRequired(true);
		this.kdtShrAdminOrg.getColumn("seq").getStyleAttributes().setHided(true);

		kdtShrAdminOrg.addKDTEditListener(new KDTEditListener(){


			public void editCanceled(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}


			public void editStarted(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}


			public void editStarting(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}


			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub		
				data_change(arg0.getRowIndex(),arg0.getColIndex());
			}




			private void data_change(int rowIndex, int colIndex) {
				// TODO Auto-generated method stub
				String [] con=new String[5];
				String str="select * from T_SAL_ConnectServer where FStatus=3";
				IRowSet rs;
				try {
					rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
					if(rs.next()){
						con[0]=rs.getString("FIP");
						con[1]=rs.getString("FPort");
						con[2]=rs.getString("FDataBaseName");
						con[3]=rs.getString("FUserName");
						con[4]=rs.getString("FUserPassWord");
						if(!com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getConnection(con)){
							MsgBox.showInfo("数据库连接配置错误");
							SysUtil.abort();
						}
					}
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(kdtShrAdminOrg.getColumn(colIndex).getKey().equalsIgnoreCase("shrAdminOrg")){
					if(kdtShrAdminOrg.getCell(rowIndex, colIndex).getValue()!=null){
						String sHRAdminCode = (String)kdtShrAdminOrg.getCell(rowIndex, colIndex).getValue();
						try {
							String sHRAdminName = com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getSHRAdmin(sHRAdminCode,con);
							if(sHRAdminName!=null&&!sHRAdminName.equals(""))
								kdtShrAdminOrg.getCell(rowIndex,"shrAdminOrgName").setValue(sHRAdminName);
							else{
								MsgBox.showInfo("sHR系统中不存在当前编码的行政组织");
								kdtShrAdminOrg.getCell(rowIndex,"shrAdminOrgName").setValue(null);
							}
						} catch (BOSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}


			public void editStopping(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}


			public void editValueChanged(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}	


		});

	}
}