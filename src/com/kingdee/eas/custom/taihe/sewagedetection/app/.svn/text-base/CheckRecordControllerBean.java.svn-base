//package com.kingdee.eas.custom.taihe.sewagedetection.app;
//
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.kingdee.bos.BOSException;
//import com.kingdee.bos.Context;
//import com.kingdee.bos.dao.IObjectValue;
//import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckItemCollection;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckItemFactory;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordEntryInfo;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordFactory;
//import com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordInfo;
//import com.kingdee.eas.custom.taihe.sewagedetection.utils.ExtractService;
//import com.kingdee.eas.custom.taihe.sewagedetection.utils.Rule;
//import com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum;
//import com.kingdee.eas.scm.common.BillBaseStatusEnum;
//import com.kingdee.eas.util.app.DbUtil;
//import com.kingdee.jdbc.rowset.IRowSet;
//
//public class CheckRecordControllerBean extends AbstractCheckRecordControllerBean
//{
//    private static Logger logger =
//        Logger.getLogger("com.kingdee.eas.custom.taihe.sewagedetection.app.CheckRecordControllerBean");
//    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//	/**
//	 * 自动同步污水检测数据
//	 */
//	protected void _getCheckRecord(Context ctx, IObjectValue model) throws BOSException {
//		try {
//			//判断是会否为生产环境
//			String eas_home=System.getProperty("EAS_HOME");
//			if(eas_home.contains("runtime")) {
//				return;
//			}
//		}catch(Exception err) {
//			err.printStackTrace();
//		}
//		//设置为user
//		ctx.setCaller(new ObjectUuidPK("256c221a-0106-1000-e000-10d7c0a813f413B7DE7F"));
//		
//		IRowSet rs = DbUtil.executeQuery(ctx," select FCompanyID,FCheckUrl,FSiteNum,FSitePwd from T_SEW_CheckBaseSetting where FbaseStatus="+UsedStatusEnum.APPROVED_VALUE);
//		try {
//			if(rs.size()<=0) {
//				return;
//			}
//			HashMap<String,CheckItemInfo> map=getCheckItemIDByName(ctx);
//			if(map==null||map.size()<=0) {
//				return;
//			}
//			List<String> datas;
//			while(rs.next()) {
//				datas=getDatasByClass(rs.getString("FCheckUrl"), rs.getString("FSiteNum"), rs.getString("FSitePwd"));
//				dealData(ctx, rs.getString("FCompanyID"), map,datas);
//			}
//		} catch (SQLException e) {
//			throw new BOSException(e);
//		}
//	}
//	/**
//	 * 数据处理
//	 * @param ctx
//	 * @param companyID
//	 * @param datas
//	 * @throws BOSException 
//	 */
//	private void dealData(Context ctx,String companyID,HashMap<String,CheckItemInfo> map,List<String> datas) throws BOSException {
//		System.out.println("污水水质检测:"+datas.toString());
//		String dateStr=sdf.format(new Date());
//		IRowSet rs = DbUtil.executeQuery(ctx, "select fid from T_SEW_CheckRecord where FcompanyID=? and to_char(fbizDate,'yyyy-MM-dd')=?",new Object[]{companyID,dateStr});
//		try {
//			CheckRecordInfo info=null;
//			if(rs.next()) {
//				info=CheckRecordFactory.getLocalInstance(ctx).getCheckRecordInfo(new ObjectUuidPK(rs.getString("fid")));
//			}else {
//				info=new CheckRecordInfo();
//				info.setString("company", companyID);
//				info.setBizDate(new Date());
//				info.setBillStatus(BillBaseStatusEnum.AUDITED);
//			}
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
//						entryInfo=new CheckRecordEntryInfo();
//						entryInfo.setCheckItem(map.get(proName));
//						entryInfo.setRecordTime(recordTime);
//						entryInfo.setUpperLimit(entryInfo.getCheckItem().getUpperLimit());
//						//yumingxu
//						entryInfo.setInIndex(entryInfo.getCheckItem().getInIndex());
//						unit=sa[1].split(" ")[1];
//						checkValue=new BigDecimal(sa[1].split(" ")[0]);
//						entryInfo.setCheckValue(checkValue);
//						if(entryInfo.getUpperLimit()!=null&&entryInfo.getUpperLimit().compareTo(BigDecimal.ZERO)>0&&entryInfo.getUpperLimit().compareTo(checkValue)<=0) {
//							entryInfo.setIsOverproof(true);
//						}
//						entryInfo.setUnit(unit);
//						info.getEntry().add(entryInfo);
//					}
//				}
//			}
//			if(entryInfo!=null) {
//				CheckRecordFactory.getLocalInstance(ctx).save(info);
//			}
//		} catch (Exception e) {
//			throw new BOSException(e);
//		}
//	}
//	
//	public List<String> getDatasByClass(String url,String subid,String uid)  
//    {  
////        Rule rule = new Rule(  
////                "http://61.133.63.5:8405/showdatac.aspx",  
////        new String[] { "subid","uid" }, new String[] { "2750","1" },  
////                "realdata", Rule.AttributeValue, Rule.GET);  
//        Rule rule = new Rule(url, new String[] { "subid","uid" }, new String[] { subid,uid }, "realdata", Rule.AttributeValue, Rule.GET);  
//        List extracts = ExtractService.extract(rule); 
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
//	private HashMap<String,CheckItemInfo> getCheckItemIDByName(Context ctx) throws BOSException {
//		HashMap<String,CheckItemInfo> map=new HashMap<String, CheckItemInfo>();
//		CheckItemCollection cols = CheckItemFactory.getLocalInstance(ctx).getCheckItemCollection("where baseStatus="+UsedStatusEnum.APPROVED_VALUE);
//		for(int index=0;index<cols.size();index++) {
//			map.put(cols.get(index).getName(), cols.get(index));
//		}
//		return map;
//	}
//}