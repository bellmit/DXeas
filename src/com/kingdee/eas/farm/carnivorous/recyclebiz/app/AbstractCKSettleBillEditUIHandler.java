/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractCKSettleBillEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudit(request,response,context);
	}
	protected void _handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionClose(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionClose(request,response,context);
	}
	protected void _handleActionClose(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnClose(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnClose(request,response,context);
	}
	protected void _handleActionUnClose(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionExecSettle(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExecSettle(request,response,context);
	}
	protected void _handleActionExecSettle(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUpdateSaleData(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUpdateSaleData(request,response,context);
	}
	protected void _handleActionUpdateSaleData(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUpdateActAmt(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUpdateActAmt(request,response,context);
	}
	protected void _handleActionUpdateActAmt(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionHasPay(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionHasPay(request,response,context);
	}
	protected void _handleActionHasPay(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}