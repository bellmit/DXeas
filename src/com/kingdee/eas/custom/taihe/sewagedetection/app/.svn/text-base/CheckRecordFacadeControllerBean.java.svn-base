//package com.kingdee.eas.custom.taihe.sewagedetection.app;
//
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import org.apache.log4j.Logger;
//
//import com.kingdee.bos.BOSException;
//import com.kingdee.bos.Context;
//import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
//import com.kingdee.bos.dao.query.SQLExecutorFactory;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckItemCollection;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckItemFactory;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordEntryInfo;
//import com.kingdee.eas.custom.taihe.sewagedetection.utils.ExtractService;
//import com.kingdee.eas.custom.taihe.sewagedetection.utils.Rule;
//import com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum;
//import com.kingdee.eas.util.app.DbUtil;
//import com.kingdee.jdbc.rowset.IRowSet;
//
//public class CheckRecordFacadeControllerBean extends AbstractCheckRecordFacadeControllerBean
//{
//	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//    private static Logger logger =
//        Logger.getLogger("com.kingdee.eas.custom.taihe.sewagedetection.app.CheckRecordFacadeControllerBean");
//
//
//	@Override
//	protected String _getHistoryDate(Context ctx, String date)
//			throws BOSException {
//		JSONObject resultJS = new JSONObject();
//		try {
//				JSONObject json=JSONObject.fromObject(date);
//				//加权限部分
//				/*String personID = getPersonID(ctx,json.getString("personNumber"));
//				if(personID!=null){
//					if(!PermissionFactory.getLocalInstance(ctx).hasFunctionPermission(new ObjectUuidPK(personID), new ObjectUuidPK(personID), "sewageDetection_modileSee"));
//					resultJS.put("massage", "您没有该业务功能权限");
//					resultJS.put("result", "0");
//					return resultJS.toString();
//				}*/
//				JSONArray resultJA = new JSONArray();
//				String nowTime = json.getString("historyTime");
//				StringBuffer companySql = new StringBuffer();
//				String sp = "\n";
//				companySql.append("select t2.FID	companyID,t2.FName_l2	companyName from ").append(sp);
//				companySql.append("T_SEW_CheckRecord 				t1").append(sp);
//				companySql.append("inner join T_ORG_BaseUnit				t2	on t1.FCompanyID = t2.FID").append(sp);
//				companySql.append("where to_char(t1.FBizDate,'yyyy-MM-dd') = '").append(nowTime).append("'").append(sp);
//				IRowSet companyRs = SQLExecutorFactory.getLocalInstance(ctx, companySql.toString()).executeSQL();
//					while(companyRs.next()){
//						JSONObject js = getDetailed(ctx, nowTime, companyRs.getString("companyID"), companyRs.getString("companyName"));
//						resultJA.add(js);
//					}
//					resultJS.put("massage", "success");
//					resultJS.put("result", "0");
//					resultJS.put("data",resultJA);
//				
//			
//		}  catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return resultJS.toString();
//		
//	}
//	//根据用户名查询ID
//	private String getPersonID(Context ctx, String personNumber){
//		StringBuffer sb = new StringBuffer();
//		sb.append("select FPERSONID from T_PM_User where FNumber = '").append(personNumber).append("'");
//		String personID = null;
//		try {
//			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
//			if(rs.next()){
//				personID = rs.getString("FPERSONID");
//			}
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return personID;
//	}
//
//	@Override
//	protected String _getNowDate(Context ctx) throws BOSException {
//		// TODO Auto-generated method stub
//		JSONObject result=new JSONObject();
//		//加权限部分
//	/*	//先设置一个假date
//		String date  = null;
//		JSONObject json=JSONObject.fromObject(date);
//		String personID = getPersonID(ctx,json.getString("personNumber"));
//		if(personID!=null){
//			try {
//				if(!PermissionFactory.getLocalInstance(ctx).hasFunctionPermission(new ObjectUuidPK(personID), new ObjectUuidPK(personID), "sewageDetection_modileSee"));
//			} catch (EASBizException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			result.put("massage", "您没有该业务功能权限");
//			result.put("result", "0");
//			return result.toString();
//		}else{
//			result = getCheckRecord(ctx);
//		}*/
//		result = getCheckRecord(ctx);
//		return result.toString();
//	}
//    private JSONObject getDetailed(Context ctx,String date,String companyID,String companyName) throws BOSException, SQLException{
//    	JSONArray detailedJA = new JSONArray();
//    	StringBuffer detailedSql = new StringBuffer();
//    	String sp = "\n";
//    	detailedSql.append("/*dialect*/").append(sp);
//    	detailedSql.append("select  ").append(sp);
//    	detailedSql.append("to_char(t2.FRECORDTIME,'yyyy-MM-dd  hh24') 	BizDate,").append(sp);
//    	detailedSql.append("t3.FName_l2				CheckItem,").append(sp);
//    	detailedSql.append("t2.FCHECKVALUE				CheckValue,").append(sp);
//    	detailedSql.append("t2.FUnit					Unit,").append(sp);
//    	detailedSql.append("t2.FUpperLimit				UpperLimit,").append(sp);
//    	//yumingxu
//    	detailedSql.append("t2.CFInIndex				InIndex,").append(sp);
//    	
//    	detailedSql.append("case when t2.FCHECKVALUE>t2.FUpperLimit		then 1	else 0 	end	IsoverProof").append(sp);
//    	detailedSql.append(" from ").append(sp);
//    	detailedSql.append("T_SEW_CheckRecord 				t1").append(sp);
//    	detailedSql.append("inner join T_SEW_CheckRecordEntry			t2	on t2.FParentID = t1.FID").append(sp);
//    	detailedSql.append("inner join T_SEW_CheckItem				t3	on t3.FID = t2.FCheckItemID").append(sp);
//    	detailedSql.append("where to_char(t1.FBizDate,'yyyy-MM-dd') = '").append(date).append("' and t1.FCompanyID ='").append(companyID).append("'").append(sp);
//    	detailedSql.append("order by to_char(t2.FRECORDTIME,'yyyy-MM-dd:HH')").append(sp);
//    	IRowSet detailedRs = SQLExecutorFactory.getLocalInstance(ctx, detailedSql.toString()).executeSQL();
//    	while(detailedRs.next()){
//    		JSONObject detailedJS = new JSONObject();
//    		detailedJS.put("BizDate", detailedRs.getString("BizDate"));		//日期
//    		detailedJS.put("CheckItem", detailedRs.getString("CheckItem"));//检测项目
//    		detailedJS.put("CheckValue", detailedRs.getString("CheckValue"));//检测值
//    		detailedJS.put("Unit", detailedRs.getString("Unit"));			//单位
//    		detailedJS.put("UpperLimit", detailedRs.getString("UpperLimit"));//指标上线
//    		detailedJS.put("InIndex", detailedRs.getString("InIndex"));//内部指标
//    		detailedJS.put("IsoverProof", detailedRs.getString("IsoverProof"));//是否超标  1超标 0未超标
//    		detailedJA.add(detailedJS);
//    	}
//    	JSONObject resultJS = new JSONObject();
//    	resultJS.put("companyName", companyName);
//    	resultJS.put("detailed", detailedJA);
//    	
//		return resultJS;
//
//    }
//    /**
//	 * 自动同步污水检测数据
//	 */
//	protected JSONObject getCheckRecord(Context ctx) throws BOSException {
//		JSONArray resultJA = new JSONArray();
//		JSONObject resultJS = new JSONObject();
//		try {
//			//判断是会否为生产环境
//			String eas_home=System.getProperty("EAS_HOME");
//			/*if(eas_home.contains("runtime")) {
//				return null;
//			}*/
//		}catch(Exception err) {
//			err.printStackTrace();
//		}
//		//设置为user
//		ctx.setCaller(new ObjectUuidPK("256c221a-0106-1000-e000-10d7c0a813f413B7DE7F"));
//		
//		IRowSet rs = DbUtil.executeQuery(ctx," select t2.FName_l2 companyName,FCompanyID,FCheckUrl,FSiteNum,FSitePwd " +
//				" from T_SEW_CheckBaseSetting t1 inner join T_ORG_BaseUnit	t2	on t2.FID = t1.FCompanyID where t1.FbaseStatus="+UsedStatusEnum.APPROVED_VALUE);
//		try {
//			if(rs.size()<=0) {
//				return null;
//			}
//			
//			List<String> datas;
//			while(rs.next()) {
//				datas=getDatasByClass(rs.getString("FCheckUrl"), rs.getString("FSiteNum"), rs.getString("FSitePwd"));
//				
//				HashMap<String,CheckItemInfo> map=getCheckItemIDByName(ctx,rs.getString("companyName"));
//				if(map==null||map.size()<=0) {
//					//return null;
//				}else{
//					JSONObject js = dealData(ctx,rs.getString("companyName"), rs.getString("FCompanyID"), map,datas);
//					resultJA.add(js);
//				}
//				
//			}
//		} catch (SQLException e) {
//			throw new BOSException(e);
//		}
//		resultJS.put("massage", "success");
//		resultJS.put("result", "0");
//		resultJS.put("data",resultJA);
//		return resultJS;
//	}
//	private JSONObject dealData(Context ctx,String companyName,String companyID, HashMap<String,CheckItemInfo> map,List<String> datas) throws BOSException {
//		System.out.println("污水水质检测:"+datas.toString());
//		//System.out.println(map.toString());
//		JSONArray detailedJA = new JSONArray();
//		try {
//			String[] sa;
//			CheckRecordEntryInfo entryInfo=null;
//			String proName,unit;//值，单位
//			BigDecimal checkValue;
//			Date recordTime=null;
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			for(String str:datas) {
//				if(str.contains("年")) {
//					str=str.replaceAll("年", "-");
//					str=str.replaceAll("月", "-");
//					str=str.replaceAll("日", "");
//					recordTime=sdf.parse(str+":00");
//				} else {
//					sa=str.split(":");
//					proName=sa[0].trim();
//					if(map.containsKey(proName)) {
//						
//						entryInfo=new CheckRecordEntryInfo();
//						String aaaaaaa  = map.get(proName).getName();
//						entryInfo.setCheckItem(map.get(proName));
//						entryInfo.setRecordTime(recordTime);
//						entryInfo.setUpperLimit(entryInfo.getCheckItem().getUpperLimit());
//						//yumignxu 
//						entryInfo.setInIndex(entryInfo.getCheckItem().getInIndex());
//						
//						unit=sa[1].split(" ")[1];
//						checkValue=new BigDecimal(sa[1].split(" ")[0]);
//						entryInfo.setCheckValue(checkValue);
//						entryInfo.setUnit(unit);
//						JSONObject detailedJS = new JSONObject();
//			    		detailedJS.put("CheckItem", map.get(proName).getName());//检测项目
//			    		detailedJS.put("CheckValue", checkValue);//检测值
//			    		detailedJS.put("Unit", unit);			//单位
//			    		detailedJS.put("UpperLimit", entryInfo.getCheckItem().getUpperLimit());//指标上线
//			    		detailedJS.put("InIndex", entryInfo.getCheckItem().getInIndex());//内部指标
//			    		//yumingxu 
//			    		if(entryInfo.getInIndex()!=null&&entryInfo.getInIndex().compareTo(BigDecimal.ZERO)>0&&entryInfo.getInIndex().compareTo(checkValue)<=0) {
//			    			detailedJS.put("IsoverProof", "1");//是否超标  1超标 0未超标
//						}else{
//							detailedJS.put("IsoverProof", "0");//是否超标  1超标 0未超标
//						}
//			    		detailedJA.add(detailedJS);
//			    		
//					}
//				}
//			}
//		} catch (Exception e) {
//			throw new BOSException(e);
//		}
//		JSONObject resultJS = new JSONObject();
//    	resultJS.put("companyName", companyName);
//    	resultJS.put("detailed", detailedJA);
//		return resultJS;
//	}
//	public List<String> getDatasByClass(String url,String subid,String uid)  
//    {  
////        Rule rule = new Rule(  
////                "http://61.133.63.5:8405/showdatac.aspx",  
////        new String[] { "subid","uid" }, new String[] { "2750","1" },  
////                "realdata", Rule.AttributeValue, Rule.GET);  
//        Rule rule = new Rule(url, new String[] { "subid","uid" }, new String[] { subid,uid }, "realdata", Rule.AttributeValue, Rule.GET);  
//        List extracts = ExtractService.extract(rule); 
//        System.out.println(extracts.toString());
//        return extracts;
//    }  
//	 public void printf(List<String> datas)  
//	    {  
//	        for (String dataStr : datas)  
//	        {  
//	            System.out.println(dataStr);  
//	            System.out.println("***********************************");  
//	        }  
//	  
//	    }  
//	
//	/**
//	 * 获取检测项目
//	 * @throws BOSException 
//	 */
//	private HashMap<String,CheckItemInfo> getCheckItemIDByName(Context ctx,String companyName) throws BOSException {
//		HashMap<String,CheckItemInfo> map=new HashMap<String, CheckItemInfo>();
//		CheckItemCollection cols = CheckItemFactory.getLocalInstance(ctx).getCheckItemCollection("where baseStatus="+UsedStatusEnum.APPROVED_VALUE+" and company.name = '"+companyName+"'");
//		System.out.println(companyName);
//		for(int index=0;index<cols.size();index++) {
//			map.put(cols.get(index).getName(), cols.get(index));
//		}
//		return map;
//	}
//}