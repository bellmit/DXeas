/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;
import java.math.BigDecimal;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class CountUI extends AbstractCountUI
{

	BEggCandlingBillEditUI srcUi;
	int rowIndex;
	int colIndex;
	BigDecimal[] coefficient;
	Integer oldValue;
	private static final Logger logger = CoreUIObject.getLogger(CountUI.class);

	/**
	 * output class constructor
	 */
	public CountUI() throws Exception
	{
		super();
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

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUITitle("¼ÆÊý");
		srcUi = (BEggCandlingBillEditUI)this.getUIContext().get("ui");
		rowIndex=((Integer) this.getUIContext().get("rowIndex")).intValue();
		colIndex=((Integer) this.getUIContext().get("colIndex")).intValue();
		coefficient = ((BigDecimal[])this.getUIContext().get("coefficient"));
		oldValue = (Integer)this.getUIContext().get("oldValues");
		txtCar.setValue(oldValue/UIRuleUtil.getInt(coefficient[0]));
		txtFloor.setValue((oldValue%UIRuleUtil.getInt(coefficient[0]))/UIRuleUtil.getInt(coefficient[1]));
		txtPlate.setValue(((oldValue%UIRuleUtil.getInt(coefficient[0]))%UIRuleUtil.getInt(coefficient[1]))/UIRuleUtil.getInt(coefficient[2]));
		txtMei.setValue(((oldValue%UIRuleUtil.getInt(coefficient[0]))%UIRuleUtil.getInt(coefficient[1]))%UIRuleUtil.getInt(coefficient[2])/UIRuleUtil.getInt(coefficient[3]));
		btnConfirm.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				int actualQty = UIRuleUtil.getInt(txtCar.getBigDecimalValue())*UIRuleUtil.getInt(coefficient[0])+UIRuleUtil.getInt(txtFloor.getBigDecimalValue())*UIRuleUtil.getInt(coefficient[1])+UIRuleUtil.getInt(txtPlate.getBigDecimalValue())*UIRuleUtil.getInt(coefficient[2])+UIRuleUtil.getInt(txtMei.getBigDecimalValue())*UIRuleUtil.getInt(coefficient[3]);
				srcUi.kdtEggEntries.getCell(rowIndex, colIndex).setValue(actualQty);
				destroyWindow();
			}
		});
		btnConfirm.addKeyListener(new KeyAdapter(){

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==10||e.getKeyCode()==32){
					int actualQty = UIRuleUtil.getInt(txtCar.getBigDecimalValue())*UIRuleUtil.getInt(coefficient[0])+UIRuleUtil.getInt(txtFloor.getBigDecimalValue())*UIRuleUtil.getInt(coefficient[1])+UIRuleUtil.getInt(txtPlate.getBigDecimalValue())*UIRuleUtil.getInt(coefficient[2])+UIRuleUtil.getInt(txtMei.getBigDecimalValue())*UIRuleUtil.getInt(coefficient[3]);
					srcUi.kdtEggEntries.getCell(rowIndex, colIndex).setValue(actualQty);
					destroyWindow();
				}
				super.keyPressed(e);
			}});
	}
	

}