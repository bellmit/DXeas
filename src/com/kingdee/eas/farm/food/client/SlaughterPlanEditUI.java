/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import java_cup.internal_error;

import javax.swing.JPanel;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.KDPanel;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.cm.common.BillBaseStatusEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.food.foodCommUtils.foodComm;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.eas.farm.food.SlaughterPlan;
import com.kingdee.eas.farm.food.SlaughterPlanEntryInfo;
import com.kingdee.eas.farm.food.SlaughterPlanFacadeFactory;
import com.kingdee.eas.farm.food.SlaughterPlanFactory;
import com.kingdee.eas.farm.food.SlaughterPlanInfo;

/**
 * output class name
 */
public class SlaughterPlanEditUI extends AbstractSlaughterPlanEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SlaughterPlanEditUI.class);

	LinkedHashMap<String,String> mapHavntLocked = new LinkedHashMap<String, String>();

	LinkedHashMap<String,String>  mapHadLocked= new LinkedHashMap<String, String>();


	Map<String,String> mapTemp = new LinkedHashMap<String,String>();//存放临时数据
	private Map<Integer,BigDecimal> mapCullAndDeath=new LinkedHashMap<Integer, BigDecimal>();//存放饲喂规范的死淘信息

	private int schedulingHenHouseQty=0;//排班计划分录，当日宰杀舍数预留值（修改前保留舍数的值，若填写的数为负数则返回修改前的这个值）
	private Date slaughterDate=new Date();
	private boolean isLocked=false;//记录当前行数操作是否锁定或取消锁定 
	private int slaughterQty=0;






	/**
	 * output class constructor
	 */
	public SlaughterPlanEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		setEntrysVisual();
	}

	/**
	 * 日期不在范围内的在非编辑状态下不可视
	 */
	private void setEntrysVisual() {
		PeriodInfo fiscalPeriod=null;
		// TODO Auto-generated method stub
		if(prmtperiod.getValue()!=null)
			fiscalPeriod = (PeriodInfo)prmtperiod.getValue();
		if(!this.oprtState.equals("ADDNEW")&&!this.oprtState.equals("EDIT")&&kdtEntrys.getRowCount()>0){

			for(int i=kdtEntrys.getRowCount()-1;i>=0;i--){
				if(((Date)kdtEntrys.getCell(i, "pkDate").getValue()).after(fiscalPeriod.getEndDate()))
					kdtEntrys.getRow(i).getStyleAttributes().setHided(true);
				else
					break;
			}
			for(int i=kdtEntryScheduling.getRowCount()-1;i>=0;i--){
				if(((Date)kdtEntryScheduling.getCell(i, "schedulingDate").getValue()).after(fiscalPeriod.getEndDate()))
					kdtEntryScheduling.getRow(i).getStyleAttributes().setHided(true);
				else
					break;
			}
		}
		else{
			for(int i=kdtEntrys.getRowCount()-1;i>=0;i--){
				if(((Date)kdtEntrys.getCell(i, "pkDate").getValue()).after(fiscalPeriod.getEndDate()))
					kdtEntrys.getRow(i).getStyleAttributes().setHided(false);
				else
					break;
			}
			for(int i=kdtEntryScheduling.getRowCount()-1;i>=0;i--){
				if(((Date)kdtEntryScheduling.getCell(i, "schedulingDate").getValue()).after(fiscalPeriod.getEndDate()))
					kdtEntryScheduling.getRow(i).getStyleAttributes().setHided(false);
				else
					break;
			}
		}
	}
	public void storeFields()
	{
		super.storeFields();
	}
	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}	
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.food.SlaughterPlanFactory.getRemoteInstance();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUIFormat();//UI界面设置
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		mapCullAndDeath=SlaughterPlanFacadeFactory.getRemoteInstance().getCullAndDeathFromFeedModel();//给饲喂规范的死淘信息赋值
	}

	/**
	 * 界面格式调整
	 */
	private void setUIFormat() {
		// TODO Auto-generated method stub
		kDDateCreateTime.setTimeEnabled(false);
		kDDateLastUpdateTime.setTimeEnabled(false);
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		this.btnRefresh.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_refresh"));


		if(editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			btnEdit.setEnabled(false);

		contLastUpdateUser.setVisible(true);
		contLastUpdateTime.setVisible(true);

		//日历表格的按钮不可见
		kdtEntryScheduling_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntryScheduling_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntryScheduling_detailPanel.getRemoveLinesButton().setVisible(false);

		//分录的新增插入按钮不可见
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);


		kdtEntrysAddRemoveBtnListener();
	}

	/**
	 * 按钮  获取屠宰计划点击事件
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void btnGetSlaughterPlan_mouseClick(MouseEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		createCalendar();//日历的创建

		valiateBeforeGetSlaughterPlan();
		mapHavntLocked.clear();

		//遍历上月屠宰计划
		HashMap<String,String> slaughterPlanOfLastMonth=checkSlaughterPlanLastMonth((PeriodInfo)prmtperiod.getValue());



		//从养殖批次中获取   符合日龄  的所有数据
		LinkedHashMap<String,String> mapInnitial = SlaughterPlanFacadeFactory.getRemoteInstance().getSlaughterPlan((PeriodInfo)prmtperiod.getValue(), txtageOfDaysFrom.getIntegerValue(),txtageOfDaysTo.getIntegerValue());
		
//		//删除   存栏量为0或者完全出栏的鸡舍
//		removeDateZeroBreedingStocking(mapInnitial);
		
		
		if(mapInnitial.size()==0)
			giveUserTips("未能获取到本月的屠宰计划的相关的数据");




		for (Map.Entry<String, String> entry : mapInnitial.entrySet()) 
			mapHavntLocked.put(entry.getKey(), entry.getValue());

		//上月屠宰计划中的相同数据删除
		if(slaughterPlanOfLastMonth==null||slaughterPlanOfLastMonth.size()==0){}
		else{
			Iterator<Entry<String, String>> it=slaughterPlanOfLastMonth.entrySet().iterator();
			while(it.hasNext()){
				Entry<String, String> entry=it.next();
				if(mapHavntLocked.get(entry.getKey())!=null)
					mapHavntLocked.remove(entry.getKey());
			}
		}

		LinkedHashMap<String, String> beforeMap = foodComm.sortTwoDimension(mapHavntLocked);
		sortEntry(beforeMap);
		kdtEntrysCalculateSlaughterQty();//计算每栋鸡舍的宰杀数量
		setSlaughterQtyAndDetails();//填写宰杀详情
		super.btnGetSlaughterPlan_mouseClick(e);
	}

	
//	/**
//	 * 删除   存栏量为0或者完全出栏的鸡舍
//	 * @param mapInnitial
//	 * @throws BOSException 
//	 * @throws EASBizException 
//	 */
//	private void removeDateZeroBreedingStocking(
//			LinkedHashMap<String, String> mapInnitial) throws EASBizException, BOSException {
//		// TODO Auto-generated method stub
//		String[] str=new String[5];
//		
//		Iterator<Entry<String, String>> it = mapInnitial.entrySet().iterator();  
//		while(it.hasNext()){
//			Entry<String, String> entry = it.next();
//			str=entry.getKey().split("_");
//			str=SlaughterPlanFacadeFactory.getRemoteInstance().getSlaughterQtyInOneDay(str[1],str[2],str[3]);
//			if(str==null)
//				it.remove();
//		}
//		
//	}
	/**
	 * 检查上个月的屠宰计划是否录入，如果是，返回key值的map
	 * @param fiscalPeriod
	 * @return
	 * @throws BOSException 
	 */
	private HashMap<String, String> checkSlaughterPlanLastMonth(PeriodInfo period) throws BOSException {
		// TODO Auto-generated method stub
		HashMap<String,String> slaughterPlanOfLastMonth=new HashMap<String,String>();
		if(period==null)
			return null;
		PeriodInfo fiscalPeriod = (PeriodInfo)period;


		//获得上月的屠宰计划
		//		CoreBaseCollection coll = SlaughterPlanFactory.getRemoteInstance().getCollection(" where period='"+foodComm.getUpperPeriodInfo(fiscalPeriod).getId().toString()+"' and billStatus=4");//审核状态
		CoreBaseCollection coll = SlaughterPlanFactory.getRemoteInstance().getCollection(" where period='"+foodComm.getUpperPeriodInfo(fiscalPeriod).getId().toString()+"'");//
		if(coll.size()==0)
			return null;
		SlaughterPlanInfo slaughterPlanInfoOfLastMonth = (SlaughterPlanInfo)coll.get(0);


		SlaughterPlanEntryInfo entryInfo=null;
		for(int i=0;i<slaughterPlanInfoOfLastMonth.getEntrys().size();i++){
			entryInfo=slaughterPlanInfoOfLastMonth.getEntrys().get(i);
			if(entryInfo.getPkDate().after(foodComm.getUpperPeriodInfo(fiscalPeriod).getEndDate()))
				continue;
			slaughterPlanOfLastMonth.put(getKey(entryInfo,"true"), getValue(entryInfo));
			slaughterPlanOfLastMonth.put(getKey(entryInfo,"false"), getValue(entryInfo));
		}		
		return slaughterPlanOfLastMonth;
	}



	private String getValue(SlaughterPlanEntryInfo entryInfo) {
		// TODO Auto-generated method stub

		String str[]=new String[3];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		str[0]=sdf.format(entryInfo.getPkDate());//宰杀日期
		str[1]=String.valueOf(entryInfo.getAgeOfDaysActually());//日龄
		str[2]=String.valueOf(entryInfo.getSlaughterAmt());//宰杀只数


		return foodComm.getValue(str);
	}
	private String getKey(SlaughterPlanEntryInfo entryInfo,String isLocked) {
		// TODO Auto-generated method stub
		String[] str=new String[5];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(entryInfo==null)
			return null;
		str[0]=sdf.format(entryInfo.getLairageDate());
		str[1]=entryInfo.getStoOrgUnit().getId().toString();
		str[2]=entryInfo.getHenHouse().getId().toString();
		str[3]=entryInfo.getBreedBatch().getId().toString();
		str[4]=isLocked;

		return foodComm.getKey(str);
	}
	/**
	 * 重排屠宰计划
	 */
	@Override
	protected void btnSort_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		//一：将未锁定的已锁定的分别回收
		beforeSortPlan();

		//二：需要排序的排序
		sortEntry(mapHavntLocked);
		insertHavntSortIntoEntry();
		kdtEntrysCalculateSlaughterQty();//计算每栋鸡舍的宰杀数量
		setSlaughterQtyAndDetails();//填写宰杀详情
		//四:直接展现数据
		super.btnSort_mouseClick(e);
	}

	/**
	 * 将锁定的插入到分录中
	 * @throws ParseException 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void insertHavntSortIntoEntry() throws ParseException, EASBizException, BOSException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String[] array=new String[3];
		String key;
		String value;
		String[] strKey=new String[5];
		String[] strValue=new String[3];

		Iterator<Entry<String, String>> it = mapHadLocked.entrySet().iterator();  
		while(it.hasNext()){  
			Entry<String, String> entry=it.next();
			array = entry.getValue().split("_");
			date=sdf.parse(array[0]);
			for(int i=0;i<kdtEntrys.getRowCount()-1;i++){
				key = entry.getKey();
				value = entry.getValue();
				strKey = key.split("_");
				strValue = value.split("_");
				if(!date.after((Date)kdtEntrys.getCell(0,"pkDate").getValue())){
					kdtEntrys.addRow(0);
					kdtEntrysAddRowAtLastTimesSort(0,strKey,strValue);
					break;
				}

				else if(date.after((Date)kdtEntrys.getCell(i,"pkDate").getValue())&&!date.after((Date)kdtEntrys.getCell(i+1,"pkDate").getValue())){
					kdtEntrys.addRow(i+1);
					kdtEntrysAddRowAtLastTimesSort(i+1,strKey,strValue);
					break;
				}

				else if(!date.before((Date)kdtEntrys.getCell(kdtEntrys.getRowCount()-1,"pkDate").getValue())){
					kdtEntrys.addRow(kdtEntrys.getRowCount());
					kdtEntrysAddRowAtLastTimesSort(kdtEntrys.getRowCount(),strKey,strValue);
					break;
				}
			}
		}

	}
	/**
	 * 获取屠宰计划前的数据校验
	 */
	private void valiateBeforeGetSlaughterPlan() {
		// TODO Auto-generated method stub
		if(BillBaseStatusEnum.AUDITED.equals(editData.getBillStatus()))
			return;
		if(prmtperiod.getValue()==null)
			giveUserTips("期间字段为空");
		if(txtageOfDaysFrom.getIntegerValue()==null||txtageOfDaysFrom.getIntegerValue()==0)
			giveUserTips("日龄最小值不能为空且必须大于0");
		if(txtageOfDaysTo.getIntegerValue()==null||txtageOfDaysTo.getIntegerValue()==0)
			giveUserTips("日龄最大值不能为空且必须大于0");
		if(txtageOfDaysFrom.getIntegerValue()>txtageOfDaysTo.getIntegerValue())
			giveUserTips("日龄的最小值不能大于最大值");
		if(txtslaughterHenHouseQtyAveDay.getIntegerValue()==null||txtslaughterHenHouseQtyAveDay.getIntegerValue()<=0)
			giveUserTips("日标准宰杀舍数不能为空且必须大于0");
	}
	/**
	 * 界面刷新
	 */
	@Override
	public void actionRefresh_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		reloadData();
		super.actionRefresh_actionPerformed(e);
	}


	/**
	 * 重新排序前  将需要的数据分别整理
	 */
	protected void beforeSortPlan(){
		//map清空		
		mapHadLocked.clear();
		mapHavntLocked.clear();

		for(int i=0;i<kdtEntrys.getRowCount();i++)
			if(kdtEntrys.getCell(i, "isLocked").getValue().equals(true))
				mapHadLocked.put(getKey(i,true), getValue(i));
			else
				mapHavntLocked.put(getKey(i,false), getValue(i));
	}


	/**
	 * value格式
	 * @param i
	 * @return
	 */
	private String getValue(int i) {
		// TODO Auto-generated method stub
		String str[]=new String[3];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		str[0]=sdf.format((Date)kdtEntrys.getRow(i).getCell("pkDate").getValue());//宰杀日期
		str[1]=kdtEntrys.getRow(i).getCell("ageOfDaysActually").getValue().toString();//日龄
		str[2]=kdtEntrys.getRow(i).getCell("SlaughterAmt").getValue().toString();//宰杀只数

		return foodComm.getValue(str);
	}

	/**
	 * key格式：入栏日期_养殖场ID_鸡舍ID_养殖批次ID
	 * @param i   分录的行数-1
	 * @param b   是否锁定
	 * @return
	 */
	private String getKey(int i, boolean b) {
		// TODO Auto-generated method stub
		String[] str=new String[5];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		



		str[0] = sdf.format((Date)kdtEntrys.getRow(i).getCell("lairageDate").getValue());//入栏日期		
		str[1] = ((StorageOrgUnitInfo)kdtEntrys.getRow(i).getCell("stoOrgUnit").getValue()).getId().toString();//养殖场
		str[2] = ((HenhouseInfo)kdtEntrys.getRow(i).getCell("henHouse").getValue()).getId().toString();//鸡舍
		str[3] = ((BreedBatchInfo)kdtEntrys.getRow(i).getCell("breedBatch").getValue()).getId().toString();//养殖批次
		if(b)
			str[4] = "true";
		else
			str[4] = "false";

		return foodComm.getKey(str);
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.food.SlaughterPlanInfo objectValue = new com.kingdee.eas.farm.food.SlaughterPlanInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());

		//设置库存组织 为食品厂   食品厂编码为4
		try {
			objectValue.setStoOrg(foodComm.getStorageOrgUnitInfoByNumber("4"));
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objectValue;
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
	 * 判断是否已存在当月屠宰计划
	 * @throws BOSException 
	 */
	public void isExist() throws BOSException{
		if(editData.getPeriod()==null)
			return;
		String str = "";
		if(prmtperiod.getValue()!=null)
			str=" where billstatus<>1 and period='"+((PeriodInfo)prmtperiod.getValue()).getId().toString()+"'";
		if(editData.getId()!=null)
			str+=" and id <>'"+editData.getId().toString()+"'";
		CoreBaseCollection coll = SlaughterPlanFactory.getRemoteInstance().getCollection(str);
		if(coll.size()>0)
			giveUserTips("当前期间的屠宰计划已存在");
	}



	/**
	 *设置宰杀分录的监听事件，删除一条记录时，从对应的map里清空该数据 
	 */
	private void kdtEntrysAddRemoveBtnListener() {
		// TODO Auto-generated method stub
		kdtEntrys_detailPanel.addRemoveListener(new IDetailPanelListener(){

			public void afterEvent(DetailPanelEvent arg0) throws Exception {
				// TODO Auto-generated method stub
			}

			public void beforeEvent(DetailPanelEvent arg0) throws Exception {
				// TODO Auto-generated method stub
				if(0!=MsgBox.showConfirm2(null,"删除的分录将无法重新添加，确定要将该条记录删除吗？" ))
					SysUtil.abort();
			}});
	}
	/**
	 * 屠宰计划分录事件
	 */
	@Override
	protected void kdtEntrys_editStarte(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		if("pkDate".equals(kdtEntrys.getColumn(e.getColIndex()).getKey())){
			slaughterDate=(Date)kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue();
			slaughterQty=(Integer)kdtEntrys.getCell(e.getRowIndex(), "SlaughterAmt").getValue();
		}

		if("isLocked".equals(kdtEntrys.getColumn(e.getColIndex()).getKey()))
			isLocked=kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue().equals(true);
		super.kdtEntrys_editStarte(e);
	}

	/**
	 * 分录值改变事件的处理
	 */
	@Override
	protected void kdtEntrys_editStoppe(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub

		//修改日期后自动变更日龄和宰杀数量
		if("pkDate".equals(kdtEntrys.getColumn(e.getColIndex()).getKey())){
			if(kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue()==null){
				MsgBox.showInfo("宰杀日期不允许为空");
				kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).setValue(slaughterDate);
				abort();
			}
			modifySlaughterQty(e.getRowIndex(),e.getColIndex());
			modifyHadSortHenHouseQty(e.getRowIndex());		
		}

		if("isLocked".equals(kdtEntrys.getColumn(e.getColIndex()).getKey()))
			if(!kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue().equals(isLocked))
				kdtEntrySchedulingChangeHenHouseLockedAtm((Date)kdtEntrys.getCell(e.getRowIndex(), "pkDate").getValue(),isLocked);
		super.kdtEntrys_editStoppe(e);
	}


	/*
	 *某日的宰杀日期调整后自动修改该日的已排序舍数，目的日期的的日历获得焦点
	 *顺便修改当日宰杀数量和宰杀详情
	 */
	private void modifyHadSortHenHouseQty(int rowIndex) throws BOSException {
		// TODO Auto-generated method stub
		int flag=0;
		if(!DateUtils.isSameDay((Date)kdtEntrys.getCell(rowIndex, "pkDate").getValue(),slaughterDate)){
			for(int i=0;i<kdtEntryScheduling.getRowCount();i++){
				if(DateUtils.isSameDay((Date) kdtEntryScheduling.getCell(i,"schedulingDate").getValue(), slaughterDate)){
					kdtEntryScheduling.getCell(i,"hadSortHenHouseQty").setValue((Integer)kdtEntryScheduling.getCell(i,"hadSortHenHouseQty").getValue()-1);//当前日期已排序的舍数
					kdtEntryScheduling.getCell(i,"slaughterQty").setValue(Integer.parseInt(String.valueOf(kdtEntryScheduling.getCell(i,"slaughterQty").getValue()))-slaughterQty);//当前日期宰杀量
					kdtEntryScheduling.getCell(i,"remark").setValue(this.getRemark(rowIndex,kdtEntryScheduling.getCell(i,"remark").getValue(),"-"));//当前日期宰杀量
					++flag;
				}
				if(DateUtils.isSameDay((Date) kdtEntryScheduling.getCell(i,"schedulingDate").getValue(), (Date)kdtEntrys.getCell(rowIndex, "pkDate").getValue())){
					kdtEntryScheduling.getEditManager().editCellAt(i,kdtEntryScheduling.getColumnIndex("schedulingHenHouseQty") );
					kdtEntryScheduling.getCell(i,"hadSortHenHouseQty").setValue((Integer)kdtEntryScheduling.getCell(i,"hadSortHenHouseQty").getValue()+1);
					kdtEntryScheduling.getCell(i,"slaughterQty").setValue(Integer.parseInt(String.valueOf(kdtEntryScheduling.getCell(i,"slaughterQty").getValue()))+(Integer)kdtEntrys.getCell(rowIndex, "SlaughterAmt").getValue());
					kdtEntryScheduling.getCell(i,"remark").setValue(this.getRemark(rowIndex,kdtEntryScheduling.getCell(i,"remark").getValue(),"+"));//当前日期宰杀量
					++flag;
				}
				setFontColorScheduling(i); 
				if(flag==2)
					break;
			}
		}
	}
	/**
	 * 修改宰杀详情
	 * @param rowIndex
	 * @param string
	 * @param string2
	 * @return
	 * @throws BOSException 
	 */
	private String getRemark(int rowIndex, Object remarkString, String comparisionOperator) throws BOSException {
		String remark="";
		if(remarkString!=null&&remarkString instanceof String)
			remark=remarkString.toString();

		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<String,Integer>();
		int flag=0;//养殖场编号之前是否存在
		int str=0;
		String storageOrgUnitNum = foodComm.getFeedFactoryNumber((StorageOrgUnitInfo)kdtEntrys.getCell(rowIndex, "stoOrgUnit").getValue());
		if(!comparisionOperator.equals("-")&&!comparisionOperator.equals("+"))
			return null;
		if(remark==null||remark.equals(""))
			return storageOrgUnitNum+"*1";
		else if(remark.indexOf("+")!=-1){
			String[] str1 = remark.split("\\+");
			for(int i=0;i<str1.length;i++){
				String[] str2 = str1[i].split("\\*");
				if(str2[0].equals(storageOrgUnitNum)){
					if(comparisionOperator.equals("-"))
						str=Integer.parseInt(str2[1])-1;
					else
						str=Integer.parseInt(str2[1])+1;
					map.put(str2[0], str);
					flag=1;
				}
				else
					map.put(str2[0],Integer.parseInt(str2[1]));
			}
			if(flag==0)
				map.put(storageOrgUnitNum, 1);
			return foodComm.getDetailsOfSlaughter(map);
		}
		else{
			int num=0;
			num=Integer.parseInt(remark.substring(remark.indexOf("*")+1));
			if(comparisionOperator.equals("-")){
				if(num-1>0)
					return remark.substring(0,remark.indexOf("*")+1)+String.valueOf(num-1);
				else
					return "";
			}
			else
				return remark.substring(0,remark.indexOf("*")+1)+String.valueOf(num+1);
		}

	}
	/**
	 * 修改宰杀日期后修改宰杀数量
	 * @param rowIndex
	 * @param colIndex
	 * @throws ParseException
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void modifySlaughterQty(int rowIndex, int colIndex) throws ParseException, EASBizException, BOSException {
		// TODO Auto-generated method stub
		String str[]=new String[3];

		Date slaughterDateAfterChange=(Date)kdtEntrys.getCell(rowIndex, colIndex).getValue();
		int days = Integer.parseInt(String.valueOf(((slaughterDateAfterChange.getTime()-slaughterDate.getTime())/1000/3600/24)));
		kdtEntrys.getCell(rowIndex, "ageOfDaysActually").setValue((Integer)kdtEntrys.getCell(rowIndex, "ageOfDaysActually").getValue()+days);


		String stoOrgUnitInfoID=((StorageOrgUnitInfo)kdtEntrys.getCell(rowIndex, "stoOrgUnit").getValue()).getId().toString();
		String henHouseInfoID=((HenhouseInfo)kdtEntrys.getCell(rowIndex, "henHouse").getValue()).getId().toString();
		String breedBatchInfoID=((BreedBatchInfo)kdtEntrys.getCell(rowIndex, "breedBatch").getValue()).getId().toString();


		//获得该鸡舍在商品鸡养殖日报的最后一日的存栏量
		str = SlaughterPlanFacadeFactory.getRemoteInstance().getSlaughterQtyInOneDay(stoOrgUnitInfoID,henHouseInfoID,breedBatchInfoID);

		//根据死淘迭代出最终宰杀数量
		int slaughterQty = getSlaughterAmtOfCurrentHenHouse(str[0],str[1],str[2],(Date)kdtEntrys.getCell(rowIndex, "pkDate").getValue());
		kdtEntrys.getCell(rowIndex, "SlaughterAmt").setValue(slaughterQty);
	}
	/**
	 * 用户修改是否锁定时，日历分录锁定舍数相应修改
	 * @param value
	 * @param b
	 */
	private void kdtEntrySchedulingChangeHenHouseLockedAtm(Date value, boolean bool) {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtEntryScheduling.getRowCount();i++)
			if(DateUtils.isSameDay(value, (Date)kdtEntryScheduling.getCell(i,"schedulingDate").getValue())){
				if(bool)
					kdtEntryScheduling.getCell(i,"lockedHenHouse").setValue((Integer)kdtEntryScheduling.getCell(i,"lockedHenHouse").getValue()-1);
				else
					kdtEntryScheduling.getCell(i,"lockedHenHouse").setValue(1+(Integer)kdtEntryScheduling.getCell(i,"lockedHenHouse").getValue());
				break;
			}
	}
	@Override
	protected void kdtEntryScheduling_editStart(KDTEditEvent e)
	throws Exception {
		// TODO Auto-generated method stub

		//保留日历分录的开始宰杀舍数
		if(e.getColIndex()==kdtEntryScheduling.getColumnIndex("schedulingHenHouseQty"))
			if(kdtEntryScheduling.getCell(e.getRowIndex(), e.getColIndex()).getValue()!=null)
				schedulingHenHouseQty=(Integer.parseInt(kdtEntryScheduling.getCell(e.getRowIndex(),"schedulingHenHouseQty").getValue().toString()));
		super.kdtEntryScheduling_editStart(e);
	}
	/**
	 * 日历表格事件处理
	 */
	@Override
	protected void kdtEntryScheduling_editStopp(KDTEditEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		//勾选某日休班时，默认设置宰杀舍数为0
		//取消勾选休班时，默认设置宰杀舍数为标准宰杀舍数
		if(e.getColIndex()==kdtEntryScheduling.getColumnIndex("isOffDuty"))
			if(kdtEntryScheduling.getCell(e.getRowIndex(), e.getColIndex()).getValue().equals(true))
				kdtEntryScheduling.getCell(e.getRowIndex(),"schedulingHenHouseQty").setValue(0);
			else if(txtslaughterHenHouseQtyAveDay.getIntegerValue()!=null)
				kdtEntryScheduling.getCell(e.getRowIndex(),"schedulingHenHouseQty").setValue(txtslaughterHenHouseQtyAveDay.getIntegerValue());


		//宰杀舍数设置为0时，默认当天休班；限定宰杀舍数不为负数
		if(e.getColIndex()==kdtEntryScheduling.getColumnIndex("schedulingHenHouseQty"))
			if(kdtEntryScheduling.getCell(e.getRowIndex(), e.getColIndex()).getValue().equals(0))
				kdtEntryScheduling.getCell(e.getRowIndex(),"isOffDuty").setValue(true);
			else{
				int henHouseQty = Integer.parseInt(kdtEntryScheduling.getCell(e.getRowIndex(), e.getColIndex()).getValue().toString());
				if(henHouseQty<0){
					MsgBox.showInfo("所填写的舍数不能小于0");
					kdtEntryScheduling.getCell(e.getRowIndex(),"schedulingHenHouseQty").setValue(schedulingHenHouseQty);
				}
				else
					kdtEntryScheduling.getCell(e.getRowIndex(),"isOffDuty").setValue(false);
			}

		//		this.getMapOffDuty();//修改后，休班map更新

		super.kdtEntryScheduling_editStopp(e);
	}
	/**
	 * 增加分录
	 * @param lairageDate
	 * @param slughterDate
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void kdtEntryAddRow(Date lairageDate, Date slughterDate,
			String[] array, int agesOfDays) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		kdtEntrys.addRow();
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "lairageDate").setValue(lairageDate);
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "pkDate").setValue(slughterDate);
		int ageOfDays = foodComm.getDiffBetweenTwoDays(lairageDate, slughterDate);
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "ageOfDaysActually").setValue(ageOfDays);
		if(txtageOfDaysFrom.getIntegerValue()!=null&&txtageOfDaysTo.getIntegerValue()!=null)
			if(ageOfDays<txtageOfDaysFrom.getIntegerValue()||ageOfDays>txtageOfDaysTo.getIntegerValue()){
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "ageOfDaysActually").getStyleAttributes().setFontColor(Color.red);
			}
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "stoOrgUnit").setValue(foodComm.getStorageOrgUnitInfoByID(array[1]));
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "henHouse").setValue(foodComm.getHenHouseInfoByID(array[2]));
		if(foodComm.getHenHouseInfoByID(array[2])!=null)
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "henHouseName").setValue(foodComm.getHenHouseInfoByID(array[2]).getName());
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "breedBatch").setValue(foodComm.getBreedBatchInfoByID(array[3]));
		if("true".equals(array[4]))
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "isLocked").setValue(true);
		else
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "isLocked").setValue(false);
	}






	/**
	 * 生成日历分录
	 */
	protected void createCalendar(){

		if(prmtperiod.getValue()==null)
			return;
		if(txtslaughterHenHouseQtyAveDay.getIntegerValue()==null||txtslaughterHenHouseQtyAveDay.getIntegerValue()==0)
			return;
		kdtEntryScheduling.removeRows();//清空日历分录
		PeriodInfo fiscalPeriodInfo = (PeriodInfo)prmtperiod.getValue();

		Calendar calBeginDate=Calendar.getInstance();
		Calendar calEndDate=Calendar.getInstance();

		//取得所选会计期间的起始日期和结束日期
		calBeginDate.setTime(fiscalPeriodInfo.getBeginDate());
		calEndDate.setTime(fiscalPeriodInfo.getEndDate());
		calEndDate.add(Calendar.DATE, +7);

		//将日期添加到分录上，并设置当日宰杀舍数默认值
		do{
			kdtEntryScheduling.addRow();
			kdtEntryScheduling.getCell(kdtEntryScheduling.getRowCount()-1, "schedulingDate").setValue(calBeginDate.getTime());
			kdtEntryScheduling.getCell(kdtEntryScheduling.getRowCount()-1, "schedulingHenHouseQty").setValue(txtslaughterHenHouseQtyAveDay.getIntegerValue());
			kdtEntryScheduling.getCell(kdtEntryScheduling.getRowCount()-1, "isOffDuty").setValue(false);
			kdtEntryScheduling.getCell(kdtEntryScheduling.getRowCount()-1, "lockedHenHouse").setValue(0);
			calBeginDate.add(Calendar.DATE, +1);
		}while(!calBeginDate.after(calEndDate));
	}



	/**
	 * 最终展现屠宰计划
	 * @param mapTemp2
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void listSlaughterPlan(Map<String, String> map) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		kdtEntrys.removeRows();
		String[] strKey=new String[5]; 
		String[] strValue=new String[3]; 
		String key;
		String value;
		Iterator<Entry<String, String>> it = map.entrySet().iterator();  
		while(it.hasNext()){  
			Entry<String, String> entry=it.next();
			key=entry.getKey();
			value=entry.getValue();
			strKey=key.split("_");
			strValue=value.split("_");
			kdtEntrysAddRowAtLastTimesSort(-1,strKey,strValue);
		}
	}
	/**
	 * 排序
	 * @throws ParseException 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	protected void sortEntry(Map<String, String> map) throws ParseException, BOSException, EASBizException{

		kdtEntrys.removeRows();
		int schedulingHenHouseQty=0;//当日宰杀舍数设定
		int lockedHenHouseQty=0;//当日已锁定宰杀舍数
		int num=0;//临时变量

		for(int i=0;i<kdtEntryScheduling.getRowCount();i++){
			schedulingHenHouseQty=(Integer) kdtEntryScheduling.getCell(i, "schedulingHenHouseQty").getValue();
			lockedHenHouseQty=(Integer)kdtEntryScheduling.getCell(i, "lockedHenHouse").getValue();
			if(lockedHenHouseQty<schedulingHenHouseQty)
				num=lockedHenHouseQty;
			else
				continue;
			Iterator<Entry<String, String>> it = map.entrySet().iterator();  
			while(it.hasNext()){  
				Entry<String, String> entry=it.next();  
				if(insertValueInfoSuccessfully(entry.getKey(),i)){
					num++;
					it.remove();
				}
				if(num==schedulingHenHouseQty)
					break;
			}  
		}
	}


	/**
	 * 日历每日宰杀数量的显示
	 * @param map
	 */
	private void setKdtEntrySchedulingSlaughterQty(Map<Date, Object> map) {
		// TODO Auto-generated method stub
		Date date=new Date();
		for(int i=0;i<kdtEntryScheduling.getRowCount();i++){
			date=(Date)kdtEntryScheduling.getCell(i, "schedulingDate").getValue();
			if(map.get(date)!=null)
				kdtEntryScheduling.getCell(i, "slaughterQty").setValue(map.get(date).toString());
			else
				kdtEntryScheduling.getCell(i, "slaughterQty").setValue(0);
		}
	}
	/**
	 * 日历宰杀详情数据的显示
	 * @param map
	 * @throws BOSException 
	 */
	private void setKdtEntrySchedulingSlaughterDetails(Map<Date, Object> map) throws BOSException {
		// TODO Auto-generated method stub
		Date date=new Date();
		for(int i=0;i<kdtEntryScheduling.getRowCount();i++){
			date=(Date)kdtEntryScheduling.getCell(i, "schedulingDate").getValue();
			if(map.get(date)!=null){
				kdtEntryScheduling.getCell(i, "remark").setValue(foodComm.getDetailsOfSlaughter(map.get(date).toString()));
				kdtEntryScheduling.getCell(i, "hadSortHenHouseQty").setValue(map.get(date).toString().split("_").length);
			}
			else{
				kdtEntryScheduling.getCell(i, "remark").setValue(null);
				kdtEntryScheduling.getCell(i, "hadSortHenHouseQty").setValue(0);
			}
			setFontColorScheduling(i);

		}
	}
	/**
	 * 日历分录颜色设定
	 * @param i
	 */
	private void setFontColorScheduling(int i) {
		// TODO Auto-generated method stub
		if((Integer)kdtEntryScheduling.getCell(i, "hadSortHenHouseQty").getValue()<(Integer)kdtEntryScheduling.getCell(i, "schedulingHenHouseQty").getValue())
			kdtEntryScheduling.getCell(i, "hadSortHenHouseQty").getStyleAttributes().setFontColor(Color.green);
		else if((Integer)kdtEntryScheduling.getCell(i, "hadSortHenHouseQty").getValue()>(Integer)kdtEntryScheduling.getCell(i, "schedulingHenHouseQty").getValue())
			kdtEntryScheduling.getCell(i, "hadSortHenHouseQty").getStyleAttributes().setFontColor(Color.red);
		else
			kdtEntryScheduling.getCell(i, "hadSortHenHouseQty").getStyleAttributes().setFontColor(Color.black);
	}
	/**
	 * 计算每日的宰杀数量，和宰杀详情
	 * @throws BOSException 
	 */
	private Map<Date,Object>[] kdtEntrysCalculateSlaughterQtyByDate() throws BOSException {
		// TODO Auto-generated method stub
		Map<Date,Object>[] map=new Map[2];
		map[0]=new HashMap<Date, Object>();
		map[1]=new HashMap<Date, Object>();
		Date date=new Date();
		int slaughterQty=0;
		String breedStorage="";
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getCell(i, "pkDate").getValue()!=null)
				if(i==0){
					date=(Date)kdtEntrys.getCell(i, "pkDate").getValue();
					slaughterQty=(Integer)kdtEntrys.getCell(i, "SlaughterAmt").getValue();
					breedStorage+=((StorageOrgUnitInfo)kdtEntrys.getCell(i, "stoOrgUnit").getValue()).getId().toString();
				}
				else if(!DateUtils.isSameDay(date,(Date)kdtEntrys.getCell(i, "pkDate").getValue())){

					map[0].put(date,slaughterQty);
					map[1].put(date, breedStorage);
					breedStorage=((StorageOrgUnitInfo)kdtEntrys.getCell(i, "stoOrgUnit").getValue()).getId().toString();
					slaughterQty=(Integer)kdtEntrys.getCell(i, "SlaughterAmt").getValue();
					date=(Date)kdtEntrys.getCell(i, "pkDate").getValue();
				}
				else {
					slaughterQty+=(Integer)kdtEntrys.getCell(i, "SlaughterAmt").getValue();
					breedStorage+="_"+((StorageOrgUnitInfo)kdtEntrys.getCell(i, "stoOrgUnit").getValue()).getId().toString();
				}
		}
		map[0].put((Date)kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "pkDate").getValue(),slaughterQty);
		map[1].put((Date)kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "pkDate").getValue(),breedStorage);


		return map;
	}

	/**
	 * 计算特定鸡舍的宰杀数量
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws ParseException 
	 */
	private void kdtEntrysCalculateSlaughterQty() throws EASBizException, BOSException, ParseException {
		// TODO Auto-generated method stub
		ArrayList<Integer> needDelete=new ArrayList<Integer>();
		String [] str=new String[3];
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			//			if(!DateUtils.isSameDay((Date)kdtEntrys.getCell(i, "pkDate").getValue(),foodComm.getDateByString("2000-01-01")))
			//					continue;
			if(kdtEntrys.getCell(i, "lairageDate").getValue()!=null&&kdtEntrys.getCell(i, "pkDate").getValue()!=null)
				if(kdtEntrys.getCell(i, "stoOrgUnit").getValue()!=null&&kdtEntrys.getCell(i, "henHouse").getValue()!=null&&kdtEntrys.getCell(i, "breedBatch").getValue()!=null){
					String stoOrgUnitInfoID = ((StorageOrgUnitInfo)kdtEntrys.getCell(i, "stoOrgUnit").getValue()).getId().toString();
					String henHouseInfoID = ((HenhouseInfo)kdtEntrys.getCell(i, "henHouse").getValue()).getId().toString();
					String breedBatchInfoID = ((BreedBatchInfo)kdtEntrys.getCell(i, "breedBatch").getValue()).getId().toString();

//					if(SlaughterPlanFacadeFactory.getRemoteInstance().getSlaughterQtyInOneDay(stoOrgUnitInfoID,henHouseInfoID,breedBatchInfoID)==null){
//						needDelete.add(i);
//						continue;
//					}
					//获得该鸡舍在商品鸡养殖日报的最后一日的存栏量
					str=SlaughterPlanFacadeFactory.getRemoteInstance().getSlaughterQtyInOneDay(stoOrgUnitInfoID,henHouseInfoID,breedBatchInfoID);

					//根据死淘迭代出最终宰杀数量
					kdtEntrys.getCell(i, "SlaughterAmt").setValue((Integer)getSlaughterAmtOfCurrentHenHouse(str[0],str[1],str[2],(Date)kdtEntrys.getCell(i, "pkDate").getValue()));
				}
		}
//		for(int i=kdtEntrys.getRowCount()-1;i>=0;i--)
//			if(foodComm.inNumbers(i, needDelete))
//				kdtEntrys.removeRow(i);
	}

	/**
	 * 日历分录填写每日宰杀数量和宰杀详情
	 * @throws BOSException 
	 */
	private void setSlaughterQtyAndDetails() throws BOSException {
		// TODO Auto-generated method stub
		Map<Date,Object>[] mapSlaughterInfo=kdtEntrysCalculateSlaughterQtyByDate();//计算每日的宰杀数量
		setKdtEntrySchedulingSlaughterDetails(mapSlaughterInfo[1]);//显示每日的宰杀详情（哪个场杀几个舍）
		setKdtEntrySchedulingSlaughterQty(mapSlaughterInfo[0]);//显示每日的宰杀数量
	}
	/**
	 * 排序的最后阶段，增加要显示的分录
	 * @param strKey
	 * @param strValue
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void kdtEntrysAddRowAtLastTimesSort(int num,String[] strKey,
			String[] strValue) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		int number=num;;
		if(num==-1){
			kdtEntrys.addRow();
			number=kdtEntrys.getRowCount()-1;
		}
		kdtEntrys.getCell(number,"lairageDate" ).setValue(foodComm.getDateByString(strKey[0]));
		kdtEntrys.getCell(number,"stoOrgUnit" ).setValue(foodComm.getStorageOrgUnitInfoByID(strKey[1]));
		kdtEntrys.getCell(number,"henHouse" ).setValue(foodComm.getHenHouseInfoByID(strKey[2]));
		if(foodComm.getHenHouseInfoByID(strKey[2])!=null)
			kdtEntrys.getCell(number,"henHouseName" ).setValue(foodComm.getHenHouseInfoByID(strKey[2]).getName());
		kdtEntrys.getCell(number,"breedBatch" ).setValue(foodComm.getBreedBatchInfoByID(strKey[3]));
		if(strKey[4].equals("true"))
			kdtEntrys.getCell(number,"isLocked" ).setValue(true);
		else
			kdtEntrys.getCell(number,"isLocked" ).setValue(false);

		kdtEntrys.getCell(number,"pkDate" ).setValue(foodComm.getDateByString(strValue[0]));
		kdtEntrys.getCell(number,"ageOfDaysActually" ).setValue(Integer.parseInt(strValue[1]));
		if(Integer.parseInt(strValue[1])>txtageOfDaysTo.getIntegerValue()||Integer.parseInt(strValue[1])<txtageOfDaysFrom.getIntegerValue())
			kdtEntrys.getCell(number,"ageOfDaysActually" ).getStyleAttributes().setFontColor(Color.red);
		kdtEntrys.getCell(number,"SlaughterAmt" ).setValue(Integer.parseInt(strValue[2]));

	}
	/**
	 * 根据商品鸡日报养殖数据   饲喂规范里面的死淘信息  以及  实际宰杀日龄    获得当前鸡舍的最终宰杀数量
	 * @param currentDate      商品鸡日报饲喂日期
	 * @param currentQty       商品鸡日报存栏量
	 * @param days             商品鸡日报的日龄
	 * @param slaughterDate    宰杀日龄
	 * @return                 宰杀时的理论只数
	 * @throws ParseException 
	 */
	private int getSlaughterAmtOfCurrentHenHouse(String currentDate, String currentQty, String days, Date slaughterDate) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = sdf.parse(currentDate);//养殖日报最后一个日龄

		int ageOfDays = Integer.parseInt(days);//计算时的实际日龄

		BigDecimal actualQty = new BigDecimal(currentQty);//计算时的实际数量

		Calendar cal=Calendar.getInstance();
		cal.setTime(beginDate);

		while(cal.getTime().before(slaughterDate)){
			++ageOfDays;
			cal.add(Calendar.DATE, +1);
			actualQty=actualQty.subtract(mapCullAndDeath.get(ageOfDays).multiply(new BigDecimal("0.01")).multiply(actualQty));
		}
		return foodComm.translateFromBigdecimalToInteger(actualQty);
	}
	/**
	 * 宰杀分录  增加一条分录，若成功添加，返回true，否则返回false
	 * @param key
	 * @param row
	 * @return
	 * @throws ParseException
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private boolean insertValueInfoSuccessfully(String key, int row) throws ParseException, BOSException, EASBizException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date slughterDate = (Date)kdtEntryScheduling.getCell(row, "schedulingDate").getValue();//日历分录的宰杀日期
		int agesOfDaysLimitD = 30;//宰杀日龄最小值

		if(txtageOfDaysFrom.getIntegerValue()!=null)
			agesOfDaysLimitD=txtageOfDaysFrom.getIntegerValue();

		String[] array = key.split("_");
		Date lairageDate = sdf.parse(array[0]);
		int agesOfDays = foodComm.getDiffBetweenTwoDays(lairageDate, slughterDate);

		if(agesOfDays<agesOfDaysLimitD)//如果日龄小于 填写的日龄最小值则跳过
			return false;


		kdtEntryAddRow(lairageDate,slughterDate,array,agesOfDays);//否则，增加分录




		return true;
	}

	/**
	 * 给予用户提示消息并退出进程
	 * @param str
	 */
	private void giveUserTips(String str){
		MsgBox.showInfo(str);
		abort();
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showInfo("只能审核已提交状态的单据");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核完成");
		reloadData();
	}
	/**
	 * 保存
	 */
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//判断该当月屠宰计划是否已存在
		isExist();
		if(editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showInfo("该单据已审核");
			SysUtil.abort();
		}
		super.actionSubmit_actionPerformed(e);
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showInfo("该单据尚未审核");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核完成");
		reloadData();
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.ADD)&&!this.editData.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("单据无法删除");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(arg0);
	}
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.actionEdit_actionPerformed(arg0);
		setEntrysVisual();
	}  

}