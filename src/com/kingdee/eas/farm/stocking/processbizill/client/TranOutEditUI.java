/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;
import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.Farm;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.basedata.app.StockingBatchEditUIHandler;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.hr.train.SysCate;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
/**
 * output class name
 */
public class TranOutEditUI extends AbstractTranOutEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(TranOutEditUI.class);

	/**
	 * output class constructor
	 */
	public TranOutEditUI() throws Exception
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

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.banAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.baseStatus.setEditable(false);
		this.baseStatus.setEnabled(false);

		//this.prmtcompany.setRequired(true);
		//���������Query
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
		this.kdtEntrys.getColumn("outHouse").setEditor(kdtEntrys_material_CellEditor1);  
		this.kdtEntrys.getColumn("outHouse").setRenderer(kdtEntrys_material_OVR1);


		KDBizPromptBox kdtEntrys_material_PromptBox2 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox2.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox2.setVisible(true);
		kdtEntrys_material_PromptBox2.setEditable(true);
		kdtEntrys_material_PromptBox2.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox2.setEditFormat("$name$");
		kdtEntrys_material_PromptBox2.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor2 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox2);
		ObjectValueRender kdtEntrys_material_OVR2 = new ObjectValueRender();
		kdtEntrys_material_OVR2.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("inHouse").setEditor(kdtEntrys_material_CellEditor2);  
		this.kdtEntrys.getColumn("inHouse").setRenderer(kdtEntrys_material_OVR2);


		//��¼����ֳ����������Ӽ����¼�
		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			@Override
			public void editStarting(KDTEditEvent e) {
				farmField(e);
				inFarmField(e);

				int rowIndex = e.getRowIndex();
				String outFarmID=null,inFarmID=null,outHouseID=null,inHouseID=null;

				if(kdtEntrys.getCell(rowIndex, "outFarm").getValue()!=null) {
					outFarmID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "outFarm").getValue()).getString("id");
				}
				if(kdtEntrys.getCell(rowIndex, "inFarm").getValue()!=null) {
					inFarmID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "inFarm").getValue()).getString("id");
				}
				if(kdtEntrys.getCell(rowIndex, "outHouse").getValue()!=null) {
					outHouseID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "outHouse").getValue()).getString("id");
				}
				if(kdtEntrys.getCell(rowIndex, "inHouse").getValue()!=null) {
					inHouseID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "inHouse").getValue()).getString("id");
				}
				setBatchFilter("outBatch", outFarmID, outHouseID);
				setBatchFilter("inBbatch", inFarmID, inHouseID);
				super.editStarting(e);
			}

			@Override
			public void editStopped(KDTEditEvent e) {
				//ת����ֳ����Ӽ����¼���ѡ����ֳ���Զ���������
				if("outFarm".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
					farmField(e);
				}
				//ת����ֳ����Ӽ����¼���ѡ����ֳ���Զ���������
				if("inFarm".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
					inFarmField(e);
				}
				//ת��������Ӽ����¼�
				if("outHouse".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
//					kdtEntrys.getCell(e.getRowIndex(), "outBatch").setValue(null);
//					outHouseField(e);
				}
				//ת��������Ӽ����¼�
				if("inHouse".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
//					kdtEntrys.getCell(e.getRowIndex(), "inBbatch").setValue(null);
//					outHouseField(e);
				}

				//������Ӽ����¼����Զ��������������
				if("outBatch".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())
						|| "outHouse".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
					kdtEntrys.getCell(e.getRowIndex(), "outWeek").setValue(null);
					kdtEntrys.getCell(e.getRowIndex(), "outDay").setValue(null);
					if(pkBizDate.getValue() == null){
						MsgBox.showWarning("ת�����ڲ���Ϊ�գ�");
					}

					if(kdtEntrys.getCell(e.getRowIndex(), "outBatch").getValue() != null){
						batchField(e);
					}
				}
				//��¼�е��Ƿ�ת����������Ӽ����¼�
				if("isNewBatch".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
					isNewBatchListen(e);
				}

				super.editStopped(e);
			}


			/**
			 *��ֳ���εĹ�������
			 * @param e
			 */
			private void setBatchFilter(String columnKey, String farmID,String houseID) {
				KDBizPromptBox prmtOutBatch=(KDBizPromptBox) kdtEntrys.getColumn(columnKey).getEditor().getComponent();
				SelectorListener[] ls = prmtOutBatch.getSelectorListeners();
				for(int i=0;i<ls.length;i++) {
					prmtOutBatch.removeSelectorListener(ls[i]);
				}

				FilterInfo filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
//				filter.getFilterItems().add(new FilterItemInfo("id",StockingComm.getBatchIDByHouseID(null, null, houseID),CompareType.INCLUDE));
				EntityViewInfo ev=new EntityViewInfo();
				ev.setFilter(filter);
				prmtOutBatch.setEntityViewInfo(ev);
			}



			//ת��������Ӽ����¼�
			private void outHouseField(KDTEditEvent e) {
				try {
					//�����������
					if(kdtEntrys.getColumn(e.getColIndex()).getKey().equals("outHouse")) {
						kdtEntrys.getCell(e.getRowIndex(), "outBatch").setValue(null);
						if(kdtEntrys.getCell(e.getRowIndex(), "outHouse").getValue()!=null) {
							String houseID=((IPropertyContainer) kdtEntrys.getCell(e.getRowIndex(), "outHouse").getValue()).getString("id");
							HashSet<String> batchIDs = StockingComm.getBatchIDByHouseID(null, null, houseID);
							if(batchIDs.size()==2){
								Iterator<String> iterator = batchIDs.iterator();
								while(iterator.hasNext()){
									String batchID = iterator.next();
									if(batchID.equals("abcd1234")){
										continue;
									}
									StockingBatchInfo batch=StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchID));
									kdtEntrys.getCell(e.getRowIndex(), "outBatch").setValue(batch);
								}								
							}
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
		});

		//kdtable_detail��Ӽ����¼�
		kdtEntrys_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent e) throws Exception {
				//����һ�С��Ƿ�ת�������Ρ�Ĭ��Ϊfalse,��ʱ��������������ת�����β�����
				addlineListen(e);
			}
			public void beforeEvent(DetailPanelEvent arg0) throws Exception {
			}
		});




	}


	/**
	 * ����һ�С��Ƿ�ת�������Ρ�Ĭ��Ϊfalse,��ʱ��������������ת�����β�����
	 * @param e
	 */
	protected void addlineListen(DetailPanelEvent e) {
		// TODO Auto-generated method stub
		for(int i=0,entrySize = kdtEntrys.getRowCount();i<entrySize;i++){
			if(kdtEntrys.getCell(i, "isNewBatch").getValue().toString().equalsIgnoreCase("false")){
				kdtEntrys.getCell(i, "batchid").getStyleAttributes().setLocked(true);
				kdtEntrys.getCell(i, "inBbatch").getStyleAttributes().setLocked(false);
				kdtEntrys.getCell(i, "outFarm").getStyleAttributes().setLocked(false);
				kdtEntrys.getCell(i, "outBatch").getStyleAttributes().setLocked(false);
				kdtEntrys.getCell(i, "outHouse").getStyleAttributes().setLocked(false);
				kdtEntrys.getCell(i, "outWeek").getStyleAttributes().setLocked(false);
				kdtEntrys.getCell(i, "outDay").getStyleAttributes().setLocked(false);
				kdtEntrys.getCell(i, "outmaleQty").getStyleAttributes().setLocked(false);
				kdtEntrys.getCell(i, "outFemaleQty").getStyleAttributes().setLocked(false);
				kdtEntrys.getCell(i, "inFarm").getStyleAttributes().setLocked(false);

			}
		}
	}
	/**
	 * ��¼�е��Ƿ�ת����������Ӽ����¼�
	 * @param e
	 */
	protected void isNewBatchListen(KDTEditEvent e) {
		// TODO Auto-generated method stub
		//������Ƿ�ת�������Ρ���ѡ��״̬������ת����������
		if(kdtEntrys.getCell(e.getRowIndex(), "isNewBatch").getValue().toString().equalsIgnoreCase("true")){
			kdtEntrys.getCell(e.getRowIndex(), "inBbatch").getStyleAttributes().setLocked(true);
			kdtEntrys.getCell(e.getRowIndex(), "batchid").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outFarm").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outBatch").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outHouse").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outWeek").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outDay").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outmaleQty").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outFemaleQty").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "inFarm").getStyleAttributes().setLocked(false);
		}else{
			kdtEntrys.getCell(e.getRowIndex(), "batchid").getStyleAttributes().setLocked(true);
			kdtEntrys.getCell(e.getRowIndex(), "inBbatch").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outFarm").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outBatch").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outHouse").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outWeek").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outDay").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outmaleQty").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "outFemaleQty").getStyleAttributes().setLocked(false);
			kdtEntrys.getCell(e.getRowIndex(), "inFarm").getStyleAttributes().setLocked(false);
		}
	}


	/**
	 * ������Ӽ����¼�
	 * @param e
	 */
	protected void batchField(KDTEditEvent e) {

		String batchid = ((StockingBatchInfo)kdtEntrys.getCell(e.getRowIndex(),"outBatch").getValue()).getId().toString();
		StockingBatchInfo batchInfo = null;
		StockingBatchHouseEntryCollection houseCol = null;
		try {
			batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchid));
			houseCol = batchInfo.getHouseEntry();
		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		StockingBatchHouseEntryInfo entryInfo = null;
		//ת������
		Date outDate = (Date) pkBizDate.getValue();
		int[] weekDays = null;
		for(int i=0,entrySize=houseCol.size();i<entrySize;i++){
			entryInfo = houseCol.get(i);
			//�������εķ�¼����������ת������Ӧ����һ�£���ȥ��Ӧ������������
			if(entryInfo.getHouse().getId().equals(((FarmHouseEntryInfo)kdtEntrys.getCell(e.getRowIndex(), "outHouse").getValue()).getId())){
				Date inDate = entryInfo.getInData();
				if(inDate != null){
					try {
						weekDays = StockingComm.getBreedWeekAndDay(outDate,inDate);
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		//����������
		if(weekDays == null){
			MsgBox.showWarning("�������޷���ȡ���������κ������Ƿ��Ӧ��");
			SysUtil.abort();
		}else{
			kdtEntrys.getCell(e.getRowIndex(), "outWeek").setValue(weekDays[0]);
			kdtEntrys.getCell(e.getRowIndex(), "outDay").setValue(weekDays[1]);
		}
	

	
		
		
		
		
		
		
//		String batchid = ((StockingBatchInfo)kdtEntrys.getCell(e.getRowIndex(),"outBatch").getValue()).getId().toString();
//		this.kdtEntrys.removeRows();
//		StockingBatchInfo batchInfo = null;
//		StockingBatchHouseEntryCollection houseCol = null;
//		try {
//			batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchid));
//			houseCol = batchInfo.getHouseEntry();
//		} catch (EASBizException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (BOSException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		StockingBatchHouseEntryInfo entryInfo = null;
//		//ת������
//		Date outDate = (Date) pkBizDate.getValue();
//		int[] weekDays = null;
//		IRow row;
//		for(int i=0,entrySize=houseCol.size();i<entrySize;i++){
//			entryInfo = houseCol.get(i);
//			row = this.kdtEntrys.addRow();
//			try {
//				FarmHouseEntryInfo fhinfo =  FarmHouseEntryFactory.getRemoteInstance().getFarmHouseEntryInfo(new ObjectUuidPK(batchInfo.getHouseEntry().get(i).getHouse().getId().toString()));
//				FarmInfo farminfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(batchInfo.getFarm().getId().toString()));
//				row.getCell("outFarm").setValue(farminfo);
//				row.getCell("outHouse").setValue(fhinfo);
//				row.getCell("outBatch").setValue(batchInfo);
//				Date inDate = entryInfo.getInData();
//				weekDays = StockingComm.getBreedWeekAndDay(outDate,inDate);
//				row.getCell("outWeek").setValue(weekDays[0]);
//				row.getCell("outDay").setValue(weekDays[1]);
//			} catch (EASBizException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (BOSException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//		}

	}


	/**
	 *ת����ֳ����Ӽ����¼�
	 * @param e
	 */
	protected void farmField(KDTEditEvent e) {
		// TODO Auto-generated method stub

		String farmId = null;
		KDBizPromptBox adminF7 = (KDBizPromptBox)this.kdtEntrys.getColumn("outHouse").getEditor().getComponent();
		if(kdtEntrys.getCell(e.getRowIndex(), "outFarm").getValue() != null){
			farmId = ((FarmInfo) kdtEntrys.getCell(e.getRowIndex(), "outFarm").getValue()).getId().toString();
			//����һ���µ���ͼ����
			EntityViewInfo view = new EntityViewInfo(); 
			//���ù�������
			FilterInfo filter = new FilterInfo(); 
			//��Ӳ���
			filter.getFilterItems().add(new FilterItemInfo("parent.id", farmId,CompareType.EQUALS)); 
			view.setFilter(filter);
			adminF7.setEntityViewInfo(view);
		}
	}


	/**
	 * ת����ֳ����Ӽ����¼�
	 * @param e
	 */
	protected void inFarmField(KDTEditEvent e) {

		String farmId = null;
		KDBizPromptBox adminF7 = (KDBizPromptBox)this.kdtEntrys.getColumn("inHouse").getEditor().getComponent();
		if(kdtEntrys.getCell(e.getRowIndex(), "inFarm").getValue() != null){
			farmId = ((FarmInfo) kdtEntrys.getCell(e.getRowIndex(), "inFarm").getValue()).getId().toString();
			//����һ���µ���ͼ����
			EntityViewInfo view = new EntityViewInfo(); 
			//���ù�������
			FilterInfo filter = new FilterInfo(); 
			//��Ӳ���
			filter.getFilterItems().add(new FilterItemInfo("parent.id", farmId,CompareType.EQUALS)); 
			view.setFilter(filter);
			adminF7.setEntityViewInfo(view);
		}
	}


	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
	{
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output MenuItemPCVoucher_actionPerformed method
	 */
	protected void MenuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.MenuItemPCVoucher_actionPerformed(e);
	}

	/**
	 * output menuItemDelPCVoucher_actionPerformed method
	 */
	protected void menuItemDelPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemDelPCVoucher_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.TranOutFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		actionSave_actionPerformed(e);
		super.actionSubmit_actionPerformed(e);
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws BOSException{

		if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�ٴ���ˣ�");
			SysUtil.abort();
		}
		if (!this.editData.getBaseStatus().equals(wzBillBaseStatus.submit)) {
			MsgBox.showWarning("������δ�ύ����ֹ��ˣ�");
			SysUtil.abort();
		}

		//�����µ�����
//		produceNewBatch();

		try{
			super.actionAudit_actionPerformed(e);
		}catch(BOSException e1)
		{
			e1.printStackTrace();
			MsgBox.showWarning(e1.getMessage());
			SysUtil.abort();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}



		refreshCurPage();
	}


	/**
	 * ���������֮��
	 * ��¼�еġ��Ƿ�ת���µ����Ρ��͡����Ρ���Ϊ��
	 * �������µ���ֳ����
	 */
	private void produceNewBatch() {
		//����
		IStockingBatch iStockingBatch = null;
		try {
			iStockingBatch = StockingBatchFactory.getRemoteInstance();
		} catch (BOSException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//��ͷ
		StockingBatchInfo batchInfo = new StockingBatchInfo();
		//��¼collection
		StockingBatchHouseEntryCollection farmHouseEntryColl = new StockingBatchHouseEntryCollection();
		//��¼
		StockingBatchHouseEntryInfo farmHouseEntryInfo = null;



		String batchName = null;
		BigDecimal maleQty = BigDecimal.ZERO;
		BigDecimal femaleQty = BigDecimal.ZERO;
		for(int i=0,entrySize=kdtEntrys.getRowCount();i<entrySize;i++){
			//������Ƿ�ת�������Ρ��͡����Ρ�����Ϊ��
			if("true".equalsIgnoreCase(kdtEntrys.getCell(i, "isNewBatch").getValue().toString())
					&& kdtEntrys.getCell(i, "batchid").getValue() != null){
				//ʵ������¼�� 
				farmHouseEntryInfo = new StockingBatchHouseEntryInfo();
				//��ȡ��������
				batchName = kdtEntrys.getCell(i, "batchid").getValue().toString();
				//��ȡת�빫��������ĸ������
				maleQty = (BigDecimal) kdtEntrys.getCell(i, "outmaleQty").getValue();
				femaleQty =  (BigDecimal) kdtEntrys.getCell(i, "outFemaleQty").getValue();
				//��ȡ���ʱ��
				Date inDate = (Date) pkBizDate.getValue();



				//���ñ�ͷ��Ϣ
				//���ñ���
				batchInfo.setNumber(batchName);
				//��������
				batchInfo.setName(batchName);
				//��������״̬
				batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);

				//���÷�¼��Ϣ
				//��ȡ��������
				FarmHouseEntryInfo houseInfo =null;
				//��ֳ��
				FarmInfo farmInfo = null;
				//��ֳ��
				FarmersInfo farmersInfo = null;
				//ת������
				StockingBatchInfo stockingBatchInfo = null;
				//Ʒ����Ϣ
				BreedDataInfo breedData = null;
				//ת����ֳ����Ӧ�Ĳ�����֯
				CompanyOrgUnitInfo companyInfo = null;
				try {
					houseInfo = FarmHouseEntryFactory.getRemoteInstance().getFarmHouseEntryInfo(new ObjectUuidPK(((FarmHouseEntryInfo) kdtEntrys.getCell(i, "inHouse").getValue()).getId()));
					farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(((FarmInfo) kdtEntrys.getCell(i, "inFarm").getValue()).getId()));
					stockingBatchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((StockingBatchInfo) kdtEntrys.getCell(i, "outBatch").getValue()).getId()));
					breedData = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(stockingBatchInfo.getBreedData().getId()));
					companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(farmInfo.getCompany().getId()));

					//������ֳ��������ֳ��
					String s1 = " /*dialect*/ select t1.fid farmerid from T_FM_Farmers t1 inner join T_FM_FarmersFarmEntry t2 on t2.FParentID = t1.fid where t2.FFarmID ='"+farmInfo.getId()+"'";
					IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
					String farmid = null;
					if(r1.next()){
						farmid = r1.getString("farmerid");
						farmersInfo = FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(farmid));
					}

				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//���ù�˾
				batchInfo.setCompany(companyInfo);
				//������ֳ��
				batchInfo.setFarm(farmInfo);
				//������ֳ��
				batchInfo.setFarmer(farmersInfo);
				//����Ʒ����Ϣ
				batchInfo.setBreedData(breedData);

				//��������
				farmHouseEntryInfo.setHouse(houseInfo);

				//�������ʱ��
				farmHouseEntryInfo.setInData(inDate);

				//ת�빫������
				farmHouseEntryInfo.setQty(maleQty);
				//ת��ĸ������
				farmHouseEntryInfo.setFemaleQty(femaleQty);

				farmHouseEntryColl.add(farmHouseEntryInfo);

			}else{
				continue;
			}
		}

		batchInfo.getHouseEntry().addCollection(farmHouseEntryColl);
		try {
			iStockingBatch.save(batchInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ˢ�·���
	private void refreshCurPage() {

		if (editData.getId() != null) {
			BOSUuid pk = editData.getId();
			try {
				super.doAfterSave(new ObjectUuidPK(editData.getId()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editData.setId(pk);
		}else{
			try {
				this.loadData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub

		if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("�����Ѿ���ˣ���ֹɾ����");
			SysUtil.abort();
		}

		super.actionRemove_actionPerformed(arg0);
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {

		if (!this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("������δ��ˣ���ֹ����ˣ�");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.TranOutInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.TranOutInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBaseStatus(wzBillBaseStatus.add);
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}

}