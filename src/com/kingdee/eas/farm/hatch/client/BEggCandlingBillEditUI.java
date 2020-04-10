/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import jxl.format.Orientation;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.data.engine.rows.impl.Row;
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
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierCollection;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.breed.HenhouseCollection;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.hatch.BEggCandlingBillCollection;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggTrayingBillCollection;
import com.kingdee.eas.farm.hatch.BEggTrayingBillFactory;
import com.kingdee.eas.farm.hatch.CandlingBillInputModelCollection;
import com.kingdee.eas.farm.hatch.CandlingBillInputModelFactory;
import com.kingdee.eas.farm.hatch.CandlingBillInputModelInfo;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.HatchBillTypeEnum;
import com.kingdee.eas.farm.hatch.HatchHouseFactory;
import com.kingdee.eas.farm.hatch.HatchHouseInfo;
import com.kingdee.eas.farm.hatch.HatchingBoxInfo;
import com.kingdee.eas.farm.hatch.IncubatorCollection;
import com.kingdee.eas.farm.hatch.IncubatorFactory;
import com.kingdee.eas.farm.hatch.IncubatorInfo;
import com.kingdee.eas.farm.hatch.QcEggTypeEnum;
import com.kingdee.eas.farm.hatch.hatchFacadeFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo;
import com.kingdee.eas.farm.stocking.basedata.QcEggType;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
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
public class BEggCandlingBillEditUI extends AbstractBEggCandlingBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BEggCandlingBillEditUI.class);

	StorageOrgUnitInfo currStoOrg;  // 当前库存组织
	HatchBaseDataInfo hatchBaseInfo;  // 当前孵化场

	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private List<String> CPMCol=new ArrayList<String>();
	BigDecimal [] coefficient=new BigDecimal[4];
	/**
	 * output class constructor
	 */
	public BEggCandlingBillEditUI() throws Exception
	{
		super();
		this.setUITitle("照蛋记录单");
		currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
		hatchBaseInfo = hatchFacadeFactory.getRemoteInstance().getHatchBaseData(currStoOrg);
		//		if(hatchBaseInfo==null){
		//			MsgBox.showInfo("当前未在任何孵化场，不能操作单据");
		//			//		        	this.getUIWindow().close();
		//			SysUtil.abort();
		//		}
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		this.setUITitle("照蛋记录单");
//		if(hatchBaseInfo == null){
//			MsgBox.showInfo("当前未在任何孵化场，不能操作照蛋记录单");
//			SysUtil.abort();
//		}



//		getCoefficient();
		setCellLocked();

		for(int i=0;i<kdtEggEntries.getRowCount();i++){
			if(kdtEggEntries.getCell(i, "diffEggQty").getValue()!=null)
				if(((Integer)kdtEggEntries.getCell(i, "diffEggQty").getValue())<0)
					kdtEggEntries.getCell(i, "diffEggQty").getStyleAttributes().setFontColor(Color.red);
				else
					kdtEggEntries.getCell(i, "diffEggQty").getStyleAttributes().setFontColor(Color.black);
		}




	}

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		((KDBizPromptBox)kdtEggEntries.getColumn("outBatch").getEditor().getComponent()).setDisplayFormat("$name$");
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return kdtEggEntries;
	}


	@Override
	public void onLoad() throws Exception {
		super.onLoad();

		
		
		kdtEggEntries.getColumn("rottenEggQty").getStyleAttributes().setHided(true);
		kdtEggEntries.getColumn("brokenEggQty").getStyleAttributes().setHided(true);
		kdtEggEntries.getColumn("rottenRate").getStyleAttributes().setHided(true);
		
		kdtEggEntries.getColumn("rottenEggQty").getStyleAttributes().setLocked(true);
		kdtEggEntries.getColumn("brokenEggQty").getStyleAttributes().setLocked(true);
		kdtEggEntries.getColumn("rottenRate").getStyleAttributes().setLocked(true);
		
		
		this.setUITitle("照蛋记录单");
		UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
		CandlingBillInputModelCollection coll = CandlingBillInputModelFactory.getRemoteInstance().getCandlingBillInputModelCollection("where user='"+userInfo.getString("id")+"'");
		
		cboxCPM.setSelected(false);

		btnSaveModel.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				CandlingBillInputModelInfo modelInfo;
				final UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
				try {
					boolean selected = cboxCPM.isSelected();
					CandlingBillInputModelCollection coll = CandlingBillInputModelFactory.getRemoteInstance().getCandlingBillInputModelCollection("where user='"+userInfo.getString("id")+"'");
					String userNum = userInfo.getNumber();
					String userName = userInfo.getName();
					CtrlUnitInfo ctrlUnitInfo = SysContext.getSysContext().getCurrentCtrlUnit();
					if(coll.size()>0){
						modelInfo=coll.get(0);
					}else{
						modelInfo=new CandlingBillInputModelInfo();
						modelInfo.setUser(userInfo);
						modelInfo.setNumber(userNum);
						modelInfo.setName(userName);
						modelInfo.setCU(ctrlUnitInfo);
					}
					modelInfo.setIsCFPM(selected);
					CandlingBillInputModelFactory.getRemoteInstance().save(modelInfo);
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});


		//初始化需要设置层盘枚的字段
		String [] cpmArray={"healthEggQty","noFertileEggQty","brokenYolkQty","addleEggQty","rottenEggQty","brokenEggQty"};
		CPMCol = Arrays.asList(cpmArray);


		//表格enter键焦点方向
		radioHorizon.setSelected(true);
		KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntries, Orientation.HORIZONTAL.getValue());





		btnSummary.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				updateSumPanel();
			}

		});

		radioHorizon.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioOrigin.setSelected(false);
				radioVertical.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntries, 0);
			}
		});

		radioOrigin.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioHorizon.setSelected(false);
				radioVertical.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntries, 2);
			}
		});


		radioVertical.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				radioOrigin.setSelected(false);
				radioHorizon.setSelected(false);
				KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntries, 1);
			}
		});
		kdtAreaSumEntry.getStyleAttributes().setLocked(true);
		kdtFarmerSumEntry.getStyleAttributes().setLocked(true);
		kdtAreaSumEntry_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtAreaSumEntry_detailPanel.getInsertLineButton().setEnabled(false);
		kdtAreaSumEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtFarmerSumEntry_detailPanel.getInsertLineButton().setEnabled(false);
		kdtFarmerSumEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtFarmerSumEntry_detailPanel.getAddNewLineButton().setEnabled(false);



		curStorageOrgUnitID=SysContext.getSysContext().getCurrentStorageUnit().getString("id");
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		new F7ContextManager(this, OrgType.Storage);
		// 校验组织 是否可编辑蛋卷--20190805 wzz注释
//		if(this.getOprtState().equals("ADDNEW") || this.getOprtState().equals("EDIT")){
//
//			if(currStoOrg == null){
//				MsgBox.showInfo("当前未在任何孵化场，不能操作照蛋记录单");
//				SysUtil.abort();
//			}
//
//
//			if(hatchBaseInfo == null){
//				MsgBox.showInfo("当前未在任何孵化场，不能操作照蛋记录单");
//				SysUtil.abort();
//			}
//
//		}
		// 初始化界面空间
		initUIComp();

		//20190503 macheng add 隐藏养殖户页签
		this.kDTabbedPane2.remove(kDPanel3);
		
		if(this.getOprtState().equals("EDIT")){
			checkCanEdit();

		}
		//		kdtEggEntries.getColumn("weekAge").getStyleAttributes().setLocked(false);
		//		kdtEggEntries.getColumn("dayAge").getStyleAttributes().setLocked(false);
	}
	/**
	 * 初始化UI界面组件
	 */
	private void  initUIComp(){
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		// 图标设置
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));

		this.btnTraceUp.setVisible(true);
		this.btnTraceDown.setVisible(true);
		// 设置查询F7
		this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchBaseDataQuery");
		this.prmthatchArea.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchAreaQuery");
		this.prmtincubator.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");

		//数字居右显示
		final KDTable [] table={kdtEggEntries,kdtAreaSumEntry,kdtFarmerSumEntry};
		for(int j=0;j<table.length;j++)
			for(int i=0;i<table[j].getColumnCount();i++)
				if(table[j].getColumn(i).getKey().indexOf("Qty")>=0||table[j].getColumn(i).getKey().indexOf("Rate")>=0)
					table[j].getColumn(i).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEggEntries.addKDTEditListener(new KDTEditAdapter() {
			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
				if(cboxCPM.isSelected())
					if(CPMCol.contains(kdtEggEntries.getColumnKey(e.getColIndex()))){
						setCengPanMei(e.getRowIndex(),e.getColIndex());
					}
			}

			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
					apendFootRow(new KDTable[] {kdtEggEntries});
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});
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
		this.kdtEggEntries.getColumn("outHouse").setEditor(kdtEntrys_material_CellEditor1);  
		this.kdtEggEntries.getColumn("outHouse").setRenderer(kdtEntrys_material_OVR1);

		this.kdtEggEntries_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent e)	throws Exception {
				//				addRowSetCellloced();
				setCellLocked();
			}

			public void beforeEvent(DetailPanelEvent e)	throws Exception {
				e.getObjectValue().setInt("eggSourceType", EggSourceType.SUBCONTRACT_VALUE);
			}});

		KDBizPromptBox kdtEntrys_material_PromptBox2 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox2.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
		kdtEntrys_material_PromptBox2.setVisible(true);
		kdtEntrys_material_PromptBox2.setEditable(true);
		kdtEntrys_material_PromptBox2.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox2.setEditFormat("$name$");
		kdtEntrys_material_PromptBox2.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor2 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox2);
		ObjectValueRender kdtEntrys_material_OVR2 = new ObjectValueRender();
		kdtEntrys_material_OVR2.setFormat(new BizDataFormat("$name$"));
		this.kdtEggEntries.getColumn("outArea").setEditor(kdtEntrys_material_CellEditor2);  
		this.kdtEggEntries.getColumn("outArea").setRenderer(kdtEntrys_material_OVR2);
	}

	//        this.prmtoutArea.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
	//        this.prmtoutArea.addDataChangeListener(new DataChangeListener(){
	//			public void dataChanged(DataChangeEvent arg0) {
	//				setAreaFilter();
	//			}});
	//	/**
	//	 * 设置分录区域过滤条件
	//	 */
	//	private void setAreaFilter() {
	//		String areaID="123";
	//		if(prmtoutArea.getValue()!=null) {
	//			areaID=((IPropertyContainer) prmtoutArea.getValue()).getString("id");
	//		}
	//		EntityViewInfo ev=new EntityViewInfo();
	//		FilterInfo filter=new FilterInfo();
	//		filter.getFilterItems().add(new FilterItemInfo("id",areaID,CompareType.EQUALS));
	//		ev.setFilter(filter);
	//		((KDBizPromptBox)kdtEggEntries.getColumn("outArea").getEditor().getComponent()).setEntityViewInfo(ev);
	//		setFarmerFilter();
	//	}
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
		//		setFarmerFilter();

	}
	private void  addRowSetCellloced() {
		//setCellLockedSinlgle(KDTableUtil.getSelectedRow(kdtEggEntries).getRowIndex());
	}
	//	/**
	//	 * 设置养殖场过滤条件
	//	 */
	//	private void setFarmerFilter() {
	//		String areaID="123";
	//		if(prmtoutArea.getValue()!=null) {
	//			areaID=((IPropertyContainer) prmtoutArea.getValue()).getString("id");
	//		}
	//		StockingClientComm.setFarmerFilterForHatch((KDBizPromptBox) kdtEggEntries.getColumn("farmer").getEditor().getComponent(), curCompanyID,areaID);
	//	}

	/**
	 * output kdtEntrys_Changed(int rowIndex,int colIndex) method
	 */
	public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
	{
		if(this.kdtEggEntries.getColumnKey(colIndex).equalsIgnoreCase("farmer")) {
			setFarmerInfo(rowIndex);
		}

		//出雏箱列复制功能
		if(rowIndex == 0){
			if(kdtEggEntries.getCell(rowIndex, "hatchsBox").getValue() != null){
				HatchingBoxInfo hatchInfo = (HatchingBoxInfo) kdtEggEntries.getCell(rowIndex, "hatchsBox").getValue();
				for(int i=0;i<kdtEggEntries.getRowCount();i++){
					kdtEggEntries.getCell(i, "hatchsBox").setValue(hatchInfo);
				}
			}
		}




		//根据合同和批次带出养殖户和农场
		if(kdtEggEntries.getColumn(colIndex).getKey().equals("outBatch")) {
			if(kdtEggEntries.getCell(rowIndex, "outBatch").getValue()!=null) {
				kdtEggEntries.getCell(rowIndex, "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEggEntries.getCell(rowIndex,"outBatch").getValue(), "farmer"));
				kdtEggEntries.getCell(rowIndex, "outFarm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEggEntries.getCell(rowIndex,"outBatch").getValue(), "farm"));
			}
		}
		if(kdtEggEntries.getColumn(colIndex).getKey().equals("hatchHouse")) {
			Object obj = kdtEggEntries.getCell(rowIndex, "hatchHouse").getValue();
			for(int i = 0; i < this.kdtEggEntries.getRowCount(); i++){
				if(this.kdtEggEntries.getCell(i,"hatchHouse").getValue() == null){
					this.kdtEggEntries.getCell(i,"hatchHouse").setValue(obj);
				}
			}
		}
		if(kdtEggEntries.getColumn(colIndex).getKey().equals("incubator")) {
			Object obj = kdtEggEntries.getCell(rowIndex, "incubator").getValue();
			for(int i = 0; i < this.kdtEggEntries.getRowCount(); i++){
				if(this.kdtEggEntries.getCell(i,"incubator").getValue() == null){
					this.kdtEggEntries.getCell(i,"incubator").setValue(obj);
				}
			}
		}
		if(kdtEggEntries.getColumn(colIndex).getKey().equals("eggSourceType")) {
			//setCellLockedSinlgle(rowIndex);
		}
		if(kdtEggEntries.getColumn(colIndex).getKey().equals("isMix")) {
			if(kdtEggEntries.getCell(rowIndex, "isMix").getValue().equals(true)) {
				kdtEggEntries.getCell(rowIndex, "farmer").setValue(null);
				kdtEggEntries.getCell(rowIndex, "outFarm").setValue(null);
				kdtEggEntries.getCell(rowIndex, "outHouse").setValue(null);
				kdtEggEntries.getCell(rowIndex, "outBatch").setValue(null);
			}
		}
		// 更新数量
		updateQtys();
	}

	/**
	 * 设置 外部养殖户信息
	 * @param rowIndex
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void setFarmerInfo(int rowIndex) throws EASBizException, BOSException{
		IRow currRow = this.kdtEggEntries.getRow(rowIndex);
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
	 * 更新数量
	 */
	private void updateQtys(){
		int allTransQty = 0;
		int allHealthQty = 0;
		int allNofertileQty = 0;
		int allRottenQty = 0;
		int allAddleQty = 0;
		int allOtherLossQty = 0;
		int allBrokenQty = 0;
		int allBrokenYolkQty = 0;
		int diffEggQty=0;


		// 逐行统计
		for(int i = 0; i < this.kdtEggEntries.getRowCount(); i++){
			IRow row = this.kdtEggEntries.getRow(i);
			//上孵数量
			int transQty = (Integer)row.getCell("eggQty").getValue();
			//无精蛋
			int noFertileEggQty = (Integer)row.getCell("noFertileEggQty").getValue();//白蛋
			//死精蛋
			int addleEggQty = (Integer)row.getCell("addleEggQty").getValue();
			int brokenEggQty = (Integer)row.getCell("brokenEggQty").getValue();//破损
			//臭蛋
			int rottenEggQty = (Integer)row.getCell("rottenEggQty").getValue();//臭蛋
			int otherEggQty = (Integer)row.getCell("otherEggQty").getValue();

			int brokenYolkQty = (Integer)row.getCell("brokenYolkQty").getValue();

			//亏损数
			BigDecimal lostQtyD = (BigDecimal)row.getCell("lossQty").getValue();
			int  lostQty = 0;
			if(lostQtyD == null){
				lostQty = 0;
			}
			else{
				lostQty = lostQtyD.intValue();
			}
			// 计算 受精蛋 
			int healthEggQty = transQty-noFertileEggQty-addleEggQty-brokenEggQty-rottenEggQty-otherEggQty-brokenYolkQty-lostQty;


			//计算活胚率
			BigDecimal liveEggRate = new BigDecimal("0");
			if(transQty > 0){
				liveEggRate = (new BigDecimal(healthEggQty)).divide(new BigDecimal(transQty),4,RoundingMode.HALF_UP);
				liveEggRate = liveEggRate.multiply(new BigDecimal(100));
			}

			row.getCell("liveEggRate").setValue(liveEggRate);


			//受精率=上孵数量-无精蛋-臭蛋
			BigDecimal fertilityRate = new BigDecimal("0");
			if(transQty > 0){
				fertilityRate = (new BigDecimal(transQty-noFertileEggQty-rottenEggQty)).divide(new BigDecimal(transQty),4,RoundingMode.HALF_UP);
				fertilityRate = fertilityRate.multiply(new BigDecimal(100));
			}

			//无精蛋率= 无精蛋/上孵总数
			BigDecimal noFertileEggRate = new BigDecimal("0");
			if(transQty > 0){
				noFertileEggRate = ( new BigDecimal(noFertileEggQty)).divide(new BigDecimal(transQty),4,RoundingMode.HALF_UP);
				noFertileEggRate = noFertileEggRate.multiply(new BigDecimal(100));

			}

			//计算死胚率
			BigDecimal addleEggRate = new BigDecimal("0");
			if(transQty > 0){
				addleEggRate = (new BigDecimal(addleEggQty)).divide(new BigDecimal(transQty),4,RoundingMode.HALF_UP);
				addleEggRate = addleEggRate.multiply(new BigDecimal(100));
			}


			//计算破损率
			BigDecimal psEggRate = new BigDecimal("0");
			if(transQty > 0){
				psEggRate = (new BigDecimal(brokenEggQty)).divide(new BigDecimal(transQty),4,RoundingMode.HALF_UP);
				psEggRate = psEggRate.multiply(new BigDecimal(100));
			}
			//计算臭蛋率
			BigDecimal cdEggRate = new BigDecimal("0");
			if(transQty > 0){
				cdEggRate = (new BigDecimal(rottenEggQty)).divide(new BigDecimal(transQty),4,RoundingMode.HALF_UP);
				cdEggRate = cdEggRate.multiply(new BigDecimal(100));
			}
			row.getCell("brokenRate").setValue(psEggRate);
			row.getCell("rottenRate").setValue(cdEggRate);

			//计算无精蛋率
			row.getCell("noFertileEggRate").setValue(noFertileEggRate);

			row.getCell("fertilityRate").setValue(fertilityRate);
			//照盘活胚
			row.getCell("healthEggQty").setValue(healthEggQty);
			//落盘活胚
			row.getCell("lphealthEggQty").setValue(healthEggQty);

			row.getCell("addleEggRate").setValue(addleEggRate);
			healthEggQty=(Integer)row.getCell("healthEggQty").getValue();
			//计算差异数
			diffEggQty=transQty-healthEggQty-noFertileEggQty-brokenYolkQty-addleEggQty-rottenEggQty-otherEggQty-brokenYolkQty-lostQty;
			row.getCell("diffEggQty").setValue(diffEggQty);
			if(diffEggQty<0)
				row.getCell("diffEggQty").getStyleAttributes().setFontColor(Color.red);
			else
				row.getCell("diffEggQty").getStyleAttributes().setFontColor(Color.black);
			allHealthQty = allHealthQty+healthEggQty;
			allTransQty = allTransQty + transQty;
			allNofertileQty = allNofertileQty + noFertileEggQty;
			allRottenQty  = allRottenQty + rottenEggQty;
			allAddleQty = allAddleQty + addleEggQty;
			allOtherLossQty = allOtherLossQty + otherEggQty;
			allBrokenQty = allBrokenQty + brokenEggQty;
			allBrokenYolkQty = allBrokenYolkQty + brokenYolkQty;
		}

		this.txtallAddleEggQty.setValue(allAddleQty);
		this.txtallBrokenEggQty.setValue(allBrokenQty);
		this.txtallHatchEggQty.setValue(allTransQty);
		this.txtallHealthEggQty.setValue(allHealthQty);
		this.txtallNoFertileEggQty.setValue(allNofertileQty);
		this.txtallRottenEggQty.setValue(allRottenQty);
		this.txtotherLoss.setValue(allOtherLossQty);

		this.txtbrokenEggQty.setValue(allBrokenYolkQty);

		BigDecimal fertilityRate = new BigDecimal("0");
		if(allTransQty > 0){
			fertilityRate = (new BigDecimal(allHealthQty)).divide(new BigDecimal(allTransQty),4,RoundingMode.HALF_UP);
			fertilityRate = fertilityRate.multiply(new BigDecimal(100));
		}
		this.txtfertilityRate.setValue(fertilityRate);
	}
	/**
	 * 设置鸡舍过滤条件
	 */
	private void setHenhouseFilter(StorageOrgUnitInfo cuInfo ){

	}

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		reloadData();
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
		super.actionEdit_actionPerformed(arg0);
		kdtAreaSumEntry_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtAreaSumEntry_detailPanel.getInsertLineButton().setEnabled(false);
		kdtAreaSumEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtFarmerSumEntry_detailPanel.getInsertLineButton().setEnabled(false);
		kdtFarmerSumEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtFarmerSumEntry_detailPanel.getAddNewLineButton().setEnabled(false);
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
		return com.kingdee.eas.farm.hatch.BEggCandlingBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.hatch.BEggCandlingBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggCandlingBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setHatchFactory(hatchBaseInfo);
		objectValue.setBizDate(new Date());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}
	private void setCellLocked() {
		for(int rowIndex=0;rowIndex<kdtEggEntries.getRowCount();rowIndex++) {
			//setCellLockedSinlgle(rowIndex);
		}
	}
	private void setCellLockedSinlgle(int rowIndex) {
		if(rowIndex<0) {
			return;
		}
		kdtEggEntries.getCell(rowIndex,"farmer").getStyleAttributes().setHided(true);
		
		if(kdtEggEntries.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.SubContract)||kdtEggEntries.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.InternalFarm)) {
			kdtEggEntries.getCell(rowIndex,"supplier").setValue(null);
			kdtEggEntries.getCell(rowIndex,"material").setValue(null);
			kdtEggEntries.getCell(rowIndex,"eggLog").setValue(null);

			kdtEggEntries.getCell(rowIndex,"isMix").getStyleAttributes().setLocked(false);
			kdtEggEntries.getCell(rowIndex,"outArea").getStyleAttributes().setLocked(false);
			kdtEggEntries.getCell(rowIndex,"farmer").getStyleAttributes().setLocked(false);
			kdtEggEntries.getCell(rowIndex,"outHouse").getStyleAttributes().setLocked(false);
			kdtEggEntries.getCell(rowIndex,"outBatch").getStyleAttributes().setLocked(false);
			kdtEggEntries.getCell(rowIndex,"outFarm").getStyleAttributes().setLocked(false);
			kdtEggEntries.getCell(rowIndex,"supplier").getStyleAttributes().setLocked(true);
			kdtEggEntries.getCell(rowIndex,"material").getStyleAttributes().setLocked(true);
			kdtEggEntries.getCell(rowIndex,"eggLog").getStyleAttributes().setLocked(true);
			
			
		} if(kdtEggEntries.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.Purchase)) {
			kdtEggEntries.getCell(rowIndex,"isMix").setValue(false);
			kdtEggEntries.getCell(rowIndex,"outArea").setValue(null);
			kdtEggEntries.getCell(rowIndex,"farmer").setValue(null);
			kdtEggEntries.getCell(rowIndex,"outFarm").setValue(null);
			kdtEggEntries.getCell(rowIndex,"outHouse").setValue(null);
			kdtEggEntries.getCell(rowIndex,"outBatch").setValue(null);

			kdtEggEntries.getCell(rowIndex,"isMix").getStyleAttributes().setLocked(true);
			kdtEggEntries.getCell(rowIndex,"outArea").getStyleAttributes().setLocked(true);
			kdtEggEntries.getCell(rowIndex,"farmer").getStyleAttributes().setLocked(true);
			kdtEggEntries.getCell(rowIndex,"outHouse").getStyleAttributes().setLocked(true);
			kdtEggEntries.getCell(rowIndex,"outBatch").getStyleAttributes().setLocked(true);
			kdtEggEntries.getCell(rowIndex,"outFarm").getStyleAttributes().setLocked(true);
			kdtEggEntries.getCell(rowIndex,"supplier").getStyleAttributes().setLocked(false);
			kdtEggEntries.getCell(rowIndex,"material").getStyleAttributes().setLocked(false);
			kdtEggEntries.getCell(rowIndex,"eggLog").getStyleAttributes().setLocked(false);
			
			
		}
		//		if(kdtEggEntries.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.InternalFarm)) {
		//			kdtEggEntries.getCell(rowIndex,"supplier").setValue(null);
		//			kdtEggEntries.getCell(rowIndex,"material").setValue(null);
		//			kdtEggEntries.getCell(rowIndex,"eggLog").setValue(null);
		//			kdtEggEntries.getCell(rowIndex,"outArea").setValue(null);
		//			kdtEggEntries.getCell(rowIndex,"farmer").setValue(null);
		//			kdtEggEntries.getCell(rowIndex,"outFarm").setValue(null);
		//			kdtEggEntries.getCell(rowIndex,"outHouse").setValue(null);
		//			kdtEggEntries.getCell(rowIndex,"outBatch").setValue(null);
		//
		//			kdtEggEntries.getCell(rowIndex,"isMix").getStyleAttributes().setLocked(true);
		//			kdtEggEntries.getCell(rowIndex,"outArea").getStyleAttributes().setLocked(true);
		//			kdtEggEntries.getCell(rowIndex,"farmer").getStyleAttributes().setLocked(true);
		//			kdtEggEntries.getCell(rowIndex,"outHouse").getStyleAttributes().setLocked(true);
		//			kdtEggEntries.getCell(rowIndex,"outBatch").getStyleAttributes().setLocked(true);
		//			kdtEggEntries.getCell(rowIndex,"outFarm").getStyleAttributes().setLocked(true);
		//			kdtEggEntries.getCell(rowIndex,"supplier").getStyleAttributes().setLocked(true);
		//			kdtEggEntries.getCell(rowIndex,"material").getStyleAttributes().setLocked(true);
		//			kdtEggEntries.getCell(rowIndex,"eggLog").getStyleAttributes().setLocked(true);
		//		}
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
		String key=this.kdtEggEntries.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("outFarm")||key.equals("outBatch")||key.equals("outHouse")) {
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEggEntries.getColumn("outFarm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEggEntries.getColumn("outBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtEggEntries.getCell(rowIndex, "outBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEggEntries.getCell(rowIndex, "outBatch").getValue()).getString("id");
			}
			if(this.kdtEggEntries.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEggEntries.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEggEntries.getCell(rowIndex, "outFarm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEggEntries.getCell(rowIndex, "outFarm").getValue()).getString("id");
			}
			if(this.kdtEggEntries.getCell(rowIndex, "outHouse").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEggEntries.getCell(rowIndex, "outHouse").getValue()).getString("id");
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
			((KDBizPromptBox)this.kdtEggEntries.getColumn("outHouse").getEditor().getComponent()).setEntityViewInfo(ev);
		}
		if(key.equals("outArea")) {	
			if(kdtEggEntries.getCell(rowIndex, "isMix").getValue().equals(true)) {
				//				kdtEggEntries.getCell(rowIndex, "outArea").getStyleAttributes().setLocked(true);
				//				e.setCancel(true);
			}else{
				//				kdtEggEntries.getCell(rowIndex, "outArea").getStyleAttributes().setLocked(false);
			}
		}
	}

	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub、

		for(int rowIndex=0;rowIndex<kdtEggEntries.getRowCount();rowIndex++) {
			//if(kdtEggEntries.getCell(rowIndex, "genderType").getValue()==null)
			//kdtEggEntries.getCell(rowIndex, "genderType").setValue(GenderType.Void);
		}

		//校验照蛋明细记录中的出雏箱不能为空
		checkCandingNull();


		super.beforeStoreFields(arg0);
		for(int rowIndex=0;rowIndex<kdtEggEntries.getRowCount();rowIndex++) {
			if(kdtEggEntries.getCell(rowIndex, "isMix").getValue().equals(false)&&kdtEggEntries.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.SubContract)) {
				if(kdtEggEntries.getCell(rowIndex, "outBatch").getValue()==null) {
					MsgBox.showWarning("第"+(rowIndex+1)+"行分录，养殖批次不能为空！");
					SysUtil.abort();
				}
				if(kdtEggEntries.getCell(rowIndex, "outFarm").getValue()!=null&&(Boolean)UIRuleUtil.getProperty((IObjectValue) kdtEggEntries.getCell(rowIndex, "outFarm").getValue(), "isHouseManager")&&kdtEggEntries.getCell(rowIndex, "outHouse").getValue()==null) {
					MsgBox.showWarning("第"+(rowIndex+1)+"行分录，养殖场启用棚舍管理，棚舍不能为空！");
					SysUtil.abort();
				}
			}
			else if(kdtEggEntries.getCell(rowIndex, "eggSourceType").getValue().equals(EggSourceType.Purchase)&&kdtEggEntries.getCell(rowIndex, "supplier").getValue()==null) {
				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，供应商不能为空！");
				SysUtil.abort();
			}
		}
		updateSumPanel();
		updateQtys();
	}

	/**
	 * 校验照蛋明细记录中的出雏箱不能为空
	 */
	private void checkCandingNull() {
		// TODO Auto-generated method stub

//		for(int i=0,size=kdtEggEntries.getRowCount();i<size;i++){
//
//			if(kdtEggEntries.getCell(i,"hatchsBox").getValue() == null){
//				int k=i+1;
//				MsgBox.showWarning("照蛋明细分录第"+k+"行的出雏箱不能为空！");
//				SysUtil.abort();
//			}
//		}
	}
	/**
	 * 计算汇总页签的数据
	 */
	private void updateSumPanel() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		TreeMap<String, Integer[]> outArea=new TreeMap<String, Integer[]>();

		//片区汇总
		String outArea_eggType="";

		for(int i=0;i<kdtEggEntries.getRowCount();i++){
			outArea_eggType="";
			Integer[] egg=new Integer[8];
			//
			egg[0]=kdtEggEntries.getCell(i, "eggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "eggQty").getValue());
			egg[1]=kdtEggEntries.getCell(i, "healthEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "healthEggQty").getValue());
			egg[2]=kdtEggEntries.getCell(i, "noFertileEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "noFertileEggQty").getValue());
			egg[3]=kdtEggEntries.getCell(i, "brokenYolkQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "brokenYolkQty").getValue());
			egg[4]=kdtEggEntries.getCell(i, "addleEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "addleEggQty").getValue());
			egg[5]=kdtEggEntries.getCell(i, "brokenEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "brokenEggQty").getValue());
			egg[6]=kdtEggEntries.getCell(i, "rottenEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "rottenEggQty").getValue());
			egg[7]=kdtEggEntries.getCell(i, "diffEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "diffEggQty").getValue());
			//egg[8]=kdtEggEntries.getCell(i, "lossQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "lossQty").getValue());

			if(kdtEggEntries.getCell(i, "outArea").getValue()!=null)
				outArea_eggType+=((FarmersTreeInfo)kdtEggEntries.getCell(i, "outArea").getValue()).getLongNumber();
			else if(kdtEggEntries.getCell(i, "supplier").getValue()!=null)
				outArea_eggType+=((SupplierInfo)kdtEggEntries.getCell(i, "supplier").getValue()).getString("id");
			outArea_eggType+="_";
			if(kdtEggEntries.getCell(i, "qcEggType").getValue()!=null)
				outArea_eggType+=((QcEggTypeEnum)kdtEggEntries.getCell(i, "qcEggType").getValue()).getValue();

			if(outArea.containsKey(outArea_eggType)){
				egg[0]+=outArea.get(outArea_eggType)[0];
				egg[1]+=outArea.get(outArea_eggType)[1];
				egg[2]+=outArea.get(outArea_eggType)[2];
				egg[3]+=outArea.get(outArea_eggType)[3];
				egg[4]+=outArea.get(outArea_eggType)[4];
				egg[5]+=outArea.get(outArea_eggType)[5];
				egg[6]+=outArea.get(outArea_eggType)[6];
				egg[7]+=outArea.get(outArea_eggType)[7];
				//egg[8]+=outArea.get(outArea_eggType)[8];
				outArea.put(outArea_eggType, egg);
			}
			else
				outArea.put(outArea_eggType, egg);
		}

		kdtAreaSumEntry.removeRows();
		FarmersTreeCollection collFarmerTree;
		Iterator<Map.Entry<String, Integer[]>> entriess = outArea.entrySet().iterator();
		while (entriess.hasNext()) { 
			Entry<String, Integer[]> entry = entriess.next();
			kdtAreaSumEntry.addRow();
			//try {
				String[] value = entry.getKey().split("_");
//				if(value[0]!=null&&!value[0].equals("")){
//					collFarmerTree=FarmersTreeFactory.getRemoteInstance().getFarmersTreeCollection("where longNumber='"+value[0]+"'");
//					if(collFarmerTree.size()>0)
//						kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "outArea").setValue(collFarmerTree.get(0));
//					else if(SupplierFactory.getRemoteInstance().getSupplierCollection("where id='"+value[0]+"'").size()>0)
//						kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "supplier").setValue(SupplierFactory.getRemoteInstance().getSupplierCollection("where id='"+value[0]+"'").get(0));
//				}
//				if(value[1]!=null&&!value[1].equals("")){
//					kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "qcEggType").setValue(QcEggTypeEnum.getEnum(Integer.parseInt(value[1])));
//				}
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "eggQty").setValue(entry.getValue()[0]);
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "healthEggQty").setValue(entry.getValue()[1]);
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "noFertileEggQty").setValue(entry.getValue()[2]);
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "brokenYolkQty").setValue(entry.getValue()[3]);
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "addleEggQty").setValue(entry.getValue()[4]);
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "brokenEggQty").setValue(entry.getValue()[5]);
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "rottenEggQty").setValue(entry.getValue()[6]);
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "diffEggQty").setValue(entry.getValue()[7]);
				//kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "diffEggQty").setValue(entry.getValue()[8]);

				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "fertilityRate").setValue(entry.getValue()[0]==0?BigDecimal.ZERO:(new BigDecimal(entry.getValue()[1])).divide(new BigDecimal(entry.getValue()[0]),4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)));
				kdtAreaSumEntry.getCell(kdtAreaSumEntry.getRowCount()-1, "addleEggRate").setValue(entry.getValue()[0]==0?BigDecimal.ZERO:(new BigDecimal(entry.getValue()[4])).divide(new BigDecimal(entry.getValue()[0]),4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)));

		} 

		TreeMap<String, Integer[]> farmer=new TreeMap<String, Integer[]>();

		//养殖户汇总
		String farmer_house="";

//		for(int i=0;i<kdtEggEntries.getRowCount();i++){
//			farmer_house="";
//			Integer[] egg=new Integer[8];
//			//
//			egg[0]=kdtEggEntries.getCell(i, "eggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "eggQty").getValue());
//			egg[1]=kdtEggEntries.getCell(i, "healthEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "healthEggQty").getValue());
//			egg[2]=kdtEggEntries.getCell(i, "noFertileEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "noFertileEggQty").getValue());
//			egg[3]=kdtEggEntries.getCell(i, "brokenYolkQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "brokenYolkQty").getValue());
//			egg[4]=kdtEggEntries.getCell(i, "addleEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "addleEggQty").getValue());
//			egg[5]=kdtEggEntries.getCell(i, "brokenEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "brokenEggQty").getValue());
//			egg[6]=kdtEggEntries.getCell(i, "rottenEggQty").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "rottenEggQty").getValue());
//			//egg[7]=kdtEggEntries.getCell(i, "diffEggQty").getValue()==null?0:(new BigDecimal(kdtEggEntries.getCell(i, "lossQty").getValue().toString()).intValue());
//
//			//1027
//			//egg[8]=kdtEggEntries.getCell(i, "qcEggType").getValue()==null?0:((Integer)kdtEggEntries.getCell(i, "qcEggType").getValue());
//
//			if(kdtEggEntries.getCell(i, "farmer").getValue()!=null)
//				farmer_house+=((FarmersInfo)kdtEggEntries.getCell(i, "farmer").getValue()).getNumber();
//			farmer_house+="_";
//			if(kdtEggEntries.getCell(i, "outHouse").getValue()!=null)
//				farmer_house+=((FarmHouseEntryInfo)kdtEggEntries.getCell(i, "outHouse").getValue()).getNumber();
//			//1027 yumingxu
//			farmer_house+="_";
//			if(kdtEggEntries.getCell(i, "supplier").getValue()!=null)
//				farmer_house+=((SupplierInfo)kdtEggEntries.getCell(i, "supplier").getValue()).getNumber();
//			farmer_house+="_";
//			if(kdtEggEntries.getCell(i, "qcEggType").getValue()!=null)
//				farmer_house+=((QcEggTypeEnum)kdtEggEntries.getCell(i, "qcEggType").getValue()).toString();
//
//			if(farmer.containsKey(farmer_house)){
//				egg[0]+=farmer.get(farmer_house)[0];
//				egg[1]+=farmer.get(farmer_house)[1];
//				egg[2]+=farmer.get(farmer_house)[2];
//				egg[3]+=farmer.get(farmer_house)[3];
//				egg[4]+=farmer.get(farmer_house)[4];
//				egg[5]+=farmer.get(farmer_house)[5];
//				egg[6]+=farmer.get(farmer_house)[6];
//				egg[7]+=farmer.get(farmer_house)[7];
//				//1027
//				//egg[8]+=farmer.get(farmer_house)[7];
//				farmer.put(farmer_house, egg);
//			}
//			else
//				farmer.put(farmer_house, egg);
//		}

		kdtFarmerSumEntry.removeRows();
		FarmersCollection collFarmers;
		FarmHouseEntryCollection collHenHouse;
		SupplierCollection collsupplier;
		Iterator<Map.Entry<String, Integer[]>> entrys = farmer.entrySet().iterator();
		while (entrys.hasNext()) { 
			Entry<String, Integer[]> entry = entrys.next();
			kdtFarmerSumEntry.addRow();
			try {
				String[] value = entry.getKey().split("_");
				if(value.length>0){
					if((value.length==4&&value[0]!=null&&!value[0].equals(""))
							||(value.length==4&&(entry.getKey().indexOf("_")>0))){
						collFarmers=FarmersFactory.getRemoteInstance().getFarmersCollection("where number='"+value[0]+"'");
						if(collFarmers.size()>0)
							kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "farmer").setValue(collFarmers.get(0));
					}
					if((value.length==4&&value[1]!=null&&!value[1].equals(""))
							||(value.length==4&&(entry.getKey().indexOf("_")==0))){
						collHenHouse=FarmHouseEntryFactory.getRemoteInstance().getFarmHouseEntryCollection("where number='"+value[1]+"'");
						if(collHenHouse.size()>0)
							kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "house").setValue(collHenHouse.get(0));
					}
					//1027 yumingxu
					if((value.length==4&&value[2]!=null&&!value[2].equals(""))
							||(value.length==4&&(entry.getKey().indexOf("_")==0))){
						collsupplier=SupplierFactory.getRemoteInstance().getSupplierCollection("where number='"+value[2]+"'");
						if(collsupplier.size()>0)
							kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "supploer1").setValue(collsupplier.get(0));
					}
					if((value.length==4&&value[3]!=null&&!value[3].equals(""))
							||(value.length==4&&(entry.getKey().indexOf("_")==0))){
						//collsupplier=SupplierFactory.getRemoteInstance().getSupplierCollection("where number='"+value[1]+"'");
						//if(collsupplier.size()>0)
						kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "hgdlx").setValue(value[3]);
					}

				}
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "eggQty").setValue(entry.getValue()[0]);
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "healthEggQty").setValue(entry.getValue()[1]);
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "noFertileEggQty").setValue(entry.getValue()[2]);
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "brokenYolkQty").setValue(entry.getValue()[3]);
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "addleEggQty").setValue(entry.getValue()[4]);
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "brokenEggQty").setValue(entry.getValue()[5]);
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "rottenEggQty").setValue(entry.getValue()[6]);
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "diffEggQty").setValue(entry.getValue()[7]);
				//1027
				//kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "hgdlx").setValue(entry.getValue()[8]);
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "brokenRate").setValue(entry.getValue()[0]==0?BigDecimal.ZERO:(new BigDecimal(entry.getValue()[5])).divide(new BigDecimal(entry.getValue()[0]),4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)));
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "rottenRate").setValue(entry.getValue()[0]==0?BigDecimal.ZERO:(new BigDecimal(entry.getValue()[6])).divide(new BigDecimal(entry.getValue()[0]),4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)));

				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "fertilityRate").setValue(entry.getValue()[0]==0?BigDecimal.ZERO:(new BigDecimal(entry.getValue()[1])).divide(new BigDecimal(entry.getValue()[0]),4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)));
				kdtFarmerSumEntry.getCell(kdtFarmerSumEntry.getRowCount()-1, "addleEggRate").setValue(entry.getValue()[0]==0?BigDecimal.ZERO:(new BigDecimal(entry.getValue()[4])).divide(new BigDecimal(entry.getValue()[0]),4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)));

			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
	@Override
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCreateTo_actionPerformed(e);
		//如果生成了落盘单据，则反写字段
		if(editData.getId()==null)
			return;

		String sql="select * from T_BOT_Relation where FSrcObjectID='"+editData.getId().toString()+"' and FDestEntityID='92957B02' order by FDate desc";
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(rs.size()>0){
			if(rs.next()){
				BEggTrayingBillCollection  collBEggTraying= BEggTrayingBillFactory.getRemoteInstance().getBEggTrayingBillCollection("where id='"+rs.getString("FDestObjectID")+"'");
				if(collBEggTraying.size()>0){
					String str = "update CT_FM_BEggCandlingBill set FIsTraying=1";
					if(collBEggTraying.get(0).getBizDate()!=null)
						str+=",FTrayingDate={ts '"+sdf.format(collBEggTraying.get(0).getBizDate())+"'}";
					str+=" where  fid ='"+editData.getString("id")+"'";
					hatchFacadeFactory.getRemoteInstance().excuteSql(str);
				}
			}
		}
		refreshCurPage();
	}  
	/**
	 * output actionSubmit_actionPerformed
	 * 刷新操作
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
	@Override
	public void actionAdjust_actionPerformed(ActionEvent e) throws Exception {	
		if(UIRuleUtil.isNull(editData.getString("id"))||!editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
			commUtils.giveUserTipsAndRetire("单据尚未保存或审核");
		HashMap<Object, Object> hashMap=new HashMap<Object, Object>();
		hashMap.put("srcBillType",HatchBillTypeEnum.candlingBill);
		hashMap.put("srcBill", editData);
		ClientUtils.openChildUIFromParentUI(UIFactoryName.NEWWIN, "com.kingdee.eas.farm.hatch.client.HatchAdjustBillEditUI", hashMap, null, OprtState.ADDNEW);
		super.actionAdjust_actionPerformed(e);
	}  
	private void setCengPanMei(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("ui", this);
		map.put("rowIndex", rowIndex);
		map.put("colIndex", colIndex);
		map.put("oldValues", UIRuleUtil.getInt(kdtEggEntries.getCell(rowIndex, colIndex).getValue()));
		if(coefficient.toString().length()==0)
			return;
		map.put("coefficient",coefficient);
		ClientUtils.openChildUIFromParentUI(UIFactoryName.MODEL, "com.kingdee.eas.farm.hatch.client.CountUI", map, null, OprtState.ADDNEW);	
		//		Robot robot;
		//		try {
		//			robot = new Robot();
		//			robot.keyPress(KeyEvent.VK_ENTER);
		//		} catch (AWTException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	}
	/**
	 * 获取照蛋的换算系数
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
		.append("where t1.CFBillType=1").append("\n");
		String str=sb.toString();

		HatchBaseDataInfo hatchAreaInfo =(HatchBaseDataInfo) prmthatchFactory.getValue();
		sb2.setLength(0);
		sb2.append(str);
		sb2.append(" and t5.FID='").append(hatchAreaInfo.getString("id")).append("'");
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
	@Override
	protected void setTableToSumField() {
		// TODO Auto-generated method stub
		super.setTableToSumField();
		setTableToSumField(kdtEggEntries,new String[]{"eggQty","healthEggQty","noFertileEggQty","brokenYolkQty","addleEggQty","brokenEggQty","rottenEggQty","diffEggQty"});
	}
	@Override
	protected void setTableToSumField(KDTable arg0, String[] arg1) {
		// TODO Auto-generated method stub
		super.setTableToSumField(arg0, arg1);
	}

}