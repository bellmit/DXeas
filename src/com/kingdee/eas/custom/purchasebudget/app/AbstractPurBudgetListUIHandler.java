/**
 * output package name
 */
package com.kingdee.eas.custom.purchasebudget.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractPurBudgetListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionNoPass(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionNoPass(request,response,context);
	}
	protected void _handleActionNoPass(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionImportFormExcel(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionImportFormExcel(request,response,context);
	}
	protected void _handleActionImportFormExcel(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}