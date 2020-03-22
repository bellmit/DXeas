/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.assistbiz.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractMonthFreightCalBillEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionMonthCal(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionMonthCal(request,response,context);
	}
	protected void _handleActionMonthCal(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}