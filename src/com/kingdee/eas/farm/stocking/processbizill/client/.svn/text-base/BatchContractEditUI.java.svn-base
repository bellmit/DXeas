/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class BatchContractEditUI extends AbstractBatchContractEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BatchContractEditUI.class);
    private String curCompanyID;//当前财务组织
    private boolean isLoadField=false;
    private BaseSysSettingInfo sysSetting;
    
    /**
     * output class constructor
     */
    public BatchContractEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    public void loadFields()
    {
    	DataChangeListener[] ls = this.prmtMarginBill.getListeners(DataChangeListener.class);
    	for(int index=0;index<ls.length;index++) {
    		this.prmtMarginBill.removeDataChangeListener(ls[index]);
    	}
    	isLoadField=true;
        super.loadFields(); 
        isLoadField=false;
        for(int index=0;index<ls.length;index++) {
    		this.prmtMarginBill.addDataChangeListener(ls[index]);
    	}
        
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
        
        UITools.apendFootRow(kdtReceiveBillEntry, new String[]{"receiveAmount"});
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
        return com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        objectValue.setContractDate(new java.util.Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBillStatus(BillBaseStatusEnum.ADD);
        
        return objectValue;
    }
    
    @Override
	public void storeFields() {
		// TODO Auto-generated method stub
		super.storeFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
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
		
		this.prmtMarginBill.setDisplayFormat("$number$");
		this.prmtMarginBill.setRequired(true);
		this.prmtreceiveBill.setRequired(true);
		
		prmtreceiveBill.setQueryInfo("com.kingdee.eas.farm.stocking.processbizill.app.StockingCasReceivingBillQuery");
		
		this.kdtReceiveBillEntry.checkParsed();
		
		KDBizPromptBox kdtReceiveBillEntry_receiveBill_PromptBox = new KDBizPromptBox();
        kdtReceiveBillEntry_receiveBill_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.processbizill.app.StockingCasReceivingBillQuery");
        kdtReceiveBillEntry_receiveBill_PromptBox.setVisible(true);
        kdtReceiveBillEntry_receiveBill_PromptBox.setEditable(true);
        kdtReceiveBillEntry_receiveBill_PromptBox.setDisplayFormat("$number$");
        kdtReceiveBillEntry_receiveBill_PromptBox.setEditFormat("$number$");
        kdtReceiveBillEntry_receiveBill_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtReceiveBillEntry_receiveBill_CellEditor = new KDTDefaultCellEditor(kdtReceiveBillEntry_receiveBill_PromptBox);
        this.kdtReceiveBillEntry.getColumn("receiveBill").setEditor(kdtReceiveBillEntry_receiveBill_CellEditor);
        ObjectValueRender kdtReceiveBillEntry_receiveBill_OVR = new ObjectValueRender();
        kdtReceiveBillEntry_receiveBill_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtReceiveBillEntry.getColumn("receiveBill").setRenderer(kdtReceiveBillEntry_receiveBill_OVR);
        			EntityViewInfo evikdtReceiveBillEntry_receiveBill_PromptBox = new EntityViewInfo ();
		evikdtReceiveBillEntry_receiveBill_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"company.id"));
		kdtReceiveBillEntry_receiveBill_PromptBox.setEntityViewInfo(evikdtReceiveBillEntry_receiveBill_PromptBox);
		
		setFilter();
		
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});
		
		this.prmtMarginBill.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				marginChanged(e);
			}});
		

		//检查是否具有设置权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isTemplatetockingBatchCrt");
			this.chkisTemplate.setVisible(true);
		}catch(Exception err) {
			this.chkisTemplate.setVisible(false);
		}
		
		//检查是否具有初始化权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isInitStockingBatchCrt");
			this.chkisInit.setVisible(true);
		}catch(Exception err) {
			this.chkisInit.setVisible(false);
		}
	}
	
	/**
	 * 保证金改变 设置保证金金额
	 * @param e
	 */
	private void marginChanged(DataChangeEvent e) {
		if(e.getNewValue()==null) {
			this.txtMarginBillAmount.setValue(null);
		}else{
			try {
				StringBuffer sql=new StringBuffer();
				sql.append(" select sum(tentry.FAmount) FAMount from T_FM_MarginBill tbill")
				.append(" inner join T_FM_MarginBillEntry tentry on tentry.fparentid=tbill.fid")
				.append(" where tbill.fid='").append(((IPropertyContainer) e.getNewValue()).getString("id")).append("'");
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				if(rs.next()) {
					this.txtMarginBillAmount.setValue(rs.getBigDecimal("FAMount"));
				}
				rs.close();
			}catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	
	@Override
	public void prmtfarmer_Changed() throws Exception {
		// TODO Auto-generated method stub
		super.prmtfarmer_Changed();
		setFarmFilter();
		setReceiveBillFilter();
		if(!isLoadField) {
			StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
		}
	}
	

	@Override
	public void kdtReceiveBillEntry_Changed(int rowIndex, int colIndex)
			throws Exception {
		// TODO Auto-generated method stub
		super.kdtReceiveBillEntry_Changed(rowIndex, colIndex);
		BigDecimal allAmount=BigDecimal.ZERO;
		for(int i=0;i<kdtReceiveBillEntry.getRowCount();i++) {
			allAmount=allAmount.add(UIRuleUtil.getBigDecimal(kdtReceiveBillEntry.getCell(rowIndex,"receiveAmount").getValue()));
		}
		this.txtMarginBillAmount.setValue(allAmount);
		UITools.apendFootRow(kdtReceiveBillEntry, new String[]{"receiveAmount"});
	}

	@Override
	public void prmtMarginBill_Changed() throws Exception {
		// TODO Auto-generated method stub
		super.prmtMarginBill_Changed();
		if(this.prmtMarginBill.getValue()!=null) {
			MarginBillInfo info=(MarginBillInfo) prmtMarginBill.getValue();
			for(int index=0;index<info.getEntrys().size();index++) {
				if(index==0){
					this.prmtfarm.setValue(FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(info.getEntrys().get(index).getFarm().getId())));
					this.txtbreedQty.setValue(info.getEntrys().get(index).getQty());
				}
			}
		}
	}
	
	private void setFarmFilter() {
		String farmerID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		//养殖场过滤
		StockingClientComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID);
	}

	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
		sysSetting = StockingComm.getSysSetting(null,curCompanyID);
		
		//人员过滤
		StockingClientComm.makeApplierF7(this.prmtperson, curCompanyID, this, false);
		//批次过滤
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		StockingClientComm.setStockingBatchFilter(prmtstockingBatch,curCompanyID,farmerID,farmID);
		this.prmtstockingBatch.setRequired(false);
		//养殖户过滤
		StockingClientComm.setFarmerFilter(prmtfarmer, curCompanyID);
		setFarmFilter();
		 
		//设置保证金过滤条件
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		ev.setFilter(filter);
		this.prmtMarginBill.setEntityViewInfo(ev);
		
		setReceiveBillFilter();
		
		//设置结算政策过滤条件
		SelectorListener[] ls = prmtsettlementPolicy.getSelectorListeners();
		 for(int i=0;i<ls.length;i++) {
			 prmtsettlementPolicy.removeSelectorListener(ls[i]);
		 }
		 prmtsettlementPolicy.addSelectorListener(new SelectorListener() {
				com.kingdee.eas.farm.stocking.basedata.client.StatementsPolicyListUI prmtsettlementPolicy_F7ListUI = null;
				public void willShow(SelectorEvent e) {
					if (prmtsettlementPolicy_F7ListUI == null) {
						try {
							prmtsettlementPolicy_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StatementsPolicyListUI(){
								@Override
								protected FilterInfo getDefaultFilterForQuery() {
									FilterInfo filter=new FilterInfo();
									filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
									filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
									SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
									Calendar cal=Calendar.getInstance();
									try {
										cal.setTime(sdf.parse(sdf.format(pkBizDate.getTimestamp())));
									} catch (ParseException e) {
										e.printStackTrace();
									}
									filter.getFilterItems().add(new FilterItemInfo("beginDate",cal.getTime(),CompareType.LESS_EQUALS));
//									cal.add(Calendar.DAY_OF_MONTH, 1);
									filter.getFilterItems().add(new FilterItemInfo("endDate",cal.getTime(),CompareType.GREATER_EQUALS));
									if(prmtbreedData.getValue()!=null) {
//										filter.getFilterItems().add(new FilterItemInfo("breedData.id",((IPropertyContainer) prmtbreedData.getValue()).getString("id"),CompareType.GREATER));
									}
									return filter;
								}
								@Override
								protected boolean isIgnoreCUFilter() {
									// TODO Auto-generated method stub
									return false;
								}
								@Override
								protected boolean isIgnoreTreeCUFilter() {
									// TODO Auto-generated method stub
									return false;
								}
							};
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						HashMap ctx = new HashMap();
						ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsettlementPolicy_F7ListUI));
						prmtsettlementPolicy_F7ListUI.setF7Use(true,ctx);
						prmtsettlementPolicy.setSelector(prmtsettlementPolicy_F7ListUI);
					}
				}
			});
	}
	
	/**
	 * 设置收款单过滤
	 */
	private void setReceiveBillFilter() {
		//收款单过滤
		EntityViewInfo ev1=new EntityViewInfo();
		FilterInfo filter1=new FilterInfo();
		filter1.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter1.getFilterItems().add(new FilterItemInfo("billStatus",BillStatusEnum.PAYED_VALUE,CompareType.EQUALS));
		filter1.getFilterItems().add(new FilterItemInfo("billStatus",BillStatusEnum.RECED_VALUE,CompareType.EQUALS));
		filter1.getFilterItems().add(new FilterItemInfo("billStatus",BillStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		filter1.getFilterItems().add(new FilterItemInfo("billStatus",BillStatusEnum.APPROVED_VALUE,CompareType.EQUALS));
		filter1.getFilterItems().add(new FilterItemInfo("isInitializeBill",false,CompareType.EQUALS));
		filter1.setMaskString("#0 AND (#1 OR #2 OR #3 OR #4) AND #5");
		
		//已经被合同引用的收款单id
		HashSet usedIDs = getHasUsedRecieveIDs();
//		if(usedIDs.size()>0) {
			filter1.getFilterItems().add(new FilterItemInfo("id",usedIDs,CompareType.NOTINCLUDE));
			filter1.setMaskString(filter1.getMaskString()+" AND #6");
//		}
		
		//成本中心
		String costCentorID ="";
		if(prmtfarmer.getValue()!=null) {
			try {
				costCentorID = ((IPropertyContainer) UIRuleUtil.getProperty((IObjectValue) prmtfarmer.getValue(), "costCenter")).getString("id");
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}
		filter1.getFilterItems().add(new FilterItemInfo("costCenter.id",costCentorID,CompareType.EQUALS));
		filter1.setMaskString(filter1.getMaskString()+" AND #7");
		
		if(sysSetting!=null) {
			HashSet ids=new HashSet();
			for(int index=0;index<sysSetting.getMarginTypeEntry().size();index++) {
				ids.add(sysSetting.getMarginTypeEntry().get(index).getReceiveType().getString("id"));
			}
			if(ids.size()>0) {
				filter1.getFilterItems().add(new FilterItemInfo("recBillType.id",ids,CompareType.INCLUDE));
				filter1.setMaskString(filter1.getMaskString()+" AND #8");
			}
		}
	
		
		ev1.setFilter(filter1);
		this.prmtreceiveBill.setEntityViewInfo(ev1);
		
		((KDBizPromptBox) this.kdtReceiveBillEntry.getColumn("receiveBill").getEditor().getComponent()).setEntityViewInfo(ev1);
	}
	
	
	/**
	 * 获取已经被合同引用的收款单id
	 * @return
	 */
	private HashSet getHasUsedRecieveIDs() {
		HashSet ids=new HashSet();
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid")
			.append(" from T_FM_BatchContract ")
			.append(" where FCompanyID='").append(curCompanyID).append("'")
			.append(" ");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()) {
				ids.add(rs.getString("fid"));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return ids;
	}

	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(!this.chkisTemplate.isSelected()) {//不可见，非m模板
			super.beforeStoreFields(arg0);
		}
		if(!this.chkisInit.isSelected()) {
			/*if() {
				
			}*/
		}
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