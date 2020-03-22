/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.EventListener;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
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
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BreedBatchEditUI extends AbstractBreedBatchEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BreedBatchEditUI.class);
    
    /**
     * output class constructor
     */
    public BreedBatchEditUI() throws Exception
    {
        super();
        // 设置全屏ds
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
        // 图标设置
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.CC.getValue(),CompareType.EQUALS));
        CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
        filter.getFilterItems().add(new FilterItemInfo("CU.id",cuInfo.getId().toString(),CompareType.EQUALS));
        // 设置默认当前库存组织所有禽舍信息
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
        
        // 过滤成本对象
        //initCostObjectFilter();
		
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
        return com.kingdee.eas.farm.breed.BreedBatchFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
		vo.put("houseType","1");
        
    }  
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.BreedBatchInfo objectValue = new com.kingdee.eas.farm.breed.BreedBatchInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        objectValue.setStoOrg(SysContext.getSysContext().getCurrentStorageUnit());
//        ObjectVa
        return objectValue;
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
			
			//add by dai 20150821
			if(this.houseType.getSelectedIndex()!=-1) {
				if(this.houseType.getSelectedItem().equals(HenhouseType.CC)) {//商品禽舍
					if(this.prmtbreedPlan.getValue()==null) {
						MsgBox.showWarning("养殖计划不能为空");
						SysUtil.abort();
					}
				}
			}
			///8********************
			
			try{
				HenhouseType selHenhouseType = (HenhouseType) this.houseType.getSelectedItem();
				
				if(HenhouseType.Brood.equals(selHenhouseType) || HenhouseType.LayEgg.equals(selHenhouseType)){
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
				}else if(HenhouseType.CC.equals(selHenhouseType)){
					// 商品鸡 计划不能为空
					if(this.prmtbreedPlan.getValue() == null){
						MsgBox.showWarning("商品鸡 养殖计划不能为空 ");
						SysUtil.abort();
					}
//					this.txtdays.commitEdit();
//					int days = this.txtdays.getIntegerValue();
//					if(days < 0){//modify by simple_dai
//						MsgBox.showWarning("入栏日龄不能小于0 ");
//						SysUtil.abort();
//					}else if(days > 40){
//						MsgBox.showWarning("入栏日龄过大 ");
//						SysUtil.abort();
//					}
					
				}
				
				//
				
				for(int i = 0; i < this.kdtEntrys.getRowCount(); i++){
					Date incoopDate = (Date) this.kdtEntrys.getCell(i, "incoopDate").getValue();
					Integer initQty = (Integer) this.kdtEntrys.getCell(i, "initQty").getValue();
					Integer henQty = (Integer) this.kdtEntrys.getCell(i, "henQty").getValue();
					Integer cockQty = (Integer) this.kdtEntrys.getCell(i, "cockQty").getValue();
					//  商品鸡分录所有 入栏日期、入栏量不能为空
					if(HenhouseType.CC.equals(selHenhouseType)){
						if(incoopDate == null){
							MsgBox.showWarning("分录中入栏日期不能为空");
							SysUtil.abort();
						}
					
					}else if(HenhouseType.Brood.equals(selHenhouseType)){
						
					}else if(HenhouseType.LayEgg.equals(selHenhouseType)){
						
					}
				}
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
		// 设置禽舍过滤条件
		this.houseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    //houseType_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
		// 设置禽舍类别
		setHenhouseType();
		// 设置过滤条件
		//setHenhouseFilter();
		
		if("ADDNEW".equals(this.getOprtState())){
			this.baseStatus.setSelectedIndex(1);
		}
		
	}
	
	private void initCostObjectFilter(){
		 // 设置 成本对象过滤条件
        EntityViewInfo view = new EntityViewInfo();
        FilterInfo filterInfo = new FilterInfo();
        StorageOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filterInfo.getFilterItems().add(new FilterItemInfo("description",orgInfo.getName(),CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("StorageOrgUnit.name",orgInfo.getName(),CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("name","商品鸡%",CompareType.LIKE));
		filterInfo.getFilterItems().add(new FilterItemInfo("name","父母代%",CompareType.LIKE));//add by dai 20150820
		filterInfo.getFilterItems().add(new FilterItemInfo("name","商品鸡苗%",CompareType.NOTLIKE));
		filterInfo.setMaskString("(#0 or #1) and (#2 or #3 ) and #4");
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","",CompareType.LIKE));
		SorterItemInfo sortItem = new SorterItemInfo("number");
		sortItem.setSortType(SortType.DESCEND);
		view.getSorter().add(sortItem);
		view.setFilter(filterInfo);
		
		this.prmtcostObject.setEntityViewInfo(view);
	}
	/**
	 * 根据禽舍类别设置可见性
	 */
	private void setHenhouseType(){
		HenhouseType selHenhouseType = (HenhouseType) this.houseType.getSelectedItem();
		// 设置 周龄为空且不可编辑
		if(HenhouseType.CC.equals(selHenhouseType)){
			this.txtdays.setVisible(true);
			this.contdays.setVisible(true);
			
			
			this.txtweek.setVisible(false);
			this.contweek.setVisible(false);
			this.txtweekDay.setVisible(false);
			this.txtweekDay.setVisible(false);
			
			this.kDLabel1.setVisible(false);
			this.kDLabel2.setVisible(false);
			
			this.kdtEntrys.getColumn("incoopDate").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("initQty").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(true);
			
			this.kdtEntrys.getColumn("henFixedQty").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("cockFixedQty").getStyleAttributes().setHided(true);
		}else if(HenhouseType.LayEgg.equals(selHenhouseType)){
			this.txtdays.setVisible(false);
			this.contdays.setVisible(false);
			
			
			this.txtweek.setVisible(true);
			this.contweek.setVisible(true);
			this.contweek.setBoundLabelText("转栏日期");
			this.txtweekDay.setVisible(true);
			this.txtweekDay.setVisible(true);
			
			this.kDLabel1.setVisible(true);
			this.kDLabel2.setVisible(true);
			
			this.kdtEntrys.getColumn("incoopDate").getStyleAttributes().setHided(true);
			
			
			this.kdtEntrys.getColumn("initQty").getStyleAttributes().setHided(true);
			
			this.kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("henFixedQty").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("cockFixedQty").getStyleAttributes().setHided(false);
		}else if(HenhouseType.Brood.equals(selHenhouseType)){
			this.txtdays.setVisible(false);
			this.contdays.setVisible(false);
			
			
			this.txtweek.setVisible(true);
			this.contweek.setVisible(true);
			this.contweek.setBoundLabelText("定栏日期");
			this.txtweekDay.setVisible(true);
			this.txtweekDay.setVisible(true);
			
			this.kDLabel1.setVisible(true);
			this.kDLabel2.setVisible(true);
			
			this.kdtEntrys.getColumn("incoopDate").getStyleAttributes().setHided(true);
			
			
			this.kdtEntrys.getColumn("initQty").getStyleAttributes().setHided(false);
			
			this.kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("henFixedQty").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("cockFixedQty").getStyleAttributes().setHided(true);
		}
	}
	/**
	 * 禽舍类别选中后设置禽舍过滤条件
	 */
	protected void houseType_actionPerformed(ActionEvent e) throws Exception {
		HenhouseType selHenhouseType = (HenhouseType) this.houseType.getSelectedItem();
		
		// 如果修改后的 类别 和分录的 禽舍类别不一致则删除所有分录后设置分录过滤条件
		for(int i = 0; this.kdtEntrys.getRowCount()  > 0 && i < this.kdtEntrys.getRowCount();i++){
			HenhouseInfo henHouse = (HenhouseInfo) this.kdtEntrys.getRow(i).getCell("henHouse").getValue();
			if(henHouse != null){
				henHouse = HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(henHouse.getId()));
				if(selHenhouseType == null || selHenhouseType.getValue().equals(henHouse.getHouseType().getValue())){
					continue;
				}else{
					if(MsgBox.showConfirm2("单据头禽舍类别和分录禽舍类别不一致，确认设置？") != MsgBox.YES){
						SysUtil.abort();
					}else{
						this.kdtEntrys.removeRows();
						this.editData.getEntrys().clear();
					}
				}
			}
		}
		
		// 设置定栏周期 的标签显示
		
		// 禽舍类别选中
		setHenhouseType();
		// 设置分录过滤条件
		//setHenhouseFilter();
	}
	/**
	 * 修改禽舍类别前先提示 会删除分录
	 */
	public void beforeActionPerformed(ActionEvent e){
		
		String ac = e.getActionCommand();
		Object source = e.getSource();
		// 
//		if(source instanceof KDComboBox ){
//			if(this.kdtEntrys.getRowCount() > 0){
//				if("houseType".equals(((KDComboBox)source).getName())){
//					if(MsgBox.showConfirm2("修改禽舍类别后会清除当前分录，确认修改类别？") != MsgBox.YES){
//						SysUtil.abort();
//					}else{
//						this.kdtEntrys.removeRows();
//						this.editData.getEntrys().clear();
//					}
//				}
//			}
//		}
	}
	/**
     * 设置禽舍过滤条件
     */
	private void setHenhouseFilter(){
		HenhouseType selHenhouseType = (HenhouseType) this.houseType.getSelectedItem();
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
        kdtEntrys_henHouse_PromptBox.setEntityViewInfo(evi);
        KDTDefaultCellEditor kdtEntrys_henHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouse_PromptBox);
        this.kdtEntrys.getColumn("henHouse").setEditor(kdtEntrys_henHouse_CellEditor);
        ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
        kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henHouse").setRenderer(kdtEntrys_henHouse_OVR);
			
			
	       
		
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
		if(houseType.getSelectedItem().equals(HenhouseType.CC)) { //商品鸡日龄笔录
			if(StringUtils.isBlank(this.txtdays.getText())) {
				MsgBox.showError("日龄不能为空！");
				SysUtil.abort();
			}
		}else {
			if(StringUtils.isBlank(this.txtweek.getText())||StringUtils.isBlank(this.txtweekDay.getText())) {
				MsgBox.showError("周龄或日龄不能为空！");
				SysUtil.abort();
			}
		}
	}
	
	
    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {


	    if ("henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henHouse").getValue(),"name")));
		}
	    // 计算 养殖密度
	    if ("initQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()) || "henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	HenhouseInfo currHenhouseInfo = (HenhouseInfo) kdtEntrys.getCell(rowIndex,"henHouse").getValue();
	    	int initQty = (Integer) kdtEntrys.getCell(rowIndex,"initQty").getValue();
	    	BigDecimal currDensity = new BigDecimal("0");
	    	if(currHenhouseInfo != null){
	    		currHenhouseInfo = HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(currHenhouseInfo.getId()));
	    		BigDecimal area = currHenhouseInfo.getArea();
	    		if(area != null && area.compareTo(new BigDecimal("0")) != 0){
	    			BigDecimal initQtyBD = new BigDecimal(initQty);
	    			currDensity = initQtyBD.divide(area,2,RoundingMode.HALF_UP);
	    		}
	    	}
	    	// 设置库存
	    	kdtEntrys.getCell(rowIndex,"stockingDensity").setValue(currDensity);
	    }
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
//					newRow.getCell("henHouse").setValue(HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(houseInfo.getId())));
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
		// 只有  商品鸡 才校验计划
		if(HenhouseType.CC.equals((HenhouseType)houseType.getSelectedItem())){
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedPlan.getData())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖计划"});
			}
		}
			
	}
	
}