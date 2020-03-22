/**
 * output package name
 */
package com.kingdee.eas.custom.tocloud.client;

import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.ncm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.util.client.MsgBoxStatisticsUtil;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class BaseDataRelEditUI extends AbstractBaseDataRelEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BaseDataRelEditUI.class);

	/**
	 * output class constructor
	 */
	public BaseDataRelEditUI() throws Exception
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

	@Override
	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		try{
		super.actionSubmit_actionPerformed(arg0);
		}catch(BOSException e1){
			e1.printStackTrace();
			MsgBox.showWarning(e1.getMessage());
		}
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		this.kDLabelContainer1.setVisible(false);
		this.kDLabelContainer2.setVisible(false);
		this.kDLabelContainer3.setVisible(false);
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}




	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		if (this.editData.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
		}
		if (!this.editData.getStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}

		super.actionAudit_actionPerformed(e);
		refreshCurPage();

	}
	private void refreshCurPage() {
		// TODO Auto-generated method stub
		if (editData.getId() != null) {
			BOSUuid pk = editData.getId();
			try {
				super.doAfterSave(new ObjectUuidPK(editData.getId()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editData.setId(pk);
		}else{
			try {
				this.loadData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if (this.editData.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub

		if (this.editData.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}

		super.actionRemove_actionPerformed(arg0);
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		if (!this.editData.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.tocloud.BaseDataRelFactory.getRemoteInstance();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) 
	{
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.custom.tocloud.BaseDataRelTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.tocloud.BaseDataRelInfo objectValue = new com.kingdee.eas.custom.tocloud.BaseDataRelInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}