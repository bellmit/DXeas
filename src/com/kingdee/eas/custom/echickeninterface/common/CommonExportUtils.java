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
	 * ����û���type����Ϣ
	 * 
	 * @param ctx
	 * @param username
	 * @param type
	 *            ����ֳ�������ᣬ��ֳ�淶������
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
					"username��typeΪ���쳣"));
		}

		String result="";
		Set<String> orgSet = getUserOrgsByname(ctx, username);
		// 1.��ø��û���ӵ�е���֯��ϵ�б�
		if(type.equals("orglist")){
			result=getOrgListData(ctx,orgSet);
		}
		//2.��ȡ��ֳ����Ϣ
		if (type.equals("feedfactory")) {
			result = getFeedFactoryData(ctx,orgSet);
		}
		//3.��ȡ������Ϣ
		if(type.equals("henhouse")){
			result=getHenHouseData(ctx,orgSet);
		}
		//4.��ȡ��ֳ�淶��ͷ��Ϣ
		if(type.equals("feedspecificationhead")){
			result=getFeedSpecificationhead(ctx);
		}
		//5.��ȡ��ֳ�淶��¼��Ϣ
		if(type.equals("feedspecificationentry")){
			result=getFeedSpecificationentry(ctx,params);
		}
		//6.��ȡ��ֳ���α�ͷ��Ϣ
		if(type.equals("feedlothead")){
			result=getFeedLotHead(ctx,orgSet);
		}
		//7.�����ֳ���η�¼��Ϣ
		if(type.equals("feedlotentry")){
			result=getFeedLotEntry(ctx,params);
		}
		//8.��ø���֯�������µ���ֳ������Ϣ;params ��������ֳ��fnumber������fbizdate����ʹ��','�ָ�
		if(type.equals("currentfeedlot")){
			result=getCurrentFeedLot(ctx,params);
		}
		//9.���������ȡ��ֳ�淶�ķ�¼��Ϣ;params ������cfday���䣬cfhousetype������𣬲���ʹ��','�ָ�
		if(type.equals("dayspecification")){
			result=getSpecificationByDay(ctx,params);
		}
		//10.��������id��ҵ�����ڣ���ø�������Ĵ�����
		if(type.equals("currentBatchBreedingStock")){
			result=getBatchBreedingStock(ctx,params);
		}
		return result;
	}



	/**
	 * ��ü��� ��ǰ������ key ����ID�� value ����������ϸ��Ϣ
	 * @param ctx
	 * @param params������id��ҵ�����ڣ�
	 * @return
	 * @throws EASBizException 
	 */
	private static String getBatchBreedingStock(Context ctx, String params) throws EASBizException {
		String[] paramArray=params.split(",");
		String batchID=paramArray[0];
		String bizDate=paramArray[1];
		StringBuffer result=new StringBuffer();
		EFeedCommicalCDAE efeedCommicalCDAE=new EFeedCommicalCDAE();
		StringBuffer sql1=new StringBuffer();//����������ѯsql
		StringBuffer sql2=new StringBuffer();//������������ת�����ܺ�������ѯsql
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
				//rs1�Ƕ�������
				qtyMap.put(rs1.getString("henhouseid"), rs1.getInt("qty"));
			}
			
			IRowSet rs2=DbUtil.executeQuery(ctx, sql2.toString());
			while(rs2.next()){
				//rs2���Գ���������
				String henhouseID=rs2.getString("henhouseid");
				int cullAndDeath=rs2.getInt("cullAndDeath");
				int marketQty=rs2.getInt("marketQty");
				int transQty=rs2.getInt("transQty");
				int breedingStock=qtyMap.get(henhouseID)-cullAndDeath-marketQty-transQty;
				efeedCommicalCDAE.setCFHenhouseID(henhouseID);
				efeedCommicalCDAE.setCFBreedingStock(breedingStock);//������
				efeedCommicalCDAE.setCFCullAndDeath(cullAndDeath);//������
				efeedCommicalCDAE.setCFMarketQty(marketQty);//������
				efeedCommicalCDAE.setCFTransQty(transQty);//ר����
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedCommicalCDAE));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}

	/**
	 * ��ȡ��ֳ�淶�ķ�¼��Ϣ;params ������day���䣬cfhousetype������𣬲���ʹ��','�ָ�
	 * @param ctx
	 * @param params ;���䣬�������,�������<0�򣬲�ѯ���еĹ淶
	 * @return��������ᣬ��ǰ�������ι�淶��
	 * @throws EASBizException 
	 */
	private static String getSpecificationByDay(Context ctx, String params) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedModel efFeedModel=new EFeedModel();
		//��ô������
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
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		}
		
		return result.toString();
	}

	/**
	 * ��ȡ��֯�б���֯id��name
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
		sql.deleteCharAt(sql.length()-1);//ȥ��������ġ�����
		sql.append(")and fname_l2 like '%��' order by fnumber");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				orgList.setFid(rs.getString("fid"));
				orgList.setFname(rs.getString("fname"));
				orgList.setFnumber(rs.getString("fnumber"));
				//3.��java����ת��Ϊjson�ַ���
				
				result.append(JSONUtils.convertObjectToJson(ctx, orgList));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.toString();
		
	}

	/**
	 * ��ȡ��ֳ���η�¼��Ϣ
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
					case 1:efeedLotentry.setCfchikentype("����ĸ��");break;
					case 2:efeedLotentry.setCfchikentype("���ɹ���");break;
					case 3:efeedLotentry.setCfchikentype("����ĸ��");break;
					case 4:efeedLotentry.setCfchikentype("��������");break;
					case 5:efeedLotentry.setCfchikentype("��Ʒ��");break;
					default:efeedLotentry.setCfchikentype("����");
				}
				efeedLotentry.setCfinitqty(rs.getString("cfinitqty"));
				if(rs.getDate("cfincoopdate")!=null)
					efeedLotentry.setCfincoopdate(rs.getDate("cfincoopdate").toString());
				if(rs.getInt("cfismarket")==0){
					efeedLotentry.setCfismarket("��");
				}else{
					efeedLotentry.setCfismarket("��");
				}
				efeedLotentry.setCfcockqty(rs.getString("cfcockqty"));
				efeedLotentry.setCfhenqty(rs.getString("cfhenqty"));
				efeedLotentry.setCfcockfixedqty(rs.getString("cfcockfixedqty"));
				efeedLotentry.setCfhenfixedqty(rs.getString("cfhenfixedqty"));
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedLotentry));
				result.append(",");
			}
			if(result.length()>0)
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	
	
		
		return result.toString();
	}

	/**
	 * ��ȡ��ֳ���α�ͷ��Ϣ
	 * @param ctx
	 * @param orgSet
	 * @return
	 * @throws EASBizException 
	 */
	private static String getFeedLotHead(Context ctx, Set<String> orgSet) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedLotHead efeedlothead=new EFeedLotHead();
		//1.��ѯ��֯
		sql.append(" select bb.fid feedlotfid,bs.cfname farmname,co.fname_l2 flotname ,bb.fbizdate fbizdate,sum(bbe.cfinitqty) finitqty,sum(bbe.cfcockqty) cfcockqty,sum(cfhenqty) cfhenqty,sum(cfcockfixedqty) cfcockfixedqty ,sum(cfhenfixedqty) cfhenfixedqty from ct_fm_breedbatch bb");
		sql.append(" inner join T_BD_CostObject co on bb.cfcostobjectid=co.fid ");
		sql.append(" inner join ct_fm_breedstoorgset bs on bs.cfstoorgid=bb.cfstoorgid"); 
		sql.append(" inner join ct_fm_breedbatchentry bbe on bb.fid=bbe.fparentid");
		sql.append(" where cfstoorgid in (");
		for(Iterator<String> it=orgSet.iterator();it.hasNext();){
			sql.append("'"+it.next().toString()+"',");
		}
		sql.deleteCharAt(sql.length()-1);//ȥ��������ġ�����
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
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result.toString();
	}
	
	/**
	 * �����ֳ�淶��¼
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
				//1,���ɣ�2��������3��Ʒ����
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
	 * ������ɣ���������ֳ�淶��¼
	 * @param ctx
	 * @param fparentid
	 * @return
	 */
	private static String getFeedSpecificationentryYC(Context ctx,String fparentid){
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedSpecificationEntry efeedSpecificationEntry=new EFeedSpecificationEntry();
		
		//1.����parentid��ѯ ���ɣ���������ֳ�淶
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
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
	/**
	 * ͨ������id��ȡ��������
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
	 * ��ȡparentid ����Ʒ����ֳ�淶��¼
	 * @param ctx
	 * @param fparentid��ֳ�淶��ͷid
	 * @return
	 * @throws EASBizException 
	 */
	private static String getFeedSpecificationentrySP(Context ctx,
			String fparentid) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		StringBuffer result=new StringBuffer();
		EFeedSpecificationEntry efeedSpecificationEntry=new EFeedSpecificationEntry();
		//1.����fparentid��ѯ��Ʒ����ֳ�淶��¼
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
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return result.toString();
	}

	/**
	 * ��ȡ������ֳ�淶��ͷ��Ϣ
	 * @param ctx
	 * @return
	 * @throws EASBizException 
	 */
	private static String getFeedSpecificationhead(Context ctx) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		EFeedSpecificationHead efeedSpecificationhead=new EFeedSpecificationHead();
		StringBuffer result=new StringBuffer();
		//1.��ѯ��ֳ�淶��ͷ
		sql.append(" select fid,fnumber,fname_l2,cfdeletedstatus,cfhousetype,cfbreeddays,cflimitbreeddays from CT_FM_BreedModel  order by CFHOUSETYPE");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				efeedSpecificationhead.setFid(rs.getString("FID"));
				efeedSpecificationhead.setFnumber(rs.getString("FNUMBER"));
				efeedSpecificationhead.setFname(rs.getString("FNAME_L2"));
				switch(rs.getInt("CFHOUSETYPE")){
					case 1:efeedSpecificationhead.setHousetype("���ɼ���");break;
					case 2:efeedSpecificationhead.setHousetype("��������");break;
					case 3:efeedSpecificationhead.setHousetype("��Ʒ����");break;
					default:efeedSpecificationhead.setHousetype("��������");
				}
				efeedSpecificationhead.setCfbreeddays(rs.getInt("cfbreeddays"));
				efeedSpecificationhead.setCflimitbreeddays(rs.getInt("cflimitbreeddays"));
				//1�����ã�2�ǽ���
				if(rs.getInt("cfdeletedstatus")==1)
					efeedSpecificationhead.setFstatus("����");
				else
					efeedSpecificationhead.setFstatus("����");
				
				result.append(JSONUtils.convertObjectToJson(ctx, efeedSpecificationhead));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
			
		} catch (BOSException e) {
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * �����֯�б��е����м�����Ϣ
	 * @param ctx
	 * @param orgSet
	 * @return
	 * @throws EASBizException 
	 */
	private static String getHenHouseData(Context ctx, Set<String> orgSet) throws EASBizException {
		StringBuffer sql=new StringBuffer();
		EHenHouse eHenHouse=new EHenHouse();
		StringBuffer result=new StringBuffer();
		//1.��ѯ������Ϣ
		sql.append("select h.*,b.cfname factoryname from CT_FM_Henhouse h inner join ct_fm_breedstoorgset b on  h.cfchickenfarmid=b.cfstoorgid  where CFCHICKENFARMID in (");
		for(Iterator<String> it=orgSet.iterator();it.hasNext();){
			sql.append("'"+it.next().toString()+"',");
		}
		sql.deleteCharAt(sql.length()-1);//ȥ��������ġ�����
		sql.append(") order by h.fnumber");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				eHenHouse.setFid(rs.getString("FID"));
				eHenHouse.setFnumber(rs.getString("FNUMBER"));
				eHenHouse.setFname(rs.getString("CFNAME"));
				eHenHouse.setFfeedfactory(rs.getString("factoryname"));
				switch(rs.getInt("CFHOUSETYPE")){
					case 1:eHenHouse.setFcategory("���ɼ���");break;
					case 2:eHenHouse.setFcategory("��������");break;
					case 3:eHenHouse.setFcategory("��Ʒ����");break;
					default:eHenHouse.setFcategory("��������");
				}
				eHenHouse.setFstatus(rs.getInt("CFDELETEDSTATUS"));
				
				//3.��java����ת��Ϊjson�ַ���
				
				result.append(JSONUtils.convertObjectToJson(ctx, eHenHouse));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
			
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * �����֯�б��е����е���ֳ����Ϣ
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
		//1.��ѯ��֯�����е���ֳ����Ϣ
		sql.append(" select bss.*,p.fname_l1 fleadername from CT_FM_BreedStoorgSet bss left join T_BD_Person p on p.fid=bss.cffarmleaderid  where CFSTOORGID in (");
		for(Iterator<String> it=orgSet.iterator();it.hasNext();){
			sql.append("'"+it.next().toString()+"',");
		}
		sql.deleteCharAt(sql.length()-1);//ȥ��������ġ�����
		sql.append(") order by bss.fnumber");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			//2.����ѯ���ת��Ϊ��ֳ������
			while(rs.next()){
				eFeedFactory.setFid(rs.getString("FID"));
				eFeedFactory.setFname(rs.getString("CFNAME"));
				eFeedFactory.setFnumber(rs.getString("FNUMBER"));
				eFeedFactory.setFmanagername(rs.getString("fleadername"));
				eFeedFactory.setFaddress(rs.getString("CFADDRESS"));
				eFeedFactory.setFstatus(rs.getInt("CFSTATUS"));
				switch(rs.getInt("CFHENHOUSETYPE")){
					case 1:eFeedFactory.setFhenhousetype("���ɼ���");break;
					case 2:eFeedFactory.setFhenhousetype("��������");break;
					case 3:eFeedFactory.setFhenhousetype("��Ʒ����");break;
					default:eFeedFactory.setFhenhousetype("��������");
				}
				
				//3.��java����ת��Ϊjson�ַ���
				result.append(JSONUtils.convertObjectToJson(ctx, eFeedFactory));
				result.append(",");
			}
			if(result.length()>1)
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
		} catch (BOSException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return result.toString();
	}

	/**
	 * ͨ��username��ø��û����е���֯fid
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
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		}

		return orgSet;
	}

	
	/**
	 * ��ȡ����ֳ����ҵ������֮ǰ��������ֳ������Ϣ
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
				result.deleteCharAt(result.length()-1);//ȥ�����һ��","
			
		} catch (BOSException e) {
			throw new EASBizException(new NumericExceptionSubItem("001",
					"���ݶ�ȡ�쳣" + e.getMessage()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}

}
