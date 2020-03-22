/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractFodderReceiveBillEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
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
}