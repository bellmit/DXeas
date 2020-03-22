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
public abstract class AbstractSignWasTheTableEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionCheck(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCheck(request,response,context);
	}
	protected void _handleActionCheck(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionListener(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionListener(request,response,context);
	}
	protected void _handleActionListener(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionBtnRefresh(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionBtnRefresh(request,response,context);
	}
	protected void _handleActionBtnRefresh(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}