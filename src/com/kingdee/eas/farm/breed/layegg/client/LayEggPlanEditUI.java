/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelLayEggEntryInfo;
import com.kingdee.eas.farm.breed.comm.BreedCommonUtil;
import com.kingdee.eas.farm.breed.layegg.LayEggFacadeFactory;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.mm.project.client.gantt.net.sourceforge.ganttproject.time.gregorian.GregorianCalendar;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class LayEggPlanEditUI extends AbstractLayEggPlanEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(LayEggPlanEditUI.class);



	//     当前产蛋场 养殖规范
	//    private BreedModelInfo layeggModel;
	// 获得 产蛋计划明细  周龄riling为Key ,
	Map<String,BreedModelLayEggEntryInfo> standards;
	//获得 饲喂规范的饲喂明细，从而获得产蛋鸡的死淘信息
	Map<String,BreedModelEntryInfo> feedStandards;

	/**
	 * output class constructor
	 */
	public LayEggPlanEditUI() throws Exception
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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.breed.layegg.LayEggPlanFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo objectValue = new com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

	/**
	 * 界面初始化 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		contLastUpdateUser.setVisible(true);
		contLastUpdateTime.setVisible(true);
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));

		// 加载当前 启用的产蛋规范

		standards  = LayEggFacadeFactory.getRemoteInstance().getLayeggStandard("1");
		if(standards == null || standards.size() <= 0){
			MsgBox.showWarning("未获取到当前启用的产蛋场规范的产蛋规范明细，请联系信息部处理");
			SysUtil.abort();
		}
		//加载当前的饲喂规范，从而获得死淘信息
		feedStandards=LayEggFacadeFactory.getRemoteInstance().getFeedStandard("1");
		if(feedStandards==null||feedStandards.size()<=0)
		{
			MsgBox.showWarning("未获取到当前启用的产蛋场规范的饲喂规范明细，请联系信息部处理");
			SysUtil.abort();
		}

		setBtnEnable();//设置按钮可用性		
		setSumValue();//合计行		
		setStorageUnitFilter();//设置表头养殖场：产蛋厂

	}
	private void setBtnEnable() {
		// TODO Auto-generated method stub
		if(editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
		{btnEdit.setEnabled(false);btnRemove.setEnabled(false);}
	}
	/**
	 * 设置 表头养殖场过滤
	 */
	private void setStorageUnitFilter() {
		// TODO Auto-generated method stub
		EntityViewInfo entityViewInfo=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("Number","3022%",CompareType.LIKE));
		filterInfo.getFilterItems().add(new FilterItemInfo("Number","3022",CompareType.NOTEQUALS));
		entityViewInfo.setFilter(filterInfo);
		prmtfarm.setEntityViewInfo(entityViewInfo);
	}
	/**
	 * 合计行
	 */
	private void setSumValue() {
		// TODO Auto-generated method stub
		String []array={"layEggQty","upEggQty","freakEggQty","doubleYolkEggQty","brokenEggQty"};
		apendFootRow(kdtEntrys,array);
		KDTPropertyChangeListener kdtEntryListener=new KDTPropertyChangeListener()//合计行
		{
			public void propertyChange(KDTPropertyChangeEvent arg0) 
			{
				String []array={"layEggQty","upEggQty","freakEggQty","doubleYolkEggQty","brokenEggQty"};
				Map<String, BigDecimal> sumValue=apendFootRow(kdtEntrys,array);
				txtallEggQty.setValue(sumValue.get("layEggQty"));
				txtallUpEggQty.setValue(sumValue.get("upEggQty"));
				txtallFreakEggQty.setValue(sumValue.get("freakEggQty"));
				txtallDoubleYolkEggQty.setValue(sumValue.get("doubleYolkEggQty"));
				txtallBrokenEggQty.setValue(sumValue.get("brokenEggQty"));
			}
		};
		kdtEntrys.addKDTPropertyChangeListener(kdtEntryListener);
	}
	/** 
	 * 功能：添加合计行 
	 *  
	 * @param table 
	 *            指定的KDTable 
	 * @param fields 
	 *            需要合计的列 
	 */  	
	@SuppressWarnings("unchecked")
	public static Map apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return null;  
		Map sumValue = new HashMap();  
		// 利用getRowCount得到的行可能不正确  
		int count = table.getRowCount();  
		if(count == 0){
			count = table.getRowCount1();
		}
		if(count == 0){
			count = table.getRowCount3();
		}
		for (int i = 0; i < fields.length; i++) {  
			sumValue.put(fields[i], new BigDecimal("0.00"));  
		}  
		IRow footRow = null;  
		KDTFootManager footManager = table.getFootManager();  
		if (footManager == null) {  
			footManager = new KDTFootManager(table);  
			footManager.addFootView();  
			table.setFootManager(footManager);  
		}  
		// 计算所有指定行的合计值  
		footRow = footManager.getFootRow(0);  
		for (int i = 0; i < count; i++) {  
			IRow row = table.getRow(i);  
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0.00}f";  

		String total = com.kingdee.eas.util.client.EASResource.getString(FrameWorkClientUtils.strResource  
				+ "Msg_Total");  

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(30);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i];  
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(  
					colFormat);  
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(  
					HorizontalAlignment.RIGHT);  
			footRow.getCell(colName).getStyleAttributes().setFontColor(  
					Color.black);  
		}  

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			footRow.getCell(fields[i]).setValue(sumValue.get(fields[i]));  
		}  
		return sumValue;
	}  


	@SuppressWarnings("unchecked")
	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		com.kingdee.bos.ctrl.kdf.table.ICell cell =row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (obj != null) {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
		}  
	}


	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kdtEntrys.getRowCount()==0)
		{
			MsgBox.showWarning("分录不允许为空");
			SysUtil.abort();
		}
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kdtEntrys.getRowCount()==0)
		{
			MsgBox.showWarning("分录不允许为空");
			SysUtil.abort();
		}
		super.actionSubmit_actionPerformed(e);
	}

	/**
	 * output applyDefaultValue method
	 */
	protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
		vo.put("bizDate", new Date());
		//		UserInfo currUser = SysContext.getSysContext().getCurrentUserInfo();
		//        PersonInfo currPerson = currUser.getPerson();
		//        if(currPerson != null){
		//        	vo.put("person", currPerson);
		//        }

		// 设置库存和财务组织默认
		vo.put("farm", SysContext.getSysContext().getCurrentStorageUnit());
		//        vo.put("company", SysContext.getSysContext().getCurrentFIUnit());
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

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.actionRemove_actionPerformed(arg0);
	}
	/**
	 * 重载单据内容
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
	 * 生成 产蛋计划明细
	 */
	@Override
	protected void btnGenerateDetails_actionPerformed(ActionEvent e)
	throws Exception {

		//重复点击生成明细计划时，删除以前的分录信息
		if(kdtEntrys.getRowCount()>0)
			kdtEntrys.removeRows();
		// 首先校验数据
		validateData();
		// 养殖场
		StorageOrgUnitInfo layEggFarm = (StorageOrgUnitInfo) this.prmtfarm.getValue();
		// 期间
		PeriodInfo period = (PeriodInfo) this.prmtperiod.getValue();

		Date periodBeginDate = period.getBeginDate();
		Date periodEndDate = period.getEndDate();


		int beginWeek = this.txtinitWeek.getIntegerValue();
		int beginWeekDays = this.txtinitDays.getIntegerValue();

		int initQty = this.txtinitHenQty.getIntegerValue();

		Date initDate = this.pkbeginDate.getSqlDate();

		long diff = periodEndDate.getTime()-initDate.getTime();
		long nd = 1000*24*60*60;
		long diffDaysLong = diff/nd;

		int diffDaysDay = new Long(diffDaysLong).intValue();
		// 开始日期和期间结束日期差


		//行分录的实际日龄和周龄
		int week=beginWeek;
		int weekDay=beginWeekDays;
		Date date=periodBeginDate;
		//取得开算日期的周日龄
		while(date.before(initDate))
		{
			GregorianCalendar calendar=new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1);
			date=calendar.getTime();
			++weekDay;
			if(weekDay>7){
				++week;
				weekDay=1;
			}
		};
		BigDecimal henAmt = new BigDecimal(String.valueOf(initQty));
		BigDecimal actualAmt = new BigDecimal(String.valueOf(initQty));
		for(int i=0;i<=diffDaysDay;i++)
		{
			kdtEntrys.addRow();
			GregorianCalendar cal=new GregorianCalendar();
			cal.setTime((Date)pkbeginDate.getValue());
			cal.add(Calendar.DATE, i);
			if(i!=0){
				++weekDay;
				if(weekDay>7){
					++week;
					weekDay=1;
				}
			}

			//获得该周日龄的产蛋明细
			String str=BreedCommonUtil.getWeekDayStr(week, weekDay);
			BreedModelLayEggEntryInfo LayEggModelInfo = standards.get(str);
			if(LayEggModelInfo==null)
				LayEggModelInfo = standards.get(BreedCommonUtil.getWeekDayStr(week, 1));
			if(LayEggModelInfo==null)
				LayEggModelInfo = standards.get(BreedCommonUtil.getWeekDayStr(week, 0));


			//获得该周龄的母鸡死淘明细
			BreedModelEntryInfo FeedModelInfo=feedStandards.get(String.valueOf(week));
			if(LayEggModelInfo==null){
				kdtEntrys.removeRows();
				MsgBox.showWarning("没有找到当前周日龄的产蛋规范");
				SysUtil.abort();
			}
			if(FeedModelInfo==null)
			{
				kdtEntrys.removeRows();
				MsgBox.showWarning("饲喂规范明细不完善，请联系信息部处理");
				SysUtil.abort();
			}

			//获得产蛋日计划明细

			//日期
			kdtEntrys.getCell(i, "planDate").setValue(cal.getTime());

			//周龄
			kdtEntrys.getCell(i,"week").setValue(week);
			//日龄
			kdtEntrys.getCell(i,"weekDay").setValue(weekDay);

			//种鸡套数
			BigDecimal CullAndDeathRate=BigDecimal.ZERO;
			if(FeedModelInfo.getDailyDCRate()!=null)
				CullAndDeathRate = FeedModelInfo.getDailyDCRate();
			if(i>0)
				actualAmt=actualAmt.subtract(henAmt.multiply(CullAndDeathRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN));
			kdtEntrys.getRow(i).getCell("henQty").setValue(actualAmt);

			//产蛋率与产蛋数
			BigDecimal LayEggRate = LayEggModelInfo.getEggRate();
			kdtEntrys.getRow(i).getCell("layingRate").setValue(LayEggRate);
			BigDecimal eggs = actualAmt.multiply(LayEggRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN);
			kdtEntrys.getRow(i).getCell("layEggQty").setValue(eggs);

			//合格率与合格蛋数
			BigDecimal upRate = LayEggModelInfo.getUpEggRate();
			kdtEntrys.getRow(i).getCell("upRate").setValue(upRate);
			BigDecimal upEggQty = eggs.multiply(upRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN);
			kdtEntrys.getRow(i).getCell("upEggQty").setValue(upEggQty);

			//畸形蛋数
			BigDecimal freakEggRate=LayEggModelInfo.getFreakRate();
			kdtEntrys.getRow(i).getCell("freakEggQty").setValue(eggs.multiply(freakEggRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN));

			//双黄蛋
			BigDecimal doubleYolkEggRate=LayEggModelInfo.getDoubleYolkRate();
			kdtEntrys.getRow(i).getCell("doubleYolkEggQty").setValue(eggs.multiply(doubleYolkEggRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN));

			//破蛋
			BigDecimal brokenEggRate=LayEggModelInfo.getBrokenRate();
			kdtEntrys.getRow(i).getCell("brokenEggQty").setValue(eggs.multiply(brokenEggRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN));

			//			//蛋车数
			//			int intUpEggs = Integer.parseInt(upEggQty.toString());
			//			int quantityEggs=0;
			//			if(txtquantityEggs.getIntegerValue()!=null)
			//				quantityEggs=txtquantityEggs.getIntegerValue();
			//			kdtEntrys.getRow(i).getCell("quantityEggCars").setValue((quantityEggs+intUpEggs)/getEggsPerCar());
			//			txtquantityEggs.setValue((quantityEggs+intUpEggs)%getEggsPerCar());
		}
	}
	//	/**
	//	 * 获取孵化蛋车装蛋数
	//	 */
	//	protected int getEggsPerCar(){
	//		HatchBaseDataInfo hatchBaseInfo=null;
	//		try {
	//			hatchBaseInfo=com.kingdee.eas.farm.hatch.hatchFacadeFactory.getRemoteInstance().getHatchBaseData();
	//		} catch (BOSException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		if(hatchBaseInfo==null)
	//		{
	//			MsgBox.showWarning("未发现或发现多个已启用的孵化基础资料，请联系信息部进行处理");
	//			SysUtil.abort();
	//		}
	//		return hatchBaseInfo.getEggQtyPerCar();
	//	}

	/**
	 * 校验 数据准确性
	 */
	public void validateData(){

		StorageOrgUnitInfo layEggFarm = (StorageOrgUnitInfo) this.prmtfarm.getValue();
		if(layEggFarm == null){
			MsgBox.showInfo("养殖场不能为空");
			SysUtil.abort();
		}

		PeriodInfo period = (PeriodInfo) this.prmtperiod.getValue();
		// 期间不能为空
		if(period == null){
			MsgBox.showInfo("期间不能为空");
			SysUtil.abort();
		}

		//		Date periodBeginDate = period.getBeginDate();
		Date periodEndDate = period.getEndDate();


		int beginWeek = this.txtinitWeek.getIntegerValue();
		int beginWeekDays = this.txtinitDays.getIntegerValue();
		if(beginWeek < 21){
			MsgBox.showInfo("月初周龄不能小于21");
			SysUtil.abort();
		}else{
			if(beginWeekDays <= 0){
				MsgBox.showInfo("月初日龄不能小于1");
				SysUtil.abort();
			}
			if(beginWeekDays>7){
				MsgBox.showInfo("月初日龄不能大于7");
				SysUtil.abort();
			}
		}
		int initQty = this.txtinitHenQty.getIntegerValue();

		if(initQty < 0){
			MsgBox.showInfo("月初存栏套数不能小于0");
			SysUtil.abort();
		}

		Date initDate = this.pkbeginDate.getSqlDate();

		// 起算日期不能大于期间最后一天
		if(initDate.after(periodEndDate)){
			MsgBox.showInfo("起算日期不能在月份之后");
			SysUtil.abort();
		}

	}
	/**
	 * 期间选中后 更新开算日期 为期间的 开始日期
	 */
	@Override
	protected void prmtperiod_dataChanged(DataChangeEvent e) throws Exception {
		PeriodInfo period = (PeriodInfo) this.prmtperiod.getValue();
		if(period != null){
			Date periodBeginDate = period.getBeginDate();
			Date periodEndDate = period.getEndDate();
			Date initDate = this.pkbeginDate.getSqlDate();
			if(initDate == null){
				this.pkbeginDate.setValue(periodBeginDate);
			}else
				if(!initDate.after(periodBeginDate)||!initDate.before(periodEndDate))
					this.pkbeginDate.setValue(periodBeginDate);
		}
	}
	/**
	 * 清空明细信息
	 */
	@Override
	protected void btnClearEntrys_actionPerformed(ActionEvent e)
	throws Exception {
		//清空表格内的所有行
		kdtEntrys.removeRows();
		super.btnClearEntrys_actionPerformed(e);
	}
}