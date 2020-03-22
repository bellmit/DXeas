/**
 * output package name
 */
package com.kingdee.eas.custom.wages.food.client;

import java.awt.event.*;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class AchievementEditUI extends AbstractAchievementEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AchievementEditUI.class);
    
    
    /**
     * output class constructor
     */
    public AchievementEditUI() throws Exception
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


    /* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#createNewDetailData(com.kingdee.bos.ctrl.kdf.table.KDTable)
	 */
	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.food.client.AbstractAchievementEditUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
	}
	/**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
    		SysUtil.abort();
    	}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("�����Ѿ���ˣ���ֹɾ����");
    		SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
    }

    
    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("�����Ѿ���ˣ���ֹ�ٴ���ˣ�");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("������δ�ύ����ֹ��ˣ�");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("��˳ɹ�");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output actionUnaudit_actionPerformed
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("������δ��ˣ���ֹ����ˣ�");
    		SysUtil.abort();
    	}
    	super.actionUnaudit_actionPerformed(e);
    	//this.setDataObject(this.editData);
    	this.loadData();
    	setOprtState(STATUS_VIEW);
    	lockUIForViewStatus();
    	setNextMessageText("����˳ɹ�");
    	setShowMessagePolicy(0);
    	setIsShowTextOnly(false);
    	showMessage();
    }

    
    /**
	 * output actionSubmit_actionPerformed
	 * ˢ�²���
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	}  
	private IRowSet getExeQueryRowSet() throws BOSException {
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from CT_FOO_CompAssessment").append(sp);
		sql.append("where cfbasestatus = '0'").append(sp);
		//System.out.println(sql.toString());
		IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		return rs;
	}
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.food.AchievementInfo objectValue = new com.kingdee.eas.custom.wages.food.AchievementInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        IRowSet rs = null;
		try {
			rs = getExeQueryRowSet();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(rs.size()==0){
        	MsgBox.showWarning("δ�����ۺϿ���ָ���û�����õ��ۺϿ���ָ�꣬����¼�뼨Ч���˵���");
    		SysUtil.abort();
        }
        return objectValue;
    }

}