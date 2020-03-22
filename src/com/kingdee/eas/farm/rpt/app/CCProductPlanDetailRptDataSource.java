package com.kingdee.eas.farm.rpt.app;

import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.eas.farm.rpt.CCProductPlanDetailRptFacadeFactory;
import com.kingdee.eas.rpts.ctrlsqldesign.param.AbstractJavaDataSet;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 商品鸡 养殖饲料需求 明细 报表 后台
 * @author USER
 *
 */
public class CCProductPlanDetailRptDataSource extends AbstractJavaDataSet{
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CCProductPlanRptDetailDataSource");

//	private 
	@Override
	public IRowSet[] getCustomRowSet(Window parent, String otherDataCenter)
			throws Exception {
		// 结果集
		IRowSet[] rowsets = new IRowSet[1];
		// 设置参数 TODO
		HashMap param = new HashMap();
		String sumType =  (String) filterParamMap.get("sumType");
		param.put("sumType", sumType);
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		String filterBeginDateStr = (String) filterParamMap.get("filterBeginDate");
		param.put("filterBeginDate", sdf.parse(filterBeginDateStr));
		String filterEndDateStr = (String) filterParamMap.get("filterEndDate");
		param.put("filterEndDate", sdf.parse(filterEndDateStr));
		param.put("stoOrgID", (String) filterParamMap.get("stoOrgID"));
		
		param.put("breedDays", (String) filterParamMap.get("breedDays"));
		
		param.put("showBatch", (String) filterParamMap.get("showBatch"));
		IRowSet rowset = CCProductPlanDetailRptFacadeFactory.getRemoteInstance().getRptData(param);
		
		
		rowsets[0] = rowset;
		return rowsets;
		
//		return super.getCustomRowSet(parent, otherDataCenter);
	}

	@Override
	public String getCustomSQL(Window parent) throws Exception {
		// TODO Auto-generated method stub
		return super.getCustomSQL(parent);
	}

	@Override
	public boolean isUIType() {
		// TODO Auto-generated method stub
		return super.isUIType();
	}

	@Override
	public void setFilterParam(Map filterParamMap) {
		// TODO Auto-generated method stub
		super.setFilterParam(filterParamMap);
	}
	
	
	
	
}
