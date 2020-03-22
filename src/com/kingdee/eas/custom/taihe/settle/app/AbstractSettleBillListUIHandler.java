/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractSettleBillListUIHandler extends com.kingdee.eas.custom.wlhllicensemanager.app.WlhlCoreBillListUIHandler

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
	public void handleActionExecute(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExecute(request,response,context);
	}
	protected void _handleActionExecute(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}