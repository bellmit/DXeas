package com.kingdee.eas.custom.dep.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ObjectNotFoundException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.CostItemInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.IWarehouse;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
//import com.kingdee.eas.custom.jack.JackFacadeFactory;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.mm.basedata.BomEntryCollection;
import com.kingdee.eas.mm.basedata.BomEntryFactory;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.basedata.IBom;
import com.kingdee.eas.mm.basedata.IBomEntry;
//import com.kingdee.eas.scm.im.inv.CheckInforM;
import com.kingdee.eas.scm.im.inv.IMaterialReqBill;
import com.kingdee.eas.scm.im.inv.MaterialReqBillEntryInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillFactory;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
//import com.kingdee.eas.scm.im.inv.PiggyAgeInfo;
//import com.kingdee.eas.scm.im.inv.PiggyFeedingStandardEntryCollection;
//import com.kingdee.eas.scm.im.inv.PiggyFeedingStandardEntryFactory;
//import com.kingdee.eas.scm.im.inv.PiggyFeedingStandardEntryInfo;
//import com.kingdee.eas.scm.im.inv.PiggyFeedingStandardFactory;
//import com.kingdee.eas.scm.im.inv.PiggyFeedingStandardInfo;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
//import com.kingdee.eas.scm.im.inv.client.MaterialReqBillEditUIPIEx;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * ���ϳ��ⵥ�༭������չ
 * @author Administrator
 *
 */
public class MaterialReqClientDep {

//	
//	// �༭����
//	protected MaterialReqBillEditUIPIEx ui;
//	// ���� ����
//	protected MaterialReqBillInfo editData;
//	/**
//	 * onload�� ���ý��� �ռ� ���ݣ���Ӽ���
//	 * @param param
//	 */
//	public void afterOnload(final UIParam param){
//		
//		ui = (MaterialReqBillEditUIPIEx) param.getUI();
//		editData = (MaterialReqBillInfo) ui.getEditData();
//		
//		ui.isFirstCal = true;
//		//���ü������ϰ�ť�ɼ���
//		//this.kDWorkButton1.setVisible(this.btnSave.isVisible());
//		//this.prmtBom.addSelectorListener(new SelectorHandler());
//		param.getKDBizPromptBox("prmtBom").setQueryInfo("com.kingdee.eas.mm.basedata.app.F7BomQuery");
//		param.getKDBizPromptBox("prmtBom").setVisible(true);
//		param.getKDBizPromptBox("prmtBom").setEditable(true);
//		param.getKDBizPromptBox("prmtBom").setDisplayFormat("$name$");
//		param.getKDBizPromptBox("prmtBom").setEditFormat("$number$");
//		param.getKDBizPromptBox("prmtBom").setCommitFormat("$number$");
//		FilterInfo filter = new FilterInfo();
////		filter.getFilterItems().add(
////				new FilterItemInfo("STORAGEORGUNIT.ID", SysContext.getSysContext()
////						.getCurrentCtrlUnit().getId().toString()));
//		filter.getFilterItems().add(new FilterItemInfo("STORAGEORGUNIT.ID", SysContext.getSysContext().getCurrentStorageUnit()!=null?SysContext.getSysContext().getCurrentStorageUnit().getId().toString():null));
//		 filter.getFilterItems().add(new FilterItemInfo("baseStatus", "4"));
//		 filter.setMaskString("#0 AND #1");
//		
//		EntityViewInfo evi = new EntityViewInfo();
//		evi.getSorter().add(new SorterItemInfo("number"));
//		evi.setFilter(filter);
//		param.getKDBizPromptBox("prmtBom").setEntityViewInfo(evi);
//		param.getKDTable("kdtEntry").getColumn(18).getStyleAttributes().setNumberFormat(
//				"%r{#,##0.0000}f");
//		
//		param.getKDFormattedTextField("txtquantity").setValue(new Integer("1000"));
//		//String number = this.txtNumber.getText();
//		//if (number.length() == 0) {
//			//param.getKDFormattedTextField("txtquantity").setValue(new Integer("1000"));
//			//this.txtBIMUDF0009.setValue(new Integer("1000"));
//			//this.param.getKDBizPromptBox("prmtBom").setValue("");
//		//}
//		
////		param.getKDButton("btnModifyWarehouse").addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////				modifyWarehouse(param);//�����޸Ĳֿ�
////			}
////			
////		});
////		// ���������������  Ͷ���������¼
////		param.getKDButton("btnGetPiggyEntrys").addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////				try{
////					actionPiggyAgeComfirm_actionPerformed(e);
////				}catch(Exception ex){
////					MsgBox.showInfo(ex.getMessage());
////				}
////			}
////			
////		});
//		
//		// ��Ӱ�ť �����¼�
//		// �����޸Ĳֿ�
//		param.getKDButton("btnModifyWarehouse").addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				modifyWarehouse(param);
//			}
//		});
//
//		// ���������������  Ͷ���������¼pluginCtx.getKDButton("btnGetPiggyEntrys");
//		param.getKDButton("btnGetPiggyEntrys").addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				try {
//					piggyAgeComfirm(param);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//
//		// ����bom�� �����������Ϸ�¼
//		param.getKDButton("btnCallMatQqt").addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				try {
//					actionCalMatQqt(param);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
////		// ����bom�� �����������Ϸ�¼    ������  ��ť
////		param.getKDButton("btnCalMatQqt1").addActionListener(new ActionListener(){
////			public void actionPerformed(ActionEvent e) {
////				try {
////					actionCalMatQqt(param);
////				} catch (Exception e1) {
////					e1.printStackTrace();
////				}
////			}
////		});
//		//KDTable���ӱ��༭�¼�����
//		param.getKDTable("kdtEntry").addKDTEditListener(new KDTEditAdapter(){
//
//			@Override
//			public void editStopped(KDTEditEvent e) {
//				try {
//					tableValueChanged(param,e);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				};
//			}});
//	}
//	
//	/**
//	 * ����bom�� ���������������Ϸ�¼
//	 * @param param
//	 * @throws Exception
//	 */
//	public void actionCalMatQqt(UIParam param) throws Exception {
//		
//		ui = (MaterialReqBillEditUIPIEx) param.getUI();
//		editData = (MaterialReqBillInfo) ui.getEditData();
//		
//		KDTable kdtEntry =  param.getKDTable("kdtEntry");
//		param.getKDFormattedTextField("txtquantity").commitEdit();
//		
//		// select bom
//		if (param.getKDBizPromptBox("prmtBom").getValue() == null
//				|| param.getKDBizPromptBox("prmtBom").getValue().toString().length() == 0) {
//			MsgBox.showWarning("��ѡ��BOM��");
//			return;
//		}
//		
//		// select * from bom
//		/*String bimstr = param.getKDBizPromptBox("prmtBom").getValue().toString();
//		int begin = 5;
//		int end = bimstr.indexOf("=]");
//		String bomid = bimstr.substring(begin, end + 1);*/
//		String bomid=((IObjectValue) param.getKDBizPromptBox("prmtBom").getValue()).getString("id");
//
//		FilterInfo filter = new FilterInfo();
//		filter.getFilterItems().add(new FilterItemInfo("parent", bomid));
//		EntityViewInfo evi = new EntityViewInfo();
//		evi.getSorter().add(new SorterItemInfo("material.number"));
//		evi.setFilter(filter);
//
//		IBomEntry ibom = BomEntryFactory.getRemoteInstance();
//		BomEntryCollection entryArray = ibom.getBomEntryCollection(evi);
//		int entrySize = entryArray.size();
//
//		IBom ib = BomFactory.getRemoteInstance();
//		BomInfo bomInfo = ib.getBomInfo(new ObjectUuidPK(bomid));
//		BigDecimal productQty = bomInfo.getProductQty();// 090118 edit by yuyong
//		CompanyOrgUnitInfo fiOrgUnit = SysContext.getSysContext().getCurrentFIUnit();
//		CostObjectInfo costobjectInfo = InvClientUtils.getDefaultCostObject(fiOrgUnit,(MaterialInfo)bomInfo.getMaterial(),"");
//		
//		MaterialReqBillInfo materialReqBillInfo = new MaterialReqBillInfo();
//		materialReqBillInfo.setBizDate(new Date());
//		IMaterialReqBill imaterialReqBill = MaterialReqBillFactory.getRemoteInstance();
//
//		// not fisrtCal
//		if (!ui.isFirstCal) {
//			String number = param.getKDTextField("txtNumber").getText();
//			if (number != null && number.length() > 0) {
//				try{
//					MaterialReqBillInfo materialReqBillInfo2 = imaterialReqBill.getMaterialReqBillInfo(" where number ='" + number+ "'");
//					for (int i = 0; i < materialReqBillInfo.getEntry().size(); i++) {
//						MaterialReqBillEntryInfo deentry = materialReqBillInfo.getEntry().get(i);
//						materialReqBillInfo.getEntry().remove(deentry);
//					}
//					imaterialReqBill.delete(new ObjectUuidPK(materialReqBillInfo2.getId()));
//				}catch(ObjectNotFoundException e){
//					e.printStackTrace();
//				}
//			}
//			
//		}
//
////		IRow row;
//		ICell cell;
//		BigDecimal per = new BigDecimal(param.getKDFormattedTextField("txtquantity").getValue().toString());
//		kdtEntry.removeRows();
//		int materialcol = kdtEntry.getColumnIndex("materialID");
//		int qtycol = kdtEntry.getColumnIndex("qty");
//		int warehousecol = kdtEntry.getColumnIndex("warehouse");
//		int unitcol = kdtEntry.getColumnIndex("UnitID");
//		int baseUnit= kdtEntry.getColumnIndex("baseUnit"); //����������λ
//		int baseQty = kdtEntry.getColumnIndex("baseQty"); //������λ���� 
//		IMaterial ims = MaterialFactory.getRemoteInstance();
//		IMeasureUnit iMeasureUnit = MeasureUnitFactory.getRemoteInstance();
//		IWarehouse iWarehouse = WarehouseFactory.getRemoteInstance();
//		KDTEditEvent KDE;
//		for (int i = 0; i < entrySize; i++) {
//			// get material
//			MaterialInfo material = ims.getMaterialInfo(new ObjectUuidPK(entryArray.get(i).getMaterial().getId()));
//			BigDecimal perQty = entryArray.get(i).getConsumeFixQty();// perQty
//			if (material != null) {
//				// materialReqBillEntryInfo.setMaterial(material);
//				IRow row = kdtEntry.addRow(i);
//				
//				
//				row.getCell("ID").setValue(BOSUuid.create("11774BB4"));
//				row.getCell("productName").setValue(material);
//				
//				if(material.getBaseUnit().getId()!=null){
////					MeasureUnitInfo measureUnitInfo = iMeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(material.getBaseUnit().getId()));
//					row.getCell("baseUnit").setValue(material.getBaseUnit());//������λ
//				}
//				
//                if(costobjectInfo != null)
//                {
//                	row.getCell("costObject").setValue(costobjectInfo);
//                    row.getCell("costObjectName").setValue(costobjectInfo.getName());                    
//                }
//                
//                row.getCell("costCenterOrgUnit").setValue(param.getKDBizPromptBox("prmtCostCenterUnit").getValue());
//                
//				row.getCell("materialID").setValue(material);//��Ʒ����
//				row.getCell("materialName").setValue(material.getName());
//				row.getCell("lot").getStyleAttributes().setLocked(true);
//				row.getCell("assistantAttr").getStyleAttributes().setLocked(true);
//				ui.afterInsertMaterialInfo(i);
//				KDE=new KDTEditEvent(kdtEntry, null, material, i, materialcol, false, 1);
//				ui.tableValueChanged(KDE);
//				this.tableValueChanged(param,KDE);
//				
//				CostItemInfo costItemInfo = InvClientUtils.getDefaultCostItem(fiOrgUnit, material);
//                if(costItemInfo != null)
//                {
//                    row.getCell("costItem").setValue(costItemInfo);
//                    row.getCell("costItemName").setValue(costItemInfo.getName());                	
//                }
//				MeasureUnitInfo measureUnitInfo = iMeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(entryArray.get(i).getBaseUnit().getId()));
//				row.getCell("UnitID").setValue(measureUnitInfo);//������λ
//				
//				KDE=new KDTEditEvent(kdtEntry, null, measureUnitInfo, i, unitcol, false, 1);
//				ui.tableValueChanged(KDE);
//				this.tableValueChanged(param,KDE);
//				row.getCell("baseUnit").setValue(material.getBaseUnit());//������λ
//				ui.afterUnitChanged(i,measureUnitInfo);
//
//				row.getCell("baseQty").setValue(perQty.multiply(per).divide(productQty,4,BigDecimal.ROUND_HALF_UP));//����
//				row.getCell("qty").setValue(perQty.multiply(per).divide(productQty,4,BigDecimal.ROUND_HALF_UP));//����
//				row.getCell("pfQty").setValue(perQty.multiply(per).divide(productQty,4,BigDecimal.ROUND_HALF_UP));//����
//				//row.getCell("pfQty").setValue(perQty.multiply(per).divide(productQty));//�䷽����
//				ui.afterQtyChanged(i);
//				KDE=new KDTEditEvent(kdtEntry, null, perQty.multiply(per).divide(productQty,4,BigDecimal.ROUND_HALF_UP), i,qtycol, false, 1);
//				ui.tableValueChanged(KDE);
//				this.tableValueChanged(param,KDE);
//				
//
//				if(entryArray.get(i).getDefaultWarehouse()!=null){
//					WarehouseInfo warehouseInfo = iWarehouse.getWarehouseInfo(new ObjectUuidPK(entryArray.get(i).getDefaultWarehouse().getId()));
//					row.getCell("warehouse").setValue(warehouseInfo);//�ֿ�
//				}
//				//this.tableValueChanged(e);
//				
////			
//				row.getCell("isPresent").setValue(false);
//				row.getCell("invUpdateType").setValue(ui.getDefaultInvUpdateTypeInfo(i));
//				
//			}
//		}
////		 imaterialReqBill.save(editData);
//		ui.isFirstCal = false;
//		ui.storeFields();
////		ui.setDataObject(editData);
////		ui.loadFields();
//	}
//	
//	/**
//	 * �������òֿ� ��Ϊ��һ�з�¼�Ĳֿ� 
//	 * @param param
//	 */
//	public void modifyWarehouse(UIParam param) {//�����޸Ĳֿ�
//		ui = (MaterialReqBillEditUIPIEx) param.getUI();
//		editData = (MaterialReqBillInfo) ui.getEditData();
//		
//		WarehouseInfo info=(WarehouseInfo) param.getKDTable("kdtEntry").getRow(0).getCell("warehouse").getValue();
//		if(info==null) {
//			MsgBox.showWarning("��¼��һ�вֿⲻ��Ϊ�� ��");
//			SysUtil.abort();
//		}
//		for(int i = 1;i<param.getKDTable("kdtEntry").getRowCount();i++) {
//			param.getKDTable("kdtEntry").getRow(i).getCell("warehouse").setValue(info);
//		}
//		MsgBox.showInfo( "�޸����");
//	}
//	
//	/**
//	 * ���� �� ����Ĭ��ֵ
//	 * @param param
//	 * @throws Exception
//	 */
//	public void afterActionAddNew(UIParam param) throws Exception {
//		ui = (MaterialReqBillEditUIPIEx) param.getUI();
//		editData = (MaterialReqBillInfo) ui.getEditData();
//		
//		
//		param.getKDFormattedTextField("txtquantity").setValue(new Integer("1000"));
//		param.getKDBizPromptBox("prmtBom").setValue(null);
//	}
//
//	/**
//	 * ��¼ ֵ�仯 �¼�
//	 * @param param
//	 * @param selectRow
//	 * @param selectCol
//	 * @throws Exception
//	 */
//	 public void tableValueChanged(UIParam param,KDTEditEvent e)throws Exception
//	  {
//		 ui = (MaterialReqBillEditUIPIEx) param.getUI();
//		 editData = (MaterialReqBillInfo) ui.getEditData();
//		 
//		 int selectRow = e.getRowIndex();
//		 int selectCol = e.getColIndex();	
//			
//		 IRow curRow = param.getKDTable("kdtEntry").getRow(selectRow);
//		
//		 KDTable kDTable = param.getKDTable("kdtEntry");
//		 String colName = kDTable.getColumnKey(selectCol);
//		 
//		 ICell currCell = kDTable.getCell(selectRow, selectCol);
//		 
//		 if (("lot".equals(colName)) && (currCell.getValue()!= null)) {
//			   MaterialInfo info=(MaterialInfo)param.getKDTable("kdtEntry").getRow(selectRow).getCell("materialID").getValue();
//			   if(info!=null){
//				   setKDTable(param,param.getKDTable("kdtEntry"),selectRow,"materialID");
//			   }
//		 }
//		 if (("materialID".equals(colName)&& (currCell.getValue() != null))) {
//			   if(param.getKDTable("kdtEntry").getRow(selectRow).getCell("lot").getValue()!=null){
//				   setKDTable(param,param.getKDTable("kdtEntry"),selectRow,"materialID");
//			   }
//		 }
//	  }
//	 public void setKDTable(UIParam param,KDTable kdtable,int selectRow,String mcolName) throws EASBizException, BOSException, SQLException{
//		   String lot=(String)kdtable.getRow(selectRow).getCell("lot").getValue();
//		   MaterialInfo info=(MaterialInfo)kdtable.getRow(selectRow).getCell(mcolName).getValue();
//		   String materialId=info.getId().toString();
//		   
//	       StringBuffer sql=new StringBuffer();
//	       sql.append(" select t1.fsupplierid, t2.CFmanufactureDate,t2.CFexpirationDate,t2.CFcheckInforM  ");
//	       sql.append(" from t_im_PurInWarehsbill t1 ");
//	       sql.append(" inner join t_im_PurInWarehsentry t2 on t2.fparentid=t1.fid ");
//	       sql.append(" where t2.FMATERIALID='"+materialId+"'");
//	       sql.append(" and t2.FLot='"+lot+"' ");
//	       IRowSet rs=JackFacadeFactory.getRemoteInstance().GetSqlData(sql.toString());
//	       if(rs.next()){
//	    	   kdtable.getRow(selectRow).getCell("manufactureDate").setValue(rs.getDate("CFmanufactureDate"));
//	    	   kdtable.getRow(selectRow).getCell("expirationDate").setValue(rs.getDate("CFexpirationDate"));
//	    	   if(rs.getString("CFcheckInforM")!=null){
//	    		   String checkinfor=rs.getString("CFcheckInforM");
//	    		   
//	    		   CheckInforM checkInfo = CheckInforM.getEnum(checkinfor);
//	    		   if(checkinfor.equals("0")){
//	    			   kdtable.getRow(selectRow).getCell("checkInforM").setValue("���ϸ�");
//	    		   }else if(checkinfor.equals("1")){
//	    			   kdtable.getRow(selectRow).getCell("checkInforM").setValue("�ϸ�");
//	    		   }else if(checkinfor.equals("2")){
//	    			   kdtable.getRow(selectRow).getCell("checkInforM").setValue("����");
//	    		   }
//	    	   }else{
//	    		   kdtable.getRow(selectRow).getCell("checkInforM").setValue("����");
//	    	   }
//	    	   
//	    	   if(rs.getString("fsupplierid")!=null){
//	    		   String supplierId=rs.getString("fsupplierid");
//	    		   if(!supplierId.equals("")){
//	    			   ObjectUuidPK pk=new ObjectUuidPK(supplierId);
//	    			   SupplierInfo supinfo=SupplierFactory.getRemoteInstance().getSupplierInfo(pk);
//	    			   kdtable.getRow(selectRow).getCell("supplier").setValue(supinfo);
//	    		   }
//	    	   }
//	       }else{
//	    	   //param.getKDTable("kdtEntry").getRow(selectRow).getCell("manufactureDate").setValue(new Date());
//	    	   //param.getKDTable("kdtEntry").getRow(selectRow).getCell("expirationDate").setValue(new Date()); 
//	    	   //param.getKDTable("kdtEntry").getRow(selectRow).getCell("checkInforM").setValue("����");
//	       }
//	 }
//	
//	/**
//	 * ����ѡ�е���������� ���� ���ɷ�¼ 
//	 * @param e
//	 * @throws Exception
//	 */
//	public void piggyAgeComfirm(UIParam param) throws Exception {
//		ui = (MaterialReqBillEditUIPIEx) param.getUI();
//		editData = (MaterialReqBillInfo) ui.getEditData();
//		
//		if(ui.STATUS_EDIT.equals(ui.getOprtState()) || ui.STATUS_ADDNEW.equals(ui.getOprtState())){
//			// ȷ����������
//			if (param.getKDBizPromptBox("prmtpiggyAge").getValue() == null) {
//				MsgBox.showWarning("��ѡ����������");
//				return;
//			}
//			// ����ͷ��
//			if(param.getKDFormattedTextField("txtpiggyQty").getBigDecimalValue() == null){
//				MsgBox.showWarning("����������ͷ��");
//				return;
//			}
//			// ��¼�к�������ʱ  ȷ�Ϻ����²���
//			if(param.getKDTable("kdtEntry").getRowCount() >0 &&  MsgBox.showConfirm2("��¼�а������ݣ������������ȡͶ������ɾ�����з�¼���»�ȡ���Ƿ�ȷ�ϣ�") == MsgBox.NO){
//				return;
//			}
//			// ��������
//			PiggyAgeInfo piggyAgeInfo = (PiggyAgeInfo)param.getKDBizPromptBox("prmtpiggyAge").getValue();
//			if(piggyAgeInfo != null){
//				PiggyFeedingStandardInfo standardInfo = this.getPiggyAgeFeelings(param,piggyAgeInfo);
//				if(standardInfo != null){
//					PiggyFeedingStandardEntryCollection entryColl = standardInfo.getEntrys();
//					if(entryColl != null && entryColl.size() > 0){
//						
//
//						IRow row;
//						ICell cell;
////						BigDecimal per = new BigDecimal(param.getKDFormattedTextField("txtquantity").getValue().toString());
//						param.getKDTable("kdtEntry").removeRows();
//						int materialcol = param.getKDTable("kdtEntry").getColumnIndex("materialID");
//						int qtycol = param.getKDTable("kdtEntry").getColumnIndex("qty");
//						int warehousecol = param.getKDTable("kdtEntry").getColumnIndex("warehouse");
//						int unitcol = param.getKDTable("kdtEntry").getColumnIndex("UnitID");
//						int baseUnit= param.getKDTable("kdtEntry").getColumnIndex("baseUnit"); //����������λ
//						int baseQty = param.getKDTable("kdtEntry").getColumnIndex("baseQty"); //������λ���� 
//						for (int i = 0; i < entryColl.size(); i++) {
//							// �ӱ�׼��¼�л�ȡ��������
//							PiggyFeedingStandardEntryInfo entryInfo = entryColl.get(i);
//							entryInfo = PiggyFeedingStandardEntryFactory.getRemoteInstance().getPiggyFeedingStandardEntryInfo(new ObjectUuidPK(entryInfo.getId()));
//							MaterialInfo materialInfo = entryInfo.getMaterial();
//							BigDecimal qty = entryInfo.getQtyPer();
//							if(materialInfo == null){
//								continue;
//							}
//							MaterialInfo material = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(
//									materialInfo.getId()));
//							BigDecimal perQty = qty;// perQty
//							// ͷ��
//							BigDecimal tQty = param.getKDFormattedTextField("txtpiggyQty").getBigDecimalValue();
//							IMeasureUnit iMeasureUnit = MeasureUnitFactory.getRemoteInstance();
//							if (material != null) {
//								// materialReqBillEntryInfo.setMaterial(material);
//								row = param.getKDTable("kdtEntry").addRow(i);
//								
//								param.getKDTable("kdtEntry").getRow(i).getCell("productName").setValue(material);
//								
//								if(material.getBaseUnit().getId()!=null){
//									MeasureUnitInfo measureUnitInfo = iMeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(material.getBaseUnit().getId()));
//									param.getKDTable("kdtEntry").getRow(i).getCell("baseUnit").setValue(material.getBaseUnit());//������λ
//								}
//								CostObjectInfo costobjectInfo = InvClientUtils.getDefaultCostObject(SysContext.getSysContext().getCurrentFIUnit(),materialInfo,"");
//								
//				                if(costobjectInfo != null)
//				                {
//				                    param.getKDTable("kdtEntry").getRow(i).getCell("costObject").setValue(costobjectInfo);
//				                    param.getKDTable("kdtEntry").getRow(i).getCell("costObjectName").setValue(costobjectInfo.getName());                    
//				                }
//								
//								param.getKDTable("kdtEntry").getRow(i).getCell("materialID").setValue(material);//��Ʒ����
//								param.getKDTable("kdtEntry").getRow(i).getCell("materialAlias").setValue(material.getAlias());  // ����
//								param.getKDTable("kdtEntry").getRow(i).getCell("materialName").setValue(material.getName());
//								param.getKDTable("kdtEntry").getRow(i).getCell("lot").getStyleAttributes().setLocked(true);
//								param.getKDTable("kdtEntry").getRow(i).getCell("assistantAttr").getStyleAttributes().setLocked(true);
//								ui.afterInsertMaterialInfo(i);
//								KDTEditEvent KDE=new KDTEditEvent(param.getKDTable("kdtEntry"), null, material, i, materialcol, false, 1);
//								ui.tableValueChanged(KDE);
//								this.tableValueChanged(param,KDE);
//								
//								CostItemInfo costItemInfo = InvClientUtils.getDefaultCostItem(SysContext.getSysContext().getCurrentFIUnit(), material);
//				                if(costItemInfo != null)
//				                {
//				                    param.getKDTable("kdtEntry").getRow(i).getCell("costItem").setValue(costItemInfo);
//				                    param.getKDTable("kdtEntry").getRow(i).getCell("costItemName").setValue(costItemInfo.getName());                	
//				                }
//								MeasureUnitInfo measureUnitInfo = iMeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(material.getBaseUnit().getId()));
//								param.getKDTable("kdtEntry").getRow(i).getCell("UnitID").setValue(measureUnitInfo);//������λ
//								
//								KDE=new KDTEditEvent(param.getKDTable("kdtEntry"), null, measureUnitInfo, i, unitcol, false, 1);
//								ui.tableValueChanged(KDE);
//								
//								param.getKDTable("kdtEntry").getRow(i).getCell("baseUnit").setValue(material.getBaseUnit());//������λ
//								ui.afterUnitChanged(i,measureUnitInfo);
//								
//								param.getKDTable("kdtEntry").getRow(i).getCell("qty").setValue(perQty.multiply(tQty));//����
//								param.getKDTable("kdtEntry").getRow(i).getCell("pfQty").setValue(perQty.multiply(tQty));//����
//								//param.getKDTable("kdtEntry").getRow(i).getCell("pfQty").setValue(perQty.multiply(per).divide(productQty));//�䷽����
//								ui.afterQtyChanged(i);
//								KDE=new KDTEditEvent(param.getKDTable("kdtEntry"), null, perQty.multiply(tQty), i,qtycol, false, 1);
//								ui.tableValueChanged(KDE);
//								tableValueChanged(param,KDE);
//								
//								IWarehouse iWarehouse = WarehouseFactory.getRemoteInstance();
////								if(entryArray.get(i).getDefaultWarehouse()!=null){
////									WarehouseInfo warehouseInfo = iWarehouse.getWarehouseInfo(new ObjectUuidPK(entryArray.get(i).getDefaultWarehouse().getId()));
////									param.getKDTable("kdtEntry").getRow(i).getCell("warehouse").setValue(warehouseInfo);//�ֿ�
////								}
//								//this.tableValueChanged(e);	
//							}
//						}
//						
//						
//					}else{
//						MsgBox.showWarning("������Ͷ�ϱ�׼û�з�¼");
//						return;
//					}
//				}else{
//					MsgBox.showWarning("������û������Ͷ�ϱ�׼");
//					return;
//				}
//				
//				
//				
//			}
//			
//		}else{
//			MsgBox.showInfo("�Ǳ༭״̬���ܸ���");
//			return;
//		}
//		
//		
//	}
//	
//	/**
//	 * ���������ȡָ����Ͷ�ϱ�׼��¼
//	 * @param piggyAgeInfo
//	 * @return
//	 * @throws BOSException 
//	 * @throws EASBizException 
//	 * @throws SQLException 
//	 */
//	private PiggyFeedingStandardInfo getPiggyAgeFeelings(UIParam param,PiggyAgeInfo piggyAgeInfo) throws EASBizException, BOSException, SQLException{
//		if(piggyAgeInfo != null){
//			StringBuilder sb = new StringBuilder();
//			sb.append("select t.fid from CT_IV_PiggyFeedingStandard t where t.CFPiggyAgeID = '");
//			sb.append(piggyAgeInfo.getId().toString());
//			sb.append("'");
//			IRowSet rs = JackFacadeFactory.getRemoteInstance().GetSqlData(sb.toString());
//			if(rs.next()){
//				String fid = rs.getString("fid");
//				
//				return PiggyFeedingStandardFactory.getRemoteInstance().getPiggyFeedingStandardInfo(new ObjectUuidPK(fid)); 
//			}
//		}
//		
//		return null;
//	}

}
