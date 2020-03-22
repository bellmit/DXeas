package com.kingdee.eas.custom.taihe.contract.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;

public class ContractPredictionControllerBean extends AbstractContractPredictionControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.contract.app.ContractPredictionControllerBean");

	@Override
	protected String _getData(Context ctx, String param) throws BOSException {
		// TODO Auto-generated method stub
		//获取所有公司
		JSONArray companyJA = getCompany(ctx);
		//获取所有合同类别
		JSONArray contractJA = getContract(ctx);
		//获取所有养殖场
		JSONArray farmJA = getFarm(ctx);
		//获取所有保证金政策
		JSONArray guaranteeJA = getGuarantee(ctx);
		
		return super._getData(ctx, param);
		
		
	}
	//获取所有公司
	private JSONArray getCompany(Context ctx) {
		String sb = "select FID,FName_l2 from T_ORG_BaseUnit where fnumber in ('11', '31', '21','4', '12', '32','22')";
		JSONArray ja = new JSONArray();
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb).executeSQL();
			while(rs.next()){
				JSONObject jo = new JSONObject();
				jo.put("companyID", rs.getString("FID"));
				jo.put("companyName", rs.getString("FName_l2"));
				ja.add(jo);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja;
		
	}
	//获取所有合同类别
	private JSONArray getContract(Context ctx) {
		String sb = "select FID,FName_l2 from T_SIG_ContractType where FBillStatus = '1";
		JSONArray ja = new JSONArray();
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb).executeSQL();
			while(rs.next()){
				JSONObject jo = new JSONObject();
				jo.put("contractID", rs.getString("FID"));
				jo.put("contractName", rs.getString("FName_l2"));
				ja.add(jo);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja;
		
	}
	//获取养殖场信息
	private JSONArray getFarm(Context ctx) {
		String sb = "select FID,FName_l2,CFTheHeader,CFtelePhone,CFCapacity,CFBuildDate,CFeveryHomeNum,CFMilesStd,CFFeedType,CFProhibitArea from T_FM_Farm where FBASEStatus = 2";
		JSONArray ja = new JSONArray();
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb).executeSQL();
			while(rs.next()){
				JSONObject jo = new JSONObject();
				jo.put("farmID", rs.getString("FID"));//ID
				jo.put("farmName", rs.getString("FName_l2"));//养殖场名称
				jo.put("farmHeaderName", rs.getString("CFTheHeader"));//养殖场场长名称
				jo.put("telePhone", rs.getString("CFtelePhone"));//	联系方式
				jo.put("capacity", rs.getString("CFCapacity"));//养殖规模(万只)
				jo.put("buildDate", rs.getString("CFBuildDate"));//建厂时间
				jo.put("everyHomeNum", rs.getString("CFeveryHomeNum"));//每舍规格(万只)
				jo.put("milesStd", rs.getString("CFMilesStd"));//标准里程数
				jo.put("feedType", rs.getString("CFFeedType"));//养殖方式
				jo.put("prohibitArea", rs.getString("CFProhibitArea"));//是否禁养区
				ja.add(jo);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja;
		
	}
	//获取保证金政策
	private JSONArray getGuarantee(Context ctx) {
		String sb = "select CFCompanyID,FName_l2,CFLowprice,CFassurePrice from CT_CON_AssureAmtPolicy ";
		JSONArray ja = new JSONArray();
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb).executeSQL();
			while(rs.next()){
				JSONObject jo = new JSONObject();
				jo.put("companyID", rs.getString("CFCompanyID"));
				jo.put("guaranteeName", rs.getString("FName_l2"));
				jo.put("lowprice", rs.getString("CFLowprice"));
				jo.put("assurePrice", rs.getString("CFassurePrice"));
				ja.add(jo);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja;
		
	}
	
	private JSONArray getSupplier(Context ctx) {
		StringBuffer sb = new StringBuffer();
		sb.append("/*dialect*/");
		sb.append("select ");
		sb.append("case when tc.FPhone is null then N'0'");
		sb.append("else nvl(tc.FPhone,0) end phone,");
		sb.append("tc.FComOrgID,tx.FName_l2,tc.FID from ");
		sb.append("T_BD_SupplierCompanyInfo 		tc");
		sb.append("inner join T_BD_Supplier		tx  on tx.FID = tc.FSupplierID");
		JSONArray ja = new JSONArray();
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
			while(rs.next()){
				JSONObject jo = new JSONObject();
				jo.put("supplierID", rs.getString("FID"));
				jo.put("supplierName", rs.getString("FName_l2"));
				jo.put("supplierPhone", rs.getString("phone"));
				jo.put("companyID", rs.getString("FComOrgID"));
				ja.add(jo);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja;
		
	}
	
	
	

	
	@Override
	protected String _saveData(Context ctx, String param) throws BOSException {
		// TODO Auto-generated method stub
		return super._saveData(ctx, param);
	}
    
}