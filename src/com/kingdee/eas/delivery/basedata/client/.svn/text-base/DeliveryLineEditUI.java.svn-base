/**
 * output package name
 */
package com.kingdee.eas.delivery.basedata.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DeliveryLineEditUI extends AbstractDeliveryLineEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DeliveryLineEditUI.class);
    
    /**
     * output class constructor
     */
    public DeliveryLineEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        if(this.editData.isIsInner()) {
//        	this.prmtfromStorageOrg.setEnabled(true);
        	this.prmttoStorageOrg.setEnabled(true);
        	this.prmtbeginStation.setEnabled(false);
        	this.prmtendStation.setEnabled(false);
        }else {
//        	this.prmtfromStorageOrg.setEnabled(false);
        	this.prmttoStorageOrg.setEnabled(false);
        	this.prmtbeginStation.setEnabled(true);
        	this.prmtendStation.setEnabled(true);
        }
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
        return com.kingdee.eas.delivery.basedata.DeliveryLineFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.delivery.basedata.DeliveryLineInfo objectValue = new com.kingdee.eas.delivery.basedata.DeliveryLineInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setFromStorageOrg(SysContext.getSysContext().getCurrentStorageUnit());
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		this.prmtfromStorageOrg.setRequired(true);
		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtfromStorageOrg.setSelector(sf7);
		this.prmttoStorageOrg.setSelector(new StorageF7());
		
		this.chkisInner.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				chkIsInnerChanged();
			}});
	}
    private void chkIsInnerChanged() {
    	if(this.chkisInner.isSelected()) {
    		this.prmtbeginStation.setValue(null);
    		this.prmtendStation.setValue(null);
    		this.prmttoStorageOrg.setEnabled(true);
        	this.prmtbeginStation.setEnabled(false);
        	this.prmtendStation.setEnabled(false);
    	}else {
    		this.prmttoStorageOrg.setValue(null);
    		this.prmttoStorageOrg.setEnabled(false);
        	this.prmtbeginStation.setEnabled(true);
        	this.prmtendStation.setEnabled(true);
    	}
    }
	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		super.verifyInput(e);
		if(this.chkisInner.isSelected()&&this.prmttoStorageOrg.getValue()==null) {
			MsgBox.showWarning("目的组织不能为空！");
			SysUtil.abort();
		}
	}

}