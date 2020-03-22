/**
 * output package name
 */
package com.kingdee.eas.custom.settlebill.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractSettleBillListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionGetCostAmt(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionGetCostAmt(request,response,context);
	}
	protected void _handleActionGetCostAmt(RequestContext request,ResponseContext response, Context context) throws Exception {
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
	public void handleActionCheckVoucher(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCheckVoucher(request,response,context);
	}
	protected void _handleActionCheckVoucher(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionExeSet(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExeSet(request,response,context);
	}
	protected void _handleActionExeSet(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}