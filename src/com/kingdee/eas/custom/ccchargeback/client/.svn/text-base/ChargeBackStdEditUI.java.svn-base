/**
 * output package name
 */
package com.kingdee.eas.custom.ccchargeback.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class ChargeBackStdEditUI extends AbstractChargeBackStdEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(ChargeBackStdEditUI.class);

	/**
	 * output class constructor
	 */
	public ChargeBackStdEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		if(editData.getId()==null)
			billStatus.setSelectedItem(com.kingdee.eas.custom.ccchargeback.billStatus.save);
		setUI();
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
		return com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	@SuppressWarnings("deprecation")
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo objectValue = new com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setRemark(strFillInstruction());
		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		pkauditTime.setTimeEnabled(true);
		pkcancelcancelTime.setTimeEnabled(true);
		pkcancelTime.setTimeEnabled(true);
	}

	/**
	 * 界面设置
	 */
	private void setUI() {
		// TODO Auto-generated method stub
		this.setUITitle("商品鸡验收标准");
		btnSave.setIcon(EASResource.getIcon("imgTbtn_save"));
		btnSave.setToolTipText("保存");
		btnSubmit.setIcon(EASResource.getIcon("imgTbtn_submit"));
		btnSubmit.setToolTipText("提交");
		txtremark.setEnabled(false);
		btnCancel.setEnabled(true);
		btnCancelCancel.setEnabled(true);
		txtcropSTD.setRequired(true);
		
		contcancelcanceler.setVisible(false);
		contcancelcancelTime.setVisible(false);
		contcancelUser.setVisible(false);
		contcancelTime.setVisible(false);
		
		
		
        //修改图标
        this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
        this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		
		contlastUpdateTime.setVisible(true);
		contlastUpdateUser.setVisible(true);
		contauditor.setVisible(true);
		contauditTime.setVisible(true);
		
		if(editData.getBillStatus()==null)
			return;
		//启用状态显示字段
		if(editData.getBillStatus().equals(com.kingdee.eas.custom.ccchargeback.billStatus.cancelcancel)){
			contcancelcanceler.setVisible(true);
			contcancelcancelTime.setVisible(true);
			contauditor.setVisible(false);
			contauditTime.setVisible(false);
		}
		//禁用
		if(editData.getBillStatus().equals(com.kingdee.eas.custom.ccchargeback.billStatus.cancel)){
			contcancelcanceler.setVisible(true);
			contcancelcancelTime.setVisible(true);
			contauditor.setVisible(false);
			contauditTime.setVisible(false);
			contcancelUser.setVisible(true);
			contcancelTime.setVisible(true);
			contlastUpdateTime.setVisible(false);
			contlastUpdateUser.setVisible(false);
		}
		
	}
	/**
	 * 填写说明
	 * @return
	 */
	private String strFillInstruction() {
		// TODO Auto-generated method stub
		String str="1.该标准仅适用于食品厂对收购的商品鸡进行验收；\n";
		str+="2.胸部皮炎、爪垫和嗉囊标准是指达到或超过该比例时，才对商品鸡场验收扣款；\n";
		str+="3.胴体标准是指毛鸡胴体重量低于该标准时才进行扣款扣重；\n";
		str+="4.增幅比例和增幅金额的关系是：每超过标准的增幅比例，扣除相应的增幅金额";
		return str;
	}
	/**
	 * output actionSubmit_actionPerformed
	 * 刷新操作
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
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		refreshCurPage();
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(arg0);
		refreshCurPage();
	}
	/**
	 * 编辑
	 */
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getBillStatus().equals(com.kingdee.eas.custom.ccchargeback.billStatus.cancelcancel))
			commUtils.giveUserTipsAndRetire("已启用的单据禁止编辑");
		super.actionEdit_actionPerformed(arg0);
	}
	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshCurPage();
		setMessageText("审核成功");
		showMessage();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
		setMessageText("反审核成功");
		showMessage();
	}
	/**
	 * 禁用
	 */
	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(MsgBox.CANCEL==MsgBox.showConfirm2("确定禁用吗，禁用后将无法重新启用"))
			return;
		super.actionCancel_actionPerformed(e);
		refreshCurPage();
	}
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionCancelCancel_actionPerformed(e);
		refreshCurPage();
	}

}