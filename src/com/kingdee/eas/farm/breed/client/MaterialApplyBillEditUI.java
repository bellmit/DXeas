/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryFactory;
import com.kingdee.eas.farm.breed.BreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.MaterialApplyBillEntryHenhouseEntryInfo;
import com.kingdee.eas.farm.breed.MaterialApplyBillEntryInfo;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.eas.wlhlcomm.impl.DetailPanelBackListener;

/**
 * output class name
 */
public class MaterialApplyBillEditUI extends AbstractMaterialApplyBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MaterialApplyBillEditUI.class);
    
    // 所选批次 鸡舍入栏日期
    private Map<String,Date> batchEncoopDates;
    // 标准饲喂周期
    private int standardAllFeedDays;
    // 最短饲喂周期
    private int limitedFeedDays;
    
    
    /**
     * output class constructor
     */
    public MaterialApplyBillEditUI() throws Exception
    {
        super();
        // 初始化map
        batchEncoopDates = new HashMap<String, Date>();
        
        BreedModelInfo currModel = BreedFacadeFactory.getRemoteInstance().getBreedModelByHouseType(HenhouseType.CC_VALUE);
        if(currModel == null){
        	MsgBox.showInfo("没有找到合适的养殖规范，请联系管理员");
        	SysUtil.abort();
        }else{
        	standardAllFeedDays = currModel.getBreedDays();
        	limitedFeedDays = currModel.getLimitBreedDays();
        	// 如果标准饲喂周期 小于等于0 则提示
        	if(standardAllFeedDays <= 0){
        		MsgBox.showInfo("请联系管理员维护养殖规范中维护的标准饲喂周期");
            	SysUtil.abort();
        	}
        }
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.MaterialApplyBillFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.breed.MaterialApplyBillInfo objectValue = new com.kingdee.eas.farm.breed.MaterialApplyBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        objectValue.setStoOrg(SysContext.getSysContext().getCurrentStorageUnit());
        UserInfo currUser = SysContext.getSysContext().getCurrentUserInfo();
        PersonInfo currPerson = currUser.getPerson();
        objectValue.setApplyPerson(currPerson);
        return objectValue;
    }
    
    
    /**
     * 分录更新
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
	     super.kdtEntrys_Changed(rowIndex, colIndex);
	    
	     
	     // 选中物料时，获取对应的药残日期，计算出是否合适
	     if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	 MaterialInfo currMaterial = (MaterialInfo) kdtEntrys.getCell(rowIndex,"material").getValue();
	    	 int residueDays = 0;
	    	 if(currMaterial != null){
	    		 residueDays = BreedFacadeFactory.getRemoteInstance().getMaterialResidueDays(currMaterial.getId().toString());
	    	 }
	    	 // 清理分录
//	    	 MaterialApplyBillEntryInfo entry =  (MaterialApplyBillEntryInfo) kdtEntrys.getRow(rowIndex).getUserObject();
//	    	 this.kdtHenhouseEntry.removeRows();
//	    	 if(entry != null){
//	    		 entry.getHenhouseEntry().clear();
//	    		 entry.getHenhouseEntry();
//	    	 }
	    	 
	    	 
	    	 // 设置分录 药残时间
	    	 kdtEntrys.getCell(rowIndex,"residueDays").setValue(residueDays);
	    	 
	    	 
    	 }
	     // 日期更新后更新对应分录
	     if ("useDays".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()) ||
	    		 "useDate".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()) || 
	    		 "material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	 updateHenhouseDays();
	     }
	     
	}
    /**
     * 更新鸡舍分录日期
     * @throws BOSException 
     */
    public void updateHenhouseDays() throws BOSException{
    	// 空栏期 不考虑残留时间
    	if(this.chkisEmpty.isSelected())return;
    	if(kdtHenhouseEntry.getRowCount() <= 0) return;
    	MaterialApplyBillEntryInfo focusEntryInfo = getFocusEntryInfo();
    	if(focusEntryInfo != null){
    		for(int i = 0; i < kdtHenhouseEntry.getRowCount(); i++){
		    	 HenhouseInfo currHenhouseInfo = (HenhouseInfo) kdtHenhouseEntry.getCell(i,"henhouse").getValue();
		    	 if(currHenhouseInfo != null){
			    	 Date incoopDate = batchEncoopDates.get(currHenhouseInfo.getId().toString());
//			    	 // 鸡舍明细信息
			    	 MaterialApplyBillEntryHenhouseEntryInfo henhouseEntryInfo = (MaterialApplyBillEntryHenhouseEntryInfo) kdtHenhouseEntry.getRow(i).getUserObject();
			    	 
			    	 // 使用开始和结束日龄计算
			    	 Date beginUseDate = focusEntryInfo.getUseDate();
			    	 
			    	 
			    	 
			    	 int beginDays = DateCommon.dateDiff(incoopDate, beginUseDate);
			    	 
			    	 int endDays = beginDays + focusEntryInfo.getUseDays();
			    	 // 药残日龄
			    	 int safeDays = endDays + focusEntryInfo.getResidueDays();
			    	 Calendar cal = Calendar.getInstance();
			    	 cal.setTime(incoopDate);
			    	 cal.add(Calendar.DATE, safeDays);
			    	 Date safeDate = cal.getTime();
			    	 kdtHenhouseEntry.getCell(i,"beginDays").setValue(beginDays);
			    	 kdtHenhouseEntry.getCell(i,"endDays").setValue(endDays);
			    	 kdtHenhouseEntry.getCell(i,"safeDays").setValue(safeDays);
			    	 kdtHenhouseEntry.getCell(i,"safeDate").setValue(safeDate);
			    	if(henhouseEntryInfo != null){
			    		henhouseEntryInfo.setBeginDays(beginDays);
			    		henhouseEntryInfo.setEndDays(endDays);
			    		henhouseEntryInfo.setSafeDays(safeDays);
			    		henhouseEntryInfo.setSafeDate(safeDate);
			    	}
			    	 
			     }else{
			    	 kdtHenhouseEntry.getCell(i,"beginDays").setValue(0);
			    	 kdtHenhouseEntry.getCell(i,"endDays").setValue(0);
			    	 kdtHenhouseEntry.getCell(i,"safeDays").setValue(0);
			    	 // 鸡舍明细信息
			    	 MaterialApplyBillEntryHenhouseEntryInfo henhouseEntryInfo = (MaterialApplyBillEntryHenhouseEntryInfo) kdtHenhouseEntry.getRow(i).getUserObject();
			    	 if(henhouseEntryInfo != null){
				    		henhouseEntryInfo.setBeginDays(0);
				    		henhouseEntryInfo.setEndDays(0);
				    		henhouseEntryInfo.setSafeDays(0);
				    	}
			     }
		    	 
    		}
    	}
    }
    
   
    
    /**
     * 界面初始化 
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		// 初始界面控件
		initUI();
		
		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);
			
		}else {
			if(this.getOprtState().equals("EDIT")){
				checkCanEdit();
				
			}
			
		}
		
		
        
        // 
        this.baseStatus.setEnabled(false);
        this.baseStatus.setEditable(false);
        this.pkauditTime.setEditable(false);
        this.pkauditTime.setEnabled(false);
        this.prmtstoOrg.setEnabled(false);
        this.prmtstoOrg.setEditable(false);
        // 养殖场变了以后 分录要全部删除 
        this.prmtstoOrg.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                	prmtstoOrg_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                	
                }
            }

			
        });
        // 初始化调用批次更改事件
        prmtbreedBatch_dataChanged(null);
        // 养殖场变了以后 分录要全部删除 
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
        
        kdtHenhouseEntry.addKDTEditListener(new KDTEditAdapter() {
    		public void editStopped(KDTEditEvent e) {
    			try {
    				kdtHenhouseEntrys_Changed(e);
    			}
    			catch (Exception exc) {
    				handUIException(exc);
    			}
    		}
    	});
        
        // 鸡舍明细 新增或者 插入分录 时 校验 单元格信息
        kdtHenhouseEntry_detailPanel.addAddListener(new DetailPanelBackListener(){
        	  public void beforeEvent(DetailPanelEvent event)
              throws Exception {
        		  MaterialApplyBillEntryInfo focusEntry = getFocusEntryInfo();
        		  if(focusEntry == null){
        			  SysUtil.abort();
        		  }
        	  }
        });
        kdtHenhouseEntry_detailPanel.addInsertListener(new DetailPanelBackListener(){
      	  public void beforeEvent(DetailPanelEvent event)
            throws Exception {
      		  MaterialApplyBillEntryInfo focusEntry = getFocusEntryInfo();
	   		  if(focusEntry == null){
	   			  SysUtil.abort();
	   		  }
      	  }
        });
        
	}
    
    /**
     * 鸡舍列表 编辑时，同步更新开始日期、结束日期
     * @param rowIndex
     * @param colIndex
     * @throws BOSException 
     */
    protected void kdtHenhouseEntrys_Changed(KDTEditEvent e) throws BOSException {
    	
    	int rowIndex = e.getRowIndex();
    	int colIndex = e.getColIndex();
    	Object oldValue = e.getOldValue() ;
    	Object newValue = e.getValue();
    	
    	// 清空 开始和结束日龄
    	kdtHenhouseEntry.getCell(rowIndex,"beginDays").setValue(0);
    	kdtHenhouseEntry.getCell(rowIndex,"endDays").setValue(0);
    	
    	MaterialApplyBillEntryInfo forcusEntryInfo = getFocusEntryInfo();
    	
    	 // 选中物料时，获取对应的药残日期，计算出是否合适
	     if (forcusEntryInfo != null && "henhouse".equalsIgnoreCase(kdtHenhouseEntry.getColumn(colIndex).getKey())) {
	    	 HenhouseInfo currHenhouseInfo = (HenhouseInfo) kdtHenhouseEntry.getCell(rowIndex,"henhouse").getValue();
	    	 if(currHenhouseInfo != null){
		    	 Date incoopDate = batchEncoopDates.get(currHenhouseInfo.getId().toString());
		    	 
		    	 if(incoopDate == null){
		    		 MsgBox.showInfo("未取到鸡舍入栏日期信息，请核对使用鸡舍是否为当前申请批次对应鸡舍");
		    		 SysUtil.abort();
		    	 }
		    	 // 鸡舍明细信息
		    	 MaterialApplyBillEntryHenhouseEntryInfo henhouseEntryInfo = (MaterialApplyBillEntryHenhouseEntryInfo) kdtHenhouseEntry.getRow(rowIndex).getUserObject();
		    	 
		    	 // 使用开始和结束日龄计算
		    	 Date beginUseDate = forcusEntryInfo.getUseDate();
		    	 
		    	 
		    	 
		    	 int beginDays = DateCommon.dateDiff(incoopDate, beginUseDate);
		    	 
		    	 int endDays = beginDays + forcusEntryInfo.getUseDays();
		    	 // 药残日龄
		    	 int safeDays = endDays + forcusEntryInfo.getResidueDays();
		    	 Calendar cal = Calendar.getInstance();
		    	 cal.setTime(incoopDate);
		    	 cal.add(Calendar.DATE, safeDays);
		    	 Date safeDate = cal.getTime();
		    	 
		    	 kdtHenhouseEntry.getCell(rowIndex,"beginDays").setValue(beginDays);
		    	 kdtHenhouseEntry.getCell(rowIndex,"endDays").setValue(endDays);
		    	 kdtHenhouseEntry.getCell(rowIndex,"safeDays").setValue(safeDays);
		    	 kdtHenhouseEntry.getCell(rowIndex,"safeDate").setValue(safeDate);
		     }else{
		    	 kdtHenhouseEntry.getCell(rowIndex,"beginDays").setValue(0);
		    	 kdtHenhouseEntry.getCell(rowIndex,"endDays").setValue(0);
		    	 kdtHenhouseEntry.getCell(rowIndex,"safeDays").setValue(0);
		    	 kdtHenhouseEntry.getCell(rowIndex,"safeDate").setValue(null);
		     }
	    	 
	     }
		
	}
    
    
    
    /**
     * 获取当前焦点的 分录 info
     * @return
     */
    private MaterialApplyBillEntryInfo getFocusEntryInfo() {
    	MaterialApplyBillEntryInfo entryInfo = new MaterialApplyBillEntryInfo();
    	entryInfo.setParent(editData);
    	// 获得选中行
    	int rowIndex = -1;
    	
    	// 获取选中的最上面一行
    	ArrayList blocks = kdtEntrys.getSelectManager().getBlocks(); 
    	ArrayList idList = new ArrayList();  
    	Iterator iter = blocks.iterator();   
    	if (iter.hasNext()) {    
    		KDTSelectBlock block = (KDTSelectBlock) iter.next();  
    		rowIndex = block.getTop();   
    		
    	}
    	
    	if(rowIndex >= 0){
	    	// 获取选中行的基本信息
	    	MaterialInfo materialInfo = (MaterialInfo) this.kdtEntrys.getCell(rowIndex, "material").getValue();
	    	if(materialInfo == null){
	    		MsgBox.showInfo("请先设置申请明细分录【物料】");
	    		SysUtil.abort();
	    	}
	    	int residueDays = (Integer) this.kdtEntrys.getCell(rowIndex, "residueDays").getValue();
//	    	if(residueDays == 0){
//	    		MsgBox.showInfo("申请明细物料药残时间未正常设置，请联系管理员");
//	    		SysUtil.abort();
//	    	}
	    	BigDecimal qty = (BigDecimal) this.kdtEntrys.getCell(rowIndex, "baseQty").getValue();
	    	if(qty == null || qty.compareTo(BigDecimal.ZERO) == 0){
	    		MsgBox.showInfo("请先设置申请明细分录【申请数量】");
	    		SysUtil.abort();
	    	}
	    	int useDays = (Integer) this.kdtEntrys.getCell(rowIndex, "useDays").getValue();
	    	if(useDays == 0){
	    		MsgBox.showInfo("请先设置申请明细分录 【使用天数】");
	    		SysUtil.abort();
	    	}
	    	Date beginUseDate =  (Date) this.kdtEntrys.getCell(rowIndex, "useDate").getValue();
	    	if(beginUseDate == null){
	    		MsgBox.showInfo("请先设置申请明细分录计划【开始使用日期】");
	    		SysUtil.abort();
	    	}
	    	
	    	// 设置分录信息
	    	entryInfo.setMaterial(materialInfo);
	    	entryInfo.setBaseQty(qty);
	    	entryInfo.setResidueDays(residueDays);
	    	entryInfo.setUseDays(useDays);
	    	entryInfo.setUseDate(beginUseDate);
	    	
	    	return entryInfo;
    	}
    	return null;
	}

	/**
     * 养殖批次 变化
     * @param e
     * @throws BOSException 
     * @throws EASBizException 
     */
    public void prmtbreedBatch_dataChanged(DataChangeEvent e) throws EASBizException, BOSException {
		BreedBatchInfo currBatchInfo = (BreedBatchInfo) prmtbreedBatch.getValue();
		BreedBatchEntryCollection entryColl = null;
		
		
		if(currBatchInfo != null){
			entryColl = currBatchInfo.getEntrys();
		}
		
		if(currBatchInfo != null){
			if(HenhouseType.CC_VALUE.equals(currBatchInfo.getHouseType().getValue())){
				// 批次中的分录逐个设置
				for(int i = 0; entryColl != null && i < entryColl.size(); i++){
					BreedBatchEntryInfo entryInfo = entryColl.get(i);
					
					entryInfo = BreedBatchEntryFactory.getRemoteInstance().getBreedBatchEntryInfo(new ObjectUuidPK(entryInfo.getId()));
					HenhouseInfo henhouseInfo = entryInfo.getHenHouse();
					henhouseInfo = HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(henhouseInfo.getId()));
					// 保存日龄
					Date encoopDate = entryInfo.getIncoopDate();
					
					if(encoopDate == null) //encoopDate = batchInfo.getBizDate();
					{
						MsgBox.showInfo("对应批次的分录中的入栏日期为空，请先维护好批次信息后再录入申请");
						SysUtil.abort();
					}
					batchEncoopDates.put(henhouseInfo.getId().toString(), encoopDate);
					
				}
			}else{
				Date bizDate = currBatchInfo.getBizDate();
				if(bizDate == null) //encoopDate = batchInfo.getBizDate();
				{
					MsgBox.showInfo("对应批次的入栏日期为空，请先维护好批次信息后再录入申请");
					SysUtil.abort();
				}
				
				for(int i = 0; entryColl != null && i < entryColl.size(); i++){
					BreedBatchEntryInfo entryInfo = entryColl.get(i);
					
					entryInfo = BreedBatchEntryFactory.getRemoteInstance().getBreedBatchEntryInfo(new ObjectUuidPK(entryInfo.getId()));
					HenhouseInfo henhouseInfo = entryInfo.getHenHouse();
					
					batchEncoopDates.put(henhouseInfo.getId().toString(), bizDate);
					
				}
			}
		}else{
			batchEncoopDates = new HashMap<String, Date>();
			
		}
	}
    
    /**
     * 养殖场 变化
     * 删除所有分录，同时更新鸡舍过滤条件
     * @param e
     */
    private void prmtstoOrg_dataChanged(DataChangeEvent e) {
		// TODO Auto-generated method stub
		StorageOrgUnitInfo currSto = (StorageOrgUnitInfo) e.getNewValue();
		// 设置鸡舍过滤条件
		setHenhouseFilter(currSto);
	}
    
    /**
     * 设置鸡舍过滤条件
     */
	private void setHenhouseFilter(StorageOrgUnitInfo currSto){
		
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.CC_VALUE,CompareType.EQUALS));
        if(currSto != null){
        	filter.getFilterItems().add(new FilterItemInfo("chickenFarm.id",currSto.getId().toString(),CompareType.EQUALS));
        }else{
        	filter.getFilterItems().add(new FilterItemInfo("chickenFarm.id","",CompareType.EQUALS));
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
        this.kdtHenhouseEntry.getColumn("henhouse").setEditor(kdtEntrys_henHouse_CellEditor);
        ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
        kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHenhouseEntry.getColumn("henhouse").setRenderer(kdtEntrys_henHouse_OVR);
			
			
	       
		
	}
    /**
     * 清除分录
     */
    private void removeAllEntrys(){
    	this.kdtEntrys.removeRows();
    	this.kdtHenhouseEntry.removeRows();
    	
    }
    /**
     * 设置默认值output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
        vo.put("bizDate", new Date());
        
        UserInfo currUser = SysContext.getSysContext().getCurrentUserInfo();
        PersonInfo currPerson = currUser.getPerson();
        if(currPerson != null){
        	vo.put("applyPerson", currPerson);
        }
        // 默认养殖场
        vo.put("stoOrg", SysContext.getSysContext().getCurrentStorageUnit());
     // 设置鸡舍过滤条件
		setHenhouseFilter(SysContext.getSysContext().getCurrentStorageUnit());
    }
    /**
     * 初始化界面组件信息
     */
    private void initUI(){
    	
    	 // 养殖场 过滤
    	EntityViewInfo evi = new EntityViewInfo();
    	FilterInfo filter = new FilterInfo();
         // 
//        filter.getFilterItems().add(new FilterItemInfo("longNumber","%!3022!%",CompareType.LIKE));
        evi.setFilter(filter);
        
        this.prmtstoOrg.setEntityViewInfo(evi);


    	// 操作员过滤
    	 // prmtapplyPerson		
        this.prmtapplyPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtapplyPerson.setVisible(true);		
        this.prmtapplyPerson.setEditable(true);		
        this.prmtapplyPerson.setDisplayFormat("$name$");		
        this.prmtapplyPerson.setEditFormat("$number$");		
        this.prmtapplyPerson.setCommitFormat("$number$");		
        this.prmtapplyPerson.setRequired(true);
        evi = new EntityViewInfo();
        filter = new FilterInfo();
         // 组织是孵化场的人
        filter.getFilterItems().add(new FilterItemInfo("AdminOrgUnit.displayName","%"+SysContext.getSysContext().getCurrentStorageUnit().getName()+"%",CompareType.LIKE));
        evi.setFilter(filter);
//        SorterItemCollection sorter = new SorterItemCollection();
//        SorterItemInfo sortItem = new SorterItemInfo("bizDate");
//        sortItem.setSortType(SortType.DESCEND);
//        sorter.add(sortItem);
//        evi.setSorter(sorter);
        this.prmtapplyPerson.setEntityViewInfo(evi);
      

        evi = new EntityViewInfo();
        filter = new FilterInfo();
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
        this.prmtbreedBatch.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchF7Query");		
        this.prmtbreedBatch.setEntityViewInfo(evi);
        
        
        
    }
  
    
    
    /**
     * 校验当前组织是否是单据创建组织，如果不是，提示消息中断操作
     */
    private void checkCanEdit(){
    	CtrlUnitInfo cu = SysContext.getSysContext().getCurrentCtrlUnit();
		CtrlUnitInfo billCU = this.editData.getCU();
		
		if(billCU != null){
			if(!cu.getId().toString().equals(billCU.getId().toString())){
				MsgBox.showWarning("当前组织不是单据创建组织，不能修改单据");
				SysUtil.abort();
			}
		}
    }
    
   
    
    @Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
    	try{
			super.actionSubmit_actionPerformed(e);
			reloadData();
    	}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionSave_actionPerformed(e);
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
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
			MsgBox.showWarning("反审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	/**
	 * 校验
	 */
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		

		super.beforeStoreFields(arg0);
		
		if(!this.chkisEmpty.isSelected()){
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedBatch.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖批次"});
			}
		}

		
		// 添加校验
		checkData();
	}
	/**
     * 校验数据 
     * 
     */
    private void checkData(){
//    	for (int i=0,n=kdtHenhouseEntry.getRowCount();i<n;i++) {
//    		int safeDays = (Integer) kdtHenhouseEntry.getCell(i,"safeDays").getValue();
//    		// 安全日期 大于 标准饲喂日期
//    		if(safeDays > standardAllFeedDays){
//    			MsgBox.showInfo("存在安全宰杀日龄大于标准饲喂周期"+standardAllFeedDays+"的鸡舍，不能保存数据");
//            	SysUtil.abort();
//    		}
//		}
    	
    }


}