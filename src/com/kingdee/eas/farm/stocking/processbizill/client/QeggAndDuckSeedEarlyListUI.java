/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.ncm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class QeggAndDuckSeedEarlyListUI extends AbstractQeggAndDuckSeedEarlyListUI
{
	private static final Logger logger = CoreUIObject.getLogger(QeggAndDuckSeedEarlyListUI.class);

	/**
	 * output class constructor
	 */
	public QeggAndDuckSeedEarlyListUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		setUITitle("2018年5.1日各区合格蛋、鸭苗库存");
		super.onLoad();
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)) {
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
}