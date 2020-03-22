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
public abstract class AbstractDrugReceiveBillListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionChkVoucherAll(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionChkVoucherAll(request,response,context);
	}
	protected void _handleActionChkVoucherAll(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionChkVoucherFlag(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionChkVoucherFlag(request,response,context);
	}
	protected void _handleActionChkVoucherFlag(RequestContext request,ResponseContext response, Context context) throws Exception {
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
}