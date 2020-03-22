/**
 * output package name
 */
package com.kingdee.eas.farm.pig.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.farm.pig.DisableState;
import com.kingdee.eas.farm.pig.PigFarmInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class PigHouseEditUI extends AbstractPigHouseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(PigHouseEditUI.class);
    
    /**
     * output class constructor
     */
    public PigHouseEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
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
        return com.kingdee.eas.farm.pig.PigHouseFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.pig.PigHouseTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.PigHouseInfo objectValue = new com.kingdee.eas.farm.pig.PigHouseInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    
    /**
     * 界面初始化完成
     */
    @Override
	public void onLoad() throws Exception {
		// 
		super.onLoad();
		
		if(this.editData != null && this.editData.getId() != null && this.editData.getDeletedStatus() != null){
			if(this.editData.getDeletedStatus().getValue() == DisableState.DISABLE_VALUE){
				if("EDIT".equals(this.getOprtState()) || "VIEW".equals(this.getOprtState())){
					this.btnCancel.setEnabled(false);
					this.btnCancelCancel.setEnabled(true);
				}
			}else{
				this.btnCancel.setEnabled(true);
				this.btnCancelCancel.setEnabled(false);
			}
		}else{
			this.editData.setDeletedStatus(DisableState.Enable);
			this.deletedStatus.setSelectedItem(DisableState.Enable);
		}
	}
    /**
     * 修改养殖场时 更新所属库存组织
     */
	@Override
	protected void prmtpigFarm_dataChanged(DataChangeEvent e) throws Exception {
		PigFarmInfo currPigFarm = (PigFarmInfo) this.prmtpigFarm.getData();
		if(currPigFarm != null){
			StorageOrgUnitInfo stoOrgInfo = currPigFarm.getStoOrgUnit();
			if(stoOrgInfo != null){
				this.prmtstoOrg.setValue(stoOrgInfo);
			}
			
		}
	}
    
    
    

}