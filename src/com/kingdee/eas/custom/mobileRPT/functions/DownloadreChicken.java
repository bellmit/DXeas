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
	//ë�������ձ���
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
		sql.append("select").append(sp);
		sql.append("t2.FName_l2 ��ֳ��,").append(sp);
		sql.append("t2.FAddress ��ַ,").append(sp);
		sql.append("t2.CFMilesStd ����,").append(sp);
		sql.append("sum(t1.CFTotalSettleAmt) ���ռ۸�,").append(sp);
		sql.append("sum(t1.CFActulSettleFreAmt)/sum((case when t1.CFTotalSettleWgt = 0 then 1 else t1.CFTotalSettleWgt end))  ʵ���˷�,").append(sp);
		sql.append("sum(t1.CFCarcassSettleWgt)/sum((case when t1.CFTotalSettleWgt = 0 then 1 else t1.CFTotalSettleWgt end)) ������,").append(sp);
		sql.append("sum(t1.CFTotalSettleWgt) ����������,").append(sp);
		sql.append("sum(t1.CFTotalSettleWgt)/sum(CFQty) ֻ��,").append(sp);
		sql.append("nvl(t1.FPlusPrice,0) ���ʼ��Ӽ�,").append(sp);
		sql.append("sum(t1.CFActulSettleFreAmt)+sum(t1.CFTotalSettleWgt) ���ռ۸��˷�,").append(sp);
		sql.append("t1.FHouseBefore �Ƿ���ǰ,").append(sp);
		sql.append("t1.CFPurchaseType ��ͬ����Э��").append(sp);
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
			jo.put("FarmName", StringUtils.isNotBlank(rs.getString("��ֳ��")) ? rs.getString("��ֳ��") : "");
			jo.put("Address", StringUtils.isNotBlank(rs.getString("��ַ")) ? rs.getString("��ַ") : "");
			jo.put("MilesStd", StringUtils.isNotBlank(rs.getString("����")) ? rs.getString("����") : "");
			jo.put("TotalSettleAmt", StringUtils.isNotBlank(rs.getString("���ռ۸�")) ? rs.getString("���ռ۸�") : "");
			jo.put("ActulSettleFreAmt", StringUtils.isNotBlank(rs.getString("ʵ���˷�")) ? rs.getString("ʵ���˷�") : "");
			jo.put("cclv", StringUtils.isNotBlank(rs.getString("������")) ? rs.getString("������") : "");
			jo.put("TotalSettleWgt", StringUtils.isNotBlank(rs.getString("����������")) ? rs.getString("����������") : "");
			jo.put("zz", StringUtils.isNotBlank(rs.getString("ֻ��")) ? rs.getString("ֻ��") : "");
			jo.put("PlusPrice", StringUtils.isNotBlank(rs.getString("���ʼ��Ӽ�")) ? rs.getString("���ʼ��Ӽ�") : "");
			jo.put("HouseBefore", StringUtils.isNotBlank(rs.getString("�Ƿ���ǰ")) ? rs.getString("�Ƿ���ǰ") : "");
			jo.put("PurchaseType", StringUtils.isNotBlank(rs.getString("��ͬ����Э��")) ? rs.getString("��ͬ����Э��") : "");
			jo.put("TotalSettleFreAmt", StringUtils.isNotBlank(rs.getString("���ռ۸��˷�")) ? rs.getString("���ռ۸��˷�") : "");
		
			ja.add(jo);
		}
		return ja;
	}

}
