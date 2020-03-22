/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basebizbill.client;

import java.awt.event.*;
import java.util.Date;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.CoreBillEditUI;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class MileModifyRecordEditUI extends AbstractMileModifyRecordEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MileModifyRecordEditUI.class);

	/**
	 * output class constructor
	 */
	public MileModifyRecordEditUI() throws Exception
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
		return com.kingdee.eas.farm.feemanager.basebizbill.MileModifyRecordFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{
		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.menuBar.setVisible(false);
		pkBizDate.setEnabled(false);
		pkmodifyTime.setEnabled(false);
		pkBizDate.setTimeEnabled(true);
		pkmodifyTime.setTimeEnabled(true);
		prmtmodifier.setEnabled(false);
		prmtmodifyPerson.setEnabled(false);
		txtsingleMileageB.setEnabled(false);
		txtallMileageB.setEnabled(false);
		prmttransportRecord.setEnabled(false);
		//设置按钮不可用
		for(int i=0;i<toolBar.getComponentCount();i++)
			if(!toolBar.getComponent(i).equals(btnSave))
				toolBar.getComponent(i).setEnabled(false);
		if(this.oprtState.equals("ADDNEW")){
			pkBizDate.setValue(new Date());
			pkmodifyTime.setValue(new Date());
			prmtmodifier.setValue(SysContext.getSysContext().getCurrentUserInfo());
			prmtmodifyPerson.setValue(SysContext.getSysContext().getCurrentUserInfo().getPerson());
			if(this.getUIContext().get("src")!=null){
				TransportationrecordInfo transInfo=(TransportationrecordInfo) getUIContext().get("src");
				prmttransportRecord.setValue(transInfo);
				txtsingleMileageB.setValue(transInfo.getSingleMileage());
				txtallMileageB.setValue(transInfo.getTotalMileage());
			}
		}
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.feemanager.basebizbill.MileModifyRecordInfo objectValue = new com.kingdee.eas.farm.feemanager.basebizbill.MileModifyRecordInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));

		return objectValue;
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		if(this.getUIContext().get("ui")!=null){
			UIUtil.refreshEditUI((CoreBillEditUI) this.getUIContext().get("ui"));
		}
		this.destroyWindow();
	}

}