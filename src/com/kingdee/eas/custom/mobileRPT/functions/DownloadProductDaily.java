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
			throw new BOSException("���ڲ�����Ϊ�գ�");
		}
		if(queryJSON.containsKey("companyID") && StringUtils.isNotBlank(queryJSON.getString("companyID"))){
			if(queryJSON.getString("companyID").equals("0")){
				//companyID = queryJSON.getString("companyID");
				isGroup = false;
			}
			companyID = queryJSON.getString("companyID");
		}else{
			throw new BOSException("��˾������Ϊ�գ�");
		}
		JSONArray ja = new JSONArray();
		String sp = "\n";
		StringBuffer sql = new StringBuffer();
		sql.append("/*dialect*/");
		sql.append("select distinct ").append(sp);
		sql.append("t6.FName_l2 ��˾,").append(sp);
		sql.append("to_char(t1.FBizdate,'yyyy-MM-dd') ҵ������,").append(sp);
		sql.append("t1.CFSlaughterAmt ��ɱ����,").append(sp);
		sql.append("t1.CFComprehensivePrice �ۺ��ۼ�,").append(sp);
		sql.append("t1.CFCarcassRatio ���������,").append(sp);
		sql.append("t1.CFDivisionRatio �ָ������,").append(sp);
		sql.append("t1.CFGrossChickenAPrice ë������,").append(sp);
		sql.append("t1.CFGrossChickenAWgt ë������,").append(sp);
		sql.append("t1.CFWaterAbsorption ��ˮ��,").append(sp);
		sql.append("CAST(t1.CFCommodityChickenAmt/t1.CFSlaughterAmt as numeric(4,2)) ��Ʒ������").append(sp);
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
			jo.put("Company", StringUtils.isNotBlank(rs.getString("��˾")) ? rs.getString("��˾") : "");
			jo.put("FBizdate", StringUtils.isNotBlank(rs.getString("ҵ������")) ? rs.getString("ҵ������") : "");
			jo.put("SlaughterAmt", StringUtils.isNotBlank(rs.getString("��ɱ����")) ? rs.getString("��ɱ����") : "");
			jo.put("ComprehensivePrice", StringUtils.isNotBlank(rs.getString("�ۺ��ۼ�")) ? rs.getString("�ۺ��ۼ�") : "");
			jo.put("CarcassRatio", StringUtils.isNotBlank(rs.getString("���������")) ? rs.getString("���������") : "");
			jo.put("DivisionRatio", StringUtils.isNotBlank(rs.getString("�ָ������")) ? rs.getString("�ָ������") : "");
			jo.put("GrossChickenAPrice", StringUtils.isNotBlank(rs.getString("ë������")) ? rs.getString("ë������") : "");
			jo.put("GrossChickenAWgt", StringUtils.isNotBlank(rs.getString("ë������")) ? rs.getString("ë������") : "");
			jo.put("WaterAbsorption", StringUtils.isNotBlank(rs.getString("��ˮ��")) ? rs.getString("��ˮ��") : "");
			jo.put("bl", StringUtils.isNotBlank(rs.getString("��Ʒ������")) ? rs.getString("��Ʒ������") : "");
			ja.add(jo);
		}
		return ja;
	}

}
