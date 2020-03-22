/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
//import com.kingdee.eas.WSInterface.billFacade.BaseBillSupport;
import com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BreedSeedCostListUI extends AbstractBreedSeedCostListUI
{
    @Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		refresh(e);
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			int n = MsgBox.showConfirm2("点击修改将自动反审核当前的基础资料，是否确认");
			if(n==0){
				BreedSeedCostInfo info = BreedSeedCostFactory.getRemoteInstance().getBreedSeedCostInfo(new ObjectUuidPK(getSelectedKeyValue()));
				BreedSeedCostFactory.getRemoteInstance().unAudit(info);
			}else
				return;
		}
		super.actionEdit_actionPerformed(e);
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核成功");
		refresh(e);
	}

	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo query = super.getDefaultFilterForQuery();
		String mask = query.getMaskString();
		int size = query.getFilterItems().size();
		query.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.DELETED_VALUE,CompareType.NOTEQUALS));
		mask="("+mask+") AND (#"+size+")";
		query.setMaskString(mask);
		return query;
	}

	private static final Logger logger = CoreUIObject.getLogger(BreedSeedCostListUI.class);
    
    /**
     * output class constructor
     */
    public BreedSeedCostListUI() throws Exception
    {
        super();
    }

    @Override
	protected void abort() {
		// TODO Auto-generated method stub
		super.abort();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		btnUnAudit.setVisible(true);
		this.btnUnAudit.setVisible(true);
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
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
        return com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostInfo();
		
        return objectValue;
    }

}