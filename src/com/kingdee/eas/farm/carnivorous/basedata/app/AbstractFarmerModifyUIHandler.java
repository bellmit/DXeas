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
public abstract class AbstractFarmerModifyUIHandler extends com.kingdee.eas.framework.app.CoreUIHandler

{
	public void handleActionListChanged(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionListChanged(request,response,context);
	}
	protected void _handleActionListChanged(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionForcedLoad(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionForcedLoad(request,response,context);
	}
	protected void _handleActionForcedLoad(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}