/**
 * output package name
 */
package com.kingdee.eas.delivery.basedata.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractDeliveryLineEditUIHandler extends com.kingdee.eas.basedata.framework.app.DataBaseSIEditUIHandler

{
	public void handleActionAddLine(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAddLine(request,response,context);
	}
	protected void _handleActionAddLine(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionInsertLine(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionInsertLine(request,response,context);
	}
	protected void _handleActionInsertLine(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionRemoveLine(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionRemoveLine(request,response,context);
	}
	protected void _handleActionRemoveLine(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}