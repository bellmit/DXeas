package com.kingdee.eas.farm.food.app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.farm.food.FreshCountBillEntryInfo;
import com.kingdee.eas.farm.food.FreshCountBillFactory;
import com.kingdee.eas.farm.food.FreshCountBillInfo;
import com.kingdee.eas.farm.food.IFreshCountBill;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.OrgUnitUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;

public class WSFoodFacadeControllerBean extends AbstractWSFoodFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.food.app.WSFoodFacadeControllerBean");

	/**
	 * 上传单据
	 */
	protected String _uploadBill(Context ctx, String jsonString) throws BOSException {
		JSONObject result=new JSONObject();
		result.put("resultCode",0 );
		result.put("resultMsg","成功" );
		JSONObject jsonOb;
		try {
			jsonOb = JSONObject.fromObject(jsonString);	
			if(jsonOb.get("companyNum")==null) {
				result.put("resultCode",1 );
				result.put("resultMsg","公司不能为空！" );
				return result.toString();
			}
			if(jsonOb.get("billType")==null) {
				/*result.put("resultCode",1 );
				result.put("resultMsg","传入单据类型不能为空！" );*/
			}
	
			OrgUnitInfo orgInfo = OrgUnitUtils.getOrgUnitInfoByNum(ctx, jsonOb.getString("companyNum"));
		     
			FreshCountBillInfo info=new FreshCountBillInfo();
			info.setBizDate(new java.util.Date());
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			info.setNumber(AppCommon.getInstance(ctx).getAutoCode(ctx, info, orgInfo.getId().toString()));
			info.setStorageOrg(StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(orgInfo.getId())));
			IMaterial ims = MaterialFactory.getLocalInstance(ctx);
			JSONArray entrysJa=jsonOb.getJSONArray("entrys");
			JSONObject entryJo;
			if(entrysJa!=null) {
				for(int index=0;index<entrysJa.size();index++) {
					entryJo=entrysJa.getJSONObject(index);
					if(entryJo.get("materialID")==null) {
						result.put("resultCode",1 );
						result.put("resultMsg","第"+(index+1)+"行物料不能为空！" );
						break;
					}
					if(entryJo.get("qty")==null) {
						result.put("resultCode",1 );
						result.put("resultMsg","第"+(index+1)+"数量不能为空！" );
						break;
					}
					
					FreshCountBillEntryInfo entryInfo=new FreshCountBillEntryInfo();
					MaterialInfo mi = ims.getMaterialInfo(new ObjectUuidPK(entryJo.getString("materialID")));
					entryInfo.setMaterial(mi);
					entryInfo.setMaterialName(mi.getName());
					entryInfo.setModel(mi.getModel());
					entryInfo.setUnit(mi.getBaseUnit());
					entryInfo.setQty(new BigDecimal(entryJo.getString("qty")));
					//entryInfo.setWeight(new BigDecimal(jsonOb.getString("weight")));
					info.getEntrys().add(entryInfo);
				}
			}
			FreshCountBillFactory.getLocalInstance(ctx).submit(info);
		} catch (Exception e) {
			throw new BOSException(e.getMessage());
		}
		return result.toString();
	}

	/**
	 * 获取基础资料
	 */
	protected String _getBaseData(Context ctx, String jsonStr) throws BOSException {
		// TODO Auto-generated method stub
		try{
			JSONObject queryJson=JSONObject.fromObject(jsonStr);
			if(queryJson.get("billType")==null) {
				/*result.put("resultCode",1 );
				result.put("resultMsg","传入单据类型不能为空！" );*/
			}
			
			String companyNum=queryJson.getString("companyNum");
			if(StringUtils.isBlank(companyNum)) {
				return null;
			}
			JSONArray ja=new JSONArray();
			StringBuffer sql=new StringBuffer();
			sql.append(" select tm.FID,tm.FNumber,tm.FName_l2 FName,tm.FModel ");
			sql.append(" from CT_FM_CoutBillSetting tmain");
			sql.append(" inner join t_org_baseUnit torg on torg.FID=tmain.CFStorageOrgUnitID");
			sql.append(" inner join CT_FM_CoutBSME tentry on tentry.FParentID=tmain.FID");
			sql.append(" inner join t_bd_material tm on tm.FID=tentry.CFMaterialID");
			sql.append(" where torg.FNumber=? and CFBillType=1");
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString(),new Object[]{companyNum});
			while (rs.next()) {
				JSONObject jo=new JSONObject();
				jo.put("materialID", rs.getString("FID"));
				jo.put("number", rs.getString("FNumber"));
				jo.put("name",rs.getString("FName") );
				jo.put("model", rs.getString("FModel"));
				ja.add(jo);
			}
			rs.close();
			return ja.toString();
		}catch(Exception e){
			throw new BOSException(e.getMessage());
		}
	}

	/**
	 * 获取鲜品计数单
	 */
	protected String _getBillInfo(Context ctx, String jsonString) throws BOSException {
		
		return null;
	}

	/**
	 * 获取鲜品计数单 列表
	 */
	protected String _getBillList(Context ctx, String jsonString) throws BOSException {
		try {
			JSONObject queryJson=JSONObject.fromObject(jsonString);
			if(queryJson.get("billType")==null) {
				/*result.put("resultCode",1 );
				result.put("resultMsg","传入单据类型不能为空！" );*/
			}
			String companyNum=queryJson.getString("companyNum");
			String bizDateStr=queryJson.getString("bizDate");
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			Date bizDate=format.parse(bizDateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(bizDate);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrg.number",companyNum,CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("bizDate",bizDate,CompareType.GREATER_EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("bizDate",cal.getTime(),CompareType.LESS_EQUALS));
			SorterItemCollection sorter=new SorterItemCollection();
			SorterItemInfo siInfo = new SorterItemInfo("number");
			siInfo.setSortType(SortType.DESCEND);
			sorter.add(siInfo);
			ev.setSorter(sorter);
			ev.setFilter(filter);
			CoreBaseCollection cols = FreshCountBillFactory.getLocalInstance(ctx).getCollection(ev);
			FreshCountBillInfo countBillInfo;
			FreshCountBillEntryInfo countEntryInfo;
			IFreshCountBill is = FreshCountBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("entrys.*"));
			slor.add(new SelectorItemInfo("entrys.material.*"));
			if(cols!=null&&cols.size()>0) {
				JSONArray jsa=new JSONArray();
				for(int i=0;i<cols.size();i++){
					countBillInfo=is.getFreshCountBillInfo(new ObjectUuidPK(cols.get(i).getId()),slor);
					for(int j=0;j<countBillInfo.getEntrys().size();j++) {//分录
						countEntryInfo= countBillInfo.getEntrys().get(j);
						JSONObject jo=new JSONObject();
						jo.put("billID", countBillInfo.getId().toString());
						jo.put("billNumber", countBillInfo.getNumber());
						jo.put("bizDate", format.format(countBillInfo.getBizDate()));
						jo.put("entryID",countEntryInfo.getId().toString());
						jo.put("materialNum", countEntryInfo.getMaterial().getNumber());
						jo.put("materialName", countEntryInfo.getMaterial().getName());
						jo.put("model", countEntryInfo.getMaterial().getModel());
						jo.put("qty", countEntryInfo.getQty());
						jo.put("weight", countEntryInfo.getWeight());
						jsa.add(jo);
					}
				}
				System.out.println(jsa.toString());
				return jsa.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
    
}