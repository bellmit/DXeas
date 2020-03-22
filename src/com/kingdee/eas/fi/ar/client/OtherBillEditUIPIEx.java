package com.kingdee.eas.fi.ar.client;

import java.util.ArrayList;

import com.kingdee.eas.fi.ar.client.OtherBillEditUI;
import com.kingdee.util.StringUtils;

/**
 * 应收单 编辑界面扩展
 * @author USER
 *
 */
public class OtherBillEditUIPIEx extends OtherBillEditUI {

	public OtherBillEditUIPIEx() throws Exception {
		super();
	}
	/**
	 * 合计行
	 */
	@Override
	public void setTableToSumField() {
	    String[] entry_sum_cols = StringUtils.stringArrayAppend(ENTRY_SUM_COL, "badAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "badAmountLocal");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "preparedBadAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "preparedBadAmountLocal");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "discountAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "discountAmountLocal");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "dis");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "afterDisAmount");
	    
	    
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "LzAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "MonthDSAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "YearDSAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "SwDSamount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "FxDSAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "BaseAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "NoDSAmount");
	    entry_sum_cols = StringUtils.stringArrayAppend(entry_sum_cols, "NetSaleAmount");
	    super.setTableToSumField(this.kdtEntry, entry_sum_cols);
	    super.setTableToSumField(this.kdtPlan, PLAN_SUM_COL);
	}
	
}
