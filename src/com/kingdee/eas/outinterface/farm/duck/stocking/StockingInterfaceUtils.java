package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * ���ݷ���������
 * @author alex_dai
 *
 */
public class StockingInterfaceUtils {
	
	/**
	 * ��ȡ��ɫ��������
	 * @return
	 */
	public static String getRoleFilterStr(JSONObject paramsJO,String farmerColumnName) {
		//�����ֶβ�Ϊ��
		if(StringUtils.isEmpty(farmerColumnName)) {
			farmerColumnName="";
		}else {
			farmerColumnName+=".";
		}
		
		//��ɫ
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = paramsJO.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			rolesStr.append(" ");
			//����
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(farmerColumnName).append("identity='").append(paramsJO.getString("idNo")).append("'");
			}
			//ҵ��Ա������Ա
			else if(StringUtils.equalsIgnoreCase(role,"manager")){
//				rolesStr.append(farmerColumnName).append("id in (")
//				.append(" select distinct tentry.FFarmerID")
//				.append(" from T_FM_PersonFarmerRelation tmain")
//				.append(" inner join T_FM_PersonFarmerRelationEntry tentry on tentry.fparentid=tmain.fid")
//				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
//				.append(" where tuser.fnumber='").append(paramsJO.getString("userNum")).append("'")
//				.append(" and tmain.FBaseStatus=3")
//				.append(")");
				//�����ݶ���ͨȨ��ά�����
				rolesStr.append(farmerColumnName).append("" +
						"id in(select distinct per.CFFarmID from CT_FM_EmtPermission per\r\n" + 
						"inner join CT_FM_EmtPermissionUserEntrys  pere on per.fid=pere.fparentid\r\n" + 
						"inner join t_pm_user tuser on tuser.fpersonid=pere.CFPersonNameID\r\n" + 
						"where tuser.fnumber='"+paramsJO.getString("userNum")+"' )" );
			}
			//˾��--����������Χ����
			else if(StringUtils.equalsIgnoreCase(role,"driver")){
				rolesStr.append(farmerColumnName).append("id in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_DriverFarmerRange tmain")
				.append(" inner join T_FM_DriverFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join CT_FM_Driver tp on tp.fid=tmain.FDriverID")
				.append(" where tp.CFDrivercardid='").append(paramsJO.getString("idNo")).append("'")
				.append(" and tmain.FBaseStatus=3")
				.append(")");
			}
			//�����ڵĽ�ɫ
			else {
				rolesStr.append(" id='00000000-0000-0000-0000-000000000000CCE7AED4'");
			}
		}
		return rolesStr.toString();
	}
	
	/**
	 * ��ȡ��ɫ��������
	 * @return
	 * @throws BOSException 
	 */
	public static ArrayList<String> getFarmerIdsByRole(Context ctx,JSONObject paramsJO) throws BOSException {
		//��ɫ
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = paramsJO.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" union ");
			}
			//����
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" select fid from T_FM_Farmers where ")
				.append(" fidentity='").append(paramsJO.getString("idNo")).append("'");
			}
			//ҵ��Ա������Ա
			else if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" select fid from T_FM_Farmers tfarmer where ")
				.append(" exists (")
				.append(" select tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRelation tmain")
				.append(" inner join T_FM_PersonFarmerRelationEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(paramsJO.getString("userNum")).append("'")
				.append(" and tfarmer.fid=tentry.FFarmerID")
				.append(" and tmain.FBaseStatus=3")
				.append(")");
			}
			//˾��--����������Χ����
			else if(StringUtils.equalsIgnoreCase(role,"driver")){
				rolesStr.append(" select fid from T_FM_Farmers tfarmer where ")
				.append(" exists (")
				.append(" select tentry.FFarmerID")
				.append(" from T_FM_DriverFarmerRange tmain")
				.append(" inner join T_FM_DriverFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join CT_FM_Driver tp on tp.fid=tmain.FDriverID")
				.append(" where tp.CFDrivercardid='").append(paramsJO.getString("idNo")).append("'")
				.append(" and tfarmer.fid=tentry.FFarmerID")
				.append(" and tmain.FBaseStatus=3")
				.append(")");
			}
			//�����ڵĽ�ɫ
			else {
				rolesStr.append(" select fid from T_FM_Farmers where ")
				.append(" fid='00000000-0000-0000-0000-000000000000CCE7AED4'");
			}
		}
		
		ArrayList<String> list=new ArrayList<String>();
		if(rolesStr.length()>0) {
			IRowSet rs = DbUtil.executeQuery(ctx, "/*dialect*/"+rolesStr.toString());
			try {
				while(rs.next()) {
					list.add(rs.getString("fid"));
				}
			} catch (SQLException e) {
				throw new BOSException(e);
			}
		}
		
		
		return list;
	}
	
	/**
	 * ������ֳ����ȡ����
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static FarmersInfo getFarmerByFarm(Context ctx,FarmInfo farmInfo) throws BOSException, EASBizException {
		if(farmInfo==null) {
			return null;
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" select top 1 tffe.FID")
		.append(" from T_FM_FarmersFarm tff")
		.append(" inner join T_FM_FarmersFarmEntry tffe on tffe.FParentid=tff.fid")
		.append(" where tffe.FFarmID='").append(farmInfo.getString("id")).append("'")
		.append(" order by tff.FCreateTime desc")
		.append(" ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()) {
				return FarmersFactory.getLocalInstance(ctx).getFarmersInfo(new ObjectUuidPK(rs.getString("FID")));
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return null;
	}
}
