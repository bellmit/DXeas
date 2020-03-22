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



	//     ��ǰ������ ��ֳ�淶
	//    private BreedModelInfo layeggModel;
	// ��� �����ƻ���ϸ  ����rilingΪKey ,
	Map<String,BreedModelLayEggEntryInfo> standards;
	//��� ��ι�淶����ι��ϸ���Ӷ���ò�������������Ϣ
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
	 * �����ʼ�� 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		// ����ȫ��
		//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		contLastUpdateUser.setVisible(true);
		contLastUpdateTime.setVisible(true);
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));

		// ���ص�ǰ ���õĲ����淶

		standards  = LayEggFacadeFactory.getRemoteInstance().getLayeggStandard("1");
		if(standards == null || standards.size() <= 0){
			MsgBox.showWarning("δ��ȡ����ǰ���õĲ������淶�Ĳ����淶��ϸ������ϵ��Ϣ������");
			SysUtil.abort();
		}
		//���ص�ǰ����ι�淶���Ӷ����������Ϣ
		feedStandards=LayEggFacadeFactory.getRemoteInstance().getFeedStandard("1");
		if(feedStandards==null||feedStandards.size()<=0)
		{
			MsgBox.showWarning("δ��ȡ����ǰ���õĲ������淶����ι�淶��ϸ������ϵ��Ϣ������");
			SysUtil.abort();
		}

		setBtnEnable();//���ð�ť������		
		setSumValue();//�ϼ���		
		setStorageUnitFilter();//���ñ�ͷ��ֳ����������

	}
	private void setBtnEnable() {
		// TODO Auto-generated method stub
		if(editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
		{btnEdit.setEnabled(false);btnRemove.setEnabled(false);}
	}
	/**
	 * ���� ��ͷ��ֳ������
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
	 * �ϼ���
	 */
	private void setSumValue() {
		// TODO Auto-generated method stub
		String []array={"layEggQty","upEggQty","freakEggQty","doubleYolkEggQty","brokenEggQty"};
		apendFootRow(kdtEntrys,array);
		KDTPropertyChangeListener kdtEntryListener=new KDTPropertyChangeListener()//�ϼ���
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
	 * ���ܣ���Ӻϼ��� 
	 *  
	 * @param table 
	 *            ָ����KDTable 
	 * @param fields 
	 *            ��Ҫ�ϼƵ��� 
	 */  	
	@SuppressWarnings("unchecked")
	public static Map apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return null;  
		Map sumValue = new HashMap();  
		// ����getRowCount�õ����п��ܲ���ȷ  
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
		// ��������ָ���еĺϼ�ֵ  
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
		// ���úϼ�����ʾ��ʽ  
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

		// ���úϼ��е�ֵ  
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
			MsgBox.showWarning("��¼������Ϊ��");
			SysUtil.abort();
		}
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kdtEntrys.getRowCount()==0)
		{
			MsgBox.showWarning("��¼������Ϊ��");
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

		// ���ÿ��Ͳ�����֯Ĭ��
		vo.put("farm", SysContext.getSysContext().getCurrentStorageUnit());
		//        vo.put("company", SysContext.getSysContext().getCurrentFIUnit());
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

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.actionRemove_actionPerformed(arg0);
	}
	/**
	 * ���ص�������
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
	 * ���� �����ƻ���ϸ
	 */
	@Override
	protected void btnGenerateDetails_actionPerformed(ActionEvent e)
	throws Exception {

		//�ظ����������ϸ�ƻ�ʱ��ɾ����ǰ�ķ�¼��Ϣ
		if(kdtEntrys.getRowCount()>0)
			kdtEntrys.removeRows();
		// ����У������
		validateData();
		// ��ֳ��
		StorageOrgUnitInfo layEggFarm = (StorageOrgUnitInfo) this.prmtfarm.getValue();
		// �ڼ�
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
		// ��ʼ���ں��ڼ�������ڲ�


		//�з�¼��ʵ�����������
		int week=beginWeek;
		int weekDay=beginWeekDays;
		Date date=periodBeginDate;
		//ȡ�ÿ������ڵ�������
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

			//��ø�������Ĳ�����ϸ
			String str=BreedCommonUtil.getWeekDayStr(week, weekDay);
			BreedModelLayEggEntryInfo LayEggModelInfo = standards.get(str);
			if(LayEggModelInfo==null)
				LayEggModelInfo = standards.get(BreedCommonUtil.getWeekDayStr(week, 1));
			if(LayEggModelInfo==null)
				LayEggModelInfo = standards.get(BreedCommonUtil.getWeekDayStr(week, 0));


			//��ø������ĸ��������ϸ
			BreedModelEntryInfo FeedModelInfo=feedStandards.get(String.valueOf(week));
			if(LayEggModelInfo==null){
				kdtEntrys.removeRows();
				MsgBox.showWarning("û���ҵ���ǰ������Ĳ����淶");
				SysUtil.abort();
			}
			if(FeedModelInfo==null)
			{
				kdtEntrys.removeRows();
				MsgBox.showWarning("��ι�淶��ϸ�����ƣ�����ϵ��Ϣ������");
				SysUtil.abort();
			}

			//��ò����ռƻ���ϸ

			//����
			kdtEntrys.getCell(i, "planDate").setValue(cal.getTime());

			//����
			kdtEntrys.getCell(i,"week").setValue(week);
			//����
			kdtEntrys.getCell(i,"weekDay").setValue(weekDay);

			//�ּ�����
			BigDecimal CullAndDeathRate=BigDecimal.ZERO;
			if(FeedModelInfo.getDailyDCRate()!=null)
				CullAndDeathRate = FeedModelInfo.getDailyDCRate();
			if(i>0)
				actualAmt=actualAmt.subtract(henAmt.multiply(CullAndDeathRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN));
			kdtEntrys.getRow(i).getCell("henQty").setValue(actualAmt);

			//�������������
			BigDecimal LayEggRate = LayEggModelInfo.getEggRate();
			kdtEntrys.getRow(i).getCell("layingRate").setValue(LayEggRate);
			BigDecimal eggs = actualAmt.multiply(LayEggRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN);
			kdtEntrys.getRow(i).getCell("layEggQty").setValue(eggs);

			//�ϸ�����ϸ���
			BigDecimal upRate = LayEggModelInfo.getUpEggRate();
			kdtEntrys.getRow(i).getCell("upRate").setValue(upRate);
			BigDecimal upEggQty = eggs.multiply(upRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN);
			kdtEntrys.getRow(i).getCell("upEggQty").setValue(upEggQty);

			//���ε���
			BigDecimal freakEggRate=LayEggModelInfo.getFreakRate();
			kdtEntrys.getRow(i).getCell("freakEggQty").setValue(eggs.multiply(freakEggRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN));

			//˫�Ƶ�
			BigDecimal doubleYolkEggRate=LayEggModelInfo.getDoubleYolkRate();
			kdtEntrys.getRow(i).getCell("doubleYolkEggQty").setValue(eggs.multiply(doubleYolkEggRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN));

			//�Ƶ�
			BigDecimal brokenEggRate=LayEggModelInfo.getBrokenRate();
			kdtEntrys.getRow(i).getCell("brokenEggQty").setValue(eggs.multiply(brokenEggRate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN));

			//			//������
			//			int intUpEggs = Integer.parseInt(upEggQty.toString());
			//			int quantityEggs=0;
			//			if(txtquantityEggs.getIntegerValue()!=null)
			//				quantityEggs=txtquantityEggs.getIntegerValue();
			//			kdtEntrys.getRow(i).getCell("quantityEggCars").setValue((quantityEggs+intUpEggs)/getEggsPerCar());
			//			txtquantityEggs.setValue((quantityEggs+intUpEggs)%getEggsPerCar());
		}
	}
	//	/**
	//	 * ��ȡ��������װ����
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
	//			MsgBox.showWarning("δ���ֻ��ֶ�������õķ����������ϣ�����ϵ��Ϣ�����д���");
	//			SysUtil.abort();
	//		}
	//		return hatchBaseInfo.getEggQtyPerCar();
	//	}

	/**
	 * У�� ����׼ȷ��
	 */
	public void validateData(){

		StorageOrgUnitInfo layEggFarm = (StorageOrgUnitInfo) this.prmtfarm.getValue();
		if(layEggFarm == null){
			MsgBox.showInfo("��ֳ������Ϊ��");
			SysUtil.abort();
		}

		PeriodInfo period = (PeriodInfo) this.prmtperiod.getValue();
		// �ڼ䲻��Ϊ��
		if(period == null){
			MsgBox.showInfo("�ڼ䲻��Ϊ��");
			SysUtil.abort();
		}

		//		Date periodBeginDate = period.getBeginDate();
		Date periodEndDate = period.getEndDate();


		int beginWeek = this.txtinitWeek.getIntegerValue();
		int beginWeekDays = this.txtinitDays.getIntegerValue();
		if(beginWeek < 21){
			MsgBox.showInfo("�³����䲻��С��21");
			SysUtil.abort();
		}else{
			if(beginWeekDays <= 0){
				MsgBox.showInfo("�³����䲻��С��1");
				SysUtil.abort();
			}
			if(beginWeekDays>7){
				MsgBox.showInfo("�³����䲻�ܴ���7");
				SysUtil.abort();
			}
		}
		int initQty = this.txtinitHenQty.getIntegerValue();

		if(initQty < 0){
			MsgBox.showInfo("�³�������������С��0");
			SysUtil.abort();
		}

		Date initDate = this.pkbeginDate.getSqlDate();

		// �������ڲ��ܴ����ڼ����һ��
		if(initDate.after(periodEndDate)){
			MsgBox.showInfo("�������ڲ������·�֮��");
			SysUtil.abort();
		}

	}
	/**
	 * �ڼ�ѡ�к� ���¿������� Ϊ�ڼ�� ��ʼ����
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
	 * �����ϸ��Ϣ
	 */
	@Override
	protected void btnClearEntrys_actionPerformed(ActionEvent e)
	throws Exception {
		//��ձ���ڵ�������
		kdtEntrys.removeRows();
		super.btnClearEntrys_actionPerformed(e);
	}
}