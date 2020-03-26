/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

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
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.bot.IBOTRelation;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.custom.commonld.ICommFacade;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingCollection;
import com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingFactory;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCollection;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory;
import com.kingdee.eas.farm.stocking.hatch.IEggSettleBill;
import com.kingdee.eas.farm.stocking.hatch.StatisticsType;
import com.kingdee.eas.farm.stocking.hatch.StockingHatchFacadeFactory;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.KDTableUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class EggReceiveBillEditUI extends AbstractEggReceiveBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(EggReceiveBillEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private boolean isLoadField=false;
	private BaseSysSettingInfo sysSetting;
	private MeasureUnitInfo unitNum,unitKG,unitG;
	protected Color colrWht=new Color(255,255,255);
	protected Color colrYel =new Color(235,251,179);
	protected Color colrZs=new Color(211,198,232);
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private HatchBaseDataInfo hbInfo=null;//孵化场设置

	private ICTable icTable;
	private LinkedList<HashMap<String, Object>> rowCountAndDefalutValue=new LinkedList<HashMap<String,Object>>();

	/**
	 * output class constructor
	 */
	public EggReceiveBillEditUI() throws Exception
	{
		super();
		//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setUITitle("种蛋挑选表");
	}

	public void loadFields()
	{
		isLoadField=true;
		super.loadFields(); 
		isLoadField=false;
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else if(this.editData.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)){
			this.actionSubmit.setEnabled(true);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
		setColHide();
		setEntryRowColor();
		setMerger();
		apendFootRow(kdtEntrys, new String[]{"allQty","effectAllQty","brokenQty","qc1lv1Qty","qc1lv2Qty","qc2lv1Qty","qc2lv2Qty","qc3lv1Qty","qc4lv1Qty","qc5lv2Qty","qc6lv2Qty","greensQty","dirtyQty","doubleQty","mutantQty","brokenSingeQty","flowQty","brokenDoubleQty","tinyEggQty"});
		kdtEntrys.getColumn("qc1lv1Qty").getStyleAttributes().setNumberFormat("%r{0.000}f");
		hbInfo=StockingComm.getHatchBaseDataByOrgID(null, prmtstorageOrgUnit.getValue()==null?curStorageOrgUnitID:((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id"));

		//仓库
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id", prmtstorageOrgUnit.getValue()==null?curStorageOrgUnitID:((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id"),CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);

		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getCell(i, "settleBillID").getValue()!=null)
				kdtEntrys.getRow(i).getStyleAttributes().setLocked(true);
		}
	}


	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		beforeSubmit();
		super.actionSubmit_actionPerformed(e);
		afterStoreFileds();
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

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
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		this.actionSubmit.setEnabled(true);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		try {
			objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID)));
			objectValue.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return objectValue;
	}


	public void onLoad() throws Exception {
		// TODO Auto-generated method stub

		UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
		EggReceiveBillColorSettingCollection coll = EggReceiveBillColorSettingFactory.getRemoteInstance().getEggReceiveBillColorSettingCollection("where user='"+userInfo.getString("id")+"'");
		if(coll.size()>0){
			colrYel=new Color(coll.get(0).getWgtR(),coll.get(0).getWgtG(),coll.get(0).getWgtB());
			colrZs=new Color(coll.get(0).getAvgWgtR(),coll.get(0).getAvgWgtG(),coll.get(0).getAvgWgtB());
			colrWht=new Color(coll.get(0).getMeiQtyR(),coll.get(0).getMeiQtyG(),coll.get(0).getMeiQtyB());
		}



		toSettleBill.setVisible(false);
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}

		curStorageOrgUnitID=sysSetting.getDefaultStorageOrgUnit().getString("id");
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		IMeasureUnit ius = MeasureUnitFactory.getRemoteInstance();
		unitNum=ius.getMeasureUnitInfo(new ObjectUuidPK("lwwAAAAANDxbglxX"));
		unitKG=ius.getMeasureUnitInfo(new ObjectUuidPK("gw5fUwEOEADgAAsRwKgSOFuCXFc="));
		unitG=ius.getMeasureUnitInfo(new ObjectUuidPK("gw5fUwEOEADgAAsNwKgSOFuCXFc="));
		super.onLoad();
		initControl();
		//初始化合并表格
		icTable=new ICTable();
		icTable.setTable(kdtEntrys);
		icTable.setSingleMerageCols(new String[]{"internalFarm","internalBatch","supplier","farmer","farm","house","stockingBatch",
				"warehouse","material","costItem","weekAge","dayAge","isFormal","sendDate","sendAllQty","farmerGroup"});
		//设置行的默认值
		setDefalutRowValue();

		btnAddRows.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(txtAddRows.getIntegerValue()>0)
					for(int i=0;i<txtAddRows.getIntegerValue();i++)
						addEntryRow();
			}

		});

		this.kdtEntrys.getColumn("farmer").getStyleAttributes().setLocked(true);

	}
	protected void setDefalutRowValue() {
		Calendar cal=Calendar.getInstance();
		cal.setTime(pkBizDate.getTimestamp());
		cal.add(Calendar.DAY_OF_MONTH, -1);

		rowCountAndDefalutValue.clear();

		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("statisticsType", StatisticsType.NumQty);
		map.put("unit", unitNum);
		map.put("sendDate",cal.getTime());
		map.put("warehouse",hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);
		map.put(ICTable.rowBackgroupColor, colrWht);
		rowCountAndDefalutValue.add(map);


		HashMap<String, Object> map2=new HashMap<String, Object>();
		map2.put("statisticsType", StatisticsType.AllWight);
		map2.put("unit", unitKG);
		map2.put("sendDate",cal.getTime());
		map2.put("warehouse",hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);
		map2.put(ICTable.rowBackgroupColor, colrYel);
		rowCountAndDefalutValue.add(map2);

		HashMap<String, Object> map3=new HashMap<String, Object>();
		map3.put("statisticsType", StatisticsType.AvgWeight);
		map3.put("unit", unitG);
		map3.put("sendDate",cal.getTime());
		map3.put("warehouse",hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);
		map3.put(ICTable.rowBackgroupColor, colrZs);
		map3.put(ICTable.setRowLocked, true);
		rowCountAndDefalutValue.add(map3);

		icTable.setRowCountAndDefalutValue(rowCountAndDefalutValue);
	}

	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));


		this.kdtEntrys.getColumn("farmer").getStyleAttributes().setLocked(true);


		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);

		//仓库
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id", prmtstorageOrgUnit.getValue()==null?curStorageOrgUnitID:((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id"),CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);

		setFilter();
		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//设置行的默认值
				setDefalutRowValue();
			}});
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				storageOrgUnit_changed(e);
			}});
		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
			}

		});
		ActionListener[] ls = this.kdtEntrys_detailPanel.getAddNewLineButton().getListeners(ActionListener.class);
		for(int index=0;index<ls.length;index++) {
			this.kdtEntrys_detailPanel.getAddNewLineButton().removeActionListener(ls[index]);
		}
		ls = this.kdtEntrys_detailPanel.getInsertLineButton().getListeners(ActionListener.class);
		for(int index=0;index<ls.length;index++) {
			this.kdtEntrys_detailPanel.getInsertLineButton().removeActionListener(ls[index]);
		}
		ls = this.kdtEntrys_detailPanel.getRemoveLinesButton().getListeners(ActionListener.class);
		for(int index=0;index<ls.length;index++) {
			this.kdtEntrys_detailPanel.getRemoveLinesButton().removeActionListener(ls[index]);
		}
		this.kdtEntrys_detailPanel.getAddNewLineButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				addEntryRow();
			}});
		this.kdtEntrys_detailPanel.getInsertLineButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				insertEntryRow();
			}});
		this.kdtEntrys_detailPanel.getRemoveLinesButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				removeEntryRow();
			}});

		this.kdtEntrys.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				kdtEntry_selectChanged();
			}});

		this.eggSource.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setColHide();
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
		this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor1);  
		this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR1);

		kdtEntrys.getColumn("internalFarm").setRequired(true);
		kdtEntrys.getColumn("internalBatch").setRequired(true);
		kdtEntrys.getColumn("supplier").setRequired(true);
		kdtEntrys.getColumn("farmer").setRequired(true);
		kdtEntrys.getColumn("farm").setRequired(true);
		kdtEntrys.getColumn("stockingBatch").setRequired(true);
		kdtEntrys.getColumn("stockingBatch").setRequired(true);
		kdtEntrys.getColumn("isExistDownBill").setWidth(140);

		//检查是否具有初始化权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isInitStockingBatchCrt");
			this.chkisInit.setVisible(true);
		}catch(Exception err) {
			this.chkisInit.setVisible(false);
		}

		/*//检查是否具有价格查看权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
//			PermissionFactory.getRemoteInstance().hasFunctionPermission(arg0, arg1, arg2)
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "showPriceColstockingHatch");
			kdtEntrys.getColumn("price1").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("price2").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("price3").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("price4").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("price5").getStyleAttributes().setHided(false);
		}catch(Exception err) {
			kdtEntrys.getColumn("price1").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("price2").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("price3").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("price4").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("price5").getStyleAttributes().setHided(true);
		}*/

		for(int colIndex=0;colIndex<kdtEntrys.getColumnCount();colIndex++) {
			if(kdtEntrys.getColumnKey(colIndex).toLowerCase().contains("qty")) {
				((KDFormattedTextField)kdtEntrys.getColumn(colIndex).getEditor().getComponent()).setPrecision(3);
			}
		}
	}

	private void setColHide() {
		if(eggSource.getSelectedIndex()==-1) {
			return;
		}
		if(eggSource.getSelectedItem().equals(EggSourceType.SubContract)||eggSource.getSelectedItem().equals(EggSourceType.InternalFarm)) {
			kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalBatch").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("farm").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("house").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(false);
		}
		//		if(eggSource.getSelectedItem().equals(EggSourceType.InternalFarm)) {
		//			kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(false);
		//			kdtEntrys.getColumn("internalBatch").getStyleAttributes().setHided(false);
		//			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(true);
		//			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(true);
		//			kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(true);
		//			kdtEntrys.getColumn("farm").getStyleAttributes().setHided(true);
		//			kdtEntrys.getColumn("house").getStyleAttributes().setHided(true);
		//			kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(true);
		//		}
		else if(eggSource.getSelectedItem().equals(EggSourceType.Purchase)) {
			kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalBatch").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("farm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("house").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(true);
		}
		//	else 
	}


	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
		vo.setInt("eggSource", EggSourceType.INTERNALFARM_VALUE);
	}

	/**
	 * 增加分录行
	 * @param bottom 
	 */
	private void addEntryRow( ) {
		icTable.addRow();
	}

	private void setMergeSigle(int rowIndex){
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("internalFarm"), rowIndex+2, kdtEntrys.getColumnIndex("internalFarm"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("internalBatch"), rowIndex+2, kdtEntrys.getColumnIndex("internalBatch"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("supplier"), rowIndex+2, kdtEntrys.getColumnIndex("supplier"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("farmer"), rowIndex+2, kdtEntrys.getColumnIndex("farmer"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("farm"), rowIndex+2, kdtEntrys.getColumnIndex("farm"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("house"), rowIndex+2, kdtEntrys.getColumnIndex("house"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("stockingBatch"), rowIndex+2, kdtEntrys.getColumnIndex("stockingBatch"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("warehouse"), rowIndex+2, kdtEntrys.getColumnIndex("warehouse"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("material"), rowIndex+2, kdtEntrys.getColumnIndex("material"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("costItem"), rowIndex+2, kdtEntrys.getColumnIndex("costItem"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("weekAge"), rowIndex+2, kdtEntrys.getColumnIndex("weekAge"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("dayAge"), rowIndex+2, kdtEntrys.getColumnIndex("dayAge"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("isFormal"), rowIndex+2, kdtEntrys.getColumnIndex("isFormal"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("sendDate"), rowIndex+2, kdtEntrys.getColumnIndex("sendDate"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("sendAllQty"), rowIndex+2, kdtEntrys.getColumnIndex("sendAllQty"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("farmerGroup"), rowIndex+2, kdtEntrys.getColumnIndex("farmerGroup"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("isExistDownBill"), rowIndex+2, kdtEntrys.getColumnIndex("isExistDownBill"));
		kdtEntrys.getMergeManager().mergeBlock(rowIndex, kdtEntrys.getColumnIndex("genderType"), rowIndex+2, kdtEntrys.getColumnIndex("genderType"));
	}

	private void setMerger() {
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			if(rowIndex%3==0) {
				setMergeSigle(rowIndex);
			}
		}
	}

	/**
	 * 插入分录行
	 */
	private void insertEntryRow() {
		icTable.insertRow();
	}
	/**
	 * 删除分录行
	 */
	private void removeEntryRow() {
		int rowIndex = KDTableUtil.getSelectedRow(kdtEntrys);
		if(rowIndex<0) {
			MsgBox.showWarning("请选择分录行！");
			return;
		}
		icTable.removeRow();
	}


	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 明细分录选择改变
	 */
	private void kdtEntry_selectChanged() {
		int rowIndex = KDTableUtil.getSelectedRow(kdtEntrys);
		if(rowIndex==-1) {
			return;
		}
		if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue()!=null&&kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.NumQty)) {
			kdtPickDetail_detailPanel.getAddNewLineButton().setEnabled(true);
			kdtPickDetail_detailPanel.getInsertLineButton().setEnabled(true);
			kdtPickDetail_detailPanel.getRemoveLinesButton().setEnabled(true);
		}else{
			kdtPickDetail_detailPanel.getAddNewLineButton().setEnabled(false);
			kdtPickDetail_detailPanel.getInsertLineButton().setEnabled(false);
			kdtPickDetail_detailPanel.getRemoveLinesButton().setEnabled(false);
		}
	}

	protected void setEntryRowColor() {
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue()==null){
				continue;
			}
			if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.AllWight)) {
				kdtEntrys.getRow(rowIndex).getStyleAttributes().setBackground(colrYel);
				kdtEntrys.getRow(rowIndex).getCell("farmer").getStyleAttributes().setLocked(true);
				kdtEntrys.getRow(rowIndex).getCell("farm").getStyleAttributes().setLocked(true);
				kdtEntrys.getRow(rowIndex).getCell("stockingBatch").getStyleAttributes().setLocked(true);
			} else if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.AvgWeight)) {
				kdtEntrys.getRow(rowIndex).getStyleAttributes().setBackground(colrZs);
				kdtEntrys.getRow(rowIndex).getStyleAttributes().setLocked(true);
			}else if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.NumQty)){
				for(int col=kdtEntrys.getColumnIndex("statisticsType");col<=kdtEntrys.getColumnIndex("diffQty");col++)
					kdtEntrys.getRow(rowIndex).getCell(col).getStyleAttributes().setBackground(colrWht);
			}
		}
	}

	private void storageOrgUnit_changed(DataChangeEvent e){
		if(e.getNewValue()==null) {
			curStorageOrgUnitID=null;
		}else{
			curStorageOrgUnitID=((PropertyContainer) this.prmtstorageOrgUnit.getValue()).getString("id");
			try {
				orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
				f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
				f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");
			} catch (EASBizException e1) {
				e1.printStackTrace();
			} catch (BOSException e1) {
				e1.printStackTrace();
			}
		}
		//仓库
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id", prmtstorageOrgUnit.getValue()==null?curStorageOrgUnitID:((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id"),CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);

		hbInfo=StockingComm.getHatchBaseDataByOrgID(null, prmtstorageOrgUnit.getValue()==null?curStorageOrgUnitID:((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id"));
		////设置行的默认值
		setDefalutRowValue();

	}

	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
		KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
		KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
		KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();

		//批次过滤
		StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,null,null);
		//养殖户过滤
		setFarmerFilter(prmtFarmer, curCompanyID);
		//养殖场过滤
		StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, null);

		//人员过滤
		StockingClientComm.makeApplierF7((KDBizPromptBox) kdtPickDetail.getColumn("pickPerson").getEditor().getComponent(), curCompanyID, this, false);
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
		String key=this.kdtEntrys.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")||key.equals("house")) {
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id");
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
			((KDBizPromptBox)this.kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		}
	}

	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")) {	
			//设置仓库
			if(kdtEntrys.getCell(rowIndex,"material").getValue()!=null) {
				kdtEntrys.getCell(rowIndex,"warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, ((PropertyContainer) kdtEntrys.getCell(rowIndex,"material").getValue()).getString("id")));
			}
			icTable.setOtherCellSameVaule(rowIndex, "material", kdtEntrys.getCell(rowIndex,"material").getValue());
			icTable.setOtherCellSameVaule(rowIndex, "warehouse", kdtEntrys.getCell(rowIndex,"warehouse").getValue());
		}

		if(kdtEntrys.getColumn(colIndex).getKey().equals("genderType")) {			

			icTable.setOtherCellSameVaule(rowIndex, "genderType", kdtEntrys.getCell(rowIndex,"genderType").getValue());
		}
		//根据合同和批次带出养殖户和农场
		if(kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")) {
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				//				kdtEntrys.getCell(rowIndex, "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farmer"));
				kdtEntrys.getCell(rowIndex, "farm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farm"));
				kdtEntrys.getCell(rowIndex, "farmerGroup").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"farmer").getValue(), "treeid"));
				ArrayList<String> list = StockingComm.getEggListByStockingBatchID(null, ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id"), true);
				if(list!=null&&list.size()>0) {
					kdtEntrys.getCell(rowIndex, "material").setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(list.get(0))));
					if(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, list.get(0))!=null)
						kdtEntrys.getCell(rowIndex, "warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, list.get(0)));
				}
			}

			setEntryAge(rowIndex);

			kdtEntrys.getCell(rowIndex, "costItem").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "costItem"));

			icTable.setOtherCellSameVaule(rowIndex, "stockingBatch", kdtEntrys.getCell(rowIndex,"stockingBatch").getValue());
			//			icTable.setOtherCellSameVaule(rowIndex, "farmer", kdtEntrys.getCell(rowIndex,"farmer").getValue());
			icTable.setOtherCellSameVaule(rowIndex, "farm", kdtEntrys.getCell(rowIndex,"farm").getValue());
			icTable.setOtherCellSameVaule(rowIndex, "costItem", kdtEntrys.getCell(rowIndex,"costItem").getValue());
			icTable.setOtherCellSameVaule(rowIndex, "material", kdtEntrys.getCell(rowIndex,"material").getValue());
			icTable.setOtherCellSameVaule(rowIndex, "warehouse", kdtEntrys.getCell(rowIndex,"warehouse").getValue());
		}


		if(kdtEntrys.getColumnKey(colIndex).equals("sendDate")) {
			icTable.setOtherCellSameVaule(rowIndex, "sendDate", kdtEntrys.getCell(rowIndex,"sendDate").getValue());
			//计算周龄+日龄
			setEntryAge(rowIndex);
		}

		//根据养殖户带出养殖场
		if(kdtEntrys.getColumnKey(colIndex).equals("farmer")) {
			String farmerID=null;
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null) {
				farmerID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, colIndex).getValue()).getString("id");
			}
			kdtEntrys.getCell(rowIndex, "farm").setValue(StockingComm.getFarmInfoByFarmerID(null,farmerID));
			if(farmerID!=null&&kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				if(!((IPropertyContainer) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farmer")).getString("id").equals(farmerID)) {
					kdtEntrys.getCell(rowIndex,"stockingBatch").setValue(null);
					icTable.setOtherCellSameVaule(rowIndex, "stockingBatch", kdtEntrys.getCell(rowIndex,"stockingBatch").getValue());
				}
			}

			icTable.setOtherCellSameVaule(rowIndex, "farmer", kdtEntrys.getCell(rowIndex,"farmer").getValue());
			icTable.setOtherCellSameVaule(rowIndex, "farm", kdtEntrys.getCell(rowIndex,"farm").getValue());
			icTable.setOtherCellSameVaule(rowIndex, "farmerGroup", kdtEntrys.getCell(rowIndex,"farmerGroup").getValue());

			boolean flag = true;
			for(int i=0;i<kdtEntrys.getRowCount();i++){
				if(kdtEntrys.getCell(rowIndex, colIndex).getValue()==null)
					break;
				for(int j=kdtEntrys.getColumn("id").getColumnIndex()+1;j<kdtEntrys.getColumn("statisticsType").getColumnIndex();j++)
					if(!kdtEntrys.getColumn(j).getKey().equals("sendDate")&&kdtEntrys.getCell(i, j).getValue()!=null){
						flag=false;
						break;
					}
				if(flag){
					kdtEntrys.getCell(i, "farmer").setValue(kdtEntrys.getCell(rowIndex,"farmer").getValue());
					kdtEntrys.getCell(i, "farm").setValue(kdtEntrys.getCell(rowIndex,"farm").getValue());
					kdtEntrys.getCell(i, "farmerGroup").setValue(kdtEntrys.getCell(rowIndex,"farmerGroup").getValue());
				}
				flag=true;

			}


		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("warehouse")) {
			icTable.setOtherCellSameVaule(rowIndex, "warehouse", kdtEntrys.getCell(rowIndex,"warehouse").getValue());
		}

		if(kdtEntrys.getColumnKey(colIndex).equals("house")) {
			icTable.setOtherCellSameVaule(rowIndex, "house", kdtEntrys.getCell(rowIndex,"house").getValue());
		}


		if(kdtEntrys.getColumnKey(colIndex).equals("stockingBatch")
				||kdtEntrys.getColumnKey(colIndex).equals("house")
				||kdtEntrys.getColumnKey(colIndex).equals("sendDate")){
			String houseID=null;
			if( kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {
				houseID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id");
			}
			//批次、发出日期不为空
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null&&kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
				setSendQtyByTheEggTable(rowIndex,((IPropertyContainer) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id"), houseID, (Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue());
			}else {
				icTable.setCellSameVaule(rowIndex, "sendAllQty",BigDecimal.ZERO);
				icTable.setCellSameVaule(rowIndex, "isFormal",false);
			}

		}




		/**
		 * 棚舍带出最近的批次
		 */
		if("house".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())){
			//			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null){
			//				FarmHouseEntryInfo outHouse = (FarmHouseEntryInfo)kdtEntrys.getCell(rowIndex ,"house").getValue();
			//				final String sp="\n";
			//				String sql="select distinct "+sp+
			//				" t1.FID  breedBatch,"+sp+
			//				" t4.FID  farmer,"+sp+
			//				" t6.FID  outFarm,"+sp+
			//				" t5.Fname_l2"+sp+
			//				"from "+sp+
			//				" T_FM_StockingBatch                      t1"+sp+
			//				"inner join T_FM_StockingBatchHouseEntry  t2 on t1.FID=t2.FParentID"+sp+
			//				"inner join CT_FM_FarmHouseEntry          t3 on t3.FID=t2.FHouseID"+sp+
			//				"      and t3.FID='"+outHouse.getId().toString()+"'"+sp+
			//				"      and t2.FInData=("+sp+
			//				"select "+sp+
			//				" max(t2.FIndata)"+sp+
			//				"from"+sp+
			//				" T_FM_StockingBatch                      t1"+sp+
			//				"inner join T_FM_StockingBatchHouseEntry  t2 on t1.FID=t2.FParentID"+sp+
			//				"inner join CT_FM_FarmHouseEntry          t3 on t3.FID=t2.FHouseID"+sp+
			//				"      and t3.FID='"+outHouse.getId().toString()+"'"+sp+
			//				""+sp+
			//				")"+sp+
			//				"left join T_FM_Farmers                  t4 on t4.FID=t1.FFarmerID   "+sp+              
			//				"left join T_FM_FarmersTREE              t5 on t5.FID=t4.FTreeID"+sp+
			//				"inner join T_FM_Farm                     t6 on t6.FID=t1.FFarmID"+sp;
			//
			//				IRowSet rs;
			//				try {
			//					rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			//					if(rs.next()){
			//						kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(rs.getString("breedBatch")==null?null:(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("breedBatch")))));
			//					}
			////					else
			////						kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(null);
			//				} catch (BOSException e1) {
			//					// TODO Auto-generated catch block
			//					e1.printStackTrace();
			//				} catch (SQLException e1) {
			//					// TODO Auto-generated catch block
			//					e1.printStackTrace();
			//				} catch (EASBizException e1) {
			//					// TODO Auto-generated catch block
			//					e1.printStackTrace();
			//				}
			//			}
		}

		String key=this.kdtEntrys.getColumnKey(colIndex);
		int firstRowIndex=0;
		if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.NumQty)) {
			firstRowIndex=rowIndex;
		}
		if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.AllWight)) {
			firstRowIndex=rowIndex-1;
		}

		//计算总蛋数 = 破蛋数+合格单数+畸形蛋数
		if(key.equalsIgnoreCase("brokenQty")||key.equalsIgnoreCase("wrongSharpEgg")	 
				||key.equalsIgnoreCase("effectAllQty")) {
			calEffectAllQty(rowIndex);
			calEntryValValue(firstRowIndex,colIndex);
		}

		//		//合格2，计算隐纹率
		//		if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue()!=null&&kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.NumQty)) {//&&(key.equalsIgnoreCase("qc2lv1Qty")||key.equalsIgnoreCase("qc2lv2Qty"))
		//			if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"allQty").getValue()).signum()>0) {
		//				kdtEntrys.getCell(rowIndex,"hiddenRate").setValue((UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"qc2lv1Qty").getValue()).add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"qc2lv2Qty").getValue())).multiply(new BigDecimal(100)).divide(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"allQty").getValue()),6,BigDecimal.ROUND_HALF_UP)).setScale(2,BigDecimal.ROUND_HALF_UP));
		//			}else{
		//				kdtEntrys.getCell(rowIndex,"hiddenRate").setValue(BigDecimal.ZERO);
		//			}
		//		}
		//
		for(int i=0;i<kdtEntrys.getRowCount()-2;){
			for(int j=kdtEntrys.getColumn("id").getColumnIndex()+1;j<kdtEntrys.getColumn("statisticsType").getColumnIndex();j++){
				kdtEntrys.getCell(i+1, j).setValue(kdtEntrys.getCell(i, j).getValue());
				kdtEntrys.getCell(i+2, j).setValue(kdtEntrys.getCell(i, j).getValue());
			}
			i+=3;
		}

		//		kdtEntrys.getCell(firstRowIndex+1,"allQty").setValue(null);
		//		kdtEntrys.getCell(firstRowIndex+1,"effectAllQty").setValue(null);
		apendFootRow(kdtEntrys, new String[]{"allQty","effectAllQty","brokenQty","qc1lv1Qty","qc1lv2Qty","qc2lv1Qty","qc2lv2Qty","qc3lv1Qty","qc4lv1Qty","qc5lv2Qty","qc6lv2Qty","greensQty","dirtyQty","doubleQty","mutantQty","brokenSingeQty","flowQty","brokenDoubleQty","tinyEggQty"});
	}


	private void setEntryAge(int rowIndex) throws DataAccessException, BOSException, EASBizException {
		int week=0;
		int weekDay=0;
		if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null&&kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
			Date inDate=null;
			if(kdtEntrys.getCell(rowIndex, "house").getValue()==null) {//禽舍为空 
				inDate= (Date) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "inDate");
			}else{//禽舍不为空
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("HouseEntry.*");
				StockingBatchInfo batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id")),slor);

				for(int index=0;index<batchInfo.getHouseEntry().size();index++) {
					if(batchInfo.getHouseEntry().get(index).getHouse().getString("id").equals(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id"))) {
						inDate=batchInfo.getHouseEntry().get(index).getInData();
						break;
					}
				}
			}
			int[] result = StockingComm.getBreedWeekAndDay((Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue(), inDate);
			week=result[0];
			weekDay=result[1];
		}

		icTable.setCellSameVaule(rowIndex, "weekAge", week+"周"+weekDay);
		icTable.setCellSameVaule(rowIndex, "dayAge", week>0?(week-1)*7+weekDay:0);
	}

	/**
	 * 根据批次、棚舍等信息获取交蛋表确认数量
	 * @param stockingBatchID
	 * @param houseID
	 * @param bizDate
	 * @return
	 */
	private void setSendQtyByTheEggTable(int rowIndex,String stockingBatchID,String houseID,Date bizDate) {
		try {
			IRow row=kdtEntrys.getRow(rowIndex);
			/**
			 * 检查是否已经存在该批次其他行
			 */
			boolean isExistOthers=false;
			for(int i=0;i<kdtEntrys.getRowCount();i++) {
				if(i==rowIndex) {
					continue;
				}
				if(kdtEntrys.getCell(i, "statisticsType").getValue()==null||!kdtEntrys.getCell(i, "statisticsType").getValue().equals(StatisticsType.NumQty)) {
					continue;
				}
				if(kdtEntrys.getCell(i, "stockingBatch").getValue()==null) {
					continue;
				}else{
					if(((IPropertyContainer) kdtEntrys.getCell(i, "stockingBatch").getValue()).getString("id").equals(stockingBatchID)) {
						isExistOthers=true;
						break;
					}
				}
			}

			StringBuffer sql=new StringBuffer();
			sql.append(" select sum(tentry.CFQualified) fallQty,tentry.fhouseID,tentry.fseq")
			//sql.append(" select sum(tentry.FSendAllQty) fallQty,tentry.fhouseID,tentry.fseq")

			.append(" from T_FM_TheEggTableEntry tentry ")
			.append(" inner join T_FM_TheEggTable tbill on tbill.fid=tentry.fparentid")
			.append(" where fcompanyid='").append(curCompanyID).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and to_char(tbill.fbizDate,'yyyy-MM-dd')='").append(sdf.format(bizDate)).append("'")
			.append(" and tentry.FStockingBatchID='").append(stockingBatchID).append("'");
			if(StringUtils.isNotEmpty(houseID)) {
				sql.append(" and tentry.fhouseid='").append(houseID).append("'");
			}
			sql.append("  group by tentry.fhouseID,tentry.fseq")
			.append(" order by tentry.fseq asc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			IRow newRow;
			int newCount=3;
			boolean hasUpdate=false;
			IFarmHouseEntry ifs = FarmHouseEntryFactory.getRemoteInstance();
			FarmHouseEntryInfo houseInfo ;
			while(rs.next()) {
				if(isExistOthers) {
					boolean isFormal=getFormal(stockingBatchID, rs.getString("fhouseid"),bizDate);
					icTable.setCellSameVaule(rowIndex, "isFormal", isFormal);
					icTable.setCellSameVaule(rowIndex, "sendAllQty", rs.getBigDecimal("fallQty"));
					icTable.setCellSameVaule(rowIndex, "warehouse", hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);
					break;
				}else{
					houseInfo=null;
					//不存在其他行
					if(houseID==null) {
						houseID=rs.getString("fhouseID");
					}
					if(!hasUpdate&&(rs.getString("fhouseid")==null||rs.getString("fhouseID").equals(houseID))){
						if(StringUtils.isNotEmpty(rs.getString("fhouseid"))) {
							houseInfo = ifs.getFarmHouseEntryInfo(new ObjectUuidPK(rs.getString("fhouseid")));
						}
						boolean isFormal=getFormal(stockingBatchID, rs.getString("fhouseid"),bizDate);

						icTable.setCellSameVaule(rowIndex, "house", houseInfo);
						icTable.setCellSameVaule(rowIndex, "sendAllQty", rs.getBigDecimal("FAllQty"));
						icTable.setCellSameVaule(rowIndex, "isFormal", isFormal);
						icTable.setCellSameVaule(rowIndex, "warehouse", hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);

						hasUpdate=true;
					}else{
						newRow=kdtEntrys.addRow(rowIndex+(newCount++));
						if(StringUtils.isNotEmpty(rs.getString("fhouseid"))) {
							houseInfo = ifs.getFarmHouseEntryInfo(new ObjectUuidPK(rs.getString("fhouseid")));
						}
						boolean isFormal=getFormal(stockingBatchID, rs.getString("fhouseid"),bizDate);
						//						String farmerGroupName=((IObjectValue) UIRuleUtil.getProperty((IObjectValue) row.getCell("farmer").getValue(),"treeid")).getString("name");
						newRow.getCell("statisticsType").setValue(StatisticsType.NumQty);
						newRow.getCell("unit").setValue(unitNum);

						newRow=kdtEntrys.addRow(rowIndex+(newCount++));
						newRow.getCell("statisticsType").setValue(StatisticsType.AllWight);
						newRow.getCell("unit").setValue(unitKG);
						newRow.getStyleAttributes().setBackground(colrYel);

						newRow=kdtEntrys.addRow(rowIndex+(newCount++));
						newRow.getCell("statisticsType").setValue(StatisticsType.AvgWeight);
						newRow.getCell("unit").setValue(unitG);
						newRow.getStyleAttributes().setBackground(colrZs);
						newRow.getStyleAttributes().setLocked(true);

						icTable.setCellSameVaule(newRow.getRowIndex()-2, "stockingBatch", row.getCell("stockingBatch").getValue());
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "farmer", row.getCell("farmer").getValue());
						//						icTable.setCellSameVaule(newRow.getRowIndex()-2, "farmerGroup", farmerGroupName);
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "farm", row.getCell("farm").getValue());
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "house", houseInfo);
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "sendDate", row.getCell("sendDate").getValue());
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "isFormal", isFormal);
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "sendAllQty", rs.getBigDecimal("FAllQty"));
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "warehouse", hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);

						setEntryAge(newCount-3);

						setMergeSigle(newCount-3);
					}
				}
			}
			if(rs.size()<=0){
				boolean isFormal=getFormal(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id"), houseID,(Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue());

				icTable.setCellSameVaule(rowIndex, "isFormal", isFormal);
				icTable.setCellSameVaule(rowIndex, "sendAllQty", BigDecimal.ZERO);
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 根据批次、棚舍等信息获取蛋品报送数量
	 * @param stockingBatchID
	 * @param houseID
	 * @param bizDate
	 * @return
	 */
	private void setSendQty(int rowIndex,String stockingBatchID,String houseID,Date bizDate) {
		try {
			IRow row=kdtEntrys.getRow(rowIndex);
			/**
			 * 检查是否已经存在该批次其他行
			 */
			boolean isExistOthers=false;
			for(int i=0;i<kdtEntrys.getRowCount();i++) {
				if(i==rowIndex) {
					continue;
				}
				if(kdtEntrys.getCell(i, "statisticsType").getValue()==null||!kdtEntrys.getCell(i, "statisticsType").getValue().equals(StatisticsType.NumQty)) {
					continue;
				}
				if(kdtEntrys.getCell(i, "stockingBatch").getValue()==null) {
					continue;
				}else{
					if(((IPropertyContainer) kdtEntrys.getCell(i, "stockingBatch").getValue()).getString("id").equals(stockingBatchID)) {
						isExistOthers=true;
						break;
					}
				}
			}

			StringBuffer sql=new StringBuffer();
			sql.append(" select sum(tentry.fallQty) fallQty,tentry.fhouseID,tentry.fseq")
			.append(" from T_FM_StockingBDSEE tentry ")
			.append(" inner join T_FM_StockingBreedDaily tbill on tbill.fid=tentry.fparentid")
			.append(" where fcompanyid='").append(curCompanyID).append("'")
			.append(" and tbill.cfbasestatus=4")
			.append(" and to_char(tbill.fbizDate,'yyyy-MM-dd')='").append(sdf.format(bizDate)).append("'")
			.append(" and tbill.cfstockingbatchid='").append(stockingBatchID).append("'");
			if(StringUtils.isNotEmpty(houseID)) {
				sql.append(" and tentry.fhouseid='").append(houseID).append("'");
			}
			sql.append("  group by tentry.fhouseID,tentry.fseq")
			.append(" order by tentry.fseq asc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			IRow newRow;
			int newCount=3;
			boolean hasUpdate=false;
			IFarmHouseEntry ifs = FarmHouseEntryFactory.getRemoteInstance();
			FarmHouseEntryInfo houseInfo ;
			while(rs.next()) {
				if(isExistOthers) {
					boolean isFormal=getFormal(stockingBatchID, rs.getString("fhouseid"),bizDate);
					icTable.setCellSameVaule(rowIndex, "isFormal", isFormal);
					icTable.setCellSameVaule(rowIndex, "sendAllQty", rs.getBigDecimal("fallQty"));
					icTable.setCellSameVaule(rowIndex, "warehouse", hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);

					break;
				}else{
					houseInfo=null;
					//不存在其他行
					//					if(rs.getString("fhouseID")!=null) {
					if(houseID==null) {
						houseID=rs.getString("fhouseID");
					}
					if(!hasUpdate&&(rs.getString("fhouseid")==null||rs.getString("fhouseID").equals(houseID))){
						if(StringUtils.isNotEmpty(rs.getString("fhouseid"))) {
							houseInfo = ifs.getFarmHouseEntryInfo(new ObjectUuidPK(rs.getString("fhouseid")));
						}
						boolean isFormal=getFormal(stockingBatchID, rs.getString("fhouseid"),bizDate);

						icTable.setCellSameVaule(rowIndex, "house", houseInfo);
						icTable.setCellSameVaule(rowIndex, "sendAllQty", rs.getBigDecimal("FAllQty"));
						icTable.setCellSameVaule(rowIndex, "isFormal", isFormal);
						icTable.setCellSameVaule(rowIndex, "warehouse", hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);

						hasUpdate=true;
					}else{
						newRow=kdtEntrys.addRow(rowIndex+(newCount++));
						if(StringUtils.isNotEmpty(rs.getString("fhouseid"))) {
							houseInfo = ifs.getFarmHouseEntryInfo(new ObjectUuidPK(rs.getString("fhouseid")));
						}
						boolean isFormal=getFormal(stockingBatchID, rs.getString("fhouseid"),bizDate);
						String farmerGroupName=((IObjectValue) UIRuleUtil.getProperty((IObjectValue) row.getCell("farmer").getValue(),"treeid")).getString("name");
						newRow.getCell("statisticsType").setValue(StatisticsType.NumQty);
						newRow.getCell("unit").setValue(unitNum);

						newRow=kdtEntrys.addRow(rowIndex+(newCount++));
						newRow.getCell("statisticsType").setValue(StatisticsType.AllWight);
						newRow.getCell("unit").setValue(unitKG);
						newRow.getStyleAttributes().setBackground(colrYel);

						newRow=kdtEntrys.addRow(rowIndex+(newCount++));
						newRow.getCell("statisticsType").setValue(StatisticsType.AvgWeight);
						newRow.getCell("unit").setValue(unitG);
						newRow.getStyleAttributes().setBackground(colrZs);
						newRow.getStyleAttributes().setLocked(true);

						icTable.setCellSameVaule(newRow.getRowIndex()-2, "stockingBatch", row.getCell("stockingBatch").getValue());
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "farmer", row.getCell("farmer").getValue());
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "farmerGroup", farmerGroupName);
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "farm", row.getCell("farm").getValue());
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "house", houseInfo);
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "sendDate", row.getCell("sendDate").getValue());
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "isFormal", isFormal);
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "sendAllQty", rs.getBigDecimal("FAllQty"));
						icTable.setCellSameVaule(newRow.getRowIndex()-2, "warehouse", hbInfo!=null?hbInfo.getDefaultEggWarehouse():null);

						setEntryAge(newCount-3);

						setMergeSigle(newCount-3);
					}
				}
			}
			if(rs.size()<=0){
				boolean isFormal=getFormal(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id"), houseID,(Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue());
				icTable.setCellSameVaule(rowIndex, "isFormal", isFormal);
				icTable.setCellSameVaule(rowIndex, "sendAllQty", BigDecimal.ZERO);
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	/**
	 * 获取是否转正
	 * @param batchInfo
	 * @param houseID
	 * @return
	 */
	private boolean getFormal(String batchID,String houseID,Date date) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tbatch.FFormalDate,tentry.FFormalDate FEntryDate")
			.append(" from T_FM_StockingBatch tbatch")
			.append(" left join T_FM_StockingBatchHouseEntry tentry on (tentry.fparentid=tbatch.fid and tentry.fhouseid='").append(houseID).append("')")
			.append(" where tbatch.fid='").append(batchID).append("'")
			.append(" ")
			;
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				if(StringUtils.isNotEmpty(houseID)&&rs.getString("FEntryDate")!=null) {
					if(rs.getDate("FEntryDate").compareTo(date)<=0) {
						return true;
					}else{
						return false;
					}
				}
				if(StringUtils.isEmpty(houseID)&&rs.getString("FFormalDate")!=null) {
					if(rs.getDate("FFormalDate").compareTo(date)<=0) {
						return true;
					}else{
						return false;
					}
				}

			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return false;
	}


	/**
	 * 计算平均数
	 * @param firstRowIndex
	 */
	private void calEntryValValue(int rowIndex,int colIndex) {
		if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, colIndex).getValue()).signum()>0) {
			kdtEntrys.getCell(rowIndex+2, colIndex).setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex+1, colIndex).getValue()).multiply(new BigDecimal(1000)).divide(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, colIndex).getValue()),3,BigDecimal.ROUND_HALF_UP));
		}else{
			kdtEntrys.getCell(rowIndex+2, colIndex).setValue(BigDecimal.ZERO);
		}
	}

	/**
	 * 计算破蛋
	 * @param rowIndex
	 */
	private void calBrokenEgg(int rowIndex) {

		calAllQty(rowIndex);
		calBrokenRate(rowIndex);
	}
	/**
	 * 计算破损率
	 * @param rowIndex
	 */
	private void calBrokenRate(int rowIndex) {
		if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "allQty").getValue()).signum()>0) {
			kdtEntrys.getCell(rowIndex, "brokenRate").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "brokenQty").getValue()).multiply(new BigDecimal(100).divide(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "allQty").getValue()),6,BigDecimal.ROUND_HALF_UP)).setScale(2,BigDecimal.ROUND_HALF_UP));
		}else{
			kdtEntrys.getCell(rowIndex, "brokenRate").setValue(BigDecimal.ZERO);
		}
	}

	/**
	 * 
	 * @param rowIndex
	 */
	private void calEffectAllQty(int rowIndex){
		//合格蛋数加上畸形蛋和破损蛋
		calAllQty(rowIndex);
	}
	/**
	 * 计算总蛋数
	 */
	private void calAllQty(int rowIndex) {
		BigDecimal allQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"effectAllQty").getValue())
		.add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"wrongSharpEgg").getValue()))
		.add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"brokenQty").getValue()))
		.add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"eggLiquid").getValue()));;

		//计算总蛋数
		kdtEntrys.getCell(rowIndex, "allQty").setValue(allQty);
		//计算合格率
		if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue()!=null
				&& kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.NumQty)
				&& allQty.signum() > 0 ) {
			//计算差异数量
			kdtEntrys.getCell(rowIndex, "diffQty").setValue(allQty.subtract(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"sendAllQty").getValue())));
		}else{
			kdtEntrys.getCell(rowIndex, "diffQty").setValue(BigDecimal.ZERO);
		}
	}


	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
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
		editData.setBillStatus(BillBaseStatusEnum.ADD);
		//        editData.setNumber(null);
		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();

		setMakeRelations(null);
	}

	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		//保存或者提交前校验已经启用棚舍管理的养殖场，棚舍不可以为空
		beforeSubmit();
		reCalEntryQty();
	}

	private void beforeSubmit() throws DataAccessException, BOSException {
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue()==null||!kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.NumQty)) {
				continue;
			}

			//如果是内部养殖场，养殖场和批次不能为空
			if(eggSource.getSelectedItem().equals(EggSourceType.InternalFarm)) {
				if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()==null 
						|| kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()==null) {
					MsgBox.showWarning("第"+(rowIndex+1)+"行分录，养殖批次不能为空！");
					SysUtil.abort();
				}

			}
			//只要启用了棚舍管理，棚舍就是必录项
			if(kdtEntrys.getCell(rowIndex, "farm").getValue()!=null&&(Boolean)UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "farm").getValue(), "isHouseManager")&&kdtEntrys.getCell(rowIndex, "house").getValue()==null) {
//				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，养殖场启用棚舍管理，棚舍不能为空！");
//				SysUtil.abort();
			}
			if(eggSource.getSelectedItem().equals(EggSourceType.Purchase)&&kdtEntrys.getCell(rowIndex, "supplier").getValue()==null) {
				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，供应商不能为空！");
				SysUtil.abort();
			}
		}
	}

	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
	}


	public void storeFields() {
		// TODO Auto-generated method stub
		super.storeFields();
	}

	private void afterStoreFileds() {
		int sumQty;
		boolean isExist;
		for(int index=0;index<this.editData.getEntrys().size();index++) {
			if(this.editData.getEntrys().get(index).getStatisticsType()==null||!this.editData.getEntrys().get(index).getStatisticsType().equals(StatisticsType.NumQty)) {
				continue;
			}
			sumQty=0;
			isExist=false;
			for(int j=0;j<this.editData.getEntrys().get(index).getPickDetail().size();j++) {
				sumQty+=this.editData.getEntrys().get(index).getPickDetail().get(j).getQty();
				isExist=true;
			}
			/*if(!isExist) {
				MsgBox.showWarning("第"+(index+1)+"行分录，挑选人员不能为空！");
				SysUtil.abort();
			}*/
			if(isExist&&this.editData.getEntrys().get(index).getAllQty().compareTo(new BigDecimal(sumQty))!=0) {
				MsgBox.showWarning("第"+(index+1)+"行分录，挑选人总数量!=接收蛋数");
				SysUtil.abort();
			}
		}
	}
	/**
	 * 重算分录
	 */
	private void reCalEntryQty() {
		String[] temp = new String[]{"qc1lv1Qty","qc1lv2Qty","qc2lv1Qty","qc2lv2Qty","qc3lv1Qty","qc4lv1Qty","qc5lv2Qty","qc6lv2Qty","greensQty","dirtyQty","doubleQty","mutantQty","brokenSingeQty","flowQty","brokenDoubleQty","tinyEggQty"};
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			if(kdtEntrys.getCell(rowIndex, "statisticsType").getValue()!=null&&kdtEntrys.getCell(rowIndex, "statisticsType").getValue().equals(StatisticsType.NumQty)) {
				for(int i=0;i<temp.length;i++) {
					try {
						kdtEntrys_Changed(rowIndex, kdtEntrys.getColumnIndex(temp[i]));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
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
			if(row==null) {
				continue;
			}
			//非枚数、不记录
			if(row.getCell("statisticsType").getValue()==null||!row.getCell("statisticsType").getValue().equals(StatisticsType.NumQty)) {
				continue;
			}
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0.00}f";  

		String total = "合计" ;

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(30);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i]; 
			System.out.println(colName);
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


		//合格率，破损率，隐纹率在合计行添加均值
		//		if(UIRuleUtil.getBigDecimal(footRow.getCell("allQty").getValue()).signum()>0){
		//			BigDecimal qcQty=UIRuleUtil.getBigDecimal(footRow.getCell("qc1lv1Qty").getValue()).add(UIRuleUtil.getBigDecimal(footRow.getCell("qc1lv2Qty").getValue()));
		//			footRow.getCell( "qcRateFarmer").setValue(qcQty.multiply(new BigDecimal(100)).divide(UIRuleUtil.getBigDecimal(footRow.getCell("allQty").getValue()),6,BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP));//只有合格一级
		//			qcQty=qcQty.add(UIRuleUtil.getBigDecimal(footRow.getCell("qc2lv1Qty").getValue())).add(UIRuleUtil.getBigDecimal(footRow.getCell("qc2lv2Qty").getValue())).add(UIRuleUtil.getBigDecimal(footRow.getCell("qc3lv1Qty").getValue())).add(UIRuleUtil.getBigDecimal(footRow.getCell("qc4lv1Qty").getValue())).add(UIRuleUtil.getBigDecimal(footRow.getCell("qc5lv2Qty").getValue())).add(UIRuleUtil.getBigDecimal(footRow.getCell("qc6lv2Qty").getValue()));
		//			footRow.getCell( "qcRateWorkshop").setValue(qcQty.multiply(new BigDecimal(100)).divide(UIRuleUtil.getBigDecimal(footRow.getCell("allQty").getValue()),6,BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP));
		//		}
		//		//破损率
		//		if(UIRuleUtil.getBigDecimal(footRow.getCell("allQty").getValue()).signum()>0) {
		//			footRow.getCell( "brokenRate").setValue(UIRuleUtil.getBigDecimal(footRow.getCell( "brokenQty").getValue()).multiply(new BigDecimal(100).divide(UIRuleUtil.getBigDecimal(footRow.getCell( "allQty").getValue()),6,BigDecimal.ROUND_HALF_UP)).setScale(3,BigDecimal.ROUND_HALF_UP));
		//		}else{
		//			footRow.getCell( "brokenRate").setValue(BigDecimal.ZERO);
		//		}
		//		if(UIRuleUtil.getBigDecimal(footRow.getCell("allQty").getValue()).signum()>0) {
		//			footRow.getCell("hiddenRate").setValue((UIRuleUtil.getBigDecimal(footRow.getCell("qc2lv1Qty").getValue()).add(UIRuleUtil.getBigDecimal(footRow.getCell("qc2lv2Qty").getValue())).multiply(new BigDecimal(100)).divide(UIRuleUtil.getBigDecimal(footRow.getCell("allQty").getValue()),6,BigDecimal.ROUND_HALF_UP)).setScale(3,BigDecimal.ROUND_HALF_UP));
		//		}else{
		//			footRow.getCell("hiddenRate").setValue(BigDecimal.ZERO);
		//		}
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
	/* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	private void setFarmerFilter(KDBizPromptBox prmtfarmer,String companyID) {
		StockingClientComm.setFarmerFilterForHatch(prmtfarmer, companyID,null);
	}

	@Override
	public void actionDeleteDownBill_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String id = editData.getId()!=null?editData.getId().toString():null;
		if(id==null)
			return;
		ArrayList<String> list = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(id, "7DD0D62D");
		BOTRelationCollection coll;
		EntityViewInfo evi=new EntityViewInfo();
		IBOTRelation iBOTRelation = BOTRelationFactory.getRemoteInstance();
		IEggSettleBill iEggSettleBill = EggSettleBillFactory.getRemoteInstance();
		if(list.size()>0){
			int result=MsgBox.showConfirm2("确认删除所有下游结算单么？");
			if(result==0){
				for(int i=0;i<list.size();i++){
					FilterInfo filter=new FilterInfo();
					filter.getFilterItems().add(new FilterItemInfo("SrcObjectID",id,CompareType.EQUALS));
					filter.getFilterItems().add(new FilterItemInfo("DestObjectID",list.get(i),CompareType.EQUALS));
					evi.setFilter(filter);
					coll = iBOTRelation.getCollection(evi);
					if(coll.size()>0){
						if(iEggSettleBill.getCollection("where id='"+list.get(i)+"'").size()>0)
							iEggSettleBill.delete(new ObjectUuidPK(list.get(i)));
						iBOTRelation.delete(new ObjectUuidPK(coll.get(0).getString("id")));
					}
				}
				UIUtil.refreshEditUI(this);
				MsgBox.showInfo("删除成功，此次共删除"+list.size()+"张结算单据");
			}
		}

	}
	/**
	 * 指定分录生成结算单
	 */
	@Override
	public void actionToSettleBill_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionToSettleBill_actionPerformed(e);
		if(editData.getId()==null)
			commUtils.giveUserTipsAndRetire("请先保存单据");
		int[] selectRows = KDTableUtil.getSelectedRows(kdtEntrys);
		if(selectRows.length==0)
			commUtils.giveUserTipsAndRetire("请先选择分录行");
		if(selectRows.length%3!=0||selectRows[0]%3!=0)
			commUtils.giveUserTipsAndRetire("每三行一个分录，请按分录选择");

		int selectRow = selectRows.length-1;
		for(int j=editData.getEntrys().size()-1;j>=0;j--){
			if(selectRow<0||j!=selectRows[selectRow])
				editData.getEntrys().remove(editData.getEntrys().get(j));
			else{
				--selectRow;
			}
		}
		System.out.println("剩结算分录条数"+editData.getEntrys().size());
		if(editData.getEntrys().size()>0){
			StockingHatchFacadeFactory.getRemoteInstance().createToEggSettleBill(editData);
			MsgBox.showInfo("生成成功");
		}
		UIUtil.refreshEditUI(this);
	}

	@Override
	protected void btnRefresh_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.btnRefresh_mouseClick(e);
		EggSettleBillCollection coll;
		IEggSettleBill remoteInstance = EggSettleBillFactory.getRemoteInstance();
		ICommFacade remoteInstance2 = CommFacadeFactory.getRemoteInstance();
		if(editData.getId()!=null){
			for(int i=0;i<editData.getEntrys().size();i++){
				if(UIRuleUtil.isNotNull(editData.getEntrys().get(i).getSettleBillID())){
					coll = remoteInstance.getEggSettleBillCollection("where id='"+editData.getEntrys().get(i).getSettleBillID()+"'");
					if(coll.size()==0){
						remoteInstance2.excuteUpdateSql("update T_FM_EggReceiveBillEntry set FSettleBillID='',FIsExistDownBill=0 where fid='"+editData.getEntrys().get(i).getString("id")+"'");
					}
				}
			}
		}
		UIUtil.refreshEditUI(this);
	}

	@Override
	public void actionSetColor_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSetColor_actionPerformed(e);
		HashMap<Object, Object> hashMap=new HashMap<Object, Object>();
		hashMap.put("colorWgt",colrYel);
		hashMap.put("colorAvg",colrZs);
		hashMap.put("ui", this);
		hashMap.put("user",SysContext.getSysContext().getCurrentUserInfo());

		ClientUtils.openChildUIFromParentUI(UIFactoryName.MODEL, "com.kingdee.eas.farm.stocking.hatch.client.ColorSelect", hashMap, null, OprtState.ADDNEW);
	}
}