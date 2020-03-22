/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EventListener;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedAreaInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.ParentBreedBatchFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.breed.parentFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class ParentBreedBatchEditUI extends AbstractParentBreedBatchEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ParentBreedBatchEditUI.class);
    
    // 当前养殖场
    private BreedStoorgSetInfo currFarm;

    /**
     * output class constructor
     */
    public ParentBreedBatchEditUI() throws Exception
    {
    	
        super();
        
        // 当前 养殖场
		StorageOrgUnitInfo currStoorg = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStoorg == null){
			MsgBox.showInfo("当前未在任何库存组织");
			SysUtil.abort();
		}
		currFarm = parentFacadeFactory.getRemoteInstance().getFarmByStoOrgID(currStoorg.getId().toString());
		if(currStoorg == null){
			MsgBox.showInfo("当前未在任何养殖场，请先切换到对应养殖场后再做相关操作");
			SysUtil.abort();
		}
        // 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
        // 图标设置
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		this.prmtbabyCostObject.setDisplayFormat("$name$");	
		this.prmtyoungCostObject.setDisplayFormat("$name$");	
//		this.prmtadultCostObject.setDisplayFormat("$name$");	
		this.prmteggCostObject.setDisplayFormat("$name$");
		
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
//        filter.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.CC.getValue(),CompareType.EQUALS));
        CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
        filter.getFilterItems().add(new FilterItemInfo("CU.id",cuInfo.getId().toString(),CompareType.EQUALS));
        // 设置默认当前库存组织所有鸡舍信息
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filter.getFilterItems().add(new FilterItemInfo("stoOrg.id",currStorageOrgInfo.getId().toString(),CompareType.EQUALS));
        evi.setFilter(filter);
        
        
        
        SorterItemCollection sorter = new SorterItemCollection();
        SorterItemInfo sortItem = new SorterItemInfo("bizDate");
        sortItem.setSortType(SortType.DESCEND);
        sorter.add(sortItem);
        evi.setSorter(sorter);
        this.prmtbreedPlan.setQueryInfo("com.kingdee.eas.farm.breed.business.app.F7CCBreedPlanQuery");
        this.prmtbreedPlan.setEntityViewInfo(evi);
        
//        this.henhouseType.removeItem(HenhouseType.Brood);
//        this.henhouseType.removeItem(HenhouseType.CC);
//        this.henhouseType.setSelectedItem(HenhouseType.LayEgg);
    }
   
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
		vo.put("houseType","2");
        vo.put("farm", currFarm);
        vo.put("week", 1);
        vo.put("weekDay", 1);
       
        
    }  
   
    /**
     * 审核
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("不能审核未提交的单据");
			SysUtil.abort();
		}
		try{
			if(MsgBox.showConfirm2("请确认是否当前批次已完全入栏，如果没有完全入栏请保存养殖批次状态为提交状态，否则后续养殖批次将不可修改,确认审核？") == MsgBox.YES){
				super.actionAudit_actionPerformed(e);
				MsgBox.showWarning("审核完成");
				reloadData();
			}
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	/**
     * 重载单据内容
     * @throws Exception 
     * @throws BOSException 
     * @throws EASBizException 
     */
	private void reloadData() throws EASBizException, BOSException, Exception{
		
		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();
			
			
		
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("只能反审核处于审核状态的批次");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	/**
	 * 提交前校验
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			
			
			try{
				this.txtweek.commitEdit();
				this.txtweekDay.commitEdit();
				// 校验周龄和日龄不能 小于1
				int week = this.txtweek.getIntegerValue();
				int day = this.txtweekDay.getIntegerValue();
				if(week < 1){
					MsgBox.showWarning("周龄不能小于1 ");
					SysUtil.abort();
				}else if(week > 100){
					MsgBox.showWarning("周龄不能大于100 ");
					SysUtil.abort();
				}else if(!(day >= 0 && day <8)){
					MsgBox.showWarning("日龄只能处于0到7之间 ");
					SysUtil.abort();
				}else if(week > 1 && day == 0){
					MsgBox.showWarning("只有在第一周允许日龄为0 ");
					SysUtil.abort();
				}
			
				//
				
				
				super.actionSubmit_actionPerformed(e);
				
			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}
			
			
		}else{
			MsgBox.showWarning("只能提交未审核的批次");
			SysUtil.abort();
		}
	}
	/**
	 * 初始化
	 */
	@Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		
		this.kdtEntrys.getSelectManager().setSelectMode(1);
		
		initComp();
		// 设置鸡舍类别
		setHenhouseType();
		// 设置过滤条件
		setHenhouseFilter();
		
		// 设置区过滤条件
		setAreaFilter(currFarm.getId().toString());
		
		 // 设置 转栏分录  不可增删改 bianji
        this.kdtTransEntrys_detailPanel.getAddNewLineButton().setVisible(false);
        this.kdtTransEntrys_detailPanel.getInsertLineButton().setVisible(false);
        this.kdtTransEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
        this.kdtTransEntrys.setEditable(false);
        this.kdtTransEntrys.setEnabled(false);
        
		if("ADDNEW".equals(this.getOprtState())){
			this.baseStatus.setSelectedIndex(1);
		}
		
		
		 kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
				public void editStopped(KDTEditEvent e) {
					try {
						kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
					}
					catch (Exception exc) {
						handUIException(exc);
					}
				}
			});
		 
		 kdtFieldDetailEntrys.addKDTEditListener(new KDTEditAdapter() {
				public void editStopped(KDTEditEvent e) {
					try {
						kdtFieldDetailEntrys_Changed(e.getRowIndex(),e.getColIndex());
					}
					catch (Exception exc) {
						handUIException(exc);
					}
				}
			});
		 
		 
		 
		
	}
	
	
	/**
	 * 根据鸡舍类别设置可见性
	 */
	private void setHenhouseType(){
		
			
//		this.kdtEntrys.getColumn("incoopDate").getStyleAttributes().setHided(true);
//		
//		
//		this.kdtEntrys.getColumn("initQty").getStyleAttributes().setHided(true);
//		
//		this.kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(false);
//		this.kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(false);
//		this.kdtEntrys.getColumn("henFixedQty").getStyleAttributes().setHided(false);
//		this.kdtEntrys.getColumn("cockFixedQty").getStyleAttributes().setHided(false);
//		
	}
	
	
	/**
     * 设置鸡舍过滤条件
     */
	private void setHenhouseFilter(){
		
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
       
        StorageOrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filter.getFilterItems().add(new FilterItemInfo("stoOrg.id",cuInfo.getId().toString(),CompareType.EQUALS));
		BreedAreaInfo currArea = (BreedAreaInfo) this.prmtbreedArea.getValue();
		if(currArea != null){
			filter.getFilterItems().add(new FilterItemInfo("breedArea.id",currArea.getId().toString(),CompareType.EQUALS));
		}
        
        evi.setFilter(filter);
		final KDBizPromptBox kdtEntrys_henHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henHouse_PromptBox.setVisible(true);
        kdtEntrys_henHouse_PromptBox.setEditable(true);
        kdtEntrys_henHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setEntityViewInfo(evi);
        KDTDefaultCellEditor kdtEntrys_henHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouse_PromptBox);
        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henHouse_CellEditor);
        ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
        kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henhouse").setRenderer(kdtEntrys_henHouse_OVR);
			
			
	       
		
	}

    /**
     * copy时设置默认值
     */
	protected void setFieldsNull(AbstractObjectValue newData) {
		super.setFieldsNull(newData);
		// 设置状态默认新增
		newData.put("baseStatus", BillBaseStatusEnum.ADD);
	}
	//add by simple_dai 20150426
	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		
		if(StringUtils.isBlank(this.txtweek.getText())||StringUtils.isBlank(this.txtweekDay.getText())) {
			MsgBox.showError("周龄或日龄不能为空！");
			SysUtil.abort();
		}
		
	}
	
	
    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
	
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
    	
	    if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));
	    	HenhouseInfo currHenhouse = (HenhouseInfo) kdtEntrys.getCell(rowIndex,"henhouse").getValue();
	    	if(currHenhouse != null){
		    	String henhouseID = currHenhouse.getId().toString();
		    	// 设置明细分录的  栏位过滤条件
		    	setFieldFilter(henhouseID);
	    	}else{
	    		setFieldFilter("");
	    	}
	    }
	    // 计算 养殖密度 
	    if ("cockInitQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()) || "henInitQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()) || "henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	HenhouseInfo currHenhouseInfo = (HenhouseInfo) kdtEntrys.getCell(rowIndex,"henhouse").getValue();
	    	int initQty = (Integer) kdtEntrys.getCell(rowIndex,"henInitQty").getValue();
	    	int initCockQty = (Integer) kdtEntrys.getCell(rowIndex,"cockInitQty").getValue();
	    	
	    	BigDecimal currDensity = new BigDecimal("0");
	    	if(currHenhouseInfo != null){
	    		currHenhouseInfo = HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(currHenhouseInfo.getId()));
	    		BigDecimal area = currHenhouseInfo.getArea();
	    		if(area != null && area.compareTo(new BigDecimal("0")) != 0){
	    			BigDecimal initQtyBD = new BigDecimal(initQty+initCockQty);
	    			currDensity = initQtyBD.divide(area,2,RoundingMode.HALF_UP);
	    		}
	    	}
	    	// 设置库存
	    	kdtEntrys.getCell(rowIndex,"stockingDensity").setValue(currDensity);
	    }
    }
    /**
     * 栏位明细 更新时自动 更新对应 上级分录   数量  
     */
    public void kdtFieldDetailEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
    	int henQtyAll = 0;
    	int cockQtyAll = 0;
    	
    	// 入栏明细 合计
    	for(int i = 0; i < this.kdtFieldDetailEntrys.getRowCount(); i++){
    		int henQty = (Integer) this.kdtFieldDetailEntrys.getCell(i, "henInitQty").getValue();
    		int cockQty = (Integer) this.kdtFieldDetailEntrys.getCell(i, "cockInitQty").getValue();
    		
    		henQtyAll = henQtyAll + henQty;
    		cockQtyAll = cockQtyAll + cockQty;
    	}
    	
    	
//	    // 计算 养殖密度
//	    if ("henInitQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()) || "henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
//	    	HenhouseInfo currHenhouseInfo = (HenhouseInfo) kdtEntrys.getCell(rowIndex,"henhouse").getValue();
//	    	int initQty = (Integer) kdtEntrys.getCell(rowIndex,"henInitQty").getValue();
//	    	BigDecimal currDensity = new BigDecimal("0");
//	    	if(currHenhouseInfo != null){
//	    		currHenhouseInfo = HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(currHenhouseInfo.getId()));
//	    		BigDecimal area = currHenhouseInfo.getArea();
//	    		if(area != null && area.compareTo(new BigDecimal("0")) != 0){
//	    			BigDecimal initQtyBD = new BigDecimal(initQty);
//	    			currDensity = initQtyBD.divide(area,2,RoundingMode.HALF_UP);
//	    		}
//	    	}
//	    	// 设置库存
//	    	kdtEntrys.getCell(rowIndex,"stockingDensity").setValue(currDensity);
//	    }
    }
    /**
     * 养殖计划发生变化时 更新分录，如果分录不为空 则不做任何操作
     */
	@Override
	protected void prmtbreedPlan_dataChanged(DataChangeEvent e)
			throws Exception {
//		
//		if(this.kdtEntrys.getRowCount() > 0){
//			return ;
//		}else{
//			CCBreedPlanInfo planInfo = (CCBreedPlanInfo) this.prmtbreedPlan.getValue();
//			if(planInfo != null){
//				CCBreedPlanEntryCollection planEntryCol = planInfo.getEntrys();
//				ICCBreedPlanEntry breedPlanEntry = CCBreedPlanEntryFactory.getRemoteInstance();
//				for(int i = 0; i < planEntryCol.size(); i++){
//					CCBreedPlanEntryInfo entryInfo = planEntryCol.get(i);
//					entryInfo = breedPlanEntry.getCCBreedPlanEntryInfo(new ObjectUuidPK(entryInfo.getId()));
//					
//					IRow newRow = this.kdtEntrys.addRow();
//					HenhouseInfo houseInfo = entryInfo.getHenHouse();
//					newRow.getCell("henhouse").setValue(HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(houseInfo.getId())));
//					newRow.getCell("henhouseName").setValue(entryInfo.getHenhouseName());
//					newRow.getCell("incoopDate").setValue(entryInfo.getIncoopDate());
//					newRow.getCell("initQty").setValue(entryInfo.getInitQty());
//					
//					newRow.getCell("chikenType").setValue(ChikenType.CommecialChiken);
//					
//					
//				}
//			}
//		}
	}
	
	/**
	 * 校验非空
	 */
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		super.beforeStoreFields(arg0);
		
			
	}
    /**
     * output loadFields method
     * @throws BOSException 
     * @throws EASBizException 
     */
    public void loadFields() 
    {
        super.loadFields();
        try{
        // 加载完 数据后，重新设置  专栏分录 中 的批次信息
        for(int i = 0; i < this.kdtTransEntrys.getRowCount(); i++){
        	IRow row = this.kdtTransEntrys.getRow(i);
        	if(row != null){
        		ParentBreedBatchInfo fromBatch = (ParentBreedBatchInfo) row.getCell("fromBatch").getValue();
        		if(fromBatch != null){
        			fromBatch = ParentBreedBatchFactory.getRemoteInstance().getParentBreedBatchInfo(new ObjectUuidPK(fromBatch.getId()));
        			row.getCell("fromBatch").setValue(fromBatch);
        		}
        		
        		ParentBreedBatchInfo toBatch = (ParentBreedBatchInfo) row.getCell("toBatch").getValue();
        		if(toBatch != null){
        			toBatch = ParentBreedBatchFactory.getRemoteInstance().getParentBreedBatchInfo(new ObjectUuidPK(toBatch.getId()));
        			row.getCell("toBatch").setValue(toBatch);
        		}
        	}
        }
        }catch(EASBizException bize){
        	bize.printStackTrace();
        	this.handleException(bize);
        }catch(BOSException bose){
        	bose.printStackTrace();
        	this.handleException(bose);
        }
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
        return com.kingdee.eas.farm.breed.ParentBreedBatchFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.breed.ParentBreedBatchInfo objectValue = new com.kingdee.eas.farm.breed.ParentBreedBatchInfo();
        UserInfo currUser = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo();
        objectValue.setCreator(currUser);
		PersonInfo currPerson = currUser.getPerson();
		if(currPerson != null){
			objectValue.setPerson(currPerson);
			
		}
//        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setFarm(currFarm);
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        objectValue.setWeek(1);
        objectValue.setWeekDay(1);
        
        objectValue.setHenhouseType(HenhouseType.LayEgg);
//        objectValue.setStoOrg(SysContext.getSysContext().getCurrentStorageUnit());
        return objectValue;
    }
   
	/**
	 * 初始化界面 组件
	 */
    private void initComp(){
    	
    	// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
			
		this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
		this.prmtbreedArea.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedAreaQuery");
		this.prmtbreedModel.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedModelF7Query");
		
		
//		this.prmtbreedPlan.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
//		this.prmtadultCostObject.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
//		this.prmtbabyCostObject.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
//		this.prmtyoungCostObject.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
		
		
    }

    /**
     * 养殖场 变化 后 更新 区过滤条件
     */
	@Override
	protected void prmtfarm_dataChanged(DataChangeEvent e) throws Exception {
		
		currFarm = (BreedStoorgSetInfo) this.prmtfarm.getValue();
		String farmID = "";
		if(currFarm != null){
			farmID = currFarm.getId().toString();
		}
		this.prmtbreedArea.setValue(null);
		// 设置区过滤条件
		setAreaFilter(farmID);
	}
    /**
     * 设置 禽舍过滤条件
     */
    protected void prmtbreedArea_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    	
    	
    	this.kdtEntrys.removeRows();
    	setHenhouseFilter();
    }
	/**
	 * 设置 区 过滤条件
	 */
	private void setAreaFilter(String farmID){
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
       
        
        filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
		
        evi.setFilter(filter);
		this.prmtbreedArea.setEntityViewInfo(evi);
	}
	
	
	
	/**
	 * 根据选中的 分录行 设置 栏位明细的 过滤条件  废弃 
	 */
	@Override
	protected void kdtEntrys_tableSelectChanged(KDTSelectEvent e)
			throws Exception {
		
	}

	/**
	 * 设置栏位过滤条件
	 * @param farmID
	 */
	private void setFieldFilter(String henhouseID){
		if(henhouseID == null) henhouseID = "";
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
       
        
        filter.getFilterItems().add(new FilterItemInfo("henhouse.id",henhouseID,CompareType.EQUALS));
		
        evi.setFilter(filter);
		final KDBizPromptBox kdtEntrys_henHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7HouseFieldQuery");
        kdtEntrys_henHouse_PromptBox.setVisible(true);
        kdtEntrys_henHouse_PromptBox.setEditable(true);
        kdtEntrys_henHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setEntityViewInfo(evi);
        KDTDefaultCellEditor kdtEntrys_henHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouse_PromptBox);
        this.kdtFieldDetailEntrys.getColumn("housefield").setEditor(kdtEntrys_henHouse_CellEditor);
        ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
        kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFieldDetailEntrys.getColumn("housefield").setRenderer(kdtEntrys_henHouse_OVR);
	}

	@Override
	protected void kdtEntrys_activeCellChanged(KDTActiveCellEvent e)
			throws Exception {
		int rowIndex = e.getRowIndex();
		String focusHenhouseID = "";
//		this.txtDescription.setText("Active:"+Integer.toString(rowIndex));
		IRow focusRow = this.kdtEntrys.getRow(rowIndex);
		if(focusRow != null){
			ICell henhouseCell = this.kdtEntrys.getCell(rowIndex, "henhouse");
			if(henhouseCell != null){
				HenhouseInfo henhouse = (HenhouseInfo) henhouseCell.getValue();
				if(henhouse != null){
					focusHenhouseID = henhouse.getId().toString();
				}
			}
		}
		
		setFieldFilter(focusHenhouseID);
//		MsgBox.showInfo("Active:"+Integer.toString(rowIndex));
	}

	/**
	 * 废弃 active才是 每次正常触发
	 */
	@Override
	protected void kdtEntrys_tableClicked(KDTMouseEvent e) throws Exception {
		int rowIndex = e.getRowIndex();
//		this.txtDescription.setText("Click:"+Integer.toString(rowIndex));
//		MsgBox.showInfo("Click"+Integer.toString(rowIndex));
	}
	
	
	
	 /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
        sic.add(new SelectorItemInfo("isMoultingBatch"));
        sic.add(new SelectorItemInfo("isToBreed"));
        sic.add(new SelectorItemInfo("isToLayegg"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.incoopDate"));
    	sic.add(new SelectorItemInfo("entrys.stockingDensity"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henhouse.id"));
			sic.add(new SelectorItemInfo("entrys.henhouse.name"));
        	sic.add(new SelectorItemInfo("entrys.henhouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.henInitQty"));
    	sic.add(new SelectorItemInfo("entrys.cockInitQty"));
    	sic.add(new SelectorItemInfo("entrys.henhouseName"));
    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.id"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.housefield.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.housefield.id"));
			sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.housefield.name"));
        	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.housefield.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.henInitQty"));
    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.cockInitQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("TransEntrys.isFromOtherBatch"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.fromBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.fromBatch.id"));
			sic.add(new SelectorItemInfo("TransEntrys.fromBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.id"));
			sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.id"));
			sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntrys.transDate"));
    	sic.add(new SelectorItemInfo("TransEntrys.transWeeks"));
    	sic.add(new SelectorItemInfo("TransEntrys.transWeekDays"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.outHousefield.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.outHousefield.id"));
			sic.add(new SelectorItemInfo("TransEntrys.outHousefield.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.outHousefield.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.inHousefield.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.inHousefield.id"));
			sic.add(new SelectorItemInfo("TransEntrys.inHousefield.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.inHousefield.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntrys.isBuy"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.supplier.id"));
			sic.add(new SelectorItemInfo("TransEntrys.supplier.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.supplier.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntrys.isTransOut"));
    	sic.add(new SelectorItemInfo("TransEntrys.asTransEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.toBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.toBatch.id"));
			sic.add(new SelectorItemInfo("TransEntrys.toBatch.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntrys.transHenQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.transCockQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.henAsFixedQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.cockAsFixedQty"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedPlan.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedPlan.id"));
        	sic.add(new SelectorItemInfo("breedPlan.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("babyCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("babyCostObject.id"));
        	sic.add(new SelectorItemInfo("babyCostObject.number"));
        	sic.add(new SelectorItemInfo("babyCostObject.name"));
        	sic.add(new SelectorItemInfo("babyCostObject.relatedName"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("youngCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("youngCostObject.id"));
        	sic.add(new SelectorItemInfo("youngCostObject.number"));
        	sic.add(new SelectorItemInfo("youngCostObject.name"));
        	sic.add(new SelectorItemInfo("youngCostObject.relatedName"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("eggCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggCostObject.id"));
        	sic.add(new SelectorItemInfo("eggCostObject.number"));
        	sic.add(new SelectorItemInfo("eggCostObject.name"));
        	sic.add(new SelectorItemInfo("eggCostObject.relatedName"));
		}
        sic.add(new SelectorItemInfo("youngDate"));
        sic.add(new SelectorItemInfo("adultDate"));
        sic.add(new SelectorItemInfo("initDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedArea.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedArea.id"));
        	sic.add(new SelectorItemInfo("breedArea.number"));
        	sic.add(new SelectorItemInfo("breedArea.areaName"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedModel.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedModel.id"));
        	sic.add(new SelectorItemInfo("breedModel.number"));
        	sic.add(new SelectorItemInfo("breedModel.name"));
		}
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("weekDay"));
        sic.add(new SelectorItemInfo("henhouseType"));
        return sic;
    }   
	
	
}