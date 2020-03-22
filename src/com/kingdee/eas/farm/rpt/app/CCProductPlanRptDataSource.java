package com.kingdee.eas.farm.rpt.app;

import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.eas.farm.rpt.CCProductPlanRptFacadeFactory;
import com.kingdee.eas.rpts.ctrlsqldesign.param.AbstractJavaDataSet;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 商品鸡生产计划报表 后台
 * @author USER
 *
 */
public class CCProductPlanRptDataSource extends AbstractJavaDataSet{
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CCProductPlanRptDataSource");

//	private 
	@Override
	public IRowSet[] getCustomRowSet(Window parent, String otherDataCenter)
			throws Exception {
		// 结果集
		IRowSet[] rowsets = new IRowSet[1];
		// 设置参数 TODO
		HashMap param = new HashMap();
		IRowSet rowset = CCProductPlanRptFacadeFactory.getRemoteInstance().getRptData(param);
		
		
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
