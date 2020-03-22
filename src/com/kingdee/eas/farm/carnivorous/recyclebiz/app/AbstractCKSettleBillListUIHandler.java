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
public abstract class AbstractCKSettleBillListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionUpdateActAmt(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUpdateActAmt(request,response,context);
	}
	protected void _handleActionUpdateActAmt(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUpdateSale(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUpdateSale(request,response,context);
	}
	protected void _handleActionUpdateSale(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionHasPay(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionHasPay(request,response,context);
	}
	protected void _handleActionHasPay(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}