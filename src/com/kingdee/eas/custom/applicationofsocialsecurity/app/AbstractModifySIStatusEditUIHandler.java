/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractModifySIStatusEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionUndoAll(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUndoAll(request,response,context);
	}
	protected void _handleActionUndoAll(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUndoSelected(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUndoSelected(request,response,context);
	}
	protected void _handleActionUndoSelected(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}