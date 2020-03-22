/**
 * output package name
 */
package com.kingdee.eas.custom.stockprice.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractBasePriceOfOtherCompanyEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionGetAllMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionGetAllMaterial(request,response,context);
	}
	protected void _handleActionGetAllMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionImpExcel(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionImpExcel(request,response,context);
	}
	protected void _handleActionImpExcel(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionExpModel(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExpModel(request,response,context);
	}
	protected void _handleActionExpModel(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudit(request,response,context);
	}
	protected void _handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}