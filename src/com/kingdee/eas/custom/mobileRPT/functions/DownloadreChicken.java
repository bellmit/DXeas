package com.kingdee.eas.custom.mobileRPT.functions;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class DownloadreChicken implements IDownload {
	//毛鸡回收日报表
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
		sql.append("select").append(sp);
		sql.append("t2.FName_l2 养殖户,").append(sp);
		sql.append("t2.FAddress 地址,").append(sp);
		sql.append("t2.CFMilesStd 距离,").append(sp);
		sql.append("sum(t1.CFTotalSettleAmt) 回收价格,").append(sp);
		sql.append("sum(t1.CFActulSettleFreAmt)/sum((case when t1.CFTotalSettleWgt = 0 then 1 else t1.CFTotalSettleWgt end))  实际运费,").append(sp);
		sql.append("sum(t1.CFCarcassSettleWgt)/sum((case when t1.CFTotalSettleWgt = 0 then 1 else t1.CFTotalSettleWgt end)) 出成率,").append(sp);
		sql.append("sum(t1.CFTotalSettleWgt) 结算总重量,").append(sp);
		sql.append("sum(t1.CFTotalSettleWgt)/sum(CFQty) 只重,").append(sp);
		sql.append("nvl(t1.FPlusPrice,0) 优质鸡加价,").append(sp);
		sql.append("sum(t1.CFActulSettleFreAmt)+sum(t1.CFTotalSettleWgt) 回收价格含运费,").append(sp);
		sql.append("t1.FHouseBefore 是否棚前,").append(sp);
		sql.append("t1.CFPurchaseType 合同或者协议").append(sp);
		sql.append("from").append(sp);
		sql.append("CT_SET_SettleBill t1").append(sp);
		sql.append("inner join T_FM_Farm t2 on t2.FID = t1.CFFarmID").append(sp);
		sql.append("inner join T_ORG_Company t3 on t3.FID = t1.CFCompanyID").append(sp);
		sql.append("where ").append(sp);
		sql.append("to_char(t1.FBizdate,'yyyy-MM-dd') = '").append(date).append("'").append(sp);
		if(isGroup){
			sql.append("and t3.FNumber like '").append(companyID).append("%'").append(sp);
		}
		sql.append("group by t2.FName_l2,t2.FAddress,t2.CFMilesStd,t1.FPlusPrice,t1.FHouseBefore,t1.CFPurchaseType").append(sp);
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONObject jo = new JSONObject();
		while(rs.next()){
			jo = new JSONObject();
			jo.put("FarmName", StringUtils.isNotBlank(rs.getString("养殖户")) ? rs.getString("养殖户") : "");
			jo.put("Address", StringUtils.isNotBlank(rs.getString("地址")) ? rs.getString("地址") : "");
			jo.put("MilesStd", StringUtils.isNotBlank(rs.getString("距离")) ? rs.getString("距离") : "");
			jo.put("TotalSettleAmt", StringUtils.isNotBlank(rs.getString("回收价格")) ? rs.getString("回收价格") : "");
			jo.put("ActulSettleFreAmt", StringUtils.isNotBlank(rs.getString("实际运费")) ? rs.getString("实际运费") : "");
			jo.put("cclv", StringUtils.isNotBlank(rs.getString("出成率")) ? rs.getString("出成率") : "");
			jo.put("TotalSettleWgt", StringUtils.isNotBlank(rs.getString("结算总重量")) ? rs.getString("结算总重量") : "");
			jo.put("zz", StringUtils.isNotBlank(rs.getString("只重")) ? rs.getString("只重") : "");
			jo.put("PlusPrice", StringUtils.isNotBlank(rs.getString("优质鸡加价")) ? rs.getString("优质鸡加价") : "");
			jo.put("HouseBefore", StringUtils.isNotBlank(rs.getString("是否棚前")) ? rs.getString("是否棚前") : "");
			jo.put("PurchaseType", StringUtils.isNotBlank(rs.getString("合同或者协议")) ? rs.getString("合同或者协议") : "");
			jo.put("TotalSettleFreAmt", StringUtils.isNotBlank(rs.getString("回收价格含运费")) ? rs.getString("回收价格含运费") : "");
		
			ja.add(jo);
		}
		return ja;
	}

}
