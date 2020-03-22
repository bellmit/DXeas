package com.kingdee.eas.custom.salegrossprofitsrpt.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kingdee.bos.*;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitCollection;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.dynbusiness.util.DBUtil;
import com.kingdee.eas.framework.report.app.CreateTempTableResult;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.scm.common.util.SCMUtils;
import com.kingdee.eas.scm.sd.sale.SaleReportBillStatusEnum;
import com.kingdee.eas.scm.sd.sale.SaleReportBizTypeEnum;
import com.kingdee.eas.scm.sd.sale.SaleReportClassificationEnum;
import com.kingdee.eas.scm.sd.sale.report.SaleImcomEnum;
import com.kingdee.eas.scm.util.constant.RecIssueTypeConstant;
import com.kingdee.eas.util.ResourceBase;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SaleGrossProfitsControllerBean extends AbstractSaleGrossProfitsControllerBean
{

	private  HashMap<String,String[]> head=null;
	@Override
	protected IRowSet _getQueryResultByParams(Context ctx, RptParams rptparams)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		//		head = combinationHead(rptparams);
		StringBuffer sb=getStringBufferByClassification(ctx,rptparams);

		return null;
	}







	
	private StringBuffer getStringBufferByClassification(Context ctx,
			RptParams rptparams) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		if((rptparams.getString("classification").equals("1"))){
			sb.append("");
			sb.append("SELECT");
			sb.append(" t3.FNumber                      materialNum,");
			sb.append(" t3.FName_l2                     materialName,");
			sb.append(" t3.FModel                       materialModel,");
			sb.append(" t3.FSimpleName                  materialSimpleName,");
			sb.append(" t4.FName_l2                     baseUnitName,");//基本计量单位
			sb.append(" sum(t2.FBaseQty)                saleQtyBaseUnit,");//销售数量（基本单位）
			sb.append(" sum(t2.FBaseQty)                outQtyBaseUnit,");//出库数量（基本单位）
			sb.append(" t4.FName_l2                     unitStatistics,");//统计计量单位
			sb.append(" sum(t2.FBaseQty)                saleQtyStatUnit,");//销售数量（统计单位）
			sb.append(" sum(t2.FBaseQty)                outQtyStatUnit,");//出库数量（统计单位）
			sb.append(" sum(t2.FNonTaxAmount)           nonTaxAmt,");//销售收入
			sb.append(" sum(t2.FActualCost)             actualCost,");//销售成本
			sb.append(" sum(t2.FNonTaxAmount)");
			sb.append("       -sum(t2.FActualCost)     grossProfit,");//毛利 
			sb.append(" case when sum(t2.FActualCost)=0 then 1");
			sb.append(" when sum(t2.FNonTaxAmount)=0 then 0 ");
			sb.append(" else round((sum(t2.FNonTaxAmount)-sum(t2.FActualCost))/sum(t2.FNonTaxAmount),4) ");
			sb.append(" end                    grossProfitRate,");//毛利率
			sb.append(" case when sum(t2.FBaseQty)=0 then null");
			sb.append(" else round((sum(t2.FNonTaxAmount)");
			sb.append(" -sum(t2.FActualCost))/sum(t2.FBaseQty),4) end unitGrossProfitBase,");//单位毛利润(基本)
			sb.append(" case when sum(t2.FBaseQty)=0 then null");
			sb.append(" else round((sum(t2.FNonTaxAmount)");
			sb.append(" -sum(t2.FActualCost))/sum(t2.FBaseQty),4) end unitGrossProfitStat,");//单位毛利润(统计)
			sb.append(" sum(t2.CFdis)                   discount,");//费用分摊
			sb.append(" sum(t2.FNonTaxAmount)");
			sb.append(" -sum(t2.FActualCost)");
			sb.append(" -sum(t2.CFdis)           afterDisGrossProfit,");//折扣后毛利润
			sb.append(" case when sum(t2.FActualCost)=0 then 0");
			sb.append(" when sum(t2.FNonTaxAmount)-sum(t2.FActualCost)=0 then 0"); 
			sb.append(" else ");
			sb.append(" round((sum(t2.FNonTaxAmount)-sum(t2.FActualCost)-sum(t2.CFdis))");
			sb.append(" /(sum(t2.FNonTaxAmount)-sum(t2.CFdis)),4)  ");
			sb.append(" end actGrossProfitRate,");//折扣后毛利率
			sb.append(" case when sum(t2.FActualCost)=0 then null");
			sb.append(" else round((sum(t2.FNonTaxAmount)");
			sb.append(" -sum(t2.FActualCost)-sum(t2.CFdis))/sum(t2.FBaseQty),4) ");
			sb.append(" end actUnitGrossProfitBase,");//单位毛利润(基本)
			sb.append("  when sum(t2.FActualCost)=0 then null");
			sb.append(" else round((sum(t2.FNonTaxAmount)");
			sb.append(" -sum(t2.FActualCost)-sum(t2.CFdis))/sum(t2.FBaseQty),4) ");
			sb.append(" end actUnitGrossProfitStat");//单位毛利润(统计)


			sb.append(" FROM");
			sb.append(" T_IM_SaleIssueBill                t1");
			sb.append(" inner join T_IM_SaleIssueEntry    t2  on t1.FID=t2.FParentID");
			sb.append(" inner join T_BD_Material          t3  on t3.FID=t2.FMaterialID");
			sb.append(" inner join T_BD_MeasureUnit       t4  on t4.FID=t2.FBaseUnitID ");//基本计量单位
			sb.append(" inner join T_BD_MeasureUnit       t5  on t5.FID=t2.FUnitID");//计量单位
			sb.append(" inner join T_BD_Customer          t6  on t6.FID=t1.FCustomerID");//送货客户



			sb.append(" inner join T_BD_CustomerSaleInfo  t7  on t7.FCustomerID=t6.FID");
			if(rptparams.getObject("")!=null)
				sb.append(" and t7.FSaleOrgID='@orgID'");
			sb.append(" left  join T_BD_CustomerSaler     t8  on t7.FID=t8.FCustomerSaleID");
			sb.append(" left  join T_BD_Person            t9  on t9.FID=t8.FPersonID");
			sb.append(" left  join T_BD_SalePerson        t10 on t9.FID=t10.FPersonID");
			sb.append(" left  join T_BD_Person            t11 on t11.FID=t2.FSalePersonID");
			sb.append(" left  join T_BD_SaleGroup         t12 on t12.FID=t2.FSaleGroupID");
			sb.append(" left  join T_SCM_BizType          t13 on t13.FID=t1.FBizTypeID");
			sb.append(" left  join T_BD_Customer          t14 on t14.FID=t2.FBalanceCustomerID");//应收客户
			sb.append(" left  join T_BD_Customer          t15 on t15.FID=t2.FOrderCustomerID");//订货客户
			sb.append(" left  join T_BD_MaterialGroup     t16 on t16.FID=t3.FMaterialGroupID");//物料分组
			sb.append(" left  join T_ORG_Admin            t17 on t17.FID=t1.FAdminOrgUnitID");//部门



			//			where t1.FBizDate>={ts '@startDate'} --日期
			//			and t1.FBizDate<={ts '@endDate'}
			//			and (case when '@statisticsType'=0
			//					then t2.FStorageOrgUnitID
			//					else t2.FCompanyOrgUnitID end) in ('@orgID')
			//					and (t11.Fnumber>='@salePersonFrom' or ? is null)--销售员
			//					and (t11.FNumber<='@salePersonTo'or ? is null)
			//			and (t12.FNumber<='@saleGroupFrom'or ? is null)--销售组
			//			and (t12.FNumber<='@saleGroupTo'or ? is null)
			//			and (t13.FNumber='@bizType'or ? is null)
			//			and (t3.FNumber>='@materialFrom' or ? is null)--物料
			//			and (t3.FNumber<='@materialTo' or ? is null)
			//			and (t16.FNumber>='@materialGroupFrom' or ? is null)--物料组
			//			and (t16.FNumber<='@materialGroupTo' or ? is null)
			//			and ((case when '@customerType'= 0 --应收客户
			//					then t14.FNumber
			//					when '@customerType'= 1 --送货客户
			//					then t6.Fnumber
			//					else                   --送货客户
			//					t15.Fnumber end )>='@customerFrom' or ? is null)
			//					and ((case when '@customerType'= 0 --应收客户
			//							then t14.FNumber
			//							when '@customerType'= 1 --送货客户
			//							then t6.Fnumber
			//							else                   --送货客户
			//							t15.Fnumber end )<='@customerTo' or ? is null)
			//							and t1.FBaseStatus in (case when '@billStatus'=4
			//									then (select 4 from dual) 
			//							when '@billStatus'=-4
			//							then (
			//									select  distinct FBaseStatus 
			//									from T_IM_SaleIssueBill where FBaseStatus<>4)
			//							else (select distinct FBaseStatus from T_IM_SaleIssueBill) end)
			//
			//			group by t3.FNumber,t3.FName_l2,t3.FModel,t4.FName_l2,t5.FName_l2,t3.FSimpleName
			//			order by t3.FNumber desc
		}
		return null;
	}















	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.salegrossprofitsrpt.app.SaleGrossProfitsControllerBean");
	private static final long serialVersionUID = 6884251906121719078L;
	private static Object SubLabel = null;
	private Object locString;
	private int minLevel;
	private String tempTable;
	private Object classficationType;
	private String sp;
	private RptParams params;
	private boolean isBySaleOrg;
	private Object tempColsForSelect;
	private Object tempColsForGroup;
	private Object groupCols;
	private int defaultPre;
	private boolean isAssistSum;
	private boolean isFromOUTSTORE;
	private Object saleOrgIDs;
	private String companyOrgIDs;
	private SaleReportBizTypeEnum bizType;
	private SaleReportBillStatusEnum billStatus;
	public SaleGrossProfitsControllerBean()
	{
		this.sp = "\r\n";

		this.locString = "L2";

		this.SubLabel = "";








		this.params = new RptParams();


		this.tempColsForSelect = null;


		this.tempColsForGroup = null;


		this.groupCols = null;

		this.minLevel = 1;

		this.defaultPre = 2;




		this.isAssistSum = false;

		this.isFromOUTSTORE = false;


		this.saleOrgIDs = null;


		this.companyOrgIDs = null;


		this.isBySaleOrg = true;
	}









	protected RptParams _query(Context ctx, RptParams params, int FROM, int len)
	throws BOSException, EASBizException {
		if (params.getBoolean("AuxiliaryProperties")) {
			this.isAssistSum = true;
		}
		if (logger.isDebugEnabled()) {
			logger
			.debug(new StringBuilder()
			.append(
					ResourceBase
					.getString(
							"com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource",
							"28_SaleGrossProfitsControllerBean",
							ctx.getLocale())).append(
									params.getString("tempTable")).toString());
		}

		String tempTable = params.getString("tempTable");

		SaleReportClassificationEnum classficationType = SaleReportClassificationEnum
		.getEnum(new Integer(params.getString("classification"))
		.intValue());
		int level = params.getInt("levelCount");

		StringBuffer selectTotalColBuff = new StringBuffer();
		for (int i = 1; i <= level; ++i) {
			selectTotalColBuff.append("FNumber_").append(String.valueOf(i))
			.append("Name,");
		}
		StringBuffer orderByTotalColBuff = new StringBuffer();
		for (int i = 1; i <= level; ++i) {
			orderByTotalColBuff.append("isnull(FNumber_").append(
					String.valueOf(i)).append(",'!') desc, ").append(
					"isnull(FNumber_").append(String.valueOf(i)).append(
					"Name,'!') desc,");
		}
		if (orderByTotalColBuff.length() > 0) {
			orderByTotalColBuff.setLength(orderByTotalColBuff.length() - 1);
		}

		StringBuffer selectCol = new StringBuffer();
		StringBuffer orderByCol = new StringBuffer();

		if (classficationType.equals(SaleReportClassificationEnum.material)) {
			if (this.isAssistSum)
				selectCol
				.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
			else {
				selectCol
				.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
			}
			orderByCol.append("fmaterialNum desc ");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customer)) {
			selectCol.append("fcustomerNumber,fcustomerName,").append(
					this.defaultPre).append(" FQtyPrecision,");
			orderByCol.append("fcustomerNumber desc ");
		} else if ((classficationType
				.equals(SaleReportClassificationEnum.materialGroup))
				|| (classficationType
						.equals(SaleReportClassificationEnum.customerGroup))) {
			selectCol.append(selectTotalColBuff).append(this.defaultPre)
			.append(" FQtyPrecision,");
			orderByCol.append(orderByTotalColBuff);
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustGroup)) {
			if (this.isAssistSum)
				selectCol
				.append(
				"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,")
				.append(selectTotalColBuff);
			else {
				selectCol
				.append(
				"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,")
				.append(selectTotalColBuff);
			}
			orderByCol.append("fmaterialNum desc ,baseUnitName,").append(
					orderByTotalColBuff);
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustomer)) {
			if (this.isAssistSum) {
				selectCol
				.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
				selectCol.append("fcustomerNumber,fcustomerName,");
			} else {
				selectCol
				.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
				selectCol.append("fcustomerNumber,fcustomerName,");
			}
			orderByCol
			.append("fmaterialNum desc ,baseUnitName,fcustomerNumber desc");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusmaterial)) {
			if (this.isAssistSum) {
				selectCol.append("fcustomerNumber,fcustomerName,");
				selectCol
				.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
			} else {
				selectCol
				.append("fcustomerNumber,fcustomerName,")
				.append(
				"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
			}
			orderByCol
			.append("fcustomerNumber desc ,fmaterialNum desc,baseUnitName");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterGroup)) {
			selectCol.append("fcustomerNumber,fcustomerName,").append(
					this.defaultPre).append(" FQtyPrecision,").append(
							selectTotalColBuff);
			orderByCol.append("fcustomerNumber,").append(orderByTotalColBuff);
		} else if (classficationType
				.equals(SaleReportClassificationEnum.custGroupPlusMaterial)) {
			if (this.isAssistSum)
				selectCol
				.append(selectTotalColBuff)
				.append(
				"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
			else {
				selectCol
				.append(selectTotalColBuff)
				.append(
				"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
			}
			orderByCol.append(orderByTotalColBuff).append(
			",fmaterialNum desc,baseUnitName");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materGroupPlusCustomer)) {
			selectCol.append(selectTotalColBuff).append(
			"fcustomerNumber,fcustomerName,").append(this.defaultPre)
			.append(" FQtyPrecision,");
			orderByCol.append(orderByTotalColBuff).append(
			",fcustomerNumber desc");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.departmentplusmaterial)) {
			if (this.isAssistSum)
				selectCol
				.append("fadminunitName,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
			else {
				selectCol
				.append("fadminunitName,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
			}
			orderByCol.append("fadminunitName,fmaterialNum desc,baseUnitName");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterPerson)) {
			if (this.isAssistSum) {
				selectCol
				.append("fsalePersonNum,fSalePersonName,fcustomerNumber,fcustomerName,");
				selectCol
				.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
			} else {
				selectCol
				.append("fsalePersonNum,fSalePersonName,fcustomerNumber,fcustomerName,");
				selectCol
				.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
			}
			orderByCol
			.append(" fsalePersonNum,fSalePersonName,fcustomerNumber desc ,fcustomerName ");
			orderByCol.append(",fmaterialNum desc ,baseUnitName");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.saleorder)) {
			selectCol.append("fsoNumber,").append(this.defaultPre).append(
			" FQtyPrecision,");
			orderByCol.append("fsoNumber desc ");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.salecontract)) {
			selectCol.append("fscNumber,").append(this.defaultPre).append(
			" FQtyPrecision,");
			orderByCol.append("fscNumber desc");
		}
		StringBuffer sqlBuff = new StringBuffer();

		if ((classficationType.equals(SaleReportClassificationEnum.material))
				|| (classficationType
						.equals(SaleReportClassificationEnum.materialPlusCustGroup))
						|| (classficationType
								.equals(SaleReportClassificationEnum.custGroupPlusMaterial))
								|| (classficationType
										.equals(SaleReportClassificationEnum.materialPlusCustomer))
										|| (classficationType
												.equals(SaleReportClassificationEnum.customerPlusmaterial))
												|| (classficationType
														.equals(SaleReportClassificationEnum.departmentplusmaterial))
														|| (classficationType
																.equals(SaleReportClassificationEnum.customerPlusMaterPerson))) {
			sqlBuff
			.append("SELECT ")
			.append(selectCol)
			.append(
			"saleQty,outQty, statUnitName, statSaleQty, statOutQty, avgSalePrice,saleAmount,saleCost,profit,profitRate,unitProfit, statProfit ");
			sqlBuff.append(" FROM ").append(tempTable).append(" ORDER BY ")
			.append(orderByCol);
		} else {
			sqlBuff
			.append("SELECT ")
			.append(selectCol)
			.append(
			"saleQty,outQty,avgSalePrice,saleAmount,saleCost,profit,profitRate FROM ")
			.append(tempTable).append(" ORDER BY ").append(orderByCol);
		}
		RptRowSet rs = executeQuery(sqlBuff.toString(), null, FROM, len, ctx);
		RptParams pp = new RptParams();
		pp.setObject("rowset", rs);
		return pp;
	}

	protected RptParams _createTempTable(Context ctx, RptParams params)
	throws BOSException, EASBizException {
		this.locString = getLoc(ctx);
		this.params = params;

		this.SubLabel = SCMUtils.getResource(
				"com.kingdee.eas.scm.sd.sale.report.SDReportResource",
				"SUB_STRING", ctx);

		dropTable(params.getString("tempTable"), ctx);
		this.tempTable = getTempTableName(
				getServerResource("RPTTempTable", ctx), ctx);

		this.bizType = SaleReportBizTypeEnum.all;
		if (params.containsKey("billType")) {
			this.bizType = SaleReportBizTypeEnum.getEnum(new Integer(params
					.getString("billType")).intValue());
		}

		this.billStatus = SaleReportBillStatusEnum.all;
		if (params.containsKey("billStatus")) {
			this.billStatus = SaleReportBillStatusEnum.getEnum(new Integer(
					params.getString("billStatus")).intValue());
		}
		this.classficationType = SaleReportClassificationEnum.material;
		if (params.containsKey("classification")) {
			this.classficationType = SaleReportClassificationEnum
			.getEnum(new Integer(params.getString("classification"))
			.intValue());
		}

		if (params.containsKey("byOrgType")) {
			this.isBySaleOrg = params.getBoolean("byOrgType");
		}
		if (this.isBySaleOrg) {
			Object[] saleOrgs = (Object[]) (Object[]) params
			.getObject("fullSaleOrgUnit");

			this.saleOrgIDs = getOrgIds(saleOrgs);
		} else {
			Object[] companyOrgs = (Object[]) (Object[]) params
			.getObject("fullCompanyOrgUnit");
			this.companyOrgIDs = getOrgIds(companyOrgs);
		}

		if (params.getBoolean("AuxiliaryProperties")) {
			this.isAssistSum = true;
		}

		processData(ctx, params);

		int rowCount = totalRowCount(ctx);

		boolean saleQtyFlag = getUserPremission(ctx, "saleQty");

		boolean outQtyFalg = getUserPremission(ctx, "outQty");

		boolean saleIncomeFlag = getUserPremission(ctx, "saleIncome");
		boolean saleCostFlag = getUserPremission(ctx, "saleCost");

		boolean SaleProfitFlag = getUserPremission(ctx, "saleProfit");

		boolean saleProfitRateFalg = getUserPremission(ctx, "saleProfitRate");

		RptParams result = new RptParams();
		result.setString("tempTable", this.tempTable);
		result.setInt("levelCount", this.minLevel);
		result.setInt("rowCount", rowCount);
		result.setBoolean("SaleQty", saleQtyFlag);
		result.setBoolean("OutQty", outQtyFalg);
		result.setBoolean("SaleIncome", saleIncomeFlag);
		result.setBoolean("SaleCost", saleCostFlag);
		result.setBoolean("SaleProfit", SaleProfitFlag);
		result.setBoolean("SaleProfitRate", saleProfitRateFalg);
		return result;
	}

	public boolean getUserPremission(Context ctx, String permission)
	throws EASBizException, BOSException {
		boolean Flag = false;
		UserInfo curUseInfo = ContextUtil.getCurrentUserInfo(ctx);
		FullOrgUnitCollection orgUnitCollection = PermissionFactory
		.getLocalInstance(ctx).getAuthorizedOrg(
				new ObjectUuidPK(curUseInfo.getId()), OrgType.Sale,
				null, permission);
		OrgUnitInfo info = ContextUtil.getCurrentOrgUnit(ctx);
		for (int k = 0; k < orgUnitCollection.size(); ++k) {
			if (info.getId().toString().equals(
					orgUnitCollection.get(k).getId().toString())) {
				Flag = true;
				return Flag;
			}
		}
		return Flag;
	}

	private int totalRowCount(Context ctx) throws BOSException, EASBizException {
		String countSql = new StringBuilder()
		.append("SELECT count(1) cc FROM ").append(this.tempTable)
		.toString();
		RptRowSet rs = executeQuery(countSql, null, ctx);
		rs.next();
		int count = 0;
		if (rs.getObject(0) != null) {
			count = rs.getInt(0);
		}
		return count;
	}

	private int getLevel() {
		int reqLevel = 1;
		if (this.params.getObject("grade") instanceof String)
			reqLevel = Integer.parseInt(this.params.getString("grade"));
		else if (this.params.getObject("grade") instanceof Integer) {
			reqLevel = this.params.getInt("grade");
		}

		return reqLevel;
	}

	public void processData(Context ctx, RptParams params) throws BOSException,
	EASBizException {
		createTempData(ctx, params);

		updateTempForStatColumn(ctx);

		twoTotalData(ctx, params);

		updateTempForProfit(ctx);
	}

	private void updateTempForProfit(Context ctx) throws BOSException,
	EASBizException {
		StringBuffer updateSql = new StringBuffer();
		updateSql.setLength(0);
		updateSql.append(" update ").append(this.tempTable);
		updateSql.append(" set profit = saleAmount - saleCost,");
		updateSql.append(" profitRate= Case When saleAmount = 0 Then 0.00 ");
		updateSql
		.append(" Else case when (saleAmount - saleCost) < 0 and saleAmount < 0 then -1*to_decimal((saleAmount - saleCost)/saleAmount*100,31,8) ");
		updateSql
		.append(" else to_decimal((saleAmount - saleCost)/saleAmount*100,31,8) end END ");
		executeUpdate(updateSql.toString(), null, ctx);
	}

	private void updateTempForStatColumn(Context ctx) throws BOSException,
	EASBizException {
		StringBuffer updateSql = new StringBuffer();
		if ((!(this.classficationType
				.equals(SaleReportClassificationEnum.material)))
				&& (!(this.classficationType
						.equals(SaleReportClassificationEnum.materialPlusCustGroup)))
						&& (!(this.classficationType
								.equals(SaleReportClassificationEnum.custGroupPlusMaterial)))
								&& (!(this.classficationType
										.equals(SaleReportClassificationEnum.materialPlusCustomer)))
										&& (!(this.classficationType
												.equals(SaleReportClassificationEnum.customerPlusmaterial)))
												&& (!(this.classficationType
														.equals(SaleReportClassificationEnum.departmentplusmaterial)))
														&& (!(this.classficationType
																.equals(SaleReportClassificationEnum.customerPlusMaterPerson)))) {
			return;
		}

		updateSql.append(" update ").append(this.tempTable).append(
		" set statUnitName = null");
		executeUpdate(updateSql.toString(), null, ctx);
		updateSql.setLength(0);

		updateSql.append(" update ").append(this.tempTable);
		updateSql.append(" set (statUnitName,FBaseConvsRate) = ");
		updateSql.append(" (select statUnit.fname_").append(this.locString)
		.append(",statMmUnit.FBaseConvsRate ");
		updateSql.append("    from T_BD_MultiMeasureUnit statMmUnit ");
		updateSql
		.append("    left outer join T_BD_MeasureUnit statUnit on statMmUnit.fmeasureunitid = statUnit.fid ");
		updateSql.append("    where statMmUnit.FMaterialID = ").append(
				this.tempTable).append(
				".fmaterialid and statMmUnit.FIsStatUnit = 1)");
		executeUpdate(updateSql.toString(), null, ctx);

		updateSql.setLength(0);
		updateSql.append(" update ").append(this.tempTable);
		updateSql.append(" set profit = saleAmount - saleCost,");
		updateSql.append(" profitRate= Case When saleAmount = 0 Then 0.00 ");
		updateSql
		.append(" Else case when (saleAmount - saleCost) < 0 and saleAmount < 0 then -1*to_decimal((saleAmount - saleCost)/saleAmount*100,31,8) else ");
		updateSql
		.append("  to_decimal((saleAmount - saleCost)/saleAmount*100,31,8) END END, ");
		updateSql
		.append(" statSaleQty = case when FBaseConvsRate <> -1 and FBaseConvsRate is not null then to_decimal(saleQty/FBaseConvsRate,31,8) ");
		updateSql.append(" else saleQty end, ");
		updateSql
		.append(" statOutQty = case when FBaseConvsRate <> -1 and FBaseConvsRate is not null then to_decimal(outQty/FBaseConvsRate,31,8) ");
		updateSql.append(" else outQty end, ");
		updateSql.append(" unitProfit = case when saleQty = 0 then null else ");
		updateSql
		.append("   case when (saleAmount - saleCost) <0 and saleQty < 0 then -1*to_decimal((saleAmount - saleCost)/saleQty,31,8) else ");
		updateSql
		.append("  to_decimal((saleAmount - saleCost)/saleQty,31,8) end end, ");
		updateSql
		.append(" statProfit = case when FBaseConvsRate <> -1 and FBaseConvsRate is not null and saleQty <> 0 then ");
		updateSql
		.append("   case when (saleAmount - saleCost) <0 and to_decimal(saleQty/FBaseConvsRate,31,8) < 0 then -1*to_decimal((saleAmount - saleCost)/to_decimal(saleQty/FBaseConvsRate,31,8),31,8) ");
		updateSql
		.append("    else to_decimal((saleAmount - saleCost)/to_decimal(saleQty/FBaseConvsRate,31,8),31,8) end ");
		updateSql.append(" else case when saleQty = 0 then null else ");
		updateSql
		.append("   case when (saleAmount - saleCost) < 0 and saleQty < 0 then -1*to_decimal((saleAmount - saleCost)/saleQty,31,8) ");
		updateSql
		.append("   else to_decimal((saleAmount - saleCost)/saleQty,31,8) end end end ");

		updateSql.append(" where statUnitName is not null ");

		executeUpdate(updateSql.toString(), null, ctx);
	}

	private void createTempData(Context ctx, RptParams params)
	throws BOSException, EASBizException {
		StringBuffer sumOut = new StringBuffer();
		sumOut
		.append(
		"to_decimal(saleQty,31,8) saleQty,to_decimal(outQty,31,8) outQty,")
		.append(this.sp);
		sumOut
		.append(
		"to_decimal(0.0,31,8) statSaleQty,to_decimal(0.0,31,8) statOutQty,")
		.append(this.sp);
		sumOut
		.append(
		"to_decimal(avgSalePrice,31,8) avgSalePrice,to_decimal(saleAmount,31,8) saleAmount,to_decimal(saleCost,31,8) saleCost,")
		.append(this.sp);
		sumOut
		.append(
		"to_decimal(0.0,31,8) profit,to_decimal(0.0,31,8) profitRate, ")
		.append(this.sp);
		sumOut
		.append(
		"to_decimal(0.0,31,8) unitProfit,to_decimal(0.0,31,8) statProfit ")
		.append(this.sp);

		StringBuffer setNullSql = null;

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustGroup))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.customerPlusMaterGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.materGroupPlusCustomer))
								|| (this.classficationType
										.equals(SaleReportClassificationEnum.custGroupPlusMaterial))
										|| (this.classficationType
												.equals(SaleReportClassificationEnum.materialGroup))
												|| (this.classficationType
														.equals(SaleReportClassificationEnum.customerGroup))) {
			int reqLevel = getLevel();
			setNullSql = new StringBuffer();

			for (int i = 1; i <= reqLevel; ++i) {
				sumOut.append(",FLongNumber FNumber_").append(i).append(
				",FLongNumber FNumber_").append(i).append("Name");
				setNullSql.append("FNumber_").append(i).append(" = NULL,");
				if (i < reqLevel)
					setNullSql.append("FNumber_").append(i).append(
					"Name = NULL, ");
				else {
					setNullSql.append("FNumber_").append(i).append(
					"Name = NULL ");
				}
			}

		}

		StringBuffer sumIn = new StringBuffer();
		sumIn
		.append(
		"to_decimal(sum(saleQty),31,8) saleQty,to_decimal(sum(outQty),31,8) outQty,")
		.append(this.sp);
		sumIn
		.append(
		"case when sum(outQty)=0 then null else round(sum(saleAmount)/sum(outQty),5) end avgSalePrice,to_decimal(sum(saleAmount),31,8) saleAmount,to_decimal(sum(saleCost),31,8) saleCost ")
		.append(this.sp);
		String querySql = null;
		try {
			if ((!(this.isBySaleOrg)) && (params.containsKey("isContainCost"))
					&& (params.getBoolean("isContainCost"))
					&& (this.billStatus.equals(SaleReportBillStatusEnum.cal))) {
				HashMap dateMap = new HashMap();
				String periodYear = params.getString("periodYear");
				String periodYearTo = params.getString("periodYearTo");
				String periodMonth = params.getString("periodMonth");
				String periodMonthTo = params.getString("periodMonthTo");

				String[] companyId = this.companyOrgIDs.split(",");

				int i = 0;
				for (int size = companyId.length - 1; i < size; ++i) {
					HashMap tempMap = new HashMap();
					String companyOrgId = companyId[i];

					String sqlFromDate = new StringBuilder()
					.append(
					"select fbegindate from T_BD_Period p inner join T_ORG_Company c on p.FTypeID = c.FAccountPeriodID where p.fperiodyear = '")
					.append(periodYear).append(
					"' and p.fperiodnumber='").append(
							periodMonth).append("' and c.fid=").append(
									companyOrgId).toString();
					String sqlToDate = new StringBuilder()
					.append(
					"select fenddate from T_BD_Period p inner join T_ORG_Company c on p.FTypeID = c.FAccountPeriodID where p.fperiodyear = '")
					.append(periodYearTo).append(
					"' and p.fperiodnumber='").append(
							periodMonthTo).append("' and c.fid=")
							.append(companyOrgId).toString();

					IRowSet rs1 = DBUtil.executeQuery(ctx, sqlFromDate, null);
					IRowSet rs2 = DBUtil.executeQuery(ctx, sqlToDate, null);

					while (rs1.next()) {
						tempMap.put("beginDateByCal", rs1.getString(1));
					}

					while (rs2.next()) {
						tempMap.put("endDateByCal", rs2.getString(1));
					}
					dateMap.put(companyOrgId, tempMap);
				}
				params.setObject("dateByCal", dateMap);
			}

			querySql = buildSql(ctx, params);
			StringBuffer insertSql = new StringBuffer();
			insertSql.append(" SELECT ").append(this.tempColsForSelect).append(
			",").append(sumOut).append(this.sp).append(" into ")
			.append(this.tempTable).append(" FROM (SELECT ").append(
					this.sp).append(this.tempColsForGroup).append(",")
					.append(sumIn).append(this.sp).append(" FROM (").append(
							querySql).append(") as temp0____").append(this.sp)
							.append(" GROUP BY ").append(this.groupCols)
							.append(this.sp).append(") as temp3_____");

			CreateTempTableResult result = executeCreateAsSelectInto(ctx,
					insertSql.toString(), null);
			this.tempTable = result.getTempTable();
		} catch (BOSException e) {
			throw e;
		} catch (SQLException e) {
			logger.error(e);
		}
		if (setNullSql != null)
			executeUpdate(new StringBuilder().append("UPDATE ").append(
					this.tempTable).append(" SET ").append(
							setNullSql.toString()).toString(), null, ctx);
	}

	private void twoTotalData(Context ctx, RptParams params)
	throws BOSException, EASBizException {
		String groupByMaterial = null;
		if (this.isAssistSum)
			groupByMaterial = "fmaterialid,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName ";
		else {
			groupByMaterial = "fmaterialid,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName ";
		}
		String groupByCustomer = "fcustomerid,fcustomerNumber,fcustomerName";
		String groupByDepartment = "fadminunitid,fadminunitName";
		String groupByPersonCustomer = "fSalePersonid,fSalePersonNum,fSalePersonName,fcustomerid,fcustomerNumber,fcustomerName";
		String groupByPerson = "fSalePersonid,fSalePersonNum,fSalePersonName";

		if (this.classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustomer)) {
			String insertCols = new StringBuilder().append(groupByMaterial)
			.append(",fcustomerNumber").toString();
			String selectCols = new StringBuilder().append(groupByMaterial)
			.append(",' ").append(this.SubLabel).append("' ")
			.toString();
			insertGroupData(ctx, insertCols, selectCols, groupByMaterial, true);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustGroup)) {
			classficationGroup(ctx, params, groupByMaterial, null, true);

			updateTempForStatColumn(ctx);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.customerPlusmaterial)) {
			String insertCols = new StringBuilder().append(groupByCustomer)
			.append(",fmaterialNum").toString();
			String selectCols = new StringBuilder().append(groupByCustomer)
			.append(",' ").append(this.SubLabel).append("' ")
			.toString();
			insertGroupData(ctx, insertCols, selectCols, groupByCustomer, true);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterGroup)) {
			classficationGroup(ctx, params, groupByCustomer, null, false);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.materGroupPlusCustomer)) {
			classficationGroup(ctx, params, null, groupByCustomer, false);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.custGroupPlusMaterial)) {
			classficationGroup(ctx, params, null, groupByMaterial, true);

			updateTempForStatColumn(ctx);
		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.materialGroup))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.customerGroup))) {
			classficationGroup(ctx, params, null, null, false);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.material)) {
			subtotal(ctx, params, "fmaterialNum", true);
		}
		if (this.classficationType
				.equals(SaleReportClassificationEnum.customer)) {
			subtotal(ctx, params, "fcustomerNumber", false);
		}
		if (this.classficationType
				.equals(SaleReportClassificationEnum.saleorder)) {
			subtotal(ctx, params, "fsoNumber", false);
		}
		if (this.classficationType
				.equals(SaleReportClassificationEnum.salecontract)) {
			subtotal(ctx, params, "fscNumber", false);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.departmentplusmaterial)) {
			String insertCols = new StringBuilder().append(groupByDepartment)
			.append(",fmaterialNum").toString();
			String selectCols = new StringBuilder().append(groupByDepartment)
			.append(",' ").append(this.SubLabel).append("' ")
			.toString();
			insertGroupData(ctx, insertCols, selectCols, groupByDepartment,
					true);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterPerson)) {
			String insPersCusTotalCols = new StringBuilder().append(
					groupByPersonCustomer).append(",fmaterialNum").toString();
			String selPersCusTotalCols = new StringBuilder().append(
					groupByPersonCustomer).append(",' ").append(this.SubLabel)
					.append("' ").toString();

			insertGroupData(ctx, insPersCusTotalCols, selPersCusTotalCols,
					groupByPersonCustomer, true);

			String insPersTotalCols = new StringBuilder().append(groupByPerson)
			.append(",fcustomerNumber").toString();
			String selPersTotalCols = new StringBuilder().append(groupByPerson)
			.append(",' ").append(this.SubLabel).append("' ")
			.toString();
			StringBuffer totalSql = new StringBuffer();
			totalSql.append("insert into ");
			totalSql.append(this.tempTable).append("\n (");
			totalSql.append(insPersTotalCols);
			totalSql.append(",saleQty,outQty,saleCost,saleAmount) ");
			totalSql.append(this.sp);
			totalSql.append("\n SELECT ");
			totalSql.append(selPersTotalCols);
			totalSql
			.append(",sum(saleQty),sum(outQty),sum(saleCost),sum(saleAmount) ");
			totalSql.append(this.sp);
			totalSql.append("\n FROM ").append(this.tempTable);
			totalSql.append(this.sp);
			totalSql.append("\n where fmaterialNum <>' ");
			totalSql.append(this.SubLabel).append("'");
			totalSql.append("\n GROUP BY ");
			totalSql.append(groupByPerson).append(this.sp);
			executeUpdate(totalSql.toString(), null, ctx);
		}

		if ((!(this.classficationType
				.equals(SaleReportClassificationEnum.material)))
				&& (!(this.classficationType
						.equals(SaleReportClassificationEnum.materialPlusCustomer)))
						&& (!(this.classficationType
								.equals(SaleReportClassificationEnum.customerPlusmaterial)))
								&& (!(this.classficationType
										.equals(SaleReportClassificationEnum.materialPlusCustGroup)))
										&& (!(this.classficationType
												.equals(SaleReportClassificationEnum.custGroupPlusMaterial)))
												&& (!(this.classficationType
														.equals(SaleReportClassificationEnum.departmentplusmaterial)))
														&& (!(this.classficationType
																.equals(SaleReportClassificationEnum.customerPlusMaterPerson)))) {
			return;
		}

		String updateSql = new StringBuilder().append("UPDATE ").append(
				this.tempTable).append(" SET FQtyPrecision = ").append(
						String.valueOf(this.defaultPre)).append(
						" WHERE FQtyPrecision IS NULL").toString();
		executeUpdate(updateSql, null, ctx);
	}

	private void insertGroupData(Context ctx, String insertCol,
			String selectBy, String groupBy, boolean isIncludeStatUnit)
	throws BOSException, EASBizException {
		StringBuffer totalSql = new StringBuffer();
		totalSql.append("insert into ").append(this.tempTable).append(" (")
		.append(insertCol);
		if (isIncludeStatUnit)
			totalSql
			.append(
			",saleQty,outQty,saleCost,saleAmount,statSaleQty, statOutQty) ")
			.append(this.sp);
		else {
			totalSql.append(",saleQty,outQty,saleCost,saleAmount) ").append(
					this.sp);
		}
		totalSql.append(" SELECT ").append(selectBy).append(
		",sum(saleQty),sum(outQty),sum(saleCost),sum(saleAmount) ")
		.append(this.sp);
		if (isIncludeStatUnit) {
			totalSql.append(",sum(statSaleQty),sum(statOutQty)");
		}
		totalSql.append(" FROM ").append(this.tempTable).append(this.sp);
		totalSql.append(" GROUP BY ").append(groupBy).append(this.sp);
		executeUpdate(totalSql.toString(), null, ctx);
	}

	private String buildSql(Context ctx, RptParams params) {
		this.tempColsForSelect = null;
		this.tempColsForGroup = null;
		this.groupCols = null;

		this.isFromOUTSTORE = false;
		if (params.containsKey("imcomeFrom")) {
			SaleImcomEnum saleImcom = SaleImcomEnum.getEnum(new Integer(params
					.getString("imcomeFrom")).intValue());
			if (saleImcom.equals(SaleImcomEnum.FROM_OUTSTORE)) {
				this.isFromOUTSTORE = true;
			}
		}

		StringBuffer querySql = new StringBuffer();
		if (this.isFromOUTSTORE) {
			String imCostSql = buildImCost(ctx, params);
			querySql.append(imCostSql);
		} else {
			String mainSql = buildSaleAmount(ctx, params, "sourceBillType");
			querySql.append(mainSql).append(this.sp);

			if ((params.containsKey("containInvoice"))
					&& (params.getBoolean("containInvoice"))) {
				String mainSqlNull = buildSaleAmount(ctx, params, "null");
				querySql.append(" UNION ALL ").append(this.sp).append(
						mainSqlNull).append(this.sp);
			}

			if (this.bizType.equals(SaleReportBizTypeEnum.all)) {
				String imCostSql = buildImCost(ctx, params);
				String apCostSql = buildApCost(ctx, params);
				querySql.append(" UNION ALL ").append(this.sp)
				.append(imCostSql).append(this.sp);
				querySql.append(" UNION ALL ").append(this.sp)
				.append(apCostSql);
			} else if (this.bizType.equals(SaleReportBizTypeEnum.sale)) {
				String apCostSql = buildApCost(ctx, params);
				querySql.append(" UNION ALL ").append(this.sp)
				.append(apCostSql);
			} else {
				String imCostSql = buildImCost(ctx, params);
				querySql.append(" UNION ALL ").append(this.sp)
				.append(imCostSql);
			}

		}

		if ((!(this.isBySaleOrg))
				&& (!(this.classficationType
						.equals(SaleReportClassificationEnum.saleorder)))
						&& (!(this.classficationType
								.equals(SaleReportClassificationEnum.salecontract)))
								&& (params.containsKey("isContainCost"))
								&& (params.getBoolean("isContainCost"))) {
			if (this.billStatus.equals(SaleReportBillStatusEnum.cal)) {
				String[] companyId = this.companyOrgIDs.split(",");
				int i = 0;
				for (int size = companyId.length - 1; i < size; ++i) {
					if (params.containsKey("currentOrgId")) {
						params.remove("currentOrgId");
					}
					String companyOrgId = companyId[i];
					params.setString("currentOrgId", companyOrgId);

					String costAdjSql = buildCostAdjBillQuery(ctx, params);
					querySql.append(" UNION ALL ").append(this.sp).append(
							costAdjSql).append(this.sp);
				}
				if (params.containsKey("currentOrgId"))
					params.remove("currentOrgId");
			} else {
				String costAdjSql = buildCostAdjBillQuery(ctx, params);
				querySql.append(" UNION ALL ").append(this.sp).append(
						costAdjSql).append(this.sp);
			}
		}

		return querySql.toString();
	}

	private List buildSqlList(Context ctx, RptParams params) {
		this.tempColsForSelect = null;
		this.tempColsForGroup = null;
		this.groupCols = null;

		this.isFromOUTSTORE = false;
		if (params.containsKey("imcomeFrom")) {
			SaleImcomEnum saleImcom = SaleImcomEnum.getEnum(new Integer(params
					.getString("imcomeFrom")).intValue());
			if (saleImcom.equals(SaleImcomEnum.FROM_OUTSTORE)) {
				this.isFromOUTSTORE = true;
			}
		}

		List querySql = new ArrayList();
		if (this.isFromOUTSTORE) {
			String imCostSql = buildImCost(ctx, params);
			querySql.add(imCostSql);
		} else {
			String mainSql = buildSaleAmount(ctx, params, "sourceBillType");
			querySql.add(mainSql);

			if ((params.containsKey("containInvoice"))
					&& (params.getBoolean("containInvoice"))) {
				String mainSqlNull = buildSaleAmount(ctx, params, "null");
				querySql.add(mainSqlNull);
			}

			if (this.bizType.equals(SaleReportBizTypeEnum.all)) {
				String imCostSql = buildImCost(ctx, params);
				String apCostSql = buildApCost(ctx, params);
				querySql.add(imCostSql);
				querySql.add(apCostSql);
			} else if (this.bizType.equals(SaleReportBizTypeEnum.sale)) {
				String apCostSql = buildApCost(ctx, params);
				querySql.add(apCostSql);
			} else {
				String imCostSql = buildImCost(ctx, params);
				querySql.add(imCostSql);
			}

		}

		if ((!(this.isBySaleOrg))
				&& (!(this.classficationType
						.equals(SaleReportClassificationEnum.saleorder)))
						&& (!(this.classficationType
								.equals(SaleReportClassificationEnum.salecontract)))
								&& (params.containsKey("isContainCost"))
								&& (params.getBoolean("isContainCost"))) {
			String costAdjSql = buildCostAdjBillQuery(ctx, params);
			querySql.add(costAdjSql);
		}
		return querySql;
	}

	private String buildSaleAmount(Context ctx, RptParams params,
			String sourceBillType) {
		StringBuffer sql = new StringBuffer();
		if (this.billStatus.equals(SaleReportBillStatusEnum.cal)) {
			if (this.bizType.equals(SaleReportBizTypeEnum.all)) {
				QuerySql mainQuery = buildSaleQuery(ctx, params, 2,
						sourceBillType);
				QuerySql calQuery = buildSaleQuery(ctx, params, 3,
						sourceBillType);
				sql.append(mainQuery.getSql()).append(this.sp);
				sql.append(" union all ").append(this.sp);
				sql.append(calQuery.getSql()).append(this.sp);
			} else if (this.bizType.equals(SaleReportBizTypeEnum.sale)) {
				QuerySql calQuery = buildSaleQuery(ctx, params, 3,
						sourceBillType);
				sql.append(calQuery.getSql()).append(this.sp);
			} else {
				QuerySql mainQuery = buildSaleQuery(ctx, params, 2,
						sourceBillType);
				sql.append(mainQuery.getSql()).append(this.sp);
			}
		} else {
			QuerySql mainQuery = buildSaleQuery(ctx, params, 1, sourceBillType);

			sql.append(mainQuery.getSql()).append(this.sp);
		}

		return sql.toString();
	}

	private QuerySql buildSaleQuery(Context ctx, RptParams params, int type,
			String sourceBillType) {
		QuerySql querySql = new QuerySql();
		boolean isCalStatus = false;
		String fromDate = params.getString("dateStart");
		String toDate = params.getString("dateEnd");
		String periodYear = params.getString("periodYear");
		String periodYearTo = params.getString("periodYearTo");
		String periodMonth = params.getString("periodMonth");
		String periodMonthTo = params.getString("periodMonthTo");

		if (type == 2) {
			isCalStatus = true;
		}

		String amountColumn = "";
		String qtyColumn = "";
		if (isCalStatus) {
			amountColumn = "cl_entry.FCurrWrittenOffAmount";

			qtyColumn = "cl_entry.FCurrWrittenOffQty";
		} else {
			amountColumn = "ar_entry.famountlocal";

			qtyColumn = " case when ar_entry.fmaterialID is not null then ar_entry.fbaseqty else ar_entry.fquantity end as ";
		}

		querySql.aliasName = "AR";
		querySql.selectPart.append(" SELECT ");

		if (!(isCalStatus)) {
			querySql.fromPart.append(" FROM t_ar_otherbill ar_otherbill ")
			.append(this.sp);
			querySql.fromPart
			.append(" INNER JOIN t_ar_otherbillentry ar_entry ");
			querySql.fromPart.append(
			" on ar_otherbill.fid = ar_entry.FParentID ").append(
					this.sp);
		} else {
			querySql.fromPart.append(" FROM T_CL_WriteOffRecord cl_entry  ")
			.append(this.sp);
			querySql.fromPart
			.append(
			" INNER JOIN T_CL_WriteOffGroup cl_writeoff on cl_entry.FParentID = cl_writeoff.FID ")
			.append(this.sp);
			querySql.fromPart
			.append(" INNER JOIN t_ar_otherbillentry ar_entry on ar_entry.FID = cl_entry.FBillEntryID ");
			querySql.fromPart
			.append(
			" INNER JOIN  t_ar_otherbill ar_otherbill on ar_otherbill.fid = ar_entry.FParentID")
			.append(this.sp);
		}

		if ("null".equals(sourceBillType)) {
			querySql.wherePart
			.append(" WHERE ar_otherbill.FIsTransBill = 0 AND (ar_otherbill.FBillType = 104 ");
		} else if ((params.containsKey("containInvoice"))
				&& (params.getBoolean("containInvoice")))
			querySql.wherePart
			.append(" WHERE ar_otherbill.FIsTransBill = 0 AND (ar_otherbill.FBillType = 102 ");
		else {
			querySql.wherePart
			.append(" WHERE ar_otherbill.FIsTransBill = 0 AND (ar_otherbill.FBillType = 102 or ar_otherbill.FBillType = 104");
		}

		if ((!("null".equals(sourceBillType)))
				&& (params.containsKey("containInvoice"))
				&& (params.getBoolean("containInvoice"))) {
			querySql.wherePart.append(" or ar_otherbill.FBillType = 103 ");
		}

		querySql.wherePart.append(" )");

		if ((params.containsKey("containBizBill"))
				&& (params.getBoolean("containBizBill")))
			querySql.wherePart.append("  ");
		else {
			querySql.wherePart.append(" and ar_otherbill.FisBizBill = 0 ");
		}

		if ("null".equals(sourceBillType))
			buildSelectPartNull(querySql);
		else {
			buildSelectPart(querySql);
		}

		querySql.selectPart.append(qtyColumn).append(" saleQty,0.0 outQty,")
		.append(amountColumn).append(" saleAmount,0.0 saleCost  ")
		.append(this.sp);

		if (2 != type) {
			if (fromDate != null) {
				querySql.wherePart.append(
				" AND ar_otherbill.FBizDate >= to_date('").append(
						fromDate).append("') ");
			}
			if (toDate != null) {
				querySql.wherePart.append(
				" AND ar_otherbill.FBizDate <= to_date('").append(
						toDate).append("') ");
			}

			if (fromDate != null) {
				querySql.wherePart.append(
				" AND ar_entry.FBillDate >= to_date('")
				.append(fromDate).append("') ");
			}
			if (toDate != null) {
				querySql.wherePart.append(
				" AND ar_entry.FBillDate <= to_date('").append(toDate)
				.append("') ");
			}
		}

		if (3 == type) {
			appendTable(querySql, "T_SCM_BizType");
			querySql.wherePart.append(" AND billType.FNumber = '").append(220)
			.append("'");
		} else {
			appendTable(querySql, "T_SCM_BizType");
			if (!(this.bizType.equals(SaleReportBizTypeEnum.all))) {
				if (this.bizType.equals(SaleReportBizTypeEnum.generalSale)) {
					querySql.wherePart
					.append(" AND billType.FNumber in ('210','211','212','213') ");
				} else if (this.bizType
						.equals(SaleReportBizTypeEnum.consignSale)) {
					querySql.wherePart
					.append(" AND billType.FNumber in ('230','231') ");
				} else if (this.bizType.equals(SaleReportBizTypeEnum.sale)) {
					querySql.wherePart
					.append(" AND billType.FNumber in ('220') ");
				}
			}
		}

		if (1 == type) {
			if (this.billStatus.equals(SaleReportBillStatusEnum.audit))
				querySql.wherePart.append(" AND ar_otherbill.FBillStatus = 3 ");
			else if (this.billStatus.equals(SaleReportBillStatusEnum.unAudit))
				querySql.wherePart.append(" AND ar_otherbill.FBillStatus =2 ");
			else
				querySql.wherePart
				.append(" AND ar_otherbill.FBillStatus <> 1 ");
		} else if (2 == type) {
			if (fromDate != null) {
				querySql.wherePart.append(
				" AND cl_writeoff.FWriteOffDate >=to_date('").append(
						fromDate.toString()).append("') ");
			}
			if (toDate != null) {
				querySql.wherePart.append(
				" AND cl_writeoff.FWriteOffDate <= to_date('").append(
						toDate.toString()).append("') ");
			}

			querySql.wherePart.append(" AND ( (cl_writeoff.FWriteOffYear > ")
			.append(Integer.valueOf(periodYear));
			querySql.wherePart.append(" AND cl_writeoff.FWriteOffYear < ")
			.append(Integer.valueOf(periodYearTo)).append(")");
			querySql.wherePart.append(" OR ( cl_writeoff.FWriteOffYear >= ")
			.append(Integer.valueOf(periodYear));
			querySql.wherePart.append(" AND cl_writeoff.FWriteOffYear < ")
			.append(Integer.valueOf(periodYearTo));
			querySql.wherePart.append(" AND cl_writeoff.FWriteOffPeriod >= ")
			.append(Integer.valueOf(periodMonth)).append(")");
			querySql.wherePart.append(" OR ( cl_writeoff.FWriteOffYear > ")
			.append(Integer.valueOf(periodYear));
			querySql.wherePart.append(" AND cl_writeoff.FWriteOffYear <= ")
			.append(Integer.valueOf(periodYearTo));
			querySql.wherePart.append(" AND cl_writeoff.FWriteOffPeriod <= ")
			.append(Integer.valueOf(periodMonthTo)).append(")");
			querySql.wherePart.append(" OR ( cl_writeoff.FWriteOffYear = ")
			.append(Integer.valueOf(periodYear));
			querySql.wherePart.append(" AND cl_writeoff.FWriteOffYear = ")
			.append(Integer.valueOf(periodYearTo));
			querySql.wherePart.append(" AND cl_writeoff.FWriteOffPeriod <= ")
			.append(Integer.valueOf(periodMonthTo));
			querySql.wherePart.append(" AND cl_writeoff.FWriteOffPeriod >= ")
			.append(Integer.valueOf(periodMonth)).append(")");
			querySql.wherePart.append(")");
		} else if (3 == type) {
			querySql.wherePart.append(" AND ar_otherbill.FBillStatus = 3 ");
		}
		querySql = buildConditionPart2(ctx, querySql, params);
		return querySql;
	}

	private String buildCostAdjBillQuery(Context ctx, RptParams params) {
		QuerySql costAdjBillSql = new QuerySql();
		costAdjBillSql.aliasName = "costAdjBill";

		costAdjBillSql.selectPart.append(" SELECT ");
		costAdjBillSql.fromPart
		.append(" FROM  T_CL_CostAdjustBillEntry costAdjBillEntry ");
		costAdjBillSql.fromPart
		.append(
		" INNER JOIN T_CL_CostAdjustBill costAdjBill on costAdjBill.FID = costAdjBillEntry.FParentID ")
		.append(this.sp);

		costAdjBillSql.wherePart
		.append(" WHERE costAdjBill.FIssueType = 0 and costAdjBill.FCalculateKind = 1 ");

		buildSelectPart(costAdjBillSql);

		costAdjBillSql.selectPart.append(
		" 0.0 saleQty,costAdjBillEntry.fbaseqty outQty,").append(
				this.sp);
		costAdjBillSql.selectPart.append(
		" 0.0 saleAmount,costAdjBillEntry.factualcost saleCost  ")
		.append(this.sp);

		String fromDate = null;
		String toDate = null;
		if (this.billStatus.equals(SaleReportBillStatusEnum.cal)) {
			String currentOrgId = params.getString("currentOrgId");
			HashMap dateMap = (HashMap) params.getObject("dateByCal");
			if (dateMap != null) {
				HashMap tempMap = (HashMap) dateMap.get(currentOrgId);
				if (tempMap != null) {
					fromDate = (String) tempMap.get("beginDateByCal");
					toDate = (String) tempMap.get("endDateByCal");
				}
			}
		} else {
			fromDate = params.getString("dateStart");
			toDate = params.getString("dateEnd");
		}

		if (fromDate != null)
			costAdjBillSql.wherePart.append(
			" AND costAdjBill.FBizDate >= to_date('").append(
					fromDate.toString()).append("') ");
		if (toDate != null) {
			costAdjBillSql.wherePart.append(
			" AND costAdjBill.FBizDate <= to_date('").append(
					toDate.toString()).append("') ");
		}
		if (fromDate != null) {
			costAdjBillSql.wherePart.append(
			" AND costAdjBillEntry.FBizDate >= to_date('").append(
					fromDate.toString()).append("') ");
		}
		if (toDate != null) {
			costAdjBillSql.wherePart.append(
			" AND costAdjBillEntry.FBizDate <= to_date('").append(
					toDate.toString()).append("') ");
		}

		if ((this.billStatus.equals(SaleReportBillStatusEnum.audit))
				|| (this.billStatus.equals(SaleReportBillStatusEnum.cal))) {
			costAdjBillSql.wherePart.append(" AND costAdjBill.FBaseStatus = ")
			.append(4).append(this.sp);
		} else if (this.billStatus.equals(SaleReportBillStatusEnum.unAudit)) {
			costAdjBillSql.wherePart.append(" AND costAdjBill.FBaseStatus = ")
			.append(2).append(this.sp);
		} else
			costAdjBillSql.wherePart.append(" AND costAdjBill.FBaseStatus <> ")
			.append(1).append(this.sp);

		costAdjBillSql = buildConditionPart2(ctx, costAdjBillSql, params);

		return costAdjBillSql.getSql();
	}

	private void buildSelectPart(QuerySql querySql) {
		if ((this.classficationType
				.equals(SaleReportClassificationEnum.material))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.materialPlusCustGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.custGroupPlusMaterial))
								|| (this.classficationType
										.equals(SaleReportClassificationEnum.materialPlusCustomer))
										|| (this.classficationType
												.equals(SaleReportClassificationEnum.customerPlusmaterial))
												|| (this.classficationType
														.equals(SaleReportClassificationEnum.departmentplusmaterial))
														|| (this.classficationType
																.equals(SaleReportClassificationEnum.customerPlusMaterPerson))) {
			if (querySql.aliasName.equalsIgnoreCase("AR")) {
				querySql.selectPart
				.append(" case when ar_entry.fmaterialID is not null then material.fid else ei.FID end AS fmaterialid,");
				querySql.selectPart
				.append(" case when ar_entry.fmaterialID is not null then material.Fnumber else ei.Fnumber end AS fmaterialNum,");
				querySql.selectPart
				.append(" case when ar_entry.fmaterialID is not null then ");
				querySql.selectPart.append(" material.fname_").append(
						this.locString).append(" else ei.FName_").append(
								this.locString).append(" end AS fmaterialName,");
				querySql.selectPart
				.append(
				" case when ar_entry.fmaterialID is not null then material.fshortname else  ei.FName_")
				.append(this.locString).append(
				" end as fmaterialShortName, ");
				if (this.isAssistSum)
					querySql.selectPart.append(
					" material.Fmodel,assistProperty.FName_").append(
							this.locString).append(
							" AS FassistPropertyName,mmUnit.FQtyPrecision,")
							.append(this.sp);
				else {
					querySql.selectPart.append(
					" material.Fmodel,mmUnit.FQtyPrecision,").append(
							this.sp);
				}
				querySql.selectPart
				.append(
				" case when ar_entry.fmaterialID is not null then baseUnit.fname_")
				.append(this.locString).append(" else unit.FName_")
				.append(this.locString).append(" end AS baseUnitName,");
				if (this.isAssistSum) {
					querySql.otherPart1
					.append("fmaterialid,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
					querySql.otherPartAlias1
					.append("fmaterialid,max(fmaterialNum) fmaterialNum,max(fmaterialName) fmaterialName,max(fmaterialShortName) fmaterialShortName,max(Fmodel) Fmodel,FassistPropertyName,FQtyPrecision,max(baseUnitName) baseUnitName,");
					querySql.groupPart
					.append("fmaterialid,FassistPropertyName,FQtyPrecision,");
				} else {
					querySql.otherPart1
					.append("fmaterialid,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
					querySql.otherPartAlias1
					.append("fmaterialid,max(fmaterialNum) fmaterialNum,max(fmaterialName) fmaterialName,max(fmaterialShortName) fmaterialShortName,max(Fmodel) Fmodel,FQtyPrecision,max(baseUnitName) baseUnitName,");
					querySql.groupPart.append("fmaterialid,FQtyPrecision,");
				}

				querySql.selectPart
				.append(
				" case when ar_entry.fmaterialID is not null then baseUnit.fname_")
				.append(this.locString);
				querySql.selectPart.append(" else unit.FName_").append(
						this.locString).append(
						" end AS statUnitName, -1.0 as FBaseConvsRate, ");
				querySql.otherPart1
				.append(" statUnitName, to_decimal(FBaseConvsRate,21,8) FBaseConvsRate, ");
				querySql.otherPartAlias1
				.append(" max(statUnitName) statUnitName, to_decimal(FBaseConvsRate,21,8) FBaseConvsRate, ");
				querySql.groupPart.append("FBaseConvsRate,");
				appendTable(querySql, "t_bd_material");
				appendTable(querySql, "T_SCM_ExpenseItem");
				appendTable(querySql, "T_BD_MultiMeasureUnit");
			} else {
				querySql.selectPart
				.append(
				" material.fid fmaterialid,material.Fnumber fmaterialNum,material.fname_")
				.append(this.locString);
				if (this.isAssistSum)
					querySql.selectPart
					.append(
					" as fmaterialName,material.FShortName fmaterialShortName,material.Fmodel,assistProperty.FName_")
					.append(this.locString)
					.append(
					" AS FassistPropertyName,mmUnit.FQtyPrecision,baseUnit.Fname_")
					.append(this.locString);
				else {
					querySql.selectPart
					.append(
					" as fmaterialName,material.FShortName fmaterialShortName,material.Fmodel,mmUnit.FQtyPrecision,baseUnit.Fname_")
					.append(this.locString);
				}

				querySql.selectPart.append(" as baseUnitName, ")
				.append(this.sp);
				if (this.isAssistSum) {
					querySql.otherPart1
					.append("fmaterialid,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
					querySql.otherPartAlias1
					.append("fmaterialid,max(fmaterialNum) fmaterialNum,max(fmaterialName) fmaterialName,max(fmaterialShortName) fmaterialShortName,max(Fmodel) Fmodel,FassistPropertyName,FQtyPrecision,max(baseUnitName) baseUnitName,");
					querySql.groupPart
					.append("fmaterialid,FassistPropertyName,FQtyPrecision,");
				} else {
					querySql.otherPart1
					.append("fmaterialid,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
					querySql.otherPartAlias1
					.append("fmaterialid,max(fmaterialNum) fmaterialNum,max(fmaterialName) fmaterialName,max(fmaterialShortName) fmaterialShortName,max(Fmodel) Fmodel,FQtyPrecision,max(baseUnitName) baseUnitName,");
					querySql.groupPart.append("fmaterialid,FQtyPrecision,");
				}

				querySql.selectPart.append(" baseUnit.Fname_").append(
						this.locString).append(
						" as statUnitName,-1.0 as FBaseConvsRate,");
				querySql.otherPart1
				.append(" statUnitName, to_decimal(FBaseConvsRate,21,8) FBaseConvsRate, ");
				querySql.otherPartAlias1
				.append(" max(statUnitName) statUnitName, to_decimal(FBaseConvsRate,21,8) FBaseConvsRate, ");
				querySql.groupPart.append("FBaseConvsRate,");
				appendTable(querySql, "t_bd_material");
				appendTable(querySql, "T_BD_MultiMeasureUnit");
			}
		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.customer))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.customerPlusMaterGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.materGroupPlusCustomer))
								|| (this.classficationType
										.equals(SaleReportClassificationEnum.customerPlusmaterial))
										|| (this.classficationType
												.equals(SaleReportClassificationEnum.materialPlusCustomer))
												|| (this.classficationType
														.equals(SaleReportClassificationEnum.customerPlusMaterPerson))) {
			querySql.selectPart
			.append(
			" customer.Fid fcustomerid,customer.Fnumber fcustomerNumber,customer.FName_")
			.append(this.locString).append(" as fcustomerName,")
			.append(this.sp);
			querySql.otherPart1
			.append("fcustomerid,fcustomerNumber,fcustomerName,");
			querySql.otherPartAlias1
			.append("fcustomerid,max(fcustomerNumber) fcustomerNumber,max(fcustomerName) fcustomerName,");
			querySql.groupPart.append("fcustomerid,");
			appendTable(querySql, "t_bd_customer");
		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.materialGroup))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.materGroupPlusCustomer))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.customerPlusMaterGroup))) {
			querySql.selectPart
			.append(
			"mg.FGroupStandard STDID,mg.Fid FGID,mg.FLevel,mg.FLongNumber,mg.FNumber FGNumber,")
			.append(this.sp);
			querySql.otherPart1
			.append("STDID,FGID,FLevel,FLongNumber,FGNumber,");
			querySql.otherPartAlias1
			.append("max(STDID) STDID,FGID,max(FLevel) FLevel,max(FLongNumber) FLongNumber,max(FGNumber) FGNumber,");
			querySql.groupPart.append("FGID,");
			appendTable(querySql, "t_bd_material");
			appendTable(querySql, "t_bd_MaterialGroupDetial");
			appendTable(querySql, "t_bd_materialgroup");
		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.customerGroup))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.materialPlusCustGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.custGroupPlusMaterial))) {
			querySql.selectPart
			.append(
			" cbg.FCSSPGroupStandardID STDID,cbg.Fid FGID,cbg.FLevel,cbg.FLongNumber,cbg.FNumber FGNumber,")
			.append(this.sp);
			querySql.otherPart1
			.append("STDID,FGID,FLevel,FLongNumber,FGNumber,");
			querySql.otherPartAlias1
			.append("max(STDID) STDID,FGID,max(FLevel) FLevel,max(FLongNumber) FLongNumber,max(FGNumber) FGNumber,");
			querySql.groupPart.append("FGID,");
			appendTable(querySql, "t_bd_customer");
			appendTable(querySql, "t_bd_csspgroup");
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.saleorder)) {
			if (querySql.aliasName.equalsIgnoreCase("SALEISSUE")) {
				querySql.selectPart
				.append(" im_entry1.FSaleOrderNumber fsoNumber,");
				querySql.wherePart.append(" AND im_entry1.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
			} else if (querySql.aliasName.equalsIgnoreCase("AP")) {
				querySql.selectPart
				.append(" ap_entry1.FCoreBillNumber  fsoNumber,");
				querySql.wherePart.append(" AND ap_entry1.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
			} else if (querySql.aliasName.equalsIgnoreCase("AR")) {
				querySql.selectPart
				.append(" ar_entry.FCoreBillNumber  fsoNumber,");
				querySql.wherePart.append(" AND ar_entry.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
			}

			querySql.otherPart1.append(" fsoNumber,");
			querySql.otherPartAlias1.append(" fsoNumber,");
			querySql.groupPart.append("fsoNumber,");
		}
		if (this.classficationType
				.equals(SaleReportClassificationEnum.salecontract)) {
			querySql.otherPart1.append(" fscNumber,");
			querySql.otherPartAlias1.append(" fscNumber,");
			querySql.groupPart.append("fscNumber,");
			querySql.selectPart.append(" soEntry.FSourceBillNumber fscNumber,");
			querySql.tables.add("T_SD_SaleOrderEntry");

			if (querySql.aliasName.equalsIgnoreCase("SALEISSUE")) {
				querySql.wherePart.append(" AND im_entry1.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
				querySql.fromPart
				.append(
				" INNER JOIN T_SD_SaleOrderEntry soEntry ON im_entry1.FSaleOrderEntryID = soEntry.FID ")
				.append(this.sp);
			} else if (querySql.aliasName.equalsIgnoreCase("AP")) {
				querySql.wherePart.append(" AND ap_entry1.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-010bc0a812fd463ED552")
				.append("' ").append(this.sp);
				querySql.fromPart
				.append(
				" INNER JOIN T_SM_PurOrderEntry soEntry ON ap_entry1.FCoreBillEntryId = soEntry.FID ")
				.append(this.sp);
			} else if (querySql.aliasName.equalsIgnoreCase("AR")) {
				querySql.wherePart.append(" AND ar_entry.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
				querySql.fromPart
				.append(
				" INNER JOIN T_SD_SaleOrderEntry soEntry ON ar_entry.FCoreBillEntryId = soEntry.FID ")
				.append(this.sp);
			}
			querySql.wherePart.append(" AND soEntry.FSourceBillTypeID = '")
			.append("DEZBNUYZRM6ieHZ5GGlRc0Y+1VI=").append("' ")
			.append(this.sp);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.departmentplusmaterial)) {
			querySql.selectPart.append(
			"adminunit.fid fadminunitid,adminunit.FName_").append(
					this.locString).append(" as fadminunitName,").append(
							this.sp);
			querySql.otherPart1.append("fadminunitid,fadminunitName,");
			querySql.otherPartAlias1
			.append("fadminunitid,max(fadminunitName) fadminunitName,");
			querySql.groupPart.append("fadminunitid,");
			appendTable(querySql, "T_ORG_Admin");
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterPerson)) {
			querySql.selectPart.append("salePerson.fid fSalePersonid");
			querySql.selectPart.append(",salePerson.FNumber fSalePersonNum");
			querySql.selectPart.append(",salePerson.FName_").append(
					this.locString).append(" as fSalePersonName,").append(
							this.sp);
			querySql.otherPart1
			.append("fSalepersonid,fSalePersonNum,fSalePersonName,");
			querySql.otherPartAlias1
			.append("fSalepersonid,max(fSalePersonNum) fSalePersonNum,max(fSalePersonName) fSalePersonName,");
			querySql.groupPart.append("fSalepersonid,");
			appendTable(querySql, "T_BD_Person");
		}

		if (this.tempColsForSelect == null) {
			this.tempColsForSelect = querySql.otherPart1.toString().substring(
					0, querySql.otherPart1.lastIndexOf(","));
		}
		if (this.tempColsForGroup == null) {
			this.tempColsForGroup = querySql.otherPartAlias1.toString()
			.substring(0, querySql.otherPartAlias1.lastIndexOf(","));
		}
		if (this.groupCols == null)
			this.groupCols = querySql.groupPart.toString().substring(0,
					querySql.groupPart.lastIndexOf(","));
		querySql.groupPart.setLength(0);
	}

	private String buildApCost(Context ctx, RptParams params) {
		QuerySql costApSql = new QuerySql();
		costApSql.aliasName = "AP";
		costApSql.selectPart.append(" SELECT ");
		costApSql.fromPart.append(" FROM t_ap_otherbillentry  ap_entry1 ")
		.append(this.sp);
		costApSql.fromPart
		.append(
		" INNER JOIN t_ap_otherbill ap_other1 on ap_other1.FID = ap_entry1.FParentID ")
		.append(this.sp);

		costApSql.wherePart.append(" WHERE  ap_other1.FBizTypeID = '").append(
		"d8e80652-010b-1001-e000-04c5c0a812202407435C").append("' ");
		buildSelectPart(costApSql);
		costApSql.selectPart.append(" 0.0 saleQty,ap_entry1.fbaseqty outQty,")
		.append("0.0 saleAmount,ap_entry1.famountlocal saleCost  ")
		.append(this.sp);
		String fromDate = params.getString("dateStart");
		String toDate = params.getString("dateEnd");

		if (fromDate != null) {
			costApSql.wherePart.append(" AND ap_other1.FBizDate >= to_date('")
			.append(fromDate).append("') ").append(this.sp);
		}
		if (toDate != null) {
			costApSql.wherePart.append(" AND ap_other1.FBizDate <= to_date('")
			.append(toDate).append("') ").append(this.sp);
		}

		if (fromDate != null) {
			costApSql.wherePart.append(" AND ap_entry1.FBillDate >= to_date('")
			.append(fromDate).append("') ").append(this.sp);
		}
		if (toDate != null) {
			costApSql.wherePart.append(" AND ap_entry1.FBillDate <= to_date('")
			.append(toDate).append("') ").append(this.sp);
		}

		if ((this.billStatus.equals(SaleReportBillStatusEnum.audit))
				|| (this.billStatus.equals(SaleReportBillStatusEnum.cal)))
			costApSql.wherePart.append(" AND ap_other1.FBillStatus = ").append(
					3);
		else if (this.billStatus.equals(SaleReportBillStatusEnum.unAudit))
			costApSql.wherePart.append(" AND ap_other1.FBillStatus = ").append(
					2);
		else {
			costApSql.wherePart.append(" AND ap_other1.FBillStatus <> ")
			.append(1);
		}
		costApSql = buildConditionPart2(ctx, costApSql, params);
		return costApSql.getSql();
	}

	private String buildImCost(Context ctx, RptParams params) {
		QuerySql costImSql = new QuerySql();
		costImSql.aliasName = "SALEISSUE";
		String qtyColumn = "";
		String amountColumn = "";
		String fromDate = params.getString("dateStart");
		String toDate = params.getString("dateEnd");
		String periodYear = params.getString("periodYear");
		String periodYearTo = params.getString("periodYearTo");
		String periodMonth = params.getString("periodMonth");
		String periodMonthTo = params.getString("periodMonthTo");

		if (this.billStatus.equals(SaleReportBillStatusEnum.cal)) {
			qtyColumn = "cl_entry1.FCurrWrittenOffQty";
			amountColumn = "cl_entry1.FCurrWrittenOffAmount";
		} else {
			qtyColumn = "im_entry1.fbaseqty";
			amountColumn = "im_entry1.factualcost";
		}

		String saleQtyColumn = " 0.0 ";
		String saleAmountloc = " 0.0 ";
		if (this.isFromOUTSTORE) {
			saleQtyColumn = " im_entry1.fbaseqty ";

			saleAmountloc = " im_entry1.FLocalNonTaxAmount ";
		}
		costImSql.selectPart.append(" SELECT ");

		if (!(this.billStatus.equals(SaleReportBillStatusEnum.cal))) {
			costImSql.fromPart.append(" FROM t_im_saleissueentry im_entry1 ");
			costImSql.fromPart
			.append(
			" INNER JOIN T_IM_SaleIssueBill im_saleissue1 on im_saleissue1.FID = im_entry1.FParentID ")
			.append(this.sp);
		} else {
			costImSql.fromPart
			.append(" FROM  T_CL_WriteOffRecord cl_entry1   ").append(
					this.sp);
			costImSql.fromPart
			.append(
			" INNER JOIN T_CL_WriteOffGroup cl_writeoff1 on cl_entry1.FParentID = cl_writeoff1.FID  ")
			.append(this.sp);
			costImSql.fromPart
			.append(
			" INNER JOIN t_im_saleissueentry im_entry1 on im_entry1.FID = cl_entry1.FBillEntryID")
			.append(this.sp);
			costImSql.fromPart
			.append(
			" INNER JOIN T_IM_SaleIssueBill im_saleissue1 on im_saleissue1.FID = im_entry1.FParentID ")
			.append(this.sp);
		}
		costImSql.wherePart.append(" WHERE 1=1 ");
		buildSelectPart(costImSql);
		costImSql.selectPart.append(saleQtyColumn).append(" saleQty,").append(
				qtyColumn).append(" outQty,").append(this.sp);
		costImSql.selectPart.append(saleAmountloc).append(" saleAmount,")
		.append(amountColumn).append(" saleCost  ").append(this.sp);

		if (!(this.billStatus.equals(SaleReportBillStatusEnum.cal))) {
			if (fromDate != null) {
				costImSql.wherePart.append(
				" AND im_saleissue1.FBizDate >= to_date('").append(
						fromDate).append("') ");
			}
			if (toDate != null) {
				costImSql.wherePart.append(
				" AND im_saleissue1.FBizDate <= to_date('").append(
						toDate).append("') ");
			}

			if (fromDate != null) {
				costImSql.wherePart.append(
				" AND im_entry1.FBizDate >= to_date('")
				.append(fromDate).append("') ");
			}
			if (toDate != null) {
				costImSql.wherePart.append(
				" AND im_entry1.FBizDate <= to_date('").append(toDate)
				.append("') ");
			}
		}

		if ((this.bizType.equals(SaleReportBizTypeEnum.consignSale))
				|| (this.bizType.equals(SaleReportBizTypeEnum.generalSale))) {
			costImSql.fromPart
			.append("INNER JOIN T_SCM_TransactionType t12 ON im_saleissue1.FTransactionTypeID = t12.FID ");

			if (this.bizType.equals(SaleReportBizTypeEnum.consignSale)) {
				costImSql.wherePart.append(" AND im_saleissue1.fbiztypeid = '");
				costImSql.wherePart.append(
				"d8e80652-0113-1000-e000-04c5c0a812202407435C").append(
				"' ").append(this.sp);

				costImSql.wherePart.append(" AND t12.FRITypeID='").append(
						RecIssueTypeConstant.SALEOUT_RITYPEID).append("'")
						.append(this.sp);
			} else if (this.bizType.equals(SaleReportBizTypeEnum.generalSale)) {
				costImSql.wherePart
				.append(" AND im_saleissue1.fbiztypeid in ('");
				costImSql.wherePart.append(
				"d8e80652-010e-1000-e000-04c5c0a812202407435C").append(
				"', '");
				costImSql.wherePart.append(
				"d8e80652-0110-1000-e000-04c5c0a812202407435C").append(
				"', '");
				costImSql.wherePart.append("wIZPS7oOQaOl1CeE/8cZOSQHQ1w=")
				.append("', '");
				costImSql.wherePart.append("7eD9TwIyTMmt7ELiDSC65CQHQ1w=")
				.append("')");
				costImSql.wherePart.append(this.sp);
			}

		}

		if (this.bizType.equals(SaleReportBizTypeEnum.all)) {
			costImSql.fromPart
			.append("INNER JOIN T_SCM_TransactionType t12 ON im_saleissue1.FTransactionTypeID = t12.FID ");
			costImSql.wherePart.append(" AND ((t12.FID NOT IN ");
			costImSql.wherePart
			.append("  (SELECT FID FROM T_SCM_TransactionType transType WHERE ");
			costImSql.wherePart.append("      t12.FRITypeID='").append(
					RecIssueTypeConstant.CONSIGNOUT_RITYPEID).append("'");
			costImSql.wherePart.append("   OR t12.FRITypeID='").append(
					RecIssueTypeConstant.CONSIGNRT_RITYPEID).append("')")
					.append(this.sp);

			costImSql.wherePart.append(")) ");
		}

		if (this.billStatus.equals(SaleReportBillStatusEnum.cal)) {
			if (fromDate != null) {
				costImSql.wherePart.append(
				" AND cl_writeoff1.FWriteOffDate >=to_date('").append(
						fromDate.toString()).append("') ").append(this.sp);
			}
			if (toDate != null) {
				costImSql.wherePart.append(
				" AND cl_writeoff1.FWriteOffDate <= to_date('").append(
						toDate.toString()).append("') ").append(this.sp);
			}
			costImSql.wherePart.append(" AND ( ");
			costImSql.wherePart.append(" (cl_writeoff1.FWriteOffYear > ")
			.append(Integer.valueOf(periodYear));
			costImSql.wherePart.append("   AND cl_writeoff1.FWriteOffYear < ")
			.append(Integer.valueOf(periodYearTo)).append(")");
			costImSql.wherePart.append(" OR ( cl_writeoff1.FWriteOffYear >= ")
			.append(Integer.valueOf(periodYear));
			costImSql.wherePart.append("   AND cl_writeoff1.FWriteOffYear < ")
			.append(Integer.valueOf(periodYearTo));
			costImSql.wherePart.append(
			"   AND cl_writeoff1.FWriteOffPeriod >= ").append(
					new StringBuilder().append(Integer.valueOf(periodMonth))
					.append(")").toString());
			costImSql.wherePart.append(" OR ( cl_writeoff1.FWriteOffYear > ")
			.append(Integer.valueOf(periodYear));
			costImSql.wherePart.append("   AND cl_writeoff1.FWriteOffYear <= ")
			.append(Integer.valueOf(periodYearTo));
			costImSql.wherePart.append(
			"   AND cl_writeoff1.FWriteOffPeriod <= ").append(
					new StringBuilder().append(Integer.valueOf(periodMonthTo))
					.append(")").toString());
			costImSql.wherePart.append(" OR ( cl_writeoff1.FWriteOffYear = ")
			.append(Integer.valueOf(periodYear));
			costImSql.wherePart.append("   AND cl_writeoff1.FWriteOffYear = ")
			.append(Integer.valueOf(periodYearTo));
			costImSql.wherePart.append(
			"   AND cl_writeoff1.FWriteOffPeriod <= ").append(
					Integer.valueOf(periodMonthTo));
			costImSql.wherePart.append(new StringBuilder().append(
			"   AND cl_writeoff1.FWriteOffPeriod >= ").append(
					Integer.valueOf(periodMonth)).append(")").toString());
			costImSql.wherePart.append("    )");
		} else if (this.billStatus.equals(SaleReportBillStatusEnum.audit)) {
			costImSql.wherePart.append(" AND im_saleissue1.FBaseStatus = ")
			.append(4).append(this.sp);
		} else if (this.billStatus.equals(SaleReportBillStatusEnum.unAudit)) {
			costImSql.wherePart.append(" AND im_saleissue1.FBaseStatus = ")
			.append(2).append(this.sp);
		} else {
			StringBuffer status = new StringBuffer();
			status.append(4).append(",");
			status.append(2);
			costImSql.wherePart.append(" AND im_saleissue1.FBaseStatus IN (")
			.append(status.toString()).append(")");
		}

		costImSql = buildConditionPart2(ctx, costImSql, params);
		return costImSql.getSql();
	}

	private QuerySql buildConditionPart2(Context ctx, QuerySql querySql,
			RptParams params) {
		if (params.getObject("customerClassfiled") != null) {
			querySql.wherePart.append(" AND csss.fname_")
			.append(this.locString).append(" = '").append(
					params.getObject("customerClassfiled").toString()
					.trim()).append("'").append(this.sp);
			appendTable(querySql, "T_BD_CSSPGroupStandard");
		}

		if ((params.getObject("materialFrom") != null)
				&& (!(params.getObject("materialFrom").toString().trim()
						.equals("")))) {
			querySql.wherePart.append(" AND material.FNumber >= '").append(
					params.getObject("materialFrom").toString().trim()).append(
					"'").append(this.sp);
			appendTable(querySql, "t_bd_material");
		}
		if ((params.getObject("materialTo") != null)
				&& (!(params.getObject("materialTo").toString().trim()
						.equals("")))) {
			querySql.wherePart.append(" AND material.FNumber <= '").append(
					params.getObject("materialTo").toString().trim()).append(
					"'").append(this.sp);
			appendTable(querySql, "t_bd_material");
		}
		if ((params.getObject("shortNameFrom") != null)
				&& (!(params.getObject("shortNameFrom").toString().trim()
						.equals("")))) {
			String shortNameFrom = (String) params.getObject("shortNameFrom");
			if (shortNameFrom.indexOf("'") != -1) {
				shortNameFrom = shortNameFrom.replaceAll("'", "''");
			}
			querySql.wherePart.append(" AND material.FShortName >= '").append(
					shortNameFrom.trim()).append("'").append(this.sp);
			appendTable(querySql, "t_bd_material");
		}
		if ((params.getObject("shortNameTo") != null)
				&& (!(params.getObject("shortNameTo").toString().trim()
						.equals("")))) {
			String shortNameTo = (String) params.getObject("shortNameTo");
			if (shortNameTo.indexOf("'") != -1) {
				shortNameTo = shortNameTo.replaceAll("'", "''");
			}
			querySql.wherePart.append(" AND material.FShortName <= '").append(
					shortNameTo).append("'").append(this.sp);
			appendTable(querySql, "t_bd_material");
		}

		if (((params.getObject("materialGroupFrom") != null) && (!(params
				.getObject("materialGroupFrom").toString().trim().equals(""))))
				|| ((params.getObject("materialGroupTo") != null) && (!(params
						.getObject("materialGroupTo").toString().trim()
						.equals(""))))) {
			appendTable(querySql, "t_bd_material");
			appendTable(querySql, "t_bd_MaterialGroupDetial");
			appendTable(querySql, "t_bd_materialgroup");
			querySql.wherePart.append(getMaterialTypeWhere(ctx, params));
		}

		if ((((this.classficationType
				.equals(SaleReportClassificationEnum.materGroupPlusCustomer))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.customerPlusMaterGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.materialGroup))
								|| ((params.getObject("materialGroupFrom") != null) && (!(params
										.getObject("materialGroupFrom").toString().trim()
										.equals("")))) || ((params.getObject("materialGroupTo") != null) && (!(params
												.getObject("materialGroupTo").toString().trim().equals(""))))))
												&& (params.getObject("materialClassfiled") != null)) {
			querySql.wherePart.append(" AND mas.fname_l2= '").append(
					params.getObject("materialClassfiled").toString().trim())
					.append("'").append(this.sp);
			appendTable(querySql, "T_BD_MaterialGroupStandard");
		}

		if ((params.getObject("customerFrom") != null)
				&& (!(params.getObject("customerFrom").toString().trim()
						.equals("")))) {
			querySql.wherePart.append(" AND customer.FNumber >='").append(
					params.getObject("customerFrom").toString().trim()).append(
					"'").append(this.sp);
			appendTable(querySql, "t_bd_customer");
		}
		if ((params.getObject("customerTo") != null)
				&& (!(params.getObject("customerTo").toString().trim()
						.equals("")))) {
			querySql.wherePart.append(" AND customer.FNumber <='").append(
					params.getObject("customerTo").toString().trim()).append(
					"'").append(this.sp);
			appendTable(querySql, "t_bd_customer");
		}
		if ((params.getObject("customerGroupFrom") != null)
				&& (!(params.getObject("customerGroupFrom").toString().trim()
						.equals("")))) {
			querySql.wherePart.append(" AND cbg.FNumber >= '").append(
					params.getObject("customerGroupFrom").toString().trim())
					.append("'").append(this.sp);
			appendTable(querySql, "t_bd_customer");
			appendTable(querySql, "t_bd_csspgroup");
		}
		if ((params.getObject("customerGroupTo") != null)
				&& (!(params.getObject("customerGroupTo").toString().trim()
						.equals("")))) {
			querySql.wherePart.append(" AND cbg.FNumber <='").append(
					params.getObject("customerGroupTo").toString().trim())
					.append("'").append(this.sp);
			appendTable(querySql, "t_bd_customer");
			appendTable(querySql, "t_bd_csspgroup");
		}

		if (this.isBySaleOrg) {
			querySql.wherePart.append(" AND saleOrg.FID IN (").append(
					this.saleOrgIDs).append(") ").append(this.sp);
			appendTable(querySql, "t_org_baseUnit");
		} else if ((this.billStatus.equals(SaleReportBillStatusEnum.cal))
				&& (params.containsKey("currentOrgId"))) {
			String currentOrgId = params.getString("currentOrgId");
			querySql.wherePart.append(" AND companyOrg.FID IN (").append(
					currentOrgId).append(") ").append(this.sp);
			appendTable(querySql, "t_org_Company");
		} else {
			querySql.wherePart.append(" AND companyOrg.FID IN (").append(
					this.companyOrgIDs).append(") ").append(this.sp);
			appendTable(querySql, "t_org_Company");
		}

		if (!(querySql.aliasName.equalsIgnoreCase("costAdjBill"))) {
			if ((params.getObject("saleGroupFrom") != null)
					&& (!(params.getObject("saleGroupFrom").toString().trim()
							.equals("")))) {
				querySql.wherePart.append(" AND saleGroup.FNumber >='").append(
						params.getObject("saleGroupFrom").toString().trim())
						.append("'").append(this.sp);
				appendTable(querySql, "t_bd_salegroup");
			}
			if ((params.getObject("saleGroupTo") != null)
					&& (!(params.getObject("saleGroupTo").toString().trim()
							.equals("")))) {
				querySql.wherePart.append(" AND saleGroup.FNumber <='").append(
						params.getObject("saleGroupTo").toString().trim())
						.append("'").append(this.sp);
				appendTable(querySql, "t_bd_salegroup");
			}
			if ((params.getObject("salePersonFrom") != null)
					&& (!(params.getObject("salePersonFrom").toString().trim()
							.equals("")))) {
				querySql.wherePart.append(" AND salePerson.FNumber >='")
				.append(
						params.getObject("salePersonFrom").toString()
						.trim()).append("'").append(this.sp);
				appendTable(querySql, "t_bd_saleperson");
			}
			if ((params.getObject("salePersonTo") != null)
					&& (!(params.getObject("salePersonTo").toString().trim()
							.equals("")))) {
				querySql.wherePart.append(" AND salePerson.FNumber <='")
				.append(
						params.getObject("salePersonTo").toString()
						.trim()).append("'").append(this.sp);
				appendTable(querySql, "t_bd_saleperson");
			}
		}

		if ((new Integer(params.getString("CustomerType")).intValue() == 2)
				&& (querySql.tables.contains("t_im_saleissuebill"))) {
			querySql.wherePart
			.append(" AND im_saleissue1.FTransactionTypeID <>'wxI1pBHYRwCcMmgJoF8w5rAI3Kc=' ");
		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.material))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.materialPlusCustGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.custGroupPlusMaterial))
								|| (this.classficationType
										.equals(SaleReportClassificationEnum.materialPlusCustomer))
										|| (this.classficationType
												.equals(SaleReportClassificationEnum.customerPlusmaterial))
												|| (this.classficationType
														.equals(SaleReportClassificationEnum.departmentplusmaterial))
														|| (this.classficationType
																.equals(SaleReportClassificationEnum.customerPlusMaterPerson))) {
			appendTable(querySql, "T_BD_AsstAttrValue");
		}
		return querySql;
	}

	private String getMaterialTypeWhere(Context ctx, RptParams params) {
		StringBuffer sqlWhere = new StringBuffer();

		String materialTypeFrom = null;
		String materialTypeTo = null;
		if (params.getObject("materialGroupFrom") != null) {
			materialTypeFrom = params.getObject("materialGroupFrom").toString()
			.trim();
		}

		if (params.getObject("materialGroupTo") != null) {
			materialTypeTo = params.getObject("materialGroupTo").toString()
			.trim();
		}

		if ((materialTypeFrom != null) || (materialTypeTo != null)) {
			StringBuffer sql2 = new StringBuffer();
			StringBuffer sql22 = new StringBuffer();
			sql2.append("select flongnumber from t_bd_materialGroup where ");
			if (materialTypeFrom != null) {
				sql2.append("fnumber >= '").append(materialTypeFrom).append(
				"' ");
				sql22.append(" mg.fnumber >= '").append(materialTypeFrom)
				.append("' ");
			}
			if (materialTypeTo != null) {
				if (materialTypeFrom != null) {
					sql2.append("and ");
					sql22.append("and ");
				}
				sql2.append("fnumber <= '").append(materialTypeTo).append("' ");
				sql22.append("mg.fnumber <= '").append(materialTypeTo).append(
				"' ");
			}
			try {
				RptRowSet rs = executeQuery(sql2.toString(), null, ctx);

				StringBuffer sql3 = new StringBuffer();
				int count = 0;
				while (rs.next()) {
					if (count > 0) {
						sql3.append(" or ");
					}
					sql3.append(" (mg.flongnumber = '").append(
							rs.getString("flongnumber")).append("' ");
					sql3.append("or mg.flongnumber like '").append(
							rs.getString("flongnumber")).append("!%') ");
					++count;
				}

				if (count > 0) {
					if (count < 30)
						sqlWhere.append(" and (").append(sql3).append(") ");
					else
						sqlWhere.append(" and (").append(sql22).append(") ");
				} else
					sqlWhere.append(" and 1 = 2 ");
			} catch (BOSException e) {
				logger.error(e);
			}
		}

		return sqlWhere.toString();
	}

	private void appendTable(QuerySql querySql, String tableName) {
		if (tableName.equalsIgnoreCase("T_SCM_ExpenseItem")) {
			if (!(querySql.tables.contains("T_SCM_ExpenseItem"))) {
				querySql.tables.add("T_SCM_ExpenseItem");
				querySql.fromPart
				.append(
				" LEFT OUTER JOIN T_SCM_ExpenseItem ei on ei.fid = ar_entry.fexpenseitemid ")
				.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("t_bd_material")) {
			if (!(querySql.tables.contains("t_bd_material"))) {
				querySql.tables.add("t_bd_material");

				if (querySql.aliasName.equals("AR"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN t_bd_material material on material.fid = ar_entry.fmaterialID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("AP"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN t_bd_material material on material.fid = ap_entry1.fmaterialID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("SALEISSUE"))
					querySql.fromPart
					.append(
					" INNER JOIN t_bd_material material on material.fid = im_entry1.fmaterialID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("costAdjBill"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN t_bd_material material on material.fid = costAdjBillEntry.fmaterialID ")
					.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("T_BD_AsstAttrValue")) {
			if (!(querySql.tables.contains("T_BD_AsstAttrValue"))) {
				querySql.tables.add("T_BD_AsstAttrValue");
				if (querySql.aliasName.equals("AR"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN T_BD_AsstAttrValue assistProperty on assistProperty.fid = ar_entry.fassistPropertyID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("AP"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN T_BD_AsstAttrValue assistProperty on assistProperty.fid = ap_entry1.fassistPropertyID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("SALEISSUE"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN T_BD_AsstAttrValue assistProperty on assistProperty.fid = im_entry1.fassistPropertyID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("costAdjBill"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN T_BD_AsstAttrValue assistProperty on assistProperty.fid = costAdjBillEntry.fassistPropertyID ")
					.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("T_BD_MultiMeasureUnitNull")) {
			if (!(querySql.tables.contains("T_BD_MultiMeasureUnitNull"))) {
				querySql.tables.add("t_bd_material");
				if (querySql.aliasName.equals("AR")) {
					querySql.fromPart
					.append(" LEFT OUTER JOIN t_bd_measureUnit baseUnit ");
					querySql.fromPart.append(
					"on material.FBaseUnit = baseUnit.FID ").append(
							this.sp);
					querySql.fromPart
					.append(" LEFT OUTER JOIN T_BD_MultiMeasureUnit mmUnit ");
					querySql.fromPart
					.append(" on ar_entry.fmaterialID =  mmUnit.FMaterialID ");
					querySql.fromPart.append(
					" AND baseUnit.FID = mmUnit.FMeasureUnitID ")
					.append(this.sp);
					querySql.fromPart
					.append(
					" left outer join T_BD_MeasureUnit unit on unit.fid = ar_entry.FMeasureUnitID ")
					.append(this.sp);
				} else if (querySql.aliasName.equals("AP")) {
					querySql.fromPart
					.append(
					" inner join t_bd_measureUnit baseUnit on material.FBaseUnit = baseUnit.FID ")
					.append(this.sp);
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_MultiMeasureUnit mmUnit on ap_entry1.fmaterialID =  mmUnit.FMaterialID AND baseUnit.FID = mmUnit.FMeasureUnitID ")
					.append(this.sp);
				} else if (querySql.aliasName.equals("SALEISSUE")) {
					querySql.fromPart
					.append(
					" inner join t_bd_measureUnit baseUnit on material.FBaseUnit = baseUnit.FID ")
					.append(this.sp);
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_MultiMeasureUnit mmUnit on im_entry1.fmaterialID =  mmUnit.FMaterialID AND baseUnit.FID = mmUnit.FMeasureUnitID ")
					.append(this.sp);
				} else if (querySql.aliasName.equals("costAdjBill")) {
					querySql.fromPart
					.append(
					" inner join t_bd_measureUnit baseUnit on material.FBaseUnit = baseUnit.FID ")
					.append(this.sp);
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_MultiMeasureUnit mmUnit on costAdjBillEntry.fmaterialID =  mmUnit.FMaterialID AND baseUnit.FID = mmUnit.FMeasureUnitID ")
					.append(this.sp);
				}
			}
		} else if (tableName.equalsIgnoreCase("T_BD_CSSPGroupStandard")) {
			if (!(querySql.tables.contains("T_BD_CSSPGroupStandard"))) {
				querySql.tables.add("T_BD_CSSPGroupStandard");
				querySql.fromPart
				.append(
				" inner  join T_BD_CSSPGroupStandard csss on csss.fid=cbg.FCSSPGroupStandardID")
				.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("T_BD_MaterialGroupStandard")) {
			if (!(querySql.tables.contains("T_BD_MaterialGroupStandard"))) {
				querySql.tables.add("T_BD_MaterialGroupStandard");
				querySql.fromPart
				.append(
				" inner  join T_BD_MaterialGroupStandard mas on mas.fid=mg.FGroupStandard")
				.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("T_BD_MultiMeasureUnit")) {
			if (!(querySql.tables.contains("T_BD_MultiMeasureUnit"))) {
				querySql.tables.add("t_bd_material");
				if (querySql.aliasName.equals("AR")) {
					querySql.fromPart
					.append(" LEFT OUTER JOIN t_bd_measureUnit baseUnit ");
					querySql.fromPart.append(
					"on material.FBaseUnit = baseUnit.FID ").append(
							this.sp);
					querySql.fromPart
					.append(" LEFT OUTER JOIN T_BD_MultiMeasureUnit mmUnit ");
					querySql.fromPart
					.append(" on ar_entry.fmaterialID =  mmUnit.FMaterialID ");
					querySql.fromPart.append(
					" AND baseUnit.FID = mmUnit.FMeasureUnitID ")
					.append(this.sp);

					querySql.fromPart
					.append(
					" left outer join T_BD_MeasureUnit unit on unit.fid = ar_entry.FMeasureUnitID ")
					.append(this.sp);
				} else if (querySql.aliasName.equals("AP")) {
					querySql.fromPart
					.append(
					" inner join t_bd_measureUnit baseUnit on material.FBaseUnit = baseUnit.FID ")
					.append(this.sp);
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_MultiMeasureUnit mmUnit on ap_entry1.fmaterialID =  mmUnit.FMaterialID AND baseUnit.FID = mmUnit.FMeasureUnitID ")
					.append(this.sp);
				} else if (querySql.aliasName.equals("SALEISSUE")) {
					querySql.fromPart
					.append(
					" inner join t_bd_measureUnit baseUnit on material.FBaseUnit = baseUnit.FID ")
					.append(this.sp);
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_MultiMeasureUnit mmUnit on im_entry1.fmaterialID =  mmUnit.FMaterialID AND baseUnit.FID = mmUnit.FMeasureUnitID ")
					.append(this.sp);
				} else if (querySql.aliasName.equals("costAdjBill")) {
					querySql.fromPart
					.append(
					" inner join t_bd_measureUnit baseUnit on material.FBaseUnit = baseUnit.FID ")
					.append(this.sp);
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_MultiMeasureUnit mmUnit on costAdjBillEntry.fmaterialID =  mmUnit.FMaterialID AND baseUnit.FID = mmUnit.FMeasureUnitID ")
					.append(this.sp);
				}
			}
		} else if (tableName.equalsIgnoreCase("t_bd_MaterialGroupDetial")) {
			if (!(querySql.tables.contains("t_bd_MaterialGroupDetial"))) {
				querySql.tables.add("t_bd_MaterialGroupDetial");
				querySql.fromPart
				.append(
				" inner  join t_bd_MaterialGroupDetial mgd on material.fid = mgd.fmaterialid")
				.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("t_bd_materialgroup")) {
			if (!(querySql.tables.contains("t_bd_materialgroup"))) {
				querySql.tables.add("t_bd_materialgroup");
				querySql.fromPart
				.append(
				" inner  join t_bd_materialgroup mg on mgd.FMaterialGroupID = mg.fid ")
				.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("t_bd_customer")) {
			if (!(querySql.tables.contains("t_bd_customer"))) {
				querySql.tables.add("t_bd_customer");

				if ((new Integer(this.params.getString("CustomerType"))
				.intValue() == 1)
				&& (querySql.aliasName.equals("AR"))) {
					querySql.fromPart
					.append(" INNER JOIN t_bd_customer customer ");
					querySql.fromPart
					.append(" on ar_otherbill.FAsstActID = customer.fid ");
					querySql.fromPart.append(this.sp);
				}

				if ((new Integer(this.params.getString("CustomerType"))
				.intValue() == 2)
				&& (querySql.aliasName.equals("AR"))) {
					querySql.fromPart
					.append(" INNER JOIN t_bd_customer customer ");
					querySql.fromPart
					.append(" on ar_entry.FServiceCustomerID = customer.fid ");
					querySql.fromPart.append(this.sp);
				}

				if (new Integer(this.params.getString("CustomerType"))
				.intValue() == 3) {
					if (querySql.aliasName.equals("SALEISSUE")) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on im_entry1.FOrderCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					} else if (querySql.aliasName.equals("AR")) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on ar_entry.FOrderCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					} else if (querySql.aliasName.equals("AP")) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on ap_other1.FAsstActID = customer.fid ");
						querySql.fromPart.append(this.sp);
					} else if (querySql.aliasName.equals("costAdjBill")) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on costAdjBill.FCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					}
				} else if (querySql.aliasName.equals("AP")) {
					querySql.tables.add("T_SM_PURORDER");
					querySql.fromPart.append(
					" INNER JOIN T_SM_PURORDER purOrder ").append(
							this.sp);
					querySql.fromPart
					.append(
					" on purOrder.FNumber = ap_entry1.FCoreBillNumber ")
					.append(this.sp);
					querySql.fromPart.append(
					" inner join T_SM_PURORDERENTRY purentry1 ")
					.append(this.sp);
					querySql.fromPart.append(
					" on purOrder.FID = purentry1.FParentID ").append(
							this.sp);
					querySql.fromPart
					.append(
					" AND purentry1.fid = ap_entry1.fsourcebillentryid ")
					.append(this.sp);
					querySql.fromPart.append(
					" INNER JOIN T_SD_SALEORDER saleOrder ").append(
							this.sp);
					querySql.fromPart
					.append(
					" on saleOrder.fnumber = purentry1.fsourcebillnumber ")
					.append(this.sp);
					querySql.fromPart.append(
					" INNER JOIN T_SD_SALEORDERENTRY soEntry1 ")
					.append(this.sp);
					querySql.fromPart
					.append(
					" on soEntry1.fparentid = saleOrder.fid AND soEntry1.fid = purentry1.fsourcebillentryid")
					.append(this.sp);
					querySql.fromPart.append(this.sp);

					if (new Integer(this.params.getString("CustomerType"))
					.intValue() == 1) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on soEntry1.FReceiveCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					}

					if (new Integer(this.params.getString("CustomerType"))
					.intValue() == 2) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on soEntry1.FDeliveryCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					}

					if (new Integer(this.params.getString("CustomerType"))
					.intValue() == 3) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on saleOrder.FOrderCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					}
				} else if (querySql.aliasName.equals("SALEISSUE")) {
					if (new Integer(this.params.getString("CustomerType"))
					.intValue() == 1) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on im_entry1.FBalanceCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					}

					if (new Integer(this.params.getString("CustomerType"))
					.intValue() == 2) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append(" on im_saleissue1.FCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					}

					if (new Integer(this.params.getString("CustomerType"))
					.intValue() == 3) {
						querySql.fromPart
						.append(" INNER JOIN t_bd_customer customer ");
						querySql.fromPart
						.append("on im_entry1.FOrderCustomerID = customer.fid ");
						querySql.fromPart.append(this.sp);
					}
				} else if (querySql.aliasName.equals("costAdjBill")) {
					querySql.fromPart
					.append(" INNER JOIN t_bd_customer customer ");
					querySql.fromPart
					.append(" on costAdjBill.FCustomerID = customer.fid ");
					querySql.fromPart.append(this.sp);
				}
			}

		} else if (tableName.equalsIgnoreCase("t_bd_csspgroup")) {
			if (!(querySql.tables.contains("t_bd_csspgroup"))) {
				querySql.tables.add("t_bd_csspgroup");
				querySql.fromPart
				.append(
				" INNER JOIN T_BD_CustomerGroupDetail cstD on cstD.FCustomerID = customer.fid")
				.append(this.sp);
				querySql.fromPart
				.append(
				" INNER JOIN t_bd_csspgroup cbg on cstD.FCustomerGroupID = cbg.fid ")
				.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("t_org_baseUnit")) {
			if (!(querySql.tables.contains("t_org_baseUnit"))) {
				querySql.tables.add("t_org_baseUnit");
				if (querySql.aliasName.equals("AR")) {
					querySql.fromPart
					.append(
					" INNER JOIN t_org_baseUnit saleOrg on saleOrg.FID = ar_otherbill.FSaleOrgID")
					.append(this.sp);
				} else if (querySql.aliasName.equals("AP")) {
					if (!(querySql.tables.contains("T_SM_PURORDER"))) {
						querySql.tables.add("T_SM_PURORDER");
						querySql.fromPart.append(
						" INNER JOIN T_SM_PURORDER purOrder ").append(
								this.sp);
						querySql.fromPart
						.append(
						" on purOrder.FNumber = ap_entry1.FCoreBillNumber ")
						.append(this.sp);
						querySql.fromPart.append(
						" inner join T_SM_PURORDERENTRY purentry1 ")
						.append(this.sp);
						querySql.fromPart.append(
						" on purOrder.FID = purentry1.FParentID ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" AND purentry1.fid = ap_entry1.fsourcebillentryid ")
						.append(this.sp);
						querySql.fromPart.append(
						" INNER JOIN T_SD_SALEORDER saleOrder ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" on saleOrder.fnumber = purentry1.fsourcebillnumber ")
						.append(this.sp);
						querySql.fromPart.append(
						" INNER JOIN T_SD_SALEORDERENTRY soEntry1 ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" on soEntry1.fparentid = saleOrder.fid AND soEntry1.fid = purentry1.fsourcebillentryid")
						.append(this.sp);
					}

					querySql.fromPart
					.append(
					" INNER JOIN t_org_baseUnit saleOrg on saleOrg.FID = saleOrder.FSaleOrgUnitID")
					.append(this.sp);
				} else if (querySql.aliasName.equals("SALEISSUE")) {
					querySql.fromPart
					.append(
					" INNER JOIN t_org_baseUnit saleOrg on saleOrg.FID = im_entry1.FSaleOrgUnitID")
					.append(this.sp);
				}
			}
		} else if (tableName.equalsIgnoreCase("t_org_Company")) {
			if (!(querySql.tables.contains("t_org_Company"))) {
				querySql.tables.add("t_org_Company");
				if (querySql.aliasName.equals("AR")) {
					querySql.fromPart
					.append(
					" INNER JOIN t_org_Company companyOrg on companyOrg.FID = ar_otherbill.FCompanyID")
					.append(this.sp);
				} else if (querySql.aliasName.equals("AP")) {
					if (!(querySql.tables.contains("T_SM_PURORDER"))) {
						querySql.tables.add("T_SM_PURORDER");
						querySql.fromPart.append(
						" INNER JOIN T_SM_PURORDER purOrder ").append(
								this.sp);
						querySql.fromPart
						.append(
						" on purOrder.FNumber = ap_entry1.FCoreBillNumber ")
						.append(this.sp);
						querySql.fromPart.append(
						" inner join T_SM_PURORDERENTRY purentry1 ")
						.append(this.sp);
						querySql.fromPart.append(
						" on purOrder.FID = purentry1.FParentID ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" AND purentry1.fid = ap_entry1.fsourcebillentryid ")
						.append(this.sp);
						querySql.fromPart.append(
						" INNER JOIN T_SD_SALEORDER saleOrder ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" on saleOrder.fnumber = purentry1.fsourcebillnumber ")
						.append(this.sp);
						querySql.fromPart.append(
						" INNER JOIN T_SD_SALEORDERENTRY soEntry1 ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" on soEntry1.fparentid = saleOrder.fid AND soEntry1.fid = purentry1.fsourcebillentryid")
						.append(this.sp);
					}

					querySql.fromPart
					.append(
					" INNER JOIN t_org_Company companyOrg on companyOrg.FID = saleOrder.FCompanyOrgUnitID")
					.append(this.sp);
				} else if (querySql.aliasName.equals("SALEISSUE")) {
					querySql.fromPart
					.append(
					" INNER JOIN t_org_Company companyOrg on companyOrg.FID = im_entry1.FCompanyOrgUnitID")
					.append(this.sp);
				} else {
					if (!(querySql.aliasName.equals("costAdjBill")))
						return;
					querySql.fromPart
					.append("LEFT OUTER JOIN T_ORG_UnitRelation orgRe ON orgRe.FFromUnitID = costAdjBill.FStorageOrgUnitID ");
					querySql.fromPart.append(
					"     AND orgRe.FTypeRelationID = '").append(
					"00000000-0000-0000-0000-0000000000070FE9F8B5")
					.append("' ").append(this.sp);
					querySql.fromPart
					.append(
					"inner join t_org_Company companyOrg on orgRe.FToUnitID = companyOrg.FID  ")
					.append(this.sp);
				}
			}

		} else if (tableName.equalsIgnoreCase("t_bd_salegroup")) {
			if (!(querySql.tables.contains("t_bd_salegroup"))) {
				querySql.tables.add("t_bd_salegroup");
				if (querySql.aliasName.equals("AR")) {
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_SaleGroup saleGroup on saleGroup.fid = ar_otherbill.FSaleGroupID")
					.append(this.sp);
				} else if (querySql.aliasName.equals("AP")) {
					if (querySql.fromPart.toString().indexOf("T_SM_PURORDER") <= 0) {
						querySql.fromPart.append(
						" INNER JOIN T_SM_PURORDER purOrder ").append(
								this.sp);
						querySql.fromPart
						.append(
						" on purOrder.FNumber = ap_entry1.FCoreBillNumber ")
						.append(this.sp);
						querySql.fromPart.append(
						" inner join T_SM_PURORDERENTRY purentry1 ")
						.append(this.sp);
						querySql.fromPart.append(
						" on purOrder.FID = purentry1.FParentID ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" AND purentry1.fid = ap_entry1.fsourcebillentryid ")
						.append(this.sp);
						querySql.fromPart.append(
						" INNER JOIN T_SD_SALEORDER saleOrder ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" on saleOrder.fnumber = purentry1.fsourcebillnumber ")
						.append(this.sp);
						querySql.fromPart.append(
						" INNER JOIN T_SD_SALEORDERENTRY soEntry1 ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" on soEntry1.fparentid = saleOrder.fid AND soEntry1.fid = purentry1.fsourcebillentryid")
						.append(this.sp);
					}

					querySql.fromPart
					.append(
					" INNER JOIN T_BD_SaleGroup saleGroup on saleGroup.fid = saleOrder.FSaleGroupID")
					.append(this.sp);
				} else if (querySql.aliasName.equals("SALEISSUE")) {
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_SaleGroup saleGroup on saleGroup.fid = im_entry1.FSaleGroupID")
					.append(this.sp);
				}
			}
		} else if (tableName.equalsIgnoreCase("t_bd_saleperson")) {
			if (!(querySql.tables.contains("t_bd_saleperson"))) {
				querySql.tables.add("t_bd_saleperson");
				if ((querySql.aliasName.equals("AR"))
						&& (querySql.fromPart.toString().indexOf(
						" T_BD_Person ") == -1)) {
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_Person salePerson on salePerson.fid = ar_otherbill.FPersonId")
					.append(this.sp);
				} else if ((querySql.aliasName.equals("AP"))
						&& (querySql.fromPart.toString().indexOf(
						" T_BD_Person ") == -1)) {
					if (querySql.fromPart.toString().indexOf("T_SM_PURORDER") <= 0) {
						querySql.fromPart.append(
						" INNER JOIN T_SM_PURORDER purOrder ").append(
								this.sp);
						querySql.fromPart
						.append(
						" on purOrder.FNumber = ap_entry1.FCoreBillNumber ")
						.append(this.sp);
						querySql.fromPart.append(
						" inner join T_SM_PURORDERENTRY purentry1 ")
						.append(this.sp);
						querySql.fromPart.append(
						" on purOrder.FID = purentry1.FParentID ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" AND purentry1.fid = ap_entry1.fsourcebillentryid ")
						.append(this.sp);
						querySql.fromPart.append(
						" INNER JOIN T_SD_SALEORDER saleOrder ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" on saleOrder.fnumber = purentry1.fsourcebillnumber ")
						.append(this.sp);
						querySql.fromPart.append(
						" INNER JOIN T_SD_SALEORDERENTRY soEntry1 ")
						.append(this.sp);
						querySql.fromPart
						.append(
						" on soEntry1.fparentid = saleOrder.fid AND soEntry1.fid = purentry1.fsourcebillentryid")
						.append(this.sp);
					}
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_Person salePerson on salePerson.fid = saleOrder.FSalePersonID")
					.append(this.sp);
				} else if ((querySql.aliasName.equals("SALEISSUE"))
						&& (querySql.fromPart.toString().indexOf(
						" T_BD_Person ") == -1)) {
					querySql.fromPart
					.append(
					" INNER JOIN T_BD_Person salePerson on salePerson.fid = im_entry1.FSalePersonID")
					.append(this.sp);
				}
			}
		} else if (tableName.equalsIgnoreCase("t_scm_biztype")) {
			if (!(querySql.tables.contains("t_scm_biztype"))) {
				querySql.tables.add("t_scm_biztype");
				if (querySql.aliasName.equals("AR"))
					querySql.fromPart
					.append(
					" INNER JOIN T_SCM_BizType billType on billType.fid  = ar_otherbill.FBizTypeID")
					.append(this.sp);
				else if (querySql.aliasName.equals("AP"))
					querySql.fromPart
					.append(
					" INNER JOIN T_SCM_BizType billType on billType.fid  = ap_other1.FBizTypeID")
					.append(this.sp);
			}
		} else if (tableName.equalsIgnoreCase("T_ORG_Admin")) {
			if (!(querySql.tables.contains("T_ORG_Admin"))) {
				querySql.tables.add("T_ORG_Admin");
				if (querySql.aliasName.equals("AR"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN T_ORG_Admin adminunit on adminunit.fid = ar_otherbill.FAdminOrgUnitID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("AP"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN T_ORG_Admin adminunit on adminunit.fid = ap_other1.FAdminOrgUnitID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("SALEISSUE"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN T_ORG_Admin adminunit on adminunit.fid = im_saleissue1.FAdminOrgUnitID ")
					.append(this.sp);
				else if (querySql.aliasName.equals("costAdjBill"))
					querySql.fromPart
					.append(
					" LEFT OUTER JOIN T_ORG_Admin adminunit on adminunit.fid = costAdjBill.FAdminOrgUnitID ")
					.append(this.sp);
			}
		} else {
			if ((!(tableName.equalsIgnoreCase("T_BD_Person")))
					|| (querySql.tables.contains("T_BD_Person")))
				return;
			querySql.tables.add("T_BD_Person");

			if (querySql.aliasName.equals("AR"))
				querySql.fromPart
				.append(
				" LEFT OUTER JOIN T_BD_Person salePerson on salePerson.fid = ar_otherbill.Fpersonid ")
				.append(this.sp);
			else if (querySql.aliasName.equals("AP"))
				querySql.fromPart
				.append(
				" LEFT OUTER JOIN T_BD_Person salePerson on salePerson.fid = ap_other1.Fpersonid ")
				.append(this.sp);
			else if (querySql.aliasName.equals("SALEISSUE"))
				querySql.fromPart
				.append(
				" LEFT OUTER JOIN T_BD_Person salePerson on salePerson.fid = im_entry1.fsalepersonid ")
				.append(this.sp);
			else if (querySql.aliasName.equals("costAdjBill"))
				querySql.fromPart
				.append(
				" LEFT OUTER JOIN T_BD_Person salePerson on salePerson.fid = costAdjBill.FCustomerID ")
				.append(this.sp);
		}
	}

	private void classficationGroup(Context ctx, RptParams params,
			String prefixFlds, String suffix, boolean isIncludeStatUnit)
	throws BOSException, EASBizException {
		this.minLevel = minLevel(ctx, params);

		String[] splitSqls = splitLongNumber(ctx, this.minLevel, params);

		String[] sbuTotalSqls = subTotal(prefixFlds, suffix, this.minLevel,
				isIncludeStatUnit);

		String deleteSql = new StringBuilder().append("DELETE FROM ").append(
				this.tempTable).append(" WHERE FGID IS NOT NULL").toString();

		String totalSql = null;
		if (this.minLevel >= 1) {
			StringBuffer totalBuff = new StringBuffer();
			totalBuff.append("insert into ").append(this.tempTable);

			totalBuff.append(" (");
			if ((prefixFlds != null)
					&& (!(this.classficationType
							.equals(SaleReportClassificationEnum.custGroupPlusMaterial)))) {
				totalBuff.append(prefixFlds).append(",");
			}
			totalBuff.append("FNumber_1,FNumber_1Name");

			if (isIncludeStatUnit)
				totalBuff
				.append(",saleQty,outQty,saleCost,saleAmount,statSaleQty,statOutQty ");
			else {
				totalBuff.append(",saleQty,outQty,saleCost,saleAmount ");
			}
			totalBuff.append(") ");

			totalBuff.append(" SELECT ");
			if ((prefixFlds != null)
					&& (!(this.classficationType
							.equals(SaleReportClassificationEnum.custGroupPlusMaterial)))) {
				totalBuff.append(prefixFlds).append(",");
			}
			totalBuff.append("' ").append(this.SubLabel).append("',' ").append(
					this.SubLabel).append("'");

			if (isIncludeStatUnit)
				totalBuff
				.append(",sum(saleQty),sum(outQty),sum(saleCost),sum(saleAmount),sum(statSaleQty),sum(statOutQty) ");
			else {
				totalBuff
				.append(",sum(saleQty),sum(outQty),sum(saleCost),sum(saleAmount) ");
			}
			totalBuff.append(" FROM ").append(this.tempTable).append(this.sp);
			totalBuff.append(" WHERE FGID is not null ").append(this.sp);

			if ((prefixFlds != null)
					&& (!(this.classficationType
							.equals(SaleReportClassificationEnum.custGroupPlusMaterial)))) {
				totalBuff.append(" GROUP BY ").append(prefixFlds).append(
						this.sp);
			}
			totalSql = totalBuff.toString();
		}

		executeBatchUpdate(ctx, splitSqls);
		if (totalSql != null) {
			executeUpdate(totalSql, null, ctx);
		}

		executeBatchUpdate(ctx, sbuTotalSqls);
		executeUpdate(deleteSql, null, ctx);
	}

	private void subtotal(Context ctx, RptParams params, String fld,
			boolean isIncludeStatUnit) throws BOSException, EASBizException {
		int rowCount = totalRowCount(ctx);
		if (rowCount > 0) {
			StringBuffer sql = new StringBuffer();

			String qtyColumn = new StringBuilder().append(
			"saleQty,outQty,saleAmount,saleCost").append(
					(isIncludeStatUnit) ? ",statSaleQty,statOutQty" : "")
					.toString();

			String sumQtyColumn = new StringBuilder()
			.append(
			"sum(saleQty),sum(outQty),sum(saleAmount),sum(saleCost)")
			.append(
					(isIncludeStatUnit) ? ",sum(statSaleQty),sum(statOutQty)"
							: "").toString();
			if ("fmaterialNum".equals(fld)) {
				sql.append("INSERT INTO ").append(this.tempTable).append(" (")
				.append(fld).append(",Fmaterialid,").append(qtyColumn)
				.append(")");
				sql.append(" SELECT ' ").append(this.SubLabel).append(
				"','zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz',")
				.append(sumQtyColumn);
				sql.append(" FROM ").append(this.tempTable);
			} else if ("fcustomerNumber".equals(fld)) {
				sql.append("INSERT INTO ").append(this.tempTable).append(" (")
				.append(fld).append(",Fcustomerid,").append(qtyColumn)
				.append(")");
				sql.append(" SELECT ' ").append(this.SubLabel).append(
				"','zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz',");
				sql.append(sumQtyColumn).append(" FROM ")
				.append(this.tempTable);
			} else {
				sql.append("INSERT INTO ").append(this.tempTable).append(" (")
				.append(fld).append(",").append(qtyColumn).append(")");
				sql.append(" SELECT ' ").append(this.SubLabel).append("',");
				sql.append(sumQtyColumn).append(" FROM ")
				.append(this.tempTable);
			}
			executeUpdate(sql.toString(), null, ctx);
		}
	}

	private int minLevel(Context ctx, RptParams params) throws BOSException,
	EASBizException {
		int minLevel = 0;

		String countSql = new StringBuilder().append(
		"SELECT max(Flevel) resultLevel FROM ").append(this.tempTable)
		.toString();
		RptRowSet rs = executeQuery(countSql, null, ctx);
		rs.next();
		if (rs.getObject(0) == null) {
			return 1;
		}
		int resultLevel = rs.getInt(0);

		int reqLevel = getLevel();

		minLevel = Math.min(resultLevel, reqLevel);

		return minLevel;
	}

	private String[] splitLongNumber(Context ctx, int level, RptParams params) {
		List sqlList = new ArrayList();
		for (int i = 1; i <= level; ++i) {
			String levelString = String.valueOf(i);
			StringBuffer sql = new StringBuffer();
			if ((this.classficationType
					.equals(SaleReportClassificationEnum.materialGroup))
					|| (this.classficationType
							.equals(SaleReportClassificationEnum.customerPlusMaterGroup))
							|| (this.classficationType
									.equals(SaleReportClassificationEnum.materGroupPlusCustomer))) {
				sql.append("update ").append(this.tempTable).append(
				" set FNumber_").append(levelString).append(
				" = FLongNumber ");
				sql.append(" WHERE Flevel = ").append(levelString);
				sqlList.add(sql.toString());
			} else {
				sql.append("update ").append(this.tempTable).append(
				" set FNumber_").append(levelString).append(
				" = FGNumber ");
				sql.append(" WHERE Flevel = ").append(levelString);
				sqlList.add(sql.toString());
			}

			if ((this.classficationType
					.equals(SaleReportClassificationEnum.materialGroup))
					|| (this.classficationType
							.equals(SaleReportClassificationEnum.customerPlusMaterGroup))
							|| (this.classficationType
									.equals(SaleReportClassificationEnum.materGroupPlusCustomer))) {
				if (i > level) {
					continue;
				}
				StringBuffer lenBuffer = new StringBuffer();
				if (i == 1) {
					lenBuffer.append(i);
				} else {
					lenBuffer.append("len(FNumber_");
					lenBuffer.append(i - 1);
					lenBuffer.append(") + 2 ");
				}

				StringBuffer sql2 = new StringBuffer();
				sql2.append("update ").append(this.tempTable);
				sql2.append(" set FNumber_").append(levelString).append(
				"= substring(FLongNumber,1,charindex('!',FLongNumber,")
				.append(lenBuffer).append(") -1)");
				sql2.append(" WHERE FLevel > ").append(levelString);
				sqlList.add(sql2.toString());
			} else {
				if (i > level) {
					continue;
				}
				StringBuffer lenBuffer = new StringBuffer();
				for (int j = 1; j < i; ++j) {
					lenBuffer.append("len(FNumber_").append(String.valueOf(j))
					.append(") + ");
				}

				StringBuffer sql2 = new StringBuffer();
				sql2.append("update ").append(this.tempTable).append(
				" set FNumber_").append(levelString).append(
				"= substring(FLongNumber,").append(lenBuffer).append(
						levelString).append(",charindex('!',FLongNumber,")
						.append(lenBuffer).append(levelString).append(") - (")
						.append(lenBuffer).append(levelString).append(
						")) WHERE FLevel > ").append(levelString);

				sqlList.add(sql2.toString());
			}

		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.materialGroup))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.customerPlusMaterGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.materGroupPlusCustomer))) {
			for (int i = 1; i <= level; ++i) {
				StringBuffer sql = new StringBuffer();
				sql.append("update ").append(this.tempTable).append(" as t1 ");
				sql.append(
						new StringBuilder().append(" set (FNumber_").append(
								String.valueOf(i)).toString()).append(
								"Name) = ");
				sql
				.append("  (SELECT bb.FName_")
				.append(this.locString)
				.append(
				" FROM t_bd_materialgroup as bb,T_BD_MaterialGroupStandard s ");
				sql
				.append("    WHERE bb.FGroupStandard = s.FID AND t1.STDID = s.FID ");
				sql.append("      AND bb.fid = t1.fgid");
				sql.append("      AND t1.FNumber_").append(String.valueOf(i))
				.append(" = bb.FLongNumber ");
				sql.append("      AND t1.FLevel = ").append(String.valueOf(i));
				sql.append("      AND t1.FNumber_").append(String.valueOf(i))
				.append("Name IS NULL ").append(") ");
				sqlList.add(sql.toString());

				int count = 0;
				try {
					count = _getMaxLevel(ctx);
				} catch (BOSException e) {
					logger.error(e);
				}
				for (int j = i + 1; j <= count; ++j) {
					StringBuffer sql1 = new StringBuffer();
					sql1.append("update ").append(this.tempTable).append(
					" as t1 ");
					sql1.append(
							new StringBuilder().append(" set (FNumber_")
							.append(String.valueOf(i)).toString())
							.append("Name) = ");
					sql1
					.append(" (SELECT bb.FName_")
					.append(this.locString)
					.append(
					" FROM t_bd_materialgroup as bb,T_BD_MaterialGroupStandard s ");
					sql1.append("   WHERE bb.FGroupStandard = s.FID ");
					sql1.append("     AND t1.STDID = s.FID ");

					sql1.append("     AND t1.FNumber_").append(
							String.valueOf(i)).append(" = bb.FLongNumber ");
					sql1.append("     AND t1.FLevel = ").append(
							String.valueOf(j));

					sql1.append("     AND t1.FNumber_").append(
							String.valueOf(i)).append(
							"Name IS NULL GROUP BY t1.FGID").append(
							" , bb.FName_").append(this.locString).append(") ");

					sql1.append("     WHERE t1.FLevel = ").append(
							String.valueOf(j));
					sql1.append("     AND t1.FNumber_").append(
							String.valueOf(i)).append("Name IS NULL ");

					sqlList.add(sql1.toString());
				}
			}
		} else
			for (int i = 1; i <= level; ++i) {
				StringBuffer sql = new StringBuffer();
				sql.append("update ").append(this.tempTable).append(" AS t1 ");
				sql.append(
						new StringBuilder().append(" set (FNumber_").append(
								String.valueOf(i)).toString()).append(
								"Name) = ");
				sql.append(" (SELECT bb.FName_").append(this.locString).append(
				" FROM T_BD_CSSPGroup as bb,T_BD_CSSPGroupStandard s ");
				sql
				.append("   WHERE bb.FCSSPGroupStandardID = s.FID AND t1.STDID = s.FID  ");
				sql.append("     AND t1.FNumber_").append(String.valueOf(i))
				.append(" = bb.FNumber ");
				sql.append("     AND bb.FLevel = ").append(String.valueOf(i));
				sql.append("     AND t1.FNumber_").append(String.valueOf(i))
				.append("Name IS NULL ").append(") ");
				sqlList.add(sql.toString());
			}

		String[] sqls = (String[]) (String[]) sqlList
		.toArray(new String[sqlList.size()]);
		return sqls;
	}

	protected int _getMaxLevel(Context ctx) throws BOSException {
		String sqllen = null;
		sqllen = "SELECT MAX(FLevel) AS cc FROM  ";
		sqllen = new StringBuilder().append(sqllen).append(this.tempTable)
		.toString();
		RptRowSet rs = executeQuery(sqllen, null, ctx);
		int max = 0;
		if ((rs.next()) && (rs.getObject(0) != null)) {
			max = rs.getInt(0);
		}
		return max;
	}

	private String[] subTotal(String prefixFlds, String suffix, int level,
			boolean isIncludeStatUnit) {
		List sqlList = new ArrayList();
		StringBuffer totalSql = new StringBuffer();
		if (suffix != null) {
			level += 1;
		}

		for (int i = 1; i < level; ++i) {
			totalSql.setLength(0);
			totalSql.append("insert into ").append(this.tempTable).append(" (");
			if (prefixFlds != null) {
				totalSql.append(prefixFlds).append(",");
			}
			for (int i1 = 1; i1 <= i; ++i1) {
				totalSql.append("FNumber_").append(String.valueOf(i1)).append(
				",").append("FNumber_").append(String.valueOf(i1))
				.append("Name,");

				if ((i1 == i) && (i == level - 1) && (suffix != null)) {
					if (this.classficationType
							.equals(SaleReportClassificationEnum.materGroupPlusCustomer))
						totalSql.append("fcustomerNumber").append(",");
					else if (this.classficationType
							.equals(SaleReportClassificationEnum.custGroupPlusMaterial))
						totalSql.append("fmaterialNum").append(",");
				} else if (i1 == i) {
					totalSql.append("FNumber_").append(String.valueOf(i + 1))
					.append("Name,");
				}
			}

			if (isIncludeStatUnit) {
				totalSql
				.append("saleQty,outQty,saleCost,saleAmount,statSaleQty,statOutQty) ");
			} else
				totalSql.append("saleQty,outQty,saleCost,saleAmount) ");

			totalSql.append(" SELECT ");
			if (prefixFlds != null) {
				totalSql.append(prefixFlds).append(",");
			}
			for (int j = 1; j <= i; ++j) {
				totalSql.append("FNumber_").append(String.valueOf(j)).append(
				",FNumber_").append(String.valueOf(j)).append("Name,");
				if ((j == i) && (i == level - 1) && (suffix != null))
					totalSql.append("' ").append(this.SubLabel).append("',");
				else if (j == i) {
					totalSql.append("' ").append(this.SubLabel).append("',");
				}
			}

			if (isIncludeStatUnit) {
				totalSql
				.append("sum(saleQty),sum(outQty),sum(saleCost),sum(saleAmount),sum(statSaleQty),sum(statOutQty) ");
			} else
				totalSql
				.append("sum(saleQty),sum(outQty),sum(saleCost),sum(saleAmount) ");

			totalSql.append(" FROM ").append(this.tempTable).append(
			" WHERE FGID IS NOT NULL AND flevel >= ").append(
					String.valueOf(i)).append(" group by ");
			if (prefixFlds != null)
				totalSql.append(prefixFlds).append(",");
			if (isIncludeStatUnit)
				;
			for (int j = 1; j < i; ++j) {
				totalSql.append("FNumber_").append(String.valueOf(j)).append(
				",").append("FNumber_").append(String.valueOf(j))
				.append("Name, ");
			}
			totalSql.append("FNumber_").append(String.valueOf(i)).append(",")
			.append("FNumber_").append(String.valueOf(i)).append(
			"Name ");

			sqlList.add(totalSql.toString());
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustGroup)) {
			sqlList.add(new StringBuilder().append(" update ").append(
					this.tempTable).append(
					" set fmaterialid = null where FGID IS NULL ").toString());
		}

		sqlList.add(getDetailDataSql(prefixFlds, suffix, level,
				isIncludeStatUnit));
		String[] sqlSubtotals = (String[]) (String[]) sqlList
		.toArray(new String[sqlList.size()]);
		return sqlSubtotals;
	}

	private String getDetailDataSql(String prefixFlds, String suffix,
			int level, boolean isIncludeStatUnit) {
		StringBuffer totalSql = new StringBuffer();
		if (suffix != null) {
			level -= 1;
		}
		totalSql.append("insert into ").append(this.tempTable).append(" (");
		if (prefixFlds != null) {
			totalSql.append(prefixFlds).append(",");
		}
		for (int i1 = 1; i1 <= level; ++i1) {
			totalSql.append("FNumber_").append(String.valueOf(i1)).append(",")
			.append("FNumber_").append(String.valueOf(i1)).append(
			"Name,");
		}
		if (suffix != null) {
			totalSql.append(suffix).append(",");
		}

		if (isIncludeStatUnit) {
			totalSql.append("statUnitName,FBaseConvsRate,");
			totalSql
			.append("saleQty,outQty,saleCost,saleAmount,statSaleQty,statOutQty) ");
		} else {
			totalSql.append("saleQty,outQty,saleCost,saleAmount) ");
		}
		totalSql.append(" SELECT ");
		if (prefixFlds != null) {
			totalSql.append(prefixFlds).append(",");
		}
		for (int j = 1; j <= level; ++j) {
			totalSql.append("FNumber_").append(String.valueOf(j)).append(
			",FNumber_").append(String.valueOf(j)).append("Name,");
		}
		if (suffix != null) {
			totalSql.append(suffix).append(",");
		}

		if (isIncludeStatUnit) {
			totalSql.append("statUnitName,FBaseConvsRate,");
			totalSql
			.append("sum(saleQty),sum(outQty),sum(saleCost),sum(saleAmount),sum(statSaleQty),sum(statOutQty) ");
		} else {
			totalSql
			.append("sum(saleQty),sum(outQty),sum(saleCost),sum(saleAmount) ");
		}

		totalSql.append(" FROM ").append(this.tempTable).append(
		" WHERE FGID IS NOT NULL ");
		totalSql.append(" group by ");
		if (prefixFlds != null)
			totalSql.append(prefixFlds).append(",");
		if (isIncludeStatUnit) {
			totalSql.append("statUnitName,FBaseConvsRate,");
		}
		for (int j = 1; j < level; ++j) {
			totalSql.append("FNumber_").append(String.valueOf(j)).append(",")
			.append("FNumber_").append(String.valueOf(j)).append(
			"Name, ");
		}
		totalSql.append("FNumber_").append(String.valueOf(level)).append(",")
		.append("FNumber_").append(String.valueOf(level)).append(
		"Name ");
		if (suffix != null) {
			totalSql.append(",").append(suffix);
		}
		return totalSql.toString();
	}

	protected int _getMaxCustomerLevel(Context ctx) throws BOSException {
		String sql = "SELECT max(flevel) cc FROM t_bd_csspgroup  ";
		RptRowSet rs = executeQuery(sql, null, ctx);
		int max = 1;
		if ((rs.next()) && (rs.getObject(0) != null)) {
			max = rs.getInt(0);
		}
		return max;
	}

	protected int _getMaxMaterialLevel(Context ctx) throws BOSException {
		String sql = "SELECT max(flevel) cc FROM t_bd_materialgroup ";
		RptRowSet rs = executeQuery(sql, null, ctx);
		int max = 1;
		if ((rs.next()) && (rs.getObject(0) != null)) {
			max = rs.getInt(0);
		}
		return max;
	}

	protected String getOrgIds(Object[] infos) {
		StringBuffer OrgunitId = new StringBuffer();
		if ((infos != null) && (infos.length > 0)) {
			int i = 0;
			for (int n = infos.length; i < n; ++i) {
				Boolean isleaf = (Boolean) ((FullOrgUnitInfo) infos[i])
				.get("isleaf");
				int fisleaf;
				if (isleaf.booleanValue())
					fisleaf = 1;
				else {
					fisleaf = 0;
				}
				if (fisleaf == 1) {
					OrgunitId.append(new StringBuilder().append("'").append(
							((FullOrgUnitInfo) infos[i]).getId().toString())
							.append("',").toString());
				}
			}
		}

		OrgunitId.append("'XXXX_XXXX'");
		return OrgunitId.toString();
	}

	protected int[] _getMaxLevels(Context ctx) throws BOSException {
		int[] levels = new int[2];

		levels[0] = _getMaxCustomerLevel(ctx);
		levels[1] = _getMaxMaterialLevel(ctx);

		return levels;
	}

	public String getServerResource(String key, Context ctx) {
		return SCMUtils
		.getResource(
				"com.kingdee.eas.scm.sd.sale.report.SDReportResource",
				key, ctx);
	}

	private void buildSelectPartNull(QuerySql querySql) {
		if ((this.classficationType
				.equals(SaleReportClassificationEnum.material))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.materialPlusCustGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.custGroupPlusMaterial))
								|| (this.classficationType
										.equals(SaleReportClassificationEnum.materialPlusCustomer))
										|| (this.classficationType
												.equals(SaleReportClassificationEnum.customerPlusmaterial))
												|| (this.classficationType
														.equals(SaleReportClassificationEnum.departmentplusmaterial))
														|| (this.classficationType
																.equals(SaleReportClassificationEnum.customerPlusMaterPerson))) {
			querySql.selectPart
			.append(
			" case when ar_entry.fmaterialID is not null then material.fid else ei.FID end AS fmaterialid,")
			.append(
			" case when ar_entry.fmaterialID is not null then material.Fnumber else ei.Fnumber end AS fmaterialNum,")
			.append(" case when ar_entry.fmaterialID is not null then ")
			.append(" material.fname_")
			.append(this.locString)
			.append(" else ei.FName_")
			.append(this.locString)
			.append(" end AS fmaterialName,")
			.append(
			" case when ar_entry.fmaterialID is not null then material.fshortname else  ei.FName_")
			.append(this.locString).append(
			" end as fmaterialShortName, ");

			if (this.isAssistSum) {
				querySql.selectPart.append(
				" material.Fmodel,assistProperty.FName_").append(
						this.locString).append(
						" AS FassistPropertyName,mmUnit.FQtyPrecision,")
						.append(this.sp);
			} else {
				querySql.selectPart.append(
				" material.Fmodel,mmUnit.FQtyPrecision,").append(
						this.sp);
			}
			querySql.selectPart
			.append(
			" case when ar_entry.fmaterialID is not null then baseUnit.fname_")
			.append(this.locString).append(" else unit.FName_").append(
					this.locString).append(" end AS baseUnitName,");

			if (this.isAssistSum) {
				querySql.otherPart1
				.append("fmaterialid,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
				querySql.otherPartAlias1
				.append("fmaterialid,max(fmaterialNum) fmaterialNum,max(fmaterialName) fmaterialName,max(fmaterialShortName) fmaterialShortName,max(Fmodel) Fmodel,FassistPropertyName,FQtyPrecision,max(baseUnitName) baseUnitName,");
				querySql.groupPart
				.append("fmaterialid,FassistPropertyName,FQtyPrecision,");
			} else {
				querySql.otherPart1
				.append("fmaterialid,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
				querySql.otherPartAlias1
				.append("fmaterialid,max(fmaterialNum) fmaterialNum,max(fmaterialName) fmaterialName,max(fmaterialShortName) fmaterialShortName,max(Fmodel) Fmodel,FQtyPrecision,max(baseUnitName) baseUnitName,");
				querySql.groupPart.append("fmaterialid,FQtyPrecision,");
			}

			querySql.selectPart
			.append(
			" case when ar_entry.fmaterialID is not null then baseUnit.fname_")
			.append(this.locString);
			querySql.selectPart.append(" else unit.FName_").append(
					this.locString).append(
					" end AS statUnitName,-1.0 as FBaseConvsRate,");
			querySql.otherPart1
			.append(" statUnitName, to_decimal(FBaseConvsRate,21,8) FBaseConvsRate, ");
			querySql.otherPartAlias1
			.append(" max(statUnitName) statUnitName, to_decimal(FBaseConvsRate,21,8) FBaseConvsRate, ");
			querySql.groupPart.append("FBaseConvsRate, ");
			appendTable(querySql, "t_bd_material");
			appendTable(querySql, "T_SCM_ExpenseItem");
			appendTable(querySql, "T_BD_MultiMeasureUnitNull");
			appendTable(querySql, "T_BD_AsstAttrValue");
		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.customer))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.customerPlusMaterGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.materGroupPlusCustomer))
								|| (this.classficationType
										.equals(SaleReportClassificationEnum.customerPlusmaterial))
										|| (this.classficationType
												.equals(SaleReportClassificationEnum.materialPlusCustomer))
												|| (this.classficationType
														.equals(SaleReportClassificationEnum.customerPlusMaterPerson))) {
			querySql.selectPart
			.append(
			" customer.Fid fcustomerid,customer.Fnumber fcustomerNumber,customer.FName_")
			.append(this.locString).append(" as fcustomerName,")
			.append(this.sp);
			querySql.otherPart1
			.append("fcustomerid,fcustomerNumber,fcustomerName,");
			querySql.otherPartAlias1
			.append("fcustomerid,max(fcustomerNumber) fcustomerNumber,max(fcustomerName) fcustomerName,");
			querySql.groupPart.append("fcustomerid,");

			appendTable(querySql, "t_bd_customer");
		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.materialGroup))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.materGroupPlusCustomer))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.customerPlusMaterGroup))) {
			querySql.selectPart
			.append(
			"mg.FGroupStandard STDID,mg.Fid FGID,mg.FLevel,mg.FLongNumber,mg.FNumber FGNumber,")
			.append(this.sp);
			querySql.otherPart1
			.append("STDID,FGID,FLevel,FLongNumber,FGNumber,");
			querySql.otherPartAlias1
			.append("max(STDID) STDID,FGID,max(FLevel) FLevel,max(FLongNumber) FLongNumber,max(FGNumber) FGNumber,");
			querySql.groupPart.append("FGID,");

			appendTable(querySql, "t_bd_material");
			appendTable(querySql, "t_bd_MaterialGroupDetial");
			appendTable(querySql, "t_bd_materialgroup");
		}

		if ((this.classficationType
				.equals(SaleReportClassificationEnum.customerGroup))
				|| (this.classficationType
						.equals(SaleReportClassificationEnum.materialPlusCustGroup))
						|| (this.classficationType
								.equals(SaleReportClassificationEnum.custGroupPlusMaterial))) {
			querySql.selectPart
			.append(
			" cbg.FCSSPGroupStandardID STDID,cbg.Fid FGID,cbg.FLevel,cbg.FLongNumber,cbg.FNumber FGNumber,")
			.append(this.sp);
			querySql.otherPart1
			.append("STDID,FGID,FLevel,FLongNumber,FGNumber,");
			querySql.otherPartAlias1
			.append("max(STDID) STDID,FGID,max(FLevel) FLevel,max(FLongNumber) FLongNumber,max(FGNumber) FGNumber,");
			querySql.groupPart.append("FGID,");

			appendTable(querySql, "t_bd_customer");
			appendTable(querySql, "t_bd_csspgroup");
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.saleorder)) {
			if (querySql.aliasName.equalsIgnoreCase("SALEISSUE")) {
				querySql.selectPart
				.append(" im_entry1.FSaleOrderNumber fsoNumber,");
				querySql.wherePart.append(" AND im_entry1.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
			} else if (querySql.aliasName.equalsIgnoreCase("AP")) {
				querySql.selectPart
				.append(" ap_entry1.FCoreBillNumber  fsoNumber,");
				querySql.wherePart.append(" AND ap_entry1.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
			} else if (querySql.aliasName.equalsIgnoreCase("AR")) {
				querySql.selectPart
				.append(" ar_entry.FCoreBillNumber  fsoNumber,");
				querySql.wherePart.append(" AND ar_entry.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
			}

			querySql.otherPart1.append(" fsoNumber,");
			querySql.otherPartAlias1.append(" fsoNumber,");
			querySql.groupPart.append("fsoNumber,");
		}
		if (this.classficationType
				.equals(SaleReportClassificationEnum.salecontract)) {
			querySql.otherPart1.append(" fscNumber,");
			querySql.otherPartAlias1.append(" fscNumber,");
			querySql.groupPart.append("fscNumber,");

			querySql.selectPart.append(" soEntry.FSourceBillNumber fscNumber,");
			querySql.tables.add("T_SD_SaleOrderEntry");

			if (querySql.aliasName.equalsIgnoreCase("SALEISSUE")) {
				querySql.wherePart.append(" AND im_entry1.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
				querySql.fromPart
				.append(
				" INNER JOIN T_SD_SaleOrderEntry soEntry ON im_entry1.FSaleOrderEntryID = soEntry.FID ")
				.append(this.sp);
			} else if (querySql.aliasName.equalsIgnoreCase("AP")) {
				querySql.wherePart.append(" AND ap_entry1.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);

				querySql.fromPart
				.append(
				" INNER JOIN T_SM_PurOrderEntry soEntry ON ap_entry1.FCoreBillEntryId = soEntry.FID ")
				.append(this.sp);
			} else if (querySql.aliasName.equalsIgnoreCase("AR")) {
				querySql.wherePart.append(" AND ar_entry.FCoreBillTypeID = '")
				.append("510b6503-0105-1000-e000-0113c0a812fd463ED552")
				.append("' ").append(this.sp);
				querySql.fromPart
				.append(
				" INNER JOIN T_SD_SaleOrderEntry soEntry ON ar_entry.FCoreBillEntryId = soEntry.FID ")
				.append(this.sp);
			}
			querySql.wherePart.append(" AND soEntry.FSourceBillTypeID = '")
			.append("DEZBNUYZRM6ieHZ5GGlRc0Y+1VI=").append("' ")
			.append(this.sp);
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.departmentplusmaterial)) {
			querySql.selectPart.append(
			"adminunit.fid fadminunitid,adminunit.FName_").append(
					this.locString).append(" as fadminunitName,").append(
							this.sp);

			querySql.otherPart1.append("fadminunitid,fadminunitName,");
			querySql.otherPartAlias1
			.append("fadminunitid,max(fadminunitName) fadminunitName,");
			querySql.otherPart1.append("fadminunitid,");
			appendTable(querySql, "T_ORG_Admin");
		}

		if (this.classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterPerson)) {
			querySql.selectPart.append("salePerson.fid fSalePersonid");
			querySql.selectPart.append(",salePerson.FNumber fSalePersonNum");
			querySql.selectPart.append(",salePerson.FName_").append(
					this.locString).append(" as fSalePersonName,").append(
							this.sp);

			querySql.otherPart1
			.append("fSalepersonid,fSalePersonNum,fSalePersonName,");
			querySql.otherPart1
			.append("fSalepersonid,max(fSalePersonNum) fSalePersonNum,max(fSalePersonName) fSalePersonName,");
			querySql.groupPart.append("fSalepersonid,");
			appendTable(querySql, "T_BD_Person");
		}

		if (this.tempColsForSelect == null) {
			this.tempColsForSelect = querySql.otherPart1.toString().substring(
					0, querySql.otherPart1.lastIndexOf(","));
		}
		if (this.tempColsForGroup == null) {
			this.tempColsForGroup = querySql.otherPartAlias1.toString()
			.substring(0, querySql.otherPartAlias1.lastIndexOf(","));
		}
		if (this.groupCols == null)
			this.groupCols = querySql.groupPart.toString().substring(0,
					querySql.groupPart.lastIndexOf(","));
		querySql.groupPart.setLength(0);
	}

	protected boolean isUseRWSplit() {
		return true;
	}

	static class QuerySql {
		StringBuffer selectPart;
		StringBuffer fromPart;
		StringBuffer wherePart;
		StringBuffer groupPart;
		StringBuffer otherPart1;
		StringBuffer otherPartAlias1;
		int unionCount;
		Set tables;
		String aliasName;

		QuerySql() {
			this.selectPart = new StringBuffer();

			this.fromPart = new StringBuffer();

			this.wherePart = new StringBuffer();

			this.groupPart = new StringBuffer();

			this.otherPart1 = new StringBuffer();

			this.otherPartAlias1 = new StringBuffer();

			this.unionCount = 0;

			this.tables = new HashSet();

			this.aliasName = "";
		}

		String getSql() {
			StringBuffer sql = new StringBuffer();
			for (int i = 0; i <= this.unionCount; ++i) {
				if (i > 0) {
					sql.append(" union all ");
				}
				sql.append(this.selectPart.toString()).append(
						this.fromPart.toString()).append(
								this.wherePart.toString()).append(
										this.groupPart.toString());
			}
			return sql.toString();
		}
	}

}