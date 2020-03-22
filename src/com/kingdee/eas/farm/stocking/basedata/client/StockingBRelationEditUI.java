/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class StockingBRelationEditUI extends AbstractStockingBRelationEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(StockingBRelationEditUI.class);
    
    /**
     * output class constructor
     */
    public StockingBRelationEditUI() throws Exception
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

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
	}
	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
		if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if (!this.editData.getBaseStatus().equals(wzBillBaseStatus.submit)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		
		super.actionAudit_actionPerformed(e);
		
		refreshCurPage();
    }

    private void refreshCurPage() {
		// TODO Auto-generated method stub


		if (editData.getId() != null) {
			BOSUuid pk = editData.getId();
			try {
				super.doAfterSave(new ObjectUuidPK(editData.getId()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editData.setId(pk);
		}else{
			try {
				this.loadData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
	}
    
    @Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub

		if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}

		super.actionRemove_actionPerformed(arg0);
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {

		if (!this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
	}
    
    
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.StockingBRelationFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.StockingBRelationTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }
    
    
    
    @Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		actionSave_actionPerformed(e);
		super.actionSubmit_actionPerformed(e);
	}

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.StockingBRelationInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.StockingBRelationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}