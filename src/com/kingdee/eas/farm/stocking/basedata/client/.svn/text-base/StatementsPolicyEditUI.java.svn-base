/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
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
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemFactory;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class StatementsPolicyEditUI extends AbstractStatementsPolicyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(StatementsPolicyEditUI.class);
    private F7ContextManager f7Manager;
    private OrgUnitInfo orgInfo = null;//库存组织
    private String curCompanyID;
    
    /**
     * output class constructor
     */
    public StatementsPolicyEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
       /* setColMerger(this.kdtPriceEntry,1,1);
        setColMerger(this.kdtRecycleEntry,1,1);*/
    }

    /**
	 * 设置单元格融合
	 */
	private void setColMerger(KDTable table,int colIndex1,int colIndex2) {
		table.getMergeManager().removeAllMergeBlock();
		try {
			String value,valueKeep=null;
		    String value2,valueKeep2=null;
			int rowIndexKeep=0;
			int rowIndexKeep2=0;
			for(int rowIndex=0;rowIndex<table.getRowCount();rowIndex++) {
				if(table.getRow(rowIndex).getCell(colIndex1).getValue()==null) {
					valueKeep=null;
					rowIndexKeep=0;
					continue;
				}
				value=table.getRow(rowIndex).getCell(colIndex1).getValue().toString();
				value2=table.getRow(rowIndex).getCell(colIndex2).getValue().toString();
				if(valueKeep==null){
					valueKeep=value;
					rowIndexKeep=rowIndex;
					
					valueKeep2=value2;
					rowIndexKeep2=rowIndex;
					
				}else{
					if(!valueKeep.equals(value)) {
						table.getMergeManager().mergeBlock(rowIndexKeep, colIndex1, rowIndex-1, colIndex1);
						valueKeep=value;
						rowIndexKeep=rowIndex;
						
						table.getMergeManager().mergeBlock(rowIndexKeep2, colIndex2, rowIndex-1, colIndex2);
						valueKeep2=value2;
						rowIndexKeep2=rowIndex;
					}else{
						if(!valueKeep2.equals(value2)) {
							table.getMergeManager().mergeBlock(rowIndexKeep2, colIndex2, rowIndex-1, colIndex2);
							valueKeep2=value2;
							rowIndexKeep2=rowIndex;
						}
					}
					if(rowIndex==(table.getRowCount()-1)) {
						table.getMergeManager().mergeBlock(rowIndexKeep, colIndex1, rowIndex, colIndex1);
						table.getMergeManager().mergeBlock(rowIndexKeep2, colIndex2, rowIndex, colIndex2);
					}
				}
			}
		}catch(Exception e) {
			
		}

	}
    

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.StatementsPolicyFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.StatementsPolicyTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
			objectValue.setBeginDate(sdf.parse(sdf.format(new java.util.Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return objectValue;
    }
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
    	curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		initControl();
	}
    
    private void initControl() {
    	this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		this.pkbeginDate.setDatePattern("yyyy-MM-dd");
		this.pkendDate.setDatePattern("yyyy-MM-dd");
		
    	CompanyF7 cf7=new CompanyF7();
    	cf7.setIsCUFilter(true);
    	this.prmtcompany.setSelector(cf7);
    	 try {
	    	orgInfo = CompanyOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(SysContext.getSysContext().getCurrentFIUnit().getId()));
			f7Manager = new F7ContextManager(this, OrgType.Company);
			f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtPriceEntry.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
			f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtRecycleEntry.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
			
    	 }catch(Exception err) {
    		 
    	 }
    	setSetlementItemFilter();
    	
    	this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setSetlementItemFilter();
			}});
    }
    /**
     * 获取有物料结算项目的物料
     * @return
     */
    private HashSet<String> getMaterialsInSettleItem() {
    	HashSet<String> set=new HashSet<String>();
    	try {
    		StringBuffer sql=new StringBuffer();
    		sql.append(" select tentry.fmaterialid")
    		.append(" from T_FM_SettlementItem tmain")
    		.append(" inner join T_FM_SettlementIME tentry on tentry.fparentid=tmain.fid")
    		.append(" where tmain.FCompanyID='").append(curCompanyID).append("'")
    		.append(" and tmain.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
    		.append(" and tentry.fmaterialid is not null")
    		;
    		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
    		while(rs.next()) {
    			if(rs.getString("fmaterialID")==null) {
    				continue;
    			}
    			set.add(rs.getString("fmaterialID"));
    		}
    	}catch(Exception err) {
    		err.printStackTrace();
    	}
    	return set;
    }
    
    /**
     * 设置结算项目过滤条件
     * @param companyID
     */
    private void setSetlementItemFilter() {
    	if(this.prmtcompany.getValue()!=null) {
    		curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
    	}else{
    		curCompanyID=null;
    	}
    	
    	EntityViewInfo ev0=new EntityViewInfo();
		FilterInfo filter0=new FilterInfo();
		filter0.getFilterItems().add(new FilterItemInfo("id",getMaterialsInSettleItem(),CompareType.INCLUDE));
		ev0.setFilter(filter0);
		((KDBizPromptBox) this.kdtPriceEntry.getColumn("material").getEditor().getComponent()).setEntityViewInfo(ev0);
		((KDBizPromptBox) this.kdtRecycleEntry.getColumn("material").getEditor().getComponent()).setEntityViewInfo(ev0);
    	
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.enable,CompareType.EQUALS));
		ev.setFilter(filter);
		
		//结算项目过滤
		final KDBizPromptBox kdtPriceEntry_settlementItem_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtPriceEntry_settlementItem_PromptBox.setVisible(true);
        kdtPriceEntry_settlementItem_PromptBox.setEditable(true);
        kdtPriceEntry_settlementItem_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_settlementItem_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_settlementItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_settlementItem_PromptBox);
        this.kdtPriceEntry.getColumn("settlementItem").setEditor(kdtPriceEntry_settlementItem_CellEditor);
        ObjectValueRender kdtPriceEntry_settlementItem_OVR = new ObjectValueRender();
        kdtPriceEntry_settlementItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPriceEntry.getColumn("settlementItem").setRenderer(kdtPriceEntry_settlementItem_OVR);
        			kdtPriceEntry_settlementItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtPriceEntry_settlementItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtPriceEntry_settlementItem_PromptBox_F7ListUI == null) {
					try {
						kdtPriceEntry_settlementItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
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
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtPriceEntry_settlementItem_PromptBox_F7ListUI));
					kdtPriceEntry_settlementItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtPriceEntry_settlementItem_PromptBox.setSelector(kdtPriceEntry_settlementItem_PromptBox_F7ListUI);
				}
			}
		});
        //奖惩政策		
		final KDBizPromptBox kdtAwardsEntry_policy_PromptBox = new KDBizPromptBox();
        kdtAwardsEntry_policy_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.RewardsPolicyQuery");
        kdtAwardsEntry_policy_PromptBox.setVisible(true);
        kdtAwardsEntry_policy_PromptBox.setEditable(true);
        kdtAwardsEntry_policy_PromptBox.setDisplayFormat("$number$");
        kdtAwardsEntry_policy_PromptBox.setEditFormat("$number$");
        kdtAwardsEntry_policy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAwardsEntry_policy_CellEditor = new KDTDefaultCellEditor(kdtAwardsEntry_policy_PromptBox);
        this.kdtAwardsEntry.getColumn("policy").setEditor(kdtAwardsEntry_policy_CellEditor);
        ObjectValueRender kdtAwardsEntry_policy_OVR = new ObjectValueRender();
        kdtAwardsEntry_policy_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAwardsEntry.getColumn("policy").setRenderer(kdtAwardsEntry_policy_OVR);
        			kdtAwardsEntry_policy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.RewardsPolicyListUI kdtAwardsEntry_policy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtAwardsEntry_policy_PromptBox_F7ListUI == null) {
					try {
						kdtAwardsEntry_policy_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.RewardsPolicyListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
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
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtAwardsEntry_policy_PromptBox_F7ListUI));
					kdtAwardsEntry_policy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtAwardsEntry_policy_PromptBox.setSelector(kdtAwardsEntry_policy_PromptBox_F7ListUI);
				}
			}
		});
    	//补贴政策		
		final KDBizPromptBox kdtSubsidyEntry_policy_PromptBox = new KDBizPromptBox();
        kdtSubsidyEntry_policy_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SubsidyQuery");
        kdtSubsidyEntry_policy_PromptBox.setVisible(true);
        kdtSubsidyEntry_policy_PromptBox.setEditable(true);
        kdtSubsidyEntry_policy_PromptBox.setDisplayFormat("$number$");
        kdtSubsidyEntry_policy_PromptBox.setEditFormat("$number$");
        kdtSubsidyEntry_policy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSubsidyEntry_policy_CellEditor = new KDTDefaultCellEditor(kdtSubsidyEntry_policy_PromptBox);
        this.kdtSubsidyEntry.getColumn("policy").setEditor(kdtSubsidyEntry_policy_CellEditor);
        ObjectValueRender kdtSubsidyEntry_policy_OVR = new ObjectValueRender();
        kdtSubsidyEntry_policy_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtSubsidyEntry.getColumn("policy").setRenderer(kdtSubsidyEntry_policy_OVR);
        			kdtSubsidyEntry_policy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SubsidyListUI kdtSubsidyEntry_policy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtSubsidyEntry_policy_PromptBox_F7ListUI == null) {
					try {
						kdtSubsidyEntry_policy_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SubsidyListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
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
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtSubsidyEntry_policy_PromptBox_F7ListUI));
					kdtSubsidyEntry_policy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtSubsidyEntry_policy_PromptBox.setSelector(kdtSubsidyEntry_policy_PromptBox_F7ListUI);
				}
			}
		});		
    }
	@Override
	public void kdtPriceEntry_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtPriceEntry_Changed(rowIndex, colIndex);
		if(kdtPriceEntry.getColumnKey(colIndex).equalsIgnoreCase("material")) {
			if(this.prmtcompany.getValue()!=null&&kdtPriceEntry.getCell(rowIndex, colIndex).getValue()!=null) {
				kdtPriceEntry.getCell(rowIndex, "settlementItem").setValue(getSettlementItemByMaterialID(((IPropertyContainer) this.prmtcompany.getValue()).getString("id"),((IPropertyContainer) kdtPriceEntry.getCell(rowIndex, colIndex).getValue()).getString("id")));
			}else{
				kdtPriceEntry.getCell(rowIndex, "settlementItem").setValue(null);
			}
		}
	}
	@Override
	public void kdtRecycleEntry_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtRecycleEntry_Changed(rowIndex, colIndex);
		if(kdtRecycleEntry.getColumnKey(colIndex).equalsIgnoreCase("material")) {
			if(this.prmtcompany.getValue()!=null&&kdtRecycleEntry.getCell(rowIndex, colIndex).getValue()!=null) {
				kdtRecycleEntry.getCell(rowIndex, "settlementItem").setValue(getSettlementItemByMaterialID(((IPropertyContainer) this.prmtcompany.getValue()).getString("id"),((IPropertyContainer) kdtRecycleEntry.getCell(rowIndex, colIndex).getValue()).getString("id")));
			}else{
				kdtRecycleEntry.getCell(rowIndex, "settlementItem").setValue(null);
			}
		}
	}
	/**
	 * 根据财务组织ID和物料ID获取 结算项目
	 * @param companyID
	 * @param materialID
	 * @return 
	 * @throws BOSException 
	 */
	private SettlementItemInfo getSettlementItemByMaterialID(String companyID,String materialID) throws BOSException {
//		EntityViewInfo view=new EntityViewInfo();
//		FilterInfo filter=new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
//		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
//		filter.getFilterItems().add(new FilterItemInfo("MaterialEntry_material.id",materialID,CompareType.EQUALS));
//		view.setFilter(filter);
//		SettlementItemCollection col = SettlementItemFactory.getRemoteInstance().getSettlementItemCollection(view);
//		if(col!=null&&col.size()>0) {
//			return col.get(0);
//		}
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tmain.fid from T_FM_SettlementItem tmain")
			.append(" inner join T_FM_SettlementIME tentry on tentry.fparentid=tmain.fid")
			.append(" where tentry.FMaterialID='").append(materialID).append("'")
			.append(" and tmain.FCompanyID='").append(companyID).append("'")
			.append(" and FbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" order by fcreatetime desc")
			;
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				return SettlementItemFactory.getRemoteInstance().getSettlementItemInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		this.actionCancelCancel.setEnabled(true);
		this.actionEdit.setEnabled(false);
		
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCopy_actionPerformed(e);
		if (!(UtilRequest.isPrepare("ActionCopy", this)))
		{
		  checkModified();
		}

		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState()))))
		{
		  IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
		  if (objectValue != null)
		  {
		    try
		    {
		      String id = this.idList.getID(this.idList.getCurrentIndex());
		      setOprtState("RELEASEALL");
		      pubFireVOChangeListener(id);
		    }
		    catch (Throwable E) {
		    }
		  }
		}
		ObjectValueUtil.copy(this.editData);

		unLockUI();

		setFieldsNull(this.editData);
		setOprtState("ADDNEW");
		

		this.editData.setBaseStatus(null);
		
		setDataObject(this.editData);
//		loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}
}