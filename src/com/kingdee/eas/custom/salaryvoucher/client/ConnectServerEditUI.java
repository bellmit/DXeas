/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.salaryvoucher.voucherStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;



/**
 * output class name
 */
public class ConnectServerEditUI extends AbstractConnectServerEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(ConnectServerEditUI.class);

	/**
	 * output class constructor
	 */
	public ConnectServerEditUI() throws Exception
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
		return com.kingdee.eas.custom.salaryvoucher.ConnectServerFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}
	/**
	 * 禁用
	 */
	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null&&editData.getStatus().equals(voucherStatus.cancelcancel))
			super.actionCancel_actionPerformed(e);
		else{
			MsgBox.showInfo("只允许禁用已启用的单据");
			SysUtil.abort();
		}
	}

	/**
	 * 启用
	 */
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null&&editData.getStatus().equals(voucherStatus.save))
			super.actionCancelCancel_actionPerformed(e);
		else{
			MsgBox.showInfo("只允许启用保存状态的单据");
			SysUtil.abort();
		}

	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getStatus().equals(voucherStatus.save))
			super.actionRemove_actionPerformed(e);
		else{
			MsgBox.showInfo("只允许删除保存状态的单据");
			SysUtil.abort();
		}
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData!=null&&editData.getStatus().equals(voucherStatus.save))
			super.actionSubmit_actionPerformed(e);
		else{
			MsgBox.showInfo("只允许保存启用的单据");
			SysUtil.abort();
		}
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();	


		btnSubmit.setToolTipText("保存");
		btnSave.setVisible(false);
		btnCopy.setVisible(false);
		btnCancel.setEnabled(true);
		btnCancelCancel.setEnabled(true);
	
		

		
		
	}
	
	
	/**
	 * 测试数据库连接
	 */
	@Override
	protected void btnTestConnection_actionPerforme(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		if(isNull()){
			String []str=new String[5];
			str[0]=txtIP.getStringValue();
			str[1]=txtport.getStringValue();
			str[2]=txtdataBaseName.getStringValue();
			str[3]=txtuserName.getStringValue();
			str[4]=txtuserPassword.getStringValue();
			try {
				boolean conn = com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getConnection(str);
				if(conn){
					MsgBox.showInfo("连接成功");
				}
				else
					MsgBox.showInfo("连接失败");
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else
			MsgBox.showInfo("连接信息填写不完整");
		super.btnTestConnection_actionPerforme(e);
	}
	
	/**
	 * 连接sHR数据库的信息是否有空
	 * @return
	 */
	private boolean isNull() {
		// TODO Auto-generated method stub
		if(txtIP.getStringValue()==null||txtport.getStringValue()==null||txtdataBaseName.getStringValue()==null||txtuserName.getStringValue()==null||txtuserPassword.getStringValue()==null)
			return false;
		else
			return true;
	}
	
//	/**
//	 * IP地址格式匹配
//	 */
//	@Override
//	protected void txtIP_actionPerforme(ActionEvent e) throws Exception {
//		// TODO Auto-generated method stub
//		if(txtIP.getStringValue()==null||txtIP.getStringValue().equals(""))
//			return;
//		else if(!isIP(txtIP.getStringValue())){
//			MsgBox.showInfo("请输入正确的IP地址，格式为"+"xxx.xxx.xxx.xxx"+"xxx的范围从0-255");
//			txtIP.setStringValue(null);
//		}
//		super.txtIP_actionPerforme(e);
//	}
	
	/**
	* 验证IP地址
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean isIP(String str) {
		Pattern pattern = Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}