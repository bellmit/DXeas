/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.framework.*;
import com.sun.mail.handlers.message_rfc822;

/**
 * output class name
 */
public class GeneratePlanSelectUI extends AbstractGeneratePlanSelectUI
{
	private static final Logger logger = CoreUIObject.getLogger(GeneratePlanSelectUI.class);

	/**
	 * output class constructor
	 */
	public GeneratePlanSelectUI() throws Exception
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

	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.btnAddLine_actionPerformed(e);
	}

	@Override
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();


		hideButton();//�������а�ť

		boolean[] per=(boolean[])this.getUIContext().get("permission");
		if(per[0])
			kDComboBox1.addItem("�����ƻ�");
		if(per[1])
			kDComboBox1.addItem("�Ϸ��ƻ�");
		if(per[2])
			kDComboBox1.addItem("�����ƻ�");
		if(per[3])
			kDComboBox1.addItem("���׼ƻ�");
		if(kDComboBox1.getItemCount()==0)
			this.uiWindow.close();
		btnConfirm.requestFocus(true);


	}

	/**
	 * �򿪽���
	 */
	@Override
	protected void btnConfirm_actionPerforme(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kDComboBox1.getSelectedItem().equals(null))
			return;
		else if(kDComboBox1.getSelectedItem().equals("�����ƻ�"))
			generateNextBill("com.kingdee.eas.farm.breed.layegg.client.LayEggPlanEditUI");
		else if(kDComboBox1.getSelectedItem().equals("�Ϸ��ƻ�"))
			generateNextBill("com.kingdee.eas.farm.breed.business.client.CCBreedPlanEditUI");
		else if(kDComboBox1.getSelectedItem().equals("�����ƻ�"))
			generateNextBill("com.kingdee.eas.farm.hatch.client.BatchPlanEditUI");
		else if(kDComboBox1.getSelectedItem().equals("��ɱ�ƻ�"))
			generateNextBill("com.kingdee.eas.farm.food.client.SlaughterPlanEditUI");
		this.uiWindow.close();
		super.btnConfirm_actionPerforme(e);
	}


	/**
	 * �򿪼ƻ���������
	 * @param billString    �����ȫ·��
	 */
	protected void generateNextBill(String billString){
		String destBillEditUIClassName =billString;
		Map map = new UIContext(this);
		map.put(UIContext.OWNER, this);
		IUIWindow uiWindow = null ;
		try {
			uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
		} catch (UIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ʼչ��UI
		uiWindow.show();
	}

	/**
	 * ����ͼ��
	 */
	protected void hideButton() {
		// TODO Auto-generated method stub
		this.btnAddNew.setVisible(false);
		this.btnCopy.setVisible(false);
		this.btnEdit.setVisible(false);
		this.btnSave.setVisible(false);
		this.btnSubmit.setVisible(false);
		this.btnRemove.setVisible(false);

		this.btnNext.setVisible(false);
		this.btnLast.setVisible(false);
		this.btnPre.setVisible(false);
		this.btnFirst.setVisible(false);

		this.btnAttachment.setVisible(false);

		this.btnAddLine.setVisible(false);
		this.btnInsertLine.setVisible(false);
		this.btnRemoveLine.setVisible(false);


		this.btnAuditResult.setVisible(false);
		this.btnWorkFlowG.setVisible(false);
		this.btnNextPerson.setVisible(false);
		this.btnMultiapprove.setVisible(false);
		this.btnCreateFrom.setVisible(false);

		this.btnPrint.setVisible(false);
		this.btnPrintPreview.setVisible(false);

		this.btnTraceDown.setVisible(false);
		this.btnTraceUp.setVisible(false);
		
		this.menuBar.setVisible(false);
	}

}