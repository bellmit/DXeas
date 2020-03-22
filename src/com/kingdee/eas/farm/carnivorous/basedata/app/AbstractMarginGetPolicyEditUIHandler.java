/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractMarginGetPolicyEditUIHandler extends com.kingdee.eas.framework.app.EditUIHandler

{
	public void handleActionAudtit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudtit(request,response,context);
	}
	protected void _handleActionAudtit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}