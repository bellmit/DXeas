package com.kingdee.eas.farm.stocking.common;

import java.awt.Color;
import java.awt.Rectangle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.IParser;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.framework.IBaseDataParser;
import com.kingdee.eas.basedata.master.cssp.MainDataParser;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitCollection;
import com.kingdee.eas.basedata.org.OrgUnitRelationFactory;
import com.kingdee.eas.basedata.person.client.PersonPromptBox;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
//import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
//import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * 放养客户端公用类
 * @author dai_andong
 * @date 2016-11-16
 */
public class StockingClientComm {

	public static StockingClientComm getInstance() {
		return new StockingClientComm();
	}


	/**
	 * 检查和得到库存组织id
	 * @return
	 */
	public static String checkAndGetStorageOrgUnitID() {
		String storageOrgUnitID=null;
		if(SysContext.getSysContext().getCurrentStorageUnit()!=null)
			storageOrgUnitID=SysContext.getSysContext().getCurrentStorageUnit().getString("id");
		else
			if(SysContext.getSysContext().getCurrentCostUnit()!=null)
				storageOrgUnitID=StockingComm.getStorageOrgIDByCostCenterID(null,SysContext.getSysContext().getCurrentCostUnit().getString("id"));
		if(StringUtils.isBlank(storageOrgUnitID)) {
			MsgBox.showWarning("库存组织不能为空！");
			SysUtil.abort();
		}
		return storageOrgUnitID;
	}
	/**
	 * 根据编码或名称获取养殖场Info
	 * @param companyID
	 * @param number
	 * @param name
	 * @return
	 * @throws EASBizException 
	 */
	public static FarmInfo getFarmInfoByNumOrName(String companyID,String number,String name) throws EASBizException {
		if(StringUtils.isBlank(companyID)) {
			throw new EASBizException(new NumericExceptionSubItem("001","财务组织不能为空！"));
		}
		if(StringUtils.isBlank(number)&&StringUtils.isBlank(name)) {
			throw new EASBizException(new NumericExceptionSubItem("001","编码和名称不能同时为空！"));
		}
		try {
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.enable,CompareType.EQUALS));
			if(StringUtils.isNotBlank(number)) {
				filter.getFilterItems().add(new FilterItemInfo("number",number,CompareType.EQUALS));
			}
			if(StringUtils.isNotBlank(name)) {
				filter.getFilterItems().add(new FilterItemInfo("name",name,CompareType.EQUALS));
			}
			ev.setFilter(filter);
			FarmCollection col = FarmFactory.getRemoteInstance().getFarmCollection(ev);
			if(col!=null&&col.size()>0) {
				return col.get(0);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
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

	/**
	 * 给放养批次设置过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static void setStockingBatchFilter( final KDBizPromptBox prmtstockingBatch, final String companyID,final String farmerID,final String farmID) {
		setStockingBatchFilter(prmtstockingBatch, companyID, farmerID, farmID, null,false);
	}

	/**
	 * 给放养批次设置过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static void setStockingBatchFilter( final KDBizPromptBox prmtstockingBatch, final String companyID,final String farmerID,final String farmID,final String houseID) {
		setStockingBatchFilter(prmtstockingBatch, companyID, farmerID, farmID, houseID,false);
	}

	private class StockingBatchParser implements IParser{
		@Override
		public void applyPattern(String arg0) {

		}

		@Override
		public IRowSet getRowSetForPopupF8(String arg0) {
			return null;
		}

		@Override
		public void setQuickQureyEntityViewInfo(EntityViewInfo arg0) {

		}

		@Override
		public Object stringToValue(String arg0) {
			return null;
		}
	}

	/**
	 * 给放养批次设置过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static void setStockingBatchFilter( final KDBizPromptBox prmtstockingBatch, final String companyID,final String farmerID,final String farmID,final String houseID,final boolean isPersonLimit) {
		// prmtstockingBatch	

		SelectorListener[] ls = prmtstockingBatch.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtstockingBatch.removeSelectorListener(ls[i]);
		}
		prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
		prmtstockingBatch.setVisible(true);		
		prmtstockingBatch.setEditable(true);		
		prmtstockingBatch.setDisplayFormat("$name$");		
		prmtstockingBatch.setEditFormat("$number$");		
		prmtstockingBatch.setCommitFormat("$number$;$name$");		
		prmtstockingBatch.setRequired(true);

		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								if(StringUtils.isNotEmpty(companyID)) {
									filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
								}
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								//是否完全出栏
								filter.getFilterItems().add(new FilterItemInfo("isAllOut",0,CompareType.EQUALS));
								if(StringUtils.isNotEmpty(farmerID)) {
									filter.getFilterItems().add(new FilterItemInfo("farmer.id",farmerID,CompareType.EQUALS));
								}
								if(StringUtils.isNotEmpty(farmID)) {
									filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
								}
								if(StringUtils.isNotEmpty(houseID)) {
									filter.getFilterItems().add(new FilterItemInfo("id",StockingComm.getBatchIDByHouseID(null, companyID, houseID),CompareType.INCLUDE));
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

	/* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public  static void setFarmerFilter(KDBizPromptBox prmtfarmer,String companyID) {
		setFarmerFilter(prmtfarmer, companyID,true);
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

		prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
		prmtfarmer.setEditable(false);		
		prmtfarmer.setDisplayFormat("$name$");		
		prmtfarmer.setEditFormat("$name$");		
		prmtfarmer.setCommitFormat("$number$;$name$");	
		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {

								return getFarmerFilter(companyID, isPersonLimit);
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
							protected String getF7ListClassName() {
								return "com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI";
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
				}
			}
		});
	}
	/* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 * isPersonLimit 是否人员过滤-技术员管理范围
	 * isOnlyOtherCompany 只显示其他公司
	 * StockingFarmTypeEnum 养殖场类型
	 */
	public  static void setFarmerFilter(final KDBizPromptBox prmtfarmer,final String companyID,final boolean isPersonLimit,
			final boolean isOnlyOtherCompany,final StockingFarmTypeEnum farmType) {
		// prmtfarmer
		SelectorListener[] ls = prmtfarmer.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarmer.removeSelectorListener(ls[i]);
		}

		prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
		prmtfarmer.setEditable(false);		
		prmtfarmer.setDisplayFormat("$name$");		
		prmtfarmer.setEditFormat("$name$");		
		prmtfarmer.setCommitFormat("$number$;$name$");	

		prmtfarmer.setRequired(true);
		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								return getFarmerFilter(companyID, isPersonLimit,isOnlyOtherCompany,farmType);
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								if(StringUtils.isEmpty(companyID)||isOnlyOtherCompany) {
									return true;
								}
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								if(StringUtils.isEmpty(companyID)||isOnlyOtherCompany) {
									return true;
								}
								return false;
							}
							protected String getF7ListClassName() {
								return "com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI";
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
				}
			}
		});
	}
	/**
	 * 获取养户过滤条件
	 * @param companyID
	 * @param isPersonLimit
	 * @return
	 */
	public static FilterInfo getFarmerFilter(String companyID,boolean isPersonLimit,boolean isOnlyOtherCompany, StockingFarmTypeEnum farmType) {
		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,isOnlyOtherCompany?CompareType.NOTEQUALS:CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
		//获取业务员对应的养殖场
		if(isPersonLimit&&SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null) {
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct t0.FParentid from  T_FM_FarmersFarmEntry t0")
			.append(" inner join t_fm_farm tfarm on tfarm.fid=t0.FFarmID")
			.append(" inner join T_FM_PersonFarmerRelationEntry t2 on t2.CFFarmID=t0.FFarmId")
			.append(" inner join T_FM_PersonFarmerRelation t1  on t2.fparentid=t1.fid")
			.append(" where t1.FPersonID='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getString("id")).append("'")
			.append(" and t1.FBaseStatus=3");
			if(farmType!=null) {
				sql.append(" and tfarm.FFarmType=").append(farmType.getValue());
			}
			filter.getFilterItems().add(new FilterItemInfo("id",sql.toString(),CompareType.INNER));
		}else {
			if(farmType!=null) {
				StringBuffer sql=new StringBuffer();
				sql.append(" select distinct t0.FParentid from  T_FM_FarmersFarmEntry t0")
				.append(" inner join t_fm_farm tfarm on tfarm.fid=t0.FFarmID")
				.append(" and tfarm.FFarmType=").append(farmType.getValue());
				filter.getFilterItems().add(new FilterItemInfo("id",sql.toString(),CompareType.INNER));
			}
		}
		return filter;
	}
	/**
	 * 给放养批次设置过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 * isOnlyOtherCompany 是否查询其他公司数据
	 */
	public static void setStockingBatchFilter( final KDBizPromptBox prmtstockingBatch, final String companyID,final String farmerID,
			final String farmID,final String houseID,final boolean isPersonLimit,
			final boolean isOnlyOtherCompany,final StockingFarmTypeEnum farmType) {
		// prmtstockingBatch	

		SelectorListener[] ls = prmtstockingBatch.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtstockingBatch.removeSelectorListener(ls[i]);
		}
		prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
		prmtstockingBatch.setVisible(true);		
		prmtstockingBatch.setEditable(true);		
		prmtstockingBatch.setDisplayFormat("$name$");		
		prmtstockingBatch.setEditFormat("$number$");		
		prmtstockingBatch.setCommitFormat("$number$;$name$");		
		prmtstockingBatch.setRequired(true);

		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								if(StringUtils.isNotEmpty(companyID)) {
									filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,(isOnlyOtherCompany?CompareType.NOTEQUALS:CompareType.EQUALS)));
								}
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								//是否完全出栏
								filter.getFilterItems().add(new FilterItemInfo("isAllOut",0,CompareType.EQUALS));
								if(StringUtils.isNotEmpty(farmerID)) {
									filter.getFilterItems().add(new FilterItemInfo("farmer.id",farmerID,CompareType.EQUALS));
								}
								if(StringUtils.isNotEmpty(farmID)) {
									filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
								}
								if(farmType!=null) {
									filter.getFilterItems().add(new FilterItemInfo("farm.farmType",farmType.getValue(),CompareType.EQUALS));
								}
								if(StringUtils.isNotEmpty(houseID)) {
									filter.getFilterItems().add(new FilterItemInfo("id",StockingComm.getBatchIDByHouseID(null, companyID, houseID),CompareType.INCLUDE));
								}
								//获取业务员对应的养殖户
								if(isPersonLimit&&SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null) {
//									Set ids=getFarmerSetByCurrentUser();
//									if(ids.size()>0) {
//										filter.getFilterItems().add(new FilterItemInfo("farmer.id",ids,CompareType.INCLUDE));
//									}
									
									StringBuffer sql=new StringBuffer();
									sql.append(" select distinct t2.CFFarmID from T_FM_PersonFarmerRelation t1  ")
									.append(" inner join  T_FM_PersonFarmerRelationEntry t2 on t2.fparentid=t1.fid")
									.append(" where FPersonID='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getString("id")).append("'")
									.append(" and t2.CFFarmID is not null");
									filter.getFilterItems().add(new FilterItemInfo("farm.id",sql.toString(),CompareType.INNER));
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

	/* 设置养殖场过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public  static void setFarmFilter(final KDBizPromptBox prmtfarm,final String companyID,final String farmerID,final boolean isPersonLimit,
			final boolean isOnlyOtherCompany,final StockingFarmTypeEnum farmType) {
		// prmtfarm	
		SelectorListener[] ls = prmtfarm.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarm.removeSelectorListener(ls[i]);
		}
		prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
		prmtfarm.setVisible(true);		
		prmtfarm.setEditable(true);		
		prmtfarm.setDisplayFormat("$name$");		
		prmtfarm.setEditFormat("$number$");		
		prmtfarm.setCommitFormat("$number$;$name$");	
		prmtfarm.setCommitParser(new MainDataParser(prmtfarm));
		prmtfarm.setRequired(true);
		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								StringBuffer sql=new StringBuffer();
								sql.append(" select distinct tentry.FFarmID from T_FM_Farmers tmain ")
								.append(" inner join T_FM_FarmersFarmEntry tentry on tentry.FParentid=tmain.fid")
								.append(" where 1=1")
								.append(" and tentry.ffarmid is not null");
								if(!"ALL_FARMER".equalsIgnoreCase(farmerID)) {
									sql.append(" and tmain.FID='").append(farmerID).append("'");
								}

								FilterInfo filter=new FilterInfo();
								if(StringUtils.isNotEmpty(companyID)) {
									filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,isOnlyOtherCompany?CompareType.NOTEQUALS:CompareType.EQUALS));
								}
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("id",sql.toString(),CompareType.INNER));
								if(farmType!=null) {
									filter.getFilterItems().add(new FilterItemInfo("farmType",farmType.getValue(),CompareType.EQUALS));
								}
								
								//养殖场
								if(isPersonLimit&&SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null) {
									sql.setLength(0);
									sql.append(" select distinct t2.CFFarmID")
									.append(" from T_FM_PersonFarmerRelationEntry t2 ")
									.append(" inner join T_FM_PersonFarmerRelation t1  on t2.fparentid=t1.fid")
									.append(" where t1.FPersonID='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getString("id")).append("'")
									.append(" and t1.FBaseStatus=3");
									filter.getFilterItems().add(new FilterItemInfo("id",sql.toString(),CompareType.INNER));
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
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
					prmtfarm_F7ListUI.setF7Use(true,ctx);
					prmtfarm.setSelector(prmtfarm_F7ListUI);
				}
			}
		});
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
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
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
	 * farm parse
	 * @author QYDEP2
	 *
	 */
	public class  StockingBaseDataParser implements IBaseDataParser,IParser {
		private FilterInfo filter;
		private boolean isEnter;
		public FilterInfo getQuickFilter() {
			return filter;
		}

		@Override
		public boolean isCommitByEnter() {
			return isEnter;
		}

		@Override
		public void setCommitByEnter(boolean isEnter) {
			this.isEnter=isEnter;
		}

		@Override
		public void setQuickFilter(FilterInfo filter) {
			this.filter=filter;
		}

		@Override
		public void applyPattern(String paramString) {
			// TODO Auto-generated method stub

		}

		@Override
		public IRowSet getRowSetForPopupF8(String paramString) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setQuickQureyEntityViewInfo(EntityViewInfo paramEntityViewInfo) {
			// TODO Auto-generated method stub

		}

		@Override
		public Object stringToValue(String paramString) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	/* 设置养殖场过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public  static void setFarmFilter(final KDBizPromptBox prmtfarm,final String companyID,final String farmerID) {
		// prmtfarm	
		SelectorListener[] ls = prmtfarm.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarm.removeSelectorListener(ls[i]);
		}
		prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
		prmtfarm.setVisible(true);		
		prmtfarm.setEditable(true);		
		prmtfarm.setDisplayFormat("$name$");		
		prmtfarm.setEditFormat("$number$");		
		prmtfarm.setCommitFormat("$number$;$name$");	
		prmtfarm.setCommitParser(new MainDataParser(prmtfarm));
		prmtfarm.setRequired(true);
		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								//养殖户所包含养殖场
								//								Set idSet=new HashSet();
								//								idSet.add("hahahahaha");
								//								//								if(StringUtils.isNotBlank(farmerID)) {
								//								try {
								//									StringBuffer sql=new StringBuffer();
								//									sql.append(" select distinct tentry.FFarmID from T_FM_Farmers tmain ")
								//									.append(" inner join T_FM_FarmersFarmEntry tentry on tentry.FParentid=tmain.fid")
								//									.append(" where tmain.FID='").append(farmerID).append("'")
								//									.append(" and tentry.ffarmid is not null");
								//									;
								//									IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
								//									while(rs.next()) {
								//										idSet.add(rs.getString("FFarmID"));
								//									}
								//								}catch(Exception err) {
								//									err.printStackTrace();
								//								}

								//								}

								FilterInfo filter=new FilterInfo();
								if(StringUtils.isNotEmpty(companyID)) {
									filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
								}
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								//								if(StringUtils.isNotBlank(farmerID)) {
								//								filter.getFilterItems().add(new FilterItemInfo("id",idSet,CompareType.INCLUDE));
								//								}
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
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
					prmtfarm_F7ListUI.setF7Use(true,ctx);
					prmtfarm.setSelector(prmtfarm_F7ListUI);
				}
			}
		});
	}
	/**
	 * 物料改变设置默认仓库
	 * @param row
	 * @param colMatierialName
	 * @param colWarehouseName
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static void setWarehouseInfoByMaterial(String storageOrgUnitID,IRow row,String colMatierialName,String colWarehouseName) throws EASBizException, BOSException {
		if(row.getCell(colMatierialName).getValue()!=null&&StringUtils.isNotBlank(storageOrgUnitID)) {
			String materialID=((IObjectValue)row.getCell(colMatierialName).getValue()).getString("id");
			row.getCell(colWarehouseName).setValue(StockingComm.getDefaultWarehouseByMaterial(null, storageOrgUnitID, materialID));
		}else{
			row.getCell(colWarehouseName).setValue(null);
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
	public static void appendFootRowByC(KDTable table,String title,int rowIndex,String fields[],Object values[]) {
		int size = fields.length;
		if (size == 0)
			return;
		// 利用getRowCount的到的行可能不正确
		IRow footRow = null;
		KDTFootManager footManager = table.getFootManager();
		if (footManager == null) {
			footManager = new KDTFootManager(table);
			footManager.addFootView();
			table.setFootManager(footManager);
		}
		footRow = footManager.getFootRow(rowIndex);

		if (footRow == null) {
			for(int index=0;index<=rowIndex;index++) {
				if(footManager.getFootRow(index)==null) {
					footRow = footManager.addFootRow(index);
				}
			}
		}


		// 设置合计行显示样式
		String colFormat = "%{0.00}f";
		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);
		table.getIndexColumn().setWidth(30);
		footManager.addIndexText(0, title);
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));

		for (int i = 0; i < size; i++) {
			String colName = fields[i];
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(colFormat);
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
			footRow.getCell(colName).getStyleAttributes().setFontColor(Color.black);
		}

		// 设置合计行的值
		for (int i = 0; i < fields.length; i++) {
			footRow.getCell(fields[i]).setValue(values[i]);
		}
	}

	/**
	 * 在表格上方增加按钮
	 * @param btn
	 * @param table
	 */
	public static void addDetailButton(KDWorkButton btn,KDTable table) {
		JPanel controlPanel = (JPanel) table.getParent().getParent();
		if(controlPanel instanceof DetailPanel ){
			JPanel  d;
			double sumWidth=0;
			for(int index=0;index<controlPanel.getComponentCount();index++) {
				d = (JPanel )controlPanel.getComponent(index);
				if(d.getName().equalsIgnoreCase("controlPanel")) {
					Rectangle rect = table.getBounds();
					for(int j=0;j<d.getComponentCount();j++) {//获取最左边的 坐标
						if(d.getComponent(j) instanceof KDWorkButton)
							sumWidth+=d.getComponent(j).getSize().getWidth();
					}
					int x =rect.width-(int)sumWidth - (btn.getWidth() + 86 + 5);
					d.add(btn,new com.kingdee.bos.ctrl.swing.KDLayout.Constraints(x, 5, btn.getWidth(), 19, 9));
					break;
				}
			}
		}
	}

	/**
	 * 设置仓库过滤条件
	 */
	public static void setWarehouseFilter(KDBizPromptBox prmtWarehouse,String storageOrgUnitID) {
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",storageOrgUnitID,CompareType.EQUALS));
		EntityViewInfo ev=new EntityViewInfo();
		ev.setFilter(filter);
		prmtWarehouse.setEntityViewInfo(ev);

	}

	/**
	 * 获取选择行指定列的值
	 * @param table
	 * @param string
	 * @return
	 */
	public static Object getSelectedKeyValue(KDTable table, String colName) {
		if(table.getColumn(colName)!=null) {
			if(KDTableUtil.getSelectedRow(table).getRowIndex()>-1) {
				return KDTableUtil.getSelectedRow(table).getCell(colName).getValue();
			}
		}
		return "";
	}

	/**
	 * 设置分录价格
	 */
	public static void setEntryBasePriceByBatchID(int priceType,String batchID,IRow row) {
		setEntryBasePriceByContractID(priceType,StockingComm.getContractIDByBatchID(null,batchID), row);
	}

	/**
	 * 设置分录价格
	 */
	public static void setEntryOrderBasePriceByContractID(int priceType,String contractID,IRow row) {

		String materialID=null,unitID=null;
		if(row.getCell("material").getValue()!=null) {
			materialID=((IPropertyContainer) row.getCell("material").getValue()).getString("id");
		}
		if(row.getCell("unit").getValue()!=null) {
			unitID=((IPropertyContainer) row.getCell("unit").getValue()).getString("id");
		}

		ArrayList<BasePriceBean> list = StockingComm.getBasePrice(null,priceType,contractID,materialID,unitID);
		if(list!=null&&list.size()>0) {
			row.getCell("orderBasePrice").setValue(list.get(0).getBasePrice());
			if(row.getCell("orderReceivePrice").getValue()==null) {
				row.getCell("orderReceivePrice").setValue(list.get(0).getBasePrice());
			}
		}else{
			row.getCell("orderBasePrice").setValue(BigDecimal.ZERO);
		}
	}

	/**
	 * 设置分录价格
	 */
	public static void setEntryOrderBasePriceByBatchID(int priceType,String batchID,IRow row) {
		setEntryOrderBasePriceByContractID(priceType,StockingComm.getContractIDByBatchID(null,batchID), row);
	}

	/**
	 /**
	 * 设置分录目标价格
	 */
	public static void setEntryBasePriceByContractID(int priceType,String contractID,IRow row) {

		String materialID=null,unitID=null;
		if(row.getCell("material").getValue()!=null) {
			materialID=((IPropertyContainer) row.getCell("material").getValue()).getString("id");
		}
		if(row.getCell("unit").getValue()!=null) {
			unitID=((IPropertyContainer) row.getCell("unit").getValue()).getString("id");
		}

		ArrayList<BasePriceBean> list = StockingComm.getBasePrice(null,priceType,contractID,materialID,unitID);
		if(list!=null&&list.size()>0) {
			row.getCell("basePrice").setValue(list.get(0).getBasePrice());
			//			if(row.getCell("receivePrice").getValue()==null) {
			row.getCell("receivePrice").setValue(list.get(0).getBasePrice());
			//			}
		}else{
			row.getCell("basePrice").setValue(BigDecimal.ZERO);
		}
	}
	/**
	 * 设置成本对象过滤条件
	 * @param aCompanyOrgUnitInfo
	 * @param bizcostObjectBox
	 * @throws Exception
	 */
	public static void setCostObjectFilter(CompanyOrgUnitInfo aCompanyOrgUnitInfo,KDBizPromptBox bizcostObjectBox) throws Exception {
		//删除监听
		if(bizcostObjectBox==null)
			return;
		SelectorListener[] liss = bizcostObjectBox.getSelectorListeners();
		for(int i=0;i<liss.length;i++) {
			bizcostObjectBox.removeSelectorListener(liss[i]);
		}

		//		bizcostObjectBox = new KDBizPromptBox();
		bizcostObjectBox.setEditFormat("$number$");
		bizcostObjectBox.setDisplayFormat("$number$");
		bizcostObjectBox.setCommitFormat("$number$");
		bizcostObjectBox.setEditable(true);
		bizcostObjectBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
		if (aCompanyOrgUnitInfo != null) {
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			FilterItemInfo filterItemInfo = new FilterItemInfo("company.id", aCompanyOrgUnitInfo.getId().toString(),
					CompareType.EQUALS);
			filterInfo.getFilterItems().add(filterItemInfo);
			viewInfo.setFilter(filterInfo);
			bizcostObjectBox.setEntityViewInfo(viewInfo);
			CtrlUnitInfo cui = (CtrlUnitInfo) aCompanyOrgUnitInfo.getCU().clone();
			bizcostObjectBox.setCurrentCtrlUnit(cui);
		} else {
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			FilterItemInfo filterItemInfo = new FilterItemInfo("company.id", "''", CompareType.EQUALS);
			filterInfo.getFilterItems().add(filterItemInfo);
			viewInfo.setFilter(filterInfo);
			bizcostObjectBox.setEntityViewInfo(viewInfo);
		}
	}

	/**
	 * 合同过滤
	 * @param prmt
	 * @param companyID
	 * @param farmerID
	 */
	public static void  setBatchContractFilter(KDBizPromptBox prmt,String companyID,String farmerID,String farmID) {
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		if(StringUtils.isNotEmpty(farmerID)) {
			filter.getFilterItems().add(new FilterItemInfo("farmer.id",farmerID,CompareType.EQUALS));
		}
		if(StringUtils.isNotEmpty(farmID)) {
			//			filter.getFilterItems().add(new FilterItemInfo("farm.id",farmID,CompareType.EQUALS));
		}

		ev.setFilter(filter);
		prmt.setEntityViewInfo(ev);
	}
	/**
	 * 根据养殖户获取养殖场  
	 * @return
	 */
	public static  void setFarmInfoByFarmer(KDBizPromptBox farmer,KDBizPromptBox farm) {
		if(farmer.getValue()==null) {
			farm.setValue(null);
		}else{
			try {
				farm.setValue(StockingComm.getFarmInfoByFarmerID(null,((IPropertyContainer) farmer.getValue()).getString("id")));
			}catch(Exception err){
				err.printStackTrace();
			}
		}
	}

	/**
	 * 根据养户设置批次
	 */
	public static void setBatchByFarmerFarm(String companyID,KDBizPromptBox prmtBatch,KDBizPromptBox prmtFarmer,KDBizPromptBox prmtFarm) {
		try {
			String farmerID=null,farmID=null;
			if(prmtFarmer.getValue()!=null) {
				farmerID=((IPropertyContainer) prmtFarmer.getValue()).getString("id");
			}
			if(prmtFarm.getValue()!=null) {
				farmID=((IPropertyContainer) prmtFarm.getValue()).getString("id");
			}

			StringBuffer sql=new StringBuffer();
			sql.append(" select fid  ")
			.append(" from t_fm_stockingBatch ")
			.append(" where FCompanyID='").append(companyID).append("'")
			.append(" and fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" and FFarmerID='").append(farmerID).append("'")
			.append(" and FFarmID='").append(farmID).append("'")
			.append(" and (FIsAllOut=0 or FIsAllOut is null)")
			.append(" order by FInDate desc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				prmtBatch.setValue(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("fid"))));
			}else{
				prmtBatch.setValue(null);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	/**
	 * 根据批次Id获取已经完全出栏的id
	 * @return
	 */
	public static HashSet getAllOutHouseIDsByBatchID(String companyID,String batchID,String farmID,boolean includeAllout) {
		HashSet set =new HashSet();
		set.add("abcd1234");
		try {
			if(StringUtils.isNotEmpty(batchID)) {
				StringBuffer sql=new StringBuffer();
				sql.append(" select tentry.FHouseID ")
				.append(" from t_fm_stockingBatch tmain")
				.append(" inner join T_FM_StockingBatchHouseEntry tentry on tentry.FParentID=tmain.fid")
				.append(" inner join CT_FM_FarmHouseEntry tfe on tfe.fid=tentry.FHouseID")
				.append(" inner join T_FM_Farm tf on tf.fid=tfe.fparentid")
				.append(" where tmain.fid='").append(batchID).append("'")
				.append(" and tmain.FCompanyID='").append(companyID).append("'")
				.append(" and tmain.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE);
				if(!includeAllout) {
					sql.append(" and tentry.fisAllout=0");
				}
				if(StringUtils.isNotEmpty(farmID)) {
					sql.append(" and tf.fid='").append(farmID).append("'");
				}
				sql.append(" and tmain.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE);
				IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				while(rs.next()) {
					set.add(rs.getString("FHouseID"));
				}

			}else{
				StringBuffer sql=new StringBuffer();
				sql.append(" select tfe.fid ")
				.append(" from CT_FM_FarmHouseEntry tfe ")
				.append(" inner join T_FM_Farm tf on tf.fid=tfe.fparentid")
				.append(" where  tf.fid='").append(farmID).append("'");
				IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				while(rs.next()) {
					set.add(rs.getString("fid"));
				}
			}

		}catch(Exception err) {
			err.printStackTrace();
		}
		return set;
	}
	/* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static  void setFarmerFilterForHatch(final KDBizPromptBox prmtfarmer,final String companyID,final String groupID) {
		// prmtfarmer
		SelectorListener[] ls = prmtfarmer.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarmer.removeSelectorListener(ls[i]);
		}

		prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
		prmtfarmer.setEditable(false);		
		prmtfarmer.setDisplayFormat("$name$");		
		prmtfarmer.setEditFormat("$name$");		
		prmtfarmer.setCommitFormat("$number$;$name$");		
		prmtfarmer.setRequired(true);
		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								if(StringUtils.isNotEmpty(companyID)) {
									filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
								}
								if(StringUtils.isNotEmpty(groupID)) {
									filter.getFilterItems().add(new FilterItemInfo("treeid.id",groupID,CompareType.EQUALS));
								}
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
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
							@Override
							protected boolean initDefaultFilter() {
								// TODO Auto-generated method stub
								return true;
							}
							@Override
							protected CommonQueryDialog initCommonQueryDialog() {
								// TODO Auto-generated method stub
								CommonQueryDialog ds = super.initCommonQueryDialog();
								EntityViewInfo ev=new EntityViewInfo();
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("name","",CompareType.LIKE));
								ev.setFilter(filter);
								ds.setDefalutEntityViewInfo(ev);
								return ds;
							}
							@Override
							public void onLoad() throws Exception {
								// TODO Auto-generated method stub
								super.onLoad();
							}

						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
				}
			}
		});
	}


	/* 设置上孵厅过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static  void setHatchHouseFilter(final KDBizPromptBox prmtHatchHouse,final String treeid) {
		// prmtfarmer
		SelectorListener[] ls = prmtHatchHouse.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtHatchHouse.removeSelectorListener(ls[i]);
		}

		prmtHatchHouse.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");		
		prmtHatchHouse.setEditable(true);		
		prmtHatchHouse.setDisplayFormat("$name$");		
		prmtHatchHouse.setEditFormat("$name$");		
		prmtHatchHouse.setCommitFormat("$number$;$name$");		
		prmtHatchHouse.setRequired(true);
		prmtHatchHouse.addSelectorListener(new SelectorListener(){
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI hatchHouseListUI=null;
			public void willShow(SelectorEvent arg0) {
				// TODO Auto-generated method stub
				if(hatchHouseListUI==null){
					try {
						hatchHouseListUI=new com.kingdee.eas.farm.hatch.client.HatchHouseListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("hatchArea.name",treeid,CompareType.EQUALS));
								return filter;
							}
							@Override
							protected boolean initDefaultFilter() {
								// TODO Auto-generated method stub
								return true;
							}
						};
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				HashMap ctx = new HashMap();
				ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(hatchHouseListUI));
				hatchHouseListUI.setF7Use(true,ctx);
				prmtHatchHouse.setSelector(hatchHouseListUI);
			}});
	}


	/* 设置孵化箱过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static  void setIncubatorFilter(final KDBizPromptBox prmtIncubator,final String hatchHouseNum) {
		// prmtfarmer
		SelectorListener[] ls = prmtIncubator.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtIncubator.removeSelectorListener(ls[i]);
		}

		prmtIncubator.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");
		prmtIncubator.setVisible(true);
		prmtIncubator.setEditable(true);
		prmtIncubator.setDisplayFormat("$number$");
		prmtIncubator.setEditFormat("$number$");
		prmtIncubator.setCommitFormat("$number$");
		prmtIncubator.addSelectorListener(new SelectorListener(){
			com.kingdee.eas.farm.hatch.client.IncubatorListUI incubatorListUI=null;
			public void willShow(SelectorEvent arg0) {
				// TODO Auto-generated method stub
				if(incubatorListUI==null){
					try {
						incubatorListUI=new com.kingdee.eas.farm.hatch.client.IncubatorListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("hatchHouse.number",hatchHouseNum,CompareType.EQUALS));
								return filter;
							}
							@Override
							protected boolean initDefaultFilter() {
								// TODO Auto-generated method stub
								return true;
							}
						};
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				HashMap ctx = new HashMap();
				ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(incubatorListUI));
				incubatorListUI.setF7Use(true,ctx);
				prmtIncubator.setSelector(incubatorListUI);
			}});
	}


	/* 设置批次过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static  void setOutBatchFilter(final KDBizPromptBox prmtOutBatch,final String outArea) {
		SelectorListener[] ls = prmtOutBatch.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtOutBatch.removeSelectorListener(ls[i]);
		}

		prmtOutBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
		prmtOutBatch.setVisible(true);
		prmtOutBatch.setEditable(true);
		prmtOutBatch.setDisplayFormat("$name$");
		prmtOutBatch.setEditFormat("$number$");
		prmtOutBatch.setCommitFormat("$number$;$name$");
		prmtOutBatch.addSelectorListener(new SelectorListener(){
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI stockingBatchListUI=null;
			public void willShow(SelectorEvent arg0) {
				// TODO Auto-generated method stub
				if(stockingBatchListUI==null){
					try {
						stockingBatchListUI=new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								if(!StringUtils.isEmpty(outArea))
									filter.getFilterItems().add(new FilterItemInfo("treeid1.id",outArea,CompareType.EQUALS));
								return filter;
							}
							@Override
							protected boolean initDefaultFilter() {
								// TODO Auto-generated method stub
								return true;
							}
						};
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				HashMap ctx = new HashMap();
				ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(stockingBatchListUI));
				stockingBatchListUI.setF7Use(true,ctx);
				prmtOutBatch.setSelector(stockingBatchListUI);
			}});
	}


	public static void setHatchingBoxFilterForHatch(final KDBizPromptBox f7,
			final String treeid) {
		// TODO Auto-generated method stub
		SelectorListener[] ls = f7.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			f7.removeSelectorListener(ls[i]);
		}
		f7.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchingBoxQuery");
		f7.setVisible(true);
		f7.setEditable(true);
		f7.setEnabled(true);
		f7.setDisplayFormat("$number$");
		f7.setEditFormat("$number$");
		f7.setCommitFormat("$number$");
		f7.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchingBoxListUI kdtEntrys_hatchingBox_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_hatchingBox_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_hatchingBox_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchingBoxListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("hatchHouse.id",treeid,CompareType.EQUALS));
								return filter;
							}
						};

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_hatchingBox_PromptBox_F7ListUI));
					kdtEntrys_hatchingBox_PromptBox_F7ListUI.setF7Use(true,ctx);
					f7.setSelector(kdtEntrys_hatchingBox_PromptBox_F7ListUI);
				}
			}
		});
	}


	/**
	 * 根据库存组织获取养殖场Info
	 * @param companyID
	 * @param number
	 * @param name
	 * @return
	 * @throws EASBizException 
	 */
	public static FarmInfo getFarmInfoByStorageOrgUnit(String orgUnitID) throws EASBizException {
		try {
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",orgUnitID,CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.enable,CompareType.EQUALS));
			ev.setFilter(filter);
			FarmCollection col = FarmFactory.getRemoteInstance().getFarmCollection(ev);
			if(col!=null&&col.size()>0) {
				return col.get(0);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	public static void setSettlePolicyFilter(
			KDBizPromptBox prmtstatementPolicy, String companyID, Object object) {
		// TODO Auto-generated method stub

	}


	public static void setFarmFilter(KDBizPromptBox prmtfarm, String companyID) {
		// TODO Auto-generated method stub

	}

	/**
	 * 根据养殖场自动带出养殖户
	 * @param prmtfarmer
	 * @param prmtfarm
	 */
	public static void setFarmrInfoByFarm(KDBizPromptBox farmer,
			KDBizPromptBox farm) {
		if(farm.getValue()==null) {
			farmer.setValue(null);
		}else{
			try {
				String s1 = "/*dialect*/ select t1.fid farmerid from T_FM_Farmers t1 inner join T_FM_FarmersFarmEntry t2 on t2.FParentID = t1.fid  where t2.FFarmID ='"+((IPropertyContainer) farm.getValue()).getString("id")+"'";
				IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
				com.kingdee.eas.farm.stocking.basedata.FarmersInfo farmerInfo = null;
				String farmerid = null;
				if(r1.next()){
					farmerid = r1.getString("farmerid");
				}
				if(farmerid != null){
					farmerInfo = FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(farmerid));
				}
				farmer.setValue(farmerInfo);
			}catch(Exception err){
				err.printStackTrace();
			}
		}

	}

/**
 * 根据养殖场设置养殖户和批次
 * @param curCompanyID
 * @param prmtstockingBatch
 * @param prmtfarmer
 * @param prmtfarm
 */
	public static void setBatchfarmerByFarm(String companyID,
			KDBizPromptBox prmtstockingBatch, KDBizPromptBox prmtFarmer,
			KDBizPromptBox prmtFarm) {
		// TODO Auto-generated method stub
		try {
			String farmID=null;
			if(prmtFarm.getValue()!=null) {
				farmID=((IPropertyContainer) prmtFarm.getValue()).getString("id");
			}

			StringBuffer sql=new StringBuffer();
			sql.append("/*dialect*/ select fid batchid, FFarmerID farmerid  from t_fm_stockingBatch  ")
			.append(" where FCompanyID='").append(companyID).append("'")
			.append("and fbaseStatus=3 and FFarmID='").append(farmID).append("'")
			.append(" and (FIsAllOut=0 or FIsAllOut is null) order by FInDate desc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				prmtstockingBatch.setValue(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("batchid"))));
				prmtFarmer.setValue(FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(rs.getString("farmerid"))));
			}else{
				prmtstockingBatch.setValue(null);
				prmtFarmer.setValue(null);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		
		
		
	}
}

