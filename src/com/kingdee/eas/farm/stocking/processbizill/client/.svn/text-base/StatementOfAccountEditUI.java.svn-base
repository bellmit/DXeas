/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class StatementOfAccountEditUI extends AbstractStatementOfAccountEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(StatementOfAccountEditUI.class);
	KDFormattedTextField [] APFormat={txthatchEggac,txteliminateac,txtfertilizationac,txtdepositac,txtdepositInterestac};
	KDFormattedTextField [] ARFormat={txtdrugac,txtcostOfLivingac,txtfundInterestac,txtaccessoryac,txtothersac,txtloanInterestac,txteggPayAmt};
	/**
	 * output class constructor
	 */
	public StatementOfAccountEditUI() throws Exception
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
		return com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFactory.getRemoteInstance();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		KDFormattedTextField []textField={txtfeedsall,txtaccessoryac,txtcostOfLivingac,txtdepositac,txtdepositInterestac,txtdrugac,txteliminateac,txtfundInterestac,txthatchEggac,txtloanInterestac,txtothersac,txtfertilizationac};
		UIUtil.setQualityPhaseDisplayFormat(textField, SwingConstants.RIGHT);
		kdtFeedsnew.getColumn("seq").getStyleAttributes().setHided(true);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		pkconfirmTime.setTimeEnabled(true);
		for(int i=0;i<APFormat.length;i++){
			APFormat[i].addDataChangeListener(new DataChangeListener(){

				public void dataChanged(DataChangeEvent arg0) {
					// TODO Auto-generated method stub
					calTotalAP();
				}});
		}

		for(int i=0;i<ARFormat.length;i++){
			ARFormat[i].addDataChangeListener(new DataChangeListener(){

				public void dataChanged(DataChangeEvent arg0) {
					// TODO Auto-generated method stub
					calTotalAR();
				}});
		}
		
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
		com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));

		return objectValue;
	}
	/**
	 * 计算总应付
	 */
	private void calTotalAP(){
		txttotalAPAmount.setValue(UIRuleUtil.getBigDecimal(txthatchEggac.getBigDecimalValue())
				.add(UIRuleUtil.getBigDecimal(txteliminateac.getBigDecimalValue()))
				.add(UIRuleUtil.getBigDecimal(txtfertilizationac.getBigDecimalValue()))
				.add(UIRuleUtil.getBigDecimal(txtdepositac.getBigDecimalValue()))
				.add(UIRuleUtil.getBigDecimal(txtdepositInterestac.getBigDecimalValue())));
		calEndBalance();
	}

	/**
	 * 计算总应收
	 */
	private void calTotalAR(){
		txttotalARAmount.setValue(UIRuleUtil.getBigDecimal(txtdrugac.getBigDecimalValue())
				.add(UIRuleUtil.getBigDecimal(txtcostOfLivingac.getBigDecimalValue()))
				.add(UIRuleUtil.getBigDecimal(txtfundInterestac.getBigDecimalValue()))
				.add(UIRuleUtil.getBigDecimal(txtaccessoryac.getBigDecimalValue()))
				.add(UIRuleUtil.getBigDecimal(txtothersac.getBigDecimalValue()))
				.add(UIRuleUtil.getBigDecimal(txtloanInterestac.getBigDecimalValue()))
				.add(UIRuleUtil.getBigDecimal(txtfeedsall.getBigDecimalValue()))
				.add(txteggPayAmt.getBigDecimalValue()));
		calEndBalance();
	}
	/**
	 * 计算余额
	 */
	private void calEndBalance() {
		// TODO Auto-generated method stub
		txtclosingBalance.setValue(UIRuleUtil.getBigDecimal(txtbeginningBalance.getBigDecimalValue()).add(UIRuleUtil.getBigDecimal(txttotalARAmount.getBigDecimalValue())).subtract(UIRuleUtil.getBigDecimal(txttotalAPAmount.getBigDecimalValue())));
	}
}