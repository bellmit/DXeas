/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.farm.carnivorous.basedata.BatchCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class StockingDailyEditUI extends AbstractStockingDailyEditUI
{

	private static final Logger logger = CoreUIObject.getLogger(StockingDailyEditUI.class);
	private boolean isLoadField = false;
	private String curStorageOrgUnitID;
	private String curCompanyID;
	private OrgUnitInfo orgInfo=null;
	private F7ContextManager f7Manager;
	public StockingDailyEditUI() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());//���õ�ǰ����Ĺ��췽��
	}
	protected com.kingdee.bos.dao.IObjectValue createNewData()//�����µ����ݶ��󣬲����ó�ʼֵ���൱�ڰ����ݼ��ص��´�����Info��
	{
		StockingDailyInfo objectValue = new StockingDailyInfo();
		//���ô����߳�ֵ
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		//��ȡ��ǰ������֯
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date bizDate=sdf.parse(sdf.format(new Date()));
			//ҵ��ʱ������
			objectValue.setBizDate(bizDate);
			//			objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID)));
			//��ȡû����д������ֳ�ձ�����ֳ��
			ArrayList<String> batchIDList = getNoExistBatchIDDailyToday();
			IBatch ibs = BatchFactory.getRemoteInstance();
			BatchInfo bInfo;
			//�������������ʹ��ֳ��������ʾ�������Ϣ
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("farmer.*"));
			slor.add(new SelectorItemInfo("farm.*"));
			for(String batchID:batchIDList) {
				bInfo=ibs.getBatchInfo(new ObjectUuidPK(batchID),slor);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return objectValue;
	}
	//�õ�����û����д��ֳ�ձ�����ֳ��
	private ArrayList<String> getNoExistBatchIDDailyToday() {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		try {
			//���ְԱΪ�գ��򷵻�
			if(SysContext.getSysContext().getCurrentUserInfo().getPerson()==null) {
				return list;
			}

			//�޳����Ѿ�����д���û�
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date bizdate=(Date) pkBizDate.getValue();
			StringBuffer sql=new StringBuffer();
			sql.append(" /*dialect*/select tbatch.fid from t_fm_stockingBatch tbatch")
			.append(" where tbatch.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)//�Ѻ�׼
			.append(" and tbatch.FCompanyID='").append(curCompanyID).append("'")
			.append(" and (tbatch.ffarmerid,tbatch.ffarmid) in (")
			.append(" select t2.FFarmerID,tfarm.ffarmid  from T_FM_PersonFarmerRelation t1  ")
			.append(" inner join  T_FM_PersonFarmerRelationEntry t2 on t2.fparentid=t1.fid ")
			.append(" inner join T_FM_FarmersFarmEntry tfarm on tfarm.fparentid=t2.ffarmerid ")
			.append(" where t1.FPersonID='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'")
			.append(" and t1.FCompanyID='").append(curCompanyID).append("'")
			.append(" and (tbatch.fisAllOut=0 or tbatch.fisAllOut is null)")//δ����

			.append(" ) and (tbatch.ffarmerid,tbatch.ffarmid) not in (")
			.append("  select ffarmerid,cffarmid  ")
			.append("  from T_FM_StockingBreedDaily")
			.append("  where FCompanyID='").append(curCompanyID).append("'")
			.append("  and FBizDate>=to_date('").append(sdf.format(bizdate)).append(" 00:00:00','yyyy-MM-dd HH24:mi:ss')")
			.append("  and FBizDate<=to_date('").append(sdf.format(bizdate)).append(" 23:59:59','yyyy-MM-dd HH24:mi:ss')");
			//			if(editData!=null&&editData.getId()!=null) {
			//				//					 sql.append("  and fid!='").append(editData.getId()).append("'");
			//			}
			sql.append(" )")
			.append(" order by tbatch.fnumber");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()) {
				list.add(rs.getString("fid"));
			}

		}catch(Exception err) {
			err.printStackTrace();
		}
		return list;
	}
	@Override
	//��ȡ��ǰ������֯���û��������֯
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		//��ǰ�����֯ID
		curStorageOrgUnitID=ClientUtils.getCurrentStorageUnit().getString("id");
		//��ǰ������֯ID
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		//�ѵ�ǰ�����֯��ID��ŵ������֯��
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		//f7����
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();

		kdtAssEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				if(isLoadField)
				{
					return;
				}
				Integer oldValue = UIRuleUtil.getInt(e.getOldValue());
				Integer newValue = UIRuleUtil.getInt(e.getValue());
				if(kdtAssEntrys.getColumnKey(e.getColIndex()).equals("deathQty")||kdtAssEntrys.getColumnKey(e.getColIndex()).equals("cullQty")||kdtAssEntrys.getColumnKey(e.getColIndex()).equals("markedQty")){
					kdtAssEntrys.getCell(e.getRowIndex(), "breekingStock").setValue(UIRuleUtil.getInt(kdtAssEntrys.getCell(e.getRowIndex(), "breekingStock").getValue())-(newValue-oldValue));
				}else if(kdtAssEntrys.getColumnKey(e.getColIndex()).equals("adjustQty")){
					kdtAssEntrys.getCell(e.getRowIndex(), "breekingStock").setValue(UIRuleUtil.getInt(kdtAssEntrys.getCell(e.getRowIndex(), "breekingStock").getValue())+(newValue-oldValue));
				}
				super.editStopped(e);



			}


		});

	}
	//������ˣ������ͼ�꣬���ù�������������Ƿ���г�ʼ��Ȩ��
	private void initControl() {
		// TODO Auto-generated method stub
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));//�˵������ͼ��
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));//�˵��������ͼ��
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));//���������ͼ��
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));//�����������ͼ��
		prmtfarm.setEnabled(true);
		chkisInit.setVisible(false);
		//ҵ������
		this.pkBizDate.setDatePattern("yyyy-MM-dd");
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		//��ι��Ϣ��¼���½���
		kdtEntrys.checkParsed();
		//������Ϣ��¼���½���
		kdtImmuneEntrys.checkParsed();
		//������ι��¼�е�����F7�����ÿ����֯
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");

		//����������Ϣ�е������¼F7�����ÿ����֯
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtImmuneEntrys.getColumn("vaccineMaterial").getEditor().getComponent(), null, null, orgInfo,false);
		//		f7Manager.registerMeasureUnitF7(kdtImmuneEntrys, "material", "vaccineUnit");
		//���õ����أ�������ʽ
		this.kdtEntrys.getColumn("unitQty").getStyleAttributes().setNumberFormat("#.00");
		this.kdtEntrys.getColumn("bagQty").getStyleAttributes().setNumberFormat("#.00");
		//���ù���������������֯
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(!isLoadField) {
					//������ֳ�������ֳ��
					StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
					//�������εĹ�������
					StockingComm.setBatchFilter(prmtbatch, curCompanyID, ((IPropertyContainer)prmtfarmer.getValue()).getString("id"), ((IPropertyContainer)prmtfarm.getValue()).getString("id"));
				}
				setFilter();
			}});
		//��ֳ��
		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				farm_changed(e);
				setBatchFilter();

			}});

		//����
		this.prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed();
			}});
		//ҵ������
		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
			}});

		farm_changed(null);
		setFilter();

	}

	protected void batch_changed() {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		isLoadField=true;

		if(prmtbatch.getValue()!=null) {
			try {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("farmer.*");
				slor.add("farm.*");
				//ͨ���������ı���ֳ������ֳ��,�൱��֪�������е���ֳ������ֳ���������ֵ���������ϵ���ֳ����ֳ��
				BatchInfo batchInfo=BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(((AbstractCoreBaseInfo) prmtbatch.getValue()).getId()),slor);
				isLoadField=true;
				this.prmtfarmer.setValue(batchInfo.getFarmer());
				this.prmtfarm.setValue(batchInfo.getFarm());
				isLoadField=false;

				Date batchDate = batchInfo.getInDate();
				if(this.pkBizDate.getValue()==null) {
					return;
				}
				Date bizDate=((Date) this.pkBizDate.getValue());
				//����StockingComm���getBreedWeekAndDay()�����õ����䣬����
				int[] result = StockingComm.getBreedWeekAndDay(bizDate, batchDate);
				int week=result[0];
				int weekDay=result[1];

				this.txtweek.setValue(week);
				this.txtweekDay.setValue(weekDay);
				//���ô�����
				setPurDayAge();

				//���ϱ�׼
				getBreedFodderStandard(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
				//���߱�׼
				getBreedDrugStandard(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
				//��ֳ��¼
				getBreedEntry(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
			}catch(Exception err) {
				err.printStackTrace();
			}
		}
		else {

		}

		isLoadField=false;
	}

	private void getBreedEntry(String curCompanyID2, String string, int week,
			int weekDay) {
		// TODO Auto-generated method stub
		try {
			if(prmtbatch.getValue()==null){
				return;
			}

			if(this.kdtAssEntrys.getRowCount()>0) {
				this.kdtAssEntrys.removeRows();
			}
			//�õ�ҵ������
			Date bizDate = UIRuleUtil.getDateValue(pkBizDate.getValue());
			//��ҵ������ת����ʽ
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//дSQL����ȡ������
			StringBuffer sb = new StringBuffer();
			sb.append("/*dialect*/select").append("\n")
			.append("t3.FTotalQty-nvl(sum(CFDeathQty),0)-nvl(sum(CFCullQty),0)-nvl(sum(FMarkedQty),0)+nvl(sum(FAdjustQty),0) breekingStock").append("\n")
			.append("from") .append("\n")
			.append("T_FM_Batch                              t3").append("\n")
			.append("left join T_FM_StockingDaily            t4 on t3.FID=t4.FBatchID").append("\n") 

			.append("and t4.FBizDate<{d '").append(sdf.format(bizDate)).append("'} and t4.CFBaseStatus=4").append("\n")
			.append("left join T_FM_StockingDailyAssEntry   t2 on t4.FID=t2.FParentID").append("\n")
			.append("where t3.FID='").append(((IPropertyContainer)prmtbatch.getValue()).getString("id")).append("'").append("\n")
			.append("group by t3.FTotalQty");
			//ִ��SQL��䣬������������IRowset������С�
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			//������һ��
			IRow row;
			//ѭ��
			while(rs.next()){
				row=kdtAssEntrys.addRow();
				row.getCell("deathQty").setValue(0);
				row.getCell("cullQty").setValue(0);
				row.getCell("adjustQty").setValue(0);
				row.getCell("markedQty").setValue(0);

				row.getCell("breekingStock").setValue(rs.getString("breekingStock"));
			}




		}catch(Exception err) {
			err.printStackTrace();
		}

	}
    //������Ϣ
	private void getBreedDrugStandard(String curCompanyID, String string,
			int week, int weekDay) {
		// TODO Auto-generated method stub
		if(this.kdtImmuneEntrys.getRowCount()>0) {
			this.kdtImmuneEntrys.removeRows();
		}
		int dayAge=(week-1)*7+weekDay-1;
		StringBuffer sql=new StringBuffer();
		sql.append(" select tentry.FMaterialID,tentry.FUnitID,tentry.FQty")
		.append(" from T_FM_BreedStandard tmain ")
		.append(" inner join T_FM_BreedStandardDrugEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.FCompanyID='").append(curCompanyID).append("'")
		.append(" and FBreedDataID='").append(curCompanyID).append("'")
		.append(" and FBaseStatus=3")//����״̬
		.append(" and (")
		//��ʼ���վ����ڵ�ǰ
		.append(" (FWeek<=").append(week).append(" and FDays<=").append(weekDay).append(" ")
		//����ͬ�ܣ��մ��ڵ�ǰ��
		.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
		//�ܴ��ڵ�ǰ��
		.append(" or FEndWeek>").append(week).append(" ))")
		//0�� ���������ж�
		.append(" or (FWeek=0 and FDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
		.append(" )")
		.append(" order by tentry.FSeq")
		.append(" ");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			IMaterial ims;
			IMeasureUnit ius;
			IRow row;
			MaterialInfo mInfo;
			while(rs.next()){
				row = kdtImmuneEntrys.addRow();	
				row.getCell("materialName").setValue(rs.getString("FMaterialID"));
				row.getCell("materialModel").setValue(rs.getString("FModel"));
				row.getCell("unitQty").setValue(rs.getString("CFUNITQTY"));
//				materialID = rs.getString("FID");	
			}
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

     //��ι��Ϣ
	private void getBreedFodderStandard(String curCompanyID, String string,int week, int weekDay) {

		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		kdtEntrys.removeRows();

		Date bizDate = UIRuleUtil.getDateValue(pkBizDate.getValue());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sb.append("select").append("\n")
		.append(" distinct t2.FID,t2.FName_l2 materialName,t2.FModel,t2.CFUNITQTY").append("\n") 
		.append(" from ").append("\n") 
		.append("T_FM_FeedStd                  t1").append("\n") 
		.append("inner join T_FM_FeedStdEntry  t4 on t1.FID=t4.FParentID").append("\n") 
		.append("inner join T_BD_Material      t2 on t2.FID=t4.FMaterialID").append("\n") 
		.append("inner join T_ORG_Company      t3 on t3.FID=t1.CFCompanyID").append("\n") 
		.append("where t1.CFBeginDate<={d '").append(sdf.format(bizDate)).append("'} and (t1.CFEndDate is null or t1.CFEndDate>={d '").append(sdf.format(bizDate)).append("'})").append("\n") 
		.append(" and t3.FID='").append(SysContext.getSysContext().getCurrentFIUnit().getString("id")).append("'").append("\n");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			IRow row;
			String materialID;
			MaterialInfo materialInfo;
			//������ʾ������
			SelectorItemCollection slor;
			IMaterial iMaterial = MaterialFactory.getRemoteInstance();
			while(rs.next()){//��ѯ����ж�����¼��while(rs.next())����ѯ���ֻ��һ����¼��if(rs.next())
				row = kdtEntrys.addRow();
				row.getCell("materialName").setValue(rs.getString("materialName"));
				row.getCell("materialModel").setValue(rs.getString("FModel"));
				row.getCell("unitQty").setValue(rs.getString("CFUNITQTY"));
				materialID = rs.getString("FID");
				slor = new SelectorItemCollection();
				slor.add("*");
				slor.add("baseUnit.*");
				materialInfo = iMaterial.getMaterialInfo(new ObjectUuidPK(materialID), slor );
				row.getCell("material").setValue(materialInfo);
				row.getCell("unit").setValue(materialInfo.getBaseUnit());
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//���㴿����
	private void setPurDayAge() {
		Integer week = txtweek.getIntegerValue();
		Integer weekDay = this.txtweekDay.getIntegerValue();
		if(week==null){
			week=0;
		}
		if(weekDay==null) {
			weekDay=0;
		}
		int age=((week-1)*7+weekDay)-1;
		if(age<0) {
			age=0;
		}
		this.lblDayAge.setText(age+" ����");
	}
	//�������ι���
	protected void setBatchFilter() {
		// TODO Auto-generated method stub
		//ͨ����ֳ������ֳ���� ��������
		String farmerID=null,farmID=null,houseID=null;
		if(prmtfarmer.getValue()!=null) {//��ֳ��
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {//��ֳ��
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}//��ӷ������ι�������
		StockingComm.setStockingBatchFilter(prmtbatch,curCompanyID,farmerID,farmID,true,true);
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
		if(!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if(editData != null && !OprtState.VIEW.equals(getOprtState()))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if(objectValue != null)
				try
			{
					String id = idList.getID(idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
			}
			catch(Throwable E) { }
		}
		ObjectValueUtil.copy(editData);
		unLockUI();
		setFieldsNull(editData);
		editData.setBaseStatus(BillBaseStatusEnum.ADD);
		//        editData.setNumber(null);
		//        editData.setFarmer(null);
		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		//�����ټ���һ��
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		setPurDayAge();
		setMakeRelations(null);
	}

	@Override
	//��¼У��
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);

	}

	private void farm_changed(Object object) {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		isLoadField=true;
		boolean isExist=false;
		Component d = kdTabPanelMain.getComponentAt(kdTabPanelMain.getTabCount()-2);
		if(d.getName().equalsIgnoreCase("kDPanelTrans")||d.getName().equalsIgnoreCase("kDPanelEnvi")) {
			isExist=true;
		}
		if(prmtfarm.getValue()!=null) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farmer.*");//������ֹ���������ͼֻ��ʾ��ţ���˴˷���������ʾ��������Ϣ
			try {
				//����ÿ����ֳ��ֻ��һ�����Σ����Խ���һ�����εļ��ϣ��ں�һ������
				BatchCollection coll = BatchFactory.getRemoteInstance().getBatchCollection("where Farm='"+((IPropertyContainer)prmtfarm.getValue()).getString("id")+"' and AllOutDate is null and IsAllOut=0");
				//������ϲ�Ϊ�վ�ִ����������
				if(coll.size()>0){
					BOSUuid pc = coll.get(0).getId();

					BatchInfo batchInfo=BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(pc.toString()),slor);
					isLoadField=true;
					this.prmtbatch.setValue(batchInfo);
					this.prmtfarmer.setValue(batchInfo.getFarmer());
					isLoadField=false;
				}
			} catch (EASBizException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (BOSException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}


			try {
				if((Boolean) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "isHouseManager")) {
					if(!isExist){
						kdTabPanelMain.add(kDPanelEnvi,"������Ϣ", kdTabPanelMain.getTabCount()-1);

					}
				}else{
					if(isExist) {
						this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
						this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}else{
			if(isExist) {
				this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
				this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
			}
		}
		isLoadField = false;

	}

	protected void setFilter() {
		// TODO Auto-generated method stub
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}

		//��ֳ������
		setFarmerFilter(prmtfarmer, curCompanyID);
		String farmerID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		//��ֳ������
		StockingComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID,null);
		//���ι���
		setBatchFilter();

	}

	private void setFarmerFilter(final KDBizPromptBox prmtfarmer,final String companyID) {
		// TODO Auto-generated method stub
		// prmtfarmer
		StockingComm.setFarmerFilter(prmtfarmer, companyID, true);

	}
	protected void beforeStoreFields(ActionEvent e) throws Exception {
		deleteEmptyDrugEntry();
		super.beforeStoreFields(e);
		Calendar cal=Calendar.getInstance();
		cal.setTime(this.pkBizDate.getTimestamp());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",sdf.format(cal.getTime()),CompareType.GREATER_EQUALS));
		cal.add(Calendar.DATE,0);
		filter.getFilterItems().add(new FilterItemInfo("bizDate",sdf.format(cal.getTime()),CompareType.LESS));
		if(!oprtState.equals(OprtState.ADDNEW)&&this.editData.getId()!=null) {
			filter.getFilterItems().add(new FilterItemInfo("id",this.editData.getString("id"),CompareType.NOTEQUALS));
		}
		ev.setFilter(filter);
		CoreBaseCollection col = this.getBizInterface().getCollection(ev);
		if(col!=null&&col.size()>0) {
			MsgBox.showWarning("�����ν����ձ��Ѿ����ڣ������ظ����");
			SysUtil.abort();
		}
		if(kdtAssEntrys.getRowCount()>1) {
			MsgBox.showWarning("��ֳ��Ϣ��¼ֻ����һ�У�");
			SysUtil.abort();
		}
		for(int rowIndex=0;rowIndex<this.kdtAssEntrys.getRowCount();rowIndex++) {
			//������Ϊ0
			if(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "breekingStock").getValue()).signum()<=0&&UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "femaleBreedkingStock").getValue()).signum()<=0) {
				if(MsgBox.showConfirm2("��"+(rowIndex+1)+"����ֳ��Ϣ��¼������Ϊ0���Ƿ���ȫ������")==MsgBox.YES) {
					kdtAssEntrys.getCell(rowIndex, "isMarketed").setValue(true);
				}
			}
		}

		//��������
		if(this.kdtEntrys.getRowCount()<=0) {
			MsgBox.showWarning("��ι��Ϣ����Ϊ�գ�");
			SysUtil.abort();
		}else {
			if(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("dailyQtyAll").getValue()).compareTo(BigDecimal.ZERO) == 0){
				MsgBox.showWarning("��ι������Ϊ��");
				SysUtil.abort();
			}
		}
		if(kdtAssEntrys.getRowCount() == 0){
			MsgBox.showWarning("���Է�¼����Ϊ��");
			SysUtil.abort();
		}
		
		
	}
	private void deleteEmptyDrugEntry() {
		// TODO Auto-generated method stub
		int count=this.kdtImmuneEntrys.getRowCount();
		for(int rowIndex=0;rowIndex<count;) {
			//��������ʹ���������Ŷ�Ϊ��
			if(UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"vaccineGetQty").getValue())&&UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"vaccineUsedQty").getValue())&&UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"lot").getValue())) {
				this.kdtImmuneEntrys.removeRow(rowIndex);
			}else{
				rowIndex++;
			}
			count=this.kdtImmuneEntrys.getRowCount();
		}

	}
	@Override
	public void loadFields() {
		// TODO Auto-generated method stub
		isLoadField=true;
		isLoadField=true;
		super.loadFields(); 
		isLoadField=false;

		this.txtweek.setText(String.valueOf(this.editData.getWeek()));
		this.txtweekDay.setText(String.valueOf(this.editData.getWeekDay()));
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}

		setPurDayAge();
		//��һ�����������������¼�
		if(oprtState.equals(OprtState.ADDNEW)) {
			batch_changed();
			farm_changed(null);
		}

		setEntryLastStock();
		isLoadField=false;



	}
	private void setEntryLastStock() {
		// TODO Auto-generated method stub
		for(int rowIndex=0;rowIndex<this.kdtAssEntrys.getRowCount();rowIndex++) {
			try {
				kdtAssEntrys_Changed(rowIndex, kdtAssEntrys.getColumnIndex("deathQty"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	@Override
	public void storeFields() {//��ҵ�����ݼ��ص����ݶ���
		// TODO Auto-generated method stub
		super.storeFields();
		this.editData.setWeek(StringUtils.isNotEmpty(this.txtweek.getText())?Integer.valueOf(this.txtweek.getText()):0);
		this.editData.setWeekDay(StringUtils.isNotEmpty(this.txtweekDay.getText())?Integer.valueOf(this.txtweekDay.getText()):0);

	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub


		super.actionSave_actionPerformed(e);
	}


	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�ٴ���ˣ�");
			SysUtil.abort();
		}
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("������δ�ύ����ֹ��ˣ�");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		//VIEW�鿴״̬
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("��˳ɹ�");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("������δ��ˣ���ֹ����ˣ�");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("����˳ɹ�");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}


	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}}