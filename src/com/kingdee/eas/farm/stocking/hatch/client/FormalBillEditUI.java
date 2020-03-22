/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryCollection;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BreedPlanBillEntryInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FormalBillEditUI extends AbstractFormalBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FormalBillEditUI.class);
    private String curCompanyID;//当前财务组织
    
    /**
     * output class constructor
     */
    public FormalBillEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    public void loadFields()
    {
    	
    	super.loadFields(); 
    	
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
        return com.kingdee.eas.farm.stocking.hatch.FormalBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.stocking.hatch.FormalBillInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.FormalBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        BreedPlanBillEntryInfo entryInfo=new BreedPlanBillEntryInfo();
        entryInfo.setBreedDate(new Date());
        return objectValue;
    }
    @Override
	public void onLoad() throws Exception {
    	curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
//		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
//		f7Manager = new F7ContextManager(this, OrgType.Storage);
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
				setFilter();
			}});
		
		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				bizDate_changed();
			}});
		
		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
			}});
		
		KDBizPromptBox kdtEntrys_material_PromptBox1 = new KDBizPromptBox();
        kdtEntrys_material_PromptBox1.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEntrys_material_PromptBox1.setVisible(true);
        kdtEntrys_material_PromptBox1.setEditable(true);
        kdtEntrys_material_PromptBox1.setDisplayFormat("$name$");
        kdtEntrys_material_PromptBox1.setEditFormat("$name$");
        kdtEntrys_material_PromptBox1.setCommitFormat("$name$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor1 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox1);
        ObjectValueRender kdtEntrys_material_OVR1 = new ObjectValueRender();
        kdtEntrys_material_OVR1.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor1);  
        this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR1);
		
	}
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		//根据合同和批次带出养殖户和农场
		if(kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")) {
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				kdtEntrys.getCell(rowIndex, "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farmer"));
				kdtEntrys.getCell(rowIndex, "farm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farm"));
			
			}
		}
		//根据养殖户带出养殖场
		if(kdtEntrys.getColumnKey(colIndex).equals("farmer")) {
			String farmerID=null;
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null) {
				farmerID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, colIndex).getValue()).getString("id");
			}
			kdtEntrys.getCell(rowIndex, "farm").setValue(StockingComm.getFarmInfoByFarmerID(null,farmerID));
		}
		calEntryWeekAndDayAge(rowIndex, colIndex);
	}
	
	private void bizDate_changed() {
		int colIndex=kdtEntrys.getColumnIndex("stockingBatch");
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			try {
				calEntryWeekAndDayAge(rowIndex, colIndex);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	/**
	 * 计算周龄、日龄
	 * @param rowIndex
	 * @throws BOSException 
	 * @throws DataAccessException 
	 * @throws EASBizException 
	 */
	private void calEntryWeekAndDayAge(int rowIndex,int colIndex) throws DataAccessException, BOSException, EASBizException {
		//计算周龄、日龄
		if(kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("stockingBatch")||kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("applyDate")) {
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {//&&kdtEntrys.getCell(rowIndex, "applyDate").getValue()!=null
				Date nowDate=null,inDate=null;
				if(kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {//禽舍不为空
					StockingBatchHouseEntryCollection houseE = (StockingBatchHouseEntryCollection) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(),"HouseEntry");

					for(int index=0;index<houseE.size();index++) {
						if(houseE.get(index).getHouse().getString("id").equals(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id"))) {
							inDate=houseE.get(index).getInData();
							break;
						}
					}
					//申请周龄
					if(kdtEntrys.getCell(rowIndex, "applyDate").getValue()!=null) {
						nowDate=(Date) kdtEntrys.getCell(rowIndex, "applyDate").getValue();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "applyWeekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "applyDayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "applyWeekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "applyDayAge").setValue(0);
					}
					//当前周龄
					if(pkBizDate.getValue()!=null) {
						nowDate=pkBizDate.getTimestamp();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "nowWeekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "nowDayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "nowWeekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "nowDayAge").setValue(0);
					}
				}else{
					inDate=(Date) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "inDate");
					//当前周龄
					if(pkBizDate.getValue()!=null) {
						nowDate=pkBizDate.getTimestamp();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "nowWeekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "nowDayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "nowWeekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "nowDayAge").setValue(0);
					}
					//申请周龄
					if(kdtEntrys.getCell(rowIndex, "applyDate").getValue()!=null) {
						nowDate=(Date) kdtEntrys.getCell(rowIndex, "applyDate").getValue();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "applyWeekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "applyDayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "applyWeekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "applyDayAge").setValue(0);
					}
					
					
				}
			}
			}
	}
	
	
	/**
	 * 开始编辑
	 * @param e
	 */
	private void kdteditStarted(KDTEditEvent e) {
		int rowIndex=e.getRowIndex();
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtEntrys.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")||key.equals("house")) {
//			KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id");
			}
			StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID,houseID);
			//养殖场过滤
			StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
			//棚舍过滤
			HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,false);
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		}
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
	}	
	
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()==null) {
				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，放养养殖批次不能为空！");
				SysUtil.abort();
			}
			if(kdtEntrys.getCell(rowIndex, "farm").getValue()!=null&&(Boolean)UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "farm").getValue(), "isHouseManager")&&kdtEntrys.getCell(rowIndex, "house").getValue()==null) {
				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，养殖场启用棚舍管理，棚舍不能为空！");
				SysUtil.abort();
			}
		}
	}
}