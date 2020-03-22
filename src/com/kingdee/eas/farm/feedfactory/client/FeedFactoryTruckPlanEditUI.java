/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.swing.KDTimePicker;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo;
import com.kingdee.eas.farm.feedfactory.FeedTruckFactory;
import com.kingdee.eas.farm.feedfactory.FeedTruckInfo;
import com.kingdee.eas.farm.feedfactory.TruckPlanFacadeFactory;
import com.kingdee.eas.farm.feedfactory.TruckType;
import com.kingdee.eas.farm.feedfactory.beans.DischargeDotInfo;
import com.kingdee.eas.farm.feedfactory.beans.DistanceAndTimesInfo;
import com.kingdee.eas.farm.feedfactory.beans.FF_CONSTANTS;
import com.kingdee.eas.farm.feedfactory.beans.FodderPlanDetail;
import com.kingdee.eas.farm.feedfactory.beans.TruckExecuteInfo;
import com.kingdee.eas.farm.feedfactory.beans.TruckPlanDetail;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.DateCommon;

/**
 * output class name
 */
public class FeedFactoryTruckPlanEditUI extends AbstractFeedFactoryTruckPlanEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FeedFactoryTruckPlanEditUI.class);
    
    // 饲料厂 送料信息基本资料
    private FeedFactoryBaseDataInfo baseDataInfo ;
    // id为 towerID
    private LinkedHashMap<String,FodderPlanDetail> fordderPlanMap;
    // id 为车号
    private LinkedHashMap<String,TruckExecuteInfo> truckExecuteInfoMap;
    // 距离时间Map
    Map<String,DistanceAndTimesInfo> distanceTimesMap;
    
    // 各种暂存数据map  Key  ID   value  info
    private Map<String,MaterialInfo> materialMap;
    private Map<String,StorageOrgUnitInfo> farmMap;
    private Map<String,WarehouseInfo> towerMap;
    private Map<String,FeedTruckInfo> truckMap;
    private Map<String,PersonInfo> driveMap;
    
    
    
    
    /**
     * output class constructor
     */
    public FeedFactoryTruckPlanEditUI() throws Exception
    {
      
    	super();
        // 获得 默认的饲料厂设置
		baseDataInfo = TruckPlanFacadeFactory.getRemoteInstance().getFeedFactoryBaseData();
		driveMap = new HashMap<String, PersonInfo>();
		
		if(baseDataInfo == null){
			MsgBox.showInfo("未取到饲料厂基础设置，请联系管理员确认是否已经设置好基础信息");
			SysUtil.abort();
		}
		
        kdtAssEntrys.addKDTEditListener(new KDTEditAdapter() {
//        	// 如果是在修改 车辆  则根据车辆类型进行过滤
//        	public void editStarting(KDTEditEvent e)
//    	    {
//        		setTruckFilter(e);
//    	    }
//        	
    		public void editStopped(KDTEditEvent e) {
    			try {
    				 
    				kdtAssEntrys_Changed(e,e.getRowIndex(),e.getColIndex());
    			}
    			catch (Exception exc) {
    				handUIException(exc);
    			}
    		}

		
    	});    
		
		
    }
    
    
    
    /**
     * 更新 将要编辑行的  车辆过滤条件
     * @param e
     */
    public void setTruckFilter(IRow row){
    	
		StorageOrgUnitInfo farm = (StorageOrgUnitInfo) row.getCell("farm").getValue();
		if(farm != null && farm.getName() != null){
			String farmName = farm.getName();
			EntityViewInfo evi = new EntityViewInfo();
			FilterInfo fi = new FilterInfo();
			// 育成显示绿色
			
			if(farmName.indexOf("育成") >= 0 ){
				fi.getFilterItems().add(new FilterItemInfo("truckType",TruckType.ParentCK.getValue(),CompareType.EQUALS));
				row.getStyleAttributes().setBackground(Color.green);
				
			}else if (farmName.indexOf("产蛋") >= 0){
				fi.getFilterItems().add(new FilterItemInfo("truckType",TruckType.ParentCK.getValue(),CompareType.EQUALS));
				row.getStyleAttributes().setBackground(Color.PINK);
			}else{
				fi.getFilterItems().add(new FilterItemInfo("truckType",TruckType.CCTruck.getValue(),CompareType.EQUALS));
			}
			
			evi.setFilter(fi);
			
			final KDBizPromptBox kdtEntrys_truck_PromptBox = new KDBizPromptBox();
	        kdtEntrys_truck_PromptBox.setQueryInfo("com.kingdee.eas.farm.feedfactory.app.FeedTruckQuery");
	        kdtEntrys_truck_PromptBox.setVisible(true);
	        kdtEntrys_truck_PromptBox.setEditable(true);
	        kdtEntrys_truck_PromptBox.setDisplayFormat("$number$");
	        kdtEntrys_truck_PromptBox.setEditFormat("$number$");
	        kdtEntrys_truck_PromptBox.setCommitFormat("$number$");
//	        kdtEntrys_truck_PromptBox.setEntityViewInfo(evi);
	        KDTDefaultCellEditor kdtEntrys_truck_CellEditor = new KDTDefaultCellEditor(kdtEntrys_truck_PromptBox);
	        row.getCell("truck").setEditor(kdtEntrys_truck_CellEditor);
	        ObjectValueRender kdtEntrys_truck_OVR = new ObjectValueRender();
	        kdtEntrys_truck_OVR.setFormat(new BizDataFormat("$number$"));
	        row.getCell("truck").setRenderer(kdtEntrys_truck_OVR);
			
		}
    	
    }
    
    /**
     * 初始化界面控件状态
     */
    public void initUIComponentsStates(){
    	// 分录都不能新增删除
    	kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    	kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
    	kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	kdtEntrys_detailPanel.setTitle("派车计划明细");
    	
    	this.btnAddLine.setVisible(false);
    	this.btnInsertLine.setVisible(false);
    	this.btnRemoveLine.setVisible(false);
    	
    	this.actionInsertLine.setVisible(false);
    	this.actionAddLine.setVisible(false);
    	this.actionRemoveLine.setVisible(false);
    	
    	kdtAssEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    	kdtAssEntrys_detailPanel.getInsertLineButton().setVisible(false);
    	kdtAssEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	kdtAssEntrys_detailPanel.setTitle("要料计划明细");
    	
    	kdtTruckEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    	kdtTruckEntrys_detailPanel.getInsertLineButton().setVisible(false);
    	kdtTruckEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	kdtTruckEntrys_detailPanel.setTitle("当天车辆出车计划");
    	this.kdtEntrys.getStyleAttributes().setLocked(true);
    	this.kdtEntrys.setEditable(false);
    	
    	this.kdtTruckEntrys.getStyleAttributes().setLocked(true);
    	this.kdtTruckEntrys.setEditable(false);
    	
    	this.kdtAssEntrys.getColumn("farm").getStyleAttributes().setLocked(true);
    	this.kdtAssEntrys.getColumn("tower").getStyleAttributes().setLocked(true);
    	this.kdtAssEntrys.getColumn("inventory").getStyleAttributes().setLocked(true);
    	this.kdtAssEntrys.getColumn("material").getStyleAttributes().setLocked(true);
    	this.kdtAssEntrys.getColumn("fodderQty").getStyleAttributes().setLocked(true);
    	this.kdtAssEntrys.getColumn("farmDesc").getStyleAttributes().setLocked(true);
    	
    }
    /**
     * 界面打开是加载相关数据
     */
    @Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 设置时间控件显示到分钟
		setTimeformat();
		
		if(this.getOprtState().equals("ADDNEW") && baseDataInfo != null){
			this.beginTime.setValue(baseDataInfo.getStartLoadTime());
			this.lunchBeginTime.setValue(baseDataInfo.getLunchBeginTime());
			this.lunchEndTime.setValue(baseDataInfo.getLunchEndTime());
			
			
		}
		// 更新背景颜色
		updateAddtEntryBackGroud();
		
		// 设置 按钮可见性
		// 界面控件状态
        initUIComponentsStates();
        
        
        
        EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();
//		if(farmName.indexOf("育成") >= 0 || farmName.indexOf("产蛋") >= 0){
//			fi.getFilterItems().add(new FilterItemInfo("truckType",TruckType.ParentCK.getValue(),CompareType.EQUALS));
//			
//		}else{
//			fi.getFilterItems().add(new FilterItemInfo("truckType",TruckType.CCTruck.getValue(),CompareType.EQUALS));
//		}
		fi.getFilterItems().add(new FilterItemInfo("truckType",TruckType.ParentCK.getValue(),CompareType.EQUALS));
		evi.setFilter(fi);
		
		final KDBizPromptBox kdtEntrys_truck_PromptBox = new KDBizPromptBox();
        kdtEntrys_truck_PromptBox.setQueryInfo("com.kingdee.eas.farm.feedfactory.app.FeedTruckQuery");
        kdtEntrys_truck_PromptBox.setVisible(true);
        kdtEntrys_truck_PromptBox.setEditable(true);
        kdtEntrys_truck_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_truck_PromptBox.setEditFormat("$number$");
        kdtEntrys_truck_PromptBox.setCommitFormat("$number$");
//        kdtEntrys_truck_PromptBox.setEntityViewInfo(evi);
        KDTDefaultCellEditor kdtEntrys_truck_CellEditor = new KDTDefaultCellEditor(kdtEntrys_truck_PromptBox);
        this.kdtAssEntrys.getColumn("truck").setEditor(kdtEntrys_truck_CellEditor);
        ObjectValueRender kdtEntrys_truck_OVR = new ObjectValueRender();
        kdtEntrys_truck_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAssEntrys.getColumn("truck").setRenderer(kdtEntrys_truck_OVR);
	}

    /**
     * 设置界面内 空间的可见性  可操作性等属性
     */
    private void setBtnState(){
    	BillBaseStatusEnum nowStatus = (BillBaseStatusEnum) this.baseStatus.getSelectedItem();
    	if("VIEW".equals(this.getOprtState())  || 
    			(!BillBaseStatusEnum.ADD.equals(nowStatus) && 
    					!BillBaseStatusEnum.TEMPORARILYSAVED.equals(nowStatus) && 
    					!BillBaseStatusEnum.SUBMITED.equals(nowStatus)) ){
    		this.btnUp.setEnabled(false);
    		this.btnDown.setEnabled(false);
    		this.btnSplit.setEnabled(false);
    		this.btnGetPlan.setEnabled(false);
    		this.btnGeneteTruckPlan.setEnabled(false);
    	}else {
    		this.btnUp.setEnabled(true);
    		this.btnDown.setEnabled(true);
    		this.btnSplit.setEnabled(true);
    		this.btnGetPlan.setEnabled(true);
    		this.btnGeneteTruckPlan.setEnabled(true);
    	}
    	
    }
    /**
     * 更新要料计划背景颜色
     */
    private void updateAddtEntryBackGroud() {
		for(int i = 0 ; i < this.kdtAssEntrys.getRowCount(); i++){
			
		}
		
	}

	/**
     * 设置界面 时间显示格式
     * 
     */
    private void setTimeformat(){
    	String timePattern = "HH:mm";
    	String tablePattern = "HH:mm:ss";
    	beginTime.setTimePattern(timePattern);
    	lunchBeginTime.setTimePattern(timePattern);
    	lunchEndTime.setTimePattern(timePattern);
    	
    	 KDTimePicker kdtEntrys_beginLoadTime_TimePicker = new KDTimePicker();
         kdtEntrys_beginLoadTime_TimePicker.setName("kdtEntrys_beginLoadTime_TimePicker");
         kdtEntrys_beginLoadTime_TimePicker.setTimePattern(timePattern);
         this.kdtEntrys.getColumn("beginLoadTime").getStyleAttributes().setNumberFormat(tablePattern);
         kdtEntrys_beginLoadTime_TimePicker.setVisible(true);
         KDTDefaultCellEditor kdtEntrys_beginLoadTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_beginLoadTime_TimePicker);
         this.kdtEntrys.getColumn("beginLoadTime").setEditor(kdtEntrys_beginLoadTime_CellEditor);
//         this.kdtEntrys.getColumn("beginLoadTime").setRenderer(arg0)
         
    	 KDTimePicker kdtEntrys_leaveFFTime_TimePicker = new KDTimePicker();
         kdtEntrys_leaveFFTime_TimePicker.setName("kdtEntrys_leaveFFTime_TimePicker");
         kdtEntrys_leaveFFTime_TimePicker.setTimePattern(timePattern);
         kdtEntrys_leaveFFTime_TimePicker.setVisible(true);
         KDTDefaultCellEditor kdtEntrys_leaveFFTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveFFTime_TimePicker);
         this.kdtEntrys.getColumn("leaveFFTime").setEditor(kdtEntrys_leaveFFTime_CellEditor);
         this.kdtEntrys.getColumn("leaveFFTime").getStyleAttributes().setNumberFormat(tablePattern);
         
         KDTimePicker kdtEntrys_truckArriveTime_TimePicker = new KDTimePicker();
         kdtEntrys_truckArriveTime_TimePicker.setName("kdtEntrys_truckArriveTime_TimePicker");
         kdtEntrys_truckArriveTime_TimePicker.setTimePattern(timePattern);
         kdtEntrys_truckArriveTime_TimePicker.setVisible(true);
         KDTDefaultCellEditor kdtEntrys_truckArriveTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_truckArriveTime_TimePicker);
         this.kdtEntrys.getColumn("truckArriveTime").setEditor(kdtEntrys_truckArriveTime_CellEditor);
         this.kdtEntrys.getColumn("truckArriveTime").getStyleAttributes().setNumberFormat(tablePattern);
         KDTimePicker kdtEntrys_leaveFarmTime_TimePicker = new KDTimePicker();
         kdtEntrys_leaveFarmTime_TimePicker.setName("kdtEntrys_leaveFarmTime_TimePicker");
         kdtEntrys_leaveFarmTime_TimePicker.setTimePattern(timePattern);
         kdtEntrys_leaveFarmTime_TimePicker.setVisible(true);
         KDTDefaultCellEditor kdtEntrys_leaveFarmTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveFarmTime_TimePicker);
         this.kdtEntrys.getColumn("leaveFarmTime").setEditor(kdtEntrys_leaveFarmTime_CellEditor);
         this.kdtEntrys.getColumn("leaveFarmTime").getStyleAttributes().setNumberFormat(tablePattern);
         KDTimePicker kdtEntrys_backToFFTime_TimePicker = new KDTimePicker();
         kdtEntrys_backToFFTime_TimePicker.setName("kdtEntrys_backToFFTime_TimePicker");
         kdtEntrys_backToFFTime_TimePicker.setTimePattern(timePattern);
         kdtEntrys_backToFFTime_TimePicker.setVisible(true);
         KDTDefaultCellEditor kdtEntrys_backToFFTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_backToFFTime_TimePicker);
         this.kdtEntrys.getColumn("backToFFTime").setEditor(kdtEntrys_backToFFTime_CellEditor);
         this.kdtEntrys.getColumn("backToFFTime").getStyleAttributes().setNumberFormat(tablePattern);
//    	this.kdtAssEntrys.getColumn("").getEditor().get
    	
    }

	/**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        // 设置界面控件状态
        setBtnState();
        
        setTruckFilter();
    }

    /**
     * 加载数据后设置过滤条件
     */
    private void setTruckFilter() {
		// TODO Auto-generated method stub
    	for(int i = 0 ; i < this.kdtAssEntrys.getRowCount(); i++){
			IRow row  = this.kdtAssEntrys.getRow(i);
			this.setTruckFilter(row);
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
        return com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanFactory.getRemoteInstance();
    }

    /**
     * 编辑事件
     */
    @Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
    	super.actionEdit_actionPerformed(e);
    	// 设置界面控件状态
        setBtnState();
    }
    
    @Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{
				
				super.actionSubmit_actionPerformed(e);
				// 设置界面控件状态
		        setBtnState();
			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}
			
			
		}else{
			MsgBox.showWarning("只能提交未审核的单据");
			SysUtil.abort();
		}
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
			super.actionAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();
			// 设置界面控件状态
	        setBtnState();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
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
			MsgBox.showWarning("反审核完成");
			reloadData();
			// 设置界面控件状态
	        setBtnState();
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
        com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo objectValue = new com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
		Date bizDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(bizDate);
		cal.add(Calendar.DATE, 1);
		objectValue.setBizDate(cal.getTime());
        return objectValue;
    }
    
    /**
     * 要料计划 分录修改时相关处理
     * @param rowIndex
     * @param colIndex
     * @throws BOSException 
     * @throws EASBizException 
     */
	private void kdtAssEntrys_Changed(KDTEditEvent e,int rowIndex, int colIndex) throws EASBizException, BOSException {
		
		 if ("truck".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
			 
			 int truckCount = 1;
			 FeedTruckInfo currTruckInfo = (FeedTruckInfo) kdtAssEntrys.getCell(rowIndex,"truck").getValue();
			 if(currTruckInfo != null){
				 currTruckInfo = FeedTruckFactory.getRemoteInstance().getFeedTruckInfo(new ObjectUuidPK(currTruckInfo.getId()));
				 
				 BigDecimal potWeight = currTruckInfo.getPotWeight();
				 if(potWeight == null){
					 potWeight = BigDecimal.ZERO;
				 }
				 int potCount = currTruckInfo.getPotCount();
				 // 最大载重量
				 BigDecimal weightBility = potWeight.multiply(new BigDecimal(potCount));
				 
				 BigDecimal uplimit = currTruckInfo.getUplimit();
				 if(uplimit == null || uplimit.compareTo(BigDecimal.ONE) <=0 ){
					 uplimit = BigDecimal.ONE;
				 }
				 
				 BigDecimal upWeightBility = weightBility.multiply(uplimit);
				 // 需求量
				 BigDecimal fodderPlan = (BigDecimal) kdtAssEntrys.getCell(rowIndex,"fodderQty").getValue();
				 // 派车数
				 BigDecimal truckCountBD = fodderPlan.divide(upWeightBility, 0, RoundingMode.HALF_UP);
				 
				 truckCount = truckCountBD.intValue();
			 }
			  
			 
			 
			 
			 
			 kdtAssEntrys.getCell(rowIndex,"truckCount").setValue(truckCount);
			 
			 
			 // 如果之前同一场 有
			 
		 }
		 // 合并行 列 数据校验
		 if("mergeTrunckNum".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
			  
			 
			 String oldValue = (String) e.getOldValue();
			 String newValue = (String) e.getValue();
			 
			 
			
				try{
					if(newValue != null){
						BigDecimal mergeBD = new BigDecimal(newValue);
						int mergeTruckNum  = mergeBD.intValue();
						
						
						if(mergeTruckNum <= 0 || mergeTruckNum > rowIndex){
							MsgBox.showInfo("【合并行号】只能是 小于当前编辑行行号的 正整数");
							kdtAssEntrys.getCell(rowIndex, colIndex).setValue(oldValue);
	//						kdtAssEntrys.getCell(rowIndex, colIndex)
							
							
							SysUtil.abort();
						}
						
						kdtAssEntrys.getCell(rowIndex,colIndex).setValue(Integer.toString(mergeTruckNum));
					}
				}catch(NumberFormatException nfe){
					MsgBox.showInfo("合并行列 输入的行号不合法，请重新输入");
					kdtAssEntrys.getCell(rowIndex, colIndex).setValue(oldValue);
//					kdtAssEntrys.getCell(rowIndex, colIndex)
					
					
					SysUtil.abort();
				}
				
		 }
	}
    /**
     * 结果派车结果列表设置
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
    	super.kdtEntrys_Changed(rowIndex, colIndex);
    	
    	// 
    }
    /**
     * 根据业务日期获得要料计划 
     */
	@Override
	public void actionGetFodderPlan_actionPerformed(ActionEvent e)
			throws Exception {
		
		Date bizDate = this.pkBizDate.getSqlDate();
		if(bizDate == null){
			MsgBox.showInfo("请先选择业务日期，系统将根据选择的业务日期获得当天的要料计划");
			SysUtil.abort();
		}else{
			if(kdtAssEntrys.getRowCount() > 0){
				if(MsgBox.showConfirm2("清除要料计划列表，重新获取？") != MsgBox.OK){
					return;
				}
			}
			List<FodderPlanDetail> planDetails = TruckPlanFacadeFactory.getRemoteInstance().getFodderPlandetails(bizDate);
			// 清楚历史记录
			kdtAssEntrys.removeRows();
			// 当天存在要料计划 则全部显示在 待处理列表中
			if(planDetails != null && planDetails.size() > 0){
				for(int i = 0; i < planDetails.size(); i++ ){
					FodderPlanDetail detail = planDetails.get(i);
					
					IRow newRow = this.kdtAssEntrys.addRow();
					StorageOrgUnitInfo farmInfo = new StorageOrgUnitInfo();
					farmInfo.setId(BOSUuid.read(detail.getFarmID()));
					farmInfo.setName(detail.getFarmName());
					farmInfo.setNumber(detail.getFarmNumber());
//					farmInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(farmInfo.getId()));
					newRow.getCell("farm").setValue(farmInfo);
					WarehouseInfo tower = new WarehouseInfo();
					tower.setId(BOSUuid.read(detail.getTowerID()));
					tower.setName(detail.getTowerName());
					tower.setNumber(detail.getTowerNumber());
					newRow.getCell("tower").setValue(tower);
//					FeedTruckInfo truck = new FeedTruckInfo();
					
					MaterialInfo materialInfo = new MaterialInfo();
					materialInfo.setId(BOSUuid.read(detail.getMaterialID()));
					materialInfo.setNumber(detail.getMaterialNumber());
					materialInfo.setName(detail.getMaterialName());
					materialInfo.setModel(detail.getMaterialModel());
					newRow.getCell("material").setValue(materialInfo);
					
					newRow.getCell("inventory").setValue(detail.getInventory());
					
					newRow.getCell("fodderQty").setValue(detail.getQty());
					
					newRow.getCell("farmDesc").setValue(detail.getFarmDesc());
					
					newRow.getCell("isIgnore").setValue(Boolean.FALSE);
					
						
					// 设置 车辆过滤条件
					setTruckFilter(newRow);	
						
						
					
						
					// 育成显示绿色
					if("2YC".equals(detail.getFarmType())){
						newRow.getStyleAttributes().setBackground(Color.green);
					}else if("3CD".equals(detail.getFarmType())){
						newRow.getStyleAttributes().setBackground(Color.PINK);
					}
				}
			}else{
				MsgBox.showInfo("该业务日期没有查询到要料计划明细信息");
				SysUtil.abort();
			}
		}
	}
	
	/**
	 * 上移功能
	 * 将选中行上移一行
	 */
	@Override
	protected void btnUp_actionPerformed(ActionEvent e) throws Exception {
		IRow curRow = this.getSelectedRow();
		
		
		if(curRow != null && curRow.getRowIndex() > 0){
			// 上移一行
			IRow newRow = (IRow)curRow.clone();
			this.kdtAssEntrys.addRow(curRow.getRowIndex()-1, newRow);
			
			this.kdtAssEntrys.removeRow(curRow.getRowIndex()+1);
			
			if(curRow.getRowIndex() > 0){
				kdtAssEntrys.getSelectManager().select(curRow.getRowIndex()-1, 1,curRow.getRowIndex()-1, kdtAssEntrys.getColumnCount());
			}
//			newRow.getStyleAttributes().
//			curRow.
		}
	}

	/**
	 * 下移功能
	 */
	@Override
	protected void btnDown_actionPerformed(ActionEvent e) throws Exception {
		IRow curRow = this.getSelectedRow();
		if(curRow != null && curRow.getRowIndex() < kdtAssEntrys.getRowCount()-1){
			// 上移一行
			IRow newRow = (IRow)curRow.clone();
			this.kdtAssEntrys.addRow(curRow.getRowIndex()+2, newRow);
			this.kdtAssEntrys.removeRow(curRow.getRowIndex());
			
			if(curRow.getRowIndex() < kdtAssEntrys.getRowCount()-1){
				kdtAssEntrys.getSelectManager().select(curRow.getRowIndex()+1, 1,curRow.getRowIndex()+1, kdtAssEntrys.getColumnCount());
			}
//			curRow.
		}
	}

	/**
	 * 拆分功能
	 */
	@Override
	protected void btnSplit_actionPerformed(ActionEvent e) throws Exception {
		IRow curRow = this.getSelectedRow();
		if(curRow != null){
			// 新增一行 均分 需求量
//			IRow newRow = (IRow)curRow.clone();
			IRow newRow = this.kdtAssEntrys.addRow(curRow.getRowIndex()+1);
			
			BigDecimal fodderPlanQty = (BigDecimal) curRow.getCell("fodderQty").getValue();
			if(fodderPlanQty == null){
				fodderPlanQty = BigDecimal.ZERO;
			}
			BigDecimal splitQty = fodderPlanQty.divide(new BigDecimal(2), 2, RoundingMode.HALF_UP); //.divide(new BigDecimal(2),2,
			
			FeedTruckInfo truckInfo = (FeedTruckInfo) curRow.getCell("truck").getValue();
			
			BigDecimal truckMaxWeight = BigDecimal.ZERO;
			if(truckInfo != null){
				BigDecimal maxWeight = truckInfo.getPotWeight();
				int potCount = truckInfo.getPotCount();
				if(maxWeight != null && maxWeight.compareTo(BigDecimal.ZERO) > 0 && potCount > 0){
					truckMaxWeight = maxWeight.multiply(new BigDecimal(potCount));
				}else{
					MsgBox.showInfo("请先维护拆分行对应的饲料车单罐载重和 罐数");
					this.kdtAssEntrys.removeRow(curRow.getRowIndex()+1);
					SysUtil.abort();
				}
				// 设置需求车数
				BigDecimal newTruckCount = splitQty.divide(truckMaxWeight, 0, RoundingMode.UP) ;
				Integer truckCountNum = newTruckCount.intValue();
				newRow.getCell("truckCount").setValue(truckCountNum);
				curRow.getCell("truckCount").setValue(truckCountNum);
			}
			
			
			newRow.getCell("fodderQty").setValue(splitQty);
			curRow.getCell("fodderQty").setValue(splitQty);
			// 复制当前选中行 其他信息
			newRow.getCell("farm").setValue(curRow.getCell("farm").getValue());
			newRow.getCell("tower").setValue(curRow.getCell("tower").getValue());
			newRow.getCell("inventory").setValue(curRow.getCell("inventory").getValue());
			newRow.getCell("material").setValue(curRow.getCell("material").getValue());
			newRow.getCell("truck").setValue(curRow.getCell("truck").getValue());
			newRow.getCell("mergeTrunckNum").setValue(curRow.getCell("mergeTrunckNum").getValue());
			newRow.getCell("farmDesc").setValue(curRow.getCell("farmDesc").getValue());
			newRow.getCell("fodderPort").setValue(curRow.getCell("fodderPort").getValue());
			
			this.storeFields();
//			curRow.
		}
	}
	
	/**
	 * 
	 * @param fodderPlanQty
	 * @param truckInfo
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public int needTruckCount(BigDecimal fodderPlanQty,FeedTruckInfo truckInfo) throws EASBizException, BOSException{
		if(truckInfo == null){
			MsgBox.showInfo("计算所需车次时不能传入null");
			SysUtil.abort();
			
		}
		if(truckInfo.getPotWeight() == null){
			truckInfo = FeedTruckFactory.getRemoteInstance().getFeedTruckInfo(new ObjectUuidPK(truckInfo.getId()));
		}
		
		
		// 获取饲料车相关设置
		BigDecimal maxWeight = truckInfo.getPotWeight();
		int potCount = truckInfo.getPotCount();
		
		BigDecimal truckMaxWeight = BigDecimal.ZERO;
		if(truckInfo.getUplimit() != null &&  maxWeight != null && maxWeight.compareTo(BigDecimal.ZERO) > 0 && potCount > 0){
			truckMaxWeight = maxWeight.multiply(new BigDecimal(potCount));
			// 计算超频范围   默认超频能力1.3
			truckMaxWeight = truckMaxWeight.multiply(truckInfo.getUplimit());
			
			BigDecimal truckCount = fodderPlanQty.divide(truckMaxWeight, 0, RoundingMode.UP);
			
			return truckCount.intValue();
			
		}else{
			MsgBox.showInfo("请先维护拆分行对应的饲料车单罐载重、 罐数、超频上限");
			SysUtil.abort();
		}
		
		return 0;
	}
	/**
	 * 获取选中行
	 * @return
	 */
	private IRow getSelectedRow(){
		if(this.kdtAssEntrys.getSelectManager().get() != null){
			int beginRowNum = this.kdtAssEntrys.getSelectManager().get().getBeginRow();
			int endRowNum = this.kdtAssEntrys.getSelectManager().get().getEndRow();
			
			if(beginRowNum != endRowNum){
				MsgBox.showInfo("该操作只支持单行操作，请勿多选");
				SysUtil.abort();
			}else{
				return this.kdtAssEntrys.getRow(beginRowNum);
			}
		}else{
			MsgBox.showInfo("请选中待操作行");
			SysUtil.abort();
		}
		
		return null;
	}
	
	/**
	 * 生成派车 计划
	 */
	@Override
	public void actionGenerateTruckPlan_actionPerformed(ActionEvent e)
			throws Exception {
//		if(baseDataInfo == null){
			
//		}
		baseDataInfo = TruckPlanFacadeFactory.getRemoteInstance().getFeedFactoryBaseData();
		distanceTimesMap = TruckPlanFacadeFactory.getRemoteInstance().getDistanseSetinfo();
		// 料塔信息
		int dotNum = baseDataInfo.getMaxEntruckCount();
		if(dotNum <= 0){
			MsgBox.showInfo("请在饲料场基础信息中先维护后可用的打料口数量");
			SysUtil.abort();
		}
		
		// 料口列表
		List<DischargeDotInfo> dotInfos =  new ArrayList<DischargeDotInfo>();
		for(int i = 0; i < dotNum; i++){
			DischargeDotInfo dotInfo = new DischargeDotInfo();
			dotInfo.setNum(i+1);
			
			dotInfo.setEntruckingOverTime(baseDataInfo.getStartLoadTime());
			dotInfos.add(dotInfo);
			
		}
		
		
		
		// 整理完需要处理的detailinfos同时更新掉料口占用时间
		truckExecuteInfoMap = getfodderDetails(dotInfos);
		// 第一轮送料 按理论时间 计算 无需考虑回到饲料厂后的等待打料时间
		Set<String> keySet = truckExecuteInfoMap.keySet();
		Iterator<String> keyIte = keySet.iterator();
		// 已预装车次
		Integer preN = this.txtprepackedTruckCount.getIntegerValue();
		if(preN == null){
			preN = 0;
		}
		// 累计已预装车数
		int hasPreLoadCount = 0;
		while(keyIte.hasNext()){
			String key = keyIte.next();
			// 计算一次送料时间
			TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(key);
			// 大于已预装的车次  计算打料时间
			if((++hasPreLoadCount)>preN){
				generateSendPlan(exeInfo,false,dotInfos);
			}else{
				generateSendPlan(exeInfo,true,dotInfos);
			}
		}
		
		// 从第二轮开始 考虑等待时间 逐车送料 直到所有计划全部送完为止
		boolean exeEnd = false;
		while(!exeEnd){
			// 逐车进行计算TODO
			// 获取所有车中第一个回到饲料厂的车
			String latestKey = "";
			Time latestTime = null;
			Set<String> tobePlanSet = truckExecuteInfoMap.keySet();
			Iterator<String> whilekey = tobePlanSet.iterator();
			while(whilekey.hasNext()){
				String key = whilekey.next();
				
				// 计算一次送料时间
				TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(key);
				// 还有未送完的 计划
				if(exeInfo.getToBeSolveTask().size() > 0){
				
					Time keyTime = exeInfo.getCurrTime();
					if(latestTime != null){
						if(latestTime.after(keyTime)){
							latestTime = keyTime;
							latestKey = key;
						}
					}else{
						latestTime = keyTime;
						latestKey = key;
					}
				}
			}
			if(StringUtils.isNotBlank(latestKey)){
				// 派出一车
				generateSendPlan(truckExecuteInfoMap.get(latestKey),false,dotInfos);
			}
			// 所有车的计划列表均为空则派车计划已完成 跳出 while
			int unPlanCount= 0;
			Set<String> newkeySet = truckExecuteInfoMap.keySet();
			Iterator<String> endKeySet = newkeySet.iterator();
			while(endKeySet.hasNext()){
				String key = endKeySet.next();
				// 计算一次送料时间
				TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(key);
				
				unPlanCount = unPlanCount+ exeInfo.getToBeSolveTask().size();
				System.out.println("还有"+unPlanCount+"个计划尚未完成");
			}
			
			if(unPlanCount == 0){
				exeEnd = true;
			}else{
				unPlanCount = 0;
			}
		}
		
		
		// 全部派完后 展示到 结果列表中
		this.kdtEntrys.removeRows();
		
		// 默认按照 计划顺序排列，勾选按车次后 则按照车次排序
		if(this.chkorderByTruck.isSelected()){
			Iterator<String> resultKeyIte = keySet.iterator();
			while(resultKeyIte.hasNext()){
				// 计算一次送料时间
				TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(resultKeyIte.next());
				
				List<TruckPlanDetail> truckPlanDetails = exeInfo.getTruckPlans();
				for(int i =0; i < truckPlanDetails.size(); i++){
					IRow newPlanDetailRow = this.kdtEntrys.addRow();
					// 显示派车明细到分录中
					showTruckPlanDetails(newPlanDetailRow,truckPlanDetails.get(i));
				}
			}
		}else{
			List<TruckPlanDetail> allTruckPlans = new ArrayList<TruckPlanDetail>();
			Iterator<String> resultKeyIte = keySet.iterator();
			while(resultKeyIte.hasNext()){
				// 计算一次送料时间
				TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(resultKeyIte.next());
				
				List<TruckPlanDetail> truckPlanDetails = exeInfo.getTruckPlans();
				allTruckPlans.addAll(truckPlanDetails);
			}
			// 按照要料计划排序
			for(int i = 0; i < this.kdtAssEntrys.getRowCount(); i++){
				for(int j = 0; j < allTruckPlans.size(); j++){
					TruckPlanDetail planDetail = allTruckPlans.get(j);
					
					FodderPlanDetail fodderPlan = planDetail.getFodderPlanDetail();
					if(fodderPlan.getRowNum() == (i+1)){
						IRow newPlanDetailRow = this.kdtEntrys.addRow();
						// 显示派车明细到分录中
						showTruckPlanDetails(newPlanDetailRow,planDetail);
						break;
					}
				}
			}
		}
	    
		
		// 显示车辆 执行情况
		Iterator<String> truckKeyIte = keySet.iterator();
		this.kdtTruckEntrys.removeRows();
		while(truckKeyIte.hasNext()){
			// 
			TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(truckKeyIte.next());
			
			IRow truckRow = this.kdtTruckEntrys.addRow();
			FeedTruckInfo truckInfo = new FeedTruckInfo();
			truckInfo.setId(BOSUuid.read(exeInfo.getTruckID()));
			truckInfo.setNumber(exeInfo.getTruckNumber());
			truckInfo.setName(exeInfo.getTruckName());
			truckRow.getCell("truck").setValue(truckInfo);
			
			truckRow.getCell("allCount").setValue(exeInfo.getTruckPlans().size());
			truckRow.getCell("lunchPlace").setValue(exeInfo.getLunchPlace());
			truckRow.getCell("beginTime").setValue(exeInfo.getBeginTime());
			truckRow.getCell("endTime").setValue(exeInfo.getCurrTime());
		}
		
		
	}
	
	/**
	 * 按照特定方式 显示派车结果
	 * 
	 * 
	 * @param orderType 1、按照车辆出发顺序 2、按照要料顺序
	 */
	private void showResult(int orderType){
		
	}
	/**
	 * 将派车计划明细显示到 分录中显示
	 * @param newRow
	 * @param planDetails
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void showTruckPlanDetails(IRow newRow, TruckPlanDetail planDetail) throws EASBizException, BOSException{
		if(newRow !=null && planDetail != null){
			StorageOrgUnitInfo farmInfo = new StorageOrgUnitInfo();
			farmInfo.setId(BOSUuid.read(planDetail.getFodderPlanDetail().getFarmID()));
			farmInfo.setName(planDetail.getFodderPlanDetail().getFarmName());
			farmInfo.setNumber(planDetail.getFodderPlanDetail().getFarmNumber());
			farmInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(farmInfo.getId()));
			newRow.getCell("farm").setValue(farmInfo);
			
			WarehouseInfo tower = new WarehouseInfo();
			tower.setId(BOSUuid.read(planDetail.getFodderPlanDetail().getTowerID()));
			tower.setName(planDetail.getFodderPlanDetail().getTowerName());
			tower.setNumber(planDetail.getFodderPlanDetail().getTowerNumber());
			newRow.getCell("tower").setValue(tower);
			
			FeedTruckInfo truck = new FeedTruckInfo();
			truck.setId(BOSUuid.read(planDetail.getFodderPlanDetail().getTruckID()));
			truck.setName(planDetail.getFodderPlanDetail().getTruckName());
			truck.setNumber(planDetail.getFodderPlanDetail().getTruckNumber());
			newRow.getCell("truck").setValue(truck);
			
			newRow.getCell("drive").setValue(planDetail.getFodderPlanDetail().getDriveName());
			newRow.getCell("tel").setValue(planDetail.getFodderPlanDetail().getDriveTel());
			
			newRow.getCell("beginLoadTime").setValue(planDetail.getBeginLoadingTime());
			newRow.getCell("leaveFFTime").setValue(planDetail.getLeaveFFTime());
			
			newRow.getCell("truckArriveTime").setValue(planDetail.getArriveTime());
			
			newRow.getCell("leaveFarmTime").setValue(planDetail.getLeaveFarmTime());
			
			newRow.getCell("backToFFTime").setValue(planDetail.getBatckToFFTime());
			
			newRow.getCell("haveLunch").setValue(planDetail.isHaveLunch());
			
			newRow.getCell("lunchPlace").setValue(planDetail.getLunchPlace());
			
			newRow.getCell("planSeq").setValue(planDetail.getPlanSeq());
			
			newRow.getCell("truckSeq").setValue(planDetail.getTruckSeq());
			
			newRow.getCell("farmDesc").setValue(planDetail.getFarmDesc());
			
			newRow.getCell("fodderPort").setValue(planDetail.getFodderPort());
			
			newRow.getCell("materialID").setValue(planDetail.getMaterialID());
			
			newRow.getCell("materialName").setValue(planDetail.getMaterialName());
			
//			FeedFactoryTruckPlanAssEntryInfo assEntry = new FeedFactoryTruckPlanAssEntryInfo();
//			assEntry.setFarm(farmInfo);
//			assEntry.setTruck(truck);
//			assEntry.setTower(tower);
//			MaterialInfo materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(planDetail.getFodderPlanDetail().getMaterialID()));
//			assEntry.setMaterial(materialInfo);
//			assEntry
//			assEntry.set
//			newRow.setUserObject(assEntry);
			
		}
	}
	
	/**
	 * 生成一次的派车计划信息 ；从打料开始算 算到 回到饲料厂为止
	 * @param executeInfoMap
	 * @param hasPreLoaded 当前车辆已经预装  无需考虑 装车时间
	 * @param dotInfos 打料口信息，每次打料 更新打料口 使用时间
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void generateSendPlan(TruckExecuteInfo executeInfo,boolean haPreLoaded,List<DischargeDotInfo> dotInfos) throws BOSException, EASBizException{
		// 具体时间Map
//		if(distanceTimesMap == null){
			
//		}
		if(distanceTimesMap == null || distanceTimesMap.size() == 0){
			MsgBox.showInfo("未取到各场的路程时间设置");
			SysUtil.abort();
		}
		// 如果还有未 处理的送料计划 则 进行处理，然后 将处理完成的 计划移除
		if(executeInfo.getToBeSolveTask().size() > 0){
			
			// 派车计划明细
			TruckPlanDetail newDetail = new TruckPlanDetail();
			// 记录之前是否已经吃午饭
			boolean nowHasLunch = executeInfo.isHasLunched();
			// 开始打料时间
			Time beginTime = executeInfo.getCurrTime();
			// 计算吃饭时间
			beginTime = addLunchTimes(executeInfo, beginTime);
			
			
			
			// 打料完成时间
			Time loadEndTime = beginTime;
			if(!haPreLoaded){
				// 计算等待时间
				beginTime = getBeginLoadTime(beginTime,dotInfos);
				// 未预装的车次  计算打料时间
				loadEndTime = DateCommon.addMinutes(beginTime, baseDataInfo.getLoadingTimes());
				
			}
			// 计算吃饭时间
			loadEndTime = addLunchTimes(executeInfo, loadEndTime);
			// 如果出车时间为空 则设置 当前装完料时间    既 第一次离开饲料厂时间为出车时间
			if(executeInfo.getBeginTime() == null){
				executeInfo.setBeginTime(loadEndTime);
			}
			
			if(!nowHasLunch && executeInfo.isHasLunched()){
				newDetail.setHaveLunch(true);
				newDetail.setLunchPlace("饲料厂");
				executeInfo.setLunchPlace("饲料厂");
			}
			
			Iterator<FodderPlanDetail> fodderPlanIte = executeInfo.getToBeSolveTask().iterator();
//			FodderPlanDetail planDetail = executeInfo.getToBeSolveTask().get(0);
			FodderPlanDetail planDetail = fodderPlanIte.next();
			executeInfo.getToBeSolveTask().remove(planDetail);
			
			// 次序
			newDetail.setPlanSeq(planDetail.getRowNum());
			
			String farmID = planDetail.getFarmID();
			
			DistanceAndTimesInfo dtInfo = distanceTimesMap.get(FF_CONSTANTS.FF_KEY+farmID);
			if(dtInfo == null){
				StorageOrgUnitInfo farmInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(farmID));
				MsgBox.showInfo("饲料厂到【"+farmInfo.getName()+"】间车程基本信息未设置，请联系管理员进行设置后再重新派车");
				SysUtil.abort();
			}
			// 车程时间
			int sendTimes = dtInfo.getMinutes();
			// 到达养殖场时间
			Time sendArriveTime = DateCommon.addMinutes(loadEndTime,sendTimes);
			// 是否已经吃午饭
			boolean hasLunchInFF = executeInfo.isHasLunched();
			// 是否吃午饭
			sendArriveTime = addLunchTimes(executeInfo, sendArriveTime);
			
			FeedTruckInfo truckInfo = executeInfo.getTruckInfo();
			
			int unloadTimes = truckInfo.getUnloadTimes();
			// 卸料完成时间
			Time unloadTime = DateCommon.addMinutes(sendArriveTime, unloadTimes);
			// 离开养殖场场时间
			Time leaveFarmTime = addLunchTimes(executeInfo, unloadTime);
			
			newDetail.setFodderPlanDetail(planDetail);
			
			// 来之前没吃 现在吃了 则记录
			if(!hasLunchInFF && executeInfo.isHasLunched()){
				newDetail.setHaveLunch(true);
				newDetail.setLunchPlace("养殖场");
				executeInfo.setLunchPlace(newDetail.getFodderPlanDetail().getFarmName());
			}
			
	
			
			newDetail.setFarmDesc(planDetail.getFarmDesc());
			newDetail.setFodderPort(planDetail.getFodderPort());
//			newDetail.setLeaveFarmTime(leaveFarmTime);
			newDetail.setBeginLoadingTime(beginTime);
			
			newDetail.setLeaveFFTime(loadEndTime);
			
			newDetail.setArriveTime(sendArriveTime);
			newDetail.setLeaveFarmTime(leaveFarmTime);
			
			// 返回饲料场时间根据是否有 一车两场情况，有的话第一车不设置返回饲料场时间，第二车不设置 装料完成时间和从饲料场出发时间
			
			newDetail.setTruckID(planDetail.getTruckID());
			newDetail.setTruckName(planDetail.getTruckName());
			newDetail.setTruckNumber(planDetail.getTruckNumber());
			
			newDetail.setDriverName(planDetail.getDriveName());
			newDetail.setMaterialID(planDetail.getMaterialID());
			newDetail.setMaterialName(planDetail.getMaterialName());
			newDetail.setDriverTel(planDetail.getDriveTel());
			// 车次
			newDetail.setTruckSeq(executeInfo.getTruckPlans().size() + 1);
//			newDetail.set
			executeInfo.getTruckPlans().add(newDetail);
			// TODO 查找是否要去其他养殖场送料
			
			int currRow = planDetail.getRowNum();
			// 送 合并的车次
			boolean hasMergeRow = generateMergeRow(newDetail,planDetail,executeInfo,currRow,leaveFarmTime,unloadTimes);
			if(!hasMergeRow){
				DistanceAndTimesInfo backdtInfo = distanceTimesMap.get(farmID+FF_CONSTANTS.FF_KEY);
				// 获得返回到达 饲料场时间 
				Time arriveFFTime = DateCommon.addMinutes(leaveFarmTime,backdtInfo.getMinutes());
				// 设置返回饲料场时间
				newDetail.setBatckToFFTime(arriveFFTime);
				// 记录再次回到饲料厂时间
				executeInfo.setCurrTime(arriveFFTime);
			}
			// 移除待处理 要料计划，增加派车计划
//			executeInfo.getToBeSolveTask().remove(0);
			
		
		}
	}
	
	/**
	 * 生成合并行的 记录
	 * @param executeInfo
	 * @param haPreLoaded
	 * @param dotInfos
	 * @return 是否存在 后续的 合并车次
	 */
	private boolean generateMergeRow(TruckPlanDetail currTruckPDetail,FodderPlanDetail currPplanInfo,TruckExecuteInfo executeInfo,int currRow,Time leaveCurrFarmTime,int unloadTimes){
		boolean hasMergeRow = false;
		// 循环查找以当前车次为 前序车次的 连续送料行
		Iterator<FodderPlanDetail> allPlanIte = executeInfo.getToBeSolveTask().iterator();
		while(allPlanIte.hasNext()){
			FodderPlanDetail planInfo = allPlanIte.next();
			int mergeNum = planInfo.getMergeTruckRowNum();
			if(currRow == mergeNum){
				// 删除当前已处理数据
//				allPlanIte.remove();
				executeInfo.getToBeSolveTask().remove(planInfo);
				// 是否有合并行
				hasMergeRow = true;
				
				StorageOrgUnitInfo nextFarm = new StorageOrgUnitInfo();
				nextFarm.setId(BOSUuid.read(planInfo.getFarmID()));
				nextFarm.setName(planInfo.getFarmName());
				nextFarm.setNumber(planInfo.getFarmNumber());
				
				
				WarehouseInfo nextTower  =  new WarehouseInfo();
				nextTower.setId(BOSUuid.read(planInfo.getTowerID()));
				nextTower.setName(planInfo.getTowerName());
				nextTower.setNumber(planInfo.getTowerNumber());
				
				DistanceAndTimesInfo toOtherFarmInfo  = null;
				if(!currPplanInfo.getFarmID().equals(nextFarm.getId().toString())){
					// 养殖场间路程 路程
					toOtherFarmInfo = distanceTimesMap.get(currPplanInfo.getFarmID() + nextFarm.getId().toString());
					if(toOtherFarmInfo == null){
						MsgBox.showInfo("养殖场【"+currPplanInfo.getFarmName()+"】与【"+nextFarm.getName()+"】间路程时间未设置，请设置后再进行派车");
						SysUtil.abort();
					}
				}else{
					toOtherFarmInfo = new DistanceAndTimesInfo();
					toOtherFarmInfo.setBeginPlace(nextFarm.getName());
					toOtherFarmInfo.setEndPlace(nextFarm.getName());
					toOtherFarmInfo.setDistance(new BigDecimal(0));
					toOtherFarmInfo.setLoadFooder(false);
					toOtherFarmInfo.setMinutes(0);
				}
				// 新增一个派车计划
				TruckPlanDetail toFarmDetail = new TruckPlanDetail();

				toFarmDetail.setFodderPlanDetail(planInfo);
				// 入厂前记录是否已经吃午饭
				boolean hasLunch = executeInfo.isHasLunched();
				// 到达第二个场时间
				Time arriveNewFarmTime = DateCommon.addMinutes(leaveCurrFarmTime,toOtherFarmInfo.getMinutes());
				
				arriveNewFarmTime = addLunchTimes(executeInfo, arriveNewFarmTime);
				
				// 获得第二个场打料完成时间
				Time leaveNewFarmTimeTime = arriveNewFarmTime;
				if(!currPplanInfo.getFarmID().equals(nextFarm.getId().toString())){
					// 如果是在同一个场内 则不再累加 卸料时间
					leaveNewFarmTimeTime = DateCommon.addMinutes(arriveNewFarmTime,unloadTimes);
				}
				leaveNewFarmTimeTime = addLunchTimes(executeInfo, leaveNewFarmTimeTime);
				// 更新当前车次时间
				executeInfo.setCurrTime(leaveNewFarmTimeTime);
				
				
				if(!hasLunch && executeInfo.isHasLunched()){
					toFarmDetail.setHaveLunch(true);
					toFarmDetail.setLunchPlace("养殖场");
					executeInfo.setLunchPlace(toFarmDetail.getFodderPlanDetail().getFarmName());
				}
				// 从第二个场返回饲料场时间
				DistanceAndTimesInfo backFFFromNextFarm = distanceTimesMap.get(nextFarm.getId().toString() + FF_CONSTANTS.FF_KEY);
				if(backFFFromNextFarm == null){
					MsgBox.showInfo("养殖场【"+nextFarm.getName()+"】与饲料场间路程时间未设置，请设置后再进行派车");
					SysUtil.abort();
				}
			
				
				// 次序
				toFarmDetail.setPlanSeq(planInfo.getRowNum());
				
//				toFarmDetail.setLeaveFarmTime(leaveFarmTime);
//				toFarmDetail.setBeginLoadingTime(beginTime);
				
//				toFarmDetail.setLeaveFFTime(loadEndTime);
				
				toFarmDetail.setArriveTime(arriveNewFarmTime);
				toFarmDetail.setLeaveFarmTime(leaveNewFarmTimeTime);
				
				
				toFarmDetail.setTruckID(planInfo.getTruckID());
				toFarmDetail.setTruckName(planInfo.getTruckName());
				toFarmDetail.setTruckNumber(planInfo.getTruckNumber());
				
				toFarmDetail.setDriverName(planInfo.getDriveName());
				toFarmDetail.setDriverTel(planInfo.getDriveTel());
				
				// 车次
				currTruckPDetail.setTruckSeq(executeInfo.getTruckPlans().size() + 1);
//				newDetail.set
				executeInfo.getTruckPlans().add(toFarmDetail);
				
				int nowCurrRow = planInfo.getRowNum();
				// 继续 送下个车次
				boolean hasnewMergeRow = generateMergeRow(toFarmDetail,planInfo,executeInfo,nowCurrRow,leaveNewFarmTimeTime,unloadTimes);
				if(!hasnewMergeRow){
					// 最终返回到饲料场时间
					Time backToFFTime = DateCommon.addMinutes(leaveNewFarmTimeTime,backFFFromNextFarm.getMinutes());
					
					toFarmDetail.setBatckToFFTime(backToFFTime);
					
					// 记录再次回到饲料厂时间
					executeInfo.setCurrTime(backToFFTime);
				}
				
				
			}
		}
		
		
		return hasMergeRow;
	}
	/**
	 * 根据打料口进行排队 默认所有料口 支持所有 饲料打料
	 * 
	 * @param truckLoadTime
	 * @param dotInfos
	 * @return
	 */
	private Time getBeginLoadTime(Time truckLoadTime,List<DischargeDotInfo> dotInfos){
		DischargeDotInfo loadDot = null;
		// 找出 料口最先空出来的 一个
		for(int i = 0; i < dotInfos.size(); i++){
			DischargeDotInfo dotInfo = dotInfos.get(i);
			if(loadDot == null){
				loadDot = dotInfo;
			}else{
				if(dotInfo.getEntruckingOverTime().before(loadDot.getEntruckingOverTime())){
					loadDot = dotInfo;
				}
			}
		}
		// 最先空出来的料口 跟饲料车就位时间比较  取 较靠后一个 为开始打料时间;
		if(loadDot.getEntruckingOverTime().after(truckLoadTime)){
			
			truckLoadTime = loadDot.getEntruckingOverTime();
			
			
			
		}
		// 同时更新该料口下次空出来时间
		loadDot.setEntruckingOverTime(DateCommon.addMinutes(truckLoadTime, baseDataInfo.getLoadingTimes()));
		
		return truckLoadTime;
	}
	
	/**
	 * 添加吃饭时间
	 * @param nowTime
	 */
	private Time addLunchTimes(TruckExecuteInfo executeInfo,Time nowTime){
		// 没有安排吃饭 并且 当前执行时间在  饲料厂设置的饭点时间以内 则 将时间添加上吃饭时间
		Time lunchBeginTime = this.lunchBeginTime.getSqlTime();
		Time lunchEndTime = this.lunchEndTime.getSqlTime();
		if(lunchBeginTime == null || lunchEndTime == null){
			MsgBox.showInfo("午饭开始时间和午饭结束时间不能为空");
			SysUtil.abort();
		}
		if(!(executeInfo.isHasLunched()) && nowTime.after(lunchBeginTime) && nowTime.before(lunchEndTime)){
			Time reallunchEndTime = DateCommon.addMinutes(nowTime, baseDataInfo.getLunchTimecost());
			executeInfo.setHasLunched(true);
			return reallunchEndTime;
		}
		
		return nowTime;
	}
	/**
	 * 获取要料计划  与  饲料车安排信息，如果有 未安排的则提示是否继续 如果继续 忽略未安排的鸡舍
	 * @param dotInfos 打料口列表  在获取要料计划时 将打料口 的占用时间同步更新
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private LinkedHashMap<String,TruckExecuteInfo> getfodderDetails(List<DischargeDotInfo> dotInfos) throws EASBizException, BOSException {
		// map初始化 Key  towerID 
        fordderPlanMap = new LinkedHashMap<String, FodderPlanDetail>();
        // 按车排列的执行情况map 
        truckExecuteInfoMap = new LinkedHashMap<String, TruckExecuteInfo>();

        materialMap = new HashMap<String, MaterialInfo>();
        towerMap = new HashMap<String, WarehouseInfo>();
        farmMap = new HashMap<String, StorageOrgUnitInfo>();
        truckMap = new HashMap<String, FeedTruckInfo>();
        
        // 基础信息
        Time beginTime = this.beginTime.getSqlTime();
        
        int hour = beginTime.getHours();
        int minutes = beginTime.getMinutes();
        
        beginTime = new Time(hour,minutes,0);
        if(beginTime == null){
        	MsgBox.showInfo("请先设置开始打料时间");
        	SysUtil.abort();
        }
        // 单次打料时长
        int loadingTimes = baseDataInfo.getLoadingTimes();
        // 同时打料车数
        int m = baseDataInfo.getMaxEntruckCount();
        // 临时记录已打料车数，计算出所有车开始打料时间，及开始工作时间
        int n = 0;
        // 打料批次； 例如前两辆属于第一批  三到四辆 属于第二批  一次类推
        int j = 1;
        // 已预装车数
        Integer preN = this.txtprepackedTruckCount.getIntegerValue();
        if(preN == null){
        	preN = Integer.valueOf(0);
        }
        
		for(int i = 0; i < this.kdtAssEntrys.getRowCount(); i++){
			IRow row = kdtAssEntrys.getRow(i);
			
			boolean isIgnore =  (Boolean) row.getCell("isIgnore").getValue();
			// 不忽略的行才作为 派车依据
			if(!isIgnore){
				
				// 获取要料计划明细 和车次及   一车多场的数据
				FodderPlanDetail fodderPlanDetail = this.getRowFodderPlandetail(row, i+1);
				fordderPlanMap.put(fodderPlanDetail.getTowerID(), fodderPlanDetail);
				
				// 结果集 中添加对应plandetail
				if(truckExecuteInfoMap.containsKey(fodderPlanDetail.getTruckNumber())){
					truckExecuteInfoMap.get(fodderPlanDetail.getTruckNumber()).getToBeSolveTask().add(fodderPlanDetail);
				}else{
					TruckExecuteInfo executeInfo = new TruckExecuteInfo();
					// 饲料车信息设置
					FeedTruckInfo truckInfo = (FeedTruckInfo) row.getCell("truck").getValue();
					truckInfo = FeedTruckFactory.getRemoteInstance().getFeedTruckInfo(new ObjectUuidPK(truckInfo.getId()));
					executeInfo.setTruckInfo(truckInfo);
					executeInfo.getToBeSolveTask().add(fodderPlanDetail);
					executeInfo.setTruckID(fodderPlanDetail.getTruckID());
					executeInfo.setTruckName(fodderPlanDetail.getTruckName());
					executeInfo.setTruckNumber(fodderPlanDetail.getTruckNumber());
					
					executeInfo.setCurrPosition("饲料厂");
					executeInfo.setCurrPositionID(null);
					
					// 计算开始打料时间
					n++;
					if(((j*m)-(n-preN))<0){
						j++;
					}
					
					int addTimes = (j-1)*loadingTimes;
					
					
					// 设置初始打料时间
					Time beginLoadTime = DateCommon.addMinutes(beginTime, addTimes);
					
					executeInfo.setCurrTime(beginLoadTime);
	//				executeInfo.setBeginTime(beginLoadTime);
					truckExecuteInfoMap.put(fodderPlanDetail.getTruckNumber(), executeInfo);
					
				}
			}
			
			////////组织 detailinfo
			
			
		}
		
		return truckExecuteInfoMap;
	}

    
    /**
     * 从指定的 要料计划分录中获取 要料计划明细
     * 校验 车辆是否已经设置，前置行与当前行 车辆是否一致
     * @param row
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
    private FodderPlanDetail getRowFodderPlandetail(IRow row,int rowNumber) throws EASBizException, BOSException{

    	FodderPlanDetail newDetailInfo = new FodderPlanDetail();
    	// 行号
    	newDetailInfo.setRowNum(rowNumber);
		// 养殖场
		StorageOrgUnitInfo farm = (StorageOrgUnitInfo) row.getCell("farm").getValue();
		// 料塔
		WarehouseInfo tower = (WarehouseInfo) row.getCell("tower").getValue();
		
		MaterialInfo materialInfo = (MaterialInfo) row.getCell("material").getValue();
		// 饲料车
		FeedTruckInfo truckInfo = (FeedTruckInfo) row.getCell("truck").getValue();
		if(truckInfo == null){
			MsgBox.showInfo("第"+(row.getRowIndex()+1)+"行车辆未设置");
			
			SysUtil.abort();
		}
		
		// 剩余库存
		BigDecimal inventory = (BigDecimal)row.getCell("inventory").getValue();
		// 要料量
		BigDecimal fodderQty = (BigDecimal)row.getCell("fodderQty").getValue();
		
		// 所需车次
		Integer truckCount = (Integer)row.getCell("truckCount").getValue();
		if(truckCount == null){
			truckCount = 0;
		}
		
		
		String farmDesc = (String) row.getCell("farmDesc").getValue();
		
		String fodderPort = (String) row.getCell("fodderPort").getValue();
		
		
		// 合并行
		Integer mergeTruckNum = 0;
		
		String mergeTruckNumStr = (String) row.getCell("mergeTrunckNum").getValue();
		try{
			if(StringUtils.isNotBlank(mergeTruckNumStr)){
				BigDecimal mergeBD = new BigDecimal(mergeTruckNumStr);
				mergeTruckNum  = mergeBD.intValue();
			}else{
				mergeTruckNum = 0;
			}
		}catch(NumberFormatException nfe){
			MsgBox.showInfo("合并行列 输入的行号不合法，请重新输入");
			SysUtil.abort();
		}
		
		if(mergeTruckNum == null){
			mergeTruckNum = 0;
		}
		if(mergeTruckNum < 0){
			MsgBox.showInfo("合并行不能小于0");
			SysUtil.abort();
		}
		
			
		if(mergeTruckNum > 0){	
			// 校验与合并行 车辆设置是否一致 
			if(mergeTruckNum >= rowNumber){
				MsgBox.showInfo("只能与比自己行号小的要料计划行合并");
				SysUtil.abort();
			}
			
			if(mergeTruckNum > this.kdtAssEntrys.getRowCount()){
				MsgBox.showInfo("合并行号不能大于总行数");
				SysUtil.abort();
			}
			FeedTruckInfo mergeTruckInfo = (FeedTruckInfo) this.kdtAssEntrys.getRow(mergeTruckNum-1).getCell("truck").getValue();
			
			
			
			// 合并行不能为空
			if(mergeTruckInfo == null){
				MsgBox.showInfo("合并行饲料车不能为空");
				SysUtil.abort();
			}
			
			if(!truckInfo.getId().toString().equals(mergeTruckInfo.getId().toString())){
				MsgBox.showInfo("合并行饲料车必须相同");
				SysUtil.abort();
			}
			
			
			StorageOrgUnitInfo farmInfo = (StorageOrgUnitInfo) this.kdtAssEntrys.getRow(mergeTruckNum-1).getCell("farm").getValue();
			
				if(rowNumber - mergeTruckNum  != 1){
					MsgBox.showInfo("合并行必须为连续行 ");
					SysUtil.abort();
				}
			
			
		}
		
//		FodderPlanDetail fodderDetail = new FodderPlanDetail();
		
		if(farmMap.containsKey(farm.getId().toString())){
			farm = farmMap.get(farm.getId().toString());
		}else{
			farm = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(farm.getId()));
			farmMap.put(farm.getId().toString(), farm);
		}
		
		if(towerMap.containsKey(tower.getId().toString())){
			tower = towerMap.get(tower.getId().toString());
		}else{
			tower = WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK(tower.getId()));
			towerMap.put(tower.getId().toString(), tower);
		}
		
		if(truckMap.containsKey(truckInfo.getId().toString())){
			truckInfo = truckMap.get(truckInfo.getId().toString());
		}else{
			truckInfo = FeedTruckFactory.getRemoteInstance().getFeedTruckInfo(new ObjectUuidPK(truckInfo.getId()));
			truckMap.put(truckInfo.getId().toString(), truckInfo);
		}
		
		PersonInfo driver = truckInfo.getDriver();
		if(driver!= null){
			if(driveMap.containsKey(driver.getId().toString())){
				driver = driveMap.get(driver.getId().toString());
			}else{
				driver = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(driver.getId()));
				driveMap.put(driver.getId().toString(), driver);
			}
		}
		
		if(materialMap.containsKey(materialInfo.getId().toString())){
			materialInfo = materialMap.get(materialInfo.getId().toString());
		}else{
			materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(materialInfo.getId()));
			materialMap.put(materialInfo.getId().toString(), materialInfo);
		}
		
		// 养殖场
		newDetailInfo.setFarmID(farm.getId().toString());
		newDetailInfo.setFarmNumber(farm.getNumber());
		newDetailInfo.setFarmName(farm.getName());
		if(farm.getName().indexOf("育成")>=0){
			newDetailInfo.setFarmType("2YC");
		}else if(farm.getName().indexOf("产蛋")>=0){
			newDetailInfo.setFarmType("3CD");
		}else{
			newDetailInfo.setFarmType("1CC");
		}
		
		// 料塔
		newDetailInfo.setTowerID(tower.getId().toString());
		newDetailInfo.setTowerNumber(tower.getNumber());
		newDetailInfo.setTowerName(tower.getName());
		// 饲料
		newDetailInfo.setMaterialID(materialInfo.getId().toString());
		newDetailInfo.setMaterialModel(materialInfo.getModel());
		newDetailInfo.setMaterialName(materialInfo.getName());
		newDetailInfo.setMaterialNumber(materialInfo.getNumber());
		
		// 饲料车
		newDetailInfo.setTruckID(truckInfo.getId().toString());
		newDetailInfo.setTruckNumber(truckInfo.getNumber());
		newDetailInfo.setTruckName(truckInfo.getName());
		
		newDetailInfo.setDriveTel(truckInfo.getDriverTel());
		if(driver != null){
			newDetailInfo.setDriveName(driver.getName());
		}
		
		newDetailInfo.setFarmDesc(farmDesc);
		newDetailInfo.setFodderPort(fodderPort);
		// 饲料信息
		newDetailInfo.setInventory(inventory);
		newDetailInfo.setQty(fodderQty);
		newDetailInfo.setTruckCount(truckCount);
		newDetailInfo.setMergeTruckRowNum(mergeTruckNum);
		
    	return newDetailInfo;
    }



	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		 // super.actionPrint_actionPerformed(e);  
	    if (editData.getId() != null) {  
	        String id = editData.getId().toString();  
	        DataProvider data = new DataProvider(id);  
	        KDNoteHelper appHlp = new KDNoteHelper();  
	        appHlp.print("bim/farm/feedfactory/FeedFactoryTruckPlan",  
	                data, javax.swing.SwingUtilities.getWindowAncestor(this));  
	       
	    } else {  
	        MsgBox.showWarning("请先保存单据,再点打印!");  
	    }  
	}



	@Override
	public void actionPrintPreview_actionPerformed(ActionEvent e)
			throws Exception {
		 // super.actionPrint_actionPerformed(e);  
	    if (editData.getId() != null) {  
	        String id = editData.getId().toString();  
	        DataProvider data = new DataProvider(id);  
	        KDNoteHelper appHlp = new KDNoteHelper();  
	       
	        appHlp.printPreview("bim/farm/feedfactory/FeedFactoryTruckPlan",  
	                data, javax.swing.SwingUtilities.getWindowAncestor(this));  
	    } else {  
	        MsgBox.showWarning("请先保存单据,再点打印!");  
	    }  
	}
    
    
  
}