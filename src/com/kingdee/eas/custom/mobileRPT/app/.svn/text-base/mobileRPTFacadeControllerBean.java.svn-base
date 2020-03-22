package com.kingdee.eas.custom.mobileRPT.app;

import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.custom.mobileRPT.functions.CheckRole;
import com.kingdee.eas.custom.mobileRPT.functions.DownloadMaterialDayRpt;
import com.kingdee.eas.custom.mobileRPT.functions.DownloadProductDaily;
import com.kingdee.eas.custom.mobileRPT.functions.DownloadSaleInfoByCompany;
import com.kingdee.eas.custom.mobileRPT.functions.DownloadSaleStatistics;
import com.kingdee.eas.custom.mobileRPT.functions.DownloadreChicken;
import com.kingdee.eas.custom.mobileRPT.functions.GPSR;
import com.kingdee.eas.custom.mobileRPT.functions.HRRpt;
import com.kingdee.eas.custom.mobileRPT.functions.MaterialRpt;
import com.kingdee.eas.custom.mobileRPT.functions.PersonOrgRule;
import com.kingdee.eas.custom.mobileRPT.functions.SalePriceCompare;
import com.kingdee.eas.custom.mobileRPT.functions.SaleRpt;
import com.kingdee.eas.custom.mobileRPT.functions.modelRule;
import com.kingdee.eas.message.comm.MessageUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class mobileRPTFacadeControllerBean extends AbstractmobileRPTFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.mobileRPT.app.mobileRPTFacadeControllerBean");

	@Override
	protected String _getData(Context ctx, String param) throws BOSException {
		// TODO Auto-generated method stub
		IDownload iDownload = null;
		JSONArray ja = new JSONArray();
		System.out.println("\n-------------query condition-------------\n" + param + "\n------------end------------");
		JSONObject jo = JSONObject.fromObject(param);
		String rptName;
		if(jo.containsKey("rptName") && StringUtils.isNotBlank(jo.getString("rptName"))){
			rptName = jo.getString("rptName");
		}else{
			throw new BOSException("参数中不包含报表名称(rptName)或者报表名称为空！");
		}
		if(rptName.equalsIgnoreCase("SaleStatistics")){
			iDownload = new DownloadSaleStatistics();
		}else if(rptName.equalsIgnoreCase("SaleInfoByCompany")){
			iDownload = new DownloadSaleInfoByCompany();
		}else if(rptName.equalsIgnoreCase("GPSR")){
			iDownload = new GPSR();
		}else if(rptName.equalsIgnoreCase("SalePriceCompare")){
			iDownload = new SalePriceCompare();
		}else if(rptName.equalsIgnoreCase("MaterialDayRpt")){
			iDownload = new DownloadMaterialDayRpt();
		}else if(rptName.equalsIgnoreCase("CheckRole")){
			iDownload = new CheckRole();
		}
		else if(rptName.equalsIgnoreCase("modelRule")){
			iDownload = new modelRule();
		}
		else if(rptName.equalsIgnoreCase("reChicken")){
			iDownload = new DownloadreChicken();
		}else if(rptName.equalsIgnoreCase("SaleRpt")){
			iDownload = new SaleRpt();
		}else if(rptName.equalsIgnoreCase("ProductDaily")){
			iDownload = new DownloadProductDaily();
		}else if(rptName.equalsIgnoreCase("MaterialRpt")){
			iDownload = new MaterialRpt();
		}else if(rptName.equalsIgnoreCase("PersonOrgRule")){
			iDownload = new PersonOrgRule();
		}else if(rptName.equalsIgnoreCase("HRRpt")){
			iDownload = new HRRpt();
		}
		
		
		
		try {
			if(iDownload != null){
				ja = iDownload.downloadData(ctx, jo.getJSONObject("data"));
//				System.out.println("download result" + ja.toString());
				System.out.println("\n-------------download result-------------\n" + ja.toString() + "\n------------end------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja.toString();
	}

	@Override
	protected boolean _sendPRT(Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		String receiverAddress = "http://58.57.63.54:8089/taihe/Servlet/sendRPTMessageListToTaiHe.sv";
		//String messagetitle = "";
		StringBuffer sql = new StringBuffer();
		sql.append("Select distinct ");
		sql.append("t1.FName_l2 RPTName, ");
		sql.append("t4.FNumber UserNumber ");
		sql.append("from CT_MOB_RPTRole t1 ");
		sql.append("inner join CT_MOB_RPTRoleRoleEntry t2 on t2.FParentID=t1.FID ");
		sql.append("left join T_PM_UserRoleOrg t3 on t3.FRoleID = t2.CFRoleID ");
		sql.append("inner join T_PM_USER t4 on t4.FID=t3.FUserID");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			while(rs.next()){
				
				String messagetitle = rs.getString("RPTName")+"报表已更新，请您查看！";
				JSONObject json = new JSONObject();
				json.put("OPTYPE", "ADD");
				json.put("msgID", " ");
				json.put("orgID", " ");
				json.put("title", messagetitle);
				json.put("body", " ");
				json.put("sender", " ");
				json.put("senderNumber", " ");
				json.put("receiverNumber", rs.getString("UserNumber"));
				MessageUtils.sendPost(receiverAddress, json.toString());
				System.out.println("消息推送:"+rs.getString("UserNumber")+""+rs.getString("RPTName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return super._sendPRT(ctx);
	}
    
}