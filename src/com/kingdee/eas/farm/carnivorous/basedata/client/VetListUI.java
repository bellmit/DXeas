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
import com.kingdee.eas.farm.carnivorous.basedata.IVet;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class VetListUI extends AbstractVetListUI
{
    private static final Logger logger = CoreUIObject.getLogger(VetListUI.class);
    
    /**
     * output class constructor
     */
    public VetListUI() throws Exception
    {
        super();
    }

    public void onLoad() throws Exception {
		super.onLoad();
		this.actionCancel.setVisible(true);
		this.actionCancelCancel.setVisible(true);
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));		
	}


	protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.tblMain_tableSelectChanged(e);
		String baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "baseStatus").toString();
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

	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		actionRefresh_actionPerformed(e);
	}
	
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception  {
		IVet  intenface= (IVet) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// ���õĵ����Ի��򷽷�
		for(int j=0;j<billIdlist.length;j++){
				// ��˲���
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			intenface.audit(intenface.getVetInfo(pk));
		}
		MsgBox.showInfo("��׼�ɹ���");
		refreshList();
    }
    
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
    	
    	checkSelected();
    	
    	IVet  intenface= (IVet) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// ���õĵ����Ի��򷽷�
		for(int j=0;j<billIdlist.length;j++){
				// ����׼����
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				intenface.unAudit(intenface.getVetInfo(pk));		
		}
		MsgBox.showInfo("����׼�ɹ���");
		refreshList();
    }


	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
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


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.VetFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.VetInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.VetInfo();
		
        return objectValue;
    }

}