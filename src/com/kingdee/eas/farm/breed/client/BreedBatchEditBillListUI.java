/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class BreedBatchEditBillListUI extends AbstractBreedBatchEditBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BreedBatchEditBillListUI.class);
    
    /**
     * output class constructor
     */
    public BreedBatchEditBillListUI() throws Exception
    {
        super(); // 图标设置
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		// 默认过滤条件
		this.setFilterForQuery(this.getFilterInfo());
    }

    /**
     * 设置默认过滤条件
     */
    @Override
    public FilterInfo getFilterInfo(){
    	FilterInfo filterInfo  = new FilterInfo();
    	StorageOrgUnitInfo stoInfo = SysContext.getSysContext().getCurrentStorageUnit();
    	if(stoInfo == null){
    		SysUtil.abort();
    	}
    	
    	filterInfo.getFilterItems().add(new FilterItemInfo("stoOrg.id",stoInfo.getId().toString(),CompareType.EQUALS));
    	
    	
    	return filterInfo;
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
        return com.kingdee.eas.farm.breed.BreedBatchEditBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.BreedBatchEditBillInfo objectValue = new com.kingdee.eas.farm.breed.BreedBatchEditBillInfo();
		
        return objectValue;
    }

    /**
     * 审核
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showInfo("审核完成");
			
			this.refreshList();
			this.setMessageText("审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showInfo("反审核完成");
			
			this.refreshList();
			this.setMessageText("反审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

}