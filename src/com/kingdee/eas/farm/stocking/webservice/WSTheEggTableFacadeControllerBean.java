package com.kingdee.eas.farm.stocking.webservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.ICostObject;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeFactory;
import com.kingdee.eas.farm.stocking.basedata.IFarm;
import com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.IFarmers;
import com.kingdee.eas.farm.stocking.basedata.IFarmersTree;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.util.NumericExceptionSubItem;


public class WSTheEggTableFacadeControllerBean extends AbstractWSTheEggTableFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.webservice.WSTheEggTableFacadeControllerBean");

    
    /**
     * 生成交蛋表信息
     */
	@Override
	protected String _createNewTheEggTable(Context ctx, String param)
			throws BOSException {
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		
		
		JSONObject jsonParam=JSONObject.fromObject(param);
		
		
		String phoneNum;
		if(StringUtils.isNotEmpty(jsonParam.getString("phoneNum"))){
			phoneNum=jsonParam.getString("phoneNum");
		}else{
			resultJson.put("result",false);
			resultJson.put("reason","手机号码为空");
			return resultJson.toString();
		}
		
		
		//根据手机号查找相应的批次
		ArrayList<StockingBatchInfo> batchList=getCurrentCanBeSelectedBatch(ctx,phoneNum);
		
		return  resultJson.toString();
	}

	/**
	 * 获取当前养殖户可以选择的批次
	 * @param ctx
	 * @param phoneNum
	 * @return
	 */
	private ArrayList<StockingBatchInfo> getCurrentCanBeSelectedBatch(
			Context ctx, String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void _getBatchByFarm(Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String _getFarm(Context ctx, String param) throws BOSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String _getTheEggTableList(Context ctx, String param)
			throws BOSException {
		// TODO Auto-generated method stub
		return null;
	}
}