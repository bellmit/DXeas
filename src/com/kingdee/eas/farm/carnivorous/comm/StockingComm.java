package com.kingdee.eas.farm.carnivorous.comm;

import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.event.CommitEvent;
import com.kingdee.bos.ctrl.swing.event.CommitListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.service.job.wrapper.SqlExecutor;
import com.kingdee.bos.sql.util.StringUtil;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.MainDataParser;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.IMaterialInventory;
import com.kingdee.eas.basedata.master.material.IMaterialSales;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.master.material.MaterialSalesCollection;
import com.kingdee.eas.basedata.master.material.MaterialSalesFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.basedata.org.OrgUnitCollection;
import com.kingdee.eas.basedata.org.OrgUnitRelationFactory;
import com.kingdee.eas.basedata.person.client.PersonPromptBox;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillEntryFactory;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillFactory;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillEntryFactory;
import com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceFactory;
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.basedata.IFarm;
import com.kingdee.eas.farm.carnivorous.basedata.IFarmer;
import com.kingdee.eas.farm.carnivorous.basedata.ISystemSetting;
import com.kingdee.eas.farm.carnivorous.basedata.RandPScope;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicy;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingCollection;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.basedata.TempPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.TempPolicyMarketPriceEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.TempPolicyMarketPriceEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.CloseStatus;
import com.kingdee.eas.farm.carnivorous.feedbiz.client.BatchContractBillEditUI;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillPreHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedSourceEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType;
import com.kingdee.eas.farm.stocking.basedata.BreedData;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.BasePriceBean;
import com.kingdee.eas.farm.stocking.hatch.GenderType;
import com.kingdee.eas.farm.stocking.hatch.GenerateType;
import com.kingdee.eas.fm.common.client.query.convert.Convert;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.comm.ComReaderUtils;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

public class StockingComm {

	public  static final int PRRICE_IN_TYPE=1;//支出价格
	public  static final int PRRICE_OUT_TYPE=2;//回收价格
	public static final String IsExistMutiStockingBatch="_existMuti";
	public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat sdfMonth=new SimpleDateFormat("yyyy-MM");
	public static final SimpleDateFormat sdfTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//养殖品种过滤
	public  static void setBreedDataFilter(KDBizPromptBox prmtBreedData,GenerateType generateType){
		SelectorListener[] ls = prmtBreedData.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtBreedData.removeSelectorListener(ls[i]);
		}
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
		if(generateType!=null){
			filter.getFilterItems().add(new FilterItemInfo("generateType",generateType.getValue(),CompareType.EQUALS));
		}
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtBreedData.setEntityViewInfo(evi);
		prmtBreedData.setCommitFormat("$number$;$name$");	
	}

	//兽医过滤
	public  static void setVetFilter(KDBizPromptBox prmtVet, String companyID){
		SelectorListener[] ls = prmtVet.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtVet.removeSelectorListener(ls[i]);
		}
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("FIcompany.id",companyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtVet.setEntityViewInfo(evi);
		prmtVet.setCommitFormat("$number$;$name$");	
	}

	//抓鸡队过滤
	public  static void setCatchCKTeamFilter(KDBizPromptBox prmtCatchCKTeam, String companyID){
		SelectorListener[] ls = prmtCatchCKTeam.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtCatchCKTeam.removeSelectorListener(ls[i]);
		}
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("FIcompany.id",companyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtCatchCKTeam.setEntityViewInfo(evi);
		prmtCatchCKTeam.setCommitFormat("$number$;$name$");	
	}

	//车辆规格过滤
	public  static void setCarSizeFilter(KDBizPromptBox prmtCarSize, String companyID){
		SelectorListener[] ls = prmtCarSize.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtCarSize.removeSelectorListener(ls[i]);
		}
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("CompanyOrgUnit.id",companyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtCarSize.setEntityViewInfo(evi);
	}

	//运费计算点过滤
	public  static void setCalUnitFilter(KDBizPromptBox prmtCalUnit, String companyID){
		SelectorListener[] ls = prmtCalUnit.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtCalUnit.removeSelectorListener(ls[i]);
		}

		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("FIcompany.id",companyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtCalUnit.setEntityViewInfo(evi);
	}


	//获取养户最新的担保书
	public  static FarmerGuaranteeBillInfo getGuaranteeBill(Context ctx,String farmerID,Date bizDate){
		if(StringUtils.isEmpty(farmerID)) {
			return null;
		}
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 fid from CT_FM_FarmerGuaranteeBill")
			.append(" where CFFarmerID='").append(farmerID).append("'")
			.append(" and CFBillStatus=4")
			.append(" and to_char(CFBeginDate,'yyyy-mm-dd')<='"+sdf.format(bizDate)+"'")
			.append(" and (CFEndDate is null or to_char(CFEndDate,'yyyy-mm-dd')>='"+sdf.format(bizDate)+"')")
			.append(" order by CFBeginDate desc");
			IRowSet rs=null;
			if(ctx!=null) {
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}else {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}
			if(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				if(ctx==null)
					return FarmerGuaranteeBillFactory.getRemoteInstance().getFarmerGuaranteeBillInfo(new ObjectUuidPK(rs.getString("fid")),slor);
				else
					return FarmerGuaranteeBillFactory.getLocalInstance(ctx).getFarmerGuaranteeBillInfo(new ObjectUuidPK(rs.getString("fid")),slor);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}


	//设置担保申请表过滤
	public  static void setGuaranteeBillFilter(KDBizPromptBox prmtguaranty, String companyID,String farmerID,Date bizDate){
		SelectorListener[] ls = prmtguaranty.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtguaranty.removeSelectorListener(ls[i]);
		}
		if(bizDate==null){
			prmtguaranty.setEntityViewInfo(null);
		}
		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("FIcompany.id",companyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("farmer.id",farmerID,CompareType.EQUALS));
		try {
			filter.getFilterItems().add(new FilterItemInfo("beginDate",sdf.parse(sdf.format(bizDate)),CompareType.LESS_EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("endDate",sdf.parse(sdf.format(bizDate)),CompareType.GREATER_EQUALS));
			if(StringUtils.isNotEmpty(companyID)) {
				filter.setMaskString(" #0 and #1 and #2 and (#3 or #4 ) ");		
			}else{
				filter.setMaskString(" #0 and #1  and (#1 or #2 ) ");		
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtguaranty.setEntityViewInfo(evi);
	}

	//设置养殖评定项目过滤
	public  static void setFarmingCheckItemFilter(KDBizPromptBox prmtFarmingCheckItem, String companyID){
		SelectorListener[] ls = prmtFarmingCheckItem.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtFarmingCheckItem.removeSelectorListener(ls[i]);
		}
		prmtFarmingCheckItem.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmingCheckItemQuery");		
		prmtFarmingCheckItem.setEditable(true);		
		prmtFarmingCheckItem.setDisplayFormat("$name$");		
		prmtFarmingCheckItem.setEditFormat("$name$");		
		prmtFarmingCheckItem.setCommitFormat("$number$;$name$");	

		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("FIcompany.id",companyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtFarmingCheckItem.setEntityViewInfo(evi);
	}

	//通过品种设置奖惩政策过滤
	public  static void setRPPolicyFilterByBillType(KDBizPromptBox prmtRPPolicy,String breedDataID){
		SelectorListener[] ls = prmtRPPolicy.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtRPPolicy.removeSelectorListener(ls[i]);
		}
		prmtRPPolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.RandPPolicyQuery");		
		prmtRPPolicy.setEditable(true);		
		prmtRPPolicy.setDisplayFormat("$name$");
		prmtRPPolicy.setEditFormat("$name$");		
		prmtRPPolicy.setCommitFormat("$number$;$name$");	
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("breedData.id",breedDataID,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtRPPolicy.setEntityViewInfo(evi);
	}


	//通过结算政策和单据类型设置奖惩项目过滤
	public  static void setRPItemFilterByBillType(KDBizPromptBox prmtRPItem,String settlePolicyID,RandPScope scope){
		SelectorListener[] ls = prmtRPItem.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtRPItem.removeSelectorListener(ls[i]);
		}
		HashSet ids=new HashSet<String>();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" select distinct t1.fid from CT_FM_RewardAndPunishItem t1 inner join CT_FM_RandPPolicy t4 on t4.CFRandPItemID=t1.fid ")
		.append("  inner join T_FM_SettlePolicyAwardsEntry  t2 on t2.CFRandPPolicyID=t4.fid inner join T_FM_SettlePolicy t3 on t2.fparentid=t3.fid  ")
		.append(" where 1=1 ");
		if(settlePolicyID!=null){
			sqlBuf.append("and t3.fid='"+settlePolicyID+"'");
		}
		if(scope!=null){
			sqlBuf.append("and t1.CFScope='"+scope.getValue()+"' ");
		}
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			while (rs.next()) {
				ids.add(rs.getString("fid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(scope!=null){
			filter.getFilterItems().add(new FilterItemInfo("scope",scope.getValue(),CompareType.EQUALS));
		}
		if(ids.size()>0){
			filter.getFilterItems().add(new FilterItemInfo("id",ids,CompareType.INCLUDE));
		}
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtRPItem.setEntityViewInfo(evi);
	}

	//通过销售类型设置客户过滤
	public  static void setCustomerFilterBySale(KDBizPromptBox prmtCustomer,SaleBizType type){
		SelectorListener[] ls = prmtCustomer.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtCustomer.removeSelectorListener(ls[i]);
		}
		prmtCustomer.setDisplayFormat("$name$");
		FilterInfo filter=new FilterInfo();
		int isInter=-1;
		if(type!=null){
			isInter=type==SaleBizType.out?0:1;
		}
		filter.getFilterItems().add(new FilterItemInfo("usedStatus",1,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("isInternalCompany",isInter,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtCustomer.setEntityViewInfo(evi);
	}

	//设置客诉类型过滤
	public  static void setCustomerViewTypeFilter(KDBizPromptBox prmtCustomerViewType, String companyID){
		SelectorListener[] ls = prmtCustomerViewType.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtCustomerViewType.removeSelectorListener(ls[i]);
		}
		prmtCustomerViewType.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.CustomerViewTypeQuery");		
		prmtCustomerViewType.setEditable(true);		
		prmtCustomerViewType.setDisplayFormat("$name$");		
		prmtCustomerViewType.setEditFormat("$name$");		
		prmtCustomerViewType.setCommitFormat("$number$;$name$");	

		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("FIcompany.id",companyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtCustomerViewType.setEntityViewInfo(evi);
	}


	//设置养殖户类别过滤
	public  static void setFarmerTypeFilter(KDBizPromptBox prmtfarmerType, String companyID){
		SelectorListener[] ls = prmtfarmerType.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarmerType.removeSelectorListener(ls[i]);
		}
		prmtfarmerType.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerTypeQuery");		
		prmtfarmerType.setEditable(true);		
		prmtfarmerType.setDisplayFormat("$name$");		
		prmtfarmerType.setEditFormat("$name$");		
		prmtfarmerType.setCommitFormat("$number$;$name$");	

		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("FIcompany.id",companyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtfarmerType.setEntityViewInfo(evi);
	}



	/* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public  static void setFarmerFilter(final KDBizPromptBox prmtfarmer,final String companyID,final boolean isPersonLimit) {
		// prmtfarmer
		SelectorListener[] ls = prmtfarmer.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarmer.removeSelectorListener(ls[i]);
		}

		prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
		prmtfarmer.setEditable(true);		
		prmtfarmer.setDisplayFormat("$name$");		
		prmtfarmer.setEditFormat("$name$");		
		prmtfarmer.setCommitFormat("$number$;$name$");	
		prmtfarmer.setRequired(true);

		FilterInfo filter=new FilterInfo();
		filter=getFarmerFilter(companyID, false);
		filter.getFilterItems().add(new FilterItemInfo("FarmEntry.seq",1,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtfarmer.setEntityViewInfo(evi);
	}

	/**
	 * 获取养户过滤条件
	 * @param companyID
	 * @param isPersonLimit
	 * @return
	 */
	public static FilterInfo getFarmerFilter(String companyID,boolean isPersonLimit) {
		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		//获取业务员对应的养殖户
		Set ids=new HashSet();
		if(isPersonLimit&&SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null) {
			ids=getFarmerSetByCurrentUser();
		}

		if(ids.size()>0) {
			filter.getFilterItems().add(new FilterItemInfo("id",ids,CompareType.INCLUDE));
		}
		return filter;
	}

	private static Set getFarmerSetByCurrentUser() {
		Set ids=new HashSet();
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select t2.FFarmerID from T_FM_PersonFarmerRelation t1  ")
			.append(" inner join  T_FM_PersonFarmerRelationEntry t2 on t2.fparentid=t1.fid")
			.append(" where FPersonID='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getString("id")).append("'")
			.append(" ")
			;
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()) {
				ids.add(rs.getString("FFarmerID"));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return ids;
	}
	/**
	 * 获取参数设置
	 * @param ctx
	 * @param companyID
	 * @return SystemSettingInfo or null
	 */
	public static SystemSettingInfo getSystemSettingInfo(Context ctx,String companyID){

		SystemSettingInfo info=null;
		ISystemSetting iSystemSetting=null;
		try {
			if(ctx==null)
				iSystemSetting=SystemSettingFactory.getRemoteInstance();
			else
				iSystemSetting=SystemSettingFactory.getLocalInstance(ctx);
			SystemSettingCollection coll = iSystemSetting.getSystemSettingCollection("where company='"+companyID+"'");
			if(coll.size()>0){
				return coll.get(0);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}
	/* 设置养殖场过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public  static void setFarmFilter(final KDBizPromptBox prmtfarm,final String companyID,final String farmerID,final Boolean isAllot) {
		SelectorListener[] ls = prmtfarm.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarm.removeSelectorListener(ls[i]);
		}
		prmtfarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
		prmtfarm.setDisplayFormat("$name$");		
		prmtfarm.setEditFormat("$name$");		
		prmtfarm.setCommitFormat("$number$;$name$;$MnemonicCode$");	
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		//养殖户所包含养殖场
		Set idSet=new HashSet();
		idSet.add("hahahahaha");
		if(StringUtils.isNotBlank(farmerID)) {
			try {
				StringBuffer sql=new StringBuffer();
				sql.append(" select distinct tentry.FFarmID from CT_FM_Farmer tmain ")
				.append(" inner join CT_FM_FarmerFarmEntry tentry on tentry.FParentid=tmain.fid")
				.append(" where tmain.FID='").append(farmerID).append("'")
				.append(" and tentry.ffarmid is not null");
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				while(rs.next()) {
					idSet.add(rs.getString("FFarmID"));
				}
			}catch(Exception err) {
				err.printStackTrace();
			}}
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		if(StringUtils.isNotBlank(farmerID)) {
			filter.getFilterItems().add(new FilterItemInfo("id",idSet,CompareType.INCLUDE));
		}
		if(isAllot!=null){
			filter.getFilterItems().add(new FilterItemInfo("isAllot", isAllot,CompareType.EQUALS)); // 是否分配								
		}
		ev.setFilter(filter);
		prmtfarm.setEntityViewInfo(ev);
	}

	/**
	 * 根据养殖户设置养殖场
	 * @param prmtfarmer
	 * @param prmtfarm
	 */
	public static void setFarmInfoByFarmer(KDBizPromptBox prmtfarmer,
			KDBizPromptBox prmtfarm) {
		// TODO Auto-generated method stub
		if(prmtfarmer.getValue()==null)
			return;
		StringBuffer sql=new StringBuffer();
		sql.append(" select distinct tentry.FFarmID FFarmID from CT_FM_Farmer tmain ")
		.append(" inner join CT_FM_FarmerFarmEntry tentry on tentry.FParentid=tmain.fid")
		.append(" inner join CT_FM_Farm tfarm on tfarm.fid=tentry.FFarmID")
		.append(" where tmain.FID='").append(((IPropertyContainer)prmtfarmer.getValue()).getString("id")).append("'")
		.append(" and tentry.ffarmid is not null")
		.append(" and tfarm.FBaseStatus ='2'");
		;
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()){
				prmtfarm.setValue(FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(rs.getString("FFarmID"))));
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



	/**
	 * 设置技术员隔离
	 * @param prmtperson
	 * @param curCompanyID
	 * @param batchContractEditUI
	 * @param b
	 */
	public static void setPerosnFilter(KDBizPromptBox prmtperson,
			String curCompanyID, BatchContractBillEditUI batchContractEditUI,
			boolean b) {
		// TODO Auto-generated method stub
		String str="select FPersonID from T_FM_PersonFarmerRange where FCompanyID='"+curCompanyID+"' and FBaseStatus=4 group by FPersonID";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			EntityViewInfo evi=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			HashSet<String> set=new HashSet<String>();
			set.add("123");
			while(rs.next()){
				set.add(rs.getString("FPersonID"));
			}
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INNER));
			evi.setFilter(filter);
			prmtperson.setEntityViewInfo(evi);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过批次ID获取合同ID
	 * @param batchID
	 * @return
	 */
	public static String getContractIDByBatchID(Context ctx, String batchID) {
		// TODO Auto-generated method stub
		try {
			if(StringUtils.isEmpty(batchID)) {
				return null;
			}
			IBatch is=null;
			if(ctx!=null){ 
				is=BatchFactory.getLocalInstance(ctx);
			}else{
				is=BatchFactory.getRemoteInstance();
			}
			BatchInfo batchInfo = is.getBatchInfo(new ObjectUuidPK(batchID));
			if(batchInfo.getBatchContract()!=null) {
				return batchInfo.getBatchContract().getString("id");
			}

			StringBuffer sql=new StringBuffer();
			/*sql.append(" select top 1 tc.fid from T_FM_BreedSeedBill tbill")
		    	.append(" inner join T_FM_BatchContract tc on tc.fid=tbill.CFBatchContractID")
		    	.append(" where tbill.fbillstatus=4")
		    	.append(" and tbill.FStockingBatchID='").append(batchID).append("'")
		    	.append(" order by tbill.FCreateTime desc");*/
			sql.append(" select fbatchcontractid ")
			.append(" from t_fm_Batch")
			.append(" where fid='").append(batchID).append("'")
			.append(" and fbatchcontractid is not null");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
			}
			if(rs.next()) {
				return rs.getString("fid");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过批次ID获取合同ID
	 * @param batchID
	 * @return
	 */
	public static BatchContractBillInfo getContractInfoIDByBatchID(Context ctx, String batchID) {
		// TODO Auto-generated method stub
		try {
			if(StringUtils.isEmpty(batchID)) {
				return null;
			}
			StringBuffer sql=new StringBuffer();
			sql.append(" select fbatchcontractid ")
			.append(" from t_fm_Batch")
			.append(" where fid='").append(batchID).append("'")
			.append(" and fbatchcontractid is not null");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
			}
			if(rs.next()) {
				if(ctx==null)
					return BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(rs.getString("fbatchcontractid")));
				else
					return BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(rs.getString("fbatchcontractid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据批次查找合同
	 * @param ctx
	 * @param contractID
	 * @return
	 */
	public static String getBatchIDByContractID(Context ctx, String contractID) {
		// TODO Auto-generated method stub
		try {
			if(StringUtils.isEmpty(contractID)) {
				return null;
			}
			StringBuffer sql=new StringBuffer();
			sql.append(" select FID ")
			.append(" from t_fm_Batch")
			.append(" where fbatchcontractid='").append(contractID).append("'")
			.append(" ");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
			}
			if(rs.next()) {
				return rs.getString("fid");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据养殖户查找养殖场
	 * @param ctx
	 * @param farmerID
	 * @return
	 */
	public static FarmInfo getFarmInfoByFarmerID(
			Context ctx, String farmerID) {
		// TODO Auto-generated method stub
		try {
			if(StringUtils.isEmpty(farmerID))
				return null;
			IFarmer iFarmer=null;
			if(ctx==null)
				iFarmer=FarmerFactory.getRemoteInstance();
			else
				iFarmer=FarmerFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farmEntry.*");
			slor.add("farmEntry.farm.*");
			FarmerInfo farmerInfo = iFarmer.getFarmerInfo(new ObjectUuidPK(farmerID),slor);
			if(farmerInfo.getFarmEntry().size()>0)
				return farmerInfo.getFarmEntry().get(0).getFarm();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getFarmersByPerson(Object object,
			String companyID) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查找养殖户的最后一个批次
	 * @param object
	 * @param farmerID
	 * @param farmID
	 * @return
	 */
	public static String getLastStockingBatch(Context ctx, String farmerID,
			String farmID) {
		if(StringUtils.isEmpty(farmerID)) {
			return null;
		}
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 fid from t_fm_Batch")
			.append(" where FFarmerID='").append(farmerID).append("'")
			.append(" and FbaseStatus=").append(FarmBaseStatusEnum.APPROVE_VALUE);
			if(StringUtils.isNotEmpty(farmID)) {
				sql.append(" and FFarmID='").append(farmID).append("'");
			}sql.append(" order by FInDate desc");

			IRowSet rs=null;
			if(ctx!=null) {
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}else {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}
			if(rs.next()) {
				return rs.getString("fid");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}

		return null;
	}

	/**
	 * 得到最新的一个批次
	 * @return 返回info
	 */
	public static BatchInfo getLastStockingBatchInfo(Context ctx,String farmerID,String farmID) {
		if(StringUtils.isEmpty(farmerID)) {
			return null;
		}
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 fid from t_fm_Batch")
			.append(" where FFarmerID='").append(farmerID).append("'")
			.append(" and FbaseStatus=").append(FarmBaseStatusEnum.APPROVE_VALUE)
			.append(" and FFarmID='").append(farmID).append("'")
			.append(" order by FInDate desc");

			IRowSet rs=null;
			if(ctx!=null) {
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}else {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}
			if(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				if(ctx==null)
					return BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(rs.getString("fid")),slor);
				else
					return BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(rs.getString("fid")),slor);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}

		return null;
	}

	/**
	 * 得到最新的一个批次合同
	 * 添加结算控制
	 * @return 返回info
	 */
	public static BatchContractBillInfo getLastBatchContractInfo(Context ctx,String farmerID,String farmID,Boolean isUnSettled) {
		if(StringUtils.isEmpty(farmerID)) {
			return null;
		}
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 fid from T_FM_BatchContractBill")
			.append(" where FFarmerID='").append(farmerID).append("'")
			.append(" and FBillStatus=").append(4);
			if(StringUtils.isNotEmpty(farmID)) {
				sql.append(" and FFarmID='").append(farmID).append("'");
			}
			if(isUnSettled!=null){
				if(isUnSettled){
					sql.append(" and (CFIsRecSettled is null or CFIsRecSettled='0')");
				}else{
					sql.append(" and  CFIsRecSettled='1'");
				}
			}
			sql.append(" order by FBizDate desc");
			IRowSet rs=null;
			if(ctx!=null) {
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}else {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}
			if(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("breedData.*");
				if(ctx==null)
					return BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(rs.getString("fid")),slor);
				else
					return BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(rs.getString("fid")),slor);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取物料的单包重
	 * @return
	 */
	public static BigDecimal getUnitQty(Context ctx,String companyID,String materialID) {
		try {
			IMaterialSales ims = null;
			if(ctx!=null){
				ims=MaterialSalesFactory.getLocalInstance(ctx);
			}else{
				ims=MaterialSalesFactory.getRemoteInstance();
			}
			MaterialSalesCollection mInfos = ims.getMaterialSalesCollection(new EntityViewInfo("where Material='"+materialID+"' and OrgUnit='"+companyID+"'"));
			if(mInfos.size()!=1){
				return BigDecimal.ZERO;
			}
			MaterialSalesInfo mInfo=mInfos.get(0);
			if(mInfo.containsKey("unitQty")&&mInfo.getBigDecimal("unitQty")!=null) {
				return mInfo.getBigDecimal("unitQty");
			}
			if(mInfo.containsKey("bagQty")&&mInfo.getBigDecimal("bagQty")!=null) {
				return mInfo.getBigDecimal("bagQty");
			}
			if(mInfo.containsKey("oneBagWgt")&&mInfo.getBigDecimal("oneBagWgt")!=null) {
				return mInfo.getBigDecimal("oneBagWgt");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}

		return BigDecimal.ZERO;
	}

	/**
	 * 根据库存组织 和物料ID获取 默认仓库
	 * 
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static WarehouseInfo getDefaultWarehouseByMaterial(Context ctx, String storageOrgUnitID, String materialID)
	throws BOSException, EASBizException {
		try{
			if(StringUtils.isEmpty(storageOrgUnitID)) {
				return null;
			}
			MaterialInventoryInfo tempInfo = getDefaultWarehouseDataByMaterial(ctx, storageOrgUnitID, materialID);
			return tempInfo!=null?tempInfo.getDefaultWarehouse():null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static int[] getBreedWeekAndDay(Date date, Date inDate) {
		// TODO Auto-generated method stubeek
		int[] weekAge = new int [2]; 
		try {
			int days = DateCommon.dateDiff(inDate, date);
			//days表示的是纯日龄
			++days;
			weekAge[0] = days/7+1;
			weekAge[1] = (days%7+1)==0?7:(days%7+1);
			return weekAge;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static HashMap<MaterialInfo, BigDecimal> getBreedFodderStandard(
			Object object, String companyID, String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void setBatchFilter( final KDBizPromptBox prmtBatch, final String companyID,final String farmerID,final String farmID) {
		// TODO Auto-generated method stub
		final KDBizPromptBox kdtEntrys_batch_PromptBox = new KDBizPromptBox();
		prmtBatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");
		prmtBatch.setVisible(true);
		prmtBatch.setEditable(true);
		prmtBatch.setDisplayFormat("$number$");
		prmtBatch.setEditFormat("$number$");
		prmtBatch.setCommitFormat("$number$");

		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		//是否完全出栏
		//		filter.getFilterItems().add(new FilterItemInfo("isAllOut",0,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("farmer.id",farmerID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtBatch.setEntityViewInfo(evi);
	}

	//设置车辆过滤
	public  static void setCarFilter(final KDBizPromptBox prmtCar,final String companyID,final String driverID) {
		// TODO Auto-generated method stub
		SelectorListener[] ls = prmtCar.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtCar.removeSelectorListener(ls[i]);
		}
		HashSet<String> set=new HashSet<String>();
		String sql="select distinct t1.fid fid from CT_PUB_Car t1 inner join T_PUB_CarEntry t2 on t1.fid=t2.fparentid where t2.FDriverID='"+driverID+"' and t1.CFBaseStatus=2";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			while(rs.next()){
				set.add(rs.getString("fid"));
			}
		} catch (BOSException e2) {
			e2.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		FilterInfo filter=new FilterInfo();
		if(set.size()>0){
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
		}
		filter.getFilterItems().add(new FilterItemInfo("CompanyOrgUnit.id",companyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtCar.setEntityViewInfo(evi);

		prmtCar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtCar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtCar_F7ListUI == null) {
					try {
						prmtCar_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI(){

							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								return false;
							}
							protected FilterInfo getDefaultFilterForQuery() {	
								HashSet<String> set=new HashSet<String>();
								String sql="select distinct t1.fid fid from CT_PUB_Car t1 inner join T_PUB_CarEntry t2 on t1.fid=t2.fparentid where t2.FDriverID='"+driverID+"' and t1.CFBaseStatus=2";
								try {
									IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
									while(rs.next()){
										set.add(rs.getString("fid"));
									}
								} catch (BOSException e2) {
									e2.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
								FilterInfo filter=new FilterInfo();
								if(set.size()>0){
									filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
								}
								filter.getFilterItems().add(new FilterItemInfo("CompanyOrgUnit.id",companyID,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
								return filter;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtCar_F7ListUI));
					prmtCar_F7ListUI.setF7Use(true,ctx);
					prmtCar.setSelector(prmtCar_F7ListUI);
				}
			}
		});
	}

	//设置司机过滤
	public  static void setDriverFilter(final KDBizPromptBox prmtDriver,final String companyID,final String carID) {
		// TODO Auto-generated method stub
		SelectorListener[] ls = prmtDriver.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtDriver.removeSelectorListener(ls[i]);
		}
		prmtDriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
		prmtDriver.setVisible(true);		
		prmtDriver.setEditable(true);		
		prmtDriver.setDisplayFormat("$drivername$");		
		prmtDriver.setEditFormat("$drivername$");		
		prmtDriver.setCommitFormat("$drivername$");		
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id",companyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		if(carID!=null){
			try {
				HashSet<String> set=new HashSet<String>();
				set.add("yusheID");
				SelectorItemCollection slor =new SelectorItemCollection();
				slor.add("*");
				slor.add("Entry.*");
				slor.add("Entry.driver.*");
				CarInfo	car = CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(carID), slor);
				CarEntryCollection carEntry=car.getEntry();
				for(int i=0;i<carEntry.size();i++){
					CarEntryInfo entry =carEntry.get(i);
					set.add(entry.getDriver().getId().toString());
				}
				filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtDriver.setEntityViewInfo(evi);
	}
	//批次合同过滤
	public static void setBatchContractFilter(KDBizPromptBox prmtContract,
			String curCompanyID, Object farmer, Object farm,Boolean isFFLimit) {
		// TODO Auto-generated method stub
		prmtContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
		prmtContract.setVisible(true);		
		prmtContract.setEditable(true);		
		prmtContract.setDisplayFormat("$number$");		
		prmtContract.setEditFormat("$number$");		
		prmtContract.setCommitFormat("$number$");		
		prmtContract.setRequired(true);
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		String farmerID=null;
		String farmID=null;
		if(farmer!=null&&farmer instanceof KDBizPromptBox){
			if(((KDBizPromptBox)farmer).getValue()!=null)
				farmerID=((IPropertyContainer)((KDBizPromptBox)farmer).getValue()).getString("id");
		}else if(farmer!=null&&farmer instanceof String){
			farmerID=farmer.toString();
		}

		if(farm!=null&&farm instanceof KDBizPromptBox){
			if(((KDBizPromptBox)farm).getValue()!=null)
				farmID=((IPropertyContainer)((KDBizPromptBox)farm).getValue()).getString("id");
		}else if(farm!=null&&farm instanceof String){
			farmID=farm.toString();
		}

		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));

		if(isFFLimit){
//			filter.getFilterItems().add(new FilterItemInfo("farmer.id",StringUtils.isBlank(farmerID)?"":farmerID,CompareType.EQUALS));								
//			filter.getFilterItems().add(new FilterItemInfo("farm.id",StringUtils.isBlank(farmID)?"":farmID,CompareType.EQUALS));
		}else{
//			filter.getFilterItems().add(new FilterItemInfo("farmer.id",StringUtils.isBlank(farmerID)?"%%":farmerID,CompareType.LIKE));								
//			filter.getFilterItems().add(new FilterItemInfo("farm.id",StringUtils.isBlank(farmID)?"%%":farmID,CompareType.LIKE));
		}

		evi.setFilter(filter);
		prmtContract.setEntityViewInfo(evi);
	}
	//批次合同过滤
	public static void setBatchContractFilter(KDBizPromptBox prmtContract,
			String curCompanyID, Object farmer, Object farm,Boolean isFFLimit,Boolean isUnSettled) {
		// TODO Auto-generated method stub
		prmtContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
		prmtContract.setVisible(true);		
		prmtContract.setEditable(true);		
		prmtContract.setDisplayFormat("$number$");		
		prmtContract.setEditFormat("$number$");		
		prmtContract.setCommitFormat("$number$");		
		prmtContract.setRequired(false);
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		String farmerID=null;
		String farmID=null;
		if(farmer!=null&&farmer instanceof KDBizPromptBox){
			if(((KDBizPromptBox)farmer).getValue()!=null)
				farmerID=((IPropertyContainer)((KDBizPromptBox)farmer).getValue()).getString("id");
		}else if(farmer!=null&&farmer instanceof String){
			farmerID=farmer.toString();
		}

		if(farm!=null&&farm instanceof KDBizPromptBox){
			if(((KDBizPromptBox)farm).getValue()!=null)
				farmID=((IPropertyContainer)((KDBizPromptBox)farm).getValue()).getString("id");
		}else if(farm!=null&&farm instanceof String){
			farmID=farm.toString();
		}

		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));

		if(isFFLimit){
			filter.getFilterItems().add(new FilterItemInfo("farmer.id",StringUtils.isBlank(farmerID)?"":farmerID,CompareType.EQUALS));								
			filter.getFilterItems().add(new FilterItemInfo("farm.id",StringUtils.isBlank(farmID)?"":farmID,CompareType.EQUALS));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("farmer.id",StringUtils.isBlank(farmerID)?"%%":farmerID,CompareType.LIKE));								
			filter.getFilterItems().add(new FilterItemInfo("farm.id",StringUtils.isBlank(farmID)?"%%":farmID,CompareType.LIKE));
		}
		if(isUnSettled!=null){
			filter.getFilterItems().add(new FilterItemInfo("isRecSettled",isUnSettled?0:1,CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("isRecSettled",isUnSettled?null:1,CompareType.IS));
			filter.setMaskString("#0 AND #1 AND #2 AND #3 AND (#4 or #5)");
		}
		evi.setFilter(filter);
		prmtContract.setEntityViewInfo(evi);
	}


	public static void setEntryBasePriceByContractID(int priceType,
			String contractID, IRow row) {

		String materialID=null,unitID=null;
		if(row.getCell("material").getValue()!=null) {
			materialID=((IPropertyContainer) row.getCell("material").getValue()).getString("id");
		}
		if(row.getCell("unit").getValue()!=null) {
			unitID=((IPropertyContainer) row.getCell("unit").getValue()).getString("id");
		}

		ArrayList<BasePriceBean> list = getBasePrice(null,priceType,contractID,materialID,unitID);
		if(list!=null&&list.size()>0) {
			row.getCell("basePrice").setValue(list.get(0).getBasePrice());
			//			if(row.getCell("receivePrice").getValue()==null) {
			row.getCell("receivePrice").setValue(list.get(0).getBasePrice());
			//			}
		}else{
			row.getCell("basePrice").setValue(BigDecimal.ZERO);
		}
	}


	//通过结算政策获取物料filter
	public static FilterInfo getMaterialFilter(Context ctx,String policyID,int SettleItemType){
		FilterInfo filter=new FilterInfo();
		HashSet<String> set=new HashSet<String>();
		set.add("yusheid");
		StringBuffer sql=new StringBuffer();
		sql.append("/*dialect*/ select distinct t2.FMaterialID material from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyPriceEntry t2 on t2.fparentid=t1.fid inner join T_FM_SettlementItem t3 on t3.fid=t2.FSettlementItemID")
		.append(" where t1.fid='"+policyID+"'");
		if(3-SettleItemType == 0){
			sql.append("  and (t3.FSettleItemType=3 or t3.FSettleItemType=8 )");
		}else{
			sql.append(" and t3.FSettleItemType="+SettleItemType);
		}

		try {
			IRowSet rs;
			if(ctx!=null){
				rs = DbUtil.executeQuery(ctx, sql.toString());
			}else{
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}
			while(rs.next()){
				set.add(rs.getString("material"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
		return filter;	
	}


	//通过物料获取结算政策投入政策分录的基础价格
	public static BigDecimal getBasePrice(Context ctx,String policyID,String materialID){
		BigDecimal BasePrice=BigDecimal.ZERO;
		String sql="select isnull(t2.FBasePrice,0) price from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyPriceEntry t2 on t2.fparentid=t1.fid where t1.fid='"+policyID+"' and t2.FMaterialID='"+materialID+"'";
		try {
			IRowSet rs;
			if(ctx!=null){
				rs = DbUtil.executeQuery(ctx, sql);
			}else{
				rs=SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			}
			if(rs.next()){
				BasePrice=rs.getBigDecimal("price");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BasePrice;
	}

	//通过品种资料获取对应种苗物料
	public static ArrayList<String> getSeedIDs(Context ctx,String BreedDataID){
		ArrayList<String>  seedIDs=new ArrayList<String>();
		String sql="/*dialect*/select distinct t2.FMaterialID fid from T_FM_BreedData t1 inner join T_FM_BreedDataSeedEntry t2 on t2.fparentid=t1.fid where t1.fid='"+BreedDataID+"' ";
		try {
			IRowSet rs;
			if(ctx!=null){
				rs = DbUtil.executeQuery(ctx, sql);
			}else{
				rs=SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			}
			while(rs.next()){
				seedIDs.add(rs.getString("fid"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seedIDs;
	}

	/**
	 * 获取基础价格 
	 * @param ctx
	 * @param companyID
	 * @param materialID
	 * @return
	 */
	public static ArrayList<BasePriceBean> getBasePrice(Context ctx,int priceType,String contractID,String materialID,String unitID) {
		if(StringUtils.isEmpty(contractID)){
			return null;
		}
		try {
			ArrayList<BasePriceBean> result=new ArrayList<BasePriceBean>();
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct tse.fmaterialid,tse.FunitID,tse.FBasePrice")
			.append(" from T_FM_SettlePolicy ts");
			if(priceType==PRRICE_OUT_TYPE) {
				sql.append(" inner join T_FM_SettlePolicyPriceEntry tse on tse.fparentid=ts.fid");
			}
			if(priceType==PRRICE_IN_TYPE) {
				sql.append(" inner join T_FM_SettlePolicyRecycleEntry tse on tse.fparentid=ts.fid");
			}
			sql.append(" inner join T_FM_BatchContractBill tc on tc.FSettlementPolicyI=ts.fid")
			.append(" where tc.fid='").append(contractID).append("'");
			//    		if(StringUtils.isNotEmpty(materialID)){
			sql.append(" and tse.fmaterialid='").append(materialID).append("'");
			//    		}
			//    		if(StringUtils.isNotEmpty(unitID)){
			sql.append(" and tse.funitid='").append(unitID).append("'");
			//    		}
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
			}
			while(rs.next()) {
				BasePriceBean bean=new BasePriceBean();
				bean.setMaterialID(rs.getString("FMaterialID"));
				bean.setUnitID(rs.getString("FunitID"));
				bean.setBasePrice(rs.getBigDecimal("FBasePrice"));

				result.add(bean);
			}
			rs.close();
			return result;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据库存组织 和物料ID获取 默认仓库资料
	 * 
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static MaterialInventoryInfo getDefaultWarehouseDataByMaterial(Context ctx, String storageOrgUnitID, String materialID)
	throws BOSException, EASBizException {
		try{
			IMaterialInventory is = null;
			if (ctx != null)
				is = MaterialInventoryFactory.getLocalInstance(ctx);
			else
				is = MaterialInventoryFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("material.id", materialID, CompareType.EQUALS));
			ev.setFilter(filter);
			MaterialInventoryCollection col = is.getMaterialInventoryCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add(new SelectorItemInfo("*"));
				slr.add(new SelectorItemInfo("defaultWarehouse.*"));
				MaterialInventoryInfo info = is.getMaterialInventoryInfo(new ObjectUuidPK(col.get(0).getString("id")), slr);
				return info;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 给放养批次设置过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static void setStockingBatchFilter( final KDBizPromptBox prmtstockingBatch, final String companyID,final String farmerID,final String farmID,final boolean isFFLimit,final boolean isPersonLimit) {
		// prmtstockingBatch	

		SelectorListener[] ls = prmtstockingBatch.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtstockingBatch.removeSelectorListener(ls[i]);
		}
		prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
		prmtstockingBatch.setVisible(true);		
		prmtstockingBatch.setEditable(true);		
		prmtstockingBatch.setDisplayFormat("$name$");		
		prmtstockingBatch.setEditFormat("$number$");		
		prmtstockingBatch.setCommitFormat("$number$;$name$");		
		prmtstockingBatch.setRequired(true);

		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								if(StringUtils.isNotEmpty(companyID)) {
									filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
								}
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
								//是否完全出栏
								filter.getFilterItems().add(new FilterItemInfo("isAllOut",0,CompareType.EQUALS));	
								if(isFFLimit){
									filter.getFilterItems().add(new FilterItemInfo("farmer.id",StringUtils.isBlank(farmerID)?"":farmerID,CompareType.EQUALS));								
									filter.getFilterItems().add(new FilterItemInfo("farm.id",StringUtils.isBlank(farmID)?"":farmID,CompareType.EQUALS));
								}else{
									filter.getFilterItems().add(new FilterItemInfo("farmer.id",StringUtils.isBlank(farmerID)?"%%":farmerID,CompareType.LIKE));								
									filter.getFilterItems().add(new FilterItemInfo("farm.id",StringUtils.isBlank(farmID)?"%%":farmID,CompareType.LIKE));
								}

								//获取业务员对应的养殖户
								if(isPersonLimit&&SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null) {
									Set ids=getFarmerSetByCurrentUser();
									if(ids.size()>0) {
										filter.getFilterItems().add(new FilterItemInfo("farmer.id",ids,CompareType.INCLUDE));
									}
								}
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								if(StringUtils.isEmpty(companyID)) {
									return true;
								}
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								if(StringUtils.isEmpty(companyID)) {
									return true;
								}
								return false;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingBatch_F7ListUI));
					prmtstockingBatch_F7ListUI.setF7Use(true,ctx);
					prmtstockingBatch.setSelector(prmtstockingBatch_F7ListUI);
				}
			}
		});
	}
	/**
	 * 通过财务组织和编码获取批次
	 * @param ctx
	 * @param companyID
	 * @param number
	 * @return
	 */
	public static BatchInfo getStockingBatchByNumber(Context ctx,String companyID,String number) {
		try {
			if(StringUtils.isEmpty(number)) {
				return null;
			}
			IBatch iss =null;
			if(ctx!=null){
				iss=BatchFactory.getLocalInstance(ctx);
			}else{
				iss=BatchFactory.getRemoteInstance();
			}
			BatchCollection col = iss.getBatchCollection("where baseStatus="+FarmBaseStatusEnum.APPROVE_VALUE+" and company.id='"+companyID+"' and number='"+number+"'");
			if(col!=null&&col.size()>0) {
				return col.get(0);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public  static void setFarmerFilter(KDBizPromptBox prmtfarmer,String companyID) {
		setFarmerFilter(prmtfarmer, companyID,true);
	}
	/**
	 * 设置分录价格
	 */
	public static void setEntryBasePriceByBatchID(int priceType,String batchID,IRow row) {
		setEntryBasePriceByContractID(priceType,StockingComm.getContractIDByBatchID(null,batchID), row);
	}

	/*
	 * 根据养殖户养殖场设置批次合同过滤条件
	 */
	public static void setContractFilterByFarmer(KDBizPromptBox prmtfarmer,
			KDBizPromptBox prmtfarm, KDBizPromptBox prmtbatchContract, String curCompanyID,Boolean isUnSettled) {
		// TODO Auto-generated method stub
		String farmerID = prmtfarmer.getValue()==null?"":((IPropertyContainer)prmtfarmer.getValue()).getString("id");
		String farmID=prmtfarm.getValue()==null?"":((IPropertyContainer)prmtfarm.getValue()).getString("id");
		//合同过滤
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("farmer.id",farmerID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
		if(isUnSettled!=null){
			filter.getFilterItems().add(new FilterItemInfo("isRecSettled",isUnSettled?0:1,CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("isRecSettled",isUnSettled?null:1,CompareType.IS));
			filter.setMaskString("#0 AND #1 AND #2 AND #3 AND(#4 or #5)");
		}
		ev.setFilter(filter);
		SorterItemCollection sorter=new SorterItemCollection();
		SorterItemInfo sortInfo=new SorterItemInfo();
		sortInfo.setPropertyName("bizDate");
		sortInfo.setSortType(SortType.DESCEND);
		sorter.add(sortInfo);
		ev.setSorter(sorter);
		prmtbatchContract.setEntityViewInfo(ev);
	}

	/*
	 * 设置保证金政策过滤条件
	 * isUseBreedData表示受品种影响,无论其是否为空
	 */
	public static void  setMarginPolicyFilter(final KDBizPromptBox prmtMarginPolicy, final String curCompanyID,final Date bizDate,final KDBizPromptBox prmtbreedData,final Boolean isUseBreedData) {
		// TODO Auto-generated method stub
		SelectorListener[] ls = prmtMarginPolicy.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtMarginPolicy.removeSelectorListener(ls[i]);
		}
		prmtMarginPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.MarginPolicyListUI prmtMarginPolicyPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtMarginPolicyPolicy_F7ListUI == null) {
					try {
						prmtMarginPolicyPolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.MarginPolicyListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("FICompany.id",curCompanyID,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
								if(bizDate!=null){
									Date date=null;
									try {	
										date= sdf.parse(sdf.format(bizDate));
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

									if(isUseBreedData){
										filter.getFilterItems().add(new FilterItemInfo("breed.id",prmtbreedData.getValue()==null?"":((IPropertyContainer) prmtbreedData.getValue()).getString("id"),CompareType.EQUALS));
									}else{
										if(prmtbreedData.getValue()!=null){
											filter.getFilterItems().add(new FilterItemInfo("breed.id",((IPropertyContainer) prmtbreedData.getValue()).getString("id"),CompareType.EQUALS));
										}
									}
									filter.getFilterItems().add(new FilterItemInfo("endDate",null,CompareType.IS));
									filter.getFilterItems().add(new FilterItemInfo("endDate",date,CompareType.GREATER_EQUALS));

									if(isUseBreedData||prmtbreedData.getValue()!=null){
										filter.setMaskString("#0 AND #1 AND #2 AND (#3 or #4)");
									}else{
										filter.setMaskString("#0 AND #1 AND (#2 or #3)");
									}

								}else{
									filter.getFilterItems().add(new FilterItemInfo("id","",CompareType.EQUALS));
								}
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								return false;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtMarginPolicyPolicy_F7ListUI));
					prmtMarginPolicyPolicy_F7ListUI.setF7Use(true,ctx);
					prmtMarginPolicy.setSelector(prmtMarginPolicyPolicy_F7ListUI);
				}
			}
		});


	}

	/*
	 * 设置连养政策过滤条件
	 */
	public static void  setConFeedPolicyFilter(KDBizPromptBox prmtConFeedPolicy,String curCompanyID,Date bizDate) {
		// TODO Auto-generated method stub
		SelectorListener[] ls = prmtConFeedPolicy.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtConFeedPolicy.removeSelectorListener(ls[i]);
		}
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("FICompany.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
		if(bizDate!=null){
			try {
				filter.getFilterItems().add(new FilterItemInfo("endDate",sdf.parse(sdf.format(bizDate)),CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("endDate",null,CompareType.IS));
				filter.setMaskString("#0 AND #1 AND (#2 or #3)");	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			filter.getFilterItems().add(new FilterItemInfo("id","cannotchoose",CompareType.EQUALS));
		}
		ev.setFilter(filter);
		prmtConFeedPolicy.setEntityViewInfo(ev);
	}

	/*
	 * 设置连养合同过滤条件
	 */
	public static EntityViewInfo  setConFeedContractFilter(KDBizPromptBox prmtConFeedContract, String curCompanyID,String farmerID,String farmID,Date bizDate) {
		// TODO Auto-generated method stub	
		prmtConFeedContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.ConFeedContratctF7Query");
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("farmer.id",farmerID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		if(bizDate!=null){
			try {
				filter.getFilterItems().add(new FilterItemInfo("beginDate",sdfTime.parse(sdf.format(bizDate)+" 23:59:59"),CompareType.LESS_EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("endDate",sdf.parse(sdf.format(bizDate)),CompareType.GREATER_EQUALS));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			filter.getFilterItems().add(new FilterItemInfo("id","cannotchoose",CompareType.EQUALS));
		}		
		ev.setFilter(filter);
		prmtConFeedContract.setEntityViewInfo(ev);		
		return ev;
	}


	//设置结算政策过滤条件
	public  static void setSettlementPolicyFilter(final KDBizPromptBox prmtsettlementPolicy,final KDDatePicker pkBizDate,final String companyID,final KDBizPromptBox prmtbreedData,final Boolean isUseBreedData){
		SelectorListener[] ls = prmtsettlementPolicy.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtsettlementPolicy.removeSelectorListener(ls[i]);
		}

		prmtsettlementPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI prmtsettlementPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsettlementPolicy_F7ListUI == null) {
					try {
						prmtsettlementPolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
								Calendar cal=Calendar.getInstance();
								try {
									cal.setTime(sdf.parse(sdf.format(pkBizDate.getTimestamp())));
								} catch (ParseException e) {
									e.printStackTrace();
								}
								filter.getFilterItems().add(new FilterItemInfo("beginDate",cal.getTime(),CompareType.LESS_EQUALS));
								//									cal.add(Calendar.DAY_OF_MONTH, 1);
								filter.getFilterItems().add(new FilterItemInfo("endDate",cal.getTime(),CompareType.GREATER_EQUALS));
								if(isUseBreedData){
									filter.getFilterItems().add(new FilterItemInfo("breedData.id", prmtbreedData.getValue()==null?"":((IPropertyContainer) prmtbreedData.getValue()).getString("id"),CompareType.EQUALS));
								}else{
									if(prmtbreedData.getValue()!=null) {
										filter.getFilterItems().add(new FilterItemInfo("breedData.id",((IPropertyContainer) prmtbreedData.getValue()).getString("id"),CompareType.EQUALS));
									}
								}
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								return false;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsettlementPolicy_F7ListUI));
					prmtsettlementPolicy_F7ListUI.setF7Use(true,ctx);
					prmtsettlementPolicy.setSelector(prmtsettlementPolicy_F7ListUI);
				}
			}
		});
	}
	/**
	 * 根据养殖场获取养殖户
	 * @param prmtfarm
	 * @return
	 */
	public static FarmerInfo getFarmerInfoByFarm(Context ctx,Object farmObj) {
		// TODO Auto-generated method stub
		if(farmObj==null)
			return null;
		String farmID="";

		if(farmObj instanceof KDBizPromptBox){
			KDBizPromptBox prmtfarm = (KDBizPromptBox)farmObj;
			if(prmtfarm.getValue()==null)
				return null;
			farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
		}else if(farmObj instanceof String){
			farmID=farmObj.toString();
		}
		//养殖场已废弃养户字段，以下方法停用
		//		IFarm iFarm;
		//			if(ctx==null)
		//				iFarm=FarmFactory.getRemoteInstance();
		//			else
		//				iFarm=FarmFactory.getLocalInstance(ctx);
		//
		//			SelectorItemCollection slor=new SelectorItemCollection();
		//			slor.add("*");
		//			slor.add("farmer.*");
		//			FarmInfo farmInfo = iFarm.getFarmInfo(new ObjectUuidPK(farmID),slor);
		//			return farmInfo.getFarmer();
		FarmerInfo farmerInfo=null;
		try {
			String  farmerID="";
			String sql ="/*dialect*/select t1.fid id from CT_FM_Farmer t1 inner join CT_FM_FarmerFarmEntry t2 on t1.fid=t2.fparentid where t2.ffarmid='"+farmID+"' and fbaseStatus='2' ";
			IRowSet	rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			if(rs.next()){
				farmerID=rs.getString("id");
			}
			if(StringUtils.isNotBlank(farmerID)){
				farmerInfo=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerID));
			}
			return farmerInfo;
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

		return null;
	}
	/**
	 * 根据养殖户生成一个编号
	 * @param prmtfarmer
	 */
	public static String batchGetNewNumber(Context ctx,Object obj) {
		// TODO Auto-generated method stub
		String billNum="";
		String seq="0001";
		try {
			if(obj instanceof String)
				billNum=obj.toString()+"-";
			else if(obj instanceof FarmerInfo)
				billNum=((FarmerInfo)obj).getString("name")+"-";
			else if(obj instanceof KDBizPromptBox){
				billNum=((IPropertyContainer)((KDBizPromptBox)obj).getValue()).getString("id");
				FarmerInfo info;
				if(ctx==null)
					info=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(billNum));
				else
					info=FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(billNum));
				billNum=info.getName();
			}


			String str = "select max(fname_l2) fname from T_FM_Batch where fname_l2 like '"+billNum+"-%'";
			IRowSet rs;
			if(ctx==null)
				rs=SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			else
				rs=DbUtil.executeQuery(ctx, str);
			if(rs.next()){
				seq=rs.getString("fname");
				if(StringUtils.isEmpty(seq))
					seq="0001";
				else{
					seq=String.valueOf(Integer.parseInt(seq.substring(seq.indexOf("-")+1,seq.length())));
					seq=MathUtilsComm.getStringByNumber(4, Integer.valueOf(seq)+1);
				}
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
		return billNum+"-"+seq;
	}
	/**
	 * 注册人员信息
	 * @param bizBoxProposer
	 * @param coreui
	 * @param isSingle
	 */
	public static void makeApplierF7(KDBizPromptBox bizBoxProposer, String FIOrgUnitID,CoreUIObject coreui, boolean isSingle)
	{
		OrgUnitCollection unitColl = null;
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		FilterItemCollection fic = filter.getFilterItems();
		try
		{
			unitColl = OrgUnitRelationFactory.getRemoteInstance().getFromUnit(FIOrgUnitID, 1, 0);
			int size = 0;
			if(unitColl != null)
				size = unitColl.size();
			fic.add(new FilterItemInfo("EmployeeType.inService", new Integer(2), CompareType.NOTEQUALS));
			if(size > 0)
			{
				Set idSet = new HashSet();
				for(int i = 0; i < size; i++)
					idSet.add(unitColl.get(i).getId().toString());

				//				if(idSet.contains(FIOrgUnitID)){
				//					idSet.clear();
				//					idSet.add(FIOrgUnitID);
				//				}


				fic.add(new FilterItemInfo("AdminOrgUnit.id", idSet, CompareType.INCLUDE));
				filter.getFilterItems().add(new FilterItemInfo("AdminOrgUnit.id", idSet, CompareType.INCLUDE));
			}
			evi.setFilter(filter);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		PersonPromptBox selector = new PersonPromptBox(coreui);
		selector.setIsSingleSelect(isSingle);
		bizBoxProposer.setEntityViewInfo(evi);
		bizBoxProposer.setSelector(selector);
		bizBoxProposer.getQueryAgent().setHasCUDefaultFilter(false);
		bizBoxProposer.setDisplayFormat("$name$");
		bizBoxProposer.setEditFormat("$number$");
		bizBoxProposer.setCommitFormat("$number$");
		bizBoxProposer.setDefaultF7UIName("人员选择");
		bizBoxProposer.setQueryInfo("com.kingdee.eas.cp.bc.app.PersonQuery");
	}


	//查看是否有上下7天内或同一天是否有同一养殖场/户的批次合同
	public static Boolean checkIsHasSameContract(Context ctx,String farmerID,String farmID,Date bizdate,Boolean isDateLimit) {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		try {
			Date date=sdf.parse(sdf.format(bizdate));
			cal.setTime(date);
			cal.add(Calendar.DATE, -7);
			Date dateBefore=cal.getTime();
			cal.setTime(date);
			cal.add(Calendar.DATE, 7);
			Date dateAfter=cal.getTime();
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/SELECT * FROM  T_FM_BatchContractBill where FBillStatus='4' ");
			if(isDateLimit){
				sqlBuf.append(" and to_char(FBizDate,'yyyy-mm-dd')='"+sdf.format(bizdate)+"'  ");
			}
			sqlBuf.append(" and to_char(FBizDate,'yyyy-mm-dd')<='"+sdf.format(dateAfter)+"'")
			.append(" and to_char(FBizDate,'yyyy-mm-dd')>= '"+sdf.format(dateBefore)+"'")
			.append(" and FFarmerID='"+farmerID+"'")
			.append(" and FFarmID='"+farmID+"' ");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.next()){
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 得到实例类
	 * @param bosType
	 * @return
	 */
	public static EntityObjectInfo getEntityObject(Context ctx,String bosType) {
		try {
			IMetaDataLoader loader =null;
			if(ctx!=null)
				loader=MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			else
				loader=MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
			if (eo == null) {
				return null;
			}
			return eo;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回处理后的计算脚本
	 * @param formulaTxt
	 */
	public static String getCalDealedFormulaTxt(String formulaTxt) throws EASBizException {
		try {
			if(StringUtils.isEmpty(formulaTxt)) {
				return null;
			}
			String tempStr,resultStr="";
			int strLength=formulaTxt.length();
			int beginIndex=0;
			for(int index=0;index<strLength;index++) {
				if(formulaTxt.indexOf("[")<0) {
					resultStr+=formulaTxt.substring(0,formulaTxt.length());
					break;
				}
				resultStr+=formulaTxt.substring(0,formulaTxt.indexOf("["));
				tempStr=formulaTxt.substring(formulaTxt.indexOf("["), formulaTxt.indexOf("]")+1);
				beginIndex=tempStr.indexOf("\"");
				resultStr+=tempStr.substring(beginIndex,tempStr.indexOf("\"", beginIndex+1)+1);
				formulaTxt=formulaTxt.substring(formulaTxt.indexOf("]")+1,formulaTxt.length());
				strLength=formulaTxt.length();
			}
			System.out.println(resultStr);
			return resultStr;
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	/**
	 * 通过脚本进行计算
	 * @throws BOSException 
	 */
	public static BigDecimal getCalResultByJsTxt(Context ctx,CoreBaseCollection cols,String jsTxt) throws BOSException {
		int strLength=jsTxt.length();
		String tempStr,resultStr="";
		String[] ifp;
		CoreBaseInfo info;
		EntityObjectInfo eo;
		int beginIndex;
		HashMap<String,EntityObjectInfo> map=new HashMap<String, EntityObjectInfo>();
		for(int index=0;index<strLength;index++) {
			if(jsTxt.indexOf("\"")<0) {
				resultStr+=jsTxt.substring(0,jsTxt.length());
				break;
			}
			resultStr+=jsTxt.substring(0,jsTxt.indexOf("\""));
			beginIndex=jsTxt.indexOf("\"");
			tempStr=jsTxt.substring(beginIndex, jsTxt.indexOf("\"",beginIndex+1)+1);
			tempStr=tempStr.replaceAll("\"", "");
			if(tempStr.contains(".")) {
				ifp=tempStr.split("\\.");
				for(int j=0;j<cols.size();j++) {
					info = cols.get(j);
					if(info==null) {
						continue;
					}
					if(map.containsKey(info.getBOSType().toString())){
						eo=map.get(info.getBOSType().toString());
					}else {
						eo = getEntityObject(ctx, info.getBOSType().toString());
						map.put(info.getBOSType().toString(), eo);
					}
					//单据名称相同
					if(eo.getName().equals(ifp[0])) {
						if(info.containsKey(ifp[1])) {
							resultStr+=info.get(ifp[1])!=null?info.get(ifp[1]).toString():"0";
						}
					}
				}
			}else{
				resultStr+=tempStr;
			}
			jsTxt=jsTxt.substring(jsTxt.indexOf("\"",beginIndex+1)+1,jsTxt.length());
			strLength=jsTxt.length();
		}
		//		resultStr="result"+resultStr;
		System.out.println(resultStr);
		String paramsStr="";
		//js脚本取值
		try {
			resultStr="function getValue(params)\n{  var result=0.0;\n "+resultStr+"\n return result;\n}";
			ScriptEngineManager mgr = new ScriptEngineManager();    
			ScriptEngine engine = mgr.getEngineByMimeType("application/javascript");
			engine.eval(resultStr);   
			Invocable inv = (Invocable) engine;   
			Object res = inv.invokeFunction("getValue",paramsStr); 
			return new BigDecimal(String.valueOf(res));
		}catch(Exception err) {
			throw new BOSException("公式脚本计算错误:\n"+err.getMessage());
		}
	}

	/*
	 * 判断批次合同是否已经结算了
	 */
	public static Boolean checkIsHasSettled(Context ctx,String contractID){
		StringBuffer sqlBuf = new StringBuffer();;
		sqlBuf.append("/*dialect*/select * from T_FM_BatchContractBill ")
		.append(" where fid='"+contractID+"'");
		IRowSet rs=null;
		try {
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.next()){
				if(rs.getString("CFIsRecSettled")==null){
					return false;
				}
				return rs.getBoolean("CFIsRecSettled");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * 判断批次合同是否已存在由棚前过磅单生成的结算单
	 */
	public static Boolean checkIsHasPreHouseSettleBill(Context ctx,String contractID,String settleBillID){
		StringBuffer sqlBuf = new StringBuffer();;
		sqlBuf.append("/*dialect*/select * from CT_FM_CKSettleBill t1")
		.append(" inner join T_BOT_Relation t2 on t2.FDestObjectID=t1.fid")
		.append(" where t1.CFBatchContractID='"+contractID+"'");
		if(StringUtils.isNotBlank(settleBillID)){
			sqlBuf.append(" and t1.fid<>'"+settleBillID+"'");
		}
		IRowSet rs=null;
		try {
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public static BigDecimal getPriceFromDailyOutSalebill(Context ctx,Date bizDate,String breedDataID,BigDecimal aveWgt) {
		BigDecimal price=null;
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select fid fid from CT_FM_DailyOutSaleCPrice where CFBaseStatus=2 and ")
		.append(" to_char(CFBizDate,'yyyy-mm-dd')='"+sdf.format(bizDate)+"'  ")
		.append(" and CFBreedDataID='"+breedDataID+"' ");
		IRowSet rs=null;
		try {
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.next()){
				DailyOutSaleCPriceInfo info=null;
				if(ctx!=null){						
					info=DailyOutSaleCPriceFactory.getLocalInstance(ctx).getDailyOutSaleCPriceInfo(new ObjectUuidPK(rs.getString("fid")));
				}else{
					info=DailyOutSaleCPriceFactory.getRemoteInstance().getDailyOutSaleCPriceInfo(new ObjectUuidPK(rs.getString("fid")));
				}
				price = calPriceByOutSaleformula(ctx, info, aveWgt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	//外卖毛鸡价格公式计算
	public static  BigDecimal calPriceByOutSaleformula(Context ctx,DailyOutSaleCPriceInfo info,BigDecimal param) {
		BigDecimal price=BigDecimal.ZERO;
		if(info==null){
			return price;
		}
		for(int i=0;i<info.getEntrys().size();i++){
			DailyOutSaleCPriceEntryInfo entry;
			try {
				if(ctx!=null){						
					entry=DailyOutSaleCPriceEntryFactory.getLocalInstance(ctx).getDailyOutSaleCPriceEntryInfo(new ObjectUuidPK(info.getEntrys().get(i).getId()));
				}else{
					entry=DailyOutSaleCPriceEntryFactory.getRemoteInstance().getDailyOutSaleCPriceEntryInfo(new ObjectUuidPK(info.getEntrys().get(i).getId()));
				}
				String maxSymbol=entry.getMaxSymbol()==null?"":entry.getMaxSymbol().getAlias();
				String minSymbol=entry.getMinSymbol()==null?"":entry.getMinSymbol().getAlias();
				BigDecimal minValue=entry.getMinValue()==null?BigDecimal.ZERO:entry.getMinValue();
				BigDecimal maxValue=entry.getMaxValue()==null?BigDecimal.ZERO:entry.getMaxValue();
				if(isThisEntry(param,minSymbol,minValue,maxSymbol,maxValue)){
					return UIRuleUtil.getBigDecimal(entry.getPrice());
				}
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return price;
	}

	//结算政策回收页签公式计算
	public static  BigDecimal[] calPriceByRecformula(Context ctx,Date bizDate,String breedDataID,SettlePolicyInfo info,BigDecimal param) {
		// TODO Auto-generated method stub
		BigDecimal[] result=new BigDecimal[2];
		BigDecimal price=BigDecimal.ZERO, meatRateStd=BigDecimal.ZERO;
		if(info==null){
			result[0]=price;
			result[1]=meatRateStd;
			return result;
		}
		for(int i=0;i<info.getRecycleEntry().size();i++){
			SettlePolicyRecycleEntryInfo entry;
			try {
				if(ctx!=null){						
					entry=SettlePolicyRecycleEntryFactory.getLocalInstance(ctx).getSettlePolicyRecycleEntryInfo(new ObjectUuidPK(info.getRecycleEntry().get(i).getId()));
				}else{
					entry=SettlePolicyRecycleEntryFactory.getRemoteInstance().getSettlePolicyRecycleEntryInfo(new ObjectUuidPK(info.getRecycleEntry().get(i).getId()));
				}
				String maxSymbol=entry.getMaxSymbol()==null?"":entry.getMaxSymbol().getAlias();
				String minSymbol=entry.getMinSymbol()==null?"":entry.getMinSymbol().getAlias();
				BigDecimal minValue=entry.getMinValue()==null?BigDecimal.ZERO:entry.getMinValue();
				BigDecimal maxValue=entry.getMaxValue()==null?BigDecimal.ZERO:entry.getMaxValue();
				if(isThisEntry(param,minSymbol,minValue,maxSymbol,maxValue)){
					if(!entry.isIsUseAcualPrice()){
						price=UIRuleUtil.getBigDecimal(entry.getBasePrice());
					}else{
						price=getPriceFromDailyOutSalebill(ctx, bizDate, breedDataID, param);
					}
					meatRateStd=UIRuleUtil.getBigDecimal(entry.getFmRate());
					result[0]=price;
					result[1]=meatRateStd;
					return result;
				}
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result[0]=price;
		result[1]=meatRateStd;
		return result;
	}

	private static Boolean isThisEntry(BigDecimal param,String minSymbol,BigDecimal minValue,String maxSymbol,BigDecimal maxValue) {
		// TODO Auto-generated method stub
		Boolean minFlag=false,maxFlag=false;
		if(StringUtils.isNotBlank(minSymbol)){
			if(minSymbol.equals("等于")){
				if(param.compareTo(minValue)==0){
					minFlag=true;
				}
			}else if(minSymbol.equals("大于等于")){
				if(param.compareTo(minValue)>=0){
					minFlag=true;
				}
			}else if(minSymbol.equals("大于")){
				if(param.compareTo(minValue)>0){
					minFlag=true;
				}
			}
		}else{
			minFlag=true;
		}
		if(StringUtils.isNotBlank(maxSymbol)){
			if(maxSymbol.equals("等于")){
				if(param.compareTo(maxValue)==0){
					maxFlag=true;
				}
			}else if(maxSymbol.equals("小于等于")){
				if(param.compareTo(maxValue)<=0){
					maxFlag=true;
				}
			}else if(maxSymbol.equals("小于")){
				if(param.compareTo(maxValue)<0){
					maxFlag=true;
				}
			}
		}else{
			maxFlag=true;
		}
		return minFlag&&maxFlag;
	}

	//获取该公司最近一次关账期间
	public static  PeriodInfo getPeriodFromCloseAccount(Context ctx,String companyID) {
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select  t2.fid fid from CT_FM_ClosingRecord t1  ")
		.append(" inner join T_BD_Period t2 on t1.CFPeriodID=t2.fid ")
		.append(" where t1.CFCompanyID='"+companyID+"'  ")
		.append(" order by t2.FBeginDate desc ");
		try {
			if(ctx!=null){
				IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
				if(rs.next()){
					PeriodInfo period=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(rs.getString("fid")));
					return period;
				}
			}else{
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
				if(rs.next()){
					PeriodInfo period=PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(rs.getString("fid")));
					return period;
				}
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
		return null;
	}

	//获取出肉率系数
	public static  BigDecimal getDressingPercent(Context ctx,String companyID,String customerID,String breedDataID) {
		// TODO Auto-generated method stub
		BigDecimal	dressingPercent=BigDecimal.ZERO;
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select * from CT_FM_CKDressingPercent where CFBaseStatus =2")
		.append(" and CFBreedDataID='"+breedDataID+"' ")
		.append(" and CFCustomerID='"+customerID+"' ")
		.append(" and CFFICompanyID='"+companyID+"' ");			
		try {
			IRowSet rs;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.next()){
				dressingPercent=rs.getBigDecimal("cfdressingPercent");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dressingPercent;
	}

	//控制药料单据业务日期不能超出回收月份
	public static void checkIsOutMonth(Context ctx,Date bizDate,String contractID) throws EASBizException {
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select FBizDate bizDate")
		.append(" from CT_FM_PreHouseWgtBill ")
		.append(" where CFBatchContractID ='"+contractID+"' ")
		.append(" order by FBizDate desc  ");
		try {
			IRowSet rs;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.next()) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(sdfMonth.format(rs.getDate("bizDate"))+"-01"));
				cal.add(Calendar.MONTH, 1);
				cal.add(Calendar.DATE, -1);
				Date endDate = sdfTime.parse(sdf.format(cal.getTime())+" 23:59:59");
				Calendar end = Calendar.getInstance();
				end.setTime(endDate);
				Calendar billDate = Calendar.getInstance();
				billDate.setTime(bizDate);
				if(billDate.after(end)){
					throw new EASBizException(new NumericExceptionSubItem("001","不能超过"+sdf.format(endDate)+"开票,操作失败"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//获取临时政策
	public static HashSet<TempPolicyInfo> getTempPolicy(Context ctx,CKSettleBillInfo info,BigDecimal chickenAveWgt) {
		// TODO Auto-generated method stub
		HashSet<TempPolicyInfo> tempPolicys=new HashSet<TempPolicyInfo>();
		String recDateStr=info.getRecDate()==null?"":sdf.format(info.getRecDate());
		//结算时取结算单的毛鸡均重为保留两位的值,这里单独传一下
		chickenAveWgt = chickenAveWgt==null?UIRuleUtil.getBigDecimal(info.getChickenAveWgt()):chickenAveWgt;
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" select distinct t1.fid fid from  CT_FM_TempPolicy t1  ")
		.append(" left join  CT_FM_TempPolicyEntrys t2 on t1.fid=t2.fparentid  ")
		.append(" where t1.CFBaseStatus=2 and t1.CFFICompanyID='"+info.getFICompany().getId().toString()+"' ")
		.append(" and t1.CFBreedDataID='"+info.getBreedData().getId().toString()+"' ")
		.append(" and ((t1.cfDateRelate=0 and to_char(t1.CFBEGINDATE,'yyyy-mm-dd')<='"+sdf.format(info.getInDate())+"' ")
		.append(" and to_char(t1.CFENDDATE,'yyyy-mm-dd')>='"+sdf.format(info.getInDate())+"')  ")
		.append(" or (t1.cfDateRelate in (1,2) and to_char(t1.CFBEGINDATE,'yyyy-mm-dd')<='"+recDateStr+"' ")
		.append(" and to_char(t1.CFENDDATE,'yyyy-mm-dd')>='"+recDateStr+"') ) ")
		.append(" and (t1.CFAVGWGTTO is null ) ")
		.append(" and (t1.CFFORALL=1 or (t2.CFFARMERID='"+info.getFarmer().getId().toString()+"' ")
		.append(" and t2.CFFARMID='"+info.getFarm().getId().toString()+"')) ");
		IRowSet rs;
		try {
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			while(rs.next()){
				String id = rs.getString("fid");
				TempPolicyInfo policyInfo;
				if(ctx==null) {
					policyInfo=TempPolicyFactory.getRemoteInstance().getTempPolicyInfo(new ObjectUuidPK(id));
				}else{
					policyInfo=TempPolicyFactory.getLocalInstance(ctx).getTempPolicyInfo(new ObjectUuidPK(id));
				}
				tempPolicys.add(policyInfo);
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
		return tempPolicys;
	}

	//获取运费里程分录信息
	public static FreightMileageBillEntryInfo getFreightMileageEntryInfo(Context ctx,String batchContractID,FreightTypeEnum freightType,String calUnitID) throws EASBizException {
		// TODO Auto-generated method stub
		FreightMileageBillEntryInfo entry=null;
		try {
			BatchContractBillInfo batchContract=null;
			if(ctx==null) {
				batchContract=BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContractID));
			}else{
				batchContract=BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(batchContractID));
			}
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select distinct t2.fid  fid from CT_FM_FreightMileageBill  t1  ")
			.append(" inner join CT_FM_FreightMileageBillEntry t2 on t1.fid=t2.fparentid  ")
			.append(" where t1.cfbaseStatus=2 ")
			.append(" and t1.CFFICompanyID='"+batchContract.getCompany().getId().toString()+"' ")
			.append(" and t1.CFRouteType='"+freightType.getValue()+"' ")
			.append(" and t2.CFFarmerID='"+batchContract.getFarmer().getId().toString()+"' ")
			.append(" and t2.CFFarmID='"+batchContract.getFarm().getId().toString()+"' ")
			.append(" and t2.CFCalUnitID='"+calUnitID+"' ");
			IRowSet rs;	
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.size()==0){
				throw new EASBizException(new NumericExceptionSubItem("001","运费里程表未维护!"));
			}else if(rs.size()>1){
				throw new EASBizException(new NumericExceptionSubItem("001","查询出多条满足条件的运费里程记录,请核查!"));
			}else{
				if(rs.next()){
					if(ctx==null) {
						entry=FreightMileageBillEntryFactory.getRemoteInstance().getFreightMileageBillEntryInfo(new ObjectUuidPK(rs.getString("fid")));
					}else{
						entry=FreightMileageBillEntryFactory.getLocalInstance(ctx).getFreightMileageBillEntryInfo(new ObjectUuidPK(rs.getString("fid")));
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
		return entry;
	}


	//获取毛鸡增幅运费分录信息
	public static CKGrowthFreightBillEntryInfo getCKGrowthFreightEntryInfo(Context ctx,BatchContractBillInfo batchContract,BigDecimal aveWgt,BigDecimal distance) throws EASBizException {
		// TODO Auto-generated method stub
		CKGrowthFreightBillInfo info=null;
		try {
			if(ctx==null) {
				batchContract=BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContract.getId()));
			}else{
				batchContract=BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(batchContract.getId()));
			}
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select distinct fid  fid from CT_FM_CKGrowthFreightBill")
			.append(" where cfbaseStatus=2 ")
			.append(" and CFFICompanyID='"+batchContract.getCompany().getId().toString()+"' ")
			.append(" and CFBreedDataID='"+batchContract.getBreedData().getId().toString()+"' ")
			.append(" and CFMinAvgWgt <="+aveWgt+" ")
			.append(" and CFMaxAvgWgt >"+aveWgt+" ");
			IRowSet rs;	
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.size()==0){
				throw new EASBizException(new NumericExceptionSubItem("001","毛鸡增幅运费表未维护!"));
			}else if(rs.size()>1){
				throw new EASBizException(new NumericExceptionSubItem("001","查询出多条满足条件的毛鸡增幅运费表记录,请核查!"));
			}else{
				if(rs.next()){
					if(ctx==null) {
						info=CKGrowthFreightBillFactory.getRemoteInstance().getCKGrowthFreightBillInfo(new ObjectUuidPK(rs.getString("fid")));
					}else{
						info=CKGrowthFreightBillFactory.getLocalInstance(ctx).getCKGrowthFreightBillInfo(new ObjectUuidPK(rs.getString("fid")));
					}					
					for(int i=0;i<info.getEntrys().size();i++){
						CKGrowthFreightBillEntryInfo entry = null;
						if(ctx==null) {
							entry=CKGrowthFreightBillEntryFactory.getRemoteInstance().getCKGrowthFreightBillEntryInfo(new ObjectUuidPK(info.getEntrys().get(i).getId()));
						}else{
							entry=CKGrowthFreightBillEntryFactory.getLocalInstance(ctx).getCKGrowthFreightBillEntryInfo(new ObjectUuidPK(info.getEntrys().get(i).getId()));
						}	
						if(distance.compareTo(entry.getMileageFrom())>=0&&distance.compareTo(entry.getMileageTo())<0){
							return entry;
						}
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
		return null;
	}

	//获取翅淤血扣补
	public static BigDecimal getCyxKb(Context ctx,BatchContractBillInfo batchContract,BigDecimal cyxRate) throws EASBizException {
		BigDecimal amount=BigDecimal.ZERO;
		try {
			if(ctx==null) {
				batchContract=BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContract.getId()));
			}else{
				batchContract=BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(batchContract.getId()));
			}
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select distinct t2.fid fid,t2.CFKbAmount amount from CT_FM_CyxKbSetting  t1")
			.append(" inner join CT_FM_CyxKbSettingEntry t2 on t1.fid=t2.fparentid")
			.append(" where t1.cfbaseStatus=2 ")
			.append(" and t1.CFFICompanyID='"+batchContract.getCompany().getId().toString()+"' ")
			.append(" and t1.CFBreedDataID='"+batchContract.getBreedData().getId().toString()+"' ")
			.append(" and t2.CFMinValue <="+cyxRate+" ")
			.append(" and t2.CFMaxValue >"+cyxRate+" ");
			IRowSet rs;	
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			if(rs.next()){
				amount=rs.getBigDecimal("amount");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}

	//获取雏苗来源文本
	public static String getSeedSourceStr(Context ctx,String batchContractID) {
		// TODO Auto-generated method stub
		StringBuffer str=new StringBuffer();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select  ")
		.append(" t3.fid storageOrgUnit, ")
		.append(" t2.flot lot, ")
		.append(" sum(t2.fqty) qty ")
		.append(" from T_IM_SaleIssueBill t1 ")
		.append(" inner join T_IM_SaleIssueEntry t2 on t1.fid=t2.fparentid ")
		.append(" inner join T_ORG_Storage t3 on t1.FStorageOrgUnitID=t3.fid ")
		.append(" where t1.fid in  (select  t2.FDestObjectID from T_FM_BreedSeedReceiveBill t1 ")
		.append(" inner  join T_BOT_Relation t2 on (t1.fid=t2.FSrcObjectID and t2.FDestEntityID='CC3E933B') ")
		.append(" where t1.FBatchContractID='"+batchContractID+"') ")
		.append(" and t1.FBaseStatus in (4,7) ")
		.append(" and (t2.FIsPresent is null or t2.FIsPresent=0) ")
		.append(" group by t3.fid,t2.flot ");
		try {
			IRowSet rs;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=SQLExecutorFactory.getLocalInstance(ctx,sqlBuf.toString()).executeSQL();
			}
			while(rs.next()){
				str.append(rs.getString("lot")+":"+rs.getBigDecimal("qty")+"， ");
			}
			if (str.length() - 2>=0) 
				str.deleteCharAt(str.length()-2);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return str.toString();
	}

	//是否存在未结算批次
	public static Boolean isHasUnSettledBatch(Context ctx,String farmerID,String farmID,String curBatchContractID) {
		Boolean isHas=false;
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" SELECT * FROM T_FM_BatchContractBill where (CFISRECSETTLED is null or CFISRECSETTLED=0) and  FBillStatus =4 and FFarmerID='"+farmerID+"' and FFarmID='"+farmID+"' ");
		if(StringUtils.isNotBlank(curBatchContractID)){
			sqlBuf.append(" and fid<>'"+curBatchContractID+"'");
		}
		IRowSet rs=null;
		try {
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			}
			if(rs.size()>0){
				isHas = true;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isHas;
	}

	//查询是否有月核算记录
	public static Boolean isHasMonthFreight(Context ctx,String companyID,String periodID,String breedDataID,String customerID,String curMonthFreightID) {
		Boolean isHas=false;
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" SELECT * FROM CT_FM_MonthFreightCalBill ")
		.append(" where  CFFICOMPANYID='"+companyID+"' ")
		.append(" and CFPERIODID='"+periodID+"'")
		.append(" and CFBREEDDATAID='"+breedDataID+"'")
		.append(" and CFCUSTOMERID='"+customerID+"'");
		if(StringUtils.isNotBlank(curMonthFreightID)){
			sqlBuf.append(" and fid<>'"+curMonthFreightID+"'");
		}
		IRowSet rs=null;
		try {
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			}
			if(rs.size()>0){
				isHas = true;
			}
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return isHas;
	}


	//获取临时政策毛鸡市场价补贴
	public static  BigDecimal calPriceByTempPolicy(Context ctx,TempPolicyInfo info,BigDecimal outSalePrice) {
		BigDecimal price=BigDecimal.ZERO;
		if(info==null){
			return price;
		}
		for(int i=0;i<info.getMarketPriceEntrys().size();i++){
			TempPolicyMarketPriceEntryInfo entry; 
			try {
				if(ctx!=null){						
					entry=TempPolicyMarketPriceEntryFactory.getLocalInstance(ctx).getTempPolicyMarketPriceEntryInfo(new ObjectUuidPK(info.getMarketPriceEntrys().get(i).getId()));
				}else{
					entry=TempPolicyMarketPriceEntryFactory.getRemoteInstance().getTempPolicyMarketPriceEntryInfo(new ObjectUuidPK(info.getMarketPriceEntrys().get(i).getId()));
				}
				String maxSymbol=entry.getLessSymbol()==null?"":entry.getLessSymbol().getAlias();
				String minSymbol=entry.getHighSymbol()==null?"":entry.getHighSymbol().getAlias();
				BigDecimal minValue=UIRuleUtil.getBigDecimal(entry.getMinPrice());
				BigDecimal maxValue=UIRuleUtil.getBigDecimal(entry.getMaxPrice());
				if(isThisEntry(outSalePrice,minSymbol,minValue,maxSymbol,maxValue)){
					return UIRuleUtil.getBigDecimal(entry.getSubsidyPrice());
				}
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return price;
	}

	//获取计划存栏数
	public static Map<String, BigDecimal> getPlanStock(Context ctx,Date bizDate,BigDecimal rate308,BigDecimal rate817) {
		// TODO Auto-generated method stub
		Map<String, BigDecimal> result=new HashMap<String, BigDecimal>();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/SELECT t1.CFBreedDataID breedDataID, ")
		.append(" sum(nvl(t2.CFQty,0)*10000) qty ")
		.append(" FROM CT_FM_InputSeedPlan t1 ")
		.append(" inner join CT_FM_InputSeedPlanEntry t2 on t1.fid=t2.fparentid ")
		.append(" where t1.CFBaseStatus =2 ")
		.append(" and to_char(t2.CFDate,'yyyy-mm-dd')='"+sdf.format(bizDate)+"' ")
		.append(" group by t1.CFBreedDataID ");
		IRowSet rs=null;
		try {
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			}
			while(rs.next()){
				if(rs.getString("breedDataID").equals("lwwAAAAu66GnpxMN")){
					result.put(rs.getString("breedDataID"), rs.getBigDecimal("qty").multiply(rate817));
				}else if(rs.getString("breedDataID").equals("lwwAAAAu65ynpxMN")){//308成活率
					result.put(rs.getString("breedDataID"), rs.getBigDecimal("qty").multiply(rate308));
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	//获取饲料标准耗用量
	public static Map getFodderStd(Context ctx,int weekDay,String BreedDataID) {
		// TODO Auto-generated method stub
		Map result=new HashMap<String, BigDecimal>();
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/SELECT t2.CFMaterialID materialID,")
		.append(" sum(nvl(t2.CFSingleUsed,0))/1000 qty ")
		.append(" FROM CT_FM_FodderStd t1 ")
		.append(" inner join CT_FM_FodderStdEntry t2 on t1.fid=t2.fparentid ")
		.append(" inner join T_BD_Material t3 on t3.fid=t2.CFMaterialID ")
		.append(" where t1.CFBaseStatus =2 ")
		.append(" and t2.CFWeekDay="+weekDay)
		.append(" and t1.CFBreedDataID ='"+BreedDataID+"'")
		.append(" group by t2.CFMaterialID ");
		IRowSet rs=null;
		try {
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			}
			while(rs.next()){
				result.put(rs.getString("materialID"), rs.getBigDecimal("qty"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	//是否允许手动填写过磅数据(仅限毛鸡过磅)
	public static Boolean isPermiManual(Context ctx) {
		try {
			String macAddress = ComReaderUtils.getLocalMac();
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" select t1.fid from  CT_WHB_Setting t1  ")
			.append(" inner join CT_WHB_SettingEntrys t2 on t1.fid=t2.fparentid ")
			.append(" where t1.CFMac='"+macAddress+"' and t2. CFWeighBillType=3  ")
			.append(" and t2.CFDefaultBizType=9 ")
			.append(" and t2.CFIsPermitManual=1 ");
			IRowSet rs=null;
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			}
			if(rs.next()){
				return true;
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//养殖场上批是否交鸡(存在批次合同没有棚前过磅单的情况)
	public static Boolean isHasUnRecContract(Context ctx,String farmID) {
		try {
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/SELECT fid FROM T_FM_BatchContractBill   ")
			.append(" WHERE FBillStatus  =4 and FFarmID='"+farmID+"'  ")
			.append(" and fbizdate= (SELECT MAX(fbizdate) FROM T_FM_BatchContractBill  WHERE FBillStatus  =4 and FFarmID='"+farmID+"') ")
			.append(" and  fid not in (select distinct CFBatchContractID from CT_FM_PreHouseWgtBill where CFFarmID='"+farmID+"' and  CFBillStatus=4)  ");
			IRowSet rs=null;
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			}
			if(rs.size()>0){
				return true;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
