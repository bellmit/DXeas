package com.kingdee.eas.custom.workflow.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class WSRptDataFacadeControllerBean extends AbstractWSRptDataFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.workflow.app.WSRptDataFacadeControllerBean");
    
    /**
     * 获取生产报表数据
     */
    protected String _getProductRptDataByJson(Context ctx, String jsonData)throws BOSException {
    	JSONObject resultJson = new JSONObject();
    	resultJson.put("result", "success");
    	
    	if (StringUtils.isBlank(jsonData)) {
    		resultJson.put("result", "failure");
			resultJson.put("message", "传入参数不能为空");
			
			return resultJson.toString();
    	}
    	
    	JSONObject conditionJson = JSONObject.fromObject(jsonData);
    	String prdDate = "";
    	if (!conditionJson.containsKey("prdDate")) {
    		resultJson.put("result", "failure");
			resultJson.put("message", "传入参数不包含prdDate");
			
			return resultJson.toString();
    	} else {
    		prdDate = conditionJson.getString("prdDate");
    		if (StringUtils.isBlank(prdDate)) {
    			resultJson.put("result", "failure");
    			resultJson.put("message", "生产日期不能为空");
    			
    			return resultJson.toString();
    		}
    	}
    	
    	//总的数据json
    	JSONObject dataJson = new JSONObject();
    	
    	JSONArray planArray = new JSONArray();
    	JSONArray produceingArray = new JSONArray();
    	JSONArray producedArray = new JSONArray();
    	
    	BigDecimal plan = BigDecimal.ZERO;
    	BigDecimal producing = BigDecimal.ZERO;
    	BigDecimal producedNum = BigDecimal.ZERO;
    	BigDecimal producedWeight = BigDecimal.ZERO;
    	
    	StringBuffer sql = new StringBuffer("/*dialect*/");
    	sql.append(" select t1.fid as prdId, t3.fid as batchId, max(t4.fid) as halfPrdId, ");
    	sql.append(" max(t1.fnumber) as prdNumber, max(t1.fname_l2) as prdName, max(t.cfstandard) as cfstandard, ");
    	sql.append(" max(t2.fnumber) as batchNumber, sum(t.cfbatch) as cfbatch, ");
    	sql.append(" to_char(max(t.cfproductdate),'yyyy-mm-dd') as cfproductdate ");
    	sql.append(" from CT_GMP_PackageInstruction t ");
    	sql.append(" inner join t_bd_material t1 on t1.fid = t.cfproductnameid ");
    	sql.append(" inner join CT_PRO_Productbos t2 on t2.fid = t.fhalfbatchnumberid ");
    	sql.append(" inner join  CT_GMP_Batch t3 on t3.fid = t2.cfbatchnumberid ");
    	sql.append(" inner join t_bd_material t4 on t4.fid = t.fhalfproductnameid ");
    	sql.append(" where t.cfstorageorgunitid = '9owAAAAUmiHM567U' ");
    	sql.append(" and to_char(t.cfproductdate,'yyyy-mm-dd') = '");
    	sql.append(prdDate);
    	sql.append("' ");
    	sql.append(" group by t1.fid,t3.fid ");
    	
    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    	try {
    		
			while (rs.next()) {
				
				//计划数 start
				JSONObject planJson = new JSONObject();
				
				planJson.put("prdName",rs.getString("prdName"));
				planJson.put("cfstandard",rs.getString("cfstandard"));
				planJson.put("batchNumber",rs.getString("batchNumber"));
				BigDecimal cfbatch = rs.getBigDecimal("cfbatch");
				planJson.put("cfbatch",cfbatch);
				plan = plan.add(cfbatch);
				planJson.put("cfproductdate",rs.getString("cfproductdate"));
				
				planArray.add(planJson);
				//计划数 start
				
				//生产中  start
				String prdId = rs.getString("prdId");
				String batchId = rs.getString("batchId");
				String halgPrdId = rs.getString("halfPrdId");
				
				sql = new StringBuffer("/*dialect*/");
				sql.append(" select t1.fid, t2.fid, ");
				sql.append(" max(t1.fname_l2) as prdName, ");
				sql.append(" max(t.cfstandards) as cfstandard, ");
				sql.append(" max(t2.fnumber) as batchNumber, ");
				sql.append(" sum(t.cfbatchproduct) as cfbatch, ");
				sql.append(" to_char(max(t.cfproductdate), 'yyyy-mm-dd') as cfproductdate ");
				sql.append(" from CT_PRO_Productbos t ");
				sql.append(" inner join t_bd_material t1 on t1.fid = t.cfproductnumberid ");
				sql.append(" inner join  CT_GMP_Batch t2 on t2.fid = t.cfbatchnumberid ");
				sql.append(" where t.cfstorageorgunitid = '9owAAAAUmiHM567U' ");
				sql.append(" and t1.fid = '");
				sql.append(halgPrdId);
				sql.append("' ");
				sql.append(" and t2.fid = '");
				sql.append(batchId);
				sql.append("' ");
				sql.append(" group by t1.fid, t2.fid ");
				
				IRowSet rsProducing = DbUtil.executeQuery(ctx, sql.toString());
				while (rsProducing.next()) {
					JSONObject producingJson = new JSONObject();
					producingJson.put("prdName",rsProducing.getString("prdName"));
					producingJson.put("cfstandard",rsProducing.getString("cfstandard"));
					producingJson.put("batchNumber",rsProducing.getString("batchNumber"));
					cfbatch = rs.getBigDecimal("cfbatch");
					producingJson.put("cfbatch",cfbatch);
					producing = producing.add(cfbatch);
					producingJson.put("cfproductdate",rsProducing.getString("cfproductdate"));
					
					produceingArray.add(producingJson);
					
				}
				//生产中  end
				
				// 已完成 start
				sql = new StringBuffer("/*dialect*/");
				sql.append(" select  t1.fid, t2.fid, ");
				sql.append(" max(t1.fname_l2) as prdName, ");
				sql.append(" max(t.cfmodel) as cfstandard, ");
				sql.append(" max(t2.fnumber) as batchNumber, ");
				sql.append(" sum(t.cfnum) as cfnum, ");
				sql.append(" sum(t.fsetweight) as cfsetweight, ");
				sql.append(" to_char(max(t.cfproductdate), 'yyyy-mm-dd') as cfproductdate ");
				sql.append(" from CT_GMP_SetInventory t ");
				sql.append(" inner join t_bd_material t1 on t1.fid = t.cfproductnameid ");
				sql.append(" inner join  CT_GMP_Batch t2 on t2.fid = t.cfbatchnumberid ");
				sql.append(" where t.cfstorageorgunitid = '9owAAAAUmiHM567U' ");
				sql.append(" and t1.fid = '");
				sql.append(prdId);
				sql.append("' ");
				sql.append(" and t2.fid = '");
				sql.append(batchId);
				sql.append("' ");
				sql.append(" group by t1.fid, t2.fid ");
				
				IRowSet rsProduced = DbUtil.executeQuery(ctx, sql.toString());
				while (rsProduced.next()) {
					JSONObject producedJson = new JSONObject();
					
					producedJson.put("prdName",rsProduced.getString("prdName"));
					producedJson.put("cfstandard",rsProduced.getString("cfstandard"));
					producedJson.put("batchNumber",rsProduced.getString("batchNumber"));
					cfbatch = rs.getBigDecimal("cfnum");
					producedJson.put("cfnum",cfbatch);
					producedNum = producedNum.add(cfbatch);
					cfbatch = rs.getBigDecimal("cfsetweight");
					producedJson.put("cfsetweight",cfbatch);
					producedWeight = producedWeight.add(cfbatch);
					producedJson.put("cfproductdate",rsProduced.getString("cfproductdate"));
					
					produceingArray.add(producedJson);
				}
				// 已完成 end
				
			}
			
			dataJson.put("planQty", plan);
			dataJson.put("producingQty", producing);
			dataJson.put("producedNum", producedNum);
			dataJson.put("producedWeight", producedWeight);
			
			dataJson.put("planArray", planArray);
			dataJson.put("produceingArray", produceingArray);
			dataJson.put("producedArray", producedArray);
			
			resultJson.put("data",dataJson);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			resultJson.put("result", "failure");
			resultJson.put("message", "sql查询出错");
		}
    	
        return resultJson.toString();
    }
    
    /**
     * 获取创客报表数据
     */
    protected String _getMakerRptDataByJson(Context ctx, String jsonData)throws BOSException {
    	
    	JSONObject resultJson = new JSONObject();
    	resultJson.put("result", "success");
    	
    	if (StringUtils.isBlank(jsonData)) {
    		resultJson.put("result", "failure");
			resultJson.put("message", "传入参数不能为空");
			
			return resultJson.toString();
    	}
    	
    	JSONObject conditionJson = JSONObject.fromObject(jsonData);
    	
    	//查询类型  按照 销量bySale 或者 毛利 byProfit
    	String queryType = "";
    	if(!conditionJson.containsKey("queryType")){
    		resultJson.put("result", "failure");
			resultJson.put("message", "没有找到查询类型queryType");
			
			return resultJson.toString();
    	} else {
    		queryType = conditionJson.getString("queryType");
    		if(StringUtils.isBlank(queryType)){
    			resultJson.put("result", "failure");
    			resultJson.put("message", "查询类型queryType不能为空");
    			
    			return resultJson.toString();
    		}
    	}
    	
    	//日期类型  按照年度byYear 或者 月度byMonth
    	String dateType = "";
    	if(!conditionJson.containsKey("dateType")){
    		resultJson.put("result", "failure");
			resultJson.put("message", "没有找到日期类型dateType");
			
			return resultJson.toString();
    	} else {
    		dateType = conditionJson.getString("dateType");
    		if(StringUtils.isBlank(dateType)){
    			resultJson.put("result", "failure");
    			resultJson.put("message", "日期类型dateType不能为空");
    			
    			return resultJson.toString();
    		}
    	}
    	
    	//分组类型  按照 客户byCustomer 或者 产品byProduct  为空时  按照 销售员 统计
    	String groupType = "";
    	if(conditionJson.containsKey("groupType")){
    		groupType = conditionJson.getString("groupType");
    	} 
    	
    	//员工编码   
    	String personNumber = "";
    	if(conditionJson.containsKey("personNumber")){
    		personNumber = conditionJson.getString("personNumber");
    	}
    	
    	//员工名称    模糊查询
    	String personName = "";
    	if(conditionJson.containsKey("personName")){
    		personName = conditionJson.getString("personName");
    	}
    	
    	if("bySale".equalsIgnoreCase(queryType)){
    		//查询日期
        	String queryDate = "";
        	if(!conditionJson.containsKey("queryDate")){
        		resultJson.put("result", "failure");
    			resultJson.put("message", "没有找到查询日期queryDate");
    			
    			return resultJson.toString();
        	} else {
        		queryDate = conditionJson.getString("queryDate");
        		if(StringUtils.isBlank(queryDate)){
        			resultJson.put("result", "failure");
        			resultJson.put("message", "查询日期queryDate不能为空");
        			
        			return resultJson.toString();
        		}
        	}
        	//开始日期
        	String beginDate = "";
        	if("byYear".equalsIgnoreCase(dateType)){
        		beginDate = queryDate.substring(0, 4) + "-01-01";
        	} else if("byMonth".equalsIgnoreCase(dateType)) {
        		beginDate = queryDate.substring(0, 7) + "-01";
        	} else {
        		beginDate = queryDate;
        	}
        	
        	resultJson.put("data", this.getSaleDateByCondition(ctx, beginDate, queryDate, groupType, dateType, personNumber, personName));
        	
    	} else if("byProfit".equalsIgnoreCase(queryType)) {
    		//查询日期 格式 yyyyMM
        	String queryPeriod = "";
        	if(!conditionJson.containsKey("queryPeriod")){
        		resultJson.put("result", "failure");
    			resultJson.put("message", "没有找到查询期间queryPeriod");
    			
    			return resultJson.toString();
        	} else {
        		queryPeriod = conditionJson.getString("queryPeriod");
        		if(StringUtils.isBlank(queryPeriod)){
        			resultJson.put("result", "failure");
        			resultJson.put("message", "查询期间queryPeriod不能为空");
        			
        			return resultJson.toString();
        		}
        	}
        	
        	String beginPeriod = "";
        	if("byYear".equalsIgnoreCase(dateType)){
        		beginPeriod = queryPeriod.substring(0, 4) + "01";
        	} else if("byMonth".equalsIgnoreCase(dateType)) {
        		beginPeriod = queryPeriod;
        	} else {
        		beginPeriod = queryPeriod;
        	}
        	
        	resultJson.put("data", this.getSaleProfitDataByCondition(ctx, beginPeriod, queryPeriod, groupType, dateType, personNumber, personName));
    	}
    	
        return resultJson.toString();
    }
    
    /**
     * 根据查询条件 获取 销量数据
     * @param ctx
     * @param beginDate
     * @param endDate
     * @param groupType
     * @param dateType
     * @param personNumber
     * @param personName
     * @return
     */
    private JSONArray getSaleDateByCondition (Context ctx, String beginDateStr, String endDateStr, String groupType, String dateType, String personNumber, String personName){
    	JSONArray dataArray = new JSONArray();
    	
    	try {
	    	Calendar cal = Calendar.getInstance();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	Date beginDate = sdf.parse(beginDateStr);
	    	Date endDate = sdf.parse(endDateStr);
	    	
	    	StringBuffer sql = new StringBuffer("/*dialect*/");
	    	sql.append(" select personNumber, personName, ");
	    	if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" customerNumber, customerName, ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" materialNumber, materialName, ");
	    	}
			sql.append(" sum(FAllAmount) FAllAmount,sum(FPerYearAllAmount) FPerYearAllAmount,sum(FPerMonthAllAmount) FPerMonthAllAmount ");
			sql.append(" from (");
	    	//当前期间
	    	sql.append(" select tperson.fnumber as personNumber,tperson.fname_l2 as personName, ");
	    	
	    	if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" tcus.fnumber as customerNumber, tcus.fname_l2 as customerName, ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" tm.fnumber as materialNumber, tm.fname_l2 as materialName, ");
	    	}
	    	
	    	sql.append(" tentry.FLocalTaxAmount FAllAmount,0 FPerYearAllAmount,0 FPerMonthAllAmount ");
	    	sql.append(" from t_sd_saleOrder tBill ");
	    	sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid ");
	    	sql.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID ");
	    	sql.append(" inner join t_bd_person tperson on tperson.fid=tbill.FSalePersonID ");
	    	sql.append(" inner join t_bd_material tm on tm.fid = tentry.fmaterialid ");
	    	sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid=tentry.fmaterialid ");
	    	sql.append(" inner join T_BD_MaterialGroupStandard tmgs on ( tmgs.fid=tmgd.FMaterialGroupStandardID and tmgs.fnumber='BaseGroupStandard') ");
	    	sql.append(" where 1=1 " );
	    	sql.append(" and tBill.FBizTypeID != 'd8e80652-0113-1000-e000-04c5c0a812202407435C' ");
	    	sql.append(" and tbill.FBaseStatus in (1,2,4,7) ");
	    	sql.append(" and to_char(tbill.FbizDate,'yyyy-mm-dd') >= '");
	    	sql.append(beginDateStr);
	    	sql.append("' ");
	    	sql.append(" and to_char(tbill.FbizDate,'yyyy-mm-dd') <= '");
	    	sql.append(endDateStr);
	    	sql.append("' ");
	    	
	    	if(StringUtils.isNotBlank(personNumber)){
	    		sql.append(" and tperson.fnumber = '");
	    		sql.append(personNumber);
	    		sql.append("' ");
	    	}
	    	
	    	if(StringUtils.isNotBlank(personName)){
	    		sql.append(" and tperson.fname_l2 like '%");
	    		sql.append(personName);
	    		sql.append("%' ");
	    	}
	    	
	    	sql.append(" and tperson.fidnum = '创客' ");
	    	
	    	//环比  上月
	    	//年度 统计时  开始日期 不变 
			if("byMonth".equalsIgnoreCase(dateType)){
				cal.setTime(beginDate);
				cal.add(Calendar.MONTH, -1);
				beginDateStr=sdf.format(cal.getTime());	
			}
			cal.setTime(endDate);
			cal.add(Calendar.MONTH, -1);
			endDateStr=sdf.format(cal.getTime());
	    	
			sql.append(" union all ");
	    	sql.append(" select tperson.fnumber as personNumber,tperson.fname_l2 as personName, ");
	    	
	    	if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" tcus.fnumber as customerNumber, tcus.fname_l2 as customerName, ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" tm.fnumber as materialNumber, tm.fname_l2 as materialName, ");
	    	}
	    	
	    	sql.append(" 0 FAllAmount,0 FPerYearAllAmount,tentry.FLocalTaxAmount FPerMonthAllAmount ");
	    	sql.append(" from t_sd_saleOrder tBill ");
	    	sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid ");
	    	sql.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID ");
	    	sql.append(" inner join t_bd_person tperson on tperson.fid=tbill.FSalePersonID ");
	    	sql.append(" inner join t_bd_material tm on tm.fid = tentry.fmaterialid ");
	    	sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid=tentry.fmaterialid ");
	    	sql.append(" inner join T_BD_MaterialGroupStandard tmgs on ( tmgs.fid=tmgd.FMaterialGroupStandardID and tmgs.fnumber='BaseGroupStandard') ");
	    	sql.append(" where 1=1 ");
	    	sql.append(" and tBill.FBizTypeID != 'd8e80652-0113-1000-e000-04c5c0a812202407435C' ");
	    	sql.append(" and tbill.FBaseStatus in (1,2,4,7) ");
	    	sql.append(" and to_char(tbill.FbizDate,'yyyy-mm-dd') >= '");
	    	sql.append(beginDateStr);
	    	sql.append("' ");
	    	sql.append(" and to_char(tbill.FbizDate,'yyyy-mm-dd') <= '");
	    	sql.append(endDateStr);
	    	sql.append("' ");
	    	
	    	if(StringUtils.isNotBlank(personNumber)){
	    		sql.append(" and tperson.fnumber = '");
	    		sql.append(personNumber);
	    		sql.append("' ");
	    	}
	    	
	    	if(StringUtils.isNotBlank(personName)){
	    		sql.append(" and tperson.fname_l2 like '%");
	    		sql.append(personName);
	    		sql.append("%' ");
	    	}
	    	
	    	sql.append(" and tperson.fidnum = '创客' ");
	    	
	    	//同比  去年
	    	if("byMonth".equalsIgnoreCase(dateType)){
	    		cal.setTime(beginDate);
				cal.add(Calendar.YEAR, -1);
				beginDateStr=sdf.format(cal.getTime());
	    	} else if ("byYear".equalsIgnoreCase(dateType)){
	    		cal.setTime(beginDate);
				cal.add(Calendar.YEAR, -1);
				cal.add(Calendar.MONTH, (-1)*beginDate.getMonth());
				cal.add(Calendar.DAY_OF_MONTH, (-1)*beginDate.getDate()+1);
				beginDateStr=sdf.format(cal.getTime());
	    	}else {
	    		beginDateStr=sdf.format(cal.getTime());
	    	}
	    	
			cal.setTime(endDate);
			cal.add(Calendar.YEAR, -1);
			endDateStr=sdf.format(cal.getTime());
	    	
			sql.append(" union all ");
	    	sql.append(" select tperson.fnumber as personNumber,tperson.fname_l2 as personName, ");
	    	
	    	if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" tcus.fnumber as customerNumber, tcus.fname_l2 as customerName, ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" tm.fnumber as materialNumber, tm.fname_l2 as materialName, ");
	    	}
	    	
	    	sql.append(" 0 FAllAmount,tentry.FLocalTaxAmount FPerYearAllAmount,0 FPerMonthAllAmount ");
	    	sql.append(" from t_sd_saleOrder tBill ");
	    	sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid ");
	    	sql.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID ");
	    	sql.append(" inner join t_bd_person tperson on tperson.fid=tbill.FSalePersonID ");
	    	sql.append(" inner join t_bd_material tm on tm.fid = tentry.fmaterialid ");
	    	sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid=tentry.fmaterialid ");
	    	sql.append(" inner join T_BD_MaterialGroupStandard tmgs on ( tmgs.fid=tmgd.FMaterialGroupStandardID and tmgs.fnumber='BaseGroupStandard') ");
	    	sql.append(" where 1=1 ");
	    	sql.append(" and tBill.FBizTypeID != 'd8e80652-0113-1000-e000-04c5c0a812202407435C' ");
	    	sql.append(" and tbill.FBaseStatus in (1,2,4,7) ");
	    	sql.append(" and to_char(tbill.FbizDate,'yyyy-mm-dd') >= '");
	    	sql.append(beginDateStr);
	    	sql.append("' ");
	    	sql.append(" and to_char(tbill.FbizDate,'yyyy-mm-dd') <= '");
	    	sql.append(endDateStr);
	    	sql.append("' ");
	    	
	    	if(StringUtils.isNotBlank(personNumber)){
	    		sql.append(" and tperson.fnumber = '");
	    		sql.append(personNumber);
	    		sql.append("' ");
	    	}
	    	
	    	if(StringUtils.isNotBlank(personName)){
	    		sql.append(" and tperson.fname_l2 like '%");
	    		sql.append(personName);
	    		sql.append("%' ");
	    	}
	    	
	    	sql.append(" and tperson.fidnum = '创客' ");
			
	    	sql.append(") ");
	    	
	    	sql.append(" group by personNumber, personName ");
	    	
	    	if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" , customerNumber, customerName ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" , materialNumber, materialName ");
	    	}
			
			sql.append(" order by FAllAmount desc ");

			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while (rs.next()) {
				JSONObject dataObj = new JSONObject();
				
				dataObj.put("personNumber", rs.getString("personNumber"));
				dataObj.put("personName", rs.getString("personName"));
				
				if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
					dataObj.put("customerNumber", rs.getString("customerNumber"));
					dataObj.put("customerName", rs.getString("customerName"));
				} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
					dataObj.put("materialNumber", rs.getString("materialNumber"));
					dataObj.put("materialName", rs.getString("materialName"));
				}
				BigDecimal FAllAmount = rs.getBigDecimal("FAllAmount");
				FAllAmount = FAllAmount == null ? BigDecimal.ZERO : FAllAmount.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP);
				dataObj.put("FAllAmount",FAllAmount);
				BigDecimal FPerYearAllAmount = rs.getBigDecimal("FPerYearAllAmount");
				FPerYearAllAmount = FPerYearAllAmount == null ? BigDecimal.ZERO : FPerYearAllAmount.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP);
				dataObj.put("FPerYearAllAmount",FPerYearAllAmount);
				BigDecimal FPerMonthAllAmount = rs.getBigDecimal("FPerMonthAllAmount");
				FPerMonthAllAmount = FPerMonthAllAmount == null ? BigDecimal.ZERO : FPerMonthAllAmount.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP);
				if("byMonth".equalsIgnoreCase(dateType)){
					dataObj.put("FPerMonthAllAmount",FPerMonthAllAmount);
				} else if ("byYear".equalsIgnoreCase(dateType)){
					dataObj.put("FPerMonthAllAmount",BigDecimal.ZERO);
				} else {
					dataObj.put("FPerMonthAllAmount",BigDecimal.ZERO);
				}
				
				dataArray.add(dataObj);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dataArray.toString());
		
    	return dataArray;
    }
    
    /**
     * 根据查询条件 获取 毛利信息
     * @param ctx
     * @param beginPeriod
     * @param endPeriod
     * @param groupType
     * @param dateType
     * @param personNumber
     * @param personName
     * @return
     */
    private JSONArray getSaleProfitDataByCondition (Context ctx, String beginPeriodStr, String endPeriodStr, String groupType, String dateType, String personNumber, String personName) {
    	JSONArray dataArray = new JSONArray();
    	
    	try {
    		
    		Calendar cal = Calendar.getInstance();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	    	
	    	Date beginPeriod = sdf.parse(beginPeriodStr);
	    	Date endPeriod = sdf.parse(endPeriodStr);
    		
    		StringBuffer sql = new StringBuffer("/*dialect*/");
    		
    		sql.append(" select personNumber, personName, ");
	    	if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" customerNumber, customerName, ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" materialNumber, materialName, ");
	    	}
			sql.append(" sum(FAllAmount) FAllAmount, sum(profit) profit, ");
			sql.append(" sum(FPerYearProfit) FPerYearProfit, sum(FPerMonthProfit) FPerMonthProfit ");
			sql.append(" from (");
    		
    		sql.append(" select tperson.fnumber     as personNumber, ");
    		sql.append(" tperson.fname_l2    as personName, ");
 
    		if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" tcus.fnumber as customerNumber, tcus.fname_l2 as customerName, ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" tm.fnumber as materialNumber, tm.fname_l2 as materialName, ");
	    	}
    		
    		sql.append(" tentry.flocalamount FAllAmount, ");
    		sql.append(" (tentry.flocalamount - nvl(tentry.cfnbprice,0)*tentry.fqty) as profit, ");
    		sql.append(" 0                   FPerYearProfit, ");
    		sql.append(" 0                   FPerMonthProfit ");
    		sql.append(" from t_im_saleissuebill tBill ");
    		sql.append(" inner join t_im_saleissueentry tentry on tentry.fparentid = tbill.fid ");
    		sql.append(" inner join t_bd_customer tcus on tcus.fid = tentry.fordercustomerid ");
    		sql.append(" inner join t_bd_person tperson on tperson.fid = tentry.FSalePersonID ");
    		sql.append(" inner join t_bd_material tm on tm.fid = tentry.fmaterialid ");
    		sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid = tentry.fmaterialid ");
    		sql.append(" inner join T_BD_MaterialGroupStandard tmgs on (tmgs.fid = tmgd.FMaterialGroupStandardID and tmgs.fnumber = 'BaseGroupStandard') ");
    		sql.append(" where 1 = 1 ");
    		sql.append(" and tBill.FBizTypeID != 'd8e80652-0113-1000-e000-04c5c0a812202407435C' ");
    		sql.append(" and tbill.FBaseStatus in (1, 2, 4, 7) ");
    		sql.append(" and to_char(tbill.FbizDate, 'yyyymm') >= '");
    		sql.append(beginPeriodStr);
    		sql.append("' ");
    		sql.append(" and to_char(tbill.FbizDate, 'yyyymm') <= '");
    		sql.append(endPeriodStr);
    		sql.append("' ");
    		sql.append(" and tperson.fidnum = '创客' ");
    		sql.append("");
    		
    		if(StringUtils.isNotBlank(personNumber)){
	    		sql.append(" and tperson.fnumber = '");
	    		sql.append(personNumber);
	    		sql.append("' ");
	    	}
	    	
	    	if(StringUtils.isNotBlank(personName)){
	    		sql.append(" and tperson.fname_l2 like '%");
	    		sql.append(personName);
	    		sql.append("%' ");
	    	}
    		
	    	sql.append(" union all ");
	    	//去年
	    	cal.setTime(beginPeriod);
			cal.add(Calendar.YEAR, -1);
			if("byYear".equalsIgnoreCase(dateType)){
				cal.add(Calendar.MONTH, (-1)*beginPeriod.getMonth());
				cal.add(Calendar.DAY_OF_MONTH, (-1)*beginPeriod.getDate()+1);	
			}
			beginPeriodStr=sdf.format(cal.getTime());
	    	
			cal.setTime(endPeriod);
			cal.add(Calendar.YEAR, -1);
			endPeriodStr=sdf.format(cal.getTime());
	    	
	    	sql.append(" select tperson.fnumber     as personNumber, ");
    		sql.append(" tperson.fname_l2    as personName, ");
 
    		if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" tcus.fnumber as customerNumber, tcus.fname_l2 as customerName, ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" tm.fnumber as materialNumber, tm.fname_l2 as materialName, ");
	    	}
    		
    		sql.append(" 0 FAllAmount, ");
    		sql.append(" 0 as profit, ");
    		sql.append(" (tentry.flocalamount - nvl(tentry.cfnbprice,0)*tentry.fqty) as FPerYearProfit, ");
    		sql.append(" 0 as FPerMonthProfit ");
    		sql.append(" from t_im_saleissuebill tBill ");
    		sql.append(" inner join t_im_saleissueentry tentry on tentry.fparentid = tbill.fid ");
    		sql.append(" inner join t_bd_customer tcus on tcus.fid = tentry.fordercustomerid ");
    		sql.append(" inner join t_bd_person tperson on tperson.fid = tentry.FSalePersonID ");
    		sql.append(" inner join t_bd_material tm on tm.fid = tentry.fmaterialid ");
    		sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid = tentry.fmaterialid ");
    		sql.append(" inner join T_BD_MaterialGroupStandard tmgs on (tmgs.fid = tmgd.FMaterialGroupStandardID and tmgs.fnumber = 'BaseGroupStandard') ");
    		sql.append(" where 1 = 1 ");
    		sql.append(" and tBill.FBizTypeID != 'd8e80652-0113-1000-e000-04c5c0a812202407435C' ");
    		sql.append(" and tbill.FBaseStatus in (1, 2, 4, 7) ");
    		sql.append(" and to_char(tbill.FbizDate, 'yyyymm') >= '");
    		sql.append(beginPeriodStr);
    		sql.append("' ");
    		sql.append(" and to_char(tbill.FbizDate, 'yyyymm') <= '");
    		sql.append(endPeriodStr);
    		sql.append("' ");
    		sql.append(" and tperson.fidnum = '创客' ");
    		sql.append("");
    		
    		if(StringUtils.isNotBlank(personNumber)){
	    		sql.append(" and tperson.fnumber = '");
	    		sql.append(personNumber);
	    		sql.append("' ");
	    	}
	    	
	    	if(StringUtils.isNotBlank(personName)){
	    		sql.append(" and tperson.fname_l2 like '%");
	    		sql.append(personName);
	    		sql.append("%' ");
	    	}
	    	
	    	sql.append(" union all ");
	    	//上月
	    	//年度   截止日期 改 -1  开始日期 不变  
	    	//月度   开始日期 截止日期 都  月份-1
			if("byMonth".equalsIgnoreCase(dateType)){
				cal.setTime(beginPeriod);
				cal.add(Calendar.MONTH, -1);
				beginPeriodStr=sdf.format(cal.getTime());	
				
				cal.setTime(endPeriod);
				cal.add(Calendar.MONTH, -1);
				endPeriodStr=sdf.format(cal.getTime());
			} else {
				cal.setTime(beginPeriod);
				beginPeriodStr=sdf.format(cal.getTime());
				
				cal.setTime(endPeriod);
				cal.add(Calendar.MONTH, -1);
				endPeriodStr=sdf.format(cal.getTime());
			}
			
	    	
	    	sql.append(" select tperson.fnumber     as personNumber, ");
    		sql.append(" tperson.fname_l2    as personName, ");
 
    		if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" tcus.fnumber as customerNumber, tcus.fname_l2 as customerName, ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" tm.fnumber as materialNumber, tm.fname_l2 as materialName, ");
	    	}
    		
    		sql.append(" 0 FAllAmount, ");
    		sql.append(" 0 as profit, ");
    		sql.append(" 0 as FPerYearProfit, ");
    		sql.append(" (tentry.flocalamount - nvl(tentry.cfnbprice,0)*tentry.fqty) as FPerMonthProfit ");
    		sql.append(" from t_im_saleissuebill tBill ");
    		sql.append(" inner join t_im_saleissueentry tentry on tentry.fparentid = tbill.fid ");
    		sql.append(" inner join t_bd_customer tcus on tcus.fid = tentry.fordercustomerid ");
    		sql.append(" inner join t_bd_person tperson on tperson.fid = tentry.FSalePersonID ");
    		sql.append(" inner join t_bd_material tm on tm.fid = tentry.fmaterialid ");
    		sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid = tentry.fmaterialid ");
    		sql.append(" inner join T_BD_MaterialGroupStandard tmgs on (tmgs.fid = tmgd.FMaterialGroupStandardID and tmgs.fnumber = 'BaseGroupStandard') ");
    		sql.append(" where 1 = 1 ");
    		sql.append(" and tBill.FBizTypeID != 'd8e80652-0113-1000-e000-04c5c0a812202407435C' ");
    		sql.append(" and tbill.FBaseStatus in (1, 2, 4, 7) ");
    		sql.append(" and to_char(tbill.FbizDate, 'yyyymm') >= '");
    		sql.append(beginPeriodStr);
    		sql.append("' ");
    		sql.append(" and to_char(tbill.FbizDate, 'yyyymm') <= '");
    		sql.append(endPeriodStr);
    		sql.append("' ");
    		sql.append(" and tperson.fidnum = '创客' ");
    		sql.append("");
    		
    		if(StringUtils.isNotBlank(personNumber)){
	    		sql.append(" and tperson.fnumber = '");
	    		sql.append(personNumber);
	    		sql.append("' ");
	    	}
	    	
	    	if(StringUtils.isNotBlank(personName)){
	    		sql.append(" and tperson.fname_l2 like '%");
	    		sql.append(personName);
	    		sql.append("%' ");
	    	}
	    	
	    	sql.append(") ");
	    	
	    	sql.append(" group by personNumber, personName ");
	    	
	    	if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
	    		sql.append(" , customerNumber, customerName ");
	    	} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
	    		sql.append(" , materialNumber, materialName ");
	    	}
			
			sql.append(" order by FAllAmount desc ");
			
	    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
	    	while (rs.next()){
	    		JSONObject dataObj = new JSONObject();
				
				dataObj.put("personNumber", rs.getString("personNumber"));
				dataObj.put("personName", rs.getString("personName"));
				
				if(StringUtils.isNotBlank(groupType) && "byCustomer".equalsIgnoreCase(groupType)){
					dataObj.put("customerNumber", rs.getString("customerNumber"));
					dataObj.put("customerName", rs.getString("customerName"));
				} else if (StringUtils.isNotBlank(groupType) && "byProduct".equalsIgnoreCase(groupType)) {
					dataObj.put("materialNumber", rs.getString("materialNumber"));
					dataObj.put("materialName", rs.getString("materialName"));
				}
				
				BigDecimal FAllAmount = rs.getBigDecimal("FAllAmount");
				FAllAmount = FAllAmount == null ? BigDecimal.ZERO : FAllAmount.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP);
				dataObj.put("FAllAmount",FAllAmount);
				BigDecimal profit = rs.getBigDecimal("profit");
				profit = profit == null ? BigDecimal.ZERO : profit.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP);
				dataObj.put("profit",profit);
				BigDecimal FPerYearProfit = rs.getBigDecimal("FPerYearProfit");
				FPerYearProfit = FPerYearProfit == null ? BigDecimal.ZERO : FPerYearProfit.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP);
				dataObj.put("FPerYearProfit",FPerYearProfit);
				BigDecimal FPerMonthProfit = rs.getBigDecimal("FPerMonthProfit");
				FPerMonthProfit = FPerMonthProfit == null ? BigDecimal.ZERO : FPerMonthProfit.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP);
				
				if("byMonth".equalsIgnoreCase(dateType)){ 
					dataObj.put("FPerMonthProfit",FPerMonthProfit);
				} else if("byYear".equalsIgnoreCase(dateType)) {
					dataObj.put("FPerMonthProfit",BigDecimal.ZERO);
				} else {
					dataObj.put("FPerMonthProfit",BigDecimal.ZERO);
				}
				
				
				dataArray.add(dataObj);
	    	}
    		
    	} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dataArray.toString());
    	
    	return dataArray;
    }
}