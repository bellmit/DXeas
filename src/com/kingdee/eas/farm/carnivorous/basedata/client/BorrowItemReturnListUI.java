/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn;
import com.kingdee.eas.farm.carnivorous.basedata.IBrowerItemNew;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BorrowItemReturnListUI extends AbstractBorrowItemReturnListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BorrowItemReturnListUI.class);
    
    /**
     * output class constructor
     */
    public BorrowItemReturnListUI() throws Exception
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
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BorrowItemReturnFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.BorrowItemReturnInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.BorrowItemReturnInfo();
		
        return objectValue;
    }

    protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.tblMain_tableClicked(e);
		String baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "billStatue").toString();
		if(baseStatus.equals("����")) {
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(true);
			this.actionEdit.setEnabled(false);
		}else if(baseStatus.equals("��׼")) {
			this.actionCancel.setEnabled(true);
			this.actionCancelCancel.setEnabled(false);
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

	
	 /**
     * output actionAudit_actionPerformed
     */
    public void actionAudtit_actionPerformed(ActionEvent e) throws Exception
    {
//        super.actionAudit_actionPerformed(e);
    	checkSelected();
    	if (this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("billStatue")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("�����Ѿ���׼����ֹ�ٴκ�׼��");
			// ״̬����ȷ����ֹ����
			SysUtil.abort();
		}
		IBorrowItemReturn  intenface= (IBorrowItemReturn) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// ���õĵ����Ի��򷽷�
		for(int j=0;j<billIdlist.length;j++){
				// ��˲���
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				intenface.audtit(intenface.getBorrowItemReturnInfo(pk));
		}
		MsgBox.showInfo("��׼�ɹ���");
		refreshList();
    }
    
	 /**
     * output actionAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
//        super.actionAudit_actionPerformed(e);
    	checkSelected();
    	if (!this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("billStatue")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("δ��׼���ݲ��ܷ���׼��");
			// ״̬����ȷ����ֹ����
			SysUtil.abort();
		}
    	IBorrowItemReturn  intenface= (IBorrowItemReturn) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// ���õĵ����Ի��򷽷�
		for(int j=0;j<billIdlist.length;j++){
				// ����׼����
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				intenface.unAudit(intenface.getBorrowItemReturnInfo(pk));		
		}
		MsgBox.showInfo("����׼�ɹ���");
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