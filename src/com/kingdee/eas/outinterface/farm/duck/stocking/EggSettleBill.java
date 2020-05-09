package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;

/**
 * 种蛋结算单
 * @author alex_dai
 *
 */
public class EggSettleBill  extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "7DD0D62D";
	}
	
	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*"
				,"entrys.*"
				,"entrys.farmer.id","entrys.farmer.name"
				,"entrys.farm.id","entrys.farm.name"
				,"entrys.house.id","entrys.house.number","entrys.house.name"
				,"entrys.stockingBatch.id","entrys.stockingBatch.number","entrys.stockingBatch.name"
				,"entrys.settleItem.id","entrys.settleItem.number","entrys.settleItem.name"
				,"entrys.material.id","entrys.material.number","entrys.material.name","entrys.material.model"
				,"entrys.unit.id","entrys.unit.number","entrys.unit.name"
		};
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","bizDate"
				,"farmer.name"
				,"amount"
				,"description"
				,"eggSource"
		};
	}
	
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number desc";
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		EggSettleBillInfo info=(EggSettleBillInfo) model;
		//明细数据
		for(int index=0;index<info.getEntrys().size();index++){
			info.getEntrys().get(index).getPriceEntry().clear();
		}
		return info;
	}
	
	@Override
	protected String getQueryInfo() {
		// TODO Auto-generated method stub
		return "com.kingdee.eas.outinterface.farm.duck.stocking.InterfaceEggSettleBillQuery";
	}

	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject resutlJson = super.getData(ctx, jsonStr);
		
		//由于存在多张养户在一张领用单上得情况，所以前端传入查询List(已过滤)获取到得entryId，单据展示是只展示有权限得分录
		if(resutlJson.getString("result").equals("0")&&paramsJson.containsKey("entryId")) {
			List entryIdsList = JSONArray.toJavaObject(paramsJson.getJSONArray("entryId"), List.class);
			if(entryIdsList.size()>0) {
				if(resutlJson.getJSONObject("data")!=null){
					JSONArray entrys = resutlJson.getJSONObject("data").getJSONArray("entrys");
					for(int index=0;index<entrys.size();index++) {
						JSONObject tmpjo = entrys.getJSONObject(index);
						if(!entryIdsList.contains(tmpjo.getString("id"))) {
							entrys.remove(tmpjo);
						}
					}
				}
			}
		}
		return resutlJson;
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" bizDate>={d '").append(beginDate).append("'}")
		.append(" and bizDate<{d '").append(endDate).append("'}");
		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//角色
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "farmer");
		if(rolesStr.length()>0) {
//			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}

	
}
