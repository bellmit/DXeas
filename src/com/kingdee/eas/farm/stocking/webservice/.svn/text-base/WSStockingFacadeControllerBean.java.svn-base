package com.kingdee.eas.farm.stocking.webservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.ExceptionUtils;
import com.kingdee.eas.custom.commld.WebServiceUtil;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlDynamicBillUtils;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;

public class WSStockingFacadeControllerBean extends AbstractWSStockingFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.webservice.WSStockingFacadeControllerBean");

	/**
	 * 生成种苗领用单
	 */
	protected String _createNewBreedSeedRecBill(Context ctx, String param)
	{
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		IObjectPK caller = ctx.getCaller();
		try {
			JSONObject jo=JSONObject.fromObject(param);
			String userNum = jo.getJSONObject("data").getString("userNum");
			UserCollection userInfoColl = UserFactory.getLocalInstance(ctx).getUserCollection("where number='"+userNum+"'");
			if(userInfoColl.size()>0){
				ctx.setCaller(new ObjectUuidPK(userInfoColl.get(0).getString("id")));
			}
			String bosType= new BreedSeedBillInfo().getBOSType().toString();
			JSONArray array = jo.getJSONObject("data").getJSONArray("entrys");
			jo.getJSONObject("data").put("entrys",null);
			IObjectPK pk = new WlhlDynamicBillUtils().uploadDataByBosType(ctx, bosType,jo.getJSONObject("data").toString(),null);
			resultJson.put("id",pk.toString());
			if(pk != null){
				BreedSeedBillInfo info = BreedSeedBillFactory.getLocalInstance(ctx).getBreedSeedBillInfo(pk);
				for(int i=info.getEntrys().size()-1;i>=0;i--)
					info.getEntrys().remove(info.getEntrys().get(i));

				BreedSeedBillEntryInfo entryInfo;
				for(int i=0;i<array.size();i++){
					JSONObject elem= (JSONObject) array.get(i);
					Iterator keys = elem.keys();
					entryInfo = new BreedSeedBillEntryInfo();
					while(keys.hasNext()){
						String key = UIRuleUtil.getString(keys.next());
						if(elem.get(key) instanceof JSONObject)
							entryInfo.put(key,((JSONObject)elem.get(key)).get("id"));
						else
							entryInfo.put(key,(elem.get(key)));
					}
					entryInfo.setId(null);
					info.getEntrys().add(entryInfo);
				}
				if(jo.getJSONObject("data").getString("billStatus").equals("2")){
					BreedSeedBillFactory.getLocalInstance(ctx).submit(info);
				}else{
					BreedSeedBillFactory.getLocalInstance(ctx).save(info);
				}
			}
		} catch (EASBizException e) {
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		}finally{
			ctx.setCaller(caller);
		}
		return resultJson.toString();}

	/**
	 * 获取种苗领用单列表界面
	 */
	protected String _getBreedSeedRecBillList(Context ctx, String param)throws BOSException
	{

		JSONObject fJson = JSONObject.fromObject(param);
		fJson.put("bosType", new BreedSeedBillInfo().getBOSType().toString());
		//判断JSONObject对象中是否含有"userNum", ContextUtil 系统工具类，提供常用信息的获取
		if(!fJson.containsKey("userNum")&&!fJson.containsKey("queryStr"))
			fJson.put("queryStr"," creator.number='"+ContextUtil.getCurrentUserInfo(ctx).getNumber()+"'");
		else if(!fJson.containsKey("queryStr")){
			fJson.put("queryStr"," creator.number='"+fJson.getString("userNum")+"'");
		}else{

		}
		return WebServiceUtil.downloadBillList(ctx, fJson.toString());
	}

	/**
	 * 获取种苗领用单编辑界面详细信息
	 */
	protected String _getBreedSeedRecBillDetailInfo(Context ctx, String param)throws BOSException
	{
		// TODO Auto-generated method stub

		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		try {
			JSONArray slor = new JSONArray();
			slor.add("company.*");
			slor.add("farmer.*");
			slor.add("StorageOrgUnit.*");
			slor.add("farm.*");
			slor.add("stockingBatch.*");
			slor.add("breedData.*");
			slor.add("batchContract.*");
			slor.add("creator.*");
			slor.add("auditor.*");
			slor.add("lastUpdateUser.*");
			slor.add("cu.*");
			slor.add("handler.*");
			slor.add("entrys.*");
			slor.add("entrys.material.*");
			slor.add("entrys.unit.*");
			slor.add("entrys.warehouse.*");
			slor.add("entrys.house.*");
			JSONObject paramJson = JSONObject.fromObject(param);
			paramJson.put("slor",slor);
			resultJson.put("data", new WlhlDynamicBillUtils().getDataByID(ctx, paramJson.toString()));
		} catch (EASBizException e) {
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return resultJson.toString();
		}
		return resultJson.toString();
	}

	/**
	 * 获取用户对应的批次合同的相关信息
	 * @param userNum   EAS登录用户名的账号
	 */
	@Override
	protected String _getBatchContractByFarmerOrFarm(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub

		JSONObject fromObject = JSONObject.fromObject(param);

		JSONObject toJson = new JSONObject();
		toJson.put("result",true);
		// 技术员id
		String userNum = null;
		if(StringUtils.isEmpty(UIRuleUtil.getString(fromObject.get("userNum")))){
			toJson.put("result",false);
			toJson.put("reason","请输入EAS用户编码");
			toJson.put("location",new Throwable().getStackTrace()[1].getLineNumber());
		}else{
			userNum = UIRuleUtil.getString(fromObject.get("userNum"));
		}

		StringBuffer sb = new StringBuffer();
		sb.append("select \n")
		.append("t1.FID                               contractID,\n")
		.append("t1.FNumber                           contractNum,\n")
		.append("t1.FBizDate                          contractBizDate,\n")
		.append("t1.FBreedQty                         maleQty,\n")
		.append("t1.FFemaleBreedQty                   femaleQty,\n")
		.append("t8.FID                               maleMaterialID,\n")
		.append("t8.FNumber                           maleMaterialNum,\n")
		.append("t8.FName_l2                          maleMaterialName,\n")
		.append("t8.FModel                            maleMaterialModel,\n")
		.append("t11.FID                              maleUnitID,\n")
		.append("t11.FNumber                          maleUnitNum,\n")
		.append("t11.FName_l2                         maleUnitName,\n")
		.append("t10.FID                              femaleMaterialID,\n")
		.append("t10.FNumber                          femaleMaterialNum,\n")
		.append("t10.FName_l2                         femaleMaterialName,\n")
		.append("t10.FModel                           femaleMaterialModel,\n")
		.append("t12.FID                              femaleUnitID,\n")
		.append("t12.FNumber                          femaleUnitNum,\n")
		.append("t12.FName_l2                         femaleUnitName,\n")
		.append("t4.FID                               farmerID,\n")
		.append("t4.FNumber                          farmerNum,\n")
		.append("t4.FName_l2                         farmerName,\n")
		.append("t5.FID                              farmID,\n")
		.append("t5.FNumber                          farmNum,\n")
		.append("t5.FName_l2                         farmName,\n")
		.append("t6.FID                              breedDataID,\n")
		.append("t6.FNumber                          breedDataNum,\n")
		.append("t6.FName_l2                         breedDataName,\n")
		.append("t13.FID                             stockingBatchID,\n")
		.append("t13.FNumber                         stockingBatchNum,\n")
		.append("t13.FName_l2                        stockingBatchName\n")


		.append(" from \n")
		.append("T_FM_BatchContract                   t1\n")
		.append("inner join T_FM_Farmers              t4  on t4.FID=t1.FFarmerID\n")
		.append("inner join T_FM_Farm                 t5  on t5.FID=t1.CFFarmID\n")
		.append("inner join T_FM_PersonFarmerRelationEntry tt1 on tt1.FFarmerID=t4.FID\n")
		.append("inner join T_FM_PersonFarmerRelation      tt2 on tt2.FID=tt1.FParentID\n")
		.append("inner join T_BD_Person               t2  on t2.FID=tt2.FPersonID\n")
		.append("inner join T_PM_User                 t3  on t2.FID=t3.FPersonId\n")
		.append("inner join T_FM_BreedData            t6  on t6.FID=t1.FBreedDataID\n")
		.append("left  join T_FM_BreedDataSeedEntry   t7  on t6.FID=t7.FParentID and t7.FMaleOrFemale=1\n")
		.append("left  join T_BD_Material             t8  on t8.FID=t7.FMaterialID\n")
		.append("left  join T_BD_MeasureUnit          t11 on t11.FID=t8.FBaseUnit\n")
		.append("left  join T_FM_BreedDataSeedEntry   t9  on t6.FID=t9.FParentID and t9.FMaleOrFemale=2\n")
		.append("left  join T_BD_Material             t10 on t10.FID=t9.FMaterialID\n")
		.append("left  join T_BD_MeasureUnit          t12 on t12.FID=t10.FBaseUnit\n")
		.append("left  join T_FM_StockingBatch        t13 on t1.FID=t13.FBatchContractID\n")
		.append("where 1=1\n")
		.append("      and t3.FNumber='").append(userNum).append("'\n")
		.append("      and (t13.FIsAllOut=0 and t13.FAllOutDate is  null)\n")
		.append("order by t1.FBizDate desc\n");


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

	/**
	 * 删除种苗领用单单据
	 */
	@Override
	protected String _deleteBreedSeedRecBill(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject rJon = new JSONObject();
		rJon.put("result",true);
		JSONObject fJson = JSONObject.fromObject(param);
		String id = fJson.getString("id");
		try {
			BreedSeedBillFactory.getLocalInstance(ctx).delete(new ObjectUuidPK(id));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rJon.put("result", false);
			rJon.put("reason", ExceptionUtils.getExceptionStatement(e));
			rJon.put("location", ExceptionUtils.getExceptionLocationSimple(e));
		}
		return rJon.toString(); 
	}

	/**
	 * 获取库存组织
	 */
	@Override
	protected String _getStorageOrgUnit(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject rJon = new JSONObject();
		rJon.put("result",true);
		JSONObject fJson = JSONObject.fromObject(param);
		String company = fJson.getString("company");
		CompanyOrgUnitCollection companyOrgUnitCollection = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitCollection("where id='"+company+"'");
		CompanyOrgUnitInfo companyOrgUnitInfo = companyOrgUnitCollection.get(0);
		String str = "select t2.FID,t2.FName_l2 fname,t2.FNumber from T_FM_BreedSeedBill t1 inner join T_ORG_Storage t2 on t2.FID=t1.FStorageOrgUnitID where t1.FCompanyID='"+company+"' group by t2.FID,t2.FName_l2,t2.FNumber"
		+" union all "
		+" select t1.FID,t1.FName_l2,t1.FNumber from T_ORG_Storage t1  where t1.FID not in (select FStorageOrgUnitID from T_FM_BreedSeedBill) and t1.FlongNumber like '"+companyOrgUnitInfo.getLongNumber()+"%'";
		IRowSet rs = DbUtil.executeQuery(ctx, str);
		ResultSetMetaData metaData;
		JSONArray data = new JSONArray();
		try {
			metaData = rs.getMetaData();
			JSONObject em = null;
			while(rs.next()){
				em = new JSONObject();
				for(int i=0 ;i < metaData.getColumnCount();i++){
					em.put(metaData.getColumnName(i+1), rs.getObject(i+1));
				}
				data.add(em);
			}
			rJon.put("data",data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rJon.put("result", false);
			rJon.put("failReason", e.getMessage());
			rJon.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return rJon.toString();
		}
		return rJon.toString();
	}

	@Override
	protected String _getWareHouse(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject rJon = new JSONObject();
		rJon.put("result",true);
		JSONObject fJson = JSONObject.fromObject(param);
		String company = fJson.getString("company");
		CompanyOrgUnitCollection companyOrgUnitCollection = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitCollection("where id='"+company+"'");
		CompanyOrgUnitInfo companyOrgUnitInfo = companyOrgUnitCollection.get(0);

		StringBuffer str = new StringBuffer();
		String table ="";
		String tableEntry ="";
		if(fJson.getString("billType").equals("breed")){
			table = "T_FM_BreedSeedBill";
			tableEntry = "T_FM_BreedSeedBillEntry";
		}else if(fJson.getString("billType").equals("drug")){
			table = "T_FM_DrugReceptionBill";
			tableEntry = "T_FM_DrugReceptionBillEntry";
		}else
			return null;
		str.append("/*dialect*/Select * from (select t3.FID,t3.FName_l2 fname,t3.FNumber from ").append(tableEntry).append(" t1 inner join ").append(table).append(" t2 on t2.FID=t1.FParentID inner join T_DB_WAREHOUSE t3 on t3.FID=t1.FWarehouseID where t2.FCompanyID='"+companyOrgUnitInfo.getString("id")+"'").append("\n");
		if(fJson.containsKey("name") && StringUtils.isNotEmpty(fJson.getString("name"))){
			str.append(" and t3.FName_l2 like '%").append(fJson.getString("name")).append("%'\n");
		}
		str.append("group by t3.FID,t3.FName_l2,t3.FNumber order by t3.Fnumber)").append("\n");

		str.append(" union all").append("\n");

		str.append(" select * from").append("\n");
		str.append(" (select t1.FID,t1.FName_l2 fname,t1.FNumber from T_DB_WAREHOUSE t1 inner join T_ORG_Storage t2 on t2.FID=t1.FstorageOrgID inner join T_ORG_Company t3 on t2.FLongNumber like t3.FLongNumber||'%'    where t3.FID='"+companyOrgUnitInfo.getString("id")+"' and t1.FID not in (select FWarehouseID from ").append(tableEntry).append(" group by FWarehouseID)").append("\n");
		if(fJson.containsKey("name") && StringUtils.isNotEmpty(fJson.getString("name"))){
			str.append(" and t1.FName_l2 like '%").append(fJson.getString("name")).append("%'\n");
		}

		str.append(" group by t1.FID,t1.FName_l2,t1.FNumber order by t1.FNumber)");

		IRowSet rs = DbUtil.executeQuery(ctx, str.toString());
		ResultSetMetaData metaData;
		JSONArray data = new JSONArray();
		try {
			metaData = rs.getMetaData();
			JSONObject em;
			while(rs.next()){
				em = new JSONObject();
				for(int i=0 ;i < metaData.getColumnCount();i++){
					em.put(metaData.getColumnName(i+1), rs.getObject(i+1));
				}
				data.add(em);
			}
			rJon.put("data",data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rJon.put("result", false);
			rJon.put("failReason", e.getMessage());
			rJon.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			return rJon.toString();
		}
		return rJon.toString();
	}

	/**
	 * 根据技术员获取养殖户身份证和手机号
	 */
	@Override
	protected String _getFarmerIDCardByTechManUserNum(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		String sql = "select FPersonId from T_PM_User where fnumber='"+JSONObject.fromObject(param).getString("userNum")+"'";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		ArrayList<String> idList = new ArrayList<String>();
		ArrayList<String> mobileList = new ArrayList<String>();
		JSONObject json = new JSONObject();
		String FIdentity;
		String FMobileTel;
		try {
			if(rs.next()){
				String FPersonId = rs.getString("FPersonId");
				if(StringUtils.isNotEmpty(FPersonId)){
					rs = DbUtil.executeQuery(ctx,"select distinct t3.FIdentity,t3.FMobileTel from T_FM_PersonFarmerRelation t1 inner join T_FM_PersonFarmerRelationEntry t2 on t1.FID=t2.FParentID inner join T_FM_Farmers t3 on t3.FID=t2.FFarmerID inner join T_BD_Person t4 on t4.FID=t1.FPersonID where t4.FID='"+FPersonId+"'");
					while(rs.next()){
						FIdentity = rs.getString("FIdentity");
						FMobileTel = rs.getString("FMobileTel");
						if(!idList.contains(FIdentity.trim()) && StringUtils.isNotEmpty(FIdentity)){
							idList.add(FIdentity.trim());
						}

						if(!mobileList.contains(FMobileTel.trim()) && StringUtils.isNotEmpty(FMobileTel)){
							mobileList.add(FMobileTel.trim());
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		json.put("idList",idList);
		json.put("mobileList",mobileList);
		return json.toString();
	}

	@Override
	protected String _getCurrentStocking(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject fromObject = JSONObject.fromObject(param);
		String batchID = fromObject.getString("batchID");
		String bizDate = fromObject.getString("bizDate");
		return null;
	}

	@Override
	protected String _getTechMantelByFarmer(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject fromObject = JSONObject.fromObject(param);
		String farmerID = fromObject.getString("farmerID");
		String sql= "select distinct t4.FNumber from T_FM_PersonFarmerRelationEntry t1 inner join T_FM_PersonFarmerRelation t2 on t2.FID=t1.FParentID inner join T_BD_Person t3 on t3.FID=t2.FPersonID inner join T_PM_User t4 on t3.FID=t4.FPersonId where t1.FFarmerID='"+farmerID+"'";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		ArrayList<String> list = new ArrayList<String>();
		try {
			while(rs.next()){
				list.add(rs.getString("FNumber"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.toString();
	}

	/**
	 * 根据用户编码获取员工
	 */
	@Override
	protected String _getPersonInfoByUser(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		String sql = "select t2.FID,t2.FNumber,t2.FName_l2 fname from T_PM_User t1 inner join T_BD_Person t2 on t2.FID=t1.FPersonId where t1.FNumber=?";
		IRowSet rs = DbUtil.executeQuery(ctx, sql,new Object[]{param});
		JSONObject json = new JSONObject();
		try {
			if(rs.next()){
				json.put("id",rs.getString("FID"));
				json.put("number",rs.getString("FNumber"));
				json.put("name",rs.getString("fname"));
				return json.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 养殖户确认
	 */
	@Override
	protected String _confirmMethod(Context ctx, String param) {
		// TODO Auto-generated method stub
		JSONObject fromObject = JSONObject.fromObject(param);
		String billType = fromObject.getString("billType");
		String id = fromObject.getString("id");
		String confirmTime;
		JSONObject json = new JSONObject();
		json.put("result",true);
		try {
			if(billType.equalsIgnoreCase("breedSeedBill")){
				confirmTime = fromObject.getString("confirmTime");
				DbUtil.execute(ctx, "update T_FM_BreedSeedBill set FHasComfirm = 1,FConfirmTime={ts '"+confirmTime+"'} where FID ='"+id+"'");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("result",false);
		}

		return json.toString();
	}

}