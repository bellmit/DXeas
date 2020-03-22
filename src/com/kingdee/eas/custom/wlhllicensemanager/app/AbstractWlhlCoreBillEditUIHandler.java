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
public abstract class AbstractWlhlCoreBillEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleactionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleactionAudit(request,response,context);
	}
	protected void _handleactionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleactionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleactionUnAudit(request,response,context);
	}
	protected void _handleactionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}