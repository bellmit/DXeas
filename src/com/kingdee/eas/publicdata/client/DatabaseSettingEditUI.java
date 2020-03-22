/**
 * output package name
 */
package com.kingdee.eas.publicdata.client;

import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.BizOrgRangeF7PromptDialog;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class DatabaseSettingEditUI extends AbstractDatabaseSettingEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DatabaseSettingEditUI.class);
	private Point rm=null;
    
    
    /**
     * output class constructor
     */
    public DatabaseSettingEditUI() throws Exception
    {
        super();
        BizOrgRangeF7PromptDialog f7=new BizOrgRangeF7PromptDialog(SysContext.getSysContext().getCurrentUserInfo());
        f7.setIsCUFilter(true);
        f7.setMultiSelect(false);
        //f7.setTitle("组织hha");
        this.prmtorgUnit.setSelector(f7);
        this.prmtorgUnit.setDisplayFormat("$name$");
        
        this.dbType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				dbTypeChanged(e);
			}}
        );
        
    }
    /**
     * 数据库类型改变
     */
    private void dbTypeChanged(ItemEvent e) {
    	if(e.getItem().equals(com.kingdee.eas.publicdata.dbType.access)) {
    		this.contdbFileAddress.setVisible(true);
        	this.contdbIP.setVisible(false);
        	this.contdbPort.setVisible(false);
        	this.contdbNameJS.setVisible(true);
        }else {
        	this.contdbFileAddress.setVisible(false);
        	this.contdbIP.setVisible(true);
        	this.contdbPort.setVisible(true);
        	this.contdbNameJS.setVisible(false);
        }
    }
    
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        if(this.editData.getDbType().equals(com.kingdee.eas.publicdata.dbType.access)) {
        	this.contdbFileAddress.setVisible(true);
        	this.contdbIP.setVisible(false);
        	this.contdbPort.setVisible(false);
        	this.contdbNameJS.setVisible(true);
        }else {
        	this.contdbFileAddress.setVisible(false);
        	this.contdbIP.setVisible(true);
        	this.contdbPort.setVisible(true);
        	this.contdbNameJS.setVisible(false);
        }
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
        this.editData.setOrgUnit((FullOrgUnitInfo) this.prmtorgUnit.getValue());
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.publicdata.DatabaseSettingTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.publicdata.DatabaseSettingInfo objectValue = new com.kingdee.eas.publicdata.DatabaseSettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setOrgUnit((FullOrgUnitInfo) SysContext.getSysContext().getCurrentOrgUnit());
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
	}
    
    

}