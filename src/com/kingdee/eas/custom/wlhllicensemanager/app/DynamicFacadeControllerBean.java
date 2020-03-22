package com.kingdee.eas.custom.wlhllicensemanager.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wlhllicensemanager.util.JUtils;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlDynamicBillUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class DynamicFacadeControllerBean extends AbstractDynamicFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.wlhllicensemanager.app.DynamicFacadeControllerBean");
	protected String _getDataByID(Context ctx, String jsonStr)throws BOSException, EASBizException
	{
		JSONObject json=new JSONObject();
		json.put("result", "0");
		json.put("message", "success");
		try {
			String dataStr=new WlhlDynamicBillUtils().getDataByID(ctx, jsonStr);
			json.put("data", dataStr);
		}catch(Exception err) {
			json.put("result", "1");
			json.put("message", err.getMessage());
		}
		return json.toString();
	}
	protected String _uploadDataByBosType(Context ctx, String bosType, String jsonStr)throws BOSException, EASBizException
	{
		JSONObject json=new JSONObject();
		json.put("result", "0");
		json.put("message", "success");
		try {
			String id=new WlhlDynamicBillUtils().uploadDataByBosType(ctx, bosType,jsonStr,null).toString();
			json.put("id", id);
		}catch(Exception err) {
			json.put("result", "1");
			json.put("message", err.getMessage());
		}
		return json.toString();
	}
	protected String _downloadBillList(Context ctx, String jsonStr)throws BOSException
	{
		JSONObject json=new JSONObject();
		json.put("result", "0");
		json.put("message", "success");
		try {
			JSONObject queryJson=JSONObject.parseObject(jsonStr);
			String bosType=queryJson.getString("bosType");
			String queryStr=null;
			if(queryJson.containsKey("queryStr")) {
				queryStr="where "+queryJson.getString("queryStr");
			}
			String queryInfo=null;
			if(queryJson.containsKey("queryInfo")) {
				queryInfo=queryJson.getString("queryInfo");
			}

			String[] queryCols=null;
			if(queryJson.containsKey("queryCols")) {
				queryCols=new String[queryJson.getJSONArray("queryCols").size()];
				for(int index=0;index<queryCols.length;index++) {
					queryCols[index]=queryJson.getJSONArray("queryCols").getString(index);
				}
			}
			int beginRow=0,length=1000;
			if(queryJson.containsKey("beginRow")) {
				beginRow=Integer.valueOf(queryJson.getString("beginRow"));
			}
			if(queryJson.containsKey("length")) {
				length=Integer.valueOf(queryJson.getString("length"));
			}

			if(bosType.equals("4409E7F0")) {//ÎïÁÏ
				if(queryStr!=null&&(queryStr.equals("where qy_fodder")||queryStr.equals("where qy_drug")||queryStr.equals("where qy_egg"))) {
					json.put("data", getMaterialFilter(ctx,queryStr, JUtils.getString(queryJson, "batchID")));
					return json.toString();
				}
			}

			String dataStr=new WlhlDynamicBillUtils().downloadBillList(ctx, bosType, queryInfo, queryStr, queryCols, beginRow, length).toString();
			json.put("data", dataStr);
		}catch(Exception err) {
			json.put("result", "1");
			json.put("message", err.getMessage());
		}
		return json.toString();
	}

	private String getMaterialFilter(Context ctx,String type,String batchID) throws BOSException {
		StringBuffer sql=new StringBuffer();
		if(type.equals("where qy_fodder")) {
			sql.append(" select tm.fid materialID,tm.fnumber materialNum,tm.fname_l2 materialName,tm.fmodel model,")
			.append(" tu.fid unitID,tu.fname_l2 unitName,isnull(tm.cfunitQty,0) unitQty from (")
			.append(" select distinct tentry.CFHenMaterialID FMaterialID from T_FM_BreedStandardEntry tentry")
			.append(" inner join T_FM_BreedStandard tmain on tmain.fid=tentry.fparentid")
			.append(" inner join T_FM_StockingBatch tbatch on tbatch.FBreedDataID=tmain.FBreedDataID")
			.append(" where tbatch.fid='").append(batchID).append("'")
			.append(" union all")
			.append(" select distinct tentry.CFCockMaterialID FMaterialID from T_FM_BreedStandardEntry tentry")
			.append(" inner join T_FM_BreedStandard tmain on tmain.fid=tentry.fparentid")
			.append(" inner join T_FM_StockingBatch tbatch on tbatch.FBreedDataID=tmain.FBreedDataID")
			.append(" where tbatch.fid='").append(batchID).append("'")
			.append(" ) ttemp ")
			.append(" inner join t_bd_material tm on tm.fid=ttemp.fmaterialid")
			.append(" inner join t_bd_measureunit tu on tu.fid=tm.FBaseUnit")
			;
		}else if(type.equals("where qy_drug")) {
			sql.append(" select tm.fid materialID,tm.fnumber materialNum,tm.fname_l2 materialName,tm.fmodel model,")
			.append(" tu.fid unitID,tu.fname_l2 unitName,isnull(tm.cfunitQty,0) ")
			.append(" from T_FM_BreedStandardDrugEntry tentry")
			.append(" inner join T_FM_BreedStandard tmain on tmain.fid=tentry.fparentid")
			.append(" inner join T_FM_StockingBatch tbatch on tbatch.FBreedDataID=tmain.FBreedDataID")
			.append(" inner join t_bd_material tm on tm.fid=tentry.fmaterialid")
			.append(" inner join t_bd_measureunit tu on tu.fid=tm.FBaseUnit")
			.append(" where tbatch.fid='").append(batchID).append("'");
		}
		else if(type.equals("where qy_egg")) {
			sql.append(" select tm.fid materialID,tm.fnumber materialNum,tm.fname_l2 materialName,tm.fmodel model,")
			.append(" tu.fid unitID,tu.fname_l2 unitName,isnull(tm.cfunitQty,0) ")
			.append(" from T_FM_BreedDataEntry tentry")
			.append(" inner join T_FM_BreedData tmain on tmain.fid=tentry.fparentid")
			.append(" inner join T_FM_StockingBatch tbatch on tbatch.FBreedDataID=tmain.fid")
			.append(" inner join t_bd_material tm on tm.fid=tentry.fmaterialid")
			.append(" inner join t_bd_measureunit tu on tu.fid=tm.FBaseUnit")
			.append(" where tbatch.fid='").append(batchID).append("'");
		}
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONArray ja=new JSONArray();
		try {
			JSONObject jo;
			while(rs.next()) {
				jo=new JSONObject();
				for(int index=1;index<=rs.getRowSetMetaData().getColumnCount();index++) {
					jo.put(rs.getRowSetMetaData().getColumnName(index), rs.getString(index));
				}
				ja.add(jo);
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return ja.toString();
	}
}