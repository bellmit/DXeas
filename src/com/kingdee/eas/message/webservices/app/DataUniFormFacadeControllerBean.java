package com.kingdee.eas.message.webservices.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class DataUniFormFacadeControllerBean extends AbstractDataUniFormFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.message.webservices.app.DataUniFormFacadeControllerBean");

	/**
	 * 统一数据获取入口
	 */
	protected String _getDataFromJsonCondition(Context ctx, String jsonStr) throws BOSException {
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", "Success");
		resultJson.put("messgage", "success");
		try {
			JSONObject jsonObj=JSONObject.fromObject(jsonStr);
			if(!jsonObj.containsKey("role")) {
				throw new Exception("角色不能为空！");
			}
			if(!jsonObj.containsKey("userNum")) {
				throw new Exception("用户名不能为空！");
			}
			if(!jsonObj.containsKey("queryType")) {
				throw new Exception("查询类型不能为空！");
			}
			if(!jsonObj.containsKey("beginDate")) {
				throw new Exception("开始日期不能为空！");
			}
			if(!jsonObj.containsKey("endDate")) {
				throw new Exception("结束日期不能为空！");
			}
			
			String role=jsonObj.getString("role");//角色
			String userNum=jsonObj.getString("userNum");
			String queryType=jsonObj.getString("queryType");
			String personID=null;
			String userID=null;
			StringBuffer sql=new StringBuffer();
			sql.append(" select tuser.fid FUserID,tp.fid FPersonID,tp.fname_l2 ");
			sql.append(" from t_pm_user tuser");
			sql.append(" inner join t_bd_person tp on tp.fid=tuser.FPersonId");
			sql.append(" where tuser.FNumber='").append(userNum).append("'");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				userID=rs.getString("FUserID");
				personID=rs.getString("fname_l2");
			}
			rs.close();
			if(StringUtils.isBlank(personID)) {
				throw new Exception("用户名不存在或没有相对应的职员！");
			}
			
			String beginDate=jsonObj.containsKey("beginDate")?jsonObj.getString("beginDate"):null;
			String endDate=jsonObj.containsKey("endDate")?jsonObj.getString("endDate"):null;
			String orgNums=new String();//组织范围
			
			ArrayList<String> userOrgNumList=new ArrayList<String>();
			//用户默认组织范围
			sql.setLength(0);
			sql.append(" select torg.fnumber ");
			sql.append(" from t_pm_orgRange tRange");
			sql.append(" inner join t_org_baseUnit torg on torg.fid=tRange.FOrgID");
			sql.append(" where FUserID='").append(userID).append("'");
			sql.append(" and FType=10");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			while (rs.next()){
				userOrgNumList.add(rs.getString("FNumber"));
			}
			rs.close();
			
			ArrayList<String> orgNumList=new ArrayList<String>();
			if(jsonObj.containsKey("orgNums")) {
				JSONArray ja=jsonObj.getJSONArray("orgNums");
				for(int index=0;index<ja.size();index++) {
					if(userOrgNumList.contains(ja.getString(index))) {
						orgNumList.add(ja.getString(index));
					}
				}
			}
			if(orgNumList.size()<=0) {
				orgNumList=userOrgNumList;
			}
			for (String orgNum : orgNumList) {
				if(StringUtils.isNotEmpty(orgNums)) {
					orgNums+=",";
				}
				orgNums=orgNums+"'"+orgNum+"'";
			}
			orgNumList=null;
			userOrgNumList=null;
			
			if(queryType.equalsIgnoreCase("byday")) {
				resultJson.put("dataCol", getSaleOrderDataBySalePersonByDay(ctx,  role,orgNums, beginDate, endDate, personID));
			}else if (queryType.equalsIgnoreCase("bymonth")) {
				resultJson.put("dataCol", getSaleOrderDataBySalePersonByMonth(ctx, role,orgNums, beginDate, endDate, personID));
			}if(queryType.equalsIgnoreCase("byManageUnit")) {//经营单元
				resultJson.put("dataCol",getSaleOrderDataByManageUnit(ctx, role,orgNums, beginDate, endDate, personID));
			}
			
		}catch(Exception err) {
			throw new BOSException(err);
		}
		return resultJson.toString();
	}
	/**
	 * 通过组织编码、销售员来取销售订单数据
	 * @param ctx
	 * @param OrgNums
	 * @param salePersonID
	 * @return
	 * @throws BOSException 
	 */
    private JSONArray getSaleOrderDataBySalePersonByDay(Context ctx,String role,String orgNums,String beginDate,String endDate,String personID) throws BOSException {
    	JSONArray dataJa=new JSONArray();
    	try {
    		//查询销售订单数据
    		StringBuffer sql=new StringBuffer();
			sql.append(" select to_char(tbill.FBizDate,'yyyy-MM-dd') FBizDate,isnull(sum(tentry.fqty),0) FQty,isnull(sum(tentry.FLocalTaxAmount),0) FAllAmount");
			sql.append(" from t_sd_saleOrder tBill");
			sql.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID");
			sql.append(" inner join T_ORG_Sale tSOrg on tSOrg.fid=tBill.FSaleOrgUnitID");
			if(role.equals("saleperson")) {
				sql.append(" inner join t_bd_person tperson on tperson.fid=tbill.FSalePersonID");
			}
			sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid");
			sql.append(" where 1=1");
			sql.append(" and tBill.FBizTypeID!='d8e80652-0113-1000-e000-04c5c0a812202407435C'");
			sql.append(" and tcus.FIsInternalCompany=0 ");//是否集团内公司
			sql.append(" and (tbill.FBaseStatus=4 or tbill.FBaseStatus=7)");//审核、关闭
			sql.append(" and tbill.FbizDate>={d '").append(beginDate).append("'}");
			sql.append(" and tbill.FbizDate<={d '").append(endDate).append("'}");
			if(StringUtils.isNotEmpty(orgNums)) {
				sql.append(" and tSOrg.fnumber in (").append(orgNums).append(")");
			}
			if(role.equals("saleperson")) {
				sql.append(" and tperson.fname_l2='").append(personID).append("'");
			}
			sql.append(" group by tBill.FBizDate ");
			sql.append(" order by tBill.FBizDate asc");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date lastDate=null,tempDate;
			while(rs.next()) {
				tempDate=sdf.parse(rs.getString("FbizDate"));
				if(lastDate==null) {//上一次的日期
					lastDate=sdf.parse(beginDate);//开始日期.
					cal.setTime(lastDate);
					cal.add(Calendar.DAY_OF_MONTH, -1);
					lastDate=cal.getTime();
				}
				while((tempDate.getTime()-lastDate.getTime())/(24*60*60*1000)>1) {//天数相差大于1
					cal.setTime(lastDate);
					cal.add(Calendar.DAY_OF_MONTH, 1);
					lastDate=cal.getTime();
					
					JSONObject dataJson=new JSONObject();
					dataJson.put("bizDate", sdf.format(lastDate));
					dataJson.put("qty",0);
					dataJson.put("allAmount", 0);
					dataJa.add(dataJson);
				}
				
				JSONObject dataJson=new JSONObject();
				dataJson.put("bizDate", rs.getString("FBizDate"));
				dataJson.put("qty", rs.getBigDecimal("FQty").setScale(4, BigDecimal.ROUND_HALF_UP));
				dataJson.put("allAmount", rs.getBigDecimal("FAllAmount").setScale(4, BigDecimal.ROUND_HALF_UP));
				dataJa.add(dataJson);
				lastDate=tempDate;
			}
			rs.close();
			
			tempDate=sdf.parse(endDate);//开始日期.
			while((tempDate.getTime()-lastDate.getTime())/(24*60*60*1000)>=1) {//月份差>1
				cal.setTime(lastDate);
				cal.add(Calendar.DAY_OF_MONTH, 1);
				lastDate=cal.getTime();
				
				JSONObject dataJson=new JSONObject();
				dataJson.put("bizDate", sdf.format(lastDate));
				dataJson.put("qty",0);
				dataJson.put("allAmount", 0);
				dataJa.add(dataJson);
			}
    	
    	}catch(Exception e) {
    		throw new BOSException(e);
    	}
    	return dataJa;
    }
    /**
	 * 通过组织编码、销售员来取销售订单数据
	 * @param ctx
	 * @param OrgNums
	 * @param salePersonID
	 * @return
	 * @throws BOSException 
	 */
    private JSONArray getSaleOrderDataBySalePersonByMonth(Context ctx,String role,String orgNums,String beginDate,String endDate,String personID) throws BOSException {
    	JSONArray dataJa=new JSONArray();
    	try {
    		//查询销售订单数据
    		StringBuffer sql=new StringBuffer();
    		sql.append(" select FBizDate,sum(Fqty) FQty,sum(FAllamount) FAllAmount");
    		sql.append(" from (");
			sql.append(" select subString(to_char(tbill.FBizDate,'yyyy-MM-dd'),0,7) FBizDate,isnull(tentry.fqty,0) FQty,isnull(tentry.FLocalTaxAmount,0) FAllAmount");
			sql.append(" from t_sd_saleOrder tBill");
			sql.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID");
			sql.append(" inner join T_ORG_Sale tSOrg on tSOrg.fid=tBill.FSaleOrgUnitID");
			if(role.equals("saleperson")) {
				sql.append(" inner join t_bd_person tperson on tperson.fid=tbill.FSalePersonID");
			}
			sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid");
			sql.append(" where 1=1");
			sql.append(" and tBill.FBizTypeID!='d8e80652-0113-1000-e000-04c5c0a812202407435C'");
			sql.append(" and tcus.FIsInternalCompany=0 ");//是否集团内公司
			sql.append(" and (tbill.FBaseStatus=4 or tbill.FBaseStatus=7)");//审核、关闭
			sql.append(" and subString(to_char(tbill.FbizDate,'yyyy-MM-dd'),0,7)>='").append(beginDate.subSequence(0, 7)).append("'");
			sql.append(" and subString(to_char(tbill.FbizDate,'yyyy-MM-dd'),0,7)<='").append(endDate.subSequence(0, 7)).append("'");
			if(StringUtils.isNotEmpty(orgNums)) {
				sql.append(" and tSOrg.fnumber in (").append(orgNums).append(")");
			}
			if(role.equals("saleperson")) {
				sql.append(" and tperson.fname_l2='").append(personID).append("'");
			}
			sql.append(" )");		
			sql.append(" group by FBizDate ");
			sql.append(" order by FBizDate asc");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date lastDate=null,tempDate;
			
			while(rs.next()) {
				tempDate=sdf.parse(rs.getString("FbizDate")+"-01");
				if(lastDate==null) {//上一次的日期
					//lastDate=tempDate;
					lastDate=sdf.parse(beginDate);//开始日期.
					cal.setTime(lastDate);
					cal.add(Calendar.MONTH, -1);
					lastDate=cal.getTime();
				}
				while(getMonthDiff(lastDate, tempDate)>1) {//月份差>1
					cal.setTime(lastDate);
					cal.add(Calendar.MONTH, 1);
					lastDate=cal.getTime();
					
					JSONObject dataJson=new JSONObject();
					dataJson.put("bizDate", sdf.format(lastDate).substring(0,7));
					dataJson.put("qty",0);
					dataJson.put("allAmount", 0);
					dataJa.add(dataJson);
				}
				
				
				JSONObject dataJson=new JSONObject();
				dataJson.put("bizDate", rs.getString("FBizDate"));
				dataJson.put("qty", rs.getBigDecimal("FQty").setScale(4, BigDecimal.ROUND_HALF_UP));
				dataJson.put("allAmount", rs.getBigDecimal("FAllAmount").setScale(4, BigDecimal.ROUND_HALF_UP));
				dataJa.add(dataJson);
				lastDate=tempDate;
			}
			rs.close();
			tempDate=sdf.parse(endDate);//开始日期.
			while(getMonthDiff(lastDate, tempDate)>1) {//月份差>1
				cal.setTime(lastDate);
				cal.add(Calendar.MONTH, 1);
				lastDate=cal.getTime();
				
				JSONObject dataJson=new JSONObject();
				dataJson.put("bizDate", sdf.format(lastDate).substring(0,7));
				dataJson.put("qty",0);
				dataJson.put("allAmount", 0);
				dataJa.add(dataJson);
			}
			
    	
    	}catch(Exception e) {
    		throw new BOSException(e);
    	}
    	return dataJa;
    }
    //计算月份差
    public static int getMonthDiff(Date start, Date end) {
        if (start.after(end)) {
           /* Date t = start;
            start = end;
            end = t;*/
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar temp = Calendar.getInstance();
        temp.setTime(end);
        temp.add(Calendar.DATE, 1);

        int year = endCalendar.get(Calendar.YEAR)- startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

        if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month + 1;
        } else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month;
        } else if ((startCalendar.get(Calendar.DATE) == 1)&& (temp.get(Calendar.DATE) != 1)) {
            return year * 12 + month;
        } else {
            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }
    }
    /**
	 * 通过组织编码、经营单元
	 * @param ctx
	 * @param OrgNums
	 * @param salePersonID
	 * @return
	 * @throws BOSException 
	 */
    private JSONArray getSaleOrderDataByManageUnit(Context ctx,String role,String orgNums,String beginDateStr,String endDateStr,String personID) throws BOSException {
    	JSONArray dataJa=new JSONArray();
    	try {
    		Calendar cal=Calendar.getInstance();
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    		Date beginDate=sdf.parse(beginDateStr);
    		Date endDate=sdf.parse(endDateStr);
    		
    		//查询销售订单数据  经营单元 本期 同比 环比 
    		StringBuffer sql=new StringBuffer();
    		sql.append(" select fnumber ,fname ,sum(FAllAmount) FAllAmount,sum(FPerYearAllAmount) FPerYearAllAmount,sum(FPerMonthAllAmount) FPerMonthAllAmount");
    		sql.append(" from (");
    		//本期
    		sql.append(" select tjy.fnumber,tjy.fname_l2 FName,isnull(tentry.FLocalTaxAmount,0) FAllAmount,0 FPerYearAllAmount,0 FPerMonthAllAmount ");
			sql.append(" from t_sd_saleOrder tBill");
			sql.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID");
			sql.append(" inner join T_ORG_Sale tSOrg on tSOrg.fid=tBill.FSaleOrgUnitID");
			if(role.equals("saleperson")) {
				sql.append(" inner join t_bd_person tperson on tperson.fid=tbill.FSalePersonID");
			}
			sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid");
			sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid=tentry.fmaterialid");
			sql.append(" inner join T_BD_MaterialGroupStandard tmgs on ( tmgs.fid=tmgd.FMaterialGroupStandardID and tmgs.fnumber='001')");
			sql.append(" INNER JOIN T_BD_SaleGroup tsg ON tsg.FID = tbill.FSaleGroupID");//销售组
			sql.append(" INNER JOIN CT_BI_SaleGroupMapEntry tsgme ON tsgme.CFSaleGroupID = tsg.fid ");
			sql.append(" INNER JOIN CT_BI_SaleGroupMap tsgm ON tsgm.fid = tsgme.fparentid ");
			sql.append(" INNER JOIN t_bd_period tp ON tp.fid = tsgm.CFPeriodID AND tp.fperiodyear = year(tbill.fbizDate) AND tp.fperiodnumber = month(tbill.fbizDate)");
			sql.append(" INNER JOIN CT_BI_JyUnit tjy ON tjy.fid = tsgme.CFJyUnitID ");//经营单元
			sql.append(" inner join T_BI_JyUnitTREE tr on tr.FID=tjy.FTreeID");
			sql.append(" inner join T_BI_JyUnitTREE trp on trp.fid=tr.FParentID");
			sql.append(" where 1=1");
			sql.append(" and tBill.FBizTypeID!='d8e80652-0113-1000-e000-04c5c0a812202407435C'");
			sql.append(" and tcus.FIsInternalCompany=0 ");//是否集团内公司
			sql.append(" and (tbill.FBaseStatus=4 or tbill.FBaseStatus=7)");//审核、关闭
			sql.append(" and tbill.FbizDate>={d '").append(beginDateStr).append("'}");
			sql.append(" and tbill.FbizDate<={d '").append(endDateStr).append("'}");
			if(StringUtils.isNotEmpty(orgNums)) {
				sql.append(" and tSOrg.fnumber in (").append(orgNums).append(")");
			}
			if(role.equals("saleperson")) {
				sql.append(" and tperson.fname_l2='").append(personID).append("'");
			}
			//同比
			cal.setTime(beginDate);
			cal.add(Calendar.YEAR, -1);
			beginDateStr=sdf.format(cal.getTime());
			cal.setTime(endDate);
			cal.add(Calendar.YEAR, -1);
			endDateStr=sdf.format(cal.getTime());
			
			sql.append(" union all");
			sql.append(" select tjy.fnumber,tjy.fname_l2 FName,0 FAllAmount,isnull(tentry.FLocalTaxAmount,0) FPerYearAllAmount,0 FPerMonthAllAmount ");
			sql.append(" from t_sd_saleOrder tBill");
			sql.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID");
			sql.append(" inner join T_ORG_Sale tSOrg on tSOrg.fid=tBill.FSaleOrgUnitID");
			if(role.equals("saleperson")) {
				sql.append(" inner join t_bd_person tperson on tperson.fid=tbill.FSalePersonID");
			}
			sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid");
			sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid=tentry.fmaterialid");
			sql.append(" inner join T_BD_MaterialGroupStandard tmgs on ( tmgs.fid=tmgd.FMaterialGroupStandardID and tmgs.fnumber='001')");
			sql.append(" INNER JOIN T_BD_SaleGroup tsg ON tsg.FID = tbill.FSaleGroupID");//销售组
			sql.append(" INNER JOIN CT_BI_SaleGroupMapEntry tsgme ON tsgme.CFSaleGroupID = tsg.fid ");
			sql.append(" INNER JOIN CT_BI_SaleGroupMap tsgm ON tsgm.fid = tsgme.fparentid ");
			sql.append(" INNER JOIN t_bd_period tp ON tp.fid = tsgm.CFPeriodID AND tp.fperiodyear = year(tbill.fbizDate) AND tp.fperiodnumber = month(tbill.fbizDate)");
			sql.append(" INNER JOIN CT_BI_JyUnit tjy ON tjy.fid = tsgme.CFJyUnitID ");//经营单元
			sql.append(" inner join T_BI_JyUnitTREE tr on tr.FID=tjy.FTreeID");
			sql.append(" inner join T_BI_JyUnitTREE trp on trp.fid=tr.FParentID");
			sql.append(" where 1=1");
			sql.append(" and tBill.FBizTypeID!='d8e80652-0113-1000-e000-04c5c0a812202407435C'");
			sql.append(" and tcus.FIsInternalCompany=0 ");//是否集团内公司
			sql.append(" and (tbill.FBaseStatus=4 or tbill.FBaseStatus=7)");//审核、关闭
			sql.append(" and tbill.FbizDate>={d '").append(beginDateStr).append("'}");
			sql.append(" and tbill.FbizDate<={d '").append(endDateStr).append("'}");
			if(StringUtils.isNotEmpty(orgNums)) {
				sql.append(" and tSOrg.fnumber in (").append(orgNums).append(")");
			}
			if(role.equals("saleperson")) {
				sql.append(" and tperson.fid='").append(personID).append("'");
			}
			//环比
			cal.setTime(beginDate);
			cal.add(Calendar.MONTH, -1);
			beginDateStr=sdf.format(cal.getTime());
			cal.setTime(endDate);
			cal.add(Calendar.MONTH, -1);
			endDateStr=sdf.format(cal.getTime());
			
			sql.append(" union all");
			sql.append(" select tjy.fnumber,tjy.fname_l2 FName,0 FAllAmount,0 FPerYearAllAmount,isnull(tentry.FLocalTaxAmount,0) FPerMonthAllAmount ");
			sql.append(" from t_sd_saleOrder tBill");
			sql.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID");
			sql.append(" inner join T_ORG_Sale tSOrg on tSOrg.fid=tBill.FSaleOrgUnitID");
			if(role.equals("saleperson")) {
				sql.append(" inner join t_bd_person tperson on tperson.fid=tbill.FSalePersonID");
			}
			sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid");
			sql.append(" inner join T_BD_MaterialGroupDetial tmgd on tmgd.fmaterialid=tentry.fmaterialid");
			sql.append(" inner join T_BD_MaterialGroupStandard tmgs on ( tmgs.fid=tmgd.FMaterialGroupStandardID and tmgs.fnumber='001')");
			sql.append(" INNER JOIN T_BD_SaleGroup tsg ON tsg.FID = tbill.FSaleGroupID");//销售组
			sql.append(" INNER JOIN CT_BI_SaleGroupMapEntry tsgme ON tsgme.CFSaleGroupID = tsg.fid ");
			sql.append(" INNER JOIN CT_BI_SaleGroupMap tsgm ON tsgm.fid = tsgme.fparentid ");
			sql.append(" INNER JOIN t_bd_period tp ON tp.fid = tsgm.CFPeriodID AND tp.fperiodyear = year(tbill.fbizDate) AND tp.fperiodnumber = month(tbill.fbizDate)");
			sql.append(" INNER JOIN CT_BI_JyUnit tjy ON tjy.fid = tsgme.CFJyUnitID ");//经营单元
			sql.append(" inner join T_BI_JyUnitTREE tr on tr.FID=tjy.FTreeID");
			sql.append(" inner join T_BI_JyUnitTREE trp on trp.fid=tr.FParentID");
			sql.append(" where 1=1");
			sql.append(" and tBill.FBizTypeID!='d8e80652-0113-1000-e000-04c5c0a812202407435C'");
			sql.append(" and tcus.FIsInternalCompany=0 ");//是否集团内公司
			sql.append(" and (tbill.FBaseStatus=4 or tbill.FBaseStatus=7)");//审核、关闭
			sql.append(" and tbill.FbizDate>={d '").append(beginDateStr).append("'}");
			sql.append(" and tbill.FbizDate<={d '").append(endDateStr).append("'}");
			if(StringUtils.isNotEmpty(orgNums)) {
				sql.append(" and tSOrg.fnumber in (").append(orgNums).append(")");
			}
			if(role.equals("saleperson")) {
				sql.append(" and tperson.fid='").append(personID).append("'");
			}
			sql.append(" ) temp");
			sql.append(" group by FNumber,Fname ");
			sql.append(" order by FAllAmount desc");
			
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal unit = new BigDecimal("10000");
			while(rs.next()) {
				JSONObject dataJson=new JSONObject();
				dataJson.put("number", rs.getString("fnumber"));
				dataJson.put("name", rs.getString("fname"));
				dataJson.put("allAmount", rs.getBigDecimal("FAllAmount").divide(unit, 2, BigDecimal.ROUND_HALF_UP));
				dataJson.put("perYearAllAmount", rs.getBigDecimal("FPerYearAllAmount").divide(unit, 2, BigDecimal.ROUND_HALF_UP));
				dataJson.put("perMonthAllAmount", rs.getBigDecimal("FPerMonthAllAmount").divide(unit, 2, BigDecimal.ROUND_HALF_UP));
				dataJa.add(dataJson);
			}
			rs.close();
			
    	}catch(Exception e) {
    		throw new BOSException(e);
    	}
    	return dataJa;
    }
    /**
     * 获取 订单 状态
     */
	@Override
	protected String _getOrderStatusFromJsonCondition(Context ctx, String jsonStr) throws BOSException {
		JSONObject resultJson = new JSONObject();
		resultJson.put("result", "Success");
		resultJson.put("messgage", "success");
		
		JSONArray arrayJson = new JSONArray();
		
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		try {
			if(!jsonObj.containsKey("userName")) {
				throw new BOSException("用户名不能为空！");
			}
			if(!jsonObj.containsKey("beginDate")) {
				throw new BOSException("开始日期不能为空！");
			}
			if(!jsonObj.containsKey("endDate")) {
				throw new BOSException("结束日期不能为空！");
			}
			if(!jsonObj.containsKey("role")) {
				throw new BOSException("角色不能为空！");
			}
			
			String userName = jsonObj.getString("userName");
			String role = jsonObj.getString("role");
			String userId = "";
			String personId = "";
			String beginDate = "";
			String endDate = "";
			//根据 用户名 获取 t_pm_user id
			StringBuffer sql = new StringBuffer();
			sql.append(" select fid,FPersonId,fname_l2 from t_pm_user where fnumber = '");
			sql.append(userName);
			sql.append("'");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		
			if(rs.next()){
				userId = rs.getString("fid");
				personId = rs.getString("fname_l2");
			}
			
			if(StringUtils.isBlank(userId)){
				throw new BOSException("用户名不存在或没有相对应的职员！");
			}
			
			beginDate = jsonObj.getString("beginDate");
			endDate = jsonObj.getString("endDate");
			
			sql = new StringBuffer("/*dialect*/");
			sql.append(" select ts.FName_L2 as company, ");
			sql.append(" t.FNumber, tc.FName_L2 as customer, ");
			sql.append(" to_char(t.FBizDate,'yyyy-mm-dd') as FBizDate, ");
			sql.append(" tp.FName_L2 as person, ");
			sql.append(" (case t.FBaseStatus when 1 then '保存' when 2 then '提交' ");
			sql.append(" when 3 then '作废' when 4 then '审核' when 7 then '关闭' ");
			sql.append(" else '无' end) as FBaseStatus, ");
			sql.append(" t.ftotaltaxamount as amount ");
			sql.append(" from t_sd_saleorder t ");
			sql.append(" inner join T_ORG_Sale ts on ts.FID = t.FSaleOrgUnitID ");
			sql.append(" left join T_BD_Customer tc on tc.FID = t.FOrderCustomerID ");
			sql.append(" left join T_BD_Person tp on tp.FID = t.FSalePersonID ");
			sql.append(" where 1=1 ");
			sql.append(" and exists( ");
			sql.append(" SELECT 1 FROM T_PM_OrgRange r ");
			sql.append(" inner join T_ORG_Sale tos on tos.fid = r.forgid ");
			sql.append(" where r.fuserid = '");
			sql.append(userId);
			sql.append("' ");
			sql.append(" and r.ftype = '10' ");
			sql.append(" and tos.fid = ts.fid) ");
			if("saleperson".equals(role)){
				sql.append(" and tp.fname_l2 = '");
				sql.append(personId);
				sql.append("'");
			}
			if(StringUtils.isNotBlank(beginDate)){
				sql.append(" and to_char(t.FBizDate,'yyyy-mm-dd') >= '");
				sql.append(beginDate);
				sql.append("'");
			}
			if(StringUtils.isNotBlank(endDate)){
				sql.append(" and to_char(t.FBizDate,'yyyy-mm-dd') <= '");
				sql.append(endDate);
				sql.append("'");
			}
			sql.append(" and t.FBaseStatus in (1,2,3,4,7) ");
			sql.append(" order by t.FNumber asc ");
			System.out.println(sql.toString());
			rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				JSONObject dataJson = new JSONObject();
				dataJson.put("company", rs.getString("company"));
				dataJson.put("FNumber", rs.getString("FNumber"));
				dataJson.put("customer", rs.getString("customer"));
				dataJson.put("FBizDate", rs.getString("FBizDate"));
				dataJson.put("person", rs.getString("person"));
				dataJson.put("FBaseStatus", rs.getString("FBaseStatus"));
				dataJson.put("amount", rs.getBigDecimal("amount"));
				
				arrayJson.add(dataJson);
			}
			
			resultJson.put("dataCol", arrayJson);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException();
		}
		
		
		return resultJson.toString();
	}
}