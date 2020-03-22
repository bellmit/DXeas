/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.Color;
import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingCollection;
import com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingFactory;
import com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class ColorSelect extends AbstractColorSelect
{
	private static final Logger logger = CoreUIObject.getLogger(ColorSelect.class);
	UserInfo userInfo ;
	EggReceiveBillEditUI ui;
	/**
	 * output class constructor
	 */
	public ColorSelect() throws Exception
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
		Color colorWht=(Color)this.getUIContext().get("colorWht");
		Color colorWgt=(Color)this.getUIContext().get("colorWgt");
		Color colorAvg=(Color)this.getUIContext().get("colorAvg");
		userInfo = (UserInfo)this.getUIContext().get("user");
		ui=(EggReceiveBillEditUI) this.getUIContext().get("ui");
		cbColorMei.setColor(new Color(255,255,255));
		cbColorWgt.setColor(colorWgt);
		cbColorAvgWgt.setColor(colorAvg);


		btnConfirm.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				ui.colrWht=cbColorMei.getColor();
				ui.colrYel=cbColorWgt.getColor();
				ui.colrZs=cbColorAvgWgt.getColor();
				ui.setDefalutRowValue();
				ui.setEntryRowColor();
				//				ui.refreshColor(new Color[]{cbColorMei.getColor(),cbColorWgt.getColor(),cbColorAvgWgt.getColor()});
				destroyWindow();
			}});

		btnSaveSetting.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				ui.colrWht=cbColorMei.getColor();
				ui.colrYel=cbColorWgt.getColor();
				ui.colrZs=cbColorAvgWgt.getColor();

				EggReceiveBillColorSettingInfo info;
				UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
				EggReceiveBillColorSettingCollection coll;
				try {
					coll = EggReceiveBillColorSettingFactory.getRemoteInstance().getEggReceiveBillColorSettingCollection("where user='"+userInfo.getString("id")+"'");
					if(coll.size()>0){
						info=coll.get(0);
					}else{
						info=new EggReceiveBillColorSettingInfo();
						info.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
						info.setUser(userInfo);
						info.setNumber(userInfo.getNumber());
						info.setName(userInfo.getName());
					}
					info.setMeiQtyR(cbColorMei.getColor().getRed());
					info.setMeiQtyG(cbColorMei.getColor().getGreen());
					info.setMeiQtyB(cbColorMei.getColor().getBlue());
					info.setWgtR(cbColorWgt.getColor().getRed());
					info.setWgtG(cbColorWgt.getColor().getGreen());
					info.setWgtB(cbColorWgt.getColor().getBlue());
					info.setAvgWgtR(cbColorAvgWgt.getColor().getRed());
					info.setAvgWgtG(cbColorAvgWgt.getColor().getGreen());
					info.setAvgWgtB(cbColorAvgWgt.getColor().getBlue());
					EggReceiveBillColorSettingFactory.getRemoteInstance().save(info);
					MsgBox.showInfo("±£´æ³É¹¦");
					ui.setDefalutRowValue();
					ui.setEntryRowColor();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				destroyWindow();
			}});
		btnRecovery.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				cbColorMei.setColor(new Color(255,255,255));
				cbColorWgt.setColor(new Color(235,251,179));
				cbColorAvgWgt.setColor(new Color(211,198,232));
			}});
	}

}