/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

import java.awt.event.*;
import java.sql.Connection;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commld.jdbcUntils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;

/**
 * output class name
 */
public class DataBaseConnectionEditUI extends AbstractDataBaseConnectionEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(DataBaseConnectionEditUI.class);

	/**
	 * output class constructor
	 */
	public DataBaseConnectionEditUI() throws Exception
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
		return com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo objectValue = new com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

	/**
	 * �������ݿ��Ƿ���������
	 */
	@Override
	protected void btnTestConnection_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(UIRuleUtil.isNull(txtIP.getText()))
			throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{"IP��ַ"});
		if(UIRuleUtil.isNull(txtport.getText()))
			throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{"�˿�"});
		if(UIRuleUtil.isNull(txtdataBaseName.getText()))
			throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{"���ݿ���"});
		if(UIRuleUtil.isNull(txtuserName.getText()))
			throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{"�û���"});
		if(UIRuleUtil.isNull(txtpassword.getText()))
			throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{"����"});

		String[] str={txtIP.getText(),txtport.getText(),txtdataBaseName.getText(),txtuserName.getText(),txtpassword.getText()};
		Connection conn=jdbcUntils.getDataBaseConnection(str);
		if(conn!=null)
			commUtils.giveUserTipsAndRetire("���ӳɹ�");
		else
			commUtils.giveUserTipsAndRetire("����ʧ��");
		super.btnTestConnection_mouseClick(e);
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUI();
	}

	/**
	 * ��������
	 */
	private void setUI() {
		// TODO Auto-generated method stub
		btnCopy.setVisible(false);
		menuHelp.setVisible(false);
		MenuService.setVisible(false);
		btnCancel.setEnabled(true);
		btnCancelCancel.setEnabled(true);
	}
	
	/**
	 * ���ص�������
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
		// �ж�
		SysUtil.abort();
	}
	
	
}