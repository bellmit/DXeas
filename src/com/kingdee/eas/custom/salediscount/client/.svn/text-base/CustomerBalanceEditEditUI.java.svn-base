/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.event.*;
import java.util.Date;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;

/**
 * output class name
 */
public class CustomerBalanceEditEditUI extends AbstractCustomerBalanceEditEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CustomerBalanceEditEditUI.class);
    
    /**
     * output class constructor
     */
    public CustomerBalanceEditEditUI() throws Exception
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
        return com.kingdee.eas.custom.salediscount.CustomerBalanceEditFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salediscount.CustomerBalanceEditInfo objectValue = new com.kingdee.eas.custom.salediscount.CustomerBalanceEditInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    
    
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		
		super.actionSubmit_actionPerformed(e);
	}

	/**
	 * output applyDefaultValue method
	 */
	protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
		vo.put("bizDate", new Date());
		vo.put("company", SysContext.getSysContext().getCurrentFIUnit());
		//		UserInfo currUser = SysContext.getSysContext().getCurrentUserInfo();
		//        PersonInfo currPerson = currUser.getPerson();
		//        if(currPerson != null){
		//        	vo.put("person", currPerson);
		//        }

		// 设置库存和财务组织默认
//		vo.put("farm", SysContext.getSysContext().getCurrentStorageUnit());
		//        vo.put("company", SysContext.getSysContext().getCurrentFIUnit());
	}


	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("不能审核未提交的单据");
			SysUtil.abort();
		}
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.actionRemove_actionPerformed(arg0);
	}
	/**
	 * 重载单据内容
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
		// 中断
		SysUtil.abort();



	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("只能反审核处于审核状态的批次");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("反审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}

}