/**
 * output package name
 */
package com.kingdee.eas.custom.wlhllicensemanager.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractWlhlTreeDetailListUIHandler extends com.kingdee.eas.framework.app.TreeDetailListUIHandler

{
	public void handleActionApprove(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionApprove(request,response,context);
	}
	protected void _handleActionApprove(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnApprove(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnApprove(request,response,context);
	}
	protected void _handleActionUnApprove(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}