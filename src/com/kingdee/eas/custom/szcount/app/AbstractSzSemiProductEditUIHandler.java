/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractSzSemiProductEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
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
	public void handleActionCountInterface(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCountInterface(request,response,context);
	}
	protected void _handleActionCountInterface(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}