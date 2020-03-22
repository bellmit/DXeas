/**
 * output package name
 */
package com.kingdee.eas.farm.pig.ccpig.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.pig.PigFarmInfo;
import com.kingdee.eas.farm.pig.PigFarmType;
import com.kingdee.eas.farm.pig.PigHouseInfo;
import com.kingdee.eas.farm.pig.pigBaseDataFacadeFactory;
import com.kingdee.eas.farm.pig.bean.CCPigBatchDetailInfo;
import com.kingdee.eas.farm.pig.bean.CCPigBatchNormalInfo;
import com.kingdee.eas.farm.pig.bean.ImmunePlanDetailInfo;
import com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryInfo;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo;
import com.kingdee.eas.farm.pig.ccpig.CCPigFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CCPigDailyEditUI extends AbstractCCPigDailyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCPigDailyEditUI.class);
    

    private DataChangeListener bizDateDataChangeListener;
    private DataChangeListener batchDataChangeListener;
    private DataChangeListener pigfarmDataChangeListener;
    
    private PigFarmInfo currFarmInfo;
    // 当前商品猪养殖规范
    private CCPigBreedModelInfo breedModeInfo;
    // 当前商品猪养殖规范   当前日龄饲喂规范
    private CCPigBreedModelEntryInfo modeBreedEntryInfo;
    // 养殖规范免疫项目列表
    private List<ImmunePlanDetailInfo> immuneModelPlanDetails;//  = new ArrayList<ImmunePlanDetailInfo>();
    
    // 当前需要做的日常免疫项目列表
    private List<ImmunePlanDetailInfo> immuneDailyPlanDetails;//  = new ArrayList<ImmunePlanDetailInfo>();
    
    private CCPigBatchNormalInfo batchNormalInfo;
    // 批次 及对应的  养殖规范明细
    private Map<CCPigBatchDetailInfo,CCPigBreedModelEntryInfo> batchModels;
    
    
    
    /**
     * output class constructor
     */
    public CCPigDailyEditUI() throws Exception
    {
        super();
       
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	removeLisenters();
        super.loadFields();
        
        
        this.currFarmInfo = (PigFarmInfo) prmtfarm.getValue();
        if(currFarmInfo != null){
        	this.updatePigBatchFilter(currFarmInfo);
        }
        addLisenters();
        
    }

    /**
     * 清空监听
     */
    private void removeLisenters(){
    	if(bizDateDataChangeListener != null){
    		this.pkBizDate.removeDataChangeListener(bizDateDataChangeListener);
    	}
    	if(batchDataChangeListener != null){
    		this.prmtpigBatch.removeDataChangeListener(batchDataChangeListener);
    	}
    	
    	if(pigfarmDataChangeListener != null){
    		this.prmtfarm.removeDataChangeListener(pigfarmDataChangeListener);
    	}
    	
    }
    
    /**
     * 添加监听
     */
    private void addLisenters(){

        bizDateDataChangeListener = new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkBizDate_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        };
        this.pkBizDate.addDataChangeListener(bizDateDataChangeListener);
        
        batchDataChangeListener = new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtpigBatch_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        };
        this.prmtpigBatch.addDataChangeListener(batchDataChangeListener);
        
        pigfarmDataChangeListener  = new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtpigFarm_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }

			
        };
        this.prmtfarm.addDataChangeListener(pigfarmDataChangeListener);
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
    	
        super.storeFields();
    }
    
    
    
    @Override
	public void initUIContentLayout() {
    	
		super.initUIContentLayout();
		
		this.kdtLiveStockEntrys_detailPanel.setTitleWidth(200);
        this.kdtLiveStockEntrys_detailPanel.setTitle("当天存栏信息");
        
        this.kdtLiveStockEntrys_detailPanel.getInsertLineButton().setVisible(false);
        this.kdtLiveStockEntrys_detailPanel.getAddNewLineButton().setVisible(false);
        this.kdtLiveStockEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
	}
	/**
     * 初始化
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 初始化
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		
		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);
		
		}else {
			if(this.getOprtState().equals("EDIT")){
//				checkCanEdit();
				
			}
			// 初始界面数据
//			initData();
		}
		
//		 // 设置默认当前库存组织所有禽舍信息
//        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
//        if(currStorageOrgInfo == null){
////        	MsgBox.showInfo("当前未在任何库存组织中，不能进行新增养殖日报操作");
////        	this.uiWindow.close();
////        	SysUtil.abort();
//        }
//        else{
//        	try{
//	        	currFarmInfo = pigBaseDataFacadeFactory.getRemoteInstance().getPigfarm(currStorageOrgInfo.getId().toString());
////	        	if(currFarmInfo == null){
////	        		MsgBox.showInfo("当前未在任何养殖场中，不能进行新增养殖日报操作");
////	            	this.uiWindow.close();
////	            	SysUtil.abort();
////	        	}
//        	}catch (Exception e) {
////        		MsgBox.showInfo("当前未在任何养殖场中，不能进行新增养殖日报操作");
////            	this.uiWindow.close();
////            	SysUtil.abort();
//			}
//        }
//        this.prmtfarm.setValue(currFarmInfo);
        updatePigBatchFilter(null);
//        Date nowDate = new Date();
       
//        if(breedModeInfo == null){
//        	MsgBox.showInfo("当前没有启用的商品猪饲喂规范，请先联系系统管理员维护好饲喂规范后再填写日报");
//        	SysUtil.abort();
//        }
        
//        this.kdtAssEntrys.getColumn("days").getStyleAttributes().setLocked(true);
//        this.kdtAssEntrys.getColumn("breedingStock").getStyleAttributes().setLocked(true);
//        // 更新库存组织
//        setStorageOrgUnit(currStorageOrgInfo);
	}
    
    /**
     * 养殖场值变化事件
     * @param e
     * @throws BOSException 
     */
    private void prmtpigFarm_dataChanged(DataChangeEvent e) throws BOSException {
    	// 获取批次明细信息
    	PigFarmInfo oldFarmInfo = (PigFarmInfo) e.getOldValue();
    	PigFarmInfo newFarmInfo = (PigFarmInfo) e.getNewValue();
    	
    	
    	// 删除批次后 清理分录信息
    	if(newFarmInfo == null){
    		if(MsgBox.showConfirm2("删除养殖场，会同步清空批次和分录明细,确定删除？") == MsgBox.OK){
    			removeLisenters();
    			this.prmtpigBatch.setValue(null);
    			updatePigBatchFilter(null);
    			addLisenters();
    			clearAllEntrys();
    			return;
    		}else{
    			removeLisenters();
    			this.prmtfarm.setValue(oldFarmInfo);
    			updatePigBatchFilter(oldFarmInfo);
    			addLisenters();
    			return;
    		}
    	}else{
    		currFarmInfo = newFarmInfo;
    		// 
    		breedModeInfo = CCPigFacadeFactory.getRemoteInstance().getAvailableBreedModel(new Date(),currFarmInfo.getId().toString());
    		removeLisenters();
    		updatePigBatchFilter(newFarmInfo);
			this.prmtpigBatch.setValue(null);
			addLisenters();
			clearAllEntrys();
    		setPigFarm(currFarmInfo);
    	}
    	
    	
		
	}
    /**
     * 根据养殖场 设置 批次 过滤条件
     */
    private void updatePigBatchFilter(PigFarmInfo pigFarm){
    	// 更新各个分录中仓库的 过滤条件
        // 仓库添加过滤条件
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//    		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(pigFarm != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("pigFarm.id",pigFarm.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("pigFarm.id","",CompareType.EQUALS));
		}
		view.setFilter(filterInfo);
		
		this.prmtpigBatch.setQueryInfo("com.kingdee.eas.farm.pig.ccpig.app.CCPigBatchF7Query");		
        this.prmtpigBatch.setEditable(true);		
        this.prmtpigBatch.setDisplayFormat("$number$");		
        this.prmtpigBatch.setEditFormat("$number$");		
        this.prmtpigBatch.setCommitFormat("$number$");		
        this.prmtpigBatch.setRequired(true);
        
        prmtpigBatch.setEntityViewInfo(view);
           
    }
   
    /**
     * 批次更新时 重新获取 批次基本信息并清空分录
     * 
     */
	protected void prmtpigBatch_dataChanged(DataChangeEvent e) throws Exception {
		// 业务日期为空 则不做任何操作
    	Date bizDate = this.pkBizDate.getSqlDate();
 		if(bizDate == null){
 			return;
 		}
    	// 获取批次明细信息
    	CCPigBatchInfo oldBatchInfo = (CCPigBatchInfo) e.getOldValue();
    	CCPigBatchInfo newBatchInfo = (CCPigBatchInfo) e.getNewValue();
    	// 删除批次后 清理分录信息
    	if(newBatchInfo == null){
    		if(MsgBox.showConfirm2("删除批次，会同步清空分录明细,确定删除？") == MsgBox.OK){
    			clearAllEntrys();
    			return;
    		}else{
    			removeLisenters();
    			this.prmtpigBatch.setValue(oldBatchInfo);
    			addLisenters();
    			return;
    		}
    	}
    	// 批次有变化 且 业务日期不为空 则更新批次
    	if(oldBatchInfo != null ){
			if(MsgBox.showConfirm2("修改批次后会清除已填写的各个明细分录，需要重新填写，确认修改？") != MsgBox.OK){
				return;
    		}else{
    			removeLisenters();
    			this.prmtpigBatch.setValue(oldBatchInfo);
    			addLisenters();
    			return;
    		}
    	}
	    
    	
    	// 清理分录 
//		clearAllEntrys();
		// 重新生成 分录
		updateBatchInfo(newBatchInfo, bizDate);
	}
    
    /**
     * 业务日期变化
     */
	protected void pkBizDate_dataChanged(DataChangeEvent e) throws Exception {
    	// 新日期 、旧日期
    	Date oldDate = (Date) e.getOldValue();
    	Date newDate = (Date) e.getNewValue();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String oldDateStr = (oldDate == null?"": sdf.format(oldDate));
    	String newDateStr = (newDate == null?"": sdf.format(newDate));
    	if(oldDateStr.equals(newDateStr )){
    		return ;
    	}
    	// 删除日期后 清理分录信息
    	if(newDate == null){
    		
    		
    		if(MsgBox.showConfirm2("删除业务日期，会同步清空分录明细,确定删除？") == MsgBox.OK){
    			immuneDailyPlanDetails = null;
    			clearAllEntrys();
    			return;
    		}else{
    			e.setNewValue(oldDate);
    			removeLisenters();
    			this.pkBizDate.setValue(oldDate);
    			addLisenters();
    			return;
    		}
    	}
    	
    	currFarmInfo = (PigFarmInfo) this.prmtfarm.getValue();
    	
    	// 如果批次为空 则 直接返回
    	CCPigBatchInfo batchInfo = (CCPigBatchInfo) this.prmtpigBatch.getValue();
    	if(batchInfo == null){
    		return;
    	}
    	
    	// 批次有变化 且 业务日期不为空 则更新批次
    	if(oldDate != null ){
			if(MsgBox.showConfirm2("修改业务日期后会清除已填写的各个明细分录，需要重新填写，确认修改？") != MsgBox.OK){
				return;
    		}
    	}
	   
    	// 根据业务日期获得 日常免疫规范
        immuneDailyPlanDetails = pigBaseDataFacadeFactory.getRemoteInstance().getDailyImmunePlans(PigFarmType.COMMPIG_VALUE, newDate);
        
    	// 清理分录 
//		clearAllEntrys();
		// 重新生成 分录
		updateBatchInfo(batchInfo, newDate);
    	
	}
	
	/**
	 * 淘汰分录更新事件
	 */
	@Override
	protected void kdtCullEntrys_editStopped(KDTEditEvent e) throws Exception {
		
		super.kdtCullEntrys_editStopped(e);
		
		// 更新淘汰分录 均重
		updateCullAverageWeight(e);
		
		updateBatchTodayQtys();
	}
	
	/**
	 * 更新淘汰分录 均重
	 */
	private void updateCullAverageWeight(KDTEditEvent e){
		int colNum = e.getColIndex();
		int rowNum = e.getRowIndex();
		
		if(colNum == this.kdtCullEntrys.getColumnIndex("cullWeight") || 
				colNum == this.kdtCullEntrys.getColumnIndex("cullQty") ){
			BigDecimal cullWeight = (BigDecimal) kdtCullEntrys.getCell(rowNum, "cullWeight").getValue();
			Integer cullQty = (Integer) kdtCullEntrys.getCell(rowNum, "cullQty").getValue();
			if(cullQty != null && cullWeight != null){
				BigDecimal perWeight = cullWeight.divide(new BigDecimal(cullQty), 2, RoundingMode.HALF_UP);
				kdtCullEntrys.getCell(rowNum, "perWeight").setValue(perWeight);
			}
		}
	}
	
	/**
	 * 死亡分录更新 事件
	 */
	@Override
	protected void kdtDCEntrys_editStopped(KDTEditEvent e) throws Exception {
		
		super.kdtDCEntrys_editStopped(e);
		// 根据总重和数量自动计算均重
		updateDCAverageWeight(e);
		// 更新当天信息
		updateBatchTodayQtys();
	}
	
	/**
	 * 更新死亡分录 均重
	 */
	private void updateDCAverageWeight(KDTEditEvent e){
		int colNum = e.getColIndex();
		int rowNum = e.getRowIndex();
		
		if(colNum == this.kdtDCEntrys.getColumnIndex("deathWeight") || 
				colNum == this.kdtDCEntrys.getColumnIndex("deathQty") ){
			BigDecimal deathWeight = (BigDecimal) kdtDCEntrys.getCell(rowNum, "deathWeight").getValue();
			Integer deathQty = (Integer) kdtDCEntrys.getCell(rowNum, "deathQty").getValue();
			if(deathQty != null && deathWeight != null){
				BigDecimal perWeight = deathWeight.divide(new BigDecimal(deathQty), 2, RoundingMode.HALF_UP);
				 kdtDCEntrys.getCell(rowNum, "perWeight").setValue(perWeight);
			}
		}
	}
	
	/**
	 * 出栏分录更新 事件
	 */
	@Override
	protected void kdtOutEntrys_editStopped(KDTEditEvent e) throws Exception {
		
		super.kdtOutEntrys_editStopped(e);
		// 根据总重和数量自动计算均重
		updateOutAverageWeight(e);
		// 更新当天信息
		updateBatchTodayQtys();
	}
	
	/**
	 * 更新死亡分录 均重
	 */
	private void updateOutAverageWeight(KDTEditEvent e){
		int colNum = e.getColIndex();
		int rowNum = e.getRowIndex();
		
		if(colNum == this.kdtOutEntrys.getColumnIndex("allWeight") || 
				colNum == this.kdtOutEntrys.getColumnIndex("qty") ){
			BigDecimal weight = (BigDecimal) kdtOutEntrys.getCell(rowNum, "allWeight").getValue();
			Integer qty = (Integer) kdtOutEntrys.getCell(rowNum, "qty").getValue();
			if(qty != null && weight != null){
				BigDecimal perWeight = weight.divide(new BigDecimal(qty), 2, RoundingMode.HALF_UP);
				 kdtOutEntrys.getCell(rowNum, "avgWeight").setValue(perWeight);
			}
		}
	}
	
	
	/**
	 * 更新制定猪舍的当前存栏信息
	 * @param pighouse
	 */
	private void updateBatchStockingInfos(PigHouseInfo pighouse){
		if(pighouse != null){
			String id = pighouse.getId().toString();
			int deathQty = 0;
			int cullQty = 0;
			int outQty = 0;
			// 累计死亡数
			for(int i = 0; i < kdtDCEntrys.getRowCount(); i++){
				PigHouseInfo dcHenhouse = (PigHouseInfo) kdtDCEntrys.getCell(i, "pigHouse").getValue();
				if(dcHenhouse != null && dcHenhouse.getId().toString().equals(id)){
					int dqty =  (Integer) kdtDCEntrys.getCell(i, "deathQty").getValue();
					deathQty = deathQty + dqty;
				}
			}
			// 累计淘汰数
			for(int i = 0; i < kdtCullEntrys.getRowCount(); i++){
				PigHouseInfo dcHenhouse = (PigHouseInfo) kdtCullEntrys.getCell(i, "pigHouse").getValue();
				if(dcHenhouse != null && dcHenhouse.getId().toString().equals(id)){
					int cqty =  (Integer) kdtCullEntrys.getCell(i, "cullQty").getValue();
					cullQty = cullQty + cqty;
				}
			}
			// 累计出栏数
			for(int i = 0; i < kdtOutEntrys.getRowCount(); i++){
				PigHouseInfo dcHenhouse = (PigHouseInfo) kdtOutEntrys.getCell(i, "pigHouse").getValue();
				if(dcHenhouse != null && dcHenhouse.getId().toString().equals(id)){
					int outqty =  (Integer) kdtOutEntrys.getCell(i, "qty").getValue();
					outQty = outQty + outqty;
				}
			}
			
			
			// 更新到对应的存栏信息中
			for(int i = 0; i < kdtLiveStockEntrys.getRowCount(); i++){
				PigHouseInfo dcHenhouse = (PigHouseInfo) kdtLiveStockEntrys.getCell(i, "pigHouse").getValue();
				if(dcHenhouse != null && dcHenhouse.getId().toString().equals(id)){
					int stockQty = (Integer)kdtLiveStockEntrys.getCell(i, "death").getValue();
					// 剩余存栏量
					int endQty = stockQty - deathQty - cullQty - outQty;
					
					kdtLiveStockEntrys.getCell(i, "deathQty").setValue(deathQty);
					kdtLiveStockEntrys.getCell(i, "cullQty").setValue(cullQty);
					kdtLiveStockEntrys.getCell(i, "culldeathQty").setValue(deathQty+cullQty);
					kdtLiveStockEntrys.getCell(i, "endStock").setValue(endQty);
					
					if(endQty < 0){
						MsgBox.showInfo("当天剩余存栏小于0，请核对数据");
					}
				}
			}
		}
	}
	/**
	 * 饲喂分录
	 */
	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		
		super.kdtEntrys_Changed(rowIndex, colIndex);
	}
	/**
	 * 校验业务日期
	 * 如果业务日期小于批次入栏日期  返回false
	 */
	private boolean isDateOk(CCPigBatchInfo currBatchInfo,Date bizDate){
		if(currBatchInfo == null || bizDate == null){
			Date incoopDate = currBatchInfo.getBizDate();
			if(incoopDate != null){
				if(bizDate.compareTo(incoopDate) < 0){
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	/**
     * 清空所有分录
     */
    private void clearAllEntrys(){
    	// 清理分录明细
    	this.kdtEntrys.removeRows();
    	this.kdtImmuneEntrys.removeRows();
    	this.kdtDCEntrys.removeRows();
    	this.kdtOutEarNumberEntrys.removeRows();
    	this.kdtOutEntrys.removeRows();
    	this.kdtEnviConEntry.removeRows();
    	this.kdtLiveStockEntrys.removeRows();
    	
    	this.editData.getEntrys().clear();
    	this.editData.getImmuneEntrys().clear();
    	this.editData.getDCEntrys().clear();
    	this.editData.getOutEntrys().clear();
    	this.editData.getEnviConEntry().clear();
    	this.editData.getLiveStockEntrys().clear();
    }
    /**
     * 根据批次和业务日期 更新
     * @param currBatchInfo
     * @param bizDate
     * @throws BOSException 
     */
    private void updateBatchInfo(CCPigBatchInfo currBatchInfo,Date bizDate) throws BOSException{
    	if(currBatchInfo != null && bizDate != null){
    		if(!isDateOk(currBatchInfo,bizDate)){
    			MsgBox.showInfo("日报业务日期不能小于批次入栏日期");
    			SysUtil.abort();
    		}
    		
    		// 先清理分录
    		clearAllEntrys();
    		batchNormalInfo = CCPigFacadeFactory.getRemoteInstance().getFarmBreedCCPigBatch(currFarmInfo.getId().toString(), currBatchInfo.getId().toString(), bizDate);
    		// 获取到批次基本信息后询问是否重新加载基本信息
    		if(batchNormalInfo != null){
    			
    			expandBatchInfos(batchNormalInfo);
    			// 当前日龄
    			int nowDays = batchNormalInfo.getCurrDays();
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    			// 获得 规范免疫 分录
//    			immuneModelPlanDetails = CCPigFacadeFactory.getRemoteInstance().getModelImmunePlans(breedModeInfo, bizDate, nowDays);
    			
    			// 获得 5 天后 即将规范免疫 分录
    			immuneModelPlanDetails = CCPigFacadeFactory.getRemoteInstance().getModelRecentImmunePlans(breedModeInfo, bizDate, nowDays);
    			StringBuilder warnStr = new StringBuilder();
    			if(immuneModelPlanDetails != null && immuneModelPlanDetails.size() > 0){
    				warnStr.append("批次免疫提醒：");
    				
    				// 将 需要提醒的免疫信息 显示在 注意事项中
    				for(int i = 0; i < immuneModelPlanDetails.size(); i++){
    					ImmunePlanDetailInfo immunePlanInfo = immuneModelPlanDetails.get(i);
    					if(immunePlanInfo != null){
    						warnStr.append("需要在");
    						warnStr.append(sdf.format(immunePlanInfo.getImmuneBeginDate()));
    						warnStr.append("日到");
    						warnStr.append(sdf.format(immunePlanInfo.getImmuneEndDate()));
    						warnStr.append("日进行");
    						warnStr.append(immunePlanInfo.getImmuneMaterial().getName());
    						warnStr.append("免疫，免疫方式为").append(immunePlanInfo.getImmuneMode().getAlias());
    						warnStr.append(",");
    						warnStr.append(immunePlanInfo.getQtyPer()).append(immunePlanInfo.getUnit().getName());
    						warnStr.append("/只；");
    						
    					}
    				}
    			}
    			if(warnStr.length() > 0){
    				this.txtwarn.setText(warnStr.toString());
    			}
//    			modeBreedEntryInfo = CCPigFacadeFactory.getRemoteInstance().get
    			// TODO
    		}
    		
    	}
    }
    /**
     * 显示批次 明细信息
     * @throws BOSException 
     */
    private void expandBatchInfos(CCPigBatchNormalInfo batchNormalInfo) throws BOSException {
		if(batchNormalInfo != null && batchNormalInfo.getBatchDetails() != null && batchNormalInfo.getBatchDetails().size() > 0){
			// 批次信息
			CCPigBatchInfo batchInfo = new CCPigBatchInfo();
			batchInfo.setId(BOSUuid.read(batchNormalInfo.getBatchID()));
			batchInfo.setNumber(batchNormalInfo.getBatchNumber());
			for(int i = 0; i < batchNormalInfo.getBatchDetails().size(); i++){
				CCPigBatchDetailInfo detailInfo = batchNormalInfo.getBatchDetails().get(i);
				if(detailInfo != null){
					IRow newRow = this.kdtLiveStockEntrys.addRow();
//					newRow.setUserObject(detailInfo);
					newRow.getCell("pigHouse").setValue(detailInfo.getPigHouse());
					
					newRow.getCell("stockQty").setValue(detailInfo.getNowQty());
					newRow.getCell("days").setValue(batchNormalInfo.getCurrDays());
//					newRow.getCell("culldeathQty").setValue(detailInfo.getCullQty()+detailInfo.getDeathQty());
//					newRow.getCell("outQty").setValue(detailInfo.getMarketQty());
//					newRow.getCell("endStock").setValue(detailInfo.getNowQty());
//					newRow.getCell("cullQty").setValue(detailInfo.getCullQty());
//					newRow.getCell("deathQty").setValue(detailInfo.getDeathQty());
				}
			}
			// 设置 饲喂分录 和  注意信息
			
		}
	}
	/**
     * 根据规范 的 免疫设置 和 日常免疫设置  结合当前日龄以及批次 免疫情况  设置 免疫分录
     */
    private void setImmuneEntrys(){
    	
    }
    
    /**
     * 遍历所有分录明细  更新当天 死淘、宰杀和 剩余存栏
     */
    /**
     * 
     */
    private void updateBatchTodayQtys(){
    	for(int i = 0 ; i < this.kdtLiveStockEntrys.getRowCount(); i++){
    		PigHouseInfo houseInfo = (PigHouseInfo) this.kdtLiveStockEntrys.getCell(i,"pigHouse").getValue();
    		if(houseInfo != null){
    			int initQty = (Integer) this.kdtLiveStockEntrys.getCell(i,"stockQty").getValue();
    			int deathQty = 0;
    			int cullQty = 0;
    			int outQty = 0;
    			// 死亡累计
    			for(int o = 0; o < this.kdtDCEntrys.getRowCount(); o++){
    				PigHouseInfo dchouse = (PigHouseInfo) this.kdtDCEntrys.getCell(i,"pigHouse").getValue();
    	    		if(dchouse != null && dchouse.getId().toString().equals(houseInfo.getId().toString())){
    	    			int currDeath =  (Integer)this.kdtDCEntrys.getCell(i,"deathQty").getValue();
    	    			deathQty = deathQty + currDeath;
    	    		}
    			}
    			
    			// 淘汰累计
    			for(int o = 0; o < this.kdtCullEntrys.getRowCount(); o++){
    				PigHouseInfo cullhouse = (PigHouseInfo) this.kdtCullEntrys.getCell(i,"pigHouse").getValue();
    	    		if(cullhouse != null && cullhouse.getId().toString().equals(houseInfo.getId().toString())){
    	    			int currCull =  (Integer)this.kdtCullEntrys.getCell(i,"cullQty").getValue();
    	    			cullQty = cullQty + currCull;
    	    		}
    			}
    			
    			// 淘汰出栏
    			for(int o = 0; o < this.kdtOutEntrys.getRowCount(); o++){
    				PigHouseInfo outhouse = (PigHouseInfo) this.kdtOutEntrys.getCell(i,"pigHouse").getValue();
    	    		if(outhouse != null && outhouse.getId().toString().equals(houseInfo.getId().toString())){
    	    			int currOut =  (Integer)this.kdtOutEntrys.getCell(i,"qty").getValue();
    	    			outQty = outQty + currOut;
    	    		}
    			}
    			
    			
//    			this.kdtLiveStockEntrys.getCell(i,"initQty").setValue(arg0)
    			this.kdtLiveStockEntrys.getRow(i).getCell("culldeathQty").setValue(deathQty+cullQty);
    			this.kdtLiveStockEntrys.getRow(i).getCell("outQty").setValue(outQty);
    			this.kdtLiveStockEntrys.getRow(i).getCell("endStock").setValue(initQty-deathQty-cullQty-outQty);
    			this.kdtLiveStockEntrys.getRow(i).getCell("cullQty").setValue(cullQty);
    			this.kdtLiveStockEntrys.getRow(i).getCell("deathQty").setValue(deathQty);
    			
    		}
    	}
    	
    	
    }
	/**
     * 设置 库存组织信息到 控件中并且 更新相关过滤条件
     * @param orgInfo
     */
    private void setStorageOrgUnit(StorageOrgUnitInfo orgInfo){
    
    	// 更新各个分录中仓库的 过滤条件
    // 仓库添加过滤条件
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(orgInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("stoOrg.id",orgInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("stoOrg.id","",CompareType.EQUALS));
		}
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%禽舍%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_pighouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_pighouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtEntrys_pighouse_PromptBox.setVisible(true);
        kdtEntrys_pighouse_PromptBox.setEditable(true);
        kdtEntrys_pighouse_PromptBox.setDisplayFormat("$name$");
        kdtEntrys_pighouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_pighouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_pighouse_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pighouse_PromptBox);
        // 饲喂信息
//        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 水电信息
//        this.kdtWEEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 燃料信息
//        this.kdtFuelEntrys.getColumn("henhouse").setEditor(kdtEntrys_warehouse_CellEditor);
        // 疫苗信息
//        this.kdtImmuneEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 其他信息
//        this.kdtAssEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        
        
        
        
    }
    
    
    /**
     * 设置 养殖场信息
     * @param orgInfo
     */
    private void setPigFarm(PigFarmInfo currFarmInfo){
    	
    	
    	// 更新各个分录中仓库的 过滤条件
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(currFarmInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("pigFarm.id",currFarmInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("pigFarm.id","",CompareType.EQUALS));
		}
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%禽舍%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_pighouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_pighouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtEntrys_pighouse_PromptBox.setVisible(true);
        kdtEntrys_pighouse_PromptBox.setEditable(true);
        kdtEntrys_pighouse_PromptBox.setDisplayFormat("$name$");
        kdtEntrys_pighouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_pighouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_pighouse_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pighouse_PromptBox);
        // 饲喂信息
        this.kdtEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        
        // 死淘信息
        this.kdtDCEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 免疫信息
        this.kdtImmuneEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 淘汰信息
        this.kdtCullEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 疫苗信息
        this.kdtLiveStockEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 出栏信息
        this.kdtOutEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 环空信息
        this.kdtEnviConEntry.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        
        
        
    }
	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.ccpig.CCPigDailyFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo objectValue = new com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    
  
    @Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
    	// 更新当天信息
		updateBatchTodayQtys();
    	if(!isDateOk((CCPigBatchInfo) this.prmtpigBatch.getValue(),this.pkBizDate.getSqlDate())){
			MsgBox.showInfo("日报业务日期不能小于批次入栏日期");
			SysUtil.abort();
		}
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// 更新当天信息
		updateBatchTodayQtys();
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{
				
				if(!isDateOk((CCPigBatchInfo) this.prmtpigBatch.getValue(),this.pkBizDate.getSqlDate())){
					MsgBox.showInfo("日报业务日期不能小于批次入栏日期");
					SysUtil.abort();
				}
				super.actionSubmit_actionPerformed(e);
				
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
	 * 校验数据准确性
	 */
	public void verify(){
		
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
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
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
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	

}