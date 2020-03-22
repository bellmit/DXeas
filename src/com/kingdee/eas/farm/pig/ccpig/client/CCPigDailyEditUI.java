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
    // ��ǰ��Ʒ����ֳ�淶
    private CCPigBreedModelInfo breedModeInfo;
    // ��ǰ��Ʒ����ֳ�淶   ��ǰ������ι�淶
    private CCPigBreedModelEntryInfo modeBreedEntryInfo;
    // ��ֳ�淶������Ŀ�б�
    private List<ImmunePlanDetailInfo> immuneModelPlanDetails;//  = new ArrayList<ImmunePlanDetailInfo>();
    
    // ��ǰ��Ҫ�����ճ�������Ŀ�б�
    private List<ImmunePlanDetailInfo> immuneDailyPlanDetails;//  = new ArrayList<ImmunePlanDetailInfo>();
    
    private CCPigBatchNormalInfo batchNormalInfo;
    // ���� ����Ӧ��  ��ֳ�淶��ϸ
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
     * ��ռ���
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
     * ��Ӽ���
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
        this.kdtLiveStockEntrys_detailPanel.setTitle("���������Ϣ");
        
        this.kdtLiveStockEntrys_detailPanel.getInsertLineButton().setVisible(false);
        this.kdtLiveStockEntrys_detailPanel.getAddNewLineButton().setVisible(false);
        this.kdtLiveStockEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
	}
	/**
     * ��ʼ��
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// ��ʼ��
		// ����ȫ��
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		
		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);
		
		}else {
			if(this.getOprtState().equals("EDIT")){
//				checkCanEdit();
				
			}
			// ��ʼ��������
//			initData();
		}
		
//		 // ����Ĭ�ϵ�ǰ�����֯����������Ϣ
//        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
//        if(currStorageOrgInfo == null){
////        	MsgBox.showInfo("��ǰδ���κο����֯�У����ܽ���������ֳ�ձ�����");
////        	this.uiWindow.close();
////        	SysUtil.abort();
//        }
//        else{
//        	try{
//	        	currFarmInfo = pigBaseDataFacadeFactory.getRemoteInstance().getPigfarm(currStorageOrgInfo.getId().toString());
////	        	if(currFarmInfo == null){
////	        		MsgBox.showInfo("��ǰδ���κ���ֳ���У����ܽ���������ֳ�ձ�����");
////	            	this.uiWindow.close();
////	            	SysUtil.abort();
////	        	}
//        	}catch (Exception e) {
////        		MsgBox.showInfo("��ǰδ���κ���ֳ���У����ܽ���������ֳ�ձ�����");
////            	this.uiWindow.close();
////            	SysUtil.abort();
//			}
//        }
//        this.prmtfarm.setValue(currFarmInfo);
        updatePigBatchFilter(null);
//        Date nowDate = new Date();
       
//        if(breedModeInfo == null){
//        	MsgBox.showInfo("��ǰû�����õ���Ʒ����ι�淶��������ϵϵͳ����Աά������ι�淶������д�ձ�");
//        	SysUtil.abort();
//        }
        
//        this.kdtAssEntrys.getColumn("days").getStyleAttributes().setLocked(true);
//        this.kdtAssEntrys.getColumn("breedingStock").getStyleAttributes().setLocked(true);
//        // ���¿����֯
//        setStorageOrgUnit(currStorageOrgInfo);
	}
    
    /**
     * ��ֳ��ֵ�仯�¼�
     * @param e
     * @throws BOSException 
     */
    private void prmtpigFarm_dataChanged(DataChangeEvent e) throws BOSException {
    	// ��ȡ������ϸ��Ϣ
    	PigFarmInfo oldFarmInfo = (PigFarmInfo) e.getOldValue();
    	PigFarmInfo newFarmInfo = (PigFarmInfo) e.getNewValue();
    	
    	
    	// ɾ�����κ� �����¼��Ϣ
    	if(newFarmInfo == null){
    		if(MsgBox.showConfirm2("ɾ����ֳ������ͬ��������κͷ�¼��ϸ,ȷ��ɾ����") == MsgBox.OK){
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
     * ������ֳ�� ���� ���� ��������
     */
    private void updatePigBatchFilter(PigFarmInfo pigFarm){
    	// ���¸�����¼�вֿ�� ��������
        // �ֿ���ӹ�������
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
     * ���θ���ʱ ���»�ȡ ���λ�����Ϣ����շ�¼
     * 
     */
	protected void prmtpigBatch_dataChanged(DataChangeEvent e) throws Exception {
		// ҵ������Ϊ�� �����κβ���
    	Date bizDate = this.pkBizDate.getSqlDate();
 		if(bizDate == null){
 			return;
 		}
    	// ��ȡ������ϸ��Ϣ
    	CCPigBatchInfo oldBatchInfo = (CCPigBatchInfo) e.getOldValue();
    	CCPigBatchInfo newBatchInfo = (CCPigBatchInfo) e.getNewValue();
    	// ɾ�����κ� �����¼��Ϣ
    	if(newBatchInfo == null){
    		if(MsgBox.showConfirm2("ɾ�����Σ���ͬ����շ�¼��ϸ,ȷ��ɾ����") == MsgBox.OK){
    			clearAllEntrys();
    			return;
    		}else{
    			removeLisenters();
    			this.prmtpigBatch.setValue(oldBatchInfo);
    			addLisenters();
    			return;
    		}
    	}
    	// �����б仯 �� ҵ�����ڲ�Ϊ�� ���������
    	if(oldBatchInfo != null ){
			if(MsgBox.showConfirm2("�޸����κ���������д�ĸ�����ϸ��¼����Ҫ������д��ȷ���޸ģ�") != MsgBox.OK){
				return;
    		}else{
    			removeLisenters();
    			this.prmtpigBatch.setValue(oldBatchInfo);
    			addLisenters();
    			return;
    		}
    	}
	    
    	
    	// �����¼ 
//		clearAllEntrys();
		// �������� ��¼
		updateBatchInfo(newBatchInfo, bizDate);
	}
    
    /**
     * ҵ�����ڱ仯
     */
	protected void pkBizDate_dataChanged(DataChangeEvent e) throws Exception {
    	// ������ ��������
    	Date oldDate = (Date) e.getOldValue();
    	Date newDate = (Date) e.getNewValue();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String oldDateStr = (oldDate == null?"": sdf.format(oldDate));
    	String newDateStr = (newDate == null?"": sdf.format(newDate));
    	if(oldDateStr.equals(newDateStr )){
    		return ;
    	}
    	// ɾ�����ں� �����¼��Ϣ
    	if(newDate == null){
    		
    		
    		if(MsgBox.showConfirm2("ɾ��ҵ�����ڣ���ͬ����շ�¼��ϸ,ȷ��ɾ����") == MsgBox.OK){
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
    	
    	// �������Ϊ�� �� ֱ�ӷ���
    	CCPigBatchInfo batchInfo = (CCPigBatchInfo) this.prmtpigBatch.getValue();
    	if(batchInfo == null){
    		return;
    	}
    	
    	// �����б仯 �� ҵ�����ڲ�Ϊ�� ���������
    	if(oldDate != null ){
			if(MsgBox.showConfirm2("�޸�ҵ�����ں���������д�ĸ�����ϸ��¼����Ҫ������д��ȷ���޸ģ�") != MsgBox.OK){
				return;
    		}
    	}
	   
    	// ����ҵ�����ڻ�� �ճ����߹淶
        immuneDailyPlanDetails = pigBaseDataFacadeFactory.getRemoteInstance().getDailyImmunePlans(PigFarmType.COMMPIG_VALUE, newDate);
        
    	// �����¼ 
//		clearAllEntrys();
		// �������� ��¼
		updateBatchInfo(batchInfo, newDate);
    	
	}
	
	/**
	 * ��̭��¼�����¼�
	 */
	@Override
	protected void kdtCullEntrys_editStopped(KDTEditEvent e) throws Exception {
		
		super.kdtCullEntrys_editStopped(e);
		
		// ������̭��¼ ����
		updateCullAverageWeight(e);
		
		updateBatchTodayQtys();
	}
	
	/**
	 * ������̭��¼ ����
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
	 * ������¼���� �¼�
	 */
	@Override
	protected void kdtDCEntrys_editStopped(KDTEditEvent e) throws Exception {
		
		super.kdtDCEntrys_editStopped(e);
		// �������غ������Զ��������
		updateDCAverageWeight(e);
		// ���µ�����Ϣ
		updateBatchTodayQtys();
	}
	
	/**
	 * ����������¼ ����
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
	 * ������¼���� �¼�
	 */
	@Override
	protected void kdtOutEntrys_editStopped(KDTEditEvent e) throws Exception {
		
		super.kdtOutEntrys_editStopped(e);
		// �������غ������Զ��������
		updateOutAverageWeight(e);
		// ���µ�����Ϣ
		updateBatchTodayQtys();
	}
	
	/**
	 * ����������¼ ����
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
	 * �����ƶ�����ĵ�ǰ������Ϣ
	 * @param pighouse
	 */
	private void updateBatchStockingInfos(PigHouseInfo pighouse){
		if(pighouse != null){
			String id = pighouse.getId().toString();
			int deathQty = 0;
			int cullQty = 0;
			int outQty = 0;
			// �ۼ�������
			for(int i = 0; i < kdtDCEntrys.getRowCount(); i++){
				PigHouseInfo dcHenhouse = (PigHouseInfo) kdtDCEntrys.getCell(i, "pigHouse").getValue();
				if(dcHenhouse != null && dcHenhouse.getId().toString().equals(id)){
					int dqty =  (Integer) kdtDCEntrys.getCell(i, "deathQty").getValue();
					deathQty = deathQty + dqty;
				}
			}
			// �ۼ���̭��
			for(int i = 0; i < kdtCullEntrys.getRowCount(); i++){
				PigHouseInfo dcHenhouse = (PigHouseInfo) kdtCullEntrys.getCell(i, "pigHouse").getValue();
				if(dcHenhouse != null && dcHenhouse.getId().toString().equals(id)){
					int cqty =  (Integer) kdtCullEntrys.getCell(i, "cullQty").getValue();
					cullQty = cullQty + cqty;
				}
			}
			// �ۼƳ�����
			for(int i = 0; i < kdtOutEntrys.getRowCount(); i++){
				PigHouseInfo dcHenhouse = (PigHouseInfo) kdtOutEntrys.getCell(i, "pigHouse").getValue();
				if(dcHenhouse != null && dcHenhouse.getId().toString().equals(id)){
					int outqty =  (Integer) kdtOutEntrys.getCell(i, "qty").getValue();
					outQty = outQty + outqty;
				}
			}
			
			
			// ���µ���Ӧ�Ĵ�����Ϣ��
			for(int i = 0; i < kdtLiveStockEntrys.getRowCount(); i++){
				PigHouseInfo dcHenhouse = (PigHouseInfo) kdtLiveStockEntrys.getCell(i, "pigHouse").getValue();
				if(dcHenhouse != null && dcHenhouse.getId().toString().equals(id)){
					int stockQty = (Integer)kdtLiveStockEntrys.getCell(i, "death").getValue();
					// ʣ�������
					int endQty = stockQty - deathQty - cullQty - outQty;
					
					kdtLiveStockEntrys.getCell(i, "deathQty").setValue(deathQty);
					kdtLiveStockEntrys.getCell(i, "cullQty").setValue(cullQty);
					kdtLiveStockEntrys.getCell(i, "culldeathQty").setValue(deathQty+cullQty);
					kdtLiveStockEntrys.getCell(i, "endStock").setValue(endQty);
					
					if(endQty < 0){
						MsgBox.showInfo("����ʣ�����С��0����˶�����");
					}
				}
			}
		}
	}
	/**
	 * ��ι��¼
	 */
	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		
		super.kdtEntrys_Changed(rowIndex, colIndex);
	}
	/**
	 * У��ҵ������
	 * ���ҵ������С��������������  ����false
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
     * ������з�¼
     */
    private void clearAllEntrys(){
    	// �����¼��ϸ
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
     * �������κ�ҵ������ ����
     * @param currBatchInfo
     * @param bizDate
     * @throws BOSException 
     */
    private void updateBatchInfo(CCPigBatchInfo currBatchInfo,Date bizDate) throws BOSException{
    	if(currBatchInfo != null && bizDate != null){
    		if(!isDateOk(currBatchInfo,bizDate)){
    			MsgBox.showInfo("�ձ�ҵ�����ڲ���С��������������");
    			SysUtil.abort();
    		}
    		
    		// �������¼
    		clearAllEntrys();
    		batchNormalInfo = CCPigFacadeFactory.getRemoteInstance().getFarmBreedCCPigBatch(currFarmInfo.getId().toString(), currBatchInfo.getId().toString(), bizDate);
    		// ��ȡ�����λ�����Ϣ��ѯ���Ƿ����¼��ػ�����Ϣ
    		if(batchNormalInfo != null){
    			
    			expandBatchInfos(batchNormalInfo);
    			// ��ǰ����
    			int nowDays = batchNormalInfo.getCurrDays();
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    			// ��� �淶���� ��¼
//    			immuneModelPlanDetails = CCPigFacadeFactory.getRemoteInstance().getModelImmunePlans(breedModeInfo, bizDate, nowDays);
    			
    			// ��� 5 ��� �����淶���� ��¼
    			immuneModelPlanDetails = CCPigFacadeFactory.getRemoteInstance().getModelRecentImmunePlans(breedModeInfo, bizDate, nowDays);
    			StringBuilder warnStr = new StringBuilder();
    			if(immuneModelPlanDetails != null && immuneModelPlanDetails.size() > 0){
    				warnStr.append("�����������ѣ�");
    				
    				// �� ��Ҫ���ѵ�������Ϣ ��ʾ�� ע��������
    				for(int i = 0; i < immuneModelPlanDetails.size(); i++){
    					ImmunePlanDetailInfo immunePlanInfo = immuneModelPlanDetails.get(i);
    					if(immunePlanInfo != null){
    						warnStr.append("��Ҫ��");
    						warnStr.append(sdf.format(immunePlanInfo.getImmuneBeginDate()));
    						warnStr.append("�յ�");
    						warnStr.append(sdf.format(immunePlanInfo.getImmuneEndDate()));
    						warnStr.append("�ս���");
    						warnStr.append(immunePlanInfo.getImmuneMaterial().getName());
    						warnStr.append("���ߣ����߷�ʽΪ").append(immunePlanInfo.getImmuneMode().getAlias());
    						warnStr.append(",");
    						warnStr.append(immunePlanInfo.getQtyPer()).append(immunePlanInfo.getUnit().getName());
    						warnStr.append("/ֻ��");
    						
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
     * ��ʾ���� ��ϸ��Ϣ
     * @throws BOSException 
     */
    private void expandBatchInfos(CCPigBatchNormalInfo batchNormalInfo) throws BOSException {
		if(batchNormalInfo != null && batchNormalInfo.getBatchDetails() != null && batchNormalInfo.getBatchDetails().size() > 0){
			// ������Ϣ
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
			// ���� ��ι��¼ ��  ע����Ϣ
			
		}
	}
	/**
     * ���ݹ淶 �� �������� �� �ճ���������  ��ϵ�ǰ�����Լ����� �������  ���� ���߷�¼
     */
    private void setImmuneEntrys(){
    	
    }
    
    /**
     * �������з�¼��ϸ  ���µ��� ���ԡ���ɱ�� ʣ�����
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
    			// �����ۼ�
    			for(int o = 0; o < this.kdtDCEntrys.getRowCount(); o++){
    				PigHouseInfo dchouse = (PigHouseInfo) this.kdtDCEntrys.getCell(i,"pigHouse").getValue();
    	    		if(dchouse != null && dchouse.getId().toString().equals(houseInfo.getId().toString())){
    	    			int currDeath =  (Integer)this.kdtDCEntrys.getCell(i,"deathQty").getValue();
    	    			deathQty = deathQty + currDeath;
    	    		}
    			}
    			
    			// ��̭�ۼ�
    			for(int o = 0; o < this.kdtCullEntrys.getRowCount(); o++){
    				PigHouseInfo cullhouse = (PigHouseInfo) this.kdtCullEntrys.getCell(i,"pigHouse").getValue();
    	    		if(cullhouse != null && cullhouse.getId().toString().equals(houseInfo.getId().toString())){
    	    			int currCull =  (Integer)this.kdtCullEntrys.getCell(i,"cullQty").getValue();
    	    			cullQty = cullQty + currCull;
    	    		}
    			}
    			
    			// ��̭����
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
     * ���� �����֯��Ϣ�� �ؼ��в��� ������ع�������
     * @param orgInfo
     */
    private void setStorageOrgUnit(StorageOrgUnitInfo orgInfo){
    
    	// ���¸�����¼�вֿ�� ��������
    // �ֿ���ӹ�������
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(orgInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("stoOrg.id",orgInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("stoOrg.id","",CompareType.EQUALS));
		}
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%����%",CompareType.LIKE));
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
        // ��ι��Ϣ
//        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ˮ����Ϣ
//        this.kdtWEEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ȼ����Ϣ
//        this.kdtFuelEntrys.getColumn("henhouse").setEditor(kdtEntrys_warehouse_CellEditor);
        // ������Ϣ
//        this.kdtImmuneEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ������Ϣ
//        this.kdtAssEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        
        
        
        
    }
    
    
    /**
     * ���� ��ֳ����Ϣ
     * @param orgInfo
     */
    private void setPigFarm(PigFarmInfo currFarmInfo){
    	
    	
    	// ���¸�����¼�вֿ�� ��������
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(currFarmInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("pigFarm.id",currFarmInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("pigFarm.id","",CompareType.EQUALS));
		}
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%����%",CompareType.LIKE));
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
        // ��ι��Ϣ
        this.kdtEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        
        // ������Ϣ
        this.kdtDCEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ������Ϣ
        this.kdtImmuneEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ��̭��Ϣ
        this.kdtCullEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ������Ϣ
        this.kdtLiveStockEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ������Ϣ
        this.kdtOutEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ������Ϣ
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
    	// ���µ�����Ϣ
		updateBatchTodayQtys();
    	if(!isDateOk((CCPigBatchInfo) this.prmtpigBatch.getValue(),this.pkBizDate.getSqlDate())){
			MsgBox.showInfo("�ձ�ҵ�����ڲ���С��������������");
			SysUtil.abort();
		}
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// ���µ�����Ϣ
		updateBatchTodayQtys();
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{
				
				if(!isDateOk((CCPigBatchInfo) this.prmtpigBatch.getValue(),this.pkBizDate.getSqlDate())){
					MsgBox.showInfo("�ձ�ҵ�����ڲ���С��������������");
					SysUtil.abort();
				}
				super.actionSubmit_actionPerformed(e);
				
			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}
			
			
		}else{
			MsgBox.showWarning("ֻ���ύδ��˵ĵ���");
			SysUtil.abort();
		}
	}
	
	/**
	 * У������׼ȷ��
	 */
	public void verify(){
		
	}
	/**
     * ���ص�������
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
		// �ж�
		SysUtil.abort();
			
			
		
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("�������δ�ύ�ĵ���");
			SysUtil.abort();
		}
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showWarning("������");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("ֻ�ܷ���˴������״̬������");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("��������");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	

}