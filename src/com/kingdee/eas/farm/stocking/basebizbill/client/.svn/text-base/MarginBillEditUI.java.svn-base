/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basebizbill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basebizbill.MarginBillEntryInfo;
import com.kingdee.eas.farm.stocking.basebizbill.MarginBizTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class MarginBillEditUI extends AbstractMarginBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MarginBillEditUI.class);
    private String curCompanyID;
    private boolean isLoadField=false;
    /**
     * output class constructor
     */
    public MarginBillEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    public void loadFields()
    {
    	isLoadField=true;
        super.loadFields();
        isLoadField=false;
		
        if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
    }
    
    @Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
    
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}
	
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionRemove_actionPerformed(e);
	}
	/**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }
    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basebizbill.MarginBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo objectValue = new com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBizType(MarginBizTypeEnum.receiveAmount);
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
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				setFilter();
			}});
		
		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFarmFilter();
				addNewEntry();
			}});
		
		this.kdtEntrys_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent e) throws Exception {
			}
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				MarginBillEntryInfo entryInfo= (MarginBillEntryInfo) e.getObjectValue();
				FarmInfo farmInfo = StockingComm.getFarmInfoByFarmerID(null,((IPropertyContainer)prmtfarmer.getValue()).getString("id"));
				entryInfo.setFarm(farmInfo);
				if(prmtfarmer.getValue()!=null) {
					entryInfo.setOpPeronsName(((IPropertyContainer) prmtfarmer.getValue()).getString("name"));
				}
				entryInfo.setDate(new java.util.Date());
				
			}});
		
		//人员过滤
//		StockingClientComm.makeApplierF7((KDBizPromptBox) kdtEntrys.getColumn("").getEditor().getComponent(), SysContext.getSysContext().getCurrentCtrlUnit().getString("id"), this, false);
		setFilter();
	
	}
	/**
	 * 自动新增分录
	 */
	private void addNewEntry() {
		if(isLoadField) {
			return;
		}
		if(this.prmtfarmer.getValue()!=null&&this.kdtEntrys.getRowCount()<=0) {
			IRow row = kdtEntrys.addRow();
			FarmInfo farmInfo = StockingComm.getFarmInfoByFarmerID(null,((IPropertyContainer) this.prmtfarmer.getValue()).getString("id"));
			row.getCell("farm").setValue(farmInfo);
			row.getCell("opPeronsName").setValue(farmInfo.getName());
			row.getCell("date").setValue(new java.util.Date());
		}
	}
	
	private void setFarmFilter() {
		String farmerID=null;
		if(this.prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) this.prmtfarmer.getValue()).getString("id");
		}
		StockingClientComm.setFarmFilter((KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent(), curCompanyID, farmerID);
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
		setFarmFilter();
		
		// prmtmarginType
		 SelectorListener[] ls = this.prmtMarginType.getSelectorListeners();
		 for(int i=0;i<ls.length;i++) {
			 this.prmtMarginType.removeSelectorListener(ls[i]);
		 }
		
        prmtMarginType.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.MarginTypeListUI prmtmarginType_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtmarginType_F7ListUI == null) {
					try {
						prmtmarginType_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.MarginTypeListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								return false;
							}
							
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtmarginType_F7ListUI));
					prmtmarginType_F7ListUI.setF7Use(true,ctx);
					prmtMarginType.setSelector(prmtmarginType_F7ListUI);
				}
			}
		});
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
	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
//		if(this.prmtmarginType.getValue()==null) {
//			MsgBox.showWarning("保证金类型不能为空！");
//			SysUtil.abort();
//		}
	}
	
	
}