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
public abstract class AbstractCKCostAllocateBillEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionExecAllocate(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExecAllocate(request,response,context);
	}
	protected void _handleActionExecAllocate(RequestContext request,ResponseContext response, Context context) throws Exception {
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
	public void handleActionCostAmt(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCostAmt(request,response,context);
	}
	protected void _handleActionCostAmt(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}