/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.payReqBillFacade;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class ToReqPay extends AbstractToReqPay
{
	SignWasTheTableInfo info=null;
	ArrayList<Integer> entryColl=new ArrayList<Integer>();
	BOTMappingCollection botMappingColl=null;
	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		info=(SignWasTheTableInfo) this.getUIContext().get("srcBillInfo");
		entryColl=(ArrayList<Integer>) this.getUIContext().get("entryColl");
		botMappingColl = (BOTMappingCollection) this.getUIContext().get("botMappingCollection");
		for(int i=0;i<botMappingColl.size();i++)
			cbReqPaySelect.addItem(botMappingColl.get(i).getAlias());
		setUI();

	}

	private void setUI() {
		// TODO Auto-generated method stub
		menuBar.setVisible(false);

		this.btnAddNew.setVisible(false);
		this.btnEdit.setVisible(false);
		this.btnSave.setVisible(false);
		this.btnSubmit.setVisible(false);
		this.btnCopy.setVisible(false);
		this.btnRemove.setVisible(false);
		this.btnAttachment.setVisible(false);
		this.btnPrint.setVisible(false);
		this.btnPrintPreview.setVisible(false);
		this.btnPre.setVisible(false);
		this.btnNext.setVisible(false);
		this.btnLast.setVisible(false);
		this.btnFirst.setVisible(false);
		this.btnCancel.setVisible(false);
		this.btnCancelCancel.setVisible(false);

	}

	@Override
	protected void btnConfirm_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		String botpMappingName=(String) cbReqPaySelect.getSelectedItem();

		BOTMappingInfo botMappingInfo=null;
		for(int i=0;i<botMappingColl.size();i++)
			if(botMappingColl.get(i).getAlias().equals(botpMappingName))
				botMappingInfo=botMappingColl.get(i);
			PayRequestBillInfo payReqInfo=com.kingdee.eas.custom.signwasthetable.createToPayFactory.getRemoteInstance().toPayReqFromSignTable(info, entryColl, botMappingInfo);
		showPayReqInfo(payReqInfo);
		super.btnConfirm_mouseClick(e);
	}

	private void showPayReqInfo(PayRequestBillInfo payReqInfo) throws UIException {
		// TODO Auto-generated method stub
		String destBillEditUIClassName ="com.kingdee.eas.fi.ap.client.PayRequestBillEditUI";
		Map map = new UIContext(this);
		map.put("ID",payReqInfo.getId().toString());
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
		uiWindow.show();
	}

	private static final Logger logger = CoreUIObject.getLogger(ToReqPay.class);

	/**
	 * output class constructor
	 */
	public ToReqPay() throws Exception
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

}