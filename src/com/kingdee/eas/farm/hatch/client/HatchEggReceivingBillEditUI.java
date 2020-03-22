/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
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
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.Farm;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class HatchEggReceivingBillEditUI extends AbstractHatchEggReceivingBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(HatchEggReceivingBillEditUI.class);
    
    /**
     * output class constructor
     */
    public HatchEggReceivingBillEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }
    

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
//    	if(!editData.getBaseStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)&&!editData.getBaseStatus().equals(com.kingdee.eas.farm.hatch.billStatus.save))
//			return;
//    	
    	if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
		{
		MsgBox.showWarning("��ǰ״̬�µĵ��ݽ�ֹ�༭");
		abort();
		}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
		{
		MsgBox.showWarning("��ǰ״̬�µĵ��ݽ�ֹɾ��");
		abort();
		}
    	super.actionRemove_actionPerformed(e);
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
        com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo objectValue = new com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        objectValue.setEggSourceType(com.kingdee.eas.farm.hatch.EggSourceType.InternalFarm);
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        objectValue.setBizDate(new Date());  
        
        return objectValue;
    }
    
    /**
     * ҳ���ʼ��
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// ����ȫ��
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		// ��ʼ�� ��¼��������
		initEntrysFilter();
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			this.btnAddLine.setEnabled(false);
			this.btnRemoveLine.setEnabled(false);
			this.btnInsertLine.setEnabled(false);
		}
		// ��Դ����ɾ�� ����
		this.EggSourceType.removeItem(com.kingdee.eas.farm.hatch.EggSourceType.SubContract);
		//���ݿ����֯���˵���
		this.prmtkczz.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				StorageOrgUnitInfo info= (StorageOrgUnitInfo) prmtkczz.getValue();
	    		EntityViewInfo view = new EntityViewInfo();
	    		FilterInfo filterInfo = new FilterInfo();
	    		filterInfo.getFilterItems().add(new FilterItemInfo("storageOrg.id",info.getId().toString(),CompareType.EQUALS));   		
	    		view.setFilter(filterInfo);
	    		filterInfo.getFilterItems().add(new FilterItemInfo("WHSTATE", "1",CompareType.EQUALS)); 
	    		filterInfo.setMaskString("#0 and #1");
	    		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntrys.getColumn("eggWarehouse").getEditor().getComponent(); 
	    		prmtPost.setEntityViewInfo(view);
			}});
		
		//StorageOrgUnitInfo info1= (StorageOrgUnitInfo) prmtkczz.getValue();
		EntityViewInfo view1 = new EntityViewInfo();
		FilterInfo filterInfo1 = new FilterInfo();
		filterInfo1.getFilterItems().add(new FilterItemInfo("name","�ּ�%",CompareType.LIKE));   		
		view1.setFilter(filterInfo1);
		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntrys.getColumn("stockingFarmer").getEditor().getComponent(); 
		prmtPost.setEntityViewInfo(view1);
		
		KDBizPromptBox prmtPost1 = (KDBizPromptBox) kdtEntrys.getColumn("stockingFarm").getEditor().getComponent(); 
		prmtPost1.setEntityViewInfo(view1);
		
		this.btnTraceUp.setVisible(true);
		this.btnTraceDown.setVisible(true);
		this.btnCopy.setVisible(false);
		this.btnEdit.setEnabled(true);
		
		
	}
    
	/**
	 * ����
	 */
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		reloadData();
	}
	/**
	 * �ύ
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(arg0);
	}
	/**
	 * ���
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�ٴ���ˣ�");
			SysUtil.abort();
		}
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("������δ�ύ����ֹ��ˣ�");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		this.setMessageText("���ͨ��");
		this.showMessage();
		lockUIForViewStatus();
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		reloadData();		
	}
	
	/**
	 * �����
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("������δ��ˣ���ֹ����ˣ�");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.setMessageText("�����ͨ��");
		this.showMessage();
		this.btnEdit.setEnabled(true);
		reloadData();
	}

	/**
	 * ���ص�������
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws Exception
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
	 * �ֵ���Դ����
	 */
	@Override
	protected void EggSourceType_actionPerformed(ActionEvent e)
			throws Exception {
		
		EggSourceType sourceType = (EggSourceType) this.EggSourceType.getSelectedItem();
		if(sourceType == null){
			MsgBox.showInfo("��Դ���Ͳ���Ϊ��");
			SysUtil.abort();
		}
		if(com.kingdee.eas.farm.hatch.EggSourceType.InternalFarm.equals(sourceType)){
			this.kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(true);
			//this.kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(false);
			//this.kdtEntrys.getColumn("internalBreedingBatch").getStyleAttributes().setHided(false);
			//this.kdtEntrys.getColumn("henhouse").getStyleAttributes().setHided(false);
			//this.kdtEntrys.getColumn("internalEggBatch").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("sendDate").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("sendQty").getStyleAttributes().setHided(false);
			
			this.kdtEntrys.getColumn("stockingFarmer").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("stockingFarm").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("stockingHouse").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(false);
		}else if(com.kingdee.eas.farm.hatch.EggSourceType.Purchase.equals(sourceType)){
			this.kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("internalBreedingBatch").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("henhouse").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("internalEggBatch").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("sendDate").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("sendQty").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("stockingFarmer").getStyleAttributes().setHided(true);
			
			this.kdtEntrys.getColumn("stockingFarm").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("stockingHouse").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(true);
			
			
			
			
		}else if(com.kingdee.eas.farm.hatch.EggSourceType.SubContract.equals(sourceType)){
			MsgBox.showInfo("�ݲ�֧�ַ����ֵ����գ���ӷ���ҵ��ģ�����");
			SysUtil.abort();
		}
	}
	/**
	 * ҵ�����ڱ仯
	 */
	@Override
	protected void pkBizDate_dataChanged(DataChangeEvent e) throws Exception {
		
		super.pkBizDate_dataChanged(e);
	}
	/**
	 * �������仯
	 */
	@Override
	protected void prmthatchFactory_dataChanged(DataChangeEvent e)
			throws Exception {
		
		super.prmthatchFactory_dataChanged(e);
	}
    /**
     * ��ʼ�� ת����¼ ��������
     */
    private void initEntrysFilter(){
    	// ��ֳ������
    	
    	// ��ֳ����
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(cuInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("CU.id",cuInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("CU.id","",CompareType.EQUALS));
		}
		view.setFilter(filterInfo);
		
		final KDBizPromptBox batch_Prompt = new KDBizPromptBox();
        batch_Prompt.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
        batch_Prompt.setVisible(true);
        batch_Prompt.setEditable(true);
        batch_Prompt.setDisplayFormat("$number$");
        batch_Prompt.setEditFormat("$number$");
        batch_Prompt.setCommitFormat("$number$");
        batch_Prompt.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(batch_Prompt);
        
        
        // ��ֳ����������
        this.kdtEntrys.getColumn("internalFarm").setEditor(kdtEntrys_henhouse_CellEditor);
        
        // ���� ����
        updateEntryBatchFilter(null, null,  "internalBreedingBatch");
        // ���� ����
        updateEntryHenhouseFilter(null, null,  "henhouse");
        
       
    }
    
    /**
     * ���� ������������ ���ι�������
     * @param row
     * @param farm
     * @param batchInfo
     * @param fieldName
     */
    private void updateEntryBatchFilter(IRow row,
    		BreedStoorgSetInfo farm, 
    		String fieldName){
    	

   	 // ������ӹ�������
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(farm != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id",farm.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id","",CompareType.EQUALS));
		}
		
		
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%����%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_batch_PromptBox = new KDBizPromptBox();
       kdtEntrys_batch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7ParentBreedBatchQuery");
       kdtEntrys_batch_PromptBox.setVisible(true);
       kdtEntrys_batch_PromptBox.setEditable(true);
       kdtEntrys_batch_PromptBox.setDisplayFormat("$number$");
       kdtEntrys_batch_PromptBox.setEditFormat("$number$");
       kdtEntrys_batch_PromptBox.setCommitFormat("$number$");
       kdtEntrys_batch_PromptBox.setEntityViewInfo(view);
       KDTDefaultCellEditor kdtEntrys_batch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batch_PromptBox);

       if(row == null){
       	this.kdtEntrys.getColumn(fieldName).setEditor(kdtEntrys_batch_CellEditor);
       }else{
       	row.getCell(fieldName).setEditor(kdtEntrys_batch_CellEditor);
       }
    	
    }
    
    /**
     * ���� ������������ �����������
     * @param row
     * @param farm
     * @param batchInfo
     * @param fieldName
     */
    private void updateEntryHenhouseFilter(IRow row,
    		BreedStoorgSetInfo farm, 
    		String fieldName){
    	
    	
    	 // ������ӹ�������
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(farm != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id",farm.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id","",CompareType.EQUALS));
		}
		
		
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%����%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henhouse_PromptBox.setVisible(true);
        kdtEntrys_henhouse_PromptBox.setEditable(true);
        kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);

        if(row == null){
        	this.kdtEntrys.getColumn(fieldName).setEditor(kdtEntrys_henhouse_CellEditor);
        }else{
        	row.getCell(fieldName).setEditor(kdtEntrys_henhouse_CellEditor);
        }
        
    }
	/**
	 * ��¼�༭ �¼�
	 */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    	int rowIndex = e.getRowIndex();
    	int colIndex = e.getColIndex();
    	
    	// 
    	IRow row = this.kdtEntrys.getRow(rowIndex);
    	if(colIndex == kdtEntrys.getColumnIndex("internalBreedingBatch")){
    		ParentBreedBatchInfo batchInfo = (ParentBreedBatchInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();
    		BreedStoorgSetInfo fromFarm = null;
    		if(batchInfo != null){
    			fromFarm = batchInfo.getFarm();
    		}
    		// �������
    		updateEntryHenhouseFilter(row, fromFarm,  "henhouse");
    		
    		
    	}else if(colIndex == kdtEntrys.getColumnIndex("internalFarm")){
    		BreedStoorgSetInfo farm = (BreedStoorgSetInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();
    	
    		// ���ι���
    		updateEntryBatchFilter(row, farm,  "internalBreedingBatch");
    		
    	}
    	if(kdtEntrys.getColumnKey(colIndex).equals("stockingFarm")){
    		if(kdtEntrys.getCell(rowIndex, "stockingFarm").equals(null)){
    			
    		}else{
    			FarmInfo farm =  (FarmInfo) kdtEntrys.getCell(rowIndex, "stockingFarm").getValue();
        		EntityViewInfo view = new EntityViewInfo();
        		FilterInfo filterInfo = new FilterInfo();
        		filterInfo.getFilterItems().add(new FilterItemInfo("farm.name",farm.getName(),CompareType.EQUALS));   		
        		view.setFilter(filterInfo);
        		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntrys.getColumn("stockingBatch").getEditor().getComponent(); 
        		prmtPost.setEntityViewInfo(view);
        		
        		FilterInfo filterInfo1 = new FilterInfo();
        		filterInfo1.getFilterItems().add(new FilterItemInfo("name","%"+farm.getName()+"%",CompareType.LIKE));
        		EntityViewInfo view1 = new EntityViewInfo();
        		view1.setFilter(filterInfo1);
        		KDBizPromptBox prmtPost1 = (KDBizPromptBox) kdtEntrys.getColumn("stockingHouse").getEditor().getComponent(); 
        		prmtPost1.setEntityViewInfo(view1);
	
    		}
    		
    		
    	}
    	
    	if(kdtEntrys.getColumnKey(colIndex).equals("stockingFarmer")){
    		if(kdtEntrys.getCell(rowIndex, "stockingFarmer").equals(null)){
    			
    		}else{
    			FarmersInfo farm =  (FarmersInfo) kdtEntrys.getCell(rowIndex, "stockingFarmer").getValue();
        		EntityViewInfo view = new EntityViewInfo();
        		FilterInfo filterInfo = new FilterInfo();
        		filterInfo.getFilterItems().add(new FilterItemInfo("name",farm.getName(),CompareType.EQUALS));   		
        		view.setFilter(filterInfo);
        		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntrys.getColumn("stockingFarm").getEditor().getComponent(); 
        		prmtPost.setEntityViewInfo(view);
    		}
    		
    		
    	}
    	
    	
    	
    	
    	//yumignxu  20180830
		//BigDecimal runQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"runQty").getValue());
		BigDecimal qcEggQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"quaEggQty").getValue());
		BigDecimal smallEggQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"quaSmaallEggQty").getValue());
		BigDecimal ccd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"weakEggQty").getValue());
		BigDecimal jxd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"mutanEggQty").getValue());
		BigDecimal shd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"doubleYolkQty").getValue());
		BigDecimal zd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"zd").getValue());
		BigDecimal rd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"rd").getValue());
		BigDecimal dpd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"brokenEggQty").getValue());
		BigDecimal pd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"xpd").getValue());
		BigDecimal fxd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"fxd").getValue());
		BigDecimal allQty = qcEggQty.add(smallEggQty).add(ccd).add(jxd).add(shd).add(zd).add(rd).add(dpd).add(pd).add(fxd).add(BigDecimal.ZERO);
		kdtEntrys.getCell(e.getRowIndex(), "reQty").setValue(allQty);	
		BigDecimal diffQty = BigDecimal.ZERO;
		if(kdtEntrys.getCell(e.getRowIndex(),"sendQty").equals(null)){
			
		}else{
			diffQty = allQty.subtract(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"sendQty").getValue()));
		}
		kdtEntrys.getCell(e.getRowIndex(), "cys").setValue(diffQty);
    	
    	
    	
    	
    }
    
}