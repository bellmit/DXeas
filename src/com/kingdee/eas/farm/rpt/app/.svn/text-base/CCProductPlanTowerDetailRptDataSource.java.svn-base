package com.kingdee.eas.farm.rpt.app;

import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.eas.farm.rpt.CCProductPlanTowerDetailRptFacadeFactory;
import com.kingdee.eas.rpts.ctrlsqldesign.param.AbstractJavaDataSet;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 商品鸡 养殖饲料需求 按 料塔 明细、同时 关联 库存调拨单 取实际调拨数 进行对比 报表 后台
 * @author USER
 *
 */
public class CCProductPlanTowerDetailRptDataSource extends AbstractJavaDataSet{
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CCProductPlanRptDetailDataSource");

//	private 
	@Override
	public IRowSet[] getCustomRowSet(Window parent, String otherDataCenter)
			throws Exception {
		
		System.out.println("送料计划 取数开始 ：");
		System.out.println(new Date());
		// 结果集
		IRowSet[] rowsets = new IRowSet[1];
		// 设置参数
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
		
		param.put("showDetail", (String) filterParamMap.get("showDetail"));
		// 临时表名  在 明细表和汇总表间联查时 使用
		param.put("temptableName", (String) filterParamMap.get("temptableName"));
		
		IRowSet rowset = CCProductPlanTowerDetailRptFacadeFactory.getRemoteInstance().getRptData(param);
		
		
		rowsets[0] = rowset;
		System.out.println("送料计划 取数结束 ：");
		System.out.println(new Date());
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
