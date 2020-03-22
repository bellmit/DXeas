/**
 * output package name
 */
package com.kingdee.eas.custom.tocloud.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractTestUIHandler extends com.kingdee.eas.framework.app.CoreUIHandler

{
	public void handletest(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handletest(request,response,context);
	}
	protected void _handletest(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}