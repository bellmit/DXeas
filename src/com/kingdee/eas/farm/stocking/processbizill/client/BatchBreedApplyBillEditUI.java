/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class BatchBreedApplyBillEditUI extends AbstractBatchBreedApplyBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BatchBreedApplyBillEditUI.class);
    private String curCompanyID;
    
    /**
     * output class constructor
     */
    public BatchBreedApplyBillEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.BatchBreedApplyBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
    
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		initControl();
	}

	private void initControl() {
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				setFilter();
			}});
		setFilter();
		
		
		//人员过滤
//		StockingClientComm.makeApplierF7((KDBizPromptBox) kdtEntrys.getColumn("").getEditor().getComponent(), SysContext.getSysContext().getCurrentCtrlUnit().getString("id"), this, false);
		
	}
	/**
	 * 设置过滤条件
	 */
	private void setFilter() {
    	if(this.prmtcompany.getValue()!=null) {
    		curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
    	}else{
    		curCompanyID=null;
    	}
		//养殖户过滤
		StockingClientComm.setFarmerFilter(prmtfarmer, curCompanyID);
	}
	
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCopy_actionPerformed(e);
		if(!UtilRequest.isPrepare("ActionCopy", this))
            checkModified();
        if(editData != null && !OprtState.VIEW.equals(getOprtState()))
        {
            IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
            if(objectValue != null)
                try
                {
                    String id = idList.getID(idList.getCurrentIndex());
                    setOprtState("RELEASEALL");
                    pubFireVOChangeListener(id);
                }
                catch(Throwable E) { }
        }
        ObjectValueUtil.copy(editData);
        unLockUI();
        setFieldsNull(editData);
        editData.setBillStatus(BillBaseStatusEnum.ADD);
//        editData.setNumber(null);
        editData.setFarmer(null);
        editData.setBizDate(new java.util.Date());
        setOprtState("ADDNEW");
        setDataObject(editData);
        loadFields();
        showCopyAddNew();
        actionCopy.setEnabled(false);
        chkMenuItemSubmitAndAddNew.setVisible(true);
        setDefaultFocused();
        
        setMakeRelations(null);
	}
}