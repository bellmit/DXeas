/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractDriverListUIHandler extends com.kingdee.eas.framework.app.TreeDetailListUIHandler

{
	public void handleActionReview(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionReview(request,response,context);
	}
	protected void _handleActionReview(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnreview(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnreview(request,response,context);
	}
	protected void _handleActionUnreview(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
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
}