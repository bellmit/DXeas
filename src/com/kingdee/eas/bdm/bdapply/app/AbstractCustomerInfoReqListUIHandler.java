/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractCustomerInfoReqListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionCustomerInfoReqAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCustomerInfoReqAudit(request,response,context);
	}
	protected void _handleActionCustomerInfoReqAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionNotby(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionNotby(request,response,context);
	}
	protected void _handleActionNotby(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionAllAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAllAudit(request,response,context);
	}
	protected void _handleActionAllAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}