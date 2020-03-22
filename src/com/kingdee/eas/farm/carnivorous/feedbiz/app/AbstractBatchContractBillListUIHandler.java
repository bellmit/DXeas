/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractBatchContractBillListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionIsTemplate(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionIsTemplate(request,response,context);
	}
	protected void _handleActionIsTemplate(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionIsInit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionIsInit(request,response,context);
	}
	protected void _handleActionIsInit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionRevoke(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionRevoke(request,response,context);
	}
	protected void _handleActionRevoke(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}