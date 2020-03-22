/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractSCalSchemeListUIHandler extends com.kingdee.eas.framework.app.ListUIHandler

{
	public void handleActionGetSCalScheme(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionGetSCalScheme(request,response,context);
	}
	protected void _handleActionGetSCalScheme(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}