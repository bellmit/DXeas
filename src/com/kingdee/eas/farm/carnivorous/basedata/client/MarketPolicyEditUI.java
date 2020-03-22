/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.math.BigDecimal;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class MarketPolicyEditUI extends AbstractMarketPolicyEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MarketPolicyEditUI.class);

	/**
	 * output class constructor
	 */
	public MarketPolicyEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{

		remmoveDataChangeListener();

		super.loadFields();


		addDataChangeListener();
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
	 * 添加事件
	 */
	private void addDataChangeListener() {
		// TODO Auto-generated method stub
		txtyieldRate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(txtyieldRate.getBigDecimalValue()==null||txtyieldRate.getBigDecimalValue().compareTo(BigDecimal.ZERO)==0)
					return;
				if(marketType.getSelectedItem()!=null&&marketType.getSelectedItem().equals(MarketType.InnerComp)){
					MsgBox.showWarning("内部公司不需要填写出成率");
					txtyieldRate.setValue(BigDecimal.ZERO);
				}
			}
		});
		
		marketType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent paramItemEvent) {
				// TODO Auto-generated method stub
				if(txtyieldRate.getBigDecimalValue()==null||txtyieldRate.getBigDecimalValue().compareTo(BigDecimal.ZERO)==0)
					return;
				if(marketType.getSelectedItem()!=null&&marketType.getSelectedItem().equals(MarketType.InnerComp)){
					MsgBox.showWarning("内部公司不需要填写出成率");
					marketType.setSelectedItem(MarketType.Outer);
				}
			}});
	}
	/**
	 * 删除事件
	 */
	private void remmoveDataChangeListener() {
		// TODO Auto-generated method stub
		ListenerUtil.textFieldRemoveDataChangeListener(txtyieldRate);
		ItemListener[] listeners = marketType.getListeners(ItemListener.class);
		for(int i=0;i<listeners.length;i++)
			marketType.removeItemListener(listeners[i]);
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
		return com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompanyOrgUnit(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

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