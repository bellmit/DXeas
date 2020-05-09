package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.castor.util.Base64Decoder;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount;
import com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFactory;
import com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;

/**
 * 结算单
 * @author alex_dai
 *
 */
public class StatementsBill  extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		return "18D671B0";
	}

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*","farmer.name","farm.name","farmersTree.name"
				,"stockingBatch.number","period.number"
				,"BatchDetail.*","BatchDetail.stockingBatch.number","BatchDetail.house.number","BatchDetail.house.name"
				,"entrys.*","entrys.settlementItem.number","entrys.settlementItem.name"
				,"entrys.material.number","entrys.unit.name"
				,"EggEntry.*","EggEntry.settlementItem.number","EggEntry.settlementItem.name"
				,"EggEntry.material.number","EggEntry.unit.name"
				,"RewardsEntry.*"
				,"OtherEntry.*"
				,"HandEntry.*"
		};
	}
	
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		StatementOfAccountInfo info=(StatementOfAccountInfo) model;
		//移除签名数据
//		info.setSignData(null);
		return info;
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","farmer.name","bizDate","period.number"
				,"stockingBatch.number","confirmTime"
				,"farmerProfit"
		};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number desc,entrys.seq";
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
			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}
	
	/**
	 * 确认单据
	 */
	public static String confirm(Context ctx,String jsonStr) {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		String signData=jo.getString("signData");
		jo=ResultUtils.getResultSuccess();
		try {
			IStatementOfAccount is = StatementOfAccountFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			StatementOfAccountInfo info = is.getStatementOfAccountInfo(new ObjectUuidPK(id));
			info.setConfirmTime(new Date());
			slor.add("confirmTime");
			
			if(StringUtils.isNotBlank(signData)){
//				info.setSignData(Base64Decoder.decode(signData));
				slor.add("signData");
			}
			is.updatePartial(info,slor);
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();
	}


}
