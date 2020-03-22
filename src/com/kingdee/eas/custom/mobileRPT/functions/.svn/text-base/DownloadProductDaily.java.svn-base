package com.kingdee.eas.custom.mobileRPT.functions;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class DownloadProductDaily implements IDownload {

	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
			throws Exception {
		// TODO Auto-generated method stub
		String date;
		String companyID;
		Boolean isGroup = true;
		if(queryJSON.containsKey("date") && StringUtils.isNotBlank(queryJSON.getString("date"))){
			date = queryJSON.getString("date");
		}else{
			throw new BOSException("日期不允许为空！");
		}
		if(queryJSON.containsKey("companyID") && StringUtils.isNotBlank(queryJSON.getString("companyID"))){
			if(queryJSON.getString("companyID").equals("0")){
				//companyID = queryJSON.getString("companyID");
				isGroup = false;
			}
			companyID = queryJSON.getString("companyID");
		}else{
			throw new BOSException("公司不允许为空！");
		}
		JSONArray ja = new JSONArray();
		String sp = "\n";
		StringBuffer sql = new StringBuffer();
		sql.append("/*dialect*/");
		sql.append("select distinct ").append(sp);
		sql.append("t6.FName_l2 公司,").append(sp);
		sql.append("to_char(t1.FBizdate,'yyyy-MM-dd') 业务日期,").append(sp);
		sql.append("t1.CFSlaughterAmt 宰杀数量,").append(sp);
		sql.append("t1.CFComprehensivePrice 综合售价,").append(sp);
		sql.append("t1.CFCarcassRatio 胴体出成率,").append(sp);
		sql.append("t1.CFDivisionRatio 分割出成率,").append(sp);
		sql.append("t1.CFGrossChickenAPrice 毛鸡均价,").append(sp);
		sql.append("t1.CFGrossChickenAWgt 毛鸡均重,").append(sp);
		sql.append("t1.CFWaterAbsorption 吸水率,").append(sp);
		sql.append("CAST(t1.CFCommodityChickenAmt/t1.CFSlaughterAmt as numeric(4,2)) 商品鸡比例").append(sp);
		sql.append("from").append(sp);
		sql.append("CT_SZC_FreshDaily t1 ").append(sp);
		sql.append("inner join T_SZC_FreshDailyEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("and to_char(t1.FBizdate,'yyyy-MM-dd') = '").append(date).append("'").append(sp);
		sql.append("inner join T_BD_Material t3 on t3.FID = t2.FMaterialNumID").append(sp);
		sql.append("inner join T_BD_MaterialGroup t5 on t5.FID = t3.FMaterialGroupID").append(sp);
		sql.append("inner join T_ORG_Company t6 on t6.FID = t1.CFCompanyID").append(sp);
		if(isGroup){
			sql.append("and t6.FNumber like '").append(companyID).append("%'").append(sp);
		}
		sql.append("and t1.FProductType = 0").append(sp);
		//sql.append("group by t6.FName_l2,t1.FBizdate,t1.CFSlaughterAmt").append(sp);
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		System.out.println(sql.toString());
		JSONObject jo = new JSONObject();
		while(rs.next()){
			jo = new JSONObject();
			jo.put("Company", StringUtils.isNotBlank(rs.getString("公司")) ? rs.getString("公司") : "");
			jo.put("FBizdate", StringUtils.isNotBlank(rs.getString("业务日期")) ? rs.getString("业务日期") : "");
			jo.put("SlaughterAmt", StringUtils.isNotBlank(rs.getString("宰杀数量")) ? rs.getString("宰杀数量") : "");
			jo.put("ComprehensivePrice", StringUtils.isNotBlank(rs.getString("综合售价")) ? rs.getString("综合售价") : "");
			jo.put("CarcassRatio", StringUtils.isNotBlank(rs.getString("胴体出成率")) ? rs.getString("胴体出成率") : "");
			jo.put("DivisionRatio", StringUtils.isNotBlank(rs.getString("分割出成率")) ? rs.getString("分割出成率") : "");
			jo.put("GrossChickenAPrice", StringUtils.isNotBlank(rs.getString("毛鸡均价")) ? rs.getString("毛鸡均价") : "");
			jo.put("GrossChickenAWgt", StringUtils.isNotBlank(rs.getString("毛鸡均重")) ? rs.getString("毛鸡均重") : "");
			jo.put("WaterAbsorption", StringUtils.isNotBlank(rs.getString("吸水率")) ? rs.getString("吸水率") : "");
			jo.put("bl", StringUtils.isNotBlank(rs.getString("商品鸡比例")) ? rs.getString("商品鸡比例") : "");
			ja.add(jo);
		}
		return ja;
	}

}
