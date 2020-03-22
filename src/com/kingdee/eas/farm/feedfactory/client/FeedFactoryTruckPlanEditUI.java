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
    
    // ���ϳ� ������Ϣ��������
    private FeedFactoryBaseDataInfo baseDataInfo ;
    // idΪ towerID
    private LinkedHashMap<String,FodderPlanDetail> fordderPlanMap;
    // id Ϊ����
    private LinkedHashMap<String,TruckExecuteInfo> truckExecuteInfoMap;
    // ����ʱ��Map
    Map<String,DistanceAndTimesInfo> distanceTimesMap;
    
    // �����ݴ�����map  Key  ID   value  info
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
        // ��� Ĭ�ϵ����ϳ�����
		baseDataInfo = TruckPlanFacadeFactory.getRemoteInstance().getFeedFactoryBaseData();
		driveMap = new HashMap<String, PersonInfo>();
		
		if(baseDataInfo == null){
			MsgBox.showInfo("δȡ�����ϳ��������ã�����ϵ����Աȷ���Ƿ��Ѿ����úû�����Ϣ");
			SysUtil.abort();
		}
		
        kdtAssEntrys.addKDTEditListener(new KDTEditAdapter() {
//        	// ��������޸� ����  ����ݳ������ͽ��й���
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
     * ���� ��Ҫ�༭�е�  ������������
     * @param e
     */
    public void setTruckFilter(IRow row){
    	
		StorageOrgUnitInfo farm = (StorageOrgUnitInfo) row.getCell("farm").getValue();
		if(farm != null && farm.getName() != null){
			String farmName = farm.getName();
			EntityViewInfo evi = new EntityViewInfo();
			FilterInfo fi = new FilterInfo();
			// ������ʾ��ɫ
			
			if(farmName.indexOf("����") >= 0 ){
				fi.getFilterItems().add(new FilterItemInfo("truckType",TruckType.ParentCK.getValue(),CompareType.EQUALS));
				row.getStyleAttributes().setBackground(Color.green);
				
			}else if (farmName.indexOf("����") >= 0){
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
     * ��ʼ������ؼ�״̬
     */
    public void initUIComponentsStates(){
    	// ��¼����������ɾ��
    	kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    	kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
    	kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	kdtEntrys_detailPanel.setTitle("�ɳ��ƻ���ϸ");
    	
    	this.btnAddLine.setVisible(false);
    	this.btnInsertLine.setVisible(false);
    	this.btnRemoveLine.setVisible(false);
    	
    	this.actionInsertLine.setVisible(false);
    	this.actionAddLine.setVisible(false);
    	this.actionRemoveLine.setVisible(false);
    	
    	kdtAssEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    	kdtAssEntrys_detailPanel.getInsertLineButton().setVisible(false);
    	kdtAssEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	kdtAssEntrys_detailPanel.setTitle("Ҫ�ϼƻ���ϸ");
    	
    	kdtTruckEntrys_detailPanel.getAddNewLineButton().setVisible(false);
    	kdtTruckEntrys_detailPanel.getInsertLineButton().setVisible(false);
    	kdtTruckEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
    	kdtTruckEntrys_detailPanel.setTitle("���쳵�������ƻ�");
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
     * ������Ǽ����������
     */
    @Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		// ����ȫ��
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		// ����ʱ��ؼ���ʾ������
		setTimeformat();
		
		if(this.getOprtState().equals("ADDNEW") && baseDataInfo != null){
			this.beginTime.setValue(baseDataInfo.getStartLoadTime());
			this.lunchBeginTime.setValue(baseDataInfo.getLunchBeginTime());
			this.lunchEndTime.setValue(baseDataInfo.getLunchEndTime());
			
			
		}
		// ���±�����ɫ
		updateAddtEntryBackGroud();
		
		// ���� ��ť�ɼ���
		// ����ؼ�״̬
        initUIComponentsStates();
        
        
        
        EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();
//		if(farmName.indexOf("����") >= 0 || farmName.indexOf("����") >= 0){
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
     * ���ý����� �ռ�Ŀɼ���  �ɲ����Ե�����
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
     * ����Ҫ�ϼƻ�������ɫ
     */
    private void updateAddtEntryBackGroud() {
		for(int i = 0 ; i < this.kdtAssEntrys.getRowCount(); i++){
			
		}
		
	}

	/**
     * ���ý��� ʱ����ʾ��ʽ
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
        // ���ý���ؼ�״̬
        setBtnState();
        
        setTruckFilter();
    }

    /**
     * �������ݺ����ù�������
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
     * �༭�¼�
     */
    @Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
    	super.actionEdit_actionPerformed(e);
    	// ���ý���ؼ�״̬
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
				// ���ý���ؼ�״̬
		        setBtnState();
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
     * ���
     */
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
			// ���ý���ؼ�״̬
	        setBtnState();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
    /**
	 * �����
	 */
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
			// ���ý���ؼ�״̬
	        setBtnState();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
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
     * Ҫ�ϼƻ� ��¼�޸�ʱ��ش���
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
				 // ���������
				 BigDecimal weightBility = potWeight.multiply(new BigDecimal(potCount));
				 
				 BigDecimal uplimit = currTruckInfo.getUplimit();
				 if(uplimit == null || uplimit.compareTo(BigDecimal.ONE) <=0 ){
					 uplimit = BigDecimal.ONE;
				 }
				 
				 BigDecimal upWeightBility = weightBility.multiply(uplimit);
				 // ������
				 BigDecimal fodderPlan = (BigDecimal) kdtAssEntrys.getCell(rowIndex,"fodderQty").getValue();
				 // �ɳ���
				 BigDecimal truckCountBD = fodderPlan.divide(upWeightBility, 0, RoundingMode.HALF_UP);
				 
				 truckCount = truckCountBD.intValue();
			 }
			  
			 
			 
			 
			 
			 kdtAssEntrys.getCell(rowIndex,"truckCount").setValue(truckCount);
			 
			 
			 // ���֮ǰͬһ�� ��
			 
		 }
		 // �ϲ��� �� ����У��
		 if("mergeTrunckNum".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
			  
			 
			 String oldValue = (String) e.getOldValue();
			 String newValue = (String) e.getValue();
			 
			 
			
				try{
					if(newValue != null){
						BigDecimal mergeBD = new BigDecimal(newValue);
						int mergeTruckNum  = mergeBD.intValue();
						
						
						if(mergeTruckNum <= 0 || mergeTruckNum > rowIndex){
							MsgBox.showInfo("���ϲ��кš�ֻ���� С�ڵ�ǰ�༭���кŵ� ������");
							kdtAssEntrys.getCell(rowIndex, colIndex).setValue(oldValue);
	//						kdtAssEntrys.getCell(rowIndex, colIndex)
							
							
							SysUtil.abort();
						}
						
						kdtAssEntrys.getCell(rowIndex,colIndex).setValue(Integer.toString(mergeTruckNum));
					}
				}catch(NumberFormatException nfe){
					MsgBox.showInfo("�ϲ����� ������кŲ��Ϸ�������������");
					kdtAssEntrys.getCell(rowIndex, colIndex).setValue(oldValue);
//					kdtAssEntrys.getCell(rowIndex, colIndex)
					
					
					SysUtil.abort();
				}
				
		 }
	}
    /**
     * ����ɳ�����б�����
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
    	super.kdtEntrys_Changed(rowIndex, colIndex);
    	
    	// 
    }
    /**
     * ����ҵ�����ڻ��Ҫ�ϼƻ� 
     */
	@Override
	public void actionGetFodderPlan_actionPerformed(ActionEvent e)
			throws Exception {
		
		Date bizDate = this.pkBizDate.getSqlDate();
		if(bizDate == null){
			MsgBox.showInfo("����ѡ��ҵ�����ڣ�ϵͳ������ѡ���ҵ�����ڻ�õ����Ҫ�ϼƻ�");
			SysUtil.abort();
		}else{
			if(kdtAssEntrys.getRowCount() > 0){
				if(MsgBox.showConfirm2("���Ҫ�ϼƻ��б����»�ȡ��") != MsgBox.OK){
					return;
				}
			}
			List<FodderPlanDetail> planDetails = TruckPlanFacadeFactory.getRemoteInstance().getFodderPlandetails(bizDate);
			// �����ʷ��¼
			kdtAssEntrys.removeRows();
			// �������Ҫ�ϼƻ� ��ȫ����ʾ�� �������б���
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
					
						
					// ���� ������������
					setTruckFilter(newRow);	
						
						
					
						
					// ������ʾ��ɫ
					if("2YC".equals(detail.getFarmType())){
						newRow.getStyleAttributes().setBackground(Color.green);
					}else if("3CD".equals(detail.getFarmType())){
						newRow.getStyleAttributes().setBackground(Color.PINK);
					}
				}
			}else{
				MsgBox.showInfo("��ҵ������û�в�ѯ��Ҫ�ϼƻ���ϸ��Ϣ");
				SysUtil.abort();
			}
		}
	}
	
	/**
	 * ���ƹ���
	 * ��ѡ��������һ��
	 */
	@Override
	protected void btnUp_actionPerformed(ActionEvent e) throws Exception {
		IRow curRow = this.getSelectedRow();
		
		
		if(curRow != null && curRow.getRowIndex() > 0){
			// ����һ��
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
	 * ���ƹ���
	 */
	@Override
	protected void btnDown_actionPerformed(ActionEvent e) throws Exception {
		IRow curRow = this.getSelectedRow();
		if(curRow != null && curRow.getRowIndex() < kdtAssEntrys.getRowCount()-1){
			// ����һ��
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
	 * ��ֹ���
	 */
	@Override
	protected void btnSplit_actionPerformed(ActionEvent e) throws Exception {
		IRow curRow = this.getSelectedRow();
		if(curRow != null){
			// ����һ�� ���� ������
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
					MsgBox.showInfo("����ά������ж�Ӧ�����ϳ��������غ� ����");
					this.kdtAssEntrys.removeRow(curRow.getRowIndex()+1);
					SysUtil.abort();
				}
				// ����������
				BigDecimal newTruckCount = splitQty.divide(truckMaxWeight, 0, RoundingMode.UP) ;
				Integer truckCountNum = newTruckCount.intValue();
				newRow.getCell("truckCount").setValue(truckCountNum);
				curRow.getCell("truckCount").setValue(truckCountNum);
			}
			
			
			newRow.getCell("fodderQty").setValue(splitQty);
			curRow.getCell("fodderQty").setValue(splitQty);
			// ���Ƶ�ǰѡ���� ������Ϣ
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
			MsgBox.showInfo("�������賵��ʱ���ܴ���null");
			SysUtil.abort();
			
		}
		if(truckInfo.getPotWeight() == null){
			truckInfo = FeedTruckFactory.getRemoteInstance().getFeedTruckInfo(new ObjectUuidPK(truckInfo.getId()));
		}
		
		
		// ��ȡ���ϳ��������
		BigDecimal maxWeight = truckInfo.getPotWeight();
		int potCount = truckInfo.getPotCount();
		
		BigDecimal truckMaxWeight = BigDecimal.ZERO;
		if(truckInfo.getUplimit() != null &&  maxWeight != null && maxWeight.compareTo(BigDecimal.ZERO) > 0 && potCount > 0){
			truckMaxWeight = maxWeight.multiply(new BigDecimal(potCount));
			// ���㳬Ƶ��Χ   Ĭ�ϳ�Ƶ����1.3
			truckMaxWeight = truckMaxWeight.multiply(truckInfo.getUplimit());
			
			BigDecimal truckCount = fodderPlanQty.divide(truckMaxWeight, 0, RoundingMode.UP);
			
			return truckCount.intValue();
			
		}else{
			MsgBox.showInfo("����ά������ж�Ӧ�����ϳ��������ء� ��������Ƶ����");
			SysUtil.abort();
		}
		
		return 0;
	}
	/**
	 * ��ȡѡ����
	 * @return
	 */
	private IRow getSelectedRow(){
		if(this.kdtAssEntrys.getSelectManager().get() != null){
			int beginRowNum = this.kdtAssEntrys.getSelectManager().get().getBeginRow();
			int endRowNum = this.kdtAssEntrys.getSelectManager().get().getEndRow();
			
			if(beginRowNum != endRowNum){
				MsgBox.showInfo("�ò���ֻ֧�ֵ��в����������ѡ");
				SysUtil.abort();
			}else{
				return this.kdtAssEntrys.getRow(beginRowNum);
			}
		}else{
			MsgBox.showInfo("��ѡ�д�������");
			SysUtil.abort();
		}
		
		return null;
	}
	
	/**
	 * �����ɳ� �ƻ�
	 */
	@Override
	public void actionGenerateTruckPlan_actionPerformed(ActionEvent e)
			throws Exception {
//		if(baseDataInfo == null){
			
//		}
		baseDataInfo = TruckPlanFacadeFactory.getRemoteInstance().getFeedFactoryBaseData();
		distanceTimesMap = TruckPlanFacadeFactory.getRemoteInstance().getDistanseSetinfo();
		// ������Ϣ
		int dotNum = baseDataInfo.getMaxEntruckCount();
		if(dotNum <= 0){
			MsgBox.showInfo("�������ϳ�������Ϣ����ά������õĴ��Ͽ�����");
			SysUtil.abort();
		}
		
		// �Ͽ��б�
		List<DischargeDotInfo> dotInfos =  new ArrayList<DischargeDotInfo>();
		for(int i = 0; i < dotNum; i++){
			DischargeDotInfo dotInfo = new DischargeDotInfo();
			dotInfo.setNum(i+1);
			
			dotInfo.setEntruckingOverTime(baseDataInfo.getStartLoadTime());
			dotInfos.add(dotInfo);
			
		}
		
		
		
		// ��������Ҫ�����detailinfosͬʱ���µ��Ͽ�ռ��ʱ��
		truckExecuteInfoMap = getfodderDetails(dotInfos);
		// ��һ������ ������ʱ�� ���� ���迼�ǻص����ϳ���ĵȴ�����ʱ��
		Set<String> keySet = truckExecuteInfoMap.keySet();
		Iterator<String> keyIte = keySet.iterator();
		// ��Ԥװ����
		Integer preN = this.txtprepackedTruckCount.getIntegerValue();
		if(preN == null){
			preN = 0;
		}
		// �ۼ���Ԥװ����
		int hasPreLoadCount = 0;
		while(keyIte.hasNext()){
			String key = keyIte.next();
			// ����һ������ʱ��
			TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(key);
			// ������Ԥװ�ĳ���  �������ʱ��
			if((++hasPreLoadCount)>preN){
				generateSendPlan(exeInfo,false,dotInfos);
			}else{
				generateSendPlan(exeInfo,true,dotInfos);
			}
		}
		
		// �ӵڶ��ֿ�ʼ ���ǵȴ�ʱ�� ������ ֱ�����мƻ�ȫ������Ϊֹ
		boolean exeEnd = false;
		while(!exeEnd){
			// �𳵽��м���TODO
			// ��ȡ���г��е�һ���ص����ϳ��ĳ�
			String latestKey = "";
			Time latestTime = null;
			Set<String> tobePlanSet = truckExecuteInfoMap.keySet();
			Iterator<String> whilekey = tobePlanSet.iterator();
			while(whilekey.hasNext()){
				String key = whilekey.next();
				
				// ����һ������ʱ��
				TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(key);
				// ����δ����� �ƻ�
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
				// �ɳ�һ��
				generateSendPlan(truckExecuteInfoMap.get(latestKey),false,dotInfos);
			}
			// ���г��ļƻ��б��Ϊ�����ɳ��ƻ������ ���� while
			int unPlanCount= 0;
			Set<String> newkeySet = truckExecuteInfoMap.keySet();
			Iterator<String> endKeySet = newkeySet.iterator();
			while(endKeySet.hasNext()){
				String key = endKeySet.next();
				// ����һ������ʱ��
				TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(key);
				
				unPlanCount = unPlanCount+ exeInfo.getToBeSolveTask().size();
				System.out.println("����"+unPlanCount+"���ƻ���δ���");
			}
			
			if(unPlanCount == 0){
				exeEnd = true;
			}else{
				unPlanCount = 0;
			}
		}
		
		
		// ȫ������� չʾ�� ����б���
		this.kdtEntrys.removeRows();
		
		// Ĭ�ϰ��� �ƻ�˳�����У���ѡ�����κ� ���ճ�������
		if(this.chkorderByTruck.isSelected()){
			Iterator<String> resultKeyIte = keySet.iterator();
			while(resultKeyIte.hasNext()){
				// ����һ������ʱ��
				TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(resultKeyIte.next());
				
				List<TruckPlanDetail> truckPlanDetails = exeInfo.getTruckPlans();
				for(int i =0; i < truckPlanDetails.size(); i++){
					IRow newPlanDetailRow = this.kdtEntrys.addRow();
					// ��ʾ�ɳ���ϸ����¼��
					showTruckPlanDetails(newPlanDetailRow,truckPlanDetails.get(i));
				}
			}
		}else{
			List<TruckPlanDetail> allTruckPlans = new ArrayList<TruckPlanDetail>();
			Iterator<String> resultKeyIte = keySet.iterator();
			while(resultKeyIte.hasNext()){
				// ����һ������ʱ��
				TruckExecuteInfo exeInfo = truckExecuteInfoMap.get(resultKeyIte.next());
				
				List<TruckPlanDetail> truckPlanDetails = exeInfo.getTruckPlans();
				allTruckPlans.addAll(truckPlanDetails);
			}
			// ����Ҫ�ϼƻ�����
			for(int i = 0; i < this.kdtAssEntrys.getRowCount(); i++){
				for(int j = 0; j < allTruckPlans.size(); j++){
					TruckPlanDetail planDetail = allTruckPlans.get(j);
					
					FodderPlanDetail fodderPlan = planDetail.getFodderPlanDetail();
					if(fodderPlan.getRowNum() == (i+1)){
						IRow newPlanDetailRow = this.kdtEntrys.addRow();
						// ��ʾ�ɳ���ϸ����¼��
						showTruckPlanDetails(newPlanDetailRow,planDetail);
						break;
					}
				}
			}
		}
	    
		
		// ��ʾ���� ִ�����
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
	 * �����ض���ʽ ��ʾ�ɳ����
	 * 
	 * 
	 * @param orderType 1�����ճ�������˳�� 2������Ҫ��˳��
	 */
	private void showResult(int orderType){
		
	}
	/**
	 * ���ɳ��ƻ���ϸ��ʾ�� ��¼����ʾ
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
	 * ����һ�ε��ɳ��ƻ���Ϣ ���Ӵ��Ͽ�ʼ�� �㵽 �ص����ϳ�Ϊֹ
	 * @param executeInfoMap
	 * @param hasPreLoaded ��ǰ�����Ѿ�Ԥװ  ���迼�� װ��ʱ��
	 * @param dotInfos ���Ͽ���Ϣ��ÿ�δ��� ���´��Ͽ� ʹ��ʱ��
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void generateSendPlan(TruckExecuteInfo executeInfo,boolean haPreLoaded,List<DischargeDotInfo> dotInfos) throws BOSException, EASBizException{
		// ����ʱ��Map
//		if(distanceTimesMap == null){
			
//		}
		if(distanceTimesMap == null || distanceTimesMap.size() == 0){
			MsgBox.showInfo("δȡ��������·��ʱ������");
			SysUtil.abort();
		}
		// �������δ ��������ϼƻ� �� ���д���Ȼ�� ��������ɵ� �ƻ��Ƴ�
		if(executeInfo.getToBeSolveTask().size() > 0){
			
			// �ɳ��ƻ���ϸ
			TruckPlanDetail newDetail = new TruckPlanDetail();
			// ��¼֮ǰ�Ƿ��Ѿ����緹
			boolean nowHasLunch = executeInfo.isHasLunched();
			// ��ʼ����ʱ��
			Time beginTime = executeInfo.getCurrTime();
			// ����Է�ʱ��
			beginTime = addLunchTimes(executeInfo, beginTime);
			
			
			
			// �������ʱ��
			Time loadEndTime = beginTime;
			if(!haPreLoaded){
				// ����ȴ�ʱ��
				beginTime = getBeginLoadTime(beginTime,dotInfos);
				// δԤװ�ĳ���  �������ʱ��
				loadEndTime = DateCommon.addMinutes(beginTime, baseDataInfo.getLoadingTimes());
				
			}
			// ����Է�ʱ��
			loadEndTime = addLunchTimes(executeInfo, loadEndTime);
			// �������ʱ��Ϊ�� ������ ��ǰװ����ʱ��    �� ��һ���뿪���ϳ�ʱ��Ϊ����ʱ��
			if(executeInfo.getBeginTime() == null){
				executeInfo.setBeginTime(loadEndTime);
			}
			
			if(!nowHasLunch && executeInfo.isHasLunched()){
				newDetail.setHaveLunch(true);
				newDetail.setLunchPlace("���ϳ�");
				executeInfo.setLunchPlace("���ϳ�");
			}
			
			Iterator<FodderPlanDetail> fodderPlanIte = executeInfo.getToBeSolveTask().iterator();
//			FodderPlanDetail planDetail = executeInfo.getToBeSolveTask().get(0);
			FodderPlanDetail planDetail = fodderPlanIte.next();
			executeInfo.getToBeSolveTask().remove(planDetail);
			
			// ����
			newDetail.setPlanSeq(planDetail.getRowNum());
			
			String farmID = planDetail.getFarmID();
			
			DistanceAndTimesInfo dtInfo = distanceTimesMap.get(FF_CONSTANTS.FF_KEY+farmID);
			if(dtInfo == null){
				StorageOrgUnitInfo farmInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(farmID));
				MsgBox.showInfo("���ϳ�����"+farmInfo.getName()+"���䳵�̻�����Ϣδ���ã�����ϵ����Ա�������ú��������ɳ�");
				SysUtil.abort();
			}
			// ����ʱ��
			int sendTimes = dtInfo.getMinutes();
			// ������ֳ��ʱ��
			Time sendArriveTime = DateCommon.addMinutes(loadEndTime,sendTimes);
			// �Ƿ��Ѿ����緹
			boolean hasLunchInFF = executeInfo.isHasLunched();
			// �Ƿ���緹
			sendArriveTime = addLunchTimes(executeInfo, sendArriveTime);
			
			FeedTruckInfo truckInfo = executeInfo.getTruckInfo();
			
			int unloadTimes = truckInfo.getUnloadTimes();
			// ж�����ʱ��
			Time unloadTime = DateCommon.addMinutes(sendArriveTime, unloadTimes);
			// �뿪��ֳ����ʱ��
			Time leaveFarmTime = addLunchTimes(executeInfo, unloadTime);
			
			newDetail.setFodderPlanDetail(planDetail);
			
			// ��֮ǰû�� ���ڳ��� ���¼
			if(!hasLunchInFF && executeInfo.isHasLunched()){
				newDetail.setHaveLunch(true);
				newDetail.setLunchPlace("��ֳ��");
				executeInfo.setLunchPlace(newDetail.getFodderPlanDetail().getFarmName());
			}
			
	
			
			newDetail.setFarmDesc(planDetail.getFarmDesc());
			newDetail.setFodderPort(planDetail.getFodderPort());
//			newDetail.setLeaveFarmTime(leaveFarmTime);
			newDetail.setBeginLoadingTime(beginTime);
			
			newDetail.setLeaveFFTime(loadEndTime);
			
			newDetail.setArriveTime(sendArriveTime);
			newDetail.setLeaveFarmTime(leaveFarmTime);
			
			// �������ϳ�ʱ������Ƿ��� һ������������еĻ���һ�������÷������ϳ�ʱ�䣬�ڶ��������� װ�����ʱ��ʹ����ϳ�����ʱ��
			
			newDetail.setTruckID(planDetail.getTruckID());
			newDetail.setTruckName(planDetail.getTruckName());
			newDetail.setTruckNumber(planDetail.getTruckNumber());
			
			newDetail.setDriverName(planDetail.getDriveName());
			newDetail.setMaterialID(planDetail.getMaterialID());
			newDetail.setMaterialName(planDetail.getMaterialName());
			newDetail.setDriverTel(planDetail.getDriveTel());
			// ����
			newDetail.setTruckSeq(executeInfo.getTruckPlans().size() + 1);
//			newDetail.set
			executeInfo.getTruckPlans().add(newDetail);
			// TODO �����Ƿ�Ҫȥ������ֳ������
			
			int currRow = planDetail.getRowNum();
			// �� �ϲ��ĳ���
			boolean hasMergeRow = generateMergeRow(newDetail,planDetail,executeInfo,currRow,leaveFarmTime,unloadTimes);
			if(!hasMergeRow){
				DistanceAndTimesInfo backdtInfo = distanceTimesMap.get(farmID+FF_CONSTANTS.FF_KEY);
				// ��÷��ص��� ���ϳ�ʱ�� 
				Time arriveFFTime = DateCommon.addMinutes(leaveFarmTime,backdtInfo.getMinutes());
				// ���÷������ϳ�ʱ��
				newDetail.setBatckToFFTime(arriveFFTime);
				// ��¼�ٴλص����ϳ�ʱ��
				executeInfo.setCurrTime(arriveFFTime);
			}
			// �Ƴ������� Ҫ�ϼƻ��������ɳ��ƻ�
//			executeInfo.getToBeSolveTask().remove(0);
			
		
		}
	}
	
	/**
	 * ���ɺϲ��е� ��¼
	 * @param executeInfo
	 * @param haPreLoaded
	 * @param dotInfos
	 * @return �Ƿ���� ������ �ϲ�����
	 */
	private boolean generateMergeRow(TruckPlanDetail currTruckPDetail,FodderPlanDetail currPplanInfo,TruckExecuteInfo executeInfo,int currRow,Time leaveCurrFarmTime,int unloadTimes){
		boolean hasMergeRow = false;
		// ѭ�������Ե�ǰ����Ϊ ǰ�򳵴ε� ����������
		Iterator<FodderPlanDetail> allPlanIte = executeInfo.getToBeSolveTask().iterator();
		while(allPlanIte.hasNext()){
			FodderPlanDetail planInfo = allPlanIte.next();
			int mergeNum = planInfo.getMergeTruckRowNum();
			if(currRow == mergeNum){
				// ɾ����ǰ�Ѵ�������
//				allPlanIte.remove();
				executeInfo.getToBeSolveTask().remove(planInfo);
				// �Ƿ��кϲ���
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
					// ��ֳ����·�� ·��
					toOtherFarmInfo = distanceTimesMap.get(currPplanInfo.getFarmID() + nextFarm.getId().toString());
					if(toOtherFarmInfo == null){
						MsgBox.showInfo("��ֳ����"+currPplanInfo.getFarmName()+"���롾"+nextFarm.getName()+"����·��ʱ��δ���ã������ú��ٽ����ɳ�");
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
				// ����һ���ɳ��ƻ�
				TruckPlanDetail toFarmDetail = new TruckPlanDetail();

				toFarmDetail.setFodderPlanDetail(planInfo);
				// �볧ǰ��¼�Ƿ��Ѿ����緹
				boolean hasLunch = executeInfo.isHasLunched();
				// ����ڶ�����ʱ��
				Time arriveNewFarmTime = DateCommon.addMinutes(leaveCurrFarmTime,toOtherFarmInfo.getMinutes());
				
				arriveNewFarmTime = addLunchTimes(executeInfo, arriveNewFarmTime);
				
				// ��õڶ������������ʱ��
				Time leaveNewFarmTimeTime = arriveNewFarmTime;
				if(!currPplanInfo.getFarmID().equals(nextFarm.getId().toString())){
					// �������ͬһ������ �����ۼ� ж��ʱ��
					leaveNewFarmTimeTime = DateCommon.addMinutes(arriveNewFarmTime,unloadTimes);
				}
				leaveNewFarmTimeTime = addLunchTimes(executeInfo, leaveNewFarmTimeTime);
				// ���µ�ǰ����ʱ��
				executeInfo.setCurrTime(leaveNewFarmTimeTime);
				
				
				if(!hasLunch && executeInfo.isHasLunched()){
					toFarmDetail.setHaveLunch(true);
					toFarmDetail.setLunchPlace("��ֳ��");
					executeInfo.setLunchPlace(toFarmDetail.getFodderPlanDetail().getFarmName());
				}
				// �ӵڶ������������ϳ�ʱ��
				DistanceAndTimesInfo backFFFromNextFarm = distanceTimesMap.get(nextFarm.getId().toString() + FF_CONSTANTS.FF_KEY);
				if(backFFFromNextFarm == null){
					MsgBox.showInfo("��ֳ����"+nextFarm.getName()+"�������ϳ���·��ʱ��δ���ã������ú��ٽ����ɳ�");
					SysUtil.abort();
				}
			
				
				// ����
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
				
				// ����
				currTruckPDetail.setTruckSeq(executeInfo.getTruckPlans().size() + 1);
//				newDetail.set
				executeInfo.getTruckPlans().add(toFarmDetail);
				
				int nowCurrRow = planInfo.getRowNum();
				// ���� ���¸�����
				boolean hasnewMergeRow = generateMergeRow(toFarmDetail,planInfo,executeInfo,nowCurrRow,leaveNewFarmTimeTime,unloadTimes);
				if(!hasnewMergeRow){
					// ���շ��ص����ϳ�ʱ��
					Time backToFFTime = DateCommon.addMinutes(leaveNewFarmTimeTime,backFFFromNextFarm.getMinutes());
					
					toFarmDetail.setBatckToFFTime(backToFFTime);
					
					// ��¼�ٴλص����ϳ�ʱ��
					executeInfo.setCurrTime(backToFFTime);
				}
				
				
			}
		}
		
		
		return hasMergeRow;
	}
	/**
	 * ���ݴ��Ͽڽ����Ŷ� Ĭ�������Ͽ� ֧������ ���ϴ���
	 * 
	 * @param truckLoadTime
	 * @param dotInfos
	 * @return
	 */
	private Time getBeginLoadTime(Time truckLoadTime,List<DischargeDotInfo> dotInfos){
		DischargeDotInfo loadDot = null;
		// �ҳ� �Ͽ����ȿճ����� һ��
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
		// ���ȿճ������Ͽ� �����ϳ���λʱ��Ƚ�  ȡ �Ͽ���һ�� Ϊ��ʼ����ʱ��;
		if(loadDot.getEntruckingOverTime().after(truckLoadTime)){
			
			truckLoadTime = loadDot.getEntruckingOverTime();
			
			
			
		}
		// ͬʱ���¸��Ͽ��´οճ���ʱ��
		loadDot.setEntruckingOverTime(DateCommon.addMinutes(truckLoadTime, baseDataInfo.getLoadingTimes()));
		
		return truckLoadTime;
	}
	
	/**
	 * ��ӳԷ�ʱ��
	 * @param nowTime
	 */
	private Time addLunchTimes(TruckExecuteInfo executeInfo,Time nowTime){
		// û�а��ųԷ� ���� ��ǰִ��ʱ����  ���ϳ����õķ���ʱ������ �� ��ʱ������ϳԷ�ʱ��
		Time lunchBeginTime = this.lunchBeginTime.getSqlTime();
		Time lunchEndTime = this.lunchEndTime.getSqlTime();
		if(lunchBeginTime == null || lunchEndTime == null){
			MsgBox.showInfo("�緹��ʼʱ����緹����ʱ�䲻��Ϊ��");
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
	 * ��ȡҪ�ϼƻ�  ��  ���ϳ�������Ϣ������� δ���ŵ�����ʾ�Ƿ���� ������� ����δ���ŵļ���
	 * @param dotInfos ���Ͽ��б�  �ڻ�ȡҪ�ϼƻ�ʱ �����Ͽ� ��ռ��ʱ��ͬ������
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private LinkedHashMap<String,TruckExecuteInfo> getfodderDetails(List<DischargeDotInfo> dotInfos) throws EASBizException, BOSException {
		// map��ʼ�� Key  towerID 
        fordderPlanMap = new LinkedHashMap<String, FodderPlanDetail>();
        // �������е�ִ�����map 
        truckExecuteInfoMap = new LinkedHashMap<String, TruckExecuteInfo>();

        materialMap = new HashMap<String, MaterialInfo>();
        towerMap = new HashMap<String, WarehouseInfo>();
        farmMap = new HashMap<String, StorageOrgUnitInfo>();
        truckMap = new HashMap<String, FeedTruckInfo>();
        
        // ������Ϣ
        Time beginTime = this.beginTime.getSqlTime();
        
        int hour = beginTime.getHours();
        int minutes = beginTime.getMinutes();
        
        beginTime = new Time(hour,minutes,0);
        if(beginTime == null){
        	MsgBox.showInfo("�������ÿ�ʼ����ʱ��");
        	SysUtil.abort();
        }
        // ���δ���ʱ��
        int loadingTimes = baseDataInfo.getLoadingTimes();
        // ͬʱ���ϳ���
        int m = baseDataInfo.getMaxEntruckCount();
        // ��ʱ��¼�Ѵ��ϳ�������������г���ʼ����ʱ�䣬����ʼ����ʱ��
        int n = 0;
        // �������Σ� ����ǰ�������ڵ�һ��  �������� ���ڵڶ���  һ������
        int j = 1;
        // ��Ԥװ����
        Integer preN = this.txtprepackedTruckCount.getIntegerValue();
        if(preN == null){
        	preN = Integer.valueOf(0);
        }
        
		for(int i = 0; i < this.kdtAssEntrys.getRowCount(); i++){
			IRow row = kdtAssEntrys.getRow(i);
			
			boolean isIgnore =  (Boolean) row.getCell("isIgnore").getValue();
			// �����Ե��в���Ϊ �ɳ�����
			if(!isIgnore){
				
				// ��ȡҪ�ϼƻ���ϸ �ͳ��μ�   һ���ೡ������
				FodderPlanDetail fodderPlanDetail = this.getRowFodderPlandetail(row, i+1);
				fordderPlanMap.put(fodderPlanDetail.getTowerID(), fodderPlanDetail);
				
				// ����� ����Ӷ�Ӧplandetail
				if(truckExecuteInfoMap.containsKey(fodderPlanDetail.getTruckNumber())){
					truckExecuteInfoMap.get(fodderPlanDetail.getTruckNumber()).getToBeSolveTask().add(fodderPlanDetail);
				}else{
					TruckExecuteInfo executeInfo = new TruckExecuteInfo();
					// ���ϳ���Ϣ����
					FeedTruckInfo truckInfo = (FeedTruckInfo) row.getCell("truck").getValue();
					truckInfo = FeedTruckFactory.getRemoteInstance().getFeedTruckInfo(new ObjectUuidPK(truckInfo.getId()));
					executeInfo.setTruckInfo(truckInfo);
					executeInfo.getToBeSolveTask().add(fodderPlanDetail);
					executeInfo.setTruckID(fodderPlanDetail.getTruckID());
					executeInfo.setTruckName(fodderPlanDetail.getTruckName());
					executeInfo.setTruckNumber(fodderPlanDetail.getTruckNumber());
					
					executeInfo.setCurrPosition("���ϳ�");
					executeInfo.setCurrPositionID(null);
					
					// ���㿪ʼ����ʱ��
					n++;
					if(((j*m)-(n-preN))<0){
						j++;
					}
					
					int addTimes = (j-1)*loadingTimes;
					
					
					// ���ó�ʼ����ʱ��
					Time beginLoadTime = DateCommon.addMinutes(beginTime, addTimes);
					
					executeInfo.setCurrTime(beginLoadTime);
	//				executeInfo.setBeginTime(beginLoadTime);
					truckExecuteInfoMap.put(fodderPlanDetail.getTruckNumber(), executeInfo);
					
				}
			}
			
			////////��֯ detailinfo
			
			
		}
		
		return truckExecuteInfoMap;
	}

    
    /**
     * ��ָ���� Ҫ�ϼƻ���¼�л�ȡ Ҫ�ϼƻ���ϸ
     * У�� �����Ƿ��Ѿ����ã�ǰ�����뵱ǰ�� �����Ƿ�һ��
     * @param row
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
    private FodderPlanDetail getRowFodderPlandetail(IRow row,int rowNumber) throws EASBizException, BOSException{

    	FodderPlanDetail newDetailInfo = new FodderPlanDetail();
    	// �к�
    	newDetailInfo.setRowNum(rowNumber);
		// ��ֳ��
		StorageOrgUnitInfo farm = (StorageOrgUnitInfo) row.getCell("farm").getValue();
		// ����
		WarehouseInfo tower = (WarehouseInfo) row.getCell("tower").getValue();
		
		MaterialInfo materialInfo = (MaterialInfo) row.getCell("material").getValue();
		// ���ϳ�
		FeedTruckInfo truckInfo = (FeedTruckInfo) row.getCell("truck").getValue();
		if(truckInfo == null){
			MsgBox.showInfo("��"+(row.getRowIndex()+1)+"�г���δ����");
			
			SysUtil.abort();
		}
		
		// ʣ����
		BigDecimal inventory = (BigDecimal)row.getCell("inventory").getValue();
		// Ҫ����
		BigDecimal fodderQty = (BigDecimal)row.getCell("fodderQty").getValue();
		
		// ���賵��
		Integer truckCount = (Integer)row.getCell("truckCount").getValue();
		if(truckCount == null){
			truckCount = 0;
		}
		
		
		String farmDesc = (String) row.getCell("farmDesc").getValue();
		
		String fodderPort = (String) row.getCell("fodderPort").getValue();
		
		
		// �ϲ���
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
			MsgBox.showInfo("�ϲ����� ������кŲ��Ϸ�������������");
			SysUtil.abort();
		}
		
		if(mergeTruckNum == null){
			mergeTruckNum = 0;
		}
		if(mergeTruckNum < 0){
			MsgBox.showInfo("�ϲ��в���С��0");
			SysUtil.abort();
		}
		
			
		if(mergeTruckNum > 0){	
			// У����ϲ��� ���������Ƿ�һ�� 
			if(mergeTruckNum >= rowNumber){
				MsgBox.showInfo("ֻ������Լ��к�С��Ҫ�ϼƻ��кϲ�");
				SysUtil.abort();
			}
			
			if(mergeTruckNum > this.kdtAssEntrys.getRowCount()){
				MsgBox.showInfo("�ϲ��кŲ��ܴ���������");
				SysUtil.abort();
			}
			FeedTruckInfo mergeTruckInfo = (FeedTruckInfo) this.kdtAssEntrys.getRow(mergeTruckNum-1).getCell("truck").getValue();
			
			
			
			// �ϲ��в���Ϊ��
			if(mergeTruckInfo == null){
				MsgBox.showInfo("�ϲ������ϳ�����Ϊ��");
				SysUtil.abort();
			}
			
			if(!truckInfo.getId().toString().equals(mergeTruckInfo.getId().toString())){
				MsgBox.showInfo("�ϲ������ϳ�������ͬ");
				SysUtil.abort();
			}
			
			
			StorageOrgUnitInfo farmInfo = (StorageOrgUnitInfo) this.kdtAssEntrys.getRow(mergeTruckNum-1).getCell("farm").getValue();
			
				if(rowNumber - mergeTruckNum  != 1){
					MsgBox.showInfo("�ϲ��б���Ϊ������ ");
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
		
		// ��ֳ��
		newDetailInfo.setFarmID(farm.getId().toString());
		newDetailInfo.setFarmNumber(farm.getNumber());
		newDetailInfo.setFarmName(farm.getName());
		if(farm.getName().indexOf("����")>=0){
			newDetailInfo.setFarmType("2YC");
		}else if(farm.getName().indexOf("����")>=0){
			newDetailInfo.setFarmType("3CD");
		}else{
			newDetailInfo.setFarmType("1CC");
		}
		
		// ����
		newDetailInfo.setTowerID(tower.getId().toString());
		newDetailInfo.setTowerNumber(tower.getNumber());
		newDetailInfo.setTowerName(tower.getName());
		// ����
		newDetailInfo.setMaterialID(materialInfo.getId().toString());
		newDetailInfo.setMaterialModel(materialInfo.getModel());
		newDetailInfo.setMaterialName(materialInfo.getName());
		newDetailInfo.setMaterialNumber(materialInfo.getNumber());
		
		// ���ϳ�
		newDetailInfo.setTruckID(truckInfo.getId().toString());
		newDetailInfo.setTruckNumber(truckInfo.getNumber());
		newDetailInfo.setTruckName(truckInfo.getName());
		
		newDetailInfo.setDriveTel(truckInfo.getDriverTel());
		if(driver != null){
			newDetailInfo.setDriveName(driver.getName());
		}
		
		newDetailInfo.setFarmDesc(farmDesc);
		newDetailInfo.setFodderPort(fodderPort);
		// ������Ϣ
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
	        MsgBox.showWarning("���ȱ��浥��,�ٵ��ӡ!");  
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
	        MsgBox.showWarning("���ȱ��浥��,�ٵ��ӡ!");  
	    }  
	}
    
    
  
}