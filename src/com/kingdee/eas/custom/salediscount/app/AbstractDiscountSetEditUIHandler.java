/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractDiscountSetEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionAuditEntries(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAuditEntries(request,response,context);
	}
	protected void _handleActionAuditEntries(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAuditEntries(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAuditEntries(request,response,context);
	}
	protected void _handleActionUnAuditEntries(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionCopyEntry(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCopyEntry(request,response,context);
	}
	protected void _handleActionCopyEntry(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionPriorityQuery(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionPriorityQuery(request,response,context);
	}
	protected void _handleActionPriorityQuery(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionBatchAddEntry(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionBatchAddEntry(request,response,context);
	}
	protected void _handleActionBatchAddEntry(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionEnableEntry(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionEnableEntry(request,response,context);
	}
	protected void _handleActionEnableEntry(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionForbiddenEntry(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionForbiddenEntry(request,response,context);
	}
	protected void _handleActionForbiddenEntry(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}