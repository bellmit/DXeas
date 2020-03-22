/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import jxl.format.Orientation;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierCollection;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commld.fileUtils.excelUtils;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggFacadeFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillCollection;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.hatch.EggType;
import com.kingdee.eas.farm.hatch.HatchBaseDataCollection;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.HatchBillTypeEnum;
import com.kingdee.eas.farm.hatch.HatchHouseCollection;
import com.kingdee.eas.farm.hatch.HatchHouseFactory;
import com.kingdee.eas.farm.hatch.HatchHouseInfo;
import com.kingdee.eas.farm.hatch.IncubatorCollection;
import com.kingdee.eas.farm.hatch.IncubatorFactory;
import com.kingdee.eas.farm.hatch.IncubatorInfo;
import com.kingdee.eas.farm.hatch.QcEggTypeEnum;
import com.kingdee.eas.farm.hatch.hatchFacadeFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.hatch.GenderType;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.mobile.msg.util.MsgUtil;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class BEggHatchBillEditUI extends AbstractBEggHatchBillEditUI
{
	@Override
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}
	private static final Logger logger = CoreUIObject.getLogger(BEggHatchBillEditUI.class);
	private String curStorageOrgUnitID;//��ǰ�����֯
	private String curCompanyID;//��ǰ������֯
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//�����֯
	private boolean isLoadField=false;

	StorageOrgUnitInfo currStoOrg;  // ��ǰ�����֯
	HatchBaseDataInfo hatchBaseInfo;  // ��ǰ������
	BigDecimal[] coefficient=new BigDecimal[4];

	/**
	 * output class constructor
	 */
	public BEggHatchBillEditUI() throws Exception
	{
		super();
		this.setUITitle("�ֵ��Ϸ���");
		currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
		//��ȡ������������
		hatchBaseInfo = null;
		HatchBaseDataCollection coll = HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataCollection("where BillStatus in(3,4) and HatchFactory='"+currStoOrg.getString("id")+"'");
		coll.sort("number");
		if(coll.size()>1)
			hatchBaseInfo=coll.get(0);
		if(coll.size()==1)
			hatchBaseInfo=coll.get(0);
		if(coll.size()<1){
			MsgBox.showInfo("��ǰδ���κη����������ܲ����Ϸ���");
			SysUtil.abort();
		}
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		removeAllListener();
		super.loadFields();
		addListener();
		getCoefficient();
	}
	/**
	 * ɾ�������¼�
	 */
	private void removeAllListener() {
		//		KDTEditListener[] kdtListner = kdtEggEntry.getListeners(KDTEditListener.class);
		//		for(int i = 0; kdtListner.length > 0 && i<kdtListner.length; i++)
		//			kdtEggEntry.removeKDTEditListener(kdtListner[i]);
	}

	//����¼�
	private void addListener() {
		btnViewSummary.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				calSummary();
			}
		});
		final BEggHatchBillEditUI currUI = this;
		btnExcel.addMouseListener(new MouseAdapter(){

			@SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				kdtEggEntry.removeRows();
				HashMap<Object,Object> result=excelUtils.readExcelFile(1,1,1,-1,1,16,currUI);
				Iterator<Map.Entry<Object, Object>> entries = result.entrySet().iterator();
				HatchHouseCollection hatchHouseColl;
				IncubatorCollection incubatorColl;

				if(entries.hasNext()) {  
					Map.Entry<Object, Object> entry = entries.next();
					HashMap<Integer,Object> rowValue=(HashMap<Integer, Object>) entry.getValue();
					Iterator<Map.Entry<Integer, Object>> entries1 = rowValue.entrySet().iterator(); 
					while(entries1.hasNext()){
						Map.Entry<Integer, Object> entry1 = entries1.next();
						HashMap<Integer,Object> cellValue=(HashMap<Integer, Object>) entry1.getValue();
						kdtEggEntry.addRow();
						try {
							if(cellValue.get(0)!=null){//�Ϸ���
								hatchHouseColl = HatchHouseFactory.getRemoteInstance().getHatchHouseCollection("where number='"+(!cellValue.containsKey(0)?"":cellValue.get(0))+"'");
								if(hatchHouseColl.size()>0)
									kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "hatchHouse").setValue(hatchHouseColl.get(0));
							}
							if(cellValue.get(1)!=null&&kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "hatchHouse").getValue()!=null){//�Ϸ���
								incubatorColl = IncubatorFactory.getRemoteInstance().getIncubatorCollection("where number='"+(!cellValue.containsKey(1)?"":cellValue.get(1))+"'");
								if(incubatorColl.size()>0)
									kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "incubator").setValue(incubatorColl.get(0));
							}

							//����
							kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "hatchCarNum").setValue(!cellValue.containsKey(2)?null:(cellValue.get(2).toString().contains(".")?cellValue.get(2).toString().substring(0, cellValue.get(2).toString().indexOf(".")):cellValue.get(2).toString()));
							//�ֵ���Դ
							kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "eggSourceType").setValue(!cellValue.containsKey(3)?EggSourceType.SubContract:(cellValue.get(3).toString().contains("�ڲ�")?EggSourceType.InternalFarm:(
									cellValue.get(3).toString().contains("�ⲿ")?EggSourceType.Purchase:EggSourceType.SubContract)));
							//�Ƿ���
							kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "isMix").setValue(!cellValue.containsKey(4)?false:((cellValue.get(4).toString().toLowerCase().equals("��")||cellValue.get(4).toString().toLowerCase().equals("true")||cellValue.get(4).toString().toLowerCase().equals("1"))?true:false));
							//Ƭ��
							kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "outArea").setValue(!cellValue.containsKey(5)?null:(FarmersTreeFactory.getRemoteInstance().getFarmersTreeCollection("where name='"+cellValue.get(5)+"'").size()>0?FarmersTreeFactory.getRemoteInstance().getFarmersTreeCollection("where name='"+cellValue.get(5)+"'").get(0):null));
							//����
							kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "outBatch").setValue(!cellValue.containsKey(6)?null:(StockingBatchFactory.getRemoteInstance().getStockingBatchCollection("where name like '%"+cellValue.get(6)+"%'").size()>0?StockingBatchFactory.getRemoteInstance().getStockingBatchCollection("where name like '%"+cellValue.get(6)+"%'").get(0):null));
							//��Ӧ��
							kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "supplier").setValue(!cellValue.containsKey(12)?null:(SupplierFactory.getRemoteInstance().getSupplierCollection("where name ='"+cellValue.get(12)+"'").size()>0?SupplierFactory.getRemoteInstance().getSupplierCollection("where name ='"+cellValue.get(12)+"'").get(0):null));
							//�ϸ�����
							kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "qcEggType").setValue(!cellValue.containsKey(14));
							//�Ϸ�����
							kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "eggQty").setValue(!cellValue.containsKey(15)?null:(cellValue.get(15).toString().contains(".")?Integer.parseInt(cellValue.get(15).toString().substring(0, cellValue.get(15).toString().indexOf("."))):Integer.parseInt(cellValue.get(15).toString())));
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} 
			}

		});
		//ȥ���� edited by sun 6-12
		//		setCellLocked();
		kdtEggEntry.addKDTEditListener(new KDTEditAdapter(){

			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
			}

			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				if("outBatch".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())
						||"outHouse".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())
				){
					Calendar cal = Calendar.getInstance();
					cal.setTime((Date) pkBizDate.getValue());
					cal.add(Calendar.DATE, -1);
					//��������

					if("outBatch".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
						if(e.getValue()!=null){
							StockingBatchInfo batchInfo = (StockingBatchInfo) e.getValue();
							if(batchInfo.getBreedData()!=null){
								BreedDataInfo breedDataInfo;
								try {
									breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(batchInfo.getBreedData().getString("id")));

									kdtEggEntry.getCell(e.getRowIndex(), "breedDataNew").setValue(breedDataInfo);
									editData.getEggEntry().get(e.getRowIndex()).setBreedDataNew(breedDataInfo);

									if(breedDataInfo.getGenderType()!=null)
										kdtEggEntry.getCell(e.getRowIndex(), "genderType").setValue(breedDataInfo.getGenderType());
									else
										kdtEggEntry.getCell(e.getRowIndex(), "genderType").setValue(null);
								} catch (EASBizException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (BOSException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
						setAgeAndIsFormalInformation(e);
					}
				}

				if("eggDate".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
					setAgeAndIsFormalInformation(e);
				}

				//���ݺϸ������˵����Զ������Ϸ�����
				if("standEgg".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())
						|| "reFundEgg".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())
				){

					if(e.getValue() != null){
						for(int i=0,size=kdtEggEntry.getRowCount();i<size;i++){
							//�ϸ�����ʼ��
							int standardEgg = 0;
							//�˵�����ʼ��
							int returnEgg = 0;
							if(kdtEggEntry.getCell(i,"standEgg").getValue() != null){
								standardEgg = Integer.valueOf(kdtEggEntry.getCell(i,"standEgg").getValue().toString());
							}
							if(kdtEggEntry.getCell(i,"reFundEgg").getValue() != null){
								returnEgg = Integer.valueOf(kdtEggEntry.getCell(i,"reFundEgg").getValue().toString());
							}
							kdtEggEntry.getCell(i,"eggQty").setValue(Integer.valueOf(standardEgg-returnEgg));

						}
					}
				}

//				//������������и��ƹ���
//				if("outBatch".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
//					if(e.getValue()!=null){
//						StockingBatchInfo batchInfo = (StockingBatchInfo) e.getValue();
//						//�и���
//						if(e.getRowIndex() == 0){
//							for(int i=0;i<kdtEggEntry.getRowCount();i++){
//								kdtEggEntry.getCell(i, "outBatch").setValue(batchInfo);
//							}
//						}
//					}
//				}

				//��ע����и��ƹ���
				if("remark".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
					if(e.getValue()!=null){
						String batchInfo = e.getValue().toString();
						//�и���
						if(e.getRowIndex() == 0){
							for(int i=0;i<kdtEggEntry.getRowCount();i++){
								kdtEggEntry.getCell(i, "remark").setValue(batchInfo);
							}
						}
					}
				}




				//�ɱ���������и��ƹ���
//				if("CostObject".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
//					if(e.getValue()!=null){
//						CostObjectInfo batchInfo = (CostObjectInfo) e.getValue();
//						//�и���
//						if(e.getRowIndex() == 0){
//							for(int i=0;i<kdtEggEntry.getRowCount();i++){
//								kdtEggEntry.getCell(i, "CostObject").setValue(batchInfo);
//							}
//						}
//					}
//				}

				//�����и���
				if("weeklyAge".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
					if(e.getValue()!=null){
						//�и���
						if(e.getRowIndex() == 0){
							for(int i=0;i<kdtEggEntry.getRowCount();i++){
								kdtEggEntry.getCell(i, "weeklyAge").setValue(e.getValue());
							}
						}
					}
				}


				if("incubator".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
					if(e.getValue()!=null){
						IncubatorInfo info  = (IncubatorInfo) e.getValue();
						HatchHouseInfo hinfo = null;
						try {
							if(info.getHatchHouse() == null){
								hinfo = null;
							}else{
								hinfo = HatchHouseFactory.getRemoteInstance().getHatchHouseInfo(new ObjectUuidPK(info.getHatchHouse().getId().toString()));
							}
							if(hinfo!=null){
								kdtEggEntry.getCell(e.getRowIndex(), "hatchHouse").setValue(hinfo);
							}
							//�и���
							if(e.getRowIndex() == 0){
								for(int i=0;i<kdtEggEntry.getRowCount();i++){
									kdtEggEntry.getCell(i, "incubator").setValue(info);
									kdtEggEntry.getCell(i, "hatchHouse").setValue(hinfo);
								}
							}
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

				if("outArea".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
					if(e.getOldValue()==null||e.getValue()==null||!((FarmersTreeInfo)e.getOldValue()).equals((FarmersTreeInfo)e.getValue())){
						kdtEggEntry.getCell(e.getRowIndex(), "weeklyAge").setValue(null);
						kdtEggEntry.getCell(e.getRowIndex(), "dayAge").setValue(null);
						kdtEggEntry.getCell(e.getRowIndex(), "outFarm").setValue(null);
						kdtEggEntry.getCell(e.getRowIndex(), "farmer").setValue(null);
						kdtEggEntry.getCell(e.getRowIndex(), "outHouse").setValue(null);
						kdtEggEntry.getCell(e.getRowIndex(), "outBatch").setValue(null);
						kdtEggEntry.getCell(e.getRowIndex(), "outHouse").setValue(null);
						kdtEggEntry.getCell(e.getRowIndex(), "isFormal").setValue(false);
					}
					/**
					 * ����Ƭ���ֶε�ͬ�еĿհ׵�Ԫ��
					 */
					for(int i=0;i<kdtEggEntry.getRowCount();i++){
						if(e.getValue()!=null)
							if(kdtEggEntry.getCell(i, "outArea").getValue()==null)
								if(((EggSourceType)kdtEggEntry.getCell(i, "eggSourceType").getValue()).equals((EggSourceType)kdtEggEntry.getCell(e.getRowIndex(), "eggSourceType").getValue()))
									kdtEggEntry.getCell(i, "outArea").setValue(e.getValue());
					}
				}

				/**
				 * ����������������
				 */
//				if("outHouse".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
//					if(kdtEggEntry.getCell(e.getRowIndex() ,"farmer").getValue()==null&&kdtEggEntry.getCell(e.getRowIndex() ,"outFarm").getValue()==null&&e.getValue()!=null){
//						FarmHouseEntryInfo ourHouse = (FarmHouseEntryInfo)kdtEggEntry.getCell(e.getRowIndex() ,"outHouse").getValue();
//						final String sp="\n";
//						String sql="select distinct "+sp+
//						" t1.FID  breedBatch,"+sp+
//						" t4.FID  farmer,"+sp+
//						" t6.FID  outFarm,"+sp+
//						" t5.Fname_l2"+sp+
//						"from "+sp+
//						" T_FM_StockingBatch                      t1"+sp+
//						"inner join T_FM_StockingBatchHouseEntry  t2 on t1.FID=t2.FParentID"+sp+
//						"inner join CT_FM_FarmHouseEntry          t3 on t3.FID=t2.FHouseID"+sp+
//						"      and t3.FID='"+ourHouse.getId().toString()+"'"+sp+
//						"      and t2.FInData=("+sp+
//						"select "+sp+
//						" max(t2.FIndata)"+sp+
//						"from"+sp+
//						" T_FM_StockingBatch                      t1"+sp+
//						"inner join T_FM_StockingBatchHouseEntry  t2 on t1.FID=t2.FParentID"+sp+
//						"inner join CT_FM_FarmHouseEntry          t3 on t3.FID=t2.FHouseID"+sp+
//						"      and t3.FID='"+ourHouse.getId().toString()+"'"+sp+
//						""+sp+
//						")"+sp+
//						"inner join T_FM_Farmers                  t4 on t4.FID=t1.FFarmerID   "+sp+              
//						"inner join T_FM_FarmersTREE              t5 on t5.FID=t4.FTreeID"+sp+
//						"inner join T_FM_Farm                     t6 on t6.FID=t1.FFarmID"+sp;
//
//						IRowSet rs;
//						try {
//							rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
//							if(rs.next()){
//								kdtEggEntry.getCell(e.getRowIndex(), "outBatch").setValue(rs.getString("breedBatch")==null?null:(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("breedBatch")))));
//								if(rs.getString("breedBatch")!=null){
//									StockingBatchInfo batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("breedBatch")));
//									if(batchInfo.getBreedData()!=null){
//										BreedDataInfo breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(batchInfo.getBreedData().getString("id")));
//
//										kdtEggEntry.getCell(e.getRowIndex(), "breedDataNew").setValue(breedDataInfo);
//										editData.getEggEntry().get(e.getRowIndex()).setBreedDataNew(breedDataInfo);
//
//										if(breedDataInfo.getGenderType()!=null)
//											kdtEggEntry.getCell(e.getRowIndex(), "genderType").setValue(breedDataInfo.getGenderType());
//										else
//											kdtEggEntry.getCell(e.getRowIndex(), "genderType").setValue(null);
//									}
//								}
//								kdtEggEntry.getCell(e.getRowIndex(), "farmer").setValue(rs.getString("farmer")==null?null:(FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(rs.getString("farmer")))));
//								kdtEggEntry.getCell(e.getRowIndex(), "outFarm").setValue(rs.getString("outFarm")==null?null:(FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(rs.getString("outFarm")))));
//							}
//						} catch (BOSException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						} catch (EASBizException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
//					setAgeAndIsFormalInformation(e);
//				}

				try {
					kdtEggEntry_Changed(e.getRowIndex(),e.getColIndex());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			public void editValueChanged(KDTEditEvent e) {
				// TODO Auto-generated method stub
				//��ѡ��ϣ�Ƭ����¼
				if("isMix".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())){
					if(e.getValue().equals(true)){
						kdtEggEntry.getCell(e.getRowIndex(), "outArea").getStyleAttributes().setBackground(new Color(252,251,223));
						kdtEggEntry.getCell(e.getRowIndex(), "farmer").getStyleAttributes().setBackground(new Color(252,251,223));
						kdtEggEntry.getCell(e.getRowIndex(), "house").getStyleAttributes().setBackground(new Color(252,251,223));
						//						kdtEggEntry.getCell(e.getRowIndex(), "outBatch").getStyleAttributes().setBackground(new Color(252,251,223));
						kdtEggEntry.getCell(e.getRowIndex(), "outFarm").getStyleAttributes().setBackground(new Color(252,251,223));

						kdtEggEntry.getCell(e.getRowIndex(), "gendarType").getStyleAttributes().setBackground(new Color(252,251,223));
						kdtEggEntry.getCell(e.getRowIndex(), "BreedData").getStyleAttributes().setBackground(new Color(252,251,223));
					}
					else{
						kdtEggEntry.getCell(e.getRowIndex(), "outArea").getStyleAttributes().setBackground(Color.white);

						kdtEggEntry.getCell(e.getRowIndex(), "farmer").getStyleAttributes().setBackground(Color.white);
						kdtEggEntry.getCell(e.getRowIndex(), "house").getStyleAttributes().setBackground(Color.white);
						kdtEggEntry.getCell(e.getRowIndex(), "outBatch").getStyleAttributes().setBackground(Color.white);
						kdtEggEntry.getCell(e.getRowIndex(), "outFarm").getStyleAttributes().setBackground(Color.white);

						kdtEggEntry.getCell(e.getRowIndex(), "gendarType").getStyleAttributes().setBackground(new Color(252,251,223));
						kdtEggEntry.getCell(e.getRowIndex(), "BreedData").getStyleAttributes().setBackground(new Color(252,251,223));

						((KDBizPromptBox)kdtEggEntry.getCell(e.getRowIndex(), "farmer").getEditor().getComponent()).setRequired(false);
						((KDBizPromptBox)kdtEggEntry.getCell(e.getRowIndex(), "house").getEditor().getComponent()).setRequired(false);
						((KDBizPromptBox)kdtEggEntry.getCell(e.getRowIndex(), "outBatch").getEditor().getComponent()).setRequired(false);
						((KDBizPromptBox)kdtEggEntry.getCell(e.getRowIndex(), "outFarm").getEditor().getComponent()).setRequired(false);
					}
				}
			}});

		//�ϼ���
		final String[] array={"eggQty"};
		kdtEggEntry.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				final String[] array2={"eggQty","standEgg","reFundEgg"};
				apendFootRow(kdtEggEntry, array2);
			}});
		kdtAreaSummaryEntry.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				apendFootRow(kdtAreaSummaryEntry, array);
			}});
		kdtHatchBoxSummaryEntry.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				apendFootRow(kdtHatchBoxSummaryEntry, array);
			}});
	}
	/** 
	 * ���ܣ���Ӻϼ��� 
	 *  
	 * @param table 
	 *            ָ����KDTable 
	 * @param fields 
	 *            ��Ҫ�ϼƵ��� 
	 */  
	public static void apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
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
			sumValue.put(fields[i], new BigDecimal("0"));  
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
			if(row.getStyleAttributes().isHided())
				continue;
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// ���úϼ�����ʾ��ʽ  
		String colFormat = "%{0}f";  

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
	}  

	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		ICell cell = row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (obj != null) {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
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
		return com.kingdee.eas.farm.hatch.BEggHatchBillFactory.getRemoteInstance();
	}


	@Override
	protected void afterAddLine(KDTable table, IObjectValue lineData) {
		// TODO Auto-generated method stub
		super.afterAddLine(table, lineData);
	}


	@Override
	protected void afterInsertLine(KDTable table, IObjectValue lineData) {
		// TODO Auto-generated method stub
		super.afterInsertLine(table, lineData);
	}


	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{
		BEggHatchBillEggEntryInfo entryInfo = new BEggHatchBillEggEntryInfo();
		entryInfo.setParent(editData);
		if(hatchBaseInfo != null){
			entryInfo.setEggSourceType(hatchBaseInfo.getDefaultEggSourceType());
			try {
				entryInfo.setCostObject(CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK("4qoAAAAAasY5c0p3")));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			entryInfo.setEggHouse(hatchBaseInfo.getDefaultEggWarehouse());
		}

		return entryInfo;
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.BEggHatchBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggHatchBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setAdminOrg(SysContext.getSysContext().getCurrentAdminUnit());
		objectValue.setHatchFactory(hatchBaseInfo);
		objectValue.setStorageOrgUnit(currStoOrg);
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());

		//����Ĭ�Ϸ�����
		if(hatchBaseInfo!=null){
		}
		objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
		objectValue.setBizDate(new Date());
		PersonInfo currPerson = SysContext.getSysContext().getCurrentUserInfo().getPerson();
		objectValue.setOperator(currPerson);

		return objectValue;
	}

	/**
	 * ����Ĭ��ֵ
	 */
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		super.applyDefaultValue(vo);
		vo.put("baseStatus",new Integer(1));
		vo.put("eggType","Grand");
		vo.put("eggSourceType",new Integer(1));
		vo.put("creator",(com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		vo.put("adminOrg", SysContext.getSysContext().getCurrentAdminUnit());
		vo.put("hatchFactory", hatchBaseInfo);
		if(hatchBaseInfo != null){
			vo.put("eggType", hatchBaseInfo.getDefaultEggType());
			vo.put("eggSourceType", hatchBaseInfo.getDefaultEggSourceType());
		}
		vo.put("bizDate", new Date());
		PersonInfo currPerson = SysContext.getSysContext().getCurrentUserInfo().getPerson();
		vo.put("operator",currPerson);
	}



	@Override
	protected void loadLineFields(KDTable table, IRow row, IObjectValue obj) {

		super.loadLineFields(table, row, obj);
	}


	@Override
	public void onLoad() throws Exception {
		//���enter�����㷽��
		radioHorizon.setSelected(true);
		KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntry, Orientation.HORIZONTAL.getValue());


		curStorageOrgUnitID=SysContext.getSysContext().getCurrentStorageUnit().getString("id");
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);

		kdtAreaSummaryEntry.getColumn("seq").getStyleAttributes().setHided(true);
		kdtAreaSummaryEntry.getStyleAttributes().setLocked(true);
		kdtHatchBoxSummaryEntry.getStyleAttributes().setLocked(true);
		kdtEggEntry.getColumn("isFormal").getStyleAttributes().setLocked(true);

		super.onLoad();
		// У����֯ �Ƿ�ɱ༭����
		if(this.getOprtState().equals("ADDNEW") || this.getOprtState().equals("EDIT")){

			if(currStoOrg == null){
				MsgBox.showInfo("��ǰδ���κη����������ܲ����Ϸ���");
				//		        	this.getUIWindow().close();
				SysUtil.abort();
			}


		}
		// ��ʼ������ռ�
		initUIComp();

		if(this.getOprtState().equals("EDIT")){
			checkCanEdit();

		}
		// ��ʼ������ ������
		updateIncubatorFilter();
		setFarmerFilter();

		radioHorizon.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioOrigin.setSelected(false);
				radioVertical.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntry, 0);
			}
		});

		radioOrigin.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioHorizon.setSelected(false);
				radioVertical.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntry, 2);
			}
		});


		radioVertical.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioOrigin.setSelected(false);
				radioHorizon.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntry, 1);
			}
		});

		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEggEntry.getColumn("incubator").getEditor().getComponent();
		prmtPost.setQueryInfo("com.kingdee.eas.farm.hatch.app.IncubatorQuery");


	}
	/**
	 * ��ʼ��UI�������
	 */
	private void  initUIComp(){
		Integer i = 1;
		txtAddRows.setText(i.toString());
		contLastUpdateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);
		// ����ȫ��
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		UIUtil.apendFootRow(new KDTable[]{kdtEggEntry,kdtAreaSummaryEntry,kdtHatchBoxSummaryEntry});
		UIUtil.setQualityPhaseDisplayFormat(new KDTable[]{kdtEggEntry,kdtAreaSummaryEntry,kdtHatchBoxSummaryEntry});

		// ͼ������
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));

		this.btnTraceUp.setVisible(true);
		this.btnTraceDown.setVisible(true);
		// ���ò�ѯF7
		this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchBaseDataQuery");

		final String[] array={"eggQty"};
		final String[] array2={"eggQty","standEgg","reFundEgg"};
		UIUtil.apendFootRow(kdtEggEntry, array);
		UIUtil.apendFootRow(kdtAreaSummaryEntry, array);
		UIUtil.apendFootRow(kdtHatchBoxSummaryEntry, array);
		EntityViewInfo eviSto = new EntityViewInfo();
		FilterInfo fiSto = new FilterInfo();
		fiSto.getFilterItems().add(new  FilterItemInfo("hatchFactory.name",currStoOrg.getName(),CompareType.EQUALS));
		eviSto.setFilter(fiSto);
		this.prmthatchFactory.setEntityViewInfo(eviSto);
		prmthatchFactory.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				hatchFactory_changed(e);
			}});

		KDBizPromptBox kdtEntrys_material_PromptBox1 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox1.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox1.setVisible(true);
		kdtEntrys_material_PromptBox1.setEditable(true);
		kdtEntrys_material_PromptBox1.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox1.setEditFormat("$name$");
		kdtEntrys_material_PromptBox1.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor1 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox1);
		ObjectValueRender kdtEntrys_material_OVR1 = new ObjectValueRender();
		kdtEntrys_material_OVR1.setFormat(new BizDataFormat("$name$"));
		this.kdtEggEntry.getColumn("outHouse").setEditor(kdtEntrys_material_CellEditor1);  
		this.kdtEggEntry.getColumn("outHouse").setRenderer(kdtEntrys_material_OVR1);

		this.kdtEggEntry_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent e)
			throws Exception {
				e.getObjectValue().setInt("eggSourceType", EggSourceType.INTERNALFARM_VALUE);

				//				setCellLocked();
				// ����Ĭ�ϵ���
				updateEggHouse();
			}

			public void beforeEvent(DetailPanelEvent e)
			throws Exception {
				// TODO Auto-generated method stub

			}});
		this.kdtEggEntry_detailPanel.addInsertListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent e)
			throws Exception {
				e.getObjectValue().setInt("eggSourceType", EggSourceType.INTERNALFARM_VALUE);
				//				setCellLocked();
				// ����Ĭ�ϵ���
				updateEggHouse();
			}

			public void beforeEvent(DetailPanelEvent e)
			throws Exception {
				// TODO Auto-generated method stub

			}});

		KDBizPromptBox kdtEntrys_material_PromptBox2 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox2.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
		kdtEntrys_material_PromptBox2.setVisible(true);
		kdtEntrys_material_PromptBox2.setEditable(false);
		kdtEntrys_material_PromptBox2.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox2.setEditFormat("$name$");
		kdtEntrys_material_PromptBox2.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor2 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox2);
		ObjectValueRender kdtEntrys_material_OVR2 = new ObjectValueRender();
		kdtEntrys_material_OVR2.setFormat(new BizDataFormat("$name$"));
		this.kdtEggEntry.getColumn("outArea").setEditor(kdtEntrys_material_CellEditor2);  
		this.kdtEggEntry.getColumn("outArea").setRenderer(kdtEntrys_material_OVR2);

		this.prmtoutArea.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");

		btnAddRow.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				Integer in = txtAddRows.getIntegerValue();
				if(in ==0){
					in = 1;
				}
				if(editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
					MsgBox.showWarning("���״̬�½�ֹ�༭��");
					SysUtil.abort();
				}
				if(in>0){
					for(int i=0;i<in;i++){
						kdtEggEntry.addRow();
						kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "eggSourceType").setValue(EggSourceType.InternalFarm);
						kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "qcEggType").setValue(QcEggTypeEnum.qcEgg);
						kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "isMix").setValue(false);
						kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "isFormal").setValue(false);
						kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "dayAge").setValue(0);
						kdtEggEntry.getCell(kdtEggEntry.getRowCount()-1, "eggQty").setValue(0);
					}
					//					setCellLocked();

					// ����Ĭ�ϵ���
					try {
						updateEggHouse();
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
	}
	/**
	 * �������ı�
	 * @param e
	 */
	private void hatchFactory_changed(DataChangeEvent e) {
		StorageOrgUnitInfo info;
		if(e.getNewValue()!=null) {
			curCompanyID=null;
			hatchBaseInfo = (HatchBaseDataInfo) this.prmthatchFactory.getValue();
			try {
				info = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK( hatchBaseInfo.getHatchFactory().getId().toString()));
				prmtStorageOrgUnit.setValue(info);

			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else{
			//������
			try {
				curCompanyID=((IPropertyContainer) UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "hatchFactory")).getString("id");
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}
		clearEetry();
		setFarmerFilter();
		setHatchHouseFilter();
	}

	private void clearEetry() {
		// TODO Auto-generated method stub
		for(int i = 0;i<kdtEggEntry.getRowCount();i++){
			kdtEggEntry.getCell(i, "incubator").setValue(null);
			kdtEggEntry.getCell(i, "hatchHouse").setValue(null);
		}
	}


	/**
	 * ��������Ĭ�Ϲ������� 
	 */
	private void setFarmerFilter() {
		//��ֳ������
		StockingClientComm.setFarmerFilterForHatch((KDBizPromptBox) kdtEggEntry.getColumn("farmer").getEditor().getComponent(), curCompanyID,null);
	}
	/** 
	 * ����ָ���е�  ���� ��������
	 * @param rowIndex
	 */
	private void setFarmerFilter(int rowIndex) {
		String areaID="";

		IPropertyContainer proCon = (IPropertyContainer)kdtEggEntry.getRow(rowIndex).getCell("outArea").getValue();

		if(proCon!=null) {
			areaID=proCon.getString("id");
		}
		//��ֳ������
		KDBizPromptBox kdtEntrys_material_PromptBox2 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox2.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
		kdtEntrys_material_PromptBox2.setVisible(true);
		kdtEntrys_material_PromptBox2.setEditable(false);
		kdtEntrys_material_PromptBox2.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox2.setEditFormat("$name$");
		kdtEntrys_material_PromptBox2.setCommitFormat("$name$");
		StockingClientComm.setFarmerFilterForHatch(kdtEntrys_material_PromptBox2, curCompanyID,areaID);
		KDTDefaultCellEditor kdtEntrys_material_CellEditor2 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox2);
		ObjectValueRender kdtEntrys_material_OVR2 = new ObjectValueRender();
		kdtEntrys_material_OVR2.setFormat(new BizDataFormat("$name$"));
		this.kdtEggEntry.getCell(rowIndex,"farmer").setEditor(kdtEntrys_material_CellEditor2);  
		this.kdtEggEntry.getCell(rowIndex,"farmer").setRenderer(kdtEntrys_material_OVR2);

	}
	/**
	 * ��ʼ�༭
	 * @param e
	 */
	private void kdteditStarted(KDTEditEvent e) {
		int rowIndex=e.getRowIndex();
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtEggEntry.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("outFarm")||key.equals("outBatch")||key.equals("outHouse")) {
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEggEntry.getColumn("outFarm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEggEntry.getColumn("outBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;




			if(this.kdtEggEntry.getCell(rowIndex, "outBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEggEntry.getCell(rowIndex, "outBatch").getValue()).getString("id");
			}
			if(this.kdtEggEntry.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEggEntry.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEggEntry.getCell(rowIndex, "outFarm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEggEntry.getCell(rowIndex, "outFarm").getValue()).getString("id");
			}
			if(this.kdtEggEntry.getCell(rowIndex, "outHouse").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEggEntry.getCell(rowIndex, "outHouse").getValue()).getString("id");
			}
			//��������
			setOutBatchFilter(farmID, houseID);	
			//			StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID,houseID);
			//��ֳ������
			StockingClientComm.setFarmFilter(prmtFarm, null, farmerID);
			//�������
			if("outHouse".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey()))
				if(kdtEggEntry.getCell(e.getRowIndex(), "farmer").getValue()!=null||kdtEggEntry.getCell(e.getRowIndex(), "outFarm").getValue()!=null){
					//HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,false);
					EntityViewInfo ev=new EntityViewInfo();
					FilterInfo filter=new FilterInfo();
					//					filter.getFilterItems().add(new FilterItemInfo("name","%"+((IPropertyContainer) this.kdtEggEntry.getCell(rowIndex, "outFarm").getValue()).getString("name")+"%",CompareType.LIKE));
					filter.getFilterItems().add(new FilterItemInfo("parent.id","%"+((IPropertyContainer) this.kdtEggEntry.getCell(rowIndex, "outFarm").getValue()).getString("id")+"%",CompareType.LIKE));

					//��������
					SorterItemCollection sorter = new SorterItemCollection();
					SorterItemInfo item = new SorterItemInfo("number");
					item.setSortType(SortType.ASCEND);
					sorter.add(item);
					ev.setSorter(sorter);
					ev.setFilter(filter);  
					//filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
					((KDBizPromptBox)this.kdtEggEntry.getColumn("outHouse").getEditor().getComponent()).setEntityViewInfo(ev);
				}else{
					final String sp="\n";
					if(kdtEggEntry.getCell(e.getRowIndex(), "farmer").getValue()==null&&kdtEggEntry.getCell(e.getRowIndex(), "outFarm").getValue()==null){
						try {
							String outAreaID="";
							if(kdtEggEntry.getCell(e.getRowIndex(), "outArea").getValue()!=null)
								outAreaID=((FarmersTreeInfo)kdtEggEntry.getCell(e.getRowIndex(), "outArea").getValue()).getId().toString();

							HashSet<String> outHouseSet=new HashSet<String>();
							outHouseSet.add("abcd1234");
							String sql="select distinct"+sp+ 
							" t3.FID"+sp+
							"from "+sp+
							" T_FM_StockingBatch                      t1"+sp+
							"inner join T_FM_StockingBatchHouseEntry  t2 on t1.FID=t2.FParentID"+sp+
							"inner join CT_FM_FarmHouseEntry          t3 on t3.FID=t2.FHouseID"+sp+
							"inner join T_FM_Farmers                  t4 on t4.FID=t1.FFarmerID"+sp+
							"inner join T_FM_FarmersTREE              t5 on t5.FID=t4.FTreeID"+sp+
							"where t5.FID='"+outAreaID+"'";
							IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
							while(rs.next())
								outHouseSet.add(rs.getString("fid"));

							EntityViewInfo evi=new EntityViewInfo();
							FilterInfo filterInfo=new FilterInfo();
							filterInfo.getFilterItems().add(new FilterItemInfo("id",outHouseSet,CompareType.INCLUDE));
							evi.setFilter(filterInfo);
							((KDBizPromptBox)kdtEggEntry.getColumn(e.getColIndex()).getEditor().getComponent()).setEntityViewInfo(evi);
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
		}
		if(key.equals("outArea")) {	
			if(kdtEggEntry.getCell(rowIndex, "isMix").getValue().equals(true)) {
				//				kdtEggEntry.getCell(rowIndex, "outArea").getStyleAttributes().setLocked(true);
				e.setCancel(true);
			}else{
			}
		}

		if("hatchHouse".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey()))
			setHatchHouseFilter();
	}
	/**
	 * ��¼�༭�¼�
	 * �ٸ����ֵ���Դ �������� �е� �ɱ༭��
	 * �ڸ����ڲ���ֳ���Զ���õ�ǰ�������Σ������������λ�� ���� ;ͬʱ������ֳ���ι�������
	 * ���ⲿ��ֳ�� ����� Ĭ����ֳ�� �������ⲿ��ֳ�����λ�� ��ǰ���α��
	 * @param rowIndex
	 * @param colIndex
	 * @throws Exception 
	 */
	public void kdtEggEntry_Changed(int rowIndex, int colIndex) throws Exception {
		super.kdtEggEntry_Changed(rowIndex, colIndex);
		int eggSourceCol = this.kdtEggEntry.getColumnIndex("eggSourceType");
		int inFarmCol = this.kdtEggEntry.getColumnIndex("farm");
		int farmer = this.kdtEggEntry.getColumnIndex("farmer");
		int outFarmCol = this.kdtEggEntry.getColumnIndex("outFarm");
		int qtyCol = this.kdtEggEntry.getColumnIndex("eggQty");

		int outBatch = this.kdtEggEntry.getColumnIndex("outBatch");

		int outArea = this.kdtEggEntry.getColumnIndex("outArea");
		try {
			// �����ֵ���Դ���� ������¼�ɱ༭��
			if(colIndex == eggSourceCol){
				//ȥ���� edited by sun 6-12
				//				setRowEditStateByEggSource(rowIndex);
			}else if(colIndex == inFarmCol){
				setInternalFarmInfos(rowIndex);
			}else if(colIndex == farmer){

				setFarmerInfo(rowIndex);

			}else if(colIndex == qtyCol){
				updateEggAllQty();
			}else if(colIndex == outBatch){
				updateEggLogByOutBatch(rowIndex);
			}else if(colIndex == outArea){
				setFarmerFilter(rowIndex);
			}
			// ����Ĭ�ϵ���
			updateEggHouse();


		} catch (EASBizException e) {
			this.handleException(e);
			e.printStackTrace();
		}
		//���ݺ�ͬ�����δ�����ֳ����ũ��
		//		if(kdtEggEntry.getColumn(colIndex).getKey().equals("outBatch")) {
		//			if(kdtEggEntry.getCell(rowIndex, "outBatch").getValue()!=null) {
		//
		//				if(rowIndex != 0){
		//					kdtEggEntry.getCell(rowIndex, "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEggEntry.getCell(rowIndex,"outBatch").getValue(), "farmer"));
		//					kdtEggEntry.getCell(rowIndex, "outFarm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEggEntry.getCell(rowIndex,"outBatch").getValue(), "farm"));
		//					String costObjectid = ((StockingBatchInfo) kdtEggEntry.getCell(rowIndex,"outBatch").getValue()).getEggCostItem().getId().toString();
		//					CostObjectInfo costInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(costObjectid));
		//					kdtEggEntry.getCell(rowIndex, "eggLog").setValue(costInfo.getName());
		//				}else{
		//					for(int i=0;i<kdtEggEntry.getRowCount();i++){
		//						kdtEggEntry.getCell(i, "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEggEntry.getCell(rowIndex,"outBatch").getValue(), "farmer"));
		//						kdtEggEntry.getCell(i, "outFarm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEggEntry.getCell(rowIndex,"outBatch").getValue(), "farm"));
		//						String costObjectid = ((StockingBatchInfo) kdtEggEntry.getCell(i,"outBatch").getValue()).getEggCostItem().getId().toString();
		//						CostObjectInfo costInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(costObjectid));
		//						kdtEggEntry.getCell(i, "eggLog").setValue(costInfo.getName());
		//					}
		//				}
		//
		//
		//				super.kdtEggEntry_Changed(rowIndex, kdtEggEntry.getColumnIndex("farmer"));
		//			}
		//		}

		if(kdtEggEntry.getColumn(colIndex).getKey().equals("outFarm")) {
			this.kdtEggEntry.getCell(rowIndex, "outHouse").setValue(null);
		}

		//�����������
//		if(kdtEggEntry.getColumn(colIndex).getKey().equals("outHouse")) {
//			this.kdtEggEntry.getCell(rowIndex, "outBatch").setValue(null);
//			if(this.kdtEggEntry.getCell(rowIndex, "outHouse").getValue()!=null) {
//				String houseID=((IPropertyContainer) this.kdtEggEntry.getCell(rowIndex, "outHouse").getValue()).getString("id");
//				HashSet<String> batchIDs = StockingComm.getBatchIDByHouseID(null, null, houseID);
//				if(batchIDs.size()==2){
//					Iterator<String> iterator = batchIDs.iterator();
//					while(iterator.hasNext()){
//						String batchID = iterator.next();
//						if(batchID.equals("abcd1234")){
//							continue;
//						}
//						StockingBatchInfo batch=StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchID));
//						this.kdtEggEntry.getCell(rowIndex, "outBatch").setValue(batch);
//						//20190617 macheng add
//						if(batch.getBreedData() != null){
//							BreedDataInfo breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(batch.getBreedData().getId().toString()));
//							//							this.kdtEggEntry.getCell(rowIndex, "BreedData").setValue(breedDataInfo);
//							this.kdtEggEntry.getCell(rowIndex, "genderType").setValue(breedDataInfo.getGenderType());
//							this.kdtEggEntry.getCell(rowIndex, "breedDataNew").setValue(breedDataInfo);
//							this.editData.getEggEntry().get(rowIndex).setBreedDataNew(breedDataInfo);
//							//							this.editData.getEggEntry().get(rowIndex).setGenderType(breedDataInfo.getGenderType());
//						} 
//					}								
//				}
//			}
//		}

		if(kdtEggEntry.getColumn(colIndex).getKey().equals("hatchHouse")) {
			Object obj = kdtEggEntry.getCell(rowIndex, "hatchHouse").getValue();
			for(int i = 0; i < this.kdtEggEntry.getRowCount(); i++){
				if(this.kdtEggEntry.getCell(i,"hatchHouse").getValue() == null){
					this.kdtEggEntry.getCell(i,"hatchHouse").setValue(obj);
				}
			}
		}

		if(kdtEggEntry.getColumn(colIndex).getKey().equals("carQty")||kdtEggEntry.getColumn(colIndex).getKey().equals("floorQty")||kdtEggEntry.getColumn(colIndex).getKey().equals("plateQty")||kdtEggEntry.getColumn(colIndex).getKey().equals("meiQty")){
			calHatchQty(rowIndex);
		}
		if(kdtEggEntry.getColumn(colIndex).getKey().equals("eggSourceType")) {
			//ȥ���� edited by sun 6-12
			//			setCellLockedSinlgle(rowIndex);
		}

		if(kdtEggEntry.getColumn(colIndex).getKey().equals("isMix")) {
			if(kdtEggEntry.getCell(rowIndex, "isMix").getValue().equals(true)) {
				kdtEggEntry.getCell(rowIndex, "farmer").setValue(null);
				kdtEggEntry.getCell(rowIndex, "outFarm").setValue(null);
				kdtEggEntry.getCell(rowIndex, "outHouse").setValue(null);
				kdtEggEntry.getCell(rowIndex, "outBatch").setValue(null);
				kdtEggEntry.getCell(rowIndex, "weeklyAge").setValue(null);
				kdtEggEntry.getCell(rowIndex, "dayAge").setValue(0);
			}
		}


		// �����ǰ�� ���λ��� ��ֳ����������Ϊ�գ������ ��Ӧ ����

	}
	/**
	 * ��ȡ�Ϸ����Ļ���ϵ��
	 */
	private void getCoefficient() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		sb.append("select ").append("\n")
		.append(" t1.CFUnitMei,").append("\n")
		.append(" t1.CFPlate,").append("\n")
		.append(" t1.CFCarCoefficient,").append("\n")
		.append(" t1.CFFloor,").append("\n")
		.append(" t5.FID,").append("\n")
		.append(" t4.FID").append("\n")
		.append(" from").append("\n")
		.append("T_FM_HatchBillCoefficient                     t1").append("\n")
		.append("left  join T_FM_HatchBillCoefficientEntry     t2 on t1.FID=t2.FParentID").append("\n")
		.append("left  join T_ORG_Storage                      t3 on t3.FID=t2.FStorageOrgUnitID").append("\n")
		.append("left  join T_ORG_Company                      t4 on t4.FID=t1.FCompanyID").append("\n")
		.append("left  join CT_FM_HatchBaseData                t5 on t3.FID=t5.CFHatchFactoryID").append("\n")
		.append("where t1.CFBillType=0").append("\n");
		String str=sb.toString();
		sb2.setLength(0);
		sb2.append(str);
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb2.toString()).executeSQL();
			if(rs.next()){
				coefficient[0]=rs.getBigDecimal("CFCarCoefficient");
				coefficient[1]=rs.getBigDecimal("CFFloor");
				coefficient[2]=rs.getBigDecimal("CFPlate");
				coefficient[3]=rs.getBigDecimal("CFUnitMei");
			}else{
				sb2.setLength(0);
				sb2.append(str);
				sb2.append(" and t4.FID='").append(SysContext.getSysContext().getCurrentFIUnit().getString("id")).append("'");
				rs = SQLExecutorFactory.getRemoteInstance(sb2.toString()).executeSQL();
				if(rs.next()){
					coefficient[0]=rs.getBigDecimal("CFCarCoefficient");
					coefficient[1]=rs.getBigDecimal("CFFloor");
					coefficient[2]=rs.getBigDecimal("CFPlate");
					coefficient[3]=rs.getBigDecimal("CFUnitMei");
				}else{
					sb2.setLength(0);
					sb2.append(str);
					rs = SQLExecutorFactory.getRemoteInstance(sb2.toString()).executeSQL();
					if(rs.next()){
						coefficient[0]=rs.getBigDecimal("CFCarCoefficient");
						coefficient[1]=rs.getBigDecimal("CFFloor");
						coefficient[2]=rs.getBigDecimal("CFPlate");
						coefficient[3]=rs.getBigDecimal("CFUnitMei");
					}else{
						coefficient[0]=BigDecimal.ZERO;
						coefficient[1]=BigDecimal.ZERO;
						coefficient[2]=BigDecimal.ZERO;
						coefficient[3]=BigDecimal.ZERO;
					}
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �����Ϸ�����
	 * @param rowIndex
	 */
	private void calHatchQty(int rowIndex) {
		// TODO Auto-generated method stub
		kdtEggEntry.getCell(rowIndex, "eggQty").setValue(UIRuleUtil.getInt(coefficient[0])*UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex, "carQty").getValue())
				+UIRuleUtil.getIntValue(coefficient[1])*UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex, "floorQty").getValue())
				+UIRuleUtil.getIntValue(coefficient[2])*UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex, "plateQty").getValue())
				+UIRuleUtil.getIntValue(coefficient[3])*UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex, "meiQty").getValue()));
	}


	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		kdtAreaSummaryEntry_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtAreaSummaryEntry_detailPanel.getInsertLineButton().setEnabled(false);
		kdtAreaSummaryEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtHatchBoxSummaryEntry_detailPanel.getInsertLineButton().setEnabled(false);
		kdtHatchBoxSummaryEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtHatchBoxSummaryEntry_detailPanel.getAddNewLineButton().setEnabled(false);
	}


	private void setCellLocked() {
		for(int rowIndex=0;rowIndex<kdtEggEntry.getRowCount();rowIndex++) {
			setCellLockedSinlgle(rowIndex);
		}
	}


	/**
	 * ���� �ֵ�����
	 * @param rowIndex
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void updateEggLogByOutBatch(int rowIndex) throws EASBizException, BOSException{
		IRow currRow = this.kdtEggEntry.getRow(rowIndex);
		// ��ֳ����
		StockingBatchInfo batchInfo = (StockingBatchInfo) currRow.getCell("outBatch").getValue();

		// �ֵ�����
		String eggBatchNo = "";
		if(batchInfo != null){
			batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchInfo.getId().toString()));
		}
	}
	/**
	 * ����Ĭ�ϵ���
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void updateEggHouse() throws EASBizException, BOSException{
		WarehouseInfo eggHouse = hatchBaseInfo.getDefaultEggWarehouse();
		EggType selType = (EggType) eggType.getSelectedItem();
		//		if(EggType.Commercial.equals(selType)){
		//			eggHouse = hatchBaseInfo.getDefaultCDWarehouse();
		if(EggType.Parent.equals(selType)){
			eggHouse = hatchBaseInfo.getDefaultParentWarehouse();
		}else if(EggType.Grand.equals(selType)){
			eggHouse = hatchBaseInfo.getDefaultGrandWarehouse();
		}

		if(eggHouse == null ){
			eggHouse = hatchBaseInfo.getDefaultEggWarehouse();
		}

		if(eggHouse != null){
			eggHouse = WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK(eggHouse.getId()));
		}
		for(int i = 0; i < this.kdtEggEntry.getRowCount(); i++){
			if(this.kdtEggEntry.getCell(i,"eggHouse").getValue() == null){
				this.kdtEggEntry.getCell(i,"eggHouse").setValue(eggHouse);
				this.kdtEggEntry.getCell(i,"CostObject").setValue(CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK("4qoAAAAAasY5c0p3")));
			}
		}
	}
	/**
	 * �ϼƷ�¼����  ���µ���ͷ�Ϸ��ܵ���
	 * @param rowIndex
	 */
	private void updateEggAllQty(){
		int allEggQty = 0;
		for(int i = 0; i < this.kdtEggEntry.getRowCount(); i++){
			int qty = (Integer) this.kdtEggEntry.getCell(i,"eggQty").getValue();
			allEggQty = allEggQty + qty;
		}

		this.txtallHatchQty.setValue(allEggQty);
	}
	/**
	 * ���� �ⲿ��ֳ����Ϣ
	 * @param rowIndex
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void setFarmerInfo(int rowIndex) throws EASBizException, BOSException{
		IRow currRow = this.kdtEggEntry.getRow(rowIndex);
		if(currRow.getCell("farmer").getValue()!=null) {
			currRow.getCell("outFarm").setValue(StockingComm.getFarmInfoByFarmerID(null,((IPropertyContainer) currRow.getCell("farmer").getValue()).getString("id")));

			if(currRow.getCell("outBatch").getValue()!=null) {
				if(!((IObjectValue) UIRuleUtil.getProperty((IObjectValue) currRow.getCell("outBatch").getValue(), "farmer")).getString("id").equals(((IObjectValue) currRow.getCell("farmer").getValue()).getString("id"))) {
					currRow.getCell("outBatch").setValue(null);
				}
			}
		}else{
			currRow.getCell("outFarm").setValue(null);
			currRow.getCell("outHouse").setValue(null);
			currRow.getCell("outBatch").setValue(null);
		}
	}


	/**
	 * ����ѡ�е� �ڲ���ֳ����õ�ǰ�������� ��Ϣ�� ����
	 * @param rowIndex
	 * @throws BOSException 
	 */
	private void setInternalFarmInfos(int rowIndex) throws BOSException{
		IRow currRow = this.kdtEggEntry.getRow(rowIndex);
		BreedStoorgSetInfo internalFarm = (BreedStoorgSetInfo) currRow.getCell("farm").getValue();
		// TODO �������ι�������

		if(internalFarm == null){
			currRow.getCell("breedBatch").setValue(null);
			currRow.getCell("eggLog").setValue(null);
		}else{
			// ��õ�ǰ��������  
			ParentBreedBatchInfo parentBatchInfo = LayEggFacadeFactory.getRemoteInstance().getCurrentParentBatch(internalFarm.getId().toString(), this.pkBizDate.getSqlDate());
			currRow.getCell("breedBatch").setValue(parentBatchInfo);

			if(parentBatchInfo != null){
				CostObjectInfo eggCostObject = parentBatchInfo.getEggCostObject();
				String logStr = "";
				if(eggCostObject != null){
					logStr = eggCostObject.getBatchNumber();
				}
				currRow.getCell("eggLog").setValue(logStr);
			}
		}
	}
	/**
	 * ���� �ֵ���Դ ����ָ���� ����ֶε� �ɱ༭��
	 * @param rowIndex
	 */
	private void setRowEditStateByEggSource(int rowIndex){

		IRow currRow = this.kdtEggEntry.getRow(rowIndex);
		EggSourceType sourceType = (EggSourceType) currRow.getCell("eggSourceType").getValue();
		if(sourceType == null){
			currRow.getCell("farm").getStyleAttributes().setLocked(true);
			currRow.getCell("breedBatch").getStyleAttributes().setLocked(true);
			currRow.getCell("farmer").getStyleAttributes().setLocked(true);
			currRow.getCell("outFarm").getStyleAttributes().setLocked(true);
			currRow.getCell("outBatch").getStyleAttributes().setLocked(true);
			currRow.getCell("supplier").getStyleAttributes().setLocked(true);

			currRow.getCell("farm").getStyleAttributes().setHided(true);
		}
		else if(sourceType.equals(EggSourceType.SubContract)||sourceType.equals(EggSourceType.InternalFarm)){
			currRow.getCell("farm").getStyleAttributes().setLocked(true);
			currRow.getCell("breedBatch").getStyleAttributes().setLocked(false);
			currRow.getCell("farmer").getStyleAttributes().setLocked(false);
			currRow.getCell("outFarm").getStyleAttributes().setLocked(false);
			currRow.getCell("outBatch").getStyleAttributes().setLocked(false);
			currRow.getCell("supplier").getStyleAttributes().setLocked(true);

			currRow.getCell("farm").getStyleAttributes().setHided(true);
		}else if(sourceType.equals(EggSourceType.Purchase)){
			currRow.getCell("farm").getStyleAttributes().setLocked(true);
			currRow.getCell("breedBatch").getStyleAttributes().setLocked(true);
			currRow.getCell("farmer").getStyleAttributes().setLocked(true);
			currRow.getCell("outFarm").getStyleAttributes().setLocked(true);
			currRow.getCell("outBatch").getStyleAttributes().setLocked(true);
			currRow.getCell("supplier").getStyleAttributes().setLocked(false);

			currRow.getCell("farm").getStyleAttributes().setHided(true);
			currRow.getCell("breedBatch").getStyleAttributes().setHided(true);
			currRow.getCell("farmer").getStyleAttributes().setHided(true);
			currRow.getCell("outFarm").getStyleAttributes().setHided(true);	
		}
	}




	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		reloadData();
	}

	/**
	 * У����乴ѡ��  Ƭ���Ƿ���д��ֵ
	 */
	private void checkIsMix() {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtEggEntry.getRowCount();i++)
			if(kdtEggEntry.getCell(i, "isMix").getValue().equals(true))
				if(kdtEggEntry.getCell(i, "outArea").getValue()==null)
					commUtils.giveUserTipsAndRetire("����д��"+(i+1)+"��Ƭ��");
	}


	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
	{
		checkData();
		super.actionSubmit_actionPerformed(e);
		reloadData();
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("���״̬�½�ֹ�༭��");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
		kdtAreaSummaryEntry_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtAreaSummaryEntry_detailPanel.getInsertLineButton().setEnabled(false);
		kdtAreaSummaryEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtHatchBoxSummaryEntry_detailPanel.getInsertLineButton().setEnabled(false);
		kdtHatchBoxSummaryEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtHatchBoxSummaryEntry_detailPanel.getAddNewLineButton().setEnabled(false);
	}


	/**
	 * У�����ݺϷ��� 
	 * �Ϸ����� = �ϸ� +����
	 */
	private void checkData(){


	}




	/**
	 * У�鵱ǰ��֯�Ƿ��ǵ��ݴ�����֯��������ǣ���ʾ��Ϣ�жϲ���
	 */
	private void checkCanEdit(){
		StorageOrgUnitInfo cu = SysContext.getSysContext().getCurrentStorageUnit();
		CtrlUnitInfo billCU = this.editData.getCU();

		if(billCU != null){
			if(!cu.getId().toString().equals(billCU.getId().toString())){
				MsgBox.showWarning("��ǰ��֯���ǵ��ݴ�����֯�������޸ĵ���");
				SysUtil.abort();
			}
		}
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
			lockUIForViewStatus();
			setShowMessagePolicy(0);
			setIsShowTextOnly(false);
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
			this.btnEdit.setEnabled(true);
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}

	/**
	 * ��ֳ�����������仯ʱ����  �������������
	 */
	@Override
	protected void prmthatchArea_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception{
		//updateIncubatorFilter();
	}
	/**
	 * ��ֳ�����������仯ʱ����  �������������
	 */
	@Override
	protected void prmthatchFactory_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e){
		updateIncubatorFilter();
		setHatchHouseFilter();
		getCoefficient();
	}


	/**
	 * ���� �������������
	 */
	public void updateIncubatorFilter(){
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		if(hatchBaseInfo != null){
			filter.getFilterItems().add(new FilterItemInfo("hatchFactory.id",hatchBaseInfo.getId().toString(),CompareType.EQUALS));
		}
		evi.setFilter(filter);

		//��¼F7��ӹ���
		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEggEntry.getColumn("incubator").getEditor().getComponent(); //������F7  
		prmtPost.setEntityViewInfo(evi); // �����趨��ͼ  
	}
	@Override
	protected void btnAddLine_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.btnAddLine_actionPerformed(e);
	}

	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
//		for(int rowIndex=0;rowIndex<kdtEggEntry.getRowCount();rowIndex++) {
//			if(kdtEggEntry.getCell(rowIndex, "supplier").getValue()==null&&kdtEggEntry.getCell(rowIndex, "outBatch").getValue()==null&&kdtEggEntry.getCell(rowIndex, "isMix").getValue().equals(false)){
//				commUtils.giveUserTipsAndRetire("��"+(rowIndex+1)+"�� ���Ρ���Ӧ�̡��Ƿ��ϲ���ͬʱΪ��");
//			}
//		}

		//У�����κ����᲻��Ϊ��
		checkBatchAndHouse();

		super.beforeStoreFields(arg0);
		boolean bool = false;
		if(eggType.getSelectedItem()!=null){
			if(eggType.getSelectedItem().equals(EggType.Grand))
				bool=true;
		}
//		for(int rowIndex=0;rowIndex<kdtEggEntry.getRowCount();rowIndex++) {
//
//			if(bool)
//				if(kdtEggEntry.getCell(rowIndex, "isMix").getValue().equals(false)&&kdtEggEntry.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.SubContract)) {
//					//			if(!kdtEggEntry.getCell(rowIndex, "qcEggType").getValue().equals(QcEggTypeEnum.mix)&&kdtEggEntry.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.SubContract)) {
//					if(kdtEggEntry.getCell(rowIndex, "outBatch").getValue()==null) {
//						MsgBox.showWarning("��"+(rowIndex+1)+"�з�¼����ֳ���β���Ϊ�գ�");
//						SysUtil.abort();
//					}
//					if(kdtEggEntry.getCell(rowIndex, "outFarm").getValue()!=null&&(Boolean)UIRuleUtil.getProperty((IObjectValue) kdtEggEntry.getCell(rowIndex, "outFarm").getValue(), "isHouseManager")&&kdtEggEntry.getCell(rowIndex, "outHouse").getValue()==null) {
//						MsgBox.showWarning("��"+(rowIndex+1)+"�з�¼����ֳ����������������᲻��Ϊ�գ�");
//						SysUtil.abort();
//					}
//				}
//				else if(kdtEggEntry.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.Purchase)&&kdtEggEntry.getCell(rowIndex, "supplier").getValue()==null) {
//					MsgBox.showWarning("��"+(rowIndex+1)+"�з�¼����Ӧ�̲���Ϊ�գ�");
//					SysUtil.abort();
//				}
//		}
		
		
		
		calSummary();
		updateEggAllQty();
	}

	/**
	 * У���¼�����κ�����,�Ϸ���������Ϊ��
	 * 20190618 macheng add
	 * ����Ϸ� ����ֳ��Ϊά��  ��ֳ��  Ʒϵ Ʒ�� ��¼
	 * �����   �Զ���Ϊά��    ��ֳ�� ���� ���� Ʒϵ Ʒ�� ��¼
	 */
	private void checkBatchAndHouse() {
		// TODO Auto-generated method stub

		for(int i=0,size=kdtEggEntry.getRowCount();i<size;i++){
			//20190618 macheng add 

			if(UIRuleUtil.isNull(kdtEggEntry.getCell(i,"eggQty").getValue())) {
				MsgBox.showWarning("�Ϸ���ϸ��¼��"+(i+1)+"�м�¼�Ϸ���������Ϊ�գ�");
				SysUtil.abort();
			}

			//������Ϸ�
//			if(kdtEggEntry.getCell(i, "isMix").getValue().equals(false)){
//				if(kdtEggEntry.getCell(i,"outHouse").getValue() == null){
//					MsgBox.showWarning("�Ϸ���ϸ��¼��"+(i+1)+"�м�¼���᲻��Ϊ�գ�");
//					SysUtil.abort();
//				}
//
//				if(kdtEggEntry.getCell(i,"outBatch").getValue() == null){
//					MsgBox.showWarning("�Ϸ���ϸ��¼��"+(i+1)+"�м�¼���β���Ϊ�գ�");
//					SysUtil.abort();
//				}
//			}

		}
	}                                                                           
	/**
	 * ���÷�¼�Ϸ����Ĺ�����������ͷ��  �������� ���˸������µ� �Ϸ���
	 */
	private void setHatchHouseFilter() {
		// TODO Auto-generated method stub
		String hatchArea="";
		String hatchFactoryname="";
		if(prmthatchFactory.getValue()!=null){
			hatchFactoryname=((HatchBaseDataInfo)prmthatchFactory.getValue()).getId().toString();
			//��¼F7��ӹ���
			//���ݷ��������ӷ���������
			KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEggEntry.getColumn("hatchHouse").getEditor().getComponent(); //  
			KDBizPromptBox incubator = (KDBizPromptBox) kdtEggEntry.getColumn("incubator").getEditor().getComponent(); //������F7  
			EntityViewInfo view1 = new EntityViewInfo(); // �¶�����ͼ  
			FilterInfo filter1 = new FilterInfo(); // ���ù�������  
			filter1.getFilterItems().add(new FilterItemInfo("hatchFactory.id", hatchFactoryname,CompareType.EQUALS)); //   
			view1.setFilter(filter1); // ���ù�������  
			prmtPost.setEntityViewInfo(view1); // �����趨��ͼ  
			incubator.setEntityViewInfo(view1); 

		}

		//StockingClientComm.setHatchHouseFilter(((KDBizPromptBox)kdtEggEntry.getColumn("hatchHouse").getEditor().getComponent()), hatchArea);
	}
	/**
	 * ���ݷ�¼�Ϸ��������ݹ��˷����������
	 * @param e 
	 */
	private void setIncubatorFilter(KDTEditEvent e) {
		// TODO Auto-generated method stub
		String hatchHouseNum="";
		if(kdtEggEntry.getCell(e.getRowIndex(), "hatchHouse").getValue()!=null)
			hatchHouseNum=((HatchHouseInfo)kdtEggEntry.getCell(e.getRowIndex(), "hatchHouse").getValue()).getNumber();
	}
	/**
	 *��ֳ���εĹ�������
	 * @param e
	 */
	private void setOutBatchFilter(String farmID,String houseID) {
		// TODO Auto-generated method stub
		//		String outArea="";
		//		if(kdtEggEntry.getCell(e.getRowIndex(), "outArea").getValue()!=null)
		//			outArea=((FarmersTreeInfo)kdtEggEntry.getCell(e.getRowIndex(), "outArea").getValue()).getId().toString();
		//		StockingClientComm.setOutBatchFilter(((KDBizPromptBox)kdtEggEntry.getColumn("outBatch").getEditor().getComponent()), outArea);
		KDBizPromptBox prmtOutBatch=(KDBizPromptBox) kdtEggEntry.getColumn("outBatch").getEditor().getComponent();
		SelectorListener[] ls = prmtOutBatch.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtOutBatch.removeSelectorListener(ls[i]);
		}

		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
//		filter.getFilterItems().add(new FilterItemInfo("id",StockingComm.getBatchIDByHouseID(null, null, houseID),CompareType.INCLUDE));
		EntityViewInfo ev=new EntityViewInfo();
		ev.setFilter(filter);
		prmtOutBatch.setEntityViewInfo(ev);
	}
	//��ȡ������
	private void setAgeAndIsFormalInformation(KDTEditEvent e) {
		// TODO Auto-generated method stub

		int rowIndex = e.getRowIndex();
		if(kdtEggEntry.getCell(rowIndex,"outBatch").getValue()!=null 
				&& kdtEggEntry.getCell(e.getRowIndex(),"eggDate").getValue() != null){
			Calendar cal = Calendar.getInstance();
			//�������������������ںͲ������ڼ���������
			cal.setTime((Date)kdtEggEntry.getCell(e.getRowIndex(),"eggDate").getValue());
			try {
				StockingBatchCollection coll = StockingBatchFactory.getRemoteInstance().getStockingBatchCollection("where id='"+((StockingBatchInfo)kdtEggEntry.getCell(e.getRowIndex(),"outBatch").getValue()).getId().toString()+"'");
				if(coll.size()>0){
					if(kdtEggEntry.getCell(rowIndex, "outHouse").getValue()!=null){
						StockingBatchInfo breedBatchInfo = coll.get(0);
						FarmHouseEntryInfo farmHouseEntryInfo = (FarmHouseEntryInfo)kdtEggEntry.getCell(rowIndex, "outHouse").getValue();
						StockingBatchHouseEntryCollection collEntry = StockingBatchHouseEntryFactory.getRemoteInstance().getStockingBatchHouseEntryCollection("where parent='"+breedBatchInfo.getId().toString()+"' and house='"+farmHouseEntryInfo.getId().toString()+"'");
						if(collEntry.size()>0){
							Date inDate = (collEntry.get(0)).getInData();
							if(inDate!=null){
								int[] weekDays = StockingComm.getBreedWeekAndDay(cal.getTime(),inDate);
								kdtEggEntry.getCell(rowIndex, "weeklyAge").setValue(weekDays[0]);
								kdtEggEntry.getCell(rowIndex, "dayAge").setValue(weekDays[1]);
								if((collEntry.get(0)).getFormalDate()==null||cal.getTime().before((collEntry.get(0)).getFormalDate()))
									kdtEggEntry.getCell(rowIndex, "isFormal").setValue(false);
								else
									kdtEggEntry.getCell(rowIndex, "isFormal").setValue(true);
							}else{
								kdtEggEntry.getCell(rowIndex, "dayAge").setValue(0);
								kdtEggEntry.getCell(rowIndex, "weeklyAge").setValue(null);
								kdtEggEntry.getCell(rowIndex, "isFormal").setValue(false);
							}
						}
					}else{
						Date inDate = (coll.get(0)).getInDate();
						if(inDate!=null){
							int[] weekDays = StockingComm.getBreedWeekAndDay(cal.getTime(),inDate);
							kdtEggEntry.getCell(rowIndex, "weeklyAge").setValue(weekDays[0]);
//							kdtEggEntry.getCell(rowIndex, "weeklyAge").setValue(null);
							kdtEggEntry.getCell(rowIndex, "dayAge").setValue(weekDays[1]);
						}else{
							kdtEggEntry.getCell(rowIndex, "dayAge").setValue(0);
							kdtEggEntry.getCell(rowIndex, "weeklyAge").setValue(null);
							kdtEggEntry.getCell(rowIndex, "isFormal").setValue(false);
						}
					}
				}
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCreateTo_actionPerformed(e);

		//����������յ����ݣ���д�ֶ�
		if(editData.getId()==null)
			return;

		String sql="select * from T_BOT_Relation where FSrcObjectID='"+editData.getId().toString()+"' and FDestEntityID='D54999A2' order by FDate desc";
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(rs.size()>0){
			if(rs.next()){
				BEggCandlingBillCollection collBEggCanding = BEggCandlingBillFactory.getRemoteInstance().getBEggCandlingBillCollection("where id='"+rs.getString("FDestObjectID")+"'");
				if(collBEggCanding.size()>0){
					String str = "update CT_FM_BEggHatchBill set FIsHasBEggCanding=1";
					if(collBEggCanding.get(0).getBizDate()!=null)
						str+=",FBEggCandingDate={ts '"+sdf.format(collBEggCanding.get(0).getBizDate())+"'}";
					str+=" where  fid ='"+editData.getString("id")+"'";
					hatchFacadeFactory.getRemoteInstance().excuteSql(str);
				}
			}
		}
		refreshCurPage();
	}


	/**
	 * �������ҳǩ������
	 */
	private void calSummary() {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> outArea=new TreeMap<String, Integer>();
		TreeMap<String, Integer> supplier=new TreeMap<String, Integer>();
		TreeMap<String, Integer> gender=new TreeMap<String, Integer>();

		//Ƭ������
		String outArea_genderType_eggType="";
		for(int i=0;i<kdtEggEntry.getRowCount();i++){
			outArea_genderType_eggType="";
			//Ƭ������
			if(kdtEggEntry.getCell(i, "outArea").getValue()!=null){
				outArea_genderType_eggType+=((FarmersTreeInfo)kdtEggEntry.getCell(i, "outArea").getValue()).getLongNumber();
				if(kdtEggEntry.getCell(i, "genderType").getValue()!=null){
					outArea_genderType_eggType+="_"+((GenderType)kdtEggEntry.getCell(i, "genderType").getValue()).getValue();
				}else
					outArea_genderType_eggType+="_";
				if(kdtEggEntry.getCell(i, "qcEggType").getValue()!=null){
					outArea_genderType_eggType+="_"+((QcEggTypeEnum)kdtEggEntry.getCell(i, "qcEggType").getValue()).getValue();
				}else
					outArea_genderType_eggType+="_";
				if(outArea.containsKey(outArea_genderType_eggType)){
					outArea.put(outArea_genderType_eggType,outArea.get(outArea_genderType_eggType)+((Integer)kdtEggEntry.getCell(i, "eggQty").getValue()));
				}else{
					outArea.put(outArea_genderType_eggType,((Integer)kdtEggEntry.getCell(i, "eggQty").getValue()));
				}//��Ӧ�̻���
			}else if(kdtEggEntry.getCell(i, "supplier").getValue()!=null){

				outArea_genderType_eggType+=((SupplierInfo)kdtEggEntry.getCell(i, "supplier").getValue()).getId().toString();
				if(kdtEggEntry.getCell(i, "genderType").getValue()!=null){
					outArea_genderType_eggType+="_"+((GenderType)kdtEggEntry.getCell(i, "genderType").getValue()).getValue();
				}else
					outArea_genderType_eggType+="_";
				if(kdtEggEntry.getCell(i, "qcEggType").getValue()!=null){
					outArea_genderType_eggType+="_"+((QcEggTypeEnum)kdtEggEntry.getCell(i, "qcEggType").getValue()).getValue();
				}else
					outArea_genderType_eggType+="_";
				if(supplier.containsKey(outArea_genderType_eggType)){
					supplier.put(outArea_genderType_eggType,supplier.get(outArea_genderType_eggType)+((Integer)kdtEggEntry.getCell(i, "eggQty").getValue()));
				}else{
					supplier.put(outArea_genderType_eggType,((Integer)kdtEggEntry.getCell(i, "eggQty").getValue()));
				}//����

			}else{
				if(kdtEggEntry.getCell(i, "genderType").getValue()!=null){
					outArea_genderType_eggType+=((GenderType)kdtEggEntry.getCell(i, "genderType").getValue()).getValue();
				}else
					outArea_genderType_eggType+="_";
				if(kdtEggEntry.getCell(i, "qcEggType").getValue()!=null){
					outArea_genderType_eggType+="_"+((QcEggTypeEnum)kdtEggEntry.getCell(i, "qcEggType").getValue()).getValue();
				}else
					outArea_genderType_eggType+="_";
				if(gender.containsKey(outArea_genderType_eggType)){
					gender.put(outArea_genderType_eggType,gender.get(outArea_genderType_eggType)+((Integer)kdtEggEntry.getCell(i, "eggQty").getValue()));
				}else{
					gender.put(outArea_genderType_eggType,((Integer)(kdtEggEntry.getCell(i, "eggQty").getValue())));
				}
			}
		}
		FarmersTreeCollection collFarmersTree;
		kdtAreaSummaryEntry.removeRows();
		String[] outAreaSum;

		//Ƭ���ϼ�
		Iterator<Map.Entry<String, Integer>> entriesOut = outArea.entrySet().iterator();  
		while (entriesOut.hasNext()) { 
			Entry<String, Integer> entry = entriesOut.next();
			outArea_genderType_eggType=entry.getKey();
			kdtAreaSummaryEntry.addRow();
			outAreaSum=outArea_genderType_eggType.split("_");
			try {
				collFarmersTree = FarmersTreeFactory.getRemoteInstance().getFarmersTreeCollection("where LongNumber='"+outAreaSum[0]+"'");
				if(collFarmersTree.size()>0){
					kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "outArea").setValue(collFarmersTree.get(0));
					if(!com.kingdee.util.StringUtils.isEmpty(outAreaSum[1])){
						kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "genderType").setValue(GenderType.getEnum(outAreaSum[1]));
					}
					if(!com.kingdee.util.StringUtils.isEmpty(outAreaSum[2])){
						kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "qcEggType").setValue(QcEggTypeEnum.getEnum(Integer.parseInt(outAreaSum[2])));
					}
					kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "eggQty").setValue(entry.getValue());
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��Ӧ��
		SupplierCollection collSupplierTree;
		Iterator<Map.Entry<String, Integer>> entriesSupplier =supplier.entrySet().iterator();  
		while (entriesSupplier.hasNext()) { 
			Entry<String, Integer> entry = entriesSupplier.next();
			outArea_genderType_eggType=entry.getKey();
			kdtAreaSummaryEntry.addRow();
			outAreaSum=outArea_genderType_eggType.split("_");
			try {
				collSupplierTree = SupplierFactory.getRemoteInstance().getSupplierCollection("where id='"+outAreaSum[0]+"'");
				if(collSupplierTree.size()>0){
					kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "supplier").setValue(collSupplierTree.get(0));
					if(!com.kingdee.util.StringUtils.isEmpty(outAreaSum[1])){
						kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "genderType").setValue(GenderType.getEnum(outAreaSum[1]));
					}
					if(!com.kingdee.util.StringUtils.isEmpty(outAreaSum[2])){
						kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "qcEggType").setValue(QcEggTypeEnum.getEnum(Integer.parseInt(outAreaSum[2])));
					}
					kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "eggQty").setValue(entry.getValue());
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		//����
		//gender.entrySet()��ŵ���  Map�еļ�ֵ��ӳ���ϵ��
		//Iterator<Map.Entry<String, Integer>>��ʾ����  Map�е�ӳ���ϵ
		Iterator<Map.Entry<String, Integer>> entriesOther =gender.entrySet().iterator();  
		while (entriesOther.hasNext()) { 
			Entry<String, Integer> entry = entriesOther.next();
			outArea_genderType_eggType=entry.getKey();
			kdtAreaSummaryEntry.addRow();
			outAreaSum=outArea_genderType_eggType.split("_");
			if(!com.kingdee.util.StringUtils.isEmpty(outAreaSum[0])){
				kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "genderType").setValue(GenderType.getEnum(outAreaSum[0]));
			}
			if(outAreaSum.length > 1){
				if(!com.kingdee.util.StringUtils.isEmpty(outAreaSum[1])){
					kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "qcEggType").setValue(QcEggTypeEnum.getEnum(Integer.parseInt(outAreaSum[1])));
				}
			}

			kdtAreaSummaryEntry.getCell(kdtAreaSummaryEntry.getRowCount()-1, "eggQty").setValue(entry.getValue());
		}




		TreeMap<String, Integer> hatchBox=new TreeMap<String, Integer>();


		//������
		String incubatorNum = "";
		for(int i=0;i<kdtEggEntry.getRowCount();i++){
			if(kdtEggEntry.getCell(i, "incubator").getValue()!=null){
				incubatorNum=((IncubatorInfo) kdtEggEntry.getCell(i, "incubator").getValue()).getNumber();
				if(hatchBox.containsKey(incubatorNum)){
					hatchBox.put(incubatorNum, hatchBox.get(incubatorNum)+((Integer)kdtEggEntry.getCell(i, "eggQty").getValue()));
				}
				else
					hatchBox.put(incubatorNum,((Integer)kdtEggEntry.getCell(i, "eggQty").getValue()) );
			}
		}


		kdtHatchBoxSummaryEntry.removeRows();
		IncubatorCollection coll=null;
		IncubatorInfo incubatorInfo=null;
		HatchHouseInfo hatchHouseInfo=null;
		Iterator<Map.Entry<String, Integer>> entries = hatchBox.entrySet().iterator();  
		while (entries.hasNext()) {  
			try {
				Map.Entry<String, Integer> entry = entries.next();
				kdtHatchBoxSummaryEntry.addRow();
				coll = IncubatorFactory.getRemoteInstance().getIncubatorCollection("where number='"+entry.getKey()+"'");
				if(coll.size()>0){
					incubatorInfo = coll.get(0);
					if(incubatorInfo.getHatchHouse()!=null)
						hatchHouseInfo=HatchHouseFactory.getRemoteInstance().getHatchHouseInfo(new ObjectUuidPK(incubatorInfo.getHatchHouse().getId().toString()));
					kdtHatchBoxSummaryEntry.getCell(kdtHatchBoxSummaryEntry.getRowCount()-1, "incubator").setValue(incubatorInfo);
					kdtHatchBoxSummaryEntry.getCell(kdtHatchBoxSummaryEntry.getRowCount()-1, "hatchHouse").setValue(hatchHouseInfo);
					if(entry.getValue()>incubatorInfo.getMaxQty())
						commUtils.giveUserTipsAndRetire(incubatorInfo.getName()+"�ķ�����������������");
					kdtHatchBoxSummaryEntry.getCell(kdtHatchBoxSummaryEntry.getRowCount()-1, "eggQty").setValue(entry.getValue());
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
	}


	/**
	 * output actionSubmit_actionPerformed
	 * ˢ�²���
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	}  

	private void setCellLockedSinlgle(int rowIndex) {
		if(rowIndex<0) {
			return;
		}
		if(kdtEggEntry.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.InternalFarm)) {
			kdtEggEntry.getCell(rowIndex,"supplier").setValue(null);
			kdtEggEntry.getCell(rowIndex,"material").setValue(null);
			//			kdtEggEntry.getCell(rowIndex,"eggLog").setValue(null);

			kdtEggEntry.getCell(rowIndex,"isMix").getStyleAttributes().setLocked(false);
			kdtEggEntry.getCell(rowIndex,"outArea").getStyleAttributes().setLocked(false);
			kdtEggEntry.getCell(rowIndex,"farmer").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"outHouse").getStyleAttributes().setLocked(false);
			kdtEggEntry.getCell(rowIndex,"outBatch").getStyleAttributes().setLocked(false);
			kdtEggEntry.getCell(rowIndex,"outFarm").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"supplier").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"material").getStyleAttributes().setLocked(true);
			//			kdtEggEntry.getCell(rowIndex,"eggLog").getStyleAttributes().setLocked(true);
		} if(kdtEggEntry.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.Purchase)||kdtEggEntry.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.SubContract)) {
			kdtEggEntry.getCell(rowIndex,"isMix").setValue(false);
			kdtEggEntry.getCell(rowIndex,"outArea").setValue(null);
			kdtEggEntry.getCell(rowIndex,"farmer").setValue(null);
			kdtEggEntry.getCell(rowIndex,"outFarm").setValue(null);
			kdtEggEntry.getCell(rowIndex,"outHouse").setValue(null);
			kdtEggEntry.getCell(rowIndex,"outBatch").setValue(null);
			kdtEggEntry.getCell(rowIndex,"weeklyAge").setValue(null);
			kdtEggEntry.getCell(rowIndex,"dayAge").setValue(null);
			kdtEggEntry.getCell(rowIndex,"isMix").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"outArea").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"farmer").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"outHouse").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"outBatch").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"outFarm").getStyleAttributes().setLocked(true);
			kdtEggEntry.getCell(rowIndex,"supplier").getStyleAttributes().setLocked(false);
			kdtEggEntry.getCell(rowIndex,"material").getStyleAttributes().setLocked(false);
			//			kdtEggEntry.getCell(rowIndex,"eggLog").getStyleAttributes().setLocked(false);
		}
	}


	@Override
	public void actionAdjust_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(UIRuleUtil.isNull(editData.getString("id"))||!editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
			commUtils.giveUserTipsAndRetire("������δ��������");
		HashMap<Object, Object> hashMap=new HashMap<Object, Object>();
		hashMap.put("srcBillType",HatchBillTypeEnum.hatchBill);
		hashMap.put("srcBill", editData);
		ClientUtils.openChildUIFromParentUI(UIFactoryName.NEWWIN, "com.kingdee.eas.farm.hatch.client.HatchAdjustBillEditUI", hashMap, null, OprtState.ADDNEW);
		super.actionAdjust_actionPerformed(e);
	}

}