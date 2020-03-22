package com.kingdee.eas.custom.echickeninterface.common;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedFacade;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchEntryDetailInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CommonExportUtils {

	public CommonExportUtils() {
	}

	/**
	 * 获得用户的type的信息
	 * 
	 * @param ctx
	 * @param username
	 * @param type
	 *            ，养殖场，鸡舍，养殖规范，批次
	 * @param fparentid 
	 * @return
	 * @throws EASBizException
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	public static Object getBaseData(Context ctx, String username, String type, String params)
			throws EASBizException, NumberFormatException, SQLException {

		if (StringUtils.isBlank(username) || StringUtils.isBlank(type)) {
			throw new EASBizException(new NumericExceptionSubItem("001",
					"username或type为空异常"));
		}

		String result="";
		Set<String> orgSet = getUserOrgsByname(ctx, username);
		// 1.获得该用户所拥有的组织关系列表
		if(type.equals("orglist")){
			result=getOrgListData(ctx,orgSet);
		}
		//2.获取养殖场信息
		if (type.equals("feedfactory")) {
			result = getFeedFactoryData(ctx,orgSet);
		}
		//3.获取鸡舍信息
		if(type.equals("henhouse")){
			result=getHenHouseData(ctx,orgSet);
		}
		//4.获取养殖规范表头信息
		if(type.equals("feedspecificationhead")){
			result=getFeedSpecificationhead(ctx);
		}
		//5.获取养殖规范分录信息
		if(type.equals("feedspecificationentry")){
			result=getFeedSpecificationentry(ctx,params);
		}
		//6.获取养殖批次表头信息
		if(type.equals("feedlothead")){
			result=getFeedLotHead(ctx,orgSet);
		}
		//7.获得养殖批次分录信息
		if(type.equals("feedlotentry")){
			result=getFeedLotEntry(ctx,params);
		}
		//8.获得该组织该日期下的养殖批次信息;params 包括：养殖场fnumber，日期fbizdate参数使用','分隔
		if(type.equals("currentfeedlot")){
			result=getCurrentFeedLot(ctx,params);
		}
		//9.根据日龄获取养殖规范的分录信息;params 包括：cfday日龄，cfhousetype鸡舍类别，参数使用','分隔
		if(type.equals("dayspecification")){
			result=getSpecificationByDay(ctx,params);
		}
		//10.根据批次id，业务日期，获得各个鸡舍的存栏量
		if(type.equals("currentBatchBreedingStock")){
			result=getBatchBreedingStock(ctx,params);
		}
		return result;
	}



	/**
	 * 获得鸡舍 当前存栏量 key 鸡舍ID， value 存栏量等详细信息
	 * @param ctx
	 * @param params：批次id，业务日期；
	 * @return
	 * @throws EASBizException 
	 */
	private static String getBatchBreedingStock(Context ctx, String params) throws EASBizException {
		String[] paramArray=params.split(",");
		String batchID=paramArray[0];
		String bizDate=paramArray[1];
		StringBuffer result=new StringBuffer();
		EFeedCommicalCDAE efeedCommicalCDAE=new EFeedCommicalCDAE();
		StringBuffer sql1=new StringBuffer();//定栏数量查询sql
		StringBuffer sql2=new StringBuffer();//死淘数出栏数转栏数总和数量查询sql
		Map<String , Integer> qtyMap=new HashMap<String, Integer>();
		sql1.append(" select bbe.cfhenhouseid henhouseid,bbe.cfinitqty qty from CT_FM_BreedBatchEntry bbe where fparentid ='");
		sql1.append(batchID+"'");
		
		sql2.append(" select te.CFHenhouseID henhouseid,sum(te.CFCullAndDeath) cullAndDeath,sum(te.CFMarketQty) marketQty,sum(CFTRANSQTY) transQty   from CT_FM_CommecialCDAE te inner join CT_FM_CommecialChilkenDaily t on te.fparentid = t.fid where t.cfbreedbatchid ='");
		sql2.append(batchID);
		sql2.append("' and t.fbizdate <= {ts'");
		sql2.append(bizDate+"'} group by te.CFHenhouseID ");
		
		try {
			IRowSet rs1=DbUtil.executeQuery(ctx, sql1.toString());
			while(rs1.next()){
				//rs1是定栏数量
				qtyMap.put(rs1.getString("henhouseid"), rs1.getInt("qty"));
			}
			
			IRowSet rs2=DbUtil.executeQuery(ctx, sql2.toString());
			while(rs2.next()){
				//rs2死淘出栏总数量
				String henhouseID=rs2.getString("henhouseid");
				int cullAndDeath=rs2.getInt("cullAndDeath");
				int marketQty=rs2.getInt("marketQty");
				int transQty=rs2.getInt("transQty");
				int breedingStock=qtyMap.get(henhouseID)-cullAndDeath-marketQty-transQty;
				efeedCommicalCDAE.setCFHenhouseID(henhouseID);
				efeedCommicalCDAE.setCFBreedingStock(breedingStock);//存栏量
				efeedCommicalCDAE.setCFCullAndDeath(cullAndDeath);//死淘数
				efeedCommicalCDAE.setCFMarketQty(marketQty);//出栏数
				efeedCommicalCDAE.setCFTransQty(transQty);//专栏数
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedCommicalCDAE));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}

	/**
	 * 获取养殖规范的分录信息;params 包括：day日龄，cfhousetype鸡舍类别，参数使用','分隔
	 * @param ctx
	 * @param params ;日龄，鸡舍类别,如果日龄<0则，查询所有的规范
	 * @return；该类别鸡舍，当前日龄的饲喂规范；
	 * @throws EASBizException 
	 */
	private static String getSpecificationByDay(Context ctx, String params) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedModel efFeedModel=new EFeedModel();
		//获得传入参数
		String[] paramArray=params.split(",");
		String cfdays=paramArray[0];
		String cfhousetype=paramArray[1];
		
		sql.append(" select bm.cfdeletedstatus,bm.fname_l2,bme.cfmaterialid fslid,bme.cfdays cfdays,bme.cfqtyperday cfqtyperday,m.fname_l2 fslname,m.fnumber fslnumber");
		sql.append(" from CT_FM_BreedModel bm inner join CT_FM_BreedModelEntrys bme on bm.fid=bme.fparentid");
		sql.append(" inner join T_BD_Material m on m.fid=bme.cfmaterialid");
		sql.append(" where bm.cfdeletedstatus=1 and bm.CFHOUSETYPE="+cfhousetype);
		if(Integer.valueOf(cfdays)>-1)
			sql.append(" and bme.cfdays="+cfdays);
		sql.append(" order by bme.cfdays");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				efFeedModel.setFdays(rs.getInt("cfdays"));
				efFeedModel.setFslid(rs.getString("fslid"));
				efFeedModel.setFslname(rs.getString("fslname"));
				efFeedModel.setFslnumber(rs.getString("fslnumber"));
				efFeedModel.setCfqtyperday(rs.getString("cfqtyperday"));
				
				result.append(JSONUtils.convertObjectToJson(ctx, efFeedModel));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		}
		
		return result.toString();
	}

	/**
	 * 获取组织列表，组织id和name
	 * @param ctx
	 * @param orgSet
	 * @return
	 * @throws EASBizException 
	 */
	private static String getOrgListData(Context ctx, Set<String> orgSet) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EOrgList orgList=new EOrgList();
		sql.append(" select fid,fname_l2 fname,fnumber from T_ORG_BaseUnit where fid in(");
		for(Iterator<String> it=orgSet.iterator();it.hasNext();){
			sql.append("'"+it.next().toString()+"',");
		}
		sql.deleteCharAt(sql.length()-1);//去掉最后多余的“，”
		sql.append(")and fname_l2 like '%场' order by fnumber");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				orgList.setFid(rs.getString("fid"));
				orgList.setFname(rs.getString("fname"));
				orgList.setFnumber(rs.getString("fnumber"));
				//3.将java对象转换为json字符串
				
				result.append(JSONUtils.convertObjectToJson(ctx, orgList));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.toString();
		
	}

	/**
	 * 获取养殖批次分录信息
	 * @param ctx
	 * @param fparentid
	 * @return
	 * @throws EASBizException 
	 */
	private static String getFeedLotEntry(Context ctx, String fparentid) throws EASBizException {
		
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedLotEntry efeedLotentry=new EFeedLotEntry();
		sql.append(" select cfhenhousename,cfhenhouseid,hh.fnumber cfhenhousenumber,cfchikentype,cfinitqty,cfincoopdate,cfismarket,cfcockqty,cfhenqty,cfcockfixedqty,cfhenfixedqty from ct_fm_breedbatchentry bbh ");
		sql.append(" inner join CT_FM_Henhouse hh on bbh.cfhenhouseid=hh.fid");
		sql.append(" where fparentid='");
		sql.append(fparentid+"' order by fseq");
		
		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				efeedLotentry.setCfhenhousename(rs.getString("cfhenhousename"));
				efeedLotentry.setCfhenhouseid(rs.getString("cfhenhouseid"));
				efeedLotentry.setCfhenhousenumber(rs.getString("cfhenhousenumber"));
				switch(rs.getInt("cfchikentype")){
					case 1:efeedLotentry.setCfchikentype("育成母鸡");break;
					case 2:efeedLotentry.setCfchikentype("育成公鸡");break;
					case 3:efeedLotentry.setCfchikentype("产蛋母鸡");break;
					case 4:efeedLotentry.setCfchikentype("产蛋公鸡");break;
					case 5:efeedLotentry.setCfchikentype("商品鸡");break;
					default:efeedLotentry.setCfchikentype("其它");
				}
				efeedLotentry.setCfinitqty(rs.getString("cfinitqty"));
				if(rs.getDate("cfincoopdate")!=null)
					efeedLotentry.setCfincoopdate(rs.getDate("cfincoopdate").toString());
				if(rs.getInt("cfismarket")==0){
					efeedLotentry.setCfismarket("否");
				}else{
					efeedLotentry.setCfismarket("是");
				}
				efeedLotentry.setCfcockqty(rs.getString("cfcockqty"));
				efeedLotentry.setCfhenqty(rs.getString("cfhenqty"));
				efeedLotentry.setCfcockfixedqty(rs.getString("cfcockfixedqty"));
				efeedLotentry.setCfhenfixedqty(rs.getString("cfhenfixedqty"));
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedLotentry));
				result.append(",");
			}
			if(result.length()>0)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	
	
		
		return result.toString();
	}

	/**
	 * 获取养殖批次表头信息
	 * @param ctx
	 * @param orgSet
	 * @return
	 * @throws EASBizException 
	 */
	private static String getFeedLotHead(Context ctx, Set<String> orgSet) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedLotHead efeedlothead=new EFeedLotHead();
		//1.查询组织
		sql.append(" select bb.fid feedlotfid,bs.cfname farmname,co.fname_l2 flotname ,bb.fbizdate fbizdate,sum(bbe.cfinitqty) finitqty,sum(bbe.cfcockqty) cfcockqty,sum(cfhenqty) cfhenqty,sum(cfcockfixedqty) cfcockfixedqty ,sum(cfhenfixedqty) cfhenfixedqty from ct_fm_breedbatch bb");
		sql.append(" inner join T_BD_CostObject co on bb.cfcostobjectid=co.fid ");
		sql.append(" inner join ct_fm_breedstoorgset bs on bs.cfstoorgid=bb.cfstoorgid"); 
		sql.append(" inner join ct_fm_breedbatchentry bbe on bb.fid=bbe.fparentid");
		sql.append(" where cfstoorgid in (");
		for(Iterator<String> it=orgSet.iterator();it.hasNext();){
			sql.append("'"+it.next().toString()+"',");
		}
		sql.deleteCharAt(sql.length()-1);//去掉最后多余的“，”
		sql.append(") group by bb.fid,bs.cfname ,co.fname_l2  ,bb.fbizdate order by bs.cfname,bb.fbizdate desc");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				efeedlothead.setFeedlotfid(rs.getString("feedlotfid"));
				efeedlothead.setFarmname(rs.getString("farmname"));
				efeedlothead.setFlotname(rs.getString("flotname"));
				efeedlothead.setFbizdate(rs.getDate("fbizdate").toString());
				efeedlothead.setFinitqty(rs.getString("finitqty"));
				efeedlothead.setCfcockqty(rs.getString("cfcockqty"));
				efeedlothead.setCfhenqty(rs.getString("cfhenqty"));
				efeedlothead.setCfcockfixedqty(rs.getString("cfcockfixedqty"));
				efeedlothead.setCfhenfixedqty(rs.getString("cfhenfixedqty"));
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedlothead));
				result.append(",");
			}
			if(result.length()>0)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result.toString();
	}
	
	/**
	 * 获得养殖规范分录
	 * @param ctx
	 * @param fparentid
	 * @return
	 * @throws EASBizException 
	 */
	private static String getFeedSpecificationentry(Context ctx,
			String fparentid) throws EASBizException {
		
		StringBuffer sql=new StringBuffer();
	
		sql.append(" select cfhousetype from  CT_FM_BreedModel   where fid='");
		sql.append(fparentid+"'");
		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				//1,育成，2，产蛋，3商品鸡舍
				switch(rs.getInt("CFHOUSETYPE")){
				case 1:
				case 2:return getFeedSpecificationentryYC(ctx, fparentid);
				case 3:return getFeedSpecificationentrySP(ctx, fparentid);
				default:return null;
				}
			}
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return null;
	}

	/**
	 * 获得育成，产蛋期养殖规范分录
	 * @param ctx
	 * @param fparentid
	 * @return
	 */
	private static String getFeedSpecificationentryYC(Context ctx,String fparentid){
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedSpecificationEntry efeedSpecificationEntry=new EFeedSpecificationEntry();
		
		//1.根据parentid查询 育成，产蛋期养殖规范
		sql.append(" select cfweek,cfhenmaterialid,cfhenqtyperday,cfcockmaterialid,cfcockqtyperday,cfbreedtime,cflightingtime,cfdailydcrate from CT_FM_BreedModelEntrys   where fparentid='");
		sql.append(fparentid+"' order by cfweek");
		
		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				efeedSpecificationEntry.setFweek(rs.getInt("cfweek"));
				efeedSpecificationEntry.setCfhenmaterialname(getmaterialname(ctx, rs.getString("cfhenmaterialid")));
				efeedSpecificationEntry.setCfhenqtyperday(rs.getString("cfhenqtyperday"));
				efeedSpecificationEntry.setCfcockmaterialname(getmaterialname(ctx, rs.getString("cfcockmaterialid")));
				efeedSpecificationEntry.setCfcockqtyperday(rs.getString("cfcockqtyperday"));
				efeedSpecificationEntry.setCfbreedtime(rs.getString("cfbreedtime"));
				efeedSpecificationEntry.setCflightingtime(rs.getString("cflightingtime"));
				efeedSpecificationEntry.setCfdailydcrate(String.valueOf(rs.getFloat("cfdailydcrate")));
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedSpecificationEntry));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
	/**
	 * 通过物料id获取物料名称
	 * @param string
	 * @return
	 */
	private static String getmaterialname(Context ctx,String materialid) {

		StringBuffer sql=new StringBuffer();
		sql.append(" select fname_l2 from t_bd_material where fid='");
		sql.append(materialid+"'");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next())
				return rs.getString("fname_l2");
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取parentid 的商品鸡养殖规范分录
	 * @param ctx
	 * @param fparentid养殖规范表头id
	 * @return
	 * @throws EASBizException 
	 */
	private static String getFeedSpecificationentrySP(Context ctx,
			String fparentid) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedSpecificationEntry efeedSpecificationEntry=new EFeedSpecificationEntry();
		//1.根据fparentid查询商品鸡养殖规范分录
		sql.append(" select bme.cfdays fdays,m.fname4idx fslname,cfqtyperday,cfbreedtime,cflightingtime,cfdailydcrate,cfstandardweight from CT_FM_BreedModelEntrys bme inner join t_bd_material m on bme.cfmaterialid=m.fid where fparentid='");
		sql.append(fparentid);
		sql.append("' order by cfdays");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				efeedSpecificationEntry.setFdays(rs.getInt("fdays"));
				efeedSpecificationEntry.setFslname(rs.getString("fslname"));
				efeedSpecificationEntry.setCfqtyperday(rs.getString("cfqtyperday"));
				efeedSpecificationEntry.setCfbreedtime(rs.getString("cfbreedtime"));
				efeedSpecificationEntry.setCflightingtime(rs.getString("cflightingtime"));
				efeedSpecificationEntry.setCfdailydcrate(String.valueOf(rs.getFloat("cfdailydcrate")));
				efeedSpecificationEntry.setCfstandardweight(String.valueOf(rs.getFloat("cfstandardweight")));
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedSpecificationEntry));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return result.toString();
	}

	/**
	 * 获取所有养殖规范表头信息
	 * @param ctx
	 * @return
	 * @throws EASBizException 
	 */
	private static String getFeedSpecificationhead(Context ctx) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		EFeedSpecificationHead efeedSpecificationhead=new EFeedSpecificationHead();
		StringBuffer result=new StringBuffer();
		//1.查询养殖规范表头
		sql.append(" select fid,fnumber,fname_l2,cfdeletedstatus,cfhousetype,cfbreeddays,cflimitbreeddays from CT_FM_BreedModel  order by CFHOUSETYPE");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				efeedSpecificationhead.setFid(rs.getString("FID"));
				efeedSpecificationhead.setFnumber(rs.getString("FNUMBER"));
				efeedSpecificationhead.setFname(rs.getString("FNAME_L2"));
				switch(rs.getInt("CFHOUSETYPE")){
					case 1:efeedSpecificationhead.setHousetype("育成鸡舍");break;
					case 2:efeedSpecificationhead.setHousetype("产蛋鸡舍");break;
					case 3:efeedSpecificationhead.setHousetype("商品鸡舍");break;
					default:efeedSpecificationhead.setHousetype("其他鸡舍");
				}
				efeedSpecificationhead.setCfbreeddays(rs.getInt("cfbreeddays"));
				efeedSpecificationhead.setCflimitbreeddays(rs.getInt("cflimitbreeddays"));
				//1是启用，2是禁用
				if(rs.getInt("cfdeletedstatus")==1)
					efeedSpecificationhead.setFstatus("启用");
				else
					efeedSpecificationhead.setFstatus("禁用");
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedSpecificationhead));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
			
		} catch (BOSException e) {
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * 获得组织列表中的所有鸡舍信息
	 * @param ctx
	 * @param orgSet
	 * @return
	 * @throws EASBizException 
	 */
	private static String getHenHouseData(Context ctx, Set<String> orgSet) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		EHenHouse eHenHouse=new EHenHouse();
		StringBuffer result=new StringBuffer();
		//1.查询鸡舍信息
		sql.append("select h.*,b.cfname factoryname from CT_FM_Henhouse h inner join ct_fm_breedstoorgset b on  h.cfchickenfarmid=b.cfstoorgid  where CFCHICKENFARMID in (");
		for(Iterator<String> it=orgSet.iterator();it.hasNext();){
			sql.append("'"+it.next().toString()+"',");
		}
		sql.deleteCharAt(sql.length()-1);//去掉最后多余的“，”
		sql.append(") order by h.fnumber");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				eHenHouse.setFid(rs.getString("FID"));
				eHenHouse.setFnumber(rs.getString("FNUMBER"));
				eHenHouse.setFname(rs.getString("CFNAME"));
				eHenHouse.setFfeedfactory(rs.getString("factoryname"));
				switch(rs.getInt("CFHOUSETYPE")){
					case 1:eHenHouse.setFcategory("育成鸡舍");break;
					case 2:eHenHouse.setFcategory("产蛋鸡舍");break;
					case 3:eHenHouse.setFcategory("商品鸡舍");break;
					default:eHenHouse.setFcategory("其他鸡舍");
				}
				eHenHouse.setFstatus(rs.getInt("CFDELETEDSTATUS"));
				
				//3.将java对象转换为json字符串
				
				result.append(JSONUtils.convertObjectToJson(ctx, eHenHouse));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * 获得组织列表中的所有的养殖场信息
	 * @param orgSet
	 * @return
	 * @throws EASBizException 
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	private static String getFeedFactoryData(Context ctx,Set<String> orgSet) throws EASBizException, NumberFormatException {
		StringBuffer sql=new StringBuffer();
		EFeedFactory eFeedFactory=new EFeedFactory();
		StringBuffer result=new StringBuffer();
		//1.查询组织下所有的养殖场信息
		sql.append(" select bss.*,p.fname_l1 fleadername from CT_FM_BreedStoorgSet bss left join T_BD_Person p on p.fid=bss.cffarmleaderid  where CFSTOORGID in (");
		for(Iterator<String> it=orgSet.iterator();it.hasNext();){
			sql.append("'"+it.next().toString()+"',");
		}
		sql.deleteCharAt(sql.length()-1);//去掉最后多余的“，”
		sql.append(") order by bss.fnumber");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			//2.将查询结果转换为养殖场对象
			while(rs.next()){
				eFeedFactory.setFid(rs.getString("FID"));
				eFeedFactory.setFname(rs.getString("CFNAME"));
				eFeedFactory.setFnumber(rs.getString("FNUMBER"));
				eFeedFactory.setFmanagername(rs.getString("fleadername"));
				eFeedFactory.setFaddress(rs.getString("CFADDRESS"));
				eFeedFactory.setFstatus(rs.getInt("CFSTATUS"));
				switch(rs.getInt("CFHENHOUSETYPE")){
					case 1:eFeedFactory.setFhenhousetype("育成鸡舍");break;
					case 2:eFeedFactory.setFhenhousetype("产蛋鸡舍");break;
					case 3:eFeedFactory.setFhenhousetype("商品鸡舍");break;
					default:eFeedFactory.setFhenhousetype("其它鸡舍");
				}
				
				//3.将java对象转换为json字符串
				result.append(JSONUtils.convertObjectToJson(ctx, eFeedFactory));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return result.toString();
	}

	/**
	 * 通过username获得该用户所有的组织fid
	 * 
	 * @param ctx
	 * @param username
	 * @return org fid list
	 * @throws EASBizException
	 */
	public static Set<String> getUserOrgsByname(Context ctx, String username)
			throws EASBizException {
		Set<String> orgSet = new HashSet<String>();

		StringBuffer sql = new StringBuffer();

		sql.append(" select forgid from T_PM_OrgRange where fuserid in ( select fid from T_PM_User where fnumber='");
		sql.append(username + "')");

		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while (rs.next()) {
				orgSet.add(rs.getString("forgid"));
			}

		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		}

		return orgSet;
	}

	
	/**
	 * 获取该养殖场该业务日期之前的最新养殖批次信息
	 * @param ctx
	 * @param params
	 * @return
	 * @throws EASBizException 
	 */
	private static String getCurrentFeedLot(Context ctx, String params) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedLotHead efeedLotHead=new EFeedLotHead();
		String[] paramArray=params.split(",");
		String farmNumber=paramArray[0];
		String fbizdate=paramArray[1];
		System.out.println(farmNumber+" and "+fbizdate);
		sql.append(" select top 1 co.fname_l2 fname,bb.fbizdate fbizdate,bb.fid feedlotfid,bb.fnumber fnumber from  ct_fm_breedbatch bb");
		sql.append(" inner join T_BD_CostObject co on bb.cfcostobjectid=co.fid");
		sql.append(" inner join T_ORG_BaseUnit bu on bu.fid=bb.cfstoorgid");
		sql.append(" where bu.fnumber='");
		sql.append(farmNumber);
		sql.append("' and bb.fbizdate<=to_date('");
		sql.append(fbizdate);
		sql.append("') order by bb.fbizdate desc");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				efeedLotHead.setFlotname(rs.getString("fname"));
				efeedLotHead.setFeedlotfid(rs.getString("feedlotfid"));
				efeedLotHead.setFeedlotfnumber(rs.getString("fnumber"));
				efeedLotHead.setFbizdate(rs.getString("fbizdate"));
				result.append(JSONUtils.convertObjectToJson(ctx, efeedLotHead));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//去掉最后一个","
			
		} catch (BOSException e) {
			throw new EASBizException(new NumericExceptionSubItem("001",
					"数据读取异常" + e.getMessage()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}

}
