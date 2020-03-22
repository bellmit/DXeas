/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDTimePicker;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.IStorageOrgUnit;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.delivery.basedata.DeliveryLineCollection;
import com.kingdee.eas.delivery.basedata.DeliveryLineFactory;
import com.kingdee.eas.delivery.basedata.DeliveryLineInfo;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.IBreedBatch;
import com.kingdee.eas.farm.breed.IHenhouse;
import com.kingdee.eas.farm.breed.comm.CCBatchAgeDetailInfo;
import com.kingdee.eas.farm.breed.comm.CCBatchAgeInfo;
import com.kingdee.eas.farm.food.SendCarPlanFacadeFactory;
import com.kingdee.eas.farm.food.orderEnum;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.enums.EnumUtils;

/**
 * output class name
 */
public class FoodSendCarPlanEditUI extends AbstractFoodSendCarPlanEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FoodSendCarPlanEditUI.class);
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private Calendar cal=java.util.Calendar.getInstance();
    /**
     * output class constructor
     */
    public FoodSendCarPlanEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	DataChangeListener[] ls = this.pkBizDate.getListeners(DataChangeListener.class);
    	PropertyChangeListener[] ls2 = this.kdtOrgEntry.getListeners(PropertyChangeListener.class);
        super.loadFields();
        for(int i=0;i<ls.length;i++) {
        	this.pkBizDate.addDataChangeListener(ls[i]);
        }
        for(int i=0;i<ls2.length;i++) {
        	this.kdtOrgEntry.addPropertyChangeListener(ls2[i]);
        }
        BigDecimal carCount=this.txtcarCount.getBigDecimalValue();
        for(int index=0;index<this.kdtEntrys.getRowCount();index++) {
        	 IRow row = this.kdtEntrys.getRow(index);
        	if(carCount.intValue()>1&&(row.getRowIndex()%carCount.intValue())==0) {
    			row.getStyleAttributes().setBackground(new Color(187,205,163));
    		}
        }
        
    }
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}
	
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionRemove_actionPerformed(e);
	}
	/**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
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
        com.kingdee.eas.farm.food.FoodSendCarPlanInfo objectValue = new com.kingdee.eas.farm.food.FoodSendCarPlanInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
        java.util.Date bizDate=new java.util.Date();
        objectValue.setTransferTime(new BigDecimal(50));//平均转舍时间50Min
        objectValue.setAheadTime(BigDecimal.ZERO);
        objectValue.setBizDate(bizDate);
        objectValue.setBillStatus(BillBaseStatusEnum.ADD);
		try {
			bizDate=sdf.parse(sdf.format(bizDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(bizDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select CFBeginHitchTime ");
			sql.append(" from CT_FM_FoodBaseData ");
			sql.append(" where CFStorageOrgUnitID='").append(SysContext.getSysContext().getCurrentStorageUnit().getString("id")).append("'");
			sql.append(" order by FCreateTime desc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				Time d = rs.getTime("CFBeginHitchTime");
				System.out.println(d);
				cal.add(Calendar.HOUR_OF_DAY,d.getHours());
				cal.add(Calendar.MINUTE,d.getMinutes());
			}else {
				cal.add(Calendar.HOUR_OF_DAY, 6);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		objectValue.setHitchTime(new Time(cal.getTime().getTime()));
        return objectValue;
    }
    
	@Override
	protected void btnGetOrgEntys_actionPerformed(ActionEvent e) throws Exception {
		this.kdtOrgEntry.removeRows();
		//Map map = BreedFacadeFactory.getRemoteInstance().getCCBatchAgeAndQty(new java.util.Date(), 42, 50);
		//Iterator iter = map.entrySet().iterator();
		CCBatchAgeInfo ccInfo;
		//String index;
		IStorageOrgUnit iss = StorageOrgUnitFactory.getRemoteInstance();
		IHenhouse ihs = HenhouseFactory.getRemoteInstance();
		IBreedBatch ibs = BreedBatchFactory.getRemoteInstance();
		CCBatchAgeDetailInfo cceInfo;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date nowDateStr, initDateStr;//当前日期，入栏日期
		//while (iter.hasNext()) {
			//Map.Entry entry = (Map.Entry) iter.next();
			//index=(String) entry.getKey();
			//ccInfo = (CCBatchAgeInfo) entry.getValue();
		Object hitchTime = this.pkhitchTime.getValue();
		ArrayList list = SendCarPlanFacadeFactory.getRemoteInstance().getCCBatchAgeAndQty(sdf.parse(sdf.format(hitchTime)),46, 5);
		for(int index=0;index<list.size();index++){
			ccInfo=(CCBatchAgeInfo) list.get(index);
			for(int i=0;i<ccInfo.getDetails().size();i++) {
				cceInfo = ccInfo.getDetails().get(i);
				//if(cceInfo.getNowQty()<1)
					//continue;
				if(cceInfo.getNowQty()<=0) {
					continue;
				}
				IRow row=this.kdtOrgEntry.addRow();
				row.getCell("storageOrg").setValue(iss.getStorageOrgUnitInfo(new ObjectUuidPK(ccInfo.getStoOrgID())));
				row.getCell("batch").setValue(ibs.getBreedBatchInfo(new ObjectUuidPK(ccInfo.getBatchID())));
				row.getCell("henhouse").setValue(ihs.getHenhouseInfo(new ObjectUuidPK(cceInfo.getHenhouseID())));
//				System.out.println(((IPropertyContainer) row.getCell("storageOrg").getValue()).getString("name"));
				nowDateStr=cceInfo.getNowDate();
//				System.out.println(nowDateStr);
				initDateStr=cceInfo.getIncoopDate();
//				System.out.println(initDateStr);
				//nowDateStr=sdf.parse(sdf.format(this.pkBizDate.getValue()));//sdf.parse(sdf.format(nowDateStr));//
				initDateStr=	sdf.parse(sdf.format(initDateStr));
				long diff = nowDateStr.getTime() - initDateStr.getTime();
			    long days = diff / (1000 * 60 * 60 * 24);
				row.getCell("dayAge").setValue(days);
				row.getCell("qty").setValue(cceInfo.getNowQty());
				
			}
		}
	}
	
	/**
	 * 获取派车计划
	 */
	protected void btnOK_actionPerformed(ActionEvent e) throws Exception {
		if(this.prmtstorageOrgUnit.getValue()==null) {
			MsgBox.showWarning("库存组织不能为空！");
			SysUtil.abort();
		}
		String storageOrgID=((AbstractCoreBaseInfo) this.prmtstorageOrgUnit.getValue()).getId().toString();
		BigDecimal carCount = this.txtcarCount.getBigDecimalValue();
		if(carCount==null||carCount.compareTo(BigDecimal.ZERO)<=0) {
			MsgBox.showWarning("派车数量必须>=0!");
			SysUtil.abort();
		}
		IRow row;
		ArrayList<Object> list=new ArrayList<Object>();
		for(int index=0;index<this.kdtOrgEntry.getRowCount();index++) {
			row=this.kdtOrgEntry.getRow(index);
			//if(row.getCell("isSelected").getValue()!=null&&row.getCell("isSelected").getValue().equals(true)) {
			if(row.getCell("order").getValue()!=null&& ((orderEnum)row.getCell("order").getValue()).getValue()>0) {
				System.out.println(index);
				HashMap<String,Object> tempMap=new HashMap<String,Object>();
				tempMap.put("order", ((orderEnum)row.getCell("order").getValue()).getValue());
				tempMap.put("orgID", ((AbstractCoreBaseInfo) row.getCell("storageOrg").getValue()).getId().toString());
				tempMap.put("batchID", ((AbstractCoreBaseInfo) row.getCell("batch").getValue()).getId().toString());
				tempMap.put("henhouseID", ((AbstractCoreBaseInfo) row.getCell("henhouse").getValue()).getId().toString());
				tempMap.put("dayAge", new BigDecimal(row.getCell("dayAge").getValue().toString()));
				tempMap.put("qty", new BigDecimal(row.getCell("qty").getValue().toString()));
				list.add(tempMap);
			}
		}
		if(list.size()<=0) {
			MsgBox.showWarning("请选择要派车的商品鸡场！");
			SysUtil.abort();
		}
		
		if(list.size()>1)
			list=getOrderList(list);//排序
		
		this.kdtEntrys.removeRows();
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("storageOrgID", storageOrgID);
		map.put("carCount", carCount.intValue());
		map.put("allQty", this.txtallQty.getBigDecimalValue()==null?BigDecimal.ZERO:this.txtallQty.getBigDecimalValue());
		map.put("hitchTime", this.pkhitchTime.getTimestamp());
		map.put("transferTime", this.txttransferTime.getBigDecimalValue()==null?0:this.txttransferTime.getBigDecimalValue().intValue());//转舍时间
//		map.put("isAhead", true);//是否提前发车
		map.put("aheadTime", this.txtaheadTime.getBigDecimalValue()==null?0:this.txtaheadTime.getBigDecimalValue().intValue());//提前发车时间
		map.put("details", list);
		
		list = SendCarPlanFacadeFactory.getRemoteInstance().getRowSet(map);
		
		IStorageOrgUnit iss = StorageOrgUnitFactory.getRemoteInstance();
		for(int index=0;index<list.size();index++) {
			row=this.kdtEntrys.addRow();
			map=(HashMap) list.get(index);
			
//			row.getCell("carNo").setValue(((Integer)map.get("carNo")+1)+"号车");
			row.getCell("storageOrgUnit").setValue(iss.getStorageOrgUnitInfo(new ObjectUuidPK(map.get("orgID").toString())));
			row.getCell("startTime").setValue(map.get("tempStartTime"));
			row.getCell("reachTime").setValue(map.get("tempReachTime"));
			row.getCell("beginCatchTime").setValue(map.get("tempBeginCatchTime"));
			row.getCell("outTime").setValue(map.get("tempLeaveTime"));
			row.getCell("backTime").setValue(map.get("tempBackTime"));
			row.getCell("hitchTime").setValue(map.get("tempHitchTime"));
			row.getCell("reStartTime").setValue(map.get("tempStartTime2"));
			row.getCell("carCount").setValue(map.get("carCount"));
			if(carCount.intValue()>1&&(row.getRowIndex()%carCount.intValue())==0) {
				row.getStyleAttributes().setBackground(new Color(187,205,163));
			}
		}
		
	}
	/**
	 * 得到排序后的list
	 * @param list
	 * @return
	 */
	private ArrayList<Object> getOrderList(ArrayList<Object> list) {
		ArrayList<Object> resultList=new ArrayList<Object>();
		HashMap<String,Object> tempMap1,tempMap2;
		int minListIndex,maxListIndex;
		int order1,order2;
		for(int index=0;index<(list.size()-1);index++) {
			minListIndex=index;
			maxListIndex=index;
			tempMap1=(HashMap<String, Object>) list.get(index);
			order1=(Integer) tempMap1.get("order");
			for(int j=index+1;j<list.size();j++) {
				tempMap2=(HashMap<String, Object>) list.get(j);
				order2=(Integer) tempMap2.get("order");
				if(order2<order1) {
					minListIndex=j;
					order1=order2;
				}else {
					maxListIndex=j;
				}
			}
			resultList.add(list.get(minListIndex));
			if(index==(list.size()-2)) {
				resultList.add(list.get(maxListIndex));
			}
		}
		//根据商品鸡场汇总
/*		list.clear();
		String orgID,orgIDKeep = "";
		BigDecimal sumQty=BigDecimal.ZERO,tempQty=BigDecimal.ZERO;
		for(int index=0;index<resultList.size();index++) {
			tempMap1=(HashMap<String, Object>) resultList.get(index);
			orgID=(String) tempMap1.get("orgID");
			tempQty=(BigDecimal) tempMap1.get("qty");
			if(index==0) {
				orgIDKeep=orgID;
			}
			if(!orgIDKeep.equals(orgID)) {
				HashMap<String, Object> tempMap=new HashMap<String, Object>();
				tempMap.put("orgID", orgIDKeep);
				tempMap.put("qty", sumQty);
				list.add(tempMap);
				orgIDKeep=orgID;
				sumQty=BigDecimal.ZERO;
			}
			sumQty=sumQty.add(tempQty);
			if(index==(resultList.size()-1)) {//最后一行
				HashMap<String, Object> tempMap=new HashMap<String, Object>();
				tempMap.put("orgID", orgIDKeep);
				tempMap.put("qty", sumQty);
				list.add(tempMap);
			}
		}*/
//		return list;
		return resultList;
	}
	
	
	/**
	 * 获取商品鸡场 即时存栏、日龄信息
	 */
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		this.kdtOrgEntry.getStyleAttributes().setLocked(true);
		this.kdtOrgEntry.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		this.kdtOrgEntry_detailPanel.setEnabled(false);
		this.kdtOrgEntry_detailPanel.getAddNewLineButton().setEnabled(false);
		this.kdtOrgEntry_detailPanel.getInsertLineButton().setEnabled(false);
		this.kdtOrgEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		//this.kdtEntrys.setEnabled(false);
		this.kdtEntrys.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		this.kdtEntrys_detailPanel.setEnabled(false);
		this.kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
		this.kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
		this.kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
		
		this.kdtOrgEntry.getColumn("isSelected").getStyleAttributes().setLocked(false);
		this.kdtOrgEntry.getColumn("isSelected").getStyleAttributes().setHided(true);
		this.kdtOrgEntry.getColumn("order").getStyleAttributes().setLocked(false);
		
		this.contLastUpdateTime.setVisible(true);
		this.contLastUpdateUser.setVisible(true);
		
		this.pkauditTime.setTimeEnabled(true);
		this.pkhitchTime.setTimeEnabled(true);
		
		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);
		
		this.pkhitchTime.setRequired(true);
		
		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//bizDateChanged(e);
			}});
		
		 KDComboBox kdtOrgEntry_order_ComboBox = new KDComboBox();
        kdtOrgEntry_order_ComboBox.setName("kdtOrgEntry_order_ComboBox");
        kdtOrgEntry_order_ComboBox.setVisible(true);
        kdtOrgEntry_order_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.food.orderEnum").toArray());
        kdtOrgEntry_order_ComboBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				selectOrderChanged(e);
			}});
        KDTDefaultCellEditor kdtOrgEntry_order_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_order_ComboBox);
        this.kdtOrgEntry.getColumn("order").setEditor(kdtOrgEntry_order_CellEditor);
        
        /*this.txttransferTime.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(e.getNewValue()!=null) {
					BigDecimal timeQ=(BigDecimal) e.getNewValue();
					if(timeQ.compareTo(BigDecimal.ZERO)>0) {
						chkisAhead.setEnabled(true);
					}else {
						chkisAhead.setSelected(false);
						chkisAhead.setEnabled(false);
					}
				}
			}});*/
        this.kdtEntrys.getColumn("carNo").setWidth(50);
        this.kdtEntrys.getHead().getRow(0).getCell(this.kdtEntrys.getColumn("carNo").getColumnIndex()).setValue("车号");
        
//        ((KDTimePicker)this.kdtEntrys.getColumn("startTime").getEditor().getComponent()).setTimeEnabled(true);
//        this.kdtEntrys.getColumn("startTime").getStyleAttributes().setNumberFormat("HH:mm");
//        this.kdtEntrys.getColumn("startTime").setWidth(150);
	}
	/**
	 * 顺序号改变
	 * @param e
	 */
	private void selectOrderChanged(ItemEvent e) {
		if(e.getItem()==null)
			return;
		if(e.getItem().equals(com.kingdee.eas.farm.food.orderEnum.one)) {//顺序号为1
			IRow row = KDTableUtil.getSelectedRow(this.kdtOrgEntry);
			if(row.getCell("storageOrg").getValue()!=null) {
				try {
					String toOrgID=((IPropertyContainer) row.getCell("storageOrg").getValue()).getString("id");
					//发运路线
					EntityViewInfo ev = new EntityViewInfo();
					FilterInfo filter = new FilterInfo();
					filter.getFilterItems().add(new FilterItemInfo("fromStorageOrg.id", ((IPropertyContainer) this.prmtstorageOrgUnit.getValue()).getString("id"), CompareType.EQUALS));
					filter.getFilterItems().add(new FilterItemInfo("toStorageOrg.id", toOrgID, CompareType.EQUALS));
					ev.setFilter(filter);
					DeliveryLineCollection col = DeliveryLineFactory.getRemoteInstance().getDeliveryLineCollection(ev);
					if (col != null && col.size() > 0) {
						DeliveryLineInfo info = DeliveryLineFactory.getRemoteInstance().getDeliveryLineInfo(new ObjectUuidPK(col.get(0).getId()));
						int count=info.getDefaultCarCount();
						this.txtcarCount.setValue(count);
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 */
	private void orderChanged() {
		IRow row;
		BigDecimal sumQty=BigDecimal.ZERO,tempQty=BigDecimal.ZERO;
		for(int index=0;index<this.kdtOrgEntry.getRowCount();index++) {
			row=this.kdtOrgEntry.getRow(index);
			if(row.getCell("order").getValue()!=null&& ((orderEnum)row.getCell("order").getValue()).getValue()>0) {
				if(row.getCell("qty").getValue()!=null) {
					tempQty=new BigDecimal( row.getCell("qty").getValue().toString());
				}
				sumQty=sumQty.add(tempQty);
			}
		}
		
		this.txtallQty.setValue(sumQty);
	}
	
	/**
	 * 商品鸡场信息 选择改变事件 
	 */
	private void orgEntryPropertyChangeEvented(PropertyChangeEvent e) {
		if(e.getPropertyName().equalsIgnoreCase("isSelected")) {
			int rowIndex=KDTableUtil.getSelectedRow(this.kdtOrgEntry).getRowIndex();
			if(e.getNewValue()==null||e.getNewValue().equals(false)) {
				this.kdtOrgEntry.getRow(rowIndex).getCell("order").setValue(null);
			}
		}
	}
    private void bizDateChanged(DataChangeEvent e) {
		java.util.Date bizDate;
    	if(e.getNewValue()==null) {
    		bizDate=new java.util.Date();
    	}else {
    		bizDate=(Date) e.getNewValue();
    	}
		try {
			bizDate=sdf.parse(sdf.format(bizDate));
		} catch (ParseException e1) {
		}
		cal.setTime(bizDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.HOUR_OF_DAY, 6);
		
		this.pkhitchTime.setValue(cal.getTime());
    }
	@Override
	public void kdtOrgEntry_Changed(int rowIndex, int colIndex) throws Exception {
		orderChanged();
	}

}