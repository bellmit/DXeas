/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseCollection;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.IparentFacade;
import com.kingdee.eas.farm.breed.ParentBreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.ParentBreedBatchFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.breed.parentFacadeFactory;
import com.kingdee.eas.farm.breed.comm.ExecBotpResultInfo;
import com.kingdee.eas.farm.breed.comm.ParentBreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.comm.ParentBreedBatchEntryDetailInfo;
import com.kingdee.eas.farm.breed.layegg.EggConveyorInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyAssEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyCullDeathEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyLayEggEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggFacadeFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggHouseSetEntryCollection;
import com.kingdee.eas.farm.breed.layegg.LayEggHouseSetEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggHouseSetInfo;
import com.kingdee.eas.framework.client.CoreBillEditUI;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.IInventory;
import com.kingdee.eas.scm.im.inv.InventoryFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class LayEggDailyEditUI extends AbstractLayEggDailyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(LayEggDailyEditUI.class);
    // ��ǰ���μ��ڵ���� ��ϸ��Ϣ
    private Map<String,ParentBreedBatchEntryDetailInfo> batchEntryDetailInfos;
    // ��ֳ�淶��ϸ��Ϣ
    private BreedModelEntryInfo modelEntryInfo;
    
    // ���ڼ���
    DataChangeListener bizDateListener ;
    
    
	// ��ǰ��ֳ��
    private BreedStoorgSetInfo currFarm;
    // ��ֳ����Ӧ�����֯
    private StorageOrgUnitInfo stoOrg;
    
    private Map<String,LayEggDailyEntryInfo> tempBreedEntryMap;
    private Map<String,LayEggDailyCullDeathEntryInfo> tempCDEntryMap;
    private Map<String,LayEggDailyLayEggEntryInfo> tempEggEntryMap;
//    private Map<String,LayEggDailyTransHenhouseEntryInfo> tempTransEntryMap;
    
    /**
     * output class constructor
     */
    public LayEggDailyEditUI() throws Exception
    {
        super();
        this.setUITitle("��ֳ�ձ�");
        // ��ǰ ��ֳ��
        stoOrg = SysContext.getSysContext().getCurrentStorageUnit();
		if(stoOrg == null){
			MsgBox.showInfo("��ǰδ���κο����֯");
			SysUtil.abort();
		}
		try{
			currFarm = parentFacadeFactory.getRemoteInstance().getFarmByStoOrgID(stoOrg.getId().toString());
		}catch(BOSException bose){
			MsgBox.showInfo(bose.getMessage());
			SysUtil.abort();
		}
		if(currFarm == null){
			MsgBox.showInfo("��ǰδ���κ���ֳ���������л�����Ӧ��ֳ����������ز���");
			SysUtil.abort();
		}
        
//        this.controlPanel.add(this.btnAddnewLine, new KDLayout.Constraints(kdtConveyor_detailPanel.rect.width - 86, 5, 22, 19, 9));
    	// ������ʾ����
//		this.prmtparentBatch.setDisplayFormat("$costObject.name$");		
//        this.prmtparentBatch.setEditFormat("$costObject.name$");	
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	// ��ֳ����
    	DataChangeListener[] dl = this.prmtparentBatch.getListeners(DataChangeListener.class);
    	for(int i=0;i<dl.length;i++){
    		this.prmtparentBatch.removeDataChangeListener(dl[i]);
    	}
    	removeListener();
        super.loadFields();
        addListener();
        // ��ֳ����
        for(int i=0;i<dl.length;i++){
    		this.prmtparentBatch.addDataChangeListener(dl[i]);
    	}
        
    }
    
//    @Override
//	public void actionToStockDaily_actionPerformed(ActionEvent e)
//			throws Exception {
//		// TODO Auto-generated method stub
//    	LayEggFacadeFactory.getRemoteInstance().toStockDaily();
//		super.actionToStockDaily_actionPerformed(e);
//	}
    /**
     * �Ƴ�����
     */
    private void removeListener(){
    	// ҵ������
    	if(bizDateListener != null){
    		this.pkBizDate.removeDataChangeListener(bizDateListener);
    		bizDateListener = null;
    	}
    }
    /**
     * ��Ӽ���
     */
    private void addListener(){
    	// ҵ������
    	bizDateListener = new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkBizDate_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        };
    	this.pkBizDate.addDataChangeListener(bizDateListener);
    	
        kdtTransHenhouseEntrys.addKDTEditListener(new KDTEditAdapter() {
    		public void editStopped(KDTEditEvent e) {
    			try {
    				kdtTransHenhouseEntrys_Changed(e.getRowIndex(),e.getColIndex());
    			}
    			catch (Exception exc) {
    				handUIException(exc);
    			}
    		}
    	});
    	
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
        return com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

  
    
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// ����ҳǩ ����
		this.paneBIZLayerControl17.remove(assTab);
		this.paneBIZLayerControl17.remove(kDPanel3);
		
		// ����ȫ��
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);
		}else if(this.getOprtState().equals("EDIT")){
			checkCanEdit();
			
		}
		
		f7Init();
		
		 // ����Ĭ�ϵ�ǰ�����֯���м�����Ϣ
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        if(currStorageOrgInfo == null){
        	MsgBox.showInfo("��ǰδ���κο����֯�У����ܽ���������ֳ�ձ�����");
        	SysUtil.abort();
        }
        // ���¿����֯
        setStorageOrgUnit(currStorageOrgInfo);
        
        
//        KDWorkButton btnRefreshInventory = new KDWorkButton();
//        btnRefreshInventory.setToolTipText("ˢ�¿��");
//        btnRefreshInventory.setIcon(EASResource.getIcon("imgTbtn_addline"));
//        btnRefreshInventory.setName("lalalalalalal");
//        btnRefreshInventory.setText("lalalalalalal");
//        
//        kdtConveyor_detailPanel.add(btnRefreshInventory,new KDLayout.Constraints(500, 5, 22, 19, 9));
        
        
        kDContainer1.add(actionRefreshInventory);
        
        // ����ת����¼ ��ʼ��������
        initTranEntrysFilter();
	}
    
    

    /**
     * У�鵱ǰ��֯�Ƿ��ǵ��ݴ�����֯��������ǣ���ʾ��Ϣ�жϲ���
     */
    private void checkCanEdit(){
    	CtrlUnitInfo cu = SysContext.getSysContext().getCurrentCtrlUnit();
		CtrlUnitInfo billCU = this.editData.getCU();
		
		if(billCU != null){
			if(!cu.getId().toString().equals(billCU.getId().toString())){
				MsgBox.showWarning("��ǰ��֯���ǵ��ݴ�����֯�������޸ĵ���");
				SysUtil.abort();
			}
		}
    }
    /**
     * �༭ǰУ�鵥���Ƿ��ڴ�����֯��
     */
    @Override
    public void actionEdit_actionPerformed(ActionEvent e)throws Exception{
    	checkCanEdit();
    	super.actionEdit_actionPerformed(e);
    }


	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		String breedLog = this.txtbreedLog.getText();
		if(breedLog != null){
			int length = breedLog.length();
			if(length > 2000){
				MsgBox.showInfo("��ֳ��־�������ܴ���2000");
				SysUtil.abort();
			}
		}
		super.beforeStoreFields(arg0);
	}



	/**
     * f7��ʼ��
     */
    private void f7Init(){
    	// 
    	final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedMaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        
        
        F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this, kdtEntrys_material_PromptBox);
        FilterInfo materialFI = new FilterInfo();
        materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0203!020302!020308%",CompareType.LIKE));
//        materialFI.getFilterItems().add(new FilterItemInfo("number","02-000001",CompareType.EQUALS));
//        materialFI.setMaskString("#0 or #1");
        // �������Ϲ�������
//		m7.setBaseFilter(materialFI);
		kdtEntrys_material_PromptBox.setSelector(m7);
		kdtEntrys_material_PromptBox.setEditFormat("$number$");
		kdtEntrys_material_PromptBox.setCommitFormat("$number$");
		kdtEntrys_material_PromptBox.setRequired(true);
		
		
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("henMaterial").setEditor(kdtEntrys_material_CellEditor);
        this.kdtEntrys.getColumn("cockMaterial").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henMaterial").setRenderer(kdtEntrys_material_OVR);
        this.kdtEntrys.getColumn("cockMaterial").setRenderer(kdtEntrys_material_OVR);
        
        // ���� ��¼
    	final KDBizPromptBox kdtImmuneEntrys_material_PromptBox = new KDBizPromptBox();
    	kdtImmuneEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedMaterialBaseInfoQuery");
    	kdtEntrys_material_PromptBox.setVisible(true);
    	kdtImmuneEntrys_material_PromptBox.setEditable(true);
    	kdtImmuneEntrys_material_PromptBox.setDisplayFormat("$number$");
    	kdtImmuneEntrys_material_PromptBox.setEditFormat("$number$");
    	kdtImmuneEntrys_material_PromptBox.setCommitFormat("$number$");
        
        
        F7MaterialSimpleSelector immuneF7 = new F7MaterialSimpleSelector(this, kdtImmuneEntrys_material_PromptBox);
//        FilterInfo immuneFI = new FilterInfo();
//        immuneFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","01!0103%",CompareType.LIKE));
        // �������Ϲ�������
//        immuneF7.setBaseFilter(immuneFI);
//        kdtImmuneEntrys_material_PromptBox.setSelector(immuneF7);
        kdtImmuneEntrys_material_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_material_PromptBox.setCommitFormat("$number$");
        kdtImmuneEntrys_material_PromptBox.setRequired(true);
		
		
        KDTDefaultCellEditor kdtImmuneEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_material_PromptBox);
        this.kdtImmuneEntrys.getColumn("vaccineMaterial").setEditor(kdtImmuneEntrys_material_CellEditor);
        ObjectValueRender kdtImmueEntrys_material_OVR = new ObjectValueRender();
        kdtImmueEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("vaccineMaterial").setRenderer(kdtImmueEntrys_material_OVR);
        
        
        
        EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
////        filter.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.LayEgg.getValue(),CompareType.EQUALS));
//        CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
//        filter.getFilterItems().add(new FilterItemInfo("CU.id",cuInfo.getId().toString(),CompareType.EQUALS));
//        // ����Ĭ�ϵ�ǰ�����֯���м�����Ϣ
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filter.getFilterItems().add(new FilterItemInfo("stoOrg.id",currStorageOrgInfo.getId().toString(),CompareType.EQUALS));
        evi.setFilter(filter);
//        
        SorterItemCollection sorter = new SorterItemCollection();
        SorterItemInfo sortItem = new SorterItemInfo("bizDate");
        sortItem.setSortType(SortType.DESCEND);
        sorter.add(sortItem);
        evi.setSorter(sorter);
        this.prmtparentBatch.setQueryInfo("com.kingdee.eas.farm.breed.app.F7ParentBreedBatchQuery");
        this.prmtparentBatch.setEntityViewInfo(evi);
        
        
 // Ҫ�ϼƻ� 
        
        this.kdtFodderEntrys.getColumn("fodderMaterial").setEditor(kdtEntrys_material_CellEditor);
        this.kdtFodderEntrys.getColumn("fodderMaterial").setRenderer(kdtEntrys_material_OVR);
        
        
    	final KDBizPromptBox tower_PromptBox = new KDBizPromptBox();
    	tower_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7WarehouseQuery");
    	tower_PromptBox.setVisible(true);
    	tower_PromptBox.setEditable(true);
    	tower_PromptBox.setDisplayFormat("$number$");
    	tower_PromptBox.setEditFormat("$number$");
    	tower_PromptBox.setCommitFormat("$number$");
        
        
    	
    	EntityViewInfo towerEvi = new EntityViewInfo();
        FilterInfo towerFI = new FilterInfo();
//        materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0201!020102%",CompareType.LIKE));
//        towerFI.getFilterItems().add(new FilterItemInfo("name","%����%",CompareType.LIKE));
//        towerFI.getFilterItems().add(new FilterItemInfo("storageOrg.id",currStorageOrgInfo.getId().toString(),CompareType.EQUALS));
//        towerEvi.setFilter(towerFI);
        // �������Ϲ�������
//		m7.setBaseFilter(towerFI);
        tower_PromptBox.setEntityViewInfo(towerEvi);
		
		
        KDTDefaultCellEditor kdtFodderEntrys_tower_CellEditor = new KDTDefaultCellEditor(tower_PromptBox);
        this.kdtFodderEntrys.getColumn("fodderTower").setEditor(kdtFodderEntrys_tower_CellEditor);
        ObjectValueRender kdtFodderEntrys_tower_OVR = new ObjectValueRender();
        kdtFodderEntrys_tower_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFodderEntrys.getColumn("fodderTower").setRenderer(kdtFodderEntrys_tower_OVR);
        
        // ת����¼ ���� f7
        final KDBizPromptBox kdtTransEntrys_batch_PromptBox = new KDBizPromptBox();
    	kdtTransEntrys_batch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7ParentBreedBatchQuery");
    	kdtEntrys_material_PromptBox.setVisible(true);
    	kdtTransEntrys_batch_PromptBox.setEditable(true);
    	kdtTransEntrys_batch_PromptBox.setDisplayFormat("$number$");
    	kdtTransEntrys_batch_PromptBox.setEditFormat("$number$");
    	kdtTransEntrys_batch_PromptBox.setCommitFormat("$number$");
        
        
    	KDTDefaultCellEditor kdtTransEntrys_batch_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_batch_PromptBox);
        // �������Ϲ�������
    	this.kdtTransHenhouseEntrys.getColumn("fromBatch").setEditor(kdtTransEntrys_batch_CellEditor);
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
		
		final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henhouse_PromptBox.setVisible(true);
        kdtEntrys_henhouse_PromptBox.setEditable(true);
        kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);
        // ��ι��Ϣ
//        this.kdtEntrys.getColumn("warehouse").setEditor(kdtEntrys_warehouse_CellEditor);
        // ˮ����Ϣ
        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ������Ϣ
        this.kdtLayEggEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        
        // ������Ϣ
        this.kdtCullDeathEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ������Ϣ
        this.kdtImmuneEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // ������Ϣ
        this.kdtAssEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        
        
        
        // ���ʹ����ݹ���
        view = new EntityViewInfo();
		filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(orgInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("storageOrg.id",orgInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("storageOrg.id","",CompareType.EQUALS));
		}
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%����%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
        
        final KDBizPromptBox kdtConveyor_conveyorNumber_PromptBox = new KDBizPromptBox();
        kdtConveyor_conveyorNumber_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.layegg.app.EggConveyorQuery");
        kdtConveyor_conveyorNumber_PromptBox.setVisible(true);
        kdtConveyor_conveyorNumber_PromptBox.setEditable(true);
        kdtConveyor_conveyorNumber_PromptBox.setDisplayFormat("$number$");
        kdtConveyor_conveyorNumber_PromptBox.setEditFormat("$number$");
        kdtConveyor_conveyorNumber_PromptBox.setCommitFormat("$number$");
        kdtConveyor_conveyorNumber_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtConveyor_conveyorNumber_CellEditor = new KDTDefaultCellEditor(kdtConveyor_conveyorNumber_PromptBox);
        this.kdtConveyor.getColumn("conveyorNumber").setEditor(kdtConveyor_conveyorNumber_CellEditor);
        
    }
    

    /**
     * output createNewData method
     * @throws BOSException 
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
    	com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo objectValue = new com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
       
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        
        this.baseStatus.setSelectedItem(BillBaseStatusEnum.ADD);
        this.baseStatus.setSelectedIndex(1);
        objectValue.setBizDate(new Date());
        // ����Ĭ�ϵ�ǰ�����֯���м�����Ϣ
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        if(currStorageOrgInfo == null){
        	MsgBox.showInfo("��ǰδ���κο����֯�У����ܽ���������ֳ�ձ�����");
        	SysUtil.abort();
        }
        //   Ĭ�ϵ�ǰ�����֯
        objectValue.setFarm(currFarm);
        objectValue.setStoOrg(stoOrg);
        // ���¿����֯
        setStorageOrgUnit(currStorageOrgInfo);
        
        try {
			setEntryInfos(objectValue,currStorageOrgInfo);
		} catch (BOSException e) {
			e.printStackTrace();
			this.handleException(e);
			
		} catch (EASBizException e) {
			e.printStackTrace();
			this.handleException(e);
		}
       
        return objectValue;
    }
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
        
    }
    /**
     * ���÷�¼��Ϣ
     * 
     * ���� �����֯  ��ȡ���� �ֿ⣬Ȼ�����ÿ���ֿ�������������ɶ�Ӧ��¼ ��ӵ����еķ�¼��
     * 
     * @param info
     * @param orgInfo
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
    private LayEggDailyInfo setEntryInfos(LayEggDailyInfo info,StorageOrgUnitInfo orgInfo) throws BOSException, EASBizException{
//    	WarehouseCollection wsInfos = getStorageOrgWarehouseInfos(orgInfo);
//    	for(int i = 0; i < wsInfos.size(); i++){
//    		WarehouseInfo wsInfo = wsInfos.get(i);
//    		// �ֿ�
//    		wsInfo = WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK(wsInfo.getId()));
//    		// ����
//    		HenhouseInfo henhouseInfo = BreedFacadeFactory.getRemoteInstance().getWarehsHenhouse(wsInfo.getId().toString());
//    		
//    		if(henhouseInfo != null){
//	    		// �����¼�б����ɷ�¼  ����
//	    		// ��ι��¼  
//	//    		LayEggDailyEntryInfo entryInfo = new LayEggDailyEntryInfo();
//	//    		entryInfo.setParent(info);
//	//    		entryInfo.setWarehouse(wsInfo);
//	//    		info.getEntrys().add(entryInfo);
//	    		addBreedMaterialEntryInfos(info,henhouseInfo,wsInfo.getName());
//	    		
//	    		// ������Ϣ
//	    		LayEggDailyLayEggEntryInfo layEggEntryInfo = new LayEggDailyLayEggEntryInfo();
//	    		layEggEntryInfo.setHenhouse(henhouseInfo);
//	    		layEggEntryInfo.setHenhouseName(wsInfo.getName());
//	    		layEggEntryInfo.setParent(info);
//	    		info.getLayEggEntrys().add(layEggEntryInfo);
//	    		
//	    		// ������Ϣ
//	    		LayEggDailyCullDeathEntryInfo cdEntryInfo = new LayEggDailyCullDeathEntryInfo();
//	    		cdEntryInfo.setHenhouse(henhouseInfo);
//	    		cdEntryInfo.setHenhouseName(wsInfo.getName());
//	    		cdEntryInfo.setParent(info);
//	    		info.getCullDeathEntrys().add(cdEntryInfo);
//
//	    		// ˮ����Ϣ
////	    		LayEggDailyWEEntryInfo weEntryInfo = new LayEggDailyWEEntryInfo();
////	    		weEntryInfo.setHenhouse(henhouseInfo);
////	    		weEntryInfo.setHenhouseName(wsInfo.getName());
////	    		weEntryInfo.setParent(info);
////	    		info.getWEEntrys().add(weEntryInfo);
//	    		
//	    		
//	    		// ������Ϣ
////	    		LayEggDailyVaccineEntryInfo vaccineEntryInfo = new LayEggDailyVaccineEntryInfo();
////	    		vaccineEntryInfo.setParent(info);
////	    		vaccineEntryInfo.setHenhouse(henhouseInfo);
////	    		vaccineEntryInfo.setHenhouseName(wsInfo.getName());
////	    		info.getVaccineEntrys().add(vaccineEntryInfo);
//	    		// ������Ϣ
//	    		LayEggDailyAssEntryInfo assEntryInfo = new LayEggDailyAssEntryInfo();
//	    		assEntryInfo.setParent(info);
//	    		assEntryInfo.setHenhouse(henhouseInfo);
//	    		assEntryInfo.setHenhouseName(wsInfo.getName());
//	    		info.getAssEntrys().add(assEntryInfo);
//	    		
//	    		
//    		}
//    	}
//    	
    	// ���� ���ʹ���Ϣ
    	List eggConveyors = LayEggFacadeFactory.getRemoteInstance().getConveyors(orgInfo.getId().toString());
    	
    	for(int i = 0; i < eggConveyors.size(); i++){
    		EggConveyorInfo conveyorInfo = (EggConveyorInfo) eggConveyors.get(i);
    		// ������Ϣ
    		LayEggDailyConveyorInfo conEntryInfo = new LayEggDailyConveyorInfo();
    		conEntryInfo.setParent(info);
    		conEntryInfo.setConveyorNumber(conveyorInfo);
    		conEntryInfo.setHenhouseDesc(conveyorInfo.getHenhouseDesc());
    		
    		WarehouseInfo wInfo = conveyorInfo.getEggWarehouse();
    		// ��ö�Ӧ���ϵļ�ʱ���
    		IInventory inventory = InventoryFactory.getRemoteInstance();
    		// ˫�Ƶ���ǰ�����
    		BigDecimal doubleYolkInventory = inventory.getQty("at4AAAAApeRECefw", null, orgInfo.getId().toString(),wInfo.getId().toString(), null);
    		conEntryInfo.setDoubleYolkInventory(doubleYolkInventory);
    		// ���ε���ǰ�����
    		BigDecimal freakInventory = inventory.getQty("at4AAAAApeJECefw", null, orgInfo.getId().toString(),wInfo.getId().toString(),  null);
    		conEntryInfo.setFreakInventory(freakInventory);
    		// �ϸ񵰵�ǰ�����
    		BigDecimal qualifiedInventory = inventory.getQty("at4AAAAApeBECefw", null, orgInfo.getId().toString(),wInfo.getId().toString(),  null);
    		conEntryInfo.setQualifyInventory(qualifiedInventory);
    		
    		info.getConveyor().add(conEntryInfo);
    	}
    	
    	
    	return info;
    }
    
    /**
     * ˢ�´��ʹ������Ϣ
     * @throws BOSException 
     * @throws EASBizException 
     */
    private void refreshConveyorInventory(StorageOrgUnitInfo orgInfo) throws BOSException, EASBizException{
    	IInventory inventory = InventoryFactory.getRemoteInstance();
    	for(int i = 0; i <this.kdtConveyor.getRowCount(); i++){
    		
    		EggConveyorInfo currConveyor = (EggConveyorInfo) this.kdtConveyor.getCell(i, "conveyorNumber").getValue();
    	
    		if(currConveyor != null){
    			WarehouseInfo wInfo = currConveyor.getEggWarehouse();
	    		BigDecimal doubleYolkInventory = inventory.getQty("at4AAAAApeRECefw", null, orgInfo.getId().toString(),wInfo.getId().toString(), null);
	    		doubleYolkInventory = doubleYolkInventory == null?new BigDecimal("0"):doubleYolkInventory;
	    		this.kdtConveyor.getCell(i, "doubleYolkInventory").setValue(doubleYolkInventory);
	    		// ���ε���ǰ�����
	    		BigDecimal freakInventory = inventory.getQty("at4AAAAApeJECefw", null, orgInfo.getId().toString(),wInfo.getId().toString(),  null);
	    		freakInventory = freakInventory == null?new BigDecimal("0"):freakInventory;
	    		this.kdtConveyor.getCell(i, "freakInventory").setValue(freakInventory);
	    		// �ϸ񵰵�ǰ�����
	    		BigDecimal qualifiedInventory = inventory.getQty("at4AAAAApeBECefw", null, orgInfo.getId().toString(),wInfo.getId().toString(),  null);
	    		qualifiedInventory = qualifiedInventory == null?new BigDecimal("0"):qualifiedInventory;
	    		this.kdtConveyor.getCell(i, "qualifyInventory").setValue(qualifiedInventory);
    		}
    	}
    }
    /**
     * �����ι��¼
     * 
     * @param info
     * @param orgInfo
     * @param wsInfo
     * @return
     * @throws BOSException 
     */
    private LayEggDailyInfo addBreedMaterialEntryInfos(LayEggDailyInfo info,HenhouseInfo henhouseinfo,String henhouseName) throws BOSException{
    	if(info != null && henhouseinfo != null){
	    	
	    	boolean addedDefault = false;
	    	// ��ȡ ����� ��������
	    	LayEggHouseSetInfo coopSetInfo = (LayEggHouseSetInfo) LayEggFacadeFactory.getRemoteInstance().getHouseLayEggSet(henhouseinfo.getId().toString());	
	    	if(coopSetInfo != null){
	    		LayEggHouseSetEntryCollection entryColl = coopSetInfo.getEntrys();
	    		for(int i = 0; entryColl.size() > 0 && i <entryColl.size(); i++){
	    			LayEggHouseSetEntryInfo entryInfo = entryColl.get(i);
	    			MaterialInfo henMaterial = entryInfo.getHenMaterial();
	    			BigDecimal henQty = entryInfo.getHenDefaultQty();
	    			MaterialInfo cockMaterial = entryInfo.getCockMaterial();
	    			BigDecimal cockQty = entryInfo.getCockDefaultQty();
	    			try{
	    				
	    				// 
		    			LayEggDailyEntryInfo dailyEntryInfo = new LayEggDailyEntryInfo();
		    			dailyEntryInfo.setParent(info);
		    			dailyEntryInfo.setHenhouse(henhouseinfo);
		    			dailyEntryInfo.setHenhouseName(henhouseName);
		    			// ĸ����
		    			if(henMaterial != null){
	    					henMaterial = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(henMaterial.getId()));
	    					dailyEntryInfo.setHenMaterial(henMaterial);
			    			dailyEntryInfo.setHenMaterialName(henMaterial.getName());
		    			}
		    			dailyEntryInfo.setHenQty(henQty);
		    			// ������
		    			if(cockMaterial != null){
		    				cockMaterial = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(cockMaterial.getId()));
		    				dailyEntryInfo.setCockMaterial(cockMaterial);
			    			dailyEntryInfo.setCockMaterialName(cockMaterial.getName());
		    			}
		    			dailyEntryInfo.setCockQty(cockQty);
		    			
		        		info.getEntrys().add(dailyEntryInfo);
		        		
		        		addedDefault = true;
    				}catch(EASBizException e){
    					throw new BOSException(e);
    				}
	    			
	    		}
	    	}
	    	if(!addedDefault){
	    		LayEggDailyEntryInfo dailyEntryInfo = new LayEggDailyEntryInfo();
				dailyEntryInfo.setParent(info);
	//			dailyEntryInfo.setWarehouse(wsInfo);
				dailyEntryInfo.setHenhouse(henhouseinfo);
				dailyEntryInfo.setHenhouseName(henhouseName);
	//			dailyEntryInfo.setMaterial(materialInfo);
	//			dailyEntryInfo.setMaterialName(materialInfo.getName());
	//			dailyEntryInfo.setDailyQtyAll(quantity);
	    		info.getEntrys().add(dailyEntryInfo);
	    	}
    	}
    	return info;
    }
    
    /**
     * ���ݿ����֯��ö�Ӧ�� �ֿ���Ϣ
     * @param currStorageOrgInfo
     * @return
     * @throws BOSException 
     */
    private WarehouseCollection getStorageOrgWarehouseInfos(StorageOrgUnitInfo orgInfo) throws BOSException{
    	
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(orgInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("storageOrg.id",orgInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("storageOrg.id","",CompareType.EQUALS));
		}
		filterInfo.getFilterItems().add(new FilterItemInfo("name","%����%",CompareType.LIKE));
		view.setFilter(filterInfo);
    	return WarehouseFactory.getRemoteInstance().getWarehouseCollection(view);
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
	
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{
				// �ж� ��ְ����ְ�Ƿ�Ϊ�գ����Ϊ������ʾ �Ƿ��ύ
//				int addPerson = this.txtentryPersonQty.getIntegerValue();
//				int leavePerson = this.txtleavePersonQty.getIntegerValue();
				
//				if(addPerson == 0 || leavePerson == 0){
//					if(MsgBox.showConfirm2("������ְ����ְ��������Ϊ0���ݣ�ȷ���ύ?") != MsgBox.OK){
//						SysUtil.abort();
//					}
//				}
				
				
				
				// У����������䲻�� С��1
				int week = this.txtweek.getIntegerValue();
				int day = this.txtweekDay.getIntegerValue();
				if(week == 0){
					MsgBox.showWarning("���䲻��С��1 ");
					SysUtil.abort();
				}else if(week > 100){
					MsgBox.showWarning("���䲻�ܴ���100 ");
					SysUtil.abort();
				}else if(!(day >= 0 && day <8)){
					MsgBox.showWarning("����ֻ�ܴ���0��7֮�� ");
					SysUtil.abort();
				}else if(week > 1 && day == 0){
					MsgBox.showWarning("ֻ���ڵ�һ����������Ϊ0 ");
					SysUtil.abort();
				}
				
				
				
				// У�� ������¼����
//				for(int i = 0; i <this.kdtConveyor.getRowCount(); i++){
//					Integer yolkTrans = (Integer) this.kdtConveyor.getCell(i, "doubleYolkTransQty").getValue();
//					if(yolkTrans != null && yolkTrans.compareTo(new Integer("0")) > 0){
//						BigDecimal yolkInventory = (BigDecimal) this.kdtConveyor.getCell(i, "doubleYolkInventory").getValue();
//						Integer doubleYolkedEggs = (Integer) this.kdtConveyor.getCell(i, "doubleYolkedEggs").getValue();
//						yolkInventory = (yolkInventory== null? new BigDecimal("0"):yolkInventory);
//						doubleYolkedEggs =  (doubleYolkedEggs== null? new Integer("0"):doubleYolkedEggs);
//						if(yolkTrans.compareTo(yolkInventory.intValue() + doubleYolkedEggs.intValue()) > 0){
//							MsgBox.showInfo("���ʹ� ������˫�Ƶ��� �����ڵ�ǰ��˫�Ƶ���ʱ��桿�͵������˫�Ƶ�����֮�ͣ������ύ");
//							SysUtil.abort();
//						}
//					}
//					
//					Integer freakTrans = (Integer) this.kdtConveyor.getCell(i, "freakTransQty").getValue();
//					if(freakTrans != null && freakTrans.compareTo(new Integer("0")) > 0){
//						BigDecimal freakInventory = (BigDecimal) this.kdtConveyor.getCell(i, "freakInventory").getValue();
//						Integer freakEggs = (Integer) this.kdtConveyor.getCell(i, "freakEggs").getValue();
//						freakEggs =  (freakEggs== null? new Integer("0"):freakEggs);
//						freakInventory = (freakInventory== null? new BigDecimal("0"):freakInventory);
//						if(freakTrans.compareTo(freakInventory.intValue() + freakEggs.intValue()) > 0){
//							MsgBox.showInfo("���ʹ� ���������ε��� �����ڵ�ǰ�����ε���ʱ��桿�͵���������ε�����֮�ͣ������ύ");
//							SysUtil.abort();
//						}
//					}
//					
//					Integer qualityTrans = (Integer) this.kdtConveyor.getCell(i, "qulifiedTransQty").getValue();
//					if(qualityTrans != null && qualityTrans.compareTo(new Integer("0")) > 0){
//						BigDecimal qualityInventory = (BigDecimal) this.kdtConveyor.getCell(i, "qualifyInventory").getValue();
//						Integer qualifiedEggs = (Integer) this.kdtConveyor.getCell(i, "qualifiedEggs").getValue();
//						qualityInventory = (qualityInventory== null? new BigDecimal("0"):qualityInventory);
//						qualifiedEggs =  (qualifiedEggs== null? new Integer("0"):qualifiedEggs);
//						
//						if(qualityTrans.compareTo(qualityInventory.intValue() + qualifiedEggs.intValue() ) > 0){
//							MsgBox.showInfo("���ʹ� �������ϸ��� �����ڡ���ǰ��ʱ��桿�͵�������ϸ񵰡���֮�ͣ������ύ");
//							SysUtil.abort();
//						}
//					}
//				}
				
				
				if(this.chkisFixed.isSelected()){
					if(MsgBox.showConfirm2("�Ƿ�ȷ�ϵ����������Ϊ����������ȷ���������������޸�") != MsgBox.OK){
						return;
					}
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
	
	@Override
	public void kdtConveyor_Changed(int rowIndex, int colIndex)
			throws Exception {
		// TODO Auto-generated method stub
		super.kdtConveyor_Changed(rowIndex, colIndex);
	}
	/**
	 * ��ֳ���� ֵ���º��������
	 */
	@Override
	protected void prmtparentBatch_dataChanged(DataChangeEvent e)
			throws Exception {
		try{
			ParentBreedBatchInfo oldValue = (ParentBreedBatchInfo) e.getOldValue();
			ParentBreedBatchInfo newValue = (ParentBreedBatchInfo) e.getNewValue();
			// ֵΪ�� ����շ�¼
			if(newValue == null){
				clearEntrys();
				// ���� �ɱ����� 
				updateCostObject(null);
			}else if(oldValue != null && newValue.getId().toString().equals(oldValue.getId().toString())){
				return;
			}else{
				// �����������ɳɱ�������  �����ɱ�����
				
				clearEntrys();
				// ����������Ϣ�� ��Ӧ�� ��ֳ�淶���÷�¼��Ϣ
				setAllEntryInfos(newValue);
				
				// ���� �ɱ����� 
				updateCostObject(newValue);
//				this.setDataObject(this.editData);
//				this.loadFields();
//				// �����������¼�� ����ˢ��
//				this.loadData();
			}
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
			SysUtil.abort();
		}
		
	}
    /**
     * ����ѡ�е� ��ֳ�������� �ձ��ɱ�����
     * @param batchInfo
     * @throws BOSException 
     * @throws EASBizException 
     */
	private void updateCostObject(ParentBreedBatchInfo batchInfo) throws EASBizException, BOSException{
		if(batchInfo == null){
			this.prmtbroodCostObject.setValue(null);
//			this.prmtlayEggCostObject.setValue(null);
			this.prmtbabyCostObject.setValue(null);
			this.prmteggCostObject.setValue(null);
			
			this.chkhadFixed.setSelected(false);
			
		}else{
			// �Ѷ���
			this.chkhadFixed.setSelected(batchInfo.isIsToLayegg());
			
			CostObjectInfo youngCostObj = batchInfo.getYoungCostObject();
			if(youngCostObj != null){
				youngCostObj = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(youngCostObj.getId()));
			}
			this.prmtbroodCostObject.setValue(youngCostObj);
//			this.prmtlayEggCostObject.setValue(batchInfo.getAdultCostObject());
			CostObjectInfo babyCostObj = batchInfo.getBabyCostObject();
			if(babyCostObj != null){
				babyCostObj = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(babyCostObj.getId()));
			}
			this.prmtbabyCostObject.setValue(babyCostObj);
			
			CostObjectInfo eggCostObj = batchInfo.getEggCostObject();
			if(eggCostObj != null){
				eggCostObj = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(eggCostObj.getId()));
			}
			this.prmteggCostObject.setValue(eggCostObj);
		}
	}
	/**
	 * �����¼
	 */
	private void clearEntrys(){
		
		// �����¼ǰ  ���ݴ��Ѿ���д����
		saveDetailToTemp();
		this.kdtEntrys.removeRows();
		this.kdtAssEntrys.removeRows();
		this.kdtCullDeathEntrys.removeRows();
		this.kdtLayEggEntrys.removeRows();
		this.kdtImmuneEntrys.removeRows();
		this.txtweek.setValue(0);
		this.txtweekDay.setValue(0);
		this.editData.getEntrys().clear();
		this.editData.getAssEntrys().clear();
		this.editData.getCullDeathEntrys().clear();
		this.editData.getLayEggEntrys().clear();
		this.editData.getImmuneEntrys().clear();
		this.editData.setWeek(0);
		this.editData.setWeekDay(0);
	}
	
	/**
	 * �ݴ���ϸ���ݵ�tempmap��
	 */
	private void saveDetailToTemp(){
		tempBreedEntryMap = new HashMap<String,LayEggDailyEntryInfo>();
		tempCDEntryMap = new HashMap<String,LayEggDailyCullDeathEntryInfo>();
		tempEggEntryMap =  new HashMap<String,LayEggDailyLayEggEntryInfo>();
		
		
	}
	/**
	 * ����ѡ�е���ֳ������Ϣ���÷�¼��Ϣ
	 * @param newValue
	 * @throws BOSException 
	 */
	private void setAllEntryInfos(ParentBreedBatchInfo batchInfo) throws BOSException {
		if(batchInfo != null){
			try{
				Date bizDate = this.pkBizDate.getSqlDate();
				// ��ȡ������ϸ��Ϣ
				IparentFacade parentFacade = parentFacadeFactory.getRemoteInstance();
				batchInfo = ParentBreedBatchFactory.getRemoteInstance().getParentBreedBatchInfo(new ObjectUuidPK(batchInfo.getId()));
				ParentBreedBatchDetailInfo batchDetail = parentFacade.getBreedBatchDetailInfos(batchInfo.getId().toString(), bizDate);
				if(batchDetail != null){
					int currWeek = batchDetail.getCurrentWeek();
					this.txtweek.setValue(currWeek);
					this.editData.setWeek(currWeek);
					
					int currDay = batchDetail.getCurrentDay();
					this.txtweekDay.setValue(currDay);
					this.editData.setWeekDay(currDay);
					
					if(currWeek>0){
						int sumweek = currWeek-1;
						sumweek = sumweek*7+currDay;
						this.txtsumDay.setValue(sumweek);
						this.editData.setSumDay(sumweek);
					}else{
						int sumweek = currDay;
						this.txtsumDay.setValue(sumweek);
						this.editData.setSumDay(sumweek);
					}
					// �����ֳ�淶
//					BreedModelInfo modelInfo = batchDetail.getBreedModelInfo();
					BreedModelInfo modelInfo = batchInfo.getBreedModel();
					// �淶��¼
					modelEntryInfo = batchDetail.getBreedModelEntryInfo();
					
					ParentBreedBatchEntryCollection entryColl = batchInfo.getEntrys();
					// ���Ժ� ��ǰֻ�����
					batchEntryDetailInfos = batchDetail.getHenhouseBreedingStock(null,bizDate);
					// �����еķ�¼�������
					if(batchEntryDetailInfos == null) return;
					Set<String> keySet = batchEntryDetailInfos.keySet();
					for(String key : keySet){
						ParentBreedBatchEntryDetailInfo entryInfo = batchEntryDetailInfos.get(key);
						
						LayEggDailyEntryInfo dailyEntryInfo = new LayEggDailyEntryInfo();
		    			dailyEntryInfo.setParent(this.editData);
		    			HenhouseInfo henhouseInfo = entryInfo.getHenhouse();
		    			henhouseInfo = HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(henhouseInfo.getId()));
		    			WarehouseInfo warehsInfo = henhouseInfo.getWarehouse();
		    			if(warehsInfo != null){
		    				warehsInfo = WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK(warehsInfo.getId()));
		    				
		    			}
		    			dailyEntryInfo.setHenhouse(henhouseInfo);
		    			dailyEntryInfo.setHenhouseName(henhouseInfo.getName());
		    			// ��� ���� ��������ϸ��Ϣ
		    			ParentBreedBatchEntryDetailInfo entryDetailInfo = batchEntryDetailInfos.get(henhouseInfo.getId().toString());
		    			
		    			int henNowQty = 0;
		    			if(modelEntryInfo != null) {
		    				henNowQty = entryDetailInfo.getHenNowQty();
		    			}
		    			int cockNowQty = 0;
		    			if(modelEntryInfo != null) {
		    				cockNowQty = entryDetailInfo.getCockNowQty();
		    			}
		    			
		    			// ��ι��Ϣ 
		    			MaterialInfo henMaterialInfo = null;
		    			BigDecimal henPerQty = new BigDecimal("0");
		    			
		    			MaterialInfo cockMaterialInfo = null;
		    			BigDecimal cockPerQty = new BigDecimal("0");
		    			// �������� ��¼��Ϣ �������Ϻ�����
//		    			ChikenType chikenType = entryInfo.getChikenType();
//		    			
//		    			int henInitQty = entryInfo.getHenQty();
//		    			int cockInitQty = entryInfo.getCockQty();
		    			if(modelEntryInfo != null){
			    			cockMaterialInfo = modelEntryInfo.getCockMaterial();
			    			cockPerQty = modelEntryInfo.getCockQtyPerday();
			    			if(cockPerQty == null){
			    				cockPerQty = new BigDecimal("0");
			    			}
			    			henMaterialInfo = modelEntryInfo.getHenMaterial();
			    			henPerQty = modelEntryInfo.getHenQtyPerday();
			    			if(henPerQty == null){
			    				henPerQty = new BigDecimal("0");
			    			}
		    			}
		    			// 
		    			BigDecimal henQty  = henPerQty.multiply(new BigDecimal(henNowQty));
		    			henQty = henQty.divide(new BigDecimal("1000"),2,RoundingMode.HALF_UP);
		    			BigDecimal cockQty  = cockPerQty.multiply(new BigDecimal(cockNowQty));
		    			cockQty = cockQty.divide(new BigDecimal("1000"),2,RoundingMode.HALF_UP);
		    			
		    			// ��ǰ������ ���� ��ֻ ��
		    			
		    			if(henMaterialInfo != null){
		    				henMaterialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(henMaterialInfo.getId()));
			    			dailyEntryInfo.setHenMaterial(henMaterialInfo);
			    			dailyEntryInfo.setHenMaterialName(henMaterialInfo.getName());
			    			dailyEntryInfo.setHenMaterialModel(henMaterialInfo.getModel());
			    			dailyEntryInfo.setHenQty(henQty);
		    			}
		    			
		    			if(cockMaterialInfo != null){
		    				cockMaterialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(cockMaterialInfo.getId()));
			    			dailyEntryInfo.setCockMaterial(cockMaterialInfo);
			    			dailyEntryInfo.setCockMaterialName(cockMaterialInfo.getName());
			    			dailyEntryInfo.setCockMaterialModel(cockMaterialInfo.getModel());
			    			dailyEntryInfo.setCockQty(cockQty);
		    			}
		    			
		    			// ��ˮ��
		    			BigDecimal waterQty = new BigDecimal("0");
		    			if(modelEntryInfo != null && modelEntryInfo.getWaterQty() != null){
		    				
		    				waterQty = modelEntryInfo.getWaterQty().multiply(new BigDecimal(henNowQty + cockNowQty));
		    			}
		    			dailyEntryInfo.setWaterQty(waterQty);
		    			// 
		    			IRow newRow = this.kdtEntrys.addRow();
		    			newRow.getCell("henhouse").setValue(henhouseInfo);
		    			newRow.getCell("henhouseName").setValue(henhouseInfo.getName());
		    			newRow.getCell("henMaterial").setValue(dailyEntryInfo.getHenMaterial());
		    			newRow.getCell("henMaterialName").setValue(dailyEntryInfo.getHenMaterialName());
		    			newRow.getCell("henMaterialModel").setValue(dailyEntryInfo.getHenMaterialModel());
		    			// ������ι��
//		    			BigDecimal henNowQtyBD = new BigDecimal(henNowQty);
//		    			henNowQtyBD = henNowQtyBD.multiply(dailyEntryInfo.getHenQty());
		    			newRow.getCell("henQty").setValue(dailyEntryInfo.getHenQty());
		    			newRow.getCell("cockMaterial").setValue(dailyEntryInfo.getCockMaterial());
		    			newRow.getCell("cockMaterialName").setValue(dailyEntryInfo.getCockMaterialName());
		    			newRow.getCell("cockMaterialModel").setValue(dailyEntryInfo.getCockMaterialModel());
		    			newRow.getCell("cockQty").setValue(dailyEntryInfo.getCockQty());
		    			newRow.getCell("waterQty").setValue(dailyEntryInfo.getWaterQty());
		    			
		        		editData.getEntrys().add(dailyEntryInfo);
		        		
		        		
		        		// ������Ϣ
			    		LayEggDailyAssEntryInfo assEntryInfo = new LayEggDailyAssEntryInfo();
			    		assEntryInfo.setParent(editData);
			    		assEntryInfo.setHenhouse(henhouseInfo);
			    		if(henhouseInfo != null){
			    			assEntryInfo.setHenhouseName(henhouseInfo.getName());
			    		}
			    		if(modelEntryInfo != null){
				    		assEntryInfo.setBreedTime(modelEntryInfo.getBreedTime());
				    		assEntryInfo.setLightingTime(modelEntryInfo.getLightingTime());
				    		assEntryInfo.setTemperatureFrom(modelEntryInfo.getTemperatureFrom());
				    		assEntryInfo.setTemperatureTo(modelEntryInfo.getTemperatureTo());
				    		assEntryInfo.setHumidityFrom(modelEntryInfo.getHumidityFrom());
				    		assEntryInfo.setHumidityTo(modelEntryInfo.getHumidityTo());
			    		}
			    		editData.getAssEntrys().add(assEntryInfo);
			    		
			    		IRow assNewrow = this.kdtAssEntrys.addRow();
			    		assNewrow.getCell("henhouse").setValue(assEntryInfo.getHenhouse());
			    		assNewrow.getCell("henhouseName").setValue(assEntryInfo.getHenhouseName());
			    		assNewrow.getCell("breedTime").setValue(assEntryInfo.getBreedTime());
			    		assNewrow.getCell("lightingTime").setValue(assEntryInfo.getLightingTime());
			    		assNewrow.getCell("temperatureFrom").setValue(assEntryInfo.getTemperatureFrom());
			    		assNewrow.getCell("temperatureTo").setValue(assEntryInfo.getTemperatureTo());
			    		assNewrow.getCell("humidityFrom").setValue(assEntryInfo.getHumidityFrom());
			    		assNewrow.getCell("humidityTo").setValue(assEntryInfo.getHumidityTo());
			    		
			    		// ������Ϣ
			    		LayEggDailyLayEggEntryInfo layEggEntryInfo = new LayEggDailyLayEggEntryInfo();
			    		layEggEntryInfo.setHenhouse(henhouseInfo);
			    		layEggEntryInfo.setHenhouseName(henhouseInfo.getName());
			    		layEggEntryInfo.setParent(this.editData);
			    		this.editData.getLayEggEntrys().add(layEggEntryInfo);
			    		
			    		IRow layEggNewrow = this.kdtLayEggEntrys.addRow();
			    		layEggNewrow.getCell("henhouse").setValue(layEggEntryInfo.getHenhouse());
			    		layEggNewrow.getCell("henhouseName").setValue(dailyEntryInfo.getHenhouseName());
			    		
			    		
			    		// ������Ϣ
			    		LayEggDailyCullDeathEntryInfo cdEntryInfo = new LayEggDailyCullDeathEntryInfo();
			    		cdEntryInfo.setHenhouse(henhouseInfo);
			    		cdEntryInfo.setHenhouseName(henhouseInfo.getName());
			    		cdEntryInfo.setParent(this.editData);
			    		cdEntryInfo.setHenhouseBreekingStock(henNowQty);
			    		cdEntryInfo.setCockBreekingStock(cockNowQty);
			    		this.editData.getCullDeathEntrys().add(cdEntryInfo);
			    		
			    		IRow cdNewrow = this.kdtCullDeathEntrys.addRow();
			    		cdNewrow.getCell("henhouse").setValue(cdEntryInfo.getHenhouse());
			    		cdNewrow.getCell("henhouseName").setValue(cdEntryInfo.getHenhouseName());
			    		cdNewrow.getCell("henhouseBreekingStock").setValue(cdEntryInfo.getHenhouseBreekingStock());
			    		cdNewrow.getCell("cockBreekingStock").setValue(cdEntryInfo.getCockBreekingStock());
			    		
//			    		// ������Ϣ
//			    		LayEggDailyImmuneEntryInfo immuneEntryInfo  = new LayEggDailyImmuneEntryInfo();
//			    		immuneEntryInfo.setParent(editData);
//			    		immuneEntryInfo.setHenhouse(henhouseInfo);
//			    		immuneEntryInfo.setHenhouseName(henhouseInfo.getName());
//			    		editData.getImmuneEntrys().add(immuneEntryInfo);
//
//			    		IRow immuneNewrow = this.kdtImmuneEntrys.addRow();
//			    		immuneNewrow.getCell("henhouse").setValue(immuneEntryInfo.getHenhouse());
//			    		immuneNewrow.getCell("henhouseName").setValue(immuneEntryInfo.getHenhouseName());
					}
					// 
				}
			}catch(EASBizException e){
				throw new BOSException(e);
			}
		}
	}
	/**
	 * ҵ�����ڸ���ʱ  �޸� ���� ����
	 */
	protected void pkBizDate_dataChanged(DataChangeEvent e) throws Exception {
		
		Date bizDate = this.pkBizDate.getSqlDate();
		Date newDate = (Date) e.getNewValue();
		
		Date oldDate = (Date) e.getOldValue();
		
		if(newDate != null && oldDate != null && newDate.equals(oldDate)){
			return;
		}
		if(bizDate != null){
			ParentBreedBatchInfo batchInfo = (ParentBreedBatchInfo) this.prmtparentBatch.getValue();
			if(batchInfo != null){
				// ���� ��������
				HashMap weekInfo = parentFacadeFactory.getRemoteInstance().getBatchWeekages(batchInfo.getId().toString(),bizDate);
				Integer currWeek = (Integer) weekInfo.get("currWeek");
				Integer currDay = (Integer) weekInfo.get("currDay");
				
				// �����¼
				clearEntrys();
				// �������� ����
				this.txtweek.setValue(currWeek);
				this.txtweekDay.setValue(currDay);
				if(currWeek>0){
					int sumweek = currWeek-1;
					sumweek = sumweek*7+currDay;
					this.txtsumDay.setValue(sumweek);
					this.editData.setSumDay(sumweek);
				}else{
					int sumweek = currDay;
					this.txtsumDay.setValue(sumweek);
					this.editData.setSumDay(sumweek);
				}
				
				// ����������Ϣ�� ��Ӧ�� ��ֳ�淶���÷�¼��Ϣ
				setAllEntryInfos(batchInfo);
//				this.editData.setWeek(currWeek.intValue());
//				this.editDate.set
			}
		}
		
	}
    
	 /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
    	SelectorItemCollection sic = super.getSelectors();
//    	sic.add(new SelectorItemInfo("costObject.name"));
    	return sic;
    }
    
    /**
     * ��ʼ�� ת����¼ ��������
     */
    private void initTranEntrysFilter(){
    	// ����ת�����ι�������
    	
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
        batch_Prompt.setQueryInfo("com.kingdee.eas.farm.breed.app.F7ParentBreedBatchQuery");
        batch_Prompt.setVisible(true);
        batch_Prompt.setEditable(true);
        batch_Prompt.setDisplayFormat("$number$");
        batch_Prompt.setEditFormat("$number$");
        batch_Prompt.setCommitFormat("$number$");
        batch_Prompt.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(batch_Prompt);
        // ��������
        this.kdtTransHenhouseEntrys.getColumn("fromBatch").setEditor(kdtEntrys_henhouse_CellEditor);
        
        // ���� ����
        updateTransEntryHenhouseFilter(null, null,  "fromHenhouse");
        
        updateTransEntryHenhouseFilter(null, currFarm,  "toHenhouse");
        // ��λ ����
        updateTransEntryFieldFilter(null, null, null, "fromField");
        updateTransEntryFieldFilter(null, null, null, "toField");
    }
    
    
    /**
     * ���� ������������ �����������
     * @param row
     * @param farm
     * @param batchInfo
     * @param fieldName
     */
    private void updateTransEntryHenhouseFilter(IRow row,
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
        // ��ι��Ϣ
//        this.kdtEntrys.getColumn("warehouse").setEditor(kdtEntrys_warehouse_CellEditor);
        // ˮ����Ϣ
        if(row == null){
        	this.kdtTransHenhouseEntrys.getColumn(fieldName).setEditor(kdtEntrys_henhouse_CellEditor);
        }else{
        	row.getCell(fieldName).setEditor(kdtEntrys_henhouse_CellEditor);
        }
        
    }
    
    /**
     * ���� ������������ �����������
     * @param row
     * @param farm
     * @param henhouseInfo
     * @param fieldName
     */
    private void updateTransEntryFieldFilter(IRow row,
    		BreedStoorgSetInfo farm, 
    		HenhouseInfo henhouseInfo,
    		String fieldName){
    	
    	
    	 // ��λ��������
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		// ������ֳ��
		if(farm != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id",farm.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id","",CompareType.EQUALS));
		}
		// ��������
		if(henhouseInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("henhouse.id",henhouseInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("henhouse.id","",CompareType.EQUALS));
		}
		
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%����%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox houseField_PromptBox = new KDBizPromptBox();
        houseField_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7HouseFieldQuery");
        houseField_PromptBox.setVisible(true);
        houseField_PromptBox.setEditable(true);
        houseField_PromptBox.setDisplayFormat("$number$");
        houseField_PromptBox.setEditFormat("$number$");
        houseField_PromptBox.setCommitFormat("$number$");
        houseField_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(houseField_PromptBox);
        // ��ι��Ϣ
//        this.kdtEntrys.getColumn("warehouse").setEditor(kdtEntrys_warehouse_CellEditor);
        // ˮ����Ϣ
        if(row == null){
        	this.kdtTransHenhouseEntrys.getColumn(fieldName).setEditor(kdtEntrys_henhouse_CellEditor);
        }else{
        	row.getCell(fieldName).setEditor(kdtEntrys_henhouse_CellEditor);
        }
        
    }
    /**
     * ת����¼  ��� ʱ   ��������
     * ���ù�����������  �����������  
     * 
     */
    public void kdtTransHenhouseEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
    	// ת�����η����仯
    	IRow row = kdtTransHenhouseEntrys.getRow(rowIndex);
    	if(colIndex == kdtTransHenhouseEntrys.getColumnIndex("fromBatch")){
    		ParentBreedBatchInfo batchInfo = (ParentBreedBatchInfo) kdtTransHenhouseEntrys.getCell(rowIndex, colIndex).getValue();
    		BreedStoorgSetInfo fromFarm = null;
    		if(batchInfo != null){
    			fromFarm = batchInfo.getFarm();
    		}
    		// ת���������
    		updateTransEntryHenhouseFilter(row, fromFarm,  "fromHenhouse");
    		// ת����λ����
    		
    	}else if(colIndex == kdtTransHenhouseEntrys.getColumnIndex("fromHenhouse")){
    		HenhouseInfo fromHenhouse = (HenhouseInfo) kdtTransHenhouseEntrys.getCell(rowIndex, colIndex).getValue();
    		BreedStoorgSetInfo fromFarm = null;
    		if(fromHenhouse != null){
    			fromFarm = fromHenhouse.getFarm();
    		}
    		// ת���������
    		updateTransEntryFieldFilter(row, fromFarm, fromHenhouse, "fromField");
    		
    	}else if(colIndex == kdtTransHenhouseEntrys.getColumnIndex("toHenhouse")){
    		HenhouseInfo toHenhouse = (HenhouseInfo) kdtTransHenhouseEntrys.getCell(rowIndex, colIndex).getValue();
    		BreedStoorgSetInfo toFarm = null;
    		if(toHenhouse != null){
    			toFarm = toHenhouse.getFarm();
    		}
    		// ת���������
    		updateTransEntryFieldFilter(row, toFarm, toHenhouse, "toField");
    		
    	}
    }
    /**
     * ���Է�¼�����仯 
     * �������Ժ��Զ������Ƿ�
     * output kdtCullDeathEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtCullDeathEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
           
	    if ("henhouse".equalsIgnoreCase(kdtCullDeathEntrys.getColumn(colIndex).getKey())) {
	    	kdtCullDeathEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtCullDeathEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));
		
		}
	    HenhouseInfo henInfo = (HenhouseInfo) this.kdtCullDeathEntrys.getCell(rowIndex, "henhouse").getValue();
    	
	    // ���᲻��Ϊ�� ͬʱ ���δ��� �Զ����� ������
    	if(henInfo != null && batchEntryDetailInfos != null ){
    		ParentBreedBatchEntryDetailInfo entryDetailInfo = batchEntryDetailInfos.get(henInfo.getId().toString());
    		if(entryDetailInfo != null){
			    // ĸ������¼��
			    if("henDeath".equals(this.kdtCullDeathEntrys.getColumn(colIndex).getFieldName()) || 
			    		"henCull".equals(this.kdtCullDeathEntrys.getColumn(colIndex).getFieldName()) ||
			    		"henBatchCull".equals(this.kdtCullDeathEntrys.getColumn(colIndex).getFieldName())){
		    	
	    			int nowHenqty = entryDetailInfo.getHenNowQty();
	    			// ���� ������
	    			Integer henDeath = (Integer) this.kdtCullDeathEntrys.getCell(rowIndex, "henDeath").getValue();
	    			int henDeathInt = (henDeath == null? 0 :henDeath.intValue());
	    			Integer henCull = (Integer) this.kdtCullDeathEntrys.getCell(rowIndex, "henCull").getValue();
	    			int henCullInt = (henCull == null? 0 :henCull.intValue());
	    			Integer henBatchCull = (Integer) this.kdtCullDeathEntrys.getCell(rowIndex, "henBatchCull").getValue();
	    			int henBatchCullInt = (henBatchCull == null? 0 :henBatchCull.intValue());
	    			
	    			int stayHenQty = nowHenqty-henDeathInt-henCullInt-henBatchCullInt;
	    			this.kdtCullDeathEntrys.getCell(rowIndex, "henhouseBreekingStock").setValue(stayHenQty);
	    		}
			    // ��������¼��
			    if("cockDeath".equals(this.kdtCullDeathEntrys.getColumn(colIndex).getFieldName()) || 
			    		"cockCull".equals(this.kdtCullDeathEntrys.getColumn(colIndex).getFieldName()) ||
			    		"cockBatchCull".equals(this.kdtCullDeathEntrys.getColumn(colIndex).getFieldName())){
		    	
	    			int nowcockqty = entryDetailInfo.getCockNowQty();
	    			// ���� ������
	    			Integer cockDeath = (Integer) this.kdtCullDeathEntrys.getCell(rowIndex, "cockDeath").getValue();
	    			int cockDeathInt = (cockDeath == null? 0 :cockDeath.intValue());
	    			Integer cockCull = (Integer) this.kdtCullDeathEntrys.getCell(rowIndex, "cockCull").getValue();
	    			int cockCullInt = (cockCull == null? 0 :cockCull.intValue());
	    			Integer cockBatchCull = (Integer) this.kdtCullDeathEntrys.getCell(rowIndex, "cockBatchCull").getValue();
	    			int cockBatchCullInt = (cockBatchCull == null? 0 :cockBatchCull.intValue());
	    			
	    			int staycockQty = nowcockqty-cockDeathInt-cockCullInt-cockBatchCullInt;
	    			
	    			this.kdtCullDeathEntrys.getCell(rowIndex, "cockBreekingStock").setValue(staycockQty);
	    		}
			    
	    	}
	    	
	    }
	    	
    }
    
    
    /**
     * ��ι��¼����
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            
			if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			    	kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));
			
			}
			
			    if ("henMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			    	kdtEntrys.getCell(rowIndex,"henMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henMaterial").getValue(),"name")));
			
			}
			
			    if ("cockMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			    	kdtEntrys.getCell(rowIndex,"cockMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"cockMaterial").getValue(),"name")));
			
			}
		    if ("henMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
		    	kdtEntrys.getCell(rowIndex,"henMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henMaterial").getValue(),"name")));

		    	}

		    if ("cockMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
		    	kdtEntrys.getCell(rowIndex,"cockMaterialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"cockMaterial").getValue(),"model")));
		    }

    }
    
    /**
     * output kdtLayEggEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtLayEggEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
         
	    if ("henhouse".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
	    	kdtLayEggEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtLayEggEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));
		
		}


	    if ("eggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
	    	kdtLayEggEntrys.getCell(rowIndex,"allEggs").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"eggs").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"floorEggs").getValue())));

	    }

	    if ("floorEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
	    	kdtLayEggEntrys.getCell(rowIndex,"allEggs").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"eggs").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"floorEggs").getValue())));
	
		}
	    if ("qualifiedEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey()) || 
	    		"freakEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey()) ||
	    		"doubleYolkEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())||
	    		"brokenEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey()) ||
	    		"floorEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
	    	kdtLayEggEntrys.getCell(rowIndex,"allEggs").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(
	    			UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"qualifiedEggs").getValue())+
	    			UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"freakEggs").getValue()) + 
	    			UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"doubleYolkEggs").getValue()) + 
	    			UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"brokenEggs").getValue())));
	
		}
	    
    }

  


    /**
     * output kdtAssEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtAssEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
         
	    if ("henhouse".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
			kdtAssEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtAssEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));
			
		}


    }

   

    /**
     * �������ε���
     */
	@Override
	public void actionGenNextBill_actionPerformed(ActionEvent e)
			throws Exception {
		try{
			List<ExecBotpResultInfo> result = LayEggDailyFactory.getRemoteInstance().genNextBill(editData);
			if(result != null && result.size() > 0){
				showGennextBillResult(this,result);
			}
			this.setMessageText("�������ε������");
			this.showMessage();
		}catch (FarmException fe) {
			fe.printStackTrace();
			MsgBox.showInfo(fe.getMessage());
		}
	}
	
	
	/**
	 * ��ʾִ�н��
	 * @param result
	 * @throws UIException 
	 */
    public void showGennextBillResult(CoreBillEditUI ui,List<ExecBotpResultInfo> result) throws UIException{
    	UIContext uiContext = new UIContext(ui);
    	uiContext.put("resultInfos", result);
    	
    	IUIWindow window = null;
    	window = UIFactory.createUIFactory(UIFactoryName.NEWWIN).create("com.kingdee.eas.farm.breed.client.ExecBotpResultUI", uiContext, null, OprtState.ADDNEW);
    	window.show();
    }
    /**
     * ˢ�µ������
     */
	@Override
	public void actionRefreshInventory_actionPerformed(ActionEvent e)
			throws Exception {

		StorageOrgUnitInfo currOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
		if(this.editData != null && com.kingdee.eas.scm.common.BillBaseStatusEnum.AUDITED.equals(this.editData.getBaseStatus())){
			return;
		}
		if(currOrgInfo != null){
			this.refreshConveyorInventory(currOrgInfo);
		}
	}
	@Override
	protected void setFieldsNull(AbstractObjectValue obj) {
		// TODO Auto-generated method stub
    	LayEggDailyInfo info = (LayEggDailyInfo)obj;
    	info.setBaseStatus(BillBaseStatusEnum.ADD);
    	Date bizDate = new java.util.Date();
    	info.setBizDate(bizDate);
    	try {
    	if(bizDate != null){
    		ParentBreedBatchInfo  batchInfo=info.getParentBatch();
			if(batchInfo != null){
				// ���� ��������
				HashMap weekInfo = BreedFacadeFactory.getRemoteInstance().getBatchWeekages(batchInfo.getId().toString(),bizDate);
				Integer currWeek = (Integer) weekInfo.get("currWeek");
				Integer currDay = (Integer) weekInfo.get("currDay");
				info.setWeek(currWeek);
				info.setWeekDay(currDay);
				if(currWeek>0){
					int sumweek = currWeek-1;
					sumweek = sumweek*7+currDay;
					info.setSumDay(sumweek);
				}else{
					int sumweek = currDay;
					info.setSumDay(sumweek);
				}
			}
		}
    	}catch(Exception e) {
    		
    	}
		super.setFieldsNull(info);
	}
//	/**
//	 * �Ƿ��� ѡ���¼�
//	 * ���ò����ɱ������ѡ
//	 */
//	@Override
//	protected void chkisFixed_actionPerformed(ActionEvent e) throws Exception {
//		boolean isFixed = chkisFixed.isSelected();
//		if(isFixed){
//			// ���ÿɱ༭ ���� ����ʱ��У�� �Ƿ� ���ò����ɱ�����
//			this.prmtlayEggCostObject.setEnabled(true);
//			
//		}else{
//			// ���ò��ɱ༭�����ÿ�
//			this.prmtlayEggCostObject.setEnabled(false);
//			this.prmtlayEggCostObject.setValue(null);
//			if(this.editData != null){
//				this.editData.setLayEggCostObject(null);
//			}
//		}
//	}
	/**
	 * ת����  ѡ�� 
	 * ���� ���ɳɱ������ѡ
	 */
	@Override
	protected void chkisTransBrood_actionPerformed(ActionEvent e)
			throws Exception {
		boolean isTransBrood = chkisTransBrood.isSelected();
		if(isTransBrood){
			// ���ÿɱ༭ ���� ����ʱ��У�� �Ƿ� �������ɳɱ�����
			this.prmtbroodCostObject.setEnabled(true);
			
		}else{
			// ���ò��ɱ༭�����ÿ�
			this.prmtbroodCostObject.setEnabled(false);
			this.prmtbroodCostObject.setValue(null);
			if(this.editData != null){
				this.editData.setBroodCostObject(null);
			}
		}
	}

}