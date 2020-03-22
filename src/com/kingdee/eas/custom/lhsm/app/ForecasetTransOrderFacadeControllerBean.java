package com.kingdee.eas.custom.lhsm.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.ICustomer;
import com.kingdee.eas.basedata.org.ISaleOrgUnit;
import com.kingdee.eas.basedata.org.SaleOrgUnitFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.ExceptionUtils;
import com.kingdee.eas.custom.lhsm.ISaleForecastEntry;
import com.kingdee.eas.custom.lhsm.SaleForecastEntryFactory;
import com.kingdee.eas.custom.lhsm.SaleForecastEntryInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

import java.awt.Color;
import java.lang.String;
import java.math.BigDecimal;

public class ForecasetTransOrderFacadeControllerBean extends AbstractForecasetTransOrderFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.lhsm.app.ForecasetTransOrderFacadeControllerBean");
	protected String _getAllData(Context ctx, String param)throws BOSException
	{
		return null;
	}
	protected String _getSingleForecastData(Context ctx, String param)throws BOSException{
		JSONObject fromObject = JSONObject.fromObject(param);
		String id = fromObject.getString("id");
		JSONArray jsonArray = new JSONArray();
		StringBuffer sql =  new StringBuffer();
		sql =new StringBuffer();
		sql.append(" Select t1.*,isnull(t2.fnumber,'') fsalenumber ");
		sql.append(" from CT_LHS_SALEFORECASTENTRY2 t1 ");
		sql.append(" left join t_sd_saleorder t2 on t2.fid=t1.fsaleorderid ");
		sql.append(" where t1.fparentid='"+id+"'");
		sql.append(" order by t1.fseq ");
		IRowSet rs = ToolFacadeFactory.getLocalInstance(ctx).executeQuery(sql.toString());

		if(rs != null && rs.size() > 0){
			int m=0;
			BigDecimal baseqtyt=BigDecimal.ZERO;
			BigDecimal qtyat=BigDecimal.ZERO;
			BigDecimal qtybt=BigDecimal.ZERO;
			BigDecimal amountt=BigDecimal.ZERO;
			JSONObject jsonEntry = null;
			JSONObject jsonItem = null;
			String materialid = "";
			String materialids = "";
			CustomerInfo cinfo = null;
			ObjectUuidPK pk;
			ISaleOrgUnit iSaleOrderUnit = SaleOrgUnitFactory.getLocalInstance(ctx);
			ISaleForecastEntry iSaleForecastEntry = SaleForecastEntryFactory.getLocalInstance(ctx);
			IMeasureUnit iMeasureUnit = MeasureUnitFactory.getLocalInstance(ctx);
			ICustomer iCustomer = CustomerFactory.getLocalInstance(ctx);
			try {
				while(rs.next()){
					SaleForecastEntryInfo currEntry = iSaleForecastEntry.getSaleForecastEntryInfo(new ObjectUuidPK(rs.getString("fentryid")));
					jsonEntry = new JSONObject();

					jsonEntry.put("seq",currEntry.getSeq());
					jsonEntry.put("entryID",currEntry.getId().toString());
					jsonEntry.put("id",rs.getString("FID"));

					materialid = currEntry.getMaterialNumber().getId().toString();
					if(materialids.equals("")){
						materialids="'"+materialid+"'";
					}else{
						materialids=materialids+",'"+materialid+"'";
					}


					jsonEntry.put("materialID",materialid);
					jsonEntry.put("materialName",currEntry.getMaterialName());
					jsonEntry.put("seq",currEntry.getSeq());


					pk = new ObjectUuidPK(rs.getString("fcustomerid"));
					cinfo = iCustomer.getCustomerInfo(pk);
					jsonItem = new JSONObject();
					jsonItem.put("name",cinfo.getName());
					jsonItem.put("number",cinfo.getNumber());
					jsonItem.put("id",cinfo.getString("id"));
					jsonEntry.put("customer",jsonItem);

					if(currEntry.getCompany()!=null){
						pk = new ObjectUuidPK(currEntry.getCompany().getId());
						SaleOrgUnitInfo orgunitInfo=iSaleOrderUnit.getSaleOrgUnitInfo(pk);
						jsonItem = new JSONObject();
						jsonItem.put("name",orgunitInfo.getName());
						jsonItem.put("number",orgunitInfo.getNumber());
						jsonItem.put("id",orgunitInfo.getString("id"));
						jsonEntry.put("company",jsonItem);
					}
					// 单位
					if(currEntry.getBaseUnit()!=null){
						MeasureUnitInfo unit = iMeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(currEntry.getBaseUnit().getId()));
						if(unit != null){
							jsonEntry.put("unit",unit.getName());
							jsonEntry.put("unitID",unit.getName());
						}
					}


					//  总数量
					BigDecimal baseqty = BigDecimal.ZERO;
					baseqty.setScale(2);
					if(currEntry.getBaseQty()!= null){
						baseqty = currEntry.getBaseQty();
						baseqtyt=baseqtyt.add(baseqty);
					}
					jsonEntry.put("qty",baseqty.toPlainString());
					jsonEntry.put("price",currEntry.getBasePrice());
					amountt=amountt.add(currEntry.getAmount());
					jsonEntry.put("amount",currEntry.getAmount());

					// 已分配数量
					BigDecimal qtya = BigDecimal.ZERO;
					qtya.setScale(2);
					if(currEntry.getQtya()!= null){
						qtya = currEntry.getQtya();	
						qtyat=qtyat.add(qtya);
					}
					jsonEntry.put("qtya",qtya);



					// 可用数量
					BigDecimal qtyb = BigDecimal.ZERO;
					qtyb.setScale(2);
					if(currEntry.getQtyb()!= null){
						qtyb = currEntry.getQtyb();	
						qtybt=qtybt.add(qtyb);
					}
					jsonEntry.put("qtyb",qtyb);

					jsonEntry.put("remark",currEntry.getRemark());
					jsonArray.add(jsonEntry);
				}
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JSONObject resultJson = new JSONObject();
		resultJson.put("data",jsonArray);
		return resultJson.toString();
	}
	protected String _addSaleOrderBill(Context ctx, String param)throws BOSException
	{
		return null;
	}

	/**
	 * 查询库存
	 */
	@Override
	protected String _getMaterialInventory(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub

		JSONObject fromObject = JSONObject.fromObject(param);
		String companyID = null ;
		if(fromObject.containsKey("companyID") && StringUtils.isNotEmpty(fromObject.getString("companyID")))
			companyID = fromObject.getString("companyID");

		JSONObject jsonResult = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		String materialID = null;
		if(fromObject.containsKey("materialID") && StringUtils.isNotEmpty(fromObject.getString("materialID")))
			materialID = fromObject.getString("materialID");


		StringBuffer sb = new StringBuffer();
		sb.append("/*dialect*/").append("\n")
		.append("SELECT companyName,materialNum,materialName,wareHouse,sum(FCurStoreQty) FCurStoreQty,sum(XianPin) XianPin,sum(yubaoQty) yubaoQty,sum(dingDanQty) dingDanQty,sum(chuKuQty) chukuQty").append("\n")
		.append(" from(").append("\n")
		.append("SELECT").append("\n")
		.append(" t2.FName_l2                    companyName,").append("\n")
		.append(" t4.FNumber                     materialNum,").append("\n")
		.append(" t4.FName_l2                    materialName,").append("\n")
		.append(" sum(t1.FBaseQty)               FCurStoreQty,").append("\n")
		.append(" t3.FName_l2                    wareHouse,").append("\n")
		.append(" 0                              yubaoQty,").append("\n")
		.append(" 0                              dingDanQty,").append("\n")
		.append(" 0                              chuKuQty,").append("\n")
		.append(" 0                              XianPin").append("\n")
		.append("FROM").append("\n")
		.append("T_IM_Inventory                  t1").append("\n")
		.append("inner join T_ORG_Company        t2 on t2.FID=t1.FCompanyOrgUnitID").append("\n")
		.append("inner join T_DB_WAREHOUSE       t3 on t3.FID=t1.FWarehouseID").append("\n")
		.append("inner join T_BD_Material        t4 on t4.FID=t1.FMaterialID").append("\n")
		.append("inner join T_BD_MaterialGroup   t5 on t5.FID=t4.FMaterialGroupID").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t2.FID in ('").append(companyID).append("')").append("\n");
		sb.append("      and t5.FLongNumber like '02!0204!%'").append("\n");
		//		.append("      and (t4.FName_l2 like '%%'  or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("Group by t2.FName_l2,t4.FNumber,t4.FName_l2,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("union all").append("\n")
		.append("").append("\n")
		.append("select").append("\n")
		.append(" t3.FName_l2                    companyName,").append("\n")
		.append(" t4.FNumber                     materialNum, ").append("\n")
		.append(" t4.FName_l2                     materialName,").append("\n")
		.append(" 0,").append("\n")
		.append(" t5.FName_l2                     houseName,").append("\n")
		.append(" sum(t2.CFBaseQty)                    CFBaseQty,").append("\n")
		.append(" 0,").append("\n")
		.append(" 0,").append("\n")
		.append(" 0").append("\n")
		.append("from ").append("\n")
		.append("CT_LHS_SaleForecast              t1").append("\n")
		.append("inner join CT_LHS_SaleForecastEntry t2 on t1.FID=t2.FParentID").append("\n")
		.append("inner join T_ORG_Company          t3 on t3.FID=t1.CFCompanyID").append("\n")
		.append("inner join T_BD_Material          t4 on t4.FID=t2.CFMaterialNumberID").append("\n")
		.append("inner join T_DB_WAREHOUSE         t5 on t5.FID=t2.FwareHouseID").append("\n")
		.append("inner join T_BD_MaterialGroup     t6 on t6.FID=t4.FMaterialGroupID").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t3.FID in ('").append(companyID).append("')").append("\n");
		//		.append("where t3.FID in ('75QAAAAAAeTM567U', '75QAAAAAMlLM567U', '75QAAAAAMorM567U', '75QAAAAAMsLM567U')").append("\n")
		sb.append("      and t6.FLongNumber like '02!0204!%'").append("\n")
		.append("      and t1.FID not in (select fparentid from CT_LHS_SALEFORECASTENTRY2)").append("\n");
		//		.append("      and (t4.FName_l2 like '%%' or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("group by t4.FName_l2,t5.FName_l2,t4.FNumber,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("union all").append("\n")
		.append("").append("\n")
		.append("").append("\n")
		.append("select").append("\n")
		.append("  t3.FName_l2                    companyName,").append("\n")
		.append(" t4.FNumber                     materialNum, ").append("\n")
		.append(" t4.FName_l2                     materialName,").append("\n")
		.append(" 0,").append("\n")
		.append(" t5.FName_l2                     houseName,").append("\n")
		.append(" 0                               CFBaseQty,").append("\n")
		.append(" sum(t2.FBaseQty),").append("\n")
		.append(" 0,").append("\n")
		.append(" 0").append("\n")
		.append("from ").append("\n")
		.append("T_SD_SaleOrder                     t1").append("\n")
		.append("inner join T_SD_SaleOrderEntry    t2 on t1.FID=t2.FParentID").append("\n")
		.append("inner join T_ORG_Sale             t3 on t3.FID=t1.FSaleOrgUnitID").append("\n")
		.append("inner join T_BD_Material          t4 on t4.FID=t2.FMaterialID").append("\n")
		.append("inner join T_DB_WAREHOUSE         t5 on t5.FID=t2.FwareHouseID").append("\n")
		.append("inner join T_BD_MaterialGroup     t6 on t6.FID=t4.FMaterialGroupID").append("\n")
		.append("left  join T_BOT_Relation         t7 on t1.FID=t7.FSrcObjectID").append("\n")
		.append("left  join T_IM_SaleIssueBill     t8 on t8.FID=t7.FDestObjectID").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t3.FID in ('").append(companyID).append("')").append("\n");
		//		.append("where t3.FID in ('75QAAAAAAeTM567U', '75QAAAAAMlLM567U', '75QAAAAAMorM567U', '75QAAAAAMsLM567U')").append("\n")
		sb.append("      and t6.FLongNumber like '02!0204!%'").append("\n")
		.append("--      and (t2.FTotalIssueBaseQty is null or t2.FTotalIssueBaseQty=0)").append("\n");
		//		.append("      and (t4.FName_l2 like '%%' or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("      and t8.FID is null").append("\n")
		.append("      and t2.FBaseStatus<>3").append("\n")
		.append("      and t1.FBaseStatus not in (4,7)").append("\n")
		.append("group by t4.FName_l2,t5.FName_l2,t4.FNumber,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("union all").append("\n")
		.append("").append("\n")
		.append("select").append("\n")
		.append("  t3.FName_l2                    companyName,").append("\n")
		.append(" t4.FNumber                     materialNum, ").append("\n")
		.append(" t4.FName_l2                     materialName,").append("\n")
		.append(" 0,").append("\n")
		.append(" t5.FName_l2                     houseName,").append("\n")
		.append(" 0                               CFBaseQty,").append("\n")
		.append(" 0,").append("\n")
		.append(" sum(t2.FBaseQty),").append("\n")
		.append(" 0").append("\n")
		.append("from ").append("\n")
		.append("T_IM_SaleIssueBill                t1").append("\n")
		.append("inner join T_IM_SaleIssueEntry    t2 on t1.FID=t2.FParentID").append("\n")
		.append("inner join T_ORG_Storage          t3 on t3.FID=t1.FStorageOrgUnitID").append("\n")
		.append("inner join T_BD_Material          t4 on t4.FID=t2.FMaterialID").append("\n")
		.append("inner join T_DB_WAREHOUSE         t5 on t5.FID=t2.FwareHouseID").append("\n")
		.append("inner join T_BD_MaterialGroup     t6 on t6.FID=t4.FMaterialGroupID").append("\n")
		//		.append("where t3.FID in ('75QAAAAAAeTM567U', '75QAAAAAMlLM567U', '75QAAAAAMorM567U', '75QAAAAAMsLM567U')").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t3.FID in ('").append(companyID).append("')").append("\n");
		sb.append("      and t6.FLongNumber like '02!0204!%'").append("\n");
		//		.append("      and (t4.FName_l2 like '%%' or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("      and t1.FBaseStatus not in (4,7)").append("\n")
		.append("group by t4.FName_l2,t5.FName_l2,t4.FNumber,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("union all").append("\n")
		.append("").append("\n")
		.append("select").append("\n")
		.append(" t3.FName_l2,").append("\n")
		.append(" t4.FNumber,").append("\n")
		.append(" t4.FName_l2,").append("\n")
		.append(" 0,").append("\n")
		.append(" t5.FName_l2,").append("\n")
		.append(" 0,").append("\n")
		.append(" 0,").append("\n")
		.append(" 0,").append("\n")
		.append(" sum(t2.CFWeight)").append("\n")
		.append("from ").append("\n")
		.append("CT_SZC_SzSemiProduct                 t1").append("\n")
		.append("inner join CT_SZC_SzSemiProductEntry t2 on t1.FID=t2.FParentID").append("\n")
		.append("inner join T_ORG_Company             t3 on t3.FID=t1.CFCompanyID").append("\n")
		.append("inner join T_BD_Material             t4 on t4.FID=t2.CFMaterialID").append("\n")
		.append("inner join T_DB_WAREHOUSE            t5 on t5.FID=t2.CFWareHouseID").append("\n")
		.append("inner join T_BD_MaterialGroup     t6 on t6.FID=t4.FMaterialGroupID").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t3.FID in ('").append(companyID).append("')").append("\n");
		//		.append("where t3.FID in ('75QAAAAAAeTM567U', '75QAAAAAMlLM567U', '75QAAAAAMorM567U', '75QAAAAAMsLM567U')").append("\n")
		sb.append("      and t6.FLongNumber like '02!0204!%'").append("\n");
		//		.append("      and (t4.FName_l2 like '%%' or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("      and t1.CFStatus  in (4,7)").append("\n")
		.append("       and to_char(t1.FBizDate,'yyyyMMdd')=to_char(sysdate-1,'yyyyMMdd')").append("\n")
		.append("group by t4.FName_l2,t5.FName_l2,t4.FNumber,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("").append("\n")
		.append(")").append("\n")
		.append("group by materialNum,materialName,wareHouse,companyName").append("\n")
		.append("      having (sum(FCurStoreQty)<>0 or sum(XianPin)<>0 or sum(dingDanQty)<>0 or sum(chukuQty)<>0)").append("\n")
		.append("order by materialNum").append("\n");


		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			JSONObject jsonObj = null;
			while(rs.next()){
				jsonObj = new JSONObject();
				jsonObj.put("materialNum",rs.getObject("materialNum"));
				jsonObj.put("materialName",rs.getObject("materialName"));
				jsonObj.put("company",rs.getObject("companyName"));
				jsonObj.put("warehouse",rs.getObject("wareHouse"));
				jsonObj.put("curQty",rs.getObject("FCurStoreQty"));
				jsonObj.put("yubaoQty",rs.getObject("XianPin"));
				jsonObj.put("dingdanQty",UIRuleUtil.getBigDecimal(rs.getObject("dingDanQty")).add(UIRuleUtil.getBigDecimal(rs.getObject("chukuQty"))));
				jsonObj.put("totalQty",UIRuleUtil.getBigDecimal(rs.getObject("FCurStoreQty")).add(UIRuleUtil.getBigDecimal(rs.getObject("XianPin"))));
				jsonObj.put("canUseQty",UIRuleUtil.getBigDecimal(jsonObj.get("totalQty")).subtract(UIRuleUtil.getBigDecimal(jsonObj.get("dingdanQty"))));
				jsonArray.add(jsonObj);
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jsonResult.put("data",jsonArray);
		return jsonResult.toString();
	}
	@Override
	protected String _excuteInsertSql(Context ctx, String param) {
		// TODO Auto-generated method stub
		JSONObject fromObject = JSONObject.fromObject(param);
		String sql = fromObject.getString("sql");
		JSONObject resultJson = new JSONObject();
		resultJson.put("result",true);
		try {
			DbUtil.execute(ctx, sql);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result",false);
			resultJson.put("loc",ExceptionUtils.getExceptionLocationSimple(e));
			resultJson.put("reason",ExceptionUtils.getExceptionStatement(e));
			return resultJson.toString();
		}
		return resultJson.toString();
	}
	@Override
	protected String _excuteQuerySql(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject fromObject = JSONObject.fromObject(param);
		String sql = fromObject.getString("sql");
		JSONObject resultJson = new JSONObject();
		resultJson.put("result",true);
		JSONArray data = new JSONArray();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql);
			JSONObject em = null;
			ResultSetMetaData metaData;
			metaData = rs.getMetaData();
			while(rs.next()){
				em = new JSONObject();
				for(int i=0 ;i < metaData.getColumnCount();i++){
					em.put(metaData.getColumnName(i+1), rs.getObject(i+1));
				}
				data.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		}
		resultJson.put("data", data);
		return resultJson.toString();
	}
	@Override
	protected String _excuteInsertSql(Context ctx, String sql, Object[] obj)
			throws BOSException {
		// TODO Auto-generated method stub
		DbUtil.execute(ctx, sql,obj);
		return null;
	}
}