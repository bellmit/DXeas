/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import jxl.format.Orientation;

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
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.farm.hatch.BEggTrayingBillEggEntryCollection;
import com.kingdee.eas.farm.hatch.BEggTrayingBillEggEntryFactory;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.HatchHouseFactory;
import com.kingdee.eas.farm.hatch.HatchHouseInfo;
import com.kingdee.eas.farm.hatch.HatchingBoxInfo;
import com.kingdee.eas.farm.hatch.IncubatorInfo;
import com.kingdee.eas.farm.hatch.QcEggTypeEnum;
import com.kingdee.eas.farm.hatch.hatchFacadeFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo;
import com.kingdee.eas.farm.stocking.basedata.IQcEggTypeEntry;
import com.kingdee.eas.farm.stocking.basedata.QcEggTypeEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.QcEggTypeEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.QcEggTypeInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.hatch.GenderType;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class BHatchBabyBillEditUI extends AbstractBHatchBabyBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BHatchBabyBillEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private boolean isLoadField=false;
	private int times=0;

	StorageOrgUnitInfo currStoOrg;  // 当前库存组织
	HatchBaseDataInfo hatchBaseInfo;  // 当前孵化场
	/**
	 * output class constructor
	 */
	public BHatchBabyBillEditUI() throws Exception
	{
		super();
		currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
		hatchBaseInfo = hatchFacadeFactory.getRemoteInstance().getHatchBaseData(currStoOrg);
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{

		super.loadFields();
		//		setCellLocked();
		addFootRow();
		CBoxAddItem();

		//添加片区
		cboxFarmersTree.removeAllItems();
		ArrayList<Object> list=new ArrayList<Object>();
		//添加合格蛋类型
		cboxQcEggType.removeAllItems();
		ArrayList<QcEggTypeEnum> listQc=new ArrayList<QcEggTypeEnum>();
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getCell(i, "outAreaPP").getValue()!=null&&!list.contains((FarmersTreeInfo)kdtEntrys.getCell(i, "outAreaPP").getValue())){
				list.add((FarmersTreeInfo)kdtEntrys.getCell(i, "outAreaPP").getValue());
			}else{
				if(kdtEntrys.getCell(i, "supplier").getValue()!=null&&!list.contains((SupplierInfo)kdtEntrys.getCell(i, "supplier").getValue())){
					list.add((SupplierInfo)kdtEntrys.getCell(i, "supplier").getValue());
				}
			}
			if(kdtEntrys.getCell(i, "qcEggType").getValue()!=null&&!listQc.contains((QcEggTypeEnum)kdtEntrys.getCell(i, "qcEggType").getValue())){
				listQc.add((QcEggTypeEnum)kdtEntrys.getCell(i, "qcEggType").getValue());
			}
		}
		cboxFarmersTree.addItem("");
		cboxFarmersTree.addItems(list.toArray());


		cboxQcEggType.addItem("");
		cboxQcEggType.addItems(listQc.toArray());


		cboxFarmersTree.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				kdtEntrySetRowVisible();
				apendFootRow(kdtEntrys, new String []{"hatchQty","maoEggQty"});
			}

		});

		cboxQcEggType.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				kdtEntrySetRowVisible();
				apendFootRow(kdtEntrys, new String []{"hatchQty","maoEggQty"});
			}});
		ArrayList<String> sourceEntry=new ArrayList<String>();
		for(int i=0;i<kdtSourceEntrys.getColumnCount();i++)
			if(kdtSourceEntrys.getColumn(i).getKey().toLowerCase().indexOf("qty")>=0)
				sourceEntry.add(kdtSourceEntrys.getColumnKey(i));
		final String[] col=sourceEntry.toArray(new String[sourceEntry.size()]);

		cBoxFarmersTree.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {
				cBoxFarmersTree.removeAllItems();
				//添加片区
				ArrayList<Object> list=new ArrayList<Object>();
				for(int i=0;i<kdtSourceEntrys.getRowCount();i++){
					if(kdtSourceEntrys.getCell(i, "outAreaP").getValue()!=null){
						if(!list.contains((FarmersTreeInfo)kdtSourceEntrys.getCell(i, "outAreaP").getValue()))
							list.add((FarmersTreeInfo)kdtSourceEntrys.getCell(i, "outAreaP").getValue());
					}else{
						if(kdtSourceEntrys.getCell(i, "supplier").getValue()!=null&&!list.contains((SupplierInfo)kdtSourceEntrys.getCell(i, "supplier").getValue())){
							list.add((SupplierInfo)kdtSourceEntrys.getCell(i, "supplier").getValue());
						}
					}
				}
				cBoxFarmersTree.addItem("");
				cBoxFarmersTree.addItems(list.toArray());
				super.mouseClicked(e);
			}

		});
		cBoxQcEggType.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {

				//添加合格蛋类型
				cBoxQcEggType.removeAllItems();
				ArrayList<QcEggTypeInfo> listQc=new ArrayList<QcEggTypeInfo>();
				for(int i=0;i<kdtSourceEntrys.getRowCount();i++){
					if(kdtSourceEntrys.getCell(i, "qcEggsType").getValue()!=null&&!listQc.contains((QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue())){
						listQc.add((QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue());
					}
				}
				cBoxQcEggType.addItem("");
				cBoxQcEggType.addItems(listQc.toArray());
				super.mouseClicked(e);
			}

		});

		cBoxFarmersTree.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					kdtSourceEntrySetRowVisible();
					apendFootRow(kdtSourceEntrys, col);
				}
			}

		});

		cBoxQcEggType.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				kdtSourceEntrySetRowVisible();
				apendFootRow(kdtSourceEntrys, col);
			}});
	}

	/**
	 * 根据过滤条件 设置出雏箱页签行的可见性
	 */
	private void kdtEntrySetRowVisible() {
		// TODO Auto-generated method stub
		FarmersTreeInfo farmersTreeInfo = null;
		SupplierInfo supplierInfo=null;
		QcEggTypeEnum qcEggType;
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			kdtEntrys.getRow(i).getStyleAttributes().setHided(false);

			//片区
			if(cboxFarmersTree.getSelectedItem()!=null&&!cboxFarmersTree.getSelectedItem().equals("")){
				if(cboxFarmersTree.getSelectedItem() instanceof FarmersTreeInfo){
					farmersTreeInfo=(FarmersTreeInfo)cboxFarmersTree.getSelectedItem();
					if(kdtEntrys.getCell(i, "outAreaPP").getValue()!=null)
						if(!((FarmersTreeInfo)kdtEntrys.getCell(i, "outAreaPP").getValue()).equals(farmersTreeInfo))
							kdtEntrys.getRow(i).getStyleAttributes().setHided(true);
						else{}
					else
						kdtEntrys.getRow(i).getStyleAttributes().setHided(true);

				}else{
					supplierInfo=(SupplierInfo)cboxFarmersTree.getSelectedItem();
					if(kdtEntrys.getCell(i, "supplier").getValue()!=null)
						if(!((SupplierInfo)kdtEntrys.getCell(i, "supplier").getValue()).equals(supplierInfo))
							kdtEntrys.getRow(i).getStyleAttributes().setHided(true);
						else{}
					else
						kdtEntrys.getRow(i).getStyleAttributes().setHided(true);
				}
			}
			//合格蛋类型
			if(cboxQcEggType.getSelectedItem()!=null&&!cboxQcEggType.getSelectedItem().equals("")){
				qcEggType = (QcEggTypeEnum)cboxQcEggType.getSelectedItem();
				if(kdtEntrys.getCell(i, "qcEggType").getValue()!=null)
					if(!((QcEggTypeEnum)kdtEntrys.getCell(i, "qcEggType").getValue()).equals(qcEggType))
						kdtEntrys.getRow(i).getStyleAttributes().setHided(true);
			}
		}
	}


	private void kdtSourceEntrySetRowVisible() {
		// TODO Auto-generated method stub
		FarmersTreeInfo farmersTreeInfo = null;
		SupplierInfo supplierInfo=null;
		QcEggTypeInfo qcEggType;


		for(int i=0;i<kdtSourceEntrys.getRowCount();i++){
			kdtSourceEntrys.getRow(i).getStyleAttributes().setHided(false);

			//片区
			if(cBoxFarmersTree.getSelectedItem()!=null&&!cBoxFarmersTree.getSelectedItem().equals("")){
				if(cBoxFarmersTree.getSelectedItem() instanceof FarmersTreeInfo){
					farmersTreeInfo=(FarmersTreeInfo)cBoxFarmersTree.getSelectedItem();
					if(kdtSourceEntrys.getCell(i, "outAreaP").getValue()!=null)
						if(!((FarmersTreeInfo)kdtSourceEntrys.getCell(i, "outAreaP").getValue()).equals(farmersTreeInfo))
							kdtSourceEntrys.getRow(i).getStyleAttributes().setHided(true);
						else{}
					else
						kdtSourceEntrys.getRow(i).getStyleAttributes().setHided(true);
				}else{
					supplierInfo = (SupplierInfo)cBoxFarmersTree.getSelectedItem();
					if(kdtSourceEntrys.getCell(i, "supplier").getValue()!=null)
						if(!((SupplierInfo)kdtSourceEntrys.getCell(i, "supplier").getValue()).equals(supplierInfo))
							kdtSourceEntrys.getRow(i).getStyleAttributes().setHided(true);
						else{}
					else
						kdtEntrys.getRow(i).getStyleAttributes().setHided(true);

				}
			}
			//合格蛋类型
			if(cBoxQcEggType.getSelectedItem()!=null&&!cBoxQcEggType.getSelectedItem().equals("")){
				qcEggType = (QcEggTypeInfo)cBoxQcEggType.getSelectedItem();
				if(kdtSourceEntrys.getCell(i, "qcEggsType").getValue()!=null)
					if(!((QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue()).equals(qcEggType))
						kdtSourceEntrys.getRow(i).getStyleAttributes().setHided(true);
			}
		}
	}


	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
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
		kdtSourceEntrys.getColumn("outAreaP").setEditor(kdtEntrys_material_CellEditor2);  
		kdtSourceEntrys.getColumn("outAreaP").setRenderer(kdtEntrys_material_OVR2);
		kdtEntrys.getColumn("outAreaPP").setEditor(kdtEntrys_material_CellEditor2);  
		kdtEntrys.getColumn("outAreaPP").setRenderer(kdtEntrys_material_OVR2);
	}
	/**
	 * 添加合计行
	 */
	private void addFootRow() {
		apendFootRow(new KDTable[]{kdtEntrys,kdtImmuneEntrys,kdtSaleEntry,kdtSourceEntrys});
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
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

	@Override
	protected void loadLineFields(KDTable table, IRow row, IObjectValue obj) {

		super.loadLineFields(table, row, obj);
	}


	@Override
	public void onLoad() throws Exception {
		curStorageOrgUnitID=SysContext.getSysContext().getCurrentStorageUnit().getString("id");
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		/*    20170521 wangzw add*/
		//		KDBizPromptBox kdtEntrys_material_PromptBox2 = new KDBizPromptBox();
		//		kdtEntrys_material_PromptBox2.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
		//		kdtEntrys_material_PromptBox2.setVisible(true);
		//		kdtEntrys_material_PromptBox2.setEditable(false);
		//		kdtEntrys_material_PromptBox2.setDisplayFormat("$name$");
		//		kdtEntrys_material_PromptBox2.setEditFormat("$name$");
		//		kdtEntrys_material_PromptBox2.setCommitFormat("$name$");
		//		KDTDefaultCellEditor kdtEntrys_material_CellEditor2 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox2);
		//		ObjectValueRender kdtEntrys_material_OVR2 = new ObjectValueRender();
		//		kdtEntrys_material_OVR2.setFormat(new BizDataFormat("$name$"));
		//		kdtSourceEntrys.getColumn("outAreaP").setEditor(kdtEntrys_material_CellEditor2);  
		//		kdtSourceEntrys.getColumn("outAreaP").setRenderer(kdtEntrys_material_OVR2);
		//		kdtEntrys.getColumn("outAreaPP").setEditor(kdtEntrys_material_CellEditor2);  
		//		kdtEntrys.getColumn("outAreaPP").setRenderer(kdtEntrys_material_OVR2);
		//		

		/**/

		super.onLoad();




		// 校验组织 是否可编辑蛋卷
		if(this.getOprtState().equals("ADDNEW") || this.getOprtState().equals("EDIT")){

			if(currStoOrg == null){
				MsgBox.showInfo("当前未在任何孵化场，不能操作出雏单");
				//		        	this.getUIWindow().close();
				SysUtil.abort();
			}


			if(hatchBaseInfo == null){
				MsgBox.showInfo("当前未在任何孵化场，不能操作出雏单");
				//		        	this.getUIWindow().close();
				SysUtil.abort();
			}

		}
		// 初始化界面空间
		initUIComp();

		if(this.getOprtState().equals("EDIT")){
			checkCanEdit();

		}
		//		ArrayList<String> list=new ArrayList<String>();
		//		kDBizComboBox1.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.signwasthetable.billStatus").toArray());
		//		for(int i=0;i<kdtEntrys.getRowCount();i++){
		//			if(kdtEntrys.getCell(i, "outAreaPP").getValue()!=null)
		//				if(list.contains(((FarmersTreeInfo)kdtEntrys.getCell(i, "outAreaPP").getValue()).getName())){
		//					continue;
		//				}
		//				else{
		//					list.add(((FarmersTreeInfo)kdtEntrys.getCell(i, "outAreaPP").getValue()).getName());
		//					kDBizComboBox1.addItem(((FarmersTreeInfo)kdtEntrys.getCell(i, "outAreaPP").getValue()).getName());
		//				}
		//		}com.kingdee.eas.custom.signwasthetable.billStatus


		//表格enter键焦点方向
		radioHorizon.setSelected(true);
		KDTableHelper.setEnterKeyJumpOrientation(kdtEntrys, Orientation.HORIZONTAL.getValue());
		KDTableHelper.setEnterKeyJumpOrientation(kdtSourceEntrys, Orientation.HORIZONTAL.getValue());

		radioHorizon.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioOrigin.setSelected(false);
				radioVertical.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEntrys, 0);
				KDTableHelper.setEnterKeyJumpOrientation(kdtSourceEntrys, 0);
			}
		});

		radioOrigin.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioHorizon.setSelected(false);
				radioVertical.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEntrys, 2);
				KDTableHelper.setEnterKeyJumpOrientation(kdtSourceEntrys, 2);
			}
		});


		radioVertical.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioOrigin.setSelected(false);
				radioHorizon.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEntrys, 1);
				KDTableHelper.setEnterKeyJumpOrientation(kdtSourceEntrys, 1);
			}
		});

		//20190429 macheng add  隐藏免疫信息、种苗外销、物料领用页签
		this.kDTabbedPane1.remove(this.kDPanel2);
		this.kDTabbedPane1.remove(this.kDPanel3);
		this.kDTabbedPane1.remove(this.kDPanel6);
		//		this.kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
		//        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
		//        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
		//		this.kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
		//        kDTabbedPane1.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
	}
	/**
	 * 初始化UI界面组件
	 */
	private void  initUIComp(){
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		kdtSourceEntrys.getColumn("qcEggType").getStyleAttributes().setHided(true);
		// 图标设置
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));

		this.btnTraceUp.setVisible(true);
		this.btnTraceDown.setVisible(true);
		// 设置查询F7
		this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchBaseDataQuery");
		this.prmthatchArea.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchAreaQuery");

		//字段锁定
		//		kdtEntrys.getColumn("fertilityRate").getStyleAttributes().setLocked(true);
		//		kdtSourceEntrys.getColumn("hatcherTrayHealthQty").getStyleAttributes().setLocked(true);
		//数字字段居右显示
		KDTable[] table={kdtEntrys,kdtImmuneEntrys,kdtSaleEntry,kdtSourceEntrys};
		for(int i=0;i<table.length;i++)
			for(int j=0;j<table[i].getColumnCount();j++)
				if(table[i].getColumn(j).getKey().toLowerCase().contains("qty")
						||table[i].getColumn(j).getKey().toLowerCase().contains("rate"))
					table[i].getColumn(j).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);


		//去向登记添加监听事件
		kdtGoEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				//设置免疫物料的计量单位
				setmaterialUnit(e);
			}

			/**
			 * 设置免疫物料的计量单位
			 * @param e 
			 */
			private void setmaterialUnit(KDTEditEvent e) {
				// TODO Auto-generated method stub
				if("drug".equalsIgnoreCase(kdtGoEntrys.getColumn(e.getColIndex()).getKey())){

					MaterialInfo materialInfo = null;
					MeasureUnitInfo unitInfo = null;
					if(kdtGoEntrys.getCell(e.getRowIndex(), "drug").getValue() != null){
						try {
							materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(((MaterialInfo) kdtGoEntrys.getCell(e.getRowIndex(), "drug").getValue()).getId()));
							if(materialInfo.getBaseUnit() != null){
								unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(materialInfo.getBaseUnit().getId()));
								kdtGoEntrys.getCell(e.getRowIndex(), "unit").setValue(unitInfo);
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
			}

		});




		kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
			@Override
			public void editStarted(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarted(e);
			}
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());


					if("hatchingBox".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
						if(e.getValue()!=null){
							HatchingBoxInfo info  = (HatchingBoxInfo) e.getValue();
							try {
								HatchHouseInfo hinfo = HatchHouseFactory.getRemoteInstance().getHatchHouseInfo(new ObjectUuidPK(info.getHatchHouse().getId().toString()));
								if(hinfo!=null){
									kdtEntrys.getCell(e.getRowIndex(), "outHouse").setValue(hinfo);
								}
								//列复制
								if(e.getRowIndex() == 0){
									for(int i=0;i<kdtEntrys.getRowCount();i++){
										kdtEntrys.getCell(i, "hatchingBox").setValue(info);
										kdtEntrys.getCell(i, "outHouse").setValue(hinfo);
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
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});
		//		this.kdtEggEntry.addAfterActionListener(new BeforeActionListener(){
		//
		//			@Override
		//			public void beforeAction(BeforeActionEvent e) {
		//				if(e.getType() == BeforeActionEvent.ACTION_ADD_ROW){
		//					int rowIndex = ((Integer)e.getParameter()).intValue();
		//					
		//					if(hatchBaseInfo != null){
		//						kdtEggEntry.getRow(rowIndex).getCell("eggSourceType").setValue(hatchBaseInfo.getDefaultEggSourceType());
		//					}
		//				}
		//				
		//			}
		//			
		//		});
		prmthatchFactory.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				hatchFactory_changed(e);
			}});

		kdtSourceEntrys.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				CBoxAddItem();
				apendFootRow(new KDTable[]{kdtSourceEntrys});
			}
		});
		//		setFarmerFilter();

		//		KDBizPromptBox kdtEntrys_material_PromptBox1 = new KDBizPromptBox();
		//		kdtEntrys_material_PromptBox1.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		//		kdtEntrys_material_PromptBox1.setVisible(true);
		//		kdtEntrys_material_PromptBox1.setEditable(true);
		//		kdtEntrys_material_PromptBox1.setDisplayFormat("$name$");
		//		kdtEntrys_material_PromptBox1.setEditFormat("$name$");
		//		kdtEntrys_material_PromptBox1.setCommitFormat("$name$");
		//		KDTDefaultCellEditor kdtEntrys_material_CellEditor1 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox1);
		//		ObjectValueRender kdtEntrys_material_OVR1 = new ObjectValueRender();
		//		kdtEntrys_material_OVR1.setFormat(new BizDataFormat("$name$"));
		//		this.kdtSourceEntrys.getColumn("outHouse").setEditor(kdtEntrys_material_CellEditor1);  
		//		this.kdtSourceEntrys.getColumn("outHouse").setRenderer(kdtEntrys_material_OVR1);

		this.kdtSourceEntrys_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent e)
			throws Exception {
				//				setCellLockedSinlgle(KDTableUtil.getSelectedRow(kdtEggEntry).getRowIndex());
				//				setCellLocked();
			}

			public void beforeEvent(DetailPanelEvent e)
			throws Exception {
				// TODO Auto-generated method stub

			}});

		kdtSourceEntrys.addKDTEditListener(new KDTEditAdapter() {
			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
			}
			public void editStopped(KDTEditEvent e) {
				try {
					kdtSourceEntrys_Changed(e.getRowIndex(),e.getColIndex());
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});

		kdtImmuneEntrys.addKDTEditListener(new KDTEditAdapter() {
			public void editStopped(KDTEditEvent e) {
				try {
					apendFootRow(new KDTable[]{kdtImmuneEntrys});
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});

		kdtSaleEntry.addKDTEditListener(new KDTEditAdapter() {
			public void editStopped(KDTEditEvent e) {
				try {
					apendFootRow(new KDTable[]{kdtSaleEntry});
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});
		btnViewUp.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(editData.getId()==null)
					return;
				//查询上游单据
				//				try {
				ArrayList<String> srcBillList;
				StringBuffer sb=new StringBuffer();
				try {
					QcEggTypeEntryInfo qcEggTypeEntryInfo = null;
					QcEggTypeInfo qcEggType;
					setEntryGenderTypeIsNotNull();
					GenderType sourceGenderType;
					FarmersTreeInfo outAreaInfo;
					SupplierInfo supplierInfo;
					IQcEggTypeEntry IQcEggTypeEntry = QcEggTypeEntryFactory.getRemoteInstance();
					ArrayList<QcEggTypeEnum> qcEggTypeArray=new ArrayList<QcEggTypeEnum>();
					for(int i=0;i<kdtSourceEntrys.getRowCount();i++){

						sb.setLength(0);
						srcBillList = BOTRelationFactory.getRemoteInstance().getSrcObjIdBySrcType(editData.getString("id"), "92957B02");
						if(srcBillList.size()==0)
							return;

						qcEggTypeArray.clear();


						if(kdtSourceEntrys.getCell(i, "qcEggsType").getValue()==null)//qcEggsType
							continue;
						qcEggType = ((QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue());
						//						for(int k=0;k<qcEggType.getEntry().size();k++){
						//							qcEggTypeEntryInfo=IQcEggTypeEntry.getQcEggTypeEntryInfo(new ObjectUuidPK(qcEggType.getEntry().get(k).getString("id")));
						//							qcEggTypeArray.add(qcEggTypeEntryInfo.getQcEggsType());
						//						}

						sourceGenderType = (GenderType)kdtSourceEntrys.getCell(i, "genderType").getValue();//genderType

						if(kdtSourceEntrys.getCell(i, "outAreaP").getValue()!=null)//outArea
							outAreaInfo = (FarmersTreeInfo)kdtSourceEntrys.getCell(i, "outAreaP").getValue();
						else
							outAreaInfo=null;

						if(kdtSourceEntrys.getCell(i, "supplier").getValue()!=null)//supplier
							supplierInfo = (SupplierInfo)kdtSourceEntrys.getCell(i, "supplier").getValue();
						else
							supplierInfo=null;

						sb.append("select sum(t2.CFEggQty) CFEggQty,sum(t2.FHealthTrayingEggQty ) CFHealthEggQty ").append("\n")
						.append("from CT_FM_BEggTrayingBill t1").append("\n")
						.append("inner join CT_FM_BEggTrayingBillEggEntry t2 on t1.FID=t2.FParentID").append("\n")
						.append("      and t1.FID='").append(srcBillList.get(0)).append("'").append("\n") ;

						if(supplierInfo!=null)
							sb.append("      and t2.FSupplierID='").append(supplierInfo.getString("id")).append("'").append("\n");
						else if(outAreaInfo!=null)
							sb.append("      and t2.FOutAreaID='").append(outAreaInfo.getString("id")).append("'").append("\n");

						sb.append("      and t2.FGenderType='").append(sourceGenderType.getValue()).append("'").append("\n");

						if(qcEggType.getEntry().size()>0){
							sb.append("      and t2.FEggType in(");
							for(int k=0;k<qcEggType.getEntry().size();k++){
								if(k!=0)
									sb.append(",");
								qcEggTypeEntryInfo=IQcEggTypeEntry.getQcEggTypeEntryInfo(new ObjectUuidPK(qcEggType.getEntry().get(k).getString("id")));
								sb.append(qcEggTypeEntryInfo.getQcEggsType().getValue());
							}
							sb.append(")").append("\n");
						}

						IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
						if(rs.next()){
							kdtSourceEntrys.getCell(i, "hatchQty").setValue(rs.getInt("CFEggQty"));
							kdtSourceEntrys.getCell(i, "trayingHealthEggQty").setValue(rs.getInt("CFHealthEggQty"));
						}else{
							kdtSourceEntrys.getCell(i, "hatchQty").setValue(0);
							kdtSourceEntrys.getCell(i, "trayingHealthEggQty").setValue(0);
						}



						//获取累计出雏，累了，用sql写了，呜呜。。。。FSrcObjectID FDestEntityID  FSrcEntityID FDestObjectID
						sb.setLength(0);
						sb.append("select sum(t3.FOutQty) outQty,sum(FMaoQty) maoQty")
						.append("\nfrom T_BOT_Relation t1")
						.append("\ninner join CT_FM_BHatchBabyBill t2 on t2.FID=t1.FDestObjectID")
						.append("\n           and t1.FSrcObjectID='").append(srcBillList.get(0)).append("'")
						.append("\ninner join CT_FM_BHBBSE t3 on t2.FID=t3.FParentID");

						if(kdtSourceEntrys.getCell(i, "outAreaP").getValue()!=null)
							sb.append(" and FOutAreaPID='").append(((IPropertyContainer)kdtSourceEntrys.getCell(i, "outAreaP").getValue()).getString("id")).append("'");
						if(kdtSourceEntrys.getCell(i, "qcEggsType").getValue()!=null)
							sb.append(" and FQcEggsTypeID='").append(((QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue()).getString("id")).append("'");
						if(kdtSourceEntrys.getCell(i, "supplier").getValue()!=null)
							sb.append(" and t3.CFSupplierID='").append(((IPropertyContainer)kdtSourceEntrys.getCell(i, "supplier").getValue()).getString("id")).append("'");
						if(kdtSourceEntrys.getCell(i, "genderType").getValue()!=null){
							sb.append(" and t3.FgenderType=").append(((GenderType)kdtSourceEntrys.getCell(i, "genderType").getValue()).getValue()).append("\n");
						}


						if(UIRuleUtil.isNotNull(editData.getString("id")))
							sb.append(" and t2.FID <>'").append(editData.getString("id")).append("'");
						rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
						if(rs.next()){
							int kuiQty = UIRuleUtil.getInt(rs.getBigDecimal("outQty"))+UIRuleUtil.getInt(rs.getBigDecimal("maoQty"))+UIRuleUtil.getInt(kdtSourceEntrys.getCell(i, "outQty").getValue())-UIRuleUtil.getInt(kdtSourceEntrys.getCell(i, "trayingHealthEggQty").getValue())+UIRuleUtil.getInt(kdtSourceEntrys.getCell(i, "maoQty").getValue());
							kdtSourceEntrys.getCell(i, "kuiQty").setValue(kuiQty);
							kdtSourceEntrys.getCell(i, "allOutQty").setValue(UIRuleUtil.getInt(rs.getBigDecimal("outQty"))+UIRuleUtil.getInt(kdtSourceEntrys.getCell(i, "outQty").getValue()));
						}
					}
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//						//获取 落盘数据
				//						hatchQty=0;
				//						healthTrayingEggQty=0;
				//						str="where parent='"+trayingInfoID+"'";
				//						if(kdtSourceEntrys.getCell(i, "outAreaP").getValue()!=null&&kdtSourceEntrys.getCell(i, "supplier").getValue()==null)
				//							str+=" and OutArea='"+((FarmersTreeInfo)kdtSourceEntrys.getCell(i, "outAreaP").getValue()).getString("id")+"'";
				//						if(kdtSourceEntrys.getCell(i, "qcEggsType").getValue()!=null&&kdtSourceEntrys.getCell(i, "supplier").getValue()==null){
				//							if(!((QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue()).getName().equals("供应商")){
				//								QcEggTypeInfo qcEggTypeInfo = (QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue();
				//								if(qcEggTypeInfo.getEntry().size()>0){
				//									str+=" and EggType in (";
				//									for(int k=0;k<qcEggTypeInfo.getEntry().size();k++){
				//										if(qcEggTypeInfo.getEntry().get(k).getId()!=null){
				//											QcEggTypeEntryInfo qcEntryInfo = QcEggTypeEntryFactory.getRemoteInstance().getQcEggTypeEntryInfo(new ObjectUuidPK(qcEggTypeInfo.getEntry().get(k).getId().toString()));
				//											str+=qcEntryInfo.getQcEggsType().getValue();
				//											if(k<qcEggTypeInfo.getEntry().size()-1)
				//												str+=",";
				//										}
				//									}
				//									str+=")";
				//								}
				//							}
				//						}
				//						if(kdtSourceEntrys.getCell(i, "supplier").getValue()!=null)
				//							str+=" and supplier='"+((SupplierInfo)kdtSourceEntrys.getCell(i, "supplier").getValue()).getString("id")+"'";
				//
				//
				//						if(UIRuleUtil.isNull(kdtSourceEntrys.getCell(i, "genderType").getValue())||((GenderType)kdtSourceEntrys.getCell(i, "genderType").getValue()).getValue().equals("2"))
				//							str+=" and (genderType not in ('0','1') or genderType is null)";
				//						else
				//							str+="and genderType='"+((GenderType)kdtSourceEntrys.getCell(i, "genderType").getValue()).getValue()+"'";
				//
				//						coll = BEggTrayingBillEggEntryFactory.getRemoteInstance().getBEggTrayingBillEggEntryCollection(str);
				//						if(coll.size()>0){
				//							for(int j=0;j<coll.size();j++){
				//								hatchQty+=coll.get(j).getEggQty();
				//								healthTrayingEggQty+=coll.get(j).getHealthTrayingEggQty();
				//							}
				//							kdtSourceEntrys.getCell(i, "hatchQty").setValue(hatchQty);
				//							kdtSourceEntrys.getCell(i, "trayingHealthEggQty").setValue(healthTrayingEggQty);
				//						}else{
				//							kdtSourceEntrys.getCell(i, "hatchQty").setValue(0);
				//							kdtSourceEntrys.getCell(i, "trayingHealthEggQty").setValue(0);
				//						}
				//

				//						if(rs.next())
				//							kdtSourceEntrys.getCell(i, "allOutQty").setValue(rs.getInt("allOutQty"));
				//					}
				//				} catch (BOSException e1) {
				//					// TODO Auto-generated catch block
				//					e1.printStackTrace();
				//				} catch (SQLException e2) {
				//					// TODO Auto-generated catch block
				//					e2.printStackTrace();
				//				} catch (EASBizException e1) {
				//					// TODO Auto-generated catch block
				//					e1.printStackTrace();
				//				}
				catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		btnGetMaoQty.addMouseListener(new MouseAdapter(){
			//获取毛蛋
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				QcEggTypeEntryInfo qcEggTypeEntryInfo = null;
				QcEggTypeInfo qcEggType;
				setEntryGenderTypeIsNotNull();
				GenderType sourceGenderType;
				FarmersTreeInfo outAreaInfo;
				SupplierInfo supplierInfo;
				IQcEggTypeEntry IQcEggTypeEntry = null;
				ArrayList<QcEggTypeEnum> qcEggTypeArray=new ArrayList<QcEggTypeEnum>();
				try {
					IQcEggTypeEntry = QcEggTypeEntryFactory.getRemoteInstance();
					for(int i=0;i<kdtSourceEntrys.getRowCount();i++){

						int MaoQty=0;//reset

						qcEggTypeArray.clear();


						if(kdtSourceEntrys.getCell(i, "qcEggsType").getValue()==null)//qcEggsType
							continue;
						qcEggType = ((QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue());
						for(int k=0;k<qcEggType.getEntry().size();k++){
							qcEggTypeEntryInfo=IQcEggTypeEntry.getQcEggTypeEntryInfo(new ObjectUuidPK(qcEggType.getEntry().get(k).getString("id")));
							qcEggTypeArray.add(qcEggTypeEntryInfo.getQcEggsType());

						}

						sourceGenderType = (GenderType)kdtSourceEntrys.getCell(i, "genderType").getValue();//genderType

						if(kdtSourceEntrys.getCell(i, "outAreaP").getValue()!=null)//outArea
							outAreaInfo = (FarmersTreeInfo)kdtSourceEntrys.getCell(i, "outAreaP").getValue();
						else
							outAreaInfo=null;

						if(kdtSourceEntrys.getCell(i, "supplier").getValue()!=null)//supplier
							supplierInfo = (SupplierInfo)kdtSourceEntrys.getCell(i, "supplier").getValue();
						else
							supplierInfo=null;


						for(int j=0;j<kdtEntrys.getRowCount();j++){
							//合格单类型
							if(!qcEggTypeArray.contains((QcEggTypeEnum)kdtEntrys.getCell(j,"qcEggType").getValue()))
								continue;
							//品系
							if(!((GenderType)kdtEntrys.getCell(j, "genderType").getValue()).equals(sourceGenderType))
								continue;
							//供应商
							if(supplierInfo!=null){
								if(kdtEntrys.getCell(j, "supplier").getValue()==null||!(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(j, "supplier").getValue(),"id").toString().equals(supplierInfo.getString("id"))))
									continue;
							}else if(outAreaInfo!=null){
								if(kdtEntrys.getCell(j, "outAreaPP").getValue()==null||!(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(j, "outAreaPP").getValue(),"id").toString().equals(outAreaInfo.getString("id"))))
									continue;
							}else
								continue;


							MaoQty+=(Integer)kdtEntrys.getCell(j,"maoEggQty").getValue();
						}

						//					for(int j=0;j<kdtEntrys.getRowCount();j++){
						//						//片区
						//						if(kdtSourceEntrys.getCell(i, "supplier").getValue()==null){
						//							if(kdtSourceEntrys.getCell(i, "outAreaP").getValue()!=null)
						//								if(kdtEntrys.getCell(j, "outAreaPP").getValue()==null)
						//									continue;
						//								else if(!kdtEntrys.getCell(j, "outAreaPP").getValue().equals(kdtSourceEntrys.getCell(i, "outAreaP").getValue()))
						//									continue;
						//								else{}
						//							else if(kdtEntrys.getCell(j, "outAreaPP").getValue()!=null)
						//								continue;
						//
						//							//合格蛋类型
						//							qcEggType = ((QcEggTypeInfo)kdtSourceEntrys.getCell(i, "qcEggsType").getValue());
						//							for(int k=0;k<qcEggType.getEntry().size();k++){
						//								try {
						//									qcEggTypeEntryInfo=QcEggTypeEntryFactory.getRemoteInstance().getQcEggTypeEntryInfo(new ObjectUuidPK(qcEggType.getEntry().get(k).getString("id")));
						//														if(qcEggTypeEntryInfo.getQcEggsType().equals((QcEggTypeEnum)kdtEntrys.getCell(j,"qcEggType").getValue())){
						//										flag=true;
						//									}else
						//										continue;
						//								} catch (EASBizException e1) {
						//									// TODO Auto-generated catch block
						//									e1.printStackTrace();
						//								} catch (BOSException e1) {
						//									// TODO Auto-generated catch block
						//									e1.printStackTrace();
						//								}
						//							}
						//							if(!flag){
						//								continue;
						//							}else
						//								flag=false;
						//						}else{
						//							if(kdtEntrys.getCell(j,"supplier").getValue()==null||!((SupplierInfo)kdtEntrys.getCell(j,"supplier").getValue()).getString("id").equals(((SupplierInfo)kdtSourceEntrys.getCell(i, "supplier").getValue()).getString("id")))
						//								continue;
						//
						//						}
						//
						//						//品系
						//						if(kdtSourceEntrys.getCell(i, "genderType").getValue()==null||((GenderType)kdtSourceEntrys.getCell(i, "genderType").getValue()).equals(GenderType.Void)){
						//							if(kdtEntrys.getCell(j,"genderType").getValue()==null||((GenderType)kdtEntrys.getCell(j,"genderType").getValue()).equals(GenderType.Void)){
						//							}else
						//								continue;
						//						}else{
						//							if(!kdtSourceEntrys.getCell(i, "genderType").getValue().equals(kdtEntrys.getCell(j,"genderType").getValue()))
						//								continue;
						//						}
						//						MaoQty+=(Integer)kdtEntrys.getCell(j,"maoEggQty").getValue();
						//					}
						kdtSourceEntrys.getCell(i, "maoQty").setValue(MaoQty);
						kdtSourceEntrys.getCell(i, "kuiQty").setValue(UIRuleUtil.getInt(kdtSourceEntrys.getCell(i, "outQty").getValue())-UIRuleUtil.getInt(kdtSourceEntrys.getCell(i, "trayingHealthEggQty").getValue())+UIRuleUtil.getInt(kdtSourceEntrys.getCell(i, "maoQty").getValue()));

					}
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(e1.getStackTrace()[1].getFileName()+e1.getStackTrace()[1].getLineNumber()+"\n"+e1.getCause().getMessage());
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}});

	}


	/**
	 * 出雏明细页签增加值
	 */
	private void CBoxAddItem() {
		//		// TODO Auto-generated method stub
		//		cBoxFarmersTree.removeAllItems();
		//		cBoxQcEggType.removeAllItems();
		//		ArrayList<QcEggTypeEnum> listQc=new ArrayList<QcEggTypeEnum>();
		//		ArrayList<FarmersTreeInfo> list=new ArrayList<FarmersTreeInfo>();
		//		for(int i=0;i<kdtSourceEntrys.getRowCount();i++){
		//			if(kdtSourceEntrys.getCell(i, "outAreaP").getValue()!=null&&!list.contains((FarmersTreeInfo)kdtSourceEntrys.getCell(i, "outAreaP").getValue())){
		//				list.add((FarmersTreeInfo)kdtSourceEntrys.getCell(i, "outAreaP").getValue());
		//			}
		//			if(kdtSourceEntrys.getCell(i, "qcEggType").getValue()!=null&&!listQc.contains((QcEggTypeEnum)kdtSourceEntrys.getCell(i, "qcEggType").getValue())){
		//				listQc.add((QcEggTypeEnum)kdtSourceEntrys.getCell(i, "qcEggType").getValue());
		//			}
		//		}
		//		cBoxFarmersTree.addItem("");
		//		cBoxFarmersTree.addItems(list.toArray());
		//
		//
		//		cBoxQcEggType.addItem("");
		//		cBoxQcEggType.addItems(listQc.toArray());
	}
	/**
	 * 开始编辑
	 * @param e
	 */
	private void kdteditStarted(KDTEditEvent e) {
		int rowIndex=e.getRowIndex();
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtSourceEntrys.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("outFarm")||key.equals("outBatch")||key.equals("outHouse")) {
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtSourceEntrys.getColumn("outFarm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtSourceEntrys.getColumn("outBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtSourceEntrys.getCell(rowIndex, "outBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtSourceEntrys.getCell(rowIndex, "outBatch").getValue()).getString("id");
			}
			if(this.kdtSourceEntrys.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtSourceEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtSourceEntrys.getCell(rowIndex, "outFarm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtSourceEntrys.getCell(rowIndex, "outFarm").getValue()).getString("id");
			}
			if(this.kdtSourceEntrys.getCell(rowIndex, "outHouse").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtSourceEntrys.getCell(rowIndex, "outHouse").getValue()).getString("id");
			}
			StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID,houseID);
			//养殖场过滤
			StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
			//棚舍过滤
			HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,false);
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtSourceEntrys.getColumn("outHouse").getEditor().getComponent()).setEntityViewInfo(ev);
		}
	}

	public void kdtSourceEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		//		super.kdtSourceEntrys_Changed(rowIndex, colIndex);
		// 更新数量

		//根据合同和批次带出养殖户和农场
		if(kdtSourceEntrys.getColumn(colIndex).getKey().equals("outBatch")) {
			if(kdtSourceEntrys.getCell(rowIndex, "outBatch").getValue()!=null) {
				kdtSourceEntrys.getCell(rowIndex, "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtSourceEntrys.getCell(rowIndex,"outBatch").getValue(), "farmer"));
				kdtSourceEntrys.getCell(rowIndex, "outFarm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtSourceEntrys.getCell(rowIndex,"outBatch").getValue(), "farm"));
			}
		}
		if(kdtSourceEntrys.getColumn(colIndex).getKey().equals("hatchHouse")) {
			Object obj = kdtSourceEntrys.getCell(rowIndex, "hatchHouse").getValue();
			for(int i = 0; i < this.kdtSourceEntrys.getRowCount(); i++){
				if(this.kdtSourceEntrys.getCell(i,"hatchHouse").getValue() == null){
					this.kdtSourceEntrys.getCell(i,"hatchHouse").setValue(obj);
				}
			}
		}
		if(kdtSourceEntrys.getColumn(colIndex).getKey().equals("incubator")) {
			Object obj = kdtSourceEntrys.getCell(rowIndex, "incubator").getValue();
			for(int i = 0; i < this.kdtSourceEntrys.getRowCount(); i++){
				if(this.kdtSourceEntrys.getCell(i,"incubator").getValue() == null){
					this.kdtSourceEntrys.getCell(i,"incubator").setValue(obj);
				}
			}
		}
		if(kdtSourceEntrys.getColumn(colIndex).getKey().equals("supplier")) {
			if(kdtSourceEntrys.getCell(rowIndex, colIndex).getValue()!=null)
				kdtSourceEntrys.getCell(rowIndex, "outAreaP").setValue(null);	
		}
		if(kdtSourceEntrys.getColumn(colIndex).getKey().equals("outAreaP"))
			if(kdtSourceEntrys.getCell(rowIndex, colIndex).getValue()!=null)
				kdtSourceEntrys.getCell(rowIndex, "supplier").setValue(null);
		//	updateQtys();
		//		if(kdtSourceEntrys.getColumn(colIndex).getKey().equals("eggSourceType")) {
		//			setCellLockedSinlgle(rowIndex);
		//		}
		//		//计算落蛋活胚
		//		if(kdtSourceEntrys.getColumn(colIndex).getKey().toLowerCase().contains("qty")) {
		//			kdtSourceEntrys.getCell(rowIndex, "hatcherTrayHealthQty").setValue(
		//					UIRuleUtil.getInt(kdtSourceEntrys.getCell(rowIndex, "candingHealthQty").getValue())
		//					-UIRuleUtil.getInt(kdtSourceEntrys.getCell(rowIndex, "hatcherTrayDeathQty").getValue())
		//					-UIRuleUtil.getInt(kdtSourceEntrys.getCell(rowIndex, "sunningDeathQty").getValue())
		//			);
		//
		//		}
		//		calLossQty(rowIndex);
		//		calHealthRate(rowIndex);
		//		calFelHealthRate(rowIndex);
		//		calEggFhRate(rowIndex);
		//		calSjEggFhRate(rowIndex);

		int outQty=0;
		outQty+=(Integer)kdtSourceEntrys.getCell(rowIndex, "healthQty").getValue();
		outQty+=(Integer)kdtSourceEntrys.getCell(rowIndex, "healthQtyA1").getValue();
		outQty+=(Integer)kdtSourceEntrys.getCell(rowIndex, "healthQtyA2").getValue();
		outQty+=(Integer)kdtSourceEntrys.getCell(rowIndex, "healthQtyA3").getValue();
		outQty+=(Integer)kdtSourceEntrys.getCell(rowIndex, "healthQtyB").getValue();
		outQty+=(Integer)kdtSourceEntrys.getCell(rowIndex, "GermQty2").getValue();
		outQty+=(Integer)kdtSourceEntrys.getCell(rowIndex, "deadGermQty").getValue();
		outQty+=(Integer)kdtSourceEntrys.getCell(rowIndex, "littleChickQty").getValue();
		kdtSourceEntrys.getCell(rowIndex, "outQty").setValue(outQty);
	}
	//计算上孵蛋孵化率
	private void calEggFhRate(int rowIndex) {
		if(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "hatchQty").getValue()).signum()>0) {
			kdtSourceEntrys.getCell(rowIndex, "hatchRate").setValue(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "allQty").getValue()).multiply(new BigDecimal(100)).divide(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "hatchQty").getValue()),2,BigDecimal.ROUND_HALF_UP));
		}else{
			kdtSourceEntrys.getCell(rowIndex, "hatchRate").setValue(BigDecimal.ZERO);
		}
	}

	//计算受精蛋蛋孵化率
	private void calSjEggFhRate(int rowIndex) {
		if(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "candingHealthQty").getValue()).signum()>0) {
			kdtSourceEntrys.getCell(rowIndex, "fertilityHatchRate").setValue(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "allQty").getValue()).multiply(new BigDecimal(100)).divide(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "candingHealthQty").getValue()),2,BigDecimal.ROUND_HALF_UP));
		}else{
			kdtSourceEntrys.getCell(rowIndex, "fertilityHatchRate").setValue(BigDecimal.ZERO);
		}
	}

	//计算亏损
	/*出雏数=正品+一级+二级+三级+无品+残雏2+残苗
	健雏率=（正品+一级+二级）/出雏数*100%
	上孵蛋孵化率=出雏数/上孵数*100%
	受精蛋健雏率=（正品+一级）/照蛋活胚*100%
	受精蛋孵化率=出雏数/照蛋活胚*100%
	亏损=毛蛋+出雏数-落盘活胚*/
	private void calLossQty(int rowIndex) {
		kdtSourceEntrys.getCell(rowIndex, "lossQty").setValue(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "allQty").getValue()).add(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "unhatchedQty").getValue())).subtract(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex, "hatcherTrayHealthQty").getValue())));
	}

	/**
	 * 出雏明细页签 计算健雏率
	 * @param rowIndex
	 */
	private void calHealthRate(int rowIndex) {
		if (UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"allQty").getValue())> 0){
			BigDecimal healthQty = UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue()).add (UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())).add( UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue()));
			kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(UIRuleUtil.getBigDecimal(new BigDecimal(100).multiply(healthQty.divide(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex,"allQty").getValue()),4,BigDecimal.ROUND_HALF_UP))));
		}
		else
		{
			kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(null);
		}
	}
	/**
	 * 受精蛋健雏率=（正品+一级+二级）/照蛋活胚*100%
	 * @param rowIndex
	 */
	private void calFelHealthRate(int rowIndex) {
		if (UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue())> 0) {
			BigDecimal healthQty = UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue()).add (UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())).add( UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue()));
			kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(UIRuleUtil.getBigDecimal(new BigDecimal(100).multiply(healthQty.divide(UIRuleUtil.getBigDecimal(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue()),4,BigDecimal.ROUND_HALF_UP))));
		}
		else
		{
			kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(null);
		}
	}


	private void setCellLocked() {
		for(int rowIndex=0;rowIndex<kdtSourceEntrys.getRowCount();rowIndex++) {
			setCellLockedSinlgle(rowIndex);
		}
	}
	private void setCellLockedSinlgle(int rowIndex) {
		if(rowIndex<0) {
			return;
		}
		if(kdtSourceEntrys.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.SubContract)) {
			kdtSourceEntrys.getCell(rowIndex,"supplier").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"material").setValue(null);
			kdtSourceEntrys.getCell(rowIndex,"eggLog").setValue(null);

			//			kdtSourceEntrys.getCell(rowIndex,"farmer").getStyleAttributes().setLocked(false);
			//			kdtSourceEntrys.getCell(rowIndex,"outHouse").getStyleAttributes().setLocked(false);
			//			kdtSourceEntrys.getCell(rowIndex,"outBatch").getStyleAttributes().setLocked(false);
			//			kdtSourceEntrys.getCell(rowIndex,"outFarm").getStyleAttributes().setLocked(false);
			kdtSourceEntrys.getCell(rowIndex,"supplier").getStyleAttributes().setLocked(true);
			//			kdtSourceEntrys.getCell(rowIndex,"material").getStyleAttributes().setLocked(true);
			kdtSourceEntrys.getCell(rowIndex,"eggLog").getStyleAttributes().setLocked(true);
		} if(kdtSourceEntrys.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.Purchase)) {
			//			kdtSourceEntrys.getCell(rowIndex,"farmer").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"outFarm").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"outHouse").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"outBatch").setValue(null);
			//
			//			kdtSourceEntrys.getCell(rowIndex,"farmer").getStyleAttributes().setLocked(true);
			//			kdtSourceEntrys.getCell(rowIndex,"outHouse").getStyleAttributes().setLocked(true);
			//			kdtSourceEntrys.getCell(rowIndex,"outBatch").getStyleAttributes().setLocked(true);
			//			kdtSourceEntrys.getCell(rowIndex,"outFarm").getStyleAttributes().setLocked(true);
			kdtSourceEntrys.getCell(rowIndex,"supplier").getStyleAttributes().setLocked(false);
			//			kdtSourceEntrys.getCell(rowIndex,"material").getStyleAttributes().setLocked(false);
			kdtSourceEntrys.getCell(rowIndex,"eggLog").getStyleAttributes().setLocked(false);
		}
		if(kdtSourceEntrys.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.InternalFarm)) {
			kdtSourceEntrys.getCell(rowIndex,"supplier").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"material").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"eggLog").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"farmer").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"outFarm").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"outHouse").setValue(null);
			//			kdtSourceEntrys.getCell(rowIndex,"outBatch").setValue(null);

			//			kdtSourceEntrys.getCell(rowIndex,"farmer").getStyleAttributes().setLocked(true);
			//			kdtSourceEntrys.getCell(rowIndex,"outHouse").getStyleAttributes().setLocked(true);
			//			kdtSourceEntrys.getCell(rowIndex,"outBatch").getStyleAttributes().setLocked(true);
			//			kdtSourceEntrys.getCell(rowIndex,"outFarm").getStyleAttributes().setLocked(true);
			kdtSourceEntrys.getCell(rowIndex,"supplier").getStyleAttributes().setLocked(true);
			//			kdtSourceEntrys.getCell(rowIndex,"material").getStyleAttributes().setLocked(true);
			kdtSourceEntrys.getCell(rowIndex,"eggLog").getStyleAttributes().setLocked(true);
		}
	}
	/**
	 * 孵化场改变
	 * @param e
	 */
	private void hatchFactory_changed(DataChangeEvent e) {
		if(e.getNewValue()!=null) {
			curCompanyID=null;
		}else{
			//孵化场
			try {
				curCompanyID=((IPropertyContainer) UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "hatchFactory")).getString("id");
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}
		setFarmerFilter();
	}

	private void setFarmerFilter() {
		//养殖户过滤
		//		StockingClientComm.setFarmerFilterForHatch((KDBizPromptBox) kdtSourceEntrys.getColumn("farmer").getEditor().getComponent(), curCompanyID,null);
	}





	/**
	 * output kdtEntrys_Changed(int rowIndex,int colIndex) method
	 */
	public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
	{
		if(kdtEntrys.getColumn(colIndex).getKey().toLowerCase().contains("qty")) {
			apendFootRow(kdtEntrys, new String []{"hatchQty","maoEggQty"});
		}
		BigDecimal ksMaleQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "ksMaleQty").getValue());
		BigDecimal gjMaleQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "gjMaleQty").getValue());
		kdtEntrys.getCell(rowIndex, "maleQty").setValue(ksMaleQty.add(gjMaleQty).intValue());


		int heath1 = (Integer)kdtEntrys.getCell(rowIndex, "lphps").getValue();

		int outQty=0;
		outQty+=(Integer)kdtEntrys.getCell(rowIndex, "healthQty").getValue();
		outQty+=(Integer)kdtEntrys.getCell(rowIndex, "germQty").getValue();
		//计算母雏
		kdtEntrys.getCell(rowIndex, "femaleQty").setValue(outQty);

		outQty+=(Integer)kdtEntrys.getCell(rowIndex, "deadGermQty").getValue();
		outQty+=(Integer)kdtEntrys.getCell(rowIndex, "maoEggQty").getValue();
		outQty+=(Integer)kdtEntrys.getCell(rowIndex, "maleQty").getValue();
		outQty+=(Integer)kdtEntrys.getCell(rowIndex, "healthQty2").getValue();	

		if(outQty>heath1){
			MsgBox.showInfo("累计出雏数不能大于落盘活胚数！");
			kdtEntrys.getCell(rowIndex, "ksMaleQty").setValue(0);
			kdtEntrys.getCell(rowIndex, "gjMaleQty").setValue(0);
			kdtEntrys.getCell(rowIndex, "maleQty").setValue(0);

			SysUtil.abort();
		}
		
		//设置赠品
		BigDecimal persent = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "healthQty").getValue())
		.multiply(new BigDecimal("2")).divide(new BigDecimal("100"),0,BigDecimal.ROUND_DOWN);

		//设置损耗差异
		BigDecimal lossDiff = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "lphps").getValue())
		.subtract(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "healthQty").getValue())) //健雏
		.subtract(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "maoEggQty").getValue()))
		.subtract(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "deadGermQty").getValue()));
		
		kdtEntrys.getCell(rowIndex, "lossDiff").setValue(lossDiff);
		
		kdtEntrys.getCell(rowIndex, "gifts").setValue(persent);
		//累计出雏（总计）
		kdtEntrys.getCell(rowIndex, "allOutQty").setValue(outQty);

		//全蛋健母率
		BigDecimal health = BigDecimal.valueOf((Integer)kdtEntrys.getCell(rowIndex, "healthQty").getValue());

		BigDecimal hatchQty = BigDecimal.valueOf((Integer) kdtEntrys.getCell(rowIndex, "hatchQty").getValue());
		if(hatchQty.equals(new BigDecimal("0"))){
			hatchQty = BigDecimal.ONE;
		}

		health = health.multiply(new BigDecimal("100")).divide(hatchQty, 2, BigDecimal.ROUND_HALF_UP);
		kdtEntrys.getCell(rowIndex, "healthRate").setValue(health);

		//落盘健雏率
		//健雏
		BigDecimal lphealth = BigDecimal.valueOf((Integer)kdtEntrys.getCell(rowIndex, "healthQty").getValue());
		//赠品
		BigDecimal gifts = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "gifts").getValue());
		//落盘活胚数
		BigDecimal lphps = BigDecimal.valueOf((Integer)kdtEntrys.getCell(rowIndex, "lphps").getValue());
		if(lphps.equals(new BigDecimal("0"))){
			lphps = BigDecimal.ONE;
		}
		lphealth = lphealth.subtract(gifts).multiply(new BigDecimal("100")).divide(lphps, 2, BigDecimal.ROUND_HALF_UP);
		kdtEntrys.getCell(rowIndex, "lphralthRate").setValue(lphealth);

		//毛蛋率	maoEggRate=毛蛋/落盘活胚
		hatchQty = BigDecimal.valueOf((Integer) kdtEntrys.getCell(rowIndex, "lphps").getValue());
		if(hatchQty == null || BigDecimal.ZERO.compareTo(hatchQty) == 0){
			kdtEntrys.getCell(rowIndex, "maoEggRate").setValue(BigDecimal.ZERO);
		} else {
			BigDecimal maoEggQty = BigDecimal.valueOf((Integer)kdtEntrys.getCell(rowIndex, "maoEggQty").getValue());
			maoEggQty = maoEggQty == null ? BigDecimal.ZERO : maoEggQty;
			BigDecimal maoEggRate = maoEggQty.multiply(new BigDecimal("100")).divide(hatchQty, 2, BigDecimal.ROUND_HALF_UP);
			kdtEntrys.getCell(rowIndex, "maoEggRate").setValue(maoEggRate);
		}
		//		//弱母率germRate=弱母雏/母雏
		//		BigDecimal femaleQty = BigDecimal.valueOf((Integer) kdtEntrys.getCell(rowIndex, "femaleQty").getValue());
		//		if(femaleQty == null || BigDecimal.ZERO.compareTo(femaleQty) == 0){
		//			kdtEntrys.getCell(rowIndex, "germRate").setValue(BigDecimal.ZERO);
		//		} else {
		//			BigDecimal germQty = BigDecimal.valueOf((Integer)kdtEntrys.getCell(rowIndex, "germQty").getValue());
		//			germQty = germQty == null ? BigDecimal.ZERO : germQty;
		//			BigDecimal germRate = germQty.multiply(new BigDecimal("100")).divide(femaleQty, 2, BigDecimal.ROUND_HALF_UP);
		//			kdtEntrys.getCell(rowIndex, "germRate").setValue(germRate);
		//		}
		//		//蛋雏比eggBabyRate=上孵数量/健母雏
		//		hatchQty = BigDecimal.valueOf((Integer) kdtEntrys.getCell(rowIndex, "hatchQty").getValue());
		//		hatchQty = hatchQty == null ? BigDecimal.ZERO : hatchQty;
		//		health = BigDecimal.valueOf((Integer)kdtEntrys.getCell(rowIndex, "healthQty").getValue());
		//		if(health == null || BigDecimal.ZERO.compareTo(health) == 0){
		//			kdtEntrys.getCell(rowIndex, "eggBabyRate").setValue(BigDecimal.ZERO);
		//		} else {
		//			BigDecimal eggBabyRate = hatchQty.divide(health, 2, BigDecimal.ROUND_HALF_UP);
		//			kdtEntrys.getCell(rowIndex, "eggBabyRate").setValue(eggBabyRate);
		//		}
		//		//公母比	maleFemaleRate=公雏/母雏
		//		femaleQty = BigDecimal.valueOf((Integer) kdtEntrys.getCell(rowIndex, "femaleQty").getValue());
		//		if(femaleQty == null || BigDecimal.ZERO.compareTo(femaleQty) == 0){
		//			kdtEntrys.getCell(rowIndex, "maleFemaleRate").setValue(BigDecimal.ZERO);
		//		} else {
		//			BigDecimal maleQty = BigDecimal.valueOf((Integer) kdtEntrys.getCell(rowIndex, "maleQty").getValue());
		//			maleQty = maleQty == null ? BigDecimal.ZERO : maleQty;
		//			BigDecimal maleFemaleRate = maleQty.multiply(new BigDecimal("100")).divide(femaleQty, 2, BigDecimal.ROUND_HALF_UP);
		//			kdtEntrys.getCell(rowIndex, "maleFemaleRate").setValue(maleFemaleRate);
		//		}

	}

	/**
	 * 更新数量
	 */
	private void updateQtys(){
		BigDecimal allDeadGermQty = BigDecimal.ZERO;
		BigDecimal allMaoQty = BigDecimal.ZERO;
		BigDecimal allHealthQty = BigDecimal.ZERO;
		int allHealthQtyB = 0;
		int allNoHealthQty = 0;
		int allHealthQtyA1 = 0;
		int allHealthQtyA2 = 0;
		int allHealthQtyA3 = 0;
		int allLossQty = 0;
		// 逐行统计
		for(int i = 0; i < this.kdtEntrys.getRowCount(); i++){
			IRow row = this.kdtEntrys.getRow(i);
			//分录死雏
			BigDecimal deadGermQty = BigDecimal.ZERO;
			if(kdtEntrys.getCell(i, "deadGermQty") != null){
				deadGermQty = new BigDecimal(kdtEntrys.getCell(i, "deadGermQty").getValue().toString());
			}

			//分录毛蛋
			BigDecimal maoQty = BigDecimal.ZERO;
			if(kdtEntrys.getCell(i, "maoEggQty") != null){
				maoQty = new BigDecimal(kdtEntrys.getCell(i, "maoEggQty").getValue().toString());
			}
			//分录健雏
			BigDecimal healthQty = BigDecimal.ZERO;
			if(kdtEntrys.getCell(i, "healthQty") != null){
				healthQty = new BigDecimal(kdtEntrys.getCell(i, "healthQty").getValue().toString());
			}
			//表头死雏
			allDeadGermQty = allDeadGermQty.add(deadGermQty);
			//表头毛蛋
			allMaoQty = allMaoQty.add(maoQty);
			//表头健雏
			allHealthQty = allHealthQty.add(healthQty);
		}

		//表头死雏
		this.txtdeathQty.setValue(allDeadGermQty);
		//表头毛蛋
		this.txtunhatchedEggQty.setValue(allMaoQty);
		//表头健雏
		this.txthealthQty.setValue(allHealthQty);
		//其他不予显示
		this.txtlossQty.setValue(allLossQty);
		this.txthealthQtyB.setValue(allHealthQtyB);
		this.txtnoHealthQty.setValue(allNoHealthQty);
		this.txthealthQtyA1.setValue(allHealthQtyA1);
		this.txthealthQtyA2.setValue(allHealthQtyA2);
		this.txthealthQtyA3.setValue(allHealthQtyA3);
	}
	/**
	 * 设置鸡舍过滤条件
	 */
	private void setHenhouseFilter(StorageOrgUnitInfo cuInfo ){

	}

	//
	//	/**
	//	 * 落盘死胚
	//	 */
	//	@Override
	//	protected void txtdeadGermQty_actionPerformed(ActionEvent e)
	//	throws Exception {
	//		// TODO Auto-generated method stub
	//		super.txtdeadGermQty_actionPerformed(e);
	//	}
	/**
	 * 残死雏
	 */
	@Override
	protected void txtdeathQty_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.txtdeathQty_actionPerformed(e);
	}
	/**
	 * 损耗
	 */
	@Override
	protected void txtlossQty_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.txtlossQty_actionPerformed(e);
	}
	/**
	 * 毛蛋
	 */
	@Override
	protected void txtunhatchedEggQty_actionPerformed(ActionEvent e)
	throws Exception {
		super.txtunhatchedEggQty_actionPerformed(e);
	}
	/**
	 * 拆分数量到分录
	 * @param qty
	 * @param columnStr
	 */
	private void splitQtyToEntry(int qty,String columnStr){


	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		reloadData();
	}


	@Override
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
	{
		checkData();
		updateQtys();
		super.actionSubmit_actionPerformed(e);
		reloadData();


	}

	/**
	 * 校验数据合法性 
	 * 上孵数量 = 合格蛋 +其他
	 */
	private void checkData(){

		// 转箱量
		//    	Integer allTransQty = this.txtTransQty.getIntegerValue();
		//    	allTransQty = (allTransQty == null ?new Integer(0):allTransQty);
		//    	
		//    	// 健雏
		//    	Integer healthQty = this.txthealthQty.getIntegerValue();
		//    	healthQty = (healthQty == null ?new Integer(0):healthQty);
		//    	
		//    	// 残死雏
		//    	Integer deathQty = this.txtdeathQty.getIntegerValue();
		//    	deathQty = (deathQty == null ?new Integer(0):deathQty);
		//    	
		//    	// 毛蛋
		//    	Integer unhatchedQty = this.txtunhatchedEggQty.getIntegerValue();
		//    	unhatchedQty = (unhatchedQty == null ?new Integer(0):unhatchedQty);
		//    	
		//    	// 损耗
		//    	Integer lossQty = this.txtlossQty.getIntegerValue();
		//    	lossQty = (lossQty == null ?new Integer(0):lossQty);
		//    	
		//    	// 其他损耗
		//    	Integer otherlossQty = this.txtotherLossQty.getIntegerValue();
		//    	otherlossQty = (otherlossQty == null ?new Integer(0):otherlossQty);
		//    	
		//    	if(allTransQty != healthQty + deathQty + lossQty + otherlossQty + unhatchedQty){
		//			MsgBox.showInfo("健雏、残死雏、损耗、其他损耗和毛蛋之和与转箱量不相等");
		//			SysUtil.abort();
		//		}
		// 分录中  转箱量 必须等于  健雏、残死、损耗、毛蛋 数量之和
		//    	for(int i = 0 ; i < this.kdtEntrys.getRowCount(); i++){
		//    		Integer transQty = (Integer) this.kdtEntrys.getRow(i).getCell("transQty").getValue();
		//    		transQty = (transQty ==null?0:transQty);
		//    		Integer healthQty = (Integer) this.kdtEntrys.getRow(i).getCell("healthQty").getValue();
		//    		healthQty = (healthQty ==null?0:healthQty);
		//    		Integer dealthQty = (Integer) this.kdtEntrys.getRow(i).getCell("dealthQty").getValue();
		//    		dealthQty = (dealthQty ==null?0:dealthQty);
		//    		Integer lossQty = (Integer) this.kdtEntrys.getRow(i).getCell("lossQty").getValue();
		//    		lossQty = (lossQty ==null?0:lossQty);
		//    		Integer unhatchedEgg = (Integer) this.kdtEntrys.getRow(i).getCell("unhatchedEgg").getValue();
		//    		unhatchedEgg = (unhatchedEgg ==null?0:unhatchedEgg);
		//    		
		//    		
		//    		
		//    		if(transQty != healthQty + dealthQty + lossQty + unhatchedEgg){
		//    			MsgBox.showInfo("第" + (i+1) + "行分录中健雏、残死雏、损耗和毛蛋之和与转箱量不相等");
		//    			SysUtil.abort();
		//    		}else{
		//    			
		//    			
		//    		}
		//    	}
	}




	/**
	 * 校验当前组织是否是单据创建组织，如果不是，提示消息中断操作
	 */
	private void checkCanEdit(){
		StorageOrgUnitInfo cu = SysContext.getSysContext().getCurrentStorageUnit();
		CtrlUnitInfo billCU = this.editData.getCU();

		if(billCU != null){
			if(!cu.getId().toString().equals(billCU.getId().toString())){
				MsgBox.showWarning("当前组织不是单据创建组织，不能修改单据");
				SysUtil.abort();
			}
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
			lockUIForViewStatus();
			setShowMessagePolicy(0);
			setIsShowTextOnly(false);
			reloadData();
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
			this.btnEdit.setEnabled(true);
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.hatch.BHatchBabyBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}
	/**
	 * 设置默认值
	 */
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		super.applyDefaultValue(vo);
		vo.put("baseStatus",new Integer(1));

		vo.put("creator",(com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		vo.put("adminOrg", SysContext.getSysContext().getCurrentAdminUnit());
		vo.put("hatchFactory", hatchBaseInfo);
		if(hatchBaseInfo != null){
			//			vo.put("eggType", hatchBaseInfo.getDefaultEggType());
			//			vo.put("eggSourceType", hatchBaseInfo.getDefaultEggSourceType());
		}
		vo.put("bizDate", new Date());
		PersonInfo currPerson = SysContext.getSysContext().getCurrentUserInfo().getPerson();
		vo.put("operator",currPerson);
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.BHatchBabyBillInfo objectValue = new com.kingdee.eas.farm.hatch.BHatchBabyBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setAdminOrg(SysContext.getSysContext().getCurrentAdminUnit());
		objectValue.setBizDate(new Date());
		objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
		objectValue.setHatchFactory(hatchBaseInfo);
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub

		setEntryGenderTypeIsNotNull();
		super.beforeStoreFields(arg0);
		//		updateQtys();
	}
	/**
	 * 填充分录的品系字段---父母系
	 */
	private void setEntryGenderTypeIsNotNull() {
		// TODO Auto-generated method stub
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			//			if(kdtEntrys.getCell(rowIndex, "genderType").getValue()==null)
			//				kdtEntrys.getCell(rowIndex, "genderType").setValue(GenderType.Void);
		}

		for(int rowIndex=0;rowIndex<kdtSourceEntrys.getRowCount();rowIndex++) {
			//			if(kdtSourceEntrys.getCell(rowIndex, "genderType").getValue()==null)
			//				kdtSourceEntrys.getCell(rowIndex, "genderType").setValue(GenderType.Void);
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
	 * 表格【】  以amout，amt，qty结尾的字段添加合计行
	 * @param table
	 */
	public static void apendFootRow(KDTable table[]){
		ArrayList<String> columnName=new ArrayList<String>();
		for(int i=0;i<table.length;i++){
			columnName.clear();
			for(int j=0;j<table[i].getColumnCount();j++)
				if(table[i].getColumn(j).getKey().toLowerCase().contains("qty")
						||table[i].getColumn(j).getKey().toLowerCase().contains("amount")
						||table[i].getColumn(j).getKey().toLowerCase().contains("amt"))
					columnName.add(table[i].getColumn(j).getKey());
			apendFootRow(table[i], columnName.toArray(new String[columnName.size()]));
		}
	}
	/** 
	 * 功能：添加合计行 
	 *  
	 * @param table 
	 *            指定的KDTable 
	 * @param fields 
	 *            需要合计的列 
	 */  
	public static void apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
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
			sumValue.put(fields[i], new BigDecimal("0"));  
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
			if(row.getStyleAttributes().isHided())
				continue;
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
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

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			footRow.getCell(fields[i]).setValue(sumValue.get(fields[i]));  
		}  
	}

}