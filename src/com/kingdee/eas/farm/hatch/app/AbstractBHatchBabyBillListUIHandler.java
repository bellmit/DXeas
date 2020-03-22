/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractBHatchBabyBillListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionMultiAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionMultiAudit(request,response,context);
	}
	protected void _handleActionMultiAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionMultiAudits(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionMultiAudits(request,response,context);
	}
	protected void _handleActionMultiAudits(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}