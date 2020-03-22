package com.kingdee.eas.farm.stocking.webservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import com.kingdee.eas.custom.commld.WebServiceUtil;
import com.kingdee.eas.custom.commonld.app.WebServiceFacadeControllerBean;
import com.kingdee.eas.custom.commonld.comm.WebServiceComm;
import com.kingdee.eas.custom.farmpolling.IPollingRecordBill;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillFactory;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo;
import com.kingdee.eas.custom.farmpolling.PollingRecordBillInventoryEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillEntryInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class PollingRecordFacadeControllerBean extends AbstractPollingRecordFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.webservice.PollingRecordFacadeControllerBean");

	@Override
	protected String _createNewBill(Context ctx, String param) {
		// TODO Auto-generated method stub
		IObjectPK caller = ctx.getCaller();
		try {
			JSONObject fromObject = JSONObject.fromObject(param);
			String userNum = fromObject.getJSONObject("data").getJSONObject("person").getString("number");
			UserCollection userInfoColl = UserFactory.getLocalInstance(ctx).getUserCollection("where number='"+userNum+"'");
			if(userInfoColl.size()>0){
				ctx.setCaller(new ObjectUuidPK(userInfoColl.get(0).getString("id")));
			}
			return super._createNewBill(ctx, param);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ctx.setCaller(caller);
		}
		return null;
	}

	@Override
	protected String beforeDealWithBill(String param) {
		// TODO Auto-generated method stub
		return WebServiceComm.setBosType(param, "9CFC4C15");
	}

	@Override
	protected String _deleteBill(Context ctx, String param) {
		// TODO Auto-generated method stub
		return super._deleteBill(ctx, param);
	}

	@Override
	protected String _getBillDetailInfo(Context ctx, String param) {
		// TODO Auto-generated method stub
		slorList = new String[]{"*","company.*","farmer.*","farm.*","stockingBatch.*","person.*","InventoryEntry.*","auditor.*","creator.*","cu.*","lastUpdateUser.*","InventoryEntry.material.*","InventoryEntry.unit.*"};
		return super._getBillDetailInfo(ctx, param);
	}

	@Override
	protected String _getBillList(Context ctx, String param) {
		// TODO Auto-generated method stub
		return super._getBillList(ctx, param);
	}

	@Override
	protected void afterCreateNewBill(Context ctx, IObjectPK pk,
			JSONObject jo) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.afterCreateNewBill(ctx, pk, jo);
		IPollingRecordBill instance = PollingRecordBillFactory.getLocalInstance(ctx);
		PollingRecordBillInfo info = instance.getPollingRecordBillInfo(pk);
		for(int i=info.getInventoryEntry().size()-1;i>=0;i--)
			info.getInventoryEntry().remove(info.getInventoryEntry().get(i));

		JSONArray array = jo.getJSONArray("InventoryEntry");

		PollingRecordBillInventoryEntryInfo entryInfo;
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryInfo = new PollingRecordBillInventoryEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryInfo.put(key,elem.get(key));
			}
			info.getInventoryEntry().add(entryInfo);
		}

		PollingRecordBillFactory.getLocalInstance(ctx).save(info);
	}

	@Override
	protected void beforeCreateNewBill(Context ctx, JSONObject jo,
			JSONObject entryArray2) {
		// TODO Auto-generated method stub
		if(jo.containsKey("InventoryEntry"))
			entryJson.put("InventoryEntry",jo.getJSONArray("InventoryEntry"));
		else
			entryJson.put("InventoryEntry",new JSONArray());

		jo.put("InventoryEntry",new JSONArray());
		super.beforeCreateNewBill(ctx, jo, entryArray2);
	}



	@Override
	protected String _getBatchInfoByTechMan(Context ctx, String param)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		JSONObject jResult = new JSONObject();
		jResult.put("result",true);

		JSONArray array = null;
		JSONObject jElem = null;

		StringBuffer sb = new StringBuffer();

		JSONObject fromObject = JSONObject.fromObject(param);
		String userNum = null;
		if(fromObject.containsKey("userNum")&&StringUtils.isNotEmpty(fromObject.getString("userNum"))){
			userNum = fromObject.getString("userNum");
		}else{
			jResult.put("result", false);
			jResult.put("failReason", "userNum为空");
			return jResult.toString();
		}

		sb.append("select  ").append("\n")
		.append("bp.FNumber                     personNum,").append("\n")
		.append("bp.FName_l2                    personName,").append("\n")
		.append("bp.FID                         personID,").append("\n")
		.append("sb.FNumber                     batchNum,").append("\n")
		.append("sb.FName_l2                    batchName,").append("\n")
		.append("sb.FID                         batchID,").append("\n")
		.append("sb.FInDate                     batchInDate,").append("\n")
		.append("t1.FNumber                     farmerNum,").append("\n")
		.append("t1.FName_l2                    farmerName,").append("\n")
		.append("t1.FID                         farmerID,").append("\n")
		.append("t2.FNumber                     farmNum,").append("\n")
		.append("t2.FName_l2                    farmName,").append("\n")
		.append("t2.FID                         farmID").append("\n")
		.append("from T_FM_StockingBatch sb inner join T_FM_Farmers f on sb.FFarmerID  = f.FID").append("\n")
		.append("inner join T_FM_PersonFarmerRelationEntry pfre on pfre.FFarmerID = f.FID").append("\n")
		.append("inner join T_FM_PersonFarmerRelation pfr on pfre.FParentID = pfr.FID").append("\n")
		.append("inner join T_BD_Person  BP on BP.FID = pfr.FPersonID").append("\n")
		.append("inner join T_PM_User   PU on BP.FID = PU.FPersonId").append("\n")
		.append("inner join T_FM_Farmers        t1 on t1.FID=sb.FFarmerID").append("\n")
		.append("inner join T_FM_Farm           t2 on t2.FID=sb.FFarmID").append("\n")
		.append("where sb.FIsAllOut=0 and  sb.FAllOutDate is  null and PU.FNumber ='").append(userNum).append("' ").append("\n");

		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			array = new JSONArray();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()){
				jElem = new JSONObject();
				for (int i = 0;i < columnCount;i++){
					if(rs.getObject(i+1) instanceof Timestamp){
						jElem.put(metaData.getColumnName(i+1),rs.getTimestamp(i+1).toString());
					}else{
						jElem.put(metaData.getColumnName(i+1),rs.getObject(i+1));
					}
				}
				array.add(jElem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			jResult.put("result", false);
			jResult.put("failReason", e.getMessage());
			jResult.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return jResult.toString();
		}
		jResult.put("data",array);
		return jResult.toString();
	}


	/**
	 * 获取饲料
	 */
	@Override
	protected String _getMaterial(Context ctx, String param)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		JSONObject jResult = new JSONObject();
		jResult.put("result",true);

		JSONArray array = null;
		JSONObject jElem = null;

		StringBuffer sb = new StringBuffer();

		JSONObject fromObject = JSONObject.fromObject(param);
		String company = null;
		if(fromObject.containsKey("company")&&StringUtils.isNotEmpty(fromObject.getString("company"))){
			company = fromObject.getString("company");
		}else{
			jResult.put("result", false);
			jResult.put("failReason", "company为空");
			return jResult.toString();
		}


		sb.append("select").append("\n")
		.append("t1.FID                              materialID, ").append("\n")
		.append("t1.FNumber                          materialNum,").append("\n")
		.append("t1.FName_L2                         materialName,").append("\n")
		.append("t1.FModel                           materialModel,").append("\n")
		.append("t4.FID                              measureUnitID,").append("\n")
		.append("t4.FNumber                          measureUnitNum,").append("\n")
		.append("t4.FName_l2                         measureUnitName").append("\n")
		.append("from T_BD_Material                 t1").append("\n")
		.append("inner join T_FM_BreedStandardEntry t2 on t1.FID=t2.CFHenMaterialID").append("\n")
		.append("inner join T_FM_BreedStandard      t3 on t3.FID=t2.FParentID").append("\n")
		.append("inner join T_BD_MeasureUnit        t4 on t4.FID=t1.FBaseUnit").append("\n")
		.append("where  t3.FCompanyID = '").append(company).append("'").append("\n")
		.append("group by t1.FNumber,t1.FName_L2,t1.FModel,t1.FID,t4.FID,t4.FNumber,t4.FName_l2 ").append("\n");


		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			array = new JSONArray();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()){
				jElem = new JSONObject();
				for (int i = 0;i < columnCount;i++){
					if(rs.getObject(i+1) instanceof Timestamp){
						jElem.put(metaData.getColumnName(i+1),rs.getTimestamp(i+1).toString());
					}else{
						jElem.put(metaData.getColumnName(i+1),rs.getObject(i+1));
					}
				}
				array.add(jElem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			jResult.put("result", false);
			jResult.put("failReason", e.getMessage());
			jResult.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return jResult.toString();
		}
		jResult.put("data",array);
		return jResult.toString();
	}


}