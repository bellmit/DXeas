package com.kingdee.eas.farm.stocking.webservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.base.permission.UserCollection;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.app.WebServiceFacadeControllerBean;
import com.kingdee.eas.custom.commonld.comm.WebServiceComm;
import com.kingdee.eas.custom.farmpolling.IPollingRecordBill;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillFactory;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillInventoryEntryInfo;
import com.kingdee.eas.farm.stocking.common.BasePriceBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillInfo;
import com.kingdee.eas.farm.stocking.processbizill.IDrugReceptionBill;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class WSDrugReceptionBillFacadeControllerBean extends AbstractWSDrugReceptionBillFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.webservice.WSDrugReceptionBillFacadeControllerBean");

	private static final String bosType = "F16676F1";
	@Override
	protected String _createNewBill(Context ctx, String param) {
		// TODO Auto-generated method stub
		JSONObject json = JSONObject.fromObject(param);
		if(!json.containsKey("bosType")){
			json.put("bosType",bosType);
		}
		String userNum = json.getString("userNum");
		UserCollection userInfoColl = null;
		try {
			userInfoColl = UserFactory.getLocalInstance(ctx).getUserCollection("where number='"+userNum+"'");
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userInfoColl.size()>0){
			ctx.setCaller(new ObjectUuidPK(userInfoColl.get(0).getString("id")));
		}
		return super._createNewBill(ctx, json.toString());
	}

	@Override
	protected String _deleteBill(Context ctx, String param) {
		// TODO Auto-generated method stub
		return super._deleteBill(ctx, param);
	}

	@Override
	protected String _getBillDetailInfo(Context ctx, String param) {
		// TODO Auto-generated method stub
		slorList = new String[]{"*","company.*","StorageOrgUnit.*","farmer.*","StockingBatch.*","farm.*","BatchContract.*","Handler.*","Auditor.*","Creator.*","LastUpdateUser.*","cu.*","entrys.material.*","entrys.Warehouse.*","entrys.Unit.*","entrys.*"};
		return super._getBillDetailInfo(ctx, param);
	}

	@Override
	protected String _getBillList(Context ctx, String param) {
		// TODO Auto-generated method stub
		return super._getBillList(ctx, param);
	}




	@Override
	protected void afterCreateNewBill(Context ctx, IObjectPK pk,
			JSONObject entryJson) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.afterCreateNewBill(ctx, pk, entryJson);
		IDrugReceptionBill instance = DrugReceptionBillFactory.getLocalInstance(ctx);
		DrugReceptionBillInfo info = instance.getDrugReceptionBillInfo(pk);
		for(int i=info.getEntrys().size()-1;i>=0;i--)
			info.getEntrys().remove(info.getEntrys().get(i));

		JSONArray array = entryJson.getJSONArray("entry");

		DrugReceptionBillEntryInfo entryInfo;
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryInfo = new DrugReceptionBillEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryInfo.put(key,elem.get(key));
			}
			info.getEntrys().add(entryInfo);
		}
		DrugReceptionBillFactory.getLocalInstance(ctx).save(info);
	}

	@Override
	protected void beforeCreateNewBill(Context ctx, JSONObject dataJson,
			JSONObject entryJson) {
		// TODO Auto-generated method stub
		if(dataJson.containsKey("entry"))
			entryJson.put("entry",dataJson.getJSONArray("entry"));
		else
			entryJson.put("entry",new JSONArray());

		dataJson.put("entry",new JSONArray());
		super.beforeCreateNewBill(ctx, dataJson, entryJson);
	}

	/**
	 * 嵌入bosType
	 */
	@Override
	protected String beforeDealWithBill(String param) {
		// TODO Auto-generated method stub
		return WebServiceComm.setBosType(param, bosType);
	}


	/**
	 * 获取药品
	 */
	@Override
	protected String _getDrugMaterial(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub


		JSONObject toJson = new JSONObject();
		toJson.put("result",true);
		JSONObject json = JSONObject.fromObject(param);
		String stoOrgUnitID = json.getString("storageOrgUnitID");
		StringBuffer sb = new StringBuffer();
		sb.append("/*dialect*/select distinct t1.FID materialID,t1.FNumber materialNum,t1.FName_l2 materialName,t1.FModel materialModel,t6.FID measureUnitID,t6.FName_l2 measureUnitName,t6.FCoefficient").append("\n")
		.append(" from T_BD_Material t1 ").append("\n")
		.append("inner join T_BD_MaterialGroup t2 on t2.FID=t1.FMaterialGroupID").append("\n")
		.append(" inner join  T_BD_MaterialInventory t3 on t1.FID=t3.FMaterialID ").append("\n")
		.append(" inner join  T_ORG_BaseUnit         t4 on t4.FID=t3.FOrgUnit ").append("\n")
		.append(" inner join  T_ORG_BaseUnit         t5 on t5.FID='").append(stoOrgUnitID).append("'").append("\n")
		.append(" inner join T_BD_MeasureUnit        t6 on t6.FID=t1.FBaseUnit").append("\n")
		.append("where t2.FLongNumber like '01!0103%' and t4.FLongNumber like t5.FLongNumber||'%'").append("\n");

		if(json.containsKey("materialFilter")&&StringUtils.isNotEmpty(json.getString("materialFilter"))){
			sb.append(" and (t1.FName_l2 like '%").append(json.getString("materialFilter")).append("%' or t1.FNumber like '%").append(json.getString("materialFilter")).append("%')");
		}
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		JSONArray data = new JSONArray();
		JSONObject em = null;
		ResultSetMetaData metaData;
		try {
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
			toJson.put("result", false);
			toJson.put("failReason", e.getMessage());
			toJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return toJson.toString();
		}
		toJson.put("data", data);
		return toJson.toString();
	}

	@Override
	protected String _getDrugMaterialPrice(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		JSONObject fromObject = JSONObject.fromObject(param);
		String contractID = fromObject.getString("contractID");
		String materialID = fromObject.getString("materialID");
		String unitID = fromObject.getString("unitID");
		ArrayList<BasePriceBean> basePriceList = StockingComm.getBasePrice(ctx, StockingComm.PRRICE_OUT_TYPE, contractID, materialID, unitID);
		if( basePriceList !=null && basePriceList.size()>0){
			json.put("basePrice",basePriceList.get(0).getBasePrice());
		}else{
			json.put("basePrice",BigDecimal.ZERO);
		}
		return json.toString();
	}


}