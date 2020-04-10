/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Component;
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
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import jxl.format.Orientation;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.itrus.util.SystemUtils;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.data.engine.script.beanshell.function.numeric.ROUND;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.ormapping_ex.ast.SelectItem;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.assistant.CostObject;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.Material;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.PersonUtil;
import com.kingdee.eas.custom.commld.commUtils;
//import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedData;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BatchLastBean;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDaily;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyDrugEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyDrugEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyTransEntryInfo;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.rptclient.gr.rptclient.util.DbUtil;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class StockingBreedDailyEditUI extends AbstractStockingBreedDailyEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(StockingBreedDailyEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private boolean isLoadField=false;
	private boolean isLoadFieldLD=false;
	private BaseSysSettingInfo sysSetting;
	private boolean isHouseManager=false;//是否启动棚舍管理

	private boolean isfarmer=true;//是否执行过养殖户
	private boolean isfarm=true;//是否执行过养殖场
	/**
	 * output class constructor
	 */
	public StockingBreedDailyEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	public void loadFields(){
		isLoadFieldLD=true;
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

		//自适应列宽
		KDTable[] tables=new KDTable[]{kdtEntrys,kdtAssEntrys,kdtEggEntry,kdtSendEggEntry,kdtImmuneEntrys,kdtDrugEntrys,kdtEnvi,kdtMatUserEntry};
		resizeKdtEntry(tables);

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
		setFemaleQtyHiheOrNot();

		//第一次新增，触发批次事件
		if(oprtState.equals(OprtState.ADDNEW)) {
			try {
				batch_changed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			farm_changed(null);
		}

		setEntryLastStock();
		isLoadFieldLD=false;

		UITools.apendFootRow(kdtEntrys, new String[]{"bagQty","dailyQtyAll","femaleDailyQty"});
		UITools.apendFootRow(kdtAssEntrys, new String[]{"deathQty","femaleDeathQty","cullQty","femaleCullQty","breekingStock","femaleBreedkingStock","adjustQty","adjustFemaleQty","cullTotalWgt","cullTotalAmt"});
		UITools.apendFootRow(kdtEggEntry, new String[]{"allQty","qcEggQty","smallEggQty","doubleQty","brokenQty","mutnatQty","firstQty","rd","fxd","zd"});
		UITools.apendFootRow(kdtImmuneEntrys, new String[]{"vaccineGetQty","vaccineUsedQty"});
		com.kingdee.eas.farm.carnivorous.comm.StockingComm.makeApplierF7(prmtbizPerson, SysContext.getSysContext().getCurrentAdminUnit().getString("id"), this, false);

		if(prmtstockingBatch.getValue() != null){
			//根据批次中性别设置公禽，母禽的字段隐藏显示
			StockingBatchInfo stockingBatchInfo = (StockingBatchInfo) prmtstockingBatch.getValue();
			String sex = stockingBatchInfo.getSex().getValue();
			//公，设置母禽的字段隐藏
			if(sex.equalsIgnoreCase("1")){
				//需要隐藏的字段有
				kdtEntrys.getColumn("feMaterail").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("mqlbm").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("femaleDailyQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleDeathQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleCullQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("adjustFemaleQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleBreedkingStock").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleMarketed").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("mjUniformity").getStyleAttributes().setHided(true);

				kdtEntrys.getColumn("material").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("materialName").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("materialModel").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("dailyQtyAll").getStyleAttributes().setHided(false);

				kdtAssEntrys.getColumn("deathQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("cullQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("adjustQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("breekingStock").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("avgWeight").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("markedQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("gjUniformity").getStyleAttributes().setHided(false);
			}
			//母，设置公禽的字段隐藏
			else if(sex.equalsIgnoreCase("2")){
				//需要隐藏的字段有
				kdtEntrys.getColumn("material").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("materialName").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("materialModel").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("dailyQtyAll").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("deathQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("cullQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("adjustQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("breekingStock").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("avgWeight").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("markedQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("gjUniformity").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("feMaterail").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("mqlbm").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("femaleDailyQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleDeathQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleCullQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("adjustFemaleQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleBreedkingStock").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleMarketed").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("mjUniformity").getStyleAttributes().setHided(false);
			}
			//混，不设置隐藏
		}
	}

	private void resizeKdtEntry(KDTable[] tables) {
		for(KDTable table:tables){
			for(int i=0;i<table.getColumnCount();i++){
				KDTableHelper.autoFitColumnWidth(table, i);
			}
		}
	}



	/**
	 * 设置养殖阶段
	 */
	private void setBreedStage() {
		try {
			SelectorItemCollection slor = new SelectorItemCollection();
			slor.add("*");
			slor.add("breedData.*");
			StockingBatchInfo batch = null;
			if(this.prmtstockingBatch.getValue() != null){
				batch = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((IPropertyContainer)this.prmtstockingBatch.getValue()).getString("id")));
			}else{
				return;
			}
			if(txtweekDay.getText()==null||txtweek.getText()==null){
				return;
			}
			FarmStageEnum curBreedStage = StockingComm.getCurBreedStage(null, batch.getBreedData().getId().toString(), txtweek.getText(),txtweekDay.getText());
			nowBreedStage.setSelectedItem(curBreedStage);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 设置存栏量
	 */
	private void setEntryLastStock() {
		for(int rowIndex=0;rowIndex<this.kdtAssEntrys.getRowCount();rowIndex++) {
			try {
				kdtAssEntrys_Changed(rowIndex, kdtAssEntrys.getColumnIndex("deathQty"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * 设置纯日龄
	 */
	private void setPurDayAge() {
		Integer week = txtweek.getIntegerValue();
		Integer weekDay = this.txtweekDay.getIntegerValue();
		if(week==null){
			week=0;
		}
		if(weekDay==null) {
			weekDay=0;
		}
		int age=((week-1)*7+weekDay);
		if(age<0) {
			age=0;
		}
		this.lblDayAge.setText(age+" 日龄(day)");
		this.txtsumWeekDay.setText(age+"");
	}

	@Override
	public void kdtAssEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		if(isLoadFieldLD)
			return;

		super.kdtAssEntrys_Changed(rowIndex, colIndex);
		
		//计算失重
		if(kdtAssEntrys.getColumnKey(colIndex).equals("avgWeight")
				||kdtAssEntrys.getColumnKey(colIndex).equals("femaleQty")){
			calcLossWeight(rowIndex, colIndex);
		}
		
		
		
		
		
		if(kdtAssEntrys.getColumnKey(colIndex).equals("deathQty")
				||kdtAssEntrys.getColumnKey(colIndex).equals("femaleDeathQty")
				||kdtAssEntrys.getColumnKey(colIndex).equals("cullQty")
				||kdtAssEntrys.getColumnKey(colIndex).equals("femaleCullQty")
				||kdtAssEntrys.getColumnKey(colIndex).equals("breekingStock")
				||kdtAssEntrys.getColumnKey(colIndex).equals("femaleBreekingStock")
				||kdtAssEntrys.getColumnKey(colIndex).equals("markedQty")
				||kdtAssEntrys.getColumnKey(colIndex).equals("femaleMarketed")
				||kdtAssEntrys.getColumnKey(colIndex).equals("adjustQty")
				||kdtAssEntrys.getColumnKey(colIndex).equals("adjustFemaleQty"))
		{
			if(prmtstockingBatch.getValue()==null) {
				return;
			}

			recalBreekStocking();		
			//直接调用重算即可，且下面代码未计算转栏
			//			String houseID=null;
			//			if(kdtAssEntrys.getCell(rowIndex, "house").getValue()!=null) {
			//				houseID=((IPropertyContainer) kdtAssEntrys.getCell(rowIndex, "house").getValue()).getString("id");
			//			}
			//			//bean是初始存栏量
			//			BatchLastBean bean=StockingComm.getEntryHouseBatchBean(null,this.editData.getId()!=null?this.editData.getId().toString():null,curCompanyID,(Date)this.pkBizDate.getValue(), ((IPropertyContainer) prmtstockingBatch.getValue()).getString("id"), houseID);
			//			if(bean==null) {
			//				return;
			//			}
			//			BigDecimal deathQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"deathQty").getValue());
			//			BigDecimal femaleDeathQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"femaleDeathQty").getValue());
			//			BigDecimal cullQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"cullQty").getValue());
			//			BigDecimal femaleCullQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"femaleCullQty").getValue());
			//
			//			BigDecimal adjustQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"adjustQty").getValue());
			//			BigDecimal femaleAdjustQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"adjustFemaleQty").getValue());
			//
			//
			//			//计算这一天之前，该公司，该批次，该棚舍的公禽的转入，转出
			//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//			String sql1 = "/*dialect*/  select sum(t.maleQty) maleQty from " +
			//			"( " +
			//			"select  (-1)*sum(t2.CFOutmaleQty)  maleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid" +
			//			" where t2.CFOutFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
			//			"' and t2.CFOutBatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
			//			"' and t2.CFOutHouseID='"+houseID+"' and t1.fbizdate<= { d'"+sdf.format(pkBizDate.getValue())+"'}"+
			//			" union all "+
			//			"select   sum(t2.CFOutmaleQty)  maleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid" +
			//			" where t2.CFInFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
			//			"' and t2.CFInBbatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
			//			"' and t2.CFInHouseID='"+houseID+"' and t1.fbizdate<= { d'" +sdf.format(pkBizDate.getValue())+"'}"+
			//			") t";
			//			ISQLExecutor executor1 = SQLExecutorFactory.getRemoteInstance(sql1);
			//			IRowSet rs1 = executor1.executeSQL();
			//			BigDecimal maleQty = BigDecimal.ZERO;
			//			if(rs1.next()){
			//				maleQty = rs1.getBigDecimal("maleQty");
			//				if(maleQty == null){
			//					maleQty = BigDecimal.ZERO;
			//				}else{
			//					maleQty = rs1.getBigDecimal("maleQty");
			//				}
			//			}
			//
			//			//计算这一天之前，该公司，该养殖场，该棚舍的母禽的转入、转出
			//			String sql2 ="/*dialect*/  select sum(t.CFOutFemaleQty) femaleQty from " +
			//			"( " +
			//			"select  (-1)*sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid" +
			//			" where t2.CFOutFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
			//			"' and t2.CFOutBatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
			//			"' and t2.CFOutHouseID='"+houseID+"' and t1.fbizdate<= { d '"+sdf.format(pkBizDate.getValue())+"'}"+
			//			" union all "+
			//			"select   sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid" +
			//			" where t2.CFInFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
			//			"' and t2.CFInBbatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
			//			"' and t2.CFInHouseID='"+houseID+"' and t1.fbizdate<= { d '" +sdf.format(pkBizDate.getValue())+
			//			"'}) t";
			//			ISQLExecutor executor2 = SQLExecutorFactory.getRemoteInstance(sql2);
			//			IRowSet rs2 = executor2.executeSQL();
			//			BigDecimal femaleQty = BigDecimal.ZERO;
			//			if(rs2.next()){
			//				femaleQty = rs2.getBigDecimal("femaleQty");
			//				if(femaleQty == null){
			//					femaleQty = BigDecimal.ZERO;
			//				}else{
			//					femaleQty = rs2.getBigDecimal("femaleQty");
			//				}
			//			}
			//
			//			BigDecimal lastQty=bean.getLaskStock().subtract(deathQty).subtract(cullQty).add(adjustQty).add(maleQty);
			//			BigDecimal femaleLastQty=bean.getFemaleLaskStock().subtract(femaleDeathQty).subtract(femaleCullQty).add(femaleAdjustQty).add(femaleQty);
			//
			//
			//			kdtAssEntrys.getCell(rowIndex, "breekingStock").setValue(lastQty);
			//			kdtAssEntrys.getCell(rowIndex, "femaleBreedkingStock").setValue(femaleLastQty);

			UITools.apendFootRow(kdtAssEntrys, new String[]{"deathQty","femaleDeathQty","cullQty","femaleCullQty","breekingStock","femaleBreedkingStock","adjustQty","adjustFemaleQty","cullTotalWgt","cullTotalAmt"});
		}
		if(kdtAssEntrys.getColumnKey(colIndex).equals("house")) {
			if(prmtstockingBatch.getValue()!=null&&kdtAssEntrys.getCell(rowIndex, "house").getValue()!=null) {
				BatchLastBean bean = StockingComm.getEntryHouseBatchBean(null,this.editData.getId()!=null?this.editData.getId().toString():null,curCompanyID,this.pkBizDate.getTimestamp(), ((IPropertyContainer) prmtstockingBatch.getValue()).getString("id"), ((IPropertyContainer) kdtAssEntrys.getCell(rowIndex, "house").getValue()).getString("id"));
				if(bean!=null){
					kdtAssEntrys.getCell(rowIndex,"week").setValue(bean.getWeek());
					kdtAssEntrys.getCell(rowIndex,"weekDays").setValue(bean.getWeekDays());
					kdtAssEntrys.getCell(rowIndex,"breekingStock").setValue(bean.getLaskStock());
					kdtAssEntrys.getCell(rowIndex,"femaleBreedkingStock").setValue(bean.getFemaleLaskStock());
				}else{
					kdtAssEntrys.getCell(rowIndex,"week").setValue(null);
					kdtAssEntrys.getCell(rowIndex,"weekDays").setValue(null);
					kdtAssEntrys.getCell(rowIndex,"breekingStock").setValue(null);
					kdtAssEntrys.getCell(rowIndex,"femaleBreedkingStock").setValue(null);
				}
			}else{
				kdtAssEntrys.getCell(rowIndex,"week").setValue(null);
				kdtAssEntrys.getCell(rowIndex,"weekDays").setValue(null);
				kdtAssEntrys.getCell(rowIndex,"breekingStock").setValue(null);
				kdtAssEntrys.getCell(rowIndex,"femaleBreedkingStock").setValue(null);
			}
		}
		if(kdtAssEntrys.getColumnKey(colIndex).equals("cullTotalAmt")||kdtAssEntrys.getColumnKey(colIndex).equals("cullTotalWgt")){
			if(kdtAssEntrys.getCell(rowIndex, "cullTotalAmt").getValue()!=null&&kdtAssEntrys.getCell(rowIndex, "cullTotalWgt").getValue()!=null&&UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "cullTotalWgt").getValue()).compareTo(BigDecimal.ZERO)!=0)
				kdtAssEntrys.getCell(rowIndex, "cullAvgPrice").setValue(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "cullTotalAmt").getValue()).divide(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "cullTotalWgt").getValue()),2,BigDecimal.ROUND_HALF_EVEN));
			else
				kdtAssEntrys.getCell(rowIndex, "cullAvgPrice").setValue(null);
		}
		if(kdtAssEntrys.getColumnKey(colIndex).equals("cullTotalAmt")||kdtAssEntrys.getColumnKey(colIndex).equals("cullTotalWgt"))
			UITools.apendFootRow(kdtAssEntrys, new String[]{"cullTotalAmt","cullTotalWgt"});
	}

	/**
	 * 计算失重率
	 * @param rowIndex
	 * @param colIndex
	 */
	private void calcLossWeight(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		
		FarmHouseEntryInfo houseInfo = null;
		if(kdtAssEntrys.getCell(rowIndex, "house").getValue() != null){
			houseInfo = (FarmHouseEntryInfo) kdtAssEntrys.getCell(rowIndex, "house").getValue();
			Date bizdate = (Date) pkBizDate.getValue();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String s1 = "/*dialect*/ select t2.FFemaleQty CFFemaleLossW,t2.FAvgWeight   CFMaleLossW from" +
					" T_FM_StockingBreedDaily t1 inner join T_FM_StockingBDAE t2 on t2.FPARENTID =t1.fid" +
					" where t2.FHouseID = '"+houseInfo.getId()+"' and to_date(to_char(t1.fbizdate,'yyyy-mm-dd'),'yyyy-mm-dd')={d '"+sdf.format(bizdate)+"'}-1";
			IRowSet r1;
			
			//昨日
			BigDecimal CFFemaleLossW = BigDecimal.ZERO;
			BigDecimal CFMaleLossW = BigDecimal.ZERO;
			//当日
			BigDecimal femaleLossW = UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "femaleQty").getValue());
			BigDecimal maleLossW = UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "avgWeight").getValue());
			try {
				r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
				if(r1.next()){
					CFFemaleLossW = UIRuleUtil.getBigDecimal(r1.getBigDecimal("CFFemaleLossW"));
					CFMaleLossW = UIRuleUtil.getBigDecimal(r1.getBigDecimal("CFMaleLossW"));
				}
				//计算母禽失重率
				if(CFFemaleLossW.compareTo(BigDecimal.ZERO) == 0){
					kdtAssEntrys.getCell(rowIndex, "femaleLossRate").setValue(BigDecimal.ZERO);
				}else{
					kdtAssEntrys.getCell(rowIndex, "femaleLossRate").setValue(femaleLossW.divide(CFFemaleLossW,6,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")));
				}
				
				//计算公禽失重率
				if(CFMaleLossW.compareTo(BigDecimal.ZERO) == 0){
					kdtAssEntrys.getCell(rowIndex, "maleLossRate").setValue(BigDecimal.ZERO);
				}else{
					kdtAssEntrys.getCell(rowIndex, "maleLossRate").setValue(maleLossW.divide(CFMaleLossW,6,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")));
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
			
			
			
			
		}
		
		
	}

	//免疫分录添加合计行，并且能够实时计算
	@Override
	public void kdtImmuneEntrys_Changed(int rowIndex, int colIndex)
	throws Exception {
		// TODO Auto-generated method stub
		super.kdtImmuneEntrys_Changed(rowIndex, colIndex);

		BigDecimal qcEggQty=UIRuleUtil.getBigDecimal(kdtImmuneEntrys.getCell(rowIndex,"vaccineGetQty").getValue());
		BigDecimal smallEggQty=UIRuleUtil.getBigDecimal(kdtImmuneEntrys.getCell(rowIndex,"vaccineUsedQty").getValue());
		UITools.apendFootRow(kdtImmuneEntrys, new String[]{"vaccineGetQty","vaccineUsedQty"});
	}


	//产蛋信息添加监听事件
	@Override
	public void kdtEggEntry_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEggEntry_Changed(rowIndex, colIndex);
		if(kdtEggEntry.getColumnKey(colIndex).equals("qcEggQty")
				||kdtEggEntry.getColumnKey(colIndex).equals("smallEggQty")
				||kdtEggEntry.getColumnKey(colIndex).equals("fxd")
				||kdtEggEntry.getColumnKey(colIndex).equals("brokenQty")
				||kdtEggEntry.getColumnKey(colIndex).equals("doubleQty")
				||kdtEggEntry.getColumnKey(colIndex).equals("mutnatQty")
				||kdtEggEntry.getColumnKey(colIndex).equals("firstQty")
				||kdtEggEntry.getColumnKey(colIndex).equals("rd")
//				||kdtEggEntry.getColumnKey(colIndex).equals("BBQty")
				||kdtEggEntry.getColumnKey(colIndex).equals("zd")
				||kdtEggEntry.getColumnKey(colIndex).equals("totalLossQty")
				||kdtEggEntry.getColumnKey(colIndex).equals("allQty")
		){
			//20190509 macheng add//20190522 edited by sun
			// 总蛋数 = 合格蛋数 +不合格蛋 +BB蛋
			// 不合格蛋=商品蛋+全损蛋+其它项 
			// 商品蛋 =小蛋+畸形蛋+双黄蛋 +破蛋+脏蛋+初产蛋+BB蛋
			//合格蛋数
			BigDecimal qcEggQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"qcEggQty").getValue());
			//小蛋
			BigDecimal fxd=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"fxd").getValue());
			//双黄蛋
			BigDecimal doubleQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"doubleQty").getValue());
			//破蛋
			BigDecimal brokenQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"brokenQty").getValue());
			//畸形蛋
			BigDecimal mutnatQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"mutnatQty").getValue());
			//初产蛋--修改为宝宝蛋
			BigDecimal firstQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"firstQty").getValue());
			//脏蛋
			BigDecimal zd=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"zd").getValue());
			//其它项
			BigDecimal rd=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"rd").getValue());
			
			//BB蛋
//			BigDecimal BBQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"BBQty").getValue());

			
			
			//商品蛋
			BigDecimal smallEggQty=fxd.add(doubleQty).add(brokenQty).add(firstQty).add(mutnatQty).add(zd);
			kdtEggEntry.getCell(rowIndex, "smallEggQty").setValue(smallEggQty);
			
			//总蛋数
			BigDecimal allQty=smallEggQty.add(qcEggQty);
			kdtEggEntry.getCell(rowIndex, "allQty").setValue(allQty);
			//BigDecimal allQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"allQty").getValue());
			//不合格蛋
			BigDecimal unQCEgg =allQty.subtract(qcEggQty);
			kdtEggEntry.getCell(rowIndex, "unQCEgg").setValue(unQCEgg);

			//全损蛋	
			BigDecimal totalLossQty=unQCEgg.subtract(smallEggQty).subtract(rd);
			kdtEggEntry.getCell(rowIndex, "totalLossQty").setValue(totalLossQty);

			UITools.apendFootRow(kdtEggEntry, new String[]{"allQty","qcEggQty","smallEggQty","fxd","doubleQty","brokenQty","mutnatQty","firstQty","rd","zd","totalLossQty","unQCEgg"});
		}
	}

	@Override
	public void storeFields() {
		// TODO Auto-generated method stub
		super.storeFields();
		this.editData.setWeek(StringUtils.isNotEmpty(this.txtweek.getText())?Integer.valueOf(this.txtweek.getText()):0);
		this.editData.setWeekDay(StringUtils.isNotEmpty(this.txtweekDay.getText())?Integer.valueOf(this.txtweekDay.getText()):0);
	}


	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StringBuffer sbuff = new StringBuffer();
		sbuff.append("/*dialect*/ select fid billid from T_FM_StockingBreedDaily where FBizDate = {d '");
		sbuff.append(sdf.format(pkBizDate.getValue()));
		sbuff.append("'} and CFStockingBatchID = '");
		sbuff.append(((StockingBatchInfo)prmtstockingBatch.getValue()).getId());
		sbuff.append("'");
		if(editData.getId() != null){
			sbuff.append(" and fid !='");sbuff.append(editData.getId());sbuff.append("'");
		}
		IRowSet r1 = SQLExecutorFactory.getRemoteInstance(sbuff.toString()).executeSQL();
		if(r1.next()){
			MsgBox.showWarning("该批次在"+sdf.format(editData.getBizDate())+" 的养殖日报已经存在，禁止保存！");
			SysUtil.abort();
		}


		super.actionSubmit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
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
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)) {
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
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
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
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		orgInfo = SysContext.getSysContext().getCurrentStorageUnit();	
		try {

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date bizDate=sdf.parse(sdf.format(new Date()));

			Calendar cal=Calendar.getInstance();
			cal.setTime(bizDate);
			cal.add(Calendar.DAY_OF_MONTH, 0);
			objectValue.setBizDate(cal.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		curStorageOrgUnitID=StockingClientComm.checkAndGetStorageOrgUnitID();
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		super.onLoad();
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
		((KDFormattedTextField)kdtAssEntrys.getColumn("cullAvgPrice").getEditor().getComponent()).setPrecision(2);
		kdtTransEntry_detailPanel.getRemoveLinesButton().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent paramMouseEvent) {
				super.mouseClicked(paramMouseEvent);
				recalBreekStocking();
			}});
		for(int i=0;i<kdTabPanelMain.getTabCount();i++){
			Component d = kdTabPanelMain.getComponentAt(i);
			if(d.getName().equalsIgnoreCase("kDPanelTrans")||d.getName().equalsIgnoreCase("kDPanelSendEgg")) {
				this.kdTabPanelMain.removeTabAt(i);
			}
		}		

		//enter键方向
		KDTableHelper.setEnterKeyJumpOrientation(kdtAssEntrys, Orientation.HORIZONTAL.getValue());
		KDTableHelper.setEnterKeyJumpOrientation(kdtEntrys, Orientation.HORIZONTAL.getValue());
		KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntry, Orientation.HORIZONTAL.getValue());
		KDTableHelper.setEnterKeyJumpOrientation(kdtTransEntry, Orientation.HORIZONTAL.getValue());
		KDTableHelper.setEnterKeyJumpOrientation(kdtImmuneEntrys, Orientation.HORIZONTAL.getValue());
		KDTableHelper.setEnterKeyJumpOrientation(kdtEnvi, Orientation.HORIZONTAL.getValue());
		KDTableHelper.setEnterKeyJumpOrientation(kdtDrugEntrys, Orientation.HORIZONTAL.getValue());

		EntityViewInfo ev=new EntityViewInfo();
		SorterItemCollection sorter = new SorterItemCollection();
		SorterItemInfo item = new SorterItemInfo("name");
		item.setSortType(SortType.ASCEND);
		sorter.add(item);
		ev.setSorter(sorter);
		this.prmtfarmer.setEntityViewInfo(ev);

		this.btnCopyFrom.setVisible(false);
		this.btnCopy.setVisible(false);
		this.menuItemCopy.setVisible(false);
		this.menuItemCopyFrom.setVisible(false);

//		kdtEggEntry.getColumn("BBQty").getStyleAttributes().setHided(true);
		kdtEggEntry.getColumn("BBQty").getStyleAttributes().setLocked(true);
//		kdtEggEntry.getColumn("BBQty").getStyleAttributes().isHided();
		
		//如果批次不为空，设置隐藏
		if(prmtstockingBatch.getValue() != null){
			kdtEggEntry.getColumn("BBQty").getStyleAttributes().setHided(true);
			//根据批次中性别设置公禽，母禽的字段隐藏显示
			StockingBatchInfo stockingBatchInfo = (StockingBatchInfo) prmtstockingBatch.getValue();
			String sex = stockingBatchInfo.getSex().getValue();
			//公，设置母禽的字段隐藏
			if(sex.equalsIgnoreCase("1")){
				//需要隐藏的字段有
				kdtEntrys.getColumn("feMaterail").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("mqlbm").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("femaleDailyQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleDeathQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleCullQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("adjustFemaleQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleBreedkingStock").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleMarketed").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("mjUniformity").getStyleAttributes().setHided(true);

				kdtEntrys.getColumn("material").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("materialName").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("materialModel").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("dailyQtyAll").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("deathQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("cullQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("adjustQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("breekingStock").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("avgWeight").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("markedQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("gjUniformity").getStyleAttributes().setHided(false);

			}
			//母，设置公禽的字段隐藏
			else if(sex.equalsIgnoreCase("2")){
				//需要隐藏的字段有
				kdtEntrys.getColumn("material").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("materialName").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("materialModel").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("dailyQtyAll").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("deathQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("cullQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("adjustQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("breekingStock").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("avgWeight").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("markedQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("gjUniformity").getStyleAttributes().setHided(true);


				kdtEntrys.getColumn("feMaterail").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("mqlbm").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("femaleDailyQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleDeathQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleCullQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("adjustFemaleQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleBreedkingStock").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleMarketed").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("mjUniformity").getStyleAttributes().setHided(false);

			}
			//混，不设置隐藏
		}




		//转预产添加监听事件
		this.chkpreEgg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isPreEggPerform(e);
			}

		});


		//转产蛋添加监听事件
		this.chkisMature.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isMatrurePerform(e);
			}
		});


		//转育成加监听事件
		this.chkisBreed.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				isBreedPerform(e);

			}
		});


	}


	//转预产
	protected void isPreEggPerform(ActionEvent e) {
		// TODO Auto-generated method stub

		StockingBatchInfo StockingBatchInfo = null;
		if(this.prmtstockingBatch.getValue() != null){
			StockingBatchInfo = (StockingBatchInfo) this.prmtstockingBatch.getValue();
		}else{
			return;
		}
		//新建成本对象
		CostObjectInfo costObjectInfo = null;

		if(this.chkpreEgg.isSelected()){
			this.nowBreedStage.setSelectedItem(FarmStageEnum.purEggs);
			this.chkisBreed.setEnabled(false);
			this.chkisMature.setEnabled(false);

			//设置预产成本对象
			String preCostObjectid = null;
			if(StockingBatchInfo.getPreCostObject() != null){
				preCostObjectid = StockingBatchInfo.getPreCostObject().getId().toString();
			}else{
				MsgBox.showWarning("该批次没有设置预产成本对象");
			}
			try {
				costObjectInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(preCostObjectid));
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.prmtcurrentCostObject.setValue(costObjectInfo);

		}else{
			this.nowBreedStage.setSelectedItem(FarmStageEnum.breed);
			this.chkisBreed.setEnabled(true);
			this.chkisMature.setEnabled(true);

			//育成成本对象id
			String breedCostObjectid = null;
			if(StockingBatchInfo.getCostItem() != null){
				breedCostObjectid = StockingBatchInfo.getCostItem().getId().toString();
			}else{
				MsgBox.showWarning("该批次没有设置育成成本对象");
			}
			try {
				costObjectInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(breedCostObjectid));
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.prmtcurrentCostObject.setValue(costObjectInfo);

		}

	}

	//转产蛋
	protected void isMatrurePerform(ActionEvent e) {
		// TODO Auto-generated method stub

		StockingBatchInfo StockingBatchInfo = null;
		if(this.prmtstockingBatch.getValue() != null){
			StockingBatchInfo = (StockingBatchInfo) this.prmtstockingBatch.getValue();
		}else{
			return;
		}
		//新建成本对象
		CostObjectInfo costObjectInfo = null;

		if(this.chkisMature.isSelected()){
			this.nowBreedStage.setSelectedItem(FarmStageEnum.eggs);
			this.chkisBreed.setEnabled(false);
			this.chkpreEgg.setEnabled(false);

			//如果转产蛋是选中状态，现在所处状态是‘产蛋期’
			String eggCostObjectid = null;
			if(StockingBatchInfo.getEggCostItem() != null){
				eggCostObjectid = StockingBatchInfo.getEggCostItem().getId().toString();
			}else{
				MsgBox.showWarning("该批次没有设置产蛋成本对象");
			}
			try {
				costObjectInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(eggCostObjectid));
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.prmtcurrentCostObject.setValue(costObjectInfo);
		}else{
			this.nowBreedStage.setSelectedItem(FarmStageEnum.purEggs);
			this.chkisBreed.setEnabled(true);
			this.chkpreEgg.setEnabled(true);

			//设置预产成本对象
			String preCostObjectid = null;
			if(StockingBatchInfo.getPreCostObject() != null){
				preCostObjectid = StockingBatchInfo.getPreCostObject().getId().toString();
			}else{
				MsgBox.showWarning("该批次没有设置预产成本对象");
			}
			try {
				costObjectInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(preCostObjectid));
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.prmtcurrentCostObject.setValue(costObjectInfo);

		}
	}

	//转育成--
	protected void isBreedPerform(ActionEvent e) {
		// TODO Auto-generated method stub

		StockingBatchInfo StockingBatchInfo = null;
		if(this.prmtstockingBatch.getValue() != null){
			StockingBatchInfo = (StockingBatchInfo) this.prmtstockingBatch.getValue();
		}else{
			return;
		}
		//新建成本对象
		CostObjectInfo costObjectInfo = null;

		if(this.chkisBreed.isSelected()){
			this.nowBreedStage.setSelectedItem(FarmStageEnum.breed);
			this.chkisMature.setEnabled(false);
			this.chkpreEgg.setEnabled(false);

			//育成成本对象id
			String breedCostObjectid = null;
			if(StockingBatchInfo.getCostItem() != null){
				breedCostObjectid = StockingBatchInfo.getCostItem().getId().toString();
			}else{
				MsgBox.showWarning("该批次没有设置育成成本对象");
			}
			try {
				costObjectInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(breedCostObjectid));
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.prmtcurrentCostObject.setValue(costObjectInfo);

		}else{
			this.nowBreedStage.setSelectedItem(FarmStageEnum.brood);
			this.chkisMature.setEnabled(true);
			this.chkpreEgg.setEnabled(true);


			//育雏成本对象id
			String broodCostObjectid = null;
			if(StockingBatchInfo.getBroodCostObject() != null){
				broodCostObjectid = StockingBatchInfo.getBroodCostObject().getId().toString();
			}else{
				MsgBox.showWarning("该批次没有设置育雏成本对象");
			}
			try {
				costObjectInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(broodCostObjectid));
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.prmtcurrentCostObject.setValue(costObjectInfo);
		}
	}





	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}

		this.pkBizDate.setDatePattern("yyyy-MM-dd");

		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		kdtEntrys.checkParsed();
		kdtEggEntry.checkParsed();
		kdtImmuneEntrys.checkParsed();

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("feMaterail").getEditor().getComponent(), null, null, orgInfo,false);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEggEntry.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEggEntry, "material", "unit");

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtImmuneEntrys.getColumn("vaccineMaterial").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtDrugEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);


		this.kdtEntrys.getColumn("unitQty").getStyleAttributes().setNumberFormat("#.00");
		this.kdtEntrys.getColumn("bagQty").getStyleAttributes().setNumberFormat("#.00");

		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});


		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(!isLoadField) {
					if(isfarm){
						//根据养殖户带出养殖场
						FarmInfo farmInfo = null;
						FarmersInfo farmersInfo = null;
						if(prmtfarmer.getValue() != null){
							farmersInfo = (FarmersInfo) prmtfarmer.getValue();
							String s1 = "/*dialect*/ select t2.FFarmID farmid from T_FM_Farmers t1" +
							" inner join T_FM_FarmersFarmEntry t2 on t2.FParentID = t1.fid" +
							" where t1.fid ='"+farmersInfo.getId()+"'";
							IRowSet r1;
							try {
								r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
								String farmid = null;
								if(r1.next()){
									farmid = r1.getString("farmid");
									farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmid));
									isfarmer = false;
									prmtfarm.setValue(farmInfo);
								}
							} catch (BOSException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (EASBizException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
					}
				}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				farm_changed(e);
				if(isfarmer){
					//根据养殖场设置养殖户
					String farmID=null;
					FarmersInfo farmersInfo = null;
					if(prmtfarm.getValue()!=null) {
						farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
						try {
							String s1 = " /*dialect*/ select t1.fid farmerid from T_FM_Farmers t1 inner join T_FM_FarmersFarmEntry t2 on t2.FParentID = t1.fid where t2.FFarmID ='"+farmID+"'";
							IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
							String farmid = null;
							if(r1.next()){
								farmid = r1.getString("farmerid");
								farmersInfo = FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(farmid));
								isfarm = false;
								prmtfarmer.setValue(farmersInfo);
							}
						}catch(Exception err) {
							err.printStackTrace();
						}
					}
				}
				setBatchFilter();
				setHouseFilter();
			}});

		this.prmtstockingBatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				try {
					batch_changed();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}});

		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				try {
					date_changed();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});

		//棚舍信息
		KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox.setVisible(true);
		kdtEntrys_material_PromptBox.setEditable(true);
		kdtEntrys_material_PromptBox.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox.setEditFormat("$name$");
		kdtEntrys_material_PromptBox.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
		this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor);
		ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
		kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR);

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
		this.kdtAssEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor1);  
		this.kdtAssEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR1);

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
		this.kdtEggEntry.getColumn("house").setEditor(kdtEntrys_material_CellEditor2);  
		this.kdtEggEntry.getColumn("house").setRenderer(kdtEntrys_material_OVR2);

		KDBizPromptBox kdtEntrys_material_PromptBox3 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox3.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox3.setVisible(true);
		kdtEntrys_material_PromptBox3.setEditable(true);
		kdtEntrys_material_PromptBox3.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox3.setEditFormat("$name$");
		kdtEntrys_material_PromptBox3.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor3 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox3);
		ObjectValueRender kdtEntrys_material_OVR3 = new ObjectValueRender();
		kdtEntrys_material_OVR3.setFormat(new BizDataFormat("$name$"));
		this.kdtImmuneEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor3);  
		this.kdtImmuneEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR3);

		KDBizPromptBox kdtEntrys_material_PromptBox4 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox4.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox4.setVisible(true);
		kdtEntrys_material_PromptBox4.setEditable(true);
		kdtEntrys_material_PromptBox4.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox4.setEditFormat("$name$");
		kdtEntrys_material_PromptBox4.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor4 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox4);
		ObjectValueRender kdtEntrys_material_OVR4 = new ObjectValueRender();
		kdtEntrys_material_OVR4.setFormat(new BizDataFormat("$name$"));
		this.kdtTransEntry.getColumn("house").setEditor(kdtEntrys_material_CellEditor4);  
		this.kdtTransEntry.getColumn("house").setRenderer(kdtEntrys_material_OVR4);

		KDBizPromptBox kdtEntrys_material_PromptBox5 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox5.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox5.setVisible(true);
		kdtEntrys_material_PromptBox5.setEditable(true);
		kdtEntrys_material_PromptBox5.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox5.setEditFormat("$name$");
		kdtEntrys_material_PromptBox5.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor5 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox5);
		ObjectValueRender kdtEntrys_material_OVR5 = new ObjectValueRender();
		kdtEntrys_material_OVR5.setFormat(new BizDataFormat("$name$"));
		this.kdtTransEntry.getColumn("fromHouse").setEditor(kdtEntrys_material_CellEditor5);  
		this.kdtTransEntry.getColumn("fromHouse").setRenderer(kdtEntrys_material_OVR5);

		KDBizPromptBox kdtEntrys_material_PromptBox6 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox6.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox6.setVisible(true);
		kdtEntrys_material_PromptBox6.setEditable(true);
		kdtEntrys_material_PromptBox6.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox6.setEditFormat("$name$");
		kdtEntrys_material_PromptBox6.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor6 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox6);
		ObjectValueRender kdtEntrys_material_OVR6 = new ObjectValueRender();
		kdtEntrys_material_OVR6.setFormat(new BizDataFormat("$name$"));
		this.kdtEnvi.getColumn("house").setEditor(kdtEntrys_material_CellEditor6);  
		this.kdtEnvi.getColumn("house").setRenderer(kdtEntrys_material_OVR6);

		KDBizPromptBox kdtEntrys_material_PromptBox7 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox7.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox7.setVisible(true);
		kdtEntrys_material_PromptBox7.setEditable(true);
		kdtEntrys_material_PromptBox7.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox7.setEditFormat("$name$");
		kdtEntrys_material_PromptBox7.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor7 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox7);
		ObjectValueRender kdtEntrys_material_OVR7 = new ObjectValueRender();
		kdtEntrys_material_OVR7.setFormat(new BizDataFormat("$name$"));
		this.kdtSendEggEntry.getColumn("house").setEditor(kdtEntrys_material_CellEditor7);  
		this.kdtSendEggEntry.getColumn("house").setRenderer(kdtEntrys_material_OVR7);

		KDBizPromptBox kdtEntrys_material_PromptBox8 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox8.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox8.setVisible(true);
		kdtEntrys_material_PromptBox8.setEditable(true);
		kdtEntrys_material_PromptBox8.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox8.setEditFormat("$name$");
		kdtEntrys_material_PromptBox8.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor8 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox7);
		ObjectValueRender kdtEntrys_material_OVR8 = new ObjectValueRender();
		kdtEntrys_material_OVR8.setFormat(new BizDataFormat("$name$"));
		this.kdtDrugEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor8);  
		this.kdtDrugEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR8);

		this.kdtAssEntrys.getColumn("weekDays").getStyleAttributes().setNumberFormat("#");
		this.kdtAssEntrys.getColumn("femaleDeathQty").getStyleAttributes().setNumberFormat("#");
		this.kdtAssEntrys.getColumn("femaleCullQty").getStyleAttributes().setNumberFormat("#");
		this.kdtAssEntrys.getColumn("femaleBreedkingStock").getStyleAttributes().setNumberFormat("#");
		this.kdtEggEntry.getColumn("allQty").getStyleAttributes().setNumberFormat("#");
		this.kdtEggEntry.getColumn("runQty").getStyleAttributes().setNumberFormat("#");

		//检查是否具有初始化权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isInitStockingBatchCrt");
			this.chkisInit.setVisible(true);
		}catch(Exception err) {
			this.chkisInit.setVisible(false);
		}      
		this.kdtTransEntry_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent e) throws Exception {

			}
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				((StockingBreedDailyTransEntryInfo)e.getObjectValue()).setFromStockingBatch((StockingBatchInfo) prmtstockingBatch.getValue());
				((StockingBreedDailyTransEntryInfo)e.getObjectValue()).setFromFarmers((FarmersInfo) prmtfarmer.getValue());
				((StockingBreedDailyTransEntryInfo)e.getObjectValue()).setFromFarm((FarmInfo) prmtfarm.getValue());
			}});


		//给转栏分录添加监听事件
		this.kdtTransEntry.addKDTEditListener(new KDTEditAdapter(){
			public void editStarted(KDTEditEvent e) {
				kdtTransEntry_editStarted(e);
			}

			@Override
			public void editStopped(KDTEditEvent e) {
				kdtTransEntry_editStoped(e);
			}});

		//免疫信息分录添加监听事件
		this.kdtImmuneEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);

				//计算存栏Map
				Map<String,BigDecimal> assEntryMap = calStockingMap(e);


				if("vaccineUsedQty".equalsIgnoreCase(kdtImmuneEntrys.getColumn(e.getColIndex()).getKey())
						&& kdtImmuneEntrys.getCell(e.getRowIndex(), "house").getValue() != null
						&& kdtImmuneEntrys.getCell(e.getRowIndex(), "vaccineMaterial").getValue() != null){
					//使用数量
					BigDecimal vaccineUsedQty = UIRuleUtil.getBigDecimal(kdtImmuneEntrys.getCell(e.getRowIndex(), "vaccineUsedQty").getValue());
					//物料
					MaterialInfo matInfo = (MaterialInfo) kdtImmuneEntrys.getCell(e.getRowIndex(), "vaccineMaterial").getValue();
					//换算系数
					BigDecimal transRate = calcTransRate(matInfo);
					//棚舍
					FarmHouseEntryInfo houseInfo = (FarmHouseEntryInfo) kdtImmuneEntrys.getCell(e.getRowIndex(), "house").getValue();

					if(assEntryMap.get(houseInfo.getId().toString()) != null){
						kdtImmuneEntrys.getCell(e.getRowIndex(), "dose").setValue(vaccineUsedQty
								.divide(assEntryMap.get(houseInfo.getId().toString()),5,BigDecimal.ROUND_HALF_UP)
								.multiply(transRate));
					}
				}
			}

		});

		//用药信息分录添加监听事件
		this.kdtDrugEntrys.addKDTEditListener(new KDTEditAdapter(){
			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				//计算存栏Map
				Map<String,BigDecimal> assEntryMap = calStockingMap(e);
				if("drugQuantity".equalsIgnoreCase(kdtDrugEntrys.getColumn(e.getColIndex()).getKey())
						&& kdtDrugEntrys.getCell(e.getRowIndex(), "house").getValue() != null
						&& kdtDrugEntrys.getCell(e.getRowIndex(), "material").getValue() != null){
					//使用数量
					BigDecimal vaccineUsedQty = UIRuleUtil.getBigDecimal(kdtDrugEntrys.getCell(e.getRowIndex(), "drugQuantity").getValue());
					//物料
					MaterialInfo matInfo = (MaterialInfo) kdtDrugEntrys.getCell(e.getRowIndex(), "material").getValue();
					//换算系数
					BigDecimal transRate = calcTransRate(matInfo);
					//棚舍
					FarmHouseEntryInfo houseInfo = (FarmHouseEntryInfo) kdtDrugEntrys.getCell(e.getRowIndex(), "house").getValue();

					if(assEntryMap.get(houseInfo.getId().toString()) != null){
						kdtDrugEntrys.getCell(e.getRowIndex(), "dose").setValue(vaccineUsedQty
								.divide(assEntryMap.get(houseInfo.getId().toString()),5,BigDecimal.ROUND_HALF_UP)
								.multiply(transRate));
					}
				}
			}

		});

		/**
		 * 计算产蛋率
		 */
		this.kdtEggEntry.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				//计算存栏Map
				Map<String,BigDecimal> assEntryMap = calStockingMapEgg(e);
				if("allQty".equalsIgnoreCase(kdtEggEntry.getColumn(e.getColIndex()).getKey())
						&& kdtEggEntry.getCell(e.getRowIndex(), "house").getValue() != null){
					//使用数量
					BigDecimal vaccineUsedQty = UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(e.getRowIndex(), "allQty").getValue());
					//棚舍
					FarmHouseEntryInfo houseInfo = (FarmHouseEntryInfo) kdtEggEntry.getCell(e.getRowIndex(), "house").getValue();

					if(UIRuleUtil.isNotNull(assEntryMap.get(houseInfo.getId().toString()))){
						kdtEggEntry.getCell(e.getRowIndex(), "eggRate").setValue(vaccineUsedQty
								.divide(assEntryMap.get(houseInfo.getId().toString()),2,BigDecimal.ROUND_HALF_UP));
					}
				}
			}

		});

		setHouseFilter();
	}

	/**
	 * 通过物料获取该物料的采购也签的系数
	 * @param matInfo
	 * @return
	 */
	protected BigDecimal calcTransRate(MaterialInfo matInfo) {
		// TODO Auto-generated method stub
		BigDecimal transRate = BigDecimal.ZERO;
		if(prmtcompany.getValue() != null){
			CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) prmtcompany.getValue();
			String s1 = "/*dialect*/ select t1.cfkdnumbertextfield transRate from T_BD_MaterialPurchasing t1 inner join T_ORG_BaseUnit t2 on t1.FOrgUnit = t2.fid" +
			" where t2.fid = '"+companyInfo.getId()+"' and t1.FMaterialID = '"+matInfo.getId()+"'";
			try {
				IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
				if(r1.next()){
					transRate = UIRuleUtil.getBigDecimal(r1.getBigDecimal("transRate"));
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
		}
		return transRate;
	}

	/**
	 * 设置存栏Map
	 * @param e
	 * @return 
	 */
	protected Map<String, BigDecimal> calStockingMap(KDTEditEvent e) {
		// TODO Auto-generated method stub
		if(prmtstockingBatch.getValue() != null){

			StockingBatchInfo stockingBatchInfo = (StockingBatchInfo) prmtstockingBatch.getValue();
			//sex = 1 表示公，sex=2 代表母，sex= 3 代表混
			String sex = stockingBatchInfo.getSex().getValue();

			//遍历死淘信息分录获取公禽和母禽的存栏量总和
			//获取死淘分录的集合
			//定义一个Map存放棚舍id和公禽母禽存栏量的总和
			Map<String,BigDecimal> assEntryMap = new HashMap<String,BigDecimal>();
			//定义一个死淘分录的对象 
			String houseID = null;
			BigDecimal mealQty = BigDecimal.ZERO;
			BigDecimal feMealQty = BigDecimal.ZERO;
			BigDecimal allStockingQty = BigDecimal.ZERO;
			for(int i=0;i<kdtAssEntrys.getRowCount();i++){
				//棚舍
				if(kdtAssEntrys.getCell(i,"house").getValue() != null){
					houseID= ((FarmHouseEntryInfo) kdtAssEntrys.getCell(i,"house").getValue()).getId().toString();
				}
				//公禽存栏量
				if(sex.equalsIgnoreCase("1") || sex.equalsIgnoreCase("3")){
					if(String.valueOf(kdtAssEntrys.getCell(i,"breekingStock").getValue()) != null){
						mealQty = UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"breekingStock").getValue())
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"markedQty").getValue()))
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"cullQty").getValue()))
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"deathQty").getValue()));
					}
				}else{
					mealQty = BigDecimal.ZERO;
				}

				//母禽存栏量
				if(sex.equalsIgnoreCase("2") || sex.equalsIgnoreCase("3")){
					if(String.valueOf(kdtAssEntrys.getCell(i,"femaleBreedkingStock").getValue()) != null){
						feMealQty = UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"femaleBreedkingStock").getValue())
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"femaleMarketed").getValue()))
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"femaleCullQty").getValue()))
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"femaleDeathQty").getValue()));
					}
				}else{
					feMealQty = BigDecimal.ZERO;
				}
				feMealQty = feMealQty==null ? BigDecimal.ZERO : feMealQty;
				allStockingQty = mealQty.add(feMealQty);
				assEntryMap.put(houseID, allStockingQty);
			}

			return assEntryMap;

		}
		return globalServices;
	}


	/**
	 * 设置存栏Map--产蛋率只算母禽
	 * @param e
	 * @return 
	 */
	protected Map<String, BigDecimal> calStockingMapEgg(KDTEditEvent e) {
		// TODO Auto-generated method stub
		if(prmtstockingBatch.getValue() != null){

			StockingBatchInfo stockingBatchInfo = (StockingBatchInfo) prmtstockingBatch.getValue();
			//sex = 1 表示公，sex=2 代表母，sex= 3 代表混
			String sex = stockingBatchInfo.getSex().getValue();

			//遍历死淘信息分录获取公禽和母禽的存栏量总和
			//获取死淘分录的集合
			//定义一个Map存放棚舍id和公禽母禽存栏量的总和
			Map<String,BigDecimal> assEntryMap = new HashMap<String,BigDecimal>();
			//定义一个死淘分录的对象 
			String houseID = null;
			BigDecimal mealQty = BigDecimal.ZERO;
			BigDecimal feMealQty = BigDecimal.ZERO;
			BigDecimal allStockingQty = BigDecimal.ZERO;
			for(int i=0;i<kdtAssEntrys.getRowCount();i++){
				//棚舍
				if(kdtAssEntrys.getCell(i,"house").getValue() != null){
					houseID= ((FarmHouseEntryInfo) kdtAssEntrys.getCell(i,"house").getValue()).getId().toString();
				}

				//母禽存栏量
				if(sex.equalsIgnoreCase("2") || sex.equalsIgnoreCase("3")){
					if(String.valueOf(kdtAssEntrys.getCell(i,"femaleBreedkingStock").getValue()) != null){
						feMealQty = UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"femaleBreedkingStock").getValue())
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"femaleMarketed").getValue()))
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"femaleCullQty").getValue()))
						.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i,"femaleDeathQty").getValue()));
					}
				}else{
					feMealQty = BigDecimal.ZERO;
				}
				feMealQty = feMealQty==null ? BigDecimal.ZERO : feMealQty;
				allStockingQty = mealQty.add(feMealQty);
				assEntryMap.put(houseID, allStockingQty);
			}

			return assEntryMap;

		}
		return globalServices;
	}



	/**
	 * 转栏分录开始编辑
	 * @param e
	 */
	private void kdtTransEntry_editStarted(KDTEditEvent e) {
		if(e.getColIndex()==kdtTransEntry.getColumnIndex("fromFarm")) {
			String farmerID=null;
			if(kdtTransEntry.getCell(e.getRowIndex(), "fromFarmers").getValue()!=null) {
				farmerID=((IPropertyContainer) kdtTransEntry.getCell(e.getRowIndex(), "fromFarmers").getValue()).getString("id");
			}
			StockingClientComm.setFarmFilter((KDBizPromptBox) kdtTransEntry.getColumn("fromFarm").getEditor().getComponent(), null, farmerID);
		}
		if(e.getColIndex()==kdtTransEntry.getColumnIndex("fromStockingBatch")) {
			String farmerID=null,farmID=null,houseID=null;
			if(kdtTransEntry.getCell(e.getRowIndex(), "fromFarmers").getValue()!=null) {
				farmerID=((IPropertyContainer) kdtTransEntry.getCell(e.getRowIndex(), "fromFarmers").getValue()).getString("id");
			}
			if(kdtTransEntry.getCell(e.getRowIndex(), "fromFarm").getValue()!=null) {
				farmID=((IPropertyContainer) kdtTransEntry.getCell(e.getRowIndex(), "fromFarm").getValue()).getString("id");
			}
			if(kdtTransEntry.getCell(e.getRowIndex(), "fromHouse").getValue()!=null) {
				houseID=((IPropertyContainer) kdtTransEntry.getCell(e.getRowIndex(), "fromHouse").getValue()).getString("id");
			}
			StockingClientComm.setStockingBatchFilter(((KDBizPromptBox) kdtTransEntry.getColumn("fromStockingBatch").getEditor().getComponent()), null, farmerID, farmID, houseID);
		}
		if(e.getColIndex()==kdtTransEntry.getColumnIndex("fromHouse")) {
			String batchID=null,farmID=null;
			if(kdtTransEntry.getCell(e.getRowIndex(), "fromStockingBatch").getValue()!=null) {
				batchID=((IPropertyContainer) kdtTransEntry.getCell(e.getRowIndex(), "fromStockingBatch").getValue()).getString("id");
			}
			if(kdtTransEntry.getCell(e.getRowIndex(), "fromFarm").getValue()!=null) {
				farmID=((IPropertyContainer) kdtTransEntry.getCell(e.getRowIndex(), "fromFarm").getValue()).getString("id");
			}
			//yumingxu20180903
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("company.id",farmID,CompareType.EQUALS));
			EntityViewInfo ev=new EntityViewInfo();
			ev.setFilter(filter);
		}
	}
	/**
	 * 转栏分录开始编辑
	 * @param e
	 */
	private void kdtTransEntry_editStoped(KDTEditEvent e) {
		if(kdtTransEntry.getColumnKey(e.getColIndex()).equalsIgnoreCase("fromStockingBatch")) {
			IObjectValue stockingBatch = (IObjectValue) kdtTransEntry.getCell(e.getRowIndex(), "fromStockingBatch").getValue();
			if(stockingBatch!=null) {
				try {
					kdtTransEntry.getCell(e.getRowIndex(), "fromFarmers").setValue(UIRuleUtil.getProperty(stockingBatch, "farmer"));
					kdtTransEntry.getCell(e.getRowIndex(), "fromFarm").setValue(UIRuleUtil.getProperty(stockingBatch, "farm"));

					//20190507 转出棚舍 按照转出批次过滤
					EntityViewInfo ev=new EntityViewInfo();
					FilterInfo filter=new FilterInfo();
					String batchId = stockingBatch.getString("id");
					String farmID = ((IObjectValue) kdtTransEntry.getCell(e.getRowIndex(), "fromFarm").getValue()).getString("id");
					HashSet set=StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID,batchId ,farmID,false);
					if(set.size()>0) {
						filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
					}

					ev.setFilter(filter);
					//增加排序
					SorterItemCollection sorter = new SorterItemCollection();
					SorterItemInfo item = new SorterItemInfo("number");
					item.setSortType(SortType.ASCEND);
					sorter.add(item);
					ev.setSorter(sorter);

					((KDBizPromptBox) kdtTransEntry.getColumn("fromHouse").getEditor().getComponent()).setEntityViewInfo(ev);

				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		}
		if(kdtTransEntry.getColumnKey(e.getColIndex()).equalsIgnoreCase("fromFarmers")) {
			IObjectValue obj = (IObjectValue) kdtTransEntry.getCell(e.getRowIndex(), "fromFarmers").getValue();
			if(obj==null) {
				kdtTransEntry.getCell(e.getRowIndex(), "fromFarm").setValue(null);
				kdtTransEntry.getCell(e.getRowIndex(), "fromHouse").setValue(null);
			}else{
				kdtTransEntry.getCell(e.getRowIndex(), "fromFarm").setValue(StockingComm.getFarmInfoByFarmerID(null,obj.getString("id")));
				kdtTransEntry.getCell(e.getRowIndex(), "fromHouse").setValue(null);
			}
		}

		if(kdtTransEntry.getColumnKey(e.getColIndex()).equalsIgnoreCase("house")
				||kdtTransEntry.getColumnKey(e.getColIndex()).equalsIgnoreCase("fromHouse")
				||kdtTransEntry.getColumnKey(e.getColIndex()).indexOf("Qty")>=0){
			recalBreekStocking();
		}
	}

	/**
	 * 重新结算存栏信息
	 */
	private void recalBreekStocking() {
		// TODO Auto-generated method stub
		String houseID=null;
		for(int rowIndex=0;rowIndex<kdtAssEntrys.getRowCount();rowIndex++){
			if(kdtAssEntrys.getCell(rowIndex, "house").getValue()!=null) {
				houseID=((IPropertyContainer) kdtAssEntrys.getCell(rowIndex, "house").getValue()).getString("id");
			}
			//bean是初始存栏量
			BatchLastBean bean = null;
			try {
				bean = StockingComm.getEntryHouseBatchBean(null,this.editData.getId()!=null?this.editData.getId().toString():null,curCompanyID,(Date)this.pkBizDate.getValue(), ((IPropertyContainer) prmtstockingBatch.getValue()).getString("id"), houseID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(bean==null) {
				return;
			}
			BigDecimal deathQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"deathQty").getValue());
			BigDecimal femaleDeathQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"femaleDeathQty").getValue());
			BigDecimal cullQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"cullQty").getValue());
			BigDecimal femaleCullQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"femaleCullQty").getValue());

			BigDecimal adjustQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"adjustQty").getValue());
			BigDecimal femaleAdjustQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"adjustFemaleQty").getValue());

			//设置出栏量
			BigDecimal markedQty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"markedQty").getValue());
			BigDecimal femaleMarketed=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"femaleMarketed").getValue());


			//补算存栏量
			String tohouseID=null;
			String fromHouseID=null;
			BigDecimal transQty=null;
			BigDecimal transFemaleQty=null;
			BigDecimal lastQty  = BigDecimal.ZERO ;
			BigDecimal femaleLastQty=BigDecimal.ZERO ;

			lastQty=bean.getLaskStock().subtract(deathQty).subtract(cullQty).add(adjustQty).subtract(markedQty);
			femaleLastQty=bean.getFemaleLaskStock().subtract(femaleDeathQty).subtract(femaleCullQty).add(femaleAdjustQty).subtract(femaleMarketed);

			for(int rowIndex1=0;rowIndex1<kdtTransEntry.getRowCount();rowIndex1++){
				transQty=UIRuleUtil.getBigDecimal(kdtTransEntry.getCell(rowIndex1,"transQty").getValue());
				transFemaleQty=UIRuleUtil.getBigDecimal(kdtTransEntry.getCell(rowIndex1,"transFemaleQty").getValue());
				if(kdtTransEntry.getCell(rowIndex1, "house").getValue() !=null){
					tohouseID=((IPropertyContainer) kdtTransEntry.getCell(rowIndex1, "house").getValue()).getString("id");
					if(tohouseID.equals(houseID)){
						lastQty = lastQty.add(transQty);
						femaleLastQty = femaleLastQty.add(transFemaleQty);
					}
				}

				if(kdtTransEntry.getCell(rowIndex1, "fromHouse").getValue() !=null){
					fromHouseID=((IPropertyContainer) kdtTransEntry.getCell(rowIndex1, "fromHouse").getValue()).getString("id");
					if(fromHouseID.equals(houseID)){
						lastQty = lastQty.subtract(transQty);
						femaleLastQty = femaleLastQty.subtract(transFemaleQty);
					}
				}
			}

			//计算这一天之前，该公司，该批次，该棚舍的公禽的转入，转出
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sql1 = "/*dialect*/  select sum(t.maleQty) maleQty from " +
			"( " +
			"select   (-1)*sum(t2.CFOutmaleQty)  maleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid" +
			" where t2.CFOutFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
			"' and t2.CFOutBatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
			"' and t2.CFOutHouseID='"+houseID+"'  and t1.CFBaseStatus=3 and t1.fbizdate<= { d'"+sdf.format(pkBizDate.getValue())+"'}"+
			" union all "+
			"select   sum(t2.CFOutmaleQty)  maleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid" +
			" where t2.CFInFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
			"' and t2.CFInBbatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
			"' and t2.CFInHouseID='"+houseID+"'  and t1.CFBaseStatus=3 and t1.fbizdate<= { d'" +sdf.format(pkBizDate.getValue())+"'}"+
			") t";
			ISQLExecutor executor1 = SQLExecutorFactory.getRemoteInstance(sql1);
			IRowSet rs1;
			BigDecimal maleQty = BigDecimal.ZERO;
			BigDecimal femaleQty = BigDecimal.ZERO;
			try {
				rs1 = executor1.executeSQL();
				if(rs1.next()){
					maleQty = rs1.getBigDecimal("maleQty");
					if(maleQty == null){
						maleQty = BigDecimal.ZERO;
					}else{
						maleQty = rs1.getBigDecimal("maleQty");
					}
				}

				//计算这一天之前，该公司，该养殖场，该棚舍的母禽的转入、转出
				String sql2 ="/*dialect*/  select sum(t.CFOutFemaleQty) femaleQty from " +
				"( " +
				"select  (-1)*sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid" +
				" where t2.CFOutFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
				"' and t2.CFOutBatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
				"' and t2.CFOutHouseID='"+houseID+"'  and t1.CFBaseStatus=3 and t1.fbizdate<= { d '"+sdf.format(pkBizDate.getValue())+"'}"+
				" union all "+
				"select   sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid" +
				" where t2.CFInFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
				"' and t2.CFInBbatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
				"' and t2.CFInHouseID='"+houseID+"'  and t1.CFBaseStatus=3 and t1.fbizdate <= { d '" +sdf.format(pkBizDate.getValue())+
				"'}) t";
				ISQLExecutor executor2 = SQLExecutorFactory.getRemoteInstance(sql2);
				IRowSet rs2 = executor2.executeSQL();

				if(rs2.next()){
					femaleQty = rs2.getBigDecimal("femaleQty");
					if(femaleQty == null){
						femaleQty = BigDecimal.ZERO;
					}else{
						femaleQty = rs2.getBigDecimal("femaleQty");
					}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			kdtAssEntrys.getCell(rowIndex, "breekingStock").setValue(lastQty.add(maleQty));
			kdtAssEntrys.getCell(rowIndex, "femaleBreedkingStock").setValue(femaleLastQty.add(femaleQty));
		}
	}

	private void date_changed() throws Exception {
		//今天尚未填写的批次
		Date date = (Date) pkBizDate.getValue();
		ArrayList<String> batchIDList = getNoExistBatchIDDailyToday(date);
		if(prmtstockingBatch.getValue()!=null) {
			//今天尚未填写的批次不包含当前批次，既该批次已经填写
			try {
				String batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
				if(!batchIDList.contains(batchID)&&prmtstockingBatch.getValue()==null) {
					if(batchIDList.size()>0) {
						StockingBatchInfo bInfo=StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchIDList.get(0)));
						prmtstockingBatch.setValue(bInfo);	
					}else{
						prmtstockingBatch.setValue(null);	
					}
				}
			}catch(Exception err) {

			}
		}

		batch_changed();

	}
	/**
	 * 设置棚舍过滤条件
	 */
	private void setHouseFilter() {
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		String batchID=null,farmID=null;
		if(prmtstockingBatch.getValue()!=null) {
			batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
		}
		if(this.prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) this.prmtfarm.getValue()).getString("id");
		}

		//未完全出栏
		HashSet set=StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID,batchID,farmID,false);
		if(set.size()>0) {
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
		}

		ev.setFilter(filter);
		//增加排序
		SorterItemCollection sorter = new SorterItemCollection();
		SorterItemInfo item = new SorterItemInfo("number");
		item.setSortType(SortType.ASCEND);
		sorter.add(item);
		ev.setSorter(sorter);


		((KDBizPromptBox) kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		((KDBizPromptBox) kdtAssEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		((KDBizPromptBox) kdtEggEntry.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		((KDBizPromptBox) kdtImmuneEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		((KDBizPromptBox) kdtTransEntry.getColumn("fromHouse").getEditor().getComponent()).setEntityViewInfo(ev);
		((KDBizPromptBox) kdtEnvi.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		((KDBizPromptBox) kdtSendEggEntry.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		((KDBizPromptBox) kdtDrugEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);


		//未完全出栏
		EntityViewInfo ev1=new EntityViewInfo();
		FilterInfo filter1=new FilterInfo();
		HashSet set1=StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID,null,farmID,false);
		filter1.getFilterItems().add(new FilterItemInfo("id",set1,CompareType.INCLUDE));
		ev1.setFilter(filter1);
		((KDBizPromptBox) kdtTransEntry.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev1);
	}


	/**
	 * 养殖场改变 删掉分录
	 * @param e
	 */
	private void farm_changed(DataChangeEvent e) {
		isHouseManager=false;
		boolean isExist=false;
		Component d = kdTabPanelMain.getComponentAt(kdTabPanelMain.getTabCount()-2);
		if(d.getName().equalsIgnoreCase("kDPanelTrans")||d.getName().equalsIgnoreCase("kDPanelEnvi")) {
			isExist=true;
		}

		if(prmtfarm.getValue()!=null) {
			try {
				if((Boolean) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "isHouseManager")) {
					isHouseManager=true;
					if(!isExist){
						kdTabPanelMain.add(kDPanelEnvi,"环控信息", kdTabPanelMain.getTabCount()-1);
					}
				}else{
					if(isExist) {
						this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}else{
			if(isExist) {
				this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
			}
		}
		if(!isHouseManager) {
		}else{
			setHouseColHided(false);
		}
	}
	/**
	 * 设置棚舍列的隐藏
	 * @param isHide
	 */
	private void setHouseColHided(boolean isHide) {
		this.kdtEntrys.getColumn("house").getStyleAttributes().setHided(isHide);
		this.kdtAssEntrys.getColumn("house").getStyleAttributes().setHided(isHide);
		this.kdtAssEntrys.getColumn("week").getStyleAttributes().setHided(isHide);
		this.kdtAssEntrys.getColumn("weekDays").getStyleAttributes().setHided(isHide);
		this.kdtEggEntry.getColumn("house").getStyleAttributes().setHided(isHide);
		this.kdtImmuneEntrys.getColumn("house").getStyleAttributes().setHided(isHide);
		this.kdtSendEggEntry.getColumn("house").getStyleAttributes().setHided(isHide);
		this.kdtTransEntry.getColumn("house").getStyleAttributes().setHided(isHide);
	}

	/**
	 * 批次改变
	 * 带出日领和领料分录
	 * @throws Exception 
	 */
	private void batch_changed() throws Exception {
		if(isLoadField) {
			return;
		}
		isLoadField=true;
		if(prmtstockingBatch.getValue()!=null) {

			//根据批次中性别设置公禽，母禽的字段隐藏显示
			StockingBatchInfo stockingBatchInfo = (StockingBatchInfo) prmtstockingBatch.getValue();
			String sex = stockingBatchInfo.getSex().getValue();
			//公，设置母禽的字段隐藏
			if(sex.equalsIgnoreCase("1")){
				//需要隐藏的字段有
				kdtEntrys.getColumn("feMaterail").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("mqlbm").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("femaleDailyQty").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("femaleModel").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleDeathQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleCullQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("adjustFemaleQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleBreedkingStock").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("femaleMarketed").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("mjUniformity").getStyleAttributes().setHided(true);

				kdtEntrys.getColumn("material").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("materialName").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("materialModel").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("dailyQtyAll").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("deathQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("cullQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("adjustQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("breekingStock").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("avgWeight").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("markedQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("gjUniformity").getStyleAttributes().setHided(false);

			}
			//			母，设置公禽的字段隐藏
			else if(sex.equalsIgnoreCase("2")){
				//需要隐藏的字段有
				kdtEntrys.getColumn("material").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("materialName").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("materialModel").getStyleAttributes().setHided(true);
				kdtEntrys.getColumn("dailyQtyAll").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("deathQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("cullQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("adjustQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("breekingStock").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("avgWeight").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("markedQty").getStyleAttributes().setHided(true);
				kdtAssEntrys.getColumn("gjUniformity").getStyleAttributes().setHided(true);



				kdtEntrys.getColumn("feMaterail").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("mqlbm").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("femaleDailyQty").getStyleAttributes().setHided(false);
				kdtEntrys.getColumn("femaleModel").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleDeathQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleCullQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("adjustFemaleQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleBreedkingStock").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleQty").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("femaleMarketed").getStyleAttributes().setHided(false);
				kdtAssEntrys.getColumn("mjUniformity").getStyleAttributes().setHided(false);

			}
			//混，不设置隐藏



			try {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("farmer.*");
				slor.add("farm.*");
				slor.add("house.*");
				StockingBatchInfo batchInfo=StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((AbstractCoreBaseInfo) prmtstockingBatch.getValue()).getId()),slor);

				isLoadField=true;
				this.prmtfarmer.setValue(batchInfo.getFarmer());
				this.prmtfarm.setValue(batchInfo.getFarm());
				isLoadField=false;

				Date batchDate = batchInfo.getInDate();
				if(this.pkBizDate.getValue()==null) {
					return;
				}
				Date bizDate=((Date) this.pkBizDate.getValue());

				int[] result = StockingComm.getBreedWeekAndDay(bizDate, batchDate);
				int week=result[0];
				int weekDay=result[1];

				this.txtweek.setValue(week);
				this.txtweekDay.setValue(weekDay);
				//设置日龄
				setPurDayAge();
				//饲料标准
				getBreedFodderStandard(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
				//免疫标准
				getBreedDrugStandard(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
				//养殖分录
				getBreedEntry(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
				//产蛋分录
				setEggEntry(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
				//环控分录
				setKdtEnviEntry(curCompanyID, batchInfo.getBreedData().getString("id"));
				//用药分录
				setKdtDrugEntry(curCompanyID, batchInfo.getBreedData().getString("id"));
				this.kdtTransEntry.removeRows();
				//设置母鸭日喂料量是否 隐藏
				setFemaleQtyHiheOrNot();

			}catch(Exception err) {
				err.printStackTrace();
				throw new BOSException(err.getMessage());
			}
		}
		else {
		}
		setBreedStage();
		isLoadField=false;
	}

	private void setKdtDrugEntry(String companyID,String breedDataID) {
		if(StringUtils.isEmpty(companyID)||StringUtils.isEmpty(breedDataID)) {
			return;
		}
		if(this.kdtDrugEntrys.getRowCount()>0) {
			this.kdtDrugEntrys.removeRows();
		}
		//棚舍分录
		LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch();
		int count=0;
		IRow row;
		count=houseEntryList.size()<=0?1:houseEntryList.size();
		for(int i=0;i<count;i++) {
			row=this.kdtDrugEntrys.addRow();
			if(houseEntryList.size()>0) {
				//设置棚舍
				row.getCell("house").setValue(houseEntryList.get(i));
			}
		}
	}

	private void setKdtEnviEntry(String companyID,String breedDataID) {
		if(StringUtils.isEmpty(companyID)||StringUtils.isEmpty(breedDataID)) {
			return;
		}
		if(this.kdtEnvi.getRowCount()>0) {
			this.kdtEnvi.removeRows();
		}
		//棚舍分录
		LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch();
		int count=0;
		IRow row;
		count=houseEntryList.size()<=0?1:houseEntryList.size();
		for(int i=0;i<count;i++) {
			row=this.kdtEnvi.addRow();
			if(houseEntryList.size()>0) {
				//设置棚舍
				row.getCell("house").setValue(houseEntryList.get(i));
			}
		}
	}

	/**
	 * 设置母禽喂料量是否隐藏 产蛋期后自由采食，不区分
	 * @param dayAge
	 */
	private void setFemaleQtyHiheOrNot() {

	}

	private void setEggEntry(String companyID,String breedDataID,int week,int weekDay) {
		//日龄 
		int dayAge=(week-1)*7+weekDay-1;

		StringBuffer sql=new StringBuffer();
		sql.append(" select top 1 tentry.fid")
		.append(" from T_FM_BreedStandard tmain ")
		.append(" inner join T_FM_BreedStandardLayEggEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.FCompanyID='").append(curCompanyID).append("'")
		.append(" and FBreedDataID='").append(breedDataID).append("'")
		.append(" and FBaseStatus=3")//启用状态
		//		.append(" and CFWeek<=").append(week).append(" and CFDays<=").append(weekDay).append(" ")
		//		.append(" and ( (FEndWeek=").append(week).append(" and FEndDays>").append(weekDay).append(" )")
		//		.append(" or FEndWeek>").append(week)
		//		.append(" )")
		.append(" and (")
		//起始周日均大于当前
		.append(" (CFWeek<=").append(week).append(" and CFDays<=").append(weekDay).append(" ")
		//结束同周，日大于当前日
		.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
		//周大于当前周
		.append(" or FEndWeek>").append(week).append(" ))")
		//0周 进行日龄判断
		.append(" or (CFWeek=0 and CFDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
		.append(" )")
		.append(" order by tentry.FSeq");
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			//没有产蛋规范则退出
			if(rs.size()<=0) {
				return;
			}
		} catch (BOSException e) {
			e.printStackTrace();
		}

		if(kdtEggEntry.getRowCount()>0) {
			kdtEggEntry.removeRows();
		}

		LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch();

		int count=houseEntryList.size()<=0?1:houseEntryList.size();
		if(kdtEggEntry.getRowCount()<=0) {
			String batchID=null;
			if(prmtstockingBatch.getValue()!=null) {
				batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
			}
			//			ArrayList<String> list = StockingComm.getEggListByStockingBatchID(null, batchID,true);
			ArrayList<String> list = StockingComm.getEggListByStockingBatchID(null, batchID,true);

			if(list!=null){
				try{
					IMaterial ims = MaterialFactory.getRemoteInstance();
					MaterialInfo mInfo;
					IRow row;
					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add(new SelectorItemInfo("*"));
					slor.add(new SelectorItemInfo("baseUnit.*"));
					for(String materialID:list) {
						for(int i=0;i<count;i++) {
							row=kdtEggEntry.addRow();

							if(houseEntryList.size()>0) {
								//设置棚舍
								row.getCell("house").setValue(houseEntryList.get(i));
							}

							mInfo=ims.getMaterialInfo(new ObjectUuidPK(materialID),slor);
							row.getCell("material").setValue(mInfo);
							row.getCell("materialName").setValue(mInfo.getName());
							row.getCell("model").setValue(mInfo.getModel());
							row.getCell("unit").setValue(mInfo.getBaseUnit());
							//获取品系
							BreedDataInfo bdi = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(breedDataID));
							row.getCell("px").setValue(bdi.getGenderType());


							row.getCell("allQty").setValue(BigDecimal.ZERO);
						}
					}
				}catch(Exception err) {
					logger.error(err);
					err.printStackTrace();
				}
			}
		}
	}
	/**
	 * 根据批次获取
	 * @return
	 */
	private LinkedList<FarmHouseEntryInfo> getHouseIDListByBatch() {
		LinkedList<FarmHouseEntryInfo> list=new LinkedList<FarmHouseEntryInfo>();

		//没有启动棚舍管理
		if(!isHouseManager) {//sysSetting.isIsHouseManager(
			return list;
		}
		String batchID=null;
		if(prmtstockingBatch.getValue()!=null) {
			batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
			/*try{
				StringBuffer sql=new StringBuffer();
				sql.append(" select tentry.FhouseID")
				.append(" from T_FM_StockingBatch tmain")
				.append(" inner join  T_FM_StockingBatchHouseEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join CT_FM_FarmHouseEntry the on the.fid=tentry.FhouseID")
				.append(" where tmain.fid='").append(((IPropertyContainer) prmtstockingBatch.getValue()).getString("id")).append("'")
				.append(" and tentry.FIsAllout=0")//没有完全出栏
				.append(" order by the.FSeq")
				;
				IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				IFarmHouseEntry ifs = FarmHouseEntryFactory.getRemoteInstance();
				while(rs.next()) {
					list.add(ifs.getFarmHouseEntryInfo(new ObjectUuidPK(rs.getString("FhouseID"))));
				}
			}catch(Exception err) {
				err.printStackTrace();
			}*/
			try{
				IFarmHouseEntry ifs = FarmHouseEntryFactory.getRemoteInstance();
				LinkedHashSet<String> houseSetByBatchID = StockingComm.getHouseSetByBatchID(null,batchID);
				for(String id: houseSetByBatchID){
					list.add(ifs.getFarmHouseEntryInfo(new ObjectUuidPK(id)));
				}
			}catch(Exception err) {
				err.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 根据批次获取舍得信息
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private StockingBatchHouseEntryCollection getHouseInfoByBatch() throws EASBizException, BOSException {
		//启用棚舍管理
		if(isHouseManager) {//sysSetting.isIsHouseManager()
			if(prmtstockingBatch.getValue()!=null) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("house.*");
				StockingBatchInfo batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((AbstractCoreBaseInfo) prmtstockingBatch.getValue()).getId()),slor);
				return batchInfo.getHouseEntry();
			}
		}
		return null;
	}

	/**
	 * 通过养殖品种和业务日期获取饲料标准
	 * @param breedDataID
	 * @param week
	 * @param weekDay
	 */
	private void getBreedFodderStandard(String companyID,String breedDataID,int week,int weekDay) {
		try {
			if(StringUtils.isEmpty(companyID)||StringUtils.isEmpty(breedDataID)) {
				return;
			}

			if(this.kdtEntrys.getRowCount()>0) {
				this.kdtEntrys.removeRows();
			}
			//棚舍分录
			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch();
			//获取饲喂规范
			int count=0;
			IRow row;
			count=houseEntryList.size()<=0?1:houseEntryList.size();

			MaterialInfo mInfo;
			IMaterial ims = MaterialFactory.getRemoteInstance();

			BreedStandardEntryInfo starnardEntryInfo = StockingComm.getBreedFodderStandardEntryInfo(null, companyID, breedDataID, week,weekDay);
			if(starnardEntryInfo!=null) {
				for(int i=0;i<count;i++) {
					row=this.kdtEntrys.addRow();
					if(houseEntryList.size()>0) {
						//设置棚舍
						row.getCell("house").setValue(houseEntryList.get(i));
					}

					//公禽料
					if(starnardEntryInfo.getCockMaterial()!=null){
						mInfo=ims.getMaterialInfo(new ObjectUuidPK(starnardEntryInfo.getCockMaterial().getId()));
						row.getCell("material").setValue(mInfo);
						row.getCell("materialName").setValue(mInfo.getName());
						row.getCell("materialModel").setValue(mInfo.getModel());
					}

					row.getCell("unit").setValue(starnardEntryInfo.getCockMaterial().getBaseUnit());
					row.getCell("unitQty").setValue(StockingComm.getUnitQty(null, curCompanyID, starnardEntryInfo.getCockMaterial().getString("id")));
					//母禽料
					if(starnardEntryInfo.getHenMaterial()!=null){
						mInfo=ims.getMaterialInfo(new ObjectUuidPK(starnardEntryInfo.getHenMaterial().getId()));
						row.getCell("feMaterail").setValue(mInfo);
						row.getCell("mqlbm").setValue(mInfo.getNumber());
						row.getCell("femaleModel").setValue(mInfo.getModel());
					}
				}
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 通过养殖品种和业务日期获取 免疫
	 * @param breedDataID
	 * @param week
	 * @param weekDay
	 */
	private void getBreedDrugStandard(String companyID,String breedDataID,int week,int weekDay) {
		try {
			if(StringUtils.isEmpty(companyID)||StringUtils.isEmpty(breedDataID)) {
				return;
			}
			if(this.kdtImmuneEntrys.getRowCount()>0) {
				this.kdtImmuneEntrys.removeRows();
			}
			int dayAge=(week-1)*7+weekDay-1;
			StringBuffer sql=new StringBuffer();
			sql.append(" select tentry.FMaterialID,tentry.FUnitID,tentry.FQty")
			.append(" from T_FM_BreedStandard tmain ")
			.append(" inner join T_FM_BreedStandardDrugEntry tentry on tentry.fparentid=tmain.fid")
			.append(" where tmain.FCompanyID='").append(companyID).append("'")
			.append(" and FBreedDataID='").append(breedDataID).append("'")
			.append(" and FBaseStatus=3")//启用状态
			.append(" and (")
			//起始周日均大于当前
			.append(" (FWeek<=").append(week).append(" and FDays<=").append(weekDay).append(" ")
			//结束同周，日大于当前日
			.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
			//周大于当前周
			.append(" or FEndWeek>").append(week).append(" ))")
			//0周 进行日龄判断
			.append(" or (FWeek=0 and FDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
			.append(" )")
			.append(" order by tentry.FSeq")
			.append(" ");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			IRow row;
			MaterialInfo mInfo;
			IMaterial ims = MaterialFactory.getRemoteInstance();
			IMeasureUnit ius = MeasureUnitFactory.getRemoteInstance();
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("baseUnit.*");
			FarmHouseEntryInfo fheInfo=new FarmHouseEntryInfo();

			int count=0;
			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch();
			count=houseEntryList.size()<=0?1:houseEntryList.size();
			while(rs.next()) {

				for(int i=0;i<count;i++) {
					row=this.kdtImmuneEntrys.addRow();
					if(houseEntryList.size()>0) {
						//设置棚舍
						row.getCell("house").setValue(houseEntryList.get(i));
					}
					if(StringUtils.isNotEmpty(rs.getString("FMaterialID"))){
						mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")),slor);
						row.getCell("vaccineMaterial").setValue(mInfo);
						row.getCell("vaccineName").setValue(mInfo.getName());
						row.getCell("model").setValue(mInfo.getModel());
					}
					if(StringUtils.isNotEmpty(rs.getString("FUnitID"))){
						row.getCell("vaccineUnit").setValue(ius.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("FUnitID"))));
					}
					row.getCell("vaccineGetQty").setValue(rs.getBigDecimal("FQty"));
				}
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 通过养殖分录
	 * @param breedDataID
	 * @param week
	 * @param weekDay
	 */
	private void getBreedEntry(String companyID,String breedDataID,int week,int weekDay) {
		try {
			if(prmtstockingBatch.getValue()==null){
				return;
			}
			String batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");

			if(this.kdtAssEntrys.getRowCount()>0) {
				this.kdtAssEntrys.removeRows();
			}
			int count=0;

			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch();
			count=houseEntryList.size()<=0?1:houseEntryList.size();
			//棚舍分录
			if(prmtfarm.getValue()!=null) {
				IRow row;
				BatchLastBean bean;
				String billID=null;
				if(this.editData.getId()!=null) {
					billID=this.editData.getId().toString();
				}
				for(int index=0;index<count;index++) {
					row=this.kdtAssEntrys.addRow();
					if(houseEntryList.size()>0) {
						row.getCell("house").setValue(houseEntryList.get(index));
						bean=StockingComm.getEntryHouseBatchBean(null,billID,curCompanyID,(Date)this.pkBizDate.getValue(), batchID, houseEntryList.get(index).getString("id"),0);
					}else{
						bean=StockingComm.getEntryHouseBatchBean(null,billID,curCompanyID,(Date)this.pkBizDate.getValue(), batchID, null);
					}
					if(bean==null) {
						continue;
					}


					//计算这一天之前，该公司，该批次，该棚舍的公禽的转入，转出

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					String sql1 = "/*dialect*/  select sum(t.maleQty) maleQty from " +
					"( " +
					"select  (-1)*sum(t2.CFOutmaleQty)  maleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid" +
					" where t2.CFOutFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
					"' and t1.CFBaseStatus=3"+
					"  and t2.CFOutBatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
					"' and t2.CFOutHouseID='"+houseEntryList.get(index).getString("id")+
					"' and t1.fbizdate< { d '"+sdf.format(pkBizDate.getValue())+"'} +1 "+
					" union all "+
					"select   sum(t2.CFOutmaleQty)  maleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid" +
					" where t2.CFInFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
					"' and t1.CFBaseStatus=3"+
					"  and t2.CFInBbatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
					"' and t2.CFInHouseID='"+houseEntryList.get(index).getString("id")+
					"' and t1.fbizdate< { d '" +sdf.format(pkBizDate.getValue())+"'} +1 "+
					") t";

					ISQLExecutor executor1 = SQLExecutorFactory.getRemoteInstance(sql1);
					IRowSet rs1 = executor1.executeSQL();
					BigDecimal maleQty = BigDecimal.ZERO;
					if(rs1.next()){
						maleQty = rs1.getBigDecimal("maleQty");
						if(maleQty == null){
							maleQty = BigDecimal.ZERO;
						}else{
							maleQty = rs1.getBigDecimal("maleQty");
						}
					}


					//计算这一天之前，该公司，该养殖场，该棚舍的母禽的转入、转出
					String sql2 ="/*dialect*/  select sum(t.CFOutFemaleQty) femaleQty from " +
					"( " +
					"select  (-1)*sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid" +
					" where t2.CFOutFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
					"' and t1.CFBaseStatus=3"+
					"  and t2.CFOutBatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
					"' and t2.CFOutHouseID='"+houseEntryList.get(index).getString("id")+
					"' and t1.fbizdate< { d '"+sdf.format(pkBizDate.getValue())+"'} +1 "+
					" union all "+
					"select   sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid" +
					" where t2.CFInFarmID='"+((FarmInfo)prmtfarm.getValue()).getId().toString()+
					"' and t1.CFBaseStatus=3"+
					" and t2.CFInBbatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getId().toString()+
					"' and t2.CFInHouseID='"+houseEntryList.get(index).getString("id")+
					"' and t1.fbizdate< { d '" +sdf.format(pkBizDate.getValue())+
					"'} +1 ) t";

					ISQLExecutor executor2 = SQLExecutorFactory.getRemoteInstance(sql2);
					IRowSet rs2 = executor2.executeSQL();
					BigDecimal femaleQty = BigDecimal.ZERO;
					if(rs2.next()){
						femaleQty = rs2.getBigDecimal("femaleQty");
						if(femaleQty == null){
							femaleQty = BigDecimal.ZERO;
						}else{
							femaleQty = rs2.getBigDecimal("femaleQty");
						}
					}
					row.getCell("week").setValue(bean.getWeek());
					row.getCell("weekDays").setValue(bean.getWeekDays());
					row.getCell("breekingStock").setValue(bean.getLaskStock().add(maleQty));
					row.getCell("femaleBreedkingStock").setValue(bean.getFemaleLaskStock().add(femaleQty));
					
					//根据周日龄和品种自动带出养殖规范母鸡公鸡标准失重，母鸡公鸡标准失重率
					String s2 = "/*dialect*/ select  t2.CFFemaleLossWeight  CFFemaleLossWeight, t2.CFMaleLossWeight  CFMaleLossWeight," +
							" t2.CFFemaleLossRate  CFFemaleLossRate,t2.CFMaleLossRate  CFMaleLossRate from  T_FM_BreedStandard t1" +
							" inner join T_FM_BreedStandardEntry t2 on t2.fparentid = t1.fid where t1.FBaseStatus = 3 and  t1.FBreedDataID ='"+breedDataID+"' " +
									" and t2.CFWeek<= "+week+" and t2.CFDays<="+weekDay+" and t2.FEndWeek>=  "+week+" and t2.FEndDays >="+weekDay;
					IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s2);
					BigDecimal CFFemaleLossWeight = BigDecimal.ZERO;
					BigDecimal CFMaleLossWeight = BigDecimal.ZERO;
					BigDecimal CFFemaleLossRate = BigDecimal.ZERO;
					BigDecimal CFMaleLossRate = BigDecimal.ZERO;
					if(r1.next()){
						CFFemaleLossWeight = UIRuleUtil.getBigDecimal(r1.getBigDecimal("CFFemaleLossWeight"));
						CFMaleLossWeight = UIRuleUtil.getBigDecimal(r1.getBigDecimal("CFMaleLossWeight"));
						CFFemaleLossRate = UIRuleUtil.getBigDecimal(r1.getBigDecimal("CFFemaleLossRate"));
						CFMaleLossRate = UIRuleUtil.getBigDecimal(r1.getBigDecimal("CFMaleLossRate"));
					}
					row.getCell("femaleLossStand").setValue(CFFemaleLossWeight);
					row.getCell("maleLossStand").setValue(CFMaleLossWeight);
					row.getCell("femaleLosWeiRate").setValue(CFFemaleLossRate);
					row.getCell("maleLosWeiStand").setValue(CFMaleLossRate);
					
					
				}
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
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
		setBatchFilter();
	}

	private void setBatchFilter() {
		//批次过滤
		String farmID="";
		if(prmtfarm.getValue()!=null){
			farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
		}
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		SelectorListener[]  ls = prmtstockingBatch.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtstockingBatch.removeSelectorListener(ls[i]);
		}
		prmtstockingBatch.setEntityViewInfo(evi);
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
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

	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
	}

	//删除空白的免疫分录
	private void deleteEmptyDrugEntry() {
		int count=this.kdtImmuneEntrys.getRowCount();
		for(int rowIndex=0;rowIndex<count;) {
			//领用量，使用量，批号都为空
			if(UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"vaccineGetQty").getValue())&&UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"vaccineUsedQty").getValue())&&UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"lot").getValue())) {
				this.kdtImmuneEntrys.removeRow(rowIndex);
			}else{
				rowIndex++;
			}
			count=this.kdtImmuneEntrys.getRowCount();
		}
	}

	@Override
	protected void beforeStoreFields(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		//保存时  同一个日期同一个批次只能有一张养殖日报

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StringBuffer sbuff = new StringBuffer();
		sbuff.append("/*dialect*/ select fid billid from T_FM_StockingBreedDaily where FBizDate = {d '");
		sbuff.append(sdf.format(pkBizDate.getValue()));
		sbuff.append("'} and CFStockingBatchID = '");
		sbuff.append(((StockingBatchInfo)prmtstockingBatch.getValue()).getId());
		sbuff.append("'");
		if(editData.getId() != null){
			sbuff.append(" and fid !='");sbuff.append(editData.getId());sbuff.append("'");
		}
		IRowSet r1 = SQLExecutorFactory.getRemoteInstance(sbuff.toString()).executeSQL();
		if(r1.next()){
			MsgBox.showWarning("该批次在"+sdf.format(sdf.format(pkBizDate.getValue()))+" 的养殖日报已经存在，禁止保存！");
			SysUtil.abort();
		}



		//校验免疫分录
		deleteEmptyDrugEntry();
		//校验饲喂信息分录
		checkBreedEntry();
		//校验物料领用分录
		checkMatUseEntry();
		super.beforeStoreFields(e);

		String batchID=((IPropertyContainer) this.prmtstockingBatch.getValue()).getString("id");
		Calendar cal=Calendar.getInstance();
		cal.setTime(this.pkBizDate.getTimestamp());


		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("stockingBatch.id",batchID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",sdf.format(cal.getTime()),CompareType.GREATER_EQUALS));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		filter.getFilterItems().add(new FilterItemInfo("bizDate",sdf.format(cal.getTime()),CompareType.LESS));
		if(!oprtState.equals(OprtState.ADDNEW)&&this.editData.getId()!=null) {
			filter.getFilterItems().add(new FilterItemInfo("id",this.editData.getString("id"),CompareType.NOTEQUALS));
		}
		if(isHouseManager) {//sysSetting.isIsHouseManager()
			checkEntryHouseIsNotNull(this.kdtEntrys,"饲喂信息");
			checkEntryHouseIsNotNull(this.kdtAssEntrys,"养殖信息");
			checkEntryHouseIsNotNull(this.kdtEggEntry,"产蛋信息");
			checkEntryHouseIsNotNull(this.kdtImmuneEntrys,"免疫信息");
			checkEntryHouseIsNotNull(this.kdtTransEntry,"转栏信息");
			checkEntryHouseIsNotNull(this.kdtSendEggEntry,"蛋品报送信息");
		}
		if(isHouseManager){
			chechFeedEndtryRepeat();
		}

		for(int rowIndex=0;rowIndex<this.kdtAssEntrys.getRowCount();rowIndex++) {

			//存栏量为0
			if(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "breekingStock").getValue()).signum()<=0&&UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "femaleBreedkingStock").getValue()).signum()<=0) {
				if(MsgBox.showConfirm2("第"+(rowIndex+1)+"行养殖信息分录存栏量为0，是否完全出栏？")==MsgBox.YES) {
					kdtAssEntrys.getCell(rowIndex, "isMarketed").setValue(true);
				}
			}

		}

	}

	/**
	 * 校验物料领用分录
	 */
	private void checkMatUseEntry() {
		// TODO Auto-generated method stub
		//设置如果存在新增加的行，就必须设置物料和数量都不能为空
		for(int i=0,size=kdtMatUserEntry.getRowCount();i<size;i++){
			if(kdtMatUserEntry.getCell(i,"matNum") == null
					|| kdtMatUserEntry.getCell(i,"matQty").getValue() == null
					|| UIRuleUtil.isNull(kdtMatUserEntry.getCell(i,"matQty").getValue())
			){
				int k = i+1;
				MsgBox.showWarning("物料领用分录第"+k+"行记录的物料和数量不能为空,不能为0！");
				SysUtil.abort();
			}
		}
	}

	/**
	 * 校验免疫信息分录
	 */
	private void checkImmuneEntry() {
		// TODO Auto-generated method stub
		//设置如果免疫信息分录存在新增加的行，且棚舍，疫苗，使用量有空的字段就提示信息
		for(int i=0,size=kdtImmuneEntrys.getRowCount();i<size;i++){
			if(kdtImmuneEntrys.getCell(i,"house").getValue() == null
					|| kdtImmuneEntrys.getCell(i,"vaccineMaterial").getValue() == null
					|| kdtImmuneEntrys.getCell(i,"vaccineUsedQty").getValue() == null
					|| UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"vaccineUsedQty").getValue())){
				MsgBox.showWarning("免疫信息分录第"+i+"行记录的棚舍，疫苗，使用量不能为空或者不能为0!");
				SysUtil.abort();
			}
		}
	}

	/**
	 * 校验饲喂信息分录是否为空
	 */
	private void checkBreedEntry() {
		// TODO Auto-generated method stub
		//获取批次的性别
		if(this.prmtstockingBatch.getValue() != null){
			StockingBatchInfo batchInfo = null;
			try {
				batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((StockingBatchInfo)prmtstockingBatch.getValue()).getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sex = batchInfo.getSex().getValue();
			//如果是公禽就设置：棚舍+公禽料+日喂料量公 都不能为空
			List<Integer> infoList = new ArrayList<Integer>();
			if("1".equalsIgnoreCase(sex)){

				for(int i=0,size=this.kdtEntrys.getRowCount();i<size;i++){
					if(kdtEntrys.getCell(i,"house").getValue() == null
							|| kdtEntrys.getCell(i,"material").getValue() == null
							|| kdtEntrys.getCell(i,"dailyQtyAll").getValue() == null ){
						int k = i+1;
						String error = "饲喂信息第"+k+"行分录的公禽日喂料量为空,确定继续执行吗？";
						infoList.add(k);
					}
				}
			}

			//如果是母禽就设置：棚舍+母禽料+日喂料量母  都不能为空
			if("2".equalsIgnoreCase(sex)){
				for(int i=0,size=this.kdtEntrys.getRowCount();i<size;i++){
					if(kdtEntrys.getCell(i,"house").getValue() == null
							|| kdtEntrys.getCell(i,"feMaterail").getValue() == null
							|| kdtEntrys.getCell(i,"femaleDailyQty").getValue() == null ){
						int k = i+1;

						String error = "饲喂信息第"+k+"行分录的公禽日喂料量为空,确定继续执行吗？";
						infoList.add(k);
					}
				}
			}

			//如果是母禽就设置：棚舍+母，公禽料+日喂料量母，公     都不能为空
			if("3".equalsIgnoreCase(sex)){
				for(int i=0,size=this.kdtEntrys.getRowCount();i<size;i++){
					if(kdtEntrys.getCell(i,"house").getValue() == null
							|| kdtEntrys.getCell(i,"feMaterail").getValue() == null
							|| kdtEntrys.getCell(i,"femaleDailyQty").getValue() == null 
					){
						int k = i+1;
						String error = "饲喂信息第"+k+"行分录的公禽日喂料量为空,确定继续执行吗？";
						infoList.add(k);
					}
				}
			}

			if(infoList.size() > 0){
				int n = com.kingdee.eas.util.client.MsgBox.showConfirm2(this,"饲喂信息第"+infoList+"行分录的公禽或者母禽日喂料量为空,确定继续执行吗？");
				if(2 == n){
					SysUtil.abort();
				}
			}

		}
	}

	/**
	 * 计算只喂料量和包数
	 */
	private void oneFeedAndBoxQty() {
		// TODO Auto-generated method stub
		super.storeFields();


		//区分公禽，母禽，和混养
		if(this.prmtstockingBatch.getValue() != null){
			StockingBatchInfo stockingBatchInfo = (StockingBatchInfo) prmtstockingBatch.getValue();
			//sex = 1 表示公，sex=2 代表母，sex= 3 代表混
			String sex = stockingBatchInfo.getSex().getValue();


			//遍历死淘信息分录获取公禽和母禽的存栏量总和
			//获取死淘分录的集合
			StockingBreedDailyAssEntryCollection assEntryColl = editData.getAssEntrys();
			//定义一个Map存放棚舍id和公禽母禽存栏量的总和
			Map<String,BigDecimal> assEntryMap = new HashMap<String,BigDecimal>();
			//定义一个死淘分录的对象
			StockingBreedDailyAssEntryInfo assEntryInfo = null;
			String houseID = null;
			BigDecimal mealQty = BigDecimal.ZERO;
			BigDecimal feMealQty = BigDecimal.ZERO;
			BigDecimal allStockingQty = BigDecimal.ZERO;
			for(int i=0;i<assEntryColl.size();i++){
				assEntryInfo = assEntryColl.get(i);
				//棚舍
				if(assEntryInfo.getHouse() != null){
					houseID= assEntryInfo.getHouse().getId().toString();
				}

				//公禽存栏量
				if(sex.equalsIgnoreCase("1") || sex.equalsIgnoreCase("3")){
					if(String.valueOf(assEntryInfo.getBreekingStock()) != null){
						mealQty = BigDecimal.valueOf(assEntryInfo.getBreekingStock())
						.add(UIRuleUtil.getBigDecimal(assEntryInfo.getDeathQty()))
						.add(UIRuleUtil.getBigDecimal(assEntryInfo.getCullQty()))
						.add(UIRuleUtil.getBigDecimal(assEntryInfo.getMarkedQty()));
					}
				}else{
					mealQty = BigDecimal.ZERO;
				}

				//母禽存栏量
				if(sex.equalsIgnoreCase("2") || sex.equalsIgnoreCase("3")){
					if(String.valueOf(assEntryInfo.getFemaleBreedkingStock()) != null){
						feMealQty = assEntryInfo.getFemaleBreedkingStock()
						.add(UIRuleUtil.getBigDecimal(assEntryInfo.getFemaleDeathQty()))
						.add(UIRuleUtil.getBigDecimal(assEntryInfo.getFemaleCullQty()))
						.add(UIRuleUtil.getBigDecimal(assEntryInfo.getFemaleMarketed()));
					}
				}else{
					feMealQty = BigDecimal.ZERO;
				}
				feMealQty = feMealQty==null ? BigDecimal.ZERO : feMealQty;
				allStockingQty = mealQty.add(feMealQty);
				assEntryMap.put(houseID, allStockingQty);
			}



			//遍历饲喂信息分录将‘平均只喂量’和‘包数’赋值

			//获取饲喂信息分录
			StockingBreedDailyEntryCollection entryColl = editData.getEntrys();
			//定义一个饲喂信息的分录对象
			StockingBreedDailyEntryInfo entryInfo = null;
			//平均只喂量
			BigDecimal averFeedQty = BigDecimal.ZERO;
			//公禽日喂料量
			BigDecimal maleQty = BigDecimal.ZERO;
			//母禽日喂料量
			BigDecimal feMaleQty = BigDecimal.ZERO;
			//总日喂料量
			BigDecimal allQty = BigDecimal.ZERO;
			//获取存栏量
			BigDecimal stockQty = BigDecimal.ZERO;

			//遍历饲喂信息分录
			for(int j=0;j<entryColl.size();j++){
				entryInfo = entryColl.get(j);
				//公禽日喂料量
				if(sex.equalsIgnoreCase("1") || sex.equalsIgnoreCase("3")){
					if(entryInfo.getDailyQtyAll() != null){
						maleQty = entryInfo.getDailyQtyAll();
					}
				}else{
					maleQty = BigDecimal.ZERO;
				}
				//母禽日喂料量
				if(sex.equalsIgnoreCase("2") || sex.equalsIgnoreCase("3")){
					if(entryInfo.getFemaleDailyQty() != null){
						feMaleQty = entryInfo.getFemaleDailyQty();
					}
				}else{
					feMaleQty = BigDecimal.ZERO;
				}
				//总日喂料量
				allQty = maleQty.add(feMaleQty);

				//获取对应棚舍的存栏
				if(entryInfo.getHouse() != null && assEntryMap.get(entryInfo.getHouse().getId().toString()) != null){
					stockQty = assEntryMap.get(entryInfo.getHouse().getId().toString());
				}
				//如果存栏量不为零
				//				if(!stockQty.equals(new BigDecimal("0")) ){
				if(UIRuleUtil.isNotNull(stockQty)){
					//平均值只喂料量
					averFeedQty = allQty.divide(stockQty,2,BigDecimal.ROUND_HALF_UP);
				}
				this.kdtEntrys.getCell(j, "averageBreed").setValue(averFeedQty);
			}

			//免疫信息分录
			StockingBreedDailyImmuneEntryCollection immuneColl = editData.getImmuneEntrys();
			StockingBreedDailyImmuneEntryInfo immuneInfo = null;

			BigDecimal vaccineUseQty = BigDecimal.ZERO;
			BigDecimal breekQty = BigDecimal.ZERO;
			BigDecimal dose = BigDecimal.ZERO;
			for(int i = 0,size = immuneColl.size();i<size;i++){
				immuneInfo = immuneColl.get(i);
				vaccineUseQty = immuneInfo.getVaccineUsedQty();
				if(immuneInfo.getHouse() != null 
						&& assEntryMap.get(immuneInfo.getHouse().getId().toString()) != null){
					breekQty = assEntryMap.get(immuneInfo.getHouse().getId().toString());
				}
				if(UIRuleUtil.isNotNull(breekQty)){

					//获取物料

					dose = vaccineUseQty.divide(breekQty,2,BigDecimal.ROUND_HALF_UP);
					this.kdtImmuneEntrys.getCell(i, "dose").setValue(dose);
				}
			}


			//用药信息
			StockingBreedDailyDrugEntryCollection drugColl = editData.getDrugEntrys();
			StockingBreedDailyDrugEntryInfo drugInfo = null;
			BigDecimal drugQuantity = BigDecimal.ZERO;
			BigDecimal drugBreekQty = BigDecimal.ZERO;
			BigDecimal drugDose = BigDecimal.ZERO;
			for(int i = 0,size = drugColl.size();i<size;i++){
				drugInfo = drugColl.get(i);
				drugQuantity = drugInfo.getDrugQuantity();
				if(drugInfo.getHouse() != null 
						&& assEntryMap.get(drugInfo.getHouse().getId().toString()) != null){
					drugBreekQty = assEntryMap.get(drugInfo.getHouse().getId().toString());
				}
				if(UIRuleUtil.isNotNull(drugBreekQty) && UIRuleUtil.isNotNull(drugQuantity)){
					drugDose = drugQuantity.divide(drugBreekQty,2,BigDecimal.ROUND_HALF_UP);
					this.kdtDrugEntrys.getCell(i, "dose").setValue(drugDose);
				}
			}

			//产蛋信息
			StockingBreedDailyEggEntryCollection eggColl = editData.getEggEntry();
			StockingBreedDailyEggEntryInfo eggInfo = null;
			BigDecimal allEggQty = BigDecimal.ZERO;
			BigDecimal eggBreekQty = BigDecimal.ZERO;
			BigDecimal eggRate = BigDecimal.ZERO;
			for(int i = 0,size = eggColl.size();i<size;i++){
				eggInfo = eggColl.get(i);
				allEggQty = eggInfo.getAllQty();
				if(eggInfo.getHouse() != null 
						&& assEntryMap.get(eggInfo.getHouse().getId().toString()) != null){
					eggBreekQty = assEntryMap.get(eggInfo.getHouse().getId().toString());
				}
				if(UIRuleUtil.isNotNull(eggBreekQty)){
					eggRate = allEggQty.divide(eggBreekQty,2,BigDecimal.ROUND_HALF_UP);
					this.kdtEggEntry.getCell(i, "eggRate").setValue(eggRate);
				}
			}








		}
	}

	/**
	 * 启用棚舍管理的对重复性录入的校验
	 */
	private void chechFeedEndtryRepeat() {
		// TODO Auto-generated method stub  饲喂、死淘、免疫、产蛋、环控、转栏、单品包送
		String[] tableArray={"T_FM_StockingBreedDailyEntry","T_FM_StockingBDAE","T_FM_StockingBDIE","T_FM_StockingBDEE","T_FM_StockingBreedDailyEnvi","T_FM_StockingBDTE","T_FM_StockingBDSEE"};
		KDTable[] KDTableArray={kdtEntrys,kdtAssEntrys,kdtImmuneEntrys,kdtEggEntry,kdtEnvi,kdtTransEntry,kdtSendEggEntry};
		for(int index=0;index<tableArray.length;index++){
			String str=
				"\n/*dialect*/select t2.FHouseID"
				+"\nfrom T_FM_StockingBreedDaily                  t1"
				+"\ninner join "+tableArray[index]+"       t2 on t1.FID=t2.FParentID";

			if(prmtstockingBatch.getValue()!=null)
				str+="\n  and t1.CFStockingBatchID='"+((StockingBatchInfo)prmtstockingBatch.getValue()).getString("id")+"'";
			if(pkBizDate.getValue()!=null)
				str+="\n  and to_char(t1.FBizDate, 'yyyy-MM-dd')='"+(new SimpleDateFormat("yyyy-MM-dd")).format(pkBizDate.getValue())+"'";

			if(KDTableArray[index].getRowCount()==0)
				continue;
			for(int i=0;i<KDTableArray[index].getRowCount();i++)
				if(KDTableArray[index].getCell(i, "house").getValue()!=null){
					if(i==0)
						str+="\n and t2.FHouseID in (";
					str+="'"+((FarmHouseEntryInfo)KDTableArray[index].getCell(i, "house").getValue()).getString("id")+"'";
					if(i<KDTableArray[index].getRowCount()-1)
						str+=",";
					if(i==KDTableArray[index].getRowCount()-1)
						str+=")";
				}
			if(editData.getString("id")!=null)
				str+="\n   and t1.FID<>'"+editData.getString("id")+"'";
			IRowSet rs;
			try {
				rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
				if(rs.next())
					commUtils.giveUserTipsAndRetire("当前批次当前日期存在重复的棚舍");
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 检查分录棚舍不能为空
	 * @param table
	 */
	private void checkEntryHouseIsNotNull(KDTable table,String tableName) {
		for(int rowIndex=0;rowIndex<table.getRowCount();rowIndex++) {
			if(table.getCell(rowIndex, "house").getValue()==null) {
				MsgBox.showWarning(tableName+"第"+(rowIndex+1)+"行分录，棚舍不能为空！");
				SysUtil.abort();
			}
			if(table.getColumn("fromHouse")!=null) {
				if(table.getCell(rowIndex, "fromHouse").getValue()==null) {
					MsgBox.showWarning(tableName+"第"+(rowIndex+1)+"行分录，转出棚舍不能为空！");
					SysUtil.abort();
				}
			}
		}
	}

	/* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	private  void setFarmerFilter(final KDBizPromptBox prmtfarmer,final String companyID) {
		// prmtfarmer
		StockingClientComm.setFarmerFilter(prmtfarmer, companyID, true);
	}
	/**
	 * 获取今天尚未填写日报的养殖户
	 * @param date 
	 */
	private ArrayList<String> getNoExistBatchIDDailyToday(Date date) {
		ArrayList<String> list=new ArrayList<String>();
		try {
			//如果职员为空，则返回
			if(SysContext.getSysContext().getCurrentUserInfo().getPerson()==null) {
				return list;
			}

			//剔除掉已经有填写的用户
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date bizdate=date;
			StringBuffer sql=new StringBuffer();
			sql.append(" /*dialect*/select tbatch.fid from t_fm_stockingBatch tbatch")
			.append(" where tbatch.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)//已核准
			.append(" and tbatch.FCompanyID='").append(curCompanyID).append("'")
			.append(" and (tbatch.ffarmerid,tbatch.ffarmid) in (")
			.append(" select t2.FFarmerID,tfarm.ffarmid  from T_FM_PersonFarmerRelation t1  ")
			.append(" inner join  T_FM_PersonFarmerRelationEntry t2 on t2.fparentid=t1.fid ")
			.append(" inner join T_FM_FarmersFarmEntry tfarm on tfarm.fparentid=t2.ffarmerid ")
			.append(" where t1.FPersonID='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'")
			.append(" and t1.FCompanyID='").append(curCompanyID).append("'")
			.append(" and (tbatch.fisAllOut=0 or tbatch.fisAllOut is null)")//未出栏
			.append(" ) and (tbatch.ffarmerid,tbatch.ffarmid) not in (")
			.append("  select ffarmerid,cffarmid  ")
			.append("  from T_FM_StockingBreedDaily")
			.append("  where ffarmerid is not null and cffarmid is not null and FCompanyID='").append(curCompanyID).append("'")
			.append("  and FBizDate>= {ts '").append(sdf.format(bizdate)).append(" 00:00:00','yyyy-MM-dd HH24:mi:ss' }")
			.append("  and FBizDate<= {ts '").append(sdf.format(bizdate)).append(" 23:59:59','yyyy-MM-dd HH24:mi:ss' }");
			sql.append(" )")
			.append(" order by tbatch.fnumber");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()) {
				list.add(rs.getString("fid"));
				//				 break;
			}

		}catch(Exception err) {
			err.printStackTrace();
		}
		return list;
	}

	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);
		//单包重
		if(kdtEntrys.getColumnKey(colIndex).equals("material")&&kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
			kdtEntrys.getCell(rowIndex, "unitQty").setValue(StockingComm.getUnitQty(null, curCompanyID, ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id")));
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("unitQty").getColumnIndex());
		}
		if(kdtEntrys.getColumnKey(colIndex).equals("bagQty")||kdtEntrys.getColumnKey(colIndex).equals("dailyQtyAll") || kdtEntrys.getColumnKey(colIndex).equals("femaleDailyQty"))
		{
			UITools.apendFootRow(kdtEntrys, new String[]{"bagQty","dailyQtyAll","femaleDailyQty"});
		}
		//列复制功能
		//如果是公禽料修改，执行下面的语句
		if("material".equalsIgnoreCase(kdtEntrys.getColumnKey(colIndex))){
			MaterialInfo matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(((MaterialInfo)kdtEntrys.getCell(0,"material").getValue()).getId()));
			for(int i=0,size=kdtEntrys.getRowCount();i<size;i++){
				if(rowIndex == 0){
					kdtEntrys.getCell(i,"material").setValue(matInfo);
					kdtEntrys.getCell(i,"materialName").setValue(matInfo.getName());
				}
			}
		}

		//如果是母禽料修改，执行下面的语句
		if("feMaterail".equalsIgnoreCase(kdtEntrys.getColumnKey(colIndex))){
			for(int i=0,size=kdtEntrys.getRowCount();i<size;i++){
				if(rowIndex == 0){
					if(kdtEntrys.getCell(rowIndex,"feMaterail").getValue() != null){
						MaterialInfo matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(((MaterialInfo)kdtEntrys.getCell(rowIndex,"feMaterail").getValue()).getId()));
						kdtEntrys.getCell(i,"feMaterail").setValue(matInfo);
						kdtEntrys.getCell(i,"mqlbm").setValue(matInfo.getNumber());	
					}

				}
			}
		}




	}

	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
		vo.setInt("nowStage", FarmStageEnum.BROOD_VALUE);
	}
	/**
	 * 重算数量
	 */
	private void resetBirdsQty() {
		// TODO Auto-generated method stub
		if(kdtAssEntrys.getRowCount()==0)
			return;
		for(int i=0;i<kdtAssEntrys.getRowCount();i++){

		};
	}

	@Override
	protected void setTableToSumField(KDTable table, String[] columnFields) {
		// TODO Auto-generated method stub
		super.setTableToSumField(kdtTransEntry, new String[]{"transQty","transFemaleQty"});
	}

}