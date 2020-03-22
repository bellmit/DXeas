package com.kingdee.eas.custom.szcount.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


import bsh.StringUtil;

import com.kingdee.bos.*;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.ICostObject;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnit;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.custom.szcount.ISzSemiProduct;
import com.kingdee.eas.custom.szcount.SzCountPositionSetFactory;
import com.kingdee.eas.custom.szcount.SzCountPositionSetInfo;
import com.kingdee.eas.custom.szcount.SzSemiProductCollection;
import com.kingdee.eas.custom.szcount.SzSemiProductEntryCollection;
import com.kingdee.eas.custom.szcount.SzSemiProductEntryInfo;
import com.kingdee.eas.custom.szcount.SzSemiProductFactory;
import com.kingdee.eas.custom.szcount.SzSemiProductInfo;
import com.kingdee.eas.custom.szcount.szCountSet;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlBotpCommUtils;
import com.kingdee.eas.farm.food.stocount.PcakCountCollection;
import com.kingdee.eas.farm.food.stocount.PcakCountFactory;
import com.kingdee.eas.farm.food.stocount.ProdCountCollection;
import com.kingdee.eas.farm.food.stocount.ProdCountFactory;
import com.kingdee.eas.farm.food.stocount.SemiProductCountCollection;
import com.kingdee.eas.farm.food.stocount.SemiProductCountFactory;
import com.kingdee.eas.fm.common.FMException;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;
import java.math.BigDecimal;
import java.math.MathContext;

public class GetDataFacadeControllerBean extends AbstractGetDataFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.szcount.app.GetDataFacadeControllerBean");
    
	
	String todayDate;
	// 计数岗位 0 是鲜品 1是成品 
	
	//获取数据接口
	@Override
	protected String _GetData(Context ctx, String Params) throws BOSException {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(Params);
		String personName = json.getString("personName");
		todayDate = json.getString("todayDate");
		// = json.getString("materialPost");
		String countID = json.getString("materialPost");
		String sql = returnCountset(ctx,countID);
		IRowSet countRs = SQLExecutorFactory.getLocalInstance(ctx, sql).executeSQL();
		String materialPost = null;
		String companyID = null;
		//String isIceFrish = null;
		try {
			if(countRs.next()){
				materialPost = countRs.getString("CFcountset");
				companyID = countRs.getString("CFCompanyOrgID");
				//isIceFrish = countRs.getString("CFIsIceFrish");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		IRowSet rsType = SqlMaerialType(ctx,materialPost);
		JSONArray jsay = new JSONArray();
		JSONObject jslast = new JSONObject();
		try {
			
//			while(rsType.next()){
//				String whereSql = null;
//				JSONObject js = new JSONObject();
//				String materialType = rsType.getString("materialType");
//				if(materialType.equals("胸类")){
//					whereSql = "where   t7.flongnumber like '01!0101!010102%'";
//					js.put("category", materialType);
//					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
//					jsay.add(js);
//				}else if(materialType.equals("腿类")){
//					whereSql = "where   t7.flongnumber like '01!0101!010101%'";
//					js.put("category", materialType);
//					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
//					jsay.add(js);
//				}else if(materialType.equals("翅类")){
//					whereSql = "where   t7.flongnumber like '01!0101!010103%'";
//					js.put("category", materialType);
//					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
//					jsay.add(js);
//				}else if(materialType.equals("鸡架类")){
//					whereSql = "where   t7.flongnumber like '01!0101!010105%'";
//					js.put("category", materialType);
//					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
//					jsay.add(js);
//				}else if(materialType.equals("其他")){
//					whereSql ="where  (t7.flongnumber like '01!0101!010104%' or t7.flongnumber like '01!0101!010106%'or t7.flongnumber like '01!0101!010107%'or t7.flongnumber like '01!0101!010108%'or t7.flongnumber like '01!0101!010109%'or t7.flongnumber like '01!0101!010110%%')";
//					js.put("category", materialType);
//					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
//					jsay.add(js);
//				}
//			}
			//dx
			while(rsType.next()){
				String whereSql = null;
				JSONObject js = new JSONObject();
				String materialType = rsType.getString("materialType");
				if(materialType.equals("胸类")){
					IRowSet rsTypeDetails = SqlMaerialTypeDetails(ctx,materialType);
					whereSql = "where   (";
					while(rsTypeDetails.next()){
							whereSql = whereSql+" t7.flongnumber like ('"+rsTypeDetails.getString("FLongNumber")+"%') or";		
					}
					whereSql = whereSql.substring(0, whereSql.length()-2);
					whereSql = whereSql+")";	
					js.put("category", materialType);
					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
					jsay.add(js);
				}else if(materialType.equals("腿类")){
					IRowSet rsTypeDetails = SqlMaerialTypeDetails(ctx,materialType);
					whereSql = "where   (";
					while(rsTypeDetails.next()){
							whereSql = whereSql+" t7.flongnumber like ('"+rsTypeDetails.getString("FLongNumber")+"%') or";		
					}
					whereSql = whereSql.substring(0, whereSql.length()-2);
					whereSql = whereSql+")";	
					js.put("category", materialType);
					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
					jsay.add(js);
				}else if(materialType.equals("翅类")){
					IRowSet rsTypeDetails = SqlMaerialTypeDetails(ctx,materialType);
					whereSql = "where   (";
					while(rsTypeDetails.next()){
							whereSql = whereSql+" t7.flongnumber like ('"+rsTypeDetails.getString("FLongNumber")+"%') or";		
					}
					whereSql = whereSql.substring(0, whereSql.length()-2);
					whereSql = whereSql+")";
					js.put("category", materialType);
					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
					jsay.add(js);
				}else if(materialType.equals("爪类")){
					IRowSet rsTypeDetails = SqlMaerialTypeDetails(ctx,materialType);
					whereSql = "where   (";
					while(rsTypeDetails.next()){
							whereSql = whereSql+" t7.flongnumber like ('"+rsTypeDetails.getString("FLongNumber")+"%') or";		
					}
					whereSql = whereSql.substring(0, whereSql.length()-2);
					whereSql = whereSql+")";
					js.put("category", materialType);
					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
					jsay.add(js);
				}else if(materialType.equals("头脖类")){
					IRowSet rsTypeDetails = SqlMaerialTypeDetails(ctx,materialType);
					whereSql = "where   (";
					while(rsTypeDetails.next()){
							whereSql = whereSql+" t7.flongnumber like ('"+rsTypeDetails.getString("FLongNumber")+"%') or";		
					}
					whereSql = whereSql.substring(0, whereSql.length()-2);
					whereSql = whereSql+")";
					js.put("category", materialType);
					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
					jsay.add(js);
				}else if(materialType.equals("骨肉类")){
					IRowSet rsTypeDetails = SqlMaerialTypeDetails(ctx,materialType);
					whereSql = "where   (";
					while(rsTypeDetails.next()){
							whereSql = whereSql+" t7.flongnumber like ('"+rsTypeDetails.getString("FLongNumber")+"%') or";		
					}
					whereSql = whereSql.substring(0, whereSql.length()-2);
					whereSql = whereSql+")";
					js.put("category", materialType);
					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
					jsay.add(js);
				}else if(materialType.equals("心肝胗类")){
					IRowSet rsTypeDetails = SqlMaerialTypeDetails(ctx,materialType);
					whereSql = "where   (";
					while(rsTypeDetails.next()){
							whereSql = whereSql+" t7.flongnumber like ('"+rsTypeDetails.getString("FLongNumber")+"%') or";		
					}
					whereSql = whereSql.substring(0, whereSql.length()-2);
					whereSql = whereSql+")";
					js.put("category", materialType);
					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
					jsay.add(js);
				}else if(materialType.equals("其他类")){
					IRowSet rsTypeDetails = SqlMaerialTypeDetails(ctx,materialType);
					whereSql = "where   (";
					while(rsTypeDetails.next()){
							whereSql = whereSql+" t7.flongnumber like ('"+rsTypeDetails.getString("FLongNumber")+"%') or";		
					}
					whereSql = whereSql.substring(0, whereSql.length()-2);
					whereSql = whereSql+")";
					js.put("category", materialType);
					js.put("categoryDetails", getJsArray(ctx,personName,materialPost,whereSql,companyID));
					jsay.add(js);
				}
				
			}
			String wareHouse = getWareHouse(ctx,companyID);
			jslast.put("message", "success");
			jslast.put("result", "0");
			jslast.put("data", jsay);
			if(materialPost.equals("1")){
				jslast.put("wareHouse", wareHouse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jslast.toString();
	}
	//获取仓库 接口
	@Override
	protected String _GetWarehouse(Context ctx, String PersonID) throws BOSException {
	
		return super._GetWarehouse(ctx, PersonID);
	} 
	//获取仓库数据
	private String getWareHouse(Context ctx, String companyID){
		JSONArray jsa = new JSONArray();
		String personID;
		try {
			StringBuffer sql = new StringBuffer();
			String sp = "\n";
			sql.append("select FName_l2 whName,").append(sp);
			sql.append("FID whID from ").append(sp);
			sql.append("T_DB_WAREHOUSE").append(sp); 
			//sql.append("where FControlunitID = '").append(companyID).append("'").append(sp);
			sql.append("order by FNumber ").append(sp);
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			while(rs.next()){
				JSONObject js = new JSONObject();
				js.put("wareHouseName", rs.getString("whName"));
				js.put("wareHouseID", rs.getString("whID"));
				jsa.add(js);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsa.toString();
	}
	//保存方法 接口
	@Override
	protected String _SaveData(Context ctx, String Params) throws BOSException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println("************计数单保存开始1111"+sdf.format(new Date())+"*****************");
		JSONObject json=JSONObject.fromObject(Params);
		long timelong = json.getLong("flag");
		
		String countID = json.getString("countingPost");
		String resultString = null;
		String sql = returnCountset(ctx, countID);
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql).executeSQL();
		String countset = null;
		String companyOrgID  = null;
		try {
			if(rs.next()){
				countset = rs.getString("CFcountset");
				companyOrgID = rs.getString("CFCompanyOrgID");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String timeLong = String.valueOf(timelong);
		System.out.print(timelong);
		String timeSql = "select * from  CT_SZC_SzSemiProduct where CFTimeLong = '"+timelong+"'";
		IRowSet timeRs = SQLExecutorFactory.getLocalInstance(ctx, timeSql).executeSQL();
		try {
			if(timeRs.next()){
				JSONObject jsResult = new JSONObject();
				 jsResult.put("message", "单据已保存");
				 jsResult.put("result", "3");
				 return jsResult.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("************计数单保存结束22222"+sdf.format(new Date())+"*****************");
		if(countset.equals("1")){
			resultString = saveFinishData(ctx,json,countset,companyOrgID,countID,timeLong);
		}else{
			resultString = saveFreshDate(ctx,json,countset,companyOrgID,countID);
		}
//		System.out.println("************计数单保存结束3333"+sdf.format(new Date())+"*****************");
		return resultString;
	}
	//查看计数统计 方法
	@Override
	protected String _GetStatisticsData(Context ctx, String params) throws BOSException {
		// TODO Auto-generated method stub
		JSONObject jsontype = JSONObject.fromObject(params);
		JSONArray jsa = new JSONArray();
	
			String tjtype = jsontype.getString("type");
	
			if(tjtype.equals("mx")){
				jsa = getMXCountData(ctx,params);//获取data数据
			}else{
				jsa = getCountData(ctx,params);//获取data数据
			}
		
		
		
		JSONObject jslast = new JSONObject();
		
		//获取鲜成品对应产品种类
		JSONObject json=JSONObject.fromObject(params);
		String countID = json.getString("countPost");
		String sql = returnCountset(ctx, countID);
		IRowSet rsc = SQLExecutorFactory.getLocalInstance(ctx, sql).executeSQL();
		String countset = null;
		try {
			if(rsc.next()){
					countset = rsc.getString("CFcountset");
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		IRowSet rs = SqlCategory(ctx,countset);
		StringBuffer sbType = new StringBuffer();
		try {
			while(rs.next()){
				sbType.append(rs.getString("CFMaterialType")+",");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jslast.put("message", "success");
		jslast.put("result", "0");
		jslast.put("data", jsa);
		jslast.put("materialType", sbType.toString().substring(0, sbType.toString().length()-1));
		return jslast.toString();
	}
	//获取计数岗位接口
	@Override
	protected String _GetPersonPost(Context ctx, String Params) throws BOSException {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(Params);
		String personName = json.getString("personName");
		JSONArray personPost = null;
		try {
			String personID = getPersonID(ctx,personName);
			personPost = hahaha(ctx,personID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(personPost==null){
			personPost=null;
		}
		return personPost.toString();
	}
	//返回计数岗位ID，获取当前计数岗位 0,1;获取当前公司ID,是否是冰鲜品计数员
	private String returnCountset(Context ctx, String countID){
		StringBuffer sb = new StringBuffer();
		sb.append("select CFcountset,CFCompanyOrgID from CT_SZC_SzCountPositionSet where fid ='").append(countID).append("'");
		return sb.toString();
	}
	
	//用户名获取用户id
	private String getPersonID(Context ctx, String personName) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select t2.FID from ").append(sp);
		sql.append("T_PM_User  t1").append(sp);
		sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where t1.FNumber ='").append(personName).append("'").append(sp);
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FID");
		}
		return personID;
	}
	//获取用户对应的组织单元
	private String getPersonControlunitID(Context ctx,String personID) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FControlUnitID From T_BD_Person where FID = '").append(personID).append("'").append(sp);
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		String personCU = null ;
		while(rs.next()){
			personCU = rs.getString("FControlunitID");
		}
		return personCU;
	}
	//获取用户的计数岗位
	private String sqlPersonPost(Context ctx, String personID){
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select t1.CFCountSet CFCountSet from ").append(sp);
		sql.append("CT_SZC_SzCountPositionSet   t1").append(sp);
		sql.append("inner join   CT_SZC_SzCPSOE t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where t2.CFPersonID  = '").append(personID).append("'").append(sp);
		StringBuffer personPost = new StringBuffer();
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			while(rs.next()){
				personPost.append(rs.getString("CFCountSet"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personPost.toString();
	}
	//获取用户的计数岗位2
	private JSONArray hahaha(Context ctx, String personID){
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select ").append(sp);
		sql.append("t1.FID				CountID,").append(sp);
		sql.append("t1.FName_l2			CountName,").append(sp);
		sql.append("t1.CFCountSet 		CountSet,").append(sp);
		sql.append("t3.FName_l2 		personName,").append(sp);
		sql.append("t4.FName_l2 		companyName,").append(sp);
		sql.append("t1.CFIsIceFrish		IsIceFrish").append(sp);
		
		sql.append("from ").append(sp);
		sql.append("CT_SZC_SzCountPositionSet		t1").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE		t2	on t2.FParentID = t1.FID").append(sp);
		sql.append("inner join T_BD_Person		t3	on t3.FID = t2.CFPersonID").append(sp);
		sql.append("inner join T_ORG_Company		t4	on t4.FID = t1.CFCompanyOrgID").append(sp);
		sql.append("where t2.CFPersonID ='").append(personID).append("'").append(sp);
		JSONArray jsa  = new JSONArray();
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			while(rs.next()){
				JSONObject js = new JSONObject();
				js.put("CountID", rs.getString("CountID"));
				js.put("CountName", rs.getString("CountName"));
				js.put("CFCountSet", rs.getString("CountSet"));
				js.put("personName", rs.getString("personName"));
				js.put("compamnyName", rs.getString("companyName"));
				js.put("IsIceFrish", rs.getString("IsIceFrish"));
				jsa.add(js);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsa;
	}
	//查询物料胸类腿类等分类
	private IRowSet SqlMaerialType(Context ctx,String materialPost){
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select ").append(sp);
		sql.append("t1.CFMaterialType materialType").append(sp);
		sql.append("from  ").append(sp);
		sql.append("CT_SZC_CountPPCE t1").append(sp);
		IRowSet rs = null;
		try {
			rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	//查询物料胸类腿类等分类
	private IRowSet SqlMaerialTypeDetails(Context ctx,String CFMaterialType){
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select ").append(sp);
		sql.append("t3.FLongNumber  ").append(sp);
		sql.append("from  ").append(sp);
		sql.append("CT_SZC_CountPPCE t1").append(sp);
		sql.append("inner join CT_SZC_CountPPGE  t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("inner join T_BD_MaterialGroup  t3 on t2.CFMaterialgroupID = t3.FID").append(sp);
		sql.append("where t1.CFMaterialType='"+CFMaterialType+"' ").append(sp);
		IRowSet rs = null;
		try {
			rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	//获取成品计数或半成品技术对应产品//冻品啥的
	private IRowSet SqlCategory(Context ctx, String materialPost){
		IRowSet rs = null ;
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select CFMaterialType from ").append(sp);
		sql.append("CT_SZC_CountPosOther t1").append(sp);
		sql.append("inner join CT_SZC_CountPosOtherCppEntry  t2  on t2.FParentID = t1.FID").append(sp);
		//sql.append("where t1.CFCountPost = "+materialPost+"").append(sp);
		try {
			rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//获取数据
   private IRowSet SQLinit(Context ctx, String personID,String todayDate,String typeName,  String materialPost,String whereSql,String companyID) throws BOSException, SQLException{
	    String personCU = companyID;
    	IRowSet rs = null ;
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2		materialName,").append(sp);
		sql.append("t4.fnumber		materialNumber,").append(sp);
		sql.append("t6.Fname_l2		materialType,").append(sp);
		sql.append("t4.fid  		materialID,").append(sp);
		//if(typeName.equals("冻品")){
			sql.append("nvl(sum(t9.CFCountNumber),0)	todayNumber,").append(sp);
		//}else{
			//sql.append("nvl(sum(t9.CFWeight),0)	todayNumber,").append(sp);
		//}
		sql.append("t8.FNAME_l2		materialAssist,").append(sp);
		sql.append("t4.fmodel  		materialModel,").append(sp);
		sql.append("k2.FID	wareHouse").append(sp);
		sql.append("from").append(sp);
		sql.append("CT_SZC_SzCountPositionSet  	 tt1	").append(sp);
		sql.append("inner join CT_SZC_SzCPSME			 tt2	on	tt2.FParentID = tt1.FID").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE			 tt3	on	tt3.FParentID = tt1.FID").append(sp);
		sql.append("and tt3.CFPersonID = '").append(personID).append("'").append(sp);
		sql.append("inner join T_BD_Material 			t4     on  t4.FID = tt2.CFMaterialID").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t6 	on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup		 t7 	on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t8	on t8.FID = t4.FASSISTUNIT").append(sp);
		sql.append("left join CT_SZC_SzSemiProduct		 t10	on t10.CFPERsonID = '").append(personID).append("'").append(sp);
		sql.append("and t10.CFCount = '").append(materialPost).append("'").append(sp);
		sql.append("and to_char(t10.FBizdate,'yyyyMMdd') = to_char(sysdate,'yyyyMMdd')").append(sp);
		sql.append("left join CT_SZC_SzsemiProductEntry		 t9	on t4.FNumber = t9.CFMaterialNumber and t10.FID = T9.FParentID").append(sp);//and t9.cfbatch = '").append(todayDate).append("' 
		sql.append("and t9.CFFinishedProductType ='"+typeName+"'").append(sp);
		sql.append("inner join T_BD_MaterialInventory		k1	on k1.FMaterialID = t4.FID").append(sp);
		sql.append("and k1.FControlUnitID = '").append(personCU).append("'").append(sp);
		sql.append("left join  T_DB_WAREHOUSE			k2	on k2.FID = k1.FDefaultWarehouseID").append(sp);
		sql.append(whereSql).append(sp);
		sql.append("and tt1.CFCompanyOrgID = '").append(companyID).append("'").append(sp);
		sql.append("and tt1.CFCountSet = '").append(materialPost).append("'").append(sp);
		sql.append("and tt2.CFIsCount = 1").append(sp);
		sql.append("group by t4.fname_l2,t4.fnumber,t6.Fname_l2,t4.fid,t8.FNAME_l2,t4.fmodel,k2.FID").append(sp);
		sql.append("order by t4.fname_l2,t4.fnumber").append(sp);
		rs =SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
		return rs;
    	
    }
   //胸类，腿类等插入jsonArray
   private String getJsArray(Context ctx, String personName, String materialPost, String whereSql,String companyID){
	    IRowSet rs =null;
	    
	    JSONArray jsay2 = new JSONArray();
		IRowSet rsCategroy = SqlCategory(ctx,materialPost);
		String typeName = null;
		try {
			String personID = getPersonID(ctx,personName);
			while (rsCategroy.next()){
				typeName=rsCategroy.getString("CFMaterialType");
				rs = SQLinit(ctx,personID,todayDate,typeName,materialPost,whereSql,companyID);
				JSONArray jsay1 = new JSONArray();
				while(rs.next()){
					JSONObject xpjs= new JSONObject();
					xpjs.put("materialName", rs.getString("materialName"));//名称
					xpjs.put("materialNumber", rs.getString("materialNumber"));//编码
					xpjs.put("materialType", rs.getString("materialType"));//基本计量单位
					xpjs.put("materialID", rs.getString("materialID"));//ID
					xpjs.put("todayNumber", rs.getString("todayNumber"));//今日累计
					
					if(typeName.equals("退车间")||typeName.equals("返车间")||typeName.equals("半件")){
						xpjs.put("materialAssist", "公斤");//辅助计量单位
					}else{
						xpjs.put("materialAssist", rs.getString("materialAssist"));//辅助计量单位
					}
					xpjs.put("materialModel", rs.getString("materialModel"));//规格型号
					xpjs.put("materialWH", rs.getString("wareHouse"));
					jsay1.add(xpjs);
				}
				JSONObject jsType= new JSONObject();
				jsType.put("typeName",typeName);
//				if(materialPost.equals("0")){
//					String meteringUnit = null;
//					if(typeName.equals("鲜品")){
//						meteringUnit ="盘/包,包";
//					}else{
//						meteringUnit ="公斤";
//					}
//					jsType.put("meteringUnit",meteringUnit);
				//}else if(materialPost.equals("1")){
					String meteringUnit = null;
					//if(typeName.equals("冻品")){
						meteringUnit ="辅助";
					//}else{
						//meteringUnit ="基本";
					//}
					jsType.put("meteringUnit",meteringUnit);
				//}
				jsType.put("Details", jsay1);
				jsay2.add(jsType);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsay2.toString();
   }
   //成品计数 数据保存
    private String saveFinishData(Context ctx, JSONObject json, String countSet, String companyOrgID, String countID,String timeLong){
    	
    	JSONArray jsay = json.getJSONArray("data");//需要保存的数据
    	String todayDate = json.getString("date");//日期
    	String personName = json.getString("personName");//用户名
    	JSONObject jsResult = new JSONObject();//结果json
		Boolean notDX = false;
		Boolean isicc = true;
		Boolean isTCJ = false;
    	//新建计数单据
    	SzSemiProductInfo spinfo = new SzSemiProductInfo();	
		try {
			spinfo.setTimeLong(timeLong);
			CompanyOrgUnitInfo companyInfo=new CompanyOrgUnitInfo();
			companyInfo.setId(BOSUuid.read(companyOrgID));
			spinfo.setCompany(companyInfo);//存入计数单  公司字段
			
			CtrlUnitInfo cuInfo=new CtrlUnitInfo();
			cuInfo.setId(companyInfo.getId());
			spinfo.setCU(cuInfo);
			

			//获取技术员Info
			String 	personID  = getPersonID(ctx,personName);
//			PersonInfo  psInfo  = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(personID));
			PersonInfo  psInfo =new PersonInfo();
			psInfo.setId(BOSUuid.read(personID));
			
	    	//获取计数岗位
	    	szCountSet szcsInfo = szCountSet.getEnum(countSet);
	    	
	    	/*String wareHouse = json.getString("wareHouseID");//仓库ID
	    	WarehouseInfo whInfo  = WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(new ObjectUuidPK(wareHouse));//获取仓库
	    	spinfo.setHouseName(whInfo);//存入仓库*/
//	    	spinfo.setNumber(createSeNumber(ctx,countSet));//存入编码
	    	spinfo.setNumber(getAutoCode(ctx, companyOrgID, spinfo));
			//spinfo.setBizDate(new Date());//存入日期
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
			String dstr=todayDate;  
			Date productiondate=sdf.parse(dstr);  
			spinfo.setProductionDate(productiondate);
			
			/*
			
			
			Date productionDate = new Date();
	    	Calendar calendar = Calendar.getInstance();
	    	calendar.setTime(productionDate);
	    	calendar.add(Calendar.DAY_OF_MONTH, -1);//-1今天的时间减一天
	    	productionDate = calendar.getTime();
	    	
	    	spinfo.setProductionDate(productiondate);*/
	    	SzCountPositionSetInfo	scpsInfo = SzCountPositionSetFactory.getLocalInstance(ctx).getSzCountPositionSetInfo(new ObjectUuidPK(countID));
			//SzCountPositionSetInfo	scpsInfo =new SzCountPositionSetInfo();
			//scpsInfo.setId(BOSUuid.read(countID));
			
			notDX = scpsInfo.isIsManufacture();
			isicc = scpsInfo.isIsIceFrish();
			if(isicc){
				spinfo.setBizDate(productiondate);
			}else{
				Calendar calendar =new GregorianCalendar();
				calendar.setTime(productiondate);
				calendar.add(calendar.DATE,1);
				spinfo.setBizDate(calendar.getTime());//业务日期=生产日期+1
			}
	    	spinfo.setStation(scpsInfo);
			spinfo.setStatus(BillBaseStatusEnum.SUBMITED);
			spinfo.setPerson(psInfo);//存入计数员
			spinfo.setCount(szcsInfo);//存入技术岗位
		if(jsay.size()>0){
			//Boolean notDX = false;
			JSONObject job;
			 SzSemiProductEntryCollection pinfoec= spinfo.getEntrys();
			 ICostObject ics = CostObjectFactory.getLocalInstance(ctx);
			 IMaterial ims = MaterialFactory.getLocalInstance(ctx);

			 SelectorItemCollection slor=new SelectorItemCollection();
			 slor.add("id");
			 slor.add("number");
			 slor.add("name");
			 slor.add("model");
			 slor.add("baseUnit.*");
			 slor.add("assistUnit.*");
			 
			  for(int i=0;i<jsay.size();i++){
			    job = jsay.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
			    String materialID = job.getString("materialID");
			    String quantity = job.getString("quantity");
			    String materialUnit = job.getString("materialUnit");
			    String finishedProductType = job.getString("finishedProductType");
			    String materialWH = job.getString("materialWH");
//			    SzSemiProductEntryCollection pinfoec= spinfo.getEntrys();
			    SzSemiProductEntryInfo pinfoe = new SzSemiProductEntryInfo();
				//					MaterialInfo mInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(materialID));
			    MaterialInfo mInfo = ims.getMaterialInfo(new ObjectUuidPK(materialID),slor);
			    
					pinfoe.setCostObject(ics.getCostObjectByMaterial(materialID, companyOrgID));
					
						
					pinfoe.setMaterial(mInfo);
					BigDecimal mnumber=new BigDecimal(quantity);
					//计数数量
					pinfoe.setCountNumber(quantity);
					if(mnumber.compareTo(BigDecimal.ZERO)<0){
						isTCJ = true;
					}
					pinfoe.setMeasureUnit(materialUnit);
					pinfoe.setMaterialtype(mInfo.getModel());
//					WarehouseInfo whInfo  = WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(new ObjectUuidPK(materialWH));
					WarehouseInfo whInfo=new WarehouseInfo();
					whInfo.setId(BOSUuid.read(materialWH));
					
					pinfoe.setWareHouse(whInfo);
//					MeasureUnitInfo msuInfo =MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(mInfo.getBaseUnit().getId()));
					MeasureUnitInfo msuInfo=mInfo.getBaseUnit();
					pinfoe.setMbaseunit(msuInfo.getName());
					
					
					if(finishedProductType.equals("冻品")){
//						//基本数量
						BigDecimal a=mInfo.getAssistUnit().getCoefficient();
						pinfoe.setWeight(mnumber.multiply(a).setScale(2,BigDecimal.ROUND_HALF_UP));
					}else if(finishedProductType.equals("冰鲜品")){
						BigDecimal a=mInfo.getAssistUnit().getCoefficient();
						pinfoe.setWeight(mnumber.multiply(a).setScale(2,BigDecimal.ROUND_HALF_UP));
						
					}else if(finishedProductType.equals("半件")){
						notDX = false;
						pinfoe.setWeight(new BigDecimal(quantity));
					}else{
						isTCJ = true;
						pinfoe.setWeight(new BigDecimal(quantity));
					}
					
					pinfoe.setBatch(todayDate);
					pinfoe.setMaterialnumber(mInfo.getNumber());
					pinfoe.setFinishedProductType(finishedProductType);
					pinfoec.add(pinfoe);
			  }
			  ISzSemiProduct isc = SzSemiProductFactory.getLocalInstance(ctx);
			  isc.save(spinfo);
			  isc.audit(spinfo);
			  if(notDX){
				//调用botp生成生产入库单 
				  if(!isTCJ){
					  CoreBillBaseCollection sc = new CoreBillBaseCollection();
					  sc.add(spinfo);
					  String id = "IEyooSmIS42XVGyrlGffsQRRIsQ="; //ID
					  IObjectPK pk = new ObjectStringPK(id); //主键
					  generateDestBill(ctx,"02ABF12F","FA1292B4",sc,pk);
				  }else{
					  CoreBillBaseCollection sc = new CoreBillBaseCollection();
					  sc.add(spinfo);
					  String id = "hQO6WgNDQ9WVXHEknTPQnwRRIsQ="; //ID
					  IObjectPK pk = new ObjectStringPK(id); //主键
					  generateDestBill(ctx,"02ABF12F","FA1292B4",sc,pk);
				  }
				  
			  }
			  
			  
			  //返回结果json
			  jsResult.put("message", "success");
			  jsResult.put("result", "0");
			}
		} catch (Exception e) {
			jsResult.put("message", e.getMessage());
			jsResult.put("result", "1");
		}
		return jsResult.toString();
    }
    //鲜品计数 数据保存 
    private String saveFreshDate(Context ctx, JSONObject json, String countset, String companyOrgID, String countID) {
		// TODO Auto-generated method stub
    	JSONArray jsay = json.getJSONArray("data");//需要保存的数据
    	String todayDate = json.getString("date");//日期
    	String personName = json.getString("personName");//用户名
    	JSONObject jsResult = new JSONObject();//结果json
		Boolean notDX = false;
    	//新建计数单据
    	SzSemiProductInfo spinfo = new SzSemiProductInfo();	
		try {
			//获取技术员Info
			String 	personID  = getPersonID(ctx,personName);
			CompanyOrgUnitInfo companyInfo  = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyOrgID));
			spinfo.setCompany(companyInfo);//存入计数单  公司字段
			PersonInfo  psInfo  = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(personID));
	    	//获取计数岗位
	    	szCountSet szcsInfo = szCountSet.getEnum(countset);
//	    	spinfo.setNumber(createSeNumber(ctx,countset));//存入编码
	    	//spinfo.setNumber(WlhlBotpCommUtils.getAutoCode(ctx, spinfo, companyOrgID));
	    	spinfo.setNumber(getAutoCode(ctx, companyOrgID, spinfo));
			//spinfo.setBizDate(new Date());//存入日期
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
			String dstr=todayDate;  
			Date productiondate=sdf.parse(dstr);  
			spinfo.setProductionDate(productiondate);
			spinfo.setBizDate(productiondate);//业务日期=生产日期
			spinfo.setStatus(BillBaseStatusEnum.SUBMITED);
			spinfo.setPerson(psInfo);//存入计数员
			SzCountPositionSetInfo	scpsInfo = SzCountPositionSetFactory.getLocalInstance(ctx).getSzCountPositionSetInfo(new ObjectUuidPK(countID));
	    	spinfo.setStation(scpsInfo);
			notDX = scpsInfo.isIsManufacture();
			spinfo.setCount(szcsInfo);//存入技术岗位
		if(jsay.size()>0){
			  for(int i=0;i<jsay.size();i++){
				 // Boolean notDX = false;
				    JSONObject job = jsay.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				    String materialID = job.getString("materialID");
				    String quantity = job.getString("quantity");
				    String materialUnit = job.getString("materialUnit");
				    String finishedProductType = job.getString("finishedProductType");
				    SzSemiProductEntryCollection pinfoec= spinfo.getEntrys();
				    SzSemiProductEntryInfo pinfoe = new SzSemiProductEntryInfo();
					MaterialInfo mInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(materialID));

						//关联成本对象
						String  costnumber = mInfo.getNumber();
						String  costnumberSQL ="select t1.FID from T_BD_CostObject t1 where t1.Fnumber ='"+costnumber+"' and t1.FControlUnitID = '"+companyOrgID+"'";
						String  costID = null;
						IRowSet costRs = SQLExecutorFactory.getLocalInstance(ctx, costnumberSQL).executeSQL();
						if(costRs.size()>0){
							while(costRs.next()){
								costID = costRs.getString("FID");
							}
							ICostObject iso = CostObjectFactory.getLocalInstance(ctx);
							CostObjectInfo coInfo = iso.getCostObjectInfo(new ObjectUuidPK(costID));
							pinfoe.setCostObject(coInfo);
						}
					
					pinfoe.setMaterial(mInfo);
					/*BigDecimal mnumber=new BigDecimal(quantity);
					pinfoe.setMnumber(mnumber);*/
					
					HashMap<String, String>  hsMap =  conversionM(ctx,getPersonControlunitID(ctx,personID),mInfo.getId());
					MeasureUnitInfo msuInfoA =MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(mInfo.getAssistUnit().getId()));

					if(hsMap.get("件")==null){
						BigDecimal cnumber = new BigDecimal(quantity);
						BigDecimal a=msuInfoA.getCoefficient();
						if(a==null){
							a = BigDecimal.ONE;
						}
						pinfoe.setMeasureUnit(materialUnit);//存入计量单位
						pinfoe.setMaterialtype(mInfo.getModel());//存入规格型号
						MeasureUnitInfo msuInfo =MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(mInfo.getBaseUnit().getId()));
						pinfoe.setMbaseunit(msuInfo.getName());//存入基本计量单位
						pinfoe.setWeight(cnumber.multiply(a).setScale(2,BigDecimal.ROUND_HALF_UP));
						//cnumber = cnumber.divide(mInfo.getAssistUnit().getCoefficient(), 0, BigDecimal.ROUND_HALF_UP);
						pinfoe.setCountNumber(quantity);
					}else{
					pinfoe.setMeasureUnit(materialUnit);//存入计量单位
					pinfoe.setMaterialtype(mInfo.getModel());//存入规格型号
					MeasureUnitInfo msuInfo =MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(mInfo.getBaseUnit().getId()));
					pinfoe.setMbaseunit(msuInfo.getName());//存入基本计量单位
//					//dx修改
//					//鲜品计件件数根据单位换算
//					if(finishedProductType.equals("鲜品")){
//						
//					}else{
//						notDX = true;
//					}
					if(materialUnit.equals("公斤")){
						pinfoe.setWeight(new BigDecimal(quantity));
					}else{	
						String panhuan=  (String) hsMap.get("件");
						double Qty = new Double(quantity);
						double baohuan = new Double(panhuan);
						double zongzhong = baohuan*Qty;
						pinfoe.setWeight(new BigDecimal(zongzhong,MathContext.DECIMAL32));
						pinfoe.setCountNumber(quantity);
						
//						if(materialUnit.indexOf("盘")>=0&&materialUnit.indexOf("包")>=0){
//							System.out.println("存在盘和包计量单位");
//							String panQty = quantity.substring(0, quantity.indexOf("|"));
//							String baoQty = quantity.substring(quantity.indexOf("|")+1,quantity.length());
//							double panzhong = new Double(panQty);
//							double baozhong = new Double(baoQty);
//							String panhuan=  (String) hsMap.get("盘");
//							double panhuan1 = new Double(panhuan);
//							String baohuan=  (String) hsMap.get("包");
//							double baohuan1 = new Double(baohuan);
//							double zongzhong = panzhong*panhuan1+baozhong*baohuan1;
//							System.out.println("总重："+zongzhong);
//							pinfoe.setWeight(new BigDecimal(zongzhong,MathContext.DECIMAL32));
//							
//						}else if(materialUnit.indexOf("盘")>=0&&materialUnit.indexOf("包")==-1){
//							System.out.println("只有盘");
//							double Qty = new Double(quantity);
//							String panhuan=  (String) hsMap.get("盘");
//							double panhuan1 = new Double(panhuan);
//							double panzhong = Qty*panhuan1;
//							pinfoe.setWeight(new BigDecimal(panzhong,MathContext.DECIMAL32));
//							
//						}else if(materialUnit.indexOf("盘")==-1&&materialUnit.indexOf("包")>=0){
//							System.out.println("只有包");
//							double Qty = new Double(quantity);
//							String baohuan=  (String) hsMap.get("包");
//							double baohuan1 = new Double(baohuan);
//							double baozhong = Qty*baohuan1;
//							pinfoe.setWeight(new BigDecimal(baozhong,MathContext.DECIMAL32));
//						}
					}
					
					}
					pinfoe.setBatch(todayDate);
					pinfoe.setMaterialnumber(mInfo.getNumber());
					pinfoe.setFinishedProductType(finishedProductType);
					pinfoec.add(pinfoe);
			  }
			  ISzSemiProduct isc = SzSemiProductFactory.getLocalInstance(ctx);
			  isc.save(spinfo);
			  isc.audit(spinfo);
			  if(notDX){
//					//调用botp生成生产入库单 
				  CoreBillBaseCollection sc = new CoreBillBaseCollection();
				  sc.add(spinfo);

				  String id = "IEyooSmIS42XVGyrlGffsQRRIsQ="; //ID
				  IObjectPK pk = new ObjectStringPK(id); //主键
				  generateDestBill(ctx,"02ABF12F","FA1292B4",sc,pk);
			  }
			  //返回结果json
			  jsResult.put("message", "success");
			  jsResult.put("result", "0");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			jsResult.put("message", e.getMessage());
			jsResult.put("result", "1");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			jsResult.put("message", e.getMessage());
			jsResult.put("result", "1");
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			jsResult.put("message", e.getMessage());
			jsResult.put("result", "1");
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsResult.toString();
	}
	
	//获取物料换算关系
	private HashMap<String, String> conversionM(Context ctx, String orgID, BOSUuid uuid) throws BOSException, SQLException{
			HashMap<String, String> map = new HashMap<String, String>();
			String  conversionSql = "select FNumber,CFoneitem,CFonedise,CFonepackage from  CT_SZC_MaterialConversion where cfcompanyorgunitID = '"+orgID+"' and CFMaterialID = '"+uuid+"'";
			IRowSet conversionRs = SQLExecutorFactory.getLocalInstance(ctx,conversionSql).executeSQL();
			while(conversionRs.next()){
				map.put("编码", conversionRs.getString("FNumber"));
				map.put("件", conversionRs.getString("CFoneitem"));
				map.put("盘", conversionRs.getString("CFonedise"));
				map.put("包", conversionRs.getString("CFonepackage"));
			}
		return map;
	}
	//获取计数维护单数据
	private JSONArray getCountData(Context ctx, String params){
		
		JSONObject json = JSONObject.fromObject(params);
		String countDate = json.getString("countDate");
		String countID = json.getString("countPost");
		String countPersonName = json.getString("countPersonName");
		String countsql = returnCountset(ctx,countID);
		String countPost = null;
		String companyID = null;
		IRowSet countRs;
		try {
			countRs = SQLExecutorFactory.getLocalInstance(ctx, countsql).executeSQL();
			if(countRs.next()){
				countPost = countRs.getString("CFcountset");
				companyID = countRs.getString("CFCompanyOrgID");
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray jsa = new JSONArray();
		try {
			String personID = getPersonID(ctx,countPersonName);
			StringBuffer sql = new StringBuffer();
			String sp = "\n";
			sql.append("/*dialect*/").append(sp);
			sql.append("select").append(sp);
			sql.append("t3.FName_l2						materialName,").append(sp);
			sql.append("t2.CFMaterialNumber				materialNumber,").append(sp);
			sql.append("t2.CFMaterialType				materialType,").append(sp);
			if(countPost.equals("0")){
				sql.append("nvl(sum(t2.CFcountNumber),0)	materialCountNum,").append(sp);
				sql.append("t2.CFMeasureUnit				materialMeasureUnit,").append(sp);
				sql.append("nvl(sum(t2.CFWeight),0)			materialWeight,").append(sp);
			}else{
				sql.append("nvl(sum(t2.CFcountNumber),0)	materialCountNum,").append(sp);
				sql.append("t2.CFMeasureUnit				materialMeasureUnit,").append(sp);
				sql.append("nvl(sum(t2.CFWeight),0)		materialWeight,").append(sp);
			}
			sql.append("t2.CFFinishedProductType		materialProductType,").append(sp);
			sql.append("t4.FName_l2						wareHouseName").append(sp);
			sql.append("from").append(sp);
			sql.append("CT_SZC_SzsemiProduct					t1").append(sp);
			sql.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
			sql.append("inner join T_BD_Material				t3	on t3.FID = t2.CFMaterialID").append(sp);
			sql.append("left join T_DB_WAREHOUSE				t4	on t4.FID = t2.CFWareHouseID").append(sp);
			sql.append("where t1.CFCount = '").append(countPost).append("'").append(sp);
			sql.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
			sql.append("and t1.CFPersonID = '").append(personID).append("'").append(sp);
			sql.append("and to_char(t1.FBizDate,'yyyy-mm-dd') = '").append(countDate).append("'").append(sp);
			if(countPost.equals("0")){
				//sql.append("group by t3.FName_l2,t2.CFMaterialNumber,t2.CFMaterialType,t2.CFFinishedProductType,t4.FName_l2").append(sp);
				sql.append("group by t3.FName_l2,t2.CFMaterialNumber,t2.CFMaterialType,t2.CFMeasureUnit,t2.CFFinishedProductType,t4.FName_l2").append(sp);
			}else{
				sql.append("group by t3.FName_l2,t2.CFMaterialNumber,t2.CFMaterialType,t2.CFMeasureUnit,t2.CFFinishedProductType,t4.FName_l2").append(sp);
			}
			sql.append("order by t3.FNAME_L2").append(sp);
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			while(rs.next()){
				JSONObject jso = new JSONObject();
				jso.put("materialName", rs.getString("materialName"));
				jso.put("materialNumber", rs.getString("materialNumber"));
				jso.put("materialType", rs.getString("materialType"));
				if(countPost.equals("0")){
					jso.put("materialCountNum", rs.getString("materialCountNum"));
					jso.put("materialMeasureUnit", rs.getString("materialMeasureUnit"));
				}else{
					jso.put("materialCountNum", rs.getString("materialCountNum"));
					jso.put("materialMeasureUnit", rs.getString("materialMeasureUnit"));
				}
				jso.put("materialWeight", rs.getString("materialWeight"));
				jso.put("materialProductType", rs.getString("materialProductType"));
				jso.put("wareHouseName", rs.getString("wareHouseName"));
				jsa.add(jso);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsa;

	}
	
	
	//获取计数维护单明细数据
	private JSONArray getMXCountData(Context ctx, String params){
		
		JSONObject json = JSONObject.fromObject(params);
		String countDate = json.getString("countDate");
		String countID = json.getString("countPost");
		String countPersonName = json.getString("countPersonName");
		String countsql = returnCountset(ctx,countID);
		String countPost = null;
		String companyID = null;
		IRowSet countRs;
		try {
			countRs = SQLExecutorFactory.getLocalInstance(ctx, countsql).executeSQL();
			if(countRs.next()){
				countPost = countRs.getString("CFcountset");
				companyID = countRs.getString("CFCompanyOrgID");
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray jsa = new JSONArray();
		try {
			String personID = getPersonID(ctx,countPersonName);
			StringBuffer sql = new StringBuffer();
			String sp = "\n";
			sql.append("/*dialect*/").append(sp);
			sql.append("select").append(sp);
			sql.append("t1.FNumber						FNumber,").append(sp);
			sql.append("t3.FName_l2						materialName,").append(sp);
			sql.append("t2.CFMaterialNumber				materialNumber,").append(sp);
			sql.append("t2.CFMaterialType				materialType,").append(sp);
			if(countPost.equals("0")){
				sql.append("nvl(sum(t2.CFcountNumber),0)	materialCountNum,").append(sp);
				sql.append("t2.CFMeasureUnit				materialMeasureUnit,").append(sp);
				sql.append("nvl(sum(t2.CFWeight),0)			materialWeight,").append(sp);
			}else{
				sql.append("nvl(sum(t2.CFcountNumber),0)	materialCountNum,").append(sp);
				sql.append("t2.CFMeasureUnit				materialMeasureUnit,").append(sp);
				sql.append("nvl(sum(t2.CFWeight),0)		materialWeight,").append(sp);
			}
			sql.append("t2.CFFinishedProductType		materialProductType,").append(sp);
			sql.append("t4.FName_l2						wareHouseName").append(sp);
			sql.append("from").append(sp);
			sql.append("CT_SZC_SzsemiProduct					t1").append(sp);
			sql.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
			sql.append("inner join T_BD_Material				t3	on t3.FID = t2.CFMaterialID").append(sp);
			sql.append("left join T_DB_WAREHOUSE				t4	on t4.FID = t2.CFWareHouseID").append(sp);
			sql.append("where t1.CFCount = '").append(countPost).append("'").append(sp);
			sql.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
			sql.append("and t1.CFPersonID = '").append(personID).append("'").append(sp);
			sql.append("and to_char(t1.FBizDate,'yyyy-mm-dd') = '").append(countDate).append("'").append(sp);
			if(countPost.equals("0")){
				//sql.append("group by t3.FName_l2,t2.CFMaterialNumber,t2.CFMaterialType,t2.CFFinishedProductType,t4.FName_l2").append(sp);
				sql.append("group by t1.FNumber,t3.FName_l2,t2.CFMaterialNumber,t2.CFMaterialType,t2.CFMeasureUnit,t2.CFFinishedProductType,t4.FName_l2").append(sp);
			}else{
				sql.append("group by t1.FNumber,t3.FName_l2,t2.CFMaterialNumber,t2.CFMaterialType,t2.CFMeasureUnit,t2.CFFinishedProductType,t4.FName_l2").append(sp);
			}
			sql.append("order by t3.FNAME_L2").append(sp);
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			while(rs.next()){
				JSONObject jso = new JSONObject();
				jso.put("FNumber", rs.getString("FNumber"));
				jso.put("materialName", rs.getString("materialName"));
				jso.put("materialNumber", rs.getString("materialNumber"));
				jso.put("materialType", rs.getString("materialType"));
				if(countPost.equals("0")){
					jso.put("materialCountNum", rs.getString("materialCountNum"));
					jso.put("materialMeasureUnit", rs.getString("materialMeasureUnit"));
				}else{
					jso.put("materialCountNum", rs.getString("materialCountNum"));
					jso.put("materialMeasureUnit", rs.getString("materialMeasureUnit"));
				}
				jso.put("materialWeight", rs.getString("materialWeight"));
				jso.put("materialProductType", rs.getString("materialProductType"));
				jso.put("wareHouseName", rs.getString("wareHouseName"));
				jsa.add(jso);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsa;

	}
	
	public static void generateDestBill(Context ctx, String srcBosType,  
            String destBosType, CoreBillBaseCollection srcBillCollection,  
            IObjectPK botpPK) throws Exception {  
        IBOTMapping botMapping = BOTMappingFactory.getLocalInstance(ctx);  
        CoreBillBaseInfo billInfo = srcBillCollection.get(0);  
        BOTMappingInfo botMappingInfo = botMapping.getMapping(billInfo, destBosType, DefineSysEnum.BTP);  
        if (botMappingInfo == null) {  
            throw new FMException(FMException.NODESTBILL);  
        }  
        IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);  
        BTPTransformResult btpResult = null;  
        /*String[] ids = new String[srcBillCollection.size()]; 
        for (int i = 0; i < srcBillCollection.size(); ++i) { 
            CoreBaseInfo info = srcBillCollection.get(i); 
            ids[i] = info.getId().toString(); 
        }*/  
        btpResult = iBTPManager.transformForBotp(srcBillCollection,destBosType, botpPK);  
        IObjectCollection destBillCols = btpResult.getBills();  
        BOTRelationCollection botRelationCols = btpResult.getBOTRelationCollection();  
        for (int i = 0; i < destBillCols.size(); i++) {  
            CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols.getObject(i);  
            iBTPManager.submitRelations(destBillInfo, botRelationCols);  
        }  
    }  
	
	
	
	 /**
	 * 获取自动编码
	 * @param ctx
	 * @param companyID
	 * @param objectValue
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static String getAutoCode(Context ctx,String companyID,IObjectValue objectValue) throws BOSException, EASBizException{
		IOrgSwitchFacade orgSwitch=null;
		ICodingRuleManager codeRuleMgr=null;
		if(ctx==null){
			orgSwitch=OrgSwitchFacadeFactory.getRemoteInstance();
			codeRuleMgr=CodingRuleManagerFactory.getRemoteInstance();
		}else{
			orgSwitch=OrgSwitchFacadeFactory.getLocalInstance(ctx);
			codeRuleMgr=CodingRuleManagerFactory.getLocalInstance(ctx);
		}
		
		orgSwitch.orgSwitch(companyID);
		if(codeRuleMgr.isUseIntermitNumber(objectValue, companyID)){
			return codeRuleMgr.readNumber(objectValue, companyID);
		}else{
			return codeRuleMgr.getNumber(objectValue, companyID);
		}
		
	}
}