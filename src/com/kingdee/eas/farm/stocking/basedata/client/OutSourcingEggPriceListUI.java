/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.client.EASResource;

/**
 * output class name
 */
public class OutSourcingEggPriceListUI extends AbstractOutSourcingEggPriceListUI
{
	private static final Logger logger = CoreUIObject.getLogger(OutSourcingEggPriceListUI.class);

	/**
	 * output class constructor
	 */
	public OutSourcingEggPriceListUI() throws Exception
	{
		super();
	}


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.actionCancel.setVisible(true);
		this.actionCancelCancel.setVisible(true);
	}

	protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		super.tblMain_tableSelectChanged(e);
		String baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "baseStatus").toString();
		if(baseStatus.equals("ÆôÓÃ")) {
			this.actionCancel.setEnabled(true);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(false);
		}else if(baseStatus.equals("ºË×¼")) {
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(true);
			this.actionEdit.setEnabled(false);
		}else{
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(true);
		}
	}

	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		actionRefresh_actionPerformed(e);
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		super.actionAudit_actionPerformed(e);
		refreshList();
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		super.actionUnAudit_actionPerformed(e);
		refreshList();
	}

	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCancelCancel_actionPerformed(e);
		checkSelected();
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
			return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
			prepareCancel(null).callHandler();
		}
		cancelCancel();
		actionRefresh_actionPerformed(e);
	}
}