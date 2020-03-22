/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.Date;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.util.enums.EnumUtils;

/**
 * output class name
 */
public class SettleDataBaseEditUI extends AbstractSettleDataBaseEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SettleDataBaseEditUI.class);

	/**
	 * output class constructor
	 */
	public SettleDataBaseEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		if(this.editData.getBillStatus()!=null) {
			if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
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
		return com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setBeginDate(new Date());
		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		KDComboBox cbox=new KDComboBox();
		cbox.addItems(new String[]{"抓鸭费","风险基金","疫苗费","季节补贴","无药残","连养补贴","成活率","市场价","斤摊成本","售食品厂价增值","税率"});
		cbox.setName("item");
		cbox.setVisible(true);
		KDTDefaultCellEditor kdtDisRateEntry_carcassType_CellEditor = new KDTDefaultCellEditor(cbox);
		kdtEntry.getColumn("item").setEditor(kdtDisRateEntry_carcassType_CellEditor);


		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);

	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

}