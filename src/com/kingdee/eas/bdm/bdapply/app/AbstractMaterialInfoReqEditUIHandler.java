/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractMaterialInfoReqEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionMaterialInfoAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionMaterialInfoAudit(request,response,context);
	}
	protected void _handleActionMaterialInfoAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionBasenotby(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionBasenotby(request,response,context);
	}
	protected void _handleActionBasenotby(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionAllAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAllAudit(request,response,context);
	}
	protected void _handleActionAllAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}