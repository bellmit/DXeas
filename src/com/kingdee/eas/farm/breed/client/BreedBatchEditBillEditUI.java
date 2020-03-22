/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;
import java.util.EventListener;

import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.ChikenType;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.ParentBreedBatch;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class BreedBatchEditBillEditUI extends AbstractBreedBatchEditBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BreedBatchEditBillEditUI.class);
    
    /**
     * output class constructor
     */
    public BreedBatchEditBillEditUI() throws Exception
    {
        super();
        // ͼ������
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
//    	this.prmtbreedBatch.removeDataChangeListener(listener)
    	ChangeListener[] cLs = this.prmtbreedBatch.getChangeListeners();
    	for(int i = 0; i < cLs.length; i++){
    		ChangeListener cl = cLs[i];
    		this.prmtbreedBatch.removeChangeListener(cl);
    	}
        super.loadFields();
        for(int i = 0; i < cLs.length; i++){
    		ChangeListener cl = cLs[i];
    		this.prmtbreedBatch.addChangeListener(cl);
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
        return com.kingdee.eas.farm.breed.BreedBatchEditBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.breed.BreedBatchEditBillInfo objectValue = new com.kingdee.eas.farm.breed.BreedBatchEditBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        objectValue.setStoOrg(SysContext.getSysContext().getCurrentStorageUnit());
        objectValue.setBizDate(new Date());
        return objectValue;
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
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	/**
	 * �ύǰУ��
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{
				// У��
//				beforeStoreFields(e);
				
				ParentBreedBatchInfo breedBatchInfo = (ParentBreedBatchInfo) this.prmtbreedBatch.getValue();
				
				HenhouseType selHenhouseType = breedBatchInfo.getHenhouseType();
				
				for(int i = 0; i < this.kdtEntrys.getRowCount(); i++){
					ChikenType currChikenType = (ChikenType) this.kdtEntrys.getCell(i, "chikenType").getValue();
					
					//  ��Ʒ����¼���� �������ڡ�����������Ϊ��
					if(HenhouseType.CC.equals(selHenhouseType) ){
						if(!ChikenType.CommecialChiken.equals(currChikenType)){
							MsgBox.showInfo("��ǰ�༭����Ϊ��Ʒ�����Σ�������ݷ�¼�����ֻ��Ϊ��Ʒ��");
							SysUtil.abort();
						}
					}else if(HenhouseType.Brood.equals(selHenhouseType)){
						if(!ChikenType.BroodCock.equals(currChikenType) && !ChikenType.BroodHen.equals(currChikenType)){
							MsgBox.showInfo("��ǰ�༭����Ϊ���ɼ����Σ�������ݷ�¼�����ֻ��Ϊ���ɹ�����������ĸ��");
							SysUtil.abort();
						}
					}else if(HenhouseType.LayEgg.equals(selHenhouseType)){
						if(!ChikenType.LayeggHen.equals(currChikenType) && !ChikenType.LayeggCock.equals(currChikenType)){
							MsgBox.showInfo("��ǰ�༭����Ϊ���������Σ�������ݷ�¼�����ֻ��Ϊ�����������߲���ĸ��");
							SysUtil.abort();
						}
					}
				}
				super.actionSubmit_actionPerformed(e);
				
			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}
			
			
		}else{
			MsgBox.showWarning("ֻ���ύδ��˵�����");
			SysUtil.abort();
		}
		
	}
	/**
	 * ��ʼ��
	 */
	@Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		// ����ȫ��
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		//f7Init();

		// ���ü������
//		setHenhouseType(null);
		// ���ù�������
		setHenhouseFilter(null);
		
		if("ADDNEW".equals(this.getOprtState())){
			this.baseStatus.setSelectedIndex(1);
		}
		
		
		this.prmtbreedBatch.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtbreedBatch_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
	}
	
	
	/**
     * f7��ʼ��
     */
    private void f7Init(){
    	
      
    	this.prmtbreedBatch.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchF7Query");	
        EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
        filter.getFilterItems().add(new FilterItemInfo("CU.id",cuInfo.getId().toString(),CompareType.EQUALS));
        // ����Ĭ�ϵ�ǰ�����֯���м�����Ϣ
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filter.getFilterItems().add(new FilterItemInfo("stoOrg.id",currStorageOrgInfo.getId().toString(),CompareType.EQUALS));
        
        filter.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.LayEgg.getValue(),CompareType.NOTEQUALS));
        
        evi.setFilter(filter);
        this.prmtbreedBatch.setEntityViewInfo(evi);
        
    }
	
	/**
	 * ��ֳ���α��
	 */
	protected void prmtbreedBatch_dataChanged(DataChangeEvent e)
			throws Exception {
		ParentBreedBatchInfo breedBatchInfo = (ParentBreedBatchInfo)  e.getNewValue();;
		if(breedBatchInfo != null){
			ParentBreedBatchInfo oldBatchInfo  = (ParentBreedBatchInfo) e.getOldValue();
			HenhouseType selHenhouseType = breedBatchInfo.getHenhouseType();
			// �����¼
//			this.kdtEntrys.removeRows();
//			this.editData.getEntrys().clear();
			
			// �������ѡ��
//			setHenhouseType(selHenhouseType);
			// ���÷�¼��������
			setHenhouseFilter(selHenhouseType);
		}else{
			// ���� ��¼
//			this.kdtEntrys.removeRows();
//			this.editData.getEntrys().clear();
			// ���÷�¼��������
			setHenhouseFilter(null);
		}
	}
	/**
     * ���ü����������
     */
	private void setHenhouseFilter(HenhouseType selHenhouseType){
	
		
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        if(selHenhouseType != null){
        	filter.getFilterItems().add(new FilterItemInfo("houseType",selHenhouseType.getValue(),CompareType.EQUALS));
      
		}
        StorageOrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filter.getFilterItems().add(new FilterItemInfo("chickenFarm.id",cuInfo.getId().toString(),CompareType.EQUALS));
		
        evi.setFilter(filter);
		final KDBizPromptBox kdtEntrys_henHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henHouse_PromptBox.setVisible(true);
        kdtEntrys_henHouse_PromptBox.setEditable(true);
        kdtEntrys_henHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setCommitFormat("$number$");
        //kdtEntrys_henHouse_PromptBox.setEntityViewInfo(evi);
        KDTDefaultCellEditor kdtEntrys_henHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouse_PromptBox);
        this.kdtEntrys.getColumn("henHouse").setEditor(kdtEntrys_henHouse_CellEditor);
        ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
        kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henHouse").setRenderer(kdtEntrys_henHouse_OVR);
			
			
	       
		
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
			if(MsgBox.showConfirm2("���ε�������˺󣬵������ݽ���Ϊ��ͬ����������ͬ�������Ƿ�ȷ����ˣ�") == MsgBox.YES){
				super.actionAudit_actionPerformed(e);
				MsgBox.showWarning("������");
				reloadData();
			}
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	
	/**
	 * 
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
    	
    	
	    if ("henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henHouse").getValue(),"name")));
		}


    }
}