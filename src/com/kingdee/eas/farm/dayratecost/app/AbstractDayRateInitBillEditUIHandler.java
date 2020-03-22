/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractDayRateInitBillEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

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
	public void handleActionInitialize(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionInitialize(request,response,context);
	}
	protected void _handleActionInitialize(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnInitialize(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnInitialize(request,response,context);
	}
	protected void _handleActionUnInitialize(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}