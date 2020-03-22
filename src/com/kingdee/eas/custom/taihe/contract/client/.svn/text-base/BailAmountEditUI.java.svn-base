/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.taihe.contract.PaymentType;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BailAmountEditUI extends AbstractBailAmountEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BailAmountEditUI.class);
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//组织
	/**
	 * output class constructor
	 */
	public BailAmountEditUI() throws Exception
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
		return com.kingdee.eas.custom.taihe.contract.BailAmountFactory.getRemoteInstance();
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
		pkauditTime.setEnabled(false);
		contauditTime.setEnabled(false);
		txtpayAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		txtbeginMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		
		orgInfo = SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Company);
		f7Manager.registerBizSupplierF7(prmtpartyB, null, null, orgInfo);
		
		CompanyF7 cf7=new CompanyF7();
		prmtcompany.setSelector(cf7);
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.taihe.contract.BailAmountInfo objectValue = new com.kingdee.eas.custom.taihe.contract.BailAmountInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setPayType(PaymentType.Cash);
		objectValue.setPayTime(new Date());
		objectValue.setMoneyTypes(moneyType.charge);
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		doAfterSave(new ObjectUuidPK(editData.getString("id")));
		btnEdit.setEnabled(false);
		MsgBox.showInfo("审核成功");
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		doAfterSave(new ObjectUuidPK(editData.getString("id")));
		btnEdit.setEnabled(false);
		MsgBox.showInfo("反审核成功");
	}

}