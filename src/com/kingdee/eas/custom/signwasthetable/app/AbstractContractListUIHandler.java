/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractContractListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionCmChange(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCmChange(request,response,context);
	}
	protected void _handleActionCmChange(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUpVersion(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUpVersion(request,response,context);
	}
	protected void _handleActionUpVersion(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionToPayReq(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionToPayReq(request,response,context);
	}
	protected void _handleActionToPayReq(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionViewHistory(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionViewHistory(request,response,context);
	}
	protected void _handleActionViewHistory(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionInitial(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionInitial(request,response,context);
	}
	protected void _handleActionInitial(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionSetBailDays(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionSetBailDays(request,response,context);
	}
	protected void _handleActionSetBailDays(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionOverPay(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionOverPay(request,response,context);
	}
	protected void _handleActionOverPay(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionOverView(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionOverView(request,response,context);
	}
	protected void _handleActionOverView(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}