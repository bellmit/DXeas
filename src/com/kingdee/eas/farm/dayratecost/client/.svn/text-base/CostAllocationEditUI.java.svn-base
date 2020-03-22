/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.PeriodUtils;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.dayratecost.AllocationTypeEnum;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo;
import com.kingdee.eas.farm.dayratecost.comm.DayrateUtils;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class CostAllocationEditUI extends AbstractCostAllocationEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CostAllocationEditUI.class);
    private String curCompanyID;
    private boolean isLoadField=false;
    private String[] mergeCols;//融合列
    
    /**
     * output class constructor
     */
    public CostAllocationEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

    public void loadFields()
    {
    	isLoadField=true;
        super.loadFields();
        isLoadField=false;
		
        actionExeAllocation.setEnabled(true);
        if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
			actionExeAllocation.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
        setFiledHided();
//        UITools.apendFootRow(kdtDetail, new String[]{});
//        setMerge();
    }
    
    @Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
    
    @Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	checkFiled();
		super.actionSubmit_actionPerformed(e);
	}
    
    

	@Override
	public void actionExeAllocation_actionPerformed(ActionEvent e)		throws Exception {
		checkFiled();
		storeFields();
	
		LongTimeDialog dialog = new LongTimeDialog( (Frame) SwingUtilities.getWindowAncestor(this)); 
		dialog.setLongTimeTask(new ILongTimeTask() {
		public Object exec() throws Exception { 
			Object obj = "12345"; 
			// 查询的数据赋值与表格 
			exeAll();
			return obj; 
		} 

		public void afterExec(Object result) throws Exception {
			MsgBox.showInfo("费用分摊完成！"); 
		} 
		}); 
		Component[] cps=dialog.getContentPane().getComponents(); 
		for(Component cp:cps){ 
			if(cp instanceof JLabel){ 
				((JLabel) cp).setText("费用分摊执行中......."); 
			} 
		} 
		dialog.show(); 
		doAfterSave(new ObjectUuidPK(this.editData.getId()));
		
	}
	
	private void exeAll() {
		try {
			super.actionExeAllocation_actionPerformed(null);
		} catch (Exception e) {
			handleException(e);
		}
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
        return com.kingdee.eas.farm.dayratecost.CostAllocationFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.dayratecost.CostAllocationInfo objectValue = new com.kingdee.eas.farm.dayratecost.CostAllocationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBizDate(new java.util.Date());
        return objectValue;
    }
    
    @Override
	public void onLoad() throws Exception {
    	curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		initControls();
	}
    
    private void initControls() {
    	this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		
        KDFormattedTextField kdtDetail_proportion_TextField = new KDFormattedTextField();
        kdtDetail_proportion_TextField.setName("kdtDetail_proportion_TextField");
        kdtDetail_proportion_TextField.setVisible(true);
        kdtDetail_proportion_TextField.setEditable(true);
        kdtDetail_proportion_TextField.setHorizontalAlignment(2);
        kdtDetail_proportion_TextField.setDataType(1);
        	kdtDetail_proportion_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_proportion_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_proportion_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_proportion_CellEditor = new KDTDefaultCellEditor(kdtDetail_proportion_TextField);
        this.kdtDetail.getColumn("proportion").setEditor(kdtDetail_proportion_CellEditor);
        
		
    	CompanyF7 cf7=new CompanyF7();
    	cf7.setIsCUFilter(true);
    	this.prmtcompany.setSelector(cf7);
    
    	allocationType.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setFiledHided();
			}});
    	prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setFilter();
			}});
    	
    	this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				farmer_changed();
			}});
    	
    	prmtfarmerGroup.setRequired(true);
    	prmtfarmGroup.setRequired(true);
    	
    	kdtDetail.addKDTEditListener(new KDTEditAdapter(){
			public void editStarted(KDTEditEvent e) {
			}
			public void editStopped(KDTEditEvent e) {
			}});
    	
    	//棚舍信息
		KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$name$");
        kdtEntrys_material_PromptBox.setEditFormat("$name$");
        kdtEntrys_material_PromptBox.setCommitFormat("$name$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtDetail.getColumn("house").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("house").setRenderer(kdtEntrys_material_OVR);
        
        this.kdtDetail_detailPanel.getAddNewLineButton().setEnabled(true);
        this.kdtDetail_detailPanel.getInsertLineButton().setEnabled(true);
        this.kdtDetail_detailPanel.getRemoveLinesButton().setEnabled(true);
        
        this.kdtDetail.getStyleAttributes().setLocked(true);
        
        mergeCols=new String[]{"stockingBatch","farmer","farm","house","proportion","amount","matureDate","matureDate","matureAmount","lastLock","allLastLock"};
    	
        
        this.kdtEntrys.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent arg0) {
//				setMerge();
			}});
        
    	setFilter();
    }
    /**
     * 设置单元格融合
     */
    private void setMerge() {
    	String batchID,houseID,batchKeepID=null,houseKeepID=null;
    	int rowIndexKeep=0;
    	for(int rowIndex=0;rowIndex<kdtDetail.getRowCount();rowIndex++) {
    		batchID=((IPropertyContainer) kdtDetail.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
    		houseID=null;
    		if(kdtDetail.getCell(rowIndex, "house").getValue()!=null) {
    			houseID=((IPropertyContainer) kdtDetail.getCell(rowIndex, "house").getValue()).getString("id");
    		}
    		if(rowIndex==0) {
    			batchKeepID=batchID;
    			houseKeepID=houseID;
    			rowIndexKeep=rowIndex;
    		}else{
    			if(!batchID.equals(batchKeepID)||(batchID.equals(batchKeepID)&&houseID!=null&&!houseID.equals(houseKeepID))) {
    				for(String col:mergeCols) {
    					kdtDetail.getMergeManager().mergeBlock(rowIndexKeep,kdtDetail.getColumnIndex(col), rowIndex, kdtDetail.getColumnIndex(col));
    				}
    				batchKeepID=batchID;
        			houseKeepID=houseID;
        			rowIndexKeep=rowIndex;
    			}
    		}
    	}
    }
    
    
    private void farmer_changed() {
    	if(prmtfarmer.getValue()==null) {
    		prmtfarm.setValue(null);
    	}else{
    		StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
    	}
    }
    
    /**
     * 检查
     * @throws Exception 
     */
    private void checkFiled() throws Exception {
    	if(allocationType.getSelectedItem().equals(AllocationTypeEnum.byFarmer)) {
			if(prmtfarmer.getValue()==null) {
				MsgBox.showWarning("养殖户不能为空！");
				SysUtil.abort();
			}
		}else if(allocationType.getSelectedItem().equals(AllocationTypeEnum.byFarm)) {
			if(prmtfarmer.getValue()==null) {
				MsgBox.showWarning("养殖户不能为空！");
				SysUtil.abort();
			}
			if(prmtfarm.getValue()==null) {
				MsgBox.showWarning("养殖场不能为空！");
				SysUtil.abort();
			}
		}else if(allocationType.getSelectedItem().equals(AllocationTypeEnum.byFarmerGroup)) {
			if(prmtfarmerGroup.getValue()==null) {
				MsgBox.showWarning("养殖户类别不能为空！");
				SysUtil.abort();
			}
		}else if(allocationType.getSelectedItem().equals(AllocationTypeEnum.byFarmGroup)) {
			if(prmtfarmGroup.getValue()==null) {
				MsgBox.showWarning("养殖场类别不能为空！");
				SysUtil.abort();
			}
		}
    	if(this.kdtEntrys.getRowCount()<=0) {
    		MsgBox.showWarning("费用项目分录不能为空！");
			SysUtil.abort();
    	}
    	super.beforeStoreFields(null);
    	
    	DayRateBaseSettingInfo bdInfo = DayrateUtils.getBaseSetting(null, curCompanyID);
    	PeriodInfo nextPeriod = PeriodUtils.getNextPeriodInfo(bdInfo.getCurrentPeriod());
    	if(!PeriodUtils.PeriodCompare((PeriodInfo) this.prmtperiod.getValue(),nextPeriod)) {
    		if(MsgBox.showConfirm2("当前期间为"+bdInfo.getCurrentPeriod().getNumber()+",是否做该期间之前的单据?")!=MsgBox.YES) {
    			SysUtil.abort();
    		}
    	}
    }
    

    private void setFilter() {
    	if(prmtcompany.getValue()==null) {
    		curCompanyID="";
    	}else{
    		curCompanyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
    	}
    	StockingClientComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
    	String farmerID=null;
    	if(prmtfarmer.getValue()!=null) {
    		farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
    	}
    	StockingClientComm.setFarmFilter(prmtfarm, curCompanyID, farmerID);
    	
    	EntityViewInfo ev=new EntityViewInfo();
    	FilterInfo filter=new FilterInfo();
    	filter.getFilterItems().add(new FilterItemInfo("CU.id",curCompanyID,CompareType.EQUALS));
		ev.setFilter(filter);
		prmtfarmerGroup.setEntityViewInfo(ev);
		
		feeItemFilter();
    }
    
    private void feeItemFilter() {
    	final KDBizPromptBox kdtEntrys_feeItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_feeItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.dayratecost.app.DayrateFeeItemQuery");
        kdtEntrys_feeItem_PromptBox.setVisible(true);
        kdtEntrys_feeItem_PromptBox.setEditable(true);
        kdtEntrys_feeItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_feeItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_feeItem_PromptBox.setCommitFormat("$number$;$name$");
        KDTDefaultCellEditor kdtEntrys_feeItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_feeItem_PromptBox);
        this.kdtEntrys.getColumn("feeItem").setEditor(kdtEntrys_feeItem_CellEditor);
        ObjectValueRender kdtEntrys_feeItem_OVR = new ObjectValueRender();
        kdtEntrys_feeItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("feeItem").setRenderer(kdtEntrys_feeItem_OVR);
        			kdtEntrys_feeItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.dayratecost.client.DayrateFeeItemListUI kdtEntrys_feeItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_feeItem_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_feeItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.dayratecost.client.DayrateFeeItemListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								if(StringUtils.isEmpty(curCompanyID)) {
									return true;
								}
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								if(StringUtils.isEmpty(curCompanyID)) {
									return true;
								}
								return false;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_feeItem_PromptBox_F7ListUI));
					kdtEntrys_feeItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_feeItem_PromptBox.setSelector(kdtEntrys_feeItem_PromptBox_F7ListUI);
				}
			}
		});
    }
    

    
	/**
	 * 设置字段隐藏
	 */
	private void setFiledHided() {
		if(allocationType.getSelectedItem().equals(AllocationTypeEnum.byFarmer)) {
			contfarmer.setVisible(true);
			contfarm.setVisible(false);
			contfarmerGroup.setVisible(false);
			contfarmGroup.setVisible(false);
			
			if(!isLoadField) {
				prmtfarm.setValue(null);
				prmtfarmerGroup.setValue(null);
				prmtfarmGroup.setValue(null);
			}
			
		}else if(allocationType.getSelectedItem().equals(AllocationTypeEnum.byFarm)) {
			contfarmer.setVisible(true);
			contfarm.setVisible(true);
			contfarmerGroup.setVisible(false);
			contfarmGroup.setVisible(false);
			
			if(!isLoadField) {
				prmtfarmer.setValue(null);
				prmtfarmerGroup.setValue(null);
				prmtfarmGroup.setValue(null);
			}
		}else if(allocationType.getSelectedItem().equals(AllocationTypeEnum.byFarmerGroup)) {
			contfarmer.setVisible(false);
			contfarm.setVisible(false);
			contfarmerGroup.setVisible(true);
			contfarmGroup.setVisible(false);
			
			if(!isLoadField) {
				prmtfarmer.setValue(null);
				prmtfarm.setValue(null);
				prmtfarmGroup.setValue(null);
			}
		}else if(allocationType.getSelectedItem().equals(AllocationTypeEnum.byFarmGroup)) {
			contfarmer.setVisible(false);
			contfarm.setVisible(false);
			contfarmerGroup.setVisible(false);
			contfarmGroup.setVisible(true);
			
			if(!isLoadField) {
				prmtfarmer.setValue(null);
				prmtfarmerGroup.setValue(null);
				prmtfarm.setValue(null);
			}
		}
	}

	@Override
	protected void afterSelectLine(KDTable table, IObjectValue lineData) {
		// TODO Auto-generated method stub
		super.afterSelectLine(table, lineData);
		setMerge();
	}

	@Override
	protected void setTableToSumField() {
		// TODO Auto-generated method stub
		setTableToSumField(kdtDetail,new String[]{"proportion2","alloctionAmount"});
	}

	@Override
	protected void setTableToSumField(KDTable table, String[] columnFields) {
		// TODO Auto-generated method stub
		super.setTableToSumField(table, columnFields);
	}
	
	
	
}