/**
 * output package name
 */
package com.kingdee.eas.custom.wages.food.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractMonthFoodBillListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

{
	public void handleActionTDPrint(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionTDPrint(request,response,context);
	}
	protected void _handleActionTDPrint(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionTDPrintPreview(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionTDPrintPreview(request,response,context);
	}
	protected void _handleActionTDPrintPreview(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudit(request,response,context);
	}
	protected void _handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnaudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnaudit(request,response,context);
	}
	protected void _handleActionUnaudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionGetPerson(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionGetPerson(request,response,context);
	}
	protected void _handleActionGetPerson(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionWagecalculation(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionWagecalculation(request,response,context);
	}
	protected void _handleActionWagecalculation(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}