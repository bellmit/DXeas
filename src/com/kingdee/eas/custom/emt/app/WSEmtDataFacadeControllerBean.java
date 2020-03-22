package com.kingdee.eas.custom.emt.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.kingdee.bos.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersFarmEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmersFarmEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;

public class WSEmtDataFacadeControllerBean extends AbstractWSEmtDataFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.emt.app.WSEmtDataFacadeControllerBean");

    /**
     * 获取养殖户收入信息
     * @param lastUpdateDate 最后更新日期
     */
    @Override
	protected String _getUserInComeInfo(Context ctx, String lastUpdateDate)
			throws BOSException {
    	JSONObject resultJson = new JSONObject();
    	resultJson.put("result", "success");
		
		if(StringUtils.isBlank(lastUpdateDate)){
			resultJson.put("result", "false");
			resultJson.put("message", "最后更新日期不能为空");
			
			return resultJson.toString();
		}
		
		StringBuffer sql = new StringBuffer("/*dialect*/");
		sql.append(" select to_char(te.fsenddate,'yyyy-mm-dd') as sendDate,  ");
		sql.append(" t1.fnumber as farmNumber,max(t1.fname_l2) as farmName, ");
		sql.append(" t2.fnumber as batchNumber,max(t2.fname_l2) as batchName, ");
		sql.append(" t3.fnumber as settlementNumber, max(t3.fname_l2) as settlementName, ");
		sql.append(" sum(te.fqty) as qty,sum(te.famount) as amount, ");
		sql.append(" max(t4.fname_l2) as unitName ");
		sql.append(" from t_fm_eggsettlebillentry te ");
		sql.append(" inner join T_FM_EggSettleBill t on te.fparentid = t.fid ");
		sql.append(" inner join T_FM_Farm t1 on t1.fid = te.ffarmid ");
		sql.append(" inner join T_FM_StockingBatch t2 on t2.fid = te.fstockingbatchid ");
		sql.append(" inner join T_FM_SettlementItem t3 on t3.fid = te.fsettleitemid ");
		sql.append(" inner join T_BD_MeasureUnit t4 on t4.fid = te.funitid ");
		sql.append(" where t.fbillstatus = 4 ");
		if(StringUtils.isNotBlank(lastUpdateDate)){
			sql.append(" and to_char(te.fsenddate,'yyyy-mm-dd') > '");
			sql.append(lastUpdateDate);
			sql.append("' ");	
		}
		sql.append(" group by to_char(te.fsenddate,'yyyy-mm-dd'), t1.fnumber, t2.fnumber,t3.fnumber ");
		sql.append(" order by to_char(te.fsenddate,'yyyy-mm-dd') desc ");
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONArray dataArray = new JSONArray();
		try {
			while(rs.next()){
				JSONObject dataJson = new JSONObject();
				dataJson.put("sendDate", rs.getString("sendDate"));
				dataJson.put("farmNumber", rs.getString("farmNumber"));
				dataJson.put("farmNumber", rs.getString("farmNumber"));
				dataJson.put("batchNumber", rs.getString("batchNumber"));
				dataJson.put("batchName", rs.getString("batchName"));
				dataJson.put("settlementNumber", rs.getString("settlementNumber"));
				dataJson.put("settlementName", rs.getString("settlementName"));
				dataJson.put("qty", rs.getBigDecimal("qty"));
				dataJson.put("amount", rs.getBigDecimal("amount"));
				dataJson.put("unitName", rs.getString("unitName"));
				
				dataArray.add(dataJson);
			}
			
			resultJson.put("data", dataArray);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", "false");
			resultJson.put("message", "查询失败");
			
		}
		return resultJson.toString();
	}

    /**
     * 获取养殖户领料信息
     */
	@Override
	protected String _getUserPayInfo(Context ctx, String lastUpdateDate)
			throws BOSException {
		JSONObject resultJson = new JSONObject();
    	resultJson.put("result", "success");
		
		if(StringUtils.isBlank(lastUpdateDate)){
			resultJson.put("result", "false");
			resultJson.put("message", "最后更新日期不能为空");
			
			return resultJson.toString();
		}
		
		JSONObject dataJson = new JSONObject();
		//保证金
		dataJson.put("margin", "");
		//领苗
		dataJson.put("seed", this.getBreedSeedJSON(ctx, lastUpdateDate));
		//领料
		dataJson.put("fodder", "");
		//领药
		dataJson.put("drug", "");
		//领其他辅料
		dataJson.put("other", "");
		
		resultJson.put("data", dataJson);
		
		return resultJson.toString();
	}
    
	/**
	 * 获取 养殖户批次信息batch
	 * 
	 * @param lastUpdateDate 上次更新日期
	 */
    @Override
	protected String _getUserFeedBatchInfo(Context ctx, String lastUpdateTime)
			throws BOSException {
    	JSONObject resultJson = new JSONObject();
    	resultJson.put("result", "success");
		
		if(StringUtils.isBlank(lastUpdateTime)){
			resultJson.put("result", "false");
			resultJson.put("message", "最后更新日期不能为空");
			
			return resultJson.toString();
		}
    	
		Timestamp lastUpdateTimestamp = Timestamp.valueOf(lastUpdateTime);
		
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("createTime", lastUpdateTimestamp, CompareType.GREATER));
		filterInfo.getFilterItems().add(new FilterItemInfo("baseStatus", 3, CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("isAllout", false, CompareType.EQUALS));
		ev.setFilter(filterInfo);
		
		StockingBatchCollection stockingBatchCollection = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchCollection(ev);
		//批次信息列表
		JSONArray dataArrayJson = new JSONArray();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < stockingBatchCollection.size(); i++) {
			//单条批次信息
			JSONObject dataJson = new JSONObject();
			StockingBatchInfo stockingBatchInfo = stockingBatchCollection.get(i);
			dataJson.put("number", stockingBatchInfo.getNumber());
			dataJson.put("name", stockingBatchInfo.getName());
			FarmInfo farmInfo = stockingBatchInfo.getFarm();
			try {
				//养殖场
				farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
				dataJson.put("fatory", farmInfo.getNumber());
				//品种
				BreedDataInfo breedDataInfo = stockingBatchInfo.getBreedData();
				breedDataInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(breedDataInfo.getId()));
				
				dataJson.put("category", "005");//005种鸭
				dataJson.put("feedCategory", breedDataInfo.getName());
				
				dataJson.put("maleQty", stockingBatchInfo.getBatchQty());
				dataJson.put("femaleQty", stockingBatchInfo.getFemaleQty());
				dataJson.put("totalQty", stockingBatchInfo.getTotalQty());
				
				dataJson.put("inDate", sdFormat.format(stockingBatchInfo.getInDate()));
				
				StockingBatchHouseEntryCollection stockingBatchHouseEntryCollection = stockingBatchInfo.getHouseEntry();
				JSONArray houseaArray = new JSONArray();
				for (int k=0;k<stockingBatchHouseEntryCollection.size();k++){
					JSONObject houseJson = new JSONObject();
					StockingBatchHouseEntryInfo entryInfo  = stockingBatchHouseEntryCollection.get(i);
					FarmHouseEntryInfo houseEntryInfo  = entryInfo.getHouse();
					houseEntryInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(houseEntryInfo.getId()));
					
					houseJson.put("houseNumber", houseEntryInfo.getNumber());
					houseJson.put("maleQty", entryInfo.getQty());
					houseJson.put("femaleQty", entryInfo.getFemaleQty());
					houseJson.put("totalQty", entryInfo.getQty().add(entryInfo.getFemaleQty()));
					
					houseJson.put("inDate", sdFormat.format(stockingBatchInfo.getInDate()));
					
					houseaArray.add(houseJson);
				}
				dataJson.put("mature", houseaArray);
				
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
			dataArrayJson.add(dataJson);
		}
		
		resultJson.put("data", dataArrayJson);
		
		return resultJson.toString();
	}
	
    /**
     * 获取 养殖户farmer、养殖场factory
     * 
     * @param lastUpdateDate 上次更新日期
     */
    protected String _getUserFeedInfo(Context ctx, String lastUpdateDate)throws BOSException
    {
    	JSONObject resultJson = new JSONObject();
    	resultJson.put("result", "success");
		
		if(StringUtils.isBlank(lastUpdateDate)){
			resultJson.put("result", "false");
			resultJson.put("message", "最后更新日期不能为空");
			
			return resultJson.toString();
		}
    	
		Timestamp lastUpdateTimestamp = Timestamp.valueOf(lastUpdateDate);
		
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("createTime", lastUpdateTimestamp, CompareType.GREATER));
		filterInfo.getFilterItems().add(new FilterItemInfo("baseStatus", 3, CompareType.EQUALS));
		ev.setFilter(filterInfo);
		
		FarmersCollection farmersCollection = FarmersFactory.getLocalInstance(ctx).getFarmersCollection(ev);
		//养殖户信息列表
		JSONArray dataArrayJson = new JSONArray();
		
		for (int i = 0; i < farmersCollection.size(); i++) {
			//单条养殖户信息
			JSONObject dataJson = new JSONObject();
			
			//养殖户信息
			JSONObject farmerJson = new JSONObject();
			FarmersInfo farmersInfo = farmersCollection.get(i);
			farmerJson.put("number", farmersInfo.getNumber());
			farmerJson.put("name", farmersInfo.getName());
			farmerJson.put("certNo", farmersInfo.getIdentity());
			farmerJson.put("sex", farmersInfo.getSex().getValue());	//男 1 女 2
			farmerJson.put("mobile", farmersInfo.getMobileTel());
			farmerJson.put("address", farmersInfo.getAddress());
		
			dataJson.put("farmer", farmerJson);
		
			//养殖户对应养殖场信息
			FarmersFarmEntryCollection  factoryCollection = farmersInfo.getFarmEntry();
			JSONArray factoryArray = new JSONArray();
			if(factoryCollection != null){
				factoryArray = this.getFactoryAndHouseJSONByFactoryCollection(ctx, factoryCollection, farmersInfo);
			}

			dataJson.put("factory", factoryArray);
			
			dataArrayJson.add(dataJson);
		}
		
		resultJson.put("data", dataArrayJson);
		
		return resultJson.toString();
    }
    
    /**
     * 获取 养殖场和禽舍信息
     * @param ctx
     * @param collection
     * @param farmersInfo
     * @return
     */
    private JSONArray getFactoryAndHouseJSONByFactoryCollection(Context ctx, FarmersFarmEntryCollection  collection, FarmersInfo farmersInfo){
    	JSONArray factoryArray = new JSONArray();
    	for (int i = 0; i < collection.size(); i++) {
			JSONObject factoryObject = new JSONObject();
			FarmersFarmEntryInfo farmersFarmEntryInfo = collection.get(i);
			FarmInfo farmInfo = farmersFarmEntryInfo.getFarm();
			try {
				farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			factoryObject.put("number", farmInfo.getNumber());
			factoryObject.put("name", farmInfo.getName());
			factoryObject.put("manager", farmersInfo.getName());
			factoryObject.put("mobile", farmersInfo.getMobileTel());
			factoryObject.put("address", farmInfo.getAddress());
			
			//禽舍信息
			JSONArray houseArray = new JSONArray();
			if(farmInfo.isIsHouseManager()){
				
				FarmHouseEntryCollection farmHouseEntryCollection = farmInfo.getHouseEntry();
				if(farmHouseEntryCollection != null){
					for (int j = 0; j < farmHouseEntryCollection.size(); j++) {
						FarmHouseEntryInfo farmHouseEntryInfo = farmHouseEntryCollection.get(i);
						JSONObject houseJson = new JSONObject();
						houseJson.put("number", farmInfo.getNumber());
						houseJson.put("name", farmInfo.getName());
						houseJson.put("factory", farmersInfo.getNumber());
						houseJson.put("feedcategory", "1"); //地养
						
						houseArray.add(houseJson);
					}
				}
				
			}else {
				JSONObject houseJson = new JSONObject();
				houseJson.put("number", farmInfo.getNumber());
				houseJson.put("name", farmInfo.getName());
				houseJson.put("factory", farmersInfo.getNumber());
				houseJson.put("feedcategory", "1"); //地养
				
				houseArray.add(houseJson);
			}
			factoryObject.put("house", houseArray);
			
			factoryArray.add(factoryObject);
		}
    	
    	return factoryArray;
    }

	
    /**
     * 获取 领苗信息
     * @param ctx
     * @param lastUpdateDate
     * @return
     */
    private JSONArray getBreedSeedJSON(Context ctx, String lastUpdateDate){
    	JSONArray seedArray = new JSONArray();
    	StringBuffer sql = new StringBuffer("/*dialect*/");
    	sql.append(" select to_char(t.fbizdate,'yyyy-mm-dd') as bizdate, t1.fnumber as farmNumber, ");
    	sql.append(" max(t1.fname_l2) as farmName, t2.fnumber as batchNumber, max(t2.fname_l2) as batchName, ");
    	sql.append(" t3.fnumber as materialNumber, max(t3.fname_l2) as materialName, max(t4.fname_l2) as unit, ");
    	sql.append(" sum(te.fallreceiveqty) as qty,sum(te.cfamount) as amount ");
    	sql.append(" from T_FM_BreedSeedBill t ");
    	sql.append(" inner join t_fm_breedseedbillentry te on te.fparentid = t.fid ");
    	sql.append(" inner join T_FM_Farm t1 on t1.fid = t.ffarmid ");
    	sql.append(" inner join T_FM_StockingBatch t2 on t2.fid = t.fstockingbatchid ");
    	sql.append(" inner join t_bd_material t3 on t3.fid = te.fmaterialid ");
    	sql.append(" inner join T_BD_MeasureUnit t4 on t4.fid = te.funitid ");
    	sql.append(" where t.fbillstatus = 4 ");
    	
    	if(StringUtils.isNotBlank(lastUpdateDate)){
    		sql.append(" and to_char(t.fbizdate,'yyyy-mm-dd') > '");
    		sql.append(lastUpdateDate);
    		sql.append("' ");
    	}
    	sql.append(" group by to_char(t.fbizdate,'yyyy-mm-dd'),t1.fnumber,t2.fnumber,t3.fnumber ");
    	sql.append(" order by to_char(t.fbizdate,'yyyy-mm-dd') desc ");
    	
    	try {
    		JSONArray dataArray = new JSONArray();
			IRowSet rsRowSet = DbUtil.executeQuery(ctx, sql.toString());
			while (rsRowSet.next()) {
				JSONObject dataObject = new JSONObject();
				dataObject.put("bizdate", rsRowSet.getString("bizdate"));
				dataObject.put("farmNumber", rsRowSet.getString("farmNumber"));
				dataObject.put("farmName", rsRowSet.getString("farmName"));
				dataObject.put("batchNumber", rsRowSet.getString("batchNumber"));
				dataObject.put("batchName", rsRowSet.getString("batchName"));
				dataObject.put("materialNumber", rsRowSet.getString("materialNumber"));
				dataObject.put("materialName", rsRowSet.getString("materialName"));
				dataObject.put("unit", rsRowSet.getString("unit"));
				dataObject.put("qty", rsRowSet.getBigDecimal("qty"));
				dataObject.put("amount", rsRowSet.getBigDecimal("amount"));
				
				dataArray.add(dataObject);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	return seedArray;
    }
}