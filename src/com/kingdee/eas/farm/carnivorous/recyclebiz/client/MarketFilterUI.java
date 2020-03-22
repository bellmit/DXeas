/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.event.*;
import java.math.BigDecimal;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BigDecimalUtil;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType;
import com.kingdee.eas.fm.mobile.util.BigDecimalUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class MarketFilterUI extends AbstractMarketFilterUI
{
	private static final Logger logger = CoreUIObject.getLogger(MarketFilterUI.class);
	private MarketPolicyInfo info;
	/**
	 * output class constructor
	 */
	public MarketFilterUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		toolBar.setVisible(false);
		String id = ((IPropertyContainer)((KDBizPromptBox)this.getUIContext().get("settlePolicy")).getValue()).getString("id");
		info = MarketPolicyFactory.getRemoteInstance().getMarketPolicyInfo(new ObjectUuidPK(id));
		txtMarketPrice.setValue(UIRuleUtil.getBigDecimal(info.getContractPrice()));
		txtYieldRate.setEnabled(false);
		txtYieldRate1.setEnabled(false);
		if(info.getMarketType().equals(MarketType.Outer)){
			txtYieldRate.setVisible(true);
			txtYieldRate.setValue(UIRuleUtil.getBigDecimal(info.getYieldRate()));
			txtYieldRate1.setVisible(false);
		}else{
			txtYieldRate.setVisible(false);
			txtYieldRate1.setVisible(true);
			txtYieldRate1.setStringValue("由出成基础资料决定");
		}

		btnConfirm.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				checkBefore();
				MarketFilterUI.this.getUIContext().put("yieldRate", txtYieldRate.getBigDecimalValue());
				MarketFilterUI.this.getUIContext().put("yieldRate1", txtYieldRate1.getStringValue());
				MarketFilterUI.this.getUIContext().put("marketPrice", txtMarketPrice.getBigDecimalValue());
				MarketFilterUI.this.getUIContext().put("marketPolicy", info);
				MarketFilterUI.this.destroyWindow();
			}

		});
	}
	private void checkBefore() {
		// TODO Auto-generated method stub
		if(txtMarketPrice.getBigDecimalValue()==null||txtMarketPrice.getBigDecimalValue().compareTo(BigDecimal.ZERO)==0)
			commUtils.giveUserTipsAndRetire("市场价格不能为空");
		if(info.getMarketType().equals(MarketType.Outer)){
			if(txtYieldRate.getBigDecimalValue()==null||txtYieldRate.getBigDecimalValue().compareTo(BigDecimal.ZERO)==0)
				commUtils.giveUserTipsAndRetire("出成率不能为空");
		}
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	protected IObjectValue createNewData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ICoreBase getBizInterface() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}